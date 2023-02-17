package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.PluralRules;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.List;
/* access modifiers changed from: package-private */
public final class NFRule {
    static final /* synthetic */ boolean $assertionsDisabled = (!NFRule.class.desiredAssertionStatus());
    private static final String[] RULE_PREFIXES = {"<<", "<%", "<#", "<0", ">>", ">%", ">#", ">0", "=%", "=#", "=0"};
    static final Long ZERO = 0L;
    private long baseValue;
    private char decimalPoint = 0;
    private short exponent = 0;
    private final RuleBasedNumberFormat formatter;
    private int radix = 10;
    private PluralFormat rulePatternFormat = null;
    private String ruleText = null;
    private NFSubstitution sub1 = null;
    private NFSubstitution sub2 = null;

    public static void makeRules(String str, NFRuleSet nFRuleSet, NFRule nFRule, RuleBasedNumberFormat ruleBasedNumberFormat, List<NFRule> list) {
        NFRule nFRule2 = new NFRule(ruleBasedNumberFormat, str);
        String str2 = nFRule2.ruleText;
        int indexOf = str2.indexOf(91);
        int indexOf2 = indexOf < 0 ? -1 : str2.indexOf(93);
        if (indexOf2 < 0 || indexOf > indexOf2 || nFRule2.baseValue == -3 || nFRule2.baseValue == -1 || nFRule2.baseValue == -5 || nFRule2.baseValue == -6) {
            nFRule2.extractSubstitutions(nFRuleSet, str2, nFRule);
        } else {
            NFRule nFRule3 = null;
            StringBuilder sb = new StringBuilder();
            if ((nFRule2.baseValue > 0 && nFRule2.baseValue % power((long) nFRule2.radix, nFRule2.exponent) == 0) || nFRule2.baseValue == -2 || nFRule2.baseValue == -4) {
                nFRule3 = new NFRule(ruleBasedNumberFormat, null);
                if (nFRule2.baseValue >= 0) {
                    nFRule3.baseValue = nFRule2.baseValue;
                    if (!nFRuleSet.isFractionSet()) {
                        nFRule2.baseValue++;
                    }
                } else if (nFRule2.baseValue == -2) {
                    nFRule3.baseValue = -3;
                } else if (nFRule2.baseValue == -4) {
                    nFRule3.baseValue = nFRule2.baseValue;
                    nFRule2.baseValue = -2;
                }
                nFRule3.radix = nFRule2.radix;
                nFRule3.exponent = nFRule2.exponent;
                sb.append(str2.substring(0, indexOf));
                if (indexOf2 + 1 < str2.length()) {
                    sb.append(str2.substring(indexOf2 + 1));
                }
                nFRule3.extractSubstitutions(nFRuleSet, sb.toString(), nFRule);
            }
            sb.setLength(0);
            sb.append(str2.substring(0, indexOf));
            sb.append(str2.substring(indexOf + 1, indexOf2));
            if (indexOf2 + 1 < str2.length()) {
                sb.append(str2.substring(indexOf2 + 1));
            }
            nFRule2.extractSubstitutions(nFRuleSet, sb.toString(), nFRule);
            if (nFRule3 != null) {
                if (nFRule3.baseValue >= 0) {
                    list.add(nFRule3);
                } else {
                    nFRuleSet.setNonNumericalRule(nFRule3);
                }
            }
        }
        if (nFRule2.baseValue >= 0) {
            list.add(nFRule2);
        } else {
            nFRuleSet.setNonNumericalRule(nFRule2);
        }
    }

    public NFRule(RuleBasedNumberFormat ruleBasedNumberFormat, String str) {
        this.formatter = ruleBasedNumberFormat;
        this.ruleText = str == null ? null : parseRuleDescriptor(str);
    }

