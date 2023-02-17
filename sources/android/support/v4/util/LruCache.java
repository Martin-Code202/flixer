package android.support.v4.util;

import java.util.LinkedHashMap;
import java.util.Locale;
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V get(K k) {
        V put;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.map.get(k);
            if (v != null) {
                this.hitCount++;
                return v;
            }
            this.missCount++;
        }
        V create = create(k);
        if (create == null) {
            return null;
        }
        synchronized (this) {
            this.createCount++;
            put = this.map.put(k, create);
            if (put != null) {
                this.map.put(k, put);
            } else {
                this.size += safeSizeOf(k, create);
            }
        }
        if (put != null) {
            entryRemoved(false, k, create, put);
            return put;
        }
        trimToSize(this.maxSize);
        return create;
    }

    public final V put(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.putCount++;
            this.size += safeSizeOf(k, v);
            put = this.map.put(k, v);
            if (put != null) {
                this.size -= safeSizeOf(k, put);
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        return put;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r9) {
        /*
            r8 = this;
        L_0x0000:
            r5 = r8
            monitor-enter(r5)
            int r0 = r8.size     // Catch:{ all -> 0x0070 }
            if (r0 < 0) goto L_0x0012
            java.util.LinkedHashMap<K, V> r0 = r8.map     // Catch:{ all -> 0x0070 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x0033
            int r0 = r8.size     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x0033
        L_0x0012:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r1.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.Class r2 = r8.getClass()     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0070 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0070 }
            r0.<init>(r1)     // Catch:{ all -> 0x0070 }
            throw r0     // Catch:{ all -> 0x0070 }
        L_0x0033:
            int r0 = r8.size     // Catch:{ all -> 0x0070 }
            if (r0 <= r9) goto L_0x003f
            java.util.LinkedHashMap<K, V> r0 = r8.map     // Catch:{ all -> 0x0070 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x0041
        L_0x003f:
            monitor-exit(r5)
            goto L_0x007a
        L_0x0041:
            java.util.LinkedHashMap<K, V> r0 = r8.map
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            r6 = r0
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r3 = r6.getKey()
            java.lang.Object r4 = r6.getValue()
            java.util.LinkedHashMap<K, V> r0 = r8.map
            r0.remove(r3)
            int r0 = r8.size
            int r1 = r8.safeSizeOf(r3, r4)
            int r0 = r0 - r1
            r8.size = r0
            int r0 = r8.evictionCount
            int r0 = r0 + 1
            r8.evictionCount = r0
            monitor-exit(r5)
            goto L_0x0073
        L_0x0070:
            r7 = move-exception
            monitor-exit(r5)
            throw r7
        L_0x0073:
            r0 = 1
            r1 = 0
            r8.entryRemoved(r0, r3, r4, r1)
            goto L_0x0000
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.LruCache.trimToSize(int):void");
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    /* access modifiers changed from: protected */
    public V create(K k) {
        return null;
    }

    private int safeSizeOf(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException("Negative size: " + ((Object) k) + "=" + ((Object) v));
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        int i;
        i = this.hitCount + this.missCount;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i != 0 ? (this.hitCount * 100) / i : 0));
    }
}
