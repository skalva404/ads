package kalva.learnings.ads.ads.bf;

import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.ArrayList;

public class QuotientBloomFilter {

    private static final Log LOG = LogFactory.getLog(QuotientBloomFilter.class);

    private int qfSize;
    protected int capacity;
    protected ArrayList<Slot> set;


    public QuotientBloomFilter(int size) {
        LOG.info("Created QuotientBloomFilter of size: " + size);
        this.set = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            this.set.add(new Slot());
        this.capacity = size;
        this.qfSize = 0;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.qfSize;
    }

    public boolean isFull() {
        return getSize() >= getCapacity();
    }

    public void setSlot(int index, Slot slot) {
        this.set.set(index, slot);
    }

    protected ArrayList<Slot> getSet() {
        return set;
    }

    public void insert(Object obj) throws Exception {

        if (isFull()) {
            throw new IOException("ERROR: Quotient Filter has reached capacity");
        }
        int index = Utils.getIndex(obj, getCapacity());
        Slot currentSlot = set.get(index);
        short remainder = Utils.getRemainder(obj);

        if (!currentSlot.getMetadata().getOccupied()) {
            currentSlot.setRemainder(Utils.getRemainder(obj));

            Metadata md = new MetadataBitSet();
            md.setOccupied();
            currentSlot.setMetadata(md);
            currentSlot.setRemainder(remainder);
        } else {
            int foundIndex;
            foundIndex = lookup(index, remainder);
            if (foundIndex != -1) {
                throw new IOException("Object already exists");
            } else {
                insertShift(remainder, index);
            }
        }
    }

    public void insertShift(short remainder, int index) throws IOException {
        Integer runStart = 0;
        Integer position = index;
        boolean atStart = true;
        boolean subtract = false;
        Metadata md = new MetadataBitSet();
        md.setOccupied();
        Slot newSlot = new Slot(remainder, md);

        runStart = findRunStart(index);
        Slot currentSlot = set.get(runStart);
        while ((remainder > currentSlot.getRemainder()) && currentSlot.getMetadata().getOccupied()) {
            atStart = false;
            position++;
            subtract = true;
            currentSlot = set.get(position);
        }

        if (subtract)
            position--;
        Slot prevSlot = set.get(position);
        if (prevSlot.getMetadata().getShifted())
            newSlot.getMetadata().setShifted();

        shiftRight(position);

        if (!atStart) {
            newSlot.getMetadata().setContinuation();
        }
        set.set(position, newSlot);
    }

    public void shiftRight(int index) {
        Slot currentSlot;
        Slot nextSlot;
        Slot temp = null;
        boolean setContinuation = true;

        do {
            currentSlot = set.get(index % getCapacity());
            nextSlot = set.get((index + 1) % getCapacity());
            temp = nextSlot;
            // nextSlot = currentSlot;
            currentSlot.getMetadata().setShifted();
            currentSlot.getMetadata().setContinuation();
            set.set(index + 1 % getCapacity(), currentSlot);

            index++;
        } while (set.get(index + 1 % getCapacity()).getMetadata().getOccupied());

        if (temp.getMetadata().getOccupied()) {
            set.set(index % getCapacity(), temp);
        }
    }

    public void deleteShift(int index) throws IOException {
        Slot slot, nextSlot;
        do {
            slot = set.get(index);
            nextSlot = set.get((index++) % getCapacity());
            slot = nextSlot;
        } while (!slot.getMetadata().getOccupied());
    }

    public void delete(Object obj) throws Exception {
        int index = Utils.getIndex(obj, getCapacity());
        int foundIndex;
        foundIndex = lookup(index, Utils.getRemainder(obj));
        if (foundIndex != -1) {
            // No slots to move, inserting empty slot
            if (!set.get((foundIndex + 1) % getCapacity()).getMetadata().getOccupied()) {
                Slot newSlot = new Slot();
                set.set(foundIndex, newSlot);
            }
            deleteShift(foundIndex);
        } else {
            LOG.debug("Unable to delete, no object: " + obj.toString());
        }
    }

