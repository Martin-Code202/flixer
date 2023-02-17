package com.ibm.icu.impl.number;

import com.ibm.icu.impl.number.Format;
import com.ibm.icu.impl.number.formatters.BigDecimalMultiplier;
import com.ibm.icu.impl.number.formatters.CompactDecimalFormat;
import com.ibm.icu.impl.number.formatters.CurrencyFormat;
import com.ibm.icu.impl.number.formatters.MagnitudeMultiplier;
import com.ibm.icu.impl.number.formatters.MeasureFormat;
import com.ibm.icu.impl.number.formatters.PaddingFormat;
import com.ibm.icu.impl.number.formatters.PositiveDecimalFormat;
import com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat;
import com.ibm.icu.impl.number.formatters.RoundingFormat;
import com.ibm.icu.impl.number.formatters.ScientificFormat;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.ULocale;
import java.util.HashMap;
import java.util.Map;
public class Endpoint {
    private static final ThreadLocal<Map<String, Properties>> threadLocalPropertiesCache = new ThreadLocal<Map<String, Properties>>() { // from class: com.ibm.icu.impl.number.Endpoint.2
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map<String, Properties> initialValue() {
            return new HashMap();
        }
    };
    private static final ThreadLocal<Map<ULocale, PluralRules>> threadLocalRulesCache = new ThreadLocal<Map<ULocale, PluralRules>>() { // from class: com.ibm.icu.impl.number.Endpoint.3
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map<ULocale, PluralRules> initialValue() {
            return new HashMap();
        }
    };
    private static final ThreadLocal<Map<ULocale, DecimalFormatSymbols>> threadLocalSymbolsCache = new ThreadLocal<Map<ULocale, DecimalFormatSymbols>>() { // from class: com.ibm.icu.impl.number.Endpoint.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map<ULocale, DecimalFormatSymbols> initialValue() {
            return new HashMap();
        }
    };

    public static Format.SingularFormat fromBTA(Properties properties, DecimalFormatSymbols decimalFormatSymbols) {
        if (decimalFormatSymbols == null) {
            throw new IllegalArgumentException("symbols must not be null");
        }
        boolean z = true;
        Format.BeforeTargetAfterFormat beforeTargetAfterFormat = new Format.BeforeTargetAfterFormat(getPluralRules(decimalFormatSymbols.getULocale(), properties));
        PositiveDecimalFormat positiveDecimalFormat = new PositiveDecimalFormat(decimalFormatSymbols, properties);
        beforeTargetAfterFormat.setTargetFormat(positiveDecimalFormat);
        if (MagnitudeMultiplier.useMagnitudeMultiplier(properties)) {
            z = false;
            beforeTargetAfterFormat.addBeforeFormat(MagnitudeMultiplier.getInstance(properties));
        }
        if (BigDecimalMultiplier.useMultiplier(properties)) {
            z = false;
            beforeTargetAfterFormat.addBeforeFormat(BigDecimalMultiplier.getInstance(properties));
        }
        if (MeasureFormat.useMeasureFormat(properties)) {
            z = false;
            beforeTargetAfterFormat.addBeforeFormat(MeasureFormat.getInstance(decimalFormatSymbols, properties));
        }
        if (CurrencyFormat.useCurrency(properties)) {
            z = false;
            if (CompactDecimalFormat.useCompactDecimalFormat(properties)) {
                beforeTargetAfterFormat.addBeforeFormat(CompactDecimalFormat.getInstance(decimalFormatSymbols, properties));
            } else if (ScientificFormat.useScientificNotation(properties)) {
                beforeTargetAfterFormat.addBeforeFormat(PositiveNegativeAffixFormat.getInstance(decimalFormatSymbols, properties));
                beforeTargetAfterFormat.addBeforeFormat(ScientificFormat.getInstance(decimalFormatSymbols, properties));
            } else {
                beforeTargetAfterFormat.addBeforeFormat(CurrencyFormat.getCurrencyRounder(decimalFormatSymbols, properties));
                beforeTargetAfterFormat.addBeforeFormat(CurrencyFormat.getCurrencyModifier(decimalFormatSymbols, properties));
            }
        } else if (CompactDecimalFormat.useCompactDecimalFormat(properties)) {
            z = false;
            beforeTargetAfterFormat.addBeforeFormat(CompactDecimalFormat.getInstance(decimalFormatSymbols, properties));
        } else if (ScientificFormat.useScientificNotation(properties)) {
            z = false;
            beforeTargetAfterFormat.addBeforeFormat(PositiveNegativeAffixFormat.getInstance(decimalFormatSymbols, properties));
            beforeTargetAfterFormat.addBeforeFormat(ScientificFormat.getInstance(decimalFormatSymbols, properties));
        } else {
            beforeTargetAfterFormat.addBeforeFormat(PositiveNegativeAffixFormat.getInstance(decimalFormatSymbols, properties));
            beforeTargetAfterFormat.addBeforeFormat(RoundingFormat.getDefaultOrNoRounder(properties));
        }
        if (PaddingFormat.usePadding(properties)) {
            z = false;
            beforeTargetAfterFormat.addAfterFormat(PaddingFormat.getInstance(properties));
        }
        if (z) {
            return new Format.PositiveNegativeRounderTargetFormat(PositiveNegativeAffixFormat.getInstance(decimalFormatSymbols, properties), RoundingFormat.getDefaultOrNoRounder(properties), positiveDecimalFormat);
        }
        return beforeTargetAfterFormat;
    }

    private static PluralRules getPluralRules(ULocale uLocale, Properties properties) {
        if (properties.getCurrencyPluralInfo() != null) {
            return properties.getCurrencyPluralInfo().getPluralRules();
        }
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        PluralRules pluralRules = threadLocalRulesCache.get().get(uLocale);
        if (pluralRules != null) {
            return pluralRules;
        }
        PluralRules forLocale = PluralRules.forLocale(uLocale);
        threadLocalRulesCache.get().put(uLocale, forLocale);
        return forLocale;
    }
}
