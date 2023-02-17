package com.ibm.icu.impl.number;

import com.ibm.icu.impl.number.formatters.PaddingFormat;
import java.math.BigDecimal;
public class PatternString {
    public static Properties parseToProperties(String str, boolean z) {
        Properties properties = new Properties();
        LdmlDecimalPatternParser.parse(str, properties, z);
        return properties;
    }

    public static Properties parseToProperties(String str) {
        return parseToProperties(str, false);
    }

    public static void parseToExistingProperties(String str, Properties properties, boolean z) {
        LdmlDecimalPatternParser.parse(str, properties, z);
    }

    public static void parseToExistingProperties(String str, Properties properties) {
        parseToExistingProperties(str, properties, false);
    }

    public static String propertiesToString(Properties properties) {
        int i;
        int i2;
        int i3;
        StringBuilder sb = new StringBuilder();
        int min = Math.min(properties.getSecondaryGroupingSize(), 100);
        int min2 = Math.min(properties.getGroupingSize(), 100);
        int min3 = Math.min(properties.getFormatWidth(), 100);
        PaddingFormat.PadPosition padPosition = properties.getPadPosition();
        String padString = properties.getPadString();
        int max = Math.max(Math.min(properties.getMinimumIntegerDigits(), 100), 0);
        int min4 = Math.min(properties.getMaximumIntegerDigits(), 100);
        int max2 = Math.max(Math.min(properties.getMinimumFractionDigits(), 100), 0);
        int min5 = Math.min(properties.getMaximumFractionDigits(), 100);
        int min6 = Math.min(properties.getMinimumSignificantDigits(), 100);
        int min7 = Math.min(properties.getMaximumSignificantDigits(), 100);
        boolean decimalSeparatorAlwaysShown = properties.getDecimalSeparatorAlwaysShown();
        int min8 = Math.min(properties.getMinimumExponentDigits(), 100);
        boolean exponentSignAlwaysShown = properties.getExponentSignAlwaysShown();
        String positivePrefix = properties.getPositivePrefix();
        String positivePrefixPattern = properties.getPositivePrefixPattern();
        String positiveSuffix = properties.getPositiveSuffix();
        String positiveSuffixPattern = properties.getPositiveSuffixPattern();
        String negativePrefix = properties.getNegativePrefix();
        String negativePrefixPattern = properties.getNegativePrefixPattern();
        String negativeSuffix = properties.getNegativeSuffix();
        String negativeSuffixPattern = properties.getNegativeSuffixPattern();
        if (positivePrefixPattern != null) {
            sb.append(positivePrefixPattern);
        }
        AffixPatternUtils.escape(positivePrefix, sb);
        int length = sb.length();
        if (min != Math.min(100, -1) && min2 != Math.min(100, -1) && min != min2) {
            i = min;
            i3 = min;
            i2 = min2;
        } else if (min != Math.min(100, -1)) {
            i = min;
            i3 = 0;
            i2 = min;
        } else if (min2 != Math.min(100, -1)) {
            i = min;
            i3 = 0;
            i2 = min2;
        } else {
            i = 0;
            i3 = 0;
            i2 = 0;
        }
        int i4 = i3 + i2 + 1;
        BigDecimal roundingIncrement = properties.getRoundingIncrement();
        StringBuilder sb2 = new StringBuilder();
        int i5 = 0;
        if (min7 != Math.min(100, -1)) {
            while (sb2.length() < min6) {
                sb2.append('@');
            }
            while (sb2.length() < min7) {
                sb2.append('#');
            }
        } else if (roundingIncrement != Properties.DEFAULT_ROUNDING_INCREMENT) {
            i5 = -roundingIncrement.scale();
            String plainString = roundingIncrement.scaleByPowerOfTen(roundingIncrement.scale()).toPlainString();
            if (plainString.charAt(0) == '\'') {
                sb2.append((CharSequence) plainString, 1, plainString.length());
            } else {
                sb2.append(plainString);
            }
        }
        while (sb2.length() + i5 < max) {
            sb2.insert(0, '0');
        }
        while ((-i5) < max2) {
            sb2.append('0');
            i5--;
        }
        int max3 = Math.max(i4, sb2.length() + i5);
        int max4 = min4 != 100 ? Math.max(min4, max3) - 1 : max3 - 1;
        int min9 = min5 != 100 ? Math.min(-min5, i5) : i5;
        for (int i6 = max4; i6 >= min9; i6--) {
            int length2 = ((sb2.length() + i5) - i6) - 1;
            if (length2 < 0 || length2 >= sb2.length()) {
                sb.append('#');
            } else {
                sb.append(sb2.charAt(length2));
            }
            if (i6 > i2 && i > 0 && (i6 - i2) % i == 0) {
                sb.append(',');
            } else if (i6 > 0 && i6 == i2) {
                sb.append(',');
            } else if (i6 == 0 && (decimalSeparatorAlwaysShown || min9 < 0)) {
                sb.append('.');
            }
        }
        if (min8 != Math.min(100, -1)) {
            sb.append('E');
            if (exponentSignAlwaysShown) {
                sb.append('+');
            }
            for (int i7 = 0; i7 < min8; i7++) {
                sb.append('0');
            }
        }
        int length3 = sb.length();
        if (positiveSuffixPattern != null) {
            sb.append(positiveSuffixPattern);
        }
        AffixPatternUtils.escape(positiveSuffix, sb);
        if (min3 != 0) {
            while (min3 - sb.length() > 0) {
                sb.insert(length, '#');
                length3++;
            }
            switch (padPosition) {
                case BEFORE_PREFIX:
                    int escapePaddingString = escapePaddingString(padString, sb, 0);
                    sb.insert(0, '*');
                    length += escapePaddingString + 1;
                    length3 += escapePaddingString + 1;
                    break;
                case AFTER_PREFIX:
                    int escapePaddingString2 = escapePaddingString(padString, sb, length);
                    sb.insert(length, '*');
                    length += escapePaddingString2 + 1;
                    length3 += escapePaddingString2 + 1;
                    break;
                case BEFORE_SUFFIX:
                    escapePaddingString(padString, sb, length3);
                    sb.insert(length3, '*');
                    break;
                case AFTER_SUFFIX:
                    sb.append('*');
                    escapePaddingString(padString, sb, sb.length());
                    break;
            }
        }
        if (!(negativePrefix == null && negativeSuffix == null && ((negativePrefixPattern != null || negativeSuffixPattern == null) && (negativePrefixPattern == null || (negativePrefixPattern.length() == 1 && negativePrefixPattern.charAt(0) == '-' && negativeSuffixPattern.length() == 0))))) {
            sb.append(';');
            if (negativePrefixPattern != null) {
                sb.append(negativePrefixPattern);
            }
            AffixPatternUtils.escape(negativePrefix, sb);
            sb.append((CharSequence) sb, length, length3);
            if (negativeSuffixPattern != null) {
                sb.append(negativeSuffixPattern);
            }
            AffixPatternUtils.escape(negativeSuffix, sb);
        }
        return sb.toString();
    }

