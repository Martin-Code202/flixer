package com.google.android.gms.internal;
final class zzcfg implements Runnable {
    private /* synthetic */ zzcfb zziwo;

    zzcfg(zzcfb zzcfb) {
        this.zziwo = zzcfb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zziwo.zziwe.zzivy = null;
        this.zziwo.zziwe.zzazs();
    }
}
