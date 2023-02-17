package com.ibm.icu.impl;

import com.ibm.icu.impl.Trie2;
import java.util.Iterator;
public class Trie2Writable extends Trie2 {
    static final /* synthetic */ boolean $assertionsDisabled = (!Trie2Writable.class.desiredAssertionStatus());
    private boolean UTRIE2_DEBUG;
    private int[] data;
    private int dataCapacity;
    private int firstFreeBlock;
    private int[] index1;
    private int[] index2;
    private int index2Length;
    private int index2NullOffset;
    private boolean isCompacted;
    private int[] map;

    public Trie2Writable(int i, int i2) {
        this.index1 = new int[544];
        this.index2 = new int[35488];
        this.map = new int[34852];
        this.UTRIE2_DEBUG = false;
        init(i, i2);
    }

    private void init(int i, int i2) {
        this.initialValue = i;
        this.errorValue = i2;
        this.highStart = 1114112;
        this.data = new int[16384];
        this.dataCapacity = 16384;
        this.initialValue = i;
        this.errorValue = i2;
        this.highStart = 1114112;
        this.firstFreeBlock = 0;
        this.isCompacted = false;
        int i3 = 0;
        while (i3 < 128) {
            this.data[i3] = this.initialValue;
            i3++;
        }
        while (i3 < 192) {
            this.data[i3] = this.errorValue;
            i3++;
        }
        for (int i4 = 192; i4 < 256; i4++) {
            this.data[i4] = this.initialValue;
        }
        this.dataNullOffset = 192;
        this.dataLength = 256;
        int i5 = 0;
        int i6 = 0;
        while (i6 < 128) {
            this.index2[i5] = i6;
            this.map[i5] = 1;
            i5++;
            i6 += 32;
        }
        while (i6 < 192) {
            this.map[i5] = 0;
            i5++;
            i6 += 32;
        }
        int i7 = i5 + 1;
        this.map[6] = 34845;
        while (true) {
            i6 += 32;
            if (i6 >= 256) {
                break;
            }
            this.map[i7] = 0;
            i7++;
        }
        for (int i8 = 4; i8 < 2080; i8++) {
            this.index2[i8] = 192;
        }
        for (int i9 = 0; i9 < 576; i9++) {
            this.index2[i9 + 2080] = -1;
        }
        for (int i10 = 0; i10 < 64; i10++) {
            this.index2[i10 + 2656] = 192;
        }
        this.index2NullOffset = 2656;
        this.index2Length = 2720;
        int i11 = 0;
        int i12 = 0;
        while (i11 < 32) {
            this.index1[i11] = i12;
            i11++;
            i12 += 64;
        }
        while (i11 < 544) {
            this.index1[i11] = 2656;
            i11++;
        }
        for (int i13 = 128; i13 < 2048; i13 += 32) {
            set(i13, this.initialValue);
        }
    }

    public Trie2Writable(Trie2 trie2) {
        this.index1 = new int[544];
        this.index2 = new int[35488];
        this.map = new int[34852];
        this.UTRIE2_DEBUG = false;
        init(trie2.initialValue, trie2.errorValue);
        Iterator<Trie2.Range> it = trie2.iterator();
        while (it.hasNext()) {
            setRange(it.next(), true);
        }
    }

    private boolean isInNullBlock(int i, boolean z) {
        int i2;
        if (!Character.isHighSurrogate((char) i) || !z) {
            i2 = this.index1[i >> 11] + ((i >> 5) & 63);
        } else {
            i2 = (i >> 5) + 320;
        }
        return this.index2[i2] == this.dataNullOffset;
    }

    private int allocIndex2Block() {
        int i = this.index2Length;
        int i2 = i + 64;
        if (i2 > this.index2.length) {
            throw new IllegalStateException("Internal error in Trie2 creation.");
        }
        this.index2Length = i2;
        System.arraycopy(this.index2, this.index2NullOffset, this.index2, i, 64);
        return i;
    }

