package kalva.learnings.ads.ads.cardinality;

import org.apache.lucene.analysis.LowerCaseTokenizer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class FlajoletMartin {

    private static final double PHI = 0.77351D;

    private int m_numHashGroups;
    private HashFunction[][] m_hashes;
    private int m_numHashFunctionsInHashGroup;

    private int m_bitmapSize;
    private boolean[][][] m_bitmaps;

    private long m_numWords;

    public FlajoletMartin(int bitmapSize, int numHashGroups, int numHashFunctionsInEachGroup) {
        m_bitmapSize = bitmapSize;
        m_numHashGroups = numHashGroups;
        m_numHashFunctionsInHashGroup = numHashFunctionsInEachGroup;

        m_hashes = new HashFunction[numHashGroups][numHashFunctionsInEachGroup];
        m_bitmaps = new boolean[numHashGroups][numHashFunctionsInEachGroup][bitmapSize];

        generateHashFunctions();
    }

    private void generateHashFunctions() {
        Map<Integer, Collection<Integer>> m_and_n_map = new HashMap<>();
        for (int i = 0; i < m_numHashGroups; i++) {
            for (int j = 0; j < m_numHashFunctionsInHashGroup; j++) {
                m_hashes[i][j] = generateUniqueHashFunction(m_and_n_map);
            }
        }
    }

    private HashFunction generateUniqueHashFunction(Map<Integer, Collection<Integer>> m_and_n_map) {
        // Get odd numbers for both m and n.
        int m = 0;
        do {
            m = (int) (Integer.MAX_VALUE * Math.random());
        } while (m % 2 == 0);

        // Get pairs that we haven't seen before.
        int n = 0;
        do {
            n = (int) (Integer.MAX_VALUE * Math.random());
        } while ((n % 2 == 0) || contains(m_and_n_map, m, n));

        // Make a note of the (m, n) pair, so we don't use it again.
        Collection<Integer> valueCollection = m_and_n_map.computeIfAbsent(m, k -> new HashSet<>());
        valueCollection.add(n);

        // Generate hash function with the (m, n) pair.
        // System.out.println("Generating hashFunction with (m=" + m + ", n=" + n + ")");
        return new HashFunction(m, n, m_bitmapSize);
    }

    private static boolean contains(Map<Integer, Collection<Integer>> map, int m, int n) {
        Collection<Integer> valueList = map.get(m);
        return (valueList != null) && (valueList.contains(n));
    }

    public long countUniqueWords(Reader reader) throws IOException {
        LowerCaseTokenizer tokenizer = new LowerCaseTokenizer(reader);
        TermAttribute termAttr = (TermAttribute) tokenizer.getAttribute(TermAttribute.class);
        while (tokenizer.incrementToken()) {
            String word = termAttr.term();
            m_numWords++;
            // Implement Flajolet-Martin algorithm here.
            for (int i = 0; i < m_numHashGroups; i++) {
                for (int j = 0; j < m_numHashFunctionsInHashGroup; j++) {
                    flajoletMartin(i, j, word);
                }
            }
        }
        // Exhausted word list.

        List<Double> averageR = new ArrayList<>();
        for (int i = 0; i < m_numHashGroups; i++) {
            int sumR = 0;
            for (int j = 0; j < m_numHashFunctionsInHashGroup; j++) {
                sumR += (getFirstZeroBit(m_bitmaps[i][j]));
            }
            averageR.add(sumR * 1.0 / m_numHashFunctionsInHashGroup);
        }

        // Find the median R and estimate unique words.
        Collections.sort(averageR);
        double r = 0;
        int averageRMid = averageR.size() / 2;
        if (averageR.size() % 2 == 0) {
            r = (averageR.get(averageRMid) + averageR.get(averageRMid + 1)) / 2;
        } else {
            r = averageR.get(averageRMid + 1);
        }

        return (long) (Math.pow(2, r) / PHI);
    }

    private void flajoletMartin(int hashGroup, int hashNumWithinGroup, String word) {
        HashFunction f = m_hashes[hashGroup][hashNumWithinGroup];
        long v = f.hash(word);
        int index = rho(v);
        if (!m_bitmaps[hashGroup][hashNumWithinGroup][index]) {
            m_bitmaps[hashGroup][hashNumWithinGroup][index] = true;
        }
    }

    private int rho(long v) {
        int rho = 0;
        for (int i = 0; i < m_bitmapSize; i++) { // size of long=64 bits.
            if ((v & 0x01) == 0) {
                v = v >> 1;
                rho++;
            } else {
                break;
            }
        }
        return rho == m_bitmapSize ? 0 : rho;
    }

    private static int getFirstZeroBit(boolean[] b) {
        for (int i = 0; i < b.length; i++) {
            if (!b[i]) {
                return i;
            }
        }
        return b.length;
    }

    private static class HashFunction {
        private int m_m;
        private int m_n;

        HashFunction(int m, int n, int bitmapSize) {
            if (bitmapSize > 64) {
                throw new IllegalArgumentException("bitmap size should be at max. 64");
            }
            this.m_m = m;
            this.m_n = n;
        }

        long hash(Object o) {
            if (o instanceof String)
                return hash(o.hashCode());
            if (o instanceof Number)
                return hash(String.valueOf(o).hashCode());
            return hash(o.hashCode());
        }

        long hash(long hashCode) {
            return m_m + m_n * hashCode;
        }
    }
}
