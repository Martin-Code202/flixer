package com.ibm.icu.impl;
public interface ICUCache<K, V> {
    public static final Object NULL = new Object();

    V get(Object obj);

    void put(K k, V v);
}
