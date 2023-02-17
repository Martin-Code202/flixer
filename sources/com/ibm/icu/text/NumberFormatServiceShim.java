package com.ibm.icu.text;

import com.ibm.icu.impl.ICULocaleService;
import com.ibm.icu.impl.ICUService;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.ULocale;
import java.util.MissingResourceException;
class NumberFormatServiceShim extends NumberFormat.NumberFormatShim {
    private static ICULocaleService service = new NFService();

    NumberFormatServiceShim() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.ibm.icu.text.NumberFormat.NumberFormatShim
    public NumberFormat createInstance(ULocale uLocale, int i) {
        ULocale[] uLocaleArr = new ULocale[1];
        NumberFormat numberFormat = (NumberFormat) service.get(uLocale, i, uLocaleArr);
        if (numberFormat == null) {
            throw new MissingResourceException("Unable to construct NumberFormat", "", "");
        }
        NumberFormat numberFormat2 = (NumberFormat) numberFormat.clone();
        if (i == 1 || i == 5 || i == 6) {
            numberFormat2.setCurrency(Currency.getInstance(uLocale));
        }
        ULocale uLocale2 = uLocaleArr[0];
        numberFormat2.setLocale(uLocale2, uLocale2);
        return numberFormat2;
    }

    static class NFService extends ICULocaleService {
        NFService() {
            super("NumberFormat");
            registerFactory(new ICULocaleService.ICUResourceBundleFactory() { // from class: com.ibm.icu.text.NumberFormatServiceShim.NFService.1RBNumberFormatFactory
                /* access modifiers changed from: protected */
                @Override // com.ibm.icu.impl.ICULocaleService.ICUResourceBundleFactory, com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
                public Object handleCreate(ULocale uLocale, int i, ICUService iCUService) {
                    return NumberFormat.createInstance(uLocale, i);
                }
            });
            markDefault();
        }
    }
}