    private int getIndex2Block(int i, boolean z) {
        if (i >= 55296 && i < 56320 && z) {
            return 2048;
        }
        int i2 = i >> 11;
        int i3 = this.index1[i2];
        if (i3 != this.index2NullOffset) {
            return i3;
        }
        int allocIndex2Block = allocIndex2Block();
        this.index1[i2] = allocIndex2Block;
        return allocIndex2Block;
    }

    private int allocDataBlock(int i) {
        int i2;
        int i3;
        if (this.firstFreeBlock != 0) {
            i2 = this.firstFreeBlock;
            this.firstFreeBlock = -this.map[i2 >> 5];
        } else {
            i2 = this.dataLength;
            int i4 = i2 + 32;
            if (i4 > this.dataCapacity) {
                if (this.dataCapacity < 131072) {
                    i3 = 131072;
                } else if (this.dataCapacity < 1115264) {
                    i3 = 1115264;
                } else {
                    throw new IllegalStateException("Internal error in Trie2 creation.");
                }
                int[] iArr = new int[i3];
                System.arraycopy(this.data, 0, iArr, 0, this.dataLength);
                this.data = iArr;
                this.dataCapacity = i3;
            }
            this.dataLength = i4;
        }
        System.arraycopy(this.data, i, this.data, i2, 32);
        this.map[i2 >> 5] = 0;
        return i2;
    }

    private void releaseDataBlock(int i) {
        this.map[i >> 5] = -this.firstFreeBlock;
        this.firstFreeBlock = i;
    }

    private boolean isWritableBlock(int i) {
        return i != this.dataNullOffset && 1 == this.map[i >> 5];
    }

    private void setIndex2Entry(int i, int i2) {
        int[] iArr = this.map;
        int i3 = i2 >> 5;
        iArr[i3] = iArr[i3] + 1;
        int i4 = this.index2[i];
        int[] iArr2 = this.map;
        int i5 = i4 >> 5;
        int i6 = iArr2[i5] - 1;
        iArr2[i5] = i6;
        if (0 == i6) {
            releaseDataBlock(i4);
        }
        this.index2[i] = i2;
    }

    private int getDataBlock(int i, boolean z) {
        int index2Block = getIndex2Block(i, z) + ((i >> 5) & 63);
        int i2 = this.index2[index2Block];
        if (isWritableBlock(i2)) {
            return i2;
        }
        int allocDataBlock = allocDataBlock(i2);
        setIndex2Entry(index2Block, allocDataBlock);
        return allocDataBlock;
    }

    public Trie2Writable set(int i, int i2) {
        if (i < 0 || i > 1114111) {
            throw new IllegalArgumentException("Invalid code point.");
        }
        set(i, true, i2);
        this.fHash = 0;
        return this;
    }

    private Trie2Writable set(int i, boolean z, int i2) {
        if (this.isCompacted) {
            uncompact();
        }
        this.data[(i & 31) + getDataBlock(i, z)] = i2;
        return this;
    }

    private void uncompact() {
        Trie2Writable trie2Writable = new Trie2Writable(this);
        this.index1 = trie2Writable.index1;
        this.index2 = trie2Writable.index2;
        this.data = trie2Writable.data;
        this.index2Length = trie2Writable.index2Length;
        this.dataCapacity = trie2Writable.dataCapacity;
        this.isCompacted = trie2Writable.isCompacted;
        this.header = trie2Writable.header;
        this.index = trie2Writable.index;
        this.data16 = trie2Writable.data16;
        this.data32 = trie2Writable.data32;
        this.indexLength = trie2Writable.indexLength;
        this.dataLength = trie2Writable.dataLength;
        this.index2NullOffset = trie2Writable.index2NullOffset;
        this.initialValue = trie2Writable.initialValue;
        this.errorValue = trie2Writable.errorValue;
        this.highStart = trie2Writable.highStart;
        this.highValueIndex = trie2Writable.highValueIndex;
        this.dataNullOffset = trie2Writable.dataNullOffset;
    }

