package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarAstronomer;
import com.ibm.icu.impl.CalendarCache;
import com.ibm.icu.impl.CalendarUtil;
import com.ibm.icu.util.ULocale;
import java.io.ObjectInputStream;
public class IslamicCalendar extends Calendar {
    private static final int[][] LIMITS = {new int[]{0, 0, 0, 0}, new int[]{1, 1, 5000000, 5000000}, new int[]{0, 0, 11, 11}, new int[]{1, 1, 50, 51}, new int[0], new int[]{1, 1, 29, 30}, new int[]{1, 1, 354, 355}, new int[0], new int[]{-1, -1, 5, 5}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{1, 1, 5000000, 5000000}, new int[0], new int[]{1, 1, 5000000, 5000000}, new int[0], new int[0]};
    private static final int[] UMALQURA_MONTHLENGTH = {2730, 3412, 3785, 1748, 1770, 876, 2733, 1365, 1705, 1938, 2985, 1492, 2778, 1372, 3373, 1685, 1866, 2900, 2922, 1453, 1198, 2639, 1303, 1675, 1701, 2773, 726, 2395, 1181, 2637, 3366, 3477, 1452, 2486, 698, 2651, 1323, 2709, 1738, 2793, 756, 2422, 694, 2390, 2762, 2980, 3026, 1497, 732, 2413, 1357, 2725, 2898, 2981, 1460, 2486, 1367, 663, 1355, 1699, 1874, 2917, 1386, 2731, 1323, 3221, 3402, 3493, 1482, 2774, 2391, 1195, 2379, 2725, 2898, 2922, 1397, 630, 2231, 1115, 1365, 1449, 1460, 2522, 1245, 622, 2358, 2730, 3412, 3506, 1493, 730, 2395, 1195, 2645, 2889, 2916, 2929, 1460, 2741, 2645, 3365, 3730, 3785, 1748, 2793, 2411, 1195, 2707, 3401, 3492, 3506, 2745, 1210, 2651, 1323, 2709, 2858, 2901, 1372, 1213, 573, 2333, 2709, 2890, 2906, 1389, 694, 2363, 1179, 1621, 1705, 1876, 2922, 1388, 2733, 1365, 2857, 2962, 2985, 1492, 2778, 1370, 2731, 1429, 1865, 1892, 2986, 1461, 694, 2646, 3661, 2853, 2898, 2922, 1453, 686, 2351, 1175, 1611, 1701, 1708, 2774, 1373, 1181, 2637, 3350, 3477, 1450, 1461, 730, 2395, 1197, 1429, 1738, 1764, 2794, 1269, 694, 2390, 2730, 2900, 3026, 1497, 746, 2413, 1197, 2709, 2890, 2981, 1458, 2485, 1238, 2711, 1351, 1683, 1865, 2901, 1386, 2667, 1323, 2699, 3398, 3491, 1482, 2774, 1243, 619, 2379, 2725, 2898, 2921, 1397, 374, 2231, 603, 1323, 1381, 1460, 2522, 1261, 365, 2230, 2726, 3410, 3497, 1492, 2778, 2395, 1195, 1619, 1833, 1890, 2985, 1458, 2741, 1365, 2853, 3474, 3785, 1746, 2793, 1387, 1195, 2645, 3369, 3412, 3498, 2485, 1210, 2619, 1179, 2637, 2730, 2773, 730, 2397, 1118, 2606, 3226, 3413, 1714, 1721, 1210, 2653, 1325, 2709, 2898, 2984, 2996, 1465, 730, 2394, 2890, 3492, 3793, 1768, 2922, 1389, 1333, 1685, 3402, 3496, 3540, 1754, 1371, 669, 1579, 2837, 2890, 2965, 1450, 2734, 2350, 3215, 1319, 1685, 1706, 2774, 1373, 669};
    private static final byte[] UMALQURA_YEAR_START_ESTIMATE_FIX = {0, 0, -1, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, -1, -1, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 1, 0, 0, -1, 0, 1, 0, 1, 1, 0, 0, -1, 0, 1, 0, 0, 0, -1, 0, 1, 0, 1, 0, 0, 0, -1, 0, 0, 0, 0, -1, -1, 0, -1, 0, 1, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, -1, -1, 0, 0, 0, 1, 0, 0, -1, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, -1, 0, 1, 0, 1, 1, 0, 0, -1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, -1, 0, 1, 0, 0, -1, -1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 1, 1, 0, 0, -1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, -1, 0, 1, 0, 0, 0, -1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, 0, 0, -1, -1, 0, -1, 0, 1, 0, 0, -1, -1, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
    private static CalendarAstronomer astro = new CalendarAstronomer();
    private static CalendarCache cache = new CalendarCache();
    private static final long serialVersionUID = -6253365474073869325L;
    private CalculationType cType;
    private boolean civil;

    public IslamicCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public IslamicCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        this.civil = true;
        this.cType = CalculationType.ISLAMIC_CIVIL;
        setCalcTypeForLocale(uLocale);
        setTimeInMillis(System.currentTimeMillis());
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        return LIMITS[i][i2];
    }

