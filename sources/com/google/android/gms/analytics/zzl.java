package com.google.android.gms.analytics;

import android.util.Log;
import com.google.android.gms.analytics.zzj;
import java.lang.Thread;
import java.util.concurrent.FutureTask;
final class zzl extends FutureTask<T> {
    private /* synthetic */ zzj.zza zzdle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzl(zzj.zza zza, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.zzdle = zza;
    }

    /* access modifiers changed from: protected */
    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = zzj.this.zzdlb;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            String valueOf = String.valueOf(th);
            Log.e("GAv4", new StringBuilder(String.valueOf(valueOf).length() + 37).append("MeasurementExecutor: job failed with ").append(valueOf).toString());
        }
        super.setException(th);
    }
}
