package com.ibm.icu.util;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.LocaleIDParser;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.locale.AsciiUtil;
import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.impl.locale.Extension;
import com.ibm.icu.impl.locale.InternalLocaleBuilder;
import com.ibm.icu.impl.locale.KeyTypeData;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.impl.locale.LocaleExtensions;
import com.ibm.icu.impl.locale.LocaleSyntaxException;
import com.ibm.icu.impl.locale.UnicodeLocaleExtension;
import com.ibm.icu.text.LocaleDisplayNames;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
public final class ULocale implements Serializable, Comparable<ULocale> {
    public static Type ACTUAL_LOCALE = new Type();
    private static final SoftCache<Locale, ULocale, Void> CACHE = new SoftCache<Locale, ULocale, Void>() { // from class: com.ibm.icu.util.ULocale.2
        /* access modifiers changed from: protected */
        public ULocale createInstance(Locale locale2, Void r3) {
            return JDKLocaleHelper.toULocale(locale2);
        }
    };
    public static final ULocale CANADA = new ULocale("en_CA", Locale.CANADA);
    public static final ULocale CANADA_FRENCH = new ULocale("fr_CA", Locale.CANADA_FRENCH);
    private static String[][] CANONICALIZE_MAP = {new String[]{"C", "en_US_POSIX", null, null}, new String[]{"art_LOJBAN", "jbo", null, null}, new String[]{"az_AZ_CYRL", "az_Cyrl_AZ", null, null}, new String[]{"az_AZ_LATN", "az_Latn_AZ", null, null}, new String[]{"ca_ES_PREEURO", "ca_ES", "currency", "ESP"}, new String[]{"cel_GAULISH", "cel__GAULISH", null, null}, new String[]{"de_1901", "de__1901", null, null}, new String[]{"de_1906", "de__1906", null, null}, new String[]{"de__PHONEBOOK", "de", "collation", "phonebook"}, new String[]{"de_AT_PREEURO", "de_AT", "currency", "ATS"}, new String[]{"de_DE_PREEURO", "de_DE", "currency", "DEM"}, new String[]{"de_LU_PREEURO", "de_LU", "currency", "EUR"}, new String[]{"el_GR_PREEURO", "el_GR", "currency", "GRD"}, new String[]{"en_BOONT", "en__BOONT", null, null}, new String[]{"en_SCOUSE", "en__SCOUSE", null, null}, new String[]{"en_BE_PREEURO", "en_BE", "currency", "BEF"}, new String[]{"en_IE_PREEURO", "en_IE", "currency", "IEP"}, new String[]{"es__TRADITIONAL", "es", "collation", "traditional"}, new String[]{"es_ES_PREEURO", "es_ES", "currency", "ESP"}, new String[]{"eu_ES_PREEURO", "eu_ES", "currency", "ESP"}, new String[]{"fi_FI_PREEURO", "fi_FI", "currency", "FIM"}, new String[]{"fr_BE_PREEURO", "fr_BE", "currency", "BEF"}, new String[]{"fr_FR_PREEURO", "fr_FR", "currency", "FRF"}, new String[]{"fr_LU_PREEURO", "fr_LU", "currency", "LUF"}, new String[]{"ga_IE_PREEURO", "ga_IE", "currency", "IEP"}, new String[]{"gl_ES_PREEURO", "gl_ES", "currency", "ESP"}, new String[]{"hi__DIRECT", "hi", "collation", "direct"}, new String[]{"it_IT_PREEURO", "it_IT", "currency", "ITL"}, new String[]{"ja_JP_TRADITIONAL", "ja_JP", "calendar", "japanese"}, new String[]{"nl_BE_PREEURO", "nl_BE", "currency", "BEF"}, new String[]{"nl_NL_PREEURO", "nl_NL", "currency", "NLG"}, new String[]{"pt_PT_PREEURO", "pt_PT", "currency", "PTE"}, new String[]{"sl_ROZAJ", "sl__ROZAJ", null, null}, new String[]{"sr_SP_CYRL", "sr_Cyrl_RS", null, null}, new String[]{"sr_SP_LATN", "sr_Latn_RS", null, null}, new String[]{"sr_YU_CYRILLIC", "sr_Cyrl_RS", null, null}, new String[]{"th_TH_TRADITIONAL", "th_TH", "calendar", "buddhist"}, new String[]{"uz_UZ_CYRILLIC", "uz_Cyrl_UZ", null, null}, new String[]{"uz_UZ_CYRL", "uz_Cyrl_UZ", null, null}, new String[]{"uz_UZ_LATN", "uz_Latn_UZ", null, null}, new String[]{"zh_CHS", "zh_Hans", null, null}, new String[]{"zh_CHT", "zh_Hant", null, null}, new String[]{"zh_GAN", "zh__GAN", null, null}, new String[]{"zh_GUOYU", "zh", null, null}, new String[]{"zh_HAKKA", "zh__HAKKA", null, null}, new String[]{"zh_MIN", "zh__MIN", null, null}, new String[]{"zh_MIN_NAN", "zh__MINNAN", null, null}, new String[]{"zh_WUU", "zh__WUU", null, null}, new String[]{"zh_XIANG", "zh__XIANG", null, null}, new String[]{"zh_YUE", "zh__YUE", null, null}};
    public static final ULocale CHINA = new ULocale("zh_Hans_CN");
    public static final ULocale CHINESE = new ULocale("zh", Locale.CHINESE);
    private static final Locale EMPTY_LOCALE = new Locale("", "");
    public static final ULocale ENGLISH = new ULocale("en", Locale.ENGLISH);
    public static final ULocale FRANCE = new ULocale("fr_FR", Locale.FRANCE);
    public static final ULocale FRENCH = new ULocale(SignupConstants.Field.REGION_FR, Locale.FRENCH);
    public static final ULocale GERMAN = new ULocale("de", Locale.GERMAN);
    public static final ULocale GERMANY = new ULocale("de_DE", Locale.GERMANY);
    public static final ULocale ITALIAN = new ULocale("it", Locale.ITALIAN);
    public static final ULocale ITALY = new ULocale("it_IT", Locale.ITALY);
    public static final ULocale JAPAN = new ULocale("ja_JP", Locale.JAPAN);
    public static final ULocale JAPANESE = new ULocale("ja", Locale.JAPANESE);
    public static final ULocale KOREA = new ULocale("ko_KR", Locale.KOREA);
    public static final ULocale KOREAN = new ULocale("ko", Locale.KOREAN);
    public static final ULocale PRC = CHINA;
    public static final ULocale ROOT = new ULocale("", EMPTY_LOCALE);
    public static final ULocale SIMPLIFIED_CHINESE = new ULocale("zh_Hans");
    public static final ULocale TAIWAN = new ULocale("zh_Hant_TW");
    public static final ULocale TRADITIONAL_CHINESE = new ULocale("zh_Hant");
    public static final ULocale UK = new ULocale("en_GB", Locale.UK);
    public static final ULocale US = new ULocale("en_US", Locale.US);
    public static Type VALID_LOCALE = new Type();
    private static Locale[] defaultCategoryLocales = new Locale[Category.values().length];
    private static ULocale[] defaultCategoryULocales = new ULocale[Category.values().length];
    private static Locale defaultLocale = Locale.getDefault();
    private static ULocale defaultULocale = null;
    private static CacheBase<String, String, Void> nameCache = new SoftCache<String, String, Void>() { // from class: com.ibm.icu.util.ULocale.1
        /* access modifiers changed from: protected */
        public String createInstance(String str, Void r3) {
            return new LocaleIDParser(str).getName();
        }
    };
    private static final long serialVersionUID = 3715177670352309217L;
    private static String[][] variantsToKeywords = {new String[]{"EURO", "currency", "EUR"}, new String[]{"PINYIN", "collation", "pinyin"}, new String[]{"STROKE", "collation", "stroke"}};
    private volatile transient BaseLocale baseLocale;
    private volatile transient LocaleExtensions extensions;
    private volatile transient Locale locale;
    private String localeID;

