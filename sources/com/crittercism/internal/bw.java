package com.crittercism.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.crittercism.internal.ap;
import com.crittercism.internal.av;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public final class bw implements av.a {
    final ScheduledExecutorService a;
    final bu b;
    av c;
    public a d;
    volatile boolean e = false;
    public volatile ScheduledFuture f;
    public volatile Future g;
    public volatile Future h;
    public boolean i = true;
    public ConnectivityManager j;
    public Object k;
    private as l;
    private final ExecutorService m;
    private bx n;

    /* renamed from: o  reason: collision with root package name */
    private long f16016o;
    private boolean p = false;
    private boolean q = true;
    private long r = 0;
    private String s;

    public interface a {
        void a(bv bvVar);
    }

    public bw(as asVar, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, bu buVar, av avVar, bx bxVar, String str, ap apVar, ap.a aVar, ap.d dVar) {
        this.l = asVar;
        this.a = scheduledExecutorService;
        this.m = executorService;
        this.b = buVar;
        this.c = avVar;
        this.n = bxVar;
        this.c.a(this);
        this.f16016o = ((Long) apVar.a(dVar)).longValue();
        this.p = ((Boolean) apVar.a(aVar)).booleanValue();
        this.s = str;
        apVar.I.add(new b(aVar, dVar));
    }

    @Override // com.crittercism.internal.av.a
    public final void a() {
        this.e = true;
        b();
    }

    public final synchronized Future b() {
        boolean z = !a(this.f);
        boolean z2 = !a(this.g);
        if (!this.p || this.q || z || z2) {
            return null;
        }
        try {
            this.f = this.a.schedule(new Runnable() { // from class: com.crittercism.internal.bw.1
                @Override // java.lang.Runnable
                public final void run() {
                    bw.this.c();
                    bw.this.f = null;
                }
            }, d(), TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            cf.a("Unable to schedule sending data", e2);
        }
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void c() {
        boolean z;
        this.r = System.currentTimeMillis();
        if (!this.q) {
            if (this.j == null) {
                z = true;
            } else {
                NetworkInfo activeNetworkInfo = this.j.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    int type = activeNetworkInfo.getType();
                    if (activeNetworkInfo.isConnected() && (this.i || type == 1)) {
                        z = true;
                    }
                }
                z = false;
            }
            if (z) {
                final List<? extends bf> c2 = this.c.c();
                this.e = false;
                if (c2.size() != 0) {
                    try {
                        final bt a2 = this.n.a(this.l, c2);
                        this.g = this.m.submit(new Runnable() { // from class: com.crittercism.internal.bw.2
                            /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
                                if ((r3.a >= 500 || (r3.c instanceof java.net.SocketTimeoutException)) == false) goto L_0x002e;
                             */
                            @Override // java.lang.Runnable
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void run() {
                                /*
                                    r6 = this;
                                    com.crittercism.internal.bw r0 = com.crittercism.internal.bw.this
                                    com.crittercism.internal.bu r0 = r0.b
                                    com.crittercism.internal.bt r1 = r3
                                    com.crittercism.internal.bv r3 = r0.a(r1)
                                    r2 = r3
                                    int r0 = r3.a
                                    r1 = 200(0xc8, float:2.8E-43)
                                    if (r0 < r1) goto L_0x0019
                                    int r0 = r3.a
                                    r1 = 300(0x12c, float:4.2E-43)
                                    if (r0 >= r1) goto L_0x0019
                                    r0 = 1
                                    goto L_0x001a
                                L_0x0019:
                                    r0 = 0
                                L_0x001a:
                                    if (r0 != 0) goto L_0x002e
                                    r3 = r2
                                    int r0 = r2.a
                                    r1 = 500(0x1f4, float:7.0E-43)
                                    if (r0 >= r1) goto L_0x0029
                                    java.lang.Exception r0 = r3.c
                                    boolean r0 = r0 instanceof java.net.SocketTimeoutException
                                    if (r0 == 0) goto L_0x002b
                                L_0x0029:
                                    r0 = 1
                                    goto L_0x002c
                                L_0x002b:
                                    r0 = 0
                                L_0x002c:
                                    if (r0 != 0) goto L_0x003f
                                L_0x002e:
                                    com.crittercism.internal.bw r4 = com.crittercism.internal.bw.this
                                    java.util.List r5 = r2
                                    java.util.concurrent.ScheduledExecutorService r0 = r4.a
                                    com.crittercism.internal.bw$3 r1 = new com.crittercism.internal.bw$3
                                    r1.<init>(r5)
                                    java.util.concurrent.Future r0 = r0.submit(r1)
                                    r4.h = r0
                                L_0x003f:
                                    com.crittercism.internal.bw r0 = com.crittercism.internal.bw.this
                                    com.crittercism.internal.bw$a r0 = r0.d
                                    if (r0 == 0) goto L_0x004c
                                    com.crittercism.internal.bw r0 = com.crittercism.internal.bw.this
                                    com.crittercism.internal.bw$a r0 = r0.d
                                    r0.a(r2)
                                L_0x004c:
                                    com.crittercism.internal.bw r0 = com.crittercism.internal.bw.this
                                    r1 = 0
                                    r0.g = r1
                                    com.crittercism.internal.bw r0 = com.crittercism.internal.bw.this
                                    boolean r0 = r0.e
                                    if (r0 == 0) goto L_0x005c
                                    com.crittercism.internal.bw r0 = com.crittercism.internal.bw.this
                                    r0.b()
                                L_0x005c:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.crittercism.internal.bw.AnonymousClass2.run():void");
                            }
                        });
                    } catch (IOException unused) {
                        for (bf bfVar : c2) {
                            this.c.a(bfVar.f());
                        }
                    }
                }
            }
        }
    }

    public final synchronized void a(long j2, TimeUnit timeUnit) {
        this.f16016o = timeUnit.toMillis(j2);
    }

    public final synchronized void a(boolean z) {
        if (this.q != z) {
            this.q = z;
            if (!this.q) {
                this.r = System.currentTimeMillis();
                b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(boolean z) {
        if (this.p != z) {
            this.p = z;
            if (this.p) {
                b();
            }
        }
    }

    private synchronized long d() {
        long j2;
        j2 = this.f16016o;
        long currentTimeMillis = System.currentTimeMillis() - this.r;
        if (currentTimeMillis > 0) {
            long j3 = j2 - currentTimeMillis;
            j2 = j3;
            if (j3 < 0) {
                j2 = 0;
            }
        }
        return j2;
    }

    private static boolean a(Future future) {
        return future == null || future.isDone();
    }

    class b implements ap.c {
        private ap.a b;
        private ap.d c;

        public b(ap.a aVar, ap.d dVar) {
            this.b = aVar;
            this.c = dVar;
        }

        @Override // com.crittercism.internal.ap.c
        public final void a(ap apVar, String str) {
            if (this.b.a().equals(str)) {
                bw.this.b(((Boolean) apVar.a(this.b)).booleanValue());
            } else if (this.c.a().equals(str)) {
                bw.this.a(((Long) apVar.a(this.c)).longValue(), TimeUnit.MILLISECONDS);
            }
        }
    }

    public final String toString() {
        return this.s;
    }
}
