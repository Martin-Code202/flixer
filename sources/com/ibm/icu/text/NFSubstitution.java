package com.ibm.icu.text;

import java.text.ParsePosition;
/* access modifiers changed from: package-private */
public abstract class NFSubstitution {
    static final /* synthetic */ boolean $assertionsDisabled = (!NFSubstitution.class.desiredAssertionStatus());
    final DecimalFormat numberFormat;
    final int pos;
    final NFRuleSet ruleSet;

    public abstract double calcUpperBound(double d);

    public abstract double composeRuleValue(double d, double d2);

    /* access modifiers changed from: package-private */
    public abstract char tokenChar();

    public abstract double transformNumber(double d);

    public abstract long transformNumber(long j);

    public static NFSubstitution makeSubstitution(int i, NFRule nFRule, NFRule nFRule2, NFRuleSet nFRuleSet, RuleBasedNumberFormat ruleBasedNumberFormat, String str) {
        if (str.length() == 0) {
            return null;
        }
        switch (str.charAt(0)) {
            case '<':
                if (nFRule.getBaseValue() == -1) {
                    throw new IllegalArgumentException("<< not allowed in negative-number rule");
                } else if (nFRule.getBaseValue() == -2 || nFRule.getBaseValue() == -3 || nFRule.getBaseValue() == -4) {
                    return new IntegralPartSubstitution(i, nFRuleSet, str);
                } else {
                    if (nFRuleSet.isFractionSet()) {
                        return new NumeratorSubstitution(i, (double) nFRule.getBaseValue(), ruleBasedNumberFormat.getDefaultRuleSet(), str);
                    }
                    return new MultiplierSubstitution(i, nFRule, nFRuleSet, str);
                }
            case '=':
                return new SameValueSubstitution(i, nFRuleSet, str);
            case '>':
                if (nFRule.getBaseValue() == -1) {
                    return new AbsoluteValueSubstitution(i, nFRuleSet, str);
                }
                if (nFRule.getBaseValue() == -2 || nFRule.getBaseValue() == -3 || nFRule.getBaseValue() == -4) {
                    return new FractionalPartSubstitution(i, nFRuleSet, str);
                }
                if (!nFRuleSet.isFractionSet()) {
                    return new ModulusSubstitution(i, nFRule, nFRule2, nFRuleSet, str);
                }
                throw new IllegalArgumentException(">> not allowed in fraction rule set");
            default:
                throw new IllegalArgumentException("Illegal substitution character");
        }
    }

    NFSubstitution(int i, NFRuleSet nFRuleSet, String str) {
        this.pos = i;
        int length = str.length();
        if (length >= 2 && str.charAt(0) == str.charAt(length - 1)) {
            str = str.substring(1, length - 1);
        } else if (length != 0) {
            throw new IllegalArgumentException("Illegal substitution syntax");
        }
        if (str.length() == 0) {
            this.ruleSet = nFRuleSet;
            this.numberFormat = null;
        } else if (str.charAt(0) == '%') {
            this.ruleSet = nFRuleSet.owner.findRuleSet(str);
            this.numberFormat = null;
        } else if (str.charAt(0) == '#' || str.charAt(0) == '0') {
            this.ruleSet = null;
            this.numberFormat = (DecimalFormat) nFRuleSet.owner.getDecimalFormat().clone();
            this.numberFormat.applyPattern(str);
        } else if (str.charAt(0) == '>') {
            this.ruleSet = nFRuleSet;
            this.numberFormat = null;
        } else {
            throw new IllegalArgumentException("Illegal substitution syntax");
        }
    }

    public void setDivisor(int i, short s) {
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NFSubstitution nFSubstitution = (NFSubstitution) obj;
        return this.pos == nFSubstitution.pos && (this.ruleSet != null || nFSubstitution.ruleSet == null) && (this.numberFormat != null ? this.numberFormat.equals(nFSubstitution.numberFormat) : nFSubstitution.numberFormat == null);
    }

    public int hashCode() {
        if ($assertionsDisabled) {
            return 42;
        }
        throw new AssertionError("hashCode not designed");
    }

    public String toString() {
        if (this.ruleSet != null) {
            return tokenChar() + this.ruleSet.getName() + tokenChar();
        }
        return tokenChar() + this.numberFormat.toPattern() + tokenChar();
    }

    public void doSubstitution(long j, StringBuilder sb, int i, int i2) {
        if (this.ruleSet != null) {
            this.ruleSet.format(transformNumber(j), sb, this.pos + i, i2);
        } else if (j <= 9007199254740991L) {
            double transformNumber = transformNumber((double) j);
            if (this.numberFormat.getMaximumFractionDigits() == 0) {
                transformNumber = Math.floor(transformNumber);
            }
            sb.insert(this.pos + i, this.numberFormat.format(transformNumber));
        } else {
            sb.insert(this.pos + i, this.numberFormat.format(transformNumber(j)));
        }
    }

    public void doSubstitution(double d, StringBuilder sb, int i, int i2) {
        double transformNumber = transformNumber(d);
        if (Double.isInfinite(transformNumber)) {
            this.ruleSet.findRule(Double.POSITIVE_INFINITY).doFormat(transformNumber, sb, this.pos + i, i2);
        } else if (transformNumber == Math.floor(transformNumber) && this.ruleSet != null) {
            this.ruleSet.format((long) transformNumber, sb, this.pos + i, i2);
        } else if (this.ruleSet != null) {
            this.ruleSet.format(transformNumber, sb, this.pos + i, i2);
        } else {
            sb.insert(this.pos + i, this.numberFormat.format(transformNumber));
        }
    }

    public Number doParse(String str, ParsePosition parsePosition, double d, double d2, boolean z) {
        Number number;
        double calcUpperBound = calcUpperBound(d2);
        if (this.ruleSet != null) {
            number = this.ruleSet.parse(str, parsePosition, calcUpperBound);
            if (z && !this.ruleSet.isFractionSet() && parsePosition.getIndex() == 0) {
                number = this.ruleSet.owner.getDecimalFormat().parse(str, parsePosition);
            }
        } else {
            number = this.numberFormat.parse(str, parsePosition);
        }
        if (parsePosition.getIndex() == 0) {
            return number;
        }
        double composeRuleValue = composeRuleValue(number.doubleValue(), d);
        if (composeRuleValue == ((double) ((long) composeRuleValue))) {
            return Long.valueOf((long) composeRuleValue);
        }
        return new Double(composeRuleValue);
    }

    public final int getPos() {
        return this.pos;
    }

    public boolean isModulusSubstitution() {
        return false;
    }
}
