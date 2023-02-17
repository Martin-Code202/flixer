package com.ibm.icu.math;

import com.ibm.icu.lang.UCharacter;
import java.io.Serializable;
import java.math.BigInteger;
public class BigDecimal extends Number implements Serializable, Comparable<BigDecimal> {
    public static final BigDecimal ONE = new BigDecimal(1L);
    public static final BigDecimal TEN = new BigDecimal(10);
    public static final BigDecimal ZERO = new BigDecimal(0L);
    private static byte[] bytecar = new byte[190];
    private static byte[] bytedig = diginit();
    private static final MathContext plainMC = new MathContext(0, 0);
    private static final long serialVersionUID = 8245355804974198832L;
    private int exp;
    private byte form;
    private byte ind;
    private byte[] mant;

    public BigDecimal(java.math.BigDecimal bigDecimal) {
        this(bigDecimal.toString());
    }

    public BigDecimal(BigInteger bigInteger) {
        this(bigInteger.toString(10));
    }

    public BigDecimal(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        this.form = 0;
        if (i2 <= 0) {
            bad(cArr);
        }
        this.ind = 1;
        if (cArr[i] == '-') {
            i2--;
            if (i2 == 0) {
                bad(cArr);
            }
            this.ind = -1;
            i++;
        } else if (cArr[i] == '+') {
            i2--;
            if (i2 == 0) {
                bad(cArr);
            }
            i++;
        }
        boolean z = false;
        boolean z2 = false;
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        int i8 = i2;
        int i9 = i;
        while (true) {
            if (i8 <= 0) {
                break;
            }
            char c = cArr[i9];
            if (c >= '0' && c <= '9') {
                i7 = i9;
                i5++;
            } else if (c == '.') {
                if (i6 >= 0) {
                    bad(cArr);
                }
                i6 = i9 - i;
            } else if (c == 'e' || c == 'E') {
                break;
            } else {
                if (!UCharacter.isDigit(c)) {
                    bad(cArr);
                }
                z = true;
                i7 = i9;
                i5++;
            }
            i8--;
            i9++;
        }
        if (i9 - i > i2 - 2) {
            bad(cArr);
        }
        boolean z3 = false;
        if (cArr[i9 + 1] == '-') {
            z3 = true;
            i3 = i9 + 2;
        } else if (cArr[i9 + 1] == '+') {
            i3 = i9 + 2;
        } else {
            i3 = i9 + 1;
        }
        int i10 = i2 - (i3 - i);
        if ((i10 == 0) || (i10 > 9)) {
            bad(cArr);
        }
        int i11 = i10;
        int i12 = i3;
        while (i11 > 0) {
            char c2 = cArr[i12];
            if (c2 < '0') {
                bad(cArr);
            }
            if (c2 > '9') {
                if (!UCharacter.isDigit(c2)) {
                    bad(cArr);
                }
                i4 = UCharacter.digit(c2, 10);
                if (i4 < 0) {
                    bad(cArr);
                }
            } else {
                i4 = c2 - '0';
            }
            this.exp = (this.exp * 10) + i4;
            i11--;
            i12++;
        }
        if (z3) {
            this.exp = -this.exp;
        }
        z2 = true;
        if (i5 == 0) {
            bad(cArr);
        }
        if (i6 >= 0) {
            this.exp = (this.exp + i6) - i5;
        }
        int i13 = i7 - 1;
        for (int i14 = i; i14 <= i13; i14++) {
            char c3 = cArr[i14];
            if (c3 == '0') {
                i++;
                i6--;
                i5--;
            } else if (c3 != '.') {
                if (c3 <= '9' || UCharacter.digit(c3, 10) != 0) {
                    break;
                }
                i++;
                i6--;
                i5--;
            } else {
                i++;
                i6--;
            }
        }
        this.mant = new byte[i5];
        int i15 = i;
        if (z) {
            int i16 = i5;
            int i17 = 0;
            while (i16 > 0) {
                i15 = i17 == i6 ? i15 + 1 : i15;
                char c4 = cArr[i15];
                if (c4 <= '9') {
                    this.mant[i17] = (byte) (c4 - '0');
                } else {
                    int digit = UCharacter.digit(c4, 10);
                    if (digit < 0) {
                        bad(cArr);
                    }
                    this.mant[i17] = (byte) digit;
                }
                i15++;
                i16--;
                i17++;
            }
        } else {
            int i18 = i5;
            int i19 = 0;
            while (i18 > 0) {
                if (i19 == i6) {
                    i15++;
                }
                this.mant[i19] = (byte) (cArr[i15] - '0');
                i15++;
                i18--;
                i19++;
            }
        }
        if (this.mant[0] == 0) {
            this.ind = 0;
            if (this.exp > 0) {
                this.exp = 0;
            }
            if (z2) {
                this.mant = ZERO.mant;
                this.exp = 0;
            }
        } else if (z2) {
            this.form = 1;
            int length = (this.exp + this.mant.length) - 1;
            if ((length < -999999999) || (length > 999999999)) {
                bad(cArr);
            }
        }
    }

