package com.netflix.mediaclient.service.player.subtitles.text;

import o.C1283;
import o.C1349Bv;
public enum OpacityMapping {
    none(Float.valueOf(0.0f), "NONE"),
    semiTransparent(Float.valueOf(0.5f), "SEMI_TRANSPARENT"),
    opaque(Float.valueOf(1.0f), "OPAQUE");
    

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f2096;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Float f2097;

    private OpacityMapping(Float f, String str) {
        this.f2097 = f;
        this.f2096 = str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Float m1177() {
        return this.f2097;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Float m1176(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        OpacityMapping[] values = values();
        for (OpacityMapping opacityMapping : values) {
            if (opacityMapping.f2096.equalsIgnoreCase(str)) {
                return opacityMapping.m1177();
            }
        }
        try {
            Float valueOf = Float.valueOf(str);
            if (valueOf.floatValue() >= opaque.m1177().floatValue()) {
                return opaque.m1177();
            }
            if (valueOf.floatValue() < none.m1177().floatValue()) {
                return none.m1177();
            }
            return valueOf;
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles", "Failed to parse opacityt value " + str, th);
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m1175(Float f) {
        if (f == null) {
            return "FF";
        }
        if (f.floatValue() <= 0.0f) {
            return "00";
        }
        if (f.floatValue() >= 1.0f) {
            return "FF";
        }
        return Integer.toHexString((int) (f.floatValue() * 255.0f));
    }
}
