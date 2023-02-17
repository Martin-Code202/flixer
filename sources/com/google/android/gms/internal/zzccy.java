package com.google.android.gms.internal;

import java.util.concurrent.Callable;
/* access modifiers changed from: package-private */
public final class zzccy implements Callable<String> {
    private /* synthetic */ String zziag;
    private /* synthetic */ zzccw zziuc;

    zzccy(zzccw zzccw, String str) {
        this.zziuc = zzccw;
        this.zziag = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        zzcar zziw = this.zziuc.zzaug().zziw(this.zziag);
        if (zziw != null) {
            return zziw.getAppInstanceId();
        }
        this.zziuc.zzaum().zzayg().log("App info was null when attempting to get app instance id");
        return null;
    }
}
