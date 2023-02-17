package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;
/* access modifiers changed from: package-private */
public final class zzcdy implements Runnable {
    private /* synthetic */ zzcdw zziux;
    private /* synthetic */ AppMeasurement.ConditionalUserProperty zziuy;

    zzcdy(zzcdw zzcdw, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.zziux = zzcdw;
        this.zziuy = conditionalUserProperty;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zziux.zzb(this.zziuy);
    }
}
