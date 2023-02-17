package com.netflix.mediaclient.service.player.subtitles.text;

import android.graphics.Color;
import o.C1283;
import o.C1349Bv;
public enum ColorMapping {
    black(0.0d, "black", "000000"),
    silver(1.2632256E7d, "silver", "c0c0c0"),
    gray(8421504.0d, "gray", "808080"),
    white(1.6777215E7d, "white", "ffffff"),
    maroon(8388608.0d, "maroon", "800000"),
    red(1.671168E7d, "red", "ff0000"),
    purple(8388736.0d, "purple", "800080"),
    fuchsia(1.6711935E7d, "fuchsia", "ff00ff"),
    magenta(1.6711935E7d, "magenta", "ff00ff"),
    green(65280.0d, "green", "00ff00"),
    lime(65280.0d, "lime", "00ff00"),
    olive(8421376.0d, "olive", "808000"),
    yellow(1.677696E7d, "yellow", "ffff00"),
    navy(128.0d, "navy", "000080"),
    blue(255.0d, "blue", "0000ff"),
    teal(32896.0d, "teal", "008080"),
    aqua(65535.0d, "aqua", "00ffff"),
    cyan(65535.0d, "cyan", "00ffff"),
    orange(1.675392E7d, "orange", "ffa500"),
    pink(1.6761035E7d, "pink", "ffc0cb"),
    transparent(-1.0d, "transparent", "");
    

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private String f2053;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private double f2054;

    /* renamed from: ʾ  reason: contains not printable characters */
    private String f2055;

    private ColorMapping(double d, String str, String str2) {
        this.f2054 = d;
        this.f2053 = str;
        this.f2055 = str2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m1162() {
        return this.f2055;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static ColorMapping m1160(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        ColorMapping[] values = values();
        for (ColorMapping colorMapping : values) {
            if (colorMapping.f2053.equalsIgnoreCase(str)) {
                return colorMapping;
            }
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m1159(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        ColorMapping r1 = m1160(str);
        if (r1 != null) {
            return r1.m1162();
        }
        return m1158(str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m1158(String str) {
        char[] charArray = str.toCharArray();
        if (charArray[0] != '#') {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (charArray.length == 7) {
            sb.append(charArray[1]).append(charArray[2]);
            sb.append(charArray[3]).append(charArray[4]);
            sb.append(charArray[5]).append(charArray[6]);
        } else if (charArray.length != 4) {
            return null;
        } else {
            sb.append(charArray[1]).append(charArray[1]);
            sb.append(charArray[2]).append(charArray[2]);
            sb.append(charArray[3]).append(charArray[3]);
        }
        return sb.toString();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Integer m1161(Float f, String str) {
        if (str == null) {
            return null;
        }
        String str2 = "#" + OpacityMapping.m1175(f) + str;
        try {
            return Integer.valueOf(Color.parseColor(str2));
        } catch (Throwable th) {
            C1283.m16850("nf_subtitles", "Resolve color failed for " + str2);
            return null;
        }
    }
}
