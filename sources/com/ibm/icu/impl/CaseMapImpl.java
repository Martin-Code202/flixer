package com.ibm.icu.impl;

import com.ibm.icu.impl.UCaseProps;
import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.Edits;
import com.ibm.icu.util.ICUUncheckedIOException;
import java.io.IOException;
import org.linphone.core.Privacy;
public final class CaseMapImpl {
    static final /* synthetic */ boolean $assertionsDisabled = (!CaseMapImpl.class.desiredAssertionStatus());

    public static final class StringContextIterator implements UCaseProps.ContextIterator {
        protected int cpLimit = 0;
        protected int cpStart = 0;
        protected int dir = 0;
        protected int index = 0;
        protected int limit;
        protected CharSequence s;

        public StringContextIterator(CharSequence charSequence) {
            this.s = charSequence;
            this.limit = charSequence.length();
        }

        public void setLimit(int i) {
            if (0 > i || i > this.s.length()) {
                this.limit = this.s.length();
            } else {
                this.limit = i;
            }
        }

        public void moveToLimit() {
            int i = this.limit;
            this.cpLimit = i;
            this.cpStart = i;
        }

        public int nextCaseMapCP() {
            this.cpStart = this.cpLimit;
            if (this.cpLimit >= this.limit) {
                return -1;
            }
            int codePointAt = Character.codePointAt(this.s, this.cpLimit);
            this.cpLimit += Character.charCount(codePointAt);
            return codePointAt;
        }

        public int getCPStart() {
            return this.cpStart;
        }

        public int getCPLimit() {
            return this.cpLimit;
        }

        public int getCPLength() {
            return this.cpLimit - this.cpStart;
        }

        @Override // com.ibm.icu.impl.UCaseProps.ContextIterator
        public void reset(int i) {
            if (i > 0) {
                this.dir = 1;
                this.index = this.cpLimit;
            } else if (i < 0) {
                this.dir = -1;
                this.index = this.cpStart;
            } else {
                this.dir = 0;
                this.index = 0;
            }
        }

        @Override // com.ibm.icu.impl.UCaseProps.ContextIterator
        public int next() {
            if (this.dir > 0 && this.index < this.s.length()) {
                int codePointAt = Character.codePointAt(this.s, this.index);
                this.index += Character.charCount(codePointAt);
                return codePointAt;
            } else if (this.dir >= 0 || this.index <= 0) {
                return -1;
            } else {
                int codePointBefore = Character.codePointBefore(this.s, this.index);
                this.index -= Character.charCount(codePointBefore);
                return codePointBefore;
            }
        }
    }

    private static int appendCodePoint(Appendable appendable, int i) {
        if (i <= 65535) {
            appendable.append((char) i);
            return 1;
        }
        appendable.append((char) ((i >> 10) + 55232));
        appendable.append((char) ((i & 1023) + 56320));
        return 2;
    }

    /* access modifiers changed from: private */
    public static void appendResult(int i, Appendable appendable, int i2, int i3, Edits edits) {
        if (i < 0) {
            if (edits != null) {
                edits.addUnchanged(i2);
                if ((i3 & 16384) != 0) {
                    return;
                }
            }
            appendCodePoint(appendable, i ^ -1);
        } else if (i > 31) {
            int appendCodePoint = appendCodePoint(appendable, i);
            if (edits != null) {
                edits.addReplace(i2, appendCodePoint);
            }
        } else if (edits != null) {
            edits.addReplace(i2, i);
        }
    }

    private static final void appendUnchanged(CharSequence charSequence, int i, int i2, Appendable appendable, int i3, Edits edits) {
        if (i2 > 0) {
            if (edits != null) {
                edits.addUnchanged(i2);
                if ((i3 & 16384) != 0) {
                    return;
                }
            }
            appendable.append(charSequence, i, i + i2);
        }
    }

    private static void internalToLower(int i, int i2, StringContextIterator stringContextIterator, Appendable appendable, Edits edits) {
        while (true) {
            int nextCaseMapCP = stringContextIterator.nextCaseMapCP();
            if (nextCaseMapCP >= 0) {
                appendResult(UCaseProps.INSTANCE.toFullLower(nextCaseMapCP, stringContextIterator, appendable, i), appendable, stringContextIterator.getCPLength(), i2, edits);
            } else {
                return;
            }
        }
    }

