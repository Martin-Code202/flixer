package com.google.android.gms.internal;
final class zzazi implements Runnable {
    private /* synthetic */ zzaze zzfbq;
    private /* synthetic */ zzazm zzfbs;

    zzazi(zzazg zzazg, zzaze zzaze, zzazm zzazm) {
        this.zzfbq = zzaze;
        this.zzfbs = zzazm;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzfbq.zza(this.zzfbs);
    }
}
