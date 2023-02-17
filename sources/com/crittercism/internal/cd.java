package com.crittercism.internal;

import android.app.Application;
import com.crittercism.internal.cc;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public final class cd {
    public final HashMap<String, cc> a = new HashMap<>();
    public final ScheduledExecutorService b;
    final av<cc> c;
    public ap d;
    public boolean e = "true".equals(System.getProperty("com.crittercism.appLoadUserflowIsDisabled", "false"));
    private ScheduledFuture f;
    private a g;

    public cd(Application application, ScheduledExecutorService scheduledExecutorService, av<cc> avVar, ap apVar) {
        this.b = scheduledExecutorService;
        this.c = avVar;
        this.d = apVar;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (this.f != null) {
            this.f.cancel(false);
        }
        if (this.f == null || this.f.isDone()) {
            this.f = this.b.scheduleAtFixedRate(new b(this, (byte) 0), 10, 10, timeUnit);
        }
        this.g = new a(application);
    }

    public final void a(String str, long j) {
        synchronized (this.a) {
            final cc remove = this.a.remove(str);
            if (remove == null) {
                cf.b("endUserflow(" + str + "): no such userflow");
                return;
            }
            remove.a(cc.d.c, j);
            this.b.submit(new Runnable() { // from class: com.crittercism.internal.cd.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (((Boolean) cd.this.d.a(ap.y)).booleanValue()) {
                        remove.j = ((Float) cd.this.d.a(ap.B)).floatValue();
                        cd.this.c.a((av<cc>) remove);
                    }
                }
            });
        }
    }

    public final Collection<cc> a() {
        LinkedList linkedList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.a) {
            linkedList = new LinkedList(this.a.values());
            this.a.clear();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((cc) it.next()).a(cc.d.g, currentTimeMillis);
            }
        }
        return linkedList;
    }

    class a extends bn {
        public a(Application application) {
            super(application);
            a();
        }

        @Override // com.crittercism.internal.bn
        public final void b() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (cd.this.a) {
                for (cc ccVar : cd.this.a.values()) {
                    if (ccVar.f == cc.d.b && currentTimeMillis >= ccVar.d) {
                        ccVar.i.add(new cc.b(cc.c.b, currentTimeMillis));
                    }
                }
            }
        }

        @Override // com.crittercism.internal.bn
        public final void c() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (cd.this.a) {
                for (cc ccVar : cd.this.a.values()) {
                    if (ccVar.f == cc.d.b && currentTimeMillis >= ccVar.d) {
                        ccVar.i.add(new cc.b(cc.c.a, currentTimeMillis));
                    }
                }
            }
        }
    }

    class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(cd cdVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            HashMap hashMap = new HashMap();
            synchronized (cd.this.a) {
                for (Map.Entry<String, cc> entry : cd.this.a.entrySet()) {
                    String key = entry.getKey();
                    cc value = entry.getValue();
                    if (value.a() >= value.b) {
                        hashMap.put(key, value);
                    }
                }
                for (Map.Entry entry2 : hashMap.entrySet()) {
                    String str = (String) entry2.getKey();
                    cc ccVar = (cc) entry2.getValue();
                    cd.this.a.remove(str);
                    ccVar.a(cc.d.f, System.currentTimeMillis());
                    if (((Boolean) cd.this.d.a(ap.y)).booleanValue()) {
                        ccVar.j = ((Float) cd.this.d.a(ap.B)).floatValue();
                        cd.this.c.a((av<cc>) ccVar);
                    }
                }
            }
        }
    }
}
