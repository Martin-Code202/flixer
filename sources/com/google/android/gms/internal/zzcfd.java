package com.google.android.gms.internal;

import android.content.ComponentName;
final class zzcfd implements Runnable {
    private /* synthetic */ ComponentName val$name;
    private /* synthetic */ zzcfb zziwo;

    zzcfd(zzcfb zzcfb, ComponentName componentName) {
        this.zziwo = zzcfb;
        this.val$name = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zziwo.zziwe.onServiceDisconnected(this.val$name);
    }
}
