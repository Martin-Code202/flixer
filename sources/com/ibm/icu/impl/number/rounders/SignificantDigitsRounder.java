package com.ibm.icu.impl.number.rounders;

import com.ibm.icu.impl.number.FormatQuantity;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.impl.number.Rounder;
import com.ibm.icu.text.DecimalFormat;
public class SignificantDigitsRounder extends Rounder {
    private final int maxSig;
    private final int minSig;
    private final DecimalFormat.SignificantDigitsMode mode;

    public interface IProperties extends Rounder.IBasicRoundingProperties {
        public static final DecimalFormat.SignificantDigitsMode DEFAULT_SIGNIFICANT_DIGITS_MODE = null;

        int getMaximumSignificantDigits();

        int getMinimumSignificantDigits();

        DecimalFormat.SignificantDigitsMode getSignificantDigitsMode();
    }

    public static boolean useSignificantDigits(IProperties iProperties) {
        return (iProperties.getMinimumSignificantDigits() == -1 && iProperties.getMaximumSignificantDigits() == -1 && iProperties.getSignificantDigitsMode() == IProperties.DEFAULT_SIGNIFICANT_DIGITS_MODE) ? false : true;
    }

    public static SignificantDigitsRounder getInstance(IProperties iProperties) {
        return new SignificantDigitsRounder(iProperties);
    }

    private SignificantDigitsRounder(IProperties iProperties) {
        super(iProperties);
        int minimumSignificantDigits = iProperties.getMinimumSignificantDigits();
        int maximumSignificantDigits = iProperties.getMaximumSignificantDigits();
        this.minSig = minimumSignificantDigits < 1 ? 1 : minimumSignificantDigits > 1000 ? 1000 : minimumSignificantDigits;
        this.maxSig = maximumSignificantDigits < 0 ? 1000 : maximumSignificantDigits < this.minSig ? this.minSig : maximumSignificantDigits > 1000 ? 1000 : maximumSignificantDigits;
        DecimalFormat.SignificantDigitsMode significantDigitsMode = iProperties.getSignificantDigitsMode();
        this.mode = significantDigitsMode == null ? DecimalFormat.SignificantDigitsMode.OVERRIDE_MAXIMUM_FRACTION : significantDigitsMode;
    }

    @Override // com.ibm.icu.impl.number.Rounder
    public void apply(FormatQuantity formatQuantity) {
        int i;
        int i2;
        int i3;
        if (formatQuantity.isZero()) {
            i = this.minInt - 1;
        } else {
            i = formatQuantity.getMagnitude();
        }
        int min = Math.min(i + 1, this.maxInt);
        int i4 = min - this.minSig;
        int i5 = min - this.maxSig;
        switch (this.mode) {
            case OVERRIDE_MAXIMUM_FRACTION:
                i2 = i5;
                break;
            case RESPECT_MAXIMUM_FRACTION:
                i2 = Math.max(-this.maxFrac, i5);
                break;
            case ENSURE_MINIMUM_SIGNIFICANT:
                i2 = Math.min(i4, Math.max(-this.maxFrac, i5));
                break;
            default:
                throw new AssertionError();
        }
        formatQuantity.roundToMagnitude(i2, this.mathContext);
        if (formatQuantity.isZero()) {
            i3 = this.minInt - 1;
        } else {
            i3 = formatQuantity.getMagnitude();
        }
        int min2 = Math.min(i3 + 1, this.maxInt);
        int i6 = min2 - this.minSig;
        int i7 = min2 - this.maxSig;
        switch (this.mode) {
            case OVERRIDE_MAXIMUM_FRACTION:
                formatQuantity.setIntegerFractionLength(this.minInt, this.maxInt, Math.max(this.minFrac, -i6), Integer.MAX_VALUE);
                return;
            case RESPECT_MAXIMUM_FRACTION:
                formatQuantity.setIntegerFractionLength(this.minInt, this.maxInt, Math.min(this.maxFrac, Math.max(this.minFrac, -i6)), this.maxFrac);
                return;
            case ENSURE_MINIMUM_SIGNIFICANT:
                formatQuantity.setIntegerFractionLength(this.minInt, this.maxInt, this.minFrac, Integer.MAX_VALUE);
                return;
            default:
                return;
        }
    }

    @Override // com.ibm.icu.impl.number.Rounder, com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        super.export(properties);
        properties.setMinimumSignificantDigits(this.minSig);
        properties.setMaximumSignificantDigits(this.maxSig);
        properties.setSignificantDigitsMode(this.mode);
    }
}
