package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.UTF16;
import java.io.IOException;
import java.util.Locale;
public final class Utility {
    static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static final char[] HEX_DIGIT = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final char[] UNESCAPE_MAP = {'a', 7, 'b', '\b', 'e', 27, 'f', '\f', 'n', '\n', 'r', '\r', 't', '\t', 'v', 11};

    public static final boolean arrayEquals(Object[] objArr, Object obj) {
        if (objArr == null) {
            return obj == null;
        }
        if (!(obj instanceof Object[])) {
            return false;
        }
        Object[] objArr2 = (Object[]) obj;
        return objArr.length == objArr2.length && arrayRegionMatches(objArr, 0, objArr2, 0, objArr.length);
    }

    public static final boolean arrayEquals(int[] iArr, Object obj) {
        if (iArr == null) {
            return obj == null;
        }
        if (!(obj instanceof int[])) {
            return false;
        }
        int[] iArr2 = (int[]) obj;
        return iArr.length == iArr2.length && arrayRegionMatches(iArr, 0, iArr2, 0, iArr.length);
    }

    public static final boolean arrayEquals(double[] dArr, Object obj) {
        if (dArr == null) {
            return obj == null;
        }
        if (!(obj instanceof double[])) {
            return false;
        }
        double[] dArr2 = (double[]) obj;
        return dArr.length == dArr2.length && arrayRegionMatches(dArr, 0, dArr2, 0, dArr.length);
    }

    public static final boolean arrayEquals(byte[] bArr, Object obj) {
        if (bArr == null) {
            return obj == null;
        }
        if (!(obj instanceof byte[])) {
            return false;
        }
        byte[] bArr2 = (byte[]) obj;
        return bArr.length == bArr2.length && arrayRegionMatches(bArr, 0, bArr2, 0, bArr.length);
    }