    public BigDecimal(int i) {
        this.form = 0;
        if (i > 9 || i < -9) {
            if (i > 0) {
                this.ind = 1;
                i = -i;
            } else {
                this.ind = -1;
            }
            int i2 = i;
            int i3 = 9;
            while (true) {
                i2 /= 10;
                if (i2 == 0) {
                    break;
                }
                i3--;
            }
            this.mant = new byte[(10 - i3)];
            int i4 = (10 - i3) - 1;
            while (true) {
                this.mant[i4] = (byte) (-((byte) (i % 10)));
                i /= 10;
                if (i != 0) {
                    i4--;
                } else {
                    return;
                }
            }
        } else if (i == 0) {
            this.mant = ZERO.mant;
            this.ind = 0;
        } else if (i == 1) {
            this.mant = ONE.mant;
            this.ind = 1;
        } else if (i == -1) {
            this.mant = ONE.mant;
            this.ind = -1;
        } else {
            this.mant = new byte[1];
            if (i > 0) {
                this.mant[0] = (byte) i;
                this.ind = 1;
                return;
            }
            this.mant[0] = (byte) (-i);
            this.ind = -1;
        }
    }

    public BigDecimal(long j) {
        this.form = 0;
        if (j > 0) {
            this.ind = 1;
            j = -j;
        } else if (j == 0) {
            this.ind = 0;
        } else {
            this.ind = -1;
        }
        long j2 = j;
        int i = 18;
        while (true) {
            j2 /= 10;
            if (j2 == 0) {
                break;
            }
            i--;
        }
        this.mant = new byte[(19 - i)];
        int i2 = (19 - i) - 1;
        while (true) {
            this.mant[i2] = (byte) (-((byte) ((int) (j % 10))));
            j /= 10;
            if (j != 0) {
                i2--;
            } else {
                return;
            }
        }
    }

    public BigDecimal(String str) {
        this(str.toCharArray(), 0, str.length());
    }

    private BigDecimal() {
        this.form = 0;
    }