    private void writeBlock(int i, int i2) {
        int i3 = i + 32;
        while (i < i3) {
            i++;
            this.data[i] = i2;
        }
    }

    private void fillBlock(int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6 = i + i3;
        if (z) {
            for (int i7 = i + i2; i7 < i6; i7++) {
                this.data[i7] = i4;
            }
            return;
        }
        for (int i8 = i + i2; i8 < i6; i8++) {
            if (this.data[i8] == i5) {
                this.data[i8] = i4;
            }
        }
    }

    public Trie2Writable setRange(int i, int i2, int i3, boolean z) {
        int i4;
        if (i > 1114111 || i < 0 || i2 > 1114111 || i2 < 0 || i > i2) {
            throw new IllegalArgumentException("Invalid code point range.");
        } else if (!z && i3 == this.initialValue) {
            return this;
        } else {
            this.fHash = 0;
            if (this.isCompacted) {
                uncompact();
            }
            int i5 = i2 + 1;
            if ((i & 31) != 0) {
                int dataBlock = getDataBlock(i, true);
                int i6 = (i + 32) & -32;
                if (i6 <= i5) {
                    fillBlock(dataBlock, i & 31, 32, i3, this.initialValue, z);
                    i = i6;
                } else {
                    fillBlock(dataBlock, i & 31, i5 & 31, i3, this.initialValue, z);
                    return this;
                }
            }
            int i7 = i5 & 31;
            int i8 = i5 & -32;
            if (i3 == this.initialValue) {
                i4 = this.dataNullOffset;
            } else {
                i4 = -1;
            }
            while (i < i8) {
                boolean z2 = false;
                if (i3 != this.initialValue || !isInNullBlock(i, true)) {
                    int index2Block = getIndex2Block(i, true) + ((i >> 5) & 63);
                    int i9 = this.index2[index2Block];
                    if (isWritableBlock(i9)) {
                        if (!z || i9 < 2176) {
                            fillBlock(i9, 0, 32, i3, this.initialValue, z);
                        } else {
                            z2 = true;
                        }
                    } else if (this.data[i9] != i3 && (z || i9 == this.dataNullOffset)) {
                        z2 = true;
                    }
                    if (z2) {
                        if (i4 >= 0) {
                            setIndex2Entry(index2Block, i4);
                        } else {
                            i4 = getDataBlock(i, true);
                            writeBlock(i4, i3);
                        }
                    }
                    i += 32;
                } else {
                    i += 32;
                }
            }
            if (i7 > 0) {
                fillBlock(getDataBlock(i, true), 0, i7, i3, this.initialValue, z);
            }
            return this;
        }
    }

    public Trie2Writable setRange(Trie2.Range range, boolean z) {
        this.fHash = 0;
        if (range.leadSurrogate) {
            for (int i = range.startCodePoint; i <= range.endCodePoint; i++) {
                if (z || getFromU16SingleLead((char) i) == this.initialValue) {
                    setForLeadSurrogateCodeUnit((char) i, range.value);
                }
            }
        } else {
            setRange(range.startCodePoint, range.endCodePoint, range.value, z);
        }
        return this;
    }

    public Trie2Writable setForLeadSurrogateCodeUnit(char c, int i) {
        this.fHash = 0;
        set(c, false, i);
        return this;
    }

    @Override // com.ibm.icu.impl.Trie2
    public int get(int i) {
        if (i < 0 || i > 1114111) {
            return this.errorValue;
        }
        return get(i, true);
    }

    private int get(int i, boolean z) {
        int i2;
        if (i >= this.highStart && (i < 55296 || i >= 56320 || z)) {
            return this.data[this.dataLength - 4];
        }
        if (i < 55296 || i >= 56320 || !z) {
            i2 = this.index1[i >> 11] + ((i >> 5) & 63);
        } else {
            i2 = (i >> 5) + 320;
        }
        return this.data[(i & 31) + this.index2[i2]];
    }

