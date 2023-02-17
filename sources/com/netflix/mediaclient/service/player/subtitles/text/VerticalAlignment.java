package com.netflix.mediaclient.service.player.subtitles.text;

import o.C1349Bv;
public enum VerticalAlignment {
    top("top", 48),
    center("center", 16),
    bottom("bottom", 80);
    

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f2102;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f2103;

    private VerticalAlignment(String str, int i) {
        this.f2102 = str;
        this.f2103 = i;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m1179() {
        return this.f2102;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.f2102;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static VerticalAlignment m1178(String str) {
        if (C1349Bv.m4113(str)) {
            return top;
        }
        String trim = str.trim();
        VerticalAlignment[] values = values();
        for (VerticalAlignment verticalAlignment : values) {
            if (verticalAlignment.m1179().equalsIgnoreCase(trim)) {
                return verticalAlignment;
            }
        }
        if ("after".equalsIgnoreCase(trim)) {
            return bottom;
        }
        return top;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m1180() {
        return this.f2103;
    }
}
