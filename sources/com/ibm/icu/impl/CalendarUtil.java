package com.ibm.icu.impl;

import com.ibm.icu.impl.UResource;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.TreeMap;
public final class CalendarUtil {
    public static String getCalendarType(ULocale uLocale) {
        String keywordValue = uLocale.getKeywordValue("calendar");
        if (keywordValue != null) {
            return keywordValue;
        }
        ULocale createCanonical = ULocale.createCanonical(uLocale.toString());
        String keywordValue2 = createCanonical.getKeywordValue("calendar");
        if (keywordValue2 != null) {
            return keywordValue2;
        }
        return CalendarPreferences.INSTANCE.getCalendarTypeForRegion(ULocale.getRegionForSupplementalData(createCanonical, true));
    }

    static final class CalendarPreferences extends UResource.Sink {
        private static final CalendarPreferences INSTANCE = new CalendarPreferences();
        Map<String, String> prefs = new TreeMap();

        CalendarPreferences() {
            try {
                ((ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "supplementalData")).getAllItemsWithFallback("calendarPreferenceData", this);
            } catch (MissingResourceException e) {
            }
        }

        /* access modifiers changed from: package-private */
        public String getCalendarTypeForRegion(String str) {
            String str2 = this.prefs.get(str);
            return str2 == null ? "gregorian" : str2;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (value.getArray().getValue(0, value)) {
                    String string = value.getString();
                    if (!string.equals("gregorian")) {
                        this.prefs.put(key.toString(), string);
                    }
                }
            }
        }
    }
}
