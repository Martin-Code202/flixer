package com.ibm.icu.text;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.CalendarUtil;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.ICUException;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;
public class DateFormatSymbols implements Serializable, Cloneable {
    private static final String[][] CALENDAR_CLASSES = {new String[]{"GregorianCalendar", "gregorian"}, new String[]{"JapaneseCalendar", "japanese"}, new String[]{"BuddhistCalendar", "buddhist"}, new String[]{"TaiwanCalendar", "roc"}, new String[]{"PersianCalendar", "persian"}, new String[]{"IslamicCalendar", "islamic"}, new String[]{"HebrewCalendar", "hebrew"}, new String[]{"ChineseCalendar", "chinese"}, new String[]{"IndianCalendar", "indian"}, new String[]{"CopticCalendar", "coptic"}, new String[]{"EthiopicCalendar", "ethiopic"}};
    private static final String[] DAY_PERIOD_KEYS = {"midnight", "noon", "morning1", "afternoon1", "evening1", "night1", "morning2", "afternoon2", "evening2", "night2"};
    private static CacheBase<String, DateFormatSymbols, ULocale> DFSCACHE = new SoftCache<String, DateFormatSymbols, ULocale>() { // from class: com.ibm.icu.text.DateFormatSymbols.1
        /* access modifiers changed from: protected */
        public DateFormatSymbols createInstance(String str, ULocale uLocale) {
            int indexOf = str.indexOf(43) + 1;
            int indexOf2 = str.indexOf(43, indexOf);
            if (indexOf2 < 0) {
                indexOf2 = str.length();
            }
            return new DateFormatSymbols(uLocale, null, str.substring(indexOf, indexOf2));
        }
    };
    private static final String[] LEAP_MONTH_PATTERNS_PATHS = new String[7];
    private static final Map<String, CapitalizationContextUsage> contextUsageTypeMap = new HashMap();
    private static final long serialVersionUID = -5987973545549424702L;
    String[] abbreviatedDayPeriods;
    private ULocale actualLocale;
    String[] ampms;
    String[] ampmsNarrow;
    Map<CapitalizationContextUsage, boolean[]> capitalization;
    String[] eraNames;
    String[] eras;
    String[] leapMonthPatterns;
    String localPatternChars;
    String[] months;
    String[] narrowDayPeriods;
    String[] narrowEras;
    String[] narrowMonths;
    String[] narrowWeekdays;
    String[] quarters;
    private ULocale requestedLocale;
    String[] shortMonths;
    String[] shortQuarters;
    String[] shortWeekdays;
    String[] shortYearNames;
    String[] shortZodiacNames;
    String[] shorterWeekdays;
    String[] standaloneAbbreviatedDayPeriods;
    String[] standaloneMonths;
    String[] standaloneNarrowDayPeriods;
    String[] standaloneNarrowMonths;
    String[] standaloneNarrowWeekdays;
    String[] standaloneQuarters;
    String[] standaloneShortMonths;
    String[] standaloneShortQuarters;
    String[] standaloneShortWeekdays;
    String[] standaloneShorterWeekdays;
    String[] standaloneWeekdays;
    String[] standaloneWideDayPeriods;
    private String timeSeparator;
    private ULocale validLocale;
    String[] weekdays;
    String[] wideDayPeriods;
    private String[][] zoneStrings;

    /* access modifiers changed from: package-private */
    public enum CapitalizationContextUsage {
        OTHER,
        MONTH_FORMAT,
        MONTH_STANDALONE,
        MONTH_NARROW,
        DAY_FORMAT,
        DAY_STANDALONE,
        DAY_NARROW,
        ERA_WIDE,
        ERA_ABBREV,
        ERA_NARROW,
        ZONE_LONG,
        ZONE_SHORT,
        METAZONE_LONG,
        METAZONE_SHORT
    }

