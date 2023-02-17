package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.Utility;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* access modifiers changed from: package-private */
public final class NFRuleSet {
    static final /* synthetic */ boolean $assertionsDisabled = (!NFRuleSet.class.desiredAssertionStatus());
    LinkedList<NFRule> fractionRules;
    private boolean isFractionRuleSet = false;
    private final boolean isParseable;
    private final String name;
    final NFRule[] nonNumericalRules = new NFRule[6];
    final RuleBasedNumberFormat owner;
    private NFRule[] rules;

    public NFRuleSet(RuleBasedNumberFormat ruleBasedNumberFormat, String[] strArr, int i) {
        this.owner = ruleBasedNumberFormat;
        String str = strArr[i];
        if (str.length() == 0) {
            throw new IllegalArgumentException("Empty rule set description");
        }
        if (str.charAt(0) == '%') {
            int indexOf = str.indexOf(58);
            if (indexOf == -1) {
                throw new IllegalArgumentException("Rule set name doesn't end in colon");
            }
            String substring = str.substring(0, indexOf);
            this.isParseable = !substring.endsWith("@noparse");
            this.name = !this.isParseable ? substring.substring(0, substring.length() - 8) : substring;
            while (indexOf < str.length()) {
                indexOf++;
                if (!PatternProps.isWhiteSpace(str.charAt(indexOf))) {
                    break;
                }
            }
            str = str.substring(indexOf);
            strArr[i] = str;
        } else {
            this.name = "%default";
            this.isParseable = true;
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Empty rule set description");
        }
    }

    public void parseRules(String str) {
        ArrayList<NFRule> arrayList = new ArrayList();
        NFRule nFRule = null;
        int i = 0;
        int length = str.length();
        do {
            int indexOf = str.indexOf(59, i);
            if (indexOf < 0) {
                indexOf = length;
            }
            NFRule.makeRules(str.substring(i, indexOf), this, nFRule, this.owner, arrayList);
            if (!arrayList.isEmpty()) {
                nFRule = (NFRule) arrayList.get(arrayList.size() - 1);
            }
            i = indexOf + 1;
        } while (i < length);
        long j = 0;
        for (NFRule nFRule2 : arrayList) {
            long baseValue = nFRule2.getBaseValue();
            if (baseValue == 0) {
                nFRule2.setBaseValue(j);
            } else if (baseValue < j) {
                throw new IllegalArgumentException("Rules are not in order, base: " + baseValue + " < " + j);
            } else {
                j = baseValue;
            }
            if (!this.isFractionRuleSet) {
                j++;
            }
        }
        this.rules = new NFRule[arrayList.size()];
        arrayList.toArray(this.rules);
    }

    /* access modifiers changed from: package-private */
    public void setNonNumericalRule(NFRule nFRule) {
        long baseValue = nFRule.getBaseValue();
        if (baseValue == -1) {
            this.nonNumericalRules[0] = nFRule;
        } else if (baseValue == -2) {
            setBestFractionRule(1, nFRule, true);
        } else if (baseValue == -3) {
            setBestFractionRule(2, nFRule, true);
        } else if (baseValue == -4) {
            setBestFractionRule(3, nFRule, true);
        } else if (baseValue == -5) {
            this.nonNumericalRules[4] = nFRule;
        } else if (baseValue == -6) {
            this.nonNumericalRules[5] = nFRule;
        }
    }

    private void setBestFractionRule(int i, NFRule nFRule, boolean z) {
        if (z) {
            if (this.fractionRules == null) {
                this.fractionRules = new LinkedList<>();
            }
            this.fractionRules.add(nFRule);
        }
        if (this.nonNumericalRules[i] == null) {
            this.nonNumericalRules[i] = nFRule;
        } else if (this.owner.getDecimalFormatSymbols().getDecimalSeparator() == nFRule.getDecimalPoint()) {
            this.nonNumericalRules[i] = nFRule;
        }
    }

