package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class zzamb extends zzh<zzamb> {
    private ProductAction zzdkd;
    private final Map<String, List<Product>> zzdke = new HashMap();
    private final List<Promotion> zzdkf = new ArrayList();
    private final List<Product> zzdkg = new ArrayList();

    public final String toString() {
        HashMap hashMap = new HashMap();
        if (!this.zzdkg.isEmpty()) {
            hashMap.put("products", this.zzdkg);
        }
        if (!this.zzdkf.isEmpty()) {
            hashMap.put("promotions", this.zzdkf);
        }
        if (!this.zzdke.isEmpty()) {
            hashMap.put("impressions", this.zzdke);
        }
        hashMap.put("productAction", this.zzdkd);
        return zzh(hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzamb zzamb) {
        zzamb zzamb2 = zzamb;
        zzamb2.zzdkg.addAll(this.zzdkg);
        zzamb2.zzdkf.addAll(this.zzdkf);
        for (Map.Entry<String, List<Product>> entry : this.zzdke.entrySet()) {
            String key = entry.getKey();
            for (Product product : entry.getValue()) {
                String str = key;
                if (product != null) {
                    if (str == null) {
                        str = "";
                    }
                    if (!zzamb2.zzdke.containsKey(str)) {
                        zzamb2.zzdke.put(str, new ArrayList());
                    }
                    zzamb2.zzdke.get(str).add(product);
                }
            }
        }
        if (this.zzdkd != null) {
            zzamb2.zzdkd = this.zzdkd;
        }
    }

    public final ProductAction zzuz() {
        return this.zzdkd;
    }

    public final List<Product> zzva() {
        return Collections.unmodifiableList(this.zzdkg);
    }

    public final Map<String, List<Product>> zzvb() {
        return this.zzdke;
    }

    public final List<Promotion> zzvc() {
        return Collections.unmodifiableList(this.zzdkf);
    }
}
