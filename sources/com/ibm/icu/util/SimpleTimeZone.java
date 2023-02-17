package com.ibm.icu.util;

import com.ibm.icu.impl.Grego;
import java.io.ObjectInputStream;
import java.util.Date;
public class SimpleTimeZone extends BasicTimeZone {
    static final /* synthetic */ boolean $assertionsDisabled = (!SimpleTimeZone.class.desiredAssertionStatus());
    private static final long serialVersionUID = -7034676239311322769L;
    private static final byte[] staticMonthLength = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int dst = 3600000;
    private transient AnnualTimeZoneRule dstRule;
    private int endDay;
    private int endDayOfWeek;
    private int endMode;
    private int endMonth;
    private int endTime;
    private int endTimeMode;
    private transient TimeZoneTransition firstTransition;
    private transient InitialTimeZoneRule initialRule;
    private volatile transient boolean isFrozen = false;
    private int raw;
    private int startDay;
    private int startDayOfWeek;
    private int startMode;
    private int startMonth;
    private int startTime;
    private int startTimeMode;
    private int startYear;
    private transient AnnualTimeZoneRule stdRule;
    private transient boolean transitionRulesInitialized;
    private boolean useDaylight;
    private STZInfo xinfo = null;

    public SimpleTimeZone(int i, String str) {
        super(str);
        construct(i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3600000);
    }

    public SimpleTimeZone(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        super(str);
        construct(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12);
    }

