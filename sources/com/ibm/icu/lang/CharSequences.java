package com.ibm.icu.lang;
@Deprecated
public class CharSequences {
    @Deprecated
    public static int compare(CharSequence charSequence, int i) {
        int charAt;
        if (i < 0 || i > 1114111) {
            throw new IllegalArgumentException();
        }
        int length = charSequence.length();
        if (length == 0) {
            return -1;
        }
        char charAt2 = charSequence.charAt(0);
        int i2 = i - 65536;
        if (i2 < 0) {
            int i3 = charAt2 - i;
            if (i3 != 0) {
                return i3;
            }
            return length - 1;
        }
        int i4 = charAt2 - ((char) ((i2 >>> 10) + 55296));
        if (i4 != 0) {
            return i4;
        }
        if (length <= 1 || (charAt = charSequence.charAt(1) - ((char) ((i2 & 1023) + 56320))) == 0) {
            return length - 2;
        }
        return charAt;
    }

    @Deprecated
    public static int getSingleCodePoint(CharSequence charSequence) {
        int length = charSequence.length();
        if (length < 1 || length > 2) {
            return Integer.MAX_VALUE;
        }
        int codePointAt = Character.codePointAt(charSequence, 0);
        if ((codePointAt < 65536) == (length == 1)) {
            return codePointAt;
        }
        return Integer.MAX_VALUE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: int[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [char] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] codePoints(java.lang.CharSequence r7) {
        /*
            int r0 = r7.length()
            int[] r2 = new int[r0]
            r3 = 0
            r4 = 0
        L_0x0008:
            int r0 = r7.length()
            if (r4 >= r0) goto L_0x003e
            char r5 = r7.charAt(r4)
            r0 = 56320(0xdc00, float:7.8921E-41)
            if (r5 < r0) goto L_0x0036
            r0 = 57343(0xdfff, float:8.0355E-41)
            if (r5 > r0) goto L_0x0036
            if (r4 == 0) goto L_0x0036
            int r0 = r3 + -1
            r0 = r2[r0]
            char r6 = (char) r0
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r0) goto L_0x0036
            r0 = 56319(0xdbff, float:7.892E-41)
            if (r6 > r0) goto L_0x0036
            int r0 = r3 + -1
            int r1 = java.lang.Character.toCodePoint(r6, r5)
            r2[r0] = r1
            goto L_0x003b
        L_0x0036:
            r0 = r3
            int r3 = r3 + 1
            r2[r0] = r5
        L_0x003b:
            int r4 = r4 + 1
            goto L_0x0008
        L_0x003e:
            int r0 = r2.length
            if (r3 != r0) goto L_0x0042
            return r2
        L_0x0042:
            int[] r4 = new int[r3]
            r0 = 0
            r1 = 0
            java.lang.System.arraycopy(r2, r0, r4, r1, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.lang.CharSequences.codePoints(java.lang.CharSequence):int[]");
    }
}
