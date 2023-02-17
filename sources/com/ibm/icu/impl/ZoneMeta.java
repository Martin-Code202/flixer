package com.ibm.icu.impl;

import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.SimpleTimeZone;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.UResourceBundle;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import java.lang.ref.SoftReference;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeSet;
public final class ZoneMeta {
    static final /* synthetic */ boolean $assertionsDisabled = (!ZoneMeta.class.desiredAssertionStatus());
    private static ICUCache<String, String> CANONICAL_ID_CACHE = new SimpleCache();
    private static final CustomTimeZoneCache CUSTOM_ZONE_CACHE = new CustomTimeZoneCache();
    private static SoftReference<Set<String>> REF_CANONICAL_SYSTEM_LOCATION_ZONES;
    private static SoftReference<Set<String>> REF_CANONICAL_SYSTEM_ZONES;
    private static SoftReference<Set<String>> REF_SYSTEM_ZONES;
    private static ICUCache<String, String> REGION_CACHE = new SimpleCache();
    private static ICUCache<String, Boolean> SINGLE_COUNTRY_CACHE = new SimpleCache();
    private static final SystemTimeZoneCache SYSTEM_ZONE_CACHE = new SystemTimeZoneCache();
    private static String[] ZONEIDS = null;

    private static synchronized Set<String> getSystemZIDs() {
        Set<String> set;
        synchronized (ZoneMeta.class) {
            set = null;
            if (REF_SYSTEM_ZONES != null) {
                set = REF_SYSTEM_ZONES.get();
            }
            if (set == null) {
                TreeSet treeSet = new TreeSet();
                String[] zoneIDs = getZoneIDs();
                for (String str : zoneIDs) {
                    if (!str.equals("Etc/Unknown")) {
                        treeSet.add(str);
                    }
                }
                set = Collections.unmodifiableSet(treeSet);
                REF_SYSTEM_ZONES = new SoftReference<>(set);
            }
        }
        return set;
    }

    private static synchronized Set<String> getCanonicalSystemZIDs() {
        Set<String> set;
        synchronized (ZoneMeta.class) {
            set = null;
            if (REF_CANONICAL_SYSTEM_ZONES != null) {
                set = REF_CANONICAL_SYSTEM_ZONES.get();
            }
            if (set == null) {
                TreeSet treeSet = new TreeSet();
                String[] zoneIDs = getZoneIDs();
                for (String str : zoneIDs) {
                    if (!str.equals("Etc/Unknown")) {
                        if (str.equals(getCanonicalCLDRID(str))) {
                            treeSet.add(str);
                        }
                    }
                }
                set = Collections.unmodifiableSet(treeSet);
                REF_CANONICAL_SYSTEM_ZONES = new SoftReference<>(set);
            }
        }
        return set;
    }

    private static synchronized Set<String> getCanonicalSystemLocationZIDs() {
        Set<String> set;
        String region;
        synchronized (ZoneMeta.class) {
            set = null;
            if (REF_CANONICAL_SYSTEM_LOCATION_ZONES != null) {
                set = REF_CANONICAL_SYSTEM_LOCATION_ZONES.get();
            }
            if (set == null) {
                TreeSet treeSet = new TreeSet();
                String[] zoneIDs = getZoneIDs();
                for (String str : zoneIDs) {
                    if (!str.equals("Etc/Unknown")) {
                        if (str.equals(getCanonicalCLDRID(str)) && (region = getRegion(str)) != null && !region.equals("001")) {
                            treeSet.add(str);
                        }
                    }
                }
                set = Collections.unmodifiableSet(treeSet);
                REF_CANONICAL_SYSTEM_LOCATION_ZONES = new SoftReference<>(set);
            }
        }
        return set;
    }

    public static Set<String> getAvailableIDs(TimeZone.SystemTimeZoneType systemTimeZoneType, String str, Integer num) {
        Set<String> set;
        OlsonTimeZone systemTimeZone;
        switch (systemTimeZoneType) {
            case ANY:
                set = getSystemZIDs();
                break;
            case CANONICAL:
                set = getCanonicalSystemZIDs();
                break;
            case CANONICAL_LOCATION:
                set = getCanonicalSystemLocationZIDs();
                break;
            default:
                throw new IllegalArgumentException("Unknown SystemTimeZoneType");
        }
        if (str == null && num == null) {
            return set;
        }
        if (str != null) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        TreeSet treeSet = new TreeSet();
        for (String str2 : set) {
            if (str == null || str.equals(getRegion(str2))) {
                if (num == null || ((systemTimeZone = getSystemTimeZone(str2)) != null && num.equals(Integer.valueOf(systemTimeZone.getRawOffset())))) {
                    treeSet.add(str2);
                }
            }
        }
        if (treeSet.isEmpty()) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(treeSet);
    }

