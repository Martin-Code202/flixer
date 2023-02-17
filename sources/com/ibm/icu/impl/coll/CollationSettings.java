package com.ibm.icu.impl.coll;

import java.util.Arrays;
public final class CollationSettings extends SharedObject {
    static final /* synthetic */ boolean $assertionsDisabled = (!CollationSettings.class.desiredAssertionStatus());
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    public int fastLatinOptions = -1;
    public char[] fastLatinPrimaries = new char[384];
    long minHighNoReorder;
    public int options = 8208;
    public int[] reorderCodes = EMPTY_INT_ARRAY;
    long[] reorderRanges;
    public byte[] reorderTable;
    public long variableTop;

    CollationSettings() {
    }

    @Override // com.ibm.icu.impl.coll.SharedObject, java.lang.Object
    public CollationSettings clone() {
        CollationSettings collationSettings = (CollationSettings) super.clone();
        collationSettings.fastLatinPrimaries = (char[]) this.fastLatinPrimaries.clone();
        return collationSettings;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        CollationSettings collationSettings = (CollationSettings) obj;
        if (this.options != collationSettings.options) {
            return false;
        }
        if (((this.options & 12) == 0 || this.variableTop == collationSettings.variableTop) && Arrays.equals(this.reorderCodes, collationSettings.reorderCodes)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.options << 8;
        if ((this.options & 12) != 0) {
            i = (int) (((long) i) ^ this.variableTop);
        }
        int length = i ^ this.reorderCodes.length;
        for (int i2 = 0; i2 < this.reorderCodes.length; i2++) {
            length ^= this.reorderCodes[i2] << i2;
        }
        return length;
    }

    public void resetReordering() {
        this.reorderTable = null;
        this.minHighNoReorder = 0;
        this.reorderRanges = null;
        this.reorderCodes = EMPTY_INT_ARRAY;
    }

    /* access modifiers changed from: package-private */
    public void aliasReordering(CollationData collationData, int[] iArr, int i, byte[] bArr) {
        int[] iArr2;
        if (i == iArr.length) {
            iArr2 = iArr;
        } else {
            iArr2 = new int[i];
            System.arraycopy(iArr, 0, iArr2, 0, i);
        }
        int length = iArr.length;
        int i2 = length - i;
        if (bArr == null || (i2 != 0 ? i2 < 2 || (iArr[i] & 65535) != 0 || (iArr[length - 1] & 65535) == 0 : reorderTableHasSplitBytes(bArr))) {
            setReordering(collationData, iArr2);
            return;
        }
        this.reorderTable = bArr;
        this.reorderCodes = iArr2;
        int i3 = i;
        while (i3 < length && (iArr[i3] & 16711680) == 0) {
            i3++;
        }
        if (i3 == length) {
            if ($assertionsDisabled || !reorderTableHasSplitBytes(bArr)) {
                this.minHighNoReorder = 0;
                this.reorderRanges = null;
                return;
            }
            throw new AssertionError();
        } else if ($assertionsDisabled || bArr[iArr[i3] >>> 24] == 0) {
            this.minHighNoReorder = ((long) iArr[length - 1]) & 4294901760L;
            setReorderRanges(iArr, i3, length - i3);
        } else {
            throw new AssertionError();
        }
    }

    public void setReordering(CollationData collationData, int[] iArr) {
        int i;
        int i2;
        if (iArr.length == 0 || (iArr.length == 1 && iArr[0] == 103)) {
            resetReordering();
            return;
        }
        UVector32 uVector32 = new UVector32();
        collationData.makeReorderRanges(iArr, uVector32);
        int size = uVector32.size();
        if (size == 0) {
            resetReordering();
            return;
        }
        int[] buffer = uVector32.getBuffer();
        if (!$assertionsDisabled && size < 2) {
            throw new AssertionError();
        } else if ($assertionsDisabled || ((buffer[0] & 65535) == 0 && (buffer[size - 1] & 65535) != 0)) {
            this.minHighNoReorder = ((long) buffer[size - 1]) & 4294901760L;
            byte[] bArr = new byte[256];
            int i3 = 0;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                int i6 = buffer[i5];
                int i7 = i6 >>> 24;
                while (i3 < i7) {
                    bArr[i3] = (byte) (i3 + i6);
                    i3++;
                }
                if ((16711680 & i6) != 0) {
                    bArr[i7] = 0;
                    i3 = i7 + 1;
                    if (i4 < 0) {
                        i4 = i5;
                    }
                }
            }
            while (i3 <= 255) {
                bArr[i3] = (byte) i3;
                i3++;
            }
            if (i4 < 0) {
                i2 = 0;
                i = 0;
            } else {
                i = i4;
                i2 = size - i4;
            }
            setReorderArrays(iArr, buffer, i, i2, bArr);
        } else {
            throw new AssertionError();
        }
    }

