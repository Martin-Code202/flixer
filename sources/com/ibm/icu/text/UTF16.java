package com.ibm.icu.text;
public final class UTF16 {
    public static int charAt(String str, int i) {
        char charAt = str.charAt(i);
        if (charAt < 55296) {
            return charAt;
        }
        return _charAt(str, i, charAt);
    }

    private static int _charAt(String str, int i, char c) {
        char charAt;
        char charAt2;
        if (c > 57343) {
            return c;
        }
        if (c <= 56319) {
            int i2 = i + 1;
            if (str.length() != i2 && (charAt2 = str.charAt(i2)) >= 56320 && charAt2 <= 57343) {
                return Character.toCodePoint(c, charAt2);
            }
        } else {
            int i3 = i - 1;
            if (i3 >= 0 && (charAt = str.charAt(i3)) >= 55296 && charAt <= 56319) {
                return Character.toCodePoint(charAt, c);
            }
        }
        return c;
    }

    public static int charAt(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        if (charAt < 55296) {
            return charAt;
        }
        return _charAt(charSequence, i, charAt);
    }

    private static int _charAt(CharSequence charSequence, int i, char c) {
        char charAt;
        char charAt2;
        if (c > 57343) {
            return c;
        }
        if (c <= 56319) {
            int i2 = i + 1;
            if (charSequence.length() != i2 && (charAt2 = charSequence.charAt(i2)) >= 56320 && charAt2 <= 57343) {
                return Character.toCodePoint(c, charAt2);
            }
        } else {
            int i3 = i - 1;
            if (i3 >= 0 && (charAt = charSequence.charAt(i3)) >= 55296 && charAt <= 56319) {
                return Character.toCodePoint(charAt, c);
            }
        }
        return c;
    }

    public static int charAt(char[] cArr, int i, int i2, int i3) {
        int i4 = i3 + i;
        if (i4 < i || i4 >= i2) {
            throw new ArrayIndexOutOfBoundsException(i4);
        }
        char c = cArr[i4];
        if (!isSurrogate(c)) {
            return c;
        }
        if (c <= 56319) {
            int i5 = i4 + 1;
            if (i5 >= i2) {
                return c;
            }
            char c2 = cArr[i5];
            if (isTrailSurrogate(c2)) {
                return Character.toCodePoint(c, c2);
            }
        } else if (i4 == i) {
            return c;
        } else {
            char c3 = cArr[i4 - 1];
            if (isLeadSurrogate(c3)) {
                return Character.toCodePoint(c3, c);
            }
        }
        return c;
    }

    public static int getCharCount(int i) {
        if (i < 65536) {
            return 1;
        }
        return 2;
    }

    public static boolean isSurrogate(char c) {
        return (c & 63488) == 55296;
    }

    public static boolean isTrailSurrogate(char c) {
        return (c & 64512) == 56320;
    }

    public static boolean isLeadSurrogate(char c) {
        return (c & 64512) == 55296;
    }

    public static char getLeadSurrogate(int i) {
        if (i >= 65536) {
            return (char) ((i >> 10) + 55232);
        }
        return 0;
    }

    public static char getTrailSurrogate(int i) {
        if (i >= 65536) {
            return (char) ((i & 1023) + 56320);
        }
        return (char) i;
    }

    public static String valueOf(int i) {
        if (i >= 0 && i <= 1114111) {
            return toString(i);
        }
        throw new IllegalArgumentException("Illegal codepoint");
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : 0x000f: INVOKE  (r0v1 char) = (r2v0 int) type: STATIC call: com.ibm.icu.text.UTF16.getLeadSurrogate(int):char), (wrap: char : 0x0016: INVOKE  (r0v2 char) = (r2v0 int) type: STATIC call: com.ibm.icu.text.UTF16.getTrailSurrogate(int):char)] */
    private static String toString(int i) {
        if (i < 65536) {
            return String.valueOf((char) i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getLeadSurrogate(i));
        sb.append(getTrailSurrogate(i));
        return sb.toString();
    }
}
