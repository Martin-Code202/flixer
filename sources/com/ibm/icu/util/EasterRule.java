package com.ibm.icu.util;

import java.util.Date;
/* access modifiers changed from: package-private */
public class EasterRule implements DateRule {
    private static GregorianCalendar gregorian = new GregorianCalendar();
    private static GregorianCalendar orthodox = new GregorianCalendar();
    private GregorianCalendar calendar = gregorian;
    private int daysAfterEaster;

    public EasterRule(int i, boolean z) {
        this.daysAfterEaster = i;
        if (z) {
            orthodox.setGregorianChange(new Date(Long.MAX_VALUE));
            this.calendar = orthodox;
        }
    }
}
