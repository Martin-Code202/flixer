package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;
final class zzcdi implements Callable<List<zzcfv>> {
    private /* synthetic */ String zziag;
    private /* synthetic */ zzcdb zziuj;
    private /* synthetic */ String zziul;
    private /* synthetic */ String zzium;

    zzcdi(zzcdb zzcdb, String str, String str2, String str3) {
        this.zziuj = zzcdb;
        this.zziag = str;
        this.zziul = str2;
        this.zzium = str3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzcfv> call() {
        zzcdb.zza(this.zziuj).zzazl();
        return zzcdb.zza(this.zziuj).zzaug().zzg(this.zziag, this.zziul, this.zzium);
    }
}
