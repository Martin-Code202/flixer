package com.ibm.icu.impl.number;

import android.support.v4.view.PagerAdapter;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.TextTrieMap;
import com.ibm.icu.impl.number.formatters.BigDecimalMultiplier;
import com.ibm.icu.impl.number.formatters.MagnitudeMultiplier;
import com.ibm.icu.impl.number.formatters.PaddingFormat;
import com.ibm.icu.impl.number.formatters.PositiveDecimalFormat;
import com.ibm.icu.impl.number.formatters.ScientificFormat;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.CurrencyPluralInfo;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.ULocale;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.ParsePosition;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
public class Parse {
    static final /* synthetic */ boolean $assertionsDisabled = (!Parse.class.desiredAssertionStatus());
    public static volatile boolean DEBUGGING = false;
    private static final UnicodeSet UNISET_BIDI = new UnicodeSet("[[\\u200E\\u200F\\u061C]]").freeze();
    private static final UnicodeSet UNISET_COMMA_LIKE = new UnicodeSet("[,\\u060C\\u066B\\u3001\\uFE10\\uFE11\\uFE50\\uFE51\\uFF0C\\uFF64]").freeze();
    @Deprecated
    public static final UnicodeSet UNISET_MINUS = new UnicodeSet(45, 45, 8315, 8315, 8331, 8331, 8722, 8722, 10134, 10134, 65123, 65123, 65293, 65293).freeze();
    private static final UnicodeSet UNISET_OTHER_GROUPING_SEPARATORS = new UnicodeSet("[\\ '\\u00A0\\u066C\\u2000-\\u200A\\u2018\\u2019\\u202F\\u205F\\u3000\\uFF07]").freeze();
    private static final UnicodeSet UNISET_PERIOD_LIKE = new UnicodeSet("[.\\u2024\\u3002\\uFE12\\uFE52\\uFF0E\\uFF61]").freeze();
    @Deprecated
    public static final UnicodeSet UNISET_PLUS = new UnicodeSet(43, 43, 8314, 8314, 8330, 8330, 10133, 10133, 64297, 64297, 65122, 65122, 65291, 65291).freeze();
    private static final UnicodeSet UNISET_STRICT_COMMA_LIKE = new UnicodeSet("[,\\u066B\\uFE10\\uFE50\\uFF0C]").freeze();
    private static final UnicodeSet UNISET_STRICT_PERIOD_LIKE = new UnicodeSet("[.\\u2024\\uFE52\\uFF0E\\uFF61]").freeze();
    private static final UnicodeSet UNISET_WHITESPACE = new UnicodeSet("[[:whitespace:][\\u2000-\\u200D]]").freeze();
    protected static final ThreadLocal<ParsePosition> threadLocalParsePosition = new ThreadLocal<ParsePosition>() { // from class: com.ibm.icu.impl.number.Parse.2
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ParsePosition initialValue() {
            return new ParsePosition(0);
        }
    };
    protected static final ThreadLocal<ParserState> threadLocalParseState = new ThreadLocal<ParserState>() { // from class: com.ibm.icu.impl.number.Parse.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ParserState initialValue() {
            return new ParserState();
        }
    };

    /* access modifiers changed from: package-private */
    public enum DigitType {
        INTEGER,
        FRACTION,
        EXPONENT
    }

    public enum GroupingMode {
        DEFAULT,
        RESTRICTED
    }

    public interface IProperties extends PaddingFormat.IProperties, BigDecimalMultiplier.IProperties, MagnitudeMultiplier.IProperties, PositiveDecimalFormat.IProperties, ScientificFormat.IProperties {
        public static final GroupingMode DEFAULT_PARSE_GROUPING_MODE = null;
        public static final ParseMode DEFAULT_PARSE_MODE = null;

        boolean getDecimalPatternMatchRequired();

        boolean getParseCaseSensitive();

        GroupingMode getParseGroupingMode();

        boolean getParseIntegerOnly();

        ParseMode getParseMode();

        boolean getParseNoExponent();

        boolean getParseToBigDecimal();
    }

    public enum ParseMode {
        LENIENT,
        STRICT,
        FAST
    }

    /* access modifiers changed from: package-private */
    public enum StateName {
        BEFORE_PREFIX,
        AFTER_PREFIX,
        AFTER_INTEGER_DIGIT,
        AFTER_FRACTION_DIGIT,
        AFTER_EXPONENT_SEPARATOR,
        AFTER_EXPONENT_DIGIT,
        BEFORE_SUFFIX,
        BEFORE_SUFFIX_SEEN_EXPONENT,
        AFTER_SUFFIX,
        INSIDE_CURRENCY,
        INSIDE_DIGIT,
        INSIDE_STRING,
        INSIDE_AFFIX_PATTERN
    }

    /* access modifiers changed from: package-private */
    public enum SeparatorType {
        COMMA_LIKE,
        PERIOD_LIKE,
        OTHER_GROUPING,
        UNKNOWN;

        static SeparatorType fromCp(int i, ParseMode parseMode) {
            if (parseMode == ParseMode.FAST) {
                return UNKNOWN;
            }
            if (parseMode == ParseMode.STRICT) {
                if (Parse.UNISET_STRICT_COMMA_LIKE.contains(i)) {
                    return COMMA_LIKE;
                }
                if (Parse.UNISET_STRICT_PERIOD_LIKE.contains(i)) {
                    return PERIOD_LIKE;
                }
                if (Parse.UNISET_OTHER_GROUPING_SEPARATORS.contains(i)) {
                    return OTHER_GROUPING;
                }
                return UNKNOWN;
            } else if (Parse.UNISET_COMMA_LIKE.contains(i)) {
                return COMMA_LIKE;
            } else {
                if (Parse.UNISET_PERIOD_LIKE.contains(i)) {
                    return PERIOD_LIKE;
                }
                if (Parse.UNISET_OTHER_GROUPING_SEPARATORS.contains(i)) {
                    return OTHER_GROUPING;
                }
                return UNKNOWN;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class StateItem {
        static final /* synthetic */ boolean $assertionsDisabled = (!Parse.class.desiredAssertionStatus());
        AffixHolder affix;
        CharSequence currentAffixPattern;
        TextTrieMap<Currency.CurrencyStringInfo>.ParseState currentCurrencyTrieState;
        TextTrieMap<Byte>.ParseState currentDigitTrieState;
        DigitType currentDigitType;
        int currentOffset;
        long currentStepwiseParserTag;
        CharSequence currentString;
        boolean currentTrailing;
        int exponent;
        FormatQuantity4 fq = new FormatQuantity4();
        int groupingCp;
        long groupingWidths;
        final char id;
        String isoCode;
        StateName name;
        int numDigits;
        String path;
        StateName returnTo1;
        StateName returnTo2;
        boolean sawCurrency;
        boolean sawDecimalPoint;
        boolean sawExponentDigit;
        boolean sawInfinity;
        boolean sawNaN;
        boolean sawNegative;
        boolean sawNegativeExponent;
        boolean sawPrefix;
        boolean sawSuffix;
        int score;
        int trailingCount;
        int trailingZeros;

        StateItem(char c) {
            this.id = c;
        }

        /* access modifiers changed from: package-private */
        public StateItem clear() {
            this.name = StateName.BEFORE_PREFIX;
            this.trailingCount = 0;
            this.score = 0;
            this.fq.clear();
            this.numDigits = 0;
            this.trailingZeros = 0;
            this.exponent = 0;
            this.groupingCp = -1;
            this.groupingWidths = 0;
            this.isoCode = null;
            this.sawNegative = false;
            this.sawNegativeExponent = false;
            this.sawCurrency = false;
            this.sawNaN = false;
            this.sawInfinity = false;
            this.affix = null;
            this.sawPrefix = false;
            this.sawSuffix = false;
            this.sawDecimalPoint = false;
            this.sawExponentDigit = false;
            this.returnTo1 = null;
            this.returnTo2 = null;
            this.currentString = null;
            this.currentOffset = 0;
            this.currentTrailing = false;
            this.currentAffixPattern = null;
            this.currentStepwiseParserTag = 0;
            this.currentCurrencyTrieState = null;
            this.currentDigitTrieState = null;
            this.currentDigitType = null;
            this.path = "";
            return this;
        }

        /* access modifiers changed from: package-private */
        public StateItem copyFrom(StateItem stateItem, StateName stateName, int i) {
            this.name = stateName;
            this.score = stateItem.score;
            this.trailingCount = i < 0 ? 0 : stateItem.trailingCount + Character.charCount(i);
            this.fq.copyFrom(stateItem.fq);
            this.numDigits = stateItem.numDigits;
            this.trailingZeros = stateItem.trailingZeros;
            this.exponent = stateItem.exponent;
            this.groupingCp = stateItem.groupingCp;
            this.groupingWidths = stateItem.groupingWidths;
            this.isoCode = stateItem.isoCode;
            this.sawNegative = stateItem.sawNegative;
            this.sawNegativeExponent = stateItem.sawNegativeExponent;
            this.sawCurrency = stateItem.sawCurrency;
            this.sawNaN = stateItem.sawNaN;
            this.sawInfinity = stateItem.sawInfinity;
            this.affix = stateItem.affix;
            this.sawPrefix = stateItem.sawPrefix;
            this.sawSuffix = stateItem.sawSuffix;
            this.sawDecimalPoint = stateItem.sawDecimalPoint;
            this.sawExponentDigit = stateItem.sawExponentDigit;
            this.returnTo1 = stateItem.returnTo1;
            this.returnTo2 = stateItem.returnTo2;
            this.currentString = stateItem.currentString;
            this.currentOffset = stateItem.currentOffset;
            this.currentTrailing = stateItem.currentTrailing;
            this.currentAffixPattern = stateItem.currentAffixPattern;
            this.currentStepwiseParserTag = stateItem.currentStepwiseParserTag;
            this.currentCurrencyTrieState = stateItem.currentCurrencyTrieState;
            this.currentDigitTrieState = stateItem.currentDigitTrieState;
            this.currentDigitType = stateItem.currentDigitType;
            if (Parse.DEBUGGING) {
                this.path = stateItem.path + stateItem.id;
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public void appendDigit(byte b, DigitType digitType) {
            if (digitType == DigitType.EXPONENT) {
                this.sawExponentDigit = true;
                int i = (this.exponent * 10) + b;
                if (i < this.exponent) {
                    this.exponent = Integer.MAX_VALUE;
                } else {
                    this.exponent = i;
                }
            } else {
                this.numDigits++;
                if (digitType == DigitType.FRACTION && b == 0) {
                    this.trailingZeros++;
                } else if (digitType == DigitType.FRACTION) {
                    this.fq.appendDigit(b, this.trailingZeros, false);
                    this.trailingZeros = 0;
                } else {
                    this.fq.appendDigit(b, 0, true);
                }
            }
        }

        public boolean hasNumber() {
            return this.numDigits > 0 || this.sawNaN || this.sawInfinity;
        }

        /* access modifiers changed from: package-private */
        public Number toNumber(IProperties iProperties) {
            if (this.sawNaN) {
                return Double.valueOf(Double.NaN);
            }
            if (this.sawInfinity) {
                if (this.sawNegative) {
                    return Double.valueOf(Double.NEGATIVE_INFINITY);
                }
                return Double.valueOf(Double.POSITIVE_INFINITY);
            } else if (this.fq.isZero() && this.sawNegative) {
                return Double.valueOf(-0.0d);
            } else {
                boolean parseToBigDecimal = iProperties.getParseToBigDecimal();
                if (this.exponent != Integer.MAX_VALUE) {
                    if (this.exponent > 1000) {
                        parseToBigDecimal = true;
                    }
                    BigDecimal multiplier = iProperties.getMultiplier();
                    if (iProperties.getMagnitudeMultiplier() != 0) {
                        if (multiplier == null) {
                            multiplier = BigDecimal.ONE;
                        }
                        multiplier = multiplier.scaleByPowerOfTen(iProperties.getMagnitudeMultiplier());
                    }
                    int i = (this.sawNegativeExponent ? -1 : 1) * this.exponent;
                    MathContext mathContextOr16Digits = RoundingUtils.getMathContextOr16Digits(iProperties);
                    BigDecimal bigDecimal = this.fq.toBigDecimal();
                    if (this.sawNegative) {
                        bigDecimal = bigDecimal.negate();
                    }
                    BigDecimal scaleByPowerOfTen = bigDecimal.scaleByPowerOfTen(i);
                    if (multiplier != null) {
                        scaleByPowerOfTen = scaleByPowerOfTen.divide(multiplier, mathContextOr16Digits);
                    }
                    BigDecimal stripTrailingZeros = scaleByPowerOfTen.stripTrailingZeros();
                    if (parseToBigDecimal || stripTrailingZeros.scale() > 0) {
                        return stripTrailingZeros;
                    }
                    if ((-stripTrailingZeros.scale()) + stripTrailingZeros.precision() <= 18) {
                        return Long.valueOf(stripTrailingZeros.longValueExact());
                    }
                    return stripTrailingZeros.toBigIntegerExact();
                } else if (this.sawNegativeExponent && this.sawNegative) {
                    return Double.valueOf(-0.0d);
                } else {
                    if (this.sawNegativeExponent) {
                        return Double.valueOf(0.0d);
                    }
                    if (this.sawNegative) {
                        return Double.valueOf(Double.NEGATIVE_INFINITY);
                    }
                    return Double.valueOf(Double.POSITIVE_INFINITY);
                }
            }
        }

        public CurrencyAmount toCurrencyAmount(IProperties iProperties) {
            if ($assertionsDisabled || this.isoCode != null) {
                return new CurrencyAmount(toNumber(iProperties), Currency.getInstance(this.isoCode));
            }
            throw new AssertionError();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.path);
            sb.append("] ");
            sb.append(this.name.name());
            if (this.name == StateName.INSIDE_STRING) {
                sb.append("{");
                sb.append(this.currentString);
                sb.append(":");
                sb.append(this.currentOffset);
                sb.append("}");
            }
            if (this.name == StateName.INSIDE_AFFIX_PATTERN) {
                sb.append("{");
                sb.append(this.currentAffixPattern);
                sb.append(":");
                sb.append(AffixPatternUtils.getOffset(this.currentStepwiseParserTag) - 1);
                sb.append("}");
            }
            sb.append(" ");
            sb.append(this.fq.toBigDecimal());
            sb.append(" grouping:");
            sb.append(this.groupingCp == -1 ? new char[]{'?'} : Character.toChars(this.groupingCp));
            sb.append(" widths:");
            sb.append(Long.toHexString(this.groupingWidths));
            sb.append(" seen:");
            sb.append(this.sawNegative ? 1 : 0);
            sb.append(this.sawNegativeExponent ? 1 : 0);
            sb.append(this.sawNaN ? 1 : 0);
            sb.append(this.sawInfinity ? 1 : 0);
            sb.append(this.sawPrefix ? 1 : 0);
            sb.append(this.sawSuffix ? 1 : 0);
            sb.append(this.sawDecimalPoint ? 1 : 0);
            sb.append(" trailing:");
            sb.append(this.trailingCount);
            sb.append(" score:");
            sb.append(this.score);
            sb.append(" affix:");
            sb.append(this.affix);
            sb.append(" currency:");
            sb.append(this.isoCode);
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static class ParserState {
        static final /* synthetic */ boolean $assertionsDisabled = (!Parse.class.desiredAssertionStatus());
        Set<AffixHolder> affixHolders = new HashSet();
        boolean caseSensitive;
        int decimalCp1;
        int decimalCp2;
        SeparatorType decimalType1;
        SeparatorType decimalType2;
        TextTrieMap<Byte> digitTrie;
        int groupingCp1;
        int groupingCp2;
        GroupingMode groupingMode;
        SeparatorType groupingType1;
        SeparatorType groupingType2;
        StateItem[] items = new StateItem[16];
        int length;
        ParseMode mode;
        boolean parseCurrency;
        StateItem[] prevItems = new StateItem[16];
        int prevLength;
        IProperties properties;
        DecimalFormatSymbols symbols;

        ParserState() {
            for (int i = 0; i < this.items.length; i++) {
                this.items[i] = new StateItem((char) (i + 65));
                this.prevItems[i] = new StateItem((char) (i + 65));
            }
        }

        /* access modifiers changed from: package-private */
        public ParserState clear() {
            this.length = 0;
            this.prevLength = 0;
            this.digitTrie = null;
            this.affixHolders.clear();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void swap() {
            StateItem[] stateItemArr = this.prevItems;
            this.prevItems = this.items;
            this.items = stateItemArr;
            this.prevLength = this.length;
            this.length = 0;
        }

        /* access modifiers changed from: package-private */
        public void swapBack() {
            StateItem[] stateItemArr = this.prevItems;
            this.prevItems = this.items;
            this.items = stateItemArr;
            this.length = this.prevLength;
            this.prevLength = 0;
        }

        /* access modifiers changed from: package-private */
        public StateItem getNext() {
            if (this.length >= this.items.length) {
                this.length = this.items.length - 1;
            }
            StateItem stateItem = this.items[this.length];
            this.length++;
            return stateItem;
        }

        public int lastInsertedIndex() {
            if ($assertionsDisabled || this.length > 0) {
                return this.length - 1;
            }
            throw new AssertionError();
        }

        public StateItem getItem(int i) {
            if ($assertionsDisabled || (i >= 0 && i < this.length)) {
                return this.items[i];
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public static class AffixHolder {
        static final AffixHolder EMPTY_NEGATIVE = new AffixHolder("", "", true, true);
        static final AffixHolder EMPTY_POSITIVE = new AffixHolder("", "", true, false);
        final boolean negative;
        final String p;
        final String s;
        final boolean strings;

        static void addToState(ParserState parserState, IProperties iProperties) {
            AffixHolder fromPropertiesPositivePattern = fromPropertiesPositivePattern(iProperties);
            AffixHolder fromPropertiesNegativePattern = fromPropertiesNegativePattern(iProperties);
            AffixHolder fromPropertiesPositiveString = fromPropertiesPositiveString(iProperties);
            AffixHolder fromPropertiesNegativeString = fromPropertiesNegativeString(iProperties);
            if (fromPropertiesPositivePattern != null) {
                parserState.affixHolders.add(fromPropertiesPositivePattern);
            }
            if (fromPropertiesPositiveString != null) {
                parserState.affixHolders.add(fromPropertiesPositiveString);
            }
            if (fromPropertiesNegativePattern != null) {
                parserState.affixHolders.add(fromPropertiesNegativePattern);
            }
            if (fromPropertiesNegativeString != null) {
                parserState.affixHolders.add(fromPropertiesNegativeString);
            }
        }

        static AffixHolder fromPropertiesPositivePattern(IProperties iProperties) {
            String positivePrefixPattern = iProperties.getPositivePrefixPattern();
            String positiveSuffixPattern = iProperties.getPositiveSuffixPattern();
            if (iProperties.getSignAlwaysShown()) {
                boolean z = false;
                String negativePrefixPattern = iProperties.getNegativePrefixPattern();
                String negativeSuffixPattern = iProperties.getNegativeSuffixPattern();
                if (AffixPatternUtils.containsType(negativePrefixPattern, -1)) {
                    z = true;
                    positivePrefixPattern = AffixPatternUtils.replaceType(negativePrefixPattern, -1, '+');
                }
                if (AffixPatternUtils.containsType(negativeSuffixPattern, -1)) {
                    z = true;
                    positiveSuffixPattern = AffixPatternUtils.replaceType(negativeSuffixPattern, -1, '+');
                }
                if (!z) {
                    positivePrefixPattern = "+" + positivePrefixPattern;
                }
            }
            return getInstance(positivePrefixPattern, positiveSuffixPattern, false, false);
        }

        static AffixHolder fromPropertiesNegativePattern(IProperties iProperties) {
            String negativePrefixPattern = iProperties.getNegativePrefixPattern();
            String negativeSuffixPattern = iProperties.getNegativeSuffixPattern();
            if (negativePrefixPattern == null && negativeSuffixPattern == null) {
                String positivePrefixPattern = iProperties.getPositivePrefixPattern();
                negativeSuffixPattern = iProperties.getPositiveSuffixPattern();
                negativePrefixPattern = positivePrefixPattern == null ? "-" : "-" + positivePrefixPattern;
            }
            return getInstance(negativePrefixPattern, negativeSuffixPattern, false, true);
        }

        static AffixHolder fromPropertiesPositiveString(IProperties iProperties) {
            String positivePrefix = iProperties.getPositivePrefix();
            String positiveSuffix = iProperties.getPositiveSuffix();
            if (positivePrefix == null && positiveSuffix == null) {
                return null;
            }
            return getInstance(positivePrefix, positiveSuffix, true, false);
        }

        static AffixHolder fromPropertiesNegativeString(IProperties iProperties) {
            String negativePrefix = iProperties.getNegativePrefix();
            String negativeSuffix = iProperties.getNegativeSuffix();
            if (negativePrefix == null && negativeSuffix == null) {
                return null;
            }
            return getInstance(negativePrefix, negativeSuffix, true, true);
        }

        static AffixHolder getInstance(String str, String str2, boolean z, boolean z2) {
            if (str == null && str2 == null) {
                return z2 ? EMPTY_NEGATIVE : EMPTY_POSITIVE;
            }
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            if (str.length() == 0 && str2.length() == 0) {
                return z2 ? EMPTY_NEGATIVE : EMPTY_POSITIVE;
            }
            return new AffixHolder(str, str2, z, z2);
        }

        AffixHolder(String str, String str2, boolean z, boolean z2) {
            this.p = str;
            this.s = str2;
            this.strings = z;
            this.negative = z2;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AffixHolder)) {
                return false;
            }
            AffixHolder affixHolder = (AffixHolder) obj;
            if (this.p.equals(affixHolder.p) && this.s.equals(affixHolder.s) && this.strings == affixHolder.strings && this.negative == affixHolder.negative) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.p.hashCode() ^ this.s.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append(this.p);
            sb.append("|");
            sb.append(this.s);
            sb.append("|");
            sb.append(this.strings ? 'S' : 'P');
            sb.append("}");
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static class CurrencyAffixPatterns {
        private static final ConcurrentHashMap<ULocale, CurrencyAffixPatterns> currencyAffixPatterns = new ConcurrentHashMap<>();
        private static final ThreadLocal<Properties> threadLocalProperties = new ThreadLocal<Properties>() { // from class: com.ibm.icu.impl.number.Parse.CurrencyAffixPatterns.1
            /* access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public Properties initialValue() {
                return new Properties();
            }
        };
        private final Set<AffixHolder> set = new HashSet();

        static void addToState(ULocale uLocale, ParserState parserState) {
            CurrencyAffixPatterns currencyAffixPatterns2 = currencyAffixPatterns.get(uLocale);
            if (currencyAffixPatterns2 == null) {
                currencyAffixPatterns.putIfAbsent(uLocale, new CurrencyAffixPatterns(uLocale));
                currencyAffixPatterns2 = currencyAffixPatterns.get(uLocale);
            }
            parserState.affixHolders.addAll(currencyAffixPatterns2.set);
        }

        private CurrencyAffixPatterns(ULocale uLocale) {
            addPattern(NumberFormat.getPatternForStyle(uLocale, 1));
            CurrencyPluralInfo instance = CurrencyPluralInfo.getInstance(uLocale);
            for (StandardPlural standardPlural : StandardPlural.VALUES) {
                addPattern(instance.getCurrencyPluralPattern(standardPlural.getKeyword()));
            }
        }

        private void addPattern(String str) {
            Properties properties = threadLocalProperties.get();
            try {
                PatternString.parseToExistingProperties(str, properties);
            } catch (IllegalArgumentException e) {
            }
            this.set.add(AffixHolder.fromPropertiesPositivePattern(properties));
            this.set.add(AffixHolder.fromPropertiesNegativePattern(properties));
        }
    }

    static TextTrieMap<Byte> makeDigitTrie(String[] strArr) {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= 10) {
                break;
            }
            String str = strArr[i];
            if (Character.charCount(Character.codePointAt(str, 0)) != str.length()) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return null;
        }
        TextTrieMap<Byte> textTrieMap = new TextTrieMap<>(false);
        for (int i2 = 0; i2 < 10; i2++) {
            textTrieMap.put(strArr[i2], Byte.valueOf((byte) i2));
        }
        return textTrieMap;
    }

    public static Number parse(CharSequence charSequence, ParsePosition parsePosition, IProperties iProperties, DecimalFormatSymbols decimalFormatSymbols) {
        StateItem _parse = _parse(charSequence, parsePosition, false, iProperties, decimalFormatSymbols);
        if (_parse == null) {
            return null;
        }
        return _parse.toNumber(iProperties);
    }

    public static CurrencyAmount parseCurrency(CharSequence charSequence, ParsePosition parsePosition, IProperties iProperties, DecimalFormatSymbols decimalFormatSymbols) {
        if (parsePosition == null) {
            parsePosition = threadLocalParsePosition.get();
            parsePosition.setIndex(0);
            parsePosition.setErrorIndex(-1);
        }
        StateItem _parse = _parse(charSequence, parsePosition, true, iProperties, decimalFormatSymbols);
        if (_parse == null) {
            return null;
        }
        return _parse.toCurrencyAmount(iProperties);
    }

    private static StateItem _parse(CharSequence charSequence, ParsePosition parsePosition, boolean z, IProperties iProperties, DecimalFormatSymbols decimalFormatSymbols) {
        if (charSequence == null || parsePosition == null || iProperties == null || decimalFormatSymbols == null) {
            throw new IllegalArgumentException("All arguments are required for parse.");
        }
        ParseMode parseMode = iProperties.getParseMode();
        if (parseMode == null) {
            parseMode = ParseMode.LENIENT;
        }
        boolean parseIntegerOnly = iProperties.getParseIntegerOnly();
        boolean parseNoExponent = iProperties.getParseNoExponent();
        ParserState clear = threadLocalParseState.get().clear();
        clear.properties = iProperties;
        clear.symbols = decimalFormatSymbols;
        clear.mode = parseMode;
        clear.parseCurrency = z;
        clear.groupingMode = iProperties.getParseGroupingMode();
        if (clear.groupingMode == null) {
            clear.groupingMode = GroupingMode.DEFAULT;
        }
        clear.caseSensitive = iProperties.getParseCaseSensitive();
        clear.decimalCp1 = Character.codePointAt(decimalFormatSymbols.getDecimalSeparatorString(), 0);
        clear.decimalCp2 = Character.codePointAt(decimalFormatSymbols.getMonetaryDecimalSeparatorString(), 0);
        clear.groupingCp1 = Character.codePointAt(decimalFormatSymbols.getGroupingSeparatorString(), 0);
        clear.groupingCp2 = Character.codePointAt(decimalFormatSymbols.getMonetaryGroupingSeparatorString(), 0);
        clear.decimalType1 = SeparatorType.fromCp(clear.decimalCp1, parseMode);
        clear.decimalType2 = SeparatorType.fromCp(clear.decimalCp2, parseMode);
        clear.groupingType1 = SeparatorType.fromCp(clear.groupingCp1, parseMode);
        clear.groupingType2 = SeparatorType.fromCp(clear.groupingCp2, parseMode);
        clear.getNext().clear().name = StateName.BEFORE_PREFIX;
        if (parseMode == ParseMode.LENIENT || parseMode == ParseMode.STRICT) {
            clear.digitTrie = makeDigitTrie(decimalFormatSymbols.getDigitStringsLocal());
            AffixHolder.addToState(clear, iProperties);
            if (z) {
                CurrencyAffixPatterns.addToState(decimalFormatSymbols.getULocale(), clear);
            }
        }
        if (DEBUGGING) {
            System.out.println("Parsing: " + ((Object) charSequence));
            System.out.println(iProperties);
            System.out.println(clear.affixHolders);
        }
        int index = parsePosition.getIndex();
        while (true) {
            if (index < charSequence.length()) {
                int codePointAt = Character.codePointAt(charSequence, index);
                clear.swap();
                for (int i = 0; i < clear.prevLength; i++) {
                    StateItem stateItem = clear.prevItems[i];
                    if (DEBUGGING) {
                        System.out.println(":" + index + stateItem.id + " " + stateItem);
                    }
                    switch (stateItem.name) {
                        case BEFORE_PREFIX:
                            if (parseMode == ParseMode.LENIENT || parseMode == ParseMode.FAST) {
                                acceptMinusOrPlusSign(codePointAt, StateName.BEFORE_PREFIX, clear, stateItem, false);
                                if (clear.length > 0 && parseMode == ParseMode.FAST) {
                                    break;
                                }
                            }
                            acceptIntegerDigit(codePointAt, StateName.AFTER_INTEGER_DIGIT, clear, stateItem);
                            if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                acceptBidi(codePointAt, StateName.BEFORE_PREFIX, clear, stateItem);
                                if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                    acceptWhitespace(codePointAt, StateName.BEFORE_PREFIX, clear, stateItem);
                                    if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                        acceptPadding(codePointAt, StateName.BEFORE_PREFIX, clear, stateItem);
                                        if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                            acceptNan(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                            if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                                acceptInfinity(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                                if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                                    if (!parseIntegerOnly) {
                                                        acceptDecimalPoint(codePointAt, StateName.AFTER_FRACTION_DIGIT, clear, stateItem);
                                                        if (clear.length > 0 && parseMode == ParseMode.FAST) {
                                                            break;
                                                        }
                                                    }
                                                    if (parseMode == ParseMode.LENIENT || parseMode == ParseMode.STRICT) {
                                                        acceptPrefix(codePointAt, StateName.AFTER_PREFIX, clear, stateItem);
                                                    }
                                                    if (parseMode != ParseMode.LENIENT && parseMode != ParseMode.FAST) {
                                                        break;
                                                    } else {
                                                        acceptGrouping(codePointAt, StateName.AFTER_INTEGER_DIGIT, clear, stateItem);
                                                        if ((clear.length <= 0 || parseMode != ParseMode.FAST) && z) {
                                                            acceptCurrency(codePointAt, StateName.BEFORE_PREFIX, clear, stateItem);
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                            break;
                        case AFTER_PREFIX:
                            acceptBidi(codePointAt, StateName.AFTER_PREFIX, clear, stateItem);
                            acceptPadding(codePointAt, StateName.AFTER_PREFIX, clear, stateItem);
                            acceptNan(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                            acceptInfinity(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                            acceptIntegerDigit(codePointAt, StateName.AFTER_INTEGER_DIGIT, clear, stateItem);
                            if (!parseIntegerOnly) {
                                acceptDecimalPoint(codePointAt, StateName.AFTER_FRACTION_DIGIT, clear, stateItem);
                            }
                            if (parseMode != ParseMode.LENIENT && parseMode != ParseMode.FAST) {
                                break;
                            } else {
                                acceptWhitespace(codePointAt, StateName.AFTER_PREFIX, clear, stateItem);
                                acceptGrouping(codePointAt, StateName.AFTER_INTEGER_DIGIT, clear, stateItem);
                                if (z) {
                                    acceptCurrency(codePointAt, StateName.AFTER_PREFIX, clear, stateItem);
                                    break;
                                } else {
                                    break;
                                }
                            }
                        case AFTER_INTEGER_DIGIT:
                            acceptIntegerDigit(codePointAt, StateName.AFTER_INTEGER_DIGIT, clear, stateItem);
                            if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                if (!parseIntegerOnly) {
                                    acceptDecimalPoint(codePointAt, StateName.AFTER_FRACTION_DIGIT, clear, stateItem);
                                    if (clear.length > 0 && parseMode == ParseMode.FAST) {
                                        break;
                                    }
                                }
                                acceptGrouping(codePointAt, StateName.AFTER_INTEGER_DIGIT, clear, stateItem);
                                if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                    acceptBidi(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                    if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                        acceptPadding(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                        if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                            if (!parseNoExponent) {
                                                acceptExponentSeparator(codePointAt, StateName.AFTER_EXPONENT_SEPARATOR, clear, stateItem);
                                                if (clear.length > 0 && parseMode == ParseMode.FAST) {
                                                    break;
                                                }
                                            }
                                            if (parseMode == ParseMode.LENIENT || parseMode == ParseMode.STRICT) {
                                                acceptSuffix(codePointAt, StateName.AFTER_SUFFIX, clear, stateItem);
                                            }
                                            if (parseMode != ParseMode.LENIENT && parseMode != ParseMode.FAST) {
                                                break;
                                            } else {
                                                acceptWhitespace(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                                if ((clear.length <= 0 || parseMode != ParseMode.FAST) && ((clear.length <= 0 || parseMode != ParseMode.FAST) && z)) {
                                                    acceptCurrency(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                                    break;
                                                }
                                            }
                                        } else {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                            break;
                        case AFTER_FRACTION_DIGIT:
                            acceptFractionDigit(codePointAt, StateName.AFTER_FRACTION_DIGIT, clear, stateItem);
                            if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                acceptBidi(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                    acceptPadding(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                    if (clear.length <= 0 || parseMode != ParseMode.FAST) {
                                        if (!parseNoExponent) {
                                            acceptExponentSeparator(codePointAt, StateName.AFTER_EXPONENT_SEPARATOR, clear, stateItem);
                                            if (clear.length > 0 && parseMode == ParseMode.FAST) {
                                                break;
                                            }
                                        }
                                        if (parseMode == ParseMode.LENIENT || parseMode == ParseMode.STRICT) {
                                            acceptSuffix(codePointAt, StateName.AFTER_SUFFIX, clear, stateItem);
                                        }
                                        if (parseMode != ParseMode.LENIENT && parseMode != ParseMode.FAST) {
                                            break;
                                        } else {
                                            acceptWhitespace(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                            if ((clear.length <= 0 || parseMode != ParseMode.FAST) && ((clear.length <= 0 || parseMode != ParseMode.FAST) && z)) {
                                                acceptCurrency(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                                break;
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                            break;
                        case AFTER_EXPONENT_SEPARATOR:
                            acceptBidi(codePointAt, StateName.AFTER_EXPONENT_SEPARATOR, clear, stateItem);
                            acceptMinusOrPlusSign(codePointAt, StateName.AFTER_EXPONENT_SEPARATOR, clear, stateItem, true);
                            acceptExponentDigit(codePointAt, StateName.AFTER_EXPONENT_DIGIT, clear, stateItem);
                            break;
                        case AFTER_EXPONENT_DIGIT:
                            acceptBidi(codePointAt, StateName.BEFORE_SUFFIX_SEEN_EXPONENT, clear, stateItem);
                            acceptPadding(codePointAt, StateName.BEFORE_SUFFIX_SEEN_EXPONENT, clear, stateItem);
                            acceptExponentDigit(codePointAt, StateName.AFTER_EXPONENT_DIGIT, clear, stateItem);
                            if (parseMode == ParseMode.LENIENT || parseMode == ParseMode.STRICT) {
                                acceptSuffix(codePointAt, StateName.AFTER_SUFFIX, clear, stateItem);
                            }
                            if (parseMode != ParseMode.LENIENT && parseMode != ParseMode.FAST) {
                                break;
                            } else {
                                acceptWhitespace(codePointAt, StateName.BEFORE_SUFFIX_SEEN_EXPONENT, clear, stateItem);
                                if (z) {
                                    acceptCurrency(codePointAt, StateName.BEFORE_SUFFIX_SEEN_EXPONENT, clear, stateItem);
                                    break;
                                } else {
                                    break;
                                }
                            }
                            break;
                        case BEFORE_SUFFIX:
                            acceptBidi(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                            acceptPadding(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                            if (!parseNoExponent) {
                                acceptExponentSeparator(codePointAt, StateName.AFTER_EXPONENT_SEPARATOR, clear, stateItem);
                            }
                            if (parseMode == ParseMode.LENIENT || parseMode == ParseMode.STRICT) {
                                acceptSuffix(codePointAt, StateName.AFTER_SUFFIX, clear, stateItem);
                            }
                            if (parseMode != ParseMode.LENIENT && parseMode != ParseMode.FAST) {
                                break;
                            } else {
                                acceptWhitespace(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                if (z) {
                                    acceptCurrency(codePointAt, StateName.BEFORE_SUFFIX, clear, stateItem);
                                    break;
                                } else {
                                    break;
                                }
                            }
                            break;
                        case BEFORE_SUFFIX_SEEN_EXPONENT:
                            acceptBidi(codePointAt, StateName.BEFORE_SUFFIX_SEEN_EXPONENT, clear, stateItem);
                            acceptPadding(codePointAt, StateName.BEFORE_SUFFIX_SEEN_EXPONENT, clear, stateItem);
                            if (parseMode == ParseMode.LENIENT || parseMode == ParseMode.STRICT) {
                                acceptSuffix(codePointAt, StateName.AFTER_SUFFIX, clear, stateItem);
                            }
                            if (parseMode != ParseMode.LENIENT && parseMode != ParseMode.FAST) {
                                break;
                            } else {
                                acceptWhitespace(codePointAt, StateName.BEFORE_SUFFIX_SEEN_EXPONENT, clear, stateItem);
                                if (z) {
                                    acceptCurrency(codePointAt, StateName.BEFORE_SUFFIX_SEEN_EXPONENT, clear, stateItem);
                                    break;
                                } else {
                                    break;
                                }
                            }
                            break;
                        case AFTER_SUFFIX:
                            if ((parseMode == ParseMode.LENIENT || parseMode == ParseMode.FAST) && z) {
                                acceptBidi(codePointAt, StateName.AFTER_SUFFIX, clear, stateItem);
                                acceptPadding(codePointAt, StateName.AFTER_SUFFIX, clear, stateItem);
                                acceptWhitespace(codePointAt, StateName.AFTER_SUFFIX, clear, stateItem);
                                if (z) {
                                    acceptCurrency(codePointAt, StateName.AFTER_SUFFIX, clear, stateItem);
                                    break;
                                } else {
                                    break;
                                }
                            }
                        case INSIDE_CURRENCY:
                            acceptCurrencyOffset(codePointAt, clear, stateItem);
                            break;
                        case INSIDE_DIGIT:
                            acceptDigitTrieOffset(codePointAt, clear, stateItem);
                            break;
                        case INSIDE_STRING:
                            acceptStringOffset(codePointAt, clear, stateItem);
                            break;
                        case INSIDE_AFFIX_PATTERN:
                            acceptAffixPatternOffset(codePointAt, clear, stateItem);
                            break;
                    }
                }
                if (clear.length == 0) {
                    clear.swapBack();
                } else {
                    index += Character.charCount(codePointAt);
                }
            }
        }
        if (clear.length != 0) {
            StateItem stateItem2 = null;
            for (int i2 = 0; i2 < clear.length; i2++) {
                StateItem stateItem3 = clear.items[i2];
                if (DEBUGGING) {
                    System.out.println(":end " + stateItem3);
                }
                if (stateItem3.hasNumber()) {
                    if (parseMode == ParseMode.STRICT) {
                        boolean z2 = stateItem3.sawPrefix || (stateItem3.affix != null && stateItem3.affix.p.isEmpty());
                        boolean z3 = stateItem3.sawSuffix || (stateItem3.affix != null && stateItem3.affix.s.isEmpty());
                        boolean z4 = clear.affixHolders.contains(AffixHolder.EMPTY_POSITIVE) || clear.affixHolders.contains(AffixHolder.EMPTY_NEGATIVE);
                        if ((!z2 || !z3) && (z2 || z3 || !z4)) {
                            if (DEBUGGING) {
                                System.out.println("-> rejected due to mismatched prefix/suffix");
                            }
                        } else if (iProperties.getMinimumExponentDigits() <= 0 || stateItem3.sawExponentDigit) {
                            int groupingSize = iProperties.getGroupingSize();
                            int secondaryGroupingSize = iProperties.getSecondaryGroupingSize();
                            if (groupingSize <= 0) {
                                groupingSize = secondaryGroupingSize;
                            }
                            if (secondaryGroupingSize <= 0) {
                                secondaryGroupingSize = groupingSize;
                            }
                            long j = stateItem3.groupingWidths;
                            int numberOfLeadingZeros = 16 - (Long.numberOfLeadingZeros(j) / 4);
                            while (true) {
                                if (numberOfLeadingZeros > 1 && (15 & j) == 0) {
                                    if (!stateItem3.sawDecimalPoint) {
                                        j >>>= 4;
                                        numberOfLeadingZeros--;
                                    } else if (DEBUGGING) {
                                        System.out.println("-> rejected due to decimal point after grouping");
                                    }
                                }
                            }
                            if (groupingSize >= 0 && numberOfLeadingZeros > 1) {
                                if ((15 & j) != ((long) groupingSize)) {
                                    if (DEBUGGING) {
                                        System.out.println("-> rejected due to first grouping violation");
                                    }
                                } else if (((j >>> ((numberOfLeadingZeros - 1) * 4)) & 15) <= ((long) secondaryGroupingSize)) {
                                    int i3 = 1;
                                    while (true) {
                                        if (i3 < numberOfLeadingZeros - 1) {
                                            if (((j >>> (i3 * 4)) & 15) == ((long) secondaryGroupingSize)) {
                                                i3++;
                                            } else if (DEBUGGING) {
                                                System.out.println("-> rejected due to inner grouping violation");
                                            }
                                        }
                                    }
                                } else if (DEBUGGING) {
                                    System.out.println("-> rejected due to final grouping violation");
                                }
                            }
                        } else if (DEBUGGING) {
                            System.out.println("-> reject due to lack of exponent");
                        }
                    }
                    if (!iProperties.getDecimalPatternMatchRequired() || stateItem3.sawDecimalPoint == PositiveDecimalFormat.allowsDecimalPoint(iProperties)) {
                        if (!z || stateItem3.sawCurrency) {
                            if (stateItem2 == null) {
                                stateItem2 = stateItem3;
                            } else if (stateItem3.score > stateItem2.score) {
                                stateItem2 = stateItem3;
                            } else if (stateItem3.trailingCount < stateItem2.trailingCount) {
                                stateItem2 = stateItem3;
                            }
                        } else if (DEBUGGING) {
                            System.out.println("-> rejected due to lack of currency");
                        }
                    } else if (DEBUGGING) {
                        System.out.println("-> rejected due to decimal point violation");
                    }
                } else if (DEBUGGING) {
                    System.out.println("-> rejected due to no number value");
                }
            }
            if (DEBUGGING) {
                System.out.println("- - - - - - - - - -");
            }
            if (stateItem2 != null) {
                parsePosition.setIndex(index - stateItem2.trailingCount);
                return stateItem2;
            }
            parsePosition.setErrorIndex(index);
            return null;
        } else if (!DEBUGGING) {
            return null;
        } else {
            System.out.println("No matches found");
            System.out.println("- - - - - - - - - -");
            return null;
        }
    }

    private static void acceptWhitespace(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        if (UNISET_WHITESPACE.contains(i)) {
            parserState.getNext().copyFrom(stateItem, stateName, i);
        }
    }

    private static void acceptBidi(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        if (UNISET_BIDI.contains(i)) {
            parserState.getNext().copyFrom(stateItem, stateName, i);
        }
    }

    private static void acceptPadding(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        String padString = parserState.properties.getPadString();
        if (padString != null && padString.length() != 0 && i == Character.codePointAt(padString, 0)) {
            parserState.getNext().copyFrom(stateItem, stateName, i);
        }
    }

    private static void acceptIntegerDigit(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        acceptDigitHelper(i, stateName, parserState, stateItem, DigitType.INTEGER);
    }

    private static void acceptFractionDigit(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        acceptDigitHelper(i, stateName, parserState, stateItem, DigitType.FRACTION);
    }

    private static void acceptExponentDigit(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        acceptDigitHelper(i, stateName, parserState, stateItem, DigitType.EXPONENT);
    }

    private static void acceptDigitHelper(int i, StateName stateName, ParserState parserState, StateItem stateItem, DigitType digitType) {
        byte digit = (byte) UCharacter.digit(i, 10);
        StateItem stateItem2 = null;
        if (digit >= 0) {
            stateItem2 = parserState.getNext().copyFrom(stateItem, stateName, -1);
        }
        if (digit < 0 && (parserState.mode == ParseMode.LENIENT || parserState.mode == ParseMode.STRICT)) {
            if (parserState.digitTrie == null) {
                for (byte b = 0; b < 10; b = (byte) (b + 1)) {
                    if (i == Character.codePointAt(parserState.symbols.getDigitStringsLocal()[b], 0)) {
                        digit = b;
                        stateItem2 = parserState.getNext().copyFrom(stateItem, stateName, -1);
                    }
                }
            } else {
                acceptDigitTrie(i, stateName, parserState, stateItem, digitType);
            }
        }
        recordDigit(stateItem2, digit, digitType);
    }

    private static void recordDigit(StateItem stateItem, byte b, DigitType digitType) {
        if (stateItem != null) {
            stateItem.appendDigit(b, digitType);
            if (digitType == DigitType.INTEGER && (stateItem.groupingWidths & 15) < 15) {
                stateItem.groupingWidths++;
            }
        }
    }

    private static void acceptMinusOrPlusSign(int i, StateName stateName, ParserState parserState, StateItem stateItem, boolean z) {
        acceptMinusSign(i, stateName, null, parserState, stateItem, z);
        acceptPlusSign(i, stateName, null, parserState, stateItem, z);
    }

    private static long acceptMinusSign(int i, StateName stateName, StateName stateName2, ParserState parserState, StateItem stateItem, boolean z) {
        if (!UNISET_MINUS.contains(i)) {
            return 0;
        }
        StateItem copyFrom = parserState.getNext().copyFrom(stateItem, stateName, -1);
        copyFrom.returnTo1 = stateName2;
        if (z) {
            copyFrom.sawNegativeExponent = true;
        } else {
            copyFrom.sawNegative = true;
        }
        return 1 << parserState.lastInsertedIndex();
    }

    private static long acceptPlusSign(int i, StateName stateName, StateName stateName2, ParserState parserState, StateItem stateItem, boolean z) {
        if (!UNISET_PLUS.contains(i)) {
            return 0;
        }
        parserState.getNext().copyFrom(stateItem, stateName, -1).returnTo1 = stateName2;
        return 1 << parserState.lastInsertedIndex();
    }

    private static void acceptGrouping(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        if (stateItem.groupingCp == -1) {
            SeparatorType fromCp = SeparatorType.fromCp(i, parserState.mode);
            if (!(i == parserState.groupingCp1 || i == parserState.groupingCp2)) {
                if (fromCp != SeparatorType.UNKNOWN) {
                    if (parserState.groupingMode == GroupingMode.RESTRICTED) {
                        if (!(fromCp == parserState.groupingType1 && fromCp == parserState.groupingType2)) {
                            return;
                        }
                    } else if (fromCp != SeparatorType.COMMA_LIKE || (parserState.decimalType1 != SeparatorType.COMMA_LIKE && parserState.decimalType2 != SeparatorType.COMMA_LIKE)) {
                        if (fromCp == SeparatorType.PERIOD_LIKE && (parserState.decimalType1 == SeparatorType.PERIOD_LIKE || parserState.decimalType2 == SeparatorType.PERIOD_LIKE)) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            StateItem copyFrom = parserState.getNext().copyFrom(stateItem, stateName, i);
            copyFrom.groupingCp = i;
            copyFrom.groupingWidths <<= 4;
        } else if (i == stateItem.groupingCp) {
            parserState.getNext().copyFrom(stateItem, stateName, i).groupingWidths <<= 4;
        }
    }

    private static void acceptDecimalPoint(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        if (i != stateItem.groupingCp) {
            SeparatorType fromCp = SeparatorType.fromCp(i, parserState.mode);
            if (fromCp != parserState.decimalType1 && fromCp != parserState.decimalType2) {
                return;
            }
            if ((fromCp != SeparatorType.OTHER_GROUPING && fromCp != SeparatorType.UNKNOWN) || i == parserState.decimalCp1 || i == parserState.decimalCp2) {
                parserState.getNext().copyFrom(stateItem, stateName, -1).sawDecimalPoint = true;
            }
        }
    }

    private static void acceptNan(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        long acceptString = acceptString(i, stateName, null, parserState, stateItem, parserState.symbols.getNaN(), 0, false);
        for (int numberOfTrailingZeros = Long.numberOfTrailingZeros(acceptString); (1 << numberOfTrailingZeros) <= acceptString; numberOfTrailingZeros++) {
            if (((1 << numberOfTrailingZeros) & acceptString) != 0) {
                parserState.getItem(numberOfTrailingZeros).sawNaN = true;
            }
        }
    }

    private static void acceptInfinity(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        long acceptString = acceptString(i, stateName, null, parserState, stateItem, parserState.symbols.getInfinity(), 0, false);
        for (int numberOfTrailingZeros = Long.numberOfTrailingZeros(acceptString); (1 << numberOfTrailingZeros) <= acceptString; numberOfTrailingZeros++) {
            if (((1 << numberOfTrailingZeros) & acceptString) != 0) {
                parserState.getItem(numberOfTrailingZeros).sawInfinity = true;
            }
        }
    }

    private static void acceptExponentSeparator(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        acceptString(i, stateName, null, parserState, stateItem, parserState.symbols.getExponentSeparator(), 0, true);
    }

    private static void acceptPrefix(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        for (AffixHolder affixHolder : parserState.affixHolders) {
            acceptAffixHolder(i, stateName, parserState, stateItem, affixHolder, true);
        }
    }

    private static void acceptSuffix(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        if (stateItem.affix != null) {
            acceptAffixHolder(i, stateName, parserState, stateItem, stateItem.affix, false);
            return;
        }
        for (AffixHolder affixHolder : parserState.affixHolders) {
            acceptAffixHolder(i, stateName, parserState, stateItem, affixHolder, false);
        }
    }

    private static void acceptAffixHolder(int i, StateName stateName, ParserState parserState, StateItem stateItem, AffixHolder affixHolder, boolean z) {
        long j;
        if (affixHolder != null) {
            String str = z ? affixHolder.p : affixHolder.s;
            if (affixHolder.strings) {
                j = acceptString(i, stateName, null, parserState, stateItem, str, 0, false);
            } else {
                j = acceptAffixPattern(i, stateName, parserState, stateItem, str, AffixPatternUtils.nextToken(0, str));
            }
            for (int numberOfTrailingZeros = Long.numberOfTrailingZeros(j); (1 << numberOfTrailingZeros) <= j; numberOfTrailingZeros++) {
                if (((1 << numberOfTrailingZeros) & j) != 0) {
                    StateItem item = parserState.getItem(numberOfTrailingZeros);
                    item.affix = affixHolder;
                    if (z) {
                        item.sawPrefix = true;
                    }
                    if (!z) {
                        item.sawSuffix = true;
                    }
                    if (affixHolder.negative) {
                        item.sawNegative = true;
                    }
                    item.score += 10;
                    if (!affixHolder.negative) {
                        item.score++;
                    }
                    if (!item.sawPrefix && affixHolder.p.isEmpty()) {
                        item.score += 5;
                    }
                    if (!item.sawSuffix && affixHolder.s.isEmpty()) {
                        item.score += 5;
                    }
                }
            }
        }
    }

    private static long acceptStringOffset(int i, ParserState parserState, StateItem stateItem) {
        return acceptString(i, stateItem.returnTo1, stateItem.returnTo2, parserState, stateItem, stateItem.currentString, stateItem.currentOffset, stateItem.currentTrailing);
    }

    private static long acceptString(int i, StateName stateName, StateName stateName2, ParserState parserState, StateItem stateItem, CharSequence charSequence, int i2, boolean z) {
        if (charSequence == null || charSequence.length() == 0) {
            return 0;
        }
        return acceptStringOrAffixPatternWithIgnorables(i, stateName, stateName2, parserState, stateItem, charSequence, (long) i2, z, true);
    }

    private static long acceptStringNonIgnorable(int i, StateName stateName, StateName stateName2, ParserState parserState, StateItem stateItem, CharSequence charSequence, boolean z, int i2, long j, long j2) {
        long j3 = 0;
        int i3 = (int) j;
        int i4 = (int) j2;
        if (!codePointEquals(i2, i, parserState)) {
            return 0;
        }
        if (i3 < charSequence.length()) {
            j3 = 0 | acceptStringHelper(i, stateName, stateName2, parserState, stateItem, charSequence, i3, z);
        }
        return i4 >= charSequence.length() ? j3 | acceptStringHelper(i, stateName, stateName2, parserState, stateItem, charSequence, i4, z) : j3;
    }

    private static long acceptStringHelper(int i, StateName stateName, StateName stateName2, ParserState parserState, StateItem stateItem, CharSequence charSequence, int i2, boolean z) {
        StateItem copyFrom = parserState.getNext().copyFrom(stateItem, null, i);
        copyFrom.score++;
        if (i2 < charSequence.length()) {
            copyFrom.name = StateName.INSIDE_STRING;
            copyFrom.returnTo1 = stateName;
            copyFrom.returnTo2 = stateName2;
            copyFrom.currentString = charSequence;
            copyFrom.currentOffset = i2;
            copyFrom.currentTrailing = z;
        } else {
            copyFrom.name = stateName;
            if (!z) {
                copyFrom.trailingCount = 0;
            }
            copyFrom.returnTo1 = stateName2;
            copyFrom.returnTo2 = null;
        }
        return 1 << parserState.lastInsertedIndex();
    }

    private static long acceptAffixPatternOffset(int i, ParserState parserState, StateItem stateItem) {
        return acceptAffixPattern(i, stateItem.returnTo1, parserState, stateItem, stateItem.currentAffixPattern, stateItem.currentStepwiseParserTag);
    }

    private static long acceptAffixPattern(int i, StateName stateName, ParserState parserState, StateItem stateItem, CharSequence charSequence, long j) {
        if (charSequence == null || charSequence.length() == 0) {
            return 0;
        }
        return acceptStringOrAffixPatternWithIgnorables(i, stateName, null, parserState, stateItem, charSequence, j, false, false);
    }

    private static long acceptAffixPatternNonIgnorable(int i, StateName stateName, ParserState parserState, StateItem stateItem, CharSequence charSequence, int i2, long j, long j2) {
        int i3 = -1;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        if (i2 < 0) {
            switch (i2) {
                case -7:
                case -6:
                case -5:
                    z3 = true;
                    break;
                case -4:
                    str = parserState.symbols.getPerMillString();
                    if (!(str.length() == 1 && str.charAt(0) == 8240)) {
                        i3 = 8240;
                        break;
                    }
                case -3:
                    str = parserState.symbols.getPercentString();
                    if (!(str.length() == 1 && str.charAt(0) == '%')) {
                        i3 = 37;
                        break;
                    }
                case PagerAdapter.POSITION_NONE /* -2 */:
                    z2 = true;
                    break;
                case -1:
                    z = true;
                    break;
                default:
                    throw new AssertionError();
            }
        } else {
            i3 = i2;
        }
        long j3 = 0;
        if (i3 >= 0 && codePointEquals(i, i3, parserState)) {
            if (j >= 0) {
                j3 = 0 | acceptAffixPatternHelper(i, stateName, parserState, stateItem, charSequence, j);
            }
            if (j2 < 0) {
                j3 |= acceptAffixPatternHelper(i, stateName, parserState, stateItem, charSequence, j2);
            }
        }
        if (z) {
            if (j >= 0) {
                j3 |= acceptMinusSign(i, StateName.INSIDE_AFFIX_PATTERN, stateName, parserState, stateItem, false);
            }
            if (j2 < 0) {
                j3 |= acceptMinusSign(i, stateName, null, parserState, stateItem, false);
            }
            if (j3 == 0) {
                String minusSignString = parserState.symbols.getMinusSignString();
                int codePointAt = Character.codePointAt(minusSignString, 0);
                if (minusSignString.length() != Character.charCount(codePointAt) || !UNISET_MINUS.contains(codePointAt)) {
                    str = minusSignString;
                }
            }
        }
        if (z2) {
            if (j >= 0) {
                j3 |= acceptPlusSign(i, StateName.INSIDE_AFFIX_PATTERN, stateName, parserState, stateItem, false);
            }
            if (j2 < 0) {
                j3 |= acceptPlusSign(i, stateName, null, parserState, stateItem, false);
            }
            if (j3 == 0) {
                String plusSignString = parserState.symbols.getPlusSignString();
                int codePointAt2 = Character.codePointAt(plusSignString, 0);
                if (plusSignString.length() != Character.charCount(codePointAt2) || !UNISET_MINUS.contains(codePointAt2)) {
                    str = plusSignString;
                }
            }
        }
        if (str != null) {
            if (j >= 0) {
                j3 |= acceptString(i, StateName.INSIDE_AFFIX_PATTERN, stateName, parserState, stateItem, str, 0, false);
            }
            if (j2 < 0) {
                j3 |= acceptString(i, stateName, null, parserState, stateItem, str, 0, false);
            }
        }
        if (z3) {
            if (j >= 0) {
                j3 |= acceptCurrency(i, StateName.INSIDE_AFFIX_PATTERN, stateName, parserState, stateItem);
            }
            if (j2 < 0) {
                j3 |= acceptCurrency(i, stateName, null, parserState, stateItem);
            }
        }
        for (int numberOfTrailingZeros = Long.numberOfTrailingZeros(j3); (1 << numberOfTrailingZeros) <= j3; numberOfTrailingZeros++) {
            if (((1 << numberOfTrailingZeros) & j3) != 0) {
                parserState.getItem(numberOfTrailingZeros).currentAffixPattern = charSequence;
                parserState.getItem(numberOfTrailingZeros).currentStepwiseParserTag = j;
            }
        }
        return j3;
    }

    private static long acceptAffixPatternHelper(int i, StateName stateName, ParserState parserState, StateItem stateItem, CharSequence charSequence, long j) {
        StateItem copyFrom = parserState.getNext().copyFrom(stateItem, null, i);
        copyFrom.score++;
        if (j >= 0) {
            copyFrom.name = StateName.INSIDE_AFFIX_PATTERN;
            copyFrom.returnTo1 = stateName;
            copyFrom.currentAffixPattern = charSequence;
            copyFrom.currentStepwiseParserTag = j;
        } else {
            copyFrom.name = stateName;
            copyFrom.trailingCount = 0;
            copyFrom.returnTo1 = null;
        }
        return 1 << parserState.lastInsertedIndex();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0066 A[EDGE_INSN: B:81:0x0066->B:24:0x0066 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0172 A[EDGE_INSN: B:83:0x0172->B:77:0x0172 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long acceptStringOrAffixPatternWithIgnorables(int r22, com.ibm.icu.impl.number.Parse.StateName r23, com.ibm.icu.impl.number.Parse.StateName r24, com.ibm.icu.impl.number.Parse.ParserState r25, com.ibm.icu.impl.number.Parse.StateItem r26, java.lang.CharSequence r27, long r28, boolean r30, boolean r31) {
        /*
        // Method dump skipped, instructions count: 414
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.number.Parse.acceptStringOrAffixPatternWithIgnorables(int, com.ibm.icu.impl.number.Parse$StateName, com.ibm.icu.impl.number.Parse$StateName, com.ibm.icu.impl.number.Parse$ParserState, com.ibm.icu.impl.number.Parse$StateItem, java.lang.CharSequence, long, boolean, boolean):long");
    }

    private static void acceptCurrency(int i, StateName stateName, ParserState parserState, StateItem stateItem) {
        acceptCurrency(i, stateName, null, parserState, stateItem);
    }

    private static long acceptCurrency(int i, StateName stateName, StateName stateName2, ParserState parserState, StateItem stateItem) {
        String str;
        String str2;
        if (stateItem.sawCurrency) {
            return 0;
        }
        Currency currency = parserState.properties.getCurrency();
        if (currency != null) {
            str2 = currency.getName(parserState.symbols.getULocale(), 0, null);
            str = currency.getCurrencyCode();
        } else {
            parserState.symbols.getCurrency();
            str2 = parserState.symbols.getCurrencySymbol();
            str = parserState.symbols.getInternationalCurrencySymbol();
        }
        long acceptString = 0 | acceptString(i, stateName, stateName2, parserState, stateItem, str2, 0, false) | acceptString(i, stateName, stateName2, parserState, stateItem, str, 0, false);
        for (int numberOfTrailingZeros = Long.numberOfTrailingZeros(acceptString); (1 << numberOfTrailingZeros) <= acceptString; numberOfTrailingZeros++) {
            if (((1 << numberOfTrailingZeros) & acceptString) != 0) {
                parserState.getItem(numberOfTrailingZeros).sawCurrency = true;
                parserState.getItem(numberOfTrailingZeros).isoCode = str;
            }
        }
        if (!parserState.parseCurrency) {
            return acceptString;
        }
        ULocale uLocale = parserState.symbols.getULocale();
        return acceptString | acceptCurrencyHelper(i, stateName, stateName2, parserState, stateItem, Currency.openParseState(uLocale, i, 1)) | acceptCurrencyHelper(i, stateName, stateName2, parserState, stateItem, Currency.openParseState(uLocale, i, 0));
    }

    private static void acceptCurrencyOffset(int i, ParserState parserState, StateItem stateItem) {
        acceptCurrencyHelper(i, stateItem.returnTo1, stateItem.returnTo2, parserState, stateItem, stateItem.currentCurrencyTrieState);
    }

    private static long acceptCurrencyHelper(int i, StateName stateName, StateName stateName2, ParserState parserState, StateItem stateItem, TextTrieMap<Currency.CurrencyStringInfo>.ParseState parseState) {
        if (parseState == null) {
            return 0;
        }
        parseState.accept(i);
        long j = 0;
        Iterator currentMatches = parseState.getCurrentMatches();
        if (currentMatches != null) {
            StateItem copyFrom = parserState.getNext().copyFrom(stateItem, stateName, -1);
            copyFrom.returnTo1 = stateName2;
            copyFrom.returnTo2 = null;
            copyFrom.sawCurrency = true;
            copyFrom.isoCode = ((Currency.CurrencyStringInfo) currentMatches.next()).getISOCode();
            j = 0 | (1 << parserState.lastInsertedIndex());
        }
        if (parseState.atEnd()) {
            return j;
        }
        StateItem copyFrom2 = parserState.getNext().copyFrom(stateItem, StateName.INSIDE_CURRENCY, -1);
        copyFrom2.returnTo1 = stateName;
        copyFrom2.returnTo2 = stateName2;
        copyFrom2.currentCurrencyTrieState = parseState;
        return j | (1 << parserState.lastInsertedIndex());
    }

    private static long acceptDigitTrie(int i, StateName stateName, ParserState parserState, StateItem stateItem, DigitType digitType) {
        if ($assertionsDisabled || parserState.digitTrie != null) {
            TextTrieMap<V>.ParseState openParseState = parserState.digitTrie.openParseState(i);
            if (openParseState == null) {
                return 0;
            }
            return acceptDigitTrieHelper(i, stateName, parserState, stateItem, digitType, openParseState);
        }
        throw new AssertionError();
    }

    private static void acceptDigitTrieOffset(int i, ParserState parserState, StateItem stateItem) {
        acceptDigitTrieHelper(i, stateItem.returnTo1, parserState, stateItem, stateItem.currentDigitType, stateItem.currentDigitTrieState);
    }

    private static long acceptDigitTrieHelper(int i, StateName stateName, ParserState parserState, StateItem stateItem, DigitType digitType, TextTrieMap<Byte>.ParseState parseState) {
        if (parseState == null) {
            return 0;
        }
        parseState.accept(i);
        long j = 0;
        Iterator currentMatches = parseState.getCurrentMatches();
        if (currentMatches != null) {
            byte byteValue = ((Byte) currentMatches.next()).byteValue();
            StateItem copyFrom = parserState.getNext().copyFrom(stateItem, stateName, -1);
            copyFrom.returnTo1 = null;
            recordDigit(copyFrom, byteValue, digitType);
            j = 0 | (1 << parserState.lastInsertedIndex());
        }
        if (parseState.atEnd()) {
            return j;
        }
        StateItem copyFrom2 = parserState.getNext().copyFrom(stateItem, StateName.INSIDE_DIGIT, -1);
        copyFrom2.returnTo1 = stateName;
        copyFrom2.currentDigitTrieState = parseState;
        copyFrom2.currentDigitType = digitType;
        return j | (1 << parserState.lastInsertedIndex());
    }

    private static boolean codePointEquals(int i, int i2, ParserState parserState) {
        if (!parserState.caseSensitive) {
            i = UCharacter.foldCase(i, true);
            i2 = UCharacter.foldCase(i2, true);
        }
        return i == i2;
    }

    private static boolean isIgnorable(int i, ParserState parserState) {
        if (i < 0) {
            return false;
        }
        if (UNISET_BIDI.contains(i)) {
            return true;
        }
        return parserState.mode == ParseMode.LENIENT && UNISET_WHITESPACE.contains(i);
    }
}
