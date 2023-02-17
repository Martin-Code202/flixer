package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICULocaleService;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUService;
import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.util.ULocale;
import java.io.IOException;
import java.util.MissingResourceException;
final class BreakIteratorFactory extends BreakIterator.BreakIteratorServiceShim {
    private static final String[] KIND_NAMES = {"grapheme", "word", "line", "sentence", "title"};
    static final ICULocaleService service = new BFService();

    BreakIteratorFactory() {
    }

    @Override // com.ibm.icu.text.BreakIterator.BreakIteratorServiceShim
    public BreakIterator createBreakIterator(ULocale uLocale, int i) {
        if (service.isDefault()) {
            return createBreakInstance(uLocale, i);
        }
        ULocale[] uLocaleArr = new ULocale[1];
        BreakIterator breakIterator = (BreakIterator) service.get(uLocale, i, uLocaleArr);
        breakIterator.setLocale(uLocaleArr[0], uLocaleArr[0]);
        return breakIterator;
    }

    static class BFService extends ICULocaleService {
        BFService() {
            super("BreakIterator");
            registerFactory(new ICULocaleService.ICUResourceBundleFactory() { // from class: com.ibm.icu.text.BreakIteratorFactory.BFService.1RBBreakIteratorFactory
                /* access modifiers changed from: protected */
                @Override // com.ibm.icu.impl.ICULocaleService.ICUResourceBundleFactory, com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory
                public Object handleCreate(ULocale uLocale, int i, ICUService iCUService) {
                    return BreakIteratorFactory.createBreakInstance(uLocale, i);
                }
            });
            markDefault();
        }

        @Override // com.ibm.icu.impl.ICULocaleService
        public String validateFallbackLocale() {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static BreakIterator createBreakInstance(ULocale uLocale, int i) {
        String str;
        String keywordValue;
        String keywordValue2;
        RuleBasedBreakIterator ruleBasedBreakIterator = null;
        ICUResourceBundle bundleInstance = ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/brkitr", uLocale, ICUResourceBundle.OpenType.LOCALE_ROOT);
        String str2 = null;
        if (i == 2 && (keywordValue2 = uLocale.getKeywordValue("lb")) != null && (keywordValue2.equals("strict") || keywordValue2.equals("normal") || keywordValue2.equals("loose"))) {
            str2 = "_" + keywordValue2;
        }
        if (str2 == null) {
            try {
                str = KIND_NAMES[i];
            } catch (Exception e) {
                throw new MissingResourceException(e.toString(), "", "");
            }
        } else {
            str = KIND_NAMES[i] + str2;
        }
        try {
            ruleBasedBreakIterator = RuleBasedBreakIterator.getInstanceFromCompiledRules(ICUBinary.getData("brkitr/" + bundleInstance.getStringWithFallback("boundaries/" + str)));
        } catch (IOException e2) {
            Assert.fail(e2);
        }
        ULocale forLocale = ULocale.forLocale(bundleInstance.getLocale());
        ruleBasedBreakIterator.setLocale(forLocale, forLocale);
        ruleBasedBreakIterator.setBreakType(i);
        if (i != 3 || (keywordValue = uLocale.getKeywordValue("ss")) == null || !keywordValue.equals("standard")) {
            return ruleBasedBreakIterator;
        }
        return FilteredBreakIteratorBuilder.createInstance(new ULocale(uLocale.getBaseName())).build(ruleBasedBreakIterator);
    }
}
