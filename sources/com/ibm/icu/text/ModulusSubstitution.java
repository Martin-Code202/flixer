package com.ibm.icu.text;

import java.text.ParsePosition;
/* access modifiers changed from: package-private */
public class ModulusSubstitution extends NFSubstitution {
    long divisor;
    private final NFRule ruleToUse;

    ModulusSubstitution(int i, NFRule nFRule, NFRule nFRule2, NFRuleSet nFRuleSet, String str) {
        super(i, nFRuleSet, str);
        this.divisor = nFRule.getDivisor();
        if (this.divisor == 0) {
            throw new IllegalStateException("Substitution with bad divisor (" + this.divisor + ") " + str.substring(0, i) + " | " + str.substring(i));
        } else if (str.equals(">>>")) {
            this.ruleToUse = nFRule2;
        } else {
            this.ruleToUse = null;
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public void setDivisor(int i, short s) {
        this.divisor = NFRule.power((long) i, s);
        if (this.divisor == 0) {
            throw new IllegalStateException("Substitution with bad divisor");
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public boolean equals(Object obj) {
        return super.equals(obj) && this.divisor == ((ModulusSubstitution) obj).divisor;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public void doSubstitution(long j, StringBuilder sb, int i, int i2) {
        if (this.ruleToUse == null) {
            super.doSubstitution(j, sb, i, i2);
            return;
        }
        this.ruleToUse.doFormat(transformNumber(j), sb, this.pos + i, i2);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public void doSubstitution(double d, StringBuilder sb, int i, int i2) {
        if (this.ruleToUse == null) {
            super.doSubstitution(d, sb, i, i2);
            return;
        }
        this.ruleToUse.doFormat(transformNumber(d), sb, this.pos + i, i2);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long j) {
        return j % this.divisor;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double d) {
        return Math.floor(d % ((double) this.divisor));
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public Number doParse(String str, ParsePosition parsePosition, double d, double d2, boolean z) {
        if (this.ruleToUse == null) {
            return super.doParse(str, parsePosition, d, d2, z);
        }
        Number doParse = this.ruleToUse.doParse(str, parsePosition, false, d2);
        if (parsePosition.getIndex() == 0) {
            return doParse;
        }
        double composeRuleValue = composeRuleValue(doParse.doubleValue(), d);
        if (composeRuleValue == ((double) ((long) composeRuleValue))) {
            return Long.valueOf((long) composeRuleValue);
        }
        return new Double(composeRuleValue);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double d, double d2) {
        return (d2 - (d2 % ((double) this.divisor))) + d;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double d) {
        return (double) this.divisor;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public boolean isModulusSubstitution() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return '>';
    }
}
