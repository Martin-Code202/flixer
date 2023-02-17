package com.netflix.mediaclient.service.player;

import o.C1457Fr;
public enum StreamProfileType {
    CE3("CE3"),
    AL0("AL0"),
    AL1("AL1"),
    UNKNOWN("UNKNOWN");
    

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f1615;

    protected StreamProfileType(String str) {
        C1457Fr.m5025(str, "value");
        this.f1615 = str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final String m934() {
        return this.f1615;
    }
}
