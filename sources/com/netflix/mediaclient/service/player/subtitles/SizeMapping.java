package com.netflix.mediaclient.service.player.subtitles;

import o.C1349Bv;
public enum SizeMapping {
    small(75, "SMALL"),
    medium(100, "MEDIUM"),
    large(200, "LARGE");
    

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f1988;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f1989;

    private SizeMapping(int i, String str) {
        this.f1988 = i;
        this.f1989 = str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m1141() {
        return this.f1988;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m1140(String str) {
        if (C1349Bv.m4113(str)) {
            return medium.m1141();
        }
        SizeMapping[] values = values();
        for (SizeMapping sizeMapping : values) {
            if (sizeMapping.f1989.equalsIgnoreCase(str)) {
                return sizeMapping.f1988;
            }
        }
        return medium.m1141();
    }
}
