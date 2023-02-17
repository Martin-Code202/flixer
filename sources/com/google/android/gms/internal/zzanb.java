package com.google.android.gms.internal;
final class zzanb implements Runnable {
    private /* synthetic */ zzaoj zzdpg;
    private /* synthetic */ zzana zzdph;

    zzanb(zzana zzana, zzaoj zzaoj) {
        this.zzdph = zzana;
        this.zzdpg = zzaoj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.zzdph.zzdpd.isConnected()) {
            this.zzdph.zzdpd.zzdn("Connected to service after a timeout");
            this.zzdph.zzdpd.zza(this.zzdpg);
        }
    }
}
