package com.ibm.icu.impl.number;

import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.text.UFieldPosition;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.FieldPosition;
public abstract class FormatQuantityBCD implements FormatQuantity {
    static final /* synthetic */ boolean $assertionsDisabled = (!FormatQuantityBCD.class.desiredAssertionStatus());
    private static final double[] DOUBLE_MULTIPLIERS = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d};
    @Deprecated
    public boolean explicitExactDouble = false;
    protected int flags;
    protected boolean isApproximate;
    protected int lOptPos = Integer.MAX_VALUE;
    protected int lReqPos = 0;
    protected int origDelta;
    protected double origDouble;
    protected int precision;
    protected int rOptPos = Integer.MIN_VALUE;
    protected int rReqPos = 0;
    protected int scale;

    /* access modifiers changed from: protected */
    public abstract BigDecimal bcdToBigDecimal();

    /* access modifiers changed from: protected */
    public abstract void compact();

    /* access modifiers changed from: protected */
    public abstract void copyBcdFrom(FormatQuantity formatQuantity);

    /* access modifiers changed from: protected */
    public abstract byte getDigitPos(int i);

    /* access modifiers changed from: protected */
    public abstract void readBigIntegerToBcd(BigInteger bigInteger);

    /* access modifiers changed from: protected */
    public abstract void readIntToBcd(int i);

    /* access modifiers changed from: protected */
    public abstract void readLongToBcd(long j);

    /* access modifiers changed from: protected */
    public abstract void setBcdToZero();

    /* access modifiers changed from: protected */
    public abstract void setDigitPos(int i, byte b);

    /* access modifiers changed from: protected */
    public abstract void shiftLeft(int i);

    /* access modifiers changed from: protected */
    public abstract void shiftRight(int i);

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public void copyFrom(FormatQuantity formatQuantity) {
        copyBcdFrom(formatQuantity);
        FormatQuantityBCD formatQuantityBCD = (FormatQuantityBCD) formatQuantity;
        this.lOptPos = formatQuantityBCD.lOptPos;
        this.lReqPos = formatQuantityBCD.lReqPos;
        this.rReqPos = formatQuantityBCD.rReqPos;
        this.rOptPos = formatQuantityBCD.rOptPos;
        this.scale = formatQuantityBCD.scale;
        this.precision = formatQuantityBCD.precision;
        this.flags = formatQuantityBCD.flags;
        this.origDouble = formatQuantityBCD.origDouble;
        this.origDelta = formatQuantityBCD.origDelta;
        this.isApproximate = formatQuantityBCD.isApproximate;
    }

    public FormatQuantityBCD clear() {
        this.lOptPos = Integer.MAX_VALUE;
        this.lReqPos = 0;
        this.rReqPos = 0;
        this.rOptPos = Integer.MIN_VALUE;
        this.flags = 0;
        setBcdToZero();
        return this;
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public void setIntegerFractionLength(int i, int i2, int i3, int i4) {
        if (!$assertionsDisabled && i < 0) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && i2 < i) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && i3 < 0) {
            throw new AssertionError();
        } else if ($assertionsDisabled || i4 >= i3) {
            this.lOptPos = i2;
            this.lReqPos = i;
            this.rReqPos = -i3;
            this.rOptPos = -i4;
        } else {
            throw new AssertionError();
        }
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public void roundToIncrement(BigDecimal bigDecimal, MathContext mathContext) {
        BigDecimal round = toBigDecimal().divide(bigDecimal, 0, mathContext.getRoundingMode()).multiply(bigDecimal).round(mathContext);
        if (round.signum() == 0) {
            setBcdToZero();
        } else {
            setToBigDecimal(round);
        }
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public void multiplyBy(BigDecimal bigDecimal) {
        setToBigDecimal(toBigDecimal().multiply(bigDecimal));
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public int getMagnitude() {
        if (this.precision != 0) {
            return (this.scale + this.precision) - 1;
        }
        throw new ArithmeticException("Magnitude is not well-defined for zero");
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public void adjustMagnitude(int i) {
        if (this.precision != 0) {
            this.scale += i;
            this.origDelta += i;
        }
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public StandardPlural getStandardPlural(PluralRules pluralRules) {
        if (pluralRules == null) {
            return StandardPlural.OTHER;
        }
        return StandardPlural.orOtherFromString(pluralRules.select(this));
    }

    @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
    public double getPluralOperand(PluralRules.Operand operand) {
        if ($assertionsDisabled || !this.isApproximate) {
            switch (operand) {
                case i:
                    return (double) toLong();
                case f:
                    return (double) toFractionLong(true);
                case t:
                    return (double) toFractionLong(false);
                case v:
                    return (double) fractionCount();
                case w:
                    return (double) fractionCountWithoutTrailingZeros();
                default:
                    return Math.abs(toDouble());
            }
        } else {
            throw new AssertionError();
        }
    }

    public void populateUFieldPosition(FieldPosition fieldPosition) {
        if (fieldPosition instanceof UFieldPosition) {
            ((UFieldPosition) fieldPosition).setFractionDigits((int) getPluralOperand(PluralRules.Operand.v), (long) getPluralOperand(PluralRules.Operand.f));
        }
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public int getUpperDisplayMagnitude() {
        if ($assertionsDisabled || !this.isApproximate) {
            int i = this.scale + this.precision;
            return (this.lReqPos > i ? this.lReqPos : this.lOptPos < i ? this.lOptPos : i) - 1;
        }
        throw new AssertionError();
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public int getLowerDisplayMagnitude() {
        if ($assertionsDisabled || !this.isApproximate) {
            int i = this.scale;
            if (this.rReqPos < i) {
                return this.rReqPos;
            }
            if (this.rOptPos > i) {
                return this.rOptPos;
            }
            return i;
        }
        throw new AssertionError();
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public byte getDigit(int i) {
        if ($assertionsDisabled || !this.isApproximate) {
            return getDigitPos(i - this.scale);
        }
        throw new AssertionError();
    }

    private int fractionCount() {
        return -getLowerDisplayMagnitude();
    }

    private int fractionCountWithoutTrailingZeros() {
        return Math.max(-this.scale, 0);
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public boolean isNegative() {
        return (this.flags & 1) != 0;
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity, com.ibm.icu.text.PluralRules.IFixedDecimal
    public boolean isInfinite() {
        return (this.flags & 2) != 0;
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity, com.ibm.icu.text.PluralRules.IFixedDecimal
    public boolean isNaN() {
        return (this.flags & 4) != 0;
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public boolean isZero() {
        return this.precision == 0;
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public FormatQuantity createCopy() {
        if (this instanceof FormatQuantity2) {
            return new FormatQuantity2((FormatQuantity2) this);
        }
        if (this instanceof FormatQuantity3) {
            return new FormatQuantity3((FormatQuantity3) this);
        }
        if (this instanceof FormatQuantity4) {
            return new FormatQuantity4((FormatQuantity4) this);
        }
        throw new IllegalArgumentException("Don't know how to copy " + getClass());
    }

    public void setToInt(int i) {
        setBcdToZero();
        this.flags = 0;
        if (i < 0) {
            this.flags |= 1;
            i = -i;
        }
        if (i != 0) {
            _setToInt(i);
            compact();
        }
    }

    private void _setToInt(int i) {
        if (i == Integer.MIN_VALUE) {
            readLongToBcd(-((long) i));
        } else {
            readIntToBcd(i);
        }
    }

    public void setToLong(long j) {
        setBcdToZero();
        this.flags = 0;
        if (j < 0) {
            this.flags |= 1;
            j = -j;
        }
        if (j != 0) {
            _setToLong(j);
            compact();
        }
    }

    private void _setToLong(long j) {
        if (j == Long.MIN_VALUE) {
            readBigIntegerToBcd(BigInteger.valueOf(j).negate());
        } else if (j <= 2147483647L) {
            readIntToBcd((int) j);
        } else {
            readLongToBcd(j);
        }
    }

    public void setToBigInteger(BigInteger bigInteger) {
        setBcdToZero();
        this.flags = 0;
        if (bigInteger.signum() == -1) {
            this.flags |= 1;
            bigInteger = bigInteger.negate();
        }
        if (bigInteger.signum() != 0) {
            _setToBigInteger(bigInteger);
            compact();
        }
    }

    private void _setToBigInteger(BigInteger bigInteger) {
        if (bigInteger.bitLength() < 32) {
            readIntToBcd(bigInteger.intValue());
        } else if (bigInteger.bitLength() < 64) {
            readLongToBcd(bigInteger.longValue());
        } else {
            readBigIntegerToBcd(bigInteger);
        }
    }

    public void setToDouble(double d) {
        setBcdToZero();
        this.flags = 0;
        if (Double.compare(d, 0.0d) < 0) {
            this.flags |= 1;
            d = -d;
        }
        if (Double.isNaN(d)) {
            this.flags |= 4;
        } else if (Double.isInfinite(d)) {
            this.flags |= 2;
        } else if (d != 0.0d) {
            _setToDoubleFast(d);
            compact();
        }
    }

    private void _setToDoubleFast(double d) {
        double d2;
        int doubleToLongBits = ((int) ((9218868437227405312L & Double.doubleToLongBits(d)) >> 52)) - 1023;
        if (doubleToLongBits > 52 || ((double) ((long) d)) != d) {
            this.isApproximate = true;
            this.origDouble = d;
            this.origDelta = 0;
            int i = (int) (((double) (52 - doubleToLongBits)) / 3.32192809489d);
            if (i >= 0) {
                int i2 = i;
                while (i2 >= 22) {
                    d *= 1.0E22d;
                    i2 -= 22;
                }
                d2 = d * DOUBLE_MULTIPLIERS[i2];
            } else {
                int i3 = i;
                while (i3 <= -22) {
                    d /= 1.0E22d;
                    i3 += 22;
                }
                d2 = d / DOUBLE_MULTIPLIERS[-i3];
            }
            long round = Math.round(d2);
            if (round != 0) {
                _setToLong(round);
                this.scale -= i;
                return;
            }
            return;
        }
        _setToLong((long) d);
    }

    private void convertToAccurateDouble() {
        double d = this.origDouble;
        if ($assertionsDisabled || d != 0.0d) {
            int i = this.origDelta;
            setBcdToZero();
            String d2 = Double.toString(d);
            if (d2.indexOf(69) != -1) {
                if ($assertionsDisabled || d2.indexOf(46) == 1) {
                    int indexOf = d2.indexOf(69);
                    _setToLong(Long.parseLong(d2.charAt(0) + d2.substring(2, indexOf)));
                    this.scale += (Integer.parseInt(d2.substring(indexOf + 1)) - (indexOf - 1)) + 1;
                } else {
                    throw new AssertionError();
                }
            } else if (d2.charAt(0) == '0') {
                if ($assertionsDisabled || d2.indexOf(46) == 1) {
                    _setToLong(Long.parseLong(d2.substring(2)));
                    this.scale += 2 - d2.length();
                } else {
                    throw new AssertionError();
                }
            } else if (d2.charAt(d2.length() - 1) != '0') {
                int indexOf2 = d2.indexOf(46);
                _setToLong(Long.parseLong(d2.substring(0, indexOf2) + d2.substring(indexOf2 + 1)));
                this.scale += (indexOf2 - d2.length()) + 1;
            } else if (!$assertionsDisabled && d2.indexOf(46) != d2.length() - 2) {
                throw new AssertionError();
            } else if ($assertionsDisabled || d2.length() - 2 <= 18) {
                _setToLong(Long.parseLong(d2.substring(0, d2.length() - 2)));
            } else {
                throw new AssertionError();
            }
            this.scale += i;
            compact();
            this.explicitExactDouble = true;
            return;
        }
        throw new AssertionError();
    }

    public void setToBigDecimal(BigDecimal bigDecimal) {
        setBcdToZero();
        this.flags = 0;
        if (bigDecimal.signum() == -1) {
            this.flags |= 1;
            bigDecimal = bigDecimal.negate();
        }
        if (bigDecimal.signum() != 0) {
            _setToBigDecimal(bigDecimal);
            compact();
        }
    }

    private void _setToBigDecimal(BigDecimal bigDecimal) {
        int scale2 = bigDecimal.scale();
        _setToBigInteger(bigDecimal.scaleByPowerOfTen(scale2).toBigInteger());
        this.scale -= scale2;
    }

    /* access modifiers changed from: protected */
    public long toLong() {
        long j = 0;
        for (int i = (this.scale + this.precision) - 1; i >= 0; i--) {
            j = (10 * j) + ((long) getDigitPos(i - this.scale));
        }
        return j;
    }

    /* access modifiers changed from: protected */
    public long toFractionLong(boolean z) {
        long j = 0;
        int i = -1;
        while (true) {
            if ((i >= this.scale || (z && i >= this.rReqPos)) && i >= this.rOptPos) {
                j = (10 * j) + ((long) getDigitPos(i - this.scale));
                i--;
            }
        }
        return j;
    }

    public double toDouble() {
        double d;
        if (this.isApproximate) {
            return toDoubleFromOriginal();
        }
        if (isNaN()) {
            return Double.NaN;
        }
        if (isInfinite()) {
            return isNegative() ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        long j = 0;
        int min = this.precision - Math.min(this.precision, 17);
        for (int i = this.precision - 1; i >= min; i--) {
            j = (10 * j) + ((long) getDigitPos(i));
        }
        double d2 = (double) j;
        int i2 = this.scale + min;
        if (i2 >= 0) {
            int i3 = i2;
            while (i3 >= 22) {
                d2 *= 1.0E22d;
                i3 -= 22;
            }
            d = d2 * DOUBLE_MULTIPLIERS[i3];
        } else {
            int i4 = i2;
            while (i4 <= -22) {
                d2 /= 1.0E22d;
                i4 += 22;
            }
            d = d2 / DOUBLE_MULTIPLIERS[-i4];
        }
        if (isNegative()) {
            return -d;
        }
        return d;
    }

    public BigDecimal toBigDecimal() {
        if (this.isApproximate) {
            convertToAccurateDouble();
        }
        return bcdToBigDecimal();
    }

    /* access modifiers changed from: protected */
    public double toDoubleFromOriginal() {
        double d;
        double d2 = this.origDouble;
        int i = this.origDelta;
        if (i >= 0) {
            while (i >= 22) {
                d2 *= 1.0E22d;
                i -= 22;
            }
            d = d2 * DOUBLE_MULTIPLIERS[i];
        } else {
            while (i <= -22) {
                d2 /= 1.0E22d;
                i += 22;
            }
            d = d2 / DOUBLE_MULTIPLIERS[-i];
        }
        if (isNegative()) {
            return d * -1.0d;
        }
        return d;
    }

    private static int safeSubtract(int i, int i2) {
        int i3 = i - i2;
        if (i2 < 0 && i3 < i) {
            return Integer.MAX_VALUE;
        }
        if (i2 <= 0 || i3 <= i) {
            return i3;
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public void roundToMagnitude(int i, MathContext mathContext) {
        int safeSubtract = safeSubtract(i, this.scale);
        int precision2 = mathContext.getPrecision();
        if (i == Integer.MAX_VALUE || (precision2 > 0 && this.precision - safeSubtract > precision2)) {
            safeSubtract = this.precision - precision2;
        }
        if ((safeSubtract > 0 || this.isApproximate) && this.precision != 0) {
            byte digitPos = getDigitPos(safeSubtract(safeSubtract, 1));
            byte digitPos2 = getDigitPos(safeSubtract);
            int i2 = 2;
            if (this.isApproximate) {
                int safeSubtract2 = safeSubtract(safeSubtract, 2);
                int max = Math.max(0, this.precision - 14);
                if (digitPos == 0) {
                    i2 = -1;
                    while (true) {
                        if (safeSubtract2 < max) {
                            break;
                        } else if (getDigitPos(safeSubtract2) != 0) {
                            i2 = 1;
                            break;
                        } else {
                            safeSubtract2--;
                        }
                    }
                } else if (digitPos == 4) {
                    while (true) {
                        if (safeSubtract2 < max) {
                            break;
                        } else if (getDigitPos(safeSubtract2) != 9) {
                            i2 = 1;
                            break;
                        } else {
                            safeSubtract2--;
                        }
                    }
                } else if (digitPos == 5) {
                    while (true) {
                        if (safeSubtract2 < max) {
                            break;
                        } else if (getDigitPos(safeSubtract2) != 0) {
                            i2 = 3;
                            break;
                        } else {
                            safeSubtract2--;
                        }
                    }
                } else if (digitPos == 9) {
                    i2 = -2;
                    while (true) {
                        if (safeSubtract2 < max) {
                            break;
                        } else if (getDigitPos(safeSubtract2) != 9) {
                            i2 = 3;
                            break;
                        } else {
                            safeSubtract2--;
                        }
                    }
                } else {
                    i2 = digitPos < 5 ? 1 : 3;
                }
                boolean roundsAtMidpoint = RoundingUtils.roundsAtMidpoint(mathContext.getRoundingMode().ordinal());
                if (safeSubtract(safeSubtract, 1) < this.precision - 14 || ((roundsAtMidpoint && i2 == 2) || (!roundsAtMidpoint && i2 < 0))) {
                    convertToAccurateDouble();
                    roundToMagnitude(i, mathContext);
                    return;
                }
                this.isApproximate = false;
                this.origDouble = 0.0d;
                this.origDelta = 0;
                if (safeSubtract > 0) {
                    if (i2 == -1) {
                        i2 = 1;
                    }
                    if (i2 == -2) {
                        i2 = 3;
                    }
                } else {
                    return;
                }
            } else if (digitPos < 5) {
                i2 = 1;
            } else if (digitPos > 5) {
                i2 = 3;
            } else {
                int safeSubtract3 = safeSubtract(safeSubtract, 2);
                while (true) {
                    if (safeSubtract3 < 0) {
                        break;
                    } else if (getDigitPos(safeSubtract3) != 0) {
                        i2 = 3;
                        break;
                    } else {
                        safeSubtract3--;
                    }
                }
            }
            boolean roundingDirection = RoundingUtils.getRoundingDirection(digitPos2 % 2 == 0, isNegative(), i2, mathContext.getRoundingMode().ordinal(), this);
            if (safeSubtract >= this.precision) {
                setBcdToZero();
                this.scale = i;
            } else {
                shiftRight(safeSubtract);
            }
            if (!roundingDirection) {
                if (digitPos2 == 9) {
                    int i3 = 0;
                    while (getDigitPos(i3) == 9) {
                        i3++;
                    }
                    shiftRight(i3);
                }
                byte digitPos3 = getDigitPos(0);
                if ($assertionsDisabled || digitPos3 != 9) {
                    setDigitPos(0, (byte) (digitPos3 + 1));
                    this.precision++;
                } else {
                    throw new AssertionError();
                }
            }
            compact();
        }
    }

    @Override // com.ibm.icu.impl.number.FormatQuantity
    public void roundToInfinity() {
        if (this.isApproximate) {
            convertToAccurateDouble();
        }
    }

    @Deprecated
    public void appendDigit(byte b, int i, boolean z) {
        if (!$assertionsDisabled && i < 0) {
            throw new AssertionError();
        } else if (b != 0) {
            if (this.scale > 0) {
                i += this.scale;
                if (z) {
                    this.scale = 0;
                }
            }
            shiftLeft(i + 1);
            setDigitPos(0, b);
            if (z) {
                this.scale += i + 1;
            }
        } else if (z && this.precision != 0) {
            this.scale += i + 1;
        }
    }
}
