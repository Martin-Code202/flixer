package com.ibm.icu.text;

import com.ibm.icu.impl.CurrencyData;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.ULocale;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class CurrencyPluralInfo implements Cloneable, Serializable {
    private static final String defaultCurrencyPluralPattern = new String(defaultCurrencyPluralPatternChar);
    private static final char[] defaultCurrencyPluralPatternChar = {0, '.', '#', '#', ' ', 164, 164, 164};
    private static final long serialVersionUID = 1;
    private static final char[] tripleCurrencySign = {164, 164, 164};
    private static final String tripleCurrencyStr = new String(tripleCurrencySign);
    private Map<String, String> pluralCountToCurrencyUnitPattern = null;
    private PluralRules pluralRules = null;
    private ULocale ulocale = null;

    public CurrencyPluralInfo() {
        initialize(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public CurrencyPluralInfo(ULocale uLocale) {
        initialize(uLocale);
    }

    public static CurrencyPluralInfo getInstance(ULocale uLocale) {
        return new CurrencyPluralInfo(uLocale);
    }

    public PluralRules getPluralRules() {
        return this.pluralRules;
    }

    public String getCurrencyPluralPattern(String str) {
        String str2 = this.pluralCountToCurrencyUnitPattern.get(str);
        if (str2 != null) {
            return str2;
        }
        if (!str.equals("other")) {
            str2 = this.pluralCountToCurrencyUnitPattern.get("other");
        }
        if (str2 == null) {
            return defaultCurrencyPluralPattern;
        }
        return str2;
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            CurrencyPluralInfo currencyPluralInfo = (CurrencyPluralInfo) super.clone();
            currencyPluralInfo.ulocale = (ULocale) this.ulocale.clone();
            currencyPluralInfo.pluralCountToCurrencyUnitPattern = new HashMap();
            for (String str : this.pluralCountToCurrencyUnitPattern.keySet()) {
                currencyPluralInfo.pluralCountToCurrencyUnitPattern.put(str, this.pluralCountToCurrencyUnitPattern.get(str));
            }
            return currencyPluralInfo;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof CurrencyPluralInfo)) {
            return false;
        }
        CurrencyPluralInfo currencyPluralInfo = (CurrencyPluralInfo) obj;
        return this.pluralRules.equals(currencyPluralInfo.pluralRules) && this.pluralCountToCurrencyUnitPattern.equals(currencyPluralInfo.pluralCountToCurrencyUnitPattern);
    }

    @Override // java.lang.Object
    @Deprecated
    public int hashCode() {
        return (this.pluralCountToCurrencyUnitPattern.hashCode() ^ this.pluralRules.hashCode()) ^ this.ulocale.hashCode();
    }

    private void initialize(ULocale uLocale) {
        this.ulocale = uLocale;
        this.pluralRules = PluralRules.forLocale(uLocale);
        setupCurrencyPluralPattern(uLocale);
    }

    private void setupCurrencyPluralPattern(ULocale uLocale) {
        this.pluralCountToCurrencyUnitPattern = new HashMap();
        String pattern = NumberFormat.getPattern(uLocale, 0);
        int indexOf = pattern.indexOf(";");
        String str = null;
        if (indexOf != -1) {
            str = pattern.substring(indexOf + 1);
            pattern = pattern.substring(0, indexOf);
        }
        for (Map.Entry<String, String> entry : CurrencyData.provider.getInstance(uLocale, true).getUnitPatterns().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String replace = value.replace("{0}", pattern).replace("{1}", tripleCurrencyStr);
            if (indexOf != -1) {
                String replace2 = value.replace("{0}", str).replace("{1}", tripleCurrencyStr);
                StringBuilder sb = new StringBuilder(replace);
                sb.append(";");
                sb.append(replace2);
                replace = sb.toString();
            }
            this.pluralCountToCurrencyUnitPattern.put(key, replace);
        }
    }
}
