package com.ibm.icu.util;

import com.ibm.icu.util.ULocale;
import java.util.Date;
public class GregorianCalendar extends Calendar {
    private static final int[][] LIMITS = {new int[]{0, 0, 1, 1}, new int[]{1, 1, 5828963, 5838270}, new int[]{0, 0, 11, 11}, new int[]{1, 1, 52, 53}, new int[0], new int[]{1, 1, 28, 31}, new int[]{1, 1, 365, 366}, new int[0], new int[]{-1, -1, 4, 5}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{-5838270, -5838270, 5828964, 5838271}, new int[0], new int[]{-5838269, -5838269, 5828963, 5838270}, new int[0], new int[0], new int[0]};
    private static final int[][] MONTH_COUNT = {new int[]{31, 31, 0, 0}, new int[]{28, 29, 31, 31}, new int[]{31, 31, 59, 60}, new int[]{30, 30, 90, 91}, new int[]{31, 31, 120, 121}, new int[]{30, 30, 151, 152}, new int[]{31, 31, 181, 182}, new int[]{31, 31, 212, 213}, new int[]{30, 30, 243, 244}, new int[]{31, 31, 273, 274}, new int[]{30, 30, 304, 305}, new int[]{31, 31, 334, 335}};
    private static final long serialVersionUID = 9199388694351062137L;
    private transient int cutoverJulianDay;
    private long gregorianCutover;
    private transient int gregorianCutoverYear;
    protected transient boolean invertGregorian;
    protected transient boolean isGregorian;

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        return LIMITS[i][i2];
    }

    public GregorianCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public GregorianCalendar(TimeZone timeZone) {
        this(timeZone, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public GregorianCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        this.gregorianCutover = -12219292800000L;
        this.cutoverJulianDay = 2299161;
        this.gregorianCutoverYear = 1582;
        setTimeInMillis(System.currentTimeMillis());
    }

    public GregorianCalendar(int i, int i2, int i3) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        this.gregorianCutover = -12219292800000L;
        this.cutoverJulianDay = 2299161;
        this.gregorianCutoverYear = 1582;
        set(0, 1);
        set(1, i);
        set(2, i2);
        set(5, i3);
    }

    public void setGregorianChange(Date date) {
        this.gregorianCutover = date.getTime();
        if (this.gregorianCutover <= -184303902528000000L) {
            this.cutoverJulianDay = Integer.MIN_VALUE;
            this.gregorianCutoverYear = Integer.MIN_VALUE;
        } else if (this.gregorianCutover >= 183882168921600000L) {
            this.cutoverJulianDay = Integer.MAX_VALUE;
            this.gregorianCutoverYear = Integer.MAX_VALUE;
        } else {
            this.cutoverJulianDay = (int) floorDivide(this.gregorianCutover, 86400000);
            GregorianCalendar gregorianCalendar = new GregorianCalendar(getTimeZone());
            gregorianCalendar.setTime(date);
            this.gregorianCutoverYear = gregorianCalendar.get(19);
        }
    }

    public boolean isLeapYear(int i) {
        return i >= this.gregorianCutoverYear ? i % 4 == 0 && (i % 100 != 0 || i % 400 == 0) : i % 4 == 0;
    }

    @Override // com.ibm.icu.util.Calendar
    public boolean isEquivalentTo(Calendar calendar) {
        return super.isEquivalentTo(calendar) && this.gregorianCutover == ((GregorianCalendar) calendar).gregorianCutover;
    }

    @Override // com.ibm.icu.util.Calendar, java.lang.Object
    public int hashCode() {
        return super.hashCode() ^ ((int) this.gregorianCutover);
    }

    @Override // com.ibm.icu.util.Calendar
    public int getActualMinimum(int i) {
        return getMinimum(i);
    }

    @Override // com.ibm.icu.util.Calendar
    public int getActualMaximum(int i) {
        switch (i) {
            case 1:
                Calendar calendar = (Calendar) clone();
                calendar.setLenient(true);
                int i2 = calendar.get(0);
                Date time = calendar.getTime();
                int i3 = LIMITS[1][1];
                int i4 = LIMITS[1][2] + 1;
                while (i3 + 1 < i4) {
                    int i5 = (i3 + i4) / 2;
                    calendar.set(1, i5);
                    if (calendar.get(1) == i5 && calendar.get(0) == i2) {
                        i3 = i5;
                    } else {
                        i4 = i5;
                        calendar.setTime(time);
                    }
                }
                return i3;
            default:
                return super.getActualMaximum(i);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean inDaylightTime() {
        if (!getTimeZone().useDaylightTime()) {
            return false;
        }
        complete();
        return internalGet(16) != 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetMonthLength(int i, int i2) {
        if (i2 < 0 || i2 > 11) {
            int[] iArr = new int[1];
            i += floorDivide(i2, 12, iArr);
            i2 = iArr[0];
        }
        return MONTH_COUNT[i2][isLeapYear(i) ? (char) 1 : 0];
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetYearLength(int i) {
        return isLeapYear(i) ? 366 : 365;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public void handleComputeFields(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (i >= this.cutoverJulianDay) {
            i4 = getGregorianMonth();
            i3 = getGregorianDayOfMonth();
            i2 = getGregorianDayOfYear();
            i5 = getGregorianYear();
        } else {
            long j = (long) (i - 1721424);
            i5 = (int) floorDivide((4 * j) + 1464, 1461);
            int floorDivide = (int) (j - (((((long) i5) - 1) * 365) + floorDivide(((long) i5) - 1, 4)));
            boolean z = (i5 & 3) == 0;
            int i6 = 0;
            if (floorDivide >= (z ? 60 : 59)) {
                i6 = z ? 1 : 2;
            }
            i4 = (((floorDivide + i6) * 12) + 6) / 367;
            i3 = (floorDivide - MONTH_COUNT[i4][z ? (char) 3 : 2]) + 1;
            i2 = floorDivide + 1;
        }
        internalSet(2, i4);
        internalSet(5, i3);
        internalSet(6, i2);
        internalSet(19, i5);
        int i7 = 1;
        if (i5 < 1) {
            i7 = 0;
            i5 = 1 - i5;
        }
        internalSet(0, i7);
        internalSet(1, i5);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetExtendedYear() {
        if (newerField(19, 1) == 19) {
            return internalGet(19, 1970);
        }
        if (internalGet(0, 1) == 0) {
            return 1 - internalGet(1, 1);
        }
        return internalGet(1, 1970);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleComputeJulianDay(int i) {
        this.invertGregorian = false;
        int handleComputeJulianDay = super.handleComputeJulianDay(i);
        if (this.isGregorian == (handleComputeJulianDay >= this.cutoverJulianDay)) {
            return handleComputeJulianDay;
        }
        this.invertGregorian = true;
        return super.handleComputeJulianDay(i);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        if (i2 < 0 || i2 > 11) {
            int[] iArr = new int[1];
            i += floorDivide(i2, 12, iArr);
            i2 = iArr[0];
        }
        boolean z2 = i % 4 == 0;
        int i3 = i - 1;
        int floorDivide = (i3 * 365) + floorDivide(i3, 4) + 1721423;
        this.isGregorian = i >= this.gregorianCutoverYear;
        if (this.invertGregorian) {
            this.isGregorian = !this.isGregorian;
        }
        if (this.isGregorian) {
            z2 = z2 && (i % 100 != 0 || i % 400 == 0);
            floorDivide += (floorDivide(i3, 400) - floorDivide(i3, 100)) + 2;
        }
        if (i2 == 0) {
            return floorDivide;
        }
        return floorDivide + MONTH_COUNT[i2][z2 ? (char) 3 : 2];
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        return "gregorian";
    }
}
