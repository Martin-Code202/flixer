package com.ibm.icu.impl;

import com.ibm.icu.impl.CurrencyData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;
public class ICUCurrencyDisplayInfoProvider implements CurrencyData.CurrencyDisplayInfoProvider {
    @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfoProvider
    public CurrencyData.CurrencyDisplayInfo getInstance(ULocale uLocale, boolean z) {
        ICUResourceBundle iCUResourceBundle;
        if (z) {
            iCUResourceBundle = ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/curr", uLocale, ICUResourceBundle.OpenType.LOCALE_DEFAULT_ROOT);
        } else {
            try {
                iCUResourceBundle = ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/curr", uLocale, ICUResourceBundle.OpenType.LOCALE_ONLY);
            } catch (MissingResourceException e) {
                return null;
            }
        }
        return new ICUCurrencyDisplayInfo(iCUResourceBundle, z);
    }

    static class ICUCurrencyDisplayInfo extends CurrencyData.CurrencyDisplayInfo {
        private SoftReference<Map<String, String>> _nameMapRef;
        private SoftReference<Map<String, String>> _symbolMapRef;
        private final ICUResourceBundle currencies;
        private final boolean fallback;
        private final ICUResourceBundle plurals;
        private final ICUResourceBundle rb;

        public ICUCurrencyDisplayInfo(ICUResourceBundle iCUResourceBundle, boolean z) {
            this.fallback = z;
            this.rb = iCUResourceBundle;
            this.currencies = iCUResourceBundle.findTopLevel("Currencies");
            this.plurals = iCUResourceBundle.findTopLevel("CurrencyPlurals");
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getName(String str) {
            return getName(str, false);
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getSymbol(String str) {
            return getName(str, true);
        }

        private String getName(String str, boolean z) {
            ICUResourceBundle findWithFallback;
            if (this.currencies == null || (findWithFallback = this.currencies.findWithFallback(str)) == null) {
                if (this.fallback) {
                    return str;
                }
                return null;
            } else if (!this.fallback && !this.rb.isRoot() && findWithFallback.isRoot()) {
                return null;
            } else {
                return findWithFallback.getString(z ? 0 : 1);
            }
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getPluralName(String str, String str2) {
            ICUResourceBundle findWithFallback;
            if (this.plurals != null && (findWithFallback = this.plurals.findWithFallback(str)) != null) {
                String findStringWithFallback = findWithFallback.findStringWithFallback(str2);
                if (findStringWithFallback == null) {
                    if (!this.fallback) {
                        return null;
                    }
                    findStringWithFallback = findWithFallback.findStringWithFallback("other");
                    if (findStringWithFallback == null) {
                        return getName(str);
                    }
                }
                return findStringWithFallback;
            } else if (this.fallback) {
                return getName(str);
            } else {
                return null;
            }
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public Map<String, String> symbolMap() {
            Map<String, String> map = this._symbolMapRef == null ? null : this._symbolMapRef.get();
            if (map != null) {
                return map;
            }
            Map<String, String> _createSymbolMap = _createSymbolMap();
            this._symbolMapRef = new SoftReference<>(_createSymbolMap);
            return _createSymbolMap;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public Map<String, String> nameMap() {
            Map<String, String> map = this._nameMapRef == null ? null : this._nameMapRef.get();
            if (map != null) {
                return map;
            }
            Map<String, String> _createNameMap = _createNameMap();
            this._nameMapRef = new SoftReference<>(_createNameMap);
            return _createNameMap;
        }

        @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfo
        public Map<String, String> getUnitPatterns() {
            ICUResourceBundle findWithFallback;
            HashMap hashMap = new HashMap();
            for (ULocale uLocale = this.rb.getULocale(); uLocale != null; uLocale = uLocale.getFallback()) {
                ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/curr", uLocale);
                if (!(iCUResourceBundle == null || (findWithFallback = iCUResourceBundle.findWithFallback("CurrencyUnitPatterns")) == null)) {
                    int size = findWithFallback.getSize();
                    for (int i = 0; i < size; i++) {
                        ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle) findWithFallback.get(i);
                        String key = iCUResourceBundle2.getKey();
                        if (!hashMap.containsKey(key)) {
                            hashMap.put(key, iCUResourceBundle2.getString());
                        }
                    }
                }
            }
            return Collections.unmodifiableMap(hashMap);
        }

        @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfo
        public CurrencyData.CurrencyFormatInfo getFormatInfo(String str) {
            ICUResourceBundle at;
            ICUResourceBundle findWithFallback = this.currencies.findWithFallback(str);
            if (findWithFallback == null || findWithFallback.getSize() <= 2 || (at = findWithFallback.at(2)) == null) {
                return null;
            }
            return new CurrencyData.CurrencyFormatInfo(at.getString(0), at.getString(1), at.getString(2));
        }

        @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfo
        public CurrencyData.CurrencySpacingInfo getSpacingInfo() {
            SpacingInfoSink spacingInfoSink = new SpacingInfoSink();
            this.rb.getAllItemsWithFallback("currencySpacing", spacingInfoSink);
            return spacingInfoSink.getSpacingInfo(this.fallback);
        }

        final class SpacingInfoSink extends UResource.Sink {
            boolean hasAfterCurrency;
            boolean hasBeforeCurrency;
            CurrencyData.CurrencySpacingInfo spacingInfo;

            private SpacingInfoSink() {
                this.spacingInfo = new CurrencyData.CurrencySpacingInfo();
                this.hasBeforeCurrency = false;
                this.hasAfterCurrency = false;
            }

            @Override // com.ibm.icu.impl.UResource.Sink
            public void put(UResource.Key key, UResource.Value value, boolean z) {
                CurrencyData.CurrencySpacingInfo.SpacingType spacingType;
                CurrencyData.CurrencySpacingInfo.SpacingPattern spacingPattern;
                UResource.Table table = value.getTable();
                for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                    if (key.contentEquals("beforeCurrency")) {
                        spacingType = CurrencyData.CurrencySpacingInfo.SpacingType.BEFORE;
                        this.hasBeforeCurrency = true;
                    } else if (key.contentEquals("afterCurrency")) {
                        spacingType = CurrencyData.CurrencySpacingInfo.SpacingType.AFTER;
                        this.hasAfterCurrency = true;
                    }
                    UResource.Table table2 = value.getTable();
                    for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                        if (key.contentEquals("currencyMatch")) {
                            spacingPattern = CurrencyData.CurrencySpacingInfo.SpacingPattern.CURRENCY_MATCH;
                        } else if (key.contentEquals("surroundingMatch")) {
                            spacingPattern = CurrencyData.CurrencySpacingInfo.SpacingPattern.SURROUNDING_MATCH;
                        } else if (key.contentEquals("insertBetween")) {
                            spacingPattern = CurrencyData.CurrencySpacingInfo.SpacingPattern.INSERT_BETWEEN;
                        }
                        this.spacingInfo.setSymbolIfNull(spacingType, spacingPattern, value.getString());
                    }
                }
            }

            /* access modifiers changed from: package-private */
            public CurrencyData.CurrencySpacingInfo getSpacingInfo(boolean z) {
                if (this.hasBeforeCurrency && this.hasAfterCurrency) {
                    return this.spacingInfo;
                }
                if (z) {
                    return CurrencyData.CurrencySpacingInfo.DEFAULT;
                }
                return null;
            }
        }

        private Map<String, String> _createSymbolMap() {
            HashMap hashMap = new HashMap();
            for (ULocale uLocale = this.rb.getULocale(); uLocale != null; uLocale = uLocale.getFallback()) {
                ICUResourceBundle findTopLevel = ((ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/curr", uLocale)).findTopLevel("Currencies");
                if (findTopLevel != null) {
                    for (int i = 0; i < findTopLevel.getSize(); i++) {
                        ICUResourceBundle at = findTopLevel.at(i);
                        String key = at.getKey();
                        if (!hashMap.containsKey(key)) {
                            hashMap.put(key, key);
                            hashMap.put(at.getString(0), key);
                        }
                    }
                }
            }
            return Collections.unmodifiableMap(hashMap);
        }

        private Map<String, String> _createNameMap() {
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            HashSet hashSet = new HashSet();
            HashMap hashMap = new HashMap();
            for (ULocale uLocale = this.rb.getULocale(); uLocale != null; uLocale = uLocale.getFallback()) {
                ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/curr", uLocale);
                ICUResourceBundle findTopLevel = iCUResourceBundle.findTopLevel("Currencies");
                if (findTopLevel != null) {
                    for (int i = 0; i < findTopLevel.getSize(); i++) {
                        ICUResourceBundle at = findTopLevel.at(i);
                        String key = at.getKey();
                        if (!hashSet.contains(key)) {
                            hashSet.add(key);
                            treeMap.put(at.getString(1), key);
                        }
                    }
                }
                ICUResourceBundle findTopLevel2 = iCUResourceBundle.findTopLevel("CurrencyPlurals");
                if (findTopLevel2 != null) {
                    for (int i2 = 0; i2 < findTopLevel2.getSize(); i2++) {
                        ICUResourceBundle at2 = findTopLevel2.at(i2);
                        String key2 = at2.getKey();
                        Set set = (Set) hashMap.get(key2);
                        if (set == null) {
                            set = new HashSet();
                            hashMap.put(key2, set);
                        }
                        for (int i3 = 0; i3 < at2.getSize(); i3++) {
                            ICUResourceBundle at3 = at2.at(i3);
                            String key3 = at3.getKey();
                            if (!set.contains(key3)) {
                                treeMap.put(at3.getString(), key2);
                                set.add(key3);
                            }
                        }
                    }
                }
            }
            return Collections.unmodifiableMap(treeMap);
        }
    }
}
