package com.ibm.icu.impl;

import com.ibm.icu.impl.TextTrieMap;
import com.ibm.icu.text.LocaleDisplayNames;
import com.ibm.icu.text.TimeZoneFormat;
import com.ibm.icu.text.TimeZoneNames;
import com.ibm.icu.util.BasicTimeZone;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.TimeZoneTransition;
import com.ibm.icu.util.ULocale;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.MissingResourceException;
import java.util.concurrent.ConcurrentHashMap;
public class TimeZoneGenericNames implements Serializable, Freezable<TimeZoneGenericNames> {
    static final /* synthetic */ boolean $assertionsDisabled = (!TimeZoneGenericNames.class.desiredAssertionStatus());
    private static Cache GENERIC_NAMES_CACHE = new Cache();
    private static final TimeZoneNames.NameType[] GENERIC_NON_LOCATION_TYPES = {TimeZoneNames.NameType.LONG_GENERIC, TimeZoneNames.NameType.SHORT_GENERIC};
    private static final long serialVersionUID = 2729910342063468417L;
    private volatile transient boolean _frozen;
    private transient ConcurrentHashMap<String, String> _genericLocationNamesMap;
    private transient ConcurrentHashMap<String, String> _genericPartialLocationNamesMap;
    private transient TextTrieMap<NameInfo> _gnamesTrie;
    private transient boolean _gnamesTrieFullyLoaded;
    private final ULocale _locale;
    private transient WeakReference<LocaleDisplayNames> _localeDisplayNamesRef;
    private transient MessageFormat[] _patternFormatters;
    private transient String _region;
    private TimeZoneNames _tznames;

    public enum GenericNameType {
        LOCATION("LONG", "SHORT"),
        LONG(new String[0]),
        SHORT(new String[0]);
        
        String[] _fallbackTypeOf;

        private GenericNameType(String... strArr) {
            this._fallbackTypeOf = strArr;
        }
    }

    public enum Pattern {
        REGION_FORMAT("regionFormat", "({0})"),
        FALLBACK_FORMAT("fallbackFormat", "{1} ({0})");
        
        String _defaultVal;
        String _key;

        private Pattern(String str, String str2) {
            this._key = str;
            this._defaultVal = str2;
        }

        /* access modifiers changed from: package-private */
        public String key() {
            return this._key;
        }

        /* access modifiers changed from: package-private */
        public String defaultValue() {
            return this._defaultVal;
        }
    }

    public TimeZoneGenericNames(ULocale uLocale, TimeZoneNames timeZoneNames) {
        this._locale = uLocale;
        this._tznames = timeZoneNames;
        init();
    }

    private void init() {
        if (this._tznames == null) {
            this._tznames = TimeZoneNames.getInstance(this._locale);
        }
        this._genericLocationNamesMap = new ConcurrentHashMap<>();
        this._genericPartialLocationNamesMap = new ConcurrentHashMap<>();
        this._gnamesTrie = new TextTrieMap<>(true);
        this._gnamesTrieFullyLoaded = false;
        String canonicalCLDRID = ZoneMeta.getCanonicalCLDRID(TimeZone.getDefault());
        if (canonicalCLDRID != null) {
            loadStrings(canonicalCLDRID);
        }
    }

    private TimeZoneGenericNames(ULocale uLocale) {
        this(uLocale, (TimeZoneNames) null);
    }

    public static TimeZoneGenericNames getInstance(ULocale uLocale) {
        return (TimeZoneGenericNames) GENERIC_NAMES_CACHE.getInstance(uLocale.getBaseName(), uLocale);
    }

    public String getDisplayName(TimeZone timeZone, GenericNameType genericNameType, long j) {
        String canonicalCLDRID;
        switch (genericNameType) {
            case LOCATION:
                String canonicalCLDRID2 = ZoneMeta.getCanonicalCLDRID(timeZone);
                if (canonicalCLDRID2 != null) {
                    return getGenericLocationName(canonicalCLDRID2);
                }
                return null;
            case LONG:
            case SHORT:
                String formatGenericNonLocationName = formatGenericNonLocationName(timeZone, genericNameType, j);
                if (formatGenericNonLocationName != null || (canonicalCLDRID = ZoneMeta.getCanonicalCLDRID(timeZone)) == null) {
                    return formatGenericNonLocationName;
                }
                return getGenericLocationName(canonicalCLDRID);
            default:
                return null;
        }
    }

