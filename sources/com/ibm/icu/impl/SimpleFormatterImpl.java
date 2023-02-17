package com.ibm.icu.impl;
public final class SimpleFormatterImpl {
    static final /* synthetic */ boolean $assertionsDisabled = (!SimpleFormatterImpl.class.desiredAssertionStatus());
    private static final String[][] COMMON_PATTERNS = {new String[]{"{0} {1}", "\u0002\u0000ā \u0001"}, new String[]{"{0} ({1})", "\u0002\u0000Ă (\u0001ā)"}, new String[]{"{0}, {1}", "\u0002\u0000Ă, \u0001"}, new String[]{"{0} – {1}", "\u0002\u0000ă – \u0001"}};

    private SimpleFormatterImpl() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String compileToStringMinMaxArguments(java.lang.CharSequence r11, java.lang.StringBuilder r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 418
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.SimpleFormatterImpl.compileToStringMinMaxArguments(java.lang.CharSequence, java.lang.StringBuilder, int, int):java.lang.String");
    }

    public static int getArgumentLimit(String str) {
        return str.charAt(0);
    }

    public static String formatRawPattern(String str, int i, int i2, CharSequence... charSequenceArr) {
        StringBuilder sb = new StringBuilder();
        String compileToStringMinMaxArguments = compileToStringMinMaxArguments(str, sb, i, i2);
        sb.setLength(0);
        return formatAndAppend(compileToStringMinMaxArguments, sb, null, charSequenceArr).toString();
    }

    public static StringBuilder formatAndAppend(String str, StringBuilder sb, int[] iArr, CharSequence... charSequenceArr) {
        if ((charSequenceArr != null ? charSequenceArr.length : 0) >= getArgumentLimit(str)) {
            return format(str, charSequenceArr, sb, null, true, iArr);
        }
        throw new IllegalArgumentException("Too few values.");
    }

    public static StringBuilder formatAndReplace(String str, StringBuilder sb, int[] iArr, CharSequence... charSequenceArr) {
        if ((charSequenceArr != null ? charSequenceArr.length : 0) < getArgumentLimit(str)) {
            throw new IllegalArgumentException("Too few values.");
        }
        char c = 65535;
        String str2 = null;
        if (getArgumentLimit(str) > 0) {
            int i = 1;
            while (i < str.length()) {
                i++;
                char charAt = str.charAt(i);
                if (charAt >= 256) {
                    i += charAt - 256;
                } else if (charSequenceArr[charAt] == sb) {
                    if (i == 2) {
                        c = charAt;
                    } else if (str2 == null) {
                        str2 = sb.toString();
                    }
                }
            }
        }
        if (c < 0) {
            sb.setLength(0);
        }
        return format(str, charSequenceArr, sb, str2, false, iArr);
    }

    private static StringBuilder format(String str, CharSequence[] charSequenceArr, StringBuilder sb, String str2, boolean z, int[] iArr) {
        int i;
        if (iArr == null) {
            i = 0;
        } else {
            i = iArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                iArr[i2] = -1;
            }
        }
        int i3 = 1;
        while (i3 < str.length()) {
            i3++;
            char charAt = str.charAt(i3);
            if (charAt < 256) {
                CharSequence charSequence = charSequenceArr[charAt];
                if (charSequence != sb) {
                    if (charAt < i) {
                        iArr[charAt] = sb.length();
                    }
                    sb.append(charSequence);
                } else if (z) {
                    throw new IllegalArgumentException("Value must not be same object as result");
                } else if (i3 != 2) {
                    if (charAt < i) {
                        iArr[charAt] = sb.length();
                    }
                    sb.append(str2);
                } else if (charAt < i) {
                    iArr[charAt] = 0;
                }
            } else {
                int i4 = i3 + (charAt - 256);
                sb.append((CharSequence) str, i3, i4);
                i3 = i4;
            }
        }
        return sb;
    }
}
