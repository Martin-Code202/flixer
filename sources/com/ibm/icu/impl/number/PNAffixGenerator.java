package com.ibm.icu.impl.number;

import com.ibm.icu.impl.number.Modifier;
import com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat;
import com.ibm.icu.impl.number.modifiers.ConstantAffixModifier;
import com.ibm.icu.impl.number.modifiers.ConstantMultiFieldModifier;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.NumberFormat;
public class PNAffixGenerator {
    protected static final ThreadLocal<PNAffixGenerator> threadLocalInstance = new ThreadLocal<PNAffixGenerator>() { // from class: com.ibm.icu.impl.number.PNAffixGenerator.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public PNAffixGenerator initialValue() {
            return new PNAffixGenerator();
        }
    };
    private Result resultInstance = new Result();
    private NumberStringBuilder sb1 = new NumberStringBuilder();
    private NumberStringBuilder sb2 = new NumberStringBuilder();
    private NumberStringBuilder sb3 = new NumberStringBuilder();
    private NumberStringBuilder sb4 = new NumberStringBuilder();
    private NumberStringBuilder sb5 = new NumberStringBuilder();
    private NumberStringBuilder sb6 = new NumberStringBuilder();

    public static class Result {
        public Modifier.AffixModifier negative = null;
        public Modifier.AffixModifier positive = null;
    }

    public static PNAffixGenerator getThreadLocalInstance() {
        return threadLocalInstance.get();
    }

    public Result getModifiers(DecimalFormatSymbols decimalFormatSymbols, PositiveNegativeAffixFormat.IProperties iProperties) {
        return getModifiers(decimalFormatSymbols, decimalFormatSymbols.getCurrencySymbol(), decimalFormatSymbols.getInternationalCurrencySymbol(), decimalFormatSymbols.getCurrencySymbol(), iProperties);
    }

    public Result getModifiers(DecimalFormatSymbols decimalFormatSymbols, String str, PositiveNegativeAffixFormat.IProperties iProperties) {
        return getModifiers(decimalFormatSymbols, str, str, str, iProperties);
    }

    public Result getModifiers(DecimalFormatSymbols decimalFormatSymbols, String str, String str2, String str3, PositiveNegativeAffixFormat.IProperties iProperties) {
        if (iProperties.getSignAlwaysShown()) {
            return getModifiersWithPlusSign(decimalFormatSymbols, str, str2, str3, iProperties);
        }
        String positivePrefixPattern = iProperties.getPositivePrefixPattern();
        String positiveSuffixPattern = iProperties.getPositiveSuffixPattern();
        String negativePrefixPattern = iProperties.getNegativePrefixPattern();
        String negativeSuffixPattern = iProperties.getNegativeSuffixPattern();
        this.sb1.clear();
        this.sb2.clear();
        AffixPatternUtils.unescape(positivePrefixPattern, decimalFormatSymbols, str, str2, str3, null, this.sb1);
        AffixPatternUtils.unescape(positiveSuffixPattern, decimalFormatSymbols, str, str2, str3, null, this.sb2);
        setPositiveResult(this.sb1, this.sb2, iProperties);
        if (negativePrefixPattern == null && negativeSuffixPattern == null) {
            this.sb1.insert(0, decimalFormatSymbols.getMinusSignString(), NumberFormat.Field.SIGN);
        } else {
            this.sb1.clear();
            this.sb2.clear();
            AffixPatternUtils.unescape(negativePrefixPattern, decimalFormatSymbols, str, str2, str3, null, this.sb1);
            AffixPatternUtils.unescape(negativeSuffixPattern, decimalFormatSymbols, str, str2, str3, null, this.sb2);
        }
        setNegativeResult(this.sb1, this.sb2, iProperties);
        return this.resultInstance;
    }

    private Result getModifiersWithPlusSign(DecimalFormatSymbols decimalFormatSymbols, String str, String str2, String str3, PositiveNegativeAffixFormat.IProperties iProperties) {
        String positivePrefixPattern = iProperties.getPositivePrefixPattern();
        String positiveSuffixPattern = iProperties.getPositiveSuffixPattern();
        String negativePrefixPattern = iProperties.getNegativePrefixPattern();
        String negativeSuffixPattern = iProperties.getNegativeSuffixPattern();
        if (!(negativePrefixPattern == null && negativeSuffixPattern == null)) {
            this.sb1.clear();
            this.sb2.clear();
            this.sb3.clear();
            this.sb4.clear();
            AffixPatternUtils.unescape(negativePrefixPattern, decimalFormatSymbols, str, str2, str3, null, this.sb1);
            AffixPatternUtils.unescape(negativeSuffixPattern, decimalFormatSymbols, str, str2, str3, null, this.sb2);
            AffixPatternUtils.unescape(negativePrefixPattern, decimalFormatSymbols, str, str2, str3, decimalFormatSymbols.getPlusSignString(), this.sb3);
            AffixPatternUtils.unescape(negativeSuffixPattern, decimalFormatSymbols, str, str2, str3, decimalFormatSymbols.getPlusSignString(), this.sb4);
            if (!charSequenceEquals(this.sb1, this.sb3) || !charSequenceEquals(this.sb2, this.sb4)) {
                setPositiveResult(this.sb3, this.sb4, iProperties);
                setNegativeResult(this.sb1, this.sb2, iProperties);
                return this.resultInstance;
            }
            setNegativeResult(this.sb1, this.sb2, iProperties);
        }
        this.sb1.clear();
        this.sb2.clear();
        AffixPatternUtils.unescape(positivePrefixPattern, decimalFormatSymbols, str, str2, str3, null, this.sb1);
        AffixPatternUtils.unescape(positiveSuffixPattern, decimalFormatSymbols, str, str2, str3, null, this.sb2);
        if (negativePrefixPattern == null && negativeSuffixPattern == null) {
            this.sb3.clear();
            this.sb3.append(decimalFormatSymbols.getMinusSignString(), NumberFormat.Field.SIGN);
            this.sb3.append(this.sb1);
            setNegativeResult(this.sb3, this.sb2, iProperties);
        }
        this.sb1.insert(0, decimalFormatSymbols.getPlusSignString(), NumberFormat.Field.SIGN);
        setPositiveResult(this.sb1, this.sb2, iProperties);
        return this.resultInstance;
    }

    private void setPositiveResult(NumberStringBuilder numberStringBuilder, NumberStringBuilder numberStringBuilder2, PositiveNegativeAffixFormat.IProperties iProperties) {
        String positivePrefix = iProperties.getPositivePrefix();
        String positiveSuffix = iProperties.getPositiveSuffix();
        if (positivePrefix != null) {
            numberStringBuilder = this.sb5.clear();
            numberStringBuilder.append(positivePrefix, null);
        }
        if (positiveSuffix != null) {
            numberStringBuilder2 = this.sb6.clear();
            numberStringBuilder2.append(positiveSuffix, null);
        }
        if (numberStringBuilder.length() == 0 && numberStringBuilder2.length() == 0) {
            this.resultInstance.positive = ConstantAffixModifier.EMPTY;
        } else if (this.resultInstance.positive == null || !(this.resultInstance.positive instanceof ConstantMultiFieldModifier) || !((ConstantMultiFieldModifier) this.resultInstance.positive).contentEquals(numberStringBuilder, numberStringBuilder2)) {
            this.resultInstance.positive = new ConstantMultiFieldModifier(numberStringBuilder, numberStringBuilder2, false);
        }
    }

    private void setNegativeResult(NumberStringBuilder numberStringBuilder, NumberStringBuilder numberStringBuilder2, PositiveNegativeAffixFormat.IProperties iProperties) {
        String negativePrefix = iProperties.getNegativePrefix();
        String negativeSuffix = iProperties.getNegativeSuffix();
        if (negativePrefix != null) {
            numberStringBuilder = this.sb5.clear();
            numberStringBuilder.append(negativePrefix, null);
        }
        if (negativeSuffix != null) {
            numberStringBuilder2 = this.sb6.clear();
            numberStringBuilder2.append(negativeSuffix, null);
        }
        if (numberStringBuilder.length() == 0 && numberStringBuilder2.length() == 0) {
            this.resultInstance.negative = ConstantAffixModifier.EMPTY;
        } else if (this.resultInstance.negative == null || !(this.resultInstance.negative instanceof ConstantMultiFieldModifier) || !((ConstantMultiFieldModifier) this.resultInstance.negative).contentEquals(numberStringBuilder, numberStringBuilder2)) {
            this.resultInstance.negative = new ConstantMultiFieldModifier(numberStringBuilder, numberStringBuilder2, false);
        }
    }

    private static boolean charSequenceEquals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
