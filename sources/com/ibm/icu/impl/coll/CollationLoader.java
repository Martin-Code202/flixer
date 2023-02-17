package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.util.ICUUncheckedIOException;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.IOException;
import java.util.MissingResourceException;
public final class CollationLoader {
    private static volatile String rootRules = null;

    static final class ASCII {
        static String toLowerCase(String str) {
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if ('A' > charAt || charAt > 'Z') {
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder(str.length());
                    sb.append((CharSequence) str, 0, i).append((char) (charAt + ' '));
                    while (true) {
                        i++;
                        if (i >= str.length()) {
                            return sb.toString();
                        }
                        char charAt2 = str.charAt(i);
                        if ('A' <= charAt2 && charAt2 <= 'Z') {
                            charAt2 = (char) (charAt2 + ' ');
                        }
                        sb.append(charAt2);
                    }
                }
            }
            return str;
        }
    }

    private static final UResourceBundle findWithFallback(UResourceBundle uResourceBundle, String str) {
        return ((ICUResourceBundle) uResourceBundle).findWithFallback(str);
    }

    public static CollationTailoring loadTailoring(ULocale uLocale, Output<ULocale> output) {
        String str;
        String findStringWithFallback;
        CollationTailoring root = CollationRoot.getRoot();
        String name = uLocale.getName();
        if (name.length() == 0 || name.equals("root")) {
            output.value = (T) ULocale.ROOT;
            return root;
        }
        try {
            ICUResourceBundle bundleInstance = ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/coll", uLocale, ICUResourceBundle.OpenType.LOCALE_ROOT);
            T t = (T) bundleInstance.getULocale();
            String name2 = t.getName();
            if (name2.length() == 0 || name2.equals("root")) {
                t = (T) ULocale.ROOT;
            }
            output.value = t;
            try {
                UResourceBundle uResourceBundle = bundleInstance.get("collations");
                if (uResourceBundle == null) {
                    return root;
                }
                String keywordValue = uLocale.getKeywordValue("collation");
                String str2 = "standard";
                String findStringWithFallback2 = ((ICUResourceBundle) uResourceBundle).findStringWithFallback("default");
                if (findStringWithFallback2 != null) {
                    str2 = findStringWithFallback2;
                }
                if (keywordValue == null || keywordValue.equals("default")) {
                    str = str2;
                } else {
                    str = ASCII.toLowerCase(keywordValue);
                }
                UResourceBundle findWithFallback = findWithFallback(uResourceBundle, str);
                if (findWithFallback == null && str.length() > 6 && str.startsWith("search")) {
                    str = "search";
                    findWithFallback = findWithFallback(uResourceBundle, str);
                }
                if (findWithFallback == null && !str.equals(str2)) {
                    str = str2;
                    findWithFallback = findWithFallback(uResourceBundle, str);
                }
                if (findWithFallback == null && !str.equals("standard")) {
                    str = "standard";
                    findWithFallback = findWithFallback(uResourceBundle, str);
                }
                if (findWithFallback == null) {
                    return root;
                }
                ULocale uLocale2 = findWithFallback.getULocale();
                String name3 = uLocale2.getName();
                if (name3.length() == 0 || name3.equals("root")) {
                    uLocale2 = ULocale.ROOT;
                    if (str.equals("standard")) {
                        return root;
                    }
                }
                CollationTailoring collationTailoring = new CollationTailoring(root.settings);
                collationTailoring.actualLocale = uLocale2;
                try {
                    CollationDataReader.read(root, findWithFallback.get("%%CollationBin").getBinary(), collationTailoring);
                    try {
                        collationTailoring.setRulesResource(findWithFallback.get("Sequence"));
                    } catch (MissingResourceException e) {
                    }
                    if (!str.equals(str2)) {
                        output.value = (T) t.setKeywordValue("collation", str);
                    }
                    if (!uLocale2.equals(t) && (findStringWithFallback = ((ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/coll", uLocale2)).findStringWithFallback("collations/default")) != null) {
                        str2 = findStringWithFallback;
                    }
                    if (!str.equals(str2)) {
                        collationTailoring.actualLocale = collationTailoring.actualLocale.setKeywordValue("collation", str);
                    }
                    return collationTailoring;
                } catch (IOException e2) {
                    throw new ICUUncheckedIOException("Failed to load collation tailoring data for locale:" + uLocale2 + " type:" + str, e2);
                }
            } catch (MissingResourceException e3) {
                return root;
            }
        } catch (MissingResourceException e4) {
            output.value = (T) ULocale.ROOT;
            return root;
        }
    }
}
