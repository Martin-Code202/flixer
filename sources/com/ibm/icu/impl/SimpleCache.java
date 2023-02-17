package com.ibm.icu.impl;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class SimpleCache<K, V> implements ICUCache<K, V> {
    private volatile Reference<Map<K, V>> cacheRef = null;
    private int capacity = 16;
    private int type = 0;

    @Override // com.ibm.icu.impl.ICUCache
    public V get(Object obj) {
        Map<K, V> map;
        Reference<Map<K, V>> reference = this.cacheRef;
        if (reference == null || (map = reference.get()) == null) {
            return null;
        }
        return map.get(obj);
    }

    @Override // com.ibm.icu.impl.ICUCache
    public void put(K k, V v) {
        Reference<Map<K, V>> reference;
        Reference<Map<K, V>> reference2 = this.cacheRef;
        Map<K, V> map = null;
        if (reference2 != null) {
            map = reference2.get();
        }
        if (map == null) {
            map = Collections.synchronizedMap(new HashMap(this.capacity));
            if (this.type == 1) {
                reference = new WeakReference<>(map);
            } else {
                reference = new SoftReference<>(map);
            }
            this.cacheRef = reference;
        }
        map.put(k, v);
    }
}
