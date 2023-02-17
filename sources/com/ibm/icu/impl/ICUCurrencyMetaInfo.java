package com.ibm.icu.impl;

import com.ibm.icu.text.CurrencyMetaInfo;
import com.ibm.icu.util.Currency;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class ICUCurrencyMetaInfo extends CurrencyMetaInfo {
    private ICUResourceBundle digitInfo;
    private ICUResourceBundle regionInfo;

    /* access modifiers changed from: package-private */
    public interface Collector<T> {
        void collect(String str, String str2, long j, long j2, int i, boolean z);

        int collects();

        List<T> getList();
    }

    public ICUCurrencyMetaInfo() {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/curr", "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
        this.regionInfo = iCUResourceBundle.findTopLevel("CurrencyMap");
        this.digitInfo = iCUResourceBundle.findTopLevel("CurrencyMeta");
    }

    @Override // com.ibm.icu.text.CurrencyMetaInfo
    public List<String> currencies(CurrencyMetaInfo.CurrencyFilter currencyFilter) {
        return collect(new CurrencyCollector(), currencyFilter);
    }

    @Override // com.ibm.icu.text.CurrencyMetaInfo
    public CurrencyMetaInfo.CurrencyDigits currencyDigits(String str, Currency.CurrencyUsage currencyUsage) {
        ICUResourceBundle findWithFallback = this.digitInfo.findWithFallback(str);
        if (findWithFallback == null) {
            findWithFallback = this.digitInfo.findWithFallback("DEFAULT");
        }
        int[] intVector = findWithFallback.getIntVector();
        if (currencyUsage == Currency.CurrencyUsage.CASH) {
            return new CurrencyMetaInfo.CurrencyDigits(intVector[2], intVector[3]);
        }
        if (currencyUsage == Currency.CurrencyUsage.STANDARD) {
            return new CurrencyMetaInfo.CurrencyDigits(intVector[0], intVector[1]);
        }
        return new CurrencyMetaInfo.CurrencyDigits(intVector[0], intVector[1]);
    }

    private <T> List<T> collect(Collector<T> collector, CurrencyMetaInfo.CurrencyFilter currencyFilter) {
        if (currencyFilter == null) {
            currencyFilter = CurrencyMetaInfo.CurrencyFilter.all();
        }
        int collects = collector.collects();
        if (currencyFilter.region != null) {
            collects |= 1;
        }
        if (currencyFilter.currency != null) {
            collects |= 2;
        }
        if (!(currencyFilter.from == Long.MIN_VALUE && currencyFilter.to == Long.MAX_VALUE)) {
            collects |= 4;
        }
        if (currencyFilter.tenderOnly) {
            collects |= 8;
        }
        if (collects != 0) {
            if (currencyFilter.region != null) {
                ICUResourceBundle findWithFallback = this.regionInfo.findWithFallback(currencyFilter.region);
                if (findWithFallback != null) {
                    collectRegion(collector, currencyFilter, collects, findWithFallback);
                }
            } else {
                for (int i = 0; i < this.regionInfo.getSize(); i++) {
                    collectRegion(collector, currencyFilter, collects, this.regionInfo.at(i));
                }
            }
        }
        return collector.getList();
    }

    private <T> void collectRegion(Collector<T> collector, CurrencyMetaInfo.CurrencyFilter currencyFilter, int i, ICUResourceBundle iCUResourceBundle) {
        String key = iCUResourceBundle.getKey();
        if (i == 1) {
            collector.collect(iCUResourceBundle.getKey(), null, 0, 0, -1, false);
            return;
        }
        for (int i2 = 0; i2 < iCUResourceBundle.getSize(); i2++) {
            ICUResourceBundle at = iCUResourceBundle.at(i2);
            if (at.getSize() != 0) {
                String str = null;
                long j = Long.MIN_VALUE;
                long j2 = Long.MAX_VALUE;
                boolean z = true;
                if ((i & 2) != 0) {
                    str = at.at("id").getString();
                    if (currencyFilter.currency != null && !currencyFilter.currency.equals(str)) {
                    }
                }
                if ((i & 4) != 0) {
                    j = getDate(at.at(NetflixActivity.EXTRA_FROM), Long.MIN_VALUE, false);
                    j2 = getDate(at.at("to"), Long.MAX_VALUE, true);
                    if (currencyFilter.from <= j2) {
                        if (currencyFilter.to < j) {
                        }
                    }
                }
                if ((i & 8) != 0) {
                    ICUResourceBundle at2 = at.at("tender");
                    z = at2 == null || "true".equals(at2.getString());
                    if (currencyFilter.tenderOnly && !z) {
                    }
                }
                collector.collect(key, str, j, j2, i2, z);
            }
        }
    }

    private long getDate(ICUResourceBundle iCUResourceBundle, long j, boolean z) {
        if (iCUResourceBundle == null) {
            return j;
        }
        int[] intVector = iCUResourceBundle.getIntVector();
        return (((long) intVector[0]) << 32) | (((long) intVector[1]) & 4294967295L);
    }

    static class UniqueList<T> {
        private List<T> list = new ArrayList();
        private Set<T> seen = new HashSet();

        private UniqueList() {
        }

        /* access modifiers changed from: private */
        public static <T> UniqueList<T> create() {
            return new UniqueList<>();
        }

        /* access modifiers changed from: package-private */
        public void add(T t) {
            if (!this.seen.contains(t)) {
                this.list.add(t);
                this.seen.add(t);
            }
        }

        /* access modifiers changed from: package-private */
        public List<T> list() {
            return Collections.unmodifiableList(this.list);
        }
    }

    static class CurrencyCollector implements Collector<String> {
        private final UniqueList<String> result;

        private CurrencyCollector() {
            this.result = UniqueList.create();
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public void collect(String str, String str2, long j, long j2, int i, boolean z) {
            this.result.add(str2);
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public int collects() {
            return 2;
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public List<String> getList() {
            return this.result.list();
        }
    }
}
