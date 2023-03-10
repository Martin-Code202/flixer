package com.ibm.icu.util;

import com.ibm.icu.impl.Grego;
import java.util.Date;
public class AnnualTimeZoneRule extends TimeZoneRule {
    private static final long serialVersionUID = -8870666707791230688L;
    private final DateTimeRule dateTimeRule;
    private final int endYear;
    private final int startYear;

    public AnnualTimeZoneRule(String str, int i, int i2, DateTimeRule dateTimeRule2, int i3, int i4) {
        super(str, i, i2);
        this.dateTimeRule = dateTimeRule2;
        this.startYear = i3;
        this.endYear = i4;
    }

    public int getEndYear() {
        return this.endYear;
    }

    public Date getStartInYear(int i, int i2, int i3) {
        long j;
        long j2;
        int i4;
        if (i < this.startYear || i > this.endYear) {
            return null;
        }
        int dateRuleType = this.dateTimeRule.getDateRuleType();
        if (dateRuleType == 0) {
            j = Grego.fieldsToDay(i, this.dateTimeRule.getRuleMonth(), this.dateTimeRule.getRuleDayOfMonth());
        } else {
            boolean z = true;
            if (dateRuleType == 1) {
                int ruleWeekInMonth = this.dateTimeRule.getRuleWeekInMonth();
                if (ruleWeekInMonth > 0) {
                    j2 = Grego.fieldsToDay(i, this.dateTimeRule.getRuleMonth(), 1) + ((long) ((ruleWeekInMonth - 1) * 7));
                } else {
                    z = false;
                    j2 = Grego.fieldsToDay(i, this.dateTimeRule.getRuleMonth(), Grego.monthLength(i, this.dateTimeRule.getRuleMonth())) + ((long) ((ruleWeekInMonth + 1) * 7));
                }
            } else {
                int ruleMonth = this.dateTimeRule.getRuleMonth();
                int ruleDayOfMonth = this.dateTimeRule.getRuleDayOfMonth();
                if (dateRuleType == 3) {
                    z = false;
                    if (ruleMonth == 1 && ruleDayOfMonth == 29 && !Grego.isLeapYear(i)) {
                        ruleDayOfMonth--;
                    }
                }
                j2 = Grego.fieldsToDay(i, ruleMonth, ruleDayOfMonth);
            }
            int ruleDayOfWeek = this.dateTimeRule.getRuleDayOfWeek() - Grego.dayOfWeek(j2);
            if (z) {
                i4 = ruleDayOfWeek < 0 ? ruleDayOfWeek + 7 : ruleDayOfWeek;
            } else {
                i4 = ruleDayOfWeek > 0 ? ruleDayOfWeek - 7 : ruleDayOfWeek;
            }
            j = j2 + ((long) i4);
        }
        long ruleMillisInDay = (86400000 * j) + ((long) this.dateTimeRule.getRuleMillisInDay());
        if (this.dateTimeRule.getTimeRuleType() != 2) {
            ruleMillisInDay -= (long) i2;
        }
        if (this.dateTimeRule.getTimeRuleType() == 0) {
            ruleMillisInDay -= (long) i3;
        }
        return new Date(ruleMillisInDay);
    }

    public Date getFirstStart(int i, int i2) {
        return getStartInYear(this.startYear, i, i2);
    }

    public Date getFinalStart(int i, int i2) {
        if (this.endYear == Integer.MAX_VALUE) {
            return null;
        }
        return getStartInYear(this.endYear, i, i2);
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public Date getNextStart(long j, int i, int i2, boolean z) {
        int i3 = Grego.timeToFields(j, null)[0];
        if (i3 < this.startYear) {
            return getFirstStart(i, i2);
        }
        Date startInYear = getStartInYear(i3, i, i2);
        if (startInYear == null) {
            return startInYear;
        }
        if (startInYear.getTime() < j || (!z && startInYear.getTime() == j)) {
            return getStartInYear(i3 + 1, i, i2);
        }
        return startInYear;
    }

    public Date getPreviousStart(long j, int i, int i2, boolean z) {
        int i3 = Grego.timeToFields(j, null)[0];
        if (i3 > this.endYear) {
            return getFinalStart(i, i2);
        }
        Date startInYear = getStartInYear(i3, i, i2);
        if (startInYear == null) {
            return startInYear;
        }
        if (startInYear.getTime() > j || (!z && startInYear.getTime() == j)) {
            return getStartInYear(i3 - 1, i, i2);
        }
        return startInYear;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public boolean isTransitionRule() {
        return true;
    }

    @Override // com.ibm.icu.util.TimeZoneRule, java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", rule={" + this.dateTimeRule + "}");
        sb.append(", startYear=" + this.startYear);
        sb.append(", endYear=");
        if (this.endYear == Integer.MAX_VALUE) {
            sb.append("max");
        } else {
            sb.append(this.endYear);
        }
        return sb.toString();
    }
}
