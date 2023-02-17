package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
public final class SimpleCache implements Cache {
    private final File cacheDir;
    private final CacheEvictor evictor;
    private final CachedContentIndex index;
    private Cache.CacheException initializationException;
    private final HashMap<String, ArrayList<Cache.Listener>> listeners;
    private final HashMap<String, CacheSpan> lockedSpans;
    private long totalSpace;

    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, null, false);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, byte[] bArr, boolean z) {
        this(file, cacheEvictor, new CachedContentIndex(file, bArr, z));
    }

    SimpleCache(File file, CacheEvictor cacheEvictor, CachedContentIndex cachedContentIndex) {
        this.totalSpace = 0;
        this.cacheDir = file;
        this.evictor = cacheEvictor;
        this.lockedSpans = new HashMap<>();
        this.index = cachedContentIndex;
        this.listeners = new HashMap<>();
        final ConditionVariable conditionVariable = new ConditionVariable();
        new Thread("SimpleCache.initialize()") { // from class: com.google.android.exoplayer2.upstream.cache.SimpleCache.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (SimpleCache.this) {
                    conditionVariable.open();
                    try {
                        SimpleCache.this.initialize();
                    } catch (Cache.CacheException e) {
                        SimpleCache.this.initializationException = e;
                    }
                    SimpleCache.this.evictor.onCacheInitialized();
                }
            }
        }.start();
        conditionVariable.block();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet<CacheSpan> getCachedSpans(String str) {
        TreeSet treeSet;
        CachedContent cachedContent = this.index.get(str);
        if (cachedContent == null || cachedContent.isEmpty()) {
            treeSet = null;
        } else {
            treeSet = new TreeSet((Collection) cachedContent.getSpans());
        }
        return treeSet;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized Set<String> getKeys() {
        return new HashSet(this.index.getKeys());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCacheSpace() {
        return this.totalSpace;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized SimpleCacheSpan startReadWrite(String str, long j) {
        SimpleCacheSpan startReadWriteNonBlocking;
        while (true) {
            startReadWriteNonBlocking = startReadWriteNonBlocking(str, j);
            if (startReadWriteNonBlocking == null) {
                wait();
            }
        }
        return startReadWriteNonBlocking;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized SimpleCacheSpan startReadWriteNonBlocking(String str, long j) {
        if (this.initializationException != null) {
            throw this.initializationException;
        }
        SimpleCacheSpan span = getSpan(str, j);
        if (span.isCached) {
            SimpleCacheSpan simpleCacheSpan = this.index.get(str).touch(span);
            notifySpanTouched(span, simpleCacheSpan);
            return simpleCacheSpan;
        } else if (this.lockedSpans.containsKey(str)) {
            return null;
        } else {
            this.lockedSpans.put(str, span);
            return span;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File startFile(String str, long j, long j2) {
        Assertions.checkState(this.lockedSpans.containsKey(str));
        if (!this.cacheDir.exists()) {
            removeStaleSpansAndCachedContents();
            this.cacheDir.mkdirs();
        }
        this.evictor.onStartFile(this, str, j, j2);
        return SimpleCacheSpan.getCacheFile(this.cacheDir, this.index.assignIdForKey(str), j, System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void commitFile(File file) {
        SimpleCacheSpan createCacheEntry = SimpleCacheSpan.createCacheEntry(file, this.index);
        Assertions.checkState(createCacheEntry != null);
        Assertions.checkState(this.lockedSpans.containsKey(createCacheEntry.key));
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            Long valueOf = Long.valueOf(getContentLength(createCacheEntry.key));
            if (valueOf.longValue() != -1) {
                Assertions.checkState(createCacheEntry.position + createCacheEntry.length <= valueOf.longValue());
            }
            addSpan(createCacheEntry);
            this.index.store();
            notifyAll();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void releaseHoleSpan(CacheSpan cacheSpan) {
        Assertions.checkState(cacheSpan == this.lockedSpans.remove(cacheSpan.key));
        notifyAll();
    }

    private SimpleCacheSpan getSpan(String str, long j) {
        SimpleCacheSpan span;
        CachedContent cachedContent = this.index.get(str);
        if (cachedContent == null) {
            return SimpleCacheSpan.createOpenHole(str, j);
        }
        while (true) {
            span = cachedContent.getSpan(j);
            if (!span.isCached || span.file.exists()) {
                break;
            }
            removeStaleSpansAndCachedContents();
        }
        return span;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initialize() {
        if (!this.cacheDir.exists()) {
            this.cacheDir.mkdirs();
            return;
        }
        this.index.load();
        File[] listFiles = this.cacheDir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!file.getName().equals("cached_content_index.exi")) {
                    SimpleCacheSpan createCacheEntry = file.length() > 0 ? SimpleCacheSpan.createCacheEntry(file, this.index) : null;
                    if (createCacheEntry != null) {
                        addSpan(createCacheEntry);
                    } else {
                        file.delete();
                    }
                }
            }
            this.index.removeEmpty();
            this.index.store();
        }
    }

    private void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.index.add(simpleCacheSpan.key).addSpan(simpleCacheSpan);
        this.totalSpace += simpleCacheSpan.length;
        notifySpanAdded(simpleCacheSpan);
    }

    private void removeSpan(CacheSpan cacheSpan, boolean z) {
        CachedContent cachedContent = this.index.get(cacheSpan.key);
        if (cachedContent != null && cachedContent.removeSpan(cacheSpan)) {
            this.totalSpace -= cacheSpan.length;
            if (z) {
                try {
                    if (cachedContent.isEmpty()) {
                        this.index.removeEmpty(cachedContent.key);
                        this.index.store();
                    }
                } catch (Throwable th) {
                    notifySpanRemoved(cacheSpan);
                    throw th;
                }
            }
            notifySpanRemoved(cacheSpan);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeSpan(CacheSpan cacheSpan) {
        removeSpan(cacheSpan, true);
    }

    private void removeStaleSpansAndCachedContents() {
        LinkedList linkedList = new LinkedList();
        for (CachedContent cachedContent : this.index.getAll()) {
            Iterator<SimpleCacheSpan> it = cachedContent.getSpans().iterator();
            while (it.hasNext()) {
                SimpleCacheSpan next = it.next();
                if (!next.file.exists()) {
                    linkedList.add(next);
                }
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            removeSpan((CacheSpan) it2.next(), false);
        }
        this.index.removeEmpty();
        this.index.store();
    }

    private void notifySpanRemoved(CacheSpan cacheSpan) {
        ArrayList<Cache.Listener> arrayList = this.listeners.get(cacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanRemoved(this, cacheSpan);
            }
        }
        this.evictor.onSpanRemoved(this, cacheSpan);
    }

    private void notifySpanAdded(SimpleCacheSpan simpleCacheSpan) {
        ArrayList<Cache.Listener> arrayList = this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanAdded(this, simpleCacheSpan);
            }
        }
        this.evictor.onSpanAdded(this, simpleCacheSpan);
    }

    private void notifySpanTouched(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        ArrayList<Cache.Listener> arrayList = this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanTouched(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.evictor.onSpanTouched(this, simpleCacheSpan, cacheSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void setContentLength(String str, long j) {
        this.index.setContentLength(str, j);
        this.index.store();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getContentLength(String str) {
        return this.index.getContentLength(str);
    }
}