    public enum Category {
        DISPLAY,
        FORMAT
    }

    static {
        String systemProperty;
        defaultULocale = forLocale(defaultLocale);
        if (JDKLocaleHelper.hasLocaleCategories()) {
            Category[] values = Category.values();
            for (Category category : values) {
                int ordinal = category.ordinal();
                defaultCategoryLocales[ordinal] = JDKLocaleHelper.getDefault(category);
                defaultCategoryULocales[ordinal] = forLocale(defaultCategoryLocales[ordinal]);
            }
        } else {
            if (JDKLocaleHelper.isOriginalDefaultLocale(defaultLocale) && (systemProperty = JDKLocaleHelper.getSystemProperty("user.script")) != null && LanguageTag.isScript(systemProperty)) {
                BaseLocale base = defaultULocale.base();
                defaultULocale = getInstance(BaseLocale.getInstance(base.getLanguage(), systemProperty, base.getRegion(), base.getVariant()), defaultULocale.extensions());
            }
            for (Category category2 : Category.values()) {
                int ordinal2 = category2.ordinal();
                defaultCategoryLocales[ordinal2] = defaultLocale;
                defaultCategoryULocales[ordinal2] = defaultULocale;
            }
        }
    }

    private ULocale(String str, Locale locale2) {
        this.localeID = str;
        this.locale = locale2;
    }

    public static ULocale forLocale(Locale locale2) {
        if (locale2 == null) {
            return null;
        }
        return CACHE.getInstance(locale2, null);
    }

    public ULocale(String str) {
        this.localeID = getName(str);
    }

    public static ULocale createCanonical(String str) {
        return new ULocale(canonicalize(str), null);
    }

    private static String lscvToID(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if (str != null && str.length() > 0) {
            sb.append(str);
        }
        if (str2 != null && str2.length() > 0) {
            sb.append('_');
            sb.append(str2);
        }
        if (str3 != null && str3.length() > 0) {
            sb.append('_');
            sb.append(str3);
        }
        if (str4 != null && str4.length() > 0) {
            if (str3 == null || str3.length() == 0) {
                sb.append('_');
            }
            sb.append('_');
            sb.append(str4);
        }
        return sb.toString();
    }

    public Locale toLocale() {
        if (this.locale == null) {
            this.locale = JDKLocaleHelper.toLocale(this);
        }
        return this.locale;
    }

