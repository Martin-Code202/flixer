package com.ibm.icu.impl;

import com.ibm.icu.impl.TextTrieMap;
import com.ibm.icu.text.TimeZoneNames;
import com.ibm.icu.util.ULocale;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
public class TZDBTimeZoneNames extends TimeZoneNames {
    private static final ConcurrentHashMap<String, TZDBNames> TZDB_NAMES_MAP = new ConcurrentHashMap<>();
    private static volatile TextTrieMap<TZDBNameInfo> TZDB_NAMES_TRIE = null;
    private static final ICUResourceBundle ZONESTRINGS = ((ICUResourceBundle) ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/zone", "tzdbNames").get("zoneStrings"));
    private static final long serialVersionUID = 1;
    private ULocale _locale;
    private volatile transient String _region;

    public TZDBTimeZoneNames(ULocale uLocale) {
        this._locale = uLocale;
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public Set<String> getAvailableMetaZoneIDs(String str) {
        return TimeZoneNamesImpl._getAvailableMetaZoneIDs(str);
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public String getMetaZoneID(String str, long j) {
        return TimeZoneNamesImpl._getMetaZoneID(str, j);
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public String getReferenceZoneID(String str, String str2) {
        return TimeZoneNamesImpl._getReferenceZoneID(str, str2);
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public String getMetaZoneDisplayName(String str, TimeZoneNames.NameType nameType) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (nameType == TimeZoneNames.NameType.SHORT_STANDARD || nameType == TimeZoneNames.NameType.SHORT_DAYLIGHT) {
            return getMetaZoneNames(str).getName(nameType);
        }
        return null;
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public String getTimeZoneDisplayName(String str, TimeZoneNames.NameType nameType) {
        return null;
    }

    @Override // com.ibm.icu.text.TimeZoneNames
    public Collection<TimeZoneNames.MatchInfo> find(CharSequence charSequence, int i, EnumSet<TimeZoneNames.NameType> enumSet) {
        if (charSequence == null || charSequence.length() == 0 || i < 0 || i >= charSequence.length()) {
            throw new IllegalArgumentException("bad input text or range");
        }
        prepareFind();
        TZDBNameSearchHandler tZDBNameSearchHandler = new TZDBNameSearchHandler(enumSet, getTargetRegion());
        TZDB_NAMES_TRIE.find(charSequence, i, tZDBNameSearchHandler);
        return tZDBNameSearchHandler.getMatches();
    }

    /* access modifiers changed from: package-private */
    public static class TZDBNames {
        public static final TZDBNames EMPTY_TZDBNAMES = new TZDBNames(null, null);
        private static final String[] KEYS = {"ss", "sd"};
        private String[] _names;
        private String[] _parseRegions;

        private TZDBNames(String[] strArr, String[] strArr2) {
            this._names = strArr;
            this._parseRegions = strArr2;
        }

        static TZDBNames getInstance(ICUResourceBundle iCUResourceBundle, String str) {
            if (iCUResourceBundle == null || str == null || str.length() == 0) {
                return EMPTY_TZDBNAMES;
            }
            try {
                ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle) iCUResourceBundle.get(str);
                boolean z = true;
                String[] strArr = new String[KEYS.length];
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        strArr[i] = iCUResourceBundle2.getString(KEYS[i]);
                        z = false;
                    } catch (MissingResourceException e) {
                        strArr[i] = null;
                    }
                }
                if (z) {
                    return EMPTY_TZDBNAMES;
                }
                String[] strArr2 = null;
                try {
                    ICUResourceBundle iCUResourceBundle3 = (ICUResourceBundle) iCUResourceBundle2.get("parseRegions");
                    if (iCUResourceBundle3.getType() == 0) {
                        strArr2 = new String[]{iCUResourceBundle3.getString()};
                    } else if (iCUResourceBundle3.getType() == 8) {
                        strArr2 = iCUResourceBundle3.getStringArray();
                    }
                } catch (MissingResourceException e2) {
                }
                return new TZDBNames(strArr, strArr2);
            } catch (MissingResourceException e3) {
                return EMPTY_TZDBNAMES;
            }
        }

        /* access modifiers changed from: package-private */
        public String getName(TimeZoneNames.NameType nameType) {
            if (this._names == null) {
                return null;
            }
            switch (nameType) {
                case SHORT_STANDARD:
                    return this._names[0];
                case SHORT_DAYLIGHT:
                    return this._names[1];
                default:
                    return null;
            }
        }

        /* access modifiers changed from: package-private */
        public String[] getParseRegions() {
            return this._parseRegions;
        }
    }

    /* access modifiers changed from: package-private */
    public static class TZDBNameInfo {
        final boolean ambiguousType;
        final String mzID;
        final String[] parseRegions;
        final TimeZoneNames.NameType type;

        TZDBNameInfo(String str, TimeZoneNames.NameType nameType, boolean z, String[] strArr) {
            this.mzID = str;
            this.type = nameType;
            this.ambiguousType = z;
            this.parseRegions = strArr;
        }
    }

    static class TZDBNameSearchHandler implements TextTrieMap.ResultHandler<TZDBNameInfo> {
        static final /* synthetic */ boolean $assertionsDisabled = (!TZDBTimeZoneNames.class.desiredAssertionStatus());
        private Collection<TimeZoneNames.MatchInfo> _matches;
        private EnumSet<TimeZoneNames.NameType> _nameTypes;
        private String _region;

        TZDBNameSearchHandler(EnumSet<TimeZoneNames.NameType> enumSet, String str) {
            this._nameTypes = enumSet;
            if ($assertionsDisabled || str != null) {
                this._region = str;
                return;
            }
            throw new AssertionError();
        }

        @Override // com.ibm.icu.impl.TextTrieMap.ResultHandler
        public boolean handlePrefixMatch(int i, Iterator<TZDBNameInfo> it) {
            TZDBNameInfo tZDBNameInfo = null;
            TZDBNameInfo tZDBNameInfo2 = null;
            while (it.hasNext()) {
                TZDBNameInfo next = it.next();
                if (this._nameTypes == null || this._nameTypes.contains(next.type)) {
                    if (next.parseRegions != null) {
                        boolean z = false;
                        String[] strArr = next.parseRegions;
                        int length = strArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            if (this._region.equals(strArr[i2])) {
                                tZDBNameInfo = next;
                                z = true;
                                break;
                            }
                            i2++;
                        }
                        if (z) {
                            break;
                        } else if (tZDBNameInfo == null) {
                            tZDBNameInfo = next;
                        }
                    } else if (tZDBNameInfo2 == null) {
                        tZDBNameInfo2 = next;
                        tZDBNameInfo = next;
                    }
                }
            }
            if (tZDBNameInfo == null) {
                return true;
            }
            TimeZoneNames.NameType nameType = tZDBNameInfo.type;
            if (tZDBNameInfo.ambiguousType && ((nameType == TimeZoneNames.NameType.SHORT_STANDARD || nameType == TimeZoneNames.NameType.SHORT_DAYLIGHT) && this._nameTypes.contains(TimeZoneNames.NameType.SHORT_STANDARD) && this._nameTypes.contains(TimeZoneNames.NameType.SHORT_DAYLIGHT))) {
                nameType = TimeZoneNames.NameType.SHORT_GENERIC;
            }
            TimeZoneNames.MatchInfo matchInfo = new TimeZoneNames.MatchInfo(nameType, null, tZDBNameInfo.mzID, i);
            if (this._matches == null) {
                this._matches = new LinkedList();
            }
            this._matches.add(matchInfo);
            return true;
        }

        public Collection<TimeZoneNames.MatchInfo> getMatches() {
            if (this._matches == null) {
                return Collections.emptyList();
            }
            return this._matches;
        }
    }

    private static TZDBNames getMetaZoneNames(String str) {
        TZDBNames tZDBNames = TZDB_NAMES_MAP.get(str);
        if (tZDBNames != null) {
            return tZDBNames;
        }
        TZDBNames instance = TZDBNames.getInstance(ZONESTRINGS, "meta:" + str);
        TZDBNames putIfAbsent = TZDB_NAMES_MAP.putIfAbsent(str.intern(), instance);
        return putIfAbsent == null ? instance : putIfAbsent;
    }

    private static void prepareFind() {
        if (TZDB_NAMES_TRIE == null) {
            synchronized (TZDBTimeZoneNames.class) {
                if (TZDB_NAMES_TRIE == null) {
                    TextTrieMap<TZDBNameInfo> textTrieMap = new TextTrieMap<>(true);
                    for (String str : TimeZoneNamesImpl._getAvailableMetaZoneIDs()) {
                        TZDBNames metaZoneNames = getMetaZoneNames(str);
                        String name = metaZoneNames.getName(TimeZoneNames.NameType.SHORT_STANDARD);
                        String name2 = metaZoneNames.getName(TimeZoneNames.NameType.SHORT_DAYLIGHT);
                        if (name != null || name2 != null) {
                            String[] parseRegions = metaZoneNames.getParseRegions();
                            String intern = str.intern();
                            boolean z = (name == null || name2 == null || !name.equals(name2)) ? false : true;
                            if (name != null) {
                                textTrieMap.put(name, new TZDBNameInfo(intern, TimeZoneNames.NameType.SHORT_STANDARD, z, parseRegions));
                            }
                            if (name2 != null) {
                                textTrieMap.put(name2, new TZDBNameInfo(intern, TimeZoneNames.NameType.SHORT_DAYLIGHT, z, parseRegions));
                            }
                        }
                    }
                    TZDB_NAMES_TRIE = textTrieMap;
                }
            }
        }
    }

    private String getTargetRegion() {
        if (this._region == null) {
            String country = this._locale.getCountry();
            if (country.length() == 0) {
                country = ULocale.addLikelySubtags(this._locale).getCountry();
                if (country.length() == 0) {
                    country = "001";
                }
            }
            this._region = country;
        }
        return this._region;
    }
}
