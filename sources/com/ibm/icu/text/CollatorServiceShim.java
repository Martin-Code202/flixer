package com.ibm.icu.text;

import com.ibm.icu.impl.ICULocaleService;
import com.ibm.icu.impl.ICUService;
import com.ibm.icu.impl.coll.CollationLoader;
import com.ibm.icu.text.Collator;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.ULocale;
import java.util.MissingResourceException;
final class CollatorServiceShim extends Collator.ServiceShim {
    private static ICULocaleService service = new CService();

    CollatorServiceShim() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.ibm.icu.text.Collator.ServiceShim
    public Collator getInstance(ULocale uLocale) {
        try {
            Collator collator = (Collator) service.get(uLocale, new ULocale[1]);
            if (collator != null) {
                return (Collator) collator.clone();
            }
            throw new MissingResourceException("Could not locate Collator data", "", "");
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    static class CService extends ICULocaleService {
        CService() {
            super("Collator");
            registerFactory(new ICULocaleService.ICUResourceBundleFactory() { // from class: com.ibm.icu.text.CollatorServiceShim.CService.1CollatorFactory
                /* access modifiers changed from: protected */
                @Override // com.ibm.icu.impl.ICULocaleService.ICUResourceBundleFactory, com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
                public Object handleCreate(ULocale uLocale, int i, ICUService iCUService) {
                    return CollatorServiceShim.makeInstance(uLocale);
                }
            });
            markDefault();
        }

        @Override // com.ibm.icu.impl.ICULocaleService
        public String validateFallbackLocale() {
            return "";
        }

        /* access modifiers changed from: protected */
        @Override // com.ibm.icu.impl.ICUService
        public Object handleDefault(ICUService.Key key, String[] strArr) {
            if (strArr != null) {
                strArr[0] = "root";
            }
            try {
                return CollatorServiceShim.makeInstance(ULocale.ROOT);
            } catch (MissingResourceException e) {
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Collator makeInstance(ULocale uLocale) {
        Output output = new Output(ULocale.ROOT);
        return new RuleBasedCollator(CollationLoader.loadTailoring(uLocale, output), output.value);
    }
}