    private static final boolean civilLeapYear(int i) {
        return ((i * 11) + 14) % 30 < 11;
    }

    private long yearStart(int i) {
        if (this.cType == CalculationType.ISLAMIC_CIVIL || this.cType == CalculationType.ISLAMIC_TBLA || (this.cType == CalculationType.ISLAMIC_UMALQURA && (i < 1300 || i > 1600))) {
            return ((long) ((i - 1) * 354)) + ((long) Math.floor(((double) ((i * 11) + 3)) / 30.0d));
        }
        if (this.cType == CalculationType.ISLAMIC) {
            return trueMonthStart((long) ((i - 1) * 12));
        }
        if (this.cType != CalculationType.ISLAMIC_UMALQURA) {
            return 0;
        }
        int i2 = i - 1300;
        return (long) (UMALQURA_YEAR_START_ESTIMATE_FIX[i2] + ((int) ((((double) i2) * 354.3672d) + 460322.05d + 0.5d)));
    }

    private long monthStart(int i, int i2) {
        int i3 = i + (i2 / 12);
        int i4 = i2 % 12;
        if (this.cType == CalculationType.ISLAMIC_CIVIL || this.cType == CalculationType.ISLAMIC_TBLA || (this.cType == CalculationType.ISLAMIC_UMALQURA && i < 1300)) {
            return ((long) Math.ceil(((double) i4) * 29.5d)) + ((long) ((i3 - 1) * 354)) + ((long) Math.floor(((double) ((i3 * 11) + 3)) / 30.0d));
        }
        if (this.cType == CalculationType.ISLAMIC) {
            return trueMonthStart((long) (((i3 - 1) * 12) + i4));
        }
        if (this.cType != CalculationType.ISLAMIC_UMALQURA) {
            return 0;
        }
        long yearStart = yearStart(i);
        for (int i5 = 0; i5 < i2; i5++) {
            yearStart += (long) handleGetMonthLength(i, i5);
        }
        return yearStart;
    }

    private static final long trueMonthStart(long j) {
        long j2 = cache.get(j);
        if (j2 != CalendarCache.EMPTY) {
            return j2;
        }
        long floor = -42521587200000L + (((long) Math.floor(((double) j) * 29.530588853d)) * 86400000);
        moonAge(floor);
        if (moonAge(floor) >= 0.0d) {
            do {
                floor -= 86400000;
            } while (moonAge(floor) >= 0.0d);
        } else {
            do {
                floor += 86400000;
            } while (moonAge(floor) < 0.0d);
        }
        long j3 = ((floor - -42521587200000L) / 86400000) + 1;
        cache.put(j, j3);
        return j3;
    }

