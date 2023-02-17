package com.ibm.icu.impl.number;

import android.support.v4.view.PagerAdapter;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.NumberFormat;
public class AffixPatternUtils {
    static final /* synthetic */ boolean $assertionsDisabled = (!AffixPatternUtils.class.desiredAssertionStatus());

    public static int unescapedLength(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        char c = 0;
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int codePointAt = Character.codePointAt(charSequence, i);
            switch (c) {
                case 0:
                    if (codePointAt != 39) {
                        i2++;
                        break;
                    } else {
                        c = 1;
                        break;
                    }
                case 1:
                    if (codePointAt != 39) {
                        i2++;
                        c = 2;
                        break;
                    } else {
                        i2++;
                        c = 0;
                        break;
                    }
                case 2:
                    if (codePointAt != 39) {
                        i2++;
                        break;
                    } else {
                        c = 3;
                        break;
                    }
                case 3:
                    if (codePointAt != 39) {
                        i2++;
                        break;
                    } else {
                        i2++;
                        c = 2;
                        break;
                    }
                default:
                    throw new AssertionError();
            }
            i += Character.charCount(codePointAt);
        }
        switch (c) {
            case 1:
            case 2:
                throw new IllegalArgumentException("Unterminated quote: \"" + ((Object) charSequence) + "\"");
            default:
                return i2;
        }
    }

    public static int escape(CharSequence charSequence, StringBuilder sb) {
        if (charSequence == null) {
            return 0;
        }
        char c = 0;
        int i = 0;
        int length = sb.length();
        while (i < charSequence.length()) {
            int codePointAt = Character.codePointAt(charSequence, i);
            switch (codePointAt) {
                case 37:
                case 43:
                case 45:
                case 164:
                case 8240:
                    if (c != 0) {
                        sb.appendCodePoint(codePointAt);
                        break;
                    } else {
                        sb.append('\'');
                        sb.appendCodePoint(codePointAt);
                        c = 2;
                        break;
                    }
                case 39:
                    sb.append("''");
                    break;
                default:
                    if (c != 2) {
                        sb.appendCodePoint(codePointAt);
                        break;
                    } else {
                        sb.append('\'');
                        sb.appendCodePoint(codePointAt);
                        c = 0;
                        break;
                    }
            }
            i += Character.charCount(codePointAt);
        }
        if (c == 2) {
            sb.append('\'');
        }
        return sb.length() - length;
    }

    public static void unescape(CharSequence charSequence, DecimalFormatSymbols decimalFormatSymbols, String str, String str2, String str3, String str4, NumberStringBuilder numberStringBuilder) {
        if (charSequence != null && charSequence.length() != 0) {
            if (str4 == null) {
                str4 = decimalFormatSymbols.getMinusSignString();
            }
            long j = 0;
            while (hasNext(j, charSequence)) {
                j = nextToken(j, charSequence);
                int typeOrCp = getTypeOrCp(j);
                switch (typeOrCp) {
                    case -15:
                        numberStringBuilder.append("�", NumberFormat.Field.CURRENCY);
                        break;
                    case -14:
                    case -13:
                    case -12:
                    case -11:
                    case -10:
                    case -9:
                    case -8:
                    default:
                        numberStringBuilder.appendCodePoint(typeOrCp, null);
                        break;
                    case -7:
                        numberStringBuilder.append(str3, NumberFormat.Field.CURRENCY);
                        break;
                    case -6:
                        numberStringBuilder.append(str2, NumberFormat.Field.CURRENCY);
                        break;
                    case -5:
                        numberStringBuilder.append(str, NumberFormat.Field.CURRENCY);
                        break;
                    case -4:
                        numberStringBuilder.append(decimalFormatSymbols.getPerMillString(), NumberFormat.Field.PERMILLE);
                        break;
                    case -3:
                        numberStringBuilder.append(decimalFormatSymbols.getPercentString(), NumberFormat.Field.PERCENT);
                        break;
                    case PagerAdapter.POSITION_NONE /* -2 */:
                        numberStringBuilder.append(decimalFormatSymbols.getPlusSignString(), NumberFormat.Field.SIGN);
                        break;
                    case -1:
                        numberStringBuilder.append(str4, NumberFormat.Field.SIGN);
                        break;
                }
            }
        }
    }

    public static boolean containsType(CharSequence charSequence, int i) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        long j = 0;
        while (hasNext(j, charSequence)) {
            j = nextToken(j, charSequence);
            if (getTypeOrCp(j) == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean hasCurrencySymbols(java.lang.CharSequence r5) {
        /*
            if (r5 == 0) goto L_0x0008
            int r0 = r5.length()
            if (r0 != 0) goto L_0x000a
        L_0x0008:
            r0 = 0
            return r0
        L_0x000a:
            r2 = 0
        L_0x000c:
            boolean r0 = hasNext(r2, r5)
            if (r0 == 0) goto L_0x002a
            long r2 = nextToken(r2, r5)
            int r4 = getTypeOrCp(r2)
            r0 = -5
            if (r4 == r0) goto L_0x0027
            r0 = -6
            if (r4 == r0) goto L_0x0027
            r0 = -7
            if (r4 == r0) goto L_0x0027
            r0 = -15
            if (r4 != r0) goto L_0x0029
        L_0x0027:
            r0 = 1
            return r0
        L_0x0029:
            goto L_0x000c
        L_0x002a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.number.AffixPatternUtils.hasCurrencySymbols(java.lang.CharSequence):boolean");
    }

    public static String replaceType(CharSequence charSequence, int i, char c) {
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        char[] charArray = charSequence.toString().toCharArray();
        long j = 0;
        while (hasNext(j, charSequence)) {
            j = nextToken(j, charSequence);
            if (getTypeOrCp(j) == i) {
                charArray[getOffset(j) - 1] = c;
            }
        }
        return new String(charArray);
    }

    public static long nextToken(long j, CharSequence charSequence) {
        int offset = getOffset(j);
        int state = getState(j);
        while (offset < charSequence.length()) {
            int codePointAt = Character.codePointAt(charSequence, offset);
            int charCount = Character.charCount(codePointAt);
            switch (state) {
                case 0:
                    switch (codePointAt) {
                        case 37:
                            return makeTag(offset + charCount, -3, 0, 0);
                        case 39:
                            state = 1;
                            offset += charCount;
                            continue;
                        case 43:
                            return makeTag(offset + charCount, -2, 0, 0);
                        case 45:
                            return makeTag(offset + charCount, -1, 0, 0);
                        case 164:
                            state = 4;
                            offset += charCount;
                            continue;
                        case 8240:
                            return makeTag(offset + charCount, -4, 0, 0);
                        default:
                            return makeTag(offset + charCount, 0, 0, codePointAt);
                    }
                case 1:
                    if (codePointAt == 39) {
                        return makeTag(offset + charCount, 0, 0, codePointAt);
                    }
                    return makeTag(offset + charCount, 0, 2, codePointAt);
                case 2:
                    if (codePointAt == 39) {
                        state = 3;
                        offset += charCount;
                        break;
                    } else {
                        return makeTag(offset + charCount, 0, 2, codePointAt);
                    }
                case 3:
                    if (codePointAt != 39) {
                        state = 0;
                        break;
                    } else {
                        return makeTag(offset + charCount, 0, 2, codePointAt);
                    }
                case 4:
                    if (codePointAt == 164) {
                        state = 5;
                        offset += charCount;
                        break;
                    } else {
                        return makeTag(offset, -5, 0, 0);
                    }
                case 5:
                    if (codePointAt == 164) {
                        state = 6;
                        offset += charCount;
                        break;
                    } else {
                        return makeTag(offset, -6, 0, 0);
                    }
                case 6:
                    if (codePointAt == 164) {
                        state = 7;
                        offset += charCount;
                        break;
                    } else {
                        return makeTag(offset, -7, 0, 0);
                    }
                case 7:
                    if (codePointAt == 164) {
                        offset += charCount;
                        break;
                    } else {
                        return makeTag(offset, -15, 0, 0);
                    }
                default:
                    throw new AssertionError();
            }
        }
        switch (state) {
            case 0:
                return -1;
            case 1:
            case 2:
                throw new IllegalArgumentException("Unterminated quote in pattern affix: \"" + ((Object) charSequence) + "\"");
            case 3:
                return -1;
            case 4:
                return makeTag(offset, -5, 0, 0);
            case 5:
                return makeTag(offset, -6, 0, 0);
            case 6:
                return makeTag(offset, -7, 0, 0);
            case 7:
                return makeTag(offset, -15, 0, 0);
            default:
                throw new AssertionError();
        }
    }

    public static boolean hasNext(long j, CharSequence charSequence) {
        if ($assertionsDisabled || j >= 0) {
            int state = getState(j);
            int offset = getOffset(j);
            if (state == 2 && offset == charSequence.length() - 1 && charSequence.charAt(offset) == '\'') {
                return false;
            }
            return state != 0 || offset < charSequence.length();
        }
        throw new AssertionError();
    }

    public static int getTypeOrCp(long j) {
        if ($assertionsDisabled || j >= 0) {
            int type = getType(j);
            return type == 0 ? getCodePoint(j) : -type;
        }
        throw new AssertionError();
    }

    private static long makeTag(int i, int i2, int i3, int i4) {
        long j = 0 | ((long) i) | ((-((long) i2)) << 32) | (((long) i3) << 36) | (((long) i4) << 40);
        if ($assertionsDisabled || j >= 0) {
            return j;
        }
        throw new AssertionError();
    }

    static int getOffset(long j) {
        return (int) (-1 & j);
    }

    static int getType(long j) {
        return (int) ((j >>> 32) & 15);
    }

    static int getState(long j) {
        return (int) ((j >>> 36) & 15);
    }

    static int getCodePoint(long j) {
        return (int) (j >>> 40);
    }
}