    private String parseRuleDescriptor(String str) {
        int indexOf = str.indexOf(":");
        if (indexOf != -1) {
            String substring = str.substring(0, indexOf);
            while (true) {
                indexOf++;
                if (indexOf >= str.length() || !PatternProps.isWhiteSpace(str.charAt(indexOf))) {
                    break;
                }
            }
            str = str.substring(indexOf);
            int length = substring.length();
            char charAt = substring.charAt(0);
            char charAt2 = substring.charAt(length - 1);
            if (charAt >= '0' && charAt <= '9' && charAt2 != 'x') {
                long j = 0;
                char c = 0;
                int i = 0;
                while (i < length) {
                    c = substring.charAt(i);
                    if (c < '0' || c > '9') {
                        if (c == '/' || c == '>') {
                            break;
                        } else if (!(PatternProps.isWhiteSpace(c) || c == ',' || c == '.')) {
                            throw new IllegalArgumentException("Illegal character " + c + " in rule descriptor");
                        }
                    } else {
                        j = (10 * j) + ((long) (c - '0'));
                    }
                    i++;
                }
                setBaseValue(j);
                if (c == '/') {
                    long j2 = 0;
                    i++;
                    while (i < length) {
                        c = substring.charAt(i);
                        if (c >= '0' && c <= '9') {
                            j2 = (10 * j2) + ((long) (c - '0'));
                        } else if (c == '>') {
                            break;
                        } else if (!(PatternProps.isWhiteSpace(c) || c == ',' || c == '.')) {
                            throw new IllegalArgumentException("Illegal character " + c + " in rule descriptor");
                        }
                        i++;
                    }
                    this.radix = (int) j2;
                    if (this.radix == 0) {
                        throw new IllegalArgumentException("Rule can't have radix of 0");
                    }
                    this.exponent = expectedExponent();
                }
                if (c == '>') {
                    while (i < length) {
                        if (substring.charAt(i) != '>' || this.exponent <= 0) {
                            throw new IllegalArgumentException("Illegal character in rule descriptor");
                        }
                        this.exponent = (short) (this.exponent - 1);
                        i++;
                    }
                }
            } else if (substring.equals("-x")) {
                setBaseValue(-1);
            } else if (length == 3) {
                if (charAt == '0' && charAt2 == 'x') {
                    setBaseValue(-3);
                    this.decimalPoint = substring.charAt(1);
                } else if (charAt == 'x' && charAt2 == 'x') {
                    setBaseValue(-2);
                    this.decimalPoint = substring.charAt(1);
                } else if (charAt == 'x' && charAt2 == '0') {
                    setBaseValue(-4);
                    this.decimalPoint = substring.charAt(1);
                } else if (substring.equals("NaN")) {
                    setBaseValue(-6);
                } else if (substring.equals("Inf")) {
                    setBaseValue(-5);
                }
            }
        }
        if (str.length() <= 0 || str.charAt(0) != '\'') {
            return str;
        }
        return str.substring(1);
    }

    private void extractSubstitutions(NFRuleSet nFRuleSet, String str, NFRule nFRule) {
        PluralRules.PluralType pluralType;
        this.ruleText = str;
        this.sub1 = extractSubstitution(nFRuleSet, nFRule);
        if (this.sub1 == null) {
            this.sub2 = null;
        } else {
            this.sub2 = extractSubstitution(nFRuleSet, nFRule);
        }
        String str2 = this.ruleText;
        int indexOf = str2.indexOf("$(");
        int indexOf2 = indexOf >= 0 ? str2.indexOf(")$", indexOf) : -1;
        if (indexOf2 >= 0) {
            int indexOf3 = str2.indexOf(44, indexOf);
            if (indexOf3 < 0) {
                throw new IllegalArgumentException("Rule \"" + str2 + "\" does not have a defined type");
            }
            String substring = this.ruleText.substring(indexOf + 2, indexOf3);
            if ("cardinal".equals(substring)) {
                pluralType = PluralRules.PluralType.CARDINAL;
            } else if ("ordinal".equals(substring)) {
                pluralType = PluralRules.PluralType.ORDINAL;
            } else {
                throw new IllegalArgumentException(substring + " is an unknown type");
            }
            this.rulePatternFormat = this.formatter.createPluralFormat(pluralType, str2.substring(indexOf3 + 1, indexOf2));
        }
    }

    private NFSubstitution extractSubstitution(NFRuleSet nFRuleSet, NFRule nFRule) {
        int i;
        int indexOfAnyRulePrefix = indexOfAnyRulePrefix(this.ruleText);
        if (indexOfAnyRulePrefix == -1) {
            return null;
        }
        if (this.ruleText.startsWith(">>>", indexOfAnyRulePrefix)) {
            i = indexOfAnyRulePrefix + 2;
        } else {
            char charAt = this.ruleText.charAt(indexOfAnyRulePrefix);
            i = this.ruleText.indexOf(charAt, indexOfAnyRulePrefix + 1);
            if (charAt == '<' && i != -1 && i < this.ruleText.length() - 1 && this.ruleText.charAt(i + 1) == charAt) {
                i++;
            }
        }
        if (i == -1) {
            return null;
        }
        NFSubstitution makeSubstitution = NFSubstitution.makeSubstitution(indexOfAnyRulePrefix, this, nFRule, nFRuleSet, this.formatter, this.ruleText.substring(indexOfAnyRulePrefix, i + 1));
        this.ruleText = this.ruleText.substring(0, indexOfAnyRulePrefix) + this.ruleText.substring(i + 1);
        return makeSubstitution;
    }

