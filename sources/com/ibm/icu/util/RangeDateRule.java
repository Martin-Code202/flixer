package com.ibm.icu.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class RangeDateRule implements DateRule {
    List<Range> ranges = new ArrayList(2);

    public void add(DateRule dateRule) {
        add(new Date(Long.MIN_VALUE), dateRule);
    }

    public void add(Date date, DateRule dateRule) {
        this.ranges.add(new Range(date, dateRule));
    }
}
