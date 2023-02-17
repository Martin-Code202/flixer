package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
/* access modifiers changed from: package-private */
public final class zzcev implements Runnable {
    private /* synthetic */ String zziag;
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzcbk zziun;
    private /* synthetic */ zzceo zziwe;
    private /* synthetic */ boolean zziwh = true;
    private /* synthetic */ boolean zziwi;

    zzcev(zzceo zzceo, boolean z, boolean z2, zzcbk zzcbk, zzcas zzcas, String str) {
        this.zziwe = zzceo;
        this.zziwi = z2;
        this.zziun = zzcbk;
        this.zziui = zzcas;
        this.zziag = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbo zzcbo = this.zziwe.zzivy;
        if (zzcbo == null) {
            this.zziwe.zzaum().zzaye().log("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zziwh) {
            this.zziwe.zza(zzcbo, this.zziwi ? null : this.zziun, this.zziui);
        } else {
            try {
                if (TextUtils.isEmpty(this.zziag)) {
                    zzcbo.zza(this.zziun, this.zziui);
                } else {
                    zzcbo.zza(this.zziun, this.zziag, this.zziwe.zzaum().zzayl());
                }
            } catch (RemoteException e) {
                this.zziwe.zzaum().zzaye().zzj("Failed to send event to the service", e);
            }
        }
        this.zziwe.zzww();
    }
}
