package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.TreeSet;
/* access modifiers changed from: package-private */
public final class CachedContent {
    private final TreeSet<SimpleCacheSpan> cachedSpans;
    public final int id;
    public final String key;
    private long length;

    public CachedContent(DataInputStream dataInputStream) {
        this(dataInputStream.readInt(), dataInputStream.readUTF(), dataInputStream.readLong());
    }

    public CachedContent(int i, String str, long j) {
        this.id = i;
        this.key = str;
        this.length = j;
        this.cachedSpans = new TreeSet<>();
    }

    public void writeToStream(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.id);
        dataOutputStream.writeUTF(this.key);
        dataOutputStream.writeLong(this.length);
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.cachedSpans.add(simpleCacheSpan);
    }

    public TreeSet<SimpleCacheSpan> getSpans() {
        return this.cachedSpans;
    }

    public SimpleCacheSpan getSpan(long j) {
        SimpleCacheSpan createLookup = SimpleCacheSpan.createLookup(this.key, j);
        SimpleCacheSpan floor = this.cachedSpans.floor(createLookup);
        if (floor != null && floor.position + floor.length > j) {
            return floor;
        }
        SimpleCacheSpan ceiling = this.cachedSpans.ceiling(createLookup);
        if (ceiling == null) {
            return SimpleCacheSpan.createOpenHole(this.key, j);
        }
        return SimpleCacheSpan.createClosedHole(this.key, j, ceiling.position - j);
    }

    public SimpleCacheSpan touch(SimpleCacheSpan simpleCacheSpan) {
        Assertions.checkState(this.cachedSpans.remove(simpleCacheSpan));
        SimpleCacheSpan copyWithUpdatedLastAccessTime = simpleCacheSpan.copyWithUpdatedLastAccessTime(this.id);
        if (!simpleCacheSpan.file.renameTo(copyWithUpdatedLastAccessTime.file)) {
            throw new Cache.CacheException("Renaming of " + simpleCacheSpan.file + " to " + copyWithUpdatedLastAccessTime.file + " failed.");
        }
        this.cachedSpans.add(copyWithUpdatedLastAccessTime);
        return copyWithUpdatedLastAccessTime;
    }

    public boolean isEmpty() {
        return this.cachedSpans.isEmpty();
    }

    public boolean removeSpan(CacheSpan cacheSpan) {
        if (!this.cachedSpans.remove(cacheSpan)) {
            return false;
        }
        cacheSpan.file.delete();
        return true;
    }

    public int headerHashCode() {
        return (((this.id * 31) + this.key.hashCode()) * 31) + ((int) (this.length ^ (this.length >>> 32)));
    }
}
