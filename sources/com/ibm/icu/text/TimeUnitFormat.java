package com.ibm.icu.text;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.text.MeasureFormat;
import com.ibm.icu.util.Measure;
import com.ibm.icu.util.TimeUnit;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.text.FieldPosition;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;
@Deprecated
public class TimeUnitFormat extends MeasureFormat {
    private static final long serialVersionUID = -3707773153184971529L;
    private NumberFormat format;
    private transient boolean isReady;
    private ULocale locale;
    private transient MeasureFormat mf;
    private transient PluralRules pluralRules;
    private int style;
    private transient Map<TimeUnit, Map<String, Object[]>> timeUnitToCountToPatterns;

    @Deprecated
    public TimeUnitFormat() {
        this.mf = MeasureFormat.getInstance(ULocale.getDefault(), MeasureFormat.FormatWidth.WIDE);
        this.isReady = false;
        this.style = 0;
    }

    @Deprecated
    public TimeUnitFormat(ULocale uLocale, int i) {
        if (i < 0 || i >= 2) {
            throw new IllegalArgumentException("style should be either FULL_NAME or ABBREVIATED_NAME style");
        }
        this.mf = MeasureFormat.getInstance(uLocale, i == 0 ? MeasureFormat.FormatWidth.WIDE : MeasureFormat.FormatWidth.SHORT);
        this.style = i;
        setLocale(uLocale, uLocale);
        this.locale = uLocale;
        this.isReady = false;
    }

    private TimeUnitFormat(ULocale uLocale, int i, NumberFormat numberFormat) {
        this(uLocale, i);
        if (numberFormat != null) {
            setNumberFormat((NumberFormat) numberFormat.clone());
        }
    }

    @Deprecated
    public TimeUnitFormat setNumberFormat(NumberFormat numberFormat) {
        if (numberFormat == this.format) {
            return this;
        }
        if (numberFormat != null) {
            this.format = numberFormat;
            this.mf = this.mf.withNumberFormat(this.format);
        } else if (this.locale == null) {
            this.isReady = false;
            this.mf = this.mf.withLocale(ULocale.getDefault());
        } else {
            this.format = NumberFormat.getNumberInstance(this.locale);
            this.mf = this.mf.withNumberFormat(this.format);
        }
        return this;
    }

    @Override // com.ibm.icu.text.MeasureFormat, java.text.Format
    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.mf.format(obj, stringBuffer, fieldPosition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v4, types: [java.lang.Number] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.ibm.icu.text.MeasureFormat, java.text.Format
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.ibm.icu.util.TimeUnitAmount parseObject(java.lang.String r22, java.text.ParsePosition r23) {
        /*
        // Method dump skipped, instructions count: 290
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.TimeUnitFormat.parseObject(java.lang.String, java.text.ParsePosition):com.ibm.icu.util.TimeUnitAmount");
    }

    private void setup() {
        if (this.locale == null) {
            if (this.format != null) {
                this.locale = this.format.getLocale(null);
            } else {
                this.locale = ULocale.getDefault(ULocale.Category.FORMAT);
            }
            setLocale(this.locale, this.locale);
        }
        if (this.format == null) {
            this.format = NumberFormat.getNumberInstance(this.locale);
        }
        this.pluralRules = PluralRules.forLocale(this.locale);
        this.timeUnitToCountToPatterns = new HashMap();
        Set<String> keywords = this.pluralRules.getKeywords();
        setup("units/duration", this.timeUnitToCountToPatterns, 0, keywords);
        setup("unitsShort/duration", this.timeUnitToCountToPatterns, 1, keywords);
        this.isReady = true;
    }

    /* access modifiers changed from: package-private */
    public static final class TimeUnitFormatSetupSink extends UResource.Sink {
        boolean beenHere = false;
        ULocale locale;
        Set<String> pluralKeywords;
        int style;
        Map<TimeUnit, Map<String, Object[]>> timeUnitToCountToPatterns;

        TimeUnitFormatSetupSink(Map<TimeUnit, Map<String, Object[]>> map, int i, Set<String> set, ULocale uLocale) {
            this.timeUnitToCountToPatterns = map;
            this.style = i;
            this.pluralKeywords = set;
            this.locale = uLocale;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            TimeUnit timeUnit;
            if (!this.beenHere) {
                this.beenHere = true;
                UResource.Table table = value.getTable();
                for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                    String key2 = key.toString();
                    if (key2.equals("year")) {
                        timeUnit = TimeUnit.YEAR;
                    } else if (key2.equals("month")) {
                        timeUnit = TimeUnit.MONTH;
                    } else if (key2.equals("day")) {
                        timeUnit = TimeUnit.DAY;
                    } else if (key2.equals("hour")) {
                        timeUnit = TimeUnit.HOUR;
                    } else if (key2.equals("minute")) {
                        timeUnit = TimeUnit.MINUTE;
                    } else if (key2.equals("second")) {
                        timeUnit = TimeUnit.SECOND;
                    } else if (key2.equals("week")) {
                        timeUnit = TimeUnit.WEEK;
                    }
                    Map<String, Object[]> map = this.timeUnitToCountToPatterns.get(timeUnit);
                    if (map == null) {
                        map = new TreeMap<>();
                        this.timeUnitToCountToPatterns.put(timeUnit, map);
                    }
                    UResource.Table table2 = value.getTable();
                    for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                        String key3 = key.toString();
                        if (this.pluralKeywords.contains(key3)) {
                            Object[] objArr = map.get(key3);
                            if (objArr == null) {
                                objArr = new Object[2];
                                map.put(key3, objArr);
                            }
                            if (objArr[this.style] == null) {
                                objArr[this.style] = new MessageFormat(value.getString(), this.locale);
                            }
                        }
                    }
                }
            }
        }
    }

