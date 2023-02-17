package com.ibm.icu.impl.number;

import com.ibm.icu.impl.number.Parse;
import com.ibm.icu.impl.number.formatters.CompactDecimalFormat;
import com.ibm.icu.impl.number.formatters.CurrencyFormat;
import com.ibm.icu.impl.number.formatters.MeasureFormat;
import com.ibm.icu.impl.number.formatters.PaddingFormat;
import com.ibm.icu.text.CompactDecimalFormat;
import com.ibm.icu.text.CurrencyPluralInfo;
import com.ibm.icu.text.DecimalFormat;
import com.ibm.icu.text.MeasureFormat;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.MeasureUnit;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
public class Properties implements Cloneable, Serializable, MeasureFormat.IProperties, CompactDecimalFormat.IProperties, Parse.IProperties {
    private static final Properties DEFAULT = new Properties();
    private static final long serialVersionUID = 4095518955889349243L;
    private transient CompactDecimalFormat.CompactStyle compactStyle;
    private transient Currency currency;
    private transient CurrencyPluralInfo currencyPluralInfo;
    private transient CurrencyFormat.CurrencyStyle currencyStyle;
    private transient Currency.CurrencyUsage currencyUsage;
    private transient boolean decimalPatternMatchRequired;
    private transient boolean decimalSeparatorAlwaysShown;
    private transient boolean exponentSignAlwaysShown;
    private transient int formatWidth;
    private transient int groupingSize;
    private transient int magnitudeMultiplier;
    private transient MathContext mathContext;
    private transient int maximumFractionDigits;
    private transient int maximumIntegerDigits;
    private transient int maximumSignificantDigits;
    private transient MeasureFormat.FormatWidth measureFormatWidth;
    private transient MeasureUnit measureUnit;
    private transient int minimumExponentDigits;
    private transient int minimumFractionDigits;
    private transient int minimumGroupingDigits;
    private transient int minimumIntegerDigits;
    private transient int minimumSignificantDigits;
    private transient BigDecimal multiplier;
    private transient String negativePrefix;
    private transient String negativePrefixPattern;
    private transient String negativeSuffix;
    private transient String negativeSuffixPattern;
    private transient PaddingFormat.PadPosition padPosition;
    private transient String padString;
    private transient boolean parseCaseSensitive;
    private transient Parse.GroupingMode parseGroupingMode;
    private transient boolean parseIntegerOnly;
    private transient Parse.ParseMode parseMode;
    private transient boolean parseNoExponent;
    private transient boolean parseToBigDecimal;
    private transient String positivePrefix;
    private transient String positivePrefixPattern;
    private transient String positiveSuffix;
    private transient String positiveSuffixPattern;
    private transient BigDecimal roundingIncrement;
    private transient RoundingMode roundingMode;
    private transient int secondaryGroupingSize;
    private transient boolean signAlwaysShown;
    private transient DecimalFormat.SignificantDigitsMode significantDigitsMode;

    public Properties() {
        clear();
    }

