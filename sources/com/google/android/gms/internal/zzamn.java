package com.google.android.gms.internal;
/* access modifiers changed from: package-private */
public final class zzamn implements Runnable {
    private /* synthetic */ zzamj zzdnw;
    private /* synthetic */ zzaoi zzdoa;

    zzamn(zzamj zzamj, zzaoi zzaoi) {
        this.zzdnw = zzamj;
        this.zzdoa = zzaoi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdnw.zzdnu.zza(this.zzdoa);
    }
}
