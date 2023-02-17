package com.ibm.icu.util;

import com.ibm.icu.util.ULocale;
public class IndianCalendar extends Calendar {
    private static final int[][] LIMITS = {new int[]{0, 0, 0, 0}, new int[]{-5000000, -5000000, 5000000, 5000000}, new int[]{0, 0, 11, 11}, new int[]{1, 1, 52, 53}, new int[0], new int[]{1, 1, 30, 31}, new int[]{1, 1, 365, 366}, new int[0], new int[]{-1, -1, 5, 5}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[0]};
    private static final long serialVersionUID = 3617859668165014834L;

    public IndianCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public IndianCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        setTimeInMillis(System.currentTimeMillis());
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
    public int handleGetYearLength(int i) {
        return super.handleGetYearLength(i);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetMonthLength(int i, int i2) {
        if (i2 < 0 || i2 > 11) {
            int[] iArr = new int[1];
            i += floorDivide(i2, 12, iArr);
            i2 = iArr[0];
        }
        if (isGregorianLeap(i + 78) && i2 == 0) {
            return 31;
        }
        if (i2 < 1 || i2 > 5) {
            return 30;
        }
        return 31;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public void handleComputeFields(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int[] jdToGregorian = jdToGregorian((double) i);
        int i6 = jdToGregorian[0] - 78;
        int gregorianToJD = (int) (((double) i) - gregorianToJD(jdToGregorian[0], 1, 1));
        if (gregorianToJD < 80) {
            i6--;
            i3 = isGregorianLeap(jdToGregorian[0] + -1) ? 31 : 30;
            i2 = gregorianToJD + i3 + 155 + 90 + 10;
        } else {
            i3 = isGregorianLeap(jdToGregorian[0]) ? 31 : 30;
            i2 = gregorianToJD - 80;
        }
        if (i2 < i3) {
            i5 = 0;
            i4 = i2 + 1;
        } else {
            int i7 = i2 - i3;
            if (i7 < 155) {
                i5 = (i7 / 31) + 1;
                i4 = (i7 % 31) + 1;
            } else {
                int i8 = i7 - 155;
                i5 = (i8 / 30) + 6;
                i4 = (i8 % 30) + 1;
            }
        }
        internalSet(0, 0);
        internalSet(19, i6);
        internalSet(1, i6);
        internalSet(2, i5);
        internalSet(5, i4);
        internalSet(6, i2 + 1);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        return LIMITS[i][i2];
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        if (i2 < 0 || i2 > 11) {
            i += i2 / 12;
            i2 %= 12;
        }
        return (int) IndianToJD(i, i2 + 1, 1);
    }

    private static double IndianToJD(int i, int i2, int i3) {
        double d;
        int i4;
        int i5 = i + 78;
        if (isGregorianLeap(i5)) {
            i4 = 31;
            d = gregorianToJD(i5, 3, 21);
        } else {
            i4 = 30;
            d = gregorianToJD(i5, 3, 22);
        }
        if (i2 == 1) {
            return d + ((double) (i3 - 1));
        }
        double min = d + ((double) i4) + ((double) (Math.min(i2 - 2, 5) * 31));
        if (i2 >= 8) {
            min += (double) ((i2 - 7) * 30);
        }
        return min + ((double) (i3 - 1));
    }

    private static double gregorianToJD(int i, int i2, int i3) {
        int i4;
        int i5 = i - 1;
        int i6 = (((i5 * 365) + (i5 / 4)) - (i5 / 100)) + (i5 / 400) + (((i2 * 367) - 362) / 12);
        if (i2 <= 2) {
            i4 = 0;
        } else {
            i4 = isGregorianLeap(i) ? -1 : -2;
        }
        return ((double) (((i6 + i4) + i3) - 1)) + 1721425.5d;
    }

    private static int[] jdToGregorian(double d) {
        int i;
        double floor = Math.floor(d - 0.5d) + 0.5d;
        double d2 = floor - 1721425.5d;
        double floor2 = Math.floor(d2 / 146097.0d);
        double d3 = d2 % 146097.0d;
        double floor3 = Math.floor(d3 / 36524.0d);
        double d4 = d3 % 36524.0d;
        double floor4 = Math.floor(d4 / 1461.0d);
        double floor5 = Math.floor((d4 % 1461.0d) / 365.0d);
        int i2 = (int) ((400.0d * floor2) + (100.0d * floor3) + (4.0d * floor4) + floor5);
        if (!(floor3 == 4.0d || floor5 == 4.0d)) {
            i2++;
        }
        double gregorianToJD = floor - gregorianToJD(i2, 1, 1);
        if (floor < gregorianToJD(i2, 3, 1)) {
            i = 0;
        } else {
            i = isGregorianLeap(i2) ? 1 : 2;
        }
        int floor6 = (int) Math.floor((((gregorianToJD + ((double) i)) * 12.0d) + 373.0d) / 367.0d);
        return new int[]{i2, floor6, ((int) (floor - gregorianToJD(i2, floor6, 1))) + 1};
    }

    private static boolean isGregorianLeap(int i) {
        return i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        return "indian";
    }
}
