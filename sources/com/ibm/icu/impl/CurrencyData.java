package com.ibm.icu.impl;

import com.ibm.icu.text.CurrencyDisplayNames;
import com.ibm.icu.util.ULocale;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;
public class CurrencyData {
    public static final CurrencyDisplayInfoProvider provider;

    public static abstract class CurrencyDisplayInfo extends CurrencyDisplayNames {
        public abstract CurrencyFormatInfo getFormatInfo(String str);

        public abstract CurrencySpacingInfo getSpacingInfo();

        public abstract Map<String, String> getUnitPatterns();
    }

    public interface CurrencyDisplayInfoProvider {
        CurrencyDisplayInfo getInstance(ULocale uLocale, boolean z);
    }

    private CurrencyData() {
    }

    public static final class CurrencyFormatInfo {
        public final String currencyPattern;
        public final String monetaryGroupingSeparator;
        public final String monetarySeparator;

        public CurrencyFormatInfo(String str, String str2, String str3) {
            this.currencyPattern = str;
            this.monetarySeparator = str2;
            this.monetaryGroupingSeparator = str3;
        }
    }

    public static final class CurrencySpacingInfo {
        static final /* synthetic */ boolean $assertionsDisabled = (!CurrencyData.class.desiredAssertionStatus());
        public static final CurrencySpacingInfo DEFAULT = new CurrencySpacingInfo("[:letter:]", "[:digit:]", " ", "[:letter:]", "[:digit:]", " ");
        private final String[][] symbols = ((String[][]) Array.newInstance(String.class, SpacingType.COUNT.ordinal(), SpacingPattern.COUNT.ordinal()));

        public enum SpacingType {
            BEFORE,
            AFTER,
            COUNT
        }

        public enum SpacingPattern {
            CURRENCY_MATCH(0),
            SURROUNDING_MATCH(1),
            INSERT_BETWEEN(2),
            COUNT;
            
            static final /* synthetic */ boolean $assertionsDisabled = (!CurrencyData.class.desiredAssertionStatus());

            private SpacingPattern(int i) {
                if (!$assertionsDisabled && i != ordinal()) {
                    throw new AssertionError();
                }
            }
        }

        public CurrencySpacingInfo() {
        }

        public CurrencySpacingInfo(String... strArr) {
            if ($assertionsDisabled || strArr.length == 6) {
                int i = 0;
                for (int i2 = 0; i2 < SpacingType.COUNT.ordinal(); i2++) {
                    for (int i3 = 0; i3 < SpacingPattern.COUNT.ordinal(); i3++) {
                        this.symbols[i2][i3] = strArr[i];
                        i++;
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public void setSymbolIfNull(SpacingType spacingType, SpacingPattern spacingPattern, String str) {
            int ordinal = spacingType.ordinal();
            int ordinal2 = spacingPattern.ordinal();
            if (this.symbols[ordinal][ordinal2] == null) {
                this.symbols[ordinal][ordinal2] = str;
            }
        }

        public String[] getBeforeSymbols() {
            return this.symbols[SpacingType.BEFORE.ordinal()];
        }

        public String[] getAfterSymbols() {
            return this.symbols[SpacingType.AFTER.ordinal()];
        }
    }

    static {
        CurrencyDisplayInfoProvider currencyDisplayInfoProvider;
        try {
            currencyDisplayInfoProvider = (CurrencyDisplayInfoProvider) Class.forName("com.ibm.icu.impl.ICUCurrencyDisplayInfoProvider").newInstance();
        } catch (Throwable th) {
            currencyDisplayInfoProvider = new CurrencyDisplayInfoProvider() { // from class: com.ibm.icu.impl.CurrencyData.1
                @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfoProvider
                public CurrencyDisplayInfo getInstance(ULocale uLocale, boolean z) {
                    return DefaultInfo.getWithFallback(z);
                }
            };
        }
        provider = currencyDisplayInfoProvider;
    }

    public static class DefaultInfo extends CurrencyDisplayInfo {
        private static final CurrencyDisplayInfo FALLBACK_INSTANCE = new DefaultInfo(true);
        private static final CurrencyDisplayInfo NO_FALLBACK_INSTANCE = new DefaultInfo(false);
        private final boolean fallback;

        private DefaultInfo(boolean z) {
            this.fallback = z;
        }

        public static final CurrencyDisplayInfo getWithFallback(boolean z) {
            return z ? FALLBACK_INSTANCE : NO_FALLBACK_INSTANCE;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getName(String str) {
            if (this.fallback) {
                return str;
            }
            return null;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getPluralName(String str, String str2) {
            if (this.fallback) {
                return str;
            }
            return null;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public String getSymbol(String str) {
            if (this.fallback) {
                return str;
            }
            return null;
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public Map<String, String> symbolMap() {
            return Collections.emptyMap();
        }

        @Override // com.ibm.icu.text.CurrencyDisplayNames
        public Map<String, String> nameMap() {
            return Collections.emptyMap();
        }

        @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfo
        public Map<String, String> getUnitPatterns() {
            if (this.fallback) {
                return Collections.emptyMap();
            }
            return null;
        }

        @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfo
        public CurrencyFormatInfo getFormatInfo(String str) {
            return null;
        }

        @Override // com.ibm.icu.impl.CurrencyData.CurrencyDisplayInfo
        public CurrencySpacingInfo getSpacingInfo() {
            if (this.fallback) {
                return CurrencySpacingInfo.DEFAULT;
            }
            return null;
        }
    }
}
