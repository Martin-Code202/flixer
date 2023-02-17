package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;
/* access modifiers changed from: package-private */
public final class zzcea implements Runnable {
    private /* synthetic */ String zziag;
    private /* synthetic */ String zziul;
    private /* synthetic */ String zzium;
    private /* synthetic */ zzcdw zziux;
    private /* synthetic */ AtomicReference zziuz;

    zzcea(zzcdw zzcdw, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zziux = zzcdw;
        this.zziuz = atomicReference;
        this.zziag = str;
        this.zziul = str2;
        this.zzium = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zziux.zzikh.zzaud().zza(this.zziuz, this.zziag, this.zziul, this.zzium);
    }
}
