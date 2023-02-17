package com.ibm.icu.impl.number;

import com.ibm.icu.impl.number.Format;
import java.math.MathContext;
import java.math.RoundingMode;
public abstract class Rounder extends Format.BeforeFormat {
    static final /* synthetic */ boolean $assertionsDisabled = (!Rounder.class.desiredAssertionStatus());
    protected final MathContext mathContext;
    protected final int maxFrac;
    protected final int maxInt;
    protected final int minFrac;
    protected final int minInt;

    public interface IBasicRoundingProperties {
        public static final MathContext DEFAULT_MATH_CONTEXT = null;
        public static final RoundingMode DEFAULT_ROUNDING_MODE = null;

        MathContext getMathContext();

        int getMaximumFractionDigits();

        int getMaximumIntegerDigits();

        int getMinimumFractionDigits();

        int getMinimumIntegerDigits();

        RoundingMode getRoundingMode();
    }

    public interface MultiplierGenerator {
        int getMultiplier(int i);
    }

    public abstract void apply(FormatQuantity formatQuantity);

    protected Rounder(IBasicRoundingProperties iBasicRoundingProperties) {
        this.mathContext = RoundingUtils.getMathContextOrUnlimited(iBasicRoundingProperties);
        int maximumIntegerDigits = iBasicRoundingProperties.getMaximumIntegerDigits();
        int minimumIntegerDigits = iBasicRoundingProperties.getMinimumIntegerDigits();
        int maximumFractionDigits = iBasicRoundingProperties.getMaximumFractionDigits();
        int minimumFractionDigits = iBasicRoundingProperties.getMinimumFractionDigits();
        if (minimumIntegerDigits != 0 || maximumFractionDigits == 0) {
            this.minFrac = minimumFractionDigits < 0 ? 0 : minimumFractionDigits;
            this.maxFrac = maximumFractionDigits < 0 ? Integer.MAX_VALUE : maximumFractionDigits < this.minFrac ? this.minFrac : maximumFractionDigits;
            this.minInt = minimumIntegerDigits <= 0 ? 1 : minimumIntegerDigits;
            this.maxInt = maximumIntegerDigits < 0 ? Integer.MAX_VALUE : maximumIntegerDigits < this.minInt ? this.minInt : maximumIntegerDigits;
            return;
        }
        this.minFrac = minimumFractionDigits <= 0 ? 1 : minimumFractionDigits;
        this.maxFrac = maximumFractionDigits < 0 ? Integer.MAX_VALUE : maximumFractionDigits < this.minFrac ? this.minFrac : maximumFractionDigits;
        this.minInt = 0;
        this.maxInt = maximumIntegerDigits < 0 ? Integer.MAX_VALUE : maximumIntegerDigits;
    }

    public int chooseMultiplierAndApply(FormatQuantity formatQuantity, MultiplierGenerator multiplierGenerator) {
        FormatQuantity createCopy = formatQuantity.createCopy();
        int magnitude = formatQuantity.getMagnitude();
        int multiplier = multiplierGenerator.getMultiplier(magnitude);
        formatQuantity.adjustMagnitude(multiplier);
        apply(formatQuantity);
        if (formatQuantity.getMagnitude() == magnitude + multiplier + 1) {
            int i = magnitude + 1;
            formatQuantity.copyFrom(createCopy);
            multiplier = multiplierGenerator.getMultiplier(i);
            formatQuantity.adjustMagnitude(multiplier);
            if ($assertionsDisabled || formatQuantity.getMagnitude() == (i + multiplier) - 1) {
                apply(formatQuantity);
                if (!$assertionsDisabled && formatQuantity.getMagnitude() != i + multiplier) {
                    throw new AssertionError();
                }
            } else {
                throw new AssertionError();
            }
        }
        return multiplier;
    }

    /* access modifiers changed from: protected */
    public void applyDefaults(FormatQuantity formatQuantity) {
        formatQuantity.setIntegerFractionLength(this.minInt, this.maxInt, this.minFrac, this.maxFrac);
    }

    @Override // com.ibm.icu.impl.number.Format.BeforeFormat
    public void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder) {
        apply(formatQuantity);
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        properties.setMathContext(this.mathContext);
        properties.setRoundingMode(this.mathContext.getRoundingMode());
        properties.setMinimumFractionDigits(this.minFrac);
        properties.setMinimumIntegerDigits(this.minInt);
        properties.setMaximumFractionDigits(this.maxFrac);
        properties.setMaximumIntegerDigits(this.maxInt);
    }
}
