package com.ibm.icu.text;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
public final class ListFormatter {
    static Cache cache = new Cache();
    private final String end;
    private final ULocale locale;
    private final String middle;
    private final String start;
    private final String two;

    @Deprecated
    public enum Style {
        STANDARD("standard"),
        DURATION("unit"),
        DURATION_SHORT("unit-short"),
        DURATION_NARROW("unit-narrow");
        
        private final String name;

        private Style(String str) {
            this.name = str;
        }

        @Deprecated
        public String getName() {
            return this.name;
        }
    }

    private ListFormatter(String str, String str2, String str3, String str4, ULocale uLocale) {
        this.two = str;
        this.start = str2;
        this.middle = str3;
        this.end = str4;
        this.locale = uLocale;
    }

    /* access modifiers changed from: private */
    public static String compilePattern(String str, StringBuilder sb) {
        return SimpleFormatterImpl.compileToStringMinMaxArguments(str, sb, 2, 2);
    }

    @Deprecated
    public static ListFormatter getInstance(ULocale uLocale, Style style) {
        return cache.get(uLocale, style.getName());
    }

    public String format(Object... objArr) {
        return format(Arrays.asList(objArr));
    }

    public String format(Collection<?> collection) {
        return format(collection, -1).toString();
    }

    /* access modifiers changed from: package-private */
    public FormattedListBuilder format(Collection<?> collection, int i) {
        Iterator<?> it = collection.iterator();
        int size = collection.size();
        switch (size) {
            case 0:
                return new FormattedListBuilder("", false);
            case 1:
                return new FormattedListBuilder(it.next(), i == 0);
            case 2:
                return new FormattedListBuilder(it.next(), i == 0).append(this.two, it.next(), i == 1);
            default:
                FormattedListBuilder formattedListBuilder = new FormattedListBuilder(it.next(), i == 0);
                formattedListBuilder.append(this.start, it.next(), i == 1);
                int i2 = 2;
                while (i2 < size - 1) {
                    formattedListBuilder.append(this.middle, it.next(), i == i2);
                    i2++;
                }
                return formattedListBuilder.append(this.end, it.next(), i == size + -1);
        }
    }

    /* access modifiers changed from: package-private */
    public static class FormattedListBuilder {
        private StringBuilder current;
        private int offset;

        public FormattedListBuilder(Object obj, boolean z) {
            this.current = new StringBuilder(obj.toString());
            this.offset = z ? 0 : -1;
        }

        public FormattedListBuilder append(String str, Object obj, boolean z) {
            int[] iArr = (z || offsetRecorded()) ? new int[2] : null;
            SimpleFormatterImpl.formatAndReplace(str, this.current, iArr, this.current, obj.toString());
            if (iArr != null) {
                if (iArr[0] == -1 || iArr[1] == -1) {
                    throw new IllegalArgumentException("{0} or {1} missing from pattern " + str);
                } else if (z) {
                    this.offset = iArr[1];
                } else {
                    this.offset += iArr[0];
                }
            }
            return this;
        }

        public String toString() {
            return this.current.toString();
        }

        public int getOffset() {
            return this.offset;
        }

        private boolean offsetRecorded() {
            return this.offset >= 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static class Cache {
        private final ICUCache<String, ListFormatter> cache;

        private Cache() {
            this.cache = new SimpleCache();
        }

        public ListFormatter get(ULocale uLocale, String str) {
            String format = String.format("%s:%s", uLocale.toString(), str);
            ListFormatter listFormatter = this.cache.get(format);
            if (listFormatter != null) {
                return listFormatter;
            }
            ListFormatter load = load(uLocale, str);
            this.cache.put(format, load);
            return load;
        }

        private static ListFormatter load(ULocale uLocale, String str) {
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", uLocale);
            StringBuilder sb = new StringBuilder();
            return new ListFormatter(ListFormatter.compilePattern(iCUResourceBundle.getWithFallback("listPattern/" + str + "/2").getString(), sb), ListFormatter.compilePattern(iCUResourceBundle.getWithFallback("listPattern/" + str + "/start").getString(), sb), ListFormatter.compilePattern(iCUResourceBundle.getWithFallback("listPattern/" + str + "/middle").getString(), sb), ListFormatter.compilePattern(iCUResourceBundle.getWithFallback("listPattern/" + str + "/end").getString(), sb), uLocale);
        }
    }
}
