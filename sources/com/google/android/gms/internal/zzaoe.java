package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbp;
public final class zzaoe<V> {
    private final V zzdsp;
    private final zzbbw<V> zzdsq;

    private zzaoe(zzbbw<V> zzbbw, V v) {
        zzbp.zzu(zzbbw);
        this.zzdsq = zzbbw;
        this.zzdsp = v;
    }

    static zzaoe<Float> zza(String str, float f, float f2) {
        return new zzaoe<>(zzbbw.zza(str, Float.valueOf(0.5f)), Float.valueOf(0.5f));
    }

    static zzaoe<Integer> zza(String str, int i, int i2) {
        return new zzaoe<>(zzbbw.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    static zzaoe<Long> zza(String str, long j, long j2) {
        return new zzaoe<>(zzbbw.zza(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    static zzaoe<Boolean> zza(String str, boolean z, boolean z2) {
        return new zzaoe<>(zzbbw.zze(str, z2), Boolean.valueOf(z));
    }

    static zzaoe<String> zzc(String str, String str2, String str3) {
        return new zzaoe<>(zzbbw.zzt(str, str3), str2);
    }

    public final V get() {
        return this.zzdsp;
    }
}
