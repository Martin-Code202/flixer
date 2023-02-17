package com.ibm.icu.text;
/* access modifiers changed from: package-private */
public class SameValueSubstitution extends NFSubstitution {
    SameValueSubstitution(int i, NFRuleSet nFRuleSet, String str) {
        super(i, nFRuleSet, str);
        if (str.equals("==")) {
            throw new IllegalArgumentException("== is not a legal token");
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long j) {
        return j;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double d) {
        return d;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double d, double d2) {
        return d;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double d) {
        return d;
    }

    /* access modifiers changed from: package-private */
    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return '=';
    }
}