    public void makeIntoFractionRuleSet() {
        this.isFractionRuleSet = true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NFRuleSet)) {
            return false;
        }
        NFRuleSet nFRuleSet = (NFRuleSet) obj;
        if (!(this.name.equals(nFRuleSet.name) && this.rules.length == nFRuleSet.rules.length && this.isFractionRuleSet == nFRuleSet.isFractionRuleSet)) {
            return false;
        }
        for (int i = 0; i < this.nonNumericalRules.length; i++) {
            if (!Utility.objectEquals(this.nonNumericalRules[i], nFRuleSet.nonNumericalRules[i])) {
                return false;
            }
        }
        for (int i2 = 0; i2 < this.rules.length; i2++) {
            if (!this.rules[i2].equals(nFRuleSet.rules[i2])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if ($assertionsDisabled) {
            return 42;
        }
        throw new AssertionError("hashCode not designed");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(":\n");
        for (NFRule nFRule : this.rules) {
            sb.append(nFRule.toString()).append("\n");
        }
        NFRule[] nFRuleArr = this.nonNumericalRules;
        for (NFRule nFRule2 : nFRuleArr) {
            if (nFRule2 != null) {
                if (nFRule2.getBaseValue() == -2 || nFRule2.getBaseValue() == -3 || nFRule2.getBaseValue() == -4) {
                    Iterator<NFRule> it = this.fractionRules.iterator();
                    while (it.hasNext()) {
                        NFRule next = it.next();
                        if (next.getBaseValue() == nFRule2.getBaseValue()) {
                            sb.append(next.toString()).append("\n");
                        }
                    }
                } else {
                    sb.append(nFRule2.toString()).append("\n");
                }
            }
        }
        return sb.toString();
    }

    public boolean isFractionSet() {
        return this.isFractionRuleSet;
    }

    public String getName() {
        return this.name;
    }

    public boolean isPublic() {
        return !this.name.startsWith("%%");
    }

    public boolean isParseable() {
        return this.isParseable;
    }

    public void format(long j, StringBuilder sb, int i, int i2) {
        if (i2 >= 64) {
            throw new IllegalStateException("Recursion limit exceeded when applying ruleSet " + this.name);
        }
        findNormalRule(j).doFormat(j, sb, i, i2 + 1);
    }

    public void format(double d, StringBuilder sb, int i, int i2) {
        if (i2 >= 64) {
            throw new IllegalStateException("Recursion limit exceeded when applying ruleSet " + this.name);
        }
        findRule(d).doFormat(d, sb, i, i2 + 1);
    }

    /* access modifiers changed from: package-private */
    public NFRule findRule(double d) {
        if (this.isFractionRuleSet) {
            return findFractionRuleSetRule(d);
        }
        if (Double.isNaN(d)) {
            NFRule nFRule = this.nonNumericalRules[5];
            if (nFRule == null) {
                return this.owner.getDefaultNaNRule();
            }
            return nFRule;
        }
        if (d < 0.0d) {
            if (this.nonNumericalRules[0] != null) {
                return this.nonNumericalRules[0];
            }
            d = -d;
        }
        if (Double.isInfinite(d)) {
            NFRule nFRule2 = this.nonNumericalRules[4];
            if (nFRule2 == null) {
                return this.owner.getDefaultInfinityRule();
            }
            return nFRule2;
        }
        if (d != Math.floor(d)) {
            if (d < 1.0d && this.nonNumericalRules[2] != null) {
                return this.nonNumericalRules[2];
            }
            if (this.nonNumericalRules[1] != null) {
                return this.nonNumericalRules[1];
            }
        }
        if (this.nonNumericalRules[3] != null) {
            return this.nonNumericalRules[3];
        }
        return findNormalRule(Math.round(d));
    }

    private NFRule findNormalRule(long j) {
        if (this.isFractionRuleSet) {
            return findFractionRuleSetRule((double) j);
        }
        if (j < 0) {
            if (this.nonNumericalRules[0] != null) {
                return this.nonNumericalRules[0];
            }
            j = -j;
        }
        int i = 0;
        int length = this.rules.length;
        if (length <= 0) {
            return this.nonNumericalRules[3];
        }
        while (i < length) {
            int i2 = (i + length) >>> 1;
            long baseValue = this.rules[i2].getBaseValue();
            if (baseValue == j) {
                return this.rules[i2];
            }
            if (baseValue > j) {
                length = i2;
            } else {
                i = i2 + 1;
            }
        }
        if (length == 0) {
            throw new IllegalStateException("The rule set " + this.name + " cannot format the value " + j);
        }
        NFRule nFRule = this.rules[length - 1];
        if (!nFRule.shouldRollBack(j)) {
            return nFRule;
        }
        if (length != 1) {
            return this.rules[length - 2];
        }
        throw new IllegalStateException("The rule set " + this.name + " cannot roll back from the rule '" + nFRule + "'");
    }

    private NFRule findFractionRuleSetRule(double d) {
        long baseValue = this.rules[0].getBaseValue();
        for (int i = 1; i < this.rules.length; i++) {
            baseValue = lcm(baseValue, this.rules[i].getBaseValue());
        }
        long round = Math.round(((double) baseValue) * d);
        long j = Long.MAX_VALUE;
        int i2 = 0;
        for (int i3 = 0; i3 < this.rules.length; i3++) {
            long baseValue2 = (this.rules[i3].getBaseValue() * round) % baseValue;
            if (baseValue - baseValue2 < baseValue2) {
                baseValue2 = baseValue - baseValue2;
            }
            if (baseValue2 < j) {
                j = baseValue2;
                i2 = i3;
                if (j == 0) {
                    break;
                }
            }
        }
        if (i2 + 1 < this.rules.length && this.rules[i2 + 1].getBaseValue() == this.rules[i2].getBaseValue() && (Math.round(((double) this.rules[i2].getBaseValue()) * d) < 1 || Math.round(((double) this.rules[i2].getBaseValue()) * d) >= 2)) {
            i2++;
        }
        return this.rules[i2];
    }

    private static long lcm(long j, long j2) {
        long j3;
        long j4 = j;
        long j5 = j2;
        int i = 0;
        while ((1 & j4) == 0 && (1 & j5) == 0) {
            i++;
            j4 >>= 1;
            j5 >>= 1;
        }
        if ((1 & j4) == 1) {
            j3 = -j5;
        } else {
            j3 = j4;
        }
        while (j3 != 0) {
            while ((1 & j3) == 0) {
                j3 >>= 1;
            }
            if (j3 > 0) {
                j4 = j3;
            } else {
                j5 = -j3;
            }
            j3 = j4 - j5;
        }
        return (j / (j4 << i)) * j2;
    }

    public Number parse(String str, ParsePosition parsePosition, double d) {
        ParsePosition parsePosition2 = new ParsePosition(0);
        Long l = NFRule.ZERO;
        if (str.length() == 0) {
            return l;
        }
        NFRule[] nFRuleArr = this.nonNumericalRules;
        for (NFRule nFRule : nFRuleArr) {
            if (nFRule != null) {
                Number doParse = nFRule.doParse(str, parsePosition, false, d);
                if (parsePosition.getIndex() > parsePosition2.getIndex()) {
                    l = doParse;
                    parsePosition2.setIndex(parsePosition.getIndex());
                }
                parsePosition.setIndex(0);
            }
        }
        for (int length = this.rules.length - 1; length >= 0 && parsePosition2.getIndex() < str.length(); length--) {
            if (this.isFractionRuleSet || ((double) this.rules[length].getBaseValue()) < d) {
                Number doParse2 = this.rules[length].doParse(str, parsePosition, this.isFractionRuleSet, d);
                if (parsePosition.getIndex() > parsePosition2.getIndex()) {
                    l = doParse2;
                    parsePosition2.setIndex(parsePosition.getIndex());
                }
                parsePosition.setIndex(0);
            }
        }
        parsePosition.setIndex(parsePosition2.getIndex());
        return l;
    }
}
