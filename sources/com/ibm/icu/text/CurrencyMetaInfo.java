package com.ibm.icu.text;

import com.ibm.icu.impl.Grego;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.util.Currency;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Date;
import java.util.List;
public class CurrencyMetaInfo {
    @Deprecated
    protected static final CurrencyDigits defaultDigits = new CurrencyDigits(2, 0);
    private static final boolean hasData;
    private static final CurrencyMetaInfo impl;

    public static CurrencyMetaInfo getInstance() {
        return impl;
    }

    @Deprecated
    protected CurrencyMetaInfo() {
    }

    public static final class CurrencyFilter {
        private static final CurrencyFilter ALL = new CurrencyFilter(null, null, Long.MIN_VALUE, Long.MAX_VALUE, false);
        public final String currency;
        public final long from;
        public final String region;
        @Deprecated
        public final boolean tenderOnly;
        public final long to;

        private CurrencyFilter(String str, String str2, long j, long j2, boolean z) {
            this.region = str;
            this.currency = str2;
            this.from = j;
            this.to = j2;
            this.tenderOnly = z;
        }

        public static CurrencyFilter all() {
            return ALL;
        }

        public static CurrencyFilter onRegion(String str) {
            return ALL.withRegion(str);
        }

        public CurrencyFilter withRegion(String str) {
            return new CurrencyFilter(str, this.currency, this.from, this.to, this.tenderOnly);
        }

        public boolean equals(Object obj) {
            return (obj instanceof CurrencyFilter) && equals((CurrencyFilter) obj);
        }

        public boolean equals(CurrencyFilter currencyFilter) {
            return Utility.sameObjects(this, currencyFilter) || (currencyFilter != null && equals(this.region, currencyFilter.region) && equals(this.currency, currencyFilter.currency) && this.from == currencyFilter.from && this.to == currencyFilter.to && this.tenderOnly == currencyFilter.tenderOnly);
        }

        public int hashCode() {
            int i = 0;
            if (this.region != null) {
                i = this.region.hashCode();
            }
            if (this.currency != null) {
                i = (i * 31) + this.currency.hashCode();
            }
            return (((((((((i * 31) + ((int) this.from)) * 31) + ((int) (this.from >>> 32))) * 31) + ((int) this.to)) * 31) + ((int) (this.to >>> 32))) * 31) + (this.tenderOnly ? 1 : 0);
        }

        public String toString() {
            return CurrencyMetaInfo.debugString(this);
        }

        private static boolean equals(String str, String str2) {
            return Utility.sameObjects(str, str2) || (str != null && str.equals(str2));
        }
    }

    public static final class CurrencyDigits {
        public final int fractionDigits;
        public final int roundingIncrement;

        public CurrencyDigits(int i, int i2) {
            this.fractionDigits = i;
            this.roundingIncrement = i2;
        }

        public String toString() {
            return CurrencyMetaInfo.debugString(this);
        }
    }

    public List<String> currencies(CurrencyFilter currencyFilter) {
        return Collections.emptyList();
    }

    public CurrencyDigits currencyDigits(String str, Currency.CurrencyUsage currencyUsage) {
        return defaultDigits;
    }

    static {
        CurrencyMetaInfo currencyMetaInfo;
        boolean z = false;
        try {
            currencyMetaInfo = (CurrencyMetaInfo) Class.forName("com.ibm.icu.impl.ICUCurrencyMetaInfo").newInstance();
            z = true;
        } catch (Throwable th) {
            currencyMetaInfo = new CurrencyMetaInfo();
        }
        impl = currencyMetaInfo;
        hasData = z;
    }

    private static String dateString(long j) {
        if (j == Long.MAX_VALUE || j == Long.MIN_VALUE) {
            return null;
        }
        return Grego.timeToString(j);
    }

    /* access modifiers changed from: private */
    public static String debugString(Object obj) {
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            Field[] fields = obj.getClass().getFields();
            for (Field field : fields) {
                Object obj2 = field.get(obj);
                if (obj2 != null) {
                    if (obj2 instanceof Date) {
                        str = dateString(((Date) obj2).getTime());
                    } else if (obj2 instanceof Long) {
                        str = dateString(((Long) obj2).longValue());
                    } else {
                        str = String.valueOf(obj2);
                    }
                    if (str != null) {
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(field.getName()).append("='").append(str).append("'");
                    }
                }
            }
        } catch (Throwable th) {
        }
        sb.insert(0, obj.getClass().getSimpleName() + "(");
        sb.append(")");
        return sb.toString();
    }
}
