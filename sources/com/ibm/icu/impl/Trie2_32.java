package com.ibm.icu.impl;

import java.nio.ByteBuffer;
public class Trie2_32 extends Trie2 {
    Trie2_32() {
    }

    public static Trie2_32 createFromSerialized(ByteBuffer byteBuffer) {
        return (Trie2_32) Trie2.createFromSerialized(byteBuffer);
    }

    @Override // com.ibm.icu.impl.Trie2
    public final int get(int i) {
        if (i >= 0) {
            if (i < 55296 || (i > 56319 && i <= 65535)) {
                return this.data32[(this.index[i >> 5] << 2) + (i & 31)];
            } else if (i <= 65535) {
                return this.data32[(this.index[((i - 55296) >> 5) + 2048] << 2) + (i & 31)];
            } else if (i < this.highStart) {
                return this.data32[(this.index[this.index[(i >> 11) + 2080] + ((i >> 5) & 63)] << 2) + (i & 31)];
            } else if (i <= 1114111) {
                return this.data32[this.highValueIndex];
            }
        }
        return this.errorValue;
    }

    @Override // com.ibm.icu.impl.Trie2
    public int getFromU16SingleLead(char c) {
        return this.data32[(this.index[c >> 5] << 2) + (c & 31)];
    }

    public int getSerializedLength() {
        return (this.header.indexLength * 2) + 16 + (this.dataLength * 4);
    }

    /* access modifiers changed from: package-private */
    @Override // com.ibm.icu.impl.Trie2
    public int rangeEnd(int i, int i2, int i3) {
        char c;
        int i4;
        int i5 = i;
        loop0:
        while (true) {
            if (i5 >= i2) {
                break;
            }
            if (i5 < 55296 || (i5 > 56319 && i5 <= 65535)) {
                c = 0;
                i4 = this.index[i5 >> 5] << 2;
            } else if (i5 < 65535) {
                c = 2048;
                i4 = this.index[((i5 - 55296) >> 5) + 2048] << 2;
            } else if (i5 < this.highStart) {
                c = this.index[(i5 >> 11) + 2080];
                i4 = this.index[((i5 >> 5) & 63) + c] << 2;
            } else if (i3 == this.data32[this.highValueIndex]) {
                i5 = i2;
            }
            if (c == this.index2NullOffset) {
                if (i3 != this.initialValue) {
                    break;
                }
                i5 += 2048;
            } else if (i4 != this.dataNullOffset) {
                int i6 = i4 + (i5 & 31);
                int i7 = i4 + 32;
                for (int i8 = i6; i8 < i7; i8++) {
                    if (this.data32[i8] != i3) {
                        i5 += i8 - i6;
                        break loop0;
                    }
                }
                i5 += i7 - i6;
            } else if (i3 != this.initialValue) {
                break;
            } else {
                i5 += 32;
            }
        }
        if (i5 > i2) {
            i5 = i2;
        }
        return i5 - 1;
    }
}
