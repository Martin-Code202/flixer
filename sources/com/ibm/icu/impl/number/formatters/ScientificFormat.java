package com.ibm.icu.impl.number.formatters;

import com.ibm.icu.impl.number.Format;
import com.ibm.icu.impl.number.FormatQuantity;
import com.ibm.icu.impl.number.FormatQuantityBCD;
import com.ibm.icu.impl.number.FormatQuantitySelector;
import com.ibm.icu.impl.number.ModifierHolder;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.impl.number.Rounder;
import com.ibm.icu.impl.number.formatters.CurrencyFormat;
import com.ibm.icu.impl.number.modifiers.ConstantAffixModifier;
import com.ibm.icu.impl.number.modifiers.PositiveNegativeAffixModifier;
import com.ibm.icu.impl.number.rounders.IncrementRounder;
import com.ibm.icu.impl.number.rounders.SignificantDigitsRounder;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.NumberFormat;
public class ScientificFormat extends Format.BeforeFormat implements Rounder.MultiplierGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = (!ScientificFormat.class.desiredAssertionStatus());
    private static final ThreadLocal<Properties> threadLocalProperties = new ThreadLocal<Properties>() { // from class: com.ibm.icu.impl.number.formatters.ScientificFormat.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Properties initialValue() {
            return new Properties();
        }
    };
    private static final ThreadLocal<StringBuilder> threadLocalStringBuilder = new ThreadLocal<StringBuilder>() { // from class: com.ibm.icu.impl.number.formatters.ScientificFormat.2
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };
    private final String[] digitStrings;
    private final int exponentDigits;
    private final boolean exponentShowPlusSign;
    private final int interval;
    private final int maxInt;
    private final int minInt;
    private final Rounder rounder;
    private final ConstantAffixModifier separatorMod;
    private final PositiveNegativeAffixModifier signMod;

    public interface IProperties extends CurrencyFormat.IProperties {
        boolean getExponentSignAlwaysShown();

        int getMinimumExponentDigits();
    }

    public static boolean useScientificNotation(IProperties iProperties) {
        return iProperties.getMinimumExponentDigits() != -1;
    }

    public static ScientificFormat getInstance(DecimalFormatSymbols decimalFormatSymbols, IProperties iProperties) {
        Rounder rounder2;
        if (IncrementRounder.useRoundingIncrement(iProperties)) {
            rounder2 = IncrementRounder.getInstance(iProperties);
        } else if (SignificantDigitsRounder.useSignificantDigits(iProperties)) {
            rounder2 = SignificantDigitsRounder.getInstance(iProperties);
        } else {
            Properties clear = threadLocalProperties.get().clear();
            int minimumIntegerDigits = iProperties.getMinimumIntegerDigits();
            int maximumIntegerDigits = iProperties.getMaximumIntegerDigits();
            int minimumFractionDigits = iProperties.getMinimumFractionDigits();
            int maximumFractionDigits = iProperties.getMaximumFractionDigits();
            if (CurrencyFormat.useCurrency(iProperties)) {
                CurrencyFormat.populateCurrencyRounderProperties(clear, decimalFormatSymbols, iProperties);
                minimumFractionDigits = clear.getMinimumFractionDigits();
                maximumFractionDigits = clear.getMaximumFractionDigits();
                clear.clear();
            }
            if (minimumIntegerDigits < 0) {
                minimumIntegerDigits = 0;
            }
            if (maximumIntegerDigits < minimumIntegerDigits) {
                maximumIntegerDigits = minimumIntegerDigits;
            }
            if (minimumFractionDigits < 0) {
                minimumFractionDigits = 0;
            }
            if (maximumFractionDigits < minimumFractionDigits) {
                maximumFractionDigits = minimumFractionDigits;
            }
            clear.setRoundingMode(iProperties.getRoundingMode());
            if (minimumIntegerDigits == 0 && maximumFractionDigits == 0) {
                clear.setMinimumSignificantDigits(1);
                clear.setMaximumSignificantDigits(Integer.MAX_VALUE);
            } else if (minimumIntegerDigits == 0 && minimumFractionDigits == 0) {
                clear.setMinimumSignificantDigits(1);
                clear.setMaximumSignificantDigits(maximumFractionDigits + 1);
            } else {
                clear.setMinimumSignificantDigits(minimumIntegerDigits + minimumFractionDigits);
                clear.setMaximumSignificantDigits(minimumIntegerDigits + maximumFractionDigits);
            }
            clear.setMinimumIntegerDigits(maximumIntegerDigits == 0 ? 0 : Math.max(1, (minimumIntegerDigits + minimumFractionDigits) - maximumFractionDigits));
            clear.setMaximumIntegerDigits(maximumIntegerDigits);
            clear.setMinimumFractionDigits(Math.max(0, (minimumFractionDigits + minimumIntegerDigits) - maximumIntegerDigits));
            clear.setMaximumFractionDigits(maximumFractionDigits);
            rounder2 = SignificantDigitsRounder.getInstance(clear);
        }
        return new ScientificFormat(decimalFormatSymbols, iProperties, rounder2);
    }

    private ScientificFormat(DecimalFormatSymbols decimalFormatSymbols, IProperties iProperties, Rounder rounder2) {
        this.exponentShowPlusSign = iProperties.getExponentSignAlwaysShown();
        this.exponentDigits = Math.max(1, iProperties.getMinimumExponentDigits());
        int maximumIntegerDigits = iProperties.getMaximumIntegerDigits();
        int minimumIntegerDigits = iProperties.getMinimumIntegerDigits();
        this.minInt = minimumIntegerDigits < 0 ? 0 : minimumIntegerDigits >= 8 ? 1 : minimumIntegerDigits;
        this.maxInt = maximumIntegerDigits < minimumIntegerDigits ? minimumIntegerDigits : maximumIntegerDigits >= 8 ? minimumIntegerDigits : maximumIntegerDigits;
        if ($assertionsDisabled || (0 <= this.minInt && this.minInt <= this.maxInt && this.maxInt < 8)) {
            this.interval = this.maxInt < 1 ? 1 : this.maxInt;
            this.rounder = rounder2;
            this.digitStrings = decimalFormatSymbols.getDigitStrings();
            this.separatorMod = new ConstantAffixModifier("", decimalFormatSymbols.getExponentSeparator(), NumberFormat.Field.EXPONENT_SYMBOL, true);
            this.signMod = new PositiveNegativeAffixModifier(new ConstantAffixModifier("", this.exponentShowPlusSign ? decimalFormatSymbols.getPlusSignString() : "", NumberFormat.Field.EXPONENT_SIGN, true), new ConstantAffixModifier("", decimalFormatSymbols.getMinusSignString(), NumberFormat.Field.EXPONENT_SIGN, true));
            return;
        }
        throw new AssertionError();
    }

    @Override // com.ibm.icu.impl.number.Format.BeforeFormat
    public void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder) {
        int i;
        if (formatQuantity.isZero()) {
            this.rounder.apply(formatQuantity);
            i = 0;
        } else {
            i = -this.rounder.chooseMultiplierAndApply(formatQuantity, this);
        }
        FormatQuantityBCD from = FormatQuantitySelector.from(i);
        StringBuilder sb = threadLocalStringBuilder.get();
        sb.setLength(0);
        from.setIntegerFractionLength(this.exponentDigits, Integer.MAX_VALUE, 0, 0);
        for (int upperDisplayMagnitude = from.getUpperDisplayMagnitude(); upperDisplayMagnitude >= 0; upperDisplayMagnitude--) {
            sb.append(this.digitStrings[from.getDigit(upperDisplayMagnitude)]);
        }
        modifierHolder.add(new ConstantAffixModifier("", sb.toString(), NumberFormat.Field.EXPONENT, true));
        modifierHolder.add(this.signMod.getModifier(i < 0));
        modifierHolder.add(this.separatorMod);
    }

    @Override // com.ibm.icu.impl.number.Rounder.MultiplierGenerator
    public int getMultiplier(int i) {
        int i2 = (((i % this.interval) + this.interval) % this.interval) + 1;
        if (i2 < this.minInt) {
            i2 = this.minInt;
        } else if (i2 > this.maxInt) {
            i2 = this.maxInt;
        }
        return (i2 - i) - 1;
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        properties.setMinimumExponentDigits(this.exponentDigits);
        properties.setExponentSignAlwaysShown(this.exponentShowPlusSign);
        this.rounder.export(properties);
    }
}
