package kalva.learnings.ads.ads.bf;

public class Slot {
    private Short remainder;
    private Metadata metadata;

    public Slot() {
        this.remainder = -1;
        this.metadata = new MetadataBitSet();
    }

    public Slot(short remainder, Metadata metadata) {
        this.remainder = remainder;
        this.metadata = metadata;
    }

    public short getRemainder() {
        return remainder;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setRemainder(short remainder) {
        this.remainder = remainder;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
