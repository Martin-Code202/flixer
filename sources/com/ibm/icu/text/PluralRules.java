package com.ibm.icu.text;

import com.ibm.icu.impl.PluralRulesLoader;
import com.ibm.icu.util.ULocale;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
public class PluralRules implements Serializable {
    static final UnicodeSet ALLOWED_ID = new UnicodeSet("[a-z]").freeze();
    static final Pattern AND_SEPARATED = Pattern.compile("\\s*and\\s*");
    static final Pattern AT_SEPARATED = Pattern.compile("\\s*\\Q\\E@\\s*");
    static final Pattern COMMA_SEPARATED = Pattern.compile("\\s*,\\s*");
    public static final PluralRules DEFAULT = new PluralRules(new RuleList().addRule(DEFAULT_RULE));
    private static final Rule DEFAULT_RULE = new Rule("other", NO_CONSTRAINT, null, null);
    static final Pattern DOTDOT_SEPARATED = Pattern.compile("\\s*\\Q..\\E\\s*");
    private static final Constraint NO_CONSTRAINT = new Constraint() { // from class: com.ibm.icu.text.PluralRules.1
        private static final long serialVersionUID = 9163464945387899416L;

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isFulfilled(IFixedDecimal iFixedDecimal) {
            return true;
        }

        @Override // java.lang.Object
        public String toString() {
            return "";
        }
    };
    static final Pattern OR_SEPARATED = Pattern.compile("\\s*or\\s*");
    static final Pattern SEMI_SEPARATED = Pattern.compile("\\s*;\\s*");
    static final Pattern TILDE_SEPARATED = Pattern.compile("\\s*~\\s*");
    private static final long serialVersionUID = 1;
    private final transient Set<String> keywords;
    private final RuleList rules;

    /* access modifiers changed from: package-private */
    public interface Constraint extends Serializable {
        boolean isFulfilled(IFixedDecimal iFixedDecimal);
    }

    @Deprecated
    public interface IFixedDecimal {
        @Deprecated
        double getPluralOperand(Operand operand);

        @Deprecated
        boolean isInfinite();

        @Deprecated
        boolean isNaN();
    }

    @Deprecated
    public enum Operand {
        n,
        i,
        f,
        t,
        v,
        w,
        j
    }

    public enum PluralType {
        CARDINAL,
        ORDINAL
    }

    @Deprecated
    public enum SampleType {
        INTEGER,
        DECIMAL
    }

    @Deprecated
    public static abstract class Factory {
        @Deprecated
        protected Factory() {
        }

        @Deprecated
        public static PluralRulesLoader getDefaultFactory() {
            return PluralRulesLoader.loader;
        }
    }

    public static PluralRules parseDescription(String str) {
        String trim = str.trim();
        return trim.length() == 0 ? DEFAULT : new PluralRules(parseRuleChain(trim));
    }

    public static PluralRules createRules(String str) {
        try {
            return parseDescription(str);
        } catch (Exception e) {
            return null;
        }
    }

    @Deprecated
    public static class FixedDecimal extends Number implements Comparable<FixedDecimal>, IFixedDecimal {
        private static final long serialVersionUID = -4756200506571685661L;
        private final int baseFactor;
        @Deprecated
        public final long decimalDigits;
        @Deprecated
        public final long decimalDigitsWithoutTrailingZeros;
        @Deprecated
        public final boolean hasIntegerValue;
        @Deprecated
        public final long integerValue;
        @Deprecated
        public final boolean isNegative;
        @Deprecated
        public final double source;
        @Deprecated
        public final int visibleDecimalDigitCount;
        @Deprecated
        public final int visibleDecimalDigitCountWithoutTrailingZeros;

        @Deprecated
        public int getVisibleDecimalDigitCount() {
            return this.visibleDecimalDigitCount;
        }

