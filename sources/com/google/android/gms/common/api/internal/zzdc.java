package com.google.android.gms.common.api.internal;
final class zzdc implements Runnable {
    private /* synthetic */ String zzao;
    private /* synthetic */ LifecycleCallback zzfor;
    private /* synthetic */ zzdb zzfpf;

    zzdc(zzdb zzdb, LifecycleCallback lifecycleCallback, String str) {
        this.zzfpf = zzdb;
        this.zzfor = lifecycleCallback;
        this.zzao = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzfpf.zzbyy > 0) {
            this.zzfor.onCreate(this.zzfpf.zzfoq != null ? this.zzfpf.zzfoq.getBundle(this.zzao) : null);
        }
        if (this.zzfpf.zzbyy >= 2) {
            this.zzfor.onStart();
        }
        if (this.zzfpf.zzbyy >= 3) {
            this.zzfor.onResume();
        }
        if (this.zzfpf.zzbyy >= 4) {
            this.zzfor.onStop();
        }
        if (this.zzfpf.zzbyy >= 5) {
            this.zzfor.onDestroy();
        }
    }
}