    private void setReorderArrays(int[] iArr, int[] iArr2, int i, int i2, byte[] bArr) {
        if (iArr == null) {
            iArr = EMPTY_INT_ARRAY;
        }
        if (!$assertionsDisabled) {
            if ((iArr.length == 0) != (bArr == null)) {
                throw new AssertionError();
            }
        }
        this.reorderTable = bArr;
        this.reorderCodes = iArr;
        setReorderRanges(iArr2, i, i2);
    }

    private void setReorderRanges(int[] iArr, int i, int i2) {
        if (i2 == 0) {
            this.reorderRanges = null;
            return;
        }
        this.reorderRanges = new long[i2];
        int i3 = 0;
        do {
            i3++;
            i++;
            this.reorderRanges[i3] = ((long) iArr[i]) & 4294967295L;
        } while (i3 < i2);
    }

    public void copyReorderingFrom(CollationSettings collationSettings) {
        if (!collationSettings.hasReordering()) {
            resetReordering();
            return;
        }
        this.minHighNoReorder = collationSettings.minHighNoReorder;
        this.reorderTable = collationSettings.reorderTable;
        this.reorderRanges = collationSettings.reorderRanges;
        this.reorderCodes = collationSettings.reorderCodes;
    }

    public boolean hasReordering() {
        return this.reorderTable != null;
    }

    private static boolean reorderTableHasSplitBytes(byte[] bArr) {
        if ($assertionsDisabled || bArr[0] == 0) {
            for (int i = 1; i < 256; i++) {
                if (bArr[i] == 0) {
                    return true;
                }
            }
            return false;
        }
        throw new AssertionError();
    }

    public long reorder(long j) {
        byte b = this.reorderTable[((int) j) >>> 24];
        if (b != 0 || j <= 1) {
            return ((((long) b) & 255) << 24) | (16777215 & j);
        }
        return reorderEx(j);
    }

    private long reorderEx(long j) {
        if (!$assertionsDisabled && this.minHighNoReorder <= 0) {
            throw new AssertionError();
        } else if (j >= this.minHighNoReorder) {
            return j;
        } else {
            long j2 = j | 65535;
            int i = 0;
            while (true) {
                long j3 = this.reorderRanges[i];
                if (j2 < j3) {
                    return (((long) ((short) ((int) j3))) << 24) + j;
                }
                i++;
            }
        }
    }

    public void setStrength(int i) {
        int i2 = this.options & -61441;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 15:
                this.options = (i << 12) | i2;
                return;
            default:
                throw new IllegalArgumentException("illegal strength value " + i);
        }
    }

    static int getStrength(int i) {
        return i >> 12;
    }

    public int getStrength() {
        return getStrength(this.options);
    }

    public void setFlag(int i, boolean z) {
        if (z) {
            this.options |= i;
        } else {
            this.options &= i ^ -1;
        }
    }

    public boolean getFlag(int i) {
        return (this.options & i) != 0;
    }

    public void setCaseFirst(int i) {
        if ($assertionsDisabled || i == 0 || i == 512 || i == 768) {
            this.options = (this.options & -769) | i;
            return;
        }
        throw new AssertionError();
    }

    public int getCaseFirst() {
        return this.options & 768;
    }

    public void setAlternateHandlingShifted(boolean z) {
        int i = this.options & -13;
        if (z) {
            this.options = i | 4;
        } else {
            this.options = i;
        }
    }

    public boolean getAlternateHandling() {
        return (this.options & 12) != 0;
    }

    public void setMaxVariable(int i, int i2) {
        int i3 = this.options & -113;
        switch (i) {
            case -1:
                this.options = (i2 & 112) | i3;
                return;
            case 0:
            case 1:
            case 2:
            case 3:
                this.options = (i << 4) | i3;
                return;
            default:
                throw new IllegalArgumentException("illegal maxVariable value " + i);
        }
    }

    public int getMaxVariable() {
        return (this.options & 112) >> 4;
    }

    static boolean isTertiaryWithCaseBits(int i) {
        return (i & 1536) == 512;
    }

    static int getTertiaryMask(int i) {
        return isTertiaryWithCaseBits(i) ? 65343 : 16191;
    }

    static boolean sortsTertiaryUpperCaseFirst(int i) {
        return (i & 1792) == 768;
    }

    public boolean dontCheckFCD() {
        return (this.options & 1) == 0;
    }

    public boolean isNumeric() {
        return (this.options & 2) != 0;
    }
}