    public BigDecimal add(BigDecimal bigDecimal, MathContext mathContext) {
        int i;
        byte b;
        byte b2;
        if (mathContext.lostDigits) {
            checkdigits(bigDecimal, mathContext.digits);
        }
        BigDecimal bigDecimal2 = this;
        if (bigDecimal2.ind == 0 && mathContext.form != 0) {
            return bigDecimal.plus(mathContext);
        }
        if (bigDecimal.ind == 0 && mathContext.form != 0) {
            return bigDecimal2.plus(mathContext);
        }
        int i2 = mathContext.digits;
        if (i2 > 0) {
            if (bigDecimal2.mant.length > i2) {
                bigDecimal2 = clone(bigDecimal2).round(mathContext);
            }
            if (bigDecimal.mant.length > i2) {
                bigDecimal = clone(bigDecimal).round(mathContext);
            }
        }
        BigDecimal bigDecimal3 = new BigDecimal();
        byte[] bArr = bigDecimal2.mant;
        int length = bigDecimal2.mant.length;
        byte[] bArr2 = bigDecimal.mant;
        int length2 = bigDecimal.mant.length;
        if (bigDecimal2.exp == bigDecimal.exp) {
            bigDecimal3.exp = bigDecimal2.exp;
        } else if (bigDecimal2.exp > bigDecimal.exp) {
            int i3 = (bigDecimal2.exp + length) - bigDecimal.exp;
            if (i3 < length2 + i2 + 1 || i2 <= 0) {
                bigDecimal3.exp = bigDecimal.exp;
                if (i3 > i2 + 1 && i2 > 0) {
                    int i4 = (i3 - i2) - 1;
                    length2 -= i4;
                    bigDecimal3.exp += i4;
                    i3 = i2 + 1;
                }
                if (i3 > length) {
                    length = i3;
                }
            } else {
                bigDecimal3.mant = bArr;
                bigDecimal3.exp = bigDecimal2.exp;
                bigDecimal3.ind = bigDecimal2.ind;
                if (length < i2) {
                    bigDecimal3.mant = extend(bigDecimal2.mant, i2);
                    bigDecimal3.exp -= i2 - length;
                }
                return bigDecimal3.finish(mathContext, false);
            }
        } else {
            int i5 = (bigDecimal.exp + length2) - bigDecimal2.exp;
            if (i5 < length + i2 + 1 || i2 <= 0) {
                bigDecimal3.exp = bigDecimal2.exp;
                if (i5 > i2 + 1 && i2 > 0) {
                    int i6 = (i5 - i2) - 1;
                    length -= i6;
                    bigDecimal3.exp += i6;
                    i5 = i2 + 1;
                }
                if (i5 > length2) {
                    length2 = i5;
                }
            } else {
                bigDecimal3.mant = bArr2;
                bigDecimal3.exp = bigDecimal.exp;
                bigDecimal3.ind = bigDecimal.ind;
                if (length2 < i2) {
                    bigDecimal3.mant = extend(bigDecimal.mant, i2);
                    bigDecimal3.exp -= i2 - length2;
                }
                return bigDecimal3.finish(mathContext, false);
            }
        }
        if (bigDecimal2.ind == 0) {
            bigDecimal3.ind = 1;
        } else {
            bigDecimal3.ind = bigDecimal2.ind;
        }
        if ((bigDecimal2.ind == -1) == (bigDecimal.ind == -1)) {
            i = 1;
        } else {
            i = -1;
            if (bigDecimal.ind != 0) {
                if ((length < length2) || (bigDecimal2.ind == 0)) {
                    bArr = bArr2;
                    bArr2 = bArr;
                    length = length2;
                    length2 = length;
                    bigDecimal3.ind = (byte) (-bigDecimal3.ind);
                } else if (length <= length2) {
                    int i7 = 0;
                    int i8 = 0;
                    int length3 = bArr.length - 1;
                    int length4 = bArr2.length - 1;
                    while (true) {
                        if (i7 <= length3) {
                            b = bArr[i7];
                        } else if (i8 <= length4) {
                            b = 0;
                        } else if (mathContext.form != 0) {
                            return ZERO;
                        }
                        if (i8 <= length4) {
                            b2 = bArr2[i8];
                        } else {
                            b2 = 0;
                        }
                        if (b == b2) {
                            i7++;
                            i8++;
                        } else if (b < b2) {
                            bArr = bArr2;
                            bArr2 = bArr;
                            length = length2;
                            length2 = length;
                            bigDecimal3.ind = (byte) (-bigDecimal3.ind);
                        }
                    }
                }
            }
        }
        bigDecimal3.mant = byteaddsub(bArr, length, bArr2, length2, i, false);
        return bigDecimal3.finish(mathContext, false);
    }

    public int compareTo(BigDecimal bigDecimal) {
        return compareTo(bigDecimal, plainMC);
    }

