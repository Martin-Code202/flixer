package com.google.android.gms.internal;
final class zzazh implements Runnable {
    private /* synthetic */ zzaze zzfbq;
    private /* synthetic */ int zzfbr;

    zzazh(zzazg zzazg, zzaze zzaze, int i) {
        this.zzfbq = zzaze;
        this.zzfbr = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzfbq.zzeij.onApplicationDisconnected(this.zzfbr);
    }
}
