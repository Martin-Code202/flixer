package com.google.android.gms.internal;

import android.content.ComponentName;
final class zzanc implements Runnable {
    private /* synthetic */ ComponentName val$name;
    private /* synthetic */ zzana zzdph;

    zzanc(zzana zzana, ComponentName componentName) {
        this.zzdph = zzana;
        this.val$name = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdph.zzdpd.onServiceDisconnected(this.val$name);
    }
}