    private static int escapePaddingString(CharSequence charSequence, StringBuilder sb, int i) {
        if (charSequence == null || charSequence.length() == 0) {
            charSequence = " ";
        }
        int length = sb.length();
        if (charSequence.length() != 1) {
            sb.insert(i, '\'');
            int i2 = 1;
            for (int i3 = 0; i3 < charSequence.length(); i3++) {
                char charAt = charSequence.charAt(i3);
                if (charAt == '\'') {
                    sb.insert(i + i2, "''");
                    i2 += 2;
                } else {
                    sb.insert(i + i2, charAt);
                    i2++;
                }
            }
            sb.insert(i + i2, '\'');
        } else if (charSequence.equals("'")) {
            sb.insert(i, "''");
        } else {
            sb.insert(i, charSequence);
        }
        return sb.length() - length;
    }

    /* access modifiers changed from: package-private */
    public static class LdmlDecimalPatternParser {
        LdmlDecimalPatternParser() {
        }

        /* access modifiers changed from: package-private */
        public static class PatternParseResult {
            static final /* synthetic */ boolean $assertionsDisabled = (!PatternString.class.desiredAssertionStatus());
            SubpatternParseResult negative;
            SubpatternParseResult positive;

            private PatternParseResult() {
                this.positive = new SubpatternParseResult();
                this.negative = null;
            }

