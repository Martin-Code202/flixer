package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;
/* access modifiers changed from: package-private */
public final class zzceq implements Runnable {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzceo zziwe;
    private /* synthetic */ AtomicReference zziwf;

    zzceq(zzceo zzceo, AtomicReference atomicReference, zzcas zzcas) {
        this.zziwe = zzceo;
        this.zziwf = atomicReference;
        this.zziui = zzcas;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zziwf) {
            try {
                zzcbo zzcbo = this.zziwe.zzivy;
                if (zzcbo == null) {
                    this.zziwe.zzaum().zzaye().log("Failed to get app instance id");
                    return;
                }
                this.zziwf.set(zzcbo.zzc(this.zziui));
                String str = (String) this.zziwf.get();
                if (str != null) {
                    this.zziwe.zzaua().zzjk(str);
                    this.zziwe.zzaun().zziqu.zzjl(str);
                }
                this.zziwe.zzww();
                this.zziwf.notify();
            } catch (RemoteException e) {
                this.zziwe.zzaum().zzaye().zzj("Failed to get app instance id", e);
            } finally {
                this.zziwf.notify();
            }
        }
    }
}
