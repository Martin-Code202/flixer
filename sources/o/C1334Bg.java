package o;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: o.Bg  reason: case insensitive filesystem */
public class C1334Bg {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Pattern f4646 = Pattern.compile("^[0-9]+%$");

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final Pattern f4647 = Pattern.compile("^[0-9]+px$", 2);

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Integer m4020(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        try {
            Matcher matcher = f4647.matcher(str.toLowerCase(Locale.US));
            if (!matcher.find()) {
                return null;
            }
            return Integer.valueOf(matcher.group().replaceAll("px", ""));
        } catch (NumberFormatException e) {
            C1283.m16847("PlatformStringUtils", "Failed to parse pixel size ", e);
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Integer m4021(String str, int i, int i2, boolean z) {
        Integer r1 = m4019(str);
        if (r1 == null) {
            return r1;
        }
        if (r1.intValue() < i) {
            if (z) {
                return null;
            }
            return Integer.valueOf(i);
        } else if (r1.intValue() <= i2) {
            return r1;
        } else {
            if (z) {
                return null;
            }
            return Integer.valueOf(i2);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Integer m4019(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        try {
            Matcher matcher = f4646.matcher(str);
            if (!matcher.find()) {
                return null;
            }
            return Integer.valueOf(matcher.group().replaceAll("%", ""));
        } catch (NumberFormatException e) {
            C1283.m16847("PlatformStringUtils", "Failed to parse percentage ", e);
            return null;
        }
    }
}
