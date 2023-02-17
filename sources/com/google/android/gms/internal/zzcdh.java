package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;
final class zzcdh implements Callable<List<zzcfv>> {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzcdb zziuj;
    private /* synthetic */ String zziul;
    private /* synthetic */ String zzium;

    zzcdh(zzcdb zzcdb, zzcas zzcas, String str, String str2) {
        this.zziuj = zzcdb;
        this.zziui = zzcas;
        this.zziul = str;
        this.zzium = str2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzcfv> call() {
        zzcdb.zza(this.zziuj).zzazl();
        return zzcdb.zza(this.zziuj).zzaug().zzg(this.zziui.packageName, this.zziul, this.zzium);
    }
}
