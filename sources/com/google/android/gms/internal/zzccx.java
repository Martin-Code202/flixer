package com.google.android.gms.internal;
/* access modifiers changed from: package-private */
public final class zzccx implements Runnable {
    private /* synthetic */ zzccw zziuc;

    zzccx(zzccw zzccw) {
        this.zziuc = zzccw;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zziuc.start();
    }
}
