package kalva.learnings.ads.ads.bf;

import java.util.Iterator;
import java.util.Random;

public class RandomInRange<V> implements Iterable<RandomInRange>, Iterator<RandomInRange> {

    private Random random;
    private int max; // Maximum value returned + 1
    private int count; // Number of random elements to generate
    private int i = 0; // Number of elements generated
    private int value; // The current value

    RandomInRange(int maximum, int k) {
        max = maximum;
        count = k;
        random = new Random();
    }

    public int getValue() {
        return value;
    }

    public void init(V o) {
        random.setSeed(o.hashCode());
    }

    public Iterator<RandomInRange> iterator() {
        i = 0;
        return this;
    }

    public RandomInRange<V> next() {
        i++;
        value = random.nextInt() % max;
        if (value < 0) value = -value;
        return this;
    }

    public boolean hasNext() {
        return i < count;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}