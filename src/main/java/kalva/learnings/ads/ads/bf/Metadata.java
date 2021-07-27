package kalva.learnings.ads.ads.bf;

public interface Metadata {
    /*
    public T getMetadataSet();

    public void setMetadata(T metadata);
    */
    public Boolean getOccupied();

    public Boolean getShifted();

    public Boolean getContinuation();

    public void setOccupied();

    public void setContinuation();

    public void setShifted();

    public void clearOccupied();

    public void clearContinuation();

    public void clearShifted();

    public Boolean isClear();
}
