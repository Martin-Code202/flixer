package com.ibm.icu.text;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.util.MissingResourceException;
public class NumberingSystem {
    private static final String[] OTHER_NS_KEYWORDS = {"native", "traditional", "finance"};
    private static CacheBase<String, NumberingSystem, LocaleLookupData> cachedLocaleData = new SoftCache<String, NumberingSystem, LocaleLookupData>() { // from class: com.ibm.icu.text.NumberingSystem.1
        /* access modifiers changed from: protected */
        public NumberingSystem createInstance(String str, LocaleLookupData localeLookupData) {
            return NumberingSystem.lookupInstanceByLocale(localeLookupData);
        }
    };
    private static CacheBase<String, NumberingSystem, Void> cachedStringData = new SoftCache<String, NumberingSystem, Void>() { // from class: com.ibm.icu.text.NumberingSystem.2
        /* access modifiers changed from: protected */
        public NumberingSystem createInstance(String str, Void r3) {
            return NumberingSystem.lookupInstanceByName(str);
        }
    };
    private boolean algorithmic = false;
    private String desc = "0123456789";
    private String name = "latn";
    private int radix = 10;

    private static NumberingSystem getInstance(String str, int i, boolean z, String str2) {
        if (i < 2) {
            throw new IllegalArgumentException("Invalid radix for numbering system");
        } else if (z || (str2.length() == i && isValidDigitString(str2))) {
            NumberingSystem numberingSystem = new NumberingSystem();
            numberingSystem.radix = i;
            numberingSystem.algorithmic = z;
            numberingSystem.desc = str2;
            numberingSystem.name = str;
            return numberingSystem;
        } else {
            throw new IllegalArgumentException("Invalid digit string for numbering system");
        }
    }

    public static NumberingSystem getInstance(ULocale uLocale) {
        boolean z = true;
        String keywordValue = uLocale.getKeywordValue("numbers");
        if (keywordValue != null) {
            String[] strArr = OTHER_NS_KEYWORDS;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (keywordValue.equals(strArr[i])) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
        } else {
            keywordValue = "default";
            z = false;
        }
        if (z) {
            NumberingSystem instanceByName = getInstanceByName(keywordValue);
            if (instanceByName != null) {
                return instanceByName;
            }
            keywordValue = "default";
        }
        return cachedLocaleData.getInstance(uLocale.getBaseName() + "@numbers=" + keywordValue, new LocaleLookupData(uLocale, keywordValue));
    }

    /* access modifiers changed from: package-private */
    public static class LocaleLookupData {
        public final ULocale locale;
        public final String numbersKeyword;

        LocaleLookupData(ULocale uLocale, String str) {
            this.locale = uLocale;
            this.numbersKeyword = str;
        }
    }

    static NumberingSystem lookupInstanceByLocale(LocaleLookupData localeLookupData) {
        try {
            ICUResourceBundle withFallback = ((ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", localeLookupData.locale)).getWithFallback("NumberElements");
            String str = localeLookupData.numbersKeyword;
            String str2 = null;
            while (true) {
                try {
                    str2 = withFallback.getStringWithFallback(str);
                    break;
                } catch (MissingResourceException e) {
                    if (!str.equals("native") && !str.equals("finance")) {
                        if (!str.equals("traditional")) {
                            break;
                        }
                        str = "native";
                    } else {
                        str = "default";
                    }
                }
            }
            NumberingSystem numberingSystem = null;
            if (str2 != null) {
                numberingSystem = getInstanceByName(str2);
            }
            if (numberingSystem == null) {
                return new NumberingSystem();
            }
            return numberingSystem;
        } catch (MissingResourceException e2) {
            return new NumberingSystem();
        }
    }

    public static NumberingSystem getInstanceByName(String str) {
        return cachedStringData.getInstance(str, null);
    }

    /* access modifiers changed from: private */
    public static NumberingSystem lookupInstanceByName(String str) {
        try {
            UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "numberingSystems").get("numberingSystems").get(str);
            return getInstance(str, uResourceBundle.get("radix").getInt(), uResourceBundle.get("algorithmic").getInt() == 1, uResourceBundle.getString("desc"));
        } catch (MissingResourceException e) {
            return null;
        }
    }

    public static boolean isValidDigitString(String str) {
        return str.codePointCount(0, str.length()) == 10;
    }

    public int getRadix() {
        return this.radix;
    }

    public String getDescription() {
        return this.desc;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAlgorithmic() {
        return this.algorithmic;
    }
}
