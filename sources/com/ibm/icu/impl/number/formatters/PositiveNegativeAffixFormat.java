package com.ibm.icu.impl.number.formatters;

import com.ibm.icu.impl.number.PNAffixGenerator;
import com.ibm.icu.impl.number.modifiers.PositiveNegativeAffixModifier;
import com.ibm.icu.text.DecimalFormatSymbols;
public class PositiveNegativeAffixFormat {

    public interface IProperties {
        public static final String DEFAULT_NEGATIVE_PREFIX = null;
        public static final String DEFAULT_NEGATIVE_PREFIX_PATTERN = null;
        public static final String DEFAULT_NEGATIVE_SUFFIX = null;
        public static final String DEFAULT_NEGATIVE_SUFFIX_PATTERN = null;
        public static final String DEFAULT_POSITIVE_PREFIX = null;
        public static final String DEFAULT_POSITIVE_PREFIX_PATTERN = null;
        public static final String DEFAULT_POSITIVE_SUFFIX = null;
        public static final String DEFAULT_POSITIVE_SUFFIX_PATTERN = null;

        String getNegativePrefix();

        String getNegativePrefixPattern();

        String getNegativeSuffix();

        String getNegativeSuffixPattern();

        String getPositivePrefix();

        String getPositivePrefixPattern();

        String getPositiveSuffix();

        String getPositiveSuffixPattern();

        boolean getSignAlwaysShown();
    }

    public static PositiveNegativeAffixModifier getInstance(DecimalFormatSymbols decimalFormatSymbols, IProperties iProperties) {
        PNAffixGenerator.Result modifiers = PNAffixGenerator.getThreadLocalInstance().getModifiers(decimalFormatSymbols, iProperties);
        return new PositiveNegativeAffixModifier(modifiers.positive, modifiers.negative);
    }
}