        @Deprecated
        public FixedDecimal(double d, int i, long j) {
            this.isNegative = d < 0.0d;
            this.source = this.isNegative ? -d : d;
            this.visibleDecimalDigitCount = i;
            this.decimalDigits = j;
            this.integerValue = d > 1.0E18d ? 1000000000000000000L : (long) d;
            this.hasIntegerValue = this.source == ((double) this.integerValue);
            if (j == 0) {
                this.decimalDigitsWithoutTrailingZeros = 0;
                this.visibleDecimalDigitCountWithoutTrailingZeros = 0;
            } else {
                long j2 = j;
                int i2 = i;
                while (j2 % 10 == 0) {
                    j2 /= 10;
                    i2--;
                }
                this.decimalDigitsWithoutTrailingZeros = j2;
                this.visibleDecimalDigitCountWithoutTrailingZeros = i2;
            }
            this.baseFactor = (int) Math.pow(10.0d, (double) i);
        }

        @Deprecated
        public FixedDecimal(double d, int i) {
            this(d, i, (long) getFractionalDigits(d, i));
        }

        private static int getFractionalDigits(double d, int i) {
            if (i == 0) {
                return 0;
            }
            if (d < 0.0d) {
                d = -d;
            }
            int pow = (int) Math.pow(10.0d, (double) i);
            return (int) (Math.round(((double) pow) * d) % ((long) pow));
        }

        @Deprecated
        public FixedDecimal(double d) {
            this(d, decimals(d));
        }

        @Deprecated
        public static int decimals(double d) {
            if (Double.isInfinite(d) || Double.isNaN(d)) {
                return 0;
            }
            if (d < 0.0d) {
                d = -d;
            }
            if (d == Math.floor(d)) {
                return 0;
            }
            if (d < 1.0E9d) {
                long j = ((long) (1000000.0d * d)) % 1000000;
                int i = 10;
                for (int i2 = 6; i2 > 0; i2--) {
                    if (j % ((long) i) != 0) {
                        return i2;
                    }
                    i *= 10;
                }
                return 0;
            }
            String format = String.format(Locale.ENGLISH, "%1.15e", Double.valueOf(d));
            int lastIndexOf = format.lastIndexOf(101);
            int i3 = lastIndexOf + 1;
            if (format.charAt(i3) == '+') {
                i3++;
            }
            int parseInt = (lastIndexOf - 2) - Integer.parseInt(format.substring(i3));
            if (parseInt < 0) {
                return 0;
            }
            int i4 = lastIndexOf - 1;
            while (parseInt > 0 && format.charAt(i4) == '0') {
                parseInt--;
                i4--;
            }
            return parseInt;
        }

        @Deprecated
        public FixedDecimal(String str) {
            this(Double.parseDouble(str), getVisibleFractionCount(str));
        }

        private static int getVisibleFractionCount(String str) {
            String trim = str.trim();
            int indexOf = trim.indexOf(46) + 1;
            if (indexOf == 0) {
                return 0;
            }
            return trim.length() - indexOf;
        }

        @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
        @Deprecated
        public double getPluralOperand(Operand operand) {
            switch (operand) {
                case n:
                    return this.source;
                case i:
                    return (double) this.integerValue;
                case f:
                    return (double) this.decimalDigits;
                case t:
                    return (double) this.decimalDigitsWithoutTrailingZeros;
                case v:
                    return (double) this.visibleDecimalDigitCount;
                case w:
                    return (double) this.visibleDecimalDigitCountWithoutTrailingZeros;
                default:
                    return this.source;
            }
        }

        @Deprecated
        public static Operand getOperand(String str) {
            return Operand.valueOf(str);
        }

        @Deprecated
        public int compareTo(FixedDecimal fixedDecimal) {
            if (this.integerValue != fixedDecimal.integerValue) {
                return this.integerValue < fixedDecimal.integerValue ? -1 : 1;
            }
            if (this.source != fixedDecimal.source) {
                return this.source < fixedDecimal.source ? -1 : 1;
            }
            if (this.visibleDecimalDigitCount != fixedDecimal.visibleDecimalDigitCount) {
                return this.visibleDecimalDigitCount < fixedDecimal.visibleDecimalDigitCount ? -1 : 1;
            }
            long j = this.decimalDigits - fixedDecimal.decimalDigits;
            if (j != 0) {
                return j < 0 ? -1 : 1;
            }
            return 0;
        }