    /* access modifiers changed from: package-private */
    public final void setBaseValue(long j) {
        this.baseValue = j;
        this.radix = 10;
        if (this.baseValue >= 1) {
            this.exponent = expectedExponent();
            if (this.sub1 != null) {
                this.sub1.setDivisor(this.radix, this.exponent);
            }
            if (this.sub2 != null) {
                this.sub2.setDivisor(this.radix, this.exponent);
                return;
            }
            return;
        }
        this.exponent = 0;
    }

    private short expectedExponent() {
        if (this.radix == 0 || this.baseValue < 1) {
            return 0;
        }
        short log = (short) ((int) (Math.log((double) this.baseValue) / Math.log((double) this.radix)));
        if (power((long) this.radix, (short) (log + 1)) <= this.baseValue) {
            return (short) (log + 1);
        }
        return log;
    }

    private static int indexOfAnyRulePrefix(String str) {
        int i = -1;
        if (str.length() > 0) {
            for (String str2 : RULE_PREFIXES) {
                int indexOf = str.indexOf(str2);
                if (indexOf != -1 && (i == -1 || indexOf < i)) {
                    i = indexOf;
                }
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NFRule)) {
            return false;
        }
        NFRule nFRule = (NFRule) obj;
        return this.baseValue == nFRule.baseValue && this.radix == nFRule.radix && this.exponent == nFRule.exponent && this.ruleText.equals(nFRule.ruleText) && Utility.objectEquals(this.sub1, nFRule.sub1) && Utility.objectEquals(this.sub2, nFRule.sub2);
    }

