package com.ibm.icu.impl.number.formatters;

import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.number.AffixPatternUtils;
import com.ibm.icu.impl.number.PNAffixGenerator;
import com.ibm.icu.impl.number.PatternString;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.impl.number.Rounder;
import com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat;
import com.ibm.icu.impl.number.formatters.RoundingFormat;
import com.ibm.icu.impl.number.modifiers.GeneralPluralModifier;
import com.ibm.icu.impl.number.rounders.IncrementRounder;
import com.ibm.icu.impl.number.rounders.MagnitudeRounder;
import com.ibm.icu.impl.number.rounders.SignificantDigitsRounder;
import com.ibm.icu.text.CurrencyPluralInfo;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.util.Currency;
import java.math.BigDecimal;
public class CurrencyFormat {
    private static final Currency DEFAULT_CURRENCY = Currency.getInstance("XXX");
    private static final ThreadLocal<Properties> threadLocalProperties = new ThreadLocal<Properties>() { // from class: com.ibm.icu.impl.number.formatters.CurrencyFormat.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Properties initialValue() {
            return new Properties();
        }
    };

    public enum CurrencyStyle {
        SYMBOL,
        ISO_CODE
    }

    public interface ICurrencyProperties {
        public static final Currency DEFAULT_CURRENCY = null;
        public static final CurrencyPluralInfo DEFAULT_CURRENCY_PLURAL_INFO = null;
        public static final CurrencyStyle DEFAULT_CURRENCY_STYLE = null;
        public static final Currency.CurrencyUsage DEFAULT_CURRENCY_USAGE = null;

        Currency getCurrency();

        @Deprecated
        CurrencyPluralInfo getCurrencyPluralInfo();

        CurrencyStyle getCurrencyStyle();

        Currency.CurrencyUsage getCurrencyUsage();
    }

    public interface IProperties extends ICurrencyProperties, RoundingFormat.IProperties, PositiveNegativeAffixFormat.IProperties {
    }

    public static boolean useCurrency(IProperties iProperties) {
        return iProperties.getCurrency() != null || iProperties.getCurrencyPluralInfo() != null || iProperties.getCurrencyUsage() != null || AffixPatternUtils.hasCurrencySymbols(iProperties.getPositivePrefixPattern()) || AffixPatternUtils.hasCurrencySymbols(iProperties.getPositiveSuffixPattern()) || AffixPatternUtils.hasCurrencySymbols(iProperties.getNegativePrefixPattern()) || AffixPatternUtils.hasCurrencySymbols(iProperties.getNegativeSuffixPattern());
    }

    public static String getCurrencySymbol(DecimalFormatSymbols decimalFormatSymbols, ICurrencyProperties iCurrencyProperties) {
        if (iCurrencyProperties.getCurrencyStyle() == CurrencyStyle.ISO_CODE) {
            return getCurrencyIsoCode(decimalFormatSymbols, iCurrencyProperties);
        }
        Currency currency = iCurrencyProperties.getCurrency();
        if (currency == null) {
            return decimalFormatSymbols.getCurrencySymbol();
        }
        if (currency.equals(decimalFormatSymbols.getCurrency())) {
            return decimalFormatSymbols.getCurrencySymbol();
        }
        return currency.getName(decimalFormatSymbols.getULocale(), 0, null);
    }

    public static String getCurrencyIsoCode(DecimalFormatSymbols decimalFormatSymbols, ICurrencyProperties iCurrencyProperties) {
        Currency currency = iCurrencyProperties.getCurrency();
        if (currency == null) {
            return decimalFormatSymbols.getInternationalCurrencySymbol();
        }
        if (currency.equals(decimalFormatSymbols.getCurrency())) {
            return decimalFormatSymbols.getInternationalCurrencySymbol();
        }
        return currency.getCurrencyCode();
    }

    public static String getCurrencyLongName(DecimalFormatSymbols decimalFormatSymbols, ICurrencyProperties iCurrencyProperties, StandardPlural standardPlural) {
        Currency currency = iCurrencyProperties.getCurrency();
        if (currency == null) {
            currency = decimalFormatSymbols.getCurrency();
        }
        if (currency == null) {
            return getCurrencySymbol(decimalFormatSymbols, iCurrencyProperties);
        }
        return currency.getName(decimalFormatSymbols.getULocale(), 2, standardPlural.getKeyword(), null);
    }

    public static GeneralPluralModifier getCurrencyModifier(DecimalFormatSymbols decimalFormatSymbols, IProperties iProperties) {
        PNAffixGenerator.Result result;
        PNAffixGenerator threadLocalInstance = PNAffixGenerator.getThreadLocalInstance();
        String currencySymbol = getCurrencySymbol(decimalFormatSymbols, iProperties);
        String currencyIsoCode = getCurrencyIsoCode(decimalFormatSymbols, iProperties);
        CurrencyPluralInfo currencyPluralInfo = iProperties.getCurrencyPluralInfo();
        GeneralPluralModifier generalPluralModifier = new GeneralPluralModifier();
        Properties properties = new Properties();
        for (StandardPlural standardPlural : StandardPlural.VALUES) {
            String currencyLongName = getCurrencyLongName(decimalFormatSymbols, iProperties, standardPlural);
            if (currencyPluralInfo == null) {
                result = threadLocalInstance.getModifiers(decimalFormatSymbols, currencySymbol, currencyIsoCode, currencyLongName, iProperties);
            } else {
                PatternString.parseToExistingProperties(currencyPluralInfo.getCurrencyPluralPattern(standardPlural.getKeyword()), properties, true);
                result = threadLocalInstance.getModifiers(decimalFormatSymbols, currencySymbol, currencyIsoCode, currencyLongName, properties);
            }
            generalPluralModifier.put(standardPlural, result.positive, result.negative);
        }
        return generalPluralModifier;
    }

    public static void populateCurrencyRounderProperties(Properties properties, DecimalFormatSymbols decimalFormatSymbols, IProperties iProperties) {
        BigDecimal bigDecimal;
        Currency currency = iProperties.getCurrency();
        if (currency == null) {
            currency = decimalFormatSymbols.getCurrency();
        }
        if (currency == null) {
            currency = DEFAULT_CURRENCY;
        }
        Currency.CurrencyUsage currencyUsage = iProperties.getCurrencyUsage();
        int minimumFractionDigits = iProperties.getMinimumFractionDigits();
        int maximumFractionDigits = iProperties.getMaximumFractionDigits();
        Currency.CurrencyUsage currencyUsage2 = currencyUsage != null ? currencyUsage : Currency.CurrencyUsage.STANDARD;
        double roundingIncrement = currency.getRoundingIncrement(currencyUsage2);
        int defaultFractionDigits = currency.getDefaultFractionDigits(currencyUsage2);
        properties.setRoundingMode(iProperties.getRoundingMode());
        properties.setMinimumIntegerDigits(iProperties.getMinimumIntegerDigits());
        properties.setMaximumIntegerDigits(iProperties.getMaximumIntegerDigits());
        if (currencyUsage != null || (minimumFractionDigits < 0 && maximumFractionDigits < 0)) {
            properties.setMinimumFractionDigits(defaultFractionDigits);
            properties.setMaximumFractionDigits(defaultFractionDigits);
        } else if (minimumFractionDigits < 0) {
            properties.setMinimumFractionDigits(defaultFractionDigits < maximumFractionDigits ? defaultFractionDigits : maximumFractionDigits);
            properties.setMaximumFractionDigits(maximumFractionDigits);
        } else if (maximumFractionDigits < 0) {
            properties.setMinimumFractionDigits(minimumFractionDigits);
            properties.setMaximumFractionDigits(defaultFractionDigits > minimumFractionDigits ? defaultFractionDigits : minimumFractionDigits);
        } else {
            properties.setMinimumFractionDigits(minimumFractionDigits);
            properties.setMaximumFractionDigits(maximumFractionDigits);
        }
        if (roundingIncrement > 0.0d) {
            BigDecimal roundingIncrement2 = iProperties.getRoundingIncrement();
            if (roundingIncrement2 != null) {
                bigDecimal = roundingIncrement2;
            } else {
                bigDecimal = BigDecimal.valueOf(roundingIncrement);
            }
            properties.setRoundingIncrement(bigDecimal);
        }
    }

    public static Rounder getCurrencyRounder(DecimalFormatSymbols decimalFormatSymbols, IProperties iProperties) {
        if (SignificantDigitsRounder.useSignificantDigits(iProperties)) {
            return SignificantDigitsRounder.getInstance(iProperties);
        }
        Properties clear = threadLocalProperties.get().clear();
        populateCurrencyRounderProperties(clear, decimalFormatSymbols, iProperties);
        if (clear.getRoundingIncrement() != null) {
            return IncrementRounder.getInstance(clear);
        }
        return MagnitudeRounder.getInstance(clear);
    }
}
