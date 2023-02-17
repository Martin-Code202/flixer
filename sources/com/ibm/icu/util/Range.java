package com.ibm.icu.util;

import java.util.Date;
/* access modifiers changed from: package-private */
public class Range {
    public DateRule rule;
    public Date start;

    public Range(Date date, DateRule dateRule) {
        this.start = date;
        this.rule = dateRule;
    }
}