    private void setup(String str, Map<TimeUnit, Map<String, Object[]>> map, int i, Set<String> set) {
        try {
            ((ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/unit", this.locale)).getAllItemsWithFallback(str, new TimeUnitFormatSetupSink(map, i, set, this.locale));
        } catch (MissingResourceException e) {
        }
        TimeUnit[] values = TimeUnit.values();
        Set<String> keywords = this.pluralRules.getKeywords();
        for (TimeUnit timeUnit : values) {
            Map<String, Object[]> map2 = map.get(timeUnit);
            if (map2 == null) {
                map2 = new TreeMap<>();
                map.put(timeUnit, map2);
            }
            for (String str2 : keywords) {
                if (map2.get(str2) == null || map2.get(str2)[i] == null) {
                    searchInTree(str, i, timeUnit, str2, str2, map2);
                }
            }
        }
    }

    private void searchInTree(String str, int i, TimeUnit timeUnit, String str2, String str3, Map<String, Object[]> map) {
        ULocale uLocale = this.locale;
        String timeUnit2 = timeUnit.toString();
        while (uLocale != null) {
            try {
                MessageFormat messageFormat = new MessageFormat(((ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/unit", uLocale)).getWithFallback(str).getWithFallback(timeUnit2).getStringWithFallback(str3), this.locale);
                Object[] objArr = map.get(str2);
                if (objArr == null) {
                    objArr = new Object[2];
                    map.put(str2, objArr);
                }
                objArr[i] = messageFormat;
                return;
            } catch (MissingResourceException e) {
                uLocale = uLocale.getFallback();
            }
        }
        if (uLocale == null && str.equals("unitsShort")) {
            searchInTree("units", i, timeUnit, str2, str3, map);
            if (!(map.get(str2) == null || map.get(str2)[i] == null)) {
                return;
            }
        }
        if (str3.equals("other")) {
            MessageFormat messageFormat2 = null;
            if (timeUnit == TimeUnit.SECOND) {
                messageFormat2 = new MessageFormat("{0} s", this.locale);
            } else if (timeUnit == TimeUnit.MINUTE) {
                messageFormat2 = new MessageFormat("{0} min", this.locale);
            } else if (timeUnit == TimeUnit.HOUR) {
                messageFormat2 = new MessageFormat("{0} h", this.locale);
            } else if (timeUnit == TimeUnit.WEEK) {
                messageFormat2 = new MessageFormat("{0} w", this.locale);
            } else if (timeUnit == TimeUnit.DAY) {
                messageFormat2 = new MessageFormat("{0} d", this.locale);
            } else if (timeUnit == TimeUnit.MONTH) {
                messageFormat2 = new MessageFormat("{0} m", this.locale);
            } else if (timeUnit == TimeUnit.YEAR) {
                messageFormat2 = new MessageFormat("{0} y", this.locale);
            }
            Object[] objArr2 = map.get(str2);
            if (objArr2 == null) {
                objArr2 = new Object[2];
                map.put(str2, objArr2);
            }
            objArr2[i] = messageFormat2;
            return;
        }
        searchInTree(str, i, timeUnit, str2, "other", map);
    }

    @Override // com.ibm.icu.text.MeasureFormat
    @Deprecated
    public StringBuilder formatMeasures(StringBuilder sb, FieldPosition fieldPosition, Measure... measureArr) {
        return this.mf.formatMeasures(sb, fieldPosition, measureArr);
    }

    @Override // com.ibm.icu.text.MeasureFormat
    @Deprecated
    public MeasureFormat.FormatWidth getWidth() {
        return this.mf.getWidth();
    }

    @Override // com.ibm.icu.text.MeasureFormat
    @Deprecated
    public NumberFormat getNumberFormat() {
        return this.mf.getNumberFormat();
    }

    @Override // java.text.Format, java.lang.Object
    @Deprecated
    public Object clone() {
        TimeUnitFormat timeUnitFormat = (TimeUnitFormat) super.clone();
        timeUnitFormat.format = (NumberFormat) this.format.clone();
        return timeUnitFormat;
    }

    private Object writeReplace() {
        return this.mf.toTimeUnitProxy();
    }

    private Object readResolve() {
        return new TimeUnitFormat(this.locale, this.style, this.format);
    }
}
