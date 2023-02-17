package org.chromium.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.chromium.base.annotations.CalledByNative;
public class LocaleUtils {
    private static final Map<String, String> LANGUAGE_MAP_FOR_ANDROID;
    private static final Map<String, String> LANGUAGE_MAP_FOR_CHROMIUM;

    private LocaleUtils() {
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("iw", "he");
        hashMap.put("ji", "yi");
        hashMap.put("in", "id");
        hashMap.put("tl", "fil");
        LANGUAGE_MAP_FOR_CHROMIUM = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("und", "");
        hashMap2.put("fil", "tl");
        LANGUAGE_MAP_FOR_ANDROID = Collections.unmodifiableMap(hashMap2);
    }

    public static String getUpdatedLanguageForChromium(String str) {
        String str2 = LANGUAGE_MAP_FOR_CHROMIUM.get(str);
        return str2 == null ? str : str2;
    }

    public static String toLanguageTag(Locale locale) {
        String updatedLanguageForChromium = getUpdatedLanguageForChromium(locale.getLanguage());
        String country = locale.getCountry();
        if (!updatedLanguageForChromium.equals("no") || !country.equals("NO") || !locale.getVariant().equals("NY")) {
            return country.isEmpty() ? updatedLanguageForChromium : updatedLanguageForChromium + "-" + country;
        }
        return "nn-NO";
    }

    @CalledByNative
    public static String getDefaultLocaleString() {
        return toLanguageTag(Locale.getDefault());
    }

    @CalledByNative
    private static String getDefaultCountryCode() {
        CommandLine instance = CommandLine.getInstance();
        if (instance.hasSwitch("default-country-code")) {
            return instance.getSwitchValue("default-country-code");
        }
        return Locale.getDefault().getCountry();
    }
}
