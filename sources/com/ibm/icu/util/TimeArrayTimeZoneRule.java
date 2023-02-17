package com.ibm.icu.util;

import java.util.Arrays;
import java.util.Date;
public class TimeArrayTimeZoneRule extends TimeZoneRule {
    private static final long serialVersionUID = -1117109130077415245L;
    private final long[] startTimes;
    private final int timeType;

    public TimeArrayTimeZoneRule(String str, int i, int i2, long[] jArr, int i3) {
        super(str, i, i2);
        if (jArr == null || jArr.length == 0) {
            throw new IllegalArgumentException("No start times are specified.");
        }
        this.startTimes = (long[]) jArr.clone();
        Arrays.sort(this.startTimes);
        this.timeType = i3;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public Date getNextStart(long j, int i, int i2, boolean z) {
        int length = this.startTimes.length - 1;
        while (length >= 0) {
            long utc = getUTC(this.startTimes[length], i, i2);
            if (utc < j || (!z && utc == j)) {
                break;
            }
            length--;
        }
        if (length == this.startTimes.length - 1) {
            return null;
        }
        return new Date(getUTC(this.startTimes[length + 1], i, i2));
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public boolean isTransitionRule() {
        return true;
    }

    private long getUTC(long j, int i, int i2) {
        if (this.timeType != 2) {
            j -= (long) i;
        }
        if (this.timeType == 0) {
            return j - ((long) i2);
        }
        return j;
    }

    @Override // com.ibm.icu.util.TimeZoneRule, java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", timeType=");
        sb.append(this.timeType);
        sb.append(", startTimes=[");
        for (int i = 0; i < this.startTimes.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(Long.toString(this.startTimes[i]));
        }
        sb.append("]");
        return sb.toString();
    }
}
