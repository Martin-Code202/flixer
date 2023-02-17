package com.ibm.icu.impl.number.formatters;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.impl.number.Format;
import com.ibm.icu.impl.number.FormatQuantity;
import com.ibm.icu.impl.number.Modifier;
import com.ibm.icu.impl.number.ModifierHolder;
import com.ibm.icu.impl.number.PNAffixGenerator;
import com.ibm.icu.impl.number.PatternString;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.impl.number.Rounder;
import com.ibm.icu.impl.number.formatters.CurrencyFormat;
import com.ibm.icu.impl.number.formatters.RoundingFormat;
import com.ibm.icu.impl.number.modifiers.ConstantAffixModifier;
import com.ibm.icu.impl.number.modifiers.PositiveNegativeAffixModifier;
import com.ibm.icu.impl.number.rounders.SignificantDigitsRounder;
import com.ibm.icu.text.CompactDecimalFormat;
import com.ibm.icu.text.DecimalFormat;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.NumberingSystem;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
public class CompactDecimalFormat extends Format.BeforeFormat {
    private static final DecimalFormat.SignificantDigitsMode DEFAULT_SIG_MODE = DecimalFormat.SignificantDigitsMode.OVERRIDE_MAXIMUM_FRACTION;
    protected static final ThreadLocal<Map<CompactDecimalFingerprint, CompactDecimalData>> threadLocalDataCache = new ThreadLocal<Map<CompactDecimalFingerprint, CompactDecimalData>>() { // from class: com.ibm.icu.impl.number.formatters.CompactDecimalFormat.2
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map<CompactDecimalFingerprint, CompactDecimalData> initialValue() {
            return new HashMap();
        }
    };
    private static final ThreadLocal<Properties> threadLocalProperties = new ThreadLocal<Properties>() { // from class: com.ibm.icu.impl.number.formatters.CompactDecimalFormat.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Properties initialValue() {
            return new Properties();
        }
    };
    private final CompactDecimalData data;
    private final Modifier.PositiveNegativeModifier defaultMod;
    private final Rounder rounder;
    private final CompactDecimalFormat.CompactStyle style;

    /* access modifiers changed from: package-private */
    public enum CompactType {
        DECIMAL,
        CURRENCY
    }

    public interface IProperties extends RoundingFormat.IProperties, CurrencyFormat.ICurrencyProperties {
        public static final CompactDecimalFormat.CompactStyle DEFAULT_COMPACT_STYLE = null;

        CompactDecimalFormat.CompactStyle getCompactStyle();
    }

    public static boolean useCompactDecimalFormat(IProperties iProperties) {
        return iProperties.getCompactStyle() != IProperties.DEFAULT_COMPACT_STYLE;
    }

    public static CompactDecimalFormat getInstance(DecimalFormatSymbols decimalFormatSymbols, IProperties iProperties) {
        return new CompactDecimalFormat(decimalFormatSymbols, iProperties);
    }

    private static Rounder getRounder(IProperties iProperties) {
        Rounder rounder2 = null;
        if (!SignificantDigitsRounder.useSignificantDigits(iProperties)) {
            rounder2 = RoundingFormat.getDefaultOrNull(iProperties);
        }
        if (rounder2 != null) {
            return rounder2;
        }
        int minimumSignificantDigits = iProperties.getMinimumSignificantDigits();
        int maximumSignificantDigits = iProperties.getMaximumSignificantDigits();
        DecimalFormat.SignificantDigitsMode significantDigitsMode = iProperties.getSignificantDigitsMode();
        Properties clear = threadLocalProperties.get().clear();
        clear.setMinimumSignificantDigits(minimumSignificantDigits > 0 ? minimumSignificantDigits : 1);
        clear.setMaximumSignificantDigits(maximumSignificantDigits > 0 ? maximumSignificantDigits : 2);
        clear.setSignificantDigitsMode(significantDigitsMode != null ? significantDigitsMode : DEFAULT_SIG_MODE);
        clear.setRoundingMode(iProperties.getRoundingMode());
        clear.setMinimumFractionDigits(iProperties.getMinimumFractionDigits());
        clear.setMaximumFractionDigits(iProperties.getMaximumFractionDigits());
        clear.setMinimumIntegerDigits(iProperties.getMinimumIntegerDigits());
        clear.setMaximumIntegerDigits(iProperties.getMaximumIntegerDigits());
        return SignificantDigitsRounder.getInstance(clear);
    }

    private static CompactDecimalData getData(DecimalFormatSymbols decimalFormatSymbols, CompactDecimalFingerprint compactDecimalFingerprint) {
        CompactDecimalData compactDecimalData = threadLocalDataCache.get().get(compactDecimalFingerprint);
        if (compactDecimalData != null) {
            return compactDecimalData;
        }
        CompactDecimalData compactDecimalData2 = new CompactDecimalData();
        ULocale uLocale = decimalFormatSymbols.getULocale();
        CompactDecimalDataSink compactDecimalDataSink = new CompactDecimalDataSink(compactDecimalData2, decimalFormatSymbols, compactDecimalFingerprint);
        String name = NumberingSystem.getInstance(uLocale).getName();
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", uLocale);
        internalPopulateData(name, iCUResourceBundle, compactDecimalDataSink, compactDecimalData2);
        if (compactDecimalData2.isEmpty() && compactDecimalFingerprint.compactStyle == CompactDecimalFormat.CompactStyle.LONG) {
            compactDecimalDataSink.compactStyle = CompactDecimalFormat.CompactStyle.SHORT;
            internalPopulateData(name, iCUResourceBundle, compactDecimalDataSink, compactDecimalData2);
        }
        threadLocalDataCache.get().put(compactDecimalFingerprint, compactDecimalData2);
        return compactDecimalData2;
    }

    private static void internalPopulateData(String str, ICUResourceBundle iCUResourceBundle, CompactDecimalDataSink compactDecimalDataSink, CompactDecimalData compactDecimalData) {
        try {
            iCUResourceBundle.getAllItemsWithFallback("NumberElements/" + str, compactDecimalDataSink);
        } catch (MissingResourceException e) {
        }
        if (compactDecimalData.isEmpty() && !str.equals("latn")) {
            iCUResourceBundle.getAllItemsWithFallback("NumberElements/latn", compactDecimalDataSink);
        }
        if (compactDecimalDataSink.exception != null) {
            throw compactDecimalDataSink.exception;
        }
    }

    private static Modifier.PositiveNegativeModifier getDefaultMod(DecimalFormatSymbols decimalFormatSymbols, CompactDecimalFingerprint compactDecimalFingerprint) {
        String str;
        ULocale uLocale = decimalFormatSymbols.getULocale();
        if (compactDecimalFingerprint.compactType == CompactType.CURRENCY) {
            str = NumberFormat.getPatternForStyle(uLocale, 1);
        } else {
            str = NumberFormat.getPatternForStyle(uLocale, 0);
        }
        PNAffixGenerator.Result modifiers = PNAffixGenerator.getThreadLocalInstance().getModifiers(decimalFormatSymbols, compactDecimalFingerprint.currencySymbol, PatternString.parseToProperties(str));
        return new PositiveNegativeAffixModifier(modifiers.positive, modifiers.negative);
    }

    private CompactDecimalFormat(DecimalFormatSymbols decimalFormatSymbols, IProperties iProperties) {
        CompactDecimalFingerprint compactDecimalFingerprint = new CompactDecimalFingerprint(decimalFormatSymbols, iProperties);
        this.rounder = getRounder(iProperties);
        this.data = getData(decimalFormatSymbols, compactDecimalFingerprint);
        this.defaultMod = getDefaultMod(decimalFormatSymbols, compactDecimalFingerprint);
        this.style = iProperties.getCompactStyle();
    }

    @Override // com.ibm.icu.impl.number.Format.BeforeFormat
    public void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder, PluralRules pluralRules) {
        apply(formatQuantity, modifierHolder, pluralRules, this.rounder, this.data, this.defaultMod);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.number.Format.BeforeFormat
    public void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder) {
        throw new UnsupportedOperationException();
    }

    private static void apply(FormatQuantity formatQuantity, ModifierHolder modifierHolder, PluralRules pluralRules, Rounder rounder2, CompactDecimalData compactDecimalData, Modifier.PositiveNegativeModifier positiveNegativeModifier) {
        int i;
        if (formatQuantity.isZero()) {
            i = 0;
            rounder2.apply(formatQuantity);
        } else {
            i = formatQuantity.getMagnitude() - rounder2.chooseMultiplierAndApply(formatQuantity, compactDecimalData);
        }
        StandardPlural standardPlural = formatQuantity.getStandardPlural(pluralRules);
        boolean isNegative = formatQuantity.isNegative();
        Modifier modifier = compactDecimalData.getModifier(i, standardPlural, isNegative);
        if (modifier == null) {
            modifier = positiveNegativeModifier.getModifier(isNegative);
        }
        modifierHolder.add(modifier);
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        properties.setCompactStyle(this.style);
        this.rounder.export(properties);
    }

    /* access modifiers changed from: package-private */
    public static class CompactDecimalData implements Rounder.MultiplierGenerator {
        private static final Modifier USE_FALLBACK = new ConstantAffixModifier();
        boolean isEmpty = true;
        int largestMagnitude = -1;
        final Modifier[] mods = new Modifier[((StandardPlural.COUNT * 16) * 2)];
        final byte[] multipliers = new byte[16];

        CompactDecimalData() {
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.isEmpty;
        }

        @Override // com.ibm.icu.impl.number.Rounder.MultiplierGenerator
        public int getMultiplier(int i) {
            if (i < 0) {
                return 0;
            }
            if (i > this.largestMagnitude) {
                i = this.largestMagnitude;
            }
            return this.multipliers[i];
        }

        /* access modifiers changed from: package-private */
        public int setOrGetMultiplier(int i, byte b) {
            if (this.multipliers[i] != 0) {
                return this.multipliers[i];
            }
            this.multipliers[i] = b;
            this.isEmpty = false;
            if (i > this.largestMagnitude) {
                this.largestMagnitude = i;
            }
            return b;
        }

        /* access modifiers changed from: package-private */
        public Modifier getModifier(int i, StandardPlural standardPlural, boolean z) {
            if (i < 0) {
                return null;
            }
            if (i > this.largestMagnitude) {
                i = this.largestMagnitude;
            }
            Modifier modifier = this.mods[modIndex(i, standardPlural, z)];
            if (modifier == null && standardPlural != StandardPlural.OTHER) {
                modifier = this.mods[modIndex(i, StandardPlural.OTHER, z)];
            }
            if (modifier == USE_FALLBACK) {
                return null;
            }
            return modifier;
        }

        public boolean has(int i, StandardPlural standardPlural) {
            return this.mods[modIndex(i, standardPlural, false)] != null;
        }

        /* access modifiers changed from: package-private */
        public void setModifiers(Modifier modifier, Modifier modifier2, int i, StandardPlural standardPlural) {
            this.mods[modIndex(i, standardPlural, false)] = modifier;
            this.mods[modIndex(i, standardPlural, true)] = modifier2;
            this.isEmpty = false;
            if (i > this.largestMagnitude) {
                this.largestMagnitude = i;
            }
        }

        /* access modifiers changed from: package-private */
        public void setNoFallback(int i, StandardPlural standardPlural) {
            setModifiers(USE_FALLBACK, USE_FALLBACK, i, standardPlural);
        }

        private static final int modIndex(int i, StandardPlural standardPlural, boolean z) {
            return (StandardPlural.COUNT * i * 2) + (standardPlural.ordinal() * 2) + (z ? 1 : 0);
        }
    }

    /* access modifiers changed from: package-private */
    public static class CompactDecimalFingerprint {
        final CompactDecimalFormat.CompactStyle compactStyle;
        final CompactType compactType;
        final String currencySymbol;
        final ULocale uloc;

        CompactDecimalFingerprint(DecimalFormatSymbols decimalFormatSymbols, IProperties iProperties) {
            if (iProperties.getCurrency() != CurrencyFormat.ICurrencyProperties.DEFAULT_CURRENCY) {
                this.compactType = CompactType.CURRENCY;
                this.currencySymbol = CurrencyFormat.getCurrencySymbol(decimalFormatSymbols, iProperties);
            } else {
                this.compactType = CompactType.DECIMAL;
                this.currencySymbol = "";
            }
            this.compactStyle = iProperties.getCompactStyle();
            this.uloc = decimalFormatSymbols.getULocale();
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            CompactDecimalFingerprint compactDecimalFingerprint = (CompactDecimalFingerprint) obj;
            if (this == compactDecimalFingerprint) {
                return true;
            }
            if (this.compactStyle != compactDecimalFingerprint.compactStyle || this.compactType != compactDecimalFingerprint.compactType) {
                return false;
            }
            if ((this.currencySymbol == compactDecimalFingerprint.currencySymbol || (this.currencySymbol != null && compactDecimalFingerprint.currencySymbol != null && this.currencySymbol.equals(compactDecimalFingerprint.currencySymbol))) && this.uloc.equals(compactDecimalFingerprint.uloc)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            if (this.compactStyle != null) {
                i = this.compactStyle.hashCode() ^ 0;
            }
            if (this.compactType != null) {
                i ^= this.compactType.hashCode();
            }
            if (this.uloc != null) {
                i ^= this.uloc.hashCode();
            }
            if (this.currencySymbol != null) {
                return i ^ this.currencySymbol.hashCode();
            }
            return i;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class CompactDecimalDataSink extends UResource.Sink {
        CompactDecimalFormat.CompactStyle compactStyle;
        CompactType compactType;
        String currencySymbol;
        CompactDecimalData data;
        IllegalArgumentException exception;
        PNAffixGenerator pnag = PNAffixGenerator.getThreadLocalInstance();
        DecimalFormatSymbols symbols;

        public CompactDecimalDataSink(CompactDecimalData compactDecimalData, DecimalFormatSymbols decimalFormatSymbols, CompactDecimalFingerprint compactDecimalFingerprint) {
            this.data = compactDecimalData;
            this.symbols = decimalFormatSymbols;
            this.compactType = compactDecimalFingerprint.compactType;
            this.currencySymbol = compactDecimalFingerprint.currencySymbol;
            this.compactStyle = compactDecimalFingerprint.compactStyle;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if ((key.contentEquals("patternsShort") && this.compactStyle == CompactDecimalFormat.CompactStyle.SHORT) || (key.contentEquals("patternsLong") && this.compactStyle == CompactDecimalFormat.CompactStyle.LONG)) {
                    UResource.Table table2 = value.getTable();
                    for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                        if ((key.contentEquals("decimalFormat") && this.compactType == CompactType.DECIMAL) || (key.contentEquals("currencyFormat") && this.compactType == CompactType.CURRENCY)) {
                            UResource.Table table3 = value.getTable();
                            for (int i3 = 0; table3.getKeyAndValue(i3, key, value); i3++) {
                                try {
                                    byte length = (byte) (key.length() - 1);
                                    if (length >= 15) {
                                        continue;
                                    } else {
                                        UResource.Table table4 = value.getTable();
                                        for (int i4 = 0; table4.getKeyAndValue(i4, key, value); i4++) {
                                            StandardPlural fromString = StandardPlural.fromString(key.toString());
                                            if (!this.data.has(length, fromString)) {
                                                String value2 = value.toString();
                                                if (value2.equals("0")) {
                                                    this.data.setNoFallback(length, fromString);
                                                } else {
                                                    Properties parseToProperties = PatternString.parseToProperties(value2);
                                                    byte b = (byte) (-((length - parseToProperties.getMinimumIntegerDigits()) + 1));
                                                    if (b != this.data.setOrGetMultiplier(length, b)) {
                                                        throw new IllegalArgumentException(String.format("Different number of zeros for same power of ten in compact decimal format data for locale '%s', style '%s', type '%s'", this.symbols.getULocale().toString(), this.compactStyle.toString(), this.compactType.toString()));
                                                    }
                                                    PNAffixGenerator.Result modifiers = this.pnag.getModifiers(this.symbols, this.currencySymbol, parseToProperties);
                                                    this.data.setModifiers(modifiers.positive, modifiers.negative, length, fromString);
                                                }
                                            }
                                        }
                                        continue;
                                    }
                                } catch (IllegalArgumentException e) {
                                    this.exception = e;
                                }
                            }
                            return;
                        }
                    }
                    continue;
                }
            }
        }
    }
}
