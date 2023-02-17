package com.ibm.icu.impl;

import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.OutputInt;
public final class BMPSet {
    static final /* synthetic */ boolean $assertionsDisabled = (!BMPSet.class.desiredAssertionStatus());
    public static int U16_SURROGATE_OFFSET = 56613888;
    private int[] bmpBlockBits = new int[64];
    private boolean[] latin1Contains = new boolean[256];
    private final int[] list;
    private int[] list4kStarts = new int[18];
    private final int listLength;
    private int[] table7FF = new int[64];

    public BMPSet(int[] iArr, int i) {
        this.list = iArr;
        this.listLength = i;
        this.list4kStarts[0] = findCodePoint(2048, 0, this.listLength - 1);
        for (int i2 = 1; i2 <= 16; i2++) {
            this.list4kStarts[i2] = findCodePoint(i2 << 12, this.list4kStarts[i2 - 1], this.listLength - 1);
        }
        this.list4kStarts[17] = this.listLength - 1;
        initBits();
    }

    public boolean contains(int i) {
        if (i <= 255) {
            return this.latin1Contains[i];
        }
        if (i <= 2047) {
            return (this.table7FF[i & 63] & (1 << (i >> 6))) != 0;
        }
        if (i < 55296 || (i >= 57344 && i <= 65535)) {
            int i2 = i >> 12;
            int i3 = (this.bmpBlockBits[(i >> 6) & 63] >> i2) & 65537;
            if (i3 <= 1) {
                return 0 != i3;
            }
            return containsSlow(i, this.list4kStarts[i2], this.list4kStarts[i2 + 1]);
        } else if (i <= 1114111) {
            return containsSlow(i, this.list4kStarts[13], this.list4kStarts[17]);
        } else {
            return false;
        }
    }

    public final int span(CharSequence charSequence, int i, UnicodeSet.SpanCondition spanCondition, OutputInt outputInt) {
        char charAt;
        char charAt2;
        int i2 = i;
        int length = charSequence.length();
        int i3 = 0;
        if (UnicodeSet.SpanCondition.NOT_CONTAINED != spanCondition) {
            while (i2 < length) {
                char charAt3 = charSequence.charAt(i2);
                if (charAt3 <= 255) {
                    if (!this.latin1Contains[charAt3]) {
                        break;
                    }
                } else if (charAt3 <= 2047) {
                    if ((this.table7FF[charAt3 & '?'] & (1 << (charAt3 >> 6))) == 0) {
                        break;
                    }
                } else if (charAt3 < 55296 || charAt3 >= 56320 || i2 + 1 == length || (charAt2 = charSequence.charAt(i2 + 1)) < 56320 || charAt2 >= 57344) {
                    int i4 = charAt3 >> '\f';
                    int i5 = (this.bmpBlockBits[(charAt3 >> 6) & 63] >> i4) & 65537;
                    if (i5 <= 1) {
                        if (i5 == 0) {
                            break;
                        }
                    } else if (!containsSlow(charAt3, this.list4kStarts[i4], this.list4kStarts[i4 + 1])) {
                        break;
                    }
                } else if (!containsSlow(Character.toCodePoint(charAt3, charAt2), this.list4kStarts[16], this.list4kStarts[17])) {
                    break;
                } else {
                    i3++;
                    i2++;
                }
                i2++;
            }
        } else {
            while (i2 < length) {
                char charAt4 = charSequence.charAt(i2);
                if (charAt4 <= 255) {
                    if (this.latin1Contains[charAt4]) {
                        break;
                    }
                } else if (charAt4 <= 2047) {
                    if ((this.table7FF[charAt4 & '?'] & (1 << (charAt4 >> 6))) != 0) {
                        break;
                    }
                } else if (charAt4 < 55296 || charAt4 >= 56320 || i2 + 1 == length || (charAt = charSequence.charAt(i2 + 1)) < 56320 || charAt >= 57344) {
                    int i6 = charAt4 >> '\f';
                    int i7 = (this.bmpBlockBits[(charAt4 >> 6) & 63] >> i6) & 65537;
                    if (i7 <= 1) {
                        if (i7 != 0) {
                            break;
                        }
                    } else if (containsSlow(charAt4, this.list4kStarts[i6], this.list4kStarts[i6 + 1])) {
                        break;
                    }
                } else if (containsSlow(Character.toCodePoint(charAt4, charAt), this.list4kStarts[16], this.list4kStarts[17])) {
                    break;
                } else {
                    i3++;
                    i2++;
                }
                i2++;
            }
        }
        if (outputInt != null) {
            outputInt.value = (i2 - i) - i3;
        }
        return i2;
    }

