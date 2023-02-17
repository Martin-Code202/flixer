package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbp;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* access modifiers changed from: package-private */
public final class zzccu<V> extends FutureTask<V> implements Comparable<zzccu> {
    private final String zzisk;
    private /* synthetic */ zzccr zzisl;
    private final long zzism = zzccr.zzisj.getAndIncrement();
    private final boolean zzisn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzccu(zzccr zzccr, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzisl = zzccr;
        zzbp.zzu(str);
        this.zzisk = str;
        this.zzisn = false;
        if (this.zzism == Long.MAX_VALUE) {
            zzccr.zzaum().zzaye().log("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzccu(zzccr zzccr, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzisl = zzccr;
        zzbp.zzu(str);
        this.zzisk = str;
        this.zzisn = z;
        if (this.zzism == Long.MAX_VALUE) {
            zzccr.zzaum().zzaye().log("Tasks index overflow");
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzccu zzccu) {
        zzccu zzccu2 = zzccu;
        if (this.zzisn != zzccu2.zzisn) {
            return this.zzisn ? -1 : 1;
        }
        if (this.zzism < zzccu2.zzism) {
            return -1;
        }
        if (this.zzism > zzccu2.zzism) {
            return 1;
        }
        this.zzisl.zzaum().zzayf().zzj("Two tasks share the same index. index", Long.valueOf(this.zzism));
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.zzisl.zzaum().zzaye().zzj(this.zzisk, th);
        if (th instanceof zzccs) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}
