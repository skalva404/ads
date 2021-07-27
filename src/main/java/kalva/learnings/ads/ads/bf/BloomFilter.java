package kalva.learnings.ads.ads.bf;

import java.util.BitSet;

public class BloomFilter<V> {

    private BitSet bloomFilter;
    private RandomInRange<V> rangeRandom;
    private int k; // Number of hash functions
    private static final double LN2 = 0.6931471805599453; // ln(2)

    /**
     * Create a new bloom filter.
     *
     * @param n Expected number of elements
     * @param m Desired size of the container in bits
     **/
    public BloomFilter(int n, int m) {
        k = (int) Math.round(LN2 * m / n);
        if (k <= 0) k = 1;
        this.bloomFilter = new BitSet(m);
        this.rangeRandom = new RandomInRange<>(m, k);
    }

    /**
     * Create a bloom filter of 1Mib.
     *
     * @param n Expected number of elements
     **/
    public BloomFilter(int n) {
        this(n, 1024);
//        this(n, 1024 * 1024 * 8);
    }


    /**
     * Add an element to the container
     **/
    public void add(V o) {
        int ctr = 1;
        rangeRandom.init(o);
        for (RandomInRange r : rangeRandom) {
            int value = r.getValue();
            bloomFilter.set(value);
        }
    }

    /**
     * If the element is in the container, returns true.
     * If the element is not in the container, returns true with a probability ≈ e^(-ln(2)² * m/n), otherwise false.
     * So, when m is large enough, the return value can be interpreted as:
     * - true  : the element is probably in the container
     * - false : the element is definitely not in the container
     **/
    public boolean contains(V o) {
        rangeRandom.init(o);
        for (RandomInRange r : rangeRandom) {
            if (!bloomFilter.get(r.getValue())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes all of the elements from this filter.
     **/
    public void clear() {
        bloomFilter.clear();
    }

    /**
     * Create a copy of the current filter
     **/
    public BloomFilter clone() throws CloneNotSupportedException {
        return (BloomFilter) super.clone();
    }

    /**
     * Generate a unique hash representing the filter
     **/
    public int hashCode() {
        return bloomFilter.hashCode() ^ k;
    }

    /**
     * Test if the filters have equal bitsets.
     * WARNING: two filters may contain the same elements, but not be equal
     * (if the filters have different size for example).
     */
    public boolean equals(BloomFilter other) {
        return this.bloomFilter.equals(other.bloomFilter) && this.k == other.k;
    }

    /**
     * Merge another bloom filter into the current one.
     * After this operation, the current bloom filter contains all elements in
     * other.
     **/
    public void merge(BloomFilter other) {
        if (other.k != this.k || other.bloomFilter.size() != this.bloomFilter.size()) {
            throw new IllegalArgumentException("Incompatible bloom filters");
        }
        this.bloomFilter.or(other.bloomFilter);
    }

    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = new BloomFilter<>(10);
        for (int i = 1; i <= 10; i++) {
            bloomFilter.add("Sunil-" + i);
            System.out.print(bloomFilter.contains("Sunil-" + i) + "\t");
            System.out.println(bloomFilter.contains("sunil-" + i));
        }
    }
}
