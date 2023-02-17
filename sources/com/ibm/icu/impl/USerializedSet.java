package com.ibm.icu.impl;

import org.linphone.core.Privacy;
public final class USerializedSet {
    private char[] array = new char[8];
    private int arrayOffset;
    private int bmpLength;
    private int length;

    public final boolean getSet(char[] cArr, int i) {
        this.array = null;
        this.length = 0;
        this.bmpLength = 0;
        this.arrayOffset = 0;
        int i2 = i + 1;
        this.length = cArr[i];
        if ((this.length & Privacy.DEFAULT) != 0) {
            this.length &= 32767;
            if (cArr.length < i2 + 1 + this.length) {
                this.length = 0;
                throw new IndexOutOfBoundsException();
            }
            i2++;
            this.bmpLength = cArr[i2];
        } else if (cArr.length < this.length + i2) {
            this.length = 0;
            throw new IndexOutOfBoundsException();
        } else {
            this.bmpLength = this.length;
        }
        this.array = new char[this.length];
        System.arraycopy(cArr, i2, this.array, 0, this.length);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: int[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: char[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v21, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getRange(int i, int[] iArr) {
        if (i < 0) {
            return false;
        }
        if (this.array == null) {
            this.array = new char[8];
        }
        if (iArr == 0 || iArr.length < 2) {
            throw new IllegalArgumentException();
        }
        int i2 = i * 2;
        if (i2 < this.bmpLength) {
            int i3 = i2 + 1;
            iArr[0] = this.array[i2];
            if (i3 < this.bmpLength) {
                iArr[1] = this.array[i3] - 1;
                return true;
            } else if (i3 < this.length) {
                iArr[1] = ((this.array[i3] << 16) | this.array[i3 + 1]) - 1;
                return true;
            } else {
                iArr[1] = 1114111;
                return true;
            }
        } else {
            int i4 = (i2 - this.bmpLength) * 2;
            int i5 = this.length - this.bmpLength;
            if (i4 >= i5) {
                return false;
            }
            int i6 = this.arrayOffset + this.bmpLength;
            iArr[0] = (this.array[i6 + i4] << 16) | this.array[i6 + i4 + 1];
            int i7 = i4 + 2;
            if (i7 < i5) {
                iArr[1] = ((this.array[i6 + i7] << 16) | this.array[(i6 + i7) + 1]) - 1;
                return true;
            }
            iArr[1] = 1114111;
            return true;
        }
    }

    public final int countRanges() {
        return ((this.bmpLength + ((this.length - this.bmpLength) / 2)) + 1) / 2;
    }
}
