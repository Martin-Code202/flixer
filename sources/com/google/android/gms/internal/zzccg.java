package com.google.android.gms.internal;
final class zzccg implements Runnable {
    private /* synthetic */ boolean zziqk;
    private /* synthetic */ zzccf zziql;

    zzccg(zzccf zzccf, boolean z) {
        this.zziql = zzccf;
        this.zziqk = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzccf.zza(this.zziql).zzbo(this.zziqk);
    }
}
