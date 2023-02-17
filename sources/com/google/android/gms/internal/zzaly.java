package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzh;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public final class zzaly extends zzh<zzaly> {
    private Map<Integer, Double> zzdml = new HashMap(4);

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, Double> entry : this.zzdml.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 6).append("metric").append(valueOf).toString(), entry.getValue());
        }
        return zzh(hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzaly zzaly) {
        zzaly.zzdml.putAll(this.zzdml);
    }

    public final Map<Integer, Double> zzux() {
        return Collections.unmodifiableMap(this.zzdml);
    }
}