    public final int spanBack(CharSequence charSequence, int i, UnicodeSet.SpanCondition spanCondition) {
        char charAt;
        char charAt2;
        if (UnicodeSet.SpanCondition.NOT_CONTAINED != spanCondition) {
            do {
                i--;
                char charAt3 = charSequence.charAt(i);
                if (charAt3 <= 255) {
                    if (!this.latin1Contains[charAt3]) {
                    }
                } else if (charAt3 <= 2047) {
                    if ((this.table7FF[charAt3 & '?'] & (1 << (charAt3 >> 6))) == 0) {
                    }
                } else if (charAt3 < 55296 || charAt3 < 56320 || 0 == i || (charAt2 = charSequence.charAt(i - 1)) < 55296 || charAt2 >= 56320) {
                    int i2 = charAt3 >> '\f';
                    int i3 = (this.bmpBlockBits[(charAt3 >> 6) & 63] >> i2) & 65537;
                    if (i3 <= 1) {
                        if (i3 == 0) {
                        }
                    } else if (!containsSlow(charAt3, this.list4kStarts[i2], this.list4kStarts[i2 + 1])) {
                    }
                } else if (containsSlow(Character.toCodePoint(charAt2, charAt3), this.list4kStarts[16], this.list4kStarts[17])) {
                    i--;
                }
            } while (0 != i);
            return 0;
        }
        do {
            i--;
            char charAt4 = charSequence.charAt(i);
            if (charAt4 <= 255) {
                if (this.latin1Contains[charAt4]) {
                }
            } else if (charAt4 <= 2047) {
                if ((this.table7FF[charAt4 & '?'] & (1 << (charAt4 >> 6))) != 0) {
                }
            } else if (charAt4 < 55296 || charAt4 < 56320 || 0 == i || (charAt = charSequence.charAt(i - 1)) < 55296 || charAt >= 56320) {
                int i4 = charAt4 >> '\f';
                int i5 = (this.bmpBlockBits[(charAt4 >> 6) & 63] >> i4) & 65537;
                if (i5 <= 1) {
                    if (i5 != 0) {
                    }
                } else if (containsSlow(charAt4, this.list4kStarts[i4], this.list4kStarts[i4 + 1])) {
                }
            } else if (!containsSlow(Character.toCodePoint(charAt, charAt4), this.list4kStarts[16], this.list4kStarts[17])) {
                i--;
            }
        } while (0 != i);
        return 0;
        return i + 1;
    }

    private static void set32x64Bits(int[] iArr, int i, int i2) {
        if ($assertionsDisabled || 64 == iArr.length) {
            int i3 = i >> 6;
            int i4 = i & 63;
            int i5 = 1 << i3;
            if (i + 1 == i2) {
                iArr[i4] = iArr[i4] | i5;
                return;
            }
            int i6 = i2 >> 6;
            int i7 = i2 & 63;
            if (i3 == i6) {
                while (i4 < i7) {
                    i4++;
                    iArr[i4] = iArr[i4] | i5;
                }
                return;
            }
            if (i4 > 0) {
                do {
                    i4++;
                    iArr[i4] = iArr[i4] | i5;
                } while (i4 < 64);
                i3++;
            }
            if (i3 < i6) {
                int i8 = ((1 << i3) - 1) ^ -1;
                if (i6 < 32) {
                    i8 &= (1 << i6) - 1;
                }
                for (int i9 = 0; i9 < 64; i9++) {
                    iArr[i9] = iArr[i9] | i8;
                }
            }
            int i10 = 1 << i6;
            for (int i11 = 0; i11 < i7; i11++) {
                iArr[i11] = iArr[i11] | i10;
            }
            return;
        }
        throw new AssertionError();
    }

    private void initBits() {
        int i;
        int i2;
        int i3 = 0;
        do {
            i3++;
            i = this.list[i3];
            if (i3 < this.listLength) {
                i3++;
                i2 = this.list[i3];
            } else {
                i2 = 1114112;
            }
            if (i < 256) {
                do {
                    i++;
                    this.latin1Contains[i] = true;
                    if (i >= i2) {
                        break;
                    }
                } while (i < 256);
            } else {
                break;
            }
        } while (i2 <= 256);
        while (true) {
            if (i >= 2048) {
                break;
            }
            set32x64Bits(this.table7FF, i, i2 <= 2048 ? i2 : 2048);
            if (i2 > 2048) {
                i = 2048;
                break;
            }
            i3++;
            i = this.list[i3];
            if (i3 < this.listLength) {
                i3++;
                i2 = this.list[i3];
            } else {
                i2 = 1114112;
            }
        }
        int i4 = 2048;
        while (i < 65536) {
            if (i2 > 65536) {
                i2 = 65536;
            }
            if (i < i4) {
                i = i4;
            }
            if (i < i2) {
                if (0 != (i & 63)) {
                    int i5 = i >> 6;
                    int[] iArr = this.bmpBlockBits;
                    int i6 = i5 & 63;
                    iArr[i6] = iArr[i6] | (65537 << (i5 >> 6));
                    i = (i5 + 1) << 6;
                    i4 = i;
                }
                if (i < i2) {
                    if (i < (i2 & -64)) {
                        set32x64Bits(this.bmpBlockBits, i >> 6, i2 >> 6);
                    }
                    if (0 != (i2 & 63)) {
                        int i7 = i2 >> 6;
                        int[] iArr2 = this.bmpBlockBits;
                        int i8 = i7 & 63;
                        iArr2[i8] = iArr2[i8] | (65537 << (i7 >> 6));
                        i2 = (i7 + 1) << 6;
                        i4 = i2;
                    }
                }
            }
            if (i2 != 65536) {
                i3++;
                i = this.list[i3];
                if (i3 < this.listLength) {
                    i3++;
                    i2 = this.list[i3];
                } else {
                    i2 = 1114112;
                }
            } else {
                return;
            }
        }
    }

    private int findCodePoint(int i, int i2, int i3) {
        if (i < this.list[i2]) {
            return i2;
        }
        if (i2 >= i3 || i >= this.list[i3 - 1]) {
            return i3;
        }
        while (true) {
            int i4 = (i2 + i3) >>> 1;
            if (i4 == i2) {
                return i3;
            }
            if (i < this.list[i4]) {
                i3 = i4;
            } else {
                i2 = i4;
            }
        }
    }

    private final boolean containsSlow(int i, int i2, int i3) {
        return 0 != (findCodePoint(i, i2, i3) & 1);
    }
}
