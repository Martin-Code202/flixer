package com.ibm.icu.text;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.TZDBTimeZoneNames;
import com.ibm.icu.impl.TextTrieMap;
import com.ibm.icu.impl.TimeZoneGenericNames;
import com.ibm.icu.impl.TimeZoneNamesImpl;
import com.ibm.icu.impl.ZoneMeta;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.TimeZoneNames;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.MissingResourceException;
public class TimeZoneFormat extends UFormat implements Freezable<TimeZoneFormat>, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!TimeZoneFormat.class.desiredAssertionStatus());
    private static final EnumSet<TimeZoneGenericNames.GenericNameType> ALL_GENERIC_NAME_TYPES = EnumSet.of(TimeZoneGenericNames.GenericNameType.LOCATION, TimeZoneGenericNames.GenericNameType.LONG, TimeZoneGenericNames.GenericNameType.SHORT);
    private static final EnumSet<TimeZoneNames.NameType> ALL_SIMPLE_NAME_TYPES = EnumSet.of(TimeZoneNames.NameType.LONG_STANDARD, TimeZoneNames.NameType.LONG_DAYLIGHT, TimeZoneNames.NameType.SHORT_STANDARD, TimeZoneNames.NameType.SHORT_DAYLIGHT, TimeZoneNames.NameType.EXEMPLAR_LOCATION);
    private static final String[] ALT_GMT_STRINGS = {"GMT", "UTC", "UT"};
    private static final String[] DEFAULT_GMT_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final GMTOffsetPatternType[] PARSE_GMT_OFFSET_TYPES = {GMTOffsetPatternType.POSITIVE_HMS, GMTOffsetPatternType.NEGATIVE_HMS, GMTOffsetPatternType.POSITIVE_HM, GMTOffsetPatternType.NEGATIVE_HM, GMTOffsetPatternType.POSITIVE_H, GMTOffsetPatternType.NEGATIVE_H};
    private static volatile TextTrieMap<String> SHORT_ZONE_ID_TRIE = null;
    private static volatile TextTrieMap<String> ZONE_ID_TRIE = null;
    private static TimeZoneFormatCache _tzfCache = new TimeZoneFormatCache();
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("_locale", ULocale.class), new ObjectStreamField("_tznames", TimeZoneNames.class), new ObjectStreamField("_gmtPattern", String.class), new ObjectStreamField("_gmtOffsetPatterns", String[].class), new ObjectStreamField("_gmtOffsetDigits", String[].class), new ObjectStreamField("_gmtZeroFormat", String.class), new ObjectStreamField("_parseAllStyles", Boolean.TYPE)};
    private static final long serialVersionUID = 2281246852693575022L;
    private transient boolean _abuttingOffsetHoursAndMinutes;
    private volatile transient boolean _frozen;
    private String[] _gmtOffsetDigits;
    private transient Object[][] _gmtOffsetPatternItems;
    private String[] _gmtOffsetPatterns;
    private String _gmtPattern;
    private transient String _gmtPatternPrefix;
    private transient String _gmtPatternSuffix;
    private String _gmtZeroFormat = "GMT";
    private volatile transient TimeZoneGenericNames _gnames;
    private ULocale _locale;
    private boolean _parseAllStyles;
    private boolean _parseTZDBNames;
    private transient String _region;
    private volatile transient TimeZoneNames _tzdbNames;
    private TimeZoneNames _tznames;

    /* access modifiers changed from: package-private */
    public enum OffsetFields {
        H,
        HM,
        HMS
    }

    public enum ParseOption {
        ALL_STYLES,
        TZ_DATABASE_ABBREVIATIONS
    }

    public enum TimeType {
        UNKNOWN,
        STANDARD,
        DAYLIGHT
    }

    public enum Style {
        GENERIC_LOCATION(1),
        GENERIC_LONG(2),
        GENERIC_SHORT(4),
        SPECIFIC_LONG(8),
        SPECIFIC_SHORT(16),
        LOCALIZED_GMT(32),
        LOCALIZED_GMT_SHORT(64),
        ISO_BASIC_SHORT(128),
        ISO_BASIC_LOCAL_SHORT(256),
        ISO_BASIC_FIXED(128),
        ISO_BASIC_LOCAL_FIXED(256),
        ISO_BASIC_FULL(128),
        ISO_BASIC_LOCAL_FULL(256),
        ISO_EXTENDED_FIXED(128),
        ISO_EXTENDED_LOCAL_FIXED(256),
        ISO_EXTENDED_FULL(128),
        ISO_EXTENDED_LOCAL_FULL(256),
        ZONE_ID(512),
        ZONE_ID_SHORT(1024),
        EXEMPLAR_LOCATION(2048);
        
        final int flag;

        private Style(int i) {
            this.flag = i;
        }
    }

    public enum GMTOffsetPatternType {
        POSITIVE_HM("+H:mm", "Hm", true),
        POSITIVE_HMS("+H:mm:ss", "Hms", true),
        NEGATIVE_HM("-H:mm", "Hm", false),
        NEGATIVE_HMS("-H:mm:ss", "Hms", false),
        POSITIVE_H("+H", "H", true),
        NEGATIVE_H("-H", "H", false);
        
        private String _defaultPattern;
        private boolean _isPositive;
        private String _required;

        private GMTOffsetPatternType(String str, String str2, boolean z) {
            this._defaultPattern = str;
            this._required = str2;
            this._isPositive = z;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private String defaultPattern() {
            return this._defaultPattern;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private String required() {
            return this._required;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean isPositive() {
            return this._isPositive;
        }
    }

    protected TimeZoneFormat(ULocale uLocale) {
        this._locale = uLocale;
        this._tznames = TimeZoneNames.getInstance(uLocale);
        String str = null;
        String str2 = null;
        try {
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/zone", uLocale);
            try {
                str = iCUResourceBundle.getStringWithFallback("zoneStrings/gmtFormat");
            } catch (MissingResourceException e) {
            }
            try {
                str2 = iCUResourceBundle.getStringWithFallback("zoneStrings/hourFormat");
            } catch (MissingResourceException e2) {
            }
            try {
                this._gmtZeroFormat = iCUResourceBundle.getStringWithFallback("zoneStrings/gmtZeroFormat");
            } catch (MissingResourceException e3) {
            }
        } catch (MissingResourceException e4) {
        }
        initGMTPattern(str == null ? "GMT{0}" : str);
        String[] strArr = new String[GMTOffsetPatternType.values().length];
        if (str2 != null) {
            String[] split = str2.split(";", 2);
            strArr[GMTOffsetPatternType.POSITIVE_H.ordinal()] = truncateOffsetPattern(split[0]);
            strArr[GMTOffsetPatternType.POSITIVE_HM.ordinal()] = split[0];
            strArr[GMTOffsetPatternType.POSITIVE_HMS.ordinal()] = expandOffsetPattern(split[0]);
            strArr[GMTOffsetPatternType.NEGATIVE_H.ordinal()] = truncateOffsetPattern(split[1]);
            strArr[GMTOffsetPatternType.NEGATIVE_HM.ordinal()] = split[1];
            strArr[GMTOffsetPatternType.NEGATIVE_HMS.ordinal()] = expandOffsetPattern(split[1]);
        } else {
            GMTOffsetPatternType[] values = GMTOffsetPatternType.values();
            for (GMTOffsetPatternType gMTOffsetPatternType : values) {
                strArr[gMTOffsetPatternType.ordinal()] = gMTOffsetPatternType.defaultPattern();
            }
        }
        initGMTOffsetPatterns(strArr);
        this._gmtOffsetDigits = DEFAULT_GMT_DIGITS;
        NumberingSystem instance = NumberingSystem.getInstance(uLocale);
        if (!instance.isAlgorithmic()) {
            this._gmtOffsetDigits = toCodePoints(instance.getDescription());
        }
    }

    public static TimeZoneFormat getInstance(ULocale uLocale) {
        if (uLocale != null) {
            return (TimeZoneFormat) _tzfCache.getInstance(uLocale, uLocale);
        }
        throw new NullPointerException("locale is null");
    }

    public TimeZoneNames getTimeZoneNames() {
        return this._tznames;
    }

    private TimeZoneGenericNames getTimeZoneGenericNames() {
        if (this._gnames == null) {
            synchronized (this) {
                if (this._gnames == null) {
                    this._gnames = TimeZoneGenericNames.getInstance(this._locale);
                }
            }
        }
        return this._gnames;
    }

    private TimeZoneNames getTZDBTimeZoneNames() {
        if (this._tzdbNames == null) {
            synchronized (this) {
                if (this._tzdbNames == null) {
                    this._tzdbNames = new TZDBTimeZoneNames(this._locale);
                }
            }
        }
        return this._tzdbNames;
    }

    public String getGMTOffsetDigits() {
        StringBuilder sb = new StringBuilder(this._gmtOffsetDigits.length);
        for (String str : this._gmtOffsetDigits) {
            sb.append(str);
        }
        return sb.toString();
    }

    public TimeZoneFormat setGMTOffsetDigits(String str) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify frozen object");
        } else if (str == null) {
            throw new NullPointerException("Null GMT offset digits");
        } else {
            String[] codePoints = toCodePoints(str);
            if (codePoints.length != 10) {
                throw new IllegalArgumentException("Length of digits must be 10");
            }
            this._gmtOffsetDigits = codePoints;
            return this;
        }
    }

    public EnumSet<ParseOption> getDefaultParseOptions() {
        if (this._parseAllStyles && this._parseTZDBNames) {
            return EnumSet.of(ParseOption.ALL_STYLES, ParseOption.TZ_DATABASE_ABBREVIATIONS);
        }
        if (this._parseAllStyles) {
            return EnumSet.of(ParseOption.ALL_STYLES);
        }
        if (this._parseTZDBNames) {
            return EnumSet.of(ParseOption.TZ_DATABASE_ABBREVIATIONS);
        }
        return EnumSet.noneOf(ParseOption.class);
    }

    public final String formatOffsetISO8601Basic(int i, boolean z, boolean z2, boolean z3) {
        return formatOffsetISO8601(i, true, z, z2, z3);
    }

    public final String formatOffsetISO8601Extended(int i, boolean z, boolean z2, boolean z3) {
        return formatOffsetISO8601(i, false, z, z2, z3);
    }

    public String formatOffsetLocalizedGMT(int i) {
        return formatOffsetLocalizedGMT(i, false);
    }

    public String formatOffsetShortLocalizedGMT(int i) {
        return formatOffsetLocalizedGMT(i, true);
    }

    public final String format(Style style, TimeZone timeZone, long j) {
        return format(style, timeZone, j, null);
    }

    public String format(Style style, TimeZone timeZone, long j, Output<TimeType> output) {
        String str = null;
        if (output != null) {
            output.value = (T) TimeType.UNKNOWN;
        }
        boolean z = false;
        switch (style) {
            case GENERIC_LOCATION:
                str = getTimeZoneGenericNames().getGenericLocationName(ZoneMeta.getCanonicalCLDRID(timeZone));
                break;
            case GENERIC_LONG:
                str = getTimeZoneGenericNames().getDisplayName(timeZone, TimeZoneGenericNames.GenericNameType.LONG, j);
                break;
            case GENERIC_SHORT:
                str = getTimeZoneGenericNames().getDisplayName(timeZone, TimeZoneGenericNames.GenericNameType.SHORT, j);
                break;
            case SPECIFIC_LONG:
                str = formatSpecific(timeZone, TimeZoneNames.NameType.LONG_STANDARD, TimeZoneNames.NameType.LONG_DAYLIGHT, j, output);
                break;
            case SPECIFIC_SHORT:
                str = formatSpecific(timeZone, TimeZoneNames.NameType.SHORT_STANDARD, TimeZoneNames.NameType.SHORT_DAYLIGHT, j, output);
                break;
            case ZONE_ID:
                str = timeZone.getID();
                z = true;
                break;
            case ZONE_ID_SHORT:
                str = ZoneMeta.getShortID(timeZone);
                if (str == null) {
                    str = "unk";
                }
                z = true;
                break;
            case EXEMPLAR_LOCATION:
                str = formatExemplarLocation(timeZone);
                z = true;
                break;
        }
        if (str == null && !z) {
            int[] iArr = {0, 0};
            timeZone.getOffset(j, false, iArr);
            int i = iArr[0] + iArr[1];
            switch (style) {
                case GENERIC_LOCATION:
                case GENERIC_LONG:
                case SPECIFIC_LONG:
                case LOCALIZED_GMT:
                    str = formatOffsetLocalizedGMT(i);
                    break;
                case GENERIC_SHORT:
                case SPECIFIC_SHORT:
                case LOCALIZED_GMT_SHORT:
                    str = formatOffsetShortLocalizedGMT(i);
                    break;
                case ZONE_ID:
                case ZONE_ID_SHORT:
                case EXEMPLAR_LOCATION:
                default:
                    if (!$assertionsDisabled) {
                        throw new AssertionError();
                    }
                    break;
                case ISO_BASIC_SHORT:
                    str = formatOffsetISO8601Basic(i, true, true, true);
                    break;
                case ISO_BASIC_LOCAL_SHORT:
                    str = formatOffsetISO8601Basic(i, false, true, true);
                    break;
                case ISO_BASIC_FIXED:
                    str = formatOffsetISO8601Basic(i, true, false, true);
                    break;
                case ISO_BASIC_LOCAL_FIXED:
                    str = formatOffsetISO8601Basic(i, false, false, true);
                    break;
                case ISO_BASIC_FULL:
                    str = formatOffsetISO8601Basic(i, true, false, false);
                    break;
                case ISO_BASIC_LOCAL_FULL:
                    str = formatOffsetISO8601Basic(i, false, false, false);
                    break;
                case ISO_EXTENDED_FIXED:
                    str = formatOffsetISO8601Extended(i, true, false, true);
                    break;
                case ISO_EXTENDED_LOCAL_FIXED:
                    str = formatOffsetISO8601Extended(i, false, false, true);
                    break;
                case ISO_EXTENDED_FULL:
                    str = formatOffsetISO8601Extended(i, true, false, false);
                    break;
                case ISO_EXTENDED_LOCAL_FULL:
                    str = formatOffsetISO8601Extended(i, false, false, false);
                    break;
            }
            if (output != null) {
                output.value = iArr[1] != 0 ? (T) TimeType.DAYLIGHT : (T) TimeType.STANDARD;
            }
        }
        if ($assertionsDisabled || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public final int parseOffsetISO8601(String str, ParsePosition parsePosition) {
        return parseOffsetISO8601(str, parsePosition, false, null);
    }

    public int parseOffsetLocalizedGMT(String str, ParsePosition parsePosition) {
        return parseOffsetLocalizedGMT(str, parsePosition, false, null);
    }

    public int parseOffsetShortLocalizedGMT(String str, ParsePosition parsePosition) {
        return parseOffsetLocalizedGMT(str, parsePosition, true, null);
    }

    public TimeZone parse(Style style, String str, ParsePosition parsePosition, EnumSet<ParseOption> enumSet, Output<TimeType> output) {
        boolean z;
        boolean z2;
        TimeZone timeZone;
        TimeZoneGenericNames.GenericMatchInfo findBestMatch;
        EnumSet<TimeZoneNames.NameType> enumSet2;
        if (output == null) {
            output = new Output<>(TimeType.UNKNOWN);
        } else {
            output.value = (T) TimeType.UNKNOWN;
        }
        int index = parsePosition.getIndex();
        int length = str.length();
        boolean z3 = style == Style.SPECIFIC_LONG || style == Style.GENERIC_LONG || style == Style.GENERIC_LOCATION;
        boolean z4 = style == Style.SPECIFIC_SHORT || style == Style.GENERIC_SHORT;
        int i = 0;
        ParsePosition parsePosition2 = new ParsePosition(index);
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        if (z3 || z4) {
            Output<Boolean> output2 = new Output<>(false);
            int parseOffsetLocalizedGMT = parseOffsetLocalizedGMT(str, parsePosition2, z4, output2);
            if (parsePosition2.getErrorIndex() == -1) {
                if (parsePosition2.getIndex() == length || output2.value.booleanValue()) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return getTimeZoneForOffset(parseOffsetLocalizedGMT);
                }
                i2 = parseOffsetLocalizedGMT;
                i3 = parsePosition2.getIndex();
            }
            i = Style.LOCALIZED_GMT.flag | Style.LOCALIZED_GMT_SHORT.flag | 0;
        }
        if (enumSet == null) {
            z = getDefaultParseOptions().contains(ParseOption.TZ_DATABASE_ABBREVIATIONS);
        } else {
            z = enumSet.contains(ParseOption.TZ_DATABASE_ABBREVIATIONS);
        }
        switch (style) {
            case GENERIC_LOCATION:
            case GENERIC_LONG:
            case GENERIC_SHORT:
                EnumSet<TimeZoneGenericNames.GenericNameType> enumSet3 = null;
                switch (style) {
                    case GENERIC_LOCATION:
                        enumSet3 = EnumSet.of(TimeZoneGenericNames.GenericNameType.LOCATION);
                        break;
                    case GENERIC_LONG:
                        enumSet3 = EnumSet.of(TimeZoneGenericNames.GenericNameType.LONG, TimeZoneGenericNames.GenericNameType.LOCATION);
                        break;
                    case GENERIC_SHORT:
                        enumSet3 = EnumSet.of(TimeZoneGenericNames.GenericNameType.SHORT, TimeZoneGenericNames.GenericNameType.LOCATION);
                        break;
                    default:
                        if (!$assertionsDisabled) {
                            throw new AssertionError();
                        }
                        break;
                }
                TimeZoneGenericNames.GenericMatchInfo findBestMatch2 = getTimeZoneGenericNames().findBestMatch(str, index, enumSet3);
                if (findBestMatch2 != null && findBestMatch2.matchLength() + index > i3) {
                    output.value = (T) findBestMatch2.timeType();
                    parsePosition.setIndex(findBestMatch2.matchLength() + index);
                    return TimeZone.getTimeZone(findBestMatch2.tzID());
                }
            case SPECIFIC_LONG:
            case SPECIFIC_SHORT:
                if (style == Style.SPECIFIC_LONG) {
                    enumSet2 = EnumSet.of(TimeZoneNames.NameType.LONG_STANDARD, TimeZoneNames.NameType.LONG_DAYLIGHT);
                } else if ($assertionsDisabled || style == Style.SPECIFIC_SHORT) {
                    enumSet2 = EnumSet.of(TimeZoneNames.NameType.SHORT_STANDARD, TimeZoneNames.NameType.SHORT_DAYLIGHT);
                } else {
                    throw new AssertionError();
                }
                Collection<TimeZoneNames.MatchInfo> find = this._tznames.find(str, index, enumSet2);
                if (find != null) {
                    TimeZoneNames.MatchInfo matchInfo = null;
                    for (TimeZoneNames.MatchInfo matchInfo2 : find) {
                        if (matchInfo2.matchLength() + index > i3) {
                            matchInfo = matchInfo2;
                            i3 = index + matchInfo2.matchLength();
                        }
                    }
                    if (matchInfo != null) {
                        output.value = (T) getTimeType(matchInfo.nameType());
                        parsePosition.setIndex(i3);
                        return TimeZone.getTimeZone(getTimeZoneID(matchInfo.tzID(), matchInfo.mzID()));
                    }
                }
                if (z && style == Style.SPECIFIC_SHORT) {
                    if (!$assertionsDisabled && !enumSet2.contains(TimeZoneNames.NameType.SHORT_STANDARD)) {
                        throw new AssertionError();
                    } else if ($assertionsDisabled || enumSet2.contains(TimeZoneNames.NameType.SHORT_DAYLIGHT)) {
                        Collection<TimeZoneNames.MatchInfo> find2 = getTZDBTimeZoneNames().find(str, index, enumSet2);
                        if (find2 != null) {
                            TimeZoneNames.MatchInfo matchInfo3 = null;
                            for (TimeZoneNames.MatchInfo matchInfo4 : find2) {
                                if (matchInfo4.matchLength() + index > i3) {
                                    matchInfo3 = matchInfo4;
                                    i3 = index + matchInfo4.matchLength();
                                }
                            }
                            if (matchInfo3 != null) {
                                output.value = (T) getTimeType(matchInfo3.nameType());
                                parsePosition.setIndex(i3);
                                return TimeZone.getTimeZone(getTimeZoneID(matchInfo3.tzID(), matchInfo3.mzID()));
                            }
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
                break;
            case ZONE_ID:
                parsePosition2.setIndex(index);
                parsePosition2.setErrorIndex(-1);
                String parseZoneID = parseZoneID(str, parsePosition2);
                if (parsePosition2.getErrorIndex() == -1) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return TimeZone.getTimeZone(parseZoneID);
                }
                break;
            case ZONE_ID_SHORT:
                parsePosition2.setIndex(index);
                parsePosition2.setErrorIndex(-1);
                String parseShortZoneID = parseShortZoneID(str, parsePosition2);
                if (parsePosition2.getErrorIndex() == -1) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return TimeZone.getTimeZone(parseShortZoneID);
                }
                break;
            case EXEMPLAR_LOCATION:
                parsePosition2.setIndex(index);
                parsePosition2.setErrorIndex(-1);
                String parseExemplarLocation = parseExemplarLocation(str, parsePosition2);
                if (parsePosition2.getErrorIndex() == -1) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return TimeZone.getTimeZone(parseExemplarLocation);
                }
                break;
            case LOCALIZED_GMT:
                parsePosition2.setIndex(index);
                parsePosition2.setErrorIndex(-1);
                int parseOffsetLocalizedGMT2 = parseOffsetLocalizedGMT(str, parsePosition2);
                if (parsePosition2.getErrorIndex() != -1) {
                    i |= Style.LOCALIZED_GMT_SHORT.flag;
                    break;
                } else {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return getTimeZoneForOffset(parseOffsetLocalizedGMT2);
                }
            case LOCALIZED_GMT_SHORT:
                parsePosition2.setIndex(index);
                parsePosition2.setErrorIndex(-1);
                int parseOffsetShortLocalizedGMT = parseOffsetShortLocalizedGMT(str, parsePosition2);
                if (parsePosition2.getErrorIndex() != -1) {
                    i |= Style.LOCALIZED_GMT.flag;
                    break;
                } else {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return getTimeZoneForOffset(parseOffsetShortLocalizedGMT);
                }
            case ISO_BASIC_SHORT:
            case ISO_BASIC_FIXED:
            case ISO_BASIC_FULL:
            case ISO_EXTENDED_FIXED:
            case ISO_EXTENDED_FULL:
                parsePosition2.setIndex(index);
                parsePosition2.setErrorIndex(-1);
                int parseOffsetISO8601 = parseOffsetISO8601(str, parsePosition2);
                if (parsePosition2.getErrorIndex() == -1) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return getTimeZoneForOffset(parseOffsetISO8601);
                }
                break;
            case ISO_BASIC_LOCAL_SHORT:
            case ISO_BASIC_LOCAL_FIXED:
            case ISO_BASIC_LOCAL_FULL:
            case ISO_EXTENDED_LOCAL_FIXED:
            case ISO_EXTENDED_LOCAL_FULL:
                parsePosition2.setIndex(index);
                parsePosition2.setErrorIndex(-1);
                Output output3 = new Output(false);
                int parseOffsetISO86012 = parseOffsetISO8601(str, parsePosition2, false, output3);
                if (parsePosition2.getErrorIndex() == -1 && output3.value.booleanValue()) {
                    parsePosition.setIndex(parsePosition2.getIndex());
                    return getTimeZoneForOffset(parseOffsetISO86012);
                }
        }
        int i4 = i | style.flag;
        if (i3 <= index) {
            String str2 = null;
            TimeType timeType = TimeType.UNKNOWN;
            if (!$assertionsDisabled && i3 >= 0) {
                throw new AssertionError();
            } else if ($assertionsDisabled || i2 == Integer.MAX_VALUE) {
                if (i3 < length && ((i4 & 128) == 0 || (i4 & 256) == 0)) {
                    parsePosition2.setIndex(index);
                    parsePosition2.setErrorIndex(-1);
                    Output output4 = new Output(false);
                    int parseOffsetISO86013 = parseOffsetISO8601(str, parsePosition2, false, output4);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() == length || output4.value.booleanValue()) {
                            parsePosition.setIndex(parsePosition2.getIndex());
                            return getTimeZoneForOffset(parseOffsetISO86013);
                        } else if (i3 < parsePosition2.getIndex()) {
                            i2 = parseOffsetISO86013;
                            str2 = null;
                            timeType = TimeType.UNKNOWN;
                            i3 = parsePosition2.getIndex();
                            if (!$assertionsDisabled && i3 != index + 1) {
                                throw new AssertionError();
                            }
                        }
                    }
                }
                if (i3 < length && (Style.LOCALIZED_GMT.flag & i4) == 0) {
                    parsePosition2.setIndex(index);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output5 = new Output<>(false);
                    int parseOffsetLocalizedGMT3 = parseOffsetLocalizedGMT(str, parsePosition2, false, output5);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() == length || output5.value.booleanValue()) {
                            parsePosition.setIndex(parsePosition2.getIndex());
                            return getTimeZoneForOffset(parseOffsetLocalizedGMT3);
                        } else if (i3 < parsePosition2.getIndex()) {
                            i2 = parseOffsetLocalizedGMT3;
                            str2 = null;
                            timeType = TimeType.UNKNOWN;
                            i3 = parsePosition2.getIndex();
                        }
                    }
                }
                if (i3 < length && (Style.LOCALIZED_GMT_SHORT.flag & i4) == 0) {
                    parsePosition2.setIndex(index);
                    parsePosition2.setErrorIndex(-1);
                    Output<Boolean> output6 = new Output<>(false);
                    int parseOffsetLocalizedGMT4 = parseOffsetLocalizedGMT(str, parsePosition2, true, output6);
                    if (parsePosition2.getErrorIndex() == -1) {
                        if (parsePosition2.getIndex() == length || output6.value.booleanValue()) {
                            parsePosition.setIndex(parsePosition2.getIndex());
                            return getTimeZoneForOffset(parseOffsetLocalizedGMT4);
                        } else if (i3 < parsePosition2.getIndex()) {
                            i2 = parseOffsetLocalizedGMT4;
                            str2 = null;
                            timeType = (T) TimeType.UNKNOWN;
                            i3 = parsePosition2.getIndex();
                        }
                    }
                }
                if (enumSet == null) {
                    z2 = getDefaultParseOptions().contains(ParseOption.ALL_STYLES);
                } else {
                    z2 = enumSet.contains(ParseOption.ALL_STYLES);
                }
                if (z2) {
                    if (i3 < length) {
                        Collection<TimeZoneNames.MatchInfo> find3 = this._tznames.find(str, index, ALL_SIMPLE_NAME_TYPES);
                        TimeZoneNames.MatchInfo matchInfo5 = null;
                        int i5 = -1;
                        if (find3 != null) {
                            for (TimeZoneNames.MatchInfo matchInfo6 : find3) {
                                if (matchInfo6.matchLength() + index > i5) {
                                    matchInfo5 = matchInfo6;
                                    i5 = index + matchInfo6.matchLength();
                                }
                            }
                        }
                        if (i3 < i5) {
                            i3 = i5;
                            str2 = getTimeZoneID(matchInfo5.tzID(), matchInfo5.mzID());
                            timeType = (T) getTimeType(matchInfo5.nameType());
                            i2 = Integer.MAX_VALUE;
                        }
                    }
                    if (z && i3 < length && (Style.SPECIFIC_SHORT.flag & i4) == 0) {
                        Collection<TimeZoneNames.MatchInfo> find4 = getTZDBTimeZoneNames().find(str, index, ALL_SIMPLE_NAME_TYPES);
                        TimeZoneNames.MatchInfo matchInfo7 = null;
                        int i6 = -1;
                        if (find4 != null) {
                            for (TimeZoneNames.MatchInfo matchInfo8 : find4) {
                                if (matchInfo8.matchLength() + index > i6) {
                                    matchInfo7 = matchInfo8;
                                    i6 = index + matchInfo8.matchLength();
                                }
                            }
                            if (i3 < i6) {
                                i3 = i6;
                                str2 = getTimeZoneID(matchInfo7.tzID(), matchInfo7.mzID());
                                timeType = getTimeType(matchInfo7.nameType());
                                i2 = Integer.MAX_VALUE;
                            }
                        }
                    }
                    if (i3 < length && (findBestMatch = getTimeZoneGenericNames().findBestMatch(str, index, ALL_GENERIC_NAME_TYPES)) != null && i3 < findBestMatch.matchLength() + index) {
                        i3 = index + findBestMatch.matchLength();
                        str2 = findBestMatch.tzID();
                        timeType = findBestMatch.timeType();
                        i2 = Integer.MAX_VALUE;
                    }
                    if (i3 < length && (Style.ZONE_ID.flag & i4) == 0) {
                        parsePosition2.setIndex(index);
                        parsePosition2.setErrorIndex(-1);
                        String parseZoneID2 = parseZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1 && i3 < parsePosition2.getIndex()) {
                            i3 = parsePosition2.getIndex();
                            str2 = parseZoneID2;
                            timeType = (T) TimeType.UNKNOWN;
                            i2 = Integer.MAX_VALUE;
                        }
                    }
                    if (i3 < length && (Style.ZONE_ID_SHORT.flag & i4) == 0) {
                        parsePosition2.setIndex(index);
                        parsePosition2.setErrorIndex(-1);
                        String parseShortZoneID2 = parseShortZoneID(str, parsePosition2);
                        if (parsePosition2.getErrorIndex() == -1 && i3 < parsePosition2.getIndex()) {
                            i3 = parsePosition2.getIndex();
                            str2 = parseShortZoneID2;
                            timeType = (T) TimeType.UNKNOWN;
                            i2 = Integer.MAX_VALUE;
                        }
                    }
                }
                if (i3 > index) {
                    if (str2 != null) {
                        timeZone = TimeZone.getTimeZone(str2);
                    } else if ($assertionsDisabled || i2 != Integer.MAX_VALUE) {
                        timeZone = getTimeZoneForOffset(i2);
                    } else {
                        throw new AssertionError();
                    }
                    output.value = (T) timeType;
                    parsePosition.setIndex(i3);
                    return timeZone;
                }
                parsePosition.setErrorIndex(index);
                return null;
            } else {
                throw new AssertionError();
            }
        } else if ($assertionsDisabled || i2 != Integer.MAX_VALUE) {
            parsePosition.setIndex(i3);
            return getTimeZoneForOffset(i2);
        } else {
            throw new AssertionError();
        }
    }

    public TimeZone parse(Style style, String str, ParsePosition parsePosition, Output<TimeType> output) {
        return parse(style, str, parsePosition, null, output);
    }

    public final TimeZone parse(String str, ParsePosition parsePosition) {
        return parse(Style.GENERIC_LOCATION, str, parsePosition, EnumSet.of(ParseOption.ALL_STYLES), null);
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone;
        long currentTimeMillis = System.currentTimeMillis();
        if (obj instanceof TimeZone) {
            timeZone = (TimeZone) obj;
        } else if (obj instanceof Calendar) {
            timeZone = ((Calendar) obj).getTimeZone();
            currentTimeMillis = ((Calendar) obj).getTimeInMillis();
        } else {
            throw new IllegalArgumentException("Cannot format given Object (" + obj.getClass().getName() + ") as a time zone");
        }
        if ($assertionsDisabled || timeZone != null) {
            String formatOffsetLocalizedGMT = formatOffsetLocalizedGMT(timeZone.getOffset(currentTimeMillis));
            stringBuffer.append(formatOffsetLocalizedGMT);
            if (fieldPosition.getFieldAttribute() == DateFormat.Field.TIME_ZONE || fieldPosition.getField() == 17) {
                fieldPosition.setBeginIndex(0);
                fieldPosition.setEndIndex(formatOffsetLocalizedGMT.length());
            }
            return stringBuffer;
        }
        throw new AssertionError();
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        AttributedString attributedString = new AttributedString(format(obj, new StringBuffer(), new FieldPosition(0)).toString());
        attributedString.addAttribute(DateFormat.Field.TIME_ZONE, DateFormat.Field.TIME_ZONE);
        return attributedString.getIterator();
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    private String formatOffsetLocalizedGMT(int i, boolean z) {
        Object[] objArr;
        if (i == 0) {
            return this._gmtZeroFormat;
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        if (i < 0) {
            i = -i;
            z2 = false;
        }
        int i2 = i / 3600000;
        int i3 = i % 3600000;
        int i4 = i3 / SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS;
        int i5 = i3 % SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS;
        int i6 = i5 / 1000;
        if (i2 > 23 || i4 > 59 || i6 > 59) {
            throw new IllegalArgumentException("Offset out of range :" + i5);
        }
        if (z2) {
            if (i6 != 0) {
                objArr = this._gmtOffsetPatternItems[GMTOffsetPatternType.POSITIVE_HMS.ordinal()];
            } else if (i4 != 0 || !z) {
                objArr = this._gmtOffsetPatternItems[GMTOffsetPatternType.POSITIVE_HM.ordinal()];
            } else {
                objArr = this._gmtOffsetPatternItems[GMTOffsetPatternType.POSITIVE_H.ordinal()];
            }
        } else if (i6 != 0) {
            objArr = this._gmtOffsetPatternItems[GMTOffsetPatternType.NEGATIVE_HMS.ordinal()];
        } else if (i4 != 0 || !z) {
            objArr = this._gmtOffsetPatternItems[GMTOffsetPatternType.NEGATIVE_HM.ordinal()];
        } else {
            objArr = this._gmtOffsetPatternItems[GMTOffsetPatternType.NEGATIVE_H.ordinal()];
        }
        sb.append(this._gmtPatternPrefix);
        for (Object obj : objArr) {
            if (obj instanceof String) {
                sb.append((String) obj);
            } else if (obj instanceof GMTOffsetField) {
                switch (((GMTOffsetField) obj).getType()) {
                    case 'H':
                        appendOffsetDigits(sb, i2, z ? 1 : 2);
                        continue;
                    case 'm':
                        appendOffsetDigits(sb, i4, 2);
                        continue;
                    case 's':
                        appendOffsetDigits(sb, i6, 2);
                        continue;
                }
            }
        }
        sb.append(this._gmtPatternSuffix);
        return sb.toString();
    }

    private String formatOffsetISO8601(int i, boolean z, boolean z2, boolean z3, boolean z4) {
        int i2 = i < 0 ? -i : i;
        if (z2) {
            if (i2 < 1000) {
                return "Z";
            }
            if (z4 && i2 < 60000) {
                return "Z";
            }
        }
        OffsetFields offsetFields = z3 ? OffsetFields.H : OffsetFields.HM;
        OffsetFields offsetFields2 = z4 ? OffsetFields.HM : OffsetFields.HMS;
        char c = z ? null : ':';
        if (i2 >= 86400000) {
            throw new IllegalArgumentException("Offset out of range :" + i);
        }
        int i3 = i2 % 3600000;
        int[] iArr = {i2 / 3600000, i3 / SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS, (i3 % SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS) / 1000};
        if (!$assertionsDisabled && (iArr[0] < 0 || iArr[0] > 23)) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && (iArr[1] < 0 || iArr[1] > 59)) {
            throw new AssertionError();
        } else if ($assertionsDisabled || (iArr[2] >= 0 && iArr[2] <= 59)) {
            int ordinal = offsetFields2.ordinal();
            while (ordinal > offsetFields.ordinal() && iArr[ordinal] == 0) {
                ordinal--;
            }
            StringBuilder sb = new StringBuilder();
            char c2 = '+';
            if (i < 0) {
                int i4 = 0;
                while (true) {
                    if (i4 > ordinal) {
                        break;
                    } else if (iArr[i4] != 0) {
                        c2 = '-';
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            sb.append(c2);
            for (int i5 = 0; i5 <= ordinal; i5++) {
                if (!(c == null || i5 == 0)) {
                    sb.append(c);
                }
                if (iArr[i5] < 10) {
                    sb.append('0');
                }
                sb.append(iArr[i5]);
            }
            return sb.toString();
        } else {
            throw new AssertionError();
        }
    }

    private String formatSpecific(TimeZone timeZone, TimeZoneNames.NameType nameType, TimeZoneNames.NameType nameType2, long j, Output<TimeType> output) {
        String str;
        if (!$assertionsDisabled && nameType != TimeZoneNames.NameType.LONG_STANDARD && nameType != TimeZoneNames.NameType.SHORT_STANDARD) {
            throw new AssertionError();
        } else if ($assertionsDisabled || nameType2 == TimeZoneNames.NameType.LONG_DAYLIGHT || nameType2 == TimeZoneNames.NameType.SHORT_DAYLIGHT) {
            boolean inDaylightTime = timeZone.inDaylightTime(new Date(j));
            if (inDaylightTime) {
                str = getTimeZoneNames().getDisplayName(ZoneMeta.getCanonicalCLDRID(timeZone), nameType2, j);
            } else {
                str = getTimeZoneNames().getDisplayName(ZoneMeta.getCanonicalCLDRID(timeZone), nameType, j);
            }
            if (!(str == null || output == null)) {
                output.value = inDaylightTime ? (T) TimeType.DAYLIGHT : (T) TimeType.STANDARD;
            }
            return str;
        } else {
            throw new AssertionError();
        }
    }

    private String formatExemplarLocation(TimeZone timeZone) {
        String exemplarLocationName = getTimeZoneNames().getExemplarLocationName(ZoneMeta.getCanonicalCLDRID(timeZone));
        if (exemplarLocationName != null) {
            return exemplarLocationName;
        }
        String exemplarLocationName2 = getTimeZoneNames().getExemplarLocationName("Etc/Unknown");
        if (exemplarLocationName2 == null) {
            return "Unknown";
        }
        return exemplarLocationName2;
    }

    private String getTimeZoneID(String str, String str2) {
        String str3 = str;
        if (str3 == null) {
            if ($assertionsDisabled || str2 != null) {
                str3 = this._tznames.getReferenceZoneID(str2, getTargetRegion());
                if (str3 == null) {
                    throw new IllegalArgumentException("Invalid mzID: " + str2);
                }
            } else {
                throw new AssertionError();
            }
        }
        return str3;
    }

    private synchronized String getTargetRegion() {
        if (this._region == null) {
            this._region = this._locale.getCountry();
            if (this._region.length() == 0) {
                this._region = ULocale.addLikelySubtags(this._locale).getCountry();
                if (this._region.length() == 0) {
                    this._region = "001";
                }
            }
        }
        return this._region;
    }

    private TimeType getTimeType(TimeZoneNames.NameType nameType) {
        switch (nameType) {
            case LONG_STANDARD:
            case SHORT_STANDARD:
                return TimeType.STANDARD;
            case LONG_DAYLIGHT:
            case SHORT_DAYLIGHT:
                return TimeType.DAYLIGHT;
            default:
                return TimeType.UNKNOWN;
        }
    }

    private void initGMTPattern(String str) {
        int indexOf = str.indexOf("{0}");
        if (indexOf < 0) {
            throw new IllegalArgumentException("Bad localized GMT pattern: " + str);
        }
        this._gmtPattern = str;
        this._gmtPatternPrefix = unquote(str.substring(0, indexOf));
        this._gmtPatternSuffix = unquote(str.substring(indexOf + 3));
    }

    private static String unquote(String str) {
        if (str.indexOf(39) < 0) {
            return str;
        }
        boolean z = false;
        boolean z2 = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\'') {
                if (z) {
                    sb.append(charAt);
                    z = false;
                } else {
                    z = true;
                }
                z2 = !z2;
            } else {
                z = false;
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private void initGMTOffsetPatterns(String[] strArr) {
        int length = GMTOffsetPatternType.values().length;
        if (strArr.length < length) {
            throw new IllegalArgumentException("Insufficient number of elements in gmtOffsetPatterns");
        }
        Object[][] objArr = new Object[length][];
        GMTOffsetPatternType[] values = GMTOffsetPatternType.values();
        for (GMTOffsetPatternType gMTOffsetPatternType : values) {
            int ordinal = gMTOffsetPatternType.ordinal();
            objArr[ordinal] = parseOffsetPattern(strArr[ordinal], gMTOffsetPatternType.required());
        }
        this._gmtOffsetPatterns = new String[length];
        System.arraycopy(strArr, 0, this._gmtOffsetPatterns, 0, length);
        this._gmtOffsetPatternItems = objArr;
        checkAbuttingHoursAndMinutes();
    }

    private void checkAbuttingHoursAndMinutes() {
        this._abuttingOffsetHoursAndMinutes = false;
        Object[][] objArr = this._gmtOffsetPatternItems;
        for (Object[] objArr2 : objArr) {
            boolean z = false;
            for (Object obj : objArr2) {
                if (obj instanceof GMTOffsetField) {
                    GMTOffsetField gMTOffsetField = (GMTOffsetField) obj;
                    if (z) {
                        this._abuttingOffsetHoursAndMinutes = true;
                    } else if (gMTOffsetField.getType() == 'H') {
                        z = true;
                    }
                } else if (z) {
                    break;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class GMTOffsetField {
        final char _type;
        final int _width;

        GMTOffsetField(char c, int i) {
            this._type = c;
            this._width = i;
        }

        /* access modifiers changed from: package-private */
        public char getType() {
            return this._type;
        }

        static boolean isValid(char c, int i) {
            return i == 1 || i == 2;
        }
    }

    private static Object[] parseOffsetPattern(String str, String str2) {
        boolean z = false;
        boolean z2 = false;
        StringBuilder sb = new StringBuilder();
        char c = 0;
        int i = 1;
        boolean z3 = false;
        ArrayList arrayList = new ArrayList();
        BitSet bitSet = new BitSet(str2.length());
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i2);
            if (charAt == '\'') {
                if (!z) {
                    z = true;
                    if (c != 0) {
                        if (!GMTOffsetField.isValid(c, i)) {
                            z3 = true;
                            break;
                        }
                        arrayList.add(new GMTOffsetField(c, i));
                        c = 0;
                    }
                } else {
                    sb.append('\'');
                    z = false;
                }
                z2 = !z2;
            } else {
                z = false;
                if (z2) {
                    sb.append(charAt);
                } else {
                    int indexOf = str2.indexOf(charAt);
                    if (indexOf < 0) {
                        if (c != 0) {
                            if (!GMTOffsetField.isValid(c, i)) {
                                z3 = true;
                                break;
                            }
                            arrayList.add(new GMTOffsetField(c, i));
                            c = 0;
                        }
                        sb.append(charAt);
                    } else if (charAt == c) {
                        i++;
                    } else {
                        if (c != 0) {
                            if (!GMTOffsetField.isValid(c, i)) {
                                z3 = true;
                                break;
                            }
                            arrayList.add(new GMTOffsetField(c, i));
                        } else if (sb.length() > 0) {
                            arrayList.add(sb.toString());
                            sb.setLength(0);
                        }
                        c = charAt;
                        i = 1;
                        bitSet.set(indexOf);
                    }
                }
            }
            i2++;
        }
        if (!z3) {
            if (c == 0) {
                if (sb.length() > 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
            } else if (GMTOffsetField.isValid(c, i)) {
                arrayList.add(new GMTOffsetField(c, i));
            } else {
                z3 = true;
            }
        }
        if (!z3 && bitSet.cardinality() == str2.length()) {
            return arrayList.toArray(new Object[arrayList.size()]);
        }
        throw new IllegalStateException("Bad localized GMT offset pattern: " + str);
    }

    private static String expandOffsetPattern(String str) {
        int indexOf = str.indexOf("mm");
        if (indexOf < 0) {
            throw new RuntimeException("Bad time zone hour pattern data");
        }
        String str2 = ":";
        int lastIndexOf = str.substring(0, indexOf).lastIndexOf("H");
        if (lastIndexOf >= 0) {
            str2 = str.substring(lastIndexOf + 1, indexOf);
        }
        return str.substring(0, indexOf + 2) + str2 + "ss" + str.substring(indexOf + 2);
    }

    private static String truncateOffsetPattern(String str) {
        int indexOf = str.indexOf("mm");
        if (indexOf < 0) {
            throw new RuntimeException("Bad time zone hour pattern data");
        }
        int lastIndexOf = str.substring(0, indexOf).lastIndexOf("HH");
        if (lastIndexOf >= 0) {
            return str.substring(0, lastIndexOf + 2);
        }
        int lastIndexOf2 = str.substring(0, indexOf).lastIndexOf("H");
        if (lastIndexOf2 >= 0) {
            return str.substring(0, lastIndexOf2 + 1);
        }
        throw new RuntimeException("Bad time zone hour pattern data");
    }

    private void appendOffsetDigits(StringBuilder sb, int i, int i2) {
        if ($assertionsDisabled || (i >= 0 && i < 60)) {
            int i3 = i >= 10 ? 2 : 1;
            for (int i4 = 0; i4 < i2 - i3; i4++) {
                sb.append(this._gmtOffsetDigits[0]);
            }
            if (i3 == 2) {
                sb.append(this._gmtOffsetDigits[i / 10]);
            }
            sb.append(this._gmtOffsetDigits[i % 10]);
            return;
        }
        throw new AssertionError();
    }

    private TimeZone getTimeZoneForOffset(int i) {
        if (i == 0) {
            return TimeZone.getTimeZone("Etc/GMT");
        }
        return ZoneMeta.getCustomTimeZone(i);
    }

    private int parseOffsetLocalizedGMT(String str, ParsePosition parsePosition, boolean z, Output<Boolean> output) {
        int index = parsePosition.getIndex();
        int[] iArr = {0};
        if (output != null) {
            output.value = (T) false;
        }
        int parseOffsetLocalizedGMTPattern = parseOffsetLocalizedGMTPattern(str, index, z, iArr);
        if (iArr[0] > 0) {
            if (output != null) {
                output.value = (T) true;
            }
            parsePosition.setIndex(iArr[0] + index);
            return parseOffsetLocalizedGMTPattern;
        }
        int parseOffsetDefaultLocalizedGMT = parseOffsetDefaultLocalizedGMT(str, index, iArr);
        if (iArr[0] > 0) {
            if (output != null) {
                output.value = (T) true;
            }
            parsePosition.setIndex(iArr[0] + index);
            return parseOffsetDefaultLocalizedGMT;
        } else if (str.regionMatches(true, index, this._gmtZeroFormat, 0, this._gmtZeroFormat.length())) {
            parsePosition.setIndex(this._gmtZeroFormat.length() + index);
            return 0;
        } else {
            String[] strArr = ALT_GMT_STRINGS;
            for (String str2 : strArr) {
                if (str.regionMatches(true, index, str2, 0, str2.length())) {
                    parsePosition.setIndex(str2.length() + index);
                    return 0;
                }
            }
            parsePosition.setErrorIndex(index);
            return 0;
        }
    }

    private int parseOffsetLocalizedGMTPattern(String str, int i, boolean z, int[] iArr) {
        int i2 = i;
        int i3 = 0;
        boolean z2 = false;
        int length = this._gmtPatternPrefix.length();
        if (length <= 0 || str.regionMatches(true, i2, this._gmtPatternPrefix, 0, length)) {
            i2 += length;
            int[] iArr2 = new int[1];
            i3 = parseOffsetFields(str, i2, false, iArr2);
            if (iArr2[0] != 0) {
                i2 += iArr2[0];
                int length2 = this._gmtPatternSuffix.length();
                if (length2 <= 0 || str.regionMatches(true, i2, this._gmtPatternSuffix, 0, length2)) {
                    i2 += length2;
                    z2 = true;
                }
            }
        }
        iArr[0] = z2 ? i2 - i : 0;
        return i3;
    }

    private int parseOffsetFields(String str, int i, boolean z, int[] iArr) {
        int i2 = 0;
        int i3 = 1;
        if (iArr != null && iArr.length >= 1) {
            iArr[0] = 0;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int[] iArr2 = {0, 0, 0};
        GMTOffsetPatternType[] gMTOffsetPatternTypeArr = PARSE_GMT_OFFSET_TYPES;
        int length = gMTOffsetPatternTypeArr.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                break;
            }
            GMTOffsetPatternType gMTOffsetPatternType = gMTOffsetPatternTypeArr[i7];
            Object[] objArr = this._gmtOffsetPatternItems[gMTOffsetPatternType.ordinal()];
            if ($assertionsDisabled || objArr != null) {
                i2 = parseOffsetFieldsWithPattern(str, i, objArr, false, iArr2);
                if (i2 > 0) {
                    i3 = gMTOffsetPatternType.isPositive() ? 1 : -1;
                    i6 = iArr2[0];
                    i5 = iArr2[1];
                    i4 = iArr2[2];
                } else {
                    i7++;
                }
            } else {
                throw new AssertionError();
            }
        }
        if (i2 > 0 && this._abuttingOffsetHoursAndMinutes) {
            int i8 = 0;
            int i9 = 1;
            GMTOffsetPatternType[] gMTOffsetPatternTypeArr2 = PARSE_GMT_OFFSET_TYPES;
            int length2 = gMTOffsetPatternTypeArr2.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length2) {
                    break;
                }
                GMTOffsetPatternType gMTOffsetPatternType2 = gMTOffsetPatternTypeArr2[i10];
                Object[] objArr2 = this._gmtOffsetPatternItems[gMTOffsetPatternType2.ordinal()];
                if ($assertionsDisabled || objArr2 != null) {
                    i8 = parseOffsetFieldsWithPattern(str, i, objArr2, true, iArr2);
                    if (i8 > 0) {
                        i9 = gMTOffsetPatternType2.isPositive() ? 1 : -1;
                    } else {
                        i10++;
                    }
                } else {
                    throw new AssertionError();
                }
            }
            if (i8 > i2) {
                i2 = i8;
                i3 = i9;
                i6 = iArr2[0];
                i5 = iArr2[1];
                i4 = iArr2[2];
            }
        }
        if (iArr != null && iArr.length >= 1) {
            iArr[0] = i2;
        }
        if (i2 > 0) {
            return ((((i6 * 60) + i5) * 60) + i4) * 1000 * i3;
        }
        return 0;
    }

    private int parseOffsetFieldsWithPattern(String str, int i, Object[] objArr, boolean z, int[] iArr) {
        if ($assertionsDisabled || (iArr != null && iArr.length >= 3)) {
            iArr[2] = 0;
            iArr[1] = 0;
            iArr[0] = 0;
            boolean z2 = false;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = i;
            int[] iArr2 = {0};
            int i6 = 0;
            while (true) {
                if (i6 >= objArr.length) {
                    break;
                }
                if (objArr[i6] instanceof String) {
                    String str2 = (String) objArr[i6];
                    int length = str2.length();
                    if (!str.regionMatches(true, i5, str2, 0, length)) {
                        z2 = true;
                        break;
                    }
                    i5 += length;
                } else if ($assertionsDisabled || (objArr[i6] instanceof GMTOffsetField)) {
                    char type = ((GMTOffsetField) objArr[i6]).getType();
                    if (type == 'H') {
                        i4 = parseOffsetFieldWithLocalizedDigits(str, i5, 1, z ? 1 : 2, 0, 23, iArr2);
                    } else if (type == 'm') {
                        i3 = parseOffsetFieldWithLocalizedDigits(str, i5, 2, 2, 0, 59, iArr2);
                    } else if (type == 's') {
                        i2 = parseOffsetFieldWithLocalizedDigits(str, i5, 2, 2, 0, 59, iArr2);
                    }
                    if (iArr2[0] == 0) {
                        z2 = true;
                        break;
                    }
                    i5 += iArr2[0];
                } else {
                    throw new AssertionError();
                }
                i6++;
            }
            if (z2) {
                return 0;
            }
            iArr[0] = i4;
            iArr[1] = i3;
            iArr[2] = i2;
            return i5 - i;
        }
        throw new AssertionError();
    }

    private int parseOffsetDefaultLocalizedGMT(String str, int i, int[] iArr) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        String[] strArr = ALT_GMT_STRINGS;
        int length = strArr.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                break;
            }
            String str2 = strArr[i7];
            int length2 = str2.length();
            if (str.regionMatches(true, i, str2, 0, length2)) {
                i6 = length2;
                break;
            }
            i7++;
        }
        if (i6 != 0) {
            int i8 = i + i6;
            if (i8 + 1 < str.length()) {
                char charAt = str.charAt(i8);
                if (charAt == '+') {
                    i2 = 1;
                } else if (charAt == '-') {
                    i2 = -1;
                }
                int i9 = i8 + 1;
                int[] iArr2 = {0};
                int parseDefaultOffsetFields = parseDefaultOffsetFields(str, i9, ':', iArr2);
                if (iArr2[0] == str.length() - i9) {
                    i4 = parseDefaultOffsetFields * i2;
                    i3 = i9 + iArr2[0];
                } else {
                    int[] iArr3 = {0};
                    int parseAbuttingOffsetFields = parseAbuttingOffsetFields(str, i9, iArr3);
                    if (iArr2[0] > iArr3[0]) {
                        i4 = parseDefaultOffsetFields * i2;
                        i3 = i9 + iArr2[0];
                    } else {
                        i4 = parseAbuttingOffsetFields * i2;
                        i3 = i9 + iArr3[0];
                    }
                }
                i5 = i3 - i;
            }
        }
        iArr[0] = i5;
        return i4;
    }

    private int parseDefaultOffsetFields(String str, int i, char c, int[] iArr) {
        int length = str.length();
        int i2 = i;
        int[] iArr2 = {0};
        int i3 = 0;
        int i4 = 0;
        int parseOffsetFieldWithLocalizedDigits = parseOffsetFieldWithLocalizedDigits(str, i2, 1, 2, 0, 23, iArr2);
        if (iArr2[0] != 0) {
            i2 += iArr2[0];
            if (i2 + 1 < length && str.charAt(i2) == c) {
                i3 = parseOffsetFieldWithLocalizedDigits(str, i2 + 1, 2, 2, 0, 59, iArr2);
                if (iArr2[0] != 0) {
                    i2 += iArr2[0] + 1;
                    if (i2 + 1 < length && str.charAt(i2) == c) {
                        i4 = parseOffsetFieldWithLocalizedDigits(str, i2 + 1, 2, 2, 0, 59, iArr2);
                        if (iArr2[0] != 0) {
                            i2 += iArr2[0] + 1;
                        }
                    }
                }
            }
        }
        if (i2 == i) {
            iArr[0] = 0;
            return 0;
        }
        iArr[0] = i2 - i;
        return (3600000 * parseOffsetFieldWithLocalizedDigits) + (SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS * i3) + (i4 * 1000);
    }

    private int parseAbuttingOffsetFields(String str, int i, int[] iArr) {
        int[] iArr2 = new int[6];
        int[] iArr3 = new int[6];
        int i2 = i;
        int[] iArr4 = {0};
        int i3 = 0;
        for (int i4 = 0; i4 < 6; i4++) {
            iArr2[i4] = parseSingleLocalizedDigit(str, i2, iArr4);
            if (iArr2[i4] < 0) {
                break;
            }
            i2 += iArr4[0];
            iArr3[i4] = i2 - i;
            i3++;
        }
        if (i3 == 0) {
            iArr[0] = 0;
            return 0;
        }
        while (i3 > 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            if ($assertionsDisabled || (i3 > 0 && i3 <= 6)) {
                switch (i3) {
                    case 1:
                        i5 = iArr2[0];
                        break;
                    case 2:
                        i5 = (iArr2[0] * 10) + iArr2[1];
                        break;
                    case 3:
                        i5 = iArr2[0];
                        i6 = (iArr2[1] * 10) + iArr2[2];
                        break;
                    case 4:
                        i5 = (iArr2[0] * 10) + iArr2[1];
                        i6 = (iArr2[2] * 10) + iArr2[3];
                        break;
                    case 5:
                        i5 = iArr2[0];
                        i6 = (iArr2[1] * 10) + iArr2[2];
                        i7 = (iArr2[3] * 10) + iArr2[4];
                        break;
                    case 6:
                        i5 = (iArr2[0] * 10) + iArr2[1];
                        i6 = (iArr2[2] * 10) + iArr2[3];
                        i7 = (iArr2[4] * 10) + iArr2[5];
                        break;
                }
                if (i5 > 23 || i6 > 59 || i7 > 59) {
                    i3--;
                } else {
                    int i8 = (3600000 * i5) + (SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS * i6) + (i7 * 1000);
                    iArr[0] = iArr3[i3 - 1];
                    return i8;
                }
            } else {
                throw new AssertionError();
            }
        }
        return 0;
    }

    private int parseOffsetFieldWithLocalizedDigits(String str, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        iArr[0] = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = i;
        int[] iArr2 = {0};
        while (i9 < str.length() && i8 < i3 && (r6 = parseSingleLocalizedDigit(str, i9, iArr2)) >= 0 && (i6 = (i7 * 10) + r6) <= i5) {
            i7 = i6;
            i8++;
            i9 += iArr2[0];
        }
        if (i8 < i2 || i7 < i4) {
            return -1;
        }
        iArr[0] = i9 - i;
        return i7;
    }

    private int parseSingleLocalizedDigit(String str, int i, int[] iArr) {
        int i2 = -1;
        iArr[0] = 0;
        if (i < str.length()) {
            int codePointAt = Character.codePointAt(str, i);
            int i3 = 0;
            while (true) {
                if (i3 >= this._gmtOffsetDigits.length) {
                    break;
                } else if (codePointAt == this._gmtOffsetDigits[i3].codePointAt(0)) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 < 0) {
                i2 = UCharacter.digit(codePointAt);
            }
            if (i2 >= 0) {
                iArr[0] = Character.charCount(codePointAt);
            }
        }
        return i2;
    }

    private static String[] toCodePoints(String str) {
        int codePointCount = str.codePointCount(0, str.length());
        String[] strArr = new String[codePointCount];
        int i = 0;
        for (int i2 = 0; i2 < codePointCount; i2++) {
            int charCount = Character.charCount(str.codePointAt(i));
            strArr[i2] = str.substring(i, i + charCount);
            i += charCount;
        }
        return strArr;
    }

    private static int parseOffsetISO8601(String str, ParsePosition parsePosition, boolean z, Output<Boolean> output) {
        int i;
        if (output != null) {
            output.value = (T) false;
        }
        int index = parsePosition.getIndex();
        if (index >= str.length()) {
            parsePosition.setErrorIndex(index);
            return 0;
        }
        char charAt = str.charAt(index);
        if (Character.toUpperCase(charAt) == "Z".charAt(0)) {
            parsePosition.setIndex(index + 1);
            return 0;
        }
        if (charAt == '+') {
            i = 1;
        } else if (charAt == '-') {
            i = -1;
        } else {
            parsePosition.setErrorIndex(index);
            return 0;
        }
        ParsePosition parsePosition2 = new ParsePosition(index + 1);
        int parseAsciiOffsetFields = parseAsciiOffsetFields(str, parsePosition2, ':', OffsetFields.H, OffsetFields.HMS);
        if (parsePosition2.getErrorIndex() == -1 && !z && parsePosition2.getIndex() - index <= 3) {
            ParsePosition parsePosition3 = new ParsePosition(index + 1);
            int parseAbuttingAsciiOffsetFields = parseAbuttingAsciiOffsetFields(str, parsePosition3, OffsetFields.H, OffsetFields.HMS, false);
            if (parsePosition3.getErrorIndex() == -1 && parsePosition3.getIndex() > parsePosition2.getIndex()) {
                parseAsciiOffsetFields = parseAbuttingAsciiOffsetFields;
                parsePosition2.setIndex(parsePosition3.getIndex());
            }
        }
        if (parsePosition2.getErrorIndex() != -1) {
            parsePosition.setErrorIndex(index);
            return 0;
        }
        parsePosition.setIndex(parsePosition2.getIndex());
        if (output != null) {
            output.value = (T) true;
        }
        return i * parseAsciiOffsetFields;
    }

    private static int parseAbuttingAsciiOffsetFields(String str, ParsePosition parsePosition, OffsetFields offsetFields, OffsetFields offsetFields2, boolean z) {
        int indexOf;
        int index = parsePosition.getIndex();
        int ordinal = ((offsetFields.ordinal() + 1) * 2) - (z ? 0 : 1);
        int[] iArr = new int[((offsetFields2.ordinal() + 1) * 2)];
        int i = 0;
        int i2 = index;
        while (i < iArr.length && i2 < str.length() && (indexOf = "0123456789".indexOf(str.charAt(i2))) >= 0) {
            iArr[i] = indexOf;
            i++;
            i2++;
        }
        if (z && (i & 1) != 0) {
            i--;
        }
        if (i < ordinal) {
            parsePosition.setErrorIndex(index);
            return 0;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z2 = false;
        while (true) {
            if (i >= ordinal) {
                switch (i) {
                    case 1:
                        i3 = iArr[0];
                        break;
                    case 2:
                        i3 = (iArr[0] * 10) + iArr[1];
                        break;
                    case 3:
                        i3 = iArr[0];
                        i4 = (iArr[1] * 10) + iArr[2];
                        break;
                    case 4:
                        i3 = (iArr[0] * 10) + iArr[1];
                        i4 = (iArr[2] * 10) + iArr[3];
                        break;
                    case 5:
                        i3 = iArr[0];
                        i4 = (iArr[1] * 10) + iArr[2];
                        i5 = (iArr[3] * 10) + iArr[4];
                        break;
                    case 6:
                        i3 = (iArr[0] * 10) + iArr[1];
                        i4 = (iArr[2] * 10) + iArr[3];
                        i5 = (iArr[4] * 10) + iArr[5];
                        break;
                }
                if (i3 > 23 || i4 > 59 || i5 > 59) {
                    i -= z ? 2 : 1;
                    i5 = 0;
                    i4 = 0;
                    i3 = 0;
                } else {
                    z2 = true;
                }
            }
        }
        if (!z2) {
            parsePosition.setErrorIndex(index);
            return 0;
        }
        parsePosition.setIndex(index + i);
        return ((((i3 * 60) + i4) * 60) + i5) * 1000;
    }

    private static int parseAsciiOffsetFields(String str, ParsePosition parsePosition, char c, OffsetFields offsetFields, OffsetFields offsetFields2) {
        int indexOf;
        int index = parsePosition.getIndex();
        int[] iArr = {0, 0, 0};
        int[] iArr2 = {0, -1, -1};
        int i = 0;
        for (int i2 = index; i2 < str.length() && i <= offsetFields2.ordinal(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != c) {
                if (iArr2[i] == -1 || (indexOf = "0123456789".indexOf(charAt)) < 0) {
                    break;
                }
                iArr[i] = (iArr[i] * 10) + indexOf;
                iArr2[i] = iArr2[i] + 1;
                if (iArr2[i] >= 2) {
                    i++;
                }
            } else if (i == 0) {
                if (iArr2[0] == 0) {
                    break;
                }
                i++;
            } else if (iArr2[i] != -1) {
                break;
            } else {
                iArr2[i] = 0;
            }
        }
        int i3 = 0;
        int i4 = 0;
        OffsetFields offsetFields3 = null;
        if (iArr2[0] != 0) {
            if (iArr[0] > 23) {
                i3 = (iArr[0] / 10) * 3600000;
                offsetFields3 = OffsetFields.H;
                i4 = 1;
            } else {
                i3 = iArr[0] * 3600000;
                i4 = iArr2[0];
                offsetFields3 = OffsetFields.H;
                if (iArr2[1] == 2 && iArr[1] <= 59) {
                    i3 += iArr[1] * SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS;
                    i4 += iArr2[1] + 1;
                    offsetFields3 = OffsetFields.HM;
                    if (iArr2[2] == 2 && iArr[2] <= 59) {
                        i3 += iArr[2] * 1000;
                        i4 += iArr2[2] + 1;
                        offsetFields3 = OffsetFields.HMS;
                    }
                }
            }
        }
        if (offsetFields3 == null || offsetFields3.ordinal() < offsetFields.ordinal()) {
            parsePosition.setErrorIndex(index);
            return 0;
        }
        parsePosition.setIndex(index + i4);
        return i3;
    }

    private static String parseZoneID(String str, ParsePosition parsePosition) {
        if (ZONE_ID_TRIE == null) {
            synchronized (TimeZoneFormat.class) {
                if (ZONE_ID_TRIE == null) {
                    TextTrieMap<String> textTrieMap = new TextTrieMap<>(true);
                    String[] availableIDs = TimeZone.getAvailableIDs();
                    for (String str2 : availableIDs) {
                        textTrieMap.put(str2, str2);
                    }
                    ZONE_ID_TRIE = textTrieMap;
                }
            }
        }
        int[] iArr = {0};
        Iterator<String> it = ZONE_ID_TRIE.get(str, parsePosition.getIndex(), iArr);
        if (it != null) {
            String next = it.next();
            parsePosition.setIndex(parsePosition.getIndex() + iArr[0]);
            return next;
        }
        parsePosition.setErrorIndex(parsePosition.getIndex());
        return null;
    }

    private static String parseShortZoneID(String str, ParsePosition parsePosition) {
        if (SHORT_ZONE_ID_TRIE == null) {
            synchronized (TimeZoneFormat.class) {
                if (SHORT_ZONE_ID_TRIE == null) {
                    TextTrieMap<String> textTrieMap = new TextTrieMap<>(true);
                    for (String str2 : TimeZone.getAvailableIDs(TimeZone.SystemTimeZoneType.CANONICAL, null, null)) {
                        String shortID = ZoneMeta.getShortID(str2);
                        if (shortID != null) {
                            textTrieMap.put(shortID, str2);
                        }
                    }
                    textTrieMap.put("unk", "Etc/Unknown");
                    SHORT_ZONE_ID_TRIE = textTrieMap;
                }
            }
        }
        int[] iArr = {0};
        Iterator<String> it = SHORT_ZONE_ID_TRIE.get(str, parsePosition.getIndex(), iArr);
        if (it != null) {
            String next = it.next();
            parsePosition.setIndex(parsePosition.getIndex() + iArr[0]);
            return next;
        }
        parsePosition.setErrorIndex(parsePosition.getIndex());
        return null;
    }

    private String parseExemplarLocation(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int i = -1;
        String str2 = null;
        Collection<TimeZoneNames.MatchInfo> find = this._tznames.find(str, index, EnumSet.of(TimeZoneNames.NameType.EXEMPLAR_LOCATION));
        if (find != null) {
            TimeZoneNames.MatchInfo matchInfo = null;
            for (TimeZoneNames.MatchInfo matchInfo2 : find) {
                if (matchInfo2.matchLength() + index > i) {
                    matchInfo = matchInfo2;
                    i = index + matchInfo2.matchLength();
                }
            }
            if (matchInfo != null) {
                str2 = getTimeZoneID(matchInfo.tzID(), matchInfo.mzID());
                parsePosition.setIndex(i);
            }
        }
        if (str2 == null) {
            parsePosition.setErrorIndex(index);
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    public static class TimeZoneFormatCache extends SoftCache<ULocale, TimeZoneFormat, ULocale> {
        private TimeZoneFormatCache() {
        }

        /* access modifiers changed from: protected */
        public TimeZoneFormat createInstance(ULocale uLocale, ULocale uLocale2) {
            TimeZoneFormat timeZoneFormat = new TimeZoneFormat(uLocale2);
            timeZoneFormat.freeze();
            return timeZoneFormat;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("_locale", this._locale);
        putFields.put("_tznames", this._tznames);
        putFields.put("_gmtPattern", this._gmtPattern);
        putFields.put("_gmtOffsetPatterns", this._gmtOffsetPatterns);
        putFields.put("_gmtOffsetDigits", this._gmtOffsetDigits);
        putFields.put("_gmtZeroFormat", this._gmtZeroFormat);
        putFields.put("_parseAllStyles", this._parseAllStyles);
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this._locale = (ULocale) readFields.get("_locale", (Object) null);
        if (this._locale == null) {
            throw new InvalidObjectException("Missing field: locale");
        }
        this._tznames = (TimeZoneNames) readFields.get("_tznames", (Object) null);
        if (this._tznames == null) {
            throw new InvalidObjectException("Missing field: tznames");
        }
        this._gmtPattern = (String) readFields.get("_gmtPattern", (Object) null);
        if (this._gmtPattern == null) {
            throw new InvalidObjectException("Missing field: gmtPattern");
        }
        String[] strArr = (String[]) readFields.get("_gmtOffsetPatterns", (Object) null);
        if (strArr == null) {
            throw new InvalidObjectException("Missing field: gmtOffsetPatterns");
        } else if (strArr.length < 4) {
            throw new InvalidObjectException("Incompatible field: gmtOffsetPatterns");
        } else {
            this._gmtOffsetPatterns = new String[6];
            if (strArr.length == 4) {
                for (int i = 0; i < 4; i++) {
                    this._gmtOffsetPatterns[i] = strArr[i];
                }
                this._gmtOffsetPatterns[GMTOffsetPatternType.POSITIVE_H.ordinal()] = truncateOffsetPattern(this._gmtOffsetPatterns[GMTOffsetPatternType.POSITIVE_HM.ordinal()]);
                this._gmtOffsetPatterns[GMTOffsetPatternType.NEGATIVE_H.ordinal()] = truncateOffsetPattern(this._gmtOffsetPatterns[GMTOffsetPatternType.NEGATIVE_HM.ordinal()]);
            } else {
                this._gmtOffsetPatterns = strArr;
            }
            this._gmtOffsetDigits = (String[]) readFields.get("_gmtOffsetDigits", (Object) null);
            if (this._gmtOffsetDigits == null) {
                throw new InvalidObjectException("Missing field: gmtOffsetDigits");
            } else if (this._gmtOffsetDigits.length != 10) {
                throw new InvalidObjectException("Incompatible field: gmtOffsetDigits");
            } else {
                this._gmtZeroFormat = (String) readFields.get("_gmtZeroFormat", (Object) null);
                if (this._gmtZeroFormat == null) {
                    throw new InvalidObjectException("Missing field: gmtZeroFormat");
                }
                this._parseAllStyles = readFields.get("_parseAllStyles", false);
                if (readFields.defaulted("_parseAllStyles")) {
                    throw new InvalidObjectException("Missing field: parseAllStyles");
                }
                if (this._tznames instanceof TimeZoneNamesImpl) {
                    this._tznames = TimeZoneNames.getInstance(this._locale);
                    this._gnames = null;
                } else {
                    this._gnames = new TimeZoneGenericNames(this._locale, this._tznames);
                }
                initGMTPattern(this._gmtPattern);
                initGMTOffsetPatterns(this._gmtOffsetPatterns);
            }
        }
    }

    public boolean isFrozen() {
        return this._frozen;
    }

    public TimeZoneFormat freeze() {
        this._frozen = true;
        return this;
    }

    public TimeZoneFormat cloneAsThawed() {
        TimeZoneFormat timeZoneFormat = (TimeZoneFormat) super.clone();
        timeZoneFormat._frozen = false;
        return timeZoneFormat;
    }
}
