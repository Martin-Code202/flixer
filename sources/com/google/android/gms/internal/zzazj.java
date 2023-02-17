package com.google.android.gms.internal;
final class zzazj implements Runnable {
    private /* synthetic */ zzaze zzfbq;
    private /* synthetic */ zzays zzfbt;

    zzazj(zzazg zzazg, zzaze zzaze, zzays zzays) {
        this.zzfbq = zzaze;
        this.zzfbt = zzays;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzfbq.zza(this.zzfbt);
    }
}
