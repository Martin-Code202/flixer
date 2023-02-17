package com.ibm.icu.text;

import com.ibm.icu.impl.number.FormatQuantity4;
import java.text.ParsePosition;
/* access modifiers changed from: package-private */
public class FractionalPartSubstitution extends NFSubstitution {
    private final boolean byDigits;
    private final boolean useSpaces;

    FractionalPartSubstitution(int i, NFRuleSet nFRuleSet, String str) {
        super(i, nFRuleSet, str);
        if (str.equals(">>") || str.equals(">>>") || nFRuleSet == this.ruleSet) {
            this.byDigits = true;
            this.useSpaces = !str.equals(">>>");
            return;
        }
        this.byDigits = false;
        this.useSpaces = true;
        this.ruleSet.makeIntoFractionRuleSet();
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public void doSubstitution(double d, StringBuilder sb, int i, int i2) {
        if (!this.byDigits) {
            super.doSubstitution(d, sb, i, i2);
            return;
        }
        FormatQuantity4 formatQuantity4 = new FormatQuantity4(d);
        formatQuantity4.roundToInfinity();
        boolean z = false;
        int lowerDisplayMagnitude = formatQuantity4.getLowerDisplayMagnitude();
        while (lowerDisplayMagnitude < 0) {
            if (!z || !this.useSpaces) {
                z = true;
            } else {
                sb.insert(this.pos + i, ' ');
            }
            lowerDisplayMagnitude++;
            this.ruleSet.format((long) formatQuantity4.getDigit(lowerDisplayMagnitude), sb, this.pos + i, i2);
        }
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public long transformNumber(long j) {
        return 0;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double transformNumber(double d) {
        return d - Math.floor(d);
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public Number doParse(String str, ParsePosition parsePosition, double d, double d2, boolean z) {
        Number parse;
        if (!this.byDigits) {
            return super.doParse(str, parsePosition, d, 0.0d, z);
        }
        String str2 = str;
        ParsePosition parsePosition2 = new ParsePosition(1);
        FormatQuantity4 formatQuantity4 = new FormatQuantity4();
        int i = 0;
        while (str2.length() > 0 && parsePosition2.getIndex() != 0) {
            parsePosition2.setIndex(0);
            int intValue = this.ruleSet.parse(str2, parsePosition2, 10.0d).intValue();
            if (z && parsePosition2.getIndex() == 0 && (parse = this.ruleSet.owner.getDecimalFormat().parse(str2, parsePosition2)) != null) {
                intValue = parse.intValue();
            }
            if (parsePosition2.getIndex() != 0) {
                if (intValue == 0) {
                    i++;
                } else {
                    formatQuantity4.appendDigit((byte) intValue, i, false);
                    i = 0;
                }
                parsePosition.setIndex(parsePosition.getIndex() + parsePosition2.getIndex());
                str2 = str2.substring(parsePosition2.getIndex());
                while (str2.length() > 0 && str2.charAt(0) == ' ') {
                    str2 = str2.substring(1);
                    parsePosition.setIndex(parsePosition.getIndex() + 1);
                }
            }
        }
        return new Double(composeRuleValue(formatQuantity4.toDouble(), d));
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double composeRuleValue(double d, double d2) {
        return d + d2;
    }

    @Override // com.ibm.icu.text.NFSubstitution
    public double calcUpperBound(double d) {
        return 0.0d;
    }

    /* access modifiers changed from: package-private */
    @Override // com.ibm.icu.text.NFSubstitution
    public char tokenChar() {
        return '>';
    }
}
