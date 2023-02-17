package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
public final class UCharacterName {
    public static final UCharacterName INSTANCE;
    private static final String[] TYPE_NAMES_ = {"unassigned", "uppercase letter", "lowercase letter", "titlecase letter", "modifier letter", "other letter", "non spacing mark", "enclosing mark", "combining spacing mark", "decimal digit number", "letter number", "other number", "space separator", "line separator", "paragraph separator", "control", "format", "private use area", "surrogate", "dash punctuation", "start punctuation", "end punctuation", "connector punctuation", "other punctuation", "math symbol", "currency symbol", "modifier symbol", "other symbol", "initial punctuation", "final punctuation", "noncharacter", "lead surrogate", "trail surrogate"};
    private int[] m_ISOCommentSet_ = new int[8];
    private AlgorithmName[] m_algorithm_;
    public int m_groupcount_ = 0;
    private char[] m_groupinfo_;
    private char[] m_grouplengths_ = new char[33];
    private char[] m_groupoffsets_ = new char[33];
    int m_groupsize_ = 0;
    private byte[] m_groupstring_;
    private int[] m_nameSet_ = new int[8];
    private byte[] m_tokenstring_;
    private char[] m_tokentable_;
    private int[] m_utilIntBuffer_ = new int[2];
    private StringBuffer m_utilStringBuffer_ = new StringBuffer();

    static {
        try {
            INSTANCE = new UCharacterName();
        } catch (IOException e) {
            throw new MissingResourceException("Could not construct UCharacterName. Missing unames.icu", "", "");
        }
    }

    public int getCharFromName(int i, String str) {
        if (i >= 4 || str == null || str.length() == 0) {
            return -1;
        }
        int extendedChar = getExtendedChar(str.toLowerCase(Locale.ENGLISH), i);
        if (extendedChar >= -1) {
            return extendedChar;
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        if (i == 0 || i == 2) {
            int i2 = 0;
            if (this.m_algorithm_ != null) {
                i2 = this.m_algorithm_.length;
            }
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                int i4 = this.m_algorithm_[i3].getChar(upperCase);
                if (i4 >= 0) {
                    return i4;
                }
            }
        }
        if (i != 2) {
            return getGroupChar(upperCase, i);
        }
        int groupChar = getGroupChar(upperCase, 0);
        if (groupChar == -1) {
            return getGroupChar(upperCase, 3);
        }
        return groupChar;
    }

