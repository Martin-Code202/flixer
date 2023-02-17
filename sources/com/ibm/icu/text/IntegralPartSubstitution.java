package com.ibm.icu.text;
/* access modifiers changed from: package-private */
public class IntegralPartSubstitution extends NFSubstitution {
    IntegralPartSubstitution(int i, NFRuleSet nFRuleSet, String str) {
        super(i, nFRuleSet, str);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long j) {
        return j;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double d) {
        return Math.floor(d);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double d, double d2) {
        return d + d2;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double d) {
        return Double.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return '<';
    }
}
