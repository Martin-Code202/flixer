package com.ibm.icu.impl.number;

import java.math.BigDecimal;
import java.math.BigInteger;
public final class FormatQuantity2 extends FormatQuantityBCD {
    static final /* synthetic */ boolean $assertionsDisabled = (!FormatQuantity2.class.desiredAssertionStatus());
    private long bcd;

    public FormatQuantity2(FormatQuantity2 formatQuantity2) {
        copyFrom(formatQuantity2);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public byte getDigitPos(int i) {
        if (i < 0 || i >= 16) {
            return 0;
        }
        return (byte) ((int) ((this.bcd >>> (i * 4)) & 15));
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void setDigitPos(int i, byte b) {
        if ($assertionsDisabled || (i >= 0 && i < 16)) {
            int i2 = i * 4;
            this.bcd = (this.bcd & ((15 << i2) ^ -1)) | (((long) b) << i2);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void shiftLeft(int i) {
        if ($assertionsDisabled || this.precision + i <= 16) {
            this.bcd <<= i * 4;
            this.scale -= i;
            this.precision += i;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void shiftRight(int i) {
        this.bcd >>>= i * 4;
        this.scale += i;
        this.precision -= i;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void setBcdToZero() {
        this.bcd = 0;
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
            long j = 0;
            int i2 = 16;
            while (i != 0) {
                j = (j >>> 4) + ((((long) i) % 10) << 60);
                i /= 10;
                i2--;
            }
            this.bcd = j >>> (i2 * 4);
            this.scale = 0;
            this.precision = 16 - i2;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void readLongToBcd(long j) {
        if ($assertionsDisabled || j != 0) {
            long j2 = 0;
            int i = 16;
            while (j != 0) {
                j2 = (j2 >>> 4) + ((j % 10) << 60);
                j /= 10;
                i--;
            }
            this.bcd = j2 >>> ((i > 0 ? i : 0) * 4);
            this.scale = i < 0 ? -i : 0;
            this.precision = 16 - i;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void readBigIntegerToBcd(BigInteger bigInteger) {
        if ($assertionsDisabled || bigInteger.signum() != 0) {
            long j = 0;
            int i = 16;
            while (bigInteger.signum() != 0) {
                BigInteger[] divideAndRemainder = bigInteger.divideAndRemainder(BigInteger.TEN);
                j = (j >>> 4) + (divideAndRemainder[1].longValue() << 60);
                bigInteger = divideAndRemainder[0];
                i--;
            }
            this.bcd = j >>> ((i > 0 ? i : 0) * 4);
            this.scale = i < 0 ? -i : 0;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public BigDecimal bcdToBigDecimal() {
        long j = 0;
        for (int i = this.precision - 1; i >= 0; i--) {
            j = (10 * j) + ((long) getDigitPos(i));
        }
        BigDecimal scaleByPowerOfTen = BigDecimal.valueOf(j).scaleByPowerOfTen(this.scale);
        if (isNegative()) {
            return scaleByPowerOfTen.negate();
        }
        return scaleByPowerOfTen;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void compact() {
        if (this.bcd == 0) {
            this.scale = 0;
            this.precision = 0;
            return;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(this.bcd) / 4;
        this.bcd >>>= numberOfTrailingZeros * 4;
        this.scale += numberOfTrailingZeros;
        this.precision = 16 - (Long.numberOfLeadingZeros(this.bcd) / 4);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void copyBcdFrom(FormatQuantity formatQuantity) {
        this.bcd = ((FormatQuantity2) formatQuantity).bcd;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0015: APUT  (r1v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r2v1 java.lang.String) */
    public String toString() {
        String str;
        Object[] objArr = new Object[6];
        objArr[0] = this.lOptPos > 1000 ? "max" : String.valueOf(this.lOptPos);
        objArr[1] = Integer.valueOf(this.lReqPos);
        objArr[2] = Integer.valueOf(this.rReqPos);
        if (this.rOptPos < -1000) {
            str = "min";
        } else {
            str = String.valueOf(this.rOptPos);
        }
        objArr[3] = str;
        objArr[4] = Long.valueOf(this.bcd);
        objArr[5] = Integer.valueOf(this.scale);
        return String.format("<FormatQuantity2 %s:%d:%d:%s %016XE%d>", objArr);
    }
}