    public int getGroupLengths(int i, char[] cArr, char[] cArr2) {
        char c = 65535;
        int i2 = i * this.m_groupsize_;
        int i3 = UCharacterUtility.toInt(this.m_groupinfo_[i2 + 1], this.m_groupinfo_[i2 + 2]);
        cArr[0] = 0;
        int i4 = 0;
        while (i4 < 32) {
            byte b = this.m_groupstring_[i3];
            for (int i5 = 4; i5 >= 0; i5 -= 4) {
                byte b2 = (byte) ((b >> i5) & 15);
                if (c != 65535 || b2 <= 11) {
                    if (c != 65535) {
                        cArr2[i4] = (char) ((c | b2) + 12);
                    } else {
                        cArr2[i4] = (char) b2;
                    }
                    if (i4 < 32) {
                        cArr[i4 + 1] = (char) (cArr[i4] + cArr2[i4]);
                    }
                    c = 65535;
                    i4++;
                } else {
                    c = (char) ((b2 - 12) << 4);
                }
            }
            i3++;
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public static final class AlgorithmName {
        private char[] m_factor_;
        private byte[] m_factorstring_;
        private String m_prefix_;
        private int m_rangeend_;
        private int m_rangestart_;
        private byte m_type_;
        private int[] m_utilIntBuffer_ = new int[256];
        private StringBuffer m_utilStringBuffer_ = new StringBuffer();
        private byte m_variant_;

        AlgorithmName() {
        }

        /* access modifiers changed from: package-private */
        public boolean setInfo(int i, int i2, byte b, byte b2) {
            if (i < 0 || i > i2 || i2 > 1114111) {
                return false;
            }
            if (b != 0 && b != 1) {
                return false;
            }
            this.m_rangestart_ = i;
            this.m_rangeend_ = i2;
            this.m_type_ = b;
            this.m_variant_ = b2;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean setFactor(char[] cArr) {
            if (cArr.length != this.m_variant_) {
                return false;
            }
            this.m_factor_ = cArr;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean setPrefix(String str) {
            if (str == null || str.length() <= 0) {
                return false;
            }
            this.m_prefix_ = str;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean setFactorString(byte[] bArr) {
            this.m_factorstring_ = bArr;
            return true;
        }

        /* access modifiers changed from: package-private */
        public int getChar(String str) {
            int length = this.m_prefix_.length();
            if (str.length() < length || !this.m_prefix_.equals(str.substring(0, length))) {
                return -1;
            }
            switch (this.m_type_) {
                case 0:
                    try {
                        int parseInt = Integer.parseInt(str.substring(length), 16);
                        if (this.m_rangestart_ > parseInt || parseInt > this.m_rangeend_) {
                            return -1;
                        }
                        return parseInt;
                    } catch (NumberFormatException e) {
                        return -1;
                    }
                case 1:
                    for (int i = this.m_rangestart_; i <= this.m_rangeend_; i++) {
                        int i2 = i - this.m_rangestart_;
                        int[] iArr = this.m_utilIntBuffer_;
                        synchronized (this.m_utilIntBuffer_) {
                            for (int i3 = this.m_variant_ - 1; i3 > 0; i3--) {
                                int i4 = this.m_factor_[i3] & 255;
                                iArr[i3] = i2 % i4;
                                i2 /= i4;
                            }
                            iArr[0] = i2;
                            if (compareFactorString(iArr, this.m_variant_, str, length)) {
                                return i;
                            }
                        }
                    }
                    return -1;
                default:
                    return -1;
            }
        }

        private boolean compareFactorString(int[] iArr, int i, String str, int i2) {
            int length = this.m_factor_.length;
            if (iArr == null || i != length) {
                return false;
            }
            int i3 = 0;
            int i4 = i2;
            int i5 = length - 1;
            for (int i6 = 0; i6 <= i5; i6++) {
                char c = this.m_factor_[i6];
                i3 = UCharacterUtility.skipNullTermByteSubString(this.m_factorstring_, i3, iArr[i6]);
                i4 = UCharacterUtility.compareNullTermByteSubString(str, this.m_factorstring_, i4, i3);
                if (i4 < 0) {
                    return false;
                }
                if (i6 != i5) {
                    i3 = UCharacterUtility.skipNullTermByteSubString(this.m_factorstring_, i3, c - iArr[i6]);
                }
            }
            if (i4 != str.length()) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean setToken(char[] cArr, byte[] bArr) {
        if (cArr == null || bArr == null || cArr.length <= 0 || bArr.length <= 0) {
            return false;
        }
        this.m_tokentable_ = cArr;
        this.m_tokenstring_ = bArr;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean setAlgorithm(AlgorithmName[] algorithmNameArr) {
        if (algorithmNameArr == null || algorithmNameArr.length == 0) {
            return false;
        }
        this.m_algorithm_ = algorithmNameArr;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean setGroupCountSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        this.m_groupcount_ = i;
        this.m_groupsize_ = i2;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean setGroup(char[] cArr, byte[] bArr) {
        if (cArr == null || bArr == null || cArr.length <= 0 || bArr.length <= 0) {
            return false;
        }
        this.m_groupinfo_ = cArr;
        this.m_groupstring_ = bArr;
        return true;
    }

    private UCharacterName() {
        new UCharacterNameReader(ICUBinary.getRequiredData("unames.icu")).read(this);
    }

    private synchronized int getGroupChar(String str, int i) {
        for (int i2 = 0; i2 < this.m_groupcount_; i2++) {
            int groupChar = getGroupChar(getGroupLengths(i2, this.m_groupoffsets_, this.m_grouplengths_), this.m_grouplengths_, str, i);
            if (groupChar != -1) {
                return (this.m_groupinfo_[this.m_groupsize_ * i2] << 5) | groupChar;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x001d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x002e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [char[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [char] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0052 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0043 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getGroupChar(int r14, char[] r15, java.lang.String r16, int r17) {
        /*
            r13 = this;
            r4 = 0
            int r7 = r16.length()
            r10 = 0
        L_0x0006:
            r0 = 32
            if (r10 > r0) goto L_0x00a1
            r8 = 0
            char r6 = r15[r10]
            if (r17 == 0) goto L_0x002e
            r0 = r17
            r1 = 2
            if (r0 == r1) goto L_0x002e
            r0 = r17
            r1 = 4
            if (r0 != r1) goto L_0x001b
            r11 = 2
            goto L_0x001d
        L_0x001b:
            r11 = r17
        L_0x001d:
            r12 = r14
            byte[] r0 = r13.m_groupstring_
            r1 = 59
            int r0 = com.ibm.icu.impl.UCharacterUtility.skipByteSubString(r0, r14, r6, r1)
            int r14 = r14 + r0
            int r0 = r14 - r12
            int r6 = r6 - r0
            int r11 = r11 + -1
            if (r11 > 0) goto L_0x001d
        L_0x002e:
            r9 = 0
        L_0x002f:
            if (r9 >= r6) goto L_0x008d
            r0 = -1
            if (r8 == r0) goto L_0x008d
            if (r8 >= r7) goto L_0x008d
            byte[] r0 = r13.m_groupstring_
            int r1 = r14 + r9
            byte r4 = r0[r1]
            int r9 = r9 + 1
            char[] r0 = r13.m_tokentable_
            int r0 = r0.length
            if (r4 < r0) goto L_0x0052
            r0 = r8
            int r8 = r8 + 1
            r1 = r16
            char r0 = r1.charAt(r0)
            r1 = r4 & 255(0xff, float:3.57E-43)
            if (r0 == r1) goto L_0x002f
            r8 = -1
            goto L_0x002f
        L_0x0052:
            char[] r0 = r13.m_tokentable_
            r1 = r4 & 255(0xff, float:3.57E-43)
            char r5 = r0[r1]
            r0 = 65534(0xfffe, float:9.1833E-41)
            if (r5 != r0) goto L_0x006e
            char[] r0 = r13.m_tokentable_
            int r1 = r4 << 8
            byte[] r2 = r13.m_groupstring_
            int r3 = r14 + r9
            byte r2 = r2[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r1 = r1 | r2
            char r5 = r0[r1]
            int r9 = r9 + 1
        L_0x006e:
            r0 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r0) goto L_0x0083
            r0 = r8
            int r8 = r8 + 1
            r1 = r16
            char r0 = r1.charAt(r0)
            r1 = r4 & 255(0xff, float:3.57E-43)
            if (r0 == r1) goto L_0x002f
            r8 = -1
            goto L_0x002f
        L_0x0083:
            byte[] r0 = r13.m_tokenstring_
            r1 = r16
            int r8 = com.ibm.icu.impl.UCharacterUtility.compareNullTermByteSubString(r1, r0, r8, r5)
            goto L_0x002f
        L_0x008d:
            if (r7 != r8) goto L_0x009c
            if (r9 == r6) goto L_0x009b
            byte[] r0 = r13.m_groupstring_
            int r1 = r14 + r9
            byte r0 = r0[r1]
            r1 = 59
            if (r0 != r1) goto L_0x009c
        L_0x009b:
            return r10
        L_0x009c:
            int r14 = r14 + r6
            int r10 = r10 + 1
            goto L_0x0006
        L_0x00a1:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.UCharacterName.getGroupChar(int, char[], java.lang.String, int):int");
    }

    private static int getType(int i) {
        if (UCharacterUtility.isNonCharacter(i)) {
            return 30;
        }
        int type = UCharacter.getType(i);
        if (type != 18) {
            return type;
        }
        if (i <= 56319) {
            return 31;
        }
        return 32;
    }

    private static int getExtendedChar(String str, int i) {
        int lastIndexOf;
        if (str.charAt(0) != '<') {
            return -2;
        }
        if (i != 2) {
            return -1;
        }
        int length = str.length() - 1;
        if (str.charAt(length) != '>' || (lastIndexOf = str.lastIndexOf(45)) < 0) {
            return -1;
        }
        int i2 = lastIndexOf + 1;
        try {
            int parseInt = Integer.parseInt(str.substring(i2, length), 16);
            String substring = str.substring(1, i2 - 1);
            int length2 = TYPE_NAMES_.length;
            for (int i3 = 0; i3 < length2; i3++) {
                if (substring.compareTo(TYPE_NAMES_[i3]) == 0) {
                    if (getType(parseInt) == i3) {
                        return parseInt;
                    } else {
                        return -1;
                    }
                }
            }
            return -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
