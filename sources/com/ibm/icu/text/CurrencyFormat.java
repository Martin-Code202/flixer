package com.ibm.icu.text;

import com.ibm.icu.text.MeasureFormat;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.Measure;
import com.ibm.icu.util.ULocale;
import java.text.FieldPosition;
import java.text.ParsePosition;
class CurrencyFormat extends MeasureFormat {
    static final long serialVersionUID = -931679363692504634L;
    private NumberFormat fmt;
    private final transient MeasureFormat mf;

    public CurrencyFormat(ULocale uLocale) {
        setLocale(uLocale, uLocale);
        this.mf = MeasureFormat.getInstance(uLocale, MeasureFormat.FormatWidth.WIDE);
        this.fmt = NumberFormat.getCurrencyInstance(uLocale.toLocale());
    }

    @Override // java.text.Format, java.lang.Object
    public Object clone() {
        CurrencyFormat currencyFormat = (CurrencyFormat) super.clone();
        currencyFormat.fmt = (NumberFormat) this.fmt.clone();
        return currencyFormat;
    }

    @Override // com.ibm.icu.text.MeasureFormat, java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (!(obj instanceof CurrencyAmount)) {
            throw new IllegalArgumentException("Invalid type: " + obj.getClass().getName());
        }
        CurrencyAmount currencyAmount = (CurrencyAmount) obj;
        this.fmt.setCurrency(currencyAmount.getCurrency());
        return this.fmt.format(currencyAmount.getNumber(), stringBuffer, fieldPosition);
    }

    @Override // com.ibm.icu.text.MeasureFormat, java.text.Format
    public CurrencyAmount parseObject(String str, ParsePosition parsePosition) {
        return this.fmt.parseCurrency(str, parsePosition);
    }

    @Override // com.ibm.icu.text.MeasureFormat
    public StringBuilder formatMeasures(StringBuilder sb, FieldPosition fieldPosition, Measure... measureArr) {
        return this.mf.formatMeasures(sb, fieldPosition, measureArr);
    }

    @Override // com.ibm.icu.text.MeasureFormat
    public MeasureFormat.FormatWidth getWidth() {
        return this.mf.getWidth();
    }

    @Override // com.ibm.icu.text.MeasureFormat
    public NumberFormat getNumberFormat() {
        return this.mf.getNumberFormat();
    }

    private Object writeReplace() {
        return this.mf.toCurrencyProxy();
    }

    private Object readResolve() {
        return new CurrencyFormat(this.fmt.getLocale(ULocale.ACTUAL_LOCALE));
    }
}
