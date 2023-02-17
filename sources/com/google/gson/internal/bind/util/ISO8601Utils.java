package com.google.gson.internal.bind.util;

import java.util.TimeZone;
public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");

    /* JADX WARNING: Removed duplicated region for block: B:78:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x020a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r19, java.text.ParsePosition r20) {
        /*
        // Method dump skipped, instructions count: 646
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) {
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int i3 = i;
        int i4 = 0;
        if (i3 < i2) {
            i3++;
            int digit = Character.digit(str.charAt(i3), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = -digit;
        }
        while (i3 < i2) {
            i3++;
            int digit2 = Character.digit(str.charAt(i3), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = (i4 * 10) - digit2;
        }
        return -i4;
    }

    private static int indexOfNonDigit(String str, int i) {
        for (int i2 = i; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return i2;
            }
        }
        return str.length();
    }
}
