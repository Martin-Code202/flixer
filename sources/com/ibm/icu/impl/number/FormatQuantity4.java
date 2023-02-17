package com.ibm.icu.impl.number;

import java.math.BigDecimal;
import java.math.BigInteger;
public final class FormatQuantity4 extends FormatQuantityBCD {
    static final /* synthetic */ boolean $assertionsDisabled = (!FormatQuantity4.class.desiredAssertionStatus());
    private byte[] bcdBytes;
    private long bcdLong = 0;
    private boolean usingBytes = false;

    public FormatQuantity4() {
        setBcdToZero();
    }

    public FormatQuantity4(long j) {
        setToLong(j);
    }

    public FormatQuantity4(int i) {
        setToInt(i);
    }

    public FormatQuantity4(double d) {
        setToDouble(d);
    }

    public FormatQuantity4(BigInteger bigInteger) {
        setToBigInteger(bigInteger);
    }

    public FormatQuantity4(BigDecimal bigDecimal) {
        setToBigDecimal(bigDecimal);
    }

    public FormatQuantity4(FormatQuantity4 formatQuantity4) {
        copyFrom(formatQuantity4);
    }

    public FormatQuantity4(Number number) {
        if (number instanceof Long) {
            setToLong(number.longValue());
        } else if (number instanceof Integer) {
            setToInt(number.intValue());
        } else if (number instanceof Double) {
            setToDouble(number.doubleValue());
        } else if (number instanceof BigInteger) {
            setToBigInteger((BigInteger) number);
        } else if (number instanceof BigDecimal) {
            setToBigDecimal((BigDecimal) number);
        } else if (number instanceof com.ibm.icu.math.BigDecimal) {
            setToBigDecimal(((com.ibm.icu.math.BigDecimal) number).toBigDecimal());
        } else {
            throw new IllegalArgumentException("Number is of an unsupported type: " + number.getClass().getName());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public byte getDigitPos(int i) {
        if (this.usingBytes) {
            if (i < 0 || i > this.precision) {
                return 0;
            }
            return this.bcdBytes[i];
        } else if (i < 0 || i >= 16) {
            return 0;
        } else {
            return (byte) ((int) ((this.bcdLong >>> (i * 4)) & 15));
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void setDigitPos(int i, byte b) {
        if (!$assertionsDisabled && i < 0) {
            throw new AssertionError();
        } else if (this.usingBytes) {
            ensureCapacity(i + 1);
            this.bcdBytes[i] = b;
        } else if (i >= 16) {
            switchStorage();
            ensureCapacity(i + 1);
            this.bcdBytes[i] = b;
        } else {
            int i2 = i * 4;
            this.bcdLong = (this.bcdLong & ((15 << i2) ^ -1)) | (((long) b) << i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void shiftLeft(int i) {
        if (!this.usingBytes && this.precision + i > 16) {
            switchStorage();
        }
        if (this.usingBytes) {
            ensureCapacity(this.precision + i);
            int i2 = (this.precision + i) - 1;
            while (i2 >= i) {
                this.bcdBytes[i2] = this.bcdBytes[i2 - i];
                i2--;
            }
            while (i2 >= 0) {
                this.bcdBytes[i2] = 0;
                i2--;
            }
        } else {
            this.bcdLong <<= i * 4;
        }
        this.scale -= i;
        this.precision += i;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void shiftRight(int i) {
        if (this.usingBytes) {
            int i2 = 0;
            while (i2 < this.precision - i) {
                this.bcdBytes[i2] = this.bcdBytes[i2 + i];
                i2++;
            }
            while (i2 < this.precision) {
                this.bcdBytes[i2] = 0;
                i2++;
            }
        } else {
            this.bcdLong >>>= i * 4;
        }
        this.scale += i;
        this.precision -= i;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void setBcdToZero() {
        if (this.usingBytes) {
            for (int i = 0; i < this.precision; i++) {
                this.bcdBytes[i] = 0;
            }
        }
        this.usingBytes = false;
        this.bcdLong = 0;
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
            this.usingBytes = false;
            this.bcdLong = j >>> (i2 * 4);
            this.scale = 0;
            this.precision = 16 - i2;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void readLongToBcd(long j) {
        if (!$assertionsDisabled && j == 0) {
            throw new AssertionError();
        } else if (j >= 10000000000000000L) {
            ensureCapacity();
            int i = 0;
            while (j != 0) {
                this.bcdBytes[i] = (byte) ((int) (j % 10));
                j /= 10;
                i++;
            }
            this.usingBytes = true;
            this.scale = 0;
            this.precision = i;
        } else {
            long j2 = 0;
            int i2 = 16;
            while (j != 0) {
                j2 = (j2 >>> 4) + ((j % 10) << 60);
                j /= 10;
                i2--;
            }
            if ($assertionsDisabled || i2 >= 0) {
                this.usingBytes = false;
                this.bcdLong = j2 >>> (i2 * 4);
                this.scale = 0;
                this.precision = 16 - i2;
                return;
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void readBigIntegerToBcd(BigInteger bigInteger) {
        if ($assertionsDisabled || bigInteger.signum() != 0) {
            ensureCapacity();
            int i = 0;
            while (bigInteger.signum() != 0) {
                BigInteger[] divideAndRemainder = bigInteger.divideAndRemainder(BigInteger.TEN);
                ensureCapacity(i + 1);
                this.bcdBytes[i] = divideAndRemainder[1].byteValue();
                bigInteger = divideAndRemainder[0];
                i++;
            }
            this.usingBytes = true;
            this.scale = 0;
            this.precision = i;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public BigDecimal bcdToBigDecimal() {
        if (this.usingBytes) {
            StringBuilder sb = new StringBuilder();
            if (isNegative()) {
                sb.append('-');
            }
            if ($assertionsDisabled || this.precision > 0) {
                for (int i = this.precision - 1; i >= 0; i--) {
                    sb.append((int) getDigitPos(i));
                }
                if (this.scale != 0) {
                    sb.append('E');
                    sb.append(this.scale);
                }
                return new BigDecimal(sb.toString());
            }
            throw new AssertionError();
        }
        long j = 0;
        for (int i2 = this.precision - 1; i2 >= 0; i2--) {
            j = (10 * j) + ((long) getDigitPos(i2));
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
        if (this.usingBytes) {
            int i = 0;
            while (i < this.precision && this.bcdBytes[i] == 0) {
                i++;
            }
            if (i == this.precision) {
                setBcdToZero();
                return;
            }
            shiftRight(i);
            int i2 = this.precision - 1;
            while (i2 >= 0 && this.bcdBytes[i2] == 0) {
                i2--;
            }
            this.precision = i2 + 1;
            if (this.precision <= 16) {
                switchStorage();
            }
        } else if (this.bcdLong == 0) {
            setBcdToZero();
        } else {
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(this.bcdLong) / 4;
            this.bcdLong >>>= numberOfTrailingZeros * 4;
            this.scale += numberOfTrailingZeros;
            this.precision = 16 - (Long.numberOfLeadingZeros(this.bcdLong) / 4);
        }
    }

    private void ensureCapacity() {
        ensureCapacity(40);
    }

    private void ensureCapacity(int i) {
        if (i != 0) {
            if (this.bcdBytes == null) {
                this.bcdBytes = new byte[i];
            } else if (this.bcdBytes.length < i) {
                byte[] bArr = new byte[(i * 2)];
                System.arraycopy(this.bcdBytes, 0, bArr, 0, this.bcdBytes.length);
                this.bcdBytes = bArr;
            }
        }
    }

    private void switchStorage() {
        if (this.usingBytes) {
            this.bcdLong = 0;
            for (int i = this.precision - 1; i >= 0; i--) {
                this.bcdLong <<= 4;
                this.bcdLong |= (long) this.bcdBytes[i];
                this.bcdBytes[i] = 0;
            }
            this.usingBytes = false;
            return;
        }
        ensureCapacity();
        for (int i2 = 0; i2 < this.precision; i2++) {
            this.bcdBytes[i2] = (byte) ((int) (this.bcdLong & 15));
            this.bcdLong >>>= 4;
        }
        this.usingBytes = true;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.FormatQuantityBCD
    public void copyBcdFrom(FormatQuantity formatQuantity) {
        FormatQuantity4 formatQuantity4 = (FormatQuantity4) formatQuantity;
        if (formatQuantity4.usingBytes) {
            this.usingBytes = true;
            ensureCapacity(formatQuantity4.precision);
            System.arraycopy(formatQuantity4.bcdBytes, 0, this.bcdBytes, 0, formatQuantity4.precision);
            return;
        }
        this.usingBytes = false;
        this.bcdLong = formatQuantity4.bcdLong;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0039: APUT  (r1v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r2v1 java.lang.String) */
    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (this.usingBytes) {
            for (int i = this.precision - 1; i >= 0; i--) {
                sb.append((int) this.bcdBytes[i]);
            }
        } else {
            sb.append(Long.toHexString(this.bcdLong));
        }
        Object[] objArr = new Object[8];
        if (this.lOptPos > 1000) {
            str = "max";
        } else {
            str = String.valueOf(this.lOptPos);
        }
        objArr[0] = str;
        objArr[1] = Integer.valueOf(this.lReqPos);
        objArr[2] = Integer.valueOf(this.rReqPos);
        if (this.rOptPos < -1000) {
            str2 = "min";
        } else {
            str2 = String.valueOf(this.rOptPos);
        }
        objArr[3] = str2;
        objArr[4] = this.usingBytes ? "bytes" : "long";
        objArr[5] = sb;
        objArr[6] = "E";
        objArr[7] = Integer.valueOf(this.scale);
        return String.format("<FormatQuantity4 %s:%d:%d:%s %s %s%s%d>", objArr);
    }
}
