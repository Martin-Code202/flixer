package com.google.android.gms.internal;
/* access modifiers changed from: package-private */
public final class zzcef implements Runnable {
    private /* synthetic */ String val$name;
    private /* synthetic */ String zziul;
    private /* synthetic */ zzcdw zziux;
    private /* synthetic */ long zzivc;
    private /* synthetic */ Object zzivh;

    zzcef(zzcdw zzcdw, String str, String str2, Object obj, long j) {
        this.zziux = zzcdw;
        this.zziul = str;
        this.val$name = str2;
        this.zzivh = obj;
        this.zzivc = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zziux.zza(this.zziul, this.val$name, this.zzivh, this.zzivc);
    }
}
