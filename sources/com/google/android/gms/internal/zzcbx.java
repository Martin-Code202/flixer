package com.google.android.gms.internal;
/* access modifiers changed from: package-private */
public final class zzcbx implements Runnable {
    private /* synthetic */ String zziqa;
    private /* synthetic */ zzcbw zziqb;

    zzcbx(zzcbw zzcbw, String str) {
        this.zziqb = zzcbw;
        this.zziqa = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcch zzaun = this.zziqb.zzikh.zzaun();
        if (!zzaun.isInitialized()) {
            this.zziqb.zzk(6, "Persisted config not initialized. Not logging error/warn");
        } else {
            zzaun.zziqn.zzf(this.zziqa, 1);
        }
    }
}
