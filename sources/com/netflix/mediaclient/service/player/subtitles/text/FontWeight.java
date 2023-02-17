package com.netflix.mediaclient.service.player.subtitles.text;
public enum FontWeight {
    Thin(100),
    Light(200),
    Book(300),
    Regular(400),
    Medium(500),
    SemiBold(600),
    Bold(700),
    Black(800),
    ExtraBlack(800);
    

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f2085;

    private FontWeight(int i) {
        this.f2085 = i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m1171() {
        return this.f2085;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static FontWeight m1169(String str) {
        String r1 = m1170(str);
        FontWeight[] values = values();
        for (FontWeight fontWeight : values) {
            if (fontWeight.name().equalsIgnoreCase(r1)) {
                return fontWeight;
            }
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m1170(String str) {
        if ("normal".equalsIgnoreCase(str)) {
            return Regular.name();
        }
        return str;
    }
}
