package com.google.android.gms.internal;
public final class zzcby {
    private final int mPriority;
    private /* synthetic */ zzcbw zziqb;
    private final boolean zziqc;
    private final boolean zziqd;

    zzcby(zzcbw zzcbw, int i, boolean z, boolean z2) {
        this.zziqb = zzcbw;
        this.mPriority = i;
        this.zziqc = z;
        this.zziqd = z2;
    }

    public final void log(String str) {
        this.zziqb.zza(this.mPriority, this.zziqc, this.zziqd, str, null, null, null);
    }

    public final void zzd(String str, Object obj, Object obj2, Object obj3) {
        this.zziqb.zza(this.mPriority, this.zziqc, this.zziqd, str, obj, obj2, obj3);
    }

    public final void zze(String str, Object obj, Object obj2) {
        this.zziqb.zza(this.mPriority, this.zziqc, this.zziqd, str, obj, obj2, null);
    }

    public final void zzj(String str, Object obj) {
        this.zziqb.zza(this.mPriority, this.zziqc, this.zziqd, str, obj, null, null);
    }
}
