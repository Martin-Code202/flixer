package com.google.android.gms.internal;
final class zzayx implements Runnable {
    private /* synthetic */ zzayv zzfaq;

    private zzayx(zzayv zzayv) {
        this.zzfaq = zzayv;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzfaq.zzfap = false;
        this.zzfaq.zzbb(this.zzfaq.zzz(this.zzfaq.zzasb.elapsedRealtime()));
    }
}
