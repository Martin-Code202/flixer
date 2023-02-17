package com.ibm.icu.text;

import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.TimeZoneNamesImpl;
import com.ibm.icu.util.ULocale;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
public abstract class TimeZoneNames implements Serializable {
    private static Cache TZNAMES_CACHE = new Cache();
    private static final Factory TZNAMES_FACTORY;
    private static final long serialVersionUID = -9180227029248969153L;

    public enum NameType {
        LONG_GENERIC,
        LONG_STANDARD,
        LONG_DAYLIGHT,
        SHORT_GENERIC,
        SHORT_STANDARD,
        SHORT_DAYLIGHT,
        EXEMPLAR_LOCATION
    }

    public abstract Set<String> getAvailableMetaZoneIDs(String str);

    public abstract String getMetaZoneDisplayName(String str, NameType nameType);

    public abstract String getMetaZoneID(String str, long j);

    public abstract String getReferenceZoneID(String str, String str2);

    public abstract String getTimeZoneDisplayName(String str, NameType nameType);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.ibm.icu.text.TimeZoneNames$Factory] */
    /* JADX WARNING: Unknown variable types count: 1 */
    static {
        /*
            com.ibm.icu.text.TimeZoneNames$Cache r0 = new com.ibm.icu.text.TimeZoneNames$Cache
            r1 = 0
            r0.<init>()
            com.ibm.icu.text.TimeZoneNames.TZNAMES_CACHE = r0
            r2 = 0
            java.lang.String r0 = "com.ibm.icu.text.TimeZoneNames.Factory.impl"
            java.lang.String r1 = "com.ibm.icu.impl.TimeZoneNamesFactoryImpl"
            java.lang.String r3 = com.ibm.icu.impl.ICUConfig.get(r0, r1)
        L_0x0011:
            java.lang.Class r0 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x001d, IllegalAccessException -> 0x001f, InstantiationException -> 0x0021 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ ClassNotFoundException -> 0x001d, IllegalAccessException -> 0x001f, InstantiationException -> 0x0021 }
            com.ibm.icu.text.TimeZoneNames$Factory r0 = (com.ibm.icu.text.TimeZoneNames.Factory) r0     // Catch:{ ClassNotFoundException -> 0x001d, IllegalAccessException -> 0x001f, InstantiationException -> 0x0021 }
            r2 = r0
            goto L_0x002e
        L_0x001d:
            r4 = move-exception
            goto L_0x0022
        L_0x001f:
            r4 = move-exception
            goto L_0x0022
        L_0x0021:
            r4 = move-exception
        L_0x0022:
            java.lang.String r0 = "com.ibm.icu.impl.TimeZoneNamesFactoryImpl"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x002b
            goto L_0x002e
        L_0x002b:
            java.lang.String r3 = "com.ibm.icu.impl.TimeZoneNamesFactoryImpl"
            goto L_0x0011
        L_0x002e:
            if (r2 != 0) goto L_0x0035
            com.ibm.icu.text.TimeZoneNames$DefaultTimeZoneNames$FactoryImpl r2 = new com.ibm.icu.text.TimeZoneNames$DefaultTimeZoneNames$FactoryImpl
            r2.<init>()
        L_0x0035:
            com.ibm.icu.text.TimeZoneNames.TZNAMES_FACTORY = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.TimeZoneNames.<clinit>():void");
    }

    public static TimeZoneNames getInstance(ULocale uLocale) {
        return (TimeZoneNames) TZNAMES_CACHE.getInstance(uLocale.getBaseName(), uLocale);
    }

    public final String getDisplayName(String str, NameType nameType, long j) {
        String timeZoneDisplayName = getTimeZoneDisplayName(str, nameType);
        if (timeZoneDisplayName == null) {
            return getMetaZoneDisplayName(getMetaZoneID(str, j), nameType);
        }
        return timeZoneDisplayName;
    }

    public String getExemplarLocationName(String str) {
        return TimeZoneNamesImpl.getDefaultExemplarLocationName(str);
    }

    public Collection<MatchInfo> find(CharSequence charSequence, int i, EnumSet<NameType> enumSet) {
        throw new UnsupportedOperationException("The method is not implemented in TimeZoneNames base class.");
    }

    public static class MatchInfo {
        private int _matchLength;
        private String _mzID;
        private NameType _nameType;
        private String _tzID;

        public MatchInfo(NameType nameType, String str, String str2, int i) {
            if (nameType == null) {
                throw new IllegalArgumentException("nameType is null");
            } else if (str == null && str2 == null) {
                throw new IllegalArgumentException("Either tzID or mzID must be available");
            } else if (i <= 0) {
                throw new IllegalArgumentException("matchLength must be positive value");
            } else {
                this._nameType = nameType;
                this._tzID = str;
                this._mzID = str2;
                this._matchLength = i;
            }
        }

        public String tzID() {
            return this._tzID;
        }

        public String mzID() {
            return this._mzID;
        }

        public NameType nameType() {
            return this._nameType;
        }

        public int matchLength() {
            return this._matchLength;
        }
    }

    protected TimeZoneNames() {
    }

    @Deprecated
    public static abstract class Factory {
        @Deprecated
        public abstract TimeZoneNames getTimeZoneNames(ULocale uLocale);

        @Deprecated
        protected Factory() {
        }
    }

    static class Cache extends SoftCache<String, TimeZoneNames, ULocale> {
        private Cache() {
        }

        /* access modifiers changed from: protected */
        public TimeZoneNames createInstance(String str, ULocale uLocale) {
            return TimeZoneNames.TZNAMES_FACTORY.getTimeZoneNames(uLocale);
        }
    }

    static class DefaultTimeZoneNames extends TimeZoneNames {
        public static final DefaultTimeZoneNames INSTANCE = new DefaultTimeZoneNames();
        private static final long serialVersionUID = -995672072494349071L;

        private DefaultTimeZoneNames() {
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public Set<String> getAvailableMetaZoneIDs(String str) {
            return Collections.emptySet();
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public String getMetaZoneID(String str, long j) {
            return null;
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public String getReferenceZoneID(String str, String str2) {
            return null;
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public String getMetaZoneDisplayName(String str, NameType nameType) {
            return null;
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public String getTimeZoneDisplayName(String str, NameType nameType) {
            return null;
        }

        @Override // com.ibm.icu.text.TimeZoneNames
        public Collection<MatchInfo> find(CharSequence charSequence, int i, EnumSet<NameType> enumSet) {
            return Collections.emptyList();
        }

        public static class FactoryImpl extends Factory {
            @Override // com.ibm.icu.text.TimeZoneNames.Factory
            public TimeZoneNames getTimeZoneNames(ULocale uLocale) {
                return DefaultTimeZoneNames.INSTANCE;
            }
        }
    }
}
