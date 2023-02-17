package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
public final class zzcpt implements Api.ApiOptions.Optional {
    public static final zzcpt zzjno = new zzcpt(false, false, null, false, null, false, null, null);
    private final boolean zzeao = false;
    private final String zzeap = null;
    private final boolean zzech = false;
    private final String zzeci = null;
    private final boolean zzjnp = false;
    private final boolean zzjnq = false;
    private final Long zzjnr = null;
    private final Long zzjns = null;

    static {
        new zzcpu();
    }

    private zzcpt(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
    }

    public final String getServerClientId() {
        return this.zzeap;
    }

    public final boolean isIdTokenRequested() {
        return this.zzeao;
    }

    public final boolean zzbbx() {
        return this.zzjnp;
    }

    public final boolean zzbby() {
        return this.zzech;
    }

    public final String zzbbz() {
        return this.zzeci;
    }

    public final boolean zzbca() {
        return this.zzjnq;
    }

    public final Long zzbcb() {
        return this.zzjnr;
    }

    public final Long zzbcc() {
        return this.zzjns;
    }
}