    public int compareTo(BigDecimal bigDecimal, MathContext mathContext) {
        if (mathContext.lostDigits) {
            checkdigits(bigDecimal, mathContext.digits);
        }
        if ((this.ind == bigDecimal.ind) && (this.exp == bigDecimal.exp)) {
            int length = this.mant.length;
            if (length < bigDecimal.mant.length) {
                return (byte) (-this.ind);
            }
            if (length > bigDecimal.mant.length) {
                return this.ind;
            }
            if ((length <= mathContext.digits) || (mathContext.digits == 0)) {
                int i = length;
                int i2 = 0;
                while (i > 0) {
                    if (this.mant[i2] < bigDecimal.mant[i2]) {
                        return (byte) (-this.ind);
                    }
                    if (this.mant[i2] > bigDecimal.mant[i2]) {
                        return this.ind;
                    }
                    i--;
                    i2++;
                }
                return 0;
            }
        } else if (this.ind < bigDecimal.ind) {
            return -1;
        } else {
            if (this.ind > bigDecimal.ind) {
                return 1;
            }
        }
        BigDecimal clone = clone(bigDecimal);
        clone.ind = (byte) (-clone.ind);
        return add(clone, mathContext).ind;
    }

    public BigDecimal plus(MathContext mathContext) {
        if (mathContext.lostDigits) {
            checkdigits(null, mathContext.digits);
        }
        if (mathContext.form == 0 && this.form == 0 && (this.mant.length <= mathContext.digits || mathContext.digits == 0)) {
            return this;
        }
        return clone(this).finish(mathContext, false);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.valueOf(toString()).doubleValue();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BigDecimal)) {
            return false;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        if (this.ind != bigDecimal.ind) {
            return false;
        }
        if (((this.mant.length == bigDecimal.mant.length) & (this.exp == bigDecimal.exp)) && (this.form == bigDecimal.form)) {
            int length = this.mant.length;
            int i = 0;
            while (length > 0) {
                if (this.mant[i] != bigDecimal.mant[i]) {
                    return false;
                }
                length--;
                i++;
            }
            return true;
        }
        char[] layout = layout();
        char[] layout2 = bigDecimal.layout();
        if (layout.length != layout2.length) {
            return false;
        }
        int length2 = layout.length;
        int i2 = 0;
        while (length2 > 0) {
            if (layout[i2] != layout2[i2]) {
                return false;
            }
            length2--;
            i2++;
        }
        return true;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.valueOf(toString()).floatValue();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return toString().hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return toBigInteger().intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return toBigInteger().longValue();
    }

    public int scale() {
        if (this.exp >= 0) {
            return 0;
        }
        return -this.exp;
    }

    public BigDecimal setScale(int i, int i2) {
        int i3;
        int scale = scale();
        if (scale == i && this.form == 0) {
            return this;
        }
        BigDecimal clone = clone(this);
        if (scale <= i) {
            if (scale == 0) {
                i3 = clone.exp + i;
            } else {
                i3 = i - scale;
            }
            clone.mant = extend(clone.mant, clone.mant.length + i3);
            clone.exp = -i;
        } else if (i < 0) {
            throw new ArithmeticException("Negative scale: " + i);
        } else {
            clone = clone.round(clone.mant.length - (scale - i), i2);
            if (clone.exp != (-i)) {
                clone.mant = extend(clone.mant, clone.mant.length + 1);
                clone.exp--;
            }
        }
        clone.form = 0;
        return clone;
    }

    public java.math.BigDecimal toBigDecimal() {
        return new java.math.BigDecimal(unscaledValue(), scale());
    }

    public BigInteger toBigInteger() {
        BigDecimal bigDecimal;
        if ((this.exp >= 0) && (this.form == 0)) {
            bigDecimal = this;
        } else if (this.exp >= 0) {
            bigDecimal = clone(this);
            bigDecimal.form = 0;
        } else if ((-this.exp) >= this.mant.length) {
            bigDecimal = ZERO;
        } else {
            bigDecimal = clone(this);
            int length = bigDecimal.mant.length + bigDecimal.exp;
            byte[] bArr = new byte[length];
            System.arraycopy(bigDecimal.mant, 0, bArr, 0, length);
            bigDecimal.mant = bArr;
            bigDecimal.form = 0;
            bigDecimal.exp = 0;
        }
        return new BigInteger(new String(bigDecimal.layout()));
    }

    @Override // java.lang.Object
    public String toString() {
        return new String(layout());
    }

    public BigInteger unscaledValue() {
        BigDecimal bigDecimal;
        if (this.exp >= 0) {
            bigDecimal = this;
        } else {
            bigDecimal = clone(this);
            bigDecimal.exp = 0;
        }
        return bigDecimal.toBigInteger();
    }

    public static BigDecimal valueOf(long j) {
        return valueOf(j, 0);
    }

    public static BigDecimal valueOf(long j, int i) {
        BigDecimal bigDecimal;
        if (j == 0) {
            bigDecimal = ZERO;
        } else if (j == 1) {
            bigDecimal = ONE;
        } else if (j == 10) {
            bigDecimal = TEN;
        } else {
            bigDecimal = new BigDecimal(j);
        }
        if (i == 0) {
            return bigDecimal;
        }
        if (i < 0) {
            throw new NumberFormatException("Negative scale: " + i);
        }
        BigDecimal clone = clone(bigDecimal);
        clone.exp = -i;
        return clone;
    }

    private char[] layout() {
        char c;
        char[] cArr = new char[this.mant.length];
        int length = this.mant.length;
        int i = 0;
        while (length > 0) {
            cArr[i] = (char) (this.mant[i] + 48);
            length--;
            i++;
        }
        if (this.form != 0) {
            StringBuilder sb = new StringBuilder(cArr.length + 15);
            if (this.ind == -1) {
                sb.append('-');
            }
            int length2 = (this.exp + cArr.length) - 1;
            if (this.form == 1) {
                sb.append(cArr[0]);
                if (cArr.length > 1) {
                    sb.append('.').append(cArr, 1, cArr.length - 1);
                }
            } else {
                int i2 = length2 % 3;
                if (i2 < 0) {
                    i2 += 3;
                }
                length2 -= i2;
                int i3 = i2 + 1;
                if (i3 >= cArr.length) {
                    sb.append(cArr, 0, cArr.length);
                    for (int length3 = i3 - cArr.length; length3 > 0; length3--) {
                        sb.append('0');
                    }
                } else {
                    sb.append(cArr, 0, i3).append('.').append(cArr, i3, cArr.length - i3);
                }
            }
            if (length2 != 0) {
                if (length2 < 0) {
                    c = '-';
                    length2 = -length2;
                } else {
                    c = '+';
                }
                sb.append('E').append(c).append(length2);
            }
            char[] cArr2 = new char[sb.length()];
            int length4 = sb.length();
            if (0 != length4) {
                sb.getChars(0, length4, cArr2, 0);
            }
            return cArr2;
        } else if (this.exp != 0) {
            int i4 = this.ind == -1 ? 1 : 0;
            int length5 = this.exp + cArr.length;
            if (length5 < 1) {
                char[] cArr3 = new char[((i4 + 2) - this.exp)];
                if (i4 != 0) {
                    cArr3[0] = '-';
                }
                cArr3[i4] = '0';
                cArr3[i4 + 1] = '.';
                int i5 = -length5;
                int i6 = i4 + 2;
                while (i5 > 0) {
                    cArr3[i6] = '0';
                    i5--;
                    i6++;
                }
                System.arraycopy(cArr, 0, cArr3, (i4 + 2) - length5, cArr.length);
                return cArr3;
            } else if (length5 > cArr.length) {
                char[] cArr4 = new char[(i4 + length5)];
                if (i4 != 0) {
                    cArr4[0] = '-';
                }
                System.arraycopy(cArr, 0, cArr4, i4, cArr.length);
                int length6 = length5 - cArr.length;
                int length7 = i4 + cArr.length;
                while (length6 > 0) {
                    cArr4[length7] = '0';
                    length6--;
                    length7++;
                }
                return cArr4;
            } else {
                char[] cArr5 = new char[(i4 + 1 + cArr.length)];
                if (i4 != 0) {
                    cArr5[0] = '-';
                }
                System.arraycopy(cArr, 0, cArr5, i4, length5);
                cArr5[i4 + length5] = '.';
                System.arraycopy(cArr, length5, cArr5, i4 + length5 + 1, cArr.length - length5);
                return cArr5;
            }
        } else if (this.ind >= 0) {
            return cArr;
        } else {
            char[] cArr6 = new char[(cArr.length + 1)];
            cArr6[0] = '-';
            System.arraycopy(cArr, 0, cArr6, 1, cArr.length);
            return cArr6;
        }
    }

    private void bad(char[] cArr) {
        throw new NumberFormatException("Not a number: " + String.valueOf(cArr));
    }

    private static final byte[] extend(byte[] bArr, int i) {
        if (bArr.length == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x0069 */
    private static final byte[] byteaddsub(byte[] bArr, int i, byte[] bArr2, int i2, int i3, boolean z) {
        byte b;
        int length = bArr.length;
        int length2 = bArr2.length;
        int i4 = i - 1;
        int i5 = i2 - 1;
        int i6 = i5;
        if (i6 < i4) {
            i6 = i4;
        }
        byte[] bArr3 = null;
        if (z && i6 + 1 == length) {
            bArr3 = bArr;
        }
        if (bArr3 == null) {
            bArr3 = new byte[(i6 + 1)];
        }
        boolean z2 = false;
        if (i3 == 1) {
            z2 = true;
        } else if (i3 == -1) {
            z2 = true;
        }
        int i7 = 0;
        int i8 = i6;
        while (i8 >= 0) {
            if (i4 >= 0) {
                if (i4 < length) {
                    i7 += bArr[i4];
                }
                i4--;
            }
            if (i5 >= 0) {
                if (i5 < length2) {
                    if (!z2) {
                        i7 += bArr2[i5] * i3;
                    } else if (i3 > 0) {
                        i7 += bArr2[i5];
                    } else {
                        i7 -= bArr2[i5];
                    }
                }
                i5--;
            }
            if (i7 >= 10 || i7 < 0) {
                int i9 = i7 + 90;
                bArr3[i8] = bytedig[i9];
                b = bytecar[i9];
            } else {
                bArr3[i8] = (byte) i7;
                b = 0;
            }
            i8--;
            i7 = b;
        }
        if (i7 == 0) {
            return bArr3;
        }
        byte[] bArr4 = null;
        if (z && i6 + 2 == bArr.length) {
            bArr4 = bArr;
        }
        if (bArr4 == null) {
            bArr4 = new byte[(i6 + 2)];
        }
        bArr4[0] = (byte) i7;
        if (i6 < 10) {
            int i10 = i6 + 1;
            int i11 = 0;
            while (i10 > 0) {
                bArr4[i11 + 1] = bArr3[i11];
                i10--;
                i11++;
            }
        } else {
            System.arraycopy(bArr3, 0, bArr4, 1, i6 + 1);
        }
        return bArr4;
    }

    private static final byte[] diginit() {
        byte[] bArr = new byte[190];
        for (int i = 0; i <= 189; i++) {
            int i2 = i - 90;
            if (i2 >= 0) {
                bArr[i] = (byte) (i2 % 10);
                bytecar[i] = (byte) (i2 / 10);
            } else {
                int i3 = i2 + 100;
                bArr[i] = (byte) (i3 % 10);
                bytecar[i] = (byte) ((i3 / 10) - 10);
            }
        }
        return bArr;
    }

    private static final BigDecimal clone(BigDecimal bigDecimal) {
        BigDecimal bigDecimal2 = new BigDecimal();
        bigDecimal2.ind = bigDecimal.ind;
        bigDecimal2.exp = bigDecimal.exp;
        bigDecimal2.form = bigDecimal.form;
        bigDecimal2.mant = bigDecimal.mant;
        return bigDecimal2;
    }

    private void checkdigits(BigDecimal bigDecimal, int i) {
        if (i != 0) {
            if (this.mant.length > i && !allzero(this.mant, i)) {
                throw new ArithmeticException("Too many digits: " + toString());
            } else if (bigDecimal != null && bigDecimal.mant.length > i && !allzero(bigDecimal.mant, i)) {
                throw new ArithmeticException("Too many digits: " + bigDecimal.toString());
            }
        }
    }

    private BigDecimal round(MathContext mathContext) {
        return round(mathContext.digits, mathContext.roundingMode);
    }

    private BigDecimal round(int i, int i2) {
        byte b;
        boolean z;
        int length = this.mant.length - i;
        if (length <= 0) {
            return this;
        }
        this.exp += length;
        byte b2 = this.ind;
        byte[] bArr = this.mant;
        if (i > 0) {
            this.mant = new byte[i];
            System.arraycopy(bArr, 0, this.mant, 0, i);
            z = true;
            b = bArr[i];
        } else {
            this.mant = ZERO.mant;
            this.ind = 0;
            z = false;
            if (i == 0) {
                b = bArr[0];
            } else {
                b = 0;
            }
        }
        int i3 = 0;
        if (i2 == 4) {
            if (b >= 5) {
                i3 = b2;
            }
        } else if (i2 == 7) {
            if (!allzero(bArr, i)) {
                throw new ArithmeticException("Rounding necessary");
            }
        } else if (i2 == 5) {
            if (b > 5) {
                i3 = b2;
            } else if (b == 5 && !allzero(bArr, i + 1)) {
                i3 = b2;
            }
        } else if (i2 == 6) {
            if (b > 5) {
                i3 = b2;
            } else if (b == 5) {
                if (!allzero(bArr, i + 1)) {
                    i3 = b2;
                } else if (this.mant[this.mant.length - 1] % 2 != 0) {
                    i3 = b2;
                }
            }
        } else if (i2 != 1) {
            if (i2 == 0) {
                if (!allzero(bArr, i)) {
                    i3 = b2;
                }
            } else if (i2 == 2) {
                if (b2 > 0 && !allzero(bArr, i)) {
                    i3 = b2;
                }
            } else if (i2 != 3) {
                throw new IllegalArgumentException("Bad round value: " + i2);
            } else if (b2 < 0 && !allzero(bArr, i)) {
                i3 = b2;
            }
        }
        if (i3 != 0) {
            if (this.ind == 0) {
                this.mant = ONE.mant;
                this.ind = (byte) i3;
            } else {
                if (this.ind == -1) {
                    i3 = -i3;
                }
                byte[] byteaddsub = byteaddsub(this.mant, this.mant.length, ONE.mant, 1, i3, z);
                if (byteaddsub.length > this.mant.length) {
                    this.exp++;
                    System.arraycopy(byteaddsub, 0, this.mant, 0, this.mant.length);
                } else {
                    this.mant = byteaddsub;
                }
            }
        }
        if (this.exp <= 999999999) {
            return this;
        }
        throw new ArithmeticException("Exponent Overflow: " + this.exp);
    }

    private static final boolean allzero(byte[] bArr, int i) {
        if (i < 0) {
            i = 0;
        }
        int length = bArr.length - 1;
        for (int i2 = i; i2 <= length; i2++) {
            if (bArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b5, code lost:
        if (r6 <= 999999999) goto L_0x00d1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ibm.icu.math.BigDecimal finish(com.ibm.icu.math.MathContext r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.math.BigDecimal.finish(com.ibm.icu.math.MathContext, boolean):com.ibm.icu.math.BigDecimal");
    }
}
