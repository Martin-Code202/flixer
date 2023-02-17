package com.ibm.icu.impl;

import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.OutputInt;
import java.util.ArrayList;
public class UnicodeSetStringSpan {
    private boolean all;
    private final int maxLength16;
    private OffsetList offsets;
    private boolean someRelevant;
    private short[] spanLengths;
    private UnicodeSet spanNotSet;
    private UnicodeSet spanSet = new UnicodeSet(0, 1114111);
    private ArrayList<String> strings;

    public UnicodeSetStringSpan(UnicodeSet unicodeSet, ArrayList<String> arrayList, int i) {
        int i2;
        int i3;
        this.strings = arrayList;
        this.all = i == 127;
        this.spanSet.retainAll(unicodeSet);
        if (0 != (i & 1)) {
            this.spanNotSet = this.spanSet;
        }
        this.offsets = new OffsetList();
        int size = this.strings.size();
        int i4 = 0;
        this.someRelevant = false;
        for (int i5 = 0; i5 < size; i5++) {
            String str = this.strings.get(i5);
            int length = str.length();
            if (this.spanSet.span(str, UnicodeSet.SpanCondition.CONTAINED) < length) {
                this.someRelevant = true;
            }
            if (length > i4) {
                i4 = length;
            }
        }
        this.maxLength16 = i4;
        if (this.someRelevant || (i & 64) != 0) {
            if (this.all) {
                this.spanSet.freeze();
            }
            if (this.all) {
                i2 = size * 2;
            } else {
                i2 = size;
            }
            this.spanLengths = new short[i2];
            if (this.all) {
                i3 = size;
            } else {
                i3 = 0;
            }
            for (int i6 = 0; i6 < size; i6++) {
                String str2 = this.strings.get(i6);
                int length2 = str2.length();
                int span = this.spanSet.span(str2, UnicodeSet.SpanCondition.CONTAINED);
                if (span < length2) {
                    if (0 != (i & 2)) {
                        if (0 != (i & 32)) {
                            this.spanLengths[i6] = makeSpanLengthByte(span);
                        }
                        if (0 != (i & 16)) {
                            this.spanLengths[i3 + i6] = makeSpanLengthByte(length2 - this.spanSet.spanBack(str2, length2, UnicodeSet.SpanCondition.CONTAINED));
                        }
                    } else {
                        short[] sArr = this.spanLengths;
                        this.spanLengths[i3 + i6] = 0;
                        sArr[i6] = 0;
                    }
                    if (0 != (i & 1)) {
                        if (0 != (i & 32)) {
                            addToSpanNotSet(str2.codePointAt(0));
                        }
                        if (0 != (i & 16)) {
                            addToSpanNotSet(str2.codePointBefore(length2));
                        }
                    }
                } else if (this.all) {
                    short[] sArr2 = this.spanLengths;
                    this.spanLengths[i3 + i6] = 255;
                    sArr2[i6] = 255;
                } else {
                    this.spanLengths[i6] = 255;
                }
            }
            if (this.all) {
                this.spanNotSet.freeze();
            }
        }
    }

    public boolean needsStringSpanUTF16() {
        return this.someRelevant;
    }

    public boolean contains(int i) {
        return this.spanSet.contains(i);
    }

    private void addToSpanNotSet(int i) {
        if (Utility.sameObjects(this.spanNotSet, null) || Utility.sameObjects(this.spanNotSet, this.spanSet)) {
            if (!this.spanSet.contains(i)) {
                this.spanNotSet = this.spanSet.cloneAsThawed();
            } else {
                return;
            }
        }
        this.spanNotSet.add(i);
    }

