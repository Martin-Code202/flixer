package com.ibm.icu.impl.number;

import java.math.BigDecimal;
import java.math.BigInteger;
public final class FormatQuantity3 extends FormatQuantityBCD {
    static final /* synthetic */ boolean $assertionsDisabled = (!FormatQuantity3.class.desiredAssertionStatus());
    private static final byte[] LONG_MIN_VALUE = {8, 0, 8, 5, 7, 7, 4, 5, 8, 6, 3, 0, 2, 7, 3, 3, 2, 2, 9};
    private byte[] bcd = new byte[100];

    public FormatQuantity3(FormatQuantity3 formatQuantity3) {
        copyFrom(formatQuantity3);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public byte getDigitPos(int i) {
        if (i < 0 || i > this.precision) {
            return 0;
        }
        return this.bcd[i];
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void setDigitPos(int i, byte b) {
        if ($assertionsDisabled || i >= 0) {
            ensureCapacity(i + 1);
            this.bcd[i] = b;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void shiftLeft(int i) {
        ensureCapacity(this.precision + i);
        int i2 = (this.precision + i) - 1;
        while (i2 >= i) {
            this.bcd[i2] = this.bcd[i2 - i];
            i2--;
        }
        while (i2 >= 0) {
            this.bcd[i2] = 0;
            i2--;
        }
        this.scale -= i;
        this.precision += i;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void shiftRight(int i) {
        int i2 = 0;
        while (i2 < this.precision - i) {
            this.bcd[i2] = this.bcd[i2 + i];
            i2++;
        }
        while (i2 < this.precision) {
            this.bcd[i2] = 0;
            i2++;
        }
        this.scale += i;
        this.precision -= i;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void setBcdToZero() {
        for (int i = 0; i < this.precision; i++) {
            this.bcd[i] = 0;
        }
        this.scale = 0;
        this.precision = 0;
        this.isApproximate = false;
        this.origDouble = 0.0d;
        this.origDelta = 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void readIntToBcd(int i) {
        if ($assertionsDisabled || i != 0) {
            int i2 = 0;
            while (((long) i) != 0) {
                this.bcd[i2] = (byte) (i % 10);
                i = (int) (((long) i) / 10);
                i2++;
            }
            this.scale = 0;
            this.precision = i2;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void readLongToBcd(long j) {
        if (!$assertionsDisabled && j == 0) {
            throw new AssertionError();
        } else if (j == Long.MIN_VALUE) {
            System.arraycopy(LONG_MIN_VALUE, 0, this.bcd, 0, LONG_MIN_VALUE.length);
            this.scale = 0;
            this.precision = LONG_MIN_VALUE.length;
        } else {
            int i = 0;
            while (j != 0) {
                this.bcd[i] = (byte) ((int) (j % 10));
                j /= 10;
                i++;
            }
            this.scale = 0;
            this.precision = i;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void readBigIntegerToBcd(BigInteger bigInteger) {
        if ($assertionsDisabled || bigInteger.signum() != 0) {
            int i = 0;
            while (bigInteger.signum() != 0) {
                BigInteger[] divideAndRemainder = bigInteger.divideAndRemainder(BigInteger.TEN);
                ensureCapacity(i + 1);
                this.bcd[i] = divideAndRemainder[1].byteValue();
                bigInteger = divideAndRemainder[0];
                i++;
            }
            this.scale = 0;
            this.precision = i;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public BigDecimal bcdToBigDecimal() {
        return new BigDecimal(toDumbString());
    }

    private String toDumbString() {
        StringBuilder sb = new StringBuilder();
        if (isNegative()) {
            sb.append('-');
        }
        if (this.precision == 0) {
            sb.append('0');
            return sb.toString();
        }
        for (int i = this.precision - 1; i >= 0; i--) {
            sb.append((int) getDigitPos(i));
        }
        if (this.scale != 0) {
            sb.append('E');
            sb.append(this.scale);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void compact() {
        boolean z = true;
        int i = 0;
        while (true) {
            if (i >= this.precision) {
                break;
            } else if (this.bcd[i] != 0) {
                z = false;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.scale = 0;
            this.precision = 0;
            return;
        }
        int i2 = 0;
        while (this.bcd[i2] == 0) {
            i2++;
        }
        shiftRight(i2);
        int i3 = this.precision - 1;
        while (i3 >= 0 && this.bcd[i3] == 0) {
            i3--;
        }
        this.precision = i3 + 1;
    }

    private void ensureCapacity(int i) {
        if (this.bcd.length < i) {
            byte[] bArr = new byte[(i * 2)];
            System.arraycopy(this.bcd, 0, bArr, 0, this.bcd.length);
            this.bcd = bArr;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void copyBcdFrom(FormatQuantity formatQuantity) {
        System.arraycopy(((FormatQuantity3) formatQuantity).bcd, 0, this.bcd, 0, this.bcd.length);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0028: APUT  (r1v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r2v1 java.lang.String) */
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        for (int i = 30; i >= 0; i--) {
            sb.append((int) this.bcd[i]);
        }
        Object[] objArr = new Object[7];
        objArr[0] = this.lOptPos > 1000 ? "max" : String.valueOf(this.lOptPos);
        objArr[1] = Integer.valueOf(this.lReqPos);
        objArr[2] = Integer.valueOf(this.rReqPos);
        if (this.rOptPos < -1000) {
            str = "min";
        } else {
            str = String.valueOf(this.rOptPos);
        }
        objArr[3] = str;
        objArr[4] = sb;
        objArr[5] = "E";
        objArr[6] = Integer.valueOf(this.scale);
        return String.format("<FormatQuantity3 %s:%d:%d:%s %s%s%d>", objArr);
    }
}
