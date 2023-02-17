package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;
public final class UriUtil {
    public static Uri resolveToUri(String str, String str2) {
        return Uri.parse(resolve(str, str2));
    }

    public static String resolve(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String str3 = str == null ? "" : str;
        String str4 = str2 == null ? "" : str2;
        int[] uriIndices = getUriIndices(str4);
        if (uriIndices[0] != -1) {
            sb.append(str4);
            removeDotSegments(sb, uriIndices[1], uriIndices[2]);
            return sb.toString();
        }
        int[] uriIndices2 = getUriIndices(str3);
        if (uriIndices[3] == 0) {
            return sb.append((CharSequence) str3, 0, uriIndices2[3]).append(str4).toString();
        }
        if (uriIndices[2] == 0) {
            return sb.append((CharSequence) str3, 0, uriIndices2[2]).append(str4).toString();
        }
        if (uriIndices[1] != 0) {
            int i = uriIndices2[0] + 1;
            sb.append((CharSequence) str3, 0, i).append(str4);
            return removeDotSegments(sb, uriIndices[1] + i, uriIndices[2] + i);
        } else if (str4.charAt(uriIndices[1]) == '/') {
            sb.append((CharSequence) str3, 0, uriIndices2[1]).append(str4);
            return removeDotSegments(sb, uriIndices2[1], uriIndices2[1] + uriIndices[2]);
        } else if (uriIndices2[0] + 2 >= uriIndices2[1] || uriIndices2[1] != uriIndices2[2]) {
            int lastIndexOf = str3.lastIndexOf(47, uriIndices2[2] - 1);
            int i2 = lastIndexOf == -1 ? uriIndices2[1] : lastIndexOf + 1;
            sb.append((CharSequence) str3, 0, i2).append(str4);
            return removeDotSegments(sb, uriIndices2[1], uriIndices[2] + i2);
        } else {
            sb.append((CharSequence) str3, 0, uriIndices2[1]).append('/').append(str4);
            return removeDotSegments(sb, uriIndices2[1], uriIndices2[1] + uriIndices[2] + 1);
        }
    }

    private static String removeDotSegments(StringBuilder sb, int i, int i2) {
        int i3;
        if (i >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i4 = i;
        int i5 = i;
        while (i5 <= i2) {
            if (i5 == i2) {
                i3 = i5;
            } else if (sb.charAt(i5) == '/') {
                i3 = i5 + 1;
            } else {
                i5++;
            }
            if (i5 == i4 + 1 && sb.charAt(i4) == '.') {
                sb.delete(i4, i3);
                i2 -= i3 - i4;
                i5 = i4;
            } else if (i5 == i4 + 2 && sb.charAt(i4) == '.' && sb.charAt(i4 + 1) == '.') {
                int lastIndexOf = sb.lastIndexOf("/", i4 - 2) + 1;
                int i6 = lastIndexOf > i ? lastIndexOf : i;
                sb.delete(i6, i3);
                i2 -= i3 - i6;
                i4 = lastIndexOf;
                i5 = lastIndexOf;
            } else {
                i5++;
                i4 = i5;
            }
        }
        return sb.toString();
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x006c: APUT  (r2v0 int[]), (0 ??[int, short, byte, char]), (r7v1 int) */
    private static int[] getUriIndices(String str) {
        int i;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf == -1) {
            indexOf = length;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > indexOf) {
            indexOf2 = indexOf;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        if (indexOf4 + 2 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(indexOf4 + 2) == '/') {
            i = str.indexOf(47, indexOf4 + 3);
            if (i == -1 || i > indexOf2) {
                i = indexOf2;
            }
        } else {
            i = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i;
        iArr[2] = indexOf2;
        iArr[3] = indexOf;
        return iArr;
    }
}
