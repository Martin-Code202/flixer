package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbp;
import java.lang.Thread;
/* access modifiers changed from: package-private */
public final class zzcct implements Thread.UncaughtExceptionHandler {
    private final String zzisk;
    private /* synthetic */ zzccr zzisl;

    public zzcct(zzccr zzccr, String str) {
        this.zzisl = zzccr;
        zzbp.zzu(str);
        this.zzisk = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzisl.zzaum().zzaye().zzj(this.zzisk, th);
    }
}
