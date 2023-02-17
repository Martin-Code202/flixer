package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbp;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
/* access modifiers changed from: package-private */
public final class zzccv extends Thread {
    private /* synthetic */ zzccr zzisl;
    private final Object zziso = new Object();
    private final BlockingQueue<FutureTask<?>> zzisp;

    public zzccv(zzccr zzccr, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
        this.zzisl = zzccr;
        zzbp.zzu(str);
        zzbp.zzu(blockingQueue);
        this.zzisp = blockingQueue;
        setName(str);
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzisl.zzaum().zzayg().zzj(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.zzisl.zzish.acquire();
                z = true;
            } catch (InterruptedException e) {
                zza(e);
            }
        }
        while (true) {
            try {
                FutureTask<?> poll = this.zzisp.poll();
                if (poll != null) {
                    poll.run();
                } else {
                    synchronized (this.zziso) {
                        if (this.zzisp.peek() == null && !(this.zzisl.zzisi)) {
                            try {
                                this.zziso.wait(30000);
                            } catch (InterruptedException e2) {
                                zza(e2);
                            }
                        }
                    }
                    synchronized (this.zzisl.zzisg) {
                        if (this.zzisp.peek() == null) {
                        }
                    }
                    synchronized (this.zzisl.zzisg) {
                        this.zzisl.zzish.release();
                        this.zzisl.zzisg.notifyAll();
                        if (this == this.zzisl.zzisa) {
                            this.zzisl.zzisa = null;
                        } else if (this == this.zzisl.zzisb) {
                            this.zzisl.zzisb = null;
                        } else {
                            this.zzisl.zzaum().zzaye().log("Current scheduler thread is neither worker nor network");
                        }
                    }
                    return;
                }
            } catch (Throwable th) {
                synchronized (this.zzisl.zzisg) {
                    this.zzisl.zzish.release();
                    this.zzisl.zzisg.notifyAll();
                    if (this == this.zzisl.zzisa) {
                        this.zzisl.zzisa = null;
                    } else if (this == this.zzisl.zzisb) {
                        this.zzisl.zzisb = null;
                    } else {
                        this.zzisl.zzaum().zzaye().log("Current scheduler thread is neither worker nor network");
                    }
                    throw th;
                }
            }
        }
    }

    public final void zzml() {
        synchronized (this.zziso) {
            this.zziso.notifyAll();
        }
    }
}
