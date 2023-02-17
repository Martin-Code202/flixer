package com.ibm.icu.util;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.TextTrieMap;
import com.ibm.icu.text.CurrencyDisplayNames;
import com.ibm.icu.text.CurrencyMetaInfo;
import com.ibm.icu.util.MeasureUnit;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
public class Currency extends MeasureUnit {
    private static ICUCache<ULocale, List<TextTrieMap<CurrencyStringInfo>>> CURRENCY_NAME_CACHE = new SimpleCache();
    private static final boolean DEBUG = ICUDebug.enabled("currency");
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final EquivalenceRelation<String> EQUIVALENT_CURRENCY_SYMBOLS = new EquivalenceRelation().add("¥", "￥").add("$", "﹩", "＄").add("₨", "₹").add("£", "₤");
    private static final int[] POW10 = {1, 10, 100, 1000, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS, 100000, 1000000, 10000000, 100000000, 1000000000};
    private static final ULocale UND = new ULocale("und");
    private static final CacheBase<String, Currency, Void> regionCurrencyCache = new SoftCache<String, Currency, Void>() { // from class: com.ibm.icu.util.Currency.1
        /* access modifiers changed from: protected */
        public Currency createInstance(String str, Void r3) {
            return Currency.loadCurrency(str);
        }
    };
    private static final long serialVersionUID = -5839973855554750484L;
    private static ServiceShim shim = null;
    private final String isoCode;

    public enum CurrencyUsage {
        STANDARD,
        CASH
    }

    static abstract class ServiceShim {
        /* access modifiers changed from: package-private */
        public abstract Currency createInstance(ULocale uLocale);

        ServiceShim() {
        }
    }

    public static Currency getInstance(ULocale uLocale) {
        String keywordValue = uLocale.getKeywordValue("currency");
        if (keywordValue != null) {
            return getInstance(keywordValue);
        }
        if (shim == null) {
            return createCurrency(uLocale);
        }
        return shim.createInstance(uLocale);
    }

    static Currency createCurrency(ULocale uLocale) {
        String variant = uLocale.getVariant();
        if ("EURO".equals(variant)) {
            return getInstance("EUR");
        }
        String regionForSupplementalData = ULocale.getRegionForSupplementalData(uLocale, false);
        if ("PREEURO".equals(variant)) {
            regionForSupplementalData = regionForSupplementalData + '-';
        }
        return regionCurrencyCache.getInstance(regionForSupplementalData, null);
    }

    /* access modifiers changed from: private */
    public static Currency loadCurrency(String str) {
        boolean z;
        String str2;
        if (str.endsWith("-")) {
            str2 = str.substring(0, str.length() - 1);
            z = true;
        } else {
            str2 = str;
            z = false;
        }
        List<String> currencies = CurrencyMetaInfo.getInstance().currencies(CurrencyMetaInfo.CurrencyFilter.onRegion(str2));
        if (currencies.isEmpty()) {
            return null;
        }
        String str3 = currencies.get(0);
        if (z && "EUR".equals(str3)) {
            if (currencies.size() < 2) {
                return null;
            }
            str3 = currencies.get(1);
        }
        return getInstance(str3);
    }

    public static Currency getInstance(String str) {
        if (str == null) {
            throw new NullPointerException("The input currency code is null.");
        } else if (isAlpha3Code(str)) {
            return (Currency) MeasureUnit.internalGetInstance("currency", str.toUpperCase(Locale.ENGLISH));
        } else {
            throw new IllegalArgumentException("The input currency code is not 3-letter alphabetic code.");
        }
    }

    private static boolean isAlpha3Code(String str) {
        if (str.length() != 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            char charAt = str.charAt(i);
            if (charAt < 'A') {
                return false;
            }
            if ((charAt > 'Z' && charAt < 'a') || charAt > 'z') {
                return false;
            }
        }
        return true;
    }

    public String getCurrencyCode() {
        return this.subType;
    }

    public String getSymbol(Locale locale) {
        return getSymbol(ULocale.forLocale(locale));
    }

    public String getSymbol(ULocale uLocale) {
        return getName(uLocale, 0, new boolean[1]);
    }

    public String getName(ULocale uLocale, int i, boolean[] zArr) {
        if (i == 0 || i == 1) {
            if (zArr != null) {
                zArr[0] = false;
            }
            CurrencyDisplayNames instance = CurrencyDisplayNames.getInstance(uLocale);
            return i == 0 ? instance.getSymbol(this.subType) : instance.getName(this.subType);
        }
        throw new IllegalArgumentException("bad name style: " + i);
    }

