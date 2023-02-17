package com.google.android.gms.internal;
final class zzcaq implements Runnable {
    private /* synthetic */ long zzikw;
    private /* synthetic */ zzcan zzikx;

    zzcaq(zzcan zzcan, long j) {
        this.zzikx = zzcan;
        this.zzikw = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzikx.zzak(this.zzikw);
    }
}
