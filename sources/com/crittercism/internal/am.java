package com.crittercism.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import com.crittercism.app.CrashData;
import com.crittercism.app.CrittercismCallback;
import com.crittercism.app.CrittercismConfig;
import com.crittercism.app.CrittercismNDK;
import com.crittercism.internal.aq;
import com.crittercism.internal.ar;
import com.crittercism.internal.at;
import com.crittercism.internal.b;
import com.crittercism.internal.ba;
import com.crittercism.internal.bc;
import com.crittercism.internal.cc;
import com.crittercism.internal.d;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONArray;
import org.json.JSONObject;
public final class am {
    private Set<WebView> A = new HashSet();
    private Date B;
    private Date C = new Date();
    Application a;
    av<aq> b;
    av<bc> c;
    av<aq> d;
    av<at> e;
    av<ba> f = null;
    List<bw> g = new LinkedList();
    bw h;
    ScheduledExecutorService i = ch.a("crittercism networking");
    public ScheduledExecutorService j = ch.b("crittercism data");
    ap k;
    protected d l;
    by m;
    cd n;

    /* renamed from: o  reason: collision with root package name */
    public bo f16011o;
    au p;
    private String q = null;
    private av<ar> r;
    private av<b> s;
    private av<cc> t;
    private ak u;
    private bp v;
    private CrittercismConfig w;
    private as x;
    private bq y;
    private br z;