    @Override // com.ibm.icu.util.TimeZone
    public void setID(String str) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen SimpleTimeZone instance.");
        }
        super.setID(str);
        this.transitionRulesInitialized = false;
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getRawOffset() {
        return this.raw;
    }

    public void setStartYear(int i) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen SimpleTimeZone instance.");
        }
        getSTZInfo().sy = i;
        this.startYear = i;
        this.transitionRulesInitialized = false;
    }

    public void setStartRule(int i, int i2, int i3, int i4) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen SimpleTimeZone instance.");
        }
        getSTZInfo().setStart(i, i2, i3, i4, -1, false);
        setStartRule(i, i2, i3, i4, 0);
    }

    private void setStartRule(int i, int i2, int i3, int i4, int i5) {
        if ($assertionsDisabled || !isFrozen()) {
            this.startMonth = i;
            this.startDay = i2;
            this.startDayOfWeek = i3;
            this.startTime = i4;
            this.startTimeMode = i5;
            decodeStartRule();
            this.transitionRulesInitialized = false;
            return;
        }
        throw new AssertionError();
    }

    public void setStartRule(int i, int i2, int i3) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen SimpleTimeZone instance.");
        }
        getSTZInfo().setStart(i, -1, -1, i3, i2, false);
        setStartRule(i, i2, 0, i3, 0);
    }

    public void setStartRule(int i, int i2, int i3, int i4, boolean z) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen SimpleTimeZone instance.");
        }
        getSTZInfo().setStart(i, -1, i3, i4, i2, z);
        setStartRule(i, z ? i2 : -i2, -i3, i4, 0);
    }

    public void setEndRule(int i, int i2, int i3, int i4) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen SimpleTimeZone instance.");
        }
        getSTZInfo().setEnd(i, i2, i3, i4, -1, false);
        setEndRule(i, i2, i3, i4, 0);
    }

    public void setEndRule(int i, int i2, int i3) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen SimpleTimeZone instance.");
        }
        getSTZInfo().setEnd(i, -1, -1, i3, i2, false);
        setEndRule(i, i2, 0, i3);
    }

    public void setEndRule(int i, int i2, int i3, int i4, boolean z) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen SimpleTimeZone instance.");
        }
        getSTZInfo().setEnd(i, -1, i3, i4, i2, z);
        setEndRule(i, i2, i3, i4, 0, z);
    }

    private void setEndRule(int i, int i2, int i3, int i4, int i5, boolean z) {
        if ($assertionsDisabled || !isFrozen()) {
            setEndRule(i, z ? i2 : -i2, -i3, i4, i5);
            return;
        }
        throw new AssertionError();
    }

    private void setEndRule(int i, int i2, int i3, int i4, int i5) {
        if ($assertionsDisabled || !isFrozen()) {
            this.endMonth = i;
            this.endDay = i2;
            this.endDayOfWeek = i3;
            this.endTime = i4;
            this.endTimeMode = i5;
            decodeEndRule();
            this.transitionRulesInitialized = false;
            return;
        }
        throw new AssertionError();
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getDSTSavings() {
        return this.dst;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.xinfo != null) {
            this.xinfo.applyTo(this);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return "SimpleTimeZone: " + getID();
    }

    private STZInfo getSTZInfo() {
        if (this.xinfo == null) {
            this.xinfo = new STZInfo();
        }
        return this.xinfo;
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 >= 0 && i3 <= 11) {
            return getOffset(i, i2, i3, i4, i5, i6, Grego.monthLength(i2, i3));
        }
        throw new IllegalArgumentException();
    }

    @Deprecated
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i3 >= 0 && i3 <= 11) {
            return getOffset(i, i2, i3, i4, i5, i6, Grego.monthLength(i2, i3), Grego.previousMonthLength(i2, i3));
        }
        throw new IllegalArgumentException();
    }

    private int getOffset(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if ((i == 1 || i == 0) && i3 >= 0 && i3 <= 11 && i4 >= 1 && i4 <= i7 && i5 >= 1 && i5 <= 7 && i6 >= 0 && i6 < 86400000 && i7 >= 28 && i7 <= 31 && i8 >= 28 && i8 <= 31) {
            int i9 = this.raw;
            if (!this.useDaylight || i2 < this.startYear || i != 1) {
                return i9;
            }
            boolean z = this.startMonth > this.endMonth;
            int compareToRule = compareToRule(i3, i7, i8, i4, i5, i6, this.startTimeMode == 2 ? -this.raw : 0, this.startMode, this.startMonth, this.startDayOfWeek, this.startDay, this.startTime);
            int i10 = 0;
            if (z != (compareToRule >= 0)) {
                i10 = compareToRule(i3, i7, i8, i4, i5, i6, this.endTimeMode == 0 ? this.dst : this.endTimeMode == 2 ? -this.raw : 0, this.endMode, this.endMonth, this.endDayOfWeek, this.endDay, this.endTime);
            }
            if (z || compareToRule < 0 || i10 >= 0) {
                if (!z) {
                    return i9;
                }
                if (compareToRule < 0 && i10 >= 0) {
                    return i9;
                }
            }
            return i9 + this.dst;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    @Deprecated
    public void getOffsetFromLocal(long j, int i, int i2, int[] iArr) {
        iArr[0] = getRawOffset();
        int[] iArr2 = new int[6];
        Grego.timeToFields(j, iArr2);
        iArr[1] = getOffset(1, iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[5]) - iArr[0];
        boolean z = false;
        if (iArr[1] > 0) {
            if ((i & 3) == 1 || !((i & 3) == 3 || (i & 12) == 12)) {
                j -= (long) getDSTSavings();
                z = true;
            }
        } else if ((i2 & 3) == 3 || ((i2 & 3) != 1 && (i2 & 12) == 4)) {
            j -= (long) getDSTSavings();
            z = true;
        }
        if (z) {
            Grego.timeToFields(j, iArr2);
            iArr[1] = getOffset(1, iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[5]) - iArr[0];
        }
    }

    private int compareToRule(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13 = i6 + i7;
        while (i13 >= 86400000) {
            i13 -= 86400000;
            i4++;
            i5 = (i5 % 7) + 1;
            if (i4 > i2) {
                i4 = 1;
                i++;
            }
        }
        while (i13 < 0) {
            i4--;
            i5 = ((i5 + 5) % 7) + 1;
            if (i4 < 1) {
                i4 = i3;
                i--;
            }
            i13 += 86400000;
        }
        if (i < i9) {
            return -1;
        }
        if (i > i9) {
            return 1;
        }
        int i14 = 0;
        if (i11 > i2) {
            i11 = i2;
        }
        switch (i8) {
            case 1:
                i14 = i11;
                break;
            case 2:
                if (i11 <= 0) {
                    i14 = (((i11 + 1) * 7) + i2) - (((((i5 + i2) - i4) + 7) - i10) % 7);
                    break;
                } else {
                    i14 = ((i11 - 1) * 7) + 1 + (((i10 + 7) - ((i5 - i4) + 1)) % 7);
                    break;
                }
            case 3:
                i14 = i11 + (((((i10 + 49) - i11) - i5) + i4) % 7);
                break;
            case 4:
                i14 = i11 - (((((49 - i10) + i11) + i5) - i4) % 7);
                break;
        }
        if (i4 < i14) {
            return -1;
        }
        if (i4 > i14) {
            return 1;
        }
        if (i13 < i12) {
            return -1;
        }
        if (i13 > i12) {
            return 1;
        }
        return 0;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean useDaylightTime() {
        return this.useDaylight;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean inDaylightTime(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this);
        gregorianCalendar.setTime(date);
        return gregorianCalendar.inDaylightTime();
    }

    private void construct(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.raw = i;
        this.startMonth = i2;
        this.startDay = i3;
        this.startDayOfWeek = i4;
        this.startTime = i5;
        this.startTimeMode = i6;
        this.endMonth = i7;
        this.endDay = i8;
        this.endDayOfWeek = i9;
        this.endTime = i10;
        this.endTimeMode = i11;
        this.dst = i12;
        this.startYear = 0;
        this.startMode = 1;
        this.endMode = 1;
        decodeRules();
        if (i12 <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void decodeRules() {
        decodeStartRule();
        decodeEndRule();
    }

    private void decodeStartRule() {
        this.useDaylight = (this.startDay == 0 || this.endDay == 0) ? false : true;
        if (this.useDaylight && this.dst == 0) {
            this.dst = 86400000;
        }
        if (this.startDay == 0) {
            return;
        }
        if (this.startMonth < 0 || this.startMonth > 11) {
            throw new IllegalArgumentException();
        } else if (this.startTime < 0 || this.startTime > 86400000 || this.startTimeMode < 0 || this.startTimeMode > 2) {
            throw new IllegalArgumentException();
        } else {
            if (this.startDayOfWeek == 0) {
                this.startMode = 1;
            } else {
                if (this.startDayOfWeek > 0) {
                    this.startMode = 2;
                } else {
                    this.startDayOfWeek = -this.startDayOfWeek;
                    if (this.startDay > 0) {
                        this.startMode = 3;
                    } else {
                        this.startDay = -this.startDay;
                        this.startMode = 4;
                    }
                }
                if (this.startDayOfWeek > 7) {
                    throw new IllegalArgumentException();
                }
            }
            if (this.startMode == 2) {
                if (this.startDay < -5 || this.startDay > 5) {
                    throw new IllegalArgumentException();
                }
            } else if (this.startDay < 1 || this.startDay > staticMonthLength[this.startMonth]) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void decodeEndRule() {
        this.useDaylight = (this.startDay == 0 || this.endDay == 0) ? false : true;
        if (this.useDaylight && this.dst == 0) {
            this.dst = 86400000;
        }
        if (this.endDay == 0) {
            return;
        }
        if (this.endMonth < 0 || this.endMonth > 11) {
            throw new IllegalArgumentException();
        } else if (this.endTime < 0 || this.endTime > 86400000 || this.endTimeMode < 0 || this.endTimeMode > 2) {
            throw new IllegalArgumentException();
        } else {
            if (this.endDayOfWeek == 0) {
                this.endMode = 1;
            } else {
                if (this.endDayOfWeek > 0) {
                    this.endMode = 2;
                } else {
                    this.endDayOfWeek = -this.endDayOfWeek;
                    if (this.endDay > 0) {
                        this.endMode = 3;
                    } else {
                        this.endDay = -this.endDay;
                        this.endMode = 4;
                    }
                }
                if (this.endDayOfWeek > 7) {
                    throw new IllegalArgumentException();
                }
            }
            if (this.endMode == 2) {
                if (this.endDay < -5 || this.endDay > 5) {
                    throw new IllegalArgumentException();
                }
            } else if (this.endDay < 1 || this.endDay > staticMonthLength[this.endMonth]) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override // com.ibm.icu.util.TimeZone, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SimpleTimeZone simpleTimeZone = (SimpleTimeZone) obj;
        return this.raw == simpleTimeZone.raw && this.useDaylight == simpleTimeZone.useDaylight && idEquals(getID(), simpleTimeZone.getID()) && (!this.useDaylight || (this.dst == simpleTimeZone.dst && this.startMode == simpleTimeZone.startMode && this.startMonth == simpleTimeZone.startMonth && this.startDay == simpleTimeZone.startDay && this.startDayOfWeek == simpleTimeZone.startDayOfWeek && this.startTime == simpleTimeZone.startTime && this.startTimeMode == simpleTimeZone.startTimeMode && this.endMode == simpleTimeZone.endMode && this.endMonth == simpleTimeZone.endMonth && this.endDay == simpleTimeZone.endDay && this.endDayOfWeek == simpleTimeZone.endDayOfWeek && this.endTime == simpleTimeZone.endTime && this.endTimeMode == simpleTimeZone.endTimeMode && this.startYear == simpleTimeZone.startYear));
    }

    private boolean idEquals(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    @Override // com.ibm.icu.util.TimeZone, java.lang.Object
    public int hashCode() {
        int hashCode = (super.hashCode() + this.raw) ^ ((this.raw >>> 8) + (this.useDaylight ? 0 : 1));
        if (!this.useDaylight) {
            return hashCode + ((((((((((((((this.dst ^ ((this.dst >>> 10) + this.startMode)) ^ ((this.startMode >>> 11) + this.startMonth)) ^ ((this.startMonth >>> 12) + this.startDay)) ^ ((this.startDay >>> 13) + this.startDayOfWeek)) ^ ((this.startDayOfWeek >>> 14) + this.startTime)) ^ ((this.startTime >>> 15) + this.startTimeMode)) ^ ((this.startTimeMode >>> 16) + this.endMode)) ^ ((this.endMode >>> 17) + this.endMonth)) ^ ((this.endMonth >>> 18) + this.endDay)) ^ ((this.endDay >>> 19) + this.endDayOfWeek)) ^ ((this.endDayOfWeek >>> 20) + this.endTime)) ^ ((this.endTime >>> 21) + this.endTimeMode)) ^ ((this.endTimeMode >>> 22) + this.startYear)) ^ (this.startYear >>> 23));
        }
        return hashCode;
    }

    @Override // com.ibm.icu.util.TimeZone, java.lang.Object
    public Object clone() {
        if (isFrozen()) {
            return this;
        }
        return cloneAsThawed();
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getNextTransition(long j, boolean z) {
        if (!this.useDaylight) {
            return null;
        }
        initTransitionRules();
        long time = this.firstTransition.getTime();
        if (j < time || (z && j == time)) {
            return this.firstTransition;
        }
        Date nextStart = this.stdRule.getNextStart(j, this.dstRule.getRawOffset(), this.dstRule.getDSTSavings(), z);
        Date nextStart2 = this.dstRule.getNextStart(j, this.stdRule.getRawOffset(), this.stdRule.getDSTSavings(), z);
        if (nextStart != null && (nextStart2 == null || nextStart.before(nextStart2))) {
            return new TimeZoneTransition(nextStart.getTime(), this.dstRule, this.stdRule);
        }
        if (nextStart2 == null) {
            return null;
        }
        if (nextStart == null || nextStart2.before(nextStart)) {
            return new TimeZoneTransition(nextStart2.getTime(), this.stdRule, this.dstRule);
        }
        return null;
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getPreviousTransition(long j, boolean z) {
        if (!this.useDaylight) {
            return null;
        }
        initTransitionRules();
        long time = this.firstTransition.getTime();
        if (j < time) {
            return null;
        }
        if (!z && j == time) {
            return null;
        }
        Date previousStart = this.stdRule.getPreviousStart(j, this.dstRule.getRawOffset(), this.dstRule.getDSTSavings(), z);
        Date previousStart2 = this.dstRule.getPreviousStart(j, this.stdRule.getRawOffset(), this.stdRule.getDSTSavings(), z);
        if (previousStart != null && (previousStart2 == null || previousStart.after(previousStart2))) {
            return new TimeZoneTransition(previousStart.getTime(), this.dstRule, this.stdRule);
        }
        if (previousStart2 == null) {
            return null;
        }
        if (previousStart == null || previousStart2.after(previousStart)) {
            return new TimeZoneTransition(previousStart2.getTime(), this.stdRule, this.dstRule);
        }
        return null;
    }

    private synchronized void initTransitionRules() {
        if (!this.transitionRulesInitialized) {
            if (this.useDaylight) {
                DateTimeRule dateTimeRule = null;
                int i = this.startTimeMode == 1 ? 1 : this.startTimeMode == 2 ? 2 : 0;
                switch (this.startMode) {
                    case 1:
                        dateTimeRule = new DateTimeRule(this.startMonth, this.startDay, this.startTime, i);
                        break;
                    case 2:
                        dateTimeRule = new DateTimeRule(this.startMonth, this.startDay, this.startDayOfWeek, this.startTime, i);
                        break;
                    case 3:
                        dateTimeRule = new DateTimeRule(this.startMonth, this.startDay, this.startDayOfWeek, true, this.startTime, i);
                        break;
                    case 4:
                        dateTimeRule = new DateTimeRule(this.startMonth, this.startDay, this.startDayOfWeek, false, this.startTime, i);
                        break;
                }
                this.dstRule = new AnnualTimeZoneRule(getID() + "(DST)", getRawOffset(), getDSTSavings(), dateTimeRule, this.startYear, Integer.MAX_VALUE);
                long time = this.dstRule.getFirstStart(getRawOffset(), 0).getTime();
                int i2 = this.endTimeMode == 1 ? 1 : this.endTimeMode == 2 ? 2 : 0;
                switch (this.endMode) {
                    case 1:
                        dateTimeRule = new DateTimeRule(this.endMonth, this.endDay, this.endTime, i2);
                        break;
                    case 2:
                        dateTimeRule = new DateTimeRule(this.endMonth, this.endDay, this.endDayOfWeek, this.endTime, i2);
                        break;
                    case 3:
                        dateTimeRule = new DateTimeRule(this.endMonth, this.endDay, this.endDayOfWeek, true, this.endTime, i2);
                        break;
                    case 4:
                        dateTimeRule = new DateTimeRule(this.endMonth, this.endDay, this.endDayOfWeek, false, this.endTime, i2);
                        break;
                }
                this.stdRule = new AnnualTimeZoneRule(getID() + "(STD)", getRawOffset(), 0, dateTimeRule, this.startYear, Integer.MAX_VALUE);
                long time2 = this.stdRule.getFirstStart(getRawOffset(), this.dstRule.getDSTSavings()).getTime();
                if (time2 < time) {
                    this.initialRule = new InitialTimeZoneRule(getID() + "(DST)", getRawOffset(), this.dstRule.getDSTSavings());
                    this.firstTransition = new TimeZoneTransition(time2, this.initialRule, this.stdRule);
                } else {
                    this.initialRule = new InitialTimeZoneRule(getID() + "(STD)", getRawOffset(), 0);
                    this.firstTransition = new TimeZoneTransition(time, this.initialRule, this.dstRule);
                }
            } else {
                this.initialRule = new InitialTimeZoneRule(getID(), getRawOffset(), 0);
            }
            this.transitionRulesInitialized = true;
        }
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean isFrozen() {
        return this.isFrozen;
    }

    @Override // com.ibm.icu.util.TimeZone
    public TimeZone freeze() {
        this.isFrozen = true;
        return this;
    }

    @Override // com.ibm.icu.util.TimeZone
    public TimeZone cloneAsThawed() {
        SimpleTimeZone simpleTimeZone = (SimpleTimeZone) super.cloneAsThawed();
        simpleTimeZone.isFrozen = false;
        return simpleTimeZone;
    }
}