    public String getGenericLocationName(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String str2 = this._genericLocationNamesMap.get(str);
        if (str2 == null) {
            Output output = new Output();
            String canonicalCountry = ZoneMeta.getCanonicalCountry(str, output);
            if (canonicalCountry != null) {
                if (output.value.booleanValue()) {
                    str2 = formatPattern(Pattern.REGION_FORMAT, getLocaleDisplayNames().regionDisplayName(canonicalCountry));
                } else {
                    str2 = formatPattern(Pattern.REGION_FORMAT, this._tznames.getExemplarLocationName(str));
                }
            }
            if (str2 == null) {
                this._genericLocationNamesMap.putIfAbsent(str.intern(), "");
            } else {
                synchronized (this) {
                    String intern = str.intern();
                    String putIfAbsent = this._genericLocationNamesMap.putIfAbsent(intern, str2.intern());
                    if (putIfAbsent == null) {
                        this._gnamesTrie.put(str2, new NameInfo(intern, GenericNameType.LOCATION));
                    } else {
                        str2 = putIfAbsent;
                    }
                }
            }
            return str2;
        } else if (str2.length() == 0) {
            return null;
        } else {
            return str2;
        }
    }

    private String formatGenericNonLocationName(TimeZone timeZone, GenericNameType genericNameType, long j) {
        String metaZoneID;
        String metaZoneDisplayName;
        if ($assertionsDisabled || genericNameType == GenericNameType.LONG || genericNameType == GenericNameType.SHORT) {
            String canonicalCLDRID = ZoneMeta.getCanonicalCLDRID(timeZone);
            if (canonicalCLDRID == null) {
                return null;
            }
            TimeZoneNames.NameType nameType = genericNameType == GenericNameType.LONG ? TimeZoneNames.NameType.LONG_GENERIC : TimeZoneNames.NameType.SHORT_GENERIC;
            String timeZoneDisplayName = this._tznames.getTimeZoneDisplayName(canonicalCLDRID, nameType);
            if (timeZoneDisplayName != null || (metaZoneID = this._tznames.getMetaZoneID(canonicalCLDRID, j)) == null) {
                return timeZoneDisplayName;
            }
            boolean z = false;
            int[] iArr = {0, 0};
            timeZone.getOffset(j, false, iArr);
            if (iArr[1] == 0) {
                z = true;
                if (timeZone instanceof BasicTimeZone) {
                    BasicTimeZone basicTimeZone = (BasicTimeZone) timeZone;
                    TimeZoneTransition previousTransition = basicTimeZone.getPreviousTransition(j, true);
                    if (previousTransition == null || j - previousTransition.getTime() >= 15897600000L || previousTransition.getFrom().getDSTSavings() == 0) {
                        TimeZoneTransition nextTransition = basicTimeZone.getNextTransition(j, false);
                        if (!(nextTransition == null || nextTransition.getTime() - j >= 15897600000L || nextTransition.getTo().getDSTSavings() == 0)) {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                } else {
                    int[] iArr2 = new int[2];
                    timeZone.getOffset(j - 15897600000L, false, iArr2);
                    if (iArr2[1] != 0) {
                        z = false;
                    } else {
                        timeZone.getOffset(15897600000L + j, false, iArr2);
                        if (iArr2[1] != 0) {
                            z = false;
                        }
                    }
                }
            }
            if (z) {
                String displayName = this._tznames.getDisplayName(canonicalCLDRID, nameType == TimeZoneNames.NameType.LONG_GENERIC ? TimeZoneNames.NameType.LONG_STANDARD : TimeZoneNames.NameType.SHORT_STANDARD, j);
                if (displayName != null) {
                    timeZoneDisplayName = displayName;
                    if (displayName.equalsIgnoreCase(this._tznames.getMetaZoneDisplayName(metaZoneID, nameType))) {
                        timeZoneDisplayName = null;
                    }
                }
            }
            if (timeZoneDisplayName != null || (metaZoneDisplayName = this._tznames.getMetaZoneDisplayName(metaZoneID, nameType)) == null) {
                return timeZoneDisplayName;
            }
            String referenceZoneID = this._tznames.getReferenceZoneID(metaZoneID, getTargetRegion());
            if (referenceZoneID == null || referenceZoneID.equals(canonicalCLDRID)) {
                return metaZoneDisplayName;
            }
            int[] iArr3 = {0, 0};
            TimeZone.getFrozenTimeZone(referenceZoneID).getOffset(((long) iArr[0]) + j + ((long) iArr[1]), true, iArr3);
            if (iArr[0] == iArr3[0] && iArr[1] == iArr3[1]) {
                return metaZoneDisplayName;
            }
            return getPartialLocationName(canonicalCLDRID, metaZoneID, nameType == TimeZoneNames.NameType.LONG_GENERIC, metaZoneDisplayName);
        }
        throw new AssertionError();
    }

    private synchronized String formatPattern(Pattern pattern, String... strArr) {
        int ordinal;
        String str;
        if (this._patternFormatters == null) {
            this._patternFormatters = new MessageFormat[Pattern.values().length];
        }
        ordinal = pattern.ordinal();
        if (this._patternFormatters[ordinal] == null) {
            try {
                str = ((ICUResourceBundle) ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/zone", this._locale)).getStringWithFallback("zoneStrings/" + pattern.key());
            } catch (MissingResourceException e) {
                str = pattern.defaultValue();
            }
            this._patternFormatters[ordinal] = new MessageFormat(str);
        }
        return this._patternFormatters[ordinal].format(strArr);
    }

    private synchronized LocaleDisplayNames getLocaleDisplayNames() {
        LocaleDisplayNames localeDisplayNames;
        localeDisplayNames = null;
        if (this._localeDisplayNamesRef != null) {
            localeDisplayNames = this._localeDisplayNamesRef.get();
        }
        if (localeDisplayNames == null) {
            localeDisplayNames = LocaleDisplayNames.getInstance(this._locale);
            this._localeDisplayNamesRef = new WeakReference<>(localeDisplayNames);
        }
        return localeDisplayNames;
    }

    private synchronized void loadStrings(String str) {
        if (str != null) {
            if (str.length() != 0) {
                getGenericLocationName(str);
                for (String str2 : this._tznames.getAvailableMetaZoneIDs(str)) {
                    if (!str.equals(this._tznames.getReferenceZoneID(str2, getTargetRegion()))) {
                        TimeZoneNames.NameType[] nameTypeArr = GENERIC_NON_LOCATION_TYPES;
                        int length = nameTypeArr.length;
                        for (int i = 0; i < length; i++) {
                            TimeZoneNames.NameType nameType = nameTypeArr[i];
                            String metaZoneDisplayName = this._tznames.getMetaZoneDisplayName(str2, nameType);
                            if (metaZoneDisplayName != null) {
                                getPartialLocationName(str, str2, nameType == TimeZoneNames.NameType.LONG_GENERIC, metaZoneDisplayName);
                            }
                        }
                    }
                }
            }
        }
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

    private String getPartialLocationName(String str, String str2, boolean z, String str3) {
        String str4;
        String str5 = str + "&" + str2 + "#" + (z ? "L" : "S");
        String str6 = this._genericPartialLocationNamesMap.get(str5);
        if (str6 != null) {
            return str6;
        }
        String canonicalCountry = ZoneMeta.getCanonicalCountry(str);
        if (canonicalCountry == null) {
            str4 = this._tznames.getExemplarLocationName(str);
            if (str4 == null) {
                str4 = str;
            }
        } else if (str.equals(this._tznames.getReferenceZoneID(str2, canonicalCountry))) {
            str4 = getLocaleDisplayNames().regionDisplayName(canonicalCountry);
        } else {
            str4 = this._tznames.getExemplarLocationName(str);
        }
        String formatPattern = formatPattern(Pattern.FALLBACK_FORMAT, str4, str3);
        synchronized (this) {
            String putIfAbsent = this._genericPartialLocationNamesMap.putIfAbsent(str5.intern(), formatPattern.intern());
            if (putIfAbsent == null) {
                this._gnamesTrie.put(formatPattern, new NameInfo(str.intern(), z ? GenericNameType.LONG : GenericNameType.SHORT));
            } else {
                formatPattern = putIfAbsent;
            }
        }
        return formatPattern;
    }

    /* access modifiers changed from: package-private */
    public static class NameInfo {
        final GenericNameType type;
        final String tzID;

        NameInfo(String str, GenericNameType genericNameType) {
            this.tzID = str;
            this.type = genericNameType;
        }
    }

    public static class GenericMatchInfo {
        final int matchLength;
        final GenericNameType nameType;
        final TimeZoneFormat.TimeType timeType;
        final String tzID;

        private GenericMatchInfo(GenericNameType genericNameType, String str, int i) {
            this(genericNameType, str, i, TimeZoneFormat.TimeType.UNKNOWN);
        }

        private GenericMatchInfo(GenericNameType genericNameType, String str, int i, TimeZoneFormat.TimeType timeType2) {
            this.nameType = genericNameType;
            this.tzID = str;
            this.matchLength = i;
            this.timeType = timeType2;
        }

        public String tzID() {
            return this.tzID;
        }

        public TimeZoneFormat.TimeType timeType() {
            return this.timeType;
        }

        public int matchLength() {
            return this.matchLength;
        }
    }

    /* access modifiers changed from: package-private */
    public static class GenericNameSearchHandler implements TextTrieMap.ResultHandler<NameInfo> {
        private Collection<GenericMatchInfo> _matches;
        private int _maxMatchLen;
        private EnumSet<GenericNameType> _types;

        GenericNameSearchHandler(EnumSet<GenericNameType> enumSet) {
            this._types = enumSet;
        }

        @Override // com.ibm.icu.impl.TextTrieMap.ResultHandler
        public boolean handlePrefixMatch(int i, Iterator<NameInfo> it) {
            while (it.hasNext()) {
                NameInfo next = it.next();
                if (this._types == null || this._types.contains(next.type)) {
                    GenericMatchInfo genericMatchInfo = new GenericMatchInfo(next.type, next.tzID, i);
                    if (this._matches == null) {
                        this._matches = new LinkedList();
                    }
                    this._matches.add(genericMatchInfo);
                    if (i > this._maxMatchLen) {
                        this._maxMatchLen = i;
                    }
                }
            }
            return true;
        }

        public Collection<GenericMatchInfo> getMatches() {
            return this._matches;
        }

        public int getMaxMatchLen() {
            return this._maxMatchLen;
        }

        public void resetResults() {
            this._matches = null;
            this._maxMatchLen = 0;
        }
    }

    public GenericMatchInfo findBestMatch(String str, int i, EnumSet<GenericNameType> enumSet) {
        if (str == null || str.length() == 0 || i < 0 || i >= str.length()) {
            throw new IllegalArgumentException("bad input text or range");
        }
        GenericMatchInfo genericMatchInfo = null;
        Collection<TimeZoneNames.MatchInfo> findTimeZoneNames = findTimeZoneNames(str, i, enumSet);
        if (findTimeZoneNames != null) {
            TimeZoneNames.MatchInfo matchInfo = null;
            for (TimeZoneNames.MatchInfo matchInfo2 : findTimeZoneNames) {
                if (matchInfo == null || matchInfo2.matchLength() > matchInfo.matchLength()) {
                    matchInfo = matchInfo2;
                }
            }
            if (matchInfo != null) {
                genericMatchInfo = createGenericMatchInfo(matchInfo);
                if (genericMatchInfo.matchLength() == str.length() - i && genericMatchInfo.timeType != TimeZoneFormat.TimeType.STANDARD) {
                    return genericMatchInfo;
                }
            }
        }
        Collection<GenericMatchInfo> findLocal = findLocal(str, i, enumSet);
        if (findLocal != null) {
            for (GenericMatchInfo genericMatchInfo2 : findLocal) {
                if (genericMatchInfo == null || genericMatchInfo2.matchLength() >= genericMatchInfo.matchLength()) {
                    genericMatchInfo = genericMatchInfo2;
                }
            }
        }
        return genericMatchInfo;
    }

    private GenericMatchInfo createGenericMatchInfo(TimeZoneNames.MatchInfo matchInfo) {
        GenericNameType genericNameType;
        TimeZoneFormat.TimeType timeType = TimeZoneFormat.TimeType.UNKNOWN;
        switch (matchInfo.nameType()) {
            case LONG_STANDARD:
                genericNameType = GenericNameType.LONG;
                timeType = TimeZoneFormat.TimeType.STANDARD;
                break;
            case LONG_GENERIC:
                genericNameType = GenericNameType.LONG;
                break;
            case SHORT_STANDARD:
                genericNameType = GenericNameType.SHORT;
                timeType = TimeZoneFormat.TimeType.STANDARD;
                break;
            case SHORT_GENERIC:
                genericNameType = GenericNameType.SHORT;
                break;
            default:
                throw new IllegalArgumentException("Unexpected MatchInfo name type - " + matchInfo.nameType());
        }
        String tzID = matchInfo.tzID();
        if (tzID == null) {
            String mzID = matchInfo.mzID();
            if ($assertionsDisabled || mzID != null) {
                tzID = this._tznames.getReferenceZoneID(mzID, getTargetRegion());
            } else {
                throw new AssertionError();
            }
        }
        if ($assertionsDisabled || tzID != null) {
            return new GenericMatchInfo(genericNameType, tzID, matchInfo.matchLength(), timeType);
        }
        throw new AssertionError();
    }

    private Collection<TimeZoneNames.MatchInfo> findTimeZoneNames(String str, int i, EnumSet<GenericNameType> enumSet) {
        EnumSet<TimeZoneNames.NameType> noneOf = EnumSet.noneOf(TimeZoneNames.NameType.class);
        if (enumSet.contains(GenericNameType.LONG)) {
            noneOf.add(TimeZoneNames.NameType.LONG_GENERIC);
            noneOf.add(TimeZoneNames.NameType.LONG_STANDARD);
        }
        if (enumSet.contains(GenericNameType.SHORT)) {
            noneOf.add(TimeZoneNames.NameType.SHORT_GENERIC);
            noneOf.add(TimeZoneNames.NameType.SHORT_STANDARD);
        }
        if (!noneOf.isEmpty()) {
            return this._tznames.find(str, i, noneOf);
        }
        return null;
    }

    private synchronized Collection<GenericMatchInfo> findLocal(String str, int i, EnumSet<GenericNameType> enumSet) {
        GenericNameSearchHandler genericNameSearchHandler = new GenericNameSearchHandler(enumSet);
        this._gnamesTrie.find(str, i, genericNameSearchHandler);
        if (genericNameSearchHandler.getMaxMatchLen() == str.length() - i || this._gnamesTrieFullyLoaded) {
            return genericNameSearchHandler.getMatches();
        }
        for (String str2 : TimeZone.getAvailableIDs(TimeZone.SystemTimeZoneType.CANONICAL, null, null)) {
            loadStrings(str2);
        }
        this._gnamesTrieFullyLoaded = true;
        genericNameSearchHandler.resetResults();
        this._gnamesTrie.find(str, i, genericNameSearchHandler);
        return genericNameSearchHandler.getMatches();
    }

    /* access modifiers changed from: package-private */
    public static class Cache extends SoftCache<String, TimeZoneGenericNames, ULocale> {
        private Cache() {
        }

        /* access modifiers changed from: protected */
        public TimeZoneGenericNames createInstance(String str, ULocale uLocale) {
            return new TimeZoneGenericNames(uLocale).freeze();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        init();
    }

    public TimeZoneGenericNames freeze() {
        this._frozen = true;
        return this;
    }
}