    public static final boolean arrayEquals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof Object[]) {
            return arrayEquals((Object[]) obj, obj2);
        }
        if (obj instanceof int[]) {
            return arrayEquals((int[]) obj, obj2);
        }
        if (obj instanceof double[]) {
            return arrayEquals((double[]) obj, obj2);
        }
        if (obj instanceof byte[]) {
            return arrayEquals((byte[]) obj, obj2);
        }
        return obj.equals(obj2);
    }

    public static final boolean arrayRegionMatches(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        int i4 = i + i3;
        int i5 = i2 - i;
        for (int i6 = i; i6 < i4; i6++) {
            if (!arrayEquals(objArr[i6], objArr2[i6 + i5])) {
                return false;
            }
        }
        return true;
    }

    public static final boolean arrayRegionMatches(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = i + i3;
        int i5 = i2 - i;
        for (int i6 = i; i6 < i4; i6++) {
            if (iArr[i6] != iArr2[i6 + i5]) {
                return false;
            }
        }
        return true;
    }

    public static final boolean arrayRegionMatches(double[] dArr, int i, double[] dArr2, int i2, int i3) {
        int i4 = i + i3;
        int i5 = i2 - i;
        for (int i6 = i; i6 < i4; i6++) {
            if (dArr[i6] != dArr2[i6 + i5]) {
                return false;
            }
        }
        return true;
    }

    public static final boolean arrayRegionMatches(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i + i3;
        int i5 = i2 - i;
        for (int i6 = i; i6 < i4; i6++) {
            if (bArr[i6] != bArr2[i6 + i5]) {
                return false;
            }
        }
        return true;
    }

    public static final boolean sameObjects(Object obj, Object obj2) {
        return obj == obj2;
    }

    public static final boolean objectEquals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static final String escape(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int codePointAt = Character.codePointAt(str, i);
            i += UTF16.getCharCount(codePointAt);
            if (codePointAt < 32 || codePointAt > 127) {
                boolean z = codePointAt <= 65535;
                sb.append(z ? "\\u" : "\\U");
                sb.append(hex((long) codePointAt, z ? 4 : 8));
            } else if (codePointAt == 92) {
                sb.append("\\\\");
            } else {
                sb.append((char) codePointAt);
            }
        }
        return sb.toString();
    }

    public static int unescapeAt(String str, int[] iArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 4;
        boolean z = false;
        int i6 = iArr[0];
        int length = str.length();
        if (i6 < 0 || i6 >= length) {
            return -1;
        }
        int codePointAt = Character.codePointAt(str, i6);
        int charCount = i6 + UTF16.getCharCount(codePointAt);
        switch (codePointAt) {
            case 85:
                i4 = 8;
                i3 = 8;
                break;
            case 117:
                i4 = 4;
                i3 = 4;
                break;
            case 120:
                i3 = 1;
                if (charCount >= length || UTF16.charAt(str, charCount) != 123) {
                    i4 = 2;
                    break;
                } else {
                    charCount++;
                    z = true;
                    i4 = 8;
                    break;
                }
                break;
            default:
                int digit = UCharacter.digit(codePointAt, 8);
                if (digit >= 0) {
                    i3 = 1;
                    i4 = 3;
                    i2 = 1;
                    i5 = 3;
                    i = digit;
                    break;
                }
                break;
        }
        if (i3 != 0) {
            while (charCount < length && i2 < i4) {
                codePointAt = UTF16.charAt(str, charCount);
                int digit2 = UCharacter.digit(codePointAt, i5 == 3 ? 8 : 16);
                if (digit2 >= 0) {
                    i = (i << i5) | digit2;
                    charCount += UTF16.getCharCount(codePointAt);
                    i2++;
                }
            }
            if (i2 < i3) {
                return -1;
            }
            if (z) {
                if (codePointAt != 125) {
                    return -1;
                }
                charCount++;
            }
            if (i < 0 || i >= 1114112) {
                return -1;
            }
            if (charCount < length && UTF16.isLeadSurrogate((char) i)) {
                int i7 = charCount + 1;
                int charAt = str.charAt(charCount);
                if (charAt == 92 && i7 < length) {
                    int[] iArr2 = {i7};
                    charAt = unescapeAt(str, iArr2);
                    i7 = iArr2[0];
                }
                if (UTF16.isTrailSurrogate((char) charAt)) {
                    charCount = i7;
                    i = Character.toCodePoint((char) i, (char) charAt);
                }
            }
            iArr[0] = charCount;
            return i;
        }
        for (int i8 = 0; i8 < UNESCAPE_MAP.length; i8 += 2) {
            if (codePointAt == UNESCAPE_MAP[i8]) {
                iArr[0] = charCount;
                return UNESCAPE_MAP[i8 + 1];
            } else if (codePointAt < UNESCAPE_MAP[i8]) {
                if (codePointAt == 99 || charCount >= length) {
                    iArr[0] = charCount;
                    return codePointAt;
                } else {
                    int charAt2 = UTF16.charAt(str, charCount);
                    iArr[0] = UTF16.getCharCount(charAt2) + charCount;
                    return charAt2 & 31;
                }
            }
        }
        if (codePointAt == 99) {
        }
        iArr[0] = charCount;
        return codePointAt;
    }

    public static String hex(long j, int i) {
        if (j == Long.MIN_VALUE) {
            return "-8000000000000000";
        }
        boolean z = j < 0;
        if (z) {
            j = -j;
        }
        String upperCase = Long.toString(j, 16).toUpperCase(Locale.ENGLISH);
        if (upperCase.length() < i) {
            upperCase = "0000000000000000".substring(upperCase.length(), i) + upperCase;
        }
        if (z) {
            return '-' + upperCase;
        }
        return upperCase;
    }

    public static boolean isUnprintable(int i) {
        return i < 32 || i > 126;
    }

    public static <T extends Appendable> boolean escapeUnprintable(T t, int i) {
        try {
            if (!isUnprintable(i)) {
                return false;
            }
            t.append('\\');
            if ((-65536 & i) != 0) {
                t.append('U');
                t.append(DIGITS[(i >> 28) & 15]);
                t.append(DIGITS[(i >> 24) & 15]);
                t.append(DIGITS[(i >> 20) & 15]);
                t.append(DIGITS[(i >> 16) & 15]);
            } else {
                t.append('u');
            }
            t.append(DIGITS[(i >> 12) & 15]);
            t.append(DIGITS[(i >> 8) & 15]);
            t.append(DIGITS[(i >> 4) & 15]);
            t.append(DIGITS[i & 15]);
            return true;
        } catch (IOException e) {
            throw new IllegalIcuArgumentException(e);
        }
    }
}
