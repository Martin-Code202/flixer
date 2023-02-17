package com.google.android.exoplayer2.upstream.cache;

import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;
import java.util.Set;
public interface Cache {

    public interface Listener {
        void onSpanAdded(Cache cache, CacheSpan cacheSpan);

        void onSpanRemoved(Cache cache, CacheSpan cacheSpan);

        void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2);
    }

    void commitFile(File file);

    long getCacheSpace();

    NavigableSet<CacheSpan> getCachedSpans(String str);

    long getContentLength(String str);

    Set<String> getKeys();

    void releaseHoleSpan(CacheSpan cacheSpan);

    void removeSpan(CacheSpan cacheSpan);

    void setContentLength(String str, long j);

    File startFile(String str, long j, long j2);

    CacheSpan startReadWrite(String str, long j);

    CacheSpan startReadWriteNonBlocking(String str, long j);

    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(IOException iOException) {
            super(iOException);
        }
    }
}