    public static ULocale getDefault() {
        synchronized (ULocale.class) {
            if (defaultULocale == null) {
                return ROOT;
            }
            Locale locale2 = Locale.getDefault();
            if (!defaultLocale.equals(locale2)) {
                defaultLocale = locale2;
                defaultULocale = forLocale(locale2);
                if (!JDKLocaleHelper.hasLocaleCategories()) {
                    for (Category category : Category.values()) {
                        int ordinal = category.ordinal();
                        defaultCategoryLocales[ordinal] = locale2;
                        defaultCategoryULocales[ordinal] = forLocale(locale2);
                    }
                }
            }
            return defaultULocale;
        }
    }

    public static ULocale getDefault(Category category) {
        synchronized (ULocale.class) {
            int ordinal = category.ordinal();
            if (defaultCategoryULocales[ordinal] == null) {
                return ROOT;
            }
            if (JDKLocaleHelper.hasLocaleCategories()) {
                Locale locale2 = JDKLocaleHelper.getDefault(category);
                if (!defaultCategoryLocales[ordinal].equals(locale2)) {
                    defaultCategoryLocales[ordinal] = locale2;
                    defaultCategoryULocales[ordinal] = forLocale(locale2);
                }
            } else {
                Locale locale3 = Locale.getDefault();
                if (!defaultLocale.equals(locale3)) {
                    defaultLocale = locale3;
                    defaultULocale = forLocale(locale3);
                    for (Category category2 : Category.values()) {
                        int ordinal2 = category2.ordinal();
                        defaultCategoryLocales[ordinal2] = locale3;
                        defaultCategoryULocales[ordinal2] = forLocale(locale3);
                    }
                }
            }
            return defaultCategoryULocales[ordinal];
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        return this;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.localeID.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ULocale) {
            return this.localeID.equals(((ULocale) obj).localeID);
        }
        return false;
    }

    public int compareTo(ULocale uLocale) {
        if (this == uLocale) {
            return 0;
        }
        int compareTo = getLanguage().compareTo(uLocale.getLanguage());
        if (compareTo == 0 && (compareTo = getScript().compareTo(uLocale.getScript())) == 0 && (compareTo = getCountry().compareTo(uLocale.getCountry())) == 0 && (compareTo = getVariant().compareTo(uLocale.getVariant())) == 0) {
            Iterator<String> keywords = getKeywords();
            Iterator<String> keywords2 = uLocale.getKeywords();
            if (keywords == null) {
                compareTo = keywords2 == null ? 0 : -1;
            } else if (keywords2 == null) {
                compareTo = 1;
            } else {
                while (true) {
                    if (compareTo != 0 || !keywords.hasNext()) {
                        break;
                    } else if (!keywords2.hasNext()) {
                        compareTo = 1;
                        break;
                    } else {
                        String next = keywords.next();
                        String next2 = keywords2.next();
                        compareTo = next.compareTo(next2);
                        if (compareTo == 0) {
                            String keywordValue = getKeywordValue(next);
                            String keywordValue2 = uLocale.getKeywordValue(next2);
                            if (keywordValue == null) {
                                compareTo = keywordValue2 == null ? 0 : -1;
                            } else if (keywordValue2 == null) {
                                compareTo = 1;
                            } else {
                                compareTo = keywordValue.compareTo(keywordValue2);
                            }
                        }
                    }
                }
                if (compareTo == 0 && keywords2.hasNext()) {
                    compareTo = -1;
                }
            }
        }
        if (compareTo < 0) {
            return -1;
        }
        return compareTo > 0 ? 1 : 0;
    }

    public String getLanguage() {
        return base().getLanguage();
    }

    public String getScript() {
        return base().getScript();
    }

    public String getCountry() {
        return base().getRegion();
    }

    @Deprecated
    public static String getRegionForSupplementalData(ULocale uLocale, boolean z) {
        String keywordValue = uLocale.getKeywordValue("rg");
        if (keywordValue != null && keywordValue.length() == 6) {
            String upperString = AsciiUtil.toUpperString(keywordValue);
            if (upperString.endsWith("ZZZZ")) {
                return upperString.substring(0, 2);
            }
        }
        String country = uLocale.getCountry();
        if (country.length() != 0 || !z) {
            return country;
        }
        return addLikelySubtags(uLocale).getCountry();
    }

    public String getVariant() {
        return base().getVariant();
    }

    public static String getFallback(String str) {
        return getFallbackString(getName(str));
    }

    public ULocale getFallback() {
        if (this.localeID.length() == 0 || this.localeID.charAt(0) == '@') {
            return null;
        }
        return new ULocale(getFallbackString(this.localeID), null);
    }

    private static String getFallbackString(String str) {
        int indexOf = str.indexOf(64);
        if (indexOf == -1) {
            indexOf = str.length();
        }
        int lastIndexOf = str.lastIndexOf(95, indexOf);
        if (lastIndexOf == -1) {
            lastIndexOf = 0;
        } else {
            while (lastIndexOf > 0 && str.charAt(lastIndexOf - 1) == '_') {
                lastIndexOf--;
            }
        }
        return str.substring(0, lastIndexOf) + str.substring(indexOf);
    }

    public String getBaseName() {
        return getBaseName(this.localeID);
    }

    public static String getBaseName(String str) {
        if (str.indexOf(64) == -1) {
            return str;
        }
        return new LocaleIDParser(str).getBaseName();
    }

    public String getName() {
        return this.localeID;
    }

