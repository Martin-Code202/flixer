package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzbp;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public final class zzalz extends zzh<zzalz> {
    private final Map<String, Object> zzbql = new HashMap();

    public final void set(String str, String str2) {
        String str3 = str;
        zzbp.zzgg(str);
        if (str3 != null && str3.startsWith("&")) {
            str3 = str3.substring(1);
        }
        zzbp.zzh(str3, "Name can not be empty or \"&\"");
        this.zzbql.put(str3, str2);
    }

    public final String toString() {
        return zzh(this.zzbql);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzalz zzalz) {
        zzalz zzalz2 = zzalz;
        zzbp.zzu(zzalz2);
        zzalz2.zzbql.putAll(this.zzbql);
    }

    public final Map<String, Object> zzuy() {
        return Collections.unmodifiableMap(this.zzbql);
    }
}
