package com.netflix.cl.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public enum NamedLogSessionLookup {
    INSTANCE;
    

    /* renamed from: ˊ  reason: contains not printable characters */
    private Map<String, Long> f528 = new ConcurrentHashMap();

    private NamedLogSessionLookup() {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m152(String str, Long l) {
        if (l != null && str != null) {
            this.f528.put(str, l);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Long m151(String str) {
        if (str == null) {
            return null;
        }
        return this.f528.remove(str);
    }
}