    private static int getShortestSubtagLength(String str) {
        int length = str.length();
        int i = length;
        boolean z = true;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) == '_' || str.charAt(i3) == '-') {
                if (i2 != 0 && i2 < i) {
                    i = i2;
                }
                z = true;
            } else {
                if (z) {
                    z = false;
                    i2 = 0;
                }
                i2++;
            }
        }
        return i;
    }

    public static String getName(String str) {
        String str2;
        if (str == null || str.contains("@") || getShortestSubtagLength(str) != 1) {
            str2 = str;
        } else {
            str2 = forLanguageTag(str).getName();
            if (str2.length() == 0) {
                str2 = str;
            }
        }
        return nameCache.getInstance(str2, null);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.localeID;
    }

    public Iterator<String> getKeywords() {
        return getKeywords(this.localeID);
    }

    public static Iterator<String> getKeywords(String str) {
        return new LocaleIDParser(str).getKeywords();
    }

    public String getKeywordValue(String str) {
        return getKeywordValue(this.localeID, str);
    }

    public static String getKeywordValue(String str, String str2) {
        return new LocaleIDParser(str).getKeywordValue(str2);
    }

    public static String canonicalize(String str) {
        LocaleIDParser localeIDParser = new LocaleIDParser(str, true);
        String baseName = localeIDParser.getBaseName();
        boolean z = false;
        if (str.equals("")) {
            return "";
        }
        int i = 0;
        while (true) {
            if (i >= variantsToKeywords.length) {
                break;
            }
            String[] strArr = variantsToKeywords[i];
            int lastIndexOf = baseName.lastIndexOf("_" + strArr[0]);
            if (lastIndexOf > -1) {
                z = true;
                baseName = baseName.substring(0, lastIndexOf);
                if (baseName.endsWith("_")) {
                    baseName = baseName.substring(0, lastIndexOf - 1);
                }
                localeIDParser.setBaseName(baseName);
                localeIDParser.defaultKeywordValue(strArr[1], strArr[2]);
            } else {
                i++;
            }
        }
        int i2 = 0;
        while (true) {
            if (i2 >= CANONICALIZE_MAP.length) {
                break;
            } else if (CANONICALIZE_MAP[i2][0].equals(baseName)) {
                z = true;
                String[] strArr2 = CANONICALIZE_MAP[i2];
                localeIDParser.setBaseName(strArr2[1]);
                if (strArr2[2] != null) {
                    localeIDParser.defaultKeywordValue(strArr2[2], strArr2[3]);
                }
            } else {
                i2++;
            }
        }
        if (!z && localeIDParser.getLanguage().equals("nb") && localeIDParser.getVariant().equals("NY")) {
            localeIDParser.setBaseName(lscvToID("nn", localeIDParser.getScript(), localeIDParser.getCountry(), null));
        }
        return localeIDParser.getName();
    }

    public ULocale setKeywordValue(String str, String str2) {
        return new ULocale(setKeywordValue(this.localeID, str, str2), null);
    }

    public static String setKeywordValue(String str, String str2, String str3) {
        LocaleIDParser localeIDParser = new LocaleIDParser(str);
        localeIDParser.setKeywordValue(str2, str3);
        return localeIDParser.getName();
    }

    public String getDisplayName() {
        return getDisplayNameInternal(this, getDefault(Category.DISPLAY));
    }

    private static String getDisplayNameInternal(ULocale uLocale, ULocale uLocale2) {
        return LocaleDisplayNames.getInstance(uLocale2).localeDisplayName(uLocale);
    }

    public static final class Type {
        private Type() {
        }
    }

    public static ULocale addLikelySubtags(ULocale uLocale) {
        String[] strArr = new String[3];
        String str = null;
        int parseTagString = parseTagString(uLocale.localeID, strArr);
        if (parseTagString < uLocale.localeID.length()) {
            str = uLocale.localeID.substring(parseTagString);
        }
        String createLikelySubtagsString = createLikelySubtagsString(strArr[0], strArr[1], strArr[2], str);
        return createLikelySubtagsString == null ? uLocale : new ULocale(createLikelySubtagsString);
    }

    private static boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }

    private static void appendTag(String str, StringBuilder sb) {
        if (sb.length() != 0) {
            sb.append('_');
        }
        sb.append(str);
    }

    private static String createTagString(String str, String str2, String str3, String str4, String str5) {
        LocaleIDParser localeIDParser = null;
        boolean z = false;
        StringBuilder sb = new StringBuilder();
        if (!isEmptyString(str)) {
            appendTag(str, sb);
        } else if (isEmptyString(str5)) {
            appendTag("und", sb);
        } else {
            localeIDParser = new LocaleIDParser(str5);
            String language = localeIDParser.getLanguage();
            appendTag(!isEmptyString(language) ? language : "und", sb);
        }
        if (!isEmptyString(str2)) {
            appendTag(str2, sb);
        } else if (!isEmptyString(str5)) {
            if (localeIDParser == null) {
                localeIDParser = new LocaleIDParser(str5);
            }
            String script = localeIDParser.getScript();
            if (!isEmptyString(script)) {
                appendTag(script, sb);
            }
        }
        if (!isEmptyString(str3)) {
            appendTag(str3, sb);
            z = true;
        } else if (!isEmptyString(str5)) {
            if (localeIDParser == null) {
                localeIDParser = new LocaleIDParser(str5);
            }
            String country = localeIDParser.getCountry();
            if (!isEmptyString(country)) {
                appendTag(country, sb);
                z = true;
            }
        }
        if (str4 != null && str4.length() > 1) {
            char c = 0;
            if (str4.charAt(0) != '_') {
                c = 1;
            } else if (str4.charAt(1) == '_') {
                c = 2;
            }
            if (!z) {
                if (c == 1) {
                    sb.append('_');
                }
                sb.append(str4);
            } else if (c == 2) {
                sb.append(str4.substring(1));
            } else {
                sb.append(str4);
            }
        }
        return sb.toString();
    }

    static String createTagString(String str, String str2, String str3, String str4) {
        return createTagString(str, str2, str3, str4, null);
    }

    private static int parseTagString(String str, String[] strArr) {
        LocaleIDParser localeIDParser = new LocaleIDParser(str);
        String language = localeIDParser.getLanguage();
        String script = localeIDParser.getScript();
        String country = localeIDParser.getCountry();
        if (isEmptyString(language)) {
            strArr[0] = "und";
        } else {
            strArr[0] = language;
        }
        if (script.equals("Zzzz")) {
            strArr[1] = "";
        } else {
            strArr[1] = script;
        }
        if (country.equals("ZZ")) {
            strArr[2] = "";
        } else {
            strArr[2] = country;
        }
        String variant = localeIDParser.getVariant();
        if (!isEmptyString(variant)) {
            int indexOf = str.indexOf(variant);
            return indexOf > 0 ? indexOf - 1 : indexOf;
        }
        int indexOf2 = str.indexOf(64);
        return indexOf2 == -1 ? str.length() : indexOf2;
    }

    private static String lookupLikelySubtags(String str) {
        try {
            return UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "likelySubtags").getString(str);
        } catch (MissingResourceException e) {
            return null;
        }
    }

    private static String createLikelySubtagsString(String str, String str2, String str3, String str4) {
        String lookupLikelySubtags;
        String lookupLikelySubtags2;
        String lookupLikelySubtags3;
        if (!isEmptyString(str2) && !isEmptyString(str3) && (lookupLikelySubtags3 = lookupLikelySubtags(createTagString(str, str2, str3, null))) != null) {
            return createTagString(null, null, null, str4, lookupLikelySubtags3);
        }
        if (!isEmptyString(str2) && (lookupLikelySubtags2 = lookupLikelySubtags(createTagString(str, str2, null, null))) != null) {
            return createTagString(null, null, str3, str4, lookupLikelySubtags2);
        }
        if (!isEmptyString(str3) && (lookupLikelySubtags = lookupLikelySubtags(createTagString(str, null, str3, null))) != null) {
            return createTagString(null, str2, null, str4, lookupLikelySubtags);
        }
        String lookupLikelySubtags4 = lookupLikelySubtags(createTagString(str, null, null, null));
        if (lookupLikelySubtags4 != null) {
            return createTagString(null, str2, str3, str4, lookupLikelySubtags4);
        }
        return null;
    }

    public String toLanguageTag() {
        BaseLocale base = base();
        LocaleExtensions extensions2 = extensions();
        if (base.getVariant().equalsIgnoreCase("POSIX")) {
            base = BaseLocale.getInstance(base.getLanguage(), base.getScript(), base.getRegion(), "");
            if (extensions2.getUnicodeLocaleType("va") == null) {
                InternalLocaleBuilder internalLocaleBuilder = new InternalLocaleBuilder();
                try {
                    internalLocaleBuilder.setLocale(BaseLocale.ROOT, extensions2);
                    internalLocaleBuilder.setUnicodeLocaleKeyword("va", "posix");
                    extensions2 = internalLocaleBuilder.getLocaleExtensions();
                } catch (LocaleSyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        LanguageTag parseLocale = LanguageTag.parseLocale(base, extensions2);
        StringBuilder sb = new StringBuilder();
        String language = parseLocale.getLanguage();
        if (language.length() > 0) {
            sb.append(LanguageTag.canonicalizeLanguage(language));
        }
        String script = parseLocale.getScript();
        if (script.length() > 0) {
            sb.append("-");
            sb.append(LanguageTag.canonicalizeScript(script));
        }
        String region = parseLocale.getRegion();
        if (region.length() > 0) {
            sb.append("-");
            sb.append(LanguageTag.canonicalizeRegion(region));
        }
        for (String str : parseLocale.getVariants()) {
            sb.append("-");
            sb.append(LanguageTag.canonicalizeVariant(str));
        }
        for (String str2 : parseLocale.getExtensions()) {
            sb.append("-");
            sb.append(LanguageTag.canonicalizeExtension(str2));
        }
        String privateuse = parseLocale.getPrivateuse();
        if (privateuse.length() > 0) {
            if (sb.length() > 0) {
                sb.append("-");
            }
            sb.append("x").append("-");
            sb.append(LanguageTag.canonicalizePrivateuse(privateuse));
        }
        return sb.toString();
    }

    public static ULocale forLanguageTag(String str) {
        LanguageTag parse = LanguageTag.parse(str, null);
        InternalLocaleBuilder internalLocaleBuilder = new InternalLocaleBuilder();
        internalLocaleBuilder.setLanguageTag(parse);
        return getInstance(internalLocaleBuilder.getBaseLocale(), internalLocaleBuilder.getLocaleExtensions());
    }

    public static String toUnicodeLocaleKey(String str) {
        String bcpKey = KeyTypeData.toBcpKey(str);
        if (bcpKey != null || !UnicodeLocaleExtension.isKey(str)) {
            return bcpKey;
        }
        return AsciiUtil.toLowerString(str);
    }

    public static String toUnicodeLocaleType(String str, String str2) {
        String bcpType = KeyTypeData.toBcpType(str, str2, null, null);
        if (bcpType != null || !UnicodeLocaleExtension.isType(str2)) {
            return bcpType;
        }
        return AsciiUtil.toLowerString(str2);
    }

    public static String toLegacyKey(String str) {
        String legacyKey = KeyTypeData.toLegacyKey(str);
        if (legacyKey != null || !str.matches("[0-9a-zA-Z]+")) {
            return legacyKey;
        }
        return AsciiUtil.toLowerString(str);
    }

    public static String toLegacyType(String str, String str2) {
        String legacyType = KeyTypeData.toLegacyType(str, str2, null, null);
        if (legacyType != null || !str2.matches("[0-9a-zA-Z]+([_/\\-][0-9a-zA-Z]+)*")) {
            return legacyType;
        }
        return AsciiUtil.toLowerString(str2);
    }

    private static ULocale getInstance(BaseLocale baseLocale2, LocaleExtensions localeExtensions) {
        String lscvToID = lscvToID(baseLocale2.getLanguage(), baseLocale2.getScript(), baseLocale2.getRegion(), baseLocale2.getVariant());
        Set<Character> keys = localeExtensions.getKeys();
        if (!keys.isEmpty()) {
            TreeMap treeMap = new TreeMap();
            for (Character ch : keys) {
                Extension extension = localeExtensions.getExtension(ch);
                if (extension instanceof UnicodeLocaleExtension) {
                    UnicodeLocaleExtension unicodeLocaleExtension = (UnicodeLocaleExtension) extension;
                    for (String str : unicodeLocaleExtension.getUnicodeLocaleKeys()) {
                        String unicodeLocaleType = unicodeLocaleExtension.getUnicodeLocaleType(str);
                        String legacyKey = toLegacyKey(str);
                        String legacyType = toLegacyType(str, unicodeLocaleType.length() == 0 ? "yes" : unicodeLocaleType);
                        if (!legacyKey.equals("va") || !legacyType.equals("posix") || baseLocale2.getVariant().length() != 0) {
                            treeMap.put(legacyKey, legacyType);
                        } else {
                            lscvToID = lscvToID + "_POSIX";
                        }
                    }
                    Set<String> unicodeLocaleAttributes = unicodeLocaleExtension.getUnicodeLocaleAttributes();
                    if (unicodeLocaleAttributes.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str2 : unicodeLocaleAttributes) {
                            if (sb.length() > 0) {
                                sb.append('-');
                            }
                            sb.append(str2);
                        }
                        treeMap.put("attribute", sb.toString());
                    }
                } else {
                    treeMap.put(String.valueOf(ch), extension.getValue());
                }
            }
            if (!treeMap.isEmpty()) {
                StringBuilder sb2 = new StringBuilder(lscvToID);
                sb2.append("@");
                boolean z = false;
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (z) {
                        sb2.append(";");
                    } else {
                        z = true;
                    }
                    sb2.append((String) entry.getKey());
                    sb2.append("=");
                    sb2.append((String) entry.getValue());
                }
                lscvToID = sb2.toString();
            }
        }
        return new ULocale(lscvToID);
    }

    private BaseLocale base() {
        if (this.baseLocale == null) {
            String str = "";
            String str2 = str;
            String str3 = str;
            String str4 = str;
            if (!equals(ROOT)) {
                LocaleIDParser localeIDParser = new LocaleIDParser(this.localeID);
                str = localeIDParser.getLanguage();
                str4 = localeIDParser.getScript();
                str3 = localeIDParser.getCountry();
                str2 = localeIDParser.getVariant();
            }
            this.baseLocale = BaseLocale.getInstance(str, str4, str3, str2);
        }
        return this.baseLocale;
    }

    private LocaleExtensions extensions() {
        if (this.extensions == null) {
            Iterator<String> keywords = getKeywords();
            if (keywords == null) {
                this.extensions = LocaleExtensions.EMPTY_EXTENSIONS;
            } else {
                InternalLocaleBuilder internalLocaleBuilder = new InternalLocaleBuilder();
                while (keywords.hasNext()) {
                    String next = keywords.next();
                    if (next.equals("attribute")) {
                        for (String str : getKeywordValue(next).split("[-_]")) {
                            try {
                                internalLocaleBuilder.addUnicodeLocaleAttribute(str);
                            } catch (LocaleSyntaxException e) {
                            }
                        }
                    } else if (next.length() >= 2) {
                        String unicodeLocaleKey = toUnicodeLocaleKey(next);
                        String unicodeLocaleType = toUnicodeLocaleType(next, getKeywordValue(next));
                        if (!(unicodeLocaleKey == null || unicodeLocaleType == null)) {
                            try {
                                internalLocaleBuilder.setUnicodeLocaleKeyword(unicodeLocaleKey, unicodeLocaleType);
                            } catch (LocaleSyntaxException e2) {
                            }
                        }
                    } else if (next.length() == 1 && next.charAt(0) != 'u') {
                        try {
                            internalLocaleBuilder.setExtension(next.charAt(0), getKeywordValue(next).replace("_", "-"));
                        } catch (LocaleSyntaxException e3) {
                        }
                    }
                }
                this.extensions = internalLocaleBuilder.getLocaleExtensions();
            }
        }
        return this.extensions;
    }

    /* access modifiers changed from: package-private */
    public static final class JDKLocaleHelper {
        private static final String[][] JAVA6_MAPDATA = {new String[]{"ja_JP_JP", "ja_JP", "calendar", "japanese", "ja"}, new String[]{"no_NO_NY", "nn_NO", null, null, "nn"}, new String[]{"th_TH_TH", "th_TH", "numbers", "thai", "th"}};
        private static Object eDISPLAY;
        private static Object eFORMAT;
        private static boolean hasLocaleCategories;
        private static boolean hasScriptsAndUnicodeExtensions;
        private static Method mForLanguageTag;
        private static Method mGetDefault;
        private static Method mGetExtension;
        private static Method mGetExtensionKeys;
        private static Method mGetScript;
        private static Method mGetUnicodeLocaleAttributes;
        private static Method mGetUnicodeLocaleKeys;
        private static Method mGetUnicodeLocaleType;
        private static Method mSetDefault;

        static {
            hasScriptsAndUnicodeExtensions = false;
            hasLocaleCategories = false;
            try {
                mGetScript = Locale.class.getMethod("getScript", null);
                mGetExtensionKeys = Locale.class.getMethod("getExtensionKeys", null);
                mGetExtension = Locale.class.getMethod("getExtension", Character.TYPE);
                mGetUnicodeLocaleKeys = Locale.class.getMethod("getUnicodeLocaleKeys", null);
                mGetUnicodeLocaleAttributes = Locale.class.getMethod("getUnicodeLocaleAttributes", null);
                mGetUnicodeLocaleType = Locale.class.getMethod("getUnicodeLocaleType", String.class);
                mForLanguageTag = Locale.class.getMethod("forLanguageTag", String.class);
                hasScriptsAndUnicodeExtensions = true;
            } catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
            }
            Class<?> cls = null;
            try {
                Class<?>[] declaredClasses = Locale.class.getDeclaredClasses();
                int length = declaredClasses.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Class<?> cls2 = declaredClasses[i];
                    if (cls2.getName().equals("java.util.Locale$Category")) {
                        cls = cls2;
                        break;
                    }
                    i++;
                }
                if (cls != null) {
                    mGetDefault = Locale.class.getDeclaredMethod("getDefault", cls);
                    mSetDefault = Locale.class.getDeclaredMethod("setDefault", cls, Locale.class);
                    Method method = cls.getMethod("name", null);
                    Object[] enumConstants = cls.getEnumConstants();
                    for (Object obj : enumConstants) {
                        String str = (String) method.invoke(obj, null);
                        if (str.equals("DISPLAY")) {
                            eDISPLAY = obj;
                        } else if (str.equals("FORMAT")) {
                            eFORMAT = obj;
                        }
                    }
                    if (!(eDISPLAY == null || eFORMAT == null)) {
                        hasLocaleCategories = true;
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            }
        }

        public static boolean hasLocaleCategories() {
            return hasLocaleCategories;
        }

        public static ULocale toULocale(Locale locale) {
            return hasScriptsAndUnicodeExtensions ? toULocale7(locale) : toULocale6(locale);
        }

        public static Locale toLocale(ULocale uLocale) {
            return hasScriptsAndUnicodeExtensions ? toLocale7(uLocale) : toLocale6(uLocale);
        }

        private static ULocale toULocale7(Locale locale) {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            TreeSet<String> treeSet = null;
            TreeMap treeMap = null;
            try {
                String str = (String) mGetScript.invoke(locale, null);
                Set<Character> set = (Set) mGetExtensionKeys.invoke(locale, null);
                if (!set.isEmpty()) {
                    for (Character ch : set) {
                        if (ch.charValue() == 'u') {
                            Set<String> set2 = (Set) mGetUnicodeLocaleAttributes.invoke(locale, null);
                            if (!set2.isEmpty()) {
                                treeSet = new TreeSet();
                                for (String str2 : set2) {
                                    treeSet.add(str2);
                                }
                            }
                            for (String str3 : (Set) mGetUnicodeLocaleKeys.invoke(locale, null)) {
                                String str4 = (String) mGetUnicodeLocaleType.invoke(locale, str3);
                                if (str4 != null) {
                                    if (str3.equals("va")) {
                                        variant = variant.length() == 0 ? str4 : str4 + "_" + variant;
                                    } else {
                                        if (treeMap == null) {
                                            treeMap = new TreeMap();
                                        }
                                        treeMap.put(str3, str4);
                                    }
                                }
                            }
                        } else {
                            String str5 = (String) mGetExtension.invoke(locale, ch);
                            if (str5 != null) {
                                if (treeMap == null) {
                                    treeMap = new TreeMap();
                                }
                                treeMap.put(String.valueOf(ch), str5);
                            }
                        }
                    }
                }
                if (language.equals("no") && country.equals("NO") && variant.equals("NY")) {
                    language = "nn";
                    variant = "";
                }
                StringBuilder sb = new StringBuilder(language);
                if (str.length() > 0) {
                    sb.append('_');
                    sb.append(str);
                }
                if (country.length() > 0) {
                    sb.append('_');
                    sb.append(country);
                }
                if (variant.length() > 0) {
                    if (country.length() == 0) {
                        sb.append('_');
                    }
                    sb.append('_');
                    sb.append(variant);
                }
                if (treeSet != null) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str6 : treeSet) {
                        if (sb2.length() != 0) {
                            sb2.append('-');
                        }
                        sb2.append(str6);
                    }
                    if (treeMap == null) {
                        treeMap = new TreeMap();
                    }
                    treeMap.put("attribute", sb2.toString());
                }
                if (treeMap != null) {
                    sb.append('@');
                    boolean z = false;
                    for (Map.Entry entry : treeMap.entrySet()) {
                        String str7 = (String) entry.getKey();
                        String str8 = (String) entry.getValue();
                        if (str7.length() != 1) {
                            str7 = ULocale.toLegacyKey(str7);
                            str8 = ULocale.toLegacyType(str7, str8.length() == 0 ? "yes" : str8);
                        }
                        if (z) {
                            sb.append(';');
                        } else {
                            z = true;
                        }
                        sb.append(str7);
                        sb.append('=');
                        sb.append(str8);
                    }
                }
                return new ULocale(ULocale.getName(sb.toString()), locale);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }

        private static ULocale toULocale6(Locale locale) {
            String locale2 = locale.toString();
            if (locale2.length() == 0) {
                return ULocale.ROOT;
            }
            int i = 0;
            while (true) {
                if (i >= JAVA6_MAPDATA.length) {
                    break;
                } else if (JAVA6_MAPDATA[i][0].equals(locale2)) {
                    LocaleIDParser localeIDParser = new LocaleIDParser(JAVA6_MAPDATA[i][1]);
                    localeIDParser.setKeywordValue(JAVA6_MAPDATA[i][2], JAVA6_MAPDATA[i][3]);
                    locale2 = localeIDParser.getName();
                    break;
                } else {
                    i++;
                }
            }
            return new ULocale(ULocale.getName(locale2), locale);
        }

        private static Locale toLocale7(ULocale uLocale) {
            Locale locale = null;
            String name = uLocale.getName();
            if (uLocale.getScript().length() > 0 || name.contains("@")) {
                try {
                    locale = (Locale) mForLanguageTag.invoke(null, AsciiUtil.toUpperString(uLocale.toLanguageTag()));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2);
                }
            }
            if (locale == null) {
                return new Locale(uLocale.getLanguage(), uLocale.getCountry(), uLocale.getVariant());
            }
            return locale;
        }

        private static Locale toLocale6(ULocale uLocale) {
            String baseName = uLocale.getBaseName();
            int i = 0;
            while (true) {
                if (i >= JAVA6_MAPDATA.length) {
                    break;
                }
                if (baseName.equals(JAVA6_MAPDATA[i][1]) || baseName.equals(JAVA6_MAPDATA[i][4])) {
                    if (JAVA6_MAPDATA[i][2] == null) {
                        baseName = JAVA6_MAPDATA[i][0];
                        break;
                    }
                    String keywordValue = uLocale.getKeywordValue(JAVA6_MAPDATA[i][2]);
                    if (keywordValue != null && keywordValue.equals(JAVA6_MAPDATA[i][3])) {
                        baseName = JAVA6_MAPDATA[i][0];
                        break;
                    }
                }
                i++;
            }
            String[] languageScriptCountryVariant = new LocaleIDParser(baseName).getLanguageScriptCountryVariant();
            return new Locale(languageScriptCountryVariant[0], languageScriptCountryVariant[2], languageScriptCountryVariant[3]);
        }

        public static Locale getDefault(Category category) {
            Locale locale = Locale.getDefault();
            if (!hasLocaleCategories) {
                return locale;
            }
            Object obj = null;
            switch (category) {
                case DISPLAY:
                    obj = eDISPLAY;
                    break;
                case FORMAT:
                    obj = eFORMAT;
                    break;
            }
            if (obj == null) {
                return locale;
            }
            try {
                return (Locale) mGetDefault.invoke(null, obj);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                return locale;
            }
        }

        public static boolean isOriginalDefaultLocale(Locale locale) {
            if (!hasScriptsAndUnicodeExtensions) {
                return locale.getLanguage().equals(getSystemProperty("user.language")) && locale.getCountry().equals(getSystemProperty("user.country")) && locale.getVariant().equals(getSystemProperty("user.variant"));
            }
            try {
                return locale.getLanguage().equals(getSystemProperty("user.language")) && locale.getCountry().equals(getSystemProperty("user.country")) && locale.getVariant().equals(getSystemProperty("user.variant")) && ((String) mGetScript.invoke(locale, null)).equals(getSystemProperty("user.script"));
            } catch (Exception e) {
                return false;
            }
        }

        public static String getSystemProperty(final String str) {
            if (System.getSecurityManager() == null) {
                return System.getProperty(str);
            }
            try {
                return (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: com.ibm.icu.util.ULocale.JDKLocaleHelper.1
                    @Override // java.security.PrivilegedAction
                    public String run() {
                        return System.getProperty(str);
                    }
                });
            } catch (AccessControlException e) {
                return null;
            }
        }
    }
}