    public int span(CharSequence charSequence, int i, UnicodeSet.SpanCondition spanCondition) {
        if (spanCondition == UnicodeSet.SpanCondition.NOT_CONTAINED) {
            return spanNot(charSequence, i, null);
        }
        int span = this.spanSet.span(charSequence, i, UnicodeSet.SpanCondition.CONTAINED);
        if (span == charSequence.length()) {
            return span;
        }
        return spanWithStrings(charSequence, i, span, spanCondition);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00a5 */
    private synchronized int spanWithStrings(CharSequence charSequence, int i, int i2, UnicodeSet.SpanCondition spanCondition) {
        int span;
        int i3 = 0;
        if (spanCondition == UnicodeSet.SpanCondition.CONTAINED) {
            i3 = this.maxLength16;
        }
        this.offsets.setMaxLength(i3);
        int length = charSequence.length();
        int i4 = i2;
        int i5 = length - i2;
        int i6 = i2 - i;
        int size = this.strings.size();
        while (true) {
            if (spanCondition == UnicodeSet.SpanCondition.CONTAINED) {
                for (int i7 = 0; i7 < size; i7++) {
                    short s = this.spanLengths[i7];
                    if (s != 255) {
                        String str = this.strings.get(i7);
                        int length2 = str.length();
                        short s2 = s;
                        if (s >= 254) {
                            s2 = str.offsetByCodePoints(length2, -1);
                        }
                        if (s2 > i6) {
                            s2 = i6;
                        }
                        int i8 = length2 - (s2 == 1 ? 1 : 0);
                        int i9 = s2;
                        while (true) {
                            if (i8 > i5) {
                                break;
                            }
                            if (!this.offsets.containsOffset(i8) && matches16CPB(charSequence, i4 - i9, length, str, length2)) {
                                if (i8 == i5) {
                                    return length;
                                }
                                this.offsets.addOffset(i8);
                            }
                            if (i9 == 0) {
                                break;
                            }
                            i8++;
                            i9 = (i9 == 1 ? 1 : 0) - 1;
                        }
                    }
                }
            } else {
                int i10 = 0;
                char c = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    short s3 = this.spanLengths[i11];
                    String str2 = this.strings.get(i11);
                    int length3 = str2.length();
                    short s4 = s3;
                    if (s3 >= 254) {
                        s4 = length3;
                    }
                    if (s4 > i6) {
                        s4 = i6;
                    }
                    int i12 = length3 - (s4 == 1 ? 1 : 0);
                    int i13 = s4;
                    while (true) {
                        if (i12 > i5) {
                            break;
                        } else if (i13 < c) {
                            break;
                        } else if ((i13 > c || i12 > i10) && matches16CPB(charSequence, i4 - i13, length, str2, length3)) {
                            i10 = i12;
                            c = i13 == 1 ? 1 : 0;
                            break;
                        } else {
                            i12++;
                            i13 = (i13 == 1 ? 1 : 0) - 1;
                        }
                    }
                }
                if (i10 != 0 || c != 0) {
                    i4 += i10;
                    i5 -= i10;
                    if (i5 == 0) {
                        return length;
                    }
                    i6 = 0;
                }
            }
            if (i6 != 0 || i4 == 0) {
                if (this.offsets.isEmpty()) {
                    return i4;
                }
            } else if (this.offsets.isEmpty()) {
                span = this.spanSet.span(charSequence, i4, UnicodeSet.SpanCondition.CONTAINED);
                i6 = span - i4;
                if (i6 == i5 || i6 == 0) {
                    break;
                }
                i4 += i6;
                i5 -= i6;
            } else {
                int spanOne = spanOne(this.spanSet, charSequence, i4, i5);
                if (spanOne > 0) {
                    if (spanOne == i5) {
                        return length;
                    }
                    i4 += spanOne;
                    i5 -= spanOne;
                    this.offsets.shift(spanOne);
                    i6 = 0;
                }
            }
            int popMinimum = this.offsets.popMinimum(null);
            i4 += popMinimum;
            i5 -= popMinimum;
            i6 = 0;
        }
        return span;
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    public int spanAndCount(java.lang.CharSequence r12, int r13, com.ibm.icu.text.UnicodeSet.SpanCondition r14, com.ibm.icu.util.OutputInt r15) {
        /*
            r11 = this;
            com.ibm.icu.text.UnicodeSet$SpanCondition r0 = com.ibm.icu.text.UnicodeSet.SpanCondition.NOT_CONTAINED
            if (r14 != r0) goto L_0x0009
            int r0 = r11.spanNot(r12, r13, r15)
            return r0
        L_0x0009:
            com.ibm.icu.text.UnicodeSet$SpanCondition r0 = com.ibm.icu.text.UnicodeSet.SpanCondition.CONTAINED
            if (r14 != r0) goto L_0x0012
            int r0 = r11.spanContainedAndCount(r12, r13, r15)
            return r0
        L_0x0012:
            java.util.ArrayList<java.lang.String> r0 = r11.strings
            int r1 = r0.size()
            int r2 = r12.length()
            r3 = r13
            int r4 = r2 - r13
            r5 = 0
        L_0x0020:
            if (r4 == 0) goto L_0x0056
            com.ibm.icu.text.UnicodeSet r0 = r11.spanSet
            int r6 = spanOne(r0, r12, r3, r4)
            if (r6 <= 0) goto L_0x002c
            r7 = r6
            goto L_0x002d
        L_0x002c:
            r7 = 0
        L_0x002d:
            r8 = 0
        L_0x002e:
            if (r8 >= r1) goto L_0x004b
            java.util.ArrayList<java.lang.String> r0 = r11.strings
            java.lang.Object r0 = r0.get(r8)
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            int r10 = r9.length()
            if (r7 >= r10) goto L_0x0048
            if (r10 > r4) goto L_0x0048
            boolean r0 = matches16CPB(r12, r3, r2, r9, r10)
            if (r0 == 0) goto L_0x0048
            r7 = r10
        L_0x0048:
            int r8 = r8 + 1
            goto L_0x002e
        L_0x004b:
            if (r7 != 0) goto L_0x0050
            r15.value = r5
            return r3
        L_0x0050:
            int r5 = r5 + 1
            int r3 = r3 + r7
            int r4 = r4 - r7
            goto L_0x0020
        L_0x0056:
            r15.value = r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.UnicodeSetStringSpan.spanAndCount(java.lang.CharSequence, int, com.ibm.icu.text.UnicodeSet$SpanCondition, com.ibm.icu.util.OutputInt):int");
    }

    private synchronized int spanContainedAndCount(CharSequence charSequence, int i, OutputInt outputInt) {
        this.offsets.setMaxLength(this.maxLength16);
        int size = this.strings.size();
        int length = charSequence.length();
        int i2 = i;
        int i3 = length - i;
        int i4 = 0;
        while (i3 != 0) {
            int spanOne = spanOne(this.spanSet, charSequence, i2, i3);
            if (spanOne > 0) {
                this.offsets.addOffsetAndCount(spanOne, i4 + 1);
            }
            for (int i5 = 0; i5 < size; i5++) {
                String str = this.strings.get(i5);
                int length2 = str.length();
                if (length2 <= i3 && !this.offsets.hasCountAtOffset(length2, i4 + 1) && matches16CPB(charSequence, i2, length, str, length2)) {
                    this.offsets.addOffsetAndCount(length2, i4 + 1);
                }
            }
            if (this.offsets.isEmpty()) {
                outputInt.value = i4;
                return i2;
            }
            int popMinimum = this.offsets.popMinimum(outputInt);
            i4 = outputInt.value;
            i2 += popMinimum;
            i3 -= popMinimum;
        }
        outputInt.value = i4;
        return i2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x007d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x00d4 */
    public synchronized int spanBack(CharSequence charSequence, int i, UnicodeSet.SpanCondition spanCondition) {
        if (spanCondition == UnicodeSet.SpanCondition.NOT_CONTAINED) {
            return spanNotBack(charSequence, i);
        }
        int spanBack = this.spanSet.spanBack(charSequence, i, UnicodeSet.SpanCondition.CONTAINED);
        if (spanBack == 0) {
            return 0;
        }
        int i2 = i - spanBack;
        int i3 = 0;
        if (spanCondition == UnicodeSet.SpanCondition.CONTAINED) {
            i3 = this.maxLength16;
        }
        this.offsets.setMaxLength(i3);
        int size = this.strings.size();
        int i4 = 0;
        if (this.all) {
            i4 = size;
        }
        while (true) {
            if (spanCondition == UnicodeSet.SpanCondition.CONTAINED) {
                for (int i5 = 0; i5 < size; i5++) {
                    short s = this.spanLengths[i4 + i5];
                    if (s != 255) {
                        String str = this.strings.get(i5);
                        int length = str.length();
                        short s2 = s;
                        if (s >= 254) {
                            s2 = length - str.offsetByCodePoints(0, 1);
                        }
                        if (s2 > i2) {
                            s2 = i2;
                        }
                        int i6 = length - (s2 == 1 ? 1 : 0);
                        int i7 = s2;
                        while (true) {
                            if (i6 > spanBack) {
                                break;
                            }
                            if (!this.offsets.containsOffset(i6) && matches16CPB(charSequence, spanBack - i6, i, str, length)) {
                                if (i6 == spanBack) {
                                    return 0;
                                }
                                this.offsets.addOffset(i6);
                            }
                            if (i7 == 0) {
                                break;
                            }
                            i6++;
                            i7 = (i7 == 1 ? 1 : 0) - 1;
                        }
                    }
                }
            } else {
                int i8 = 0;
                char c = 0;
                for (int i9 = 0; i9 < size; i9++) {
                    short s3 = this.spanLengths[i4 + i9];
                    String str2 = this.strings.get(i9);
                    int length2 = str2.length();
                    short s4 = s3;
                    if (s3 >= 254) {
                        s4 = length2;
                    }
                    if (s4 > i2) {
                        s4 = i2;
                    }
                    int i10 = length2 - (s4 == 1 ? 1 : 0);
                    int i11 = s4;
                    while (true) {
                        if (i10 > spanBack) {
                            break;
                        } else if (i11 < c) {
                            break;
                        } else if ((i11 > c || i10 > i8) && matches16CPB(charSequence, spanBack - i10, i, str2, length2)) {
                            i8 = i10;
                            c = i11 == 1 ? 1 : 0;
                            break;
                        } else {
                            i10++;
                            i11 = (i11 == 1 ? 1 : 0) - 1;
                        }
                    }
                }
                if (i8 != 0 || c != 0) {
                    spanBack -= i8;
                    if (spanBack == 0) {
                        return 0;
                    }
                    i2 = 0;
                }
            }
            if (i2 != 0 || spanBack == i) {
                if (this.offsets.isEmpty()) {
                    return spanBack;
                }
            } else if (this.offsets.isEmpty()) {
                spanBack = this.spanSet.spanBack(charSequence, spanBack, UnicodeSet.SpanCondition.CONTAINED);
                i2 = spanBack - spanBack;
                if (spanBack == 0 || i2 == 0) {
                    break;
                }
            } else {
                int spanOneBack = spanOneBack(this.spanSet, charSequence, spanBack);
                if (spanOneBack > 0) {
                    if (spanOneBack == spanBack) {
                        return 0;
                    }
                    spanBack -= spanOneBack;
                    this.offsets.shift(spanOneBack);
                    i2 = 0;
                }
            }
            spanBack -= this.offsets.popMinimum(null);
            i2 = 0;
        }
        return spanBack;
    }

    private int spanNot(CharSequence charSequence, int i, OutputInt outputInt) {
        int i2;
        int i3;
        int spanOne;
        String str;
        int length;
        int length2 = charSequence.length();
        int i4 = i;
        int i5 = length2 - i;
        int size = this.strings.size();
        int i6 = 0;
        do {
            if (outputInt == null) {
                i2 = this.spanNotSet.span(charSequence, i4, UnicodeSet.SpanCondition.NOT_CONTAINED);
            } else {
                i2 = this.spanNotSet.spanAndCount(charSequence, i4, UnicodeSet.SpanCondition.NOT_CONTAINED, outputInt);
                int i7 = outputInt.value + i6;
                i6 = i7;
                outputInt.value = i7;
            }
            if (i2 == length2) {
                return length2;
            }
            i3 = length2 - i2;
            spanOne = spanOne(this.spanSet, charSequence, i2, i3);
            if (spanOne > 0) {
                return i2;
            }
            for (int i8 = 0; i8 < size; i8++) {
                if (this.spanLengths[i8] != 255 && (length = (str = this.strings.get(i8)).length()) <= i3 && matches16CPB(charSequence, i2, length2, str, length)) {
                    return i2;
                }
            }
            i4 = i2 - spanOne;
            i6++;
        } while (i3 + spanOne != 0);
        if (outputInt != null) {
            outputInt.value = i6;
        }
        return length2;
    }

    private int spanNotBack(CharSequence charSequence, int i) {
        String str;
        int length;
        int i2 = i;
        int size = this.strings.size();
        do {
            int spanBack = this.spanNotSet.spanBack(charSequence, i2, UnicodeSet.SpanCondition.NOT_CONTAINED);
            if (spanBack == 0) {
                return 0;
            }
            int spanOneBack = spanOneBack(this.spanSet, charSequence, spanBack);
            if (spanOneBack > 0) {
                return spanBack;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.spanLengths[i3] != 255 && (length = (str = this.strings.get(i3)).length()) <= spanBack && matches16CPB(charSequence, spanBack - length, i, str, length)) {
                    return spanBack;
                }
            }
            i2 = spanBack + spanOneBack;
        } while (i2 != 0);
        return 0;
    }

    static short makeSpanLengthByte(int i) {
        if (i < 254) {
            return (short) i;
        }
        return 254;
    }

    private static boolean matches16(CharSequence charSequence, int i, String str, int i2) {
        int i3 = i + i2;
        do {
            i2--;
            if (i2 <= 0) {
                return true;
            }
            i3--;
        } while (charSequence.charAt(i3) == str.charAt(i2));
        return false;
    }

    static boolean matches16CPB(CharSequence charSequence, int i, int i2, String str, int i3) {
        return matches16(charSequence, i, str, i3) && (0 >= i || !Character.isHighSurrogate(charSequence.charAt(i + -1)) || !Character.isLowSurrogate(charSequence.charAt(i))) && (i + i3 >= i2 || !Character.isHighSurrogate(charSequence.charAt((i + i3) + -1)) || !Character.isLowSurrogate(charSequence.charAt(i + i3)));
    }

    static int spanOne(UnicodeSet unicodeSet, CharSequence charSequence, int i, int i2) {
        char charAt = charSequence.charAt(i);
        if (charAt >= 55296 && charAt <= 56319 && i2 >= 2) {
            char charAt2 = charSequence.charAt(i + 1);
            if (UTF16.isTrailSurrogate(charAt2)) {
                return unicodeSet.contains(Character.toCodePoint(charAt, charAt2)) ? 2 : -2;
            }
        }
        return unicodeSet.contains(charAt) ? 1 : -1;
    }

    static int spanOneBack(UnicodeSet unicodeSet, CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i - 1);
        if (charAt >= 56320 && charAt <= 57343 && i >= 2) {
            char charAt2 = charSequence.charAt(i - 2);
            if (UTF16.isLeadSurrogate(charAt2)) {
                return unicodeSet.contains(Character.toCodePoint(charAt2, charAt)) ? 2 : -2;
            }
        }
        return unicodeSet.contains(charAt) ? 1 : -1;
    }

