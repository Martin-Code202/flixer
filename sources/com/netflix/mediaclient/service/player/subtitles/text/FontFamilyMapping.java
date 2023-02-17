package com.netflix.mediaclient.service.player.subtitles.text;

import android.graphics.Typeface;
import o.C1349Bv;
public enum FontFamilyMapping {
    defaultType(Typeface.SANS_SERIF, "default"),
    monospaceSansSerif(Typeface.MONOSPACE, "monospaceSansSerif"),
    monospaceSansSerifApi(Typeface.MONOSPACE, "monospaced_sans_serif"),
    monospaceSerif(Typeface.MONOSPACE, "monospaceSerif"),
    monospaceSerifApi(Typeface.MONOSPACE, "monospaced_serif"),
    proportionalSansSerif(Typeface.SANS_SERIF, "proportionalSansSerif"),
    proportionalSansSerifApi(Typeface.SANS_SERIF, "proportional_sans_serif"),
    proportionalSerif(Typeface.SERIF, "proportionalSerif"),
    proportionalSerifApi(Typeface.SERIF, "proportional_serif"),
    casual(Typeface.SANS_SERIF, "casual"),
    cursive(Typeface.SANS_SERIF, "cursive"),
    smallCapitals(Typeface.SANS_SERIF, "smallCapitals"),
    smallCapitalsApi(Typeface.SANS_SERIF, "small_capitals"),
    monospace(Typeface.MONOSPACE, "monospace"),
    sansSerif(Typeface.SANS_SERIF, "sansSerif"),
    serif(Typeface.SERIF, "serif");
    

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private Typeface f2073;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private String f2074;

    private FontFamilyMapping(Typeface typeface, String str) {
        this.f2073 = typeface;
        this.f2074 = str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Typeface m1168() {
        return this.f2073;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m1167() {
        return this.f2074;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static FontFamilyMapping m1163(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        FontFamilyMapping[] values = values();
        for (FontFamilyMapping fontFamilyMapping : values) {
            if (fontFamilyMapping.m1167().equalsIgnoreCase(str)) {
                return fontFamilyMapping;
            }
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m1166(FontFamilyMapping fontFamilyMapping) {
        return fontFamilyMapping == null || fontFamilyMapping.m1168() == Typeface.SANS_SERIF;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m1165(FontFamilyMapping fontFamilyMapping) {
        return fontFamilyMapping != null && fontFamilyMapping.m1168() == Typeface.MONOSPACE;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m1164(FontFamilyMapping fontFamilyMapping) {
        return !m1165(fontFamilyMapping);
    }
}
