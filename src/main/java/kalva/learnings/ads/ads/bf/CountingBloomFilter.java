package kalva.learnings.ads.ads.bf;

import java.util.BitSet;

public class CountingBloomFilter<V> {

    private BitSet bloomFilter;
    private int[] counterVector;
    private RandomInRange<V> rangeRandom;
    private int k; // Number of hash functions
    private static final double LN2 = 0.6931471805599453; // ln(2)

    /**
     * Create a new bloom filter.
     *
     * @param n Expected number of elements
     * @param m Desired size of the container in bits
     **/
    public CountingBloomFilter(int n, int m) {
        k = (int) Math.round(LN2 * m / n);
        if (k <= 0) k = 1;
        this.bloomFilter = new BitSet(m);
        this.rangeRandom = new RandomInRange<>(m, k);
        this.counterVector = new int[m];
    }

    /**
     * Create a bloom filter of 1Mib.
     *
     * @param n Expected number of elements
     **/
    public CountingBloomFilter(int n) {
        this(n, 1024);
    }

    /**
     * Add an element to the container
     **/
    public void add(V o) {
        rangeRandom.init(o);
        for (RandomInRange r : rangeRandom) {
            int value = r.getValue();
            counterVector[value]++;
            if (1 == counterVector[value]) {
                bloomFilter.set(value);
            }
        }
    }

    public void delete(V o) {
        rangeRandom.init(o);
        for (RandomInRange r : rangeRandom) {
            int value = r.getValue();
            counterVector[value]--;
            if (0 == counterVector[value]) {
                bloomFilter.clear(value);
            }
        }
    }

    public boolean contains(V o) {
        rangeRandom.init(o);
        for (RandomInRange r : rangeRandom) {
            if (!bloomFilter.get(r.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountingBloomFilter<String> bloomFilter = new CountingBloomFilter<>(10);
        for (int i = 1; i <= 10; i++) {
            bloomFilter.add("Sunil-" + i);
            System.out.print(bloomFilter.contains("Sunil-" + i) + "\t");
            bloomFilter.delete("Sunil-" + i);
            System.out.println(bloomFilter.contains("Sunil-" + i));
        }
    }
}