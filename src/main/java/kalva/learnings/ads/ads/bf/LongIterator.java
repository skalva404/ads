package kalva.learnings.ads.ads.bf;

import java.util.Iterator;

public interface LongIterator extends Iterator<Long> {

    long nextPrimitive();

    @Override
    default Long next() {
        return nextPrimitive();
    }
}