    public String getName(ULocale uLocale, int i, String str, boolean[] zArr) {
        if (i != 2) {
            return getName(uLocale, i, zArr);
        }
        if (zArr != null) {
            zArr[0] = false;
        }
        return CurrencyDisplayNames.getInstance(uLocale).getPluralName(this.subType, str);
    }

    @Deprecated
    public static TextTrieMap<CurrencyStringInfo>.ParseState openParseState(ULocale uLocale, int i, int i2) {
        List<TextTrieMap<CurrencyStringInfo>> currencyTrieVec = getCurrencyTrieVec(uLocale);
        if (i2 == 1) {
            return currencyTrieVec.get(0).openParseState(i);
        }
        return currencyTrieVec.get(1).openParseState(i);
    }

    private static List<TextTrieMap<CurrencyStringInfo>> getCurrencyTrieVec(ULocale uLocale) {
        List<TextTrieMap<CurrencyStringInfo>> list = CURRENCY_NAME_CACHE.get(uLocale);
        if (list != null) {
            return list;
        }
        TextTrieMap textTrieMap = new TextTrieMap(true);
        TextTrieMap textTrieMap2 = new TextTrieMap(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(textTrieMap2);
        arrayList.add(textTrieMap);
        setupCurrencyTrieVec(uLocale, arrayList);
        CURRENCY_NAME_CACHE.put(uLocale, arrayList);
        return arrayList;
    }

    private static void setupCurrencyTrieVec(ULocale uLocale, List<TextTrieMap<CurrencyStringInfo>> list) {
        TextTrieMap<CurrencyStringInfo> textTrieMap = list.get(0);
        TextTrieMap<CurrencyStringInfo> textTrieMap2 = list.get(1);
        CurrencyDisplayNames instance = CurrencyDisplayNames.getInstance(uLocale);
        for (Map.Entry<String, String> entry : instance.symbolMap().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            for (String str : EQUIVALENT_CURRENCY_SYMBOLS.get(key)) {
                textTrieMap.put(str, new CurrencyStringInfo(value, key));
            }
        }
        for (Map.Entry<String, String> entry2 : instance.nameMap().entrySet()) {
            String key2 = entry2.getKey();
            textTrieMap2.put(key2, new CurrencyStringInfo(entry2.getValue(), key2));
        }
    }

    @Deprecated
    public static final class CurrencyStringInfo {
        private String currencyString;
        private String isoCode;

        @Deprecated
        public CurrencyStringInfo(String str, String str2) {
            this.isoCode = str;
            this.currencyString = str2;
        }

        @Deprecated
        public String getISOCode() {
            return this.isoCode;
        }
    }

    public int getDefaultFractionDigits(CurrencyUsage currencyUsage) {
        return CurrencyMetaInfo.getInstance().currencyDigits(this.subType, currencyUsage).fractionDigits;
    }

    public double getRoundingIncrement(CurrencyUsage currencyUsage) {
        int i;
        CurrencyMetaInfo.CurrencyDigits currencyDigits = CurrencyMetaInfo.getInstance().currencyDigits(this.subType, currencyUsage);
        int i2 = currencyDigits.roundingIncrement;
        if (i2 != 0 && (i = currencyDigits.fractionDigits) >= 0 && i < POW10.length) {
            return ((double) i2) / ((double) POW10[i]);
        }
        return 0.0d;
    }

    @Override // com.ibm.icu.util.MeasureUnit, java.lang.Object
    public String toString() {
        return this.subType;
    }

    protected Currency(String str) {
        super("currency", str);
        this.isoCode = str;
    }

    /* access modifiers changed from: package-private */
    public static final class EquivalenceRelation<T> {
        private Map<T, Set<T>> data;

        private EquivalenceRelation() {
            this.data = new HashMap();
        }

        public EquivalenceRelation<T> add(T... tArr) {
            HashSet hashSet = new HashSet();
            for (T t : tArr) {
                if (this.data.containsKey(t)) {
                    throw new IllegalArgumentException("All groups passed to add must be disjoint.");
                }
                hashSet.add(t);
            }
            for (T t2 : tArr) {
                this.data.put(t2, hashSet);
            }
            return this;
        }

        public Set<T> get(T t) {
            Set<T> set = this.data.get(t);
            if (set == null) {
                return Collections.singleton(t);
            }
            return Collections.unmodifiableSet(set);
        }
    }

    private Object writeReplace() {
        return new MeasureUnit.MeasureUnitProxy(this.type, this.subType);
    }

    private Object readResolve() {
        return getInstance(this.isoCode);
    }
}
