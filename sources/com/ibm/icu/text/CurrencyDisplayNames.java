package com.ibm.icu.text;

import com.ibm.icu.impl.CurrencyData;
import com.ibm.icu.util.ULocale;
import java.util.Map;
public abstract class CurrencyDisplayNames {
    public abstract String getName(String str);

    public abstract String getPluralName(String str, String str2);

    public abstract String getSymbol(String str);

    public abstract Map<String, String> nameMap();

    public abstract Map<String, String> symbolMap();

    public static CurrencyDisplayNames getInstance(ULocale uLocale) {
        return CurrencyData.provider.getInstance(uLocale, true);
    }

    @Deprecated
    protected CurrencyDisplayNames() {
    }
}
