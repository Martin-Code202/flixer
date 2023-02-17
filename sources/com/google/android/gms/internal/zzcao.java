package com.google.android.gms.internal;
final class zzcao implements Runnable {
    private /* synthetic */ String zzanx;
    private /* synthetic */ long zzikw;
    private /* synthetic */ zzcan zzikx;

    zzcao(zzcan zzcan, String str, long j) {
        this.zzikx = zzcan;
        this.zzanx = str;
        this.zzikw = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcan.zza(this.zzikx, this.zzanx, this.zzikw);
    }
}
