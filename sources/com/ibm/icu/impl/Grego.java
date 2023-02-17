package com.ibm.icu.impl;

import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
public class Grego {
    private static final int[] DAYS_BEFORE = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
    private static final int[] MONTH_LENGTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static final boolean isLeapYear(int i) {
        return (i & 3) == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    public static final int monthLength(int i, int i2) {
        return MONTH_LENGTH[(isLeapYear(i) ? 12 : 0) + i2];
    }

    public static final int previousMonthLength(int i, int i2) {
        if (i2 > 0) {
            return monthLength(i, i2 - 1);
        }
        return 31;
    }

    public static long fieldsToDay(int i, int i2, int i3) {
        int i4 = i - 1;
        return (((((((((long) (i4 * 365)) + floorDivide((long) i4, 4)) + 1721423) + floorDivide((long) i4, 400)) - floorDivide((long) i4, 100)) + 2) + ((long) DAYS_BEFORE[(isLeapYear(i) ? 12 : 0) + i2])) + ((long) i3)) - 2440588;
    }

    public static int dayOfWeek(long j) {
        long[] jArr = new long[1];
        floorDivide(5 + j, 7, jArr);
        int i = (int) jArr[0];
        return i == 0 ? 7 : i;
    }

    public static int[] dayToFields(long j, int[] iArr) {
        if (iArr == null || iArr.length < 5) {
            iArr = new int[5];
        }
        long j2 = j + 719162;
        long[] jArr = new long[1];
        long floorDivide = floorDivide(j2, 146097, jArr);
        long floorDivide2 = floorDivide(jArr[0], 36524, jArr);
        long floorDivide3 = floorDivide(jArr[0], 1461, jArr);
        long floorDivide4 = floorDivide(jArr[0], 365, jArr);
        int i = (int) ((400 * floorDivide) + (100 * floorDivide2) + (4 * floorDivide3) + floorDivide4);
        int i2 = (int) jArr[0];
        if (floorDivide2 == 4 || floorDivide4 == 4) {
            i2 = 365;
        } else {
            i++;
        }
        boolean isLeapYear = isLeapYear(i);
        int i3 = 0;
        if (i2 >= (isLeapYear ? 60 : 59)) {
            i3 = isLeapYear ? 1 : 2;
        }
        int i4 = (((i2 + i3) * 12) + 6) / 367;
        int i5 = (i2 - DAYS_BEFORE[isLeapYear ? i4 + 12 : i4]) + 1;
        int i6 = (int) ((2 + j2) % 7);
        if (i6 < 1) {
            i6 += 7;
        }
        iArr[0] = i;
        iArr[1] = i4;
        iArr[2] = i5;
        iArr[3] = i6;
        iArr[4] = i2 + 1;
        return iArr;
    }

    public static int[] timeToFields(long j, int[] iArr) {
        if (iArr == null || iArr.length < 6) {
            iArr = new int[6];
        }
        long[] jArr = new long[1];
        dayToFields(floorDivide(j, 86400000, jArr), iArr);
        iArr[5] = (int) jArr[0];
        return iArr;
    }

    public static long floorDivide(long j, long j2) {
        return j >= 0 ? j / j2 : ((1 + j) / j2) - 1;
    }

    private static long floorDivide(long j, long j2, long[] jArr) {
        if (j >= 0) {
            jArr[0] = j % j2;
            return j / j2;
        }
        long j3 = ((1 + j) / j2) - 1;
        jArr[0] = j - (j3 * j2);
        return j3;
    }

    public static String timeToString(long j) {
        int[] timeToFields = timeToFields(j, null);
        int i = timeToFields[5];
        int i2 = i / 3600000;
        int i3 = i % 3600000;
        int i4 = i3 / SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS;
        int i5 = i3 % SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS;
        return String.format(null, "%04d-%02d-%02dT%02d:%02d:%02d.%03dZ", Integer.valueOf(timeToFields[0]), Integer.valueOf(timeToFields[1] + 1), Integer.valueOf(timeToFields[2]), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5 / 1000), Integer.valueOf(i5 % 1000));
    }
}