    public am(Application application, String str, CrittercismConfig crittercismConfig) {
        av<ar> avVar;
        av<at> avVar2;
        av<aq> avVar3;
        av<aq> avVar4;
        av<b> avVar5;
        av<bc> avVar6;
        av<cc> avVar7;
        av<ba> avVar8;
        this.q = str;
        this.a = application;
        this.x = new as(str);
        this.w = new CrittercismConfig(crittercismConfig);
        this.u = new ak(this.a, this.w);
        this.m = new by(this.a);
        boolean a2 = a(this.a);
        this.k = new ap(this.a, this.q);
        Application application2 = this.a;
        if (a2) {
            avVar = new bd<>();
        } else {
            avVar = new aw<>(application2, "app_loads_2", new ar.b((byte) 0), 10);
        }
        this.r = avVar;
        Application application3 = this.a;
        if (a2) {
            avVar2 = new az<>(10);
        } else {
            avVar2 = new aw<>(application3, "breadcrumbs", new at.a((byte) 0), 250);
        }
        this.e = avVar2;
        Application application4 = this.a;
        if (a2) {
            avVar3 = new az<>(1);
        } else {
            avVar3 = new aw<>(application4, "exceptions", new aq.a((byte) 0), 5);
        }
        this.b = avVar3;
        Application application5 = this.a;
        if (a2) {
            avVar4 = new az<>(1);
        } else {
            avVar4 = new aw<>(application5, "sdk_crashes", new aq.a((byte) 0), 5);
        }
        this.d = avVar4;
        Application application6 = this.a;
        if (a2) {
            avVar5 = new az<>(5);
        } else {
            avVar5 = new aw<>(application6, "network_statistics", new b.C0002b((byte) 0), 50);
        }
        this.s = avVar5;
        Application application7 = this.a;
        if (a2) {
            avVar6 = new bd<>();
        } else {
            avVar6 = new aw<>(application7, "ndk_crashes", new bc.b((byte) 0), 5);
        }
        this.c = avVar6;
        Application application8 = this.a;
        if (a2) {
            avVar7 = new az<>(5);
        } else {
            avVar7 = new aw<>(application8, "finished_txns", new cc.g((byte) 0), 50);
        }
        this.t = avVar7;
        Application application9 = this.a;
        String str2 = this.q;
        if (a2) {
            avVar8 = new bd<>();
        } else {
            avVar8 = new bb(application9, str2);
        }
        this.f = avVar8;
        List<String> uRLBlacklistPatterns = crittercismConfig.getURLBlacklistPatterns();
        uRLBlacklistPatterns.add(this.x.a.getHost());
        uRLBlacklistPatterns.add(this.x.b.getHost());
        uRLBlacklistPatterns.add(this.x.d.getHost());
        uRLBlacklistPatterns.add(this.x.c.getHost());
        d.a aVar = new d.a();
        aVar.a = this.j;
        aVar.b = uRLBlacklistPatterns;
        aVar.c = crittercismConfig.getPreserveQueryStringPatterns();
        aVar.d = this.s;
        aVar.e = this.e;
        aVar.f = this.k;
        this.l = new d(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, (byte) 0);
        this.n = new cd(this.a, this.j, this.t, this.k);
        this.p = new au(this.u, this.a, new ao(this.a, this.w), this.q);
        this.j.submit(new b(a2));
        try {
            this.B = new Date(bn.f());
        } catch (IOException e2) {
            cf.a(e2);
        }
        if (this.B != null) {
            a(at.a(this.B));
        } else {
            a(at.a(this.C));
        }
        if (this.w.isServiceMonitoringEnabled()) {
            Thread thread = new Thread(new a(this, (byte) 0));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e3) {
                cf.b(e3);
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(new al(Thread.getDefaultUncaughtExceptionHandler()) { // from class: com.crittercism.internal.am.1
            @Override // com.crittercism.internal.al
            public final void a(Throwable th) {
                am amVar = am.this;
                try {
                    amVar.j.submit(new Runnable(th, Thread.currentThread().getId(), new Date(), Thread.getAllStackTraces()) { // from class: com.crittercism.internal.am.3
                        final /* synthetic */ Throwable a;
                        final /* synthetic */ long b;
                        final /* synthetic */ Date c;
                        final /* synthetic */ Map d;

                        {
                            this.a = r2;
                            this.b = r3;
                            this.c = r5;
                            this.d = r6;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            StackTraceElement[] stackTraceElementArr;
                            aq aqVar = new aq(this.a, am.this.p, this.b);
                            aqVar.h = ci.a.a(this.c);
                            Map map = this.d;
                            aqVar.g = new JSONArray();
                            for (Map.Entry entry : map.entrySet()) {
                                HashMap hashMap = new HashMap();
                                Thread thread2 = (Thread) entry.getKey();
                                if (thread2.getId() != aqVar.a) {
                                    hashMap.put("name", thread2.getName());
                                    hashMap.put("id", Long.valueOf(thread2.getId()));
                                    hashMap.put("state", thread2.getState().name());
                                    JSONArray jSONArray = new JSONArray();
                                    for (StackTraceElement stackTraceElement : (StackTraceElement[]) entry.getValue()) {
                                        jSONArray.put(stackTraceElement.toString());
                                    }
                                    hashMap.put("stacktrace", jSONArray);
                                    aqVar.g.put(new JSONObject(hashMap));
                                }
                            }
                            aqVar.a(am.this.e);
                            aqVar.a(am.this.n.a());
                            if (((Boolean) am.this.k.a(ap.e)).booleanValue()) {
                                aqVar.m = ((Float) am.this.k.a(ap.h)).floatValue();
                                am.this.d.a((av<aq>) aqVar);
                            }
                            ca.a(am.this.a, new CrashData(aqVar.d, aqVar.e, this.c));
                        }
                    }).get();
                    bw bwVar = amVar.h;
                    ScheduledFuture scheduledFuture = bwVar.f;
                    if (scheduledFuture != null) {
                        scheduledFuture.get();
                    }
                    Future future = bwVar.g;
                    if (future != null) {
                        future.get();
                    }
                    Future future2 = bwVar.h;
                    if (future2 != null) {
                        future2.get();
                    }
                } catch (InterruptedException e4) {
                    cf.b(e4);
                } catch (ExecutionException e5) {
                    cf.b(e5);
                }
            }
        });
        this.f16011o = new bo(this.a, this.j, this.r, new ar(this.p), this.k, crittercismConfig.delaySendingAppLoad(), this.n, this.B);
        this.v = new bp(this.a, this.j, this.e, this.k);
        this.y = new bq(this.a, this.j, this.e, this.k);
        if (Build.VERSION.SDK_INT >= 14) {
            this.z = new br(this.a, this.p);
        }
        Date date = new Date();
        HashMap hashMap = new HashMap();
        hashMap.put("event", "Initialized Crittercism 5.8.7");
        a(new at(date, at.b.d, new JSONObject(hashMap)));
    }

    class b implements Runnable {
        private boolean b;

        public b(boolean z) {
            this.b = z;
        }

        private void a(av<at> avVar) {
            LinkedList linkedList;
            List<at> b2 = avVar.b();
            if (b2 instanceof LinkedList) {
                linkedList = (LinkedList) b2;
            } else {
                linkedList = new LinkedList(b2);
            }
            Iterator descendingIterator = linkedList.descendingIterator();
            boolean z = false;
            while (descendingIterator.hasNext()) {
                at atVar = (at) descendingIterator.next();
                if (z) {
                    avVar.a(atVar.a);
                } else if (atVar.c == at.b.a) {
                    z = true;
                }
            }
            String[] strArr = {"network_bcs", "previous_bcs", "current_bcs", "system_bcs"};
            for (int i = 0; i < 4; i++) {
                cg.a(aw.a(am.this.a, strArr[i]));
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            CrashData crashData;
            bc a2;
            am.this.k.a(ap.v);
            am.this.m.a();
            cg.a(new File(am.this.a.getFilesDir(), "com.crittercism/pending"));
            SharedPreferences sharedPreferences = am.this.a.getSharedPreferences("com.crittercism.usersettings", 0);
            if (!sharedPreferences.getBoolean("crashedOnLastLoad", false)) {
                crashData = null;
            } else {
                String string = sharedPreferences.getString("crashName", "");
                String string2 = sharedPreferences.getString("crashReason", "");
                long j = sharedPreferences.getLong("crashDate", 0);
                Date date = null;
                if (j != 0) {
                    date = new Date(j);
                }
                crashData = new CrashData(string, string2, date);
            }
            ca.a = crashData;
            ca.a(am.this.a, null);
            cb cbVar = new cb(am.this.a);
            cbVar.b.edit().putInt("sessionIDSetting", cbVar.b.getInt("sessionIDSetting", 0) + 1).commit();
            if (!this.b && (a2 = bc.a(CrittercismNDK.crashDumpDirectory(am.this.a), am.this.e, am.this.p)) != null) {
                if (((Boolean) am.this.k.a(ap.m)).booleanValue()) {
                    a2.f = ((Float) am.this.k.a(ap.p)).floatValue();
                    am.this.c.a((av<bc>) a2);
                }
                ca.a = new CrashData("NDK crash", "", new Date());
            }
            a(am.this.e);
            if (!this.b) {
                try {
                    CrittercismNDK.installNdkLib(am.this.a);
                } catch (Throwable th) {
                    cf.d("Exception installing ndk library: " + th.getClass().getName());
                }
            }
            am.this.a.getSharedPreferences("com.crittercism." + am.this.p.e + ".usermetadata", 0).edit().clear().commit();
            am.this.a(am.this.k);
        }
    }

    private static boolean a(Context context) {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        int i2 = 0;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.uid == myUid) {
                i2++;
            }
        }
        if (i2 <= 1) {
            return false;
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (runningServiceInfo.pid == myPid) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void a(final Throwable th) {
        if (th == null) {
            cf.b("Calling logHandledException with a null java.lang.Throwable. Nothing will be reported to Crittercism");
            return;
        }
        final long id = Thread.currentThread().getId();
        this.j.execute(new Runnable() { // from class: com.crittercism.internal.am.4
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) am.this.k.a(ap.i)).booleanValue()) {
                    aq aqVar = new aq(th, am.this.p, id);
                    if (((Boolean) am.this.k.a(ap.G)).booleanValue()) {
                        String str = aqVar.d;
                        String str2 = aqVar.e;
                        HashMap hashMap = new HashMap();
                        hashMap.put("name", str != null ? str : "");
                        hashMap.put("reason", str2 != null ? str2 : "");
                        am.this.e.a((av<at>) new at(at.b.g, new JSONObject(hashMap)));
                    }
                    aqVar.a(am.this.e);
                    aqVar.m = ((Float) am.this.k.a(ap.l)).floatValue();
                    am.this.b.a((av<aq>) aqVar);
                }
            }
        });
    }

    public final void a(final at atVar) {
        this.j.execute(new Runnable() { // from class: com.crittercism.internal.am.5
            @Override // java.lang.Runnable
            public final void run() {
                am.this.e.a((av<at>) atVar);
            }
        });
    }

    public final void a(ap apVar) {
        bu buVar = new bu();
        if (buVar.a == null) {
            cf.d("unable to initialize reporters");
            return;
        }
        boolean a2 = new bz(this.a).a();
        this.g.add(new bw(this.x, this.j, this.i, buVar, this.b, new aq.b(this.p, "exceptions", "/android_v2/handle_exceptions"), "EXCEPTIONS", apVar, ap.j, ap.k));
        this.h = new bw(this.x, this.j, this.i, buVar, this.d, new aq.b(this.p, "crashes", "/android_v2/handle_crashes"), "CRASHES", apVar, ap.f, ap.g);
        this.g.add(this.h);
        this.g.add(new bw(this.x, this.j, this.i, buVar, this.c, new bc.a(this.p), "NDK", apVar, ap.n, ap.f16012o));
        this.g.add(new bw(this.x, this.j, this.i, buVar, this.f, new ba.a(this.p), "METADATA", apVar, ap.r, ap.s));
        this.g.add(new bw(this.x, this.j, this.i, buVar, this.s, new b.a(this.p), "APM", apVar, ap.b, ap.c));
        bw bwVar = new bw(this.x, this.j, this.i, buVar, this.r, new ar.a(this.p), "APPLOADS", apVar, ap.v, ap.w);
        bwVar.d = new bs(this.x.b, this.a, this.p, apVar, buVar);
        this.g.add(bwVar);
        this.g.add(new bw(this.x, this.j, this.i, buVar, this.t, new cc.f(this.p, this.e), "USERFLOWS", apVar, ap.z, ap.A));
        ConnectivityManager connectivityManager = null;
        if (ao.a(this.a, "android.permission.ACCESS_NETWORK_STATE")) {
            connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        }
        for (bw bwVar2 : this.g) {
            bwVar2.j = connectivityManager;
            if (bwVar2.j != null && Build.VERSION.SDK_INT >= 21) {
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(12);
                if (!bwVar2.i) {
                    builder.addTransportType(1);
                }
                NetworkRequest build = builder.build();
                bwVar2.k = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0201: IPUT  
                      (wrap: com.crittercism.internal.bw$4 : 0x01fc: CONSTRUCTOR  (r0v37 com.crittercism.internal.bw$4) = (r19v3 'bwVar2' com.crittercism.internal.bw) call: com.crittercism.internal.bw.4.<init>(com.crittercism.internal.bw):void type: CONSTRUCTOR)
                      (r19v3 'bwVar2' com.crittercism.internal.bw)
                     com.crittercism.internal.bw.k java.lang.Object in method: com.crittercism.internal.am.a(com.crittercism.internal.ap):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:220)
                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:344)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:297)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:266)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01fc: CONSTRUCTOR  (r0v37 com.crittercism.internal.bw$4) = (r19v3 'bwVar2' com.crittercism.internal.bw) call: com.crittercism.internal.bw.4.<init>(com.crittercism.internal.bw):void type: CONSTRUCTOR in method: com.crittercism.internal.am.a(com.crittercism.internal.ap):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:455)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                    	... 31 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.crittercism.internal.bw, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                    	... 35 more
                    */
                /*
                // Method dump skipped, instructions count: 548
                */
                throw new UnsupportedOperationException("Method not decompiled: com.crittercism.internal.am.a(com.crittercism.internal.ap):void");
            }

            static class c implements Runnable {
                private CrittercismCallback<CrashData> a;
                private CrashData b;

                public c(CrittercismCallback<CrashData> crittercismCallback, CrashData crashData) {
                    this.a = crittercismCallback;
                    this.b = crashData;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.onDataReceived(this.b);
                }
            }

            public final void a(final CrittercismCallback<CrashData> crittercismCallback) {
                this.j.execute(new Runnable() { // from class: com.crittercism.internal.am.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        CrashData crashData = ca.a;
                        if (crashData != null) {
                            crashData = crashData.copy();
                        }
                        am.this.i.execute(new c(crittercismCallback, crashData));
                    }
                });
            }

            class a implements Runnable {
                private a() {
                }

                /* synthetic */ a(am amVar, byte b) {
                    this();
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        c cVar = new c(am.this.a);
                        d dVar = am.this.l;
                        boolean a2 = t.a(dVar, cVar);
                        cf.d("Http network insights installation: " + a2);
                        boolean z = false;
                        if (Build.VERSION.SDK_INT >= 19) {
                            z = m.a(dVar, cVar);
                        } else if (Build.VERSION.SDK_INT >= 14) {
                            z = l.a(dVar, cVar);
                        }
                        cf.d("Https network insights installation: " + z);
                        boolean z2 = false;
                        if (z) {
                            z2 = i.a(dVar, cVar);
                            cf.d("Network insights provider service instrumented: " + z2);
                        }
                        if (a2 || z || z2) {
                            cf.c("installed service monitoring");
                        }
                    } catch (Exception e) {
                        cf.d("Exception in installApm: " + e.getClass().getName());
                        cf.a(e);
                    }
                }
            }

            public final void a(final JSONObject jSONObject) {
                this.j.execute(new Runnable() { // from class: com.crittercism.internal.am.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (((Boolean) am.this.k.a(ap.q)).booleanValue()) {
                            ((bb) am.this.f).a(jSONObject);
                        }
                    }
                });
            }

            public final void a(String str) {
                cd cdVar = this.n;
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (cdVar.a) {
                    cdVar.a.remove(str);
                    if (cdVar.a.size() >= 50) {
                        cf.b("Aborting beginUserflow(" + str + "). Maximum number of userflows exceeded.");
                        return;
                    }
                    long longValue = ((Long) cdVar.d.a(ap.a(str, ((Long) cdVar.d.a(ap.H)).longValue()))).longValue();
                    cc.a aVar = new cc.a();
                    aVar.a = str;
                    aVar.b = currentTimeMillis;
                    aVar.c = -1;
                    aVar.d = longValue;
                    cdVar.a.put(str, aVar.a());
                    cf.d("Added userflow: " + str);
                }
            }
        }
