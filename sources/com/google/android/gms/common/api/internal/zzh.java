package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzbf;
import java.util.Arrays;
public final class zzh<O extends Api.ApiOptions> {
    private final Api<O> zzfdf;
    private final O zzfgq;
    private final boolean zzfih = true;
    private final int zzfii;

    private zzh(Api<O> api) {
        this.zzfdf = api;
        this.zzfgq = null;
        this.zzfii = System.identityHashCode(this);
    }

    private zzh(Api<O> api, O o2) {
        this.zzfdf = api;
        this.zzfgq = o2;
        this.zzfii = Arrays.hashCode(new Object[]{this.zzfdf, this.zzfgq});
    }

    public static <O extends Api.ApiOptions> zzh<O> zza(Api<O> api, O o2) {
        return new zzh<>(api, o2);
    }

    public static <O extends Api.ApiOptions> zzh<O> zzb(Api<O> api) {
        return new zzh<>(api);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzh = (zzh) obj;
        return !this.zzfih && !zzh.zzfih && zzbf.equal(this.zzfdf, zzh.zzfdf) && zzbf.equal(this.zzfgq, zzh.zzfgq);
    }

    public final int hashCode() {
        return this.zzfii;
    }

    public final String zzafv() {
        return this.zzfdf.getName();
    }
}