    public static <A extends Appendable> A toLower(int i, int i2, CharSequence charSequence, A a, Edits edits) {
        if (edits != null) {
            try {
                edits.reset();
            } catch (IOException e) {
                throw new ICUUncheckedIOException(e);
            }
        }
        internalToLower(i, i2, new StringContextIterator(charSequence), a, edits);
        return a;
    }

    public static <A extends Appendable> A toUpper(int i, int i2, CharSequence charSequence, A a, Edits edits) {
        if (edits != null) {
            try {
                edits.reset();
            } catch (IOException e) {
                throw new ICUUncheckedIOException(e);
            }
        }
        if (i == 4) {
            return (A) GreekUpper.toUpper(i2, charSequence, a, edits);
        }
        StringContextIterator stringContextIterator = new StringContextIterator(charSequence);
        while (true) {
            int nextCaseMapCP = stringContextIterator.nextCaseMapCP();
            if (nextCaseMapCP < 0) {
                return a;
            }
            appendResult(UCaseProps.INSTANCE.toFullUpper(nextCaseMapCP, stringContextIterator, a, i), a, stringContextIterator.getCPLength(), i2, edits);
        }
    }

    public static <A extends Appendable> A toTitle(int i, int i2, BreakIterator breakIterator, CharSequence charSequence, A a, Edits edits) {
        int i3;
        char charAt;
        if (edits != null) {
            try {
                edits.reset();
            } catch (IOException e) {
                throw new ICUUncheckedIOException(e);
            }
        }
        StringContextIterator stringContextIterator = new StringContextIterator(charSequence);
        int length = charSequence.length();
        boolean z = true;
        for (int i4 = 0; i4 < length; i4 = i3) {
            if (z) {
                z = false;
                i3 = breakIterator.first();
            } else {
                i3 = breakIterator.next();
            }
            if (i3 == -1 || i3 > length) {
                i3 = length;
            }
            if (i4 < i3) {
                int i5 = i4;
                stringContextIterator.setLimit(i3);
                int nextCaseMapCP = stringContextIterator.nextCaseMapCP();
                if ((i2 & 512) == 0 && 0 == UCaseProps.INSTANCE.getType(nextCaseMapCP)) {
                    while (true) {
                        int nextCaseMapCP2 = stringContextIterator.nextCaseMapCP();
                        nextCaseMapCP = nextCaseMapCP2;
                        if (nextCaseMapCP2 < 0 || 0 != UCaseProps.INSTANCE.getType(nextCaseMapCP)) {
                            break;
                        }
                    }
                    i5 = stringContextIterator.getCPStart();
                    appendUnchanged(charSequence, i4, i5 - i4, a, i2, edits);
                }
                if (i5 < i3) {
                    int cPLimit = stringContextIterator.getCPLimit();
                    appendResult(UCaseProps.INSTANCE.toFullTitle(nextCaseMapCP, stringContextIterator, a, i), a, stringContextIterator.getCPLength(), i2, edits);
                    if (i5 + 1 < i3 && i == 5 && ((charAt = charSequence.charAt(i5)) == 'i' || charAt == 'I')) {
                        char charAt2 = charSequence.charAt(i5 + 1);
                        if (charAt2 == 'j') {
                            a.append('J');
                            if (edits != null) {
                                edits.addReplace(1, 1);
                            }
                            int nextCaseMapCP3 = stringContextIterator.nextCaseMapCP();
                            cPLimit++;
                            if (!$assertionsDisabled && nextCaseMapCP3 != charAt2) {
                                throw new AssertionError();
                            } else if (!$assertionsDisabled && cPLimit != stringContextIterator.getCPLimit()) {
                                throw new AssertionError();
                            }
                        } else if (charAt2 == 'J') {
                            appendUnchanged(charSequence, i5 + 1, 1, a, i2, edits);
                            int nextCaseMapCP4 = stringContextIterator.nextCaseMapCP();
                            cPLimit++;
                            if (!$assertionsDisabled && nextCaseMapCP4 != charAt2) {
                                throw new AssertionError();
                            } else if (!$assertionsDisabled && cPLimit != stringContextIterator.getCPLimit()) {
                                throw new AssertionError();
                            }
                        }
                    }
                    if (cPLimit < i3) {
                        if ((i2 & 256) == 0) {
                            internalToLower(i, i2, stringContextIterator, a, edits);
                        } else {
                            appendUnchanged(charSequence, cPLimit, i3 - cPLimit, a, i2, edits);
                            stringContextIterator.moveToLimit();
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return a;
    }

    public static <A extends Appendable> A fold(int i, CharSequence charSequence, A a, Edits edits) {
        if (edits != null) {
            try {
                edits.reset();
            } catch (IOException e) {
                throw new ICUUncheckedIOException(e);
            }
        }
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = Character.codePointAt(charSequence, i2);
            int charCount = Character.charCount(codePointAt);
            i2 += charCount;
            appendResult(UCaseProps.INSTANCE.toFullFolding(codePointAt, a, i), a, charCount, i, edits);
        }
        return a;
    }

    static final class GreekUpper {
        private static final char[] data0370 = {880, 880, 882, 882, 0, 0, 886, 886, 0, 0, 890, 1021, 1022, 1023, 0, 895, 0, 0, 0, 0, 0, 0, 21393, 0, 21397, 21399, 21401, 0, 21407, 0, 21413, 21417, 54169, 5009, 914, 915, 916, 5013, 918, 5015, 920, 5017, 922, 923, 924, 925, 926, 5023, 928, 929, 0, 931, 932, 5029, 934, 935, 936, 5033, 37785, 37797, 21393, 21397, 21399, 21401, 54181, 5009, 914, 915, 916, 5013, 918, 5015, 920, 5017, 922, 923, 924, 925, 926, 5023, 928, 929, 931, 931, 932, 5029, 934, 935, 936, 5033, 37785, 37797, 21407, 21413, 21417, 975, 914, 920, 978, 17362, 33746, 934, 928, 975, 984, 984, 986, 986, 988, 988, 990, 990, 992, 992, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 922, 929, 1017, 895, 1012, 5013, 0, 1015, 1015, 1017, 1018, 1018, 1020, 1021, 1022, 1023};
        private static final char[] data1F00 = {5009, 5009, 21393, 21393, 21393, 21393, 21393, 21393, 5009, 5009, 21393, 21393, 21393, 21393, 21393, 21393, 5013, 5013, 21397, 21397, 21397, 21397, 0, 0, 5013, 5013, 21397, 21397, 21397, 21397, 0, 0, 5015, 5015, 21399, 21399, 21399, 21399, 21399, 21399, 5015, 5015, 21399, 21399, 21399, 21399, 21399, 21399, 5017, 5017, 21401, 21401, 21401, 21401, 21401, 21401, 5017, 5017, 21401, 21401, 21401, 21401, 21401, 21401, 5023, 5023, 21407, 21407, 21407, 21407, 0, 0, 5023, 5023, 21407, 21407, 21407, 21407, 0, 0, 5029, 5029, 21413, 21413, 21413, 21413, 21413, 21413, 0, 5029, 0, 21413, 0, 21413, 0, 21413, 5033, 5033, 21417, 21417, 21417, 21417, 21417, 21417, 5033, 5033, 21417, 21417, 21417, 21417, 21417, 21417, 21393, 21393, 21397, 21397, 21399, 21399, 21401, 21401, 21407, 21407, 21413, 21413, 21417, 21417, 0, 0, 13201, 13201, 29585, 29585, 29585, 29585, 29585, 29585, 13201, 13201, 29585, 29585, 29585, 29585, 29585, 29585, 13207, 13207, 29591, 29591, 29591, 29591, 29591, 29591, 13207, 13207, 29591, 29591, 29591, 29591, 29591, 29591, 13225, 13225, 29609, 29609, 29609, 29609, 29609, 29609, 13225, 13225, 29609, 29609, 29609, 29609, 29609, 29609, 5009, 5009, 29585, 13201, 29585, 0, 21393, 29585, 5009, 5009, 21393, 21393, 13201, 0, 5017, 0, 0, 0, 29591, 13207, 29591, 0, 21399, 29591, 21397, 21397, 21399, 21399, 13207, 0, 0, 0, 5017, 5017, 54169, 54169, 0, 0, 21401, 54169, 5017, 5017, 21401, 21401, 0, 0, 0, 0, 5029, 5029, 54181, 54181, 929, 929, 21413, 54181, 5029, 5029, 21413, 21413, 929, 0, 0, 0, 0, 0, 29609, 13225, 29609, 0, 21417, 29609, 21407, 21407, 21417, 21417, 13225, 0, 0, 0};

        private static final int getLetterData(int i) {
            if (i < 880 || 8486 < i) {
                return 0;
            }
            if (1023 < i && i < 7936) {
                return 0;
            }
            if (i <= 1023) {
                return data0370[i - 880];
            }
            if (i <= 8191) {
                return data1F00[i - 7936];
            }
            if (i == 8486) {
                return 5033;
            }
            return 0;
        }

        private static final int getDiacriticData(int i) {
            switch (i) {
                case 768:
                case 769:
                case 770:
                case 771:
                case 785:
                case 834:
                    return 16384;
                case 772:
                case 774:
                case 787:
                case 788:
                case 835:
                    return 131072;
                case 776:
                    return 65536;
                case 836:
                    return 81920;
                case 837:
                    return 8192;
                default:
                    return 0;
            }
        }

        private static boolean isFollowedByCasedLetter(CharSequence charSequence, int i) {
            while (i < charSequence.length()) {
                int typeOrIgnorable = UCaseProps.INSTANCE.getTypeOrIgnorable(Character.codePointAt(charSequence, i));
                if ((typeOrIgnorable & 4) == 0) {
                    if (typeOrIgnorable != 0) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public static <A extends Appendable> A toUpper(int i, CharSequence charSequence, A a, Edits edits) {
            boolean z;
            int diacriticData;
            boolean z2 = false;
            int i2 = 0;
            while (i2 < charSequence.length()) {
                int codePointAt = Character.codePointAt(charSequence, i2);
                int charCount = i2 + Character.charCount(codePointAt);
                boolean z3 = false;
                int typeOrIgnorable = UCaseProps.INSTANCE.getTypeOrIgnorable(codePointAt);
                if ((typeOrIgnorable & 4) != 0) {
                    z3 = (z2 & true) | false;
                } else if (typeOrIgnorable != 0) {
                    z3 = true;
                }
                int letterData = getLetterData(codePointAt);
                if (letterData > 0) {
                    int i3 = letterData & 1023;
                    if ((letterData & 4096) != 0 && (z2 && true) && (i3 == 921 || i3 == 933)) {
                        letterData |= Privacy.DEFAULT;
                    }
                    int i4 = 0;
                    if ((letterData & 8192) != 0) {
                        i4 = 1;
                    }
                    while (charCount < charSequence.length() && (diacriticData = getDiacriticData(charSequence.charAt(charCount))) != 0) {
                        letterData |= diacriticData;
                        if ((diacriticData & 8192) != 0) {
                            i4++;
                        }
                        charCount++;
                    }
                    if ((53248 & letterData) == 20480) {
                        z3 |= true;
                    }
                    boolean z4 = false;
                    if (i3 != 919 || (letterData & 16384) == 0 || i4 != 0 || (z2 && true) || isFollowedByCasedLetter(charSequence, charCount)) {
                        if ((32768 & letterData) != 0) {
                            if (i3 == 921) {
                                i3 = 938;
                                letterData &= -98305;
                            } else if (i3 == 933) {
                                i3 = 939;
                                letterData &= -98305;
                            }
                        }
                    } else if (i2 == charCount) {
                        i3 = 905;
                    } else {
                        z4 = true;
                    }
                    if (edits == null) {
                        z = true;
                    } else {
                        boolean z5 = charSequence.charAt(i2) != i3 || i4 > 0;
                        int i5 = i2 + 1;
                        if ((98304 & letterData) != 0) {
                            z5 |= i5 >= charCount || charSequence.charAt(i5) != 776;
                            i5++;
                        }
                        if (z4) {
                            z5 |= i5 >= charCount || charSequence.charAt(i5) != 769;
                            i5++;
                        }
                        int i6 = charCount - i2;
                        int i7 = (i5 - i2) + i4;
                        z = z5 | (i6 != i7);
                        if (!z) {
                            if (edits != null) {
                                edits.addUnchanged(i6);
                            }
                            z = (i & 16384) == 0;
                        } else if (edits != null) {
                            edits.addReplace(i6, i7);
                        }
                    }
                    if (z) {
                        a.append((char) i3);
                        if ((98304 & letterData) != 0) {
                            a.append(776);
                        }
                        if (z4) {
                            a.append(769);
                        }
                        while (i4 > 0) {
                            a.append(921);
                            i4--;
                        }
                    }
                } else {
                    CaseMapImpl.appendResult(UCaseProps.INSTANCE.toFullUpper(codePointAt, null, a, 4), a, charCount - i2, i, edits);
                }
                i2 = charCount;
                z2 = z3;
            }
            return a;
        }
    }
}
