package com.google.android.gms.internal;

import android.os.Bundle;
/* access modifiers changed from: package-private */
public final class zzcee implements Runnable {
    private /* synthetic */ String val$name;
    private /* synthetic */ String zziag;
    private /* synthetic */ String zziul;
    private /* synthetic */ zzcdw zziux;
    private /* synthetic */ long zzivc;
    private /* synthetic */ Bundle zzivd;
    private /* synthetic */ boolean zzive;
    private /* synthetic */ boolean zzivf;
    private /* synthetic */ boolean zzivg;

    zzcee(zzcdw zzcdw, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.zziux = zzcdw;
        this.zziul = str;
        this.val$name = str2;
        this.zzivc = j;
        this.zzivd = bundle;
        this.zzive = z;
        this.zzivf = z2;
        this.zzivg = z3;
        this.zziag = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zziux.zzb(this.zziul, this.val$name, this.zzivc, this.zzivd, this.zzive, this.zzivf, this.zzivg, this.zziag);
    }
}
