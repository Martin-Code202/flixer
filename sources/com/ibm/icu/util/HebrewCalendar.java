package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarCache;
import com.ibm.icu.util.ULocale;
public class HebrewCalendar extends Calendar {
    private static final int[][] LEAP_MONTH_START = {new int[]{0, 0, 0}, new int[]{30, 30, 30}, new int[]{59, 59, 60}, new int[]{88, 89, 90}, new int[]{117, 118, 119}, new int[]{147, 148, 149}, new int[]{177, 178, 179}, new int[]{206, 207, 208}, new int[]{236, 237, 238}, new int[]{265, 266, 267}, new int[]{295, 296, 297}, new int[]{324, 325, 326}, new int[]{354, 355, 356}, new int[]{383, 384, 385}};
    private static final int[][] LIMITS = {new int[]{0, 0, 0, 0}, new int[]{-5000000, -5000000, 5000000, 5000000}, new int[]{0, 0, 12, 12}, new int[]{1, 1, 51, 56}, new int[0], new int[]{1, 1, 29, 30}, new int[]{1, 1, 353, 385}, new int[0], new int[]{-1, -1, 5, 5}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[0]};
    private static final int[][] MONTH_LENGTH = {new int[]{30, 30, 30}, new int[]{29, 29, 30}, new int[]{29, 30, 30}, new int[]{29, 29, 29}, new int[]{30, 30, 30}, new int[]{30, 30, 30}, new int[]{29, 29, 29}, new int[]{30, 30, 30}, new int[]{29, 29, 29}, new int[]{30, 30, 30}, new int[]{29, 29, 29}, new int[]{30, 30, 30}, new int[]{29, 29, 29}};
    private static final int[][] MONTH_START = {new int[]{0, 0, 0}, new int[]{30, 30, 30}, new int[]{59, 59, 60}, new int[]{88, 89, 90}, new int[]{117, 118, 119}, new int[]{147, 148, 149}, new int[]{147, 148, 149}, new int[]{176, 177, 178}, new int[]{206, 207, 208}, new int[]{235, 236, 237}, new int[]{265, 266, 267}, new int[]{294, 295, 296}, new int[]{324, 325, 326}, new int[]{353, 354, 355}};
    private static CalendarCache cache = new CalendarCache();
    private static final long serialVersionUID = -1952524560588825816L;

    public HebrewCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public HebrewCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        setTimeInMillis(System.currentTimeMillis());
    }

    @Override // com.ibm.icu.util.Calendar
    public void add(int i, int i2) {
        int i3;
        switch (i) {
            case 2:
                int i4 = get(2);
                int i5 = get(1);
                if (i2 > 0) {
                    boolean z = i4 < 5;
                    i3 = i4 + i2;
                    while (true) {
                        if (z && i3 >= 5 && !isLeapYear(i5)) {
                            i3++;
                        }
                        if (i3 > 12) {
                            i3 -= 13;
                            i5++;
                            z = true;
                        }
                    }
                } else {
                    boolean z2 = i4 > 5;
                    i3 = i4 + i2;
                    while (true) {
                        if (z2 && i3 <= 5 && !isLeapYear(i5)) {
                            i3--;
                        }
                        if (i3 < 0) {
                            i3 += 13;
                            i5--;
                            z2 = true;
                        }
                    }
                }
                set(2, i3);
                set(1, i5);
                pinField(5);
                return;
            default:
                super.add(i, i2);
                return;
        }
    }

    private static long startOfYear(int i) {
        long j = cache.get((long) i);
        if (j == CalendarCache.EMPTY) {
            int i2 = ((i * 235) - 234) / 19;
            long j2 = (((long) i2) * 13753) + 12084;
            j = ((long) (i2 * 29)) + (j2 / 25920);
            long j3 = j2 % 25920;
            int i3 = (int) (j % 7);
            if (i3 == 2 || i3 == 4 || i3 == 6) {
                j++;
                i3 = (int) (j % 7);
            }
            if (i3 == 1 && j3 > 16404 && !isLeapYear(i)) {
                j += 2;
            } else if (i3 == 0 && j3 > 23269 && isLeapYear(i - 1)) {
                j++;
            }
            cache.put((long) i, j);
        }
        return j;
    }

    private final int yearType(int i) {
        int handleGetYearLength = handleGetYearLength(i);
        if (handleGetYearLength > 380) {
            handleGetYearLength -= 30;
        }
        switch (handleGetYearLength) {
            case 353:
                return 0;
            case 354:
                return 1;
            case 355:
                return 2;
            default:
                throw new IllegalArgumentException("Illegal year length " + handleGetYearLength + " in year " + i);
        }
    }

    @Deprecated
    public static boolean isLeapYear(int i) {
        int i2 = ((i * 12) + 17) % 19;
        return i2 >= (i2 < 0 ? -7 : 12);
    }

    private static int monthsInYear(int i) {
        return isLeapYear(i) ? 13 : 12;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        return LIMITS[i][i2];
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetMonthLength(int i, int i2) {
        while (i2 < 0) {
            i--;
            i2 += monthsInYear(i);
        }
        while (i2 > 12) {
            i++;
            i2 -= monthsInYear(i);
        }
        switch (i2) {
            case 1:
            case 2:
                return MONTH_LENGTH[i2][yearType(i)];
            default:
                return MONTH_LENGTH[i2][0];
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetYearLength(int i) {
        return (int) (startOfYear(i + 1) - startOfYear(i));
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public void validateField(int i) {
        if (i == 2 && !isLeapYear(handleGetExtendedYear()) && internalGet(2) == 5) {
            throw new IllegalArgumentException("MONTH cannot be ADAR_1(5) except leap years");
        }
        super.validateField(i);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public void handleComputeFields(int i) {
        int i2;
        long j = (long) (i - 347997);
        int i3 = ((int) (((19 * ((25920 * j) / 765433)) + 234) / 235)) + 1;
        long startOfYear = startOfYear(i3);
        while (true) {
            i2 = (int) (j - startOfYear);
            if (i2 >= 1) {
                break;
            }
            i3--;
            startOfYear = startOfYear(i3);
        }
        int yearType = yearType(i3);
        int[][] iArr = isLeapYear(i3) ? LEAP_MONTH_START : MONTH_START;
        int i4 = 0;
        while (i2 > iArr[i4][yearType]) {
            i4++;
        }
        int i5 = i4 - 1;
        internalSet(0, 0);
        internalSet(1, i3);
        internalSet(19, i3);
        internalSet(2, i5);
        internalSet(5, i2 - iArr[i5][yearType]);
        internalSet(6, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetExtendedYear() {
        if (newerField(19, 1) == 19) {
            return internalGet(19, 1);
        }
        return internalGet(1, 1);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        while (i2 < 0) {
            i--;
            i2 += monthsInYear(i);
        }
        while (i2 > 12) {
            i++;
            i2 -= monthsInYear(i);
        }
        long startOfYear = startOfYear(i);
        if (i2 != 0) {
            if (isLeapYear(i)) {
                startOfYear += (long) LEAP_MONTH_START[i2][yearType(i)];
            } else {
                startOfYear += (long) MONTH_START[i2][yearType(i)];
            }
        }
        return (int) (347997 + startOfYear);
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        return "hebrew";
    }
}
