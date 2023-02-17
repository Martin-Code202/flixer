package com.ibm.icu.text;

import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.text.PluralRules;
import java.text.FieldPosition;
/* access modifiers changed from: package-private */
public class QuantityFormatter {
    static final /* synthetic */ boolean $assertionsDisabled = (!QuantityFormatter.class.desiredAssertionStatus());
    private final SimpleFormatter[] templates = new SimpleFormatter[StandardPlural.COUNT];

    public static StandardPlural selectPlural(Number number, NumberFormat numberFormat, PluralRules pluralRules, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        UFieldPosition uFieldPosition = new UFieldPosition(fieldPosition.getFieldAttribute(), fieldPosition.getField());
        numberFormat.format(number, stringBuffer, uFieldPosition);
        String select = pluralRules.select(new PluralRules.FixedDecimal(number.doubleValue(), uFieldPosition.getCountVisibleFractionDigits(), uFieldPosition.getFractionDigits()));
        fieldPosition.setBeginIndex(uFieldPosition.getBeginIndex());
        fieldPosition.setEndIndex(uFieldPosition.getEndIndex());
        return StandardPlural.orOtherFromString(select);
    }

    public static StringBuilder format(String str, CharSequence charSequence, StringBuilder sb, FieldPosition fieldPosition) {
        int[] iArr = new int[1];
        SimpleFormatterImpl.formatAndAppend(str, sb, iArr, charSequence);
        if (!(fieldPosition.getBeginIndex() == 0 && fieldPosition.getEndIndex() == 0)) {
            if (iArr[0] >= 0) {
                fieldPosition.setBeginIndex(fieldPosition.getBeginIndex() + iArr[0]);
                fieldPosition.setEndIndex(fieldPosition.getEndIndex() + iArr[0]);
            } else {
                fieldPosition.setBeginIndex(0);
                fieldPosition.setEndIndex(0);
            }
        }
        return sb;
    }
}