    public int lookup(Object obj) {
        return lookup(Utils.getIndex(obj, getCapacity()), Utils.getRemainder(obj));
    }

    public int lookup(int index, short remainder) {
        int currentIndex = index;
        Slot currentSlot = set.get(currentIndex);
        int runStart = 0;

        if (currentSlot.getMetadata().isClear())
            return -1;

        runStart = findRunStart(currentIndex);

        return checkQuotient(runStart, remainder);
    }

    private int checkQuotient(int runStart, short remainder) {
        int currentIndex = runStart;
        Slot slot = set.get(runStart);

        do {
            if (slot.getRemainder() == remainder) {
                return currentIndex;
            } else if (slot.getRemainder() > remainder) {
                return -1;
            }
            currentIndex++;
            if (currentIndex >= getCapacity())
                currentIndex = 0;
            slot = set.get(currentIndex);
        } while (slot.getMetadata().getContinuation());

        // Did not find the remainder in the run, false
        return -1;
    }

    private int findRunStart(int currentIndex) {
        int isOccupiedCount = 0;
        int isContinuationCount = 0;
        Slot slot;

        while (true) {
            slot = set.get(currentIndex);
            if (slot.getMetadata().getOccupied())
                isOccupiedCount++;
            if (!slot.getMetadata().getShifted())
                break;
            currentIndex--;
            if (currentIndex < 0)
                currentIndex = getCapacity() - 1;
        }

        // currentIndex is now the start of the CLUSTER
        while (true) {
            slot = set.get(currentIndex);
            if (!slot.getMetadata().getContinuation())
                isContinuationCount++;
            if (isOccupiedCount <= isContinuationCount) {
                return currentIndex;
            }
            currentIndex++;
            if (currentIndex > (getCapacity() - 1))
                currentIndex = 0;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        int count = 0;
        for (Slot slot : set) {


            if ((!slot.getMetadata().getOccupied())) {
                sb.append("<empty>");
            } else {
                sb.append(slot.getMetadata().getOccupied() ? "1" : "0");
                sb.append(slot.getMetadata().getContinuation() ? "1" : "0");
                sb.append(slot.getMetadata().getShifted() ? "1" : "0");
                sb.append(":");
                sb.append(slot.getRemainder());
                sb.append(" ");
            }
            count++;
            if ((count % 15) == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void printQF() {
        System.out.println(this.toString() + "\n");
    }

    public static void main(String[] args) throws Exception {

//        BasicConfigurator.configure();
//        QuotientBloomFilter qf = new QuotientBloomFilter(45);
//        LOG.error("ERROR logging");
//        System.out.println(qf.hashCode());
//
//        System.out.println(Integer.toBinaryString(qf.hashCode()));
//        System.out.println(Integer.toBinaryString(0xFFFF & Utils.getQuotient(qf)));
//        System.out.println(Integer.toBinaryString(0xFFFF & Utils.getRemainder(qf)));
//
//        int value = 222;
//        String stringInput = "hello world";
//        long longval = 4444;
//
//        qf.insert(value);
//        System.out.println(qf.toString());
//        System.out.println();
//        qf.insert(stringInput);
//        System.out.println(qf.toString());
//        System.out.println();
//        qf.insert(longval);
//
//        System.out.println(qf.toString());

        QuotientBloomFilter qf = new QuotientBloomFilter(75);
        try {
            qf.insert("value");
            qf.insert(343443L);
            qf.insert(444);
            qf.insert(23);
            qf.insert("343443");
            qf.insert("second value");
            qf.printQF();

            int output = qf.lookup("value");
            System.out.println("The value output: " + output);
            Assert.assertEquals(58, output);

            int outputSecond = qf.lookup(23);
            System.out.println("The 23 output: " + outputSecond);
            Assert.assertEquals(0, outputSecond);

            int outputThird = qf.lookup(444);
            System.out.println("The 4444 output: " + outputThird);
            Assert.assertEquals(1, outputThird);

            int outputFourth = qf.lookup("Not Exists");
            System.out.println("The 'Not Exists' output: " + outputFourth);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