    private Properties _clear() {
        this.compactStyle = DEFAULT_COMPACT_STYLE;
        this.currency = DEFAULT_CURRENCY;
        this.currencyPluralInfo = DEFAULT_CURRENCY_PLURAL_INFO;
        this.currencyStyle = DEFAULT_CURRENCY_STYLE;
        this.currencyUsage = DEFAULT_CURRENCY_USAGE;
        this.decimalPatternMatchRequired = false;
        this.decimalSeparatorAlwaysShown = false;
        this.exponentSignAlwaysShown = false;
        this.formatWidth = 0;
        this.groupingSize = -1;
        this.magnitudeMultiplier = 0;
        this.mathContext = DEFAULT_MATH_CONTEXT;
        this.maximumFractionDigits = -1;
        this.maximumIntegerDigits = -1;
        this.maximumSignificantDigits = -1;
        this.measureFormatWidth = DEFAULT_MEASURE_FORMAT_WIDTH;
        this.measureUnit = DEFAULT_MEASURE_UNIT;
        this.minimumExponentDigits = -1;
        this.minimumFractionDigits = -1;
        this.minimumGroupingDigits = 1;
        this.minimumIntegerDigits = -1;
        this.minimumSignificantDigits = -1;
        this.multiplier = DEFAULT_MULTIPLIER;
        this.negativePrefix = DEFAULT_NEGATIVE_PREFIX;
        this.negativePrefixPattern = DEFAULT_NEGATIVE_PREFIX_PATTERN;
        this.negativeSuffix = DEFAULT_NEGATIVE_SUFFIX;
        this.negativeSuffixPattern = DEFAULT_NEGATIVE_SUFFIX_PATTERN;
        this.padPosition = DEFAULT_PAD_POSITION;
        this.padString = DEFAULT_PAD_STRING;
        this.parseCaseSensitive = false;
        this.parseGroupingMode = DEFAULT_PARSE_GROUPING_MODE;
        this.parseIntegerOnly = false;
        this.parseMode = DEFAULT_PARSE_MODE;
        this.parseNoExponent = false;
        this.parseToBigDecimal = false;
        this.positivePrefix = DEFAULT_POSITIVE_PREFIX;
        this.positivePrefixPattern = DEFAULT_POSITIVE_PREFIX_PATTERN;
        this.positiveSuffix = DEFAULT_POSITIVE_SUFFIX;
        this.positiveSuffixPattern = DEFAULT_POSITIVE_SUFFIX_PATTERN;
        this.roundingIncrement = DEFAULT_ROUNDING_INCREMENT;
        this.roundingMode = DEFAULT_ROUNDING_MODE;
        this.secondaryGroupingSize = -1;
        this.signAlwaysShown = false;
        this.significantDigitsMode = DEFAULT_SIGNIFICANT_DIGITS_MODE;
        return this;
    }

    private Properties _copyFrom(Properties properties) {
        this.compactStyle = properties.compactStyle;
        this.currency = properties.currency;
        this.currencyPluralInfo = properties.currencyPluralInfo;
        this.currencyStyle = properties.currencyStyle;
        this.currencyUsage = properties.currencyUsage;
        this.decimalPatternMatchRequired = properties.decimalPatternMatchRequired;
        this.decimalSeparatorAlwaysShown = properties.decimalSeparatorAlwaysShown;
        this.exponentSignAlwaysShown = properties.exponentSignAlwaysShown;
        this.formatWidth = properties.formatWidth;
        this.groupingSize = properties.groupingSize;
        this.magnitudeMultiplier = properties.magnitudeMultiplier;
        this.mathContext = properties.mathContext;
        this.maximumFractionDigits = properties.maximumFractionDigits;
        this.maximumIntegerDigits = properties.maximumIntegerDigits;
        this.maximumSignificantDigits = properties.maximumSignificantDigits;
        this.measureFormatWidth = properties.measureFormatWidth;
        this.measureUnit = properties.measureUnit;
        this.minimumExponentDigits = properties.minimumExponentDigits;
        this.minimumFractionDigits = properties.minimumFractionDigits;
        this.minimumGroupingDigits = properties.minimumGroupingDigits;
        this.minimumIntegerDigits = properties.minimumIntegerDigits;
        this.minimumSignificantDigits = properties.minimumSignificantDigits;
        this.multiplier = properties.multiplier;
        this.negativePrefix = properties.negativePrefix;
        this.negativePrefixPattern = properties.negativePrefixPattern;
        this.negativeSuffix = properties.negativeSuffix;
        this.negativeSuffixPattern = properties.negativeSuffixPattern;
        this.padPosition = properties.padPosition;
        this.padString = properties.padString;
        this.parseCaseSensitive = properties.parseCaseSensitive;
        this.parseGroupingMode = properties.parseGroupingMode;
        this.parseIntegerOnly = properties.parseIntegerOnly;
        this.parseMode = properties.parseMode;
        this.parseNoExponent = properties.parseNoExponent;
        this.parseToBigDecimal = properties.parseToBigDecimal;
        this.positivePrefix = properties.positivePrefix;
        this.positivePrefixPattern = properties.positivePrefixPattern;
        this.positiveSuffix = properties.positiveSuffix;
        this.positiveSuffixPattern = properties.positiveSuffixPattern;
        this.roundingIncrement = properties.roundingIncrement;
        this.roundingMode = properties.roundingMode;
        this.secondaryGroupingSize = properties.secondaryGroupingSize;
        this.signAlwaysShown = properties.signAlwaysShown;
        this.significantDigitsMode = properties.significantDigitsMode;
        return this;
    }

