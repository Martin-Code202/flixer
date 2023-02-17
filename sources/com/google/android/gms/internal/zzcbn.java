package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbp;
public final class zzcbn<V> {
    private final String zzbfe;
    private final V zzdsp;
    private final zzbbw<V> zzdsq;

    private zzcbn(String str, zzbbw<V> zzbbw, V v) {
        zzbp.zzu(zzbbw);
        this.zzdsq = zzbbw;
        this.zzdsp = v;
        this.zzbfe = str;
    }

    static zzcbn<Long> zzb(String str, long j, long j2) {
        return new zzcbn<>(str, zzbbw.zza(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    static zzcbn<Boolean> zzb(String str, boolean z, boolean z2) {
        return new zzcbn<>(str, zzbbw.zze(str, z2), Boolean.valueOf(z));
    }

    static zzcbn<String> zzi(String str, String str2, String str3) {
        return new zzcbn<>(str, zzbbw.zzt(str, str3), str2);
    }

    static zzcbn<Integer> zzm(String str, int i, int i2) {
        return new zzcbn<>(str, zzbbw.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    public final V get() {
        return this.zzdsp;
    }

    public final V get(V v) {
        return v != null ? v : this.zzdsp;
    }

    public final String getKey() {
        return this.zzbfe;
    }
}
