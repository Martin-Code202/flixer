package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
/* access modifiers changed from: package-private */
public final class zzcey implements Runnable {
    private /* synthetic */ String zziag;
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ String zziul;
    private /* synthetic */ String zzium;
    private /* synthetic */ boolean zziva;
    private /* synthetic */ zzceo zziwe;
    private /* synthetic */ AtomicReference zziwf;

    zzcey(zzceo zzceo, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzcas zzcas) {
        this.zziwe = zzceo;
        this.zziwf = atomicReference;
        this.zziag = str;
        this.zziul = str2;
        this.zzium = str3;
        this.zziva = z;
        this.zziui = zzcas;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zziwf) {
            try {
                zzcbo zzcbo = this.zziwe.zzivy;
                if (zzcbo == null) {
                    this.zziwe.zzaum().zzaye().zzd("Failed to get user properties", zzcbw.zzjf(this.zziag), this.zziul, this.zzium);
                    this.zziwf.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.zziag)) {
                    this.zziwf.set(zzcbo.zza(this.zziul, this.zzium, this.zziva, this.zziui));
                } else {
                    this.zziwf.set(zzcbo.zza(this.zziag, this.zziul, this.zzium, this.zziva));
                }
                this.zziwe.zzww();
                this.zziwf.notify();
            } catch (RemoteException e) {
                this.zziwe.zzaum().zzaye().zzd("Failed to get user properties", zzcbw.zzjf(this.zziag), this.zziul, e);
                this.zziwf.set(Collections.emptyList());
            } finally {
                this.zziwf.notify();
            }
        }
    }
}