    private static synchronized String[] getZoneIDs() {
        String[] strArr;
        synchronized (ZoneMeta.class) {
            if (ZONEIDS == null) {
                try {
                    ZONEIDS = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "zoneinfo64", ICUResourceBundle.ICU_DATA_CLASS_LOADER).getStringArray("Names");
                } catch (MissingResourceException e) {
                }
            }
            if (ZONEIDS == null) {
                ZONEIDS = new String[0];
            }
            strArr = ZONEIDS;
        }
        return strArr;
    }

    private static String getZoneID(int i) {
        if (i < 0) {
            return null;
        }
        String[] zoneIDs = getZoneIDs();
        if (i < zoneIDs.length) {
            return zoneIDs[i];
        }
        return null;
    }

    private static int getZoneIndex(String str) {
        String[] zoneIDs = getZoneIDs();
        if (zoneIDs.length <= 0) {
            return -1;
        }
        int i = 0;
        int length = zoneIDs.length;
        int i2 = Integer.MAX_VALUE;
        while (true) {
            int i3 = (i + length) / 2;
            if (i2 == i3) {
                return -1;
            }
            i2 = i3;
            int compareTo = str.compareTo(zoneIDs[i3]);
            if (compareTo == 0) {
                return i3;
            }
            if (compareTo < 0) {
                length = i3;
            } else {
                i = i3;
            }
        }
    }

    public static String getCanonicalCLDRID(TimeZone timeZone) {
        if (timeZone instanceof OlsonTimeZone) {
            return ((OlsonTimeZone) timeZone).getCanonicalID();
        }
        return getCanonicalCLDRID(timeZone.getID());
    }

    public static String getCanonicalCLDRID(String str) {
        String str2 = CANONICAL_ID_CACHE.get(str);
        if (str2 == null) {
            str2 = findCLDRCanonicalID(str);
            if (str2 == null) {
                try {
                    int zoneIndex = getZoneIndex(str);
                    if (zoneIndex >= 0) {
                        UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "zoneinfo64", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("Zones").get(zoneIndex);
                        if (uResourceBundle.getType() == 7) {
                            str = getZoneID(uResourceBundle.getInt());
                            str2 = findCLDRCanonicalID(str);
                        }
                        if (str2 == null) {
                            str2 = str;
                        }
                    }
                } catch (MissingResourceException e) {
                }
            }
            if (str2 != null) {
                CANONICAL_ID_CACHE.put(str, str2);
            }
        }
        return str2;
    }

    private static String findCLDRCanonicalID(String str) {
        String str2 = null;
        String replace = str.replace('/', ':');
        try {
            UResourceBundle bundleInstance = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "keyTypeData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
            try {
                bundleInstance.get("typeMap").get("timezone").get(replace);
                str2 = str;
            } catch (MissingResourceException e) {
            }
            if (str2 == null) {
                return bundleInstance.get("typeAlias").get("timezone").getString(replace);
            }
            return str2;
        } catch (MissingResourceException e2) {
            return null;
        }
    }

    public static String getRegion(String str) {
        int zoneIndex;
        String str2 = REGION_CACHE.get(str);
        if (str2 == null && (zoneIndex = getZoneIndex(str)) >= 0) {
            try {
                UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "zoneinfo64", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("Regions");
                if (zoneIndex < uResourceBundle.getSize()) {
                    str2 = uResourceBundle.getString(zoneIndex);
                }
            } catch (MissingResourceException e) {
            }
            if (str2 != null) {
                REGION_CACHE.put(str, str2);
            }
        }
        return str2;
    }

    public static String getCanonicalCountry(String str) {
        String region = getRegion(str);
        if (region == null || !region.equals("001")) {
            return region;
        }
        return null;
    }

    public static String getCanonicalCountry(String str, Output<Boolean> output) {
        output.value = (T) Boolean.FALSE;
        String region = getRegion(str);
        if (region != null && region.equals("001")) {
            return null;
        }
        Boolean bool = SINGLE_COUNTRY_CACHE.get(str);
        if (bool == null) {
            Set<String> availableIDs = TimeZone.getAvailableIDs(TimeZone.SystemTimeZoneType.CANONICAL_LOCATION, region, null);
            if ($assertionsDisabled || availableIDs.size() >= 1) {
                bool = Boolean.valueOf(availableIDs.size() <= 1);
                SINGLE_COUNTRY_CACHE.put(str, bool);
            } else {
                throw new AssertionError();
            }
        }
        if (bool.booleanValue()) {
            output.value = (T) Boolean.TRUE;
        } else {
            try {
                String string = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "metaZones").get("primaryZones").getString(region);
                if (str.equals(string)) {
                    output.value = (T) Boolean.TRUE;
                } else {
                    String canonicalCLDRID = getCanonicalCLDRID(str);
                    if (canonicalCLDRID != null && canonicalCLDRID.equals(string)) {
                        output.value = (T) Boolean.TRUE;
                    }
                }
            } catch (MissingResourceException e) {
            }
        }
        return region;
    }

    public static UResourceBundle openOlsonResource(UResourceBundle uResourceBundle, String str) {
        int zoneIndex = getZoneIndex(str);
        if (zoneIndex < 0) {
            return null;
        }
        if (uResourceBundle == null) {
            try {
                uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "zoneinfo64", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
            } catch (MissingResourceException e) {
                return null;
            }
        }
        UResourceBundle uResourceBundle2 = uResourceBundle.get("Zones");
        UResourceBundle uResourceBundle3 = uResourceBundle2.get(zoneIndex);
        if (uResourceBundle3.getType() == 7) {
            uResourceBundle3 = uResourceBundle2.get(uResourceBundle3.getInt());
        }
        return uResourceBundle3;
    }

    /* access modifiers changed from: package-private */
    public static class SystemTimeZoneCache extends SoftCache<String, OlsonTimeZone, String> {
        private SystemTimeZoneCache() {
        }

        /* access modifiers changed from: protected */
        public OlsonTimeZone createInstance(String str, String str2) {
            try {
                UResourceBundle bundleInstance = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "zoneinfo64", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
                UResourceBundle openOlsonResource = ZoneMeta.openOlsonResource(bundleInstance, str2);
                if (openOlsonResource == null) {
                    return null;
                }
                OlsonTimeZone olsonTimeZone = new OlsonTimeZone(bundleInstance, openOlsonResource, str2);
                olsonTimeZone.freeze();
                return olsonTimeZone;
            } catch (MissingResourceException e) {
                return null;
            }
        }
    }

    public static OlsonTimeZone getSystemTimeZone(String str) {
        return (OlsonTimeZone) SYSTEM_ZONE_CACHE.getInstance(str, str);
    }

    /* access modifiers changed from: package-private */
    public static class CustomTimeZoneCache extends SoftCache<Integer, SimpleTimeZone, int[]> {
        static final /* synthetic */ boolean $assertionsDisabled = (!ZoneMeta.class.desiredAssertionStatus());

        private CustomTimeZoneCache() {
        }

        /* access modifiers changed from: protected */
        public SimpleTimeZone createInstance(Integer num, int[] iArr) {
            if (!$assertionsDisabled && iArr.length != 4) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && iArr[0] != 1 && iArr[0] != -1) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && (iArr[1] < 0 || iArr[1] > 23)) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && (iArr[2] < 0 || iArr[2] > 59)) {
                throw new AssertionError();
            } else if ($assertionsDisabled || (iArr[3] >= 0 && iArr[3] <= 59)) {
                SimpleTimeZone simpleTimeZone = new SimpleTimeZone(iArr[0] * ((((iArr[1] * 60) + iArr[2]) * 60) + iArr[3]) * 1000, ZoneMeta.formatCustomID(iArr[1], iArr[2], iArr[3], iArr[0] < 0));
                simpleTimeZone.freeze();
                return simpleTimeZone;
            } else {
                throw new AssertionError();
            }
        }
    }

    public static SimpleTimeZone getCustomTimeZone(String str) {
        int[] iArr = new int[4];
        if (!parseCustomID(str, iArr)) {
            return null;
        }
        return (SimpleTimeZone) CUSTOM_ZONE_CACHE.getInstance(Integer.valueOf(iArr[0] * (iArr[1] | (iArr[2] << 5) | (iArr[3] << 11))), iArr);
    }

    public static String getCustomID(String str) {
        int[] iArr = new int[4];
        if (!parseCustomID(str, iArr)) {
            return null;
        }
        return formatCustomID(iArr[1], iArr[2], iArr[3], iArr[0] < 0);
    }

    static boolean parseCustomID(String str, int[] iArr) {
        if (str == null || str.length() <= "GMT".length() || !str.toUpperCase(Locale.ENGLISH).startsWith("GMT")) {
            return false;
        }
        ParsePosition parsePosition = new ParsePosition("GMT".length());
        int i = 1;
        int i2 = 0;
        int i3 = 0;
        if (str.charAt(parsePosition.getIndex()) == '-') {
            i = -1;
        } else if (str.charAt(parsePosition.getIndex()) != '+') {
            return false;
        }
        parsePosition.setIndex(parsePosition.getIndex() + 1);
        NumberFormat instance = NumberFormat.getInstance();
        instance.setParseIntegerOnly(true);
        int index = parsePosition.getIndex();
        Number parse = instance.parse(str, parsePosition);
        if (parsePosition.getIndex() == index) {
            return false;
        }
        int intValue = parse.intValue();
        if (parsePosition.getIndex() >= str.length()) {
            int index2 = parsePosition.getIndex() - index;
            if (index2 > 0 && 6 >= index2) {
                switch (index2) {
                    case 3:
                    case 4:
                        i2 = intValue % 100;
                        intValue /= 100;
                        break;
                    case 5:
                    case 6:
                        i3 = intValue % 100;
                        i2 = (intValue / 100) % 100;
                        intValue /= SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS;
                        break;
                }
            } else {
                return false;
            }
        } else if (parsePosition.getIndex() - index > 2 || str.charAt(parsePosition.getIndex()) != ':') {
            return false;
        } else {
            parsePosition.setIndex(parsePosition.getIndex() + 1);
            int index3 = parsePosition.getIndex();
            Number parse2 = instance.parse(str, parsePosition);
            if (parsePosition.getIndex() - index3 != 2) {
                return false;
            }
            i2 = parse2.intValue();
            if (parsePosition.getIndex() < str.length()) {
                if (str.charAt(parsePosition.getIndex()) != ':') {
                    return false;
                }
                parsePosition.setIndex(parsePosition.getIndex() + 1);
                int index4 = parsePosition.getIndex();
                Number parse3 = instance.parse(str, parsePosition);
                if (parsePosition.getIndex() != str.length() || parsePosition.getIndex() - index4 != 2) {
                    return false;
                }
                i3 = parse3.intValue();
            }
        }
        if (intValue > 23 || i2 > 59 || i3 > 59) {
            return false;
        }
        if (iArr == null) {
            return true;
        }
        if (iArr.length >= 1) {
            iArr[0] = i;
        }
        if (iArr.length >= 2) {
            iArr[1] = intValue;
        }
        if (iArr.length >= 3) {
            iArr[2] = i2;
        }
        if (iArr.length < 4) {
            return true;
        }
        iArr[3] = i3;
        return true;
    }

    public static SimpleTimeZone getCustomTimeZone(int i) {
        boolean z = false;
        int i2 = i;
        if (i < 0) {
            z = true;
            i2 = -i;
        }
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = i3 / 60;
        return new SimpleTimeZone(i, formatCustomID(i5 / 60, i5 % 60, i4, z));
    }

    static String formatCustomID(int i, int i2, int i3, boolean z) {
        StringBuilder sb = new StringBuilder("GMT");
        if (!(i == 0 && i2 == 0)) {
            if (z) {
                sb.append('-');
            } else {
                sb.append('+');
            }
            if (i < 10) {
                sb.append('0');
            }
            sb.append(i);
            sb.append(':');
            if (i2 < 10) {
                sb.append('0');
            }
            sb.append(i2);
            if (i3 != 0) {
                sb.append(':');
                if (i3 < 10) {
                    sb.append('0');
                }
                sb.append(i3);
            }
        }
        return sb.toString();
    }

    public static String getShortID(TimeZone timeZone) {
        String str;
        if (timeZone instanceof OlsonTimeZone) {
            str = ((OlsonTimeZone) timeZone).getCanonicalID();
        } else {
            str = getCanonicalCLDRID(timeZone.getID());
        }
        if (str == null) {
            return null;
        }
        return getShortIDFromCanonical(str);
    }

    public static String getShortID(String str) {
        String canonicalCLDRID = getCanonicalCLDRID(str);
        if (canonicalCLDRID == null) {
            return null;
        }
        return getShortIDFromCanonical(canonicalCLDRID);
    }

    private static String getShortIDFromCanonical(String str) {
        try {
            return UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "keyTypeData", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("typeMap").get("timezone").getString(str.replace('/', ':'));
        } catch (MissingResourceException e) {
            return null;
        }
    }
}
