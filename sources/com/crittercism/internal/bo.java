package com.crittercism.internal;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.crittercism.internal.cc;
import java.util.Date;
import java.util.concurrent.ExecutorService;
public final class bo extends bn {
    private final ExecutorService b;
    private final av<ar> c;
    private ar d;
    private ap e;
    private boolean f;
    private cd g;
    private Date h;

    public bo(Application application, ExecutorService executorService, av<ar> avVar, ar arVar, ap apVar, boolean z, cd cdVar, Date date) {
        super(application);
        this.b = executorService;
        this.c = avVar;
        this.d = arVar;
        this.f = z;
        this.e = apVar;
        this.g = cdVar;
        this.h = date;
        a();
    }

    @Override // com.crittercism.internal.bn
    public final synchronized void d() {
        a aVar;
        if (!this.f) {
            h();
            if (!(this.g == null || this.h == null)) {
                cd cdVar = this.g;
                Date date = this.h;
                if (date != null && cdVar != null && !cdVar.e) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        aVar = new b("App Load M", cdVar, date);
                    } else {
                        aVar = new c("App Load", cdVar, date);
                    }
                    aVar.a();
                }
                this.g = null;
                this.h = null;
            }
        }
    }

    private void h() {
        final ar arVar = this.d;
        if (arVar != null) {
            this.b.submit(new Runnable() { // from class: com.crittercism.internal.bo.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (((Boolean) bo.this.e.a(ap.u)).booleanValue()) {
                        arVar.m = ((Float) bo.this.e.a(ap.x)).floatValue();
                        bo.this.c.a((av) arVar);
                    }
                }
            });
            this.d = null;
        }
    }

    public static abstract class a implements MessageQueue.IdleHandler {
        private boolean a = false;
        private String b;
        private cd c;
        private Date d;

        public abstract void a();

        public a(String str, cd cdVar, Date date) {
            this.b = str;
            this.c = cdVar;
            this.d = date;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            if (this.a) {
                b();
                return true;
            }
            this.a = true;
            cd cdVar = this.c;
            String str = this.b;
            Date date = this.d;
            Date date2 = new Date();
            long time = date.getTime();
            long time2 = date2.getTime();
            if (time - time2 > 0) {
                cf.b(ce.NegativeLifecycleUserflowTime.a());
            } else {
                cdVar.b.submit(new Runnable(str, time, time2) { // from class: com.crittercism.internal.cd.3
                    final /* synthetic */ String a;
                    final /* synthetic */ long b;
                    final /* synthetic */ long c;

                    {
                        this.a = r2;
                        this.b = r3;
                        this.c = r5;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        cc.a aVar = new cc.a();
                        aVar.a = this.a;
                        aVar.b = this.b;
                        aVar.c = -1;
                        aVar.d = Long.MAX_VALUE;
                        aVar.e = cc.e.c;
                        cc a2 = aVar.a();
                        cd.this.a.put(a2.a, a2);
                        cd.this.a(a2.a, this.c);
                    }
                });
            }
            b();
            return true;
        }

        private void b() {
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    public static class b extends a {
        public b(String str, cd cdVar, Date date) {
            super(str, cdVar, date);
        }

        @Override // com.crittercism.internal.bo.a
        @SuppressLint({"NewApi"})
        public final void a() {
            Looper.getMainLooper().getQueue().addIdleHandler(this);
        }
    }

    public static class c extends a {
        public c(String str, cd cdVar, Date date) {
            super(str, cdVar, date);
        }

        @Override // com.crittercism.internal.bo.a
        public final void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Looper.myQueue().addIdleHandler(this);
            }
        }
    }
}
