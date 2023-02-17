package com.ibm.icu.text;

import com.ibm.icu.util.CurrencyAmount;
import java.text.ParsePosition;
public class CompactDecimalFormat extends DecimalFormat {
    private static final long serialVersionUID = 4716293295276629682L;

    public enum CompactStyle {
        SHORT,
        LONG
    }

    @Override // com.ibm.icu.text.DecimalFormat, com.ibm.icu.text.NumberFormat
    public Number parse(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    @Override // com.ibm.icu.text.DecimalFormat, com.ibm.icu.text.NumberFormat
    public CurrencyAmount parseCurrency(CharSequence charSequence, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }
}