    /* access modifiers changed from: package-private */
    public static final class OffsetList {
        static final /* synthetic */ boolean $assertionsDisabled = (!UnicodeSetStringSpan.class.desiredAssertionStatus());
        private int length;
        private int[] list = new int[16];
        private int start;

        public void setMaxLength(int i) {
            if (i > this.list.length) {
                this.list = new int[i];
            }
            clear();
        }

        public void clear() {
            int length2 = this.list.length;
            while (true) {
                length2--;
                if (length2 > 0) {
                    this.list[length2] = 0;
                } else {
                    this.length = 0;
                    this.start = 0;
                    return;
                }
            }
        }

        public boolean isEmpty() {
            return this.length == 0;
        }

        public void shift(int i) {
            int i2 = this.start + i;
            if (i2 >= this.list.length) {
                i2 -= this.list.length;
            }
            if (this.list[i2] != 0) {
                this.list[i2] = 0;
                this.length--;
            }
            this.start = i2;
        }

        public void addOffset(int i) {
            int i2 = this.start + i;
            if (i2 >= this.list.length) {
                i2 -= this.list.length;
            }
            if ($assertionsDisabled || this.list[i2] == 0) {
                this.list[i2] = 1;
                this.length++;
                return;
            }
            throw new AssertionError();
        }

