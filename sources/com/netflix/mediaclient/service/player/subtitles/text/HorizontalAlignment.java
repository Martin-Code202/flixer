package com.netflix.mediaclient.service.player.subtitles.text;

import o.C1349Bv;
public enum HorizontalAlignment {
    left("left", 3),
    center("center", 1),
    right("right", 5);
    

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f2090;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f2091;

    private HorizontalAlignment(String str, int i) {
        this.f2090 = str;
        this.f2091 = i;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m1174() {
        return this.f2090;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.f2090;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static HorizontalAlignment m1172(String str) {
        if (C1349Bv.m4113(str)) {
            return left;
        }
        String trim = str.trim();
        HorizontalAlignment[] values = values();
        for (HorizontalAlignment horizontalAlignment : values) {
            if (horizontalAlignment.m1174().equalsIgnoreCase(trim)) {
                return horizontalAlignment;
            }
        }
        if ("right".equalsIgnoreCase(trim)) {
            return right;
        }
        return left;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m1173() {
        return this.f2091;
    }
}
