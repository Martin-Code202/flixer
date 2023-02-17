package com.google.android.exoplayer2.util;
public final class ParsableNalUnitBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    private byte[] data;

    public ParsableNalUnitBitArray(byte[] bArr, int i, int i2) {
        reset(bArr, i, i2);
    }

    public void reset(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.byteOffset = i;
        this.byteLimit = i2;
        this.bitOffset = 0;
        assertValidOffset();
    }

    public void skipBit() {
        int i = this.bitOffset + 1;
        this.bitOffset = i;
        if (i == 8) {
            this.bitOffset = 0;
            this.byteOffset += shouldSkipByte(this.byteOffset + 1) ? 2 : 1;
        }
        assertValidOffset();
    }

    public void skipBits(int i) {
        int i2 = this.byteOffset;
        int i3 = i / 8;
        this.byteOffset += i3;
        this.bitOffset += i - (i3 * 8);
        if (this.bitOffset > 7) {
            this.byteOffset++;
            this.bitOffset -= 8;
        }
        int i4 = i2 + 1;
        while (i4 <= this.byteOffset) {
            if (shouldSkipByte(i4)) {
                this.byteOffset++;
                i4 += 2;
            }
            i4++;
        }
        assertValidOffset();
    }

    public boolean readBit() {
        boolean z = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        skipBit();
        return z;
    }

    public int readBits(int i) {
        int i2 = 0;
        this.bitOffset += i;
        while (this.bitOffset > 8) {
            this.bitOffset -= 8;
            i2 |= (this.data[this.byteOffset] & 255) << this.bitOffset;
            this.byteOffset += shouldSkipByte(this.byteOffset + 1) ? 2 : 1;
        }
        int i3 = (i2 | ((this.data[this.byteOffset] & 255) >> (8 - this.bitOffset))) & (-1 >>> (32 - i));
        if (this.bitOffset == 8) {
            this.bitOffset = 0;
            this.byteOffset += shouldSkipByte(this.byteOffset + 1) ? 2 : 1;
        }
        assertValidOffset();
        return i3;
    }

    public int readUnsignedExpGolombCodedInt() {
        return readExpGolombCodeNum();
    }

    public int readSignedExpGolombCodedInt() {
        int readExpGolombCodeNum = readExpGolombCodeNum();
        return (readExpGolombCodeNum % 2 == 0 ? -1 : 1) * ((readExpGolombCodeNum + 1) / 2);
    }

    private int readExpGolombCodeNum() {
        int i = 0;
        while (!readBit()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? readBits(i) : 0);
    }

    private boolean shouldSkipByte(int i) {
        return 2 <= i && i < this.byteLimit && this.data[i] == 3 && this.data[i + -2] == 0 && this.data[i + -1] == 0;
    }

    private void assertValidOffset() {
        Assertions.checkState(this.byteOffset >= 0 && (this.byteOffset < this.byteLimit || (this.byteOffset == this.byteLimit && this.bitOffset == 0)));
    }
}
