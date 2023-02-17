package com.ibm.icu.impl;

import com.ibm.icu.lang.CharSequences;
import com.ibm.icu.util.ICUException;
import java.util.Collection;
import java.util.Comparator;
public class StringRange {
    public static final Comparator<int[]> COMPARE_INT_ARRAYS = new Comparator<int[]>() { // from class: com.ibm.icu.impl.StringRange.1
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i = 0; i < min; i++) {
                int i2 = iArr[i] - iArr2[i];
                if (i2 != 0) {
                    return i2;
                }
            }
            return iArr.length - iArr2.length;
        }
    };

    public static Collection<String> expand(String str, String str2, boolean z, Collection<String> collection) {
        if (str == null || str2 == null) {
            throw new ICUException("Range must have 2 valid strings");
        }
        int[] codePoints = CharSequences.codePoints(str);
        int[] codePoints2 = CharSequences.codePoints(str2);
        int length = codePoints.length - codePoints2.length;
        if (z && length != 0) {
            throw new ICUException("Range must have equal-length strings");
        } else if (length < 0) {
            throw new ICUException("Range must have start-length ≥ end-length");
        } else if (codePoints2.length == 0) {
            throw new ICUException("Range must have end-length > 0");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.appendCodePoint(codePoints[i]);
            }
            add(0, length, codePoints, codePoints2, sb, collection);
            return collection;
        }
    }

    private static void add(int i, int i2, int[] iArr, int[] iArr2, StringBuilder sb, Collection<String> collection) {
        int i3 = iArr[i + i2];
        int i4 = iArr2[i];
        if (i3 > i4) {
            throw new ICUException("Range must have xᵢ ≤ yᵢ for each index i");
        }
        boolean z = i == iArr2.length + -1;
        int length = sb.length();
        for (int i5 = i3; i5 <= i4; i5++) {
            sb.appendCodePoint(i5);
            if (z) {
                collection.add(sb.toString());
            } else {
                add(i + 1, i2, iArr, iArr2, sb, collection);
            }
            sb.setLength(length);
        }
    }
}
