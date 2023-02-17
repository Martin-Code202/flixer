package com.google.android.gms.internal;
/* access modifiers changed from: package-private */
public final class zzcez implements Runnable {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzcft zziuo;
    private /* synthetic */ zzceo zziwe;
    private /* synthetic */ boolean zziwi;

    zzcez(zzceo zzceo, boolean z, zzcft zzcft, zzcas zzcas) {
        this.zziwe = zzceo;
        this.zziwi = z;
        this.zziuo = zzcft;
        this.zziui = zzcas;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbo zzcbo = this.zziwe.zzivy;
        if (zzcbo == null) {
            this.zziwe.zzaum().zzaye().log("Discarding data. Failed to set user attribute");
            return;
        }
        this.zziwe.zza(zzcbo, this.zziwi ? null : this.zziuo, this.zziui);
        this.zziwe.zzww();
    }
}
