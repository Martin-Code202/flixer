package com.google.android.gms.internal;
final class zzcfe implements Runnable {
    private /* synthetic */ zzcfb zziwo;
    private /* synthetic */ zzcbo zziwp;

    zzcfe(zzcfb zzcfb, zzcbo zzcbo) {
        this.zziwo = zzcfb;
        this.zziwp = zzcbo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zziwo) {
            zzcfb.zza(this.zziwo, false);
            if (!this.zziwo.zziwe.isConnected()) {
                this.zziwo.zziwe.zzaum().zzayj().log("Connected to remote service");
                this.zziwo.zziwe.zza(this.zziwp);
            }
        }
    }
}
