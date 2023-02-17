package com.ibm.icu.text;

import java.text.ParsePosition;
/* access modifiers changed from: package-private */
public class NumeratorSubstitution extends NFSubstitution {
    private final double denominator;
    private final boolean withZeros;

    NumeratorSubstitution(int i, double d, NFRuleSet nFRuleSet, String str) {
        super(i, nFRuleSet, fixdesc(str));
        this.denominator = d;
        this.withZeros = str.endsWith("<<");
    }

    static String fixdesc(String str) {
        if (str.endsWith("<<")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        NumeratorSubstitution numeratorSubstitution = (NumeratorSubstitution) obj;
        return this.denominator == numeratorSubstitution.denominator && this.withZeros == numeratorSubstitution.withZeros;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public void doSubstitution(double d, StringBuilder sb, int i, int i2) {
        double transformNumber = transformNumber(d);
        if (this.withZeros && this.ruleSet != null) {
            long j = (long) transformNumber;
            int length = sb.length();
            while (true) {
                long j2 = 10 * j;
                j = j2;
                if (((double) j2) >= this.denominator) {
                    break;
                }
                sb.insert(this.pos + i, ' ');
                this.ruleSet.format(0L, sb, i + this.pos, i2);
            }
            i += sb.length() - length;
        }
        if (transformNumber == Math.floor(transformNumber) && this.ruleSet != null) {
            this.ruleSet.format((long) transformNumber, sb, this.pos + i, i2);
        } else if (this.ruleSet != null) {
            this.ruleSet.format(transformNumber, sb, this.pos + i, i2);
        } else {
            sb.insert(this.pos + i, this.numberFormat.format(transformNumber));
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long j) {
        return Math.round(((double) j) * this.denominator);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double d) {
        return (double) Math.round(this.denominator * d);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public Number doParse(String str, ParsePosition parsePosition, double d, double d2, boolean z) {
        int i = 0;
        if (this.withZeros) {
            String str2 = str;
            ParsePosition parsePosition2 = new ParsePosition(1);
            while (str2.length() > 0 && parsePosition2.getIndex() != 0) {
                parsePosition2.setIndex(0);
                this.ruleSet.parse(str2, parsePosition2, 1.0d).intValue();
                if (parsePosition2.getIndex() == 0) {
                    break;
                }
                i++;
                parsePosition.setIndex(parsePosition.getIndex() + parsePosition2.getIndex());
                str2 = str2.substring(parsePosition2.getIndex());
                while (str2.length() > 0 && str2.charAt(0) == ' ') {
                    str2 = str2.substring(1);
                    parsePosition.setIndex(parsePosition.getIndex() + 1);
                }
            }
            str = str.substring(parsePosition.getIndex());
            parsePosition.setIndex(0);
        }
        Number doParse = super.doParse(str, parsePosition, this.withZeros ? 1.0d : d, d2, false);
        if (!this.withZeros) {
            return doParse;
        }
        long longValue = doParse.longValue();
        long j = 1;
        while (j <= longValue) {
            j *= 10;
        }
        while (i > 0) {
            j *= 10;
            i--;
        }
        return new Double(((double) longValue) / ((double) j));
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double d, double d2) {
        return d / d2;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double d) {
        return this.denominator;
    }

    /* access modifiers changed from: package-private */
    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return '<';
    }
}
