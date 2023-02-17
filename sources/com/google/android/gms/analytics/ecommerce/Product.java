package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
import java.util.Map;
public class Product {
    private Map<String, String> zzdnn = new HashMap();

    public String toString() {
        return zzh.zzl(this.zzdnn);
    }

    public final Map<String, String> zzdj(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.zzdnn.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), entry.getValue());
        }
        return hashMap;
    }
}
