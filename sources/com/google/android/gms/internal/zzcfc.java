package com.google.android.gms.internal;
final class zzcfc implements Runnable {
    private /* synthetic */ zzcbo zziwn;
    private /* synthetic */ zzcfb zziwo;

    zzcfc(zzcfb zzcfb, zzcbo zzcbo) {
        this.zziwo = zzcfb;
        this.zziwn = zzcbo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zziwo) {
            zzcfb.zza(this.zziwo, false);
            if (!this.zziwo.zziwe.isConnected()) {
                this.zziwo.zziwe.zzaum().zzayk().log("Connected to service");
                this.zziwo.zziwe.zza(this.zziwn);
            }
        }
    }
}
