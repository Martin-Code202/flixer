package com.google.android.gms.internal;

import java.util.concurrent.Callable;
final class zzcdn implements Callable<byte[]> {
    private /* synthetic */ String zziag;
    private /* synthetic */ zzcdb zziuj;
    private /* synthetic */ zzcbk zziun;

    zzcdn(zzcdb zzcdb, zzcbk zzcbk, String str) {
        this.zziuj = zzcdb;
        this.zziun = zzcbk;
        this.zziag = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() {
        zzcdb.zza(this.zziuj).zzazl();
        return zzcdb.zza(this.zziuj).zza(this.zziun, this.zziag);
    }
}