    private boolean _equals(Properties properties) {
        return (((((((((((((((((((((((((((((((((((((((((((1 != 0 && _equalsHelper(this.compactStyle, properties.compactStyle)) && _equalsHelper(this.currency, properties.currency)) && _equalsHelper(this.currencyPluralInfo, properties.currencyPluralInfo)) && _equalsHelper(this.currencyStyle, properties.currencyStyle)) && _equalsHelper(this.currencyUsage, properties.currencyUsage)) && _equalsHelper(this.decimalPatternMatchRequired, properties.decimalPatternMatchRequired)) && _equalsHelper(this.decimalSeparatorAlwaysShown, properties.decimalSeparatorAlwaysShown)) && _equalsHelper(this.exponentSignAlwaysShown, properties.exponentSignAlwaysShown)) && _equalsHelper(this.formatWidth, properties.formatWidth)) && _equalsHelper(this.groupingSize, properties.groupingSize)) && _equalsHelper(this.magnitudeMultiplier, properties.magnitudeMultiplier)) && _equalsHelper(this.mathContext, properties.mathContext)) && _equalsHelper(this.maximumFractionDigits, properties.maximumFractionDigits)) && _equalsHelper(this.maximumIntegerDigits, properties.maximumIntegerDigits)) && _equalsHelper(this.maximumSignificantDigits, properties.maximumSignificantDigits)) && _equalsHelper(this.measureFormatWidth, properties.measureFormatWidth)) && _equalsHelper(this.measureUnit, properties.measureUnit)) && _equalsHelper(this.minimumExponentDigits, properties.minimumExponentDigits)) && _equalsHelper(this.minimumFractionDigits, properties.minimumFractionDigits)) && _equalsHelper(this.minimumGroupingDigits, properties.minimumGroupingDigits)) && _equalsHelper(this.minimumIntegerDigits, properties.minimumIntegerDigits)) && _equalsHelper(this.minimumSignificantDigits, properties.minimumSignificantDigits)) && _equalsHelper(this.multiplier, properties.multiplier)) && _equalsHelper(this.negativePrefix, properties.negativePrefix)) && _equalsHelper(this.negativePrefixPattern, properties.negativePrefixPattern)) && _equalsHelper(this.negativeSuffix, properties.negativeSuffix)) && _equalsHelper(this.negativeSuffixPattern, properties.negativeSuffixPattern)) && _equalsHelper(this.padPosition, properties.padPosition)) && _equalsHelper(this.padString, properties.padString)) && _equalsHelper(this.parseCaseSensitive, properties.parseCaseSensitive)) && _equalsHelper(this.parseGroupingMode, properties.parseGroupingMode)) && _equalsHelper(this.parseIntegerOnly, properties.parseIntegerOnly)) && _equalsHelper(this.parseMode, properties.parseMode)) && _equalsHelper(this.parseNoExponent, properties.parseNoExponent)) && _equalsHelper(this.parseToBigDecimal, properties.parseToBigDecimal)) && _equalsHelper(this.positivePrefix, properties.positivePrefix)) && _equalsHelper(this.positivePrefixPattern, properties.positivePrefixPattern)) && _equalsHelper(this.positiveSuffix, properties.positiveSuffix)) && _equalsHelper(this.positiveSuffixPattern, properties.positiveSuffixPattern)) && _equalsHelper(this.roundingIncrement, properties.roundingIncrement)) && _equalsHelper(this.roundingMode, properties.roundingMode)) && _equalsHelper(this.secondaryGroupingSize, properties.secondaryGroupingSize)) && _equalsHelper(this.signAlwaysShown, properties.signAlwaysShown)) && _equalsHelper(this.significantDigitsMode, properties.significantDigitsMode);
    }

    private boolean _equalsHelper(boolean z, boolean z2) {
        return z == z2;
    }

    private boolean _equalsHelper(int i, int i2) {
        return i == i2;
    }

