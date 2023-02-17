package com.ibm.icu.text;
/* access modifiers changed from: package-private */
public class AbsoluteValueSubstitution extends NFSubstitution {
    AbsoluteValueSubstitution(int i, NFRuleSet nFRuleSet, String str) {
        super(i, nFRuleSet, str);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long j) {
        return Math.abs(j);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double d) {
        return Math.abs(d);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double d, double d2) {
        return -d;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double d) {
        return Double.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return '>';
    }
}
