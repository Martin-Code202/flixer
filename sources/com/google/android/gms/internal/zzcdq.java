package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;
final class zzcdq implements Callable<List<zzcfv>> {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzcdb zziuj;

    zzcdq(zzcdb zzcdb, zzcas zzcas) {
        this.zziuj = zzcdb;
        this.zziui = zzcas;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzcfv> call() {
        zzcdb.zza(this.zziuj).zzazl();
        return zzcdb.zza(this.zziuj).zzaug().zziv(this.zziui.packageName);
    }
}
