package com.ibm.icu.text;

import com.ibm.icu.impl.DateNumberFormat;
import com.ibm.icu.impl.DayPeriodRules;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.DisplayContext;
import com.ibm.icu.text.TimeZoneFormat;
import com.ibm.icu.util.BasicTimeZone;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.HebrewCalendar;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.TimeZoneTransition;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.MissingResourceException;
public class SimpleDateFormat extends DateFormat {
    static final /* synthetic */ boolean $assertionsDisabled = (!SimpleDateFormat.class.desiredAssertionStatus());
    private static final int[] CALENDAR_FIELD_TO_LEVEL = {0, 10, 20, 20, 30, 30, 20, 30, 30, 40, 50, 50, 60, 70, 80, 0, 0, 10, 30, 10, 0, 40, 0, 0};
    static final UnicodeSet DATE_PATTERN_TYPE = new UnicodeSet("[GyYuUQqMLlwWd]").freeze();
    static boolean DelayedHebrewMonthCheck = false;
    private static ICUCache<String, Object[]> PARSED_PATTERN_CACHE = new SimpleCache();
    private static final boolean[] PATTERN_CHAR_IS_SYNTAX = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false};
    private static final int[] PATTERN_CHAR_TO_INDEX = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, 36, -1, 10, 9, 11, 0, 5, -1, -1, 16, 26, 2, -1, 31, -1, 27, -1, 8, -1, 30, 29, 13, 32, 18, 23, -1, -1, -1, -1, -1, -1, 14, 35, 25, 3, 19, -1, 21, 15, -1, -1, 4, -1, 6, -1, -1, -1, 28, 34, 7, -1, 20, 24, 12, 33, 1, 17, -1, -1, -1, -1, -1};
    private static final int[] PATTERN_CHAR_TO_LEVEL = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, 20, 30, 30, 0, 50, -1, -1, 50, 20, 20, -1, 0, -1, 20, -1, 80, -1, 10, 0, 30, 0, 10, 0, -1, -1, -1, -1, -1, -1, 40, -1, 30, 30, 30, -1, 0, 50, -1, -1, 50, -1, 60, -1, -1, -1, 20, 10, 70, -1, 10, 0, 20, 0, 10, 0, -1, -1, -1, -1, -1};
    private static final int[] PATTERN_INDEX_TO_CALENDAR_FIELD = {0, 1, 2, 5, 11, 11, 12, 13, 14, 7, 6, 8, 3, 4, 9, 10, 10, 15, 17, 18, 19, 20, 21, 15, 15, 18, 2, 2, 2, 15, 1, 15, 15, 15, 19, -1, -2};
    private static final DateFormat.Field[] PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE = {DateFormat.Field.ERA, DateFormat.Field.YEAR, DateFormat.Field.MONTH, DateFormat.Field.DAY_OF_MONTH, DateFormat.Field.HOUR_OF_DAY1, DateFormat.Field.HOUR_OF_DAY0, DateFormat.Field.MINUTE, DateFormat.Field.SECOND, DateFormat.Field.MILLISECOND, DateFormat.Field.DAY_OF_WEEK, DateFormat.Field.DAY_OF_YEAR, DateFormat.Field.DAY_OF_WEEK_IN_MONTH, DateFormat.Field.WEEK_OF_YEAR, DateFormat.Field.WEEK_OF_MONTH, DateFormat.Field.AM_PM, DateFormat.Field.HOUR1, DateFormat.Field.HOUR0, DateFormat.Field.TIME_ZONE, DateFormat.Field.YEAR_WOY, DateFormat.Field.DOW_LOCAL, DateFormat.Field.EXTENDED_YEAR, DateFormat.Field.JULIAN_DAY, DateFormat.Field.MILLISECONDS_IN_DAY, DateFormat.Field.TIME_ZONE, DateFormat.Field.TIME_ZONE, DateFormat.Field.DAY_OF_WEEK, DateFormat.Field.MONTH, DateFormat.Field.QUARTER, DateFormat.Field.QUARTER, DateFormat.Field.TIME_ZONE, DateFormat.Field.YEAR, DateFormat.Field.TIME_ZONE, DateFormat.Field.TIME_ZONE, DateFormat.Field.TIME_ZONE, DateFormat.Field.RELATED_YEAR, DateFormat.Field.AM_PM_MIDNIGHT_NOON, DateFormat.Field.FLEXIBLE_DAY_PERIOD, DateFormat.Field.TIME_SEPARATOR};
    private static final int[] PATTERN_INDEX_TO_DATE_FORMAT_FIELD = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37};
    private static ULocale cachedDefaultLocale = null;
    private static String cachedDefaultPattern = null;
    private static final long serialVersionUID = 4774881970558875024L;
    private transient BreakIterator capitalizationBrkIter;
    private transient char[] decDigits;
    private transient char[] decimalBuf;
    private transient long defaultCenturyBase;
    private Date defaultCenturyStart;
    private transient int defaultCenturyStartYear;
    private DateFormatSymbols formatData;
    private transient boolean hasMinute;
    private transient boolean hasSecond;
    private transient ULocale locale;
    private HashMap<String, NumberFormat> numberFormatters;
    private String override;
    private HashMap<Character, String> overrideMap;
    private String pattern;
    private transient Object[] patternItems;
    private int serialVersionOnStream;
    private volatile TimeZoneFormat tzFormat;
    private transient boolean useFastFormat;
    private transient boolean useLocalZeroPaddingNumberFormat;

    private static boolean isSyntaxChar(char c) {
        if (c < PATTERN_CHAR_IS_SYNTAX.length) {
            return PATTERN_CHAR_IS_SYNTAX[c & 255];
        }
        return false;
    }

    public SimpleDateFormat() {
        this(getDefaultPattern(), null, null, null, null, true, null);
    }

    public SimpleDateFormat(String str) {
        this(str, null, null, null, null, true, null);
    }

    public SimpleDateFormat(String str, ULocale uLocale) {
        this(str, null, null, null, uLocale, true, null);
    }

    private SimpleDateFormat(String str, DateFormatSymbols dateFormatSymbols, Calendar calendar, NumberFormat numberFormat, ULocale uLocale, boolean z, String str2) {
        this.serialVersionOnStream = 2;
        this.capitalizationBrkIter = null;
        this.pattern = str;
        this.formatData = dateFormatSymbols;
        this.calendar = calendar;
        this.numberFormat = numberFormat;
        this.locale = uLocale;
        this.useFastFormat = z;
        this.override = str2;
        initialize();
    }

    @Deprecated
    public static SimpleDateFormat getInstance(Calendar.FormatConfiguration formatConfiguration) {
        String overrideString = formatConfiguration.getOverrideString();
        return new SimpleDateFormat(formatConfiguration.getPatternString(), formatConfiguration.getDateFormatSymbols(), formatConfiguration.getCalendar(), null, formatConfiguration.getLocale(), overrideString != null && overrideString.length() > 0, formatConfiguration.getOverrideString());
    }

    private void initialize() {
        if (this.locale == null) {
            this.locale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        if (this.formatData == null) {
            this.formatData = new DateFormatSymbols(this.locale);
        }
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance(this.locale);
        }
        if (this.numberFormat == null) {
            NumberingSystem instance = NumberingSystem.getInstance(this.locale);
            if (instance.isAlgorithmic()) {
                this.numberFormat = NumberFormat.getInstance(this.locale);
            } else {
                this.numberFormat = new DateNumberFormat(this.locale, instance.getDescription(), instance.getName());
            }
        }
        this.defaultCenturyBase = System.currentTimeMillis();
        setLocale(this.calendar.getLocale(ULocale.VALID_LOCALE), this.calendar.getLocale(ULocale.ACTUAL_LOCALE));
        initLocalZeroPaddingNumberFormat();
        if (this.override != null) {
            initNumberFormatters(this.locale);
        }
        parsePattern();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0005, code lost:
        if (r3.tzFormat == null) goto L_0x0007;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void initializeTimeZoneFormat(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto L_0x0007
            com.ibm.icu.text.TimeZoneFormat r0 = r3.tzFormat     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x005e
        L_0x0007:
            com.ibm.icu.util.ULocale r0 = r3.locale     // Catch:{ all -> 0x0060 }
            com.ibm.icu.text.TimeZoneFormat r0 = com.ibm.icu.text.TimeZoneFormat.getInstance(r0)     // Catch:{ all -> 0x0060 }
            r3.tzFormat = r0     // Catch:{ all -> 0x0060 }
            r1 = 0
            com.ibm.icu.text.NumberFormat r0 = r3.numberFormat     // Catch:{ all -> 0x0060 }
            boolean r0 = r0 instanceof com.ibm.icu.text.DecimalFormat     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0028
            com.ibm.icu.text.NumberFormat r0 = r3.numberFormat     // Catch:{ all -> 0x0060 }
            com.ibm.icu.text.DecimalFormat r0 = (com.ibm.icu.text.DecimalFormat) r0     // Catch:{ all -> 0x0060 }
            com.ibm.icu.text.DecimalFormatSymbols r2 = r0.getDecimalFormatSymbols()     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0060 }
            char[] r0 = r2.getDigits()     // Catch:{ all -> 0x0060 }
            r1.<init>(r0)     // Catch:{ all -> 0x0060 }
            goto L_0x003b
        L_0x0028:
            com.ibm.icu.text.NumberFormat r0 = r3.numberFormat     // Catch:{ all -> 0x0060 }
            boolean r0 = r0 instanceof com.ibm.icu.impl.DateNumberFormat     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x003b
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0060 }
            com.ibm.icu.text.NumberFormat r0 = r3.numberFormat     // Catch:{ all -> 0x0060 }
            com.ibm.icu.impl.DateNumberFormat r0 = (com.ibm.icu.impl.DateNumberFormat) r0     // Catch:{ all -> 0x0060 }
            char[] r0 = r0.getDigits()     // Catch:{ all -> 0x0060 }
            r1.<init>(r0)     // Catch:{ all -> 0x0060 }
        L_0x003b:
            if (r1 == 0) goto L_0x005e
            com.ibm.icu.text.TimeZoneFormat r0 = r3.tzFormat     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = r0.getGMTOffsetDigits()     // Catch:{ all -> 0x0060 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x005e
            com.ibm.icu.text.TimeZoneFormat r0 = r3.tzFormat     // Catch:{ all -> 0x0060 }
            boolean r0 = r0.isFrozen()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0059
            com.ibm.icu.text.TimeZoneFormat r0 = r3.tzFormat     // Catch:{ all -> 0x0060 }
            com.ibm.icu.text.TimeZoneFormat r0 = r0.cloneAsThawed()     // Catch:{ all -> 0x0060 }
            r3.tzFormat = r0     // Catch:{ all -> 0x0060 }
        L_0x0059:
            com.ibm.icu.text.TimeZoneFormat r0 = r3.tzFormat     // Catch:{ all -> 0x0060 }
            r0.setGMTOffsetDigits(r1)     // Catch:{ all -> 0x0060 }
        L_0x005e:
            monitor-exit(r3)
            return
        L_0x0060:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.SimpleDateFormat.initializeTimeZoneFormat(boolean):void");
    }

    private TimeZoneFormat tzFormat() {
        if (this.tzFormat == null) {
            initializeTimeZoneFormat(false);
        }
        return this.tzFormat;
    }

    private static synchronized String getDefaultPattern() {
        String str;
        synchronized (SimpleDateFormat.class) {
            ULocale uLocale = ULocale.getDefault(ULocale.Category.FORMAT);
            if (!uLocale.equals(cachedDefaultLocale)) {
                cachedDefaultLocale = uLocale;
                Calendar instance = Calendar.getInstance(cachedDefaultLocale);
                try {
                    ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", cachedDefaultLocale);
                    ICUResourceBundle findWithFallback = iCUResourceBundle.findWithFallback("calendar/" + instance.getType() + "/DateTimePatterns");
                    if (findWithFallback == null) {
                        findWithFallback = iCUResourceBundle.findWithFallback("calendar/gregorian/DateTimePatterns");
                    }
                    if (findWithFallback == null || findWithFallback.getSize() < 9) {
                        cachedDefaultPattern = "yy/MM/dd HH:mm";
                    } else {
                        int i = 8;
                        if (findWithFallback.getSize() >= 13) {
                            i = 8 + 4;
                        }
                        cachedDefaultPattern = SimpleFormatterImpl.formatRawPattern(findWithFallback.getString(i), 2, 2, findWithFallback.getString(3), findWithFallback.getString(7));
                    }
                } catch (MissingResourceException e) {
                    cachedDefaultPattern = "yy/MM/dd HH:mm";
                }
            }
            str = cachedDefaultPattern;
        }
        return str;
    }

    private void parseAmbiguousDatesAsAfter(Date date) {
        this.defaultCenturyStart = date;
        this.calendar.setTime(date);
        this.defaultCenturyStartYear = this.calendar.get(1);
    }

    private void initializeDefaultCenturyStart(long j) {
        this.defaultCenturyBase = j;
        Calendar calendar = (Calendar) this.calendar.clone();
        calendar.setTimeInMillis(j);
        calendar.add(1, -80);
        this.defaultCenturyStart = calendar.getTime();
        this.defaultCenturyStartYear = calendar.get(1);
    }

    private Date getDefaultCenturyStart() {
        if (this.defaultCenturyStart == null) {
            initializeDefaultCenturyStart(this.defaultCenturyBase);
        }
        return this.defaultCenturyStart;
    }

    private int getDefaultCenturyStartYear() {
        if (this.defaultCenturyStart == null) {
            initializeDefaultCenturyStart(this.defaultCenturyBase);
        }
        return this.defaultCenturyStartYear;
    }

    @Override // com.ibm.icu.text.DateFormat
    public void setContext(DisplayContext displayContext) {
        super.setContext(displayContext);
        if (this.capitalizationBrkIter != null) {
            return;
        }
        if (displayContext == DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE || displayContext == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU || displayContext == DisplayContext.CAPITALIZATION_FOR_STANDALONE) {
            this.capitalizationBrkIter = BreakIterator.getSentenceInstance(this.locale);
        }
    }

    @Override // com.ibm.icu.text.DateFormat
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = null;
        if (calendar != this.calendar && !calendar.getType().equals(this.calendar.getType())) {
            this.calendar.setTimeInMillis(calendar.getTimeInMillis());
            timeZone = this.calendar.getTimeZone();
            this.calendar.setTimeZone(calendar.getTimeZone());
            calendar = this.calendar;
        }
        StringBuffer format = format(calendar, getContext(DisplayContext.Type.CAPITALIZATION), stringBuffer, fieldPosition, null);
        if (timeZone != null) {
            this.calendar.setTimeZone(timeZone);
        }
        return format;
    }

    private StringBuffer format(Calendar calendar, DisplayContext displayContext, StringBuffer stringBuffer, FieldPosition fieldPosition, List<FieldPosition> list) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        Object[] patternItems2 = getPatternItems();
        for (int i = 0; i < patternItems2.length; i++) {
            if (patternItems2[i] instanceof String) {
                stringBuffer.append((String) patternItems2[i]);
            } else {
                PatternItem patternItem = (PatternItem) patternItems2[i];
                int i2 = 0;
                if (list != null) {
                    i2 = stringBuffer.length();
                }
                if (this.useFastFormat) {
                    subFormat(stringBuffer, patternItem.type, patternItem.length, stringBuffer.length(), i, displayContext, fieldPosition, calendar);
                } else {
                    stringBuffer.append(subFormat(patternItem.type, patternItem.length, stringBuffer.length(), i, displayContext, fieldPosition, calendar));
                }
                if (list != null) {
                    int length = stringBuffer.length();
                    if (length - i2 > 0) {
                        FieldPosition fieldPosition2 = new FieldPosition(patternCharToDateFormatField(patternItem.type));
                        fieldPosition2.setBeginIndex(i2);
                        fieldPosition2.setEndIndex(length);
                        list.add(fieldPosition2);
                    }
                }
            }
        }
        return stringBuffer;
    }

    private static int getIndexFromChar(char c) {
        if (c < PATTERN_CHAR_TO_INDEX.length) {
            return PATTERN_CHAR_TO_INDEX[c & 255];
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public DateFormat.Field patternCharToDateFormatField(char c) {
        int indexFromChar = getIndexFromChar(c);
        if (indexFromChar != -1) {
            return PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[indexFromChar];
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String subFormat(char c, int i, int i2, int i3, DisplayContext displayContext, FieldPosition fieldPosition, Calendar calendar) {
        StringBuffer stringBuffer = new StringBuffer();
        subFormat(stringBuffer, c, i, i2, i3, displayContext, fieldPosition, calendar);
        return stringBuffer.toString();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013e  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void subFormat(java.lang.StringBuffer r29, char r30, int r31, int r32, int r33, com.ibm.icu.text.DisplayContext r34, java.text.FieldPosition r35, com.ibm.icu.util.Calendar r36) {
        /*
        // Method dump skipped, instructions count: 2416
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.SimpleDateFormat.subFormat(java.lang.StringBuffer, char, int, int, int, com.ibm.icu.text.DisplayContext, java.text.FieldPosition, com.ibm.icu.util.Calendar):void");
    }

    private static void safeAppend(String[] strArr, int i, StringBuffer stringBuffer) {
        if (strArr != null && i >= 0 && i < strArr.length) {
            stringBuffer.append(strArr[i]);
        }
    }

    private static void safeAppendWithMonthPattern(String[] strArr, int i, StringBuffer stringBuffer, String str) {
        if (strArr != null && i >= 0 && i < strArr.length) {
            if (str == null) {
                stringBuffer.append(strArr[i]);
            } else {
                stringBuffer.append(SimpleFormatterImpl.formatRawPattern(str, 1, 1, strArr[i]));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class PatternItem {
        final boolean isNumeric;
        final int length;
        final char type;

        PatternItem(char c, int i) {
            this.type = c;
            this.length = i;
            this.isNumeric = SimpleDateFormat.isNumeric(c, i);
        }
    }

    private Object[] getPatternItems() {
        if (this.patternItems != null) {
            return this.patternItems;
        }
        this.patternItems = PARSED_PATTERN_CACHE.get(this.pattern);
        if (this.patternItems != null) {
            return this.patternItems;
        }
        boolean z = false;
        boolean z2 = false;
        StringBuilder sb = new StringBuilder();
        char c = 0;
        int i = 1;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.pattern.length(); i2++) {
            char charAt = this.pattern.charAt(i2);
            if (charAt == '\'') {
                if (z) {
                    sb.append('\'');
                    z = false;
                } else {
                    z = true;
                    if (c != 0) {
                        arrayList.add(new PatternItem(c, i));
                        c = 0;
                    }
                }
                z2 = !z2;
            } else {
                z = false;
                if (z2) {
                    sb.append(charAt);
                } else if (!isSyntaxChar(charAt)) {
                    if (c != 0) {
                        arrayList.add(new PatternItem(c, i));
                        c = 0;
                    }
                    sb.append(charAt);
                } else if (charAt == c) {
                    i++;
                } else {
                    if (c != 0) {
                        arrayList.add(new PatternItem(c, i));
                    } else if (sb.length() > 0) {
                        arrayList.add(sb.toString());
                        sb.setLength(0);
                    }
                    c = charAt;
                    i = 1;
                }
            }
        }
        if (c != 0) {
            arrayList.add(new PatternItem(c, i));
        } else if (sb.length() > 0) {
            arrayList.add(sb.toString());
            sb.setLength(0);
        }
        this.patternItems = arrayList.toArray(new Object[arrayList.size()]);
        PARSED_PATTERN_CACHE.put(this.pattern, this.patternItems);
        return this.patternItems;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void zeroPaddingNumber(NumberFormat numberFormat, StringBuffer stringBuffer, int i, int i2, int i3) {
        if (!this.useLocalZeroPaddingNumberFormat || i < 0) {
            numberFormat.setMinimumIntegerDigits(i2);
            numberFormat.setMaximumIntegerDigits(i3);
            numberFormat.format((long) i, stringBuffer, new FieldPosition(-1));
            return;
        }
        fastZeroPaddingNumber(stringBuffer, i, i2, i3);
    }

    @Override // com.ibm.icu.text.DateFormat
    public void setNumberFormat(NumberFormat numberFormat) {
        super.setNumberFormat(numberFormat);
        initLocalZeroPaddingNumberFormat();
        initializeTimeZoneFormat(true);
        if (this.numberFormatters != null) {
            this.numberFormatters = null;
        }
        if (this.overrideMap != null) {
            this.overrideMap = null;
        }
    }

    private void initLocalZeroPaddingNumberFormat() {
        if (this.numberFormat instanceof DecimalFormat) {
            this.decDigits = ((DecimalFormat) this.numberFormat).getDecimalFormatSymbols().getDigits();
            this.useLocalZeroPaddingNumberFormat = true;
        } else if (this.numberFormat instanceof DateNumberFormat) {
            this.decDigits = ((DateNumberFormat) this.numberFormat).getDigits();
            this.useLocalZeroPaddingNumberFormat = true;
        } else {
            this.useLocalZeroPaddingNumberFormat = false;
        }
        if (this.useLocalZeroPaddingNumberFormat) {
            this.decimalBuf = new char[10];
        }
    }

    private void fastZeroPaddingNumber(StringBuffer stringBuffer, int i, int i2, int i3) {
        int length = this.decimalBuf.length < i3 ? this.decimalBuf.length : i3;
        int i4 = length - 1;
        while (true) {
            this.decimalBuf[i4] = this.decDigits[i % 10];
            i /= 10;
            if (i4 == 0 || i == 0) {
                break;
            }
            i4--;
        }
        int i5 = i2 - (length - i4);
        while (i5 > 0 && i4 > 0) {
            i4--;
            this.decimalBuf[i4] = this.decDigits[0];
            i5--;
        }
        while (i5 > 0) {
            stringBuffer.append(this.decDigits[0]);
            i5--;
        }
        stringBuffer.append(this.decimalBuf, i4, length - i4);
    }

    /* access modifiers changed from: private */
    public static final boolean isNumeric(char c, int i) {
        return "ADdFgHhKkmrSsuWwYy".indexOf(c) >= 0 || (i <= 2 && "ceLMQq".indexOf(c) >= 0);
    }

    @Override // com.ibm.icu.text.DateFormat
    public void parse(String str, Calendar calendar, ParsePosition parsePosition) {
        TimeZoneTransition previousTransition;
        TimeZoneTransition nextTransition;
        int i;
        TimeZone timeZone = null;
        Calendar calendar2 = null;
        if (calendar != this.calendar && !calendar.getType().equals(this.calendar.getType())) {
            this.calendar.setTimeInMillis(calendar.getTimeInMillis());
            timeZone = this.calendar.getTimeZone();
            this.calendar.setTimeZone(calendar.getTimeZone());
            calendar2 = calendar;
            calendar = this.calendar;
        }
        int index = parsePosition.getIndex();
        if (index < 0) {
            parsePosition.setErrorIndex(0);
            return;
        }
        Output<DayPeriodRules.DayPeriod> output = new Output<>(null);
        Output<TimeZoneFormat.TimeType> output2 = new Output<>(TimeZoneFormat.TimeType.UNKNOWN);
        boolean[] zArr = {false};
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        MessageFormat messageFormat = null;
        if (this.formatData.leapMonthPatterns != null && this.formatData.leapMonthPatterns.length >= 7) {
            messageFormat = new MessageFormat(this.formatData.leapMonthPatterns[6], this.locale);
        }
        Object[] patternItems2 = getPatternItems();
        int i5 = 0;
        while (i5 < patternItems2.length) {
            if (patternItems2[i5] instanceof PatternItem) {
                PatternItem patternItem = (PatternItem) patternItems2[i5];
                if (patternItem.isNumeric && i2 == -1 && i5 + 1 < patternItems2.length && (patternItems2[i5 + 1] instanceof PatternItem) && ((PatternItem) patternItems2[i5 + 1]).isNumeric) {
                    i2 = i5;
                    i3 = patternItem.length;
                    i4 = index;
                }
                if (i2 != -1) {
                    int i6 = patternItem.length;
                    if (i2 == i5) {
                        i6 = i3;
                    }
                    index = subParse(str, index, patternItem.type, i6, true, false, zArr, calendar, messageFormat, output2);
                    if (index < 0) {
                        i3--;
                        if (i3 == 0) {
                            parsePosition.setIndex(index);
                            parsePosition.setErrorIndex(index);
                            if (timeZone != null) {
                                this.calendar.setTimeZone(timeZone);
                                return;
                            }
                            return;
                        }
                        i5 = i2;
                        index = i4;
                    }
                } else if (patternItem.type != 'l') {
                    i2 = -1;
                    index = subParse(str, index, patternItem.type, patternItem.length, false, true, zArr, calendar, messageFormat, output2, output);
                    if (index < 0) {
                        if (index == -32000) {
                            index = index;
                            if (i5 + 1 < patternItems2.length) {
                                try {
                                    String str2 = (String) patternItems2[i5 + 1];
                                    if (str2 == null) {
                                        str2 = (String) patternItems2[i5 + 1];
                                    }
                                    int length = str2.length();
                                    int i7 = 0;
                                    while (i7 < length && PatternProps.isWhiteSpace(str2.charAt(i7))) {
                                        i7++;
                                    }
                                    if (i7 == length) {
                                        i5++;
                                    }
                                } catch (ClassCastException e) {
                                    parsePosition.setIndex(index);
                                    parsePosition.setErrorIndex(index);
                                    if (timeZone != null) {
                                        this.calendar.setTimeZone(timeZone);
                                        return;
                                    }
                                    return;
                                }
                            }
                        } else {
                            parsePosition.setIndex(index);
                            parsePosition.setErrorIndex(index);
                            if (timeZone != null) {
                                this.calendar.setTimeZone(timeZone);
                                return;
                            }
                            return;
                        }
                    }
                }
            } else {
                i2 = -1;
                boolean[] zArr2 = new boolean[1];
                index = matchLiteral(str, index, patternItems2, i5, zArr2);
                if (!zArr2[0]) {
                    parsePosition.setIndex(index);
                    parsePosition.setErrorIndex(index);
                    if (timeZone != null) {
                        this.calendar.setTimeZone(timeZone);
                        return;
                    }
                    return;
                }
            }
            i5++;
        }
        if (index < str.length() && str.charAt(index) == '.' && getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_WHITESPACE) && patternItems2.length != 0) {
            Object obj = patternItems2[patternItems2.length - 1];
            if ((obj instanceof PatternItem) && !((PatternItem) obj).isNumeric) {
                index++;
            }
        }
        if (output.value != null) {
            DayPeriodRules instance = DayPeriodRules.getInstance(getLocale());
            if (calendar.isSet(10) || calendar.isSet(11)) {
                if (calendar.isSet(11)) {
                    i = calendar.get(11);
                } else {
                    i = calendar.get(10);
                    if (i == 0) {
                        i = 12;
                    }
                }
                if (!$assertionsDisabled && (0 > i || i > 23)) {
                    throw new AssertionError();
                } else if (i == 0 || (13 <= i && i <= 23)) {
                    calendar.set(11, i);
                } else {
                    if (i == 12) {
                        i = 0;
                    }
                    double midPointForDayPeriod = (((double) i) + (((double) calendar.get(12)) / 60.0d)) - instance.getMidPointForDayPeriod(output.value);
                    if (-6.0d > midPointForDayPeriod || midPointForDayPeriod >= 6.0d) {
                        calendar.set(9, 1);
                    } else {
                        calendar.set(9, 0);
                    }
                }
            } else {
                double midPointForDayPeriod2 = instance.getMidPointForDayPeriod(output.value);
                int i8 = (int) midPointForDayPeriod2;
                int i9 = midPointForDayPeriod2 - ((double) i8) > 0.0d ? 30 : 0;
                calendar.set(11, i8);
                calendar.set(12, i9);
            }
        }
        parsePosition.setIndex(index);
        try {
            T t = output2.value;
            if (zArr[0] || t != TimeZoneFormat.TimeType.UNKNOWN) {
                if (zArr[0] && ((Calendar) calendar.clone()).getTime().before(getDefaultCenturyStart())) {
                    calendar.set(1, getDefaultCenturyStartYear() + 100);
                }
                if (t != TimeZoneFormat.TimeType.UNKNOWN) {
                    Calendar calendar3 = (Calendar) calendar.clone();
                    TimeZone timeZone2 = calendar3.getTimeZone();
                    BasicTimeZone basicTimeZone = null;
                    if (timeZone2 instanceof BasicTimeZone) {
                        basicTimeZone = (BasicTimeZone) timeZone2;
                    }
                    calendar3.set(15, 0);
                    calendar3.set(16, 0);
                    long timeInMillis = calendar3.getTimeInMillis();
                    int[] iArr = new int[2];
                    if (basicTimeZone == null) {
                        timeZone2.getOffset(timeInMillis, true, iArr);
                        if ((t == TimeZoneFormat.TimeType.STANDARD && iArr[1] != 0) || (t == TimeZoneFormat.TimeType.DAYLIGHT && iArr[1] == 0)) {
                            timeZone2.getOffset(timeInMillis - 86400000, true, iArr);
                        }
                    } else if (t == TimeZoneFormat.TimeType.STANDARD) {
                        basicTimeZone.getOffsetFromLocal(timeInMillis, 1, 1, iArr);
                    } else {
                        basicTimeZone.getOffsetFromLocal(timeInMillis, 3, 3, iArr);
                    }
                    int i10 = iArr[1];
                    if (t == TimeZoneFormat.TimeType.STANDARD) {
                        if (iArr[1] != 0) {
                            i10 = 0;
                        }
                    } else if (iArr[1] == 0) {
                        if (basicTimeZone != null) {
                            long j = timeInMillis + ((long) iArr[0]);
                            long j2 = j;
                            long j3 = j;
                            int i11 = 0;
                            int i12 = 0;
                            while (true) {
                                previousTransition = basicTimeZone.getPreviousTransition(j2, true);
                                if (previousTransition != null) {
                                    j2 = previousTransition.getTime() - 1;
                                    i11 = previousTransition.getFrom().getDSTSavings();
                                    if (i11 != 0) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            while (true) {
                                nextTransition = basicTimeZone.getNextTransition(j3, false);
                                if (nextTransition != null) {
                                    j3 = nextTransition.getTime();
                                    i12 = nextTransition.getTo().getDSTSavings();
                                    if (i12 != 0) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (previousTransition == null || nextTransition == null) {
                                if (previousTransition != null && i11 != 0) {
                                    i10 = i11;
                                } else if (nextTransition == null || i12 == 0) {
                                    i10 = basicTimeZone.getDSTSavings();
                                } else {
                                    i10 = i12;
                                }
                            } else if (j - j2 > j3 - j) {
                                i10 = i12;
                            } else {
                                i10 = i11;
                            }
                        } else {
                            i10 = timeZone2.getDSTSavings();
                        }
                        if (i10 == 0) {
                            i10 = 3600000;
                        }
                    }
                    calendar.set(15, iArr[0]);
                    calendar.set(16, i10);
                }
            }
            if (calendar2 != null) {
                calendar2.setTimeZone(calendar.getTimeZone());
                calendar2.setTimeInMillis(calendar.getTimeInMillis());
            }
            if (timeZone != null) {
                this.calendar.setTimeZone(timeZone);
            }
        } catch (IllegalArgumentException e2) {
            parsePosition.setErrorIndex(index);
            parsePosition.setIndex(index);
            if (timeZone != null) {
                this.calendar.setTimeZone(timeZone);
            }
        }
    }

    private int matchLiteral(String str, int i, Object[] objArr, int i2, boolean[] zArr) {
        String str2 = (String) objArr[i2];
        int length = str2.length();
        int length2 = str.length();
        int i3 = 0;
        while (i3 < length && i < length2) {
            char charAt = str2.charAt(i3);
            char charAt2 = str.charAt(i);
            if (PatternProps.isWhiteSpace(charAt) && PatternProps.isWhiteSpace(charAt2)) {
                while (i3 + 1 < length && PatternProps.isWhiteSpace(str2.charAt(i3 + 1))) {
                    i3++;
                }
                while (i + 1 < length2 && PatternProps.isWhiteSpace(str.charAt(i + 1))) {
                    i++;
                }
            } else if (charAt != charAt2) {
                if (charAt2 != '.' || i != i || 0 >= i2 || !getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_WHITESPACE)) {
                    if ((charAt != ' ' && charAt != '.') || !getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_WHITESPACE)) {
                        if (i == i || !getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_PARTIAL_LITERAL_MATCH)) {
                            break;
                        }
                        i3++;
                    } else {
                        i3++;
                    }
                } else {
                    Object obj = objArr[i2 - 1];
                    if (!(obj instanceof PatternItem) || ((PatternItem) obj).isNumeric) {
                        break;
                    }
                    i++;
                }
            }
            i3++;
            i++;
        }
        zArr[0] = i3 == length;
        if (zArr[0] || !getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_WHITESPACE) || 0 >= i2 || i2 >= objArr.length - 1 || i >= length2) {
            return i;
        }
        Object obj2 = objArr[i2 - 1];
        Object obj3 = objArr[i2 + 1];
        if (!(obj2 instanceof PatternItem) || !(obj3 instanceof PatternItem)) {
            return i;
        }
        if (DATE_PATTERN_TYPE.contains(((PatternItem) obj2).type) == DATE_PATTERN_TYPE.contains(((PatternItem) obj3).type)) {
            return i;
        }
        int i4 = i;
        while (PatternProps.isWhiteSpace(str.charAt(i4))) {
            i4++;
        }
        zArr[0] = i4 > i;
        return i4;
    }

    /* access modifiers changed from: protected */
    public int matchString(String str, int i, int i2, String[] strArr, Calendar calendar) {
        return matchString(str, i, i2, strArr, null, calendar);
    }

    @Deprecated
    private int matchString(String str, int i, int i2, String[] strArr, String str2, Calendar calendar) {
        String formatRawPattern;
        int length;
        int regionMatchesWithOptionalDot;
        int regionMatchesWithOptionalDot2;
        int i3 = 0;
        int length2 = strArr.length;
        if (i2 == 7) {
            i3 = 1;
        }
        int i4 = 0;
        int i5 = -1;
        int i6 = 0;
        while (i3 < length2) {
            int length3 = strArr[i3].length();
            if (length3 > i4 && (regionMatchesWithOptionalDot2 = regionMatchesWithOptionalDot(str, i, strArr[i3], length3)) >= 0) {
                i5 = i3;
                i4 = regionMatchesWithOptionalDot2;
                i6 = 0;
            }
            if (str2 != null && (length = (formatRawPattern = SimpleFormatterImpl.formatRawPattern(str2, 1, 1, strArr[i3])).length()) > i4 && (regionMatchesWithOptionalDot = regionMatchesWithOptionalDot(str, i, formatRawPattern, length)) >= 0) {
                i5 = i3;
                i4 = regionMatchesWithOptionalDot;
                i6 = 1;
            }
            i3++;
        }
        if (i5 < 0) {
            return i ^ -1;
        }
        if (i2 >= 0) {
            if (i2 == 1) {
                i5++;
            }
            calendar.set(i2, i5);
            if (str2 != null) {
                calendar.set(22, i6);
            }
        }
        return i + i4;
    }

    private int regionMatchesWithOptionalDot(String str, int i, String str2, int i2) {
        if (str.regionMatches(true, i, str2, 0, i2)) {
            return i2;
        }
        if (str2.length() <= 0 || str2.charAt(str2.length() - 1) != '.' || !str.regionMatches(true, i, str2, 0, i2 - 1)) {
            return -1;
        }
        return i2 - 1;
    }

    /* access modifiers changed from: protected */
    public int matchQuarterString(String str, int i, int i2, String[] strArr, Calendar calendar) {
        int regionMatchesWithOptionalDot;
        int length = strArr.length;
        int i3 = 0;
        int i4 = -1;
        for (int i5 = 0; i5 < length; i5++) {
            int length2 = strArr[i5].length();
            if (length2 > i3 && (regionMatchesWithOptionalDot = regionMatchesWithOptionalDot(str, i, strArr[i5], length2)) >= 0) {
                i4 = i5;
                i3 = regionMatchesWithOptionalDot;
            }
        }
        if (i4 < 0) {
            return -i;
        }
        calendar.set(i2, i4 * 3);
        return i + i3;
    }

    private int matchDayPeriodString(String str, int i, String[] strArr, int i2, Output<DayPeriodRules.DayPeriod> output) {
        int length;
        int regionMatchesWithOptionalDot;
        int i3 = 0;
        int i4 = -1;
        for (int i5 = 0; i5 < i2; i5++) {
            if (strArr[i5] != null && (length = strArr[i5].length()) > i3 && (regionMatchesWithOptionalDot = regionMatchesWithOptionalDot(str, i, strArr[i5], length)) >= 0) {
                i4 = i5;
                i3 = regionMatchesWithOptionalDot;
            }
        }
        if (i4 < 0) {
            return -i;
        }
        output.value = (T) DayPeriodRules.DayPeriod.VALUES[i4];
        return i + i3;
    }

    private int subParse(String str, int i, char c, int i2, boolean z, boolean z2, boolean[] zArr, Calendar calendar, MessageFormat messageFormat, Output<TimeZoneFormat.TimeType> output) {
        return subParse(str, i, c, i2, z, z2, zArr, calendar, null, null, null);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Deprecated
    private int subParse(String str, int i, char c, int i2, boolean z, boolean z2, boolean[] zArr, Calendar calendar, MessageFormat messageFormat, Output<TimeZoneFormat.TimeType> output, Output<DayPeriodRules.DayPeriod> output2) {
        Number number;
        TimeZoneFormat.Style style;
        TimeZoneFormat.Style style2;
        TimeZoneFormat.Style style3;
        int matchString;
        int matchString2;
        int matchString3;
        int i3;
        Number number2 = null;
        int i4 = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        int indexFromChar = getIndexFromChar(c);
        if (indexFromChar == -1) {
            return i ^ -1;
        }
        NumberFormat numberFormat = getNumberFormat(c);
        int i5 = PATTERN_INDEX_TO_CALENDAR_FIELD[indexFromChar];
        if (messageFormat != null) {
            messageFormat.setFormatByArgumentIndex(0, numberFormat);
        }
        boolean z3 = calendar.getType().equals("chinese") || calendar.getType().equals("dangi");
        while (i < str.length()) {
            int charAt = UTF16.charAt(str, i);
            if (!UCharacter.isUWhiteSpace(charAt) || !PatternProps.isWhiteSpace(charAt)) {
                parsePosition.setIndex(i);
                if (indexFromChar == 4 || indexFromChar == 15 || ((indexFromChar == 2 && i2 <= 2) || indexFromChar == 26 || indexFromChar == 19 || indexFromChar == 25 || indexFromChar == 1 || indexFromChar == 18 || indexFromChar == 30 || ((indexFromChar == 0 && z3) || indexFromChar == 27 || indexFromChar == 28 || indexFromChar == 8))) {
                    boolean z4 = false;
                    if (messageFormat != null && (indexFromChar == 2 || indexFromChar == 26)) {
                        Object[] parse = messageFormat.parse(str, parsePosition);
                        if (parse == null || parsePosition.getIndex() <= i || !(parse[0] instanceof Number)) {
                            parsePosition.setIndex(i);
                            calendar.set(22, 0);
                        } else {
                            z4 = true;
                            number2 = (Number) parse[0];
                            calendar.set(22, 1);
                        }
                    }
                    if (!z4) {
                        if (!z) {
                            number2 = parseInt(str, parsePosition, z2, numberFormat);
                        } else if (i + i2 > str.length()) {
                            return i ^ -1;
                        } else {
                            number2 = parseInt(str, i2, parsePosition, z2, numberFormat);
                        }
                        if (number2 == null && !allowNumericFallback(indexFromChar)) {
                            return i ^ -1;
                        }
                    }
                    if (number2 != null) {
                        i4 = number2.intValue();
                    }
                }
                switch (indexFromChar) {
                    case 0:
                        if (z3) {
                            calendar.set(0, i4);
                            return parsePosition.getIndex();
                        }
                        if (i2 == 5) {
                            i3 = matchString(str, i, 0, this.formatData.narrowEras, null, calendar);
                        } else if (i2 == 4) {
                            i3 = matchString(str, i, 0, this.formatData.eraNames, null, calendar);
                        } else {
                            i3 = matchString(str, i, 0, this.formatData.eras, null, calendar);
                        }
                        if (i3 == (i ^ -1)) {
                            return -32000;
                        }
                        return i3;
                    case 1:
                    case 18:
                        if (this.override != null && ((this.override.compareTo("hebr") == 0 || this.override.indexOf("y=hebr") >= 0) && i4 < 1000)) {
                            i4 += 5000;
                        } else if (i2 == 2 && parsePosition.getIndex() - i == 2 && calendar.haveDefaultCentury() && UCharacter.isDigit(str.charAt(i)) && UCharacter.isDigit(str.charAt(i + 1))) {
                            int defaultCenturyStartYear2 = getDefaultCenturyStartYear() % 100;
                            zArr[0] = i4 == defaultCenturyStartYear2;
                            i4 += ((getDefaultCenturyStartYear() / 100) * 100) + (i4 < defaultCenturyStartYear2 ? 100 : 0);
                        }
                        calendar.set(i5, i4);
                        if (DelayedHebrewMonthCheck) {
                            if (!HebrewCalendar.isLeapYear(i4)) {
                                calendar.add(2, 1);
                            }
                            DelayedHebrewMonthCheck = false;
                        }
                        return parsePosition.getIndex();
                    case 2:
                    case 26:
                        if (i2 <= 2 || (number2 != null && getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC))) {
                            calendar.set(2, i4 - 1);
                            if (calendar.getType().equals("hebrew") && i4 >= 6) {
                                if (!calendar.isSet(1)) {
                                    DelayedHebrewMonthCheck = true;
                                } else if (!HebrewCalendar.isLeapYear(calendar.get(1))) {
                                    calendar.set(2, i4);
                                }
                            }
                            return parsePosition.getIndex();
                        }
                        boolean z5 = this.formatData.leapMonthPatterns != null && this.formatData.leapMonthPatterns.length >= 7;
                        int i6 = 0;
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 4) {
                            if (indexFromChar == 2) {
                                i6 = matchString(str, i, 2, this.formatData.months, z5 ? this.formatData.leapMonthPatterns[0] : null, calendar);
                            } else {
                                i6 = matchString(str, i, 2, this.formatData.standaloneMonths, z5 ? this.formatData.leapMonthPatterns[3] : null, calendar);
                            }
                            if (i6 > 0) {
                                return i6;
                            }
                        }
                        if (!getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) && i2 != 3) {
                            return i6;
                        }
                        if (indexFromChar == 2) {
                            return matchString(str, i, 2, this.formatData.shortMonths, z5 ? this.formatData.leapMonthPatterns[1] : null, calendar);
                        }
                        return matchString(str, i, 2, this.formatData.standaloneShortMonths, z5 ? this.formatData.leapMonthPatterns[4] : null, calendar);
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 16:
                    case 20:
                    case 21:
                    case 22:
                    case 34:
                    default:
                        if (!z) {
                            number = parseInt(str, parsePosition, z2, numberFormat);
                        } else if (i + i2 > str.length()) {
                            return -i;
                        } else {
                            number = parseInt(str, i2, parsePosition, z2, numberFormat);
                        }
                        if (number == null) {
                            return i ^ -1;
                        }
                        if (indexFromChar != 34) {
                            calendar.set(i5, number.intValue());
                        } else {
                            calendar.setRelatedYear(number.intValue());
                        }
                        return parsePosition.getIndex();
                    case 4:
                        if (i4 == calendar.getMaximum(11) + 1) {
                            i4 = 0;
                        }
                        calendar.set(11, i4);
                        return parsePosition.getIndex();
                    case 8:
                        int index = parsePosition.getIndex() - i;
                        if (index < 3) {
                            while (index < 3) {
                                i4 *= 10;
                                index++;
                            }
                        } else {
                            int i7 = 1;
                            while (index > 3) {
                                i7 *= 10;
                                index--;
                            }
                            i4 /= i7;
                        }
                        calendar.set(14, i4);
                        return parsePosition.getIndex();
                    case 9:
                        break;
                    case 14:
                        if ((this.formatData.ampmsNarrow == null || i2 < 5 || getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH)) && (matchString2 = matchString(str, i, 9, this.formatData.ampms, null, calendar)) > 0) {
                            return matchString2;
                        }
                        if (this.formatData.ampmsNarrow == null || ((i2 < 5 && !getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH)) || (matchString = matchString(str, i, 9, this.formatData.ampmsNarrow, null, calendar)) <= 0)) {
                            return i ^ -1;
                        }
                        return matchString;
                    case 15:
                        if (i4 == calendar.getLeastMaximum(10) + 1) {
                            i4 = 0;
                        }
                        calendar.set(10, i4);
                        return parsePosition.getIndex();
                    case 17:
                        TimeZone parse2 = tzFormat().parse(i2 < 4 ? TimeZoneFormat.Style.SPECIFIC_SHORT : TimeZoneFormat.Style.SPECIFIC_LONG, str, parsePosition, output);
                        if (parse2 == null) {
                            return i ^ -1;
                        }
                        calendar.setTimeZone(parse2);
                        return parsePosition.getIndex();
                    case 19:
                        if (i2 <= 2 || (number2 != null && getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC))) {
                            calendar.set(i5, i4);
                            return parsePosition.getIndex();
                        }
                    case 23:
                        TimeZone parse3 = tzFormat().parse(i2 < 4 ? TimeZoneFormat.Style.ISO_BASIC_LOCAL_FULL : i2 == 5 ? TimeZoneFormat.Style.ISO_EXTENDED_FULL : TimeZoneFormat.Style.LOCALIZED_GMT, str, parsePosition, output);
                        if (parse3 == null) {
                            return i ^ -1;
                        }
                        calendar.setTimeZone(parse3);
                        return parsePosition.getIndex();
                    case 24:
                        TimeZone parse4 = tzFormat().parse(i2 < 4 ? TimeZoneFormat.Style.GENERIC_SHORT : TimeZoneFormat.Style.GENERIC_LONG, str, parsePosition, output);
                        if (parse4 == null) {
                            return i ^ -1;
                        }
                        calendar.setTimeZone(parse4);
                        return parsePosition.getIndex();
                    case 25:
                        if (i2 == 1 || (number2 != null && getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC))) {
                            calendar.set(i5, i4);
                            return parsePosition.getIndex();
                        }
                        int i8 = 0;
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 4) {
                            int matchString4 = matchString(str, i, 7, this.formatData.standaloneWeekdays, null, calendar);
                            i8 = matchString4;
                            if (matchString4 > 0) {
                                return i8;
                            }
                        }
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 3) {
                            int matchString5 = matchString(str, i, 7, this.formatData.standaloneShortWeekdays, null, calendar);
                            i8 = matchString5;
                            if (matchString5 > 0) {
                                return i8;
                            }
                        }
                        if ((getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 6) && this.formatData.standaloneShorterWeekdays != null) {
                            return matchString(str, i, 7, this.formatData.standaloneShorterWeekdays, null, calendar);
                        }
                        return i8;
                    case 27:
                        if (i2 <= 2 || (number2 != null && getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC))) {
                            calendar.set(2, (i4 - 1) * 3);
                            return parsePosition.getIndex();
                        }
                        int i9 = 0;
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 4) {
                            int matchQuarterString = matchQuarterString(str, i, 2, this.formatData.quarters, calendar);
                            i9 = matchQuarterString;
                            if (matchQuarterString > 0) {
                                return i9;
                            }
                        }
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 3) {
                            return matchQuarterString(str, i, 2, this.formatData.shortQuarters, calendar);
                        }
                        return i9;
                    case 28:
                        if (i2 <= 2 || (number2 != null && getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC))) {
                            calendar.set(2, (i4 - 1) * 3);
                            return parsePosition.getIndex();
                        }
                        int i10 = 0;
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 4) {
                            int matchQuarterString2 = matchQuarterString(str, i, 2, this.formatData.standaloneQuarters, calendar);
                            i10 = matchQuarterString2;
                            if (matchQuarterString2 > 0) {
                                return i10;
                            }
                        }
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 3) {
                            return matchQuarterString(str, i, 2, this.formatData.standaloneShortQuarters, calendar);
                        }
                        return i10;
                    case 29:
                        switch (i2) {
                            case 1:
                                style3 = TimeZoneFormat.Style.ZONE_ID_SHORT;
                                break;
                            case 2:
                                style3 = TimeZoneFormat.Style.ZONE_ID;
                                break;
                            case 3:
                                style3 = TimeZoneFormat.Style.EXEMPLAR_LOCATION;
                                break;
                            default:
                                style3 = TimeZoneFormat.Style.GENERIC_LOCATION;
                                break;
                        }
                        TimeZone parse5 = tzFormat().parse(style3, str, parsePosition, output);
                        if (parse5 == null) {
                            return i ^ -1;
                        }
                        calendar.setTimeZone(parse5);
                        return parsePosition.getIndex();
                    case 30:
                        if (this.formatData.shortYearNames != null && (matchString3 = matchString(str, i, 1, this.formatData.shortYearNames, null, calendar)) > 0) {
                            return matchString3;
                        }
                        if (number2 == null || (!getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_ALLOW_NUMERIC) && this.formatData.shortYearNames != null && i4 <= this.formatData.shortYearNames.length)) {
                            return i ^ -1;
                        }
                        calendar.set(1, i4);
                        return parsePosition.getIndex();
                    case 31:
                        TimeZone parse6 = tzFormat().parse(i2 < 4 ? TimeZoneFormat.Style.LOCALIZED_GMT_SHORT : TimeZoneFormat.Style.LOCALIZED_GMT, str, parsePosition, output);
                        if (parse6 == null) {
                            return i ^ -1;
                        }
                        calendar.setTimeZone(parse6);
                        return parsePosition.getIndex();
                    case 32:
                        switch (i2) {
                            case 1:
                                style2 = TimeZoneFormat.Style.ISO_BASIC_SHORT;
                                break;
                            case 2:
                                style2 = TimeZoneFormat.Style.ISO_BASIC_FIXED;
                                break;
                            case 3:
                                style2 = TimeZoneFormat.Style.ISO_EXTENDED_FIXED;
                                break;
                            case 4:
                                style2 = TimeZoneFormat.Style.ISO_BASIC_FULL;
                                break;
                            default:
                                style2 = TimeZoneFormat.Style.ISO_EXTENDED_FULL;
                                break;
                        }
                        TimeZone parse7 = tzFormat().parse(style2, str, parsePosition, output);
                        if (parse7 == null) {
                            return i ^ -1;
                        }
                        calendar.setTimeZone(parse7);
                        return parsePosition.getIndex();
                    case 33:
                        switch (i2) {
                            case 1:
                                style = TimeZoneFormat.Style.ISO_BASIC_LOCAL_SHORT;
                                break;
                            case 2:
                                style = TimeZoneFormat.Style.ISO_BASIC_LOCAL_FIXED;
                                break;
                            case 3:
                                style = TimeZoneFormat.Style.ISO_EXTENDED_LOCAL_FIXED;
                                break;
                            case 4:
                                style = TimeZoneFormat.Style.ISO_BASIC_LOCAL_FULL;
                                break;
                            default:
                                style = TimeZoneFormat.Style.ISO_EXTENDED_LOCAL_FULL;
                                break;
                        }
                        TimeZone parse8 = tzFormat().parse(style, str, parsePosition, output);
                        if (parse8 == null) {
                            return i ^ -1;
                        }
                        calendar.setTimeZone(parse8);
                        return parsePosition.getIndex();
                    case 35:
                        int subParse = subParse(str, i, 'a', i2, z, z2, zArr, calendar, messageFormat, output, output2);
                        if (subParse > 0) {
                            return subParse;
                        }
                        int i11 = 0;
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 3) {
                            int matchDayPeriodString = matchDayPeriodString(str, i, this.formatData.abbreviatedDayPeriods, 2, output2);
                            i11 = matchDayPeriodString;
                            if (matchDayPeriodString > 0) {
                                return i11;
                            }
                        }
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 4) {
                            int matchDayPeriodString2 = matchDayPeriodString(str, i, this.formatData.wideDayPeriods, 2, output2);
                            i11 = matchDayPeriodString2;
                            if (matchDayPeriodString2 > 0) {
                                return i11;
                            }
                        }
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 4) {
                            int matchDayPeriodString3 = matchDayPeriodString(str, i, this.formatData.narrowDayPeriods, 2, output2);
                            i11 = matchDayPeriodString3;
                            if (matchDayPeriodString3 > 0) {
                                return i11;
                            }
                        }
                        return i11;
                    case 36:
                        int i12 = 0;
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 3) {
                            int matchDayPeriodString4 = matchDayPeriodString(str, i, this.formatData.abbreviatedDayPeriods, this.formatData.abbreviatedDayPeriods.length, output2);
                            i12 = matchDayPeriodString4;
                            if (matchDayPeriodString4 > 0) {
                                return i12;
                            }
                        }
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 4) {
                            int matchDayPeriodString5 = matchDayPeriodString(str, i, this.formatData.wideDayPeriods, this.formatData.wideDayPeriods.length, output2);
                            i12 = matchDayPeriodString5;
                            if (matchDayPeriodString5 > 0) {
                                return i12;
                            }
                        }
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 4) {
                            int matchDayPeriodString6 = matchDayPeriodString(str, i, this.formatData.narrowDayPeriods, this.formatData.narrowDayPeriods.length, output2);
                            i12 = matchDayPeriodString6;
                            if (matchDayPeriodString6 > 0) {
                                return i12;
                            }
                        }
                        return i12;
                    case 37:
                        ArrayList arrayList = new ArrayList(3);
                        arrayList.add(this.formatData.getTimeSeparatorString());
                        if (!this.formatData.getTimeSeparatorString().equals(":")) {
                            arrayList.add(":");
                        }
                        if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_PARTIAL_LITERAL_MATCH) && !this.formatData.getTimeSeparatorString().equals(".")) {
                            arrayList.add(".");
                        }
                        return matchString(str, i, -1, (String[]) arrayList.toArray(new String[0]), calendar);
                }
                int i13 = 0;
                if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 4) {
                    int matchString6 = matchString(str, i, 7, this.formatData.weekdays, null, calendar);
                    i13 = matchString6;
                    if (matchString6 > 0) {
                        return i13;
                    }
                }
                if (getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 3) {
                    int matchString7 = matchString(str, i, 7, this.formatData.shortWeekdays, null, calendar);
                    i13 = matchString7;
                    if (matchString7 > 0) {
                        return i13;
                    }
                }
                if ((getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 6) && this.formatData.shorterWeekdays != null) {
                    int matchString8 = matchString(str, i, 7, this.formatData.shorterWeekdays, null, calendar);
                    i13 = matchString8;
                    if (matchString8 > 0) {
                        return i13;
                    }
                }
                if ((getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_MULTIPLE_PATTERNS_FOR_MATCH) || i2 == 5) && this.formatData.narrowWeekdays != null) {
                    int matchString9 = matchString(str, i, 7, this.formatData.narrowWeekdays, null, calendar);
                    i13 = matchString9;
                    if (matchString9 > 0) {
                        return i13;
                    }
                }
                return i13;
            }
            i += UTF16.getCharCount(charAt);
        }
        return i ^ -1;
    }

    private boolean allowNumericFallback(int i) {
        if (i == 26 || i == 19 || i == 25 || i == 30 || i == 27 || i == 28) {
            return true;
        }
        return false;
    }

    private Number parseInt(String str, ParsePosition parsePosition, boolean z, NumberFormat numberFormat) {
        return parseInt(str, -1, parsePosition, z, numberFormat);
    }

    private Number parseInt(String str, int i, ParsePosition parsePosition, boolean z, NumberFormat numberFormat) {
        Number number;
        int index;
        int index2 = parsePosition.getIndex();
        if (z) {
            number = numberFormat.parse(str, parsePosition);
        } else if (numberFormat instanceof DecimalFormat) {
            String negativePrefix = ((DecimalFormat) numberFormat).getNegativePrefix();
            ((DecimalFormat) numberFormat).setNegativePrefix("꬀");
            number = numberFormat.parse(str, parsePosition);
            ((DecimalFormat) numberFormat).setNegativePrefix(negativePrefix);
        } else {
            boolean z2 = numberFormat instanceof DateNumberFormat;
            if (z2) {
                ((DateNumberFormat) numberFormat).setParsePositiveOnly(true);
            }
            number = numberFormat.parse(str, parsePosition);
            if (z2) {
                ((DateNumberFormat) numberFormat).setParsePositiveOnly(false);
            }
        }
        if (i <= 0 || (index = parsePosition.getIndex() - index2) <= i) {
            return number;
        }
        double doubleValue = number.doubleValue();
        for (int i2 = index - i; i2 > 0; i2--) {
            doubleValue /= 10.0d;
        }
        parsePosition.setIndex(index2 + i);
        return Integer.valueOf((int) doubleValue);
    }

    public String toPattern() {
        return this.pattern;
    }

    public void applyPattern(String str) {
        this.pattern = str;
        parsePattern();
        setLocale(null, null);
        this.patternItems = null;
    }

    @Override // com.ibm.icu.text.DateFormat, java.text.Format, java.lang.Object
    public Object clone() {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) super.clone();
        simpleDateFormat.formatData = (DateFormatSymbols) this.formatData.clone();
        if (this.decimalBuf != null) {
            simpleDateFormat.decimalBuf = new char[10];
        }
        return simpleDateFormat;
    }

    @Override // com.ibm.icu.text.DateFormat, java.lang.Object
    public int hashCode() {
        return this.pattern.hashCode();
    }

    @Override // com.ibm.icu.text.DateFormat, java.lang.Object
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) obj;
        return this.pattern.equals(simpleDateFormat.pattern) && this.formatData.equals(simpleDateFormat.formatData);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        if (this.defaultCenturyStart == null) {
            initializeDefaultCenturyStart(this.defaultCenturyBase);
        }
        initializeTimeZoneFormat(false);
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(getContext(DisplayContext.Type.CAPITALIZATION).value());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = this.serialVersionOnStream > 1 ? objectInputStream.readInt() : -1;
        if (this.serialVersionOnStream < 1) {
            this.defaultCenturyBase = System.currentTimeMillis();
        } else {
            parseAmbiguousDatesAsAfter(this.defaultCenturyStart);
        }
        this.serialVersionOnStream = 2;
        this.locale = getLocale(ULocale.VALID_LOCALE);
        if (this.locale == null) {
            this.locale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        initLocalZeroPaddingNumberFormat();
        setContext(DisplayContext.CAPITALIZATION_NONE);
        if (readInt >= 0) {
            DisplayContext[] values = DisplayContext.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                DisplayContext displayContext = values[i];
                if (displayContext.value() == readInt) {
                    setContext(displayContext);
                    break;
                }
                i++;
            }
        }
        if (!getBooleanAttribute(DateFormat.BooleanAttribute.PARSE_PARTIAL_MATCH)) {
            setBooleanAttribute(DateFormat.BooleanAttribute.PARSE_PARTIAL_LITERAL_MATCH, false);
        }
        parsePattern();
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        Calendar calendar = this.calendar;
        if (obj instanceof Calendar) {
            calendar = (Calendar) obj;
        } else if (obj instanceof Date) {
            this.calendar.setTime((Date) obj);
        } else if (obj instanceof Number) {
            this.calendar.setTimeInMillis(((Number) obj).longValue());
        } else {
            throw new IllegalArgumentException("Cannot format given Object as a Date");
        }
        StringBuffer stringBuffer = new StringBuffer();
        FieldPosition fieldPosition = new FieldPosition(0);
        ArrayList arrayList = new ArrayList();
        format(calendar, getContext(DisplayContext.Type.CAPITALIZATION), stringBuffer, fieldPosition, arrayList);
        AttributedString attributedString = new AttributedString(stringBuffer.toString());
        for (int i = 0; i < arrayList.size(); i++) {
            FieldPosition fieldPosition2 = arrayList.get(i);
            Format.Field fieldAttribute = fieldPosition2.getFieldAttribute();
            attributedString.addAttribute(fieldAttribute, fieldAttribute, fieldPosition2.getBeginIndex(), fieldPosition2.getEndIndex());
        }
        return attributedString.getIterator();
    }

    /* access modifiers changed from: package-private */
    public ULocale getLocale() {
        return this.locale;
    }

    public NumberFormat getNumberFormat(char c) {
        Character valueOf = Character.valueOf(c);
        if (this.overrideMap == null || !this.overrideMap.containsKey(valueOf)) {
            return this.numberFormat;
        }
        return this.numberFormatters.get(this.overrideMap.get(valueOf).toString());
    }

    private void initNumberFormatters(ULocale uLocale) {
        this.numberFormatters = new HashMap<>();
        this.overrideMap = new HashMap<>();
        processOverrideString(uLocale, this.override);
    }

    private void processOverrideString(ULocale uLocale, String str) {
        int i;
        boolean z;
        String str2;
        if (str != null && str.length() != 0) {
            int i2 = 0;
            boolean z2 = true;
            while (z2) {
                int indexOf = str.indexOf(";", i2);
                if (indexOf == -1) {
                    z2 = false;
                    i = str.length();
                } else {
                    i = indexOf;
                }
                String substring = str.substring(i2, i);
                int indexOf2 = substring.indexOf("=");
                if (indexOf2 == -1) {
                    str2 = substring;
                    z = true;
                } else {
                    str2 = substring.substring(indexOf2 + 1);
                    this.overrideMap.put(Character.valueOf(substring.charAt(0)), str2);
                    z = false;
                }
                NumberFormat createInstance = NumberFormat.createInstance(new ULocale(uLocale.getBaseName() + "@numbers=" + str2), 0);
                createInstance.setGroupingUsed(false);
                if (z) {
                    setNumberFormat(createInstance);
                } else {
                    this.useLocalZeroPaddingNumberFormat = false;
                }
                if (!z && !this.numberFormatters.containsKey(str2)) {
                    this.numberFormatters.put(str2, createInstance);
                }
                i2 = indexOf + 1;
            }
        }
    }

    private void parsePattern() {
        this.hasMinute = false;
        this.hasSecond = false;
        boolean z = false;
        for (int i = 0; i < this.pattern.length(); i++) {
            char charAt = this.pattern.charAt(i);
            if (charAt == '\'') {
                z = !z;
            }
            if (!z) {
                if (charAt == 'm') {
                    this.hasMinute = true;
                }
                if (charAt == 's') {
                    this.hasSecond = true;
                }
            }
        }
    }
}