            /* access modifiers changed from: package-private */
            public void saveToProperties(Properties properties, boolean z) {
                int i;
                int i2;
                if (this.positive.groupingSizes[1] != -1) {
                    properties.setGroupingSize(this.positive.groupingSizes[0]);
                } else {
                    properties.setGroupingSize(-1);
                }
                if (this.positive.groupingSizes[2] != -1) {
                    properties.setSecondaryGroupingSize(this.positive.groupingSizes[1]);
                } else {
                    properties.setSecondaryGroupingSize(-1);
                }
                if (this.positive.totalIntegerDigits == 0 && this.positive.maximumFractionDigits > 0) {
                    i2 = 0;
                    i = Math.max(1, this.positive.minimumFractionDigits);
                } else if (this.positive.minimumIntegerDigits == 0 && this.positive.minimumFractionDigits == 0) {
                    i2 = 1;
                    i = 0;
                } else {
                    i2 = this.positive.minimumIntegerDigits;
                    i = this.positive.minimumFractionDigits;
                }
                if (this.positive.minimumSignificantDigits > 0) {
                    properties.setMinimumFractionDigits(-1);
                    properties.setMaximumFractionDigits(-1);
                    properties.setRoundingIncrement(Properties.DEFAULT_ROUNDING_INCREMENT);
                    properties.setMinimumSignificantDigits(this.positive.minimumSignificantDigits);
                    properties.setMaximumSignificantDigits(this.positive.maximumSignificantDigits);
                } else if (!this.positive.rounding.isZero()) {
                    if (!z) {
                        properties.setMinimumFractionDigits(i);
                        properties.setMaximumFractionDigits(this.positive.maximumFractionDigits);
                        properties.setRoundingIncrement(this.positive.rounding.toBigDecimal());
                    } else {
                        properties.setMinimumFractionDigits(-1);
                        properties.setMaximumFractionDigits(-1);
                        properties.setRoundingIncrement(Properties.DEFAULT_ROUNDING_INCREMENT);
                    }
                    properties.setMinimumSignificantDigits(-1);
                    properties.setMaximumSignificantDigits(-1);
                } else {
                    if (!z) {
                        properties.setMinimumFractionDigits(i);
                        properties.setMaximumFractionDigits(this.positive.maximumFractionDigits);
                        properties.setRoundingIncrement(Properties.DEFAULT_ROUNDING_INCREMENT);
                    } else {
                        properties.setMinimumFractionDigits(-1);
                        properties.setMaximumFractionDigits(-1);
                        properties.setRoundingIncrement(Properties.DEFAULT_ROUNDING_INCREMENT);
                    }
                    properties.setMinimumSignificantDigits(-1);
                    properties.setMaximumSignificantDigits(-1);
                }
                if (!this.positive.hasDecimal || this.positive.maximumFractionDigits != 0) {
                    properties.setDecimalSeparatorAlwaysShown(false);
                } else {
                    properties.setDecimalSeparatorAlwaysShown(true);
                }
                if (this.positive.exponentDigits > 0) {
                    properties.setExponentSignAlwaysShown(this.positive.exponentShowPlusSign);
                    properties.setMinimumExponentDigits(this.positive.exponentDigits);
                    if (this.positive.minimumSignificantDigits == 0) {
                        properties.setMinimumIntegerDigits(this.positive.minimumIntegerDigits);
                        properties.setMaximumIntegerDigits(this.positive.totalIntegerDigits);
                    } else {
                        properties.setMinimumIntegerDigits(1);
                        properties.setMaximumIntegerDigits(-1);
                    }
                } else {
                    properties.setExponentSignAlwaysShown(false);
                    properties.setMinimumExponentDigits(-1);
                    properties.setMinimumIntegerDigits(i2);
                    properties.setMaximumIntegerDigits(-1);
                }
                if (this.positive.padding.length() > 0) {
                    properties.setFormatWidth(this.positive.paddingWidth + AffixPatternUtils.unescapedLength(this.positive.prefix) + AffixPatternUtils.unescapedLength(this.positive.suffix));
                    if (this.positive.padding.length() == 1) {
                        properties.setPadString(this.positive.padding.toString());
                    } else if (this.positive.padding.length() != 2) {
                        properties.setPadString(this.positive.padding.subSequence(1, this.positive.padding.length() - 1).toString());
                    } else if (this.positive.padding.charAt(0) == '\'') {
                        properties.setPadString("'");
                    } else {
                        properties.setPadString(this.positive.padding.toString());
                    }
                    if ($assertionsDisabled || this.positive.paddingLocation != null) {
                        properties.setPadPosition(this.positive.paddingLocation);
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    properties.setFormatWidth(0);
                    properties.setPadString(Properties.DEFAULT_PAD_STRING);
                    properties.setPadPosition(Properties.DEFAULT_PAD_POSITION);
                }
                properties.setPositivePrefixPattern(this.positive.prefix.toString());
                properties.setPositiveSuffixPattern(this.positive.suffix.toString());
                if (this.negative != null) {
                    properties.setNegativePrefixPattern(this.negative.prefix.toString());
                    properties.setNegativeSuffixPattern(this.negative.suffix.toString());
                } else {
                    properties.setNegativePrefixPattern(null);
                    properties.setNegativeSuffixPattern(null);
                }
                if (this.positive.hasPercentSign) {
                    properties.setMagnitudeMultiplier(2);
                } else if (this.positive.hasPerMilleSign) {
                    properties.setMagnitudeMultiplier(3);
                } else {
                    properties.setMagnitudeMultiplier(0);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public static class SubpatternParseResult {
            int exponentDigits;
            boolean exponentShowPlusSign;
            int[] groupingSizes;
            boolean hasDecimal;
            boolean hasPerMilleSign;
            boolean hasPercentSign;
            int maximumFractionDigits;
            int maximumSignificantDigits;
            int minimumFractionDigits;
            int minimumIntegerDigits;
            int minimumSignificantDigits;
            StringBuilder padding;
            PaddingFormat.PadPosition paddingLocation;
            int paddingWidth;
            StringBuilder prefix;
            FormatQuantity4 rounding;
            StringBuilder suffix;
            int totalIntegerDigits;

            private SubpatternParseResult() {
                this.groupingSizes = new int[]{0, -1, -1};
                this.minimumIntegerDigits = 0;
                this.totalIntegerDigits = 0;
                this.minimumFractionDigits = 0;
                this.maximumFractionDigits = 0;
                this.minimumSignificantDigits = 0;
                this.maximumSignificantDigits = 0;
                this.hasDecimal = false;
                this.paddingWidth = 0;
                this.paddingLocation = null;
                this.rounding = new FormatQuantity4();
                this.exponentShowPlusSign = false;
                this.exponentDigits = 0;
                this.hasPercentSign = false;
                this.hasPerMilleSign = false;
                this.padding = new StringBuilder();
                this.prefix = new StringBuilder();
                this.suffix = new StringBuilder();
            }
        }

        /* access modifiers changed from: package-private */
        public static class ParserState {
            int offset = 0;
            final String pattern;

            ParserState(String str) {
                this.pattern = str;
            }

            /* access modifiers changed from: package-private */
            public int peek() {
                if (this.offset == this.pattern.length()) {
                    return -1;
                }
                return this.pattern.codePointAt(this.offset);
            }

            /* access modifiers changed from: package-private */
            public int next() {
                int peek = peek();
                this.offset += Character.charCount(peek);
                return peek;
            }

            /* access modifiers changed from: package-private */
            public IllegalArgumentException toParseException(String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected character in decimal format pattern: '");
                sb.append(this.pattern);
                sb.append("': ");
                sb.append(str);
                sb.append(": ");
                if (peek() == -1) {
                    sb.append("EOL");
                } else {
                    sb.append("'");
                    sb.append(Character.toChars(peek()));
                    sb.append("'");
                }
                return new IllegalArgumentException(sb.toString());
            }
        }

        static void parse(String str, Properties properties, boolean z) {
            if (str == null || str.length() == 0) {
                properties.clear();
                return;
            }
            ParserState parserState = new ParserState(str);
            PatternParseResult patternParseResult = new PatternParseResult();
            consumePattern(parserState, patternParseResult);
            patternParseResult.saveToProperties(properties, z);
        }

        private static void consumePattern(ParserState parserState, PatternParseResult patternParseResult) {
            consumeSubpattern(parserState, patternParseResult.positive);
            if (parserState.peek() == 59) {
                parserState.next();
                patternParseResult.negative = new SubpatternParseResult();
                consumeSubpattern(parserState, patternParseResult.negative);
            }
            if (parserState.peek() != -1) {
                throw parserState.toParseException("pattern");
            }
        }

        private static void consumeSubpattern(ParserState parserState, SubpatternParseResult subpatternParseResult) {
            consumePadding(parserState, subpatternParseResult, PaddingFormat.PadPosition.BEFORE_PREFIX);
            consumeAffix(parserState, subpatternParseResult, subpatternParseResult.prefix);
            consumePadding(parserState, subpatternParseResult, PaddingFormat.PadPosition.AFTER_PREFIX);
            consumeFormat(parserState, subpatternParseResult);
            consumeExponent(parserState, subpatternParseResult);
            consumePadding(parserState, subpatternParseResult, PaddingFormat.PadPosition.BEFORE_SUFFIX);
            consumeAffix(parserState, subpatternParseResult, subpatternParseResult.suffix);
            consumePadding(parserState, subpatternParseResult, PaddingFormat.PadPosition.AFTER_SUFFIX);
        }

        private static void consumePadding(ParserState parserState, SubpatternParseResult subpatternParseResult, PaddingFormat.PadPosition padPosition) {
            if (parserState.peek() == 42) {
                subpatternParseResult.paddingLocation = padPosition;
                parserState.next();
                consumeLiteral(parserState, subpatternParseResult.padding);
            }
        }

        private static void consumeAffix(ParserState parserState, SubpatternParseResult subpatternParseResult, StringBuilder sb) {
            while (true) {
                switch (parserState.peek()) {
                    case -1:
                    case 35:
                    case 42:
                    case 44:
                    case 46:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 59:
                    case 64:
                        return;
                    case 37:
                        subpatternParseResult.hasPercentSign = true;
                        break;
                    case 8240:
                        subpatternParseResult.hasPerMilleSign = true;
                        break;
                }
                consumeLiteral(parserState, sb);
            }
        }

        private static void consumeLiteral(ParserState parserState, StringBuilder sb) {
            if (parserState.peek() == -1) {
                throw parserState.toParseException("expected unquoted literal but found end of string");
            } else if (parserState.peek() == 39) {
                sb.appendCodePoint(parserState.next());
                while (parserState.peek() != 39) {
                    if (parserState.peek() == -1) {
                        throw parserState.toParseException("expected quoted literal but found end of string");
                    }
                    sb.appendCodePoint(parserState.next());
                }
                sb.appendCodePoint(parserState.next());
            } else {
                sb.appendCodePoint(parserState.next());
            }
        }

        private static void consumeFormat(ParserState parserState, SubpatternParseResult subpatternParseResult) {
            consumeIntegerFormat(parserState, subpatternParseResult);
            if (parserState.peek() == 46) {
                parserState.next();
                subpatternParseResult.hasDecimal = true;
                subpatternParseResult.paddingWidth++;
                consumeFractionFormat(parserState, subpatternParseResult);
            }
        }

        private static void consumeIntegerFormat(ParserState parserState, SubpatternParseResult subpatternParseResult) {
            boolean z = false;
            boolean z2 = false;
            while (true) {
                switch (parserState.peek()) {
                    case 35:
                        if (!z2) {
                            subpatternParseResult.paddingWidth++;
                            int[] iArr = subpatternParseResult.groupingSizes;
                            iArr[0] = iArr[0] + 1;
                            subpatternParseResult.totalIntegerDigits += z ? 0 : 1;
                            subpatternParseResult.maximumSignificantDigits += z ? 1 : 0;
                            subpatternParseResult.rounding.appendDigit((byte) 0, 0, true);
                            break;
                        } else {
                            throw parserState.toParseException("# cannot follow 0 before decimal point");
                        }
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 45:
                    case 46:
                    case 47:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    default:
                        return;
                    case 44:
                        subpatternParseResult.paddingWidth++;
                        subpatternParseResult.groupingSizes[2] = subpatternParseResult.groupingSizes[1];
                        subpatternParseResult.groupingSizes[1] = subpatternParseResult.groupingSizes[0];
                        subpatternParseResult.groupingSizes[0] = 0;
                        break;
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        z2 = true;
                        if (!z) {
                            subpatternParseResult.paddingWidth++;
                            int[] iArr2 = subpatternParseResult.groupingSizes;
                            iArr2[0] = iArr2[0] + 1;
                            subpatternParseResult.totalIntegerDigits++;
                            subpatternParseResult.minimumIntegerDigits++;
                            subpatternParseResult.rounding.appendDigit((byte) (parserState.peek() - 48), 0, true);
                            break;
                        } else {
                            throw parserState.toParseException("Can't mix @ and 0 in pattern");
                        }
                    case 64:
                        z = true;
                        if (!z2) {
                            subpatternParseResult.paddingWidth++;
                            int[] iArr3 = subpatternParseResult.groupingSizes;
                            iArr3[0] = iArr3[0] + 1;
                            subpatternParseResult.totalIntegerDigits++;
                            subpatternParseResult.minimumSignificantDigits++;
                            subpatternParseResult.maximumSignificantDigits++;
                            subpatternParseResult.rounding.appendDigit((byte) 0, 0, true);
                            break;
                        } else {
                            throw parserState.toParseException("Can't mix @ and 0 in pattern");
                        }
                }
                parserState.next();
            }
        }

        private static void consumeFractionFormat(ParserState parserState, SubpatternParseResult subpatternParseResult) {
            int i = 0;
            boolean z = false;
            while (true) {
                switch (parserState.peek()) {
                    case 35:
                        z = true;
                        subpatternParseResult.paddingWidth++;
                        subpatternParseResult.maximumFractionDigits++;
                        i++;
                        break;
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    default:
                        return;
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        if (!z) {
                            subpatternParseResult.paddingWidth++;
                            subpatternParseResult.minimumFractionDigits++;
                            subpatternParseResult.maximumFractionDigits++;
                            if (parserState.peek() != 48) {
                                subpatternParseResult.rounding.appendDigit((byte) (parserState.peek() - 48), i, false);
                                i = 0;
                                break;
                            } else {
                                i++;
                                break;
                            }
                        } else {
                            throw parserState.toParseException("0 cannot follow # after decimal point");
                        }
                }
                parserState.next();
            }
        }

        private static void consumeExponent(ParserState parserState, SubpatternParseResult subpatternParseResult) {
            if (parserState.peek() == 69) {
                parserState.next();
                subpatternParseResult.paddingWidth++;
                if (parserState.peek() == 43) {
                    parserState.next();
                    subpatternParseResult.exponentShowPlusSign = true;
                    subpatternParseResult.paddingWidth++;
                }
                while (parserState.peek() == 48) {
                    parserState.next();
                    subpatternParseResult.exponentDigits++;
                    subpatternParseResult.paddingWidth++;
                }
            }
        }
    }
}