        public void addOffsetAndCount(int i, int i2) {
            if ($assertionsDisabled || i2 > 0) {
                int i3 = this.start + i;
                if (i3 >= this.list.length) {
                    i3 -= this.list.length;
                }
                if (this.list[i3] == 0) {
                    this.list[i3] = i2;
                    this.length++;
                } else if (i2 < this.list[i3]) {
                    this.list[i3] = i2;
                }
            } else {
                throw new AssertionError();
            }
        }

        public boolean containsOffset(int i) {
            int i2 = this.start + i;
            if (i2 >= this.list.length) {
                i2 -= this.list.length;
            }
            return this.list[i2] != 0;
        }

        public boolean hasCountAtOffset(int i, int i2) {
            int i3 = this.start + i;
            if (i3 >= this.list.length) {
                i3 -= this.list.length;
            }
            int i4 = this.list[i3];
            return i4 != 0 && i4 <= i2;
        }

        public int popMinimum(OutputInt outputInt) {
            int i;
            int i2;
            int i3 = this.start;
            do {
                i3++;
                if (i3 < this.list.length) {
                    i2 = this.list[i3];
                } else {
                    int length2 = this.list.length - this.start;
                    int i4 = 0;
                    while (true) {
                        i = this.list[i4];
                        if (i != 0) {
                            break;
                        }
                        i4++;
                    }
                    this.list[i4] = 0;
                    this.length--;
                    this.start = i4;
                    if (outputInt != null) {
                        outputInt.value = i;
                    }
                    return length2 + i4;
                }
            } while (i2 == 0);
            this.list[i3] = 0;
            this.length--;
            int i5 = i3 - this.start;
            this.start = i3;
            if (outputInt != null) {
                outputInt.value = i2;
            }
            return i5;
        }
    }
}
