package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
final class zzcff implements Runnable {
    private /* synthetic */ zzcfb zziwo;

    zzcff(zzcfb zzcfb) {
        this.zziwo = zzcfb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzceo zzceo = this.zziwo.zziwe;
        Context context = this.zziwo.zziwe.getContext();
        zzcax.zzawl();
        zzceo.onServiceDisconnected(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
