package com.google.android.gms.internal;
final class zzcfp implements Runnable {
    private /* synthetic */ long zzikw;
    private /* synthetic */ zzcfl zziwv;

    zzcfp(zzcfl zzcfl, long j) {
        this.zziwv = zzcfl;
        this.zzikw = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zziwv.zzbe(this.zzikw);
    }
}
