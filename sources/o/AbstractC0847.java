package o;
/* renamed from: o.ᓸ  reason: contains not printable characters */
public abstract class AbstractC0847 {
    private long lastModified = System.currentTimeMillis();

    protected AbstractC0847() {
    }

    public final long getLastModifiedInCache() {
        return this.lastModified;
    }

    public final boolean needsRefresh(long j) {
        return this.lastModified > 0 && this.lastModified < j;
    }

    public final void setLastModifiedInCache(long j) {
        this.lastModified = j;
    }
}