    public int hashCode() {
        if ($assertionsDisabled) {
            return 42;
        }
        throw new AssertionError("hashCode not designed");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.baseValue == -1) {
            sb.append("-x: ");
        } else if (this.baseValue == -2) {
            sb.append('x').append(this.decimalPoint == 0 ? '.' : this.decimalPoint).append("x: ");
        } else if (this.baseValue == -3) {
            sb.append('0').append(this.decimalPoint == 0 ? '.' : this.decimalPoint).append("x: ");
        } else if (this.baseValue == -4) {
            sb.append('x').append(this.decimalPoint == 0 ? '.' : this.decimalPoint).append("0: ");
        } else if (this.baseValue == -5) {
            sb.append("Inf: ");
        } else if (this.baseValue == -6) {
            sb.append("NaN: ");
        } else {
            sb.append(String.valueOf(this.baseValue));
            if (this.radix != 10) {
                sb.append('/').append(this.radix);
            }
            int expectedExponent = expectedExponent() - this.exponent;
            for (int i = 0; i < expectedExponent; i++) {
                sb.append('>');
            }
            sb.append(": ");
        }
        if (this.ruleText.startsWith(" ") && (this.sub1 == null || this.sub1.getPos() != 0)) {
            sb.append('\'');
        }
        StringBuilder sb2 = new StringBuilder(this.ruleText);
        if (this.sub2 != null) {
            sb2.insert(this.sub2.getPos(), this.sub2.toString());
        }
        if (this.sub1 != null) {
            sb2.insert(this.sub1.getPos(), this.sub1.toString());
        }
        sb.append(sb2.toString());
        sb.append(';');
        return sb.toString();
    }

    public final char getDecimalPoint() {
        return this.decimalPoint;
    }

    public final long getBaseValue() {
        return this.baseValue;
    }

    public long getDivisor() {
        return power((long) this.radix, this.exponent);
    }

    public void doFormat(long j, StringBuilder sb, int i, int i2) {
        int length = this.ruleText.length();
        int i3 = 0;
        if (this.rulePatternFormat == null) {
            sb.insert(i, this.ruleText);
        } else {
            length = this.ruleText.indexOf("$(");
            int indexOf = this.ruleText.indexOf(")$", length);
            int length2 = sb.length();
            if (indexOf < this.ruleText.length() - 1) {
                sb.insert(i, this.ruleText.substring(indexOf + 2));
            }
            sb.insert(i, this.rulePatternFormat.format((double) (j / power((long) this.radix, this.exponent))));
            if (length > 0) {
                sb.insert(i, this.ruleText.substring(0, length));
            }
            i3 = this.ruleText.length() - (sb.length() - length2);
        }
        if (this.sub2 != null) {
            this.sub2.doSubstitution(j, sb, i - (this.sub2.getPos() > length ? i3 : 0), i2);
        }
        if (this.sub1 != null) {
            this.sub1.doSubstitution(j, sb, i - (this.sub1.getPos() > length ? i3 : 0), i2);
        }
    }

    public void doFormat(double d, StringBuilder sb, int i, int i2) {
        double d2;
        int length = this.ruleText.length();
        int i3 = 0;
        if (this.rulePatternFormat == null) {
            sb.insert(i, this.ruleText);
        } else {
            length = this.ruleText.indexOf("$(");
            int indexOf = this.ruleText.indexOf(")$", length);
            int length2 = sb.length();
            if (indexOf < this.ruleText.length() - 1) {
                sb.insert(i, this.ruleText.substring(indexOf + 2));
            }
            if (0.0d > d || d >= 1.0d) {
                d2 = d / ((double) power((long) this.radix, this.exponent));
            } else {
                d2 = (double) Math.round(((double) power((long) this.radix, this.exponent)) * d);
            }
            sb.insert(i, this.rulePatternFormat.format((double) ((long) d2)));
            if (length > 0) {
                sb.insert(i, this.ruleText.substring(0, length));
            }
            i3 = this.ruleText.length() - (sb.length() - length2);
        }
        if (this.sub2 != null) {
            this.sub2.doSubstitution(d, sb, i - (this.sub2.getPos() > length ? i3 : 0), i2);
        }
        if (this.sub1 != null) {
            this.sub1.doSubstitution(d, sb, i - (this.sub1.getPos() > length ? i3 : 0), i2);
        }
    }

    static long power(long j, short s) {
        if (s < 0) {
            throw new IllegalArgumentException("Exponent can not be negative");
        } else if (j < 0) {
            throw new IllegalArgumentException("Base can not be negative");
        } else {
            long j2 = 1;
            while (s > 0) {
                if ((s & 1) == 1) {
                    j2 *= j;
                }
                j *= j;
                s = (short) (s >> 1);
            }
            return j2;
        }
    }

    public boolean shouldRollBack(long j) {
        if ((this.sub1 == null || !this.sub1.isModulusSubstitution()) && (this.sub2 == null || !this.sub2.isModulusSubstitution())) {
            return false;
        }
        long power = power((long) this.radix, this.exponent);
        return j % power == 0 && this.baseValue % power != 0;
    }

    public Number doParse(String str, ParsePosition parsePosition, boolean z, double d) {
        ParsePosition parsePosition2 = new ParsePosition(0);
        int pos = this.sub1 != null ? this.sub1.getPos() : this.ruleText.length();
        int pos2 = this.sub2 != null ? this.sub2.getPos() : this.ruleText.length();
        String stripPrefix = stripPrefix(str, this.ruleText.substring(0, pos), parsePosition2);
        int length = str.length() - stripPrefix.length();
        if (parsePosition2.getIndex() == 0 && pos != 0) {
            return ZERO;
        }
        if (this.baseValue == -5) {
            parsePosition.setIndex(parsePosition2.getIndex());
            return Double.valueOf(Double.POSITIVE_INFINITY);
        } else if (this.baseValue == -6) {
            parsePosition.setIndex(parsePosition2.getIndex());
            return Double.valueOf(Double.NaN);
        } else {
            int i = 0;
            double d2 = 0.0d;
            int i2 = 0;
            double max = (double) Math.max(0L, this.baseValue);
            do {
                parsePosition2.setIndex(0);
                double doubleValue = matchToDelimiter(stripPrefix, i2, max, this.ruleText.substring(pos, pos2), this.rulePatternFormat, parsePosition2, this.sub1, d).doubleValue();
                if (parsePosition2.getIndex() != 0 || this.sub1 == null) {
                    i2 = parsePosition2.getIndex();
                    String substring = stripPrefix.substring(parsePosition2.getIndex());
                    ParsePosition parsePosition3 = new ParsePosition(0);
                    double doubleValue2 = matchToDelimiter(substring, 0, doubleValue, this.ruleText.substring(pos2), this.rulePatternFormat, parsePosition3, this.sub2, d).doubleValue();
                    if ((parsePosition3.getIndex() != 0 || this.sub2 == null) && parsePosition2.getIndex() + length + parsePosition3.getIndex() > i) {
                        i = parsePosition2.getIndex() + length + parsePosition3.getIndex();
                        d2 = doubleValue2;
                    }
                }
                if (pos == pos2 || parsePosition2.getIndex() <= 0 || parsePosition2.getIndex() >= stripPrefix.length()) {
                    break;
                }
            } while (parsePosition2.getIndex() != i2);
            parsePosition.setIndex(i);
            if (z && i > 0 && this.sub1 == null) {
                d2 = 1.0d / d2;
            }
            if (d2 == ((double) ((long) d2))) {
                return Long.valueOf((long) d2);
            }
            return new Double(d2);
        }
    }

    private String stripPrefix(String str, String str2, ParsePosition parsePosition) {
        int prefixLength;
        if (str2.length() == 0 || (prefixLength = prefixLength(str, str2)) == 0) {
            return str;
        }
        parsePosition.setIndex(parsePosition.getIndex() + prefixLength);
        return str.substring(prefixLength);
    }

    private Number matchToDelimiter(String str, int i, double d, String str2, PluralFormat pluralFormat, ParsePosition parsePosition, NFSubstitution nFSubstitution, double d2) {
        if (!allIgnorable(str2)) {
            ParsePosition parsePosition2 = new ParsePosition(0);
            int[] findText = findText(str, str2, pluralFormat, i);
            int i2 = findText[0];
            int i3 = findText[1];
            while (i2 >= 0) {
                String substring = str.substring(0, i2);
                if (substring.length() > 0) {
                    Number doParse = nFSubstitution.doParse(substring, parsePosition2, d, d2, this.formatter.lenientParseEnabled());
                    if (parsePosition2.getIndex() == i2) {
                        parsePosition.setIndex(i2 + i3);
                        return doParse;
                    }
                }
                parsePosition2.setIndex(0);
                int[] findText2 = findText(str, str2, pluralFormat, i2 + i3);
                i2 = findText2[0];
                i3 = findText2[1];
            }
            parsePosition.setIndex(0);
            return ZERO;
        } else if (nFSubstitution == null) {
            return Double.valueOf(d);
        } else {
            ParsePosition parsePosition3 = new ParsePosition(0);
            Long l = ZERO;
            Number doParse2 = nFSubstitution.doParse(str, parsePosition3, d, d2, this.formatter.lenientParseEnabled());
            if (parsePosition3.getIndex() == 0) {
                return l;
            }
            parsePosition.setIndex(parsePosition3.getIndex());
            return doParse2 != null ? doParse2 : l;
        }
    }

    private int prefixLength(String str, String str2) {
        if (str2.length() == 0) {
            return 0;
        }
        RbnfLenientScanner lenientScanner = this.formatter.getLenientScanner();
        if (lenientScanner != null) {
            return lenientScanner.prefixLength(str, str2);
        }
        if (str.startsWith(str2)) {
            return str2.length();
        }
        return 0;
    }

    private int[] findText(String str, String str2, PluralFormat pluralFormat, int i) {
        RbnfLenientScanner lenientScanner = this.formatter.getLenientScanner();
        if (pluralFormat == null) {
            return lenientScanner != null ? lenientScanner.findText(str, str2, i) : new int[]{str.indexOf(str2, i), str2.length()};
        }
        FieldPosition fieldPosition = new FieldPosition(0);
        fieldPosition.setBeginIndex(i);
        pluralFormat.parseType(str, lenientScanner, fieldPosition);
        int beginIndex = fieldPosition.getBeginIndex();
        if (beginIndex >= 0) {
            int indexOf = this.ruleText.indexOf("$(");
            int indexOf2 = this.ruleText.indexOf(")$", indexOf) + 2;
            int endIndex = fieldPosition.getEndIndex() - beginIndex;
            String substring = this.ruleText.substring(0, indexOf);
            String substring2 = this.ruleText.substring(indexOf2);
            if (str.regionMatches(beginIndex - substring.length(), substring, 0, substring.length()) && str.regionMatches(beginIndex + endIndex, substring2, 0, substring2.length())) {
                return new int[]{beginIndex - substring.length(), substring.length() + endIndex + substring2.length()};
            }
        }
        return new int[]{-1, 0};
    }

    private boolean allIgnorable(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        RbnfLenientScanner lenientScanner = this.formatter.getLenientScanner();
        return lenientScanner != null && lenientScanner.allIgnorable(str);
    }
}
