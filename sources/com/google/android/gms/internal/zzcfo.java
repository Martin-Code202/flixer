package com.google.android.gms.internal;
final class zzcfo implements Runnable {
    private /* synthetic */ long zzikw;
    private /* synthetic */ zzcfl zziwv;

    zzcfo(zzcfl zzcfl, long j) {
        this.zziwv = zzcfl;
        this.zzikw = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zziwv.zzbd(this.zzikw);
    }
}
