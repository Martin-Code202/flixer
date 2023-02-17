package com.google.android.gms.internal;
final class zzcap implements Runnable {
    private /* synthetic */ String zzanx;
    private /* synthetic */ long zzikw;
    private /* synthetic */ zzcan zzikx;

    zzcap(zzcan zzcan, String str, long j) {
        this.zzikx = zzcan;
        this.zzanx = str;
        this.zzikw = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcan.zzb(this.zzikx, this.zzanx, this.zzikw);
    }
}
