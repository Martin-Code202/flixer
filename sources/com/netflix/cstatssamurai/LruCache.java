package com.netflix.cstatssamurai;

import java.util.LinkedHashMap;
import java.util.Map;
public class LruCache<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f529;

    public LruCache(int i) {
        super(i, 0.75f, true);
        this.f529 = i;
    }

    /* access modifiers changed from: protected */
    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.f529;
    }
}