    private boolean _equalsHelper(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    private int _hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((_hashCodeHelper(this.compactStyle) ^ 0) ^ _hashCodeHelper(this.currency)) ^ _hashCodeHelper(this.currencyPluralInfo)) ^ _hashCodeHelper(this.currencyStyle)) ^ _hashCodeHelper(this.currencyUsage)) ^ _hashCodeHelper(this.decimalPatternMatchRequired)) ^ _hashCodeHelper(this.decimalSeparatorAlwaysShown)) ^ _hashCodeHelper(this.exponentSignAlwaysShown)) ^ _hashCodeHelper(this.formatWidth)) ^ _hashCodeHelper(this.groupingSize)) ^ _hashCodeHelper(this.magnitudeMultiplier)) ^ _hashCodeHelper(this.mathContext)) ^ _hashCodeHelper(this.maximumFractionDigits)) ^ _hashCodeHelper(this.maximumIntegerDigits)) ^ _hashCodeHelper(this.maximumSignificantDigits)) ^ _hashCodeHelper(this.measureFormatWidth)) ^ _hashCodeHelper(this.measureUnit)) ^ _hashCodeHelper(this.minimumExponentDigits)) ^ _hashCodeHelper(this.minimumFractionDigits)) ^ _hashCodeHelper(this.minimumGroupingDigits)) ^ _hashCodeHelper(this.minimumIntegerDigits)) ^ _hashCodeHelper(this.minimumSignificantDigits)) ^ _hashCodeHelper(this.multiplier)) ^ _hashCodeHelper(this.negativePrefix)) ^ _hashCodeHelper(this.negativePrefixPattern)) ^ _hashCodeHelper(this.negativeSuffix)) ^ _hashCodeHelper(this.negativeSuffixPattern)) ^ _hashCodeHelper(this.padPosition)) ^ _hashCodeHelper(this.padString)) ^ _hashCodeHelper(this.parseCaseSensitive)) ^ _hashCodeHelper(this.parseGroupingMode)) ^ _hashCodeHelper(this.parseIntegerOnly)) ^ _hashCodeHelper(this.parseMode)) ^ _hashCodeHelper(this.parseNoExponent)) ^ _hashCodeHelper(this.parseToBigDecimal)) ^ _hashCodeHelper(this.positivePrefix)) ^ _hashCodeHelper(this.positivePrefixPattern)) ^ _hashCodeHelper(this.positiveSuffix)) ^ _hashCodeHelper(this.positiveSuffixPattern)) ^ _hashCodeHelper(this.roundingIncrement)) ^ _hashCodeHelper(this.roundingMode)) ^ _hashCodeHelper(this.secondaryGroupingSize)) ^ _hashCodeHelper(this.signAlwaysShown)) ^ _hashCodeHelper(this.significantDigitsMode);
    }

    private int _hashCodeHelper(boolean z) {
        return z ? 1 : 0;
    }

    private int _hashCodeHelper(int i) {
        return i * 13;
    }

    private int _hashCodeHelper(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public Properties clear() {
        return _clear();
    }

    @Override // java.lang.Object
    public Properties clone() {
        try {
            return (Properties) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public Properties copyFrom(Properties properties) {
        return _copyFrom(properties);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Properties)) {
            return false;
        }
        return _equals((Properties) obj);
    }

    @Override // com.ibm.icu.impl.number.formatters.CompactDecimalFormat.IProperties
    public CompactDecimalFormat.CompactStyle getCompactStyle() {
        return this.compactStyle;
    }

    @Override // com.ibm.icu.impl.number.formatters.CurrencyFormat.ICurrencyProperties
    public Currency getCurrency() {
        return this.currency;
    }

    @Override // com.ibm.icu.impl.number.formatters.CurrencyFormat.ICurrencyProperties
    @Deprecated
    public CurrencyPluralInfo getCurrencyPluralInfo() {
        return this.currencyPluralInfo;
    }

    @Override // com.ibm.icu.impl.number.formatters.CurrencyFormat.ICurrencyProperties
    public CurrencyFormat.CurrencyStyle getCurrencyStyle() {
        return this.currencyStyle;
    }

    @Override // com.ibm.icu.impl.number.formatters.CurrencyFormat.ICurrencyProperties
    public Currency.CurrencyUsage getCurrencyUsage() {
        return this.currencyUsage;
    }

    @Override // com.ibm.icu.impl.number.Parse.IProperties
    public boolean getDecimalPatternMatchRequired() {
        return this.decimalPatternMatchRequired;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveDecimalFormat.IProperties
    public boolean getDecimalSeparatorAlwaysShown() {
        return this.decimalSeparatorAlwaysShown;
    }

    @Override // com.ibm.icu.impl.number.formatters.ScientificFormat.IProperties
    public boolean getExponentSignAlwaysShown() {
        return this.exponentSignAlwaysShown;
    }

    @Override // com.ibm.icu.impl.number.formatters.PaddingFormat.IProperties
    public int getFormatWidth() {
        return this.formatWidth;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveDecimalFormat.IProperties
    public int getGroupingSize() {
        return this.groupingSize;
    }

    @Override // com.ibm.icu.impl.number.formatters.MagnitudeMultiplier.IProperties
    public int getMagnitudeMultiplier() {
        return this.magnitudeMultiplier;
    }

    @Override // com.ibm.icu.impl.number.Rounder.IBasicRoundingProperties
    public MathContext getMathContext() {
        return this.mathContext;
    }

    @Override // com.ibm.icu.impl.number.Rounder.IBasicRoundingProperties
    public int getMaximumFractionDigits() {
        return this.maximumFractionDigits;
    }

    @Override // com.ibm.icu.impl.number.Rounder.IBasicRoundingProperties
    public int getMaximumIntegerDigits() {
        return this.maximumIntegerDigits;
    }

    @Override // com.ibm.icu.impl.number.rounders.SignificantDigitsRounder.IProperties
    public int getMaximumSignificantDigits() {
        return this.maximumSignificantDigits;
    }

    @Override // com.ibm.icu.impl.number.formatters.MeasureFormat.IProperties
    public MeasureFormat.FormatWidth getMeasureFormatWidth() {
        return this.measureFormatWidth;
    }

    @Override // com.ibm.icu.impl.number.formatters.MeasureFormat.IProperties
    public MeasureUnit getMeasureUnit() {
        return this.measureUnit;
    }

    @Override // com.ibm.icu.impl.number.formatters.ScientificFormat.IProperties
    public int getMinimumExponentDigits() {
        return this.minimumExponentDigits;
    }

    @Override // com.ibm.icu.impl.number.Rounder.IBasicRoundingProperties
    public int getMinimumFractionDigits() {
        return this.minimumFractionDigits;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveDecimalFormat.IProperties
    public int getMinimumGroupingDigits() {
        return this.minimumGroupingDigits;
    }

    @Override // com.ibm.icu.impl.number.Rounder.IBasicRoundingProperties
    public int getMinimumIntegerDigits() {
        return this.minimumIntegerDigits;
    }

    @Override // com.ibm.icu.impl.number.rounders.SignificantDigitsRounder.IProperties
    public int getMinimumSignificantDigits() {
        return this.minimumSignificantDigits;
    }

    @Override // com.ibm.icu.impl.number.formatters.BigDecimalMultiplier.IProperties
    public BigDecimal getMultiplier() {
        return this.multiplier;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat.IProperties
    public String getNegativePrefix() {
        return this.negativePrefix;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat.IProperties
    public String getNegativePrefixPattern() {
        return this.negativePrefixPattern;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat.IProperties
    public String getNegativeSuffix() {
        return this.negativeSuffix;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat.IProperties
    public String getNegativeSuffixPattern() {
        return this.negativeSuffixPattern;
    }

    @Override // com.ibm.icu.impl.number.formatters.PaddingFormat.IProperties
    public PaddingFormat.PadPosition getPadPosition() {
        return this.padPosition;
    }

    @Override // com.ibm.icu.impl.number.formatters.PaddingFormat.IProperties
    public String getPadString() {
        return this.padString;
    }

    @Override // com.ibm.icu.impl.number.Parse.IProperties
    public boolean getParseCaseSensitive() {
        return this.parseCaseSensitive;
    }

    @Override // com.ibm.icu.impl.number.Parse.IProperties
    public Parse.GroupingMode getParseGroupingMode() {
        return this.parseGroupingMode;
    }

    @Override // com.ibm.icu.impl.number.Parse.IProperties
    public boolean getParseIntegerOnly() {
        return this.parseIntegerOnly;
    }

    @Override // com.ibm.icu.impl.number.Parse.IProperties
    public Parse.ParseMode getParseMode() {
        return this.parseMode;
    }

    @Override // com.ibm.icu.impl.number.Parse.IProperties
    public boolean getParseNoExponent() {
        return this.parseNoExponent;
    }

    @Override // com.ibm.icu.impl.number.Parse.IProperties
    public boolean getParseToBigDecimal() {
        return this.parseToBigDecimal;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat.IProperties
    public String getPositivePrefix() {
        return this.positivePrefix;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat.IProperties
    public String getPositivePrefixPattern() {
        return this.positivePrefixPattern;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat.IProperties
    public String getPositiveSuffix() {
        return this.positiveSuffix;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat.IProperties
    public String getPositiveSuffixPattern() {
        return this.positiveSuffixPattern;
    }

    @Override // com.ibm.icu.impl.number.rounders.IncrementRounder.IProperties
    public BigDecimal getRoundingIncrement() {
        return this.roundingIncrement;
    }

    @Override // com.ibm.icu.impl.number.Rounder.IBasicRoundingProperties
    public RoundingMode getRoundingMode() {
        return this.roundingMode;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveDecimalFormat.IProperties
    public int getSecondaryGroupingSize() {
        return this.secondaryGroupingSize;
    }

    @Override // com.ibm.icu.impl.number.formatters.PositiveNegativeAffixFormat.IProperties
    public boolean getSignAlwaysShown() {
        return this.signAlwaysShown;
    }

    @Override // com.ibm.icu.impl.number.rounders.SignificantDigitsRounder.IProperties
    public DecimalFormat.SignificantDigitsMode getSignificantDigitsMode() {
        return this.significantDigitsMode;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return _hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        clear();
        objectInputStream.readInt();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            String str = (String) objectInputStream.readObject();
            try {
                try {
                    Properties.class.getDeclaredField(str).set(this, objectInputStream.readObject());
                } catch (IllegalArgumentException e) {
                    throw new AssertionError(e);
                } catch (IllegalAccessException e2) {
                    throw new AssertionError(e2);
                }
            } catch (NoSuchFieldException e3) {
            } catch (SecurityException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    public Properties setCompactStyle(CompactDecimalFormat.CompactStyle compactStyle2) {
        this.compactStyle = compactStyle2;
        return this;
    }

    public Properties setCurrency(Currency currency2) {
        this.currency = currency2;
        return this;
    }

    @Deprecated
    public Properties setCurrencyPluralInfo(CurrencyPluralInfo currencyPluralInfo2) {
        if (currencyPluralInfo2 != null) {
            currencyPluralInfo2 = (CurrencyPluralInfo) currencyPluralInfo2.clone();
        }
        this.currencyPluralInfo = currencyPluralInfo2;
        return this;
    }

    public Properties setCurrencyUsage(Currency.CurrencyUsage currencyUsage2) {
        this.currencyUsage = currencyUsage2;
        return this;
    }

    public Properties setDecimalPatternMatchRequired(boolean z) {
        this.decimalPatternMatchRequired = z;
        return this;
    }

    public Properties setDecimalSeparatorAlwaysShown(boolean z) {
        this.decimalSeparatorAlwaysShown = z;
        return this;
    }

    public Properties setExponentSignAlwaysShown(boolean z) {
        this.exponentSignAlwaysShown = z;
        return this;
    }

    public Properties setFormatWidth(int i) {
        this.formatWidth = i;
        return this;
    }

    public Properties setGroupingSize(int i) {
        this.groupingSize = i;
        return this;
    }

    public Properties setMagnitudeMultiplier(int i) {
        this.magnitudeMultiplier = i;
        return this;
    }

    public Properties setMathContext(MathContext mathContext2) {
        this.mathContext = mathContext2;
        return this;
    }

    public Properties setMaximumFractionDigits(int i) {
        this.maximumFractionDigits = i;
        return this;
    }

    public Properties setMaximumIntegerDigits(int i) {
        this.maximumIntegerDigits = i;
        return this;
    }

    public Properties setMaximumSignificantDigits(int i) {
        this.maximumSignificantDigits = i;
        return this;
    }

    public Properties setMinimumExponentDigits(int i) {
        this.minimumExponentDigits = i;
        return this;
    }

    public Properties setMinimumFractionDigits(int i) {
        this.minimumFractionDigits = i;
        return this;
    }

    public Properties setMinimumGroupingDigits(int i) {
        this.minimumGroupingDigits = i;
        return this;
    }

    public Properties setMinimumIntegerDigits(int i) {
        this.minimumIntegerDigits = i;
        return this;
    }

    public Properties setMinimumSignificantDigits(int i) {
        this.minimumSignificantDigits = i;
        return this;
    }

    public Properties setMultiplier(BigDecimal bigDecimal) {
        this.multiplier = bigDecimal;
        return this;
    }

    public Properties setNegativePrefix(String str) {
        this.negativePrefix = str;
        return this;
    }

    public Properties setNegativePrefixPattern(String str) {
        this.negativePrefixPattern = str;
        return this;
    }

    public Properties setNegativeSuffix(String str) {
        this.negativeSuffix = str;
        return this;
    }

    public Properties setNegativeSuffixPattern(String str) {
        this.negativeSuffixPattern = str;
        return this;
    }

    public Properties setPadPosition(PaddingFormat.PadPosition padPosition2) {
        this.padPosition = padPosition2;
        return this;
    }

    public Properties setPadString(String str) {
        this.padString = str;
        return this;
    }

    public Properties setParseIntegerOnly(boolean z) {
        this.parseIntegerOnly = z;
        return this;
    }

    public Properties setParseMode(Parse.ParseMode parseMode2) {
        this.parseMode = parseMode2;
        return this;
    }

    public Properties setParseToBigDecimal(boolean z) {
        this.parseToBigDecimal = z;
        return this;
    }

    public Properties setPositivePrefix(String str) {
        this.positivePrefix = str;
        return this;
    }

    public Properties setPositivePrefixPattern(String str) {
        this.positivePrefixPattern = str;
        return this;
    }

    public Properties setPositiveSuffix(String str) {
        this.positiveSuffix = str;
        return this;
    }

    public Properties setPositiveSuffixPattern(String str) {
        this.positiveSuffixPattern = str;
        return this;
    }

    public Properties setRoundingIncrement(BigDecimal bigDecimal) {
        this.roundingIncrement = bigDecimal;
        return this;
    }

    public Properties setRoundingMode(RoundingMode roundingMode2) {
        this.roundingMode = roundingMode2;
        return this;
    }

    public Properties setSecondaryGroupingSize(int i) {
        this.secondaryGroupingSize = i;
        return this;
    }

    public Properties setSignificantDigitsMode(DecimalFormat.SignificantDigitsMode significantDigitsMode2) {
        this.significantDigitsMode = significantDigitsMode2;
        return this;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Properties");
        toStringBare(sb);
        sb.append(">");
        return sb.toString();
    }

    public void toStringBare(StringBuilder sb) {
        Field[] declaredFields = Properties.class.getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                Object obj = field.get(this);
                Object obj2 = field.get(DEFAULT);
                if (obj != null || obj2 != null) {
                    if (obj == null || obj2 == null) {
                        sb.append(" " + field.getName() + ":" + obj);
                    } else {
                        if (!obj.equals(obj2)) {
                            sb.append(" " + field.getName() + ":" + obj);
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(0);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Field[] declaredFields = Properties.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                try {
                    Object obj = field.get(this);
                    if (obj != null && !obj.equals(field.get(DEFAULT))) {
                        arrayList.add(field);
                        arrayList2.add(obj);
                    }
                } catch (IllegalArgumentException e) {
                    throw new AssertionError(e);
                } catch (IllegalAccessException e2) {
                    throw new AssertionError(e2);
                }
            }
        }
        int size = arrayList.size();
        objectOutputStream.writeInt(size);
        for (int i = 0; i < size; i++) {
            Object obj2 = arrayList2.get(i);
            objectOutputStream.writeObject(((Field) arrayList.get(i)).getName());
            objectOutputStream.writeObject(obj2);
        }
    }
}