    public DateFormatSymbols() {
        this(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public DateFormatSymbols(ULocale uLocale) {
        this.eras = null;
        this.eraNames = null;
        this.narrowEras = null;
        this.months = null;
        this.shortMonths = null;
        this.narrowMonths = null;
        this.standaloneMonths = null;
        this.standaloneShortMonths = null;
        this.standaloneNarrowMonths = null;
        this.weekdays = null;
        this.shortWeekdays = null;
        this.shorterWeekdays = null;
        this.narrowWeekdays = null;
        this.standaloneWeekdays = null;
        this.standaloneShortWeekdays = null;
        this.standaloneShorterWeekdays = null;
        this.standaloneNarrowWeekdays = null;
        this.ampms = null;
        this.ampmsNarrow = null;
        this.timeSeparator = null;
        this.shortQuarters = null;
        this.quarters = null;
        this.standaloneShortQuarters = null;
        this.standaloneQuarters = null;
        this.leapMonthPatterns = null;
        this.shortYearNames = null;
        this.shortZodiacNames = null;
        this.zoneStrings = null;
        this.localPatternChars = null;
        this.abbreviatedDayPeriods = null;
        this.wideDayPeriods = null;
        this.narrowDayPeriods = null;
        this.standaloneAbbreviatedDayPeriods = null;
        this.standaloneWideDayPeriods = null;
        this.standaloneNarrowDayPeriods = null;
        this.capitalization = null;
        initializeData(uLocale, CalendarUtil.getCalendarType(uLocale));
    }

    static {
        contextUsageTypeMap.put("month-format-except-narrow", CapitalizationContextUsage.MONTH_FORMAT);
        contextUsageTypeMap.put("month-standalone-except-narrow", CapitalizationContextUsage.MONTH_STANDALONE);
        contextUsageTypeMap.put("month-narrow", CapitalizationContextUsage.MONTH_NARROW);
        contextUsageTypeMap.put("day-format-except-narrow", CapitalizationContextUsage.DAY_FORMAT);
        contextUsageTypeMap.put("day-standalone-except-narrow", CapitalizationContextUsage.DAY_STANDALONE);
        contextUsageTypeMap.put("day-narrow", CapitalizationContextUsage.DAY_NARROW);
        contextUsageTypeMap.put("era-name", CapitalizationContextUsage.ERA_WIDE);
        contextUsageTypeMap.put("era-abbr", CapitalizationContextUsage.ERA_ABBREV);
        contextUsageTypeMap.put("era-narrow", CapitalizationContextUsage.ERA_NARROW);
        contextUsageTypeMap.put("zone-long", CapitalizationContextUsage.ZONE_LONG);
        contextUsageTypeMap.put("zone-short", CapitalizationContextUsage.ZONE_SHORT);
        contextUsageTypeMap.put("metazone-long", CapitalizationContextUsage.METAZONE_LONG);
        contextUsageTypeMap.put("metazone-short", CapitalizationContextUsage.METAZONE_SHORT);
        LEAP_MONTH_PATTERNS_PATHS[0] = "monthPatterns/format/wide";
        LEAP_MONTH_PATTERNS_PATHS[1] = "monthPatterns/format/abbreviated";
        LEAP_MONTH_PATTERNS_PATHS[2] = "monthPatterns/format/narrow";
        LEAP_MONTH_PATTERNS_PATHS[3] = "monthPatterns/stand-alone/wide";
        LEAP_MONTH_PATTERNS_PATHS[4] = "monthPatterns/stand-alone/abbreviated";
        LEAP_MONTH_PATTERNS_PATHS[5] = "monthPatterns/stand-alone/narrow";
        LEAP_MONTH_PATTERNS_PATHS[6] = "monthPatterns/numeric/all";
    }

    @Deprecated
    public String getTimeSeparatorString() {
        return this.timeSeparator;
    }

    @Deprecated
    public void setTimeSeparatorString(String str) {
        this.timeSeparator = str;
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            return (DateFormatSymbols) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.requestedLocale.toString().hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DateFormatSymbols dateFormatSymbols = (DateFormatSymbols) obj;
        return Utility.arrayEquals(this.eras, dateFormatSymbols.eras) && Utility.arrayEquals(this.eraNames, dateFormatSymbols.eraNames) && Utility.arrayEquals(this.months, dateFormatSymbols.months) && Utility.arrayEquals(this.shortMonths, dateFormatSymbols.shortMonths) && Utility.arrayEquals(this.narrowMonths, dateFormatSymbols.narrowMonths) && Utility.arrayEquals(this.standaloneMonths, dateFormatSymbols.standaloneMonths) && Utility.arrayEquals(this.standaloneShortMonths, dateFormatSymbols.standaloneShortMonths) && Utility.arrayEquals(this.standaloneNarrowMonths, dateFormatSymbols.standaloneNarrowMonths) && Utility.arrayEquals(this.weekdays, dateFormatSymbols.weekdays) && Utility.arrayEquals(this.shortWeekdays, dateFormatSymbols.shortWeekdays) && Utility.arrayEquals(this.shorterWeekdays, dateFormatSymbols.shorterWeekdays) && Utility.arrayEquals(this.narrowWeekdays, dateFormatSymbols.narrowWeekdays) && Utility.arrayEquals(this.standaloneWeekdays, dateFormatSymbols.standaloneWeekdays) && Utility.arrayEquals(this.standaloneShortWeekdays, dateFormatSymbols.standaloneShortWeekdays) && Utility.arrayEquals(this.standaloneShorterWeekdays, dateFormatSymbols.standaloneShorterWeekdays) && Utility.arrayEquals(this.standaloneNarrowWeekdays, dateFormatSymbols.standaloneNarrowWeekdays) && Utility.arrayEquals(this.ampms, dateFormatSymbols.ampms) && Utility.arrayEquals(this.ampmsNarrow, dateFormatSymbols.ampmsNarrow) && Utility.arrayEquals(this.abbreviatedDayPeriods, dateFormatSymbols.abbreviatedDayPeriods) && Utility.arrayEquals(this.wideDayPeriods, dateFormatSymbols.wideDayPeriods) && Utility.arrayEquals(this.narrowDayPeriods, dateFormatSymbols.narrowDayPeriods) && Utility.arrayEquals(this.standaloneAbbreviatedDayPeriods, dateFormatSymbols.standaloneAbbreviatedDayPeriods) && Utility.arrayEquals(this.standaloneWideDayPeriods, dateFormatSymbols.standaloneWideDayPeriods) && Utility.arrayEquals(this.standaloneNarrowDayPeriods, dateFormatSymbols.standaloneNarrowDayPeriods) && Utility.arrayEquals(this.timeSeparator, dateFormatSymbols.timeSeparator) && arrayOfArrayEquals(this.zoneStrings, dateFormatSymbols.zoneStrings) && this.requestedLocale.getDisplayName().equals(dateFormatSymbols.requestedLocale.getDisplayName()) && Utility.arrayEquals(this.localPatternChars, dateFormatSymbols.localPatternChars);
    }

    /* access modifiers changed from: protected */
    public void initializeData(ULocale uLocale, String str) {
        String str2 = uLocale.getBaseName() + '+' + str;
        String keywordValue = uLocale.getKeywordValue("numbers");
        if (keywordValue != null && keywordValue.length() > 0) {
            str2 = str2 + '+' + keywordValue;
        }
        initializeData(DFSCACHE.getInstance(str2, uLocale));
    }

    /* access modifiers changed from: package-private */
    public void initializeData(DateFormatSymbols dateFormatSymbols) {
        this.eras = dateFormatSymbols.eras;
        this.eraNames = dateFormatSymbols.eraNames;
        this.narrowEras = dateFormatSymbols.narrowEras;
        this.months = dateFormatSymbols.months;
        this.shortMonths = dateFormatSymbols.shortMonths;
        this.narrowMonths = dateFormatSymbols.narrowMonths;
        this.standaloneMonths = dateFormatSymbols.standaloneMonths;
        this.standaloneShortMonths = dateFormatSymbols.standaloneShortMonths;
        this.standaloneNarrowMonths = dateFormatSymbols.standaloneNarrowMonths;
        this.weekdays = dateFormatSymbols.weekdays;
        this.shortWeekdays = dateFormatSymbols.shortWeekdays;
        this.shorterWeekdays = dateFormatSymbols.shorterWeekdays;
        this.narrowWeekdays = dateFormatSymbols.narrowWeekdays;
        this.standaloneWeekdays = dateFormatSymbols.standaloneWeekdays;
        this.standaloneShortWeekdays = dateFormatSymbols.standaloneShortWeekdays;
        this.standaloneShorterWeekdays = dateFormatSymbols.standaloneShorterWeekdays;
        this.standaloneNarrowWeekdays = dateFormatSymbols.standaloneNarrowWeekdays;
        this.ampms = dateFormatSymbols.ampms;
        this.ampmsNarrow = dateFormatSymbols.ampmsNarrow;
        this.timeSeparator = dateFormatSymbols.timeSeparator;
        this.shortQuarters = dateFormatSymbols.shortQuarters;
        this.quarters = dateFormatSymbols.quarters;
        this.standaloneShortQuarters = dateFormatSymbols.standaloneShortQuarters;
        this.standaloneQuarters = dateFormatSymbols.standaloneQuarters;
        this.leapMonthPatterns = dateFormatSymbols.leapMonthPatterns;
        this.shortYearNames = dateFormatSymbols.shortYearNames;
        this.shortZodiacNames = dateFormatSymbols.shortZodiacNames;
        this.abbreviatedDayPeriods = dateFormatSymbols.abbreviatedDayPeriods;
        this.wideDayPeriods = dateFormatSymbols.wideDayPeriods;
        this.narrowDayPeriods = dateFormatSymbols.narrowDayPeriods;
        this.standaloneAbbreviatedDayPeriods = dateFormatSymbols.standaloneAbbreviatedDayPeriods;
        this.standaloneWideDayPeriods = dateFormatSymbols.standaloneWideDayPeriods;
        this.standaloneNarrowDayPeriods = dateFormatSymbols.standaloneNarrowDayPeriods;
        this.zoneStrings = dateFormatSymbols.zoneStrings;
        this.localPatternChars = dateFormatSymbols.localPatternChars;
        this.capitalization = dateFormatSymbols.capitalization;
        this.actualLocale = dateFormatSymbols.actualLocale;
        this.validLocale = dateFormatSymbols.validLocale;
        this.requestedLocale = dateFormatSymbols.requestedLocale;
    }

    /* access modifiers changed from: package-private */
    public static final class CalendarDataSink extends UResource.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = (!DateFormatSymbols.class.desiredAssertionStatus());
        List<String> aliasPathPairs = new ArrayList();
        private String aliasRelativePath;
        Map<String, String[]> arrays = new TreeMap();
        String currentCalendarType = null;
        Map<String, Map<String, String>> maps = new TreeMap();
        String nextCalendarType = null;
        private Set<String> resourcesToVisit;

        /* access modifiers changed from: package-private */
        public enum AliasType {
            SAME_CALENDAR,
            DIFFERENT_CALENDAR,
            GREGORIAN,
            NONE
        }

        CalendarDataSink() {
        }

        /* access modifiers changed from: package-private */
        public void visitAllResources() {
            this.resourcesToVisit = null;
        }

        /* access modifiers changed from: package-private */
        public void preEnumerate(String str) {
            this.currentCalendarType = str;
            this.nextCalendarType = null;
            this.aliasPathPairs.clear();
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            if ($assertionsDisabled || (this.currentCalendarType != null && !this.currentCalendarType.isEmpty())) {
                HashSet hashSet = null;
                UResource.Table table = value.getTable();
                for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                    String key2 = key.toString();
                    AliasType processAliasFromValue = processAliasFromValue(key2, value);
                    if (processAliasFromValue != AliasType.GREGORIAN) {
                        if (processAliasFromValue == AliasType.DIFFERENT_CALENDAR) {
                            if (hashSet == null) {
                                hashSet = new HashSet();
                            }
                            hashSet.add(this.aliasRelativePath);
                        } else if (processAliasFromValue == AliasType.SAME_CALENDAR) {
                            if (!this.arrays.containsKey(key2) && !this.maps.containsKey(key2)) {
                                this.aliasPathPairs.add(this.aliasRelativePath);
                                this.aliasPathPairs.add(key2);
                            }
                        } else if (this.resourcesToVisit == null || this.resourcesToVisit.isEmpty() || this.resourcesToVisit.contains(key2) || key2.equals("AmPmMarkersAbbr")) {
                            if (key2.startsWith("AmPmMarkers")) {
                                if (!key2.endsWith("%variant") && !this.arrays.containsKey(key2)) {
                                    this.arrays.put(key2, value.getStringArray());
                                }
                            } else if (key2.equals("eras") || key2.equals("dayNames") || key2.equals("monthNames") || key2.equals("quarters") || key2.equals("dayPeriod") || key2.equals("monthPatterns") || key2.equals("cyclicNameSets")) {
                                processResource(key2, key, value);
                            }
                        }
                    }
                }
                do {
                    boolean z2 = false;
                    int i2 = 0;
                    while (i2 < this.aliasPathPairs.size()) {
                        boolean z3 = false;
                        String str = this.aliasPathPairs.get(i2);
                        if (this.arrays.containsKey(str)) {
                            this.arrays.put(this.aliasPathPairs.get(i2 + 1), this.arrays.get(str));
                            z3 = true;
                        } else if (this.maps.containsKey(str)) {
                            this.maps.put(this.aliasPathPairs.get(i2 + 1), this.maps.get(str));
                            z3 = true;
                        }
                        if (z3) {
                            this.aliasPathPairs.remove(i2 + 1);
                            this.aliasPathPairs.remove(i2);
                            z2 = true;
                        } else {
                            i2 += 2;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                } while (!this.aliasPathPairs.isEmpty());
                if (hashSet != null) {
                    this.resourcesToVisit = hashSet;
                    return;
                }
                return;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        public void processResource(String str, UResource.Key key, UResource.Value value) {
            UResource.Table table = value.getTable();
            HashMap hashMap = null;
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (!key.endsWith("%variant")) {
                    String key2 = key.toString();
                    if (value.getType() == 0) {
                        if (i == 0) {
                            hashMap = new HashMap();
                            this.maps.put(str, hashMap);
                        }
                        if ($assertionsDisabled || hashMap != null) {
                            hashMap.put(key2, value.getString());
                        } else {
                            throw new AssertionError();
                        }
                    } else if ($assertionsDisabled || hashMap == null) {
                        String str2 = str + "/" + key2;
                        if ((!str2.startsWith("cyclicNameSets") || "cyclicNameSets/years/format/abbreviated".startsWith(str2) || "cyclicNameSets/zodiacs/format/abbreviated".startsWith(str2) || "cyclicNameSets/dayParts/format/abbreviated".startsWith(str2)) && !this.arrays.containsKey(str2) && !this.maps.containsKey(str2)) {
                            AliasType processAliasFromValue = processAliasFromValue(str2, value);
                            if (processAliasFromValue == AliasType.SAME_CALENDAR) {
                                this.aliasPathPairs.add(this.aliasRelativePath);
                                this.aliasPathPairs.add(str2);
                            } else if (!$assertionsDisabled && processAliasFromValue != AliasType.NONE) {
                                throw new AssertionError();
                            } else if (value.getType() == 8) {
                                this.arrays.put(str2, value.getStringArray());
                            } else if (value.getType() == 2) {
                                processResource(str2, key, value);
                            }
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
        }

        private AliasType processAliasFromValue(String str, UResource.Value value) {
            int indexOf;
            if (value.getType() != 3) {
                return AliasType.NONE;
            }
            String aliasString = value.getAliasString();
            if (aliasString.startsWith("/LOCALE/calendar/") && aliasString.length() > "/LOCALE/calendar/".length() && (indexOf = aliasString.indexOf(47, "/LOCALE/calendar/".length())) > "/LOCALE/calendar/".length()) {
                String substring = aliasString.substring("/LOCALE/calendar/".length(), indexOf);
                this.aliasRelativePath = aliasString.substring(indexOf + 1);
                if (this.currentCalendarType.equals(substring) && !str.equals(this.aliasRelativePath)) {
                    return AliasType.SAME_CALENDAR;
                }
                if (!this.currentCalendarType.equals(substring) && str.equals(this.aliasRelativePath)) {
                    if (substring.equals("gregorian")) {
                        return AliasType.GREGORIAN;
                    }
                    if (this.nextCalendarType == null || this.nextCalendarType.equals(substring)) {
                        this.nextCalendarType = substring;
                        return AliasType.DIFFERENT_CALENDAR;
                    }
                }
            }
            throw new ICUException("Malformed 'calendar' alias. Path: " + aliasString);
        }
    }

    private DateFormatSymbols(ULocale uLocale, ICUResourceBundle iCUResourceBundle, String str) {
        this.eras = null;
        this.eraNames = null;
        this.narrowEras = null;
        this.months = null;
        this.shortMonths = null;
        this.narrowMonths = null;
        this.standaloneMonths = null;
        this.standaloneShortMonths = null;
        this.standaloneNarrowMonths = null;
        this.weekdays = null;
        this.shortWeekdays = null;
        this.shorterWeekdays = null;
        this.narrowWeekdays = null;
        this.standaloneWeekdays = null;
        this.standaloneShortWeekdays = null;
        this.standaloneShorterWeekdays = null;
        this.standaloneNarrowWeekdays = null;
        this.ampms = null;
        this.ampmsNarrow = null;
        this.timeSeparator = null;
        this.shortQuarters = null;
        this.quarters = null;
        this.standaloneShortQuarters = null;
        this.standaloneQuarters = null;
        this.leapMonthPatterns = null;
        this.shortYearNames = null;
        this.shortZodiacNames = null;
        this.zoneStrings = null;
        this.localPatternChars = null;
        this.abbreviatedDayPeriods = null;
        this.wideDayPeriods = null;
        this.narrowDayPeriods = null;
        this.standaloneAbbreviatedDayPeriods = null;
        this.standaloneWideDayPeriods = null;
        this.standaloneNarrowDayPeriods = null;
        this.capitalization = null;
        initializeData(uLocale, iCUResourceBundle, str);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x03f2: APUT  (r0v167 boolean[] A[IMMUTABLE_TYPE]), (0 ??[int, short, byte, char]), (r0v170 boolean A[IMMUTABLE_TYPE]) */
    /* access modifiers changed from: protected */
    @Deprecated
    public void initializeData(ULocale uLocale, ICUResourceBundle iCUResourceBundle, String str) {
        ICUResourceBundle iCUResourceBundle2;
        CapitalizationContextUsage capitalizationContextUsage;
        Map<String, String> map;
        String str2;
        CalendarDataSink calendarDataSink = new CalendarDataSink();
        if (iCUResourceBundle == null) {
            iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", uLocale);
        }
        while (str != null) {
            ICUResourceBundle findWithFallback = iCUResourceBundle.findWithFallback("calendar/" + str);
            if (findWithFallback != null) {
                calendarDataSink.preEnumerate(str);
                findWithFallback.getAllItemsWithFallback("", calendarDataSink);
                if (str.equals("gregorian")) {
                    break;
                }
                str = calendarDataSink.nextCalendarType;
                if (str == null) {
                    str = "gregorian";
                    calendarDataSink.visitAllResources();
                }
            } else if (!"gregorian".equals(str)) {
                str = "gregorian";
                calendarDataSink.visitAllResources();
            } else {
                throw new MissingResourceException("The 'gregorian' calendar type wasn't found for the locale: " + uLocale.getBaseName(), getClass().getName(), "gregorian");
            }
        }
        Map<String, String[]> map2 = calendarDataSink.arrays;
        Map<String, Map<String, String>> map3 = calendarDataSink.maps;
        this.eras = map2.get("eras/abbreviated");
        this.eraNames = map2.get("eras/wide");
        this.narrowEras = map2.get("eras/narrow");
        this.months = map2.get("monthNames/format/wide");
        this.shortMonths = map2.get("monthNames/format/abbreviated");
        this.narrowMonths = map2.get("monthNames/format/narrow");
        this.standaloneMonths = map2.get("monthNames/stand-alone/wide");
        this.standaloneShortMonths = map2.get("monthNames/stand-alone/abbreviated");
        this.standaloneNarrowMonths = map2.get("monthNames/stand-alone/narrow");
        String[] strArr = map2.get("dayNames/format/wide");
        this.weekdays = new String[8];
        this.weekdays[0] = "";
        System.arraycopy(strArr, 0, this.weekdays, 1, strArr.length);
        String[] strArr2 = map2.get("dayNames/format/abbreviated");
        this.shortWeekdays = new String[8];
        this.shortWeekdays[0] = "";
        System.arraycopy(strArr2, 0, this.shortWeekdays, 1, strArr2.length);
        String[] strArr3 = map2.get("dayNames/format/short");
        this.shorterWeekdays = new String[8];
        this.shorterWeekdays[0] = "";
        System.arraycopy(strArr3, 0, this.shorterWeekdays, 1, strArr3.length);
        String[] strArr4 = map2.get("dayNames/format/narrow");
        if (strArr4 == null && (strArr4 = map2.get("dayNames/stand-alone/narrow")) == null && (strArr4 = map2.get("dayNames/format/abbreviated")) == null) {
            throw new MissingResourceException("Resource not found", getClass().getName(), "dayNames/format/abbreviated");
        }
        this.narrowWeekdays = new String[8];
        this.narrowWeekdays[0] = "";
        System.arraycopy(strArr4, 0, this.narrowWeekdays, 1, strArr4.length);
        String[] strArr5 = map2.get("dayNames/stand-alone/wide");
        this.standaloneWeekdays = new String[8];
        this.standaloneWeekdays[0] = "";
        System.arraycopy(strArr5, 0, this.standaloneWeekdays, 1, strArr5.length);
        String[] strArr6 = map2.get("dayNames/stand-alone/abbreviated");
        this.standaloneShortWeekdays = new String[8];
        this.standaloneShortWeekdays[0] = "";
        System.arraycopy(strArr6, 0, this.standaloneShortWeekdays, 1, strArr6.length);
        String[] strArr7 = map2.get("dayNames/stand-alone/short");
        this.standaloneShorterWeekdays = new String[8];
        this.standaloneShorterWeekdays[0] = "";
        System.arraycopy(strArr7, 0, this.standaloneShorterWeekdays, 1, strArr7.length);
        String[] strArr8 = map2.get("dayNames/stand-alone/narrow");
        this.standaloneNarrowWeekdays = new String[8];
        this.standaloneNarrowWeekdays[0] = "";
        System.arraycopy(strArr8, 0, this.standaloneNarrowWeekdays, 1, strArr8.length);
        this.ampms = map2.get("AmPmMarkers");
        this.ampmsNarrow = map2.get("AmPmMarkersNarrow");
        this.quarters = map2.get("quarters/format/wide");
        this.shortQuarters = map2.get("quarters/format/abbreviated");
        this.standaloneQuarters = map2.get("quarters/stand-alone/wide");
        this.standaloneShortQuarters = map2.get("quarters/stand-alone/abbreviated");
        this.abbreviatedDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/format/abbreviated"));
        this.wideDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/format/wide"));
        this.narrowDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/format/narrow"));
        this.standaloneAbbreviatedDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/stand-alone/abbreviated"));
        this.standaloneWideDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/stand-alone/wide"));
        this.standaloneNarrowDayPeriods = loadDayPeriodStrings(map3.get("dayPeriod/stand-alone/narrow"));
        for (int i = 0; i < 7; i++) {
            String str3 = LEAP_MONTH_PATTERNS_PATHS[i];
            if (!(str3 == null || (map = map3.get(str3)) == null || (str2 = map.get("leap")) == null)) {
                if (this.leapMonthPatterns == null) {
                    this.leapMonthPatterns = new String[7];
                }
                this.leapMonthPatterns[i] = str2;
            }
        }
        this.shortYearNames = map2.get("cyclicNameSets/years/format/abbreviated");
        this.shortZodiacNames = map2.get("cyclicNameSets/zodiacs/format/abbreviated");
        this.requestedLocale = uLocale;
        ICUResourceBundle iCUResourceBundle3 = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", uLocale);
        this.localPatternChars = "GyMdkHmsSEDFwWahKzYeugAZvcLQqVUOXxrbB";
        ULocale uLocale2 = iCUResourceBundle3.getULocale();
        setLocale(uLocale2, uLocale2);
        this.capitalization = new HashMap();
        boolean[] zArr = {false, false};
        CapitalizationContextUsage[] values = CapitalizationContextUsage.values();
        int length = values.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.capitalization.put(values[i2], zArr);
        }
        try {
            iCUResourceBundle2 = iCUResourceBundle3.getWithFallback("contextTransforms");
        } catch (MissingResourceException e) {
            iCUResourceBundle2 = null;
        }
        if (iCUResourceBundle2 != null) {
            UResourceBundleIterator iterator = iCUResourceBundle2.getIterator();
            while (iterator.hasNext()) {
                UResourceBundle next = iterator.next();
                int[] intVector = next.getIntVector();
                if (intVector.length >= 2 && (capitalizationContextUsage = contextUsageTypeMap.get(next.getKey())) != null) {
                    boolean[] zArr2 = new boolean[2];
                    zArr2[0] = intVector[0] != 0;
                    zArr2[1] = intVector[1] != 0;
                    this.capitalization.put(capitalizationContextUsage, zArr2);
                }
            }
        }
        NumberingSystem instance = NumberingSystem.getInstance(uLocale);
        try {
            setTimeSeparatorString(iCUResourceBundle3.getStringWithFallback("NumberElements/" + (instance == null ? "latn" : instance.getName()) + "/symbols/timeSeparator"));
        } catch (MissingResourceException e2) {
            setTimeSeparatorString(":");
        }
    }

    private static final boolean arrayOfArrayEquals(Object[][] objArr, Object[][] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr == null || objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        boolean z = true;
        int i = 0;
        while (i < objArr.length && (z = Utility.arrayEquals(objArr[i], (Object) objArr2[i]))) {
            i++;
        }
        return z;
    }

    private String[] loadDayPeriodStrings(Map<String, String> map) {
        String[] strArr = new String[DAY_PERIOD_KEYS.length];
        if (map != null) {
            for (int i = 0; i < DAY_PERIOD_KEYS.length; i++) {
                strArr[i] = map.get(DAY_PERIOD_KEYS[i]);
            }
        }
        return strArr;
    }

    public DateFormatSymbols(Calendar calendar, ULocale uLocale) {
        this.eras = null;
        this.eraNames = null;
        this.narrowEras = null;
        this.months = null;
        this.shortMonths = null;
        this.narrowMonths = null;
        this.standaloneMonths = null;
        this.standaloneShortMonths = null;
        this.standaloneNarrowMonths = null;
        this.weekdays = null;
        this.shortWeekdays = null;
        this.shorterWeekdays = null;
        this.narrowWeekdays = null;
        this.standaloneWeekdays = null;
        this.standaloneShortWeekdays = null;
        this.standaloneShorterWeekdays = null;
        this.standaloneNarrowWeekdays = null;
        this.ampms = null;
        this.ampmsNarrow = null;
        this.timeSeparator = null;
        this.shortQuarters = null;
        this.quarters = null;
        this.standaloneShortQuarters = null;
        this.standaloneQuarters = null;
        this.leapMonthPatterns = null;
        this.shortYearNames = null;
        this.shortZodiacNames = null;
        this.zoneStrings = null;
        this.localPatternChars = null;
        this.abbreviatedDayPeriods = null;
        this.wideDayPeriods = null;
        this.narrowDayPeriods = null;
        this.standaloneAbbreviatedDayPeriods = null;
        this.standaloneWideDayPeriods = null;
        this.standaloneNarrowDayPeriods = null;
        this.capitalization = null;
        initializeData(uLocale, calendar.getType());
    }

    /* access modifiers changed from: package-private */
    public final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if ((uLocale == null) != (uLocale2 == null)) {
            throw new IllegalArgumentException();
        }
        this.validLocale = uLocale;
        this.actualLocale = uLocale2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
    }
}