    @Override // com.ibm.icu.impl.Trie2
    public int getFromU16SingleLead(char c) {
        return get(c, false);
    }

    private boolean equal_int(int[] iArr, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (iArr[i + i4] != iArr[i2 + i4]) {
                return false;
            }
        }
        return true;
    }

    private int findSameIndex2Block(int i, int i2) {
        int i3 = i - 64;
        for (int i4 = 0; i4 <= i3; i4++) {
            if (equal_int(this.index2, i4, i2, 64)) {
                return i4;
            }
        }
        return -1;
    }

    private int findSameDataBlock(int i, int i2, int i3) {
        int i4 = i - i3;
        for (int i5 = 0; i5 <= i4; i5 += 4) {
            if (equal_int(this.data, i5, i2, i3)) {
                return i5;
            }
        }
        return -1;
    }

    private int findHighStart(int i) {
        int i2;
        int i3;
        if (i == this.initialValue) {
            i3 = this.index2NullOffset;
            i2 = this.dataNullOffset;
        } else {
            i3 = -1;
            i2 = -1;
        }
        int i4 = 544;
        int i5 = 1114112;
        while (i5 > 0) {
            i4--;
            int i6 = this.index1[i4];
            if (i6 == i3) {
                i5 -= 2048;
            } else {
                i3 = i6;
                if (i6 != this.index2NullOffset) {
                    int i7 = 64;
                    while (i7 > 0) {
                        i7--;
                        int i8 = this.index2[i6 + i7];
                        if (i8 == i2) {
                            i5 -= 32;
                        } else {
                            i2 = i8;
                            if (i8 != this.dataNullOffset) {
                                int i9 = 32;
                                while (i9 > 0) {
                                    i9--;
                                    if (this.data[i8 + i9] != i) {
                                        return i5;
                                    }
                                    i5--;
                                }
                                continue;
                            } else if (i != this.initialValue) {
                                return i5;
                            } else {
                                i5 -= 32;
                            }
                        }
                    }
                    continue;
                } else if (i != this.initialValue) {
                    return i5;
                } else {
                    i5 -= 2048;
                }
            }
        }
        return 0;
    }

    private void compactData() {
        int i = 192;
        int i2 = 0;
        int i3 = 0;
        while (i2 < 192) {
            this.map[i3] = i2;
            i2 += 32;
            i3++;
        }
        int i4 = 64;
        int i5 = 2;
        int i6 = 192;
        while (i6 < this.dataLength) {
            if (i6 == 2176) {
                i4 = 32;
                i5 = 1;
            }
            if (this.map[i6 >> 5] <= 0) {
                i6 += i4;
            } else {
                int findSameDataBlock = findSameDataBlock(i, i6, i4);
                if (findSameDataBlock >= 0) {
                    int i7 = i6 >> 5;
                    for (int i8 = i5; i8 > 0; i8--) {
                        i7++;
                        this.map[i7] = findSameDataBlock;
                        findSameDataBlock += 32;
                    }
                    i6 += i4;
                } else {
                    int i9 = i4 - 4;
                    while (i9 > 0 && !equal_int(this.data, i - i9, i6, i9)) {
                        i9 -= 4;
                    }
                    if (i9 > 0 || i < i6) {
                        int i10 = i - i9;
                        int i11 = i6 >> 5;
                        for (int i12 = i5; i12 > 0; i12--) {
                            i11++;
                            this.map[i11] = i10;
                            i10 += 32;
                        }
                        i6 += i9;
                        for (int i13 = i4 - i9; i13 > 0; i13--) {
                            i++;
                            i6++;
                            this.data[i] = this.data[i6];
                        }
                    } else {
                        int i14 = i6 >> 5;
                        for (int i15 = i5; i15 > 0; i15--) {
                            i14++;
                            this.map[i14] = i6;
                            i6 += 32;
                        }
                        i = i6;
                    }
                }
            }
        }
        int i16 = 0;
        while (i16 < this.index2Length) {
            if (i16 == 2080) {
                i16 += 576;
            }
            this.index2[i16] = this.map[this.index2[i16] >> 5];
            i16++;
        }
        this.dataNullOffset = this.map[this.dataNullOffset >> 5];
        while ((i & 3) != 0) {
            i++;
            this.data[i] = this.initialValue;
        }
        if (this.UTRIE2_DEBUG) {
            System.out.printf("compacting UTrie2: count of 32-bit data words %d->%d%n", Integer.valueOf(this.dataLength), Integer.valueOf(i));
        }
        this.dataLength = i;
    }

    private void compactIndex2() {
        int i = 0;
        int i2 = 0;
        while (i < 2080) {
            this.map[i2] = i;
            i += 64;
            i2++;
        }
        int i3 = ((this.highStart - 65536) >> 11) + 32 + 2080;
        int i4 = 2656;
        while (i4 < this.index2Length) {
            int findSameIndex2Block = findSameIndex2Block(i3, i4);
            if (findSameIndex2Block >= 0) {
                this.map[i4 >> 6] = findSameIndex2Block;
                i4 += 64;
            } else {
                int i5 = 63;
                while (i5 > 0 && !equal_int(this.index2, i3 - i5, i4, i5)) {
                    i5--;
                }
                if (i5 > 0 || i3 < i4) {
                    this.map[i4 >> 6] = i3 - i5;
                    i4 += i5;
                    for (int i6 = 64 - i5; i6 > 0; i6--) {
                        i3++;
                        i4++;
                        this.index2[i3] = this.index2[i4];
                    }
                } else {
                    this.map[i4 >> 6] = i4;
                    i4 += 64;
                    i3 = i4;
                }
            }
        }
        for (int i7 = 0; i7 < 544; i7++) {
            this.index1[i7] = this.map[this.index1[i7] >> 6];
        }
        this.index2NullOffset = this.map[this.index2NullOffset >> 6];
        while ((i3 & 3) != 0) {
            i3++;
            this.index2[i3] = 262140;
        }
        if (this.UTRIE2_DEBUG) {
            System.out.printf("compacting UTrie2: count of 16-bit index-2 words %d->%d%n", Integer.valueOf(this.index2Length), Integer.valueOf(i3));
        }
        this.index2Length = i3;
    }

    private void compactTrie() {
        int i = get(1114111);
        int findHighStart = (findHighStart(i) + 2047) & -2048;
        if (findHighStart == 1114112) {
            i = this.errorValue;
        }
        this.highStart = findHighStart;
        if (this.UTRIE2_DEBUG) {
            System.out.printf("UTrie2: highStart U+%04x  highValue 0x%x  initialValue 0x%x%n", Integer.valueOf(this.highStart), Integer.valueOf(i), Integer.valueOf(this.initialValue));
        }
        if (this.highStart < 1114112) {
            setRange(this.highStart <= 65536 ? 65536 : this.highStart, 1114111, this.initialValue, true);
        }
        compactData();
        if (this.highStart > 65536) {
            compactIndex2();
        } else if (this.UTRIE2_DEBUG) {
            System.out.printf("UTrie2: highStart U+%04x  count of 16-bit index-2 words %d->%d%n", Integer.valueOf(this.highStart), Integer.valueOf(this.index2Length), 2112);
        }
        int[] iArr = this.data;
        int i2 = this.dataLength;
        this.dataLength = i2 + 1;
        iArr[i2] = i;
        while ((this.dataLength & 3) != 0) {
            int[] iArr2 = this.data;
            int i3 = this.dataLength;
            this.dataLength = i3 + 1;
            iArr2[i3] = this.initialValue;
        }
        this.isCompacted = true;
    }

    public Trie2_32 toTrie2_32() {
        Trie2_32 trie2_32 = new Trie2_32();
        freeze(trie2_32, Trie2.ValueWidth.BITS_32);
        return trie2_32;
    }

    private void freeze(Trie2 trie2, Trie2.ValueWidth valueWidth) {
        int i;
        int i2;
        if (!this.isCompacted) {
            compactTrie();
        }
        if (this.highStart <= 65536) {
            i = 2112;
        } else {
            i = this.index2Length;
        }
        if (valueWidth == Trie2.ValueWidth.BITS_16) {
            i2 = i;
        } else {
            i2 = 0;
        }
        if (i > 65535 || this.dataNullOffset + i2 > 65535 || i2 + 2176 > 65535 || this.dataLength + i2 > 262140) {
            throw new UnsupportedOperationException("Trie2 data is too large.");
        }
        int i3 = i;
        if (valueWidth == Trie2.ValueWidth.BITS_16) {
            i3 += this.dataLength;
        } else {
            trie2.data32 = new int[this.dataLength];
        }
        trie2.index = new char[i3];
        trie2.indexLength = i;
        trie2.dataLength = this.dataLength;
        if (this.highStart <= 65536) {
            trie2.index2NullOffset = 65535;
        } else {
            trie2.index2NullOffset = this.index2NullOffset + 0;
        }
        trie2.initialValue = this.initialValue;
        trie2.errorValue = this.errorValue;
        trie2.highStart = this.highStart;
        trie2.highValueIndex = (this.dataLength + i2) - 4;
        trie2.dataNullOffset = this.dataNullOffset + i2;
        trie2.header = new Trie2.UTrie2Header();
        trie2.header.signature = 1416784178;
        trie2.header.options = valueWidth == Trie2.ValueWidth.BITS_16 ? 0 : 1;
        trie2.header.indexLength = trie2.indexLength;
        trie2.header.shiftedDataLength = trie2.dataLength >> 2;
        trie2.header.index2NullOffset = trie2.index2NullOffset;
        trie2.header.dataNullOffset = trie2.dataNullOffset;
        trie2.header.shiftedHighStart = trie2.highStart >> 11;
        int i4 = 0;
        for (int i5 = 0; i5 < 2080; i5++) {
            i4++;
            trie2.index[i4] = (char) ((this.index2[i5] + i2) >> 2);
        }
        if (this.UTRIE2_DEBUG) {
            System.out.println("\n\nIndex2 for BMP limit is " + Integer.toHexString(i4));
        }
        int i6 = 0;
        while (i6 < 2) {
            i4++;
            trie2.index[i4] = (char) (i2 + 128);
            i6++;
        }
        while (i6 < 32) {
            i4++;
            trie2.index[i4] = (char) (this.index2[i6 << 1] + i2);
            i6++;
        }
        if (this.UTRIE2_DEBUG) {
            System.out.println("Index2 for UTF-8 2byte values limit is " + Integer.toHexString(i4));
        }
        if (this.highStart > 65536) {
            int i7 = (this.highStart - 65536) >> 11;
            int i8 = i7 + 2112;
            for (int i9 = 0; i9 < i7; i9++) {
                i4++;
                trie2.index[i4] = (char) (this.index1[i9 + 32] + 0);
            }
            if (this.UTRIE2_DEBUG) {
                System.out.println("Index 1 for supplementals, limit is " + Integer.toHexString(i4));
            }
            for (int i10 = 0; i10 < this.index2Length - i8; i10++) {
                i4++;
                trie2.index[i4] = (char) ((this.index2[i8 + i10] + i2) >> 2);
            }
            if (this.UTRIE2_DEBUG) {
                System.out.println("Index 2 for supplementals, limit is " + Integer.toHexString(i4));
            }
        }
        switch (valueWidth) {
            case BITS_16:
                if ($assertionsDisabled || i4 == i2) {
                    trie2.data16 = i4;
                    for (int i11 = 0; i11 < this.dataLength; i11++) {
                        i4++;
                        trie2.index[i4] = (char) this.data[i11];
                    }
                    return;
                }
                throw new AssertionError();
            case BITS_32:
                for (int i12 = 0; i12 < this.dataLength; i12++) {
                    trie2.data32[i12] = this.data[i12];
                }
                return;
            default:
                return;
        }
    }
}