    static final double moonAge(long j) {
        double moonAge;
        synchronized (astro) {
            astro.setTime(j);
            moonAge = astro.getMoonAge();
        }
        double d = (180.0d * moonAge) / 3.141592653589793d;
        if (d > 180.0d) {
            return d - 360.0d;
        }
        return d;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetMonthLength(int i, int i2) {
        if (this.cType == CalculationType.ISLAMIC_CIVIL || this.cType == CalculationType.ISLAMIC_TBLA || (this.cType == CalculationType.ISLAMIC_UMALQURA && (i < 1300 || i > 1600))) {
            int i3 = ((i2 + 1) % 2) + 29;
            if (i2 != 11 || !civilLeapYear(i)) {
                return i3;
            }
            return i3 + 1;
        } else if (this.cType == CalculationType.ISLAMIC) {
            int i4 = i2 + ((i - 1) * 12);
            return (int) (trueMonthStart((long) (i4 + 1)) - trueMonthStart((long) i4));
        } else {
            if ((UMALQURA_MONTHLENGTH[i - 1300] & (1 << (11 - i2))) == 0) {
                return 29;
            }
            return 30;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleGetYearLength(int i) {
        int i2 = 0;
        if (this.cType == CalculationType.ISLAMIC_CIVIL || this.cType == CalculationType.ISLAMIC_TBLA || (this.cType == CalculationType.ISLAMIC_UMALQURA && (i < 1300 || i > 1600))) {
            return (civilLeapYear(i) ? 1 : 0) + 354;
        } else if (this.cType == CalculationType.ISLAMIC) {
            int i3 = (i - 1) * 12;
            return (int) (trueMonthStart((long) (i3 + 12)) - trueMonthStart((long) i3));
        } else if (this.cType != CalculationType.ISLAMIC_UMALQURA) {
            return 0;
        } else {
            for (int i4 = 0; i4 < 12; i4++) {
                i2 += handleGetMonthLength(i, i4);
            }
            return i2;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        return (int) ((monthStart(i, i2) + (this.cType == CalculationType.ISLAMIC_TBLA ? 1948439 : 1948440)) - 1);
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
    public void handleComputeFields(int i) {
        int i2 = 0;
        int i3 = 0;
        long j = ((long) i) - 1948440;
        if (this.cType == CalculationType.ISLAMIC_CIVIL || this.cType == CalculationType.ISLAMIC_TBLA) {
            if (this.cType == CalculationType.ISLAMIC_TBLA) {
                j = ((long) i) - 1948439;
            }
            i2 = (int) Math.floor(((double) ((30 * j) + 10646)) / 10631.0d);
            i3 = Math.min((int) Math.ceil(((double) ((j - 29) - yearStart(i2))) / 29.5d), 11);
        } else if (this.cType == CalculationType.ISLAMIC) {
            int floor = (int) Math.floor(((double) j) / 29.530588853d);
            if (j - ((long) Math.floor((((double) floor) * 29.530588853d) - 1.0d)) >= 25 && moonAge(internalGetTimeInMillis()) > 0.0d) {
                floor++;
            }
            while (trueMonthStart((long) floor) > j) {
                floor--;
            }
            i2 = (floor / 12) + 1;
            i3 = floor % 12;
        } else if (this.cType == CalculationType.ISLAMIC_UMALQURA) {
            if (j < yearStart(1300)) {
                i2 = (int) Math.floor(((double) ((30 * j) + 10646)) / 10631.0d);
                i3 = Math.min((int) Math.ceil(((double) ((j - 29) - yearStart(i2))) / 29.5d), 11);
            } else {
                int i4 = 1299;
                int i5 = 0;
                long j2 = 1;
                while (true) {
                    if (j2 <= 0) {
                        break;
                    }
                    i4++;
                    j2 = (j - yearStart(i4)) + 1;
                    if (j2 == ((long) handleGetYearLength(i4))) {
                        i5 = 11;
                        break;
                    } else if (j2 < ((long) handleGetYearLength(i4))) {
                        int handleGetMonthLength = handleGetMonthLength(i4, 0);
                        i5 = 0;
                        while (j2 > ((long) handleGetMonthLength)) {
                            j2 -= (long) handleGetMonthLength;
                            i5++;
                            handleGetMonthLength = handleGetMonthLength(i4, i5);
                        }
                    }
                }
                i2 = i4;
                i3 = i5;
            }
        }
        int monthStart = ((int) (j - monthStart(i2, i3))) + 1;
        internalSet(0, 0);
        internalSet(1, i2);
        internalSet(19, i2);
        internalSet(2, i3);
        internalSet(5, monthStart);
        internalSet(6, (int) ((j - monthStart(i2, 0)) + 1));
    }

    public enum CalculationType {
        ISLAMIC("islamic"),
        ISLAMIC_CIVIL("islamic-civil"),
        ISLAMIC_UMALQURA("islamic-umalqura"),
        ISLAMIC_TBLA("islamic-tbla");
        
        private String bcpType;

        private CalculationType(String str) {
            this.bcpType = str;
        }

        /* access modifiers changed from: package-private */
        public String bcpType() {
            return this.bcpType;
        }
    }

    public void setCalculationType(CalculationType calculationType) {
        this.cType = calculationType;
        if (this.cType == CalculationType.ISLAMIC_CIVIL) {
            this.civil = true;
        } else {
            this.civil = false;
        }
    }

    private void setCalcTypeForLocale(ULocale uLocale) {
        String calendarType = CalendarUtil.getCalendarType(uLocale);
        if ("islamic-civil".equals(calendarType)) {
            setCalculationType(CalculationType.ISLAMIC_CIVIL);
        } else if ("islamic-umalqura".equals(calendarType)) {
            setCalculationType(CalculationType.ISLAMIC_UMALQURA);
        } else if ("islamic-tbla".equals(calendarType)) {
            setCalculationType(CalculationType.ISLAMIC_TBLA);
        } else if (calendarType.startsWith("islamic")) {
            setCalculationType(CalculationType.ISLAMIC);
        } else {
            setCalculationType(CalculationType.ISLAMIC_CIVIL);
        }
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        if (this.cType == null) {
            return "islamic";
        }
        return this.cType.bcpType();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.cType == null) {
            this.cType = this.civil ? CalculationType.ISLAMIC_CIVIL : CalculationType.ISLAMIC;
        } else {
            this.civil = this.cType == CalculationType.ISLAMIC_CIVIL;
        }
    }
}
