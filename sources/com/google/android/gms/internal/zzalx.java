package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzh;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public final class zzalx extends zzh<zzalx> {
    private Map<Integer, String> zzdmk = new HashMap(4);

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, String> entry : this.zzdmk.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 9).append("dimension").append(valueOf).toString(), entry.getValue());
        }
        return zzh(hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzalx zzalx) {
        zzalx.zzdmk.putAll(this.zzdmk);
    }

    public final Map<Integer, String> zzuw() {
        return Collections.unmodifiableMap(this.zzdmk);
    }
}
