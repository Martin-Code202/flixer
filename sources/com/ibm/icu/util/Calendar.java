package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarUtil;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.DateFormatSymbols;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.ULocale;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;
public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar> {
    static final /* synthetic */ boolean $assertionsDisabled = (!Calendar.class.desiredAssertionStatus());
    static final int[][][] DATE_PRECEDENCE = {new int[][]{new int[]{5}, new int[]{3, 7}, new int[]{4, 7}, new int[]{8, 7}, new int[]{3, 18}, new int[]{4, 18}, new int[]{8, 18}, new int[]{6}, new int[]{37, 1}, new int[]{35, 17}}, new int[][]{new int[]{3}, new int[]{4}, new int[]{8}, new int[]{40, 7}, new int[]{40, 18}}};
    private static final String[] DEFAULT_PATTERNS = {"HH:mm:ss z", "HH:mm:ss z", "HH:mm:ss", "HH:mm", "EEEE, yyyy MMMM dd", "yyyy MMMM d", "yyyy MMM d", "yy/MM/dd", "{1} {0}", "{1} {0}", "{1} {0}", "{1} {0}", "{1} {0}"};
    static final int[][][] DOW_PRECEDENCE = {new int[][]{new int[]{7}, new int[]{18}}};
    private static final String[] FIELD_NAME = {"ERA", "YEAR", "MONTH", "WEEK_OF_YEAR", "WEEK_OF_MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR", "DAY_OF_WEEK", "DAY_OF_WEEK_IN_MONTH", "AM_PM", "HOUR", "HOUR_OF_DAY", "MINUTE", "SECOND", "MILLISECOND", "ZONE_OFFSET", "DST_OFFSET", "YEAR_WOY", "DOW_LOCAL", "EXTENDED_YEAR", "JULIAN_DAY", "MILLISECONDS_IN_DAY"};
    private static final int[] FIND_ZONE_TRANSITION_TIME_UNITS = {3600000, 1800000, SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS, 1000};
    private static final int[][] GREGORIAN_MONTH_COUNT = {new int[]{31, 31, 0, 0}, new int[]{28, 29, 31, 31}, new int[]{31, 31, 59, 60}, new int[]{30, 30, 90, 91}, new int[]{31, 31, 120, 121}, new int[]{30, 30, 151, 152}, new int[]{31, 31, 181, 182}, new int[]{31, 31, 212, 213}, new int[]{30, 30, 243, 244}, new int[]{31, 31, 273, 274}, new int[]{30, 30, 304, 305}, new int[]{31, 31, 334, 335}};
    private static final int[][] LIMITS = {new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{1, 1, 7, 7}, new int[0], new int[]{0, 0, 1, 1}, new int[]{0, 0, 11, 11}, new int[]{0, 0, 23, 23}, new int[]{0, 0, 59, 59}, new int[]{0, 0, 59, 59}, new int[]{0, 0, 999, 999}, new int[]{-43200000, -43200000, 43200000, 43200000}, new int[]{0, 0, 3600000, 3600000}, new int[0], new int[]{1, 1, 7, 7}, new int[0], new int[]{-2130706432, -2130706432, 2130706432, 2130706432}, new int[]{0, 0, 86399999, 86399999}, new int[]{0, 0, 1, 1}};
    protected static final Date MAX_DATE = new Date(183882168921600000L);
    protected static final Date MIN_DATE = new Date(-184303902528000000L);
    private static final ICUCache<String, PatternData> PATTERN_CACHE = new SimpleCache();
    private static int STAMP_MAX = SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS;
    private static final WeekDataCache WEEK_DATA_CACHE = new WeekDataCache();
    private static final long serialVersionUID = 6222646104888790989L;
    private ULocale actualLocale;
    private transient boolean areAllFieldsSet;
    private transient boolean areFieldsSet;
    private transient boolean areFieldsVirtuallySet;
    private transient int[] fields;
    private int firstDayOfWeek;
    private transient int gregorianDayOfMonth;
    private transient int gregorianDayOfYear;
    private transient int gregorianMonth;
    private transient int gregorianYear;
    private transient int internalSetMask;
    private transient boolean isTimeSet;
    private boolean lenient;
    private int minimalDaysInFirstWeek;
    private transient int nextStamp;
    private int repeatedWallTime;
    private int skippedWallTime;
    private transient int[] stamp;
    private long time;
    private ULocale validLocale;
    private int weekendCease;
    private int weekendCeaseMillis;
    private int weekendOnset;
    private int weekendOnsetMillis;
    private TimeZone zone;

    /* access modifiers changed from: protected */
    public abstract int handleComputeMonthStart(int i, int i2, boolean z);

    /* access modifiers changed from: protected */
    public abstract int handleGetExtendedYear();

    /* access modifiers changed from: protected */
    public abstract int handleGetLimit(int i, int i2);

    protected Calendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }

    protected Calendar(TimeZone timeZone, ULocale uLocale) {
        this.lenient = true;
        this.repeatedWallTime = 0;
        this.skippedWallTime = 0;
        this.nextStamp = 2;
        this.zone = timeZone;
        setWeekData(getRegionForCalendar(uLocale));
        setCalendarLocale(uLocale);
        initInternal();
    }

    private void setCalendarLocale(ULocale uLocale) {
        ULocale uLocale2 = uLocale;
        if (!(uLocale.getVariant().length() == 0 && uLocale.getKeywords() == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append(uLocale.getLanguage());
            String script = uLocale.getScript();
            if (script.length() > 0) {
                sb.append("_").append(script);
            }
            String country = uLocale.getCountry();
            if (country.length() > 0) {
                sb.append("_").append(country);
            }
            String keywordValue = uLocale.getKeywordValue("calendar");
            if (keywordValue != null) {
                sb.append("@calendar=").append(keywordValue);
            }
            uLocale2 = new ULocale(sb.toString());
        }
        setLocale(uLocale2, uLocale2);
    }

    private void recalculateStamp() {
        this.nextStamp = 1;
        for (int i = 0; i < this.stamp.length; i++) {
            int i2 = STAMP_MAX;
            int i3 = -1;
            for (int i4 = 0; i4 < this.stamp.length; i4++) {
                if (this.stamp[i4] > this.nextStamp && this.stamp[i4] < i2) {
                    i2 = this.stamp[i4];
                    i3 = i4;
                }
            }
            if (i3 < 0) {
                break;
            }
            int[] iArr = this.stamp;
            int i5 = this.nextStamp + 1;
            this.nextStamp = i5;
            iArr[i3] = i5;
        }
        this.nextStamp++;
    }

    private void initInternal() {
        this.fields = handleCreateFields();
        if (this.fields == null || this.fields.length < 23 || this.fields.length > 32) {
            throw new IllegalStateException("Invalid fields[]");
        }
        this.stamp = new int[this.fields.length];
        int i = 4718695;
        for (int i2 = 23; i2 < this.fields.length; i2++) {
            i |= 1 << i2;
        }
        this.internalSetMask = i;
    }

    public static Calendar getInstance(ULocale uLocale) {
        return getInstanceInternal(null, uLocale);
    }

    public static Calendar getInstance(TimeZone timeZone, ULocale uLocale) {
        return getInstanceInternal(timeZone, uLocale);
    }

    private static Calendar getInstanceInternal(TimeZone timeZone, ULocale uLocale) {
        if (uLocale == null) {
            uLocale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        Calendar createInstance = createInstance(uLocale);
        createInstance.setTimeZone(timeZone);
        createInstance.setTimeInMillis(System.currentTimeMillis());
        return createInstance;
    }

    private static String getRegionForCalendar(ULocale uLocale) {
        String regionForSupplementalData = ULocale.getRegionForSupplementalData(uLocale, true);
        if (regionForSupplementalData.length() == 0) {
            return "001";
        }
        return regionForSupplementalData;
    }

    /* access modifiers changed from: package-private */
    public enum CalType {
        GREGORIAN("gregorian"),
        ISO8601("iso8601"),
        BUDDHIST("buddhist"),
        CHINESE("chinese"),
        COPTIC("coptic"),
        DANGI("dangi"),
        ETHIOPIC("ethiopic"),
        ETHIOPIC_AMETE_ALEM("ethiopic-amete-alem"),
        HEBREW("hebrew"),
        INDIAN("indian"),
        ISLAMIC("islamic"),
        ISLAMIC_CIVIL("islamic-civil"),
        ISLAMIC_RGSA("islamic-rgsa"),
        ISLAMIC_TBLA("islamic-tbla"),
        ISLAMIC_UMALQURA("islamic-umalqura"),
        JAPANESE("japanese"),
        PERSIAN("persian"),
        ROC("roc"),
        UNKNOWN("unknown");
        
        String id;

        private CalType(String str) {
            this.id = str;
        }
    }

    private static CalType getCalendarTypeForLocale(ULocale uLocale) {
        String calendarType = CalendarUtil.getCalendarType(uLocale);
        if (calendarType != null) {
            String lowerCase = calendarType.toLowerCase(Locale.ENGLISH);
            CalType[] values = CalType.values();
            for (CalType calType : values) {
                if (lowerCase.equals(calType.id)) {
                    return calType;
                }
            }
        }
        return CalType.UNKNOWN;
    }

    private static Calendar createInstance(ULocale uLocale) {
        TimeZone timeZone = TimeZone.getDefault();
        CalType calendarTypeForLocale = getCalendarTypeForLocale(uLocale);
        if (calendarTypeForLocale == CalType.UNKNOWN) {
            calendarTypeForLocale = CalType.GREGORIAN;
        }
        switch (calendarTypeForLocale) {
            case GREGORIAN:
                return new GregorianCalendar(timeZone, uLocale);
            case ISO8601:
                GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, uLocale);
                gregorianCalendar.setFirstDayOfWeek(2);
                gregorianCalendar.setMinimalDaysInFirstWeek(4);
                return gregorianCalendar;
            case BUDDHIST:
                return new BuddhistCalendar(timeZone, uLocale);
            case CHINESE:
                return new ChineseCalendar(timeZone, uLocale);
            case COPTIC:
                return new CopticCalendar(timeZone, uLocale);
            case DANGI:
                return new DangiCalendar(timeZone, uLocale);
            case ETHIOPIC:
                return new EthiopicCalendar(timeZone, uLocale);
            case ETHIOPIC_AMETE_ALEM:
                EthiopicCalendar ethiopicCalendar = new EthiopicCalendar(timeZone, uLocale);
                ethiopicCalendar.setAmeteAlemEra(true);
                return ethiopicCalendar;
            case HEBREW:
                return new HebrewCalendar(timeZone, uLocale);
            case INDIAN:
                return new IndianCalendar(timeZone, uLocale);
            case ISLAMIC_CIVIL:
            case ISLAMIC_UMALQURA:
            case ISLAMIC_TBLA:
            case ISLAMIC_RGSA:
            case ISLAMIC:
                return new IslamicCalendar(timeZone, uLocale);
            case JAPANESE:
                return new JapaneseCalendar(timeZone, uLocale);
            case PERSIAN:
                return new PersianCalendar(timeZone, uLocale);
            case ROC:
                return new TaiwanCalendar(timeZone, uLocale);
            default:
                throw new IllegalArgumentException("Unknown calendar type");
        }
    }

    public final Date getTime() {
        return new Date(getTimeInMillis());
    }

    public final void setTime(Date date) {
        setTimeInMillis(date.getTime());
    }

    public long getTimeInMillis() {
        if (!this.isTimeSet) {
            updateTime();
        }
        return this.time;
    }

    public void setTimeInMillis(long j) {
        if (j > 183882168921600000L) {
            if (isLenient()) {
                j = 183882168921600000L;
            } else {
                throw new IllegalArgumentException("millis value greater than upper bounds for a Calendar : " + j);
            }
        } else if (j < -184303902528000000L) {
            if (isLenient()) {
                j = -184303902528000000L;
            } else {
                throw new IllegalArgumentException("millis value less than lower bounds for a Calendar : " + j);
            }
        }
        this.time = j;
        this.areAllFieldsSet = false;
        this.areFieldsSet = false;
        this.areFieldsVirtuallySet = true;
        this.isTimeSet = true;
        for (int i = 0; i < this.fields.length; i++) {
            int[] iArr = this.fields;
            this.stamp[i] = 0;
            iArr[i] = 0;
        }
    }

    public final int get(int i) {
        complete();
        return this.fields[i];
    }

    /* access modifiers changed from: protected */
    public final int internalGet(int i) {
        return this.fields[i];
    }

    /* access modifiers changed from: protected */
    public final int internalGet(int i, int i2) {
        return this.stamp[i] > 0 ? this.fields[i] : i2;
    }

    public final void set(int i, int i2) {
        if (this.areFieldsVirtuallySet) {
            computeFields();
        }
        this.fields[i] = i2;
        if (this.nextStamp == STAMP_MAX) {
            recalculateStamp();
        }
        int[] iArr = this.stamp;
        int i3 = this.nextStamp;
        this.nextStamp = i3 + 1;
        iArr[i] = i3;
        this.areFieldsVirtuallySet = false;
        this.areFieldsSet = false;
        this.isTimeSet = false;
    }

    private static int gregoYearFromIslamicStart(int i) {
        int i2;
        if (i >= 1397) {
            i2 = (((i - 1397) / 67) * 2) + ((i + -1397) % 67 >= 33 ? 1 : 0);
        } else {
            i2 = ((((i - 1396) / 67) - 1) * 2) + ((-(i + -1396)) % 67 <= 33 ? 1 : 0);
        }
        return (i + 579) - i2;
    }

    @Deprecated
    public final int getRelatedYear() {
        int i = get(19);
        CalType calType = CalType.GREGORIAN;
        String type = getType();
        CalType[] values = CalType.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            CalType calType2 = values[i2];
            if (type.equals(calType2.id)) {
                calType = calType2;
                break;
            }
            i2++;
        }
        switch (calType) {
            case CHINESE:
                return i - 2637;
            case COPTIC:
                return i + 284;
            case DANGI:
                return i - 2333;
            case ETHIOPIC:
                return i + 8;
            case ETHIOPIC_AMETE_ALEM:
                return i - 5492;
            case HEBREW:
                return i - 3760;
            case INDIAN:
                return i + 79;
            case ISLAMIC_CIVIL:
            case ISLAMIC_UMALQURA:
            case ISLAMIC_TBLA:
            case ISLAMIC_RGSA:
            case ISLAMIC:
                return gregoYearFromIslamicStart(i);
            case JAPANESE:
            default:
                return i;
            case PERSIAN:
                return i + 622;
        }
    }

    private static int firstIslamicStartYearFromGrego(int i) {
        int i2;
        if (i >= 1977) {
            i2 = (((i - 1977) / 65) * 2) + ((i + -1977) % 65 >= 32 ? 1 : 0);
        } else {
            i2 = ((((i - 1976) / 65) - 1) * 2) + ((-(i + -1976)) % 65 <= 32 ? 1 : 0);
        }
        return (i - 579) + i2;
    }

    @Deprecated
    public final void setRelatedYear(int i) {
        CalType calType = CalType.GREGORIAN;
        String type = getType();
        CalType[] values = CalType.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            CalType calType2 = values[i2];
            if (type.equals(calType2.id)) {
                calType = calType2;
                break;
            }
            i2++;
        }
        switch (calType) {
            case CHINESE:
                i += 2637;
                break;
            case COPTIC:
                i -= 284;
                break;
            case DANGI:
                i += 2333;
                break;
            case ETHIOPIC:
                i -= 8;
                break;
            case ETHIOPIC_AMETE_ALEM:
                i += 5492;
                break;
            case HEBREW:
                i += 3760;
                break;
            case INDIAN:
                i -= 79;
                break;
            case ISLAMIC_CIVIL:
            case ISLAMIC_UMALQURA:
            case ISLAMIC_TBLA:
            case ISLAMIC_RGSA:
            case ISLAMIC:
                i = firstIslamicStartYearFromGrego(i);
                break;
            case PERSIAN:
                i -= 622;
                break;
        }
        set(19, i);
    }

    public final void clear() {
        for (int i = 0; i < this.fields.length; i++) {
            int[] iArr = this.fields;
            this.stamp[i] = 0;
            iArr[i] = 0;
        }
        this.areFieldsVirtuallySet = false;
        this.areAllFieldsSet = false;
        this.areFieldsSet = false;
        this.isTimeSet = false;
    }

    public final boolean isSet(int i) {
        return this.areFieldsVirtuallySet || this.stamp[i] != 0;
    }

    /* access modifiers changed from: protected */
    public void complete() {
        if (!this.isTimeSet) {
            updateTime();
        }
        if (!this.areFieldsSet) {
            computeFields();
            this.areFieldsSet = true;
            this.areAllFieldsSet = true;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Calendar calendar = (Calendar) obj;
        return isEquivalentTo(calendar) && getTimeInMillis() == calendar.getTime().getTime();
    }

    public boolean isEquivalentTo(Calendar calendar) {
        return getClass() == calendar.getClass() && isLenient() == calendar.isLenient() && getFirstDayOfWeek() == calendar.getFirstDayOfWeek() && getMinimalDaysInFirstWeek() == calendar.getMinimalDaysInFirstWeek() && getTimeZone().equals(calendar.getTimeZone()) && getRepeatedWallTimeOption() == calendar.getRepeatedWallTimeOption() && getSkippedWallTimeOption() == calendar.getSkippedWallTimeOption();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.lenient ? 1 : 0) | (this.firstDayOfWeek << 1) | (this.minimalDaysInFirstWeek << 4) | (this.repeatedWallTime << 7) | (this.skippedWallTime << 9) | (this.zone.hashCode() << 11);
    }

    public int getActualMaximum(int i) {
        switch (i) {
            case 0:
            case 7:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 20:
            case 21:
                return getMaximum(i);
            case 1:
            case 2:
            case 3:
            case 4:
            case 8:
            case 17:
            case 19:
            default:
                return getActualHelper(i, getLeastMaximum(i), getMaximum(i));
            case 5:
                Calendar calendar = (Calendar) clone();
                calendar.setLenient(true);
                calendar.prepareGetActual(i, false);
                return handleGetMonthLength(calendar.get(19), calendar.get(2));
            case 6:
                Calendar calendar2 = (Calendar) clone();
                calendar2.setLenient(true);
                calendar2.prepareGetActual(i, false);
                return handleGetYearLength(calendar2.get(19));
        }
    }

    public int getActualMinimum(int i) {
        switch (i) {
            case 7:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 20:
            case 21:
                return getMinimum(i);
            case 8:
            case 17:
            case 19:
            default:
                return getActualHelper(i, getGreatestMinimum(i), getMinimum(i));
        }
    }

    /* access modifiers changed from: protected */
    public void prepareGetActual(int i, boolean z) {
        set(21, 0);
        switch (i) {
            case 1:
            case 19:
                set(6, getGreatestMinimum(6));
                break;
            case 2:
                set(5, getGreatestMinimum(5));
                break;
            case 3:
            case 4:
                int i2 = this.firstDayOfWeek;
                if (z && (i2 = (i2 + 6) % 7) < 1) {
                    i2 += 7;
                }
                set(7, i2);
                break;
            case 8:
                set(5, 1);
                set(7, get(7));
                break;
            case 17:
                set(3, getGreatestMinimum(3));
                break;
        }
        set(i, getGreatestMinimum(i));
    }

    private int getActualHelper(int i, int i2, int i3) {
        if (i2 == i3) {
            return i2;
        }
        int i4 = i3 > i2 ? 1 : -1;
        Calendar calendar = (Calendar) clone();
        calendar.complete();
        calendar.setLenient(true);
        calendar.prepareGetActual(i, i4 < 0);
        calendar.set(i, i2);
        if (calendar.get(i) != i2 && i != 4 && i4 > 0) {
            return i2;
        }
        int i5 = i2;
        do {
            i2 += i4;
            calendar.add(i, i4);
            if (calendar.get(i) != i2) {
                break;
            }
            i5 = i2;
        } while (i2 != i3);
        return i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[ADDED_TO_REGION, ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(int r19, int r20) {
        /*
        // Method dump skipped, instructions count: 452
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.util.Calendar.add(int, int):void");
    }

    public int compareTo(Calendar calendar) {
        long timeInMillis = getTimeInMillis() - calendar.getTimeInMillis();
        if (timeInMillis < 0) {
            return -1;
        }
        return timeInMillis > 0 ? 1 : 0;
    }

    public DateFormat getDateTimeFormat(int i, int i2, ULocale uLocale) {
        return formatHelper(this, uLocale, i, i2);
    }

    /* access modifiers changed from: protected */
    public DateFormat handleGetDateFormat(String str, String str2, ULocale uLocale) {
        FormatConfiguration formatConfiguration = new FormatConfiguration();
        formatConfiguration.pattern = str;
        formatConfiguration.override = str2;
        formatConfiguration.formatData = new DateFormatSymbols(this, uLocale);
        formatConfiguration.loc = uLocale;
        formatConfiguration.cal = this;
        return SimpleDateFormat.getInstance(formatConfiguration);
    }

    private static DateFormat formatHelper(Calendar calendar, ULocale uLocale, int i, int i2) {
        String str;
        if (i2 < -1 || i2 > 3) {
            throw new IllegalArgumentException("Illegal time style " + i2);
        } else if (i < -1 || i > 3) {
            throw new IllegalArgumentException("Illegal date style " + i);
        } else {
            PatternData make = PatternData.make(calendar, uLocale);
            String str2 = null;
            if (i2 >= 0 && i >= 0) {
                str = SimpleFormatterImpl.formatRawPattern(make.getDateTimePattern(i), 2, 2, make.patterns[i2], make.patterns[i + 4]);
                if (make.overrides != null) {
                    str2 = mergeOverrideStrings(make.patterns[i + 4], make.patterns[i2], make.overrides[i + 4], make.overrides[i2]);
                }
            } else if (i2 >= 0) {
                str = make.patterns[i2];
                if (make.overrides != null) {
                    str2 = make.overrides[i2];
                }
            } else if (i >= 0) {
                str = make.patterns[i + 4];
                if (make.overrides != null) {
                    str2 = make.overrides[i + 4];
                }
            } else {
                throw new IllegalArgumentException("No date or time style specified");
            }
            DateFormat handleGetDateFormat = calendar.handleGetDateFormat(str, str2, uLocale);
            handleGetDateFormat.setCalendar(calendar);
            return handleGetDateFormat;
        }
    }

    /* access modifiers changed from: package-private */
    public static class PatternData {
        private String[] overrides;
        private String[] patterns;

        public PatternData(String[] strArr, String[] strArr2) {
            this.patterns = strArr;
            this.overrides = strArr2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private String getDateTimePattern(int i) {
            int i2 = 8;
            if (this.patterns.length >= 13) {
                i2 = i + 1 + 8;
            }
            return this.patterns[i2];
        }

        /* access modifiers changed from: private */
        public static PatternData make(Calendar calendar, ULocale uLocale) {
            String type = calendar.getType();
            String str = uLocale.getBaseName() + "+" + type;
            PatternData patternData = (PatternData) Calendar.PATTERN_CACHE.get(str);
            if (patternData == null) {
                try {
                    patternData = Calendar.getPatternData(uLocale, type);
                } catch (MissingResourceException e) {
                    patternData = new PatternData(Calendar.DEFAULT_PATTERNS, null);
                }
                Calendar.PATTERN_CACHE.put(str, patternData);
            }
            return patternData;
        }
    }

    /* access modifiers changed from: private */
    public static PatternData getPatternData(ULocale uLocale, String str) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", uLocale);
        ICUResourceBundle findWithFallback = iCUResourceBundle.findWithFallback("calendar/" + str + "/DateTimePatterns");
        if (findWithFallback == null) {
            findWithFallback = iCUResourceBundle.getWithFallback("calendar/gregorian/DateTimePatterns");
        }
        int size = findWithFallback.getSize();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        for (int i = 0; i < size; i++) {
            ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle) findWithFallback.get(i);
            switch (iCUResourceBundle2.getType()) {
                case 0:
                    strArr[i] = iCUResourceBundle2.getString();
                    break;
                case 8:
                    strArr[i] = iCUResourceBundle2.getString(0);
                    strArr2[i] = iCUResourceBundle2.getString(1);
                    break;
            }
        }
        return new PatternData(strArr, strArr2);
    }

    private static String mergeOverrideStrings(String str, String str2, String str3, String str4) {
        if (str3 == null && str4 == null) {
            return null;
        }
        if (str3 == null) {
            return expandOverride(str2, str4);
        }
        if (str4 == null) {
            return expandOverride(str, str3);
        }
        if (str3.equals(str4)) {
            return str3;
        }
        return expandOverride(str, str3) + ";" + expandOverride(str2, str4);
    }

    private static String expandOverride(String str, String str2) {
        if (str2.indexOf(61) >= 0) {
            return str2;
        }
        boolean z = false;
        char c = ' ';
        StringBuilder sb = new StringBuilder();
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '\'') {
                z = !z;
            } else if (!z && first != c) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(first);
                sb.append("=");
                sb.append(str2);
            }
            c = first;
        }
        return sb.toString();
    }

    @Deprecated
    public static class FormatConfiguration {
        private Calendar cal;
        private DateFormatSymbols formatData;
        private ULocale loc;
        private String override;
        private String pattern;

        private FormatConfiguration() {
        }

        @Deprecated
        public String getPatternString() {
            return this.pattern;
        }

        @Deprecated
        public String getOverrideString() {
            return this.override;
        }

        @Deprecated
        public Calendar getCalendar() {
            return this.cal;
        }

        @Deprecated
        public ULocale getLocale() {
            return this.loc;
        }

        @Deprecated
        public DateFormatSymbols getDateFormatSymbols() {
            return this.formatData;
        }
    }

    /* access modifiers changed from: protected */
    public void pinField(int i) {
        int actualMaximum = getActualMaximum(i);
        int actualMinimum = getActualMinimum(i);
        if (this.fields[i] > actualMaximum) {
            set(i, actualMaximum);
        } else if (this.fields[i] < actualMinimum) {
            set(i, actualMinimum);
        }
    }

    /* access modifiers changed from: protected */
    public int weekNumber(int i, int i2, int i3) {
        int firstDayOfWeek2 = (((i3 - getFirstDayOfWeek()) - i2) + 1) % 7;
        if (firstDayOfWeek2 < 0) {
            firstDayOfWeek2 += 7;
        }
        int i4 = ((i + firstDayOfWeek2) - 1) / 7;
        if (7 - firstDayOfWeek2 >= getMinimalDaysInFirstWeek()) {
            return i4 + 1;
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public final int weekNumber(int i, int i2) {
        return weekNumber(i, i, i2);
    }

    public void setTimeZone(TimeZone timeZone) {
        this.zone = timeZone;
        this.areFieldsSet = false;
    }

    public TimeZone getTimeZone() {
        return this.zone;
    }

    public void setLenient(boolean z) {
        this.lenient = z;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public int getRepeatedWallTimeOption() {
        return this.repeatedWallTime;
    }

    public int getSkippedWallTimeOption() {
        return this.skippedWallTime;
    }

    public void setFirstDayOfWeek(int i) {
        if (this.firstDayOfWeek == i) {
            return;
        }
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Invalid day of week");
        }
        this.firstDayOfWeek = i;
        this.areFieldsSet = false;
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public void setMinimalDaysInFirstWeek(int i) {
        if (i < 1) {
            i = 1;
        } else if (i > 7) {
            i = 7;
        }
        if (this.minimalDaysInFirstWeek != i) {
            this.minimalDaysInFirstWeek = i;
            this.areFieldsSet = false;
        }
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDaysInFirstWeek;
    }

    /* access modifiers changed from: protected */
    public int getLimit(int i, int i2) {
        switch (i) {
            case 4:
                if (i2 == 0) {
                    return getMinimalDaysInFirstWeek() == 1 ? 1 : 0;
                }
                if (i2 == 1) {
                    return 1;
                }
                int minimalDaysInFirstWeek2 = getMinimalDaysInFirstWeek();
                int handleGetLimit = handleGetLimit(5, i2);
                if (i2 == 2) {
                    return ((7 - minimalDaysInFirstWeek2) + handleGetLimit) / 7;
                }
                return ((handleGetLimit + 6) + (7 - minimalDaysInFirstWeek2)) / 7;
            case 5:
            case 6:
            case 8:
            case 17:
            case 19:
            default:
                return handleGetLimit(i, i2);
            case 7:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 20:
            case 21:
            case 22:
                return LIMITS[i][i2];
        }
    }

    public final int getMinimum(int i) {
        return getLimit(i, 0);
    }

    public final int getMaximum(int i) {
        return getLimit(i, 3);
    }

    public final int getGreatestMinimum(int i) {
        return getLimit(i, 1);
    }

    public final int getLeastMaximum(int i) {
        return getLimit(i, 2);
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            Calendar calendar = (Calendar) super.clone();
            calendar.fields = new int[this.fields.length];
            calendar.stamp = new int[this.fields.length];
            System.arraycopy(this.fields, 0, calendar.fields, 0, this.fields.length);
            System.arraycopy(this.stamp, 0, calendar.stamp, 0, this.fields.length);
            calendar.zone = (TimeZone) this.zone.clone();
            return calendar;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[time=");
        sb.append(this.isTimeSet ? String.valueOf(this.time) : "?");
        sb.append(",areFieldsSet=");
        sb.append(this.areFieldsSet);
        sb.append(",areAllFieldsSet=");
        sb.append(this.areAllFieldsSet);
        sb.append(",lenient=");
        sb.append(this.lenient);
        sb.append(",zone=");
        sb.append(this.zone);
        sb.append(",firstDayOfWeek=");
        sb.append(this.firstDayOfWeek);
        sb.append(",minimalDaysInFirstWeek=");
        sb.append(this.minimalDaysInFirstWeek);
        sb.append(",repeatedWallTime=");
        sb.append(this.repeatedWallTime);
        sb.append(",skippedWallTime=");
        sb.append(this.skippedWallTime);
        for (int i = 0; i < this.fields.length; i++) {
            sb.append(',').append(fieldName(i)).append('=');
            sb.append(isSet(i) ? String.valueOf(this.fields[i]) : "?");
        }
        sb.append(']');
        return sb.toString();
    }

    public static final class WeekData {
        public final int firstDayOfWeek;
        public final int minimalDaysInFirstWeek;
        public final int weekendCease;
        public final int weekendCeaseMillis;
        public final int weekendOnset;
        public final int weekendOnsetMillis;

        public WeekData(int i, int i2, int i3, int i4, int i5, int i6) {
            this.firstDayOfWeek = i;
            this.minimalDaysInFirstWeek = i2;
            this.weekendOnset = i3;
            this.weekendOnsetMillis = i4;
            this.weekendCease = i5;
            this.weekendCeaseMillis = i6;
        }

        public int hashCode() {
            return (((((((((this.firstDayOfWeek * 37) + this.minimalDaysInFirstWeek) * 37) + this.weekendOnset) * 37) + this.weekendOnsetMillis) * 37) + this.weekendCease) * 37) + this.weekendCeaseMillis;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WeekData)) {
                return false;
            }
            WeekData weekData = (WeekData) obj;
            return this.firstDayOfWeek == weekData.firstDayOfWeek && this.minimalDaysInFirstWeek == weekData.minimalDaysInFirstWeek && this.weekendOnset == weekData.weekendOnset && this.weekendOnsetMillis == weekData.weekendOnsetMillis && this.weekendCease == weekData.weekendCease && this.weekendCeaseMillis == weekData.weekendCeaseMillis;
        }

        public String toString() {
            return "{" + this.firstDayOfWeek + ", " + this.minimalDaysInFirstWeek + ", " + this.weekendOnset + ", " + this.weekendOnsetMillis + ", " + this.weekendCease + ", " + this.weekendCeaseMillis + "}";
        }
    }

    public Calendar setWeekData(WeekData weekData) {
        setFirstDayOfWeek(weekData.firstDayOfWeek);
        setMinimalDaysInFirstWeek(weekData.minimalDaysInFirstWeek);
        this.weekendOnset = weekData.weekendOnset;
        this.weekendOnsetMillis = weekData.weekendOnsetMillis;
        this.weekendCease = weekData.weekendCease;
        this.weekendCeaseMillis = weekData.weekendCeaseMillis;
        return this;
    }

    /* access modifiers changed from: private */
    public static WeekData getWeekDataForRegionInternal(String str) {
        UResourceBundle uResourceBundle;
        if (str == null) {
            str = "001";
        }
        UResourceBundle uResourceBundle2 = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("weekData");
        try {
            uResourceBundle = uResourceBundle2.get(str);
        } catch (MissingResourceException e) {
            if (!str.equals("001")) {
                uResourceBundle = uResourceBundle2.get("001");
            } else {
                throw e;
            }
        }
        int[] intVector = uResourceBundle.getIntVector();
        return new WeekData(intVector[0], intVector[1], intVector[2], intVector[3], intVector[4], intVector[5]);
    }

    /* access modifiers changed from: package-private */
    public static class WeekDataCache extends SoftCache<String, WeekData, String> {
        private WeekDataCache() {
        }

        /* access modifiers changed from: protected */
        public WeekData createInstance(String str, String str2) {
            return Calendar.getWeekDataForRegionInternal(str);
        }
    }

    private void setWeekData(String str) {
        if (str == null) {
            str = "001";
        }
        setWeekData((WeekData) WEEK_DATA_CACHE.getInstance(str, str));
    }

    private void updateTime() {
        computeTime();
        if (isLenient() || !this.areAllFieldsSet) {
            this.areFieldsSet = false;
        }
        this.isTimeSet = true;
        this.areFieldsVirtuallySet = false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        if (!this.isTimeSet) {
            try {
                updateTime();
            } catch (IllegalArgumentException e) {
            }
        }
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        initInternal();
        this.isTimeSet = true;
        this.areAllFieldsSet = false;
        this.areFieldsSet = false;
        this.areFieldsVirtuallySet = true;
        this.nextStamp = 2;
    }

    /* access modifiers changed from: protected */
    public void computeFields() {
        int[] iArr = new int[2];
        getTimeZone().getOffset(this.time, false, iArr);
        long j = this.time + ((long) iArr[0]) + ((long) iArr[1]);
        int i = this.internalSetMask;
        for (int i2 = 0; i2 < this.fields.length; i2++) {
            if ((i & 1) == 0) {
                this.stamp[i2] = 1;
            } else {
                this.stamp[i2] = 0;
            }
            i >>= 1;
        }
        long floorDivide = floorDivide(j, 86400000);
        this.fields[20] = ((int) floorDivide) + 2440588;
        computeGregorianAndDOWFields(this.fields[20]);
        handleComputeFields(this.fields[20]);
        computeWeekFields();
        int i3 = (int) (j - (86400000 * floorDivide));
        this.fields[21] = i3;
        this.fields[14] = i3 % 1000;
        int i4 = i3 / 1000;
        this.fields[13] = i4 % 60;
        int i5 = i4 / 60;
        this.fields[12] = i5 % 60;
        int i6 = i5 / 60;
        this.fields[11] = i6;
        this.fields[9] = i6 / 12;
        this.fields[10] = i6 % 12;
        this.fields[15] = iArr[0];
        this.fields[16] = iArr[1];
    }

    private final void computeGregorianAndDOWFields(int i) {
        computeGregorianFields(i);
        int[] iArr = this.fields;
        int julianDayToDayOfWeek = julianDayToDayOfWeek(i);
        iArr[7] = julianDayToDayOfWeek;
        int firstDayOfWeek2 = (julianDayToDayOfWeek - getFirstDayOfWeek()) + 1;
        if (firstDayOfWeek2 < 1) {
            firstDayOfWeek2 += 7;
        }
        this.fields[18] = firstDayOfWeek2;
    }

    /* access modifiers changed from: protected */
    public final void computeGregorianFields(int i) {
        int[] iArr = new int[1];
        int floorDivide = floorDivide((long) (i - 1721426), 146097, iArr);
        int floorDivide2 = floorDivide(iArr[0], 36524, iArr);
        int floorDivide3 = floorDivide(iArr[0], 1461, iArr);
        int floorDivide4 = floorDivide(iArr[0], 365, iArr);
        int i2 = (floorDivide * 400) + (floorDivide2 * 100) + (floorDivide3 * 4) + floorDivide4;
        int i3 = iArr[0];
        if (floorDivide2 == 4 || floorDivide4 == 4) {
            i3 = 365;
        } else {
            i2++;
        }
        boolean z = (i2 & 3) == 0 && (i2 % 100 != 0 || i2 % 400 == 0);
        int i4 = 0;
        if (i3 >= (z ? 60 : 59)) {
            i4 = z ? 1 : 2;
        }
        int i5 = (((i3 + i4) * 12) + 6) / 367;
        int[] iArr2 = GREGORIAN_MONTH_COUNT[i5];
        char c = z ? (char) 3 : 2;
        this.gregorianYear = i2;
        this.gregorianMonth = i5;
        this.gregorianDayOfMonth = (i3 - iArr2[c]) + 1;
        this.gregorianDayOfYear = i3 + 1;
    }

    private final void computeWeekFields() {
        int i = this.fields[19];
        int i2 = this.fields[7];
        int i3 = this.fields[6];
        int i4 = i;
        int firstDayOfWeek2 = ((i2 + 7) - getFirstDayOfWeek()) % 7;
        int firstDayOfWeek3 = (((i2 - i3) + 7001) - getFirstDayOfWeek()) % 7;
        int i5 = ((i3 - 1) + firstDayOfWeek3) / 7;
        if (7 - firstDayOfWeek3 >= getMinimalDaysInFirstWeek()) {
            i5++;
        }
        if (i5 == 0) {
            i5 = weekNumber(i3 + handleGetYearLength(i - 1), i2);
            i4--;
        } else {
            int handleGetYearLength = handleGetYearLength(i);
            if (i3 >= handleGetYearLength - 5) {
                int i6 = ((firstDayOfWeek2 + handleGetYearLength) - i3) % 7;
                if (i6 < 0) {
                    i6 += 7;
                }
                if (6 - i6 >= getMinimalDaysInFirstWeek() && (i3 + 7) - firstDayOfWeek2 > handleGetYearLength) {
                    i5 = 1;
                    i4++;
                }
            }
        }
        this.fields[3] = i5;
        this.fields[17] = i4;
        int i7 = this.fields[5];
        this.fields[4] = weekNumber(i7, i2);
        this.fields[8] = ((i7 - 1) / 7) + 1;
    }

    /* access modifiers changed from: protected */
    public int resolveFields(int[][][] iArr) {
        int i = -1;
        for (int i2 = 0; i2 < iArr.length && i < 0; i2++) {
            int[][] iArr2 = iArr[i2];
            int i3 = 0;
            for (int[] iArr3 : iArr2) {
                int i4 = 0;
                int i5 = iArr3[0] >= 32 ? 1 : 0;
                while (true) {
                    if (i5 < iArr3.length) {
                        int i6 = this.stamp[iArr3[i5]];
                        if (i6 == 0) {
                            break;
                        }
                        i4 = Math.max(i4, i6);
                        i5++;
                    } else if (i4 > i3) {
                        int i7 = iArr3[0];
                        if (i7 >= 32) {
                            i7 &= 31;
                            if (i7 != 5 || this.stamp[4] < this.stamp[i7]) {
                                i = i7;
                            }
                        } else {
                            i = i7;
                        }
                        if (i == i7) {
                            i3 = i4;
                        }
                    }
                }
            }
        }
        return i >= 32 ? i & 31 : i;
    }

    /* access modifiers changed from: protected */
    public int newestStamp(int i, int i2, int i3) {
        int i4 = i3;
        for (int i5 = i; i5 <= i2; i5++) {
            if (this.stamp[i5] > i4) {
                i4 = this.stamp[i5];
            }
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public final int getStamp(int i) {
        return this.stamp[i];
    }

    /* access modifiers changed from: protected */
    public int newerField(int i, int i2) {
        if (this.stamp[i2] > this.stamp[i]) {
            return i2;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public void validateFields() {
        for (int i = 0; i < this.fields.length; i++) {
            if (this.stamp[i] >= 2) {
                validateField(i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void validateField(int i) {
        switch (i) {
            case 5:
                validateField(i, 1, handleGetMonthLength(handleGetExtendedYear(), internalGet(2)));
                return;
            case 6:
                validateField(i, 1, handleGetYearLength(handleGetExtendedYear()));
                return;
            case 7:
            default:
                validateField(i, getMinimum(i), getMaximum(i));
                return;
            case 8:
                if (internalGet(i) == 0) {
                    throw new IllegalArgumentException("DAY_OF_WEEK_IN_MONTH cannot be zero");
                }
                validateField(i, getMinimum(i), getMaximum(i));
                return;
        }
    }

    /* access modifiers changed from: protected */
    public final void validateField(int i, int i2, int i3) {
        int i4 = this.fields[i];
        if (i4 < i2 || i4 > i3) {
            throw new IllegalArgumentException(fieldName(i) + '=' + i4 + ", valid range=" + i2 + ".." + i3);
        }
    }

    /* access modifiers changed from: protected */
    public void computeTime() {
        int i;
        if (!isLenient()) {
            validateFields();
        }
        long julianDayToMillis = julianDayToMillis(computeJulianDay());
        if (this.stamp[21] < 2 || newestStamp(9, 14, 0) > this.stamp[21]) {
            i = computeMillisInDay();
        } else {
            i = internalGet(21);
        }
        if (this.stamp[15] >= 2 || this.stamp[16] >= 2) {
            this.time = (((long) i) + julianDayToMillis) - ((long) (internalGet(15) + internalGet(16)));
        } else if (!this.lenient || this.skippedWallTime == 2) {
            int computeZoneOffset = computeZoneOffset(julianDayToMillis, i);
            long j = (((long) i) + julianDayToMillis) - ((long) computeZoneOffset);
            if (computeZoneOffset == this.zone.getOffset(j)) {
                this.time = j;
            } else if (!this.lenient) {
                throw new IllegalArgumentException("The specified wall time does not exist due to time zone offset transition.");
            } else if ($assertionsDisabled || this.skippedWallTime == 2) {
                Long immediatePreviousZoneTransition = getImmediatePreviousZoneTransition(j);
                if (immediatePreviousZoneTransition == null) {
                    throw new RuntimeException("Could not locate a time zone transition before " + j);
                }
                this.time = immediatePreviousZoneTransition.longValue();
            } else {
                throw new AssertionError(this.skippedWallTime);
            }
        } else {
            this.time = (((long) i) + julianDayToMillis) - ((long) computeZoneOffset(julianDayToMillis, i));
        }
    }

    private Long getImmediatePreviousZoneTransition(long j) {
        if (this.zone instanceof BasicTimeZone) {
            TimeZoneTransition previousTransition = ((BasicTimeZone) this.zone).getPreviousTransition(j, true);
            if (previousTransition != null) {
                return Long.valueOf(previousTransition.getTime());
            }
            return null;
        }
        Long previousZoneTransitionTime = getPreviousZoneTransitionTime(this.zone, j, 7200000);
        if (previousZoneTransitionTime == null) {
            return getPreviousZoneTransitionTime(this.zone, j, 108000000);
        }
        return previousZoneTransitionTime;
    }

    private static Long getPreviousZoneTransitionTime(TimeZone timeZone, long j, long j2) {
        if ($assertionsDisabled || j2 > 0) {
            long j3 = (j - j2) - 1;
            int offset = timeZone.getOffset(j);
            if (offset == timeZone.getOffset(j3)) {
                return null;
            }
            return findPreviousZoneTransitionTime(timeZone, offset, j, j3);
        }
        throw new AssertionError();
    }

    private static Long findPreviousZoneTransitionTime(TimeZone timeZone, int i, long j, long j2) {
        long j3;
        boolean z = false;
        long j4 = 0;
        int[] iArr = FIND_ZONE_TRANSITION_TIME_UNITS;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i3 = iArr[i2];
            long j5 = j2 / ((long) i3);
            long j6 = j / ((long) i3);
            if (j6 > j5) {
                j4 = (((j5 + j6) + 1) >>> 1) * ((long) i3);
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            j4 = (j + j2) >>> 1;
        }
        if (z) {
            if (j4 != j) {
                if (timeZone.getOffset(j4) != i) {
                    return findPreviousZoneTransitionTime(timeZone, i, j, j4);
                }
                j = j4;
            }
            j3 = j4 - 1;
        } else {
            j3 = (j + j2) >>> 1;
        }
        if (j3 == j2) {
            return Long.valueOf(j);
        }
        if (timeZone.getOffset(j3) == i) {
            return findPreviousZoneTransitionTime(timeZone, i, j3, j2);
        }
        if (z) {
            return Long.valueOf(j);
        }
        return findPreviousZoneTransitionTime(timeZone, i, j, j3);
    }

    /* access modifiers changed from: protected */
    public int computeMillisInDay() {
        int i = 0;
        int i2 = this.stamp[11];
        int max = Math.max(this.stamp[10], this.stamp[9]);
        int i3 = max > i2 ? max : i2;
        if (i3 != 0) {
            if (i3 == i2) {
                i = internalGet(11) + 0;
            } else {
                i = internalGet(10) + 0 + (internalGet(9) * 12);
            }
        }
        return (((((i * 60) + internalGet(12)) * 60) + internalGet(13)) * 1000) + internalGet(14);
    }

    /* access modifiers changed from: protected */
    public int computeZoneOffset(long j, int i) {
        int[] iArr = new int[2];
        long j2 = j + ((long) i);
        if (this.zone instanceof BasicTimeZone) {
            ((BasicTimeZone) this.zone).getOffsetFromLocal(j2, this.skippedWallTime == 1 ? 12 : 4, this.repeatedWallTime == 1 ? 4 : 12, iArr);
        } else {
            this.zone.getOffset(j2, true, iArr);
            boolean z = false;
            if (this.repeatedWallTime == 1) {
                int offset = (iArr[0] + iArr[1]) - this.zone.getOffset((j2 - ((long) (iArr[0] + iArr[1]))) - 21600000);
                if (!$assertionsDisabled && offset <= -21600000) {
                    throw new AssertionError(offset);
                } else if (offset < 0) {
                    z = true;
                    this.zone.getOffset(((long) offset) + j2, true, iArr);
                }
            }
            if (!z && this.skippedWallTime == 1) {
                this.zone.getOffset(j2 - ((long) (iArr[0] + iArr[1])), false, iArr);
            }
        }
        return iArr[0] + iArr[1];
    }

    /* access modifiers changed from: protected */
    public int computeJulianDay() {
        if (this.stamp[20] >= 2 && newestStamp(17, 19, newestStamp(0, 8, 0)) <= this.stamp[20]) {
            return internalGet(20);
        }
        int resolveFields = resolveFields(getFieldResolutionTable());
        if (resolveFields < 0) {
            resolveFields = 5;
        }
        return handleComputeJulianDay(resolveFields);
    }

    /* access modifiers changed from: protected */
    public int[][][] getFieldResolutionTable() {
        return DATE_PRECEDENCE;
    }

    /* access modifiers changed from: protected */
    public int handleGetMonthLength(int i, int i2) {
        return handleComputeMonthStart(i, i2 + 1, true) - handleComputeMonthStart(i, i2, true);
    }

    /* access modifiers changed from: protected */
    public int handleGetYearLength(int i) {
        return handleComputeMonthStart(i + 1, 0, false) - handleComputeMonthStart(i, 0, false);
    }

    /* access modifiers changed from: protected */
    public int[] handleCreateFields() {
        return new int[23];
    }

    /* access modifiers changed from: protected */
    public int getDefaultMonthInYear(int i) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getDefaultDayInMonth(int i, int i2) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int handleComputeJulianDay(int i) {
        int i2;
        int i3;
        boolean z = i == 5 || i == 4 || i == 8;
        if (i == 3) {
            i2 = internalGet(17, handleGetExtendedYear());
        } else {
            i2 = handleGetExtendedYear();
        }
        internalSet(19, i2);
        int internalGet = z ? internalGet(2, getDefaultMonthInYear(i2)) : 0;
        int handleComputeMonthStart = handleComputeMonthStart(i2, internalGet, z);
        if (i == 5) {
            if (isSet(5)) {
                return internalGet(5, getDefaultDayInMonth(i2, internalGet)) + handleComputeMonthStart;
            }
            return getDefaultDayInMonth(i2, internalGet) + handleComputeMonthStart;
        } else if (i == 6) {
            return internalGet(6) + handleComputeMonthStart;
        } else {
            int firstDayOfWeek2 = getFirstDayOfWeek();
            int julianDayToDayOfWeek = julianDayToDayOfWeek(handleComputeMonthStart + 1) - firstDayOfWeek2;
            if (julianDayToDayOfWeek < 0) {
                julianDayToDayOfWeek += 7;
            }
            int i4 = 0;
            switch (resolveFields(DOW_PRECEDENCE)) {
                case 7:
                    i4 = internalGet(7) - firstDayOfWeek2;
                    break;
                case 18:
                    i4 = internalGet(18) - 1;
                    break;
            }
            int i5 = i4 % 7;
            if (i5 < 0) {
                i5 += 7;
            }
            int i6 = (1 - julianDayToDayOfWeek) + i5;
            if (i == 8) {
                if (i6 < 1) {
                    i6 += 7;
                }
                int internalGet2 = internalGet(8, 1);
                if (internalGet2 >= 0) {
                    i3 = i6 + ((internalGet2 - 1) * 7);
                } else {
                    i3 = i6 + ((((handleGetMonthLength(i2, internalGet(2, 0)) - i6) / 7) + internalGet2 + 1) * 7);
                }
            } else {
                if (7 - julianDayToDayOfWeek < getMinimalDaysInFirstWeek()) {
                    i6 += 7;
                }
                i3 = i6 + ((internalGet(i) - 1) * 7);
            }
            return handleComputeMonthStart + i3;
        }
    }

    /* access modifiers changed from: protected */
    public int computeGregorianMonthStart(int i, int i2) {
        if (i2 < 0 || i2 > 11) {
            int[] iArr = new int[1];
            i += floorDivide(i2, 12, iArr);
            i2 = iArr[0];
        }
        boolean z = i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
        int i3 = i - 1;
        int floorDivide = (((((i3 * 365) + floorDivide(i3, 4)) - floorDivide(i3, 100)) + floorDivide(i3, 400)) + 1721426) - 1;
        if (i2 == 0) {
            return floorDivide;
        }
        return floorDivide + GREGORIAN_MONTH_COUNT[i2][z ? (char) 3 : 2];
    }

    /* access modifiers changed from: protected */
    public void handleComputeFields(int i) {
        internalSet(2, getGregorianMonth());
        internalSet(5, getGregorianDayOfMonth());
        internalSet(6, getGregorianDayOfYear());
        int gregorianYear2 = getGregorianYear();
        internalSet(19, gregorianYear2);
        int i2 = 1;
        if (gregorianYear2 < 1) {
            i2 = 0;
            gregorianYear2 = 1 - gregorianYear2;
        }
        internalSet(0, i2);
        internalSet(1, gregorianYear2);
    }

    /* access modifiers changed from: protected */
    public final int getGregorianYear() {
        return this.gregorianYear;
    }

    /* access modifiers changed from: protected */
    public final int getGregorianMonth() {
        return this.gregorianMonth;
    }

    /* access modifiers changed from: protected */
    public final int getGregorianDayOfYear() {
        return this.gregorianDayOfYear;
    }

    /* access modifiers changed from: protected */
    public final int getGregorianDayOfMonth() {
        return this.gregorianDayOfMonth;
    }

    public final int getFieldCount() {
        return this.fields.length;
    }

    /* access modifiers changed from: protected */
    public final void internalSet(int i, int i2) {
        if (((1 << i) & this.internalSetMask) == 0) {
            throw new IllegalStateException("Subclass cannot set " + fieldName(i));
        }
        this.fields[i] = i2;
        this.stamp[i] = 1;
    }

    protected static final long floorDivide(long j, long j2) {
        return j >= 0 ? j / j2 : ((1 + j) / j2) - 1;
    }

    protected static final int floorDivide(int i, int i2) {
        return i >= 0 ? i / i2 : ((i + 1) / i2) - 1;
    }

    protected static final int floorDivide(int i, int i2, int[] iArr) {
        if (i >= 0) {
            iArr[0] = i % i2;
            return i / i2;
        }
        int i3 = ((i + 1) / i2) - 1;
        iArr[0] = i - (i3 * i2);
        return i3;
    }

    protected static final int floorDivide(long j, int i, int[] iArr) {
        if (j >= 0) {
            iArr[0] = (int) (j % ((long) i));
            return (int) (j / ((long) i));
        }
        int i2 = (int) (((1 + j) / ((long) i)) - 1);
        iArr[0] = (int) (j - (((long) i2) * ((long) i)));
        return i2;
    }

    /* access modifiers changed from: protected */
    public String fieldName(int i) {
        try {
            return FIELD_NAME[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Field " + i;
        }
    }

    protected static final long julianDayToMillis(int i) {
        return ((long) (i - 2440588)) * 86400000;
    }

    protected static final int julianDayToDayOfWeek(int i) {
        int i2 = (i + 2) % 7;
        if (i2 < 1) {
            return i2 + 7;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public final long internalGetTimeInMillis() {
        return this.time;
    }

    public String getType() {
        return "unknown";
    }

    @Deprecated
    public boolean haveDefaultCentury() {
        return true;
    }

    public final ULocale getLocale(ULocale.Type type) {
        return type == ULocale.ACTUAL_LOCALE ? this.actualLocale : this.validLocale;
    }

    /* access modifiers changed from: package-private */
    public final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if ((uLocale == null) != (uLocale2 == null)) {
            throw new IllegalArgumentException();
        }
        this.validLocale = uLocale;
        this.actualLocale = uLocale2;
    }
}
