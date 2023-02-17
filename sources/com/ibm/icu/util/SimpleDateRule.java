package com.ibm.icu.util;
public class SimpleDateRule implements DateRule {
    private Calendar calendar = new GregorianCalendar();
    private int dayOfMonth;
    private int dayOfWeek;
    private int month;

    public SimpleDateRule(int i, int i2) {
        this.month = i;
        this.dayOfMonth = i2;
        this.dayOfWeek = 0;
    }

    SimpleDateRule(int i, int i2, Calendar calendar2) {
        this.month = i;
        this.dayOfMonth = i2;
        this.dayOfWeek = 0;
        this.calendar = calendar2;
    }

    public SimpleDateRule(int i, int i2, int i3, boolean z) {
        this.month = i;
        this.dayOfMonth = i2;
        this.dayOfWeek = z ? i3 : -i3;
    }
}
