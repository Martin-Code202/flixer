package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbp;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public final class zzamx {
    private final Map<String, String> zzbql;
    private final String zzdmw;
    private final long zzdov = 0;
    private final String zzdow;
    private final boolean zzdox;
    private long zzdoy;

    public zzamx(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        this.zzdmw = str;
        this.zzdow = str2;
        this.zzdox = z;
        this.zzdoy = j2;
        if (map != null) {
            this.zzbql = new HashMap(map);
        } else {
            this.zzbql = Collections.emptyMap();
        }
    }

    public final Map<String, String> zziy() {
        return this.zzbql;
    }

    public final void zzm(long j) {
        this.zzdoy = j;
    }

    public final String zzve() {
        return this.zzdmw;
    }

    public final long zzwr() {
        return this.zzdov;
    }

    public final String zzws() {
        return this.zzdow;
    }

    public final boolean zzwt() {
        return this.zzdox;
    }

    public final long zzwu() {
        return this.zzdoy;
    }
}
