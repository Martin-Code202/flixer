package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
public final class zzccr extends zzcdu {
    private static final AtomicLong zzisj = new AtomicLong(Long.MIN_VALUE);
    private zzccv zzisa;
    private zzccv zzisb;
    private final PriorityBlockingQueue<FutureTask<?>> zzisc = new PriorityBlockingQueue<>();
    private final BlockingQueue<FutureTask<?>> zzisd = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zzise = new zzcct(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzisf = new zzcct(this, "Thread death: Uncaught exception on network thread");
    private final Object zzisg = new Object();
    private final Semaphore zzish = new Semaphore(2);
    private volatile boolean zzisi;

    zzccr(zzccw zzccw) {
        super(zzccw);
    }

    private final void zza(zzccu<?> zzccu) {
        synchronized (this.zzisg) {
            this.zzisc.add(zzccu);
            if (this.zzisa == null) {
                this.zzisa = new zzccv(this, "Measurement Worker", this.zzisc);
                this.zzisa.setUncaughtExceptionHandler(this.zzise);
                this.zzisa.start();
            } else {
                this.zzisa.zzml();
            }
        }
    }

    public static boolean zzaq() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatv() {
        super.zzatv();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatw() {
        super.zzatw();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final void zzatx() {
        if (Thread.currentThread() != this.zzisb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcan zzaty() {
        return super.zzaty();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcau zzatz() {
        return super.zzatz();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcdw zzaua() {
        return super.zzaua();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbr zzaub() {
        return super.zzaub();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbe zzauc() {
        return super.zzauc();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzceo zzaud() {
        return super.zzaud();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcek zzaue() {
        return super.zzaue();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbs zzauf() {
        return super.zzauf();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcay zzaug() {
        return super.zzaug();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbu zzauh() {
        return super.zzauh();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcfw zzaui() {
        return super.zzaui();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzccq zzauj() {
        return super.zzauj();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcfl zzauk() {
        return super.zzauk();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzccr zzaul() {
        return super.zzaul();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbw zzaum() {
        return super.zzaum();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcch zzaun() {
        return super.zzaun();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcax zzauo() {
        return super.zzauo();
    }

    public final boolean zzayt() {
        return Thread.currentThread() == this.zzisa;
    }

    public final <V> Future<V> zzd(Callable<V> callable) {
        zzwk();
        zzbp.zzu(callable);
        zzccu<?> zzccu = new zzccu<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzisa) {
            if (!this.zzisc.isEmpty()) {
                zzaum().zzayg().log("Callable skipped the worker queue.");
            }
            zzccu.run();
        } else {
            zza(zzccu);
        }
        return zzccu;
    }

    public final <V> Future<V> zze(Callable<V> callable) {
        zzwk();
        zzbp.zzu(callable);
        zzccu<?> zzccu = new zzccu<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzisa) {
            zzccu.run();
        } else {
            zza(zzccu);
        }
        return zzccu;
    }

    public final void zzg(Runnable runnable) {
        zzwk();
        zzbp.zzu(runnable);
        zza(new zzccu<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzh(Runnable runnable) {
        zzwk();
        zzbp.zzu(runnable);
        zzccu zzccu = new zzccu(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzisg) {
            this.zzisd.add(zzccu);
            if (this.zzisb == null) {
                this.zzisb = new zzccv(this, "Measurement Network", this.zzisd);
                this.zzisb.setUncaughtExceptionHandler(this.zzisf);
                this.zzisb.start();
            } else {
                this.zzisb.zzml();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final void zzuj() {
        if (Thread.currentThread() != this.zzisa) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzcdu
    public final void zzuk() {
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzd zzvx() {
        return super.zzvx();
    }
}
