package com.ibm.icu.util;

import com.ibm.icu.impl.Grego;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class RuleBasedTimeZone extends BasicTimeZone {
    private static final long serialVersionUID = 7580833058949327935L;
    private AnnualTimeZoneRule[] finalRules;
    private List<TimeZoneRule> historicRules;
    private transient List<TimeZoneTransition> historicTransitions;
    private final InitialTimeZoneRule initialRule;
    private volatile transient boolean isFrozen = false;
    private transient boolean upToDate;

    public RuleBasedTimeZone(String str, InitialTimeZoneRule initialTimeZoneRule) {
        super(str);
        this.initialRule = initialTimeZoneRule;
    }

    public void addTransitionRule(TimeZoneRule timeZoneRule) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen RuleBasedTimeZone instance.");
        } else if (!timeZoneRule.isTransitionRule()) {
            throw new IllegalArgumentException("Rule must be a transition rule");
        } else {
            if (!(timeZoneRule instanceof AnnualTimeZoneRule) || ((AnnualTimeZoneRule) timeZoneRule).getEndYear() != Integer.MAX_VALUE) {
                if (this.historicRules == null) {
                    this.historicRules = new ArrayList();
                }
                this.historicRules.add(timeZoneRule);
            } else if (this.finalRules == null) {
                this.finalRules = new AnnualTimeZoneRule[2];
                this.finalRules[0] = (AnnualTimeZoneRule) timeZoneRule;
            } else if (this.finalRules[1] == null) {
                this.finalRules[1] = (AnnualTimeZoneRule) timeZoneRule;
            } else {
                throw new IllegalStateException("Too many final rules");
            }
            this.upToDate = false;
        }
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i == 0) {
            i2 = 1 - i2;
        }
        int[] iArr = new int[2];
        getOffset((Grego.fieldsToDay(i2, i3, i4) * 86400000) + ((long) i6), true, 3, 1, iArr);
        return iArr[0] + iArr[1];
    }

    @Override // com.ibm.icu.util.TimeZone
    public void getOffset(long j, boolean z, int[] iArr) {
        getOffset(j, z, 4, 12, iArr);
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    @Deprecated
    public void getOffsetFromLocal(long j, int i, int i2, int[] iArr) {
        getOffset(j, true, i, i2, iArr);
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getRawOffset() {
        int[] iArr = new int[2];
        getOffset(System.currentTimeMillis(), false, iArr);
        return iArr[0];
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean inDaylightTime(Date date) {
        int[] iArr = new int[2];
        getOffset(date.getTime(), false, iArr);
        return iArr[1] != 0;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean useDaylightTime() {
        long currentTimeMillis = System.currentTimeMillis();
        int[] iArr = new int[2];
        getOffset(currentTimeMillis, false, iArr);
        if (iArr[1] != 0) {
            return true;
        }
        TimeZoneTransition nextTransition = getNextTransition(currentTimeMillis, false);
        if (nextTransition == null || nextTransition.getTo().getDSTSavings() == 0) {
            return false;
        }
        return true;
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getNextTransition(long j, boolean z) {
        TimeZoneTransition timeZoneTransition;
        TimeZoneTransition timeZoneTransition2;
        complete();
        if (this.historicTransitions == null) {
            return null;
        }
        boolean z2 = false;
        TimeZoneTransition timeZoneTransition3 = this.historicTransitions.get(0);
        long time = timeZoneTransition3.getTime();
        if (time > j || (z && time == j)) {
            timeZoneTransition = timeZoneTransition3;
        } else {
            int size = this.historicTransitions.size() - 1;
            TimeZoneTransition timeZoneTransition4 = this.historicTransitions.get(size);
            long time2 = timeZoneTransition4.getTime();
            if (z && time2 == j) {
                timeZoneTransition = timeZoneTransition4;
            } else if (time2 > j) {
                int i = size - 1;
                TimeZoneTransition timeZoneTransition5 = timeZoneTransition4;
                while (i > 0) {
                    TimeZoneTransition timeZoneTransition6 = this.historicTransitions.get(i);
                    long time3 = timeZoneTransition6.getTime();
                    if (time3 < j || (!z && time3 == j)) {
                        break;
                    }
                    i--;
                    timeZoneTransition5 = timeZoneTransition6;
                }
                timeZoneTransition = timeZoneTransition5;
            } else if (this.finalRules == null) {
                return null;
            } else {
                Date nextStart = this.finalRules[0].getNextStart(j, this.finalRules[1].getRawOffset(), this.finalRules[1].getDSTSavings(), z);
                Date nextStart2 = this.finalRules[1].getNextStart(j, this.finalRules[0].getRawOffset(), this.finalRules[0].getDSTSavings(), z);
                if (nextStart2.after(nextStart)) {
                    timeZoneTransition2 = new TimeZoneTransition(nextStart.getTime(), this.finalRules[1], this.finalRules[0]);
                } else {
                    timeZoneTransition2 = new TimeZoneTransition(nextStart2.getTime(), this.finalRules[0], this.finalRules[1]);
                }
                timeZoneTransition = timeZoneTransition2;
                z2 = true;
            }
        }
        TimeZoneRule from = timeZoneTransition.getFrom();
        TimeZoneRule to = timeZoneTransition.getTo();
        if (from.getRawOffset() != to.getRawOffset() || from.getDSTSavings() != to.getDSTSavings()) {
            return timeZoneTransition;
        }
        if (z2) {
            return null;
        }
        return getNextTransition(timeZoneTransition.getTime(), false);
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getPreviousTransition(long j, boolean z) {
        TimeZoneTransition timeZoneTransition;
        complete();
        if (this.historicTransitions == null) {
            return null;
        }
        TimeZoneTransition timeZoneTransition2 = this.historicTransitions.get(0);
        long time = timeZoneTransition2.getTime();
        if (z && time == j) {
            timeZoneTransition = timeZoneTransition2;
        } else if (time >= j) {
            return null;
        } else {
            int size = this.historicTransitions.size() - 1;
            TimeZoneTransition timeZoneTransition3 = this.historicTransitions.get(size);
            long time2 = timeZoneTransition3.getTime();
            if (z && time2 == j) {
                timeZoneTransition = timeZoneTransition3;
            } else if (time2 < j) {
                if (this.finalRules != null) {
                    Date previousStart = this.finalRules[0].getPreviousStart(j, this.finalRules[1].getRawOffset(), this.finalRules[1].getDSTSavings(), z);
                    Date previousStart2 = this.finalRules[1].getPreviousStart(j, this.finalRules[0].getRawOffset(), this.finalRules[0].getDSTSavings(), z);
                    if (previousStart2.before(previousStart)) {
                        timeZoneTransition3 = new TimeZoneTransition(previousStart.getTime(), this.finalRules[1], this.finalRules[0]);
                    } else {
                        timeZoneTransition3 = new TimeZoneTransition(previousStart2.getTime(), this.finalRules[0], this.finalRules[1]);
                    }
                }
                timeZoneTransition = timeZoneTransition3;
            } else {
                for (int i = size - 1; i >= 0; i--) {
                    timeZoneTransition3 = this.historicTransitions.get(i);
                    long time3 = timeZoneTransition3.getTime();
                    if (time3 < j || (z && time3 == j)) {
                        break;
                    }
                }
                timeZoneTransition = timeZoneTransition3;
            }
        }
        TimeZoneRule from = timeZoneTransition.getFrom();
        TimeZoneRule to = timeZoneTransition.getTo();
        if (from.getRawOffset() == to.getRawOffset() && from.getDSTSavings() == to.getDSTSavings()) {
            return getPreviousTransition(timeZoneTransition.getTime(), false);
        }
        return timeZoneTransition;
    }

    @Override // com.ibm.icu.util.TimeZone, java.lang.Object
    public Object clone() {
        if (isFrozen()) {
            return this;
        }
        return cloneAsThawed();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:91:0x011c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r0v58, types: [com.ibm.icu.util.AnnualTimeZoneRule[]] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r20v4, types: [com.ibm.icu.util.TimeZoneRule] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void complete() {
        /*
        // Method dump skipped, instructions count: 579
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.util.RuleBasedTimeZone.complete():void");
    }

    private void getOffset(long j, boolean z, int i, int i2, int[] iArr) {
        complete();
        TimeZoneRule timeZoneRule = null;
        if (this.historicTransitions == null) {
            timeZoneRule = this.initialRule;
        } else if (j < getTransitionTime(this.historicTransitions.get(0), z, i, i2)) {
            timeZoneRule = this.initialRule;
        } else {
            int size = this.historicTransitions.size() - 1;
            if (j > getTransitionTime(this.historicTransitions.get(size), z, i, i2)) {
                if (this.finalRules != null) {
                    timeZoneRule = findRuleInFinal(j, z, i, i2);
                }
                if (timeZoneRule == null) {
                    timeZoneRule = this.historicTransitions.get(size).getTo();
                }
            } else {
                while (size >= 0 && j < getTransitionTime(this.historicTransitions.get(size), z, i, i2)) {
                    size--;
                }
                timeZoneRule = this.historicTransitions.get(size).getTo();
            }
        }
        iArr[0] = timeZoneRule.getRawOffset();
        iArr[1] = timeZoneRule.getDSTSavings();
    }

    private TimeZoneRule findRuleInFinal(long j, boolean z, int i, int i2) {
        if (this.finalRules == null || this.finalRules.length != 2 || this.finalRules[0] == null || this.finalRules[1] == null) {
            return null;
        }
        long j2 = j;
        if (z) {
            j2 -= (long) getLocalDelta(this.finalRules[1].getRawOffset(), this.finalRules[1].getDSTSavings(), this.finalRules[0].getRawOffset(), this.finalRules[0].getDSTSavings(), i, i2);
        }
        Date previousStart = this.finalRules[0].getPreviousStart(j2, this.finalRules[1].getRawOffset(), this.finalRules[1].getDSTSavings(), true);
        long j3 = j;
        if (z) {
            j3 -= (long) getLocalDelta(this.finalRules[0].getRawOffset(), this.finalRules[0].getDSTSavings(), this.finalRules[1].getRawOffset(), this.finalRules[1].getDSTSavings(), i, i2);
        }
        Date previousStart2 = this.finalRules[1].getPreviousStart(j3, this.finalRules[0].getRawOffset(), this.finalRules[0].getDSTSavings(), true);
        if (previousStart != null && previousStart2 != null) {
            return previousStart.after(previousStart2) ? this.finalRules[0] : this.finalRules[1];
        }
        if (previousStart != null) {
            return this.finalRules[0];
        }
        if (previousStart2 != null) {
            return this.finalRules[1];
        }
        return null;
    }

    private static long getTransitionTime(TimeZoneTransition timeZoneTransition, boolean z, int i, int i2) {
        long time = timeZoneTransition.getTime();
        if (z) {
            return time + ((long) getLocalDelta(timeZoneTransition.getFrom().getRawOffset(), timeZoneTransition.getFrom().getDSTSavings(), timeZoneTransition.getTo().getRawOffset(), timeZoneTransition.getTo().getDSTSavings(), i, i2));
        }
        return time;
    }

    private static int getLocalDelta(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i + i2;
        int i8 = i3 + i4;
        boolean z = i2 != 0 && i4 == 0;
        boolean z2 = i2 == 0 && i4 != 0;
        if (i8 - i7 >= 0) {
            if (((i5 & 3) == 1 && z) || ((i5 & 3) == 3 && z2)) {
                return i7;
            }
            if (((i5 & 3) != 1 || !z2) && ((i5 & 3) != 3 || !z)) {
                return (i5 & 12) == 12 ? i7 : i8;
            }
            return i8;
        } else if (((i6 & 3) == 1 && z) || ((i6 & 3) == 3 && z2)) {
            return i8;
        } else {
            if (((i6 & 3) != 1 || !z2) && ((i6 & 3) != 3 || !z)) {
                return (i6 & 12) == 4 ? i7 : i8;
            }
            return i7;
        }
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean isFrozen() {
        return this.isFrozen;
    }

    @Override // com.ibm.icu.util.TimeZone
    public TimeZone freeze() {
        complete();
        this.isFrozen = true;
        return this;
    }

    @Override // com.ibm.icu.util.TimeZone
    public TimeZone cloneAsThawed() {
        RuleBasedTimeZone ruleBasedTimeZone = (RuleBasedTimeZone) super.cloneAsThawed();
        if (this.historicRules != null) {
            ruleBasedTimeZone.historicRules = new ArrayList(this.historicRules);
        }
        if (this.finalRules != null) {
            ruleBasedTimeZone.finalRules = (AnnualTimeZoneRule[]) this.finalRules.clone();
        }
        ruleBasedTimeZone.isFrozen = false;
        return ruleBasedTimeZone;
    }
}