        @Override // java.lang.Object
        @Deprecated
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FixedDecimal)) {
                return false;
            }
            FixedDecimal fixedDecimal = (FixedDecimal) obj;
            return this.source == fixedDecimal.source && this.visibleDecimalDigitCount == fixedDecimal.visibleDecimalDigitCount && this.decimalDigits == fixedDecimal.decimalDigits;
        }

        @Override // java.lang.Object
        @Deprecated
        public int hashCode() {
            return (int) (this.decimalDigits + ((long) ((this.visibleDecimalDigitCount + ((int) (this.source * 37.0d))) * 37)));
        }

        @Override // java.lang.Object
        @Deprecated
        public String toString() {
            return String.format("%." + this.visibleDecimalDigitCount + "f", Double.valueOf(this.source));
        }

        @Override // java.lang.Number
        @Deprecated
        public int intValue() {
            return (int) this.integerValue;
        }

        @Override // java.lang.Number
        @Deprecated
        public long longValue() {
            return this.integerValue;
        }

        @Override // java.lang.Number
        @Deprecated
        public float floatValue() {
            return (float) this.source;
        }

        @Override // java.lang.Number
        @Deprecated
        public double doubleValue() {
            return this.isNegative ? -this.source : this.source;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream objectInputStream) {
            throw new NotSerializableException();
        }

        @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
        @Deprecated
        public boolean isNaN() {
            return Double.isNaN(this.source);
        }

        @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
        @Deprecated
        public boolean isInfinite() {
            return Double.isInfinite(this.source);
        }
    }

    @Deprecated
    public static class FixedDecimalRange {
        @Deprecated
        public final FixedDecimal end;
        @Deprecated
        public final FixedDecimal start;

        @Deprecated
        public FixedDecimalRange(FixedDecimal fixedDecimal, FixedDecimal fixedDecimal2) {
            if (fixedDecimal.visibleDecimalDigitCount != fixedDecimal2.visibleDecimalDigitCount) {
                throw new IllegalArgumentException("Ranges must have the same number of visible decimals: " + fixedDecimal + "~" + fixedDecimal2);
            }
            this.start = fixedDecimal;
            this.end = fixedDecimal2;
        }

        @Deprecated
        public String toString() {
            return this.start + (this.end == this.start ? "" : "~" + this.end);
        }
    }

    @Deprecated
    public static class FixedDecimalSamples {
        @Deprecated
        public final boolean bounded;
        @Deprecated
        public final SampleType sampleType;
        @Deprecated
        public final Set<FixedDecimalRange> samples;

        private FixedDecimalSamples(SampleType sampleType2, Set<FixedDecimalRange> set, boolean z) {
            this.sampleType = sampleType2;
            this.samples = set;
            this.bounded = z;
        }

        static FixedDecimalSamples parse(String str) {
            SampleType sampleType2;
            boolean z = true;
            boolean z2 = false;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (str.startsWith("integer")) {
                sampleType2 = SampleType.INTEGER;
            } else if (str.startsWith("decimal")) {
                sampleType2 = SampleType.DECIMAL;
            } else {
                throw new IllegalArgumentException("Samples must start with 'integer' or 'decimal'");
            }
            String[] split = PluralRules.COMMA_SEPARATED.split(str.substring(7).trim());
            for (String str2 : split) {
                if (str2.equals("…") || str2.equals("...")) {
                    z = false;
                    z2 = true;
                } else if (z2) {
                    throw new IllegalArgumentException("Can only have … at the end of samples: " + str2);
                } else {
                    String[] split2 = PluralRules.TILDE_SEPARATED.split(str2);
                    switch (split2.length) {
                        case 1:
                            FixedDecimal fixedDecimal = new FixedDecimal(split2[0]);
                            checkDecimal(sampleType2, fixedDecimal);
                            linkedHashSet.add(new FixedDecimalRange(fixedDecimal, fixedDecimal));
                            continue;
                        case 2:
                            FixedDecimal fixedDecimal2 = new FixedDecimal(split2[0]);
                            FixedDecimal fixedDecimal3 = new FixedDecimal(split2[1]);
                            checkDecimal(sampleType2, fixedDecimal2);
                            checkDecimal(sampleType2, fixedDecimal3);
                            linkedHashSet.add(new FixedDecimalRange(fixedDecimal2, fixedDecimal3));
                            continue;
                        default:
                            throw new IllegalArgumentException("Ill-formed number range: " + str2);
                    }
                }
            }
            return new FixedDecimalSamples(sampleType2, Collections.unmodifiableSet(linkedHashSet), z);
        }

        private static void checkDecimal(SampleType sampleType2, FixedDecimal fixedDecimal) {
            if ((sampleType2 == SampleType.INTEGER) != (fixedDecimal.getVisibleDecimalDigitCount() == 0)) {
                throw new IllegalArgumentException("Ill-formed number range: " + fixedDecimal);
            }
        }

        @Deprecated
        public String toString() {
            StringBuilder append = new StringBuilder("@").append(this.sampleType.toString().toLowerCase(Locale.ENGLISH));
            boolean z = true;
            for (FixedDecimalRange fixedDecimalRange : this.samples) {
                if (z) {
                    z = false;
                } else {
                    append.append(",");
                }
                append.append(' ').append(fixedDecimalRange);
            }
            if (!this.bounded) {
                append.append(", …");
            }
            return append.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static class SimpleTokenizer {
        static final UnicodeSet BREAK_AND_IGNORE = new UnicodeSet(9, 10, 12, 13, 32, 32).freeze();
        static final UnicodeSet BREAK_AND_KEEP = new UnicodeSet(33, 33, 37, 37, 44, 44, 46, 46, 61, 61).freeze();

        SimpleTokenizer() {
        }

        static String[] split(String str) {
            int i = -1;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (BREAK_AND_IGNORE.contains(charAt)) {
                    if (i >= 0) {
                        arrayList.add(str.substring(i, i2));
                        i = -1;
                    }
                } else if (BREAK_AND_KEEP.contains(charAt)) {
                    if (i >= 0) {
                        arrayList.add(str.substring(i, i2));
                    }
                    arrayList.add(str.substring(i2, i2 + 1));
                    i = -1;
                } else if (i < 0) {
                    i = i2;
                }
            }
            if (i >= 0) {
                arrayList.add(str.substring(i));
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
    }

    private static Constraint parseConstraint(String str) {
        String[] split;
        String[] split2;
        String str2;
        int i;
        long[] jArr;
        OrConstraint orConstraint = null;
        for (String str3 : OR_SEPARATED.split(str)) {
            AndConstraint andConstraint = null;
            for (String str4 : AND_SEPARATED.split(str3)) {
                Constraint constraint = NO_CONSTRAINT;
                String trim = str4.trim();
                String[] split3 = SimpleTokenizer.split(trim);
                int i2 = 0;
                boolean z = true;
                boolean z2 = true;
                double d = 9.223372036854776E18d;
                double d2 = -9.223372036854776E18d;
                int i3 = 0 + 1;
                String str5 = split3[0];
                boolean z3 = false;
                try {
                    Operand operand = FixedDecimal.getOperand(str5);
                    if (i3 < split3.length) {
                        int i4 = i3 + 1;
                        String str6 = split3[1];
                        if ("mod".equals(str6) || "%".equals(str6)) {
                            i2 = Integer.parseInt(split3[2]);
                            i4 = i4 + 1 + 1;
                            str6 = nextToken(split3, 3, trim);
                        }
                        if ("not".equals(str6)) {
                            z = false;
                            i4++;
                            str6 = nextToken(split3, i4, trim);
                            if ("=".equals(str6)) {
                                throw unexpected(str6, trim);
                            }
                        } else if ("!".equals(str6)) {
                            z = false;
                            i4++;
                            str6 = nextToken(split3, i4, trim);
                            if (!"=".equals(str6)) {
                                throw unexpected(str6, trim);
                            }
                        }
                        if ("is".equals(str6) || "in".equals(str6) || "=".equals(str6)) {
                            z3 = "is".equals(str6);
                            if (!z3 || z) {
                                i = i4 + 1;
                                str2 = nextToken(split3, i4, trim);
                            } else {
                                throw unexpected(str6, trim);
                            }
                        } else if ("within".equals(str6)) {
                            z2 = false;
                            i = i4 + 1;
                            str2 = nextToken(split3, i4, trim);
                        } else {
                            throw unexpected(str6, trim);
                        }
                        if ("not".equals(str2)) {
                            if (z3 || z) {
                                z = !z;
                                i++;
                                str2 = nextToken(split3, i, trim);
                            } else {
                                throw unexpected(str2, trim);
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        while (true) {
                            long parseLong = Long.parseLong(str2);
                            long j = parseLong;
                            if (i < split3.length) {
                                i++;
                                str2 = nextToken(split3, i, trim);
                                if (str2.equals(".")) {
                                    int i5 = i + 1;
                                    String nextToken = nextToken(split3, i, trim);
                                    if (!nextToken.equals(".")) {
                                        throw unexpected(nextToken, trim);
                                    }
                                    i = i5 + 1;
                                    str2 = nextToken(split3, i5, trim);
                                    j = Long.parseLong(str2);
                                    if (i < split3.length) {
                                        i++;
                                        str2 = nextToken(split3, i, trim);
                                        if (!str2.equals(",")) {
                                            throw unexpected(str2, trim);
                                        }
                                    }
                                } else if (!str2.equals(",")) {
                                    throw unexpected(str2, trim);
                                }
                            }
                            if (parseLong > j) {
                                throw unexpected(parseLong + "~" + j, trim);
                            } else if (i2 == 0 || j < ((long) i2)) {
                                arrayList.add(Long.valueOf(parseLong));
                                arrayList.add(Long.valueOf(j));
                                d = Math.min(d, (double) parseLong);
                                d2 = Math.max(d2, (double) j);
                                if (i < split3.length) {
                                    i++;
                                    str2 = nextToken(split3, i, trim);
                                } else if (str2.equals(",")) {
                                    throw unexpected(str2, trim);
                                } else {
                                    if (arrayList.size() == 2) {
                                        jArr = null;
                                    } else {
                                        jArr = new long[arrayList.size()];
                                        for (int i6 = 0; i6 < jArr.length; i6++) {
                                            jArr[i6] = ((Long) arrayList.get(i6)).longValue();
                                        }
                                    }
                                    if (d == d2 || !z3 || z) {
                                        constraint = new RangeConstraint(i2, z, operand, z2, d, d2, jArr);
                                    } else {
                                        throw unexpected("is not <range>", trim);
                                    }
                                }
                            } else {
                                throw unexpected(j + ">mod=" + i2, trim);
                            }
                        }
                    }
                    if (andConstraint == null) {
                        andConstraint = constraint;
                    } else {
                        andConstraint = new AndConstraint(andConstraint, constraint);
                    }
                } catch (Exception e) {
                    throw unexpected(str5, trim);
                }
            }
            if (orConstraint == null) {
                orConstraint = andConstraint;
            } else {
                orConstraint = new OrConstraint(orConstraint, andConstraint);
            }
        }
        return orConstraint;
    }

    private static ParseException unexpected(String str, String str2) {
        return new ParseException("unexpected token '" + str + "' in '" + str2 + "'", -1);
    }

    private static String nextToken(String[] strArr, int i, String str) {
        if (i < strArr.length) {
            return strArr[i];
        }
        throw new ParseException("missing token at end of '" + str + "'", -1);
    }

    /* access modifiers changed from: private */
    public static Rule parseRule(String str) {
        Constraint constraint;
        if (str.length() == 0) {
            return DEFAULT_RULE;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int indexOf = lowerCase.indexOf(58);
        if (indexOf == -1) {
            throw new ParseException("missing ':' in rule description '" + lowerCase + "'", 0);
        }
        String trim = lowerCase.substring(0, indexOf).trim();
        if (!isValidKeyword(trim)) {
            throw new ParseException("keyword '" + trim + " is not valid", 0);
        }
        String trim2 = lowerCase.substring(indexOf + 1).trim();
        String[] split = AT_SEPARATED.split(trim2);
        FixedDecimalSamples fixedDecimalSamples = null;
        FixedDecimalSamples fixedDecimalSamples2 = null;
        switch (split.length) {
            case 1:
                break;
            case 2:
                fixedDecimalSamples = FixedDecimalSamples.parse(split[1]);
                if (fixedDecimalSamples.sampleType == SampleType.DECIMAL) {
                    fixedDecimalSamples2 = fixedDecimalSamples;
                    fixedDecimalSamples = null;
                    break;
                }
                break;
            case 3:
                fixedDecimalSamples = FixedDecimalSamples.parse(split[1]);
                fixedDecimalSamples2 = FixedDecimalSamples.parse(split[2]);
                if (!(fixedDecimalSamples.sampleType == SampleType.INTEGER && fixedDecimalSamples2.sampleType == SampleType.DECIMAL)) {
                    throw new IllegalArgumentException("Must have @integer then @decimal in " + trim2);
                }
            default:
                throw new IllegalArgumentException("Too many samples in " + trim2);
        }
        boolean equals = trim.equals("other");
        if (equals != (split[0].length() == 0)) {
            throw new IllegalArgumentException("The keyword 'other' must have no constraints, just samples.");
        }
        if (equals) {
            constraint = NO_CONSTRAINT;
        } else {
            constraint = parseConstraint(split[0]);
        }
        return new Rule(trim, constraint, fixedDecimalSamples, fixedDecimalSamples2);
    }

    private static RuleList parseRuleChain(String str) {
        String[] split;
        RuleList ruleList = new RuleList();
        if (str.endsWith(";")) {
            str = str.substring(0, str.length() - 1);
        }
        for (String str2 : SEMI_SEPARATED.split(str)) {
            Rule parseRule = parseRule(str2.trim());
            ruleList.hasExplicitBoundingInfo |= (parseRule.integerSamples == null && parseRule.decimalSamples == null) ? false : true;
            ruleList.addRule(parseRule);
        }
        return ruleList.finish();
    }

    /* access modifiers changed from: package-private */
    public static class RangeConstraint implements Constraint, Serializable {
        private static final long serialVersionUID = 1;
        private final boolean inRange;
        private final boolean integersOnly;
        private final double lowerBound;
        private final int mod;
        private final Operand operand;
        private final long[] range_list;
        private final double upperBound;

        RangeConstraint(int i, boolean z, Operand operand2, boolean z2, double d, double d2, long[] jArr) {
            this.mod = i;
            this.inRange = z;
            this.integersOnly = z2;
            this.lowerBound = d;
            this.upperBound = d2;
            this.range_list = jArr;
            this.operand = operand2;
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isFulfilled(IFixedDecimal iFixedDecimal) {
            double pluralOperand = iFixedDecimal.getPluralOperand(this.operand);
            if ((this.integersOnly && pluralOperand - ((double) ((long) pluralOperand)) != 0.0d) || (this.operand == Operand.j && iFixedDecimal.getPluralOperand(Operand.v) != 0.0d)) {
                return !this.inRange;
            }
            if (this.mod != 0) {
                pluralOperand %= (double) this.mod;
            }
            boolean z = pluralOperand >= this.lowerBound && pluralOperand <= this.upperBound;
            if (z && this.range_list != null) {
                z = false;
                int i = 0;
                while (!z && i < this.range_list.length) {
                    z = pluralOperand >= ((double) this.range_list[i]) && pluralOperand <= ((double) this.range_list[i + 1]);
                    i += 2;
                }
            }
            return this.inRange == z;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.operand);
            if (this.mod != 0) {
                sb.append(" % ").append(this.mod);
            }
            sb.append(!((this.lowerBound > this.upperBound ? 1 : (this.lowerBound == this.upperBound ? 0 : -1)) != 0) ? this.inRange ? " = " : " != " : this.integersOnly ? this.inRange ? " = " : " != " : this.inRange ? " within " : " not within ");
            if (this.range_list != null) {
                int i = 0;
                while (i < this.range_list.length) {
                    PluralRules.addRange(sb, (double) this.range_list[i], (double) this.range_list[i + 1], i != 0);
                    i += 2;
                }
            } else {
                PluralRules.addRange(sb, this.lowerBound, this.upperBound, false);
            }
            return sb.toString();
        }
    }

    /* renamed from: com.ibm.icu.text.PluralRules$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$PluralRules$SampleType = new int[SampleType.values().length];

        static {
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$SampleType[SampleType.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$SampleType[SampleType.DECIMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $SwitchMap$com$ibm$icu$text$PluralRules$Operand = new int[Operand.values().length];
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.n.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.i.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.f.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.t.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.v.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$PluralRules$Operand[Operand.w.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static void addRange(StringBuilder sb, double d, double d2, boolean z) {
        if (z) {
            sb.append(",");
        }
        if (d == d2) {
            sb.append(format(d));
        } else {
            sb.append(format(d) + ".." + format(d2));
        }
    }

    private static String format(double d) {
        long j = (long) d;
        return d == ((double) j) ? String.valueOf(j) : String.valueOf(d);
    }

    static abstract class BinaryConstraint implements Constraint, Serializable {
        private static final long serialVersionUID = 1;
        protected final Constraint a;
        protected final Constraint b;

        protected BinaryConstraint(Constraint constraint, Constraint constraint2) {
            this.a = constraint;
            this.b = constraint2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class AndConstraint extends BinaryConstraint {
        private static final long serialVersionUID = 7766999779862263523L;

        AndConstraint(Constraint constraint, Constraint constraint2) {
            super(constraint, constraint2);
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isFulfilled(IFixedDecimal iFixedDecimal) {
            return this.a.isFulfilled(iFixedDecimal) && this.b.isFulfilled(iFixedDecimal);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.a.toString() + " and " + this.b.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static class OrConstraint extends BinaryConstraint {
        private static final long serialVersionUID = 1405488568664762222L;

        OrConstraint(Constraint constraint, Constraint constraint2) {
            super(constraint, constraint2);
        }

        @Override // com.ibm.icu.text.PluralRules.Constraint
        public boolean isFulfilled(IFixedDecimal iFixedDecimal) {
            return this.a.isFulfilled(iFixedDecimal) || this.b.isFulfilled(iFixedDecimal);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.a.toString() + " or " + this.b.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static class Rule implements Serializable {
        private static final long serialVersionUID = 1;
        private final Constraint constraint;
        private final FixedDecimalSamples decimalSamples;
        private final FixedDecimalSamples integerSamples;
        private final String keyword;

        public Rule(String str, Constraint constraint2, FixedDecimalSamples fixedDecimalSamples, FixedDecimalSamples fixedDecimalSamples2) {
            this.keyword = str;
            this.constraint = constraint2;
            this.integerSamples = fixedDecimalSamples;
            this.decimalSamples = fixedDecimalSamples2;
        }

        public String getKeyword() {
            return this.keyword;
        }

        public boolean appliesTo(IFixedDecimal iFixedDecimal) {
            return this.constraint.isFulfilled(iFixedDecimal);
        }

        @Override // java.lang.Object
        public String toString() {
            String str;
            String str2;
            StringBuilder append = new StringBuilder().append(this.keyword).append(": ").append(this.constraint.toString());
            if (this.integerSamples == null) {
                str = "";
            } else {
                str = " " + this.integerSamples.toString();
            }
            StringBuilder append2 = append.append(str);
            if (this.decimalSamples == null) {
                str2 = "";
            } else {
                str2 = " " + this.decimalSamples.toString();
            }
            return append2.append(str2).toString();
        }

        @Override // java.lang.Object
        @Deprecated
        public int hashCode() {
            return this.keyword.hashCode() ^ this.constraint.hashCode();
        }
    }

    /* access modifiers changed from: package-private */
    public static class RuleList implements Serializable {
        private static final long serialVersionUID = 1;
        private boolean hasExplicitBoundingInfo;
        private final List<Rule> rules;

        private RuleList() {
            this.hasExplicitBoundingInfo = false;
            this.rules = new ArrayList();
        }

        public RuleList addRule(Rule rule) {
            String keyword = rule.getKeyword();
            for (Rule rule2 : this.rules) {
                if (keyword.equals(rule2.getKeyword())) {
                    throw new IllegalArgumentException("Duplicate keyword: " + keyword);
                }
            }
            this.rules.add(rule);
            return this;
        }

        public RuleList finish() {
            Rule rule = null;
            Iterator<Rule> it = this.rules.iterator();
            while (it.hasNext()) {
                Rule next = it.next();
                if ("other".equals(next.getKeyword())) {
                    rule = next;
                    it.remove();
                }
            }
            if (rule == null) {
                rule = PluralRules.parseRule("other:");
            }
            this.rules.add(rule);
            return this;
        }

        private Rule selectRule(IFixedDecimal iFixedDecimal) {
            for (Rule rule : this.rules) {
                if (rule.appliesTo(iFixedDecimal)) {
                    return rule;
                }
            }
            return null;
        }

        public String select(IFixedDecimal iFixedDecimal) {
            if (iFixedDecimal.isInfinite() || iFixedDecimal.isNaN()) {
                return "other";
            }
            return selectRule(iFixedDecimal).getKeyword();
        }

        public Set<String> getKeywords() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Rule rule : this.rules) {
                linkedHashSet.add(rule.getKeyword());
            }
            return linkedHashSet;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Rule rule : this.rules) {
                if (sb.length() != 0) {
                    sb.append(";  ");
                }
                sb.append(rule);
            }
            return sb.toString();
        }
    }

    public static PluralRules forLocale(ULocale uLocale) {
        return Factory.getDefaultFactory().forLocale(uLocale, PluralType.CARDINAL);
    }

    public static PluralRules forLocale(ULocale uLocale, PluralType pluralType) {
        return Factory.getDefaultFactory().forLocale(uLocale, pluralType);
    }

    private static boolean isValidKeyword(String str) {
        return ALLOWED_ID.containsAll(str);
    }

    private PluralRules(RuleList ruleList) {
        this.rules = ruleList;
        this.keywords = Collections.unmodifiableSet(ruleList.getKeywords());
    }

    @Override // java.lang.Object
    @Deprecated
    public int hashCode() {
        return this.rules.hashCode();
    }

    public String select(double d) {
        return this.rules.select(new FixedDecimal(d));
    }

    @Deprecated
    public String select(IFixedDecimal iFixedDecimal) {
        return this.rules.select(iFixedDecimal);
    }

    public Set<String> getKeywords() {
        return this.keywords;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.rules.toString();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof PluralRules) && equals((PluralRules) obj);
    }

    public boolean equals(PluralRules pluralRules) {
        return pluralRules != null && toString().equals(pluralRules.toString());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        throw new NotSerializableException();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new NotSerializableException();
    }

    private Object writeReplace() {
        return new PluralRulesSerialProxy(toString());
    }
}
