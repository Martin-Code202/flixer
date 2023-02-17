package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
import java.util.Map;
public class ProductAction {
    private Map<String, String> zzdnn;

    public final Map<String, String> build() {
        return new HashMap(this.zzdnn);
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.zzdnn.entrySet()) {
            if (entry.getKey().startsWith("&")) {
                hashMap.put(entry.getKey().substring(1), entry.getValue());
            } else {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return zzh.zzl(hashMap);
    }
}
