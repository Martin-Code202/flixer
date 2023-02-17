package com.google.android.gms.internal;
/* access modifiers changed from: package-private */
public final class zzamp implements Runnable {
    private /* synthetic */ zzamj zzdnw;
    private /* synthetic */ zzaob zzdob;

    zzamp(zzamj zzamj, zzaob zzaob) {
        this.zzdnw = zzamj;
        this.zzdob = zzaob;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdnw.zzdnu.zzb(this.zzdob);
    }
}
