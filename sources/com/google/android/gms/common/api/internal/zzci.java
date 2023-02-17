package com.google.android.gms.common.api.internal;
final class zzci implements Runnable {
    private /* synthetic */ String zzao;
    private /* synthetic */ LifecycleCallback zzfor;
    private /* synthetic */ zzch zzfos;

    zzci(zzch zzch, LifecycleCallback lifecycleCallback, String str) {
        this.zzfos = zzch;
        this.zzfor = lifecycleCallback;
        this.zzao = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzfos.zzbyy > 0) {
            this.zzfor.onCreate(this.zzfos.zzfoq != null ? this.zzfos.zzfoq.getBundle(this.zzao) : null);
        }
        if (this.zzfos.zzbyy >= 2) {
            this.zzfor.onStart();
        }
        if (this.zzfos.zzbyy >= 3) {
            this.zzfor.onResume();
        }
        if (this.zzfos.zzbyy >= 4) {
            this.zzfor.onStop();
        }
        if (this.zzfos.zzbyy >= 5) {
            this.zzfor.onDestroy();
        }
    }
}
