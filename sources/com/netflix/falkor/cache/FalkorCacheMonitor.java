package com.netflix.falkor.cache;

import android.content.Context;
import android.content.Intent;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import o.AbstractC0390;
import o.AbstractC0457;
import o.AbstractC1326Az;
import o.C1145;
import o.C1147;
import o.C1202;
import o.C1276;
import o.C1283;
import org.json.JSONException;
import org.json.JSONObject;
public final class FalkorCacheMonitor {

    /* renamed from: ʻ  reason: contains not printable characters */
    final AtomicLong f548 = new AtomicLong(0);

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final Runnable f549 = new Runnable() { // from class: com.netflix.falkor.cache.FalkorCacheMonitor.1
        @Override // java.lang.Runnable
        public void run() {
            FalkorCacheMonitor.this.m198(FalkorCacheMonitor.this.f559);
            FalkorCacheMonitor.this.f559.clear();
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    final AtomicLong f550 = new AtomicLong(0);

    /* renamed from: ʽ  reason: contains not printable characters */
    final AtomicLong f551 = new AtomicLong(0);

    /* renamed from: ˊ  reason: contains not printable characters */
    final AtomicInteger f552 = new AtomicInteger(0);

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private AbstractC1326Az f553;

    /* renamed from: ˋ  reason: contains not printable characters */
    final AtomicLong f554 = new AtomicLong(0);

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f555 = false;

    /* renamed from: ˎ  reason: contains not printable characters */
    final AtomicInteger f556 = new AtomicInteger(0);

    /* renamed from: ˏ  reason: contains not printable characters */
    final AtomicInteger f557 = new AtomicInteger(0);

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final List<If> f558 = new ArrayList();

    /* renamed from: ͺ  reason: contains not printable characters */
    private final List<DataUpdated> f559 = new ArrayList();

    /* renamed from: ॱ  reason: contains not printable characters */
    final AtomicInteger f560 = new AtomicInteger(0);

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Context f561;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final Consumer<Throwable> f562 = new Consumer<Throwable>() { // from class: com.netflix.falkor.cache.FalkorCacheMonitor.2
        /* renamed from: ˏ  reason: contains not printable characters */
        public void accept(Throwable th) {
            C1276.m16820().mo5729("FalkorCacheMonitor", th);
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    final AtomicLong f563 = new AtomicLong(0);

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final Action f564 = new Action() { // from class: com.netflix.falkor.cache.FalkorCacheMonitor.4
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
            r6 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
            if (r2 != null) goto L_0x003e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
            if (r4 != null) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
            r4.addSuppressed(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
            throw r6;
         */
        @Override // io.reactivex.functions.Action
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                io.realm.Realm r2 = com.netflix.falkor.cache.FalkorCache.C0004.m186()
                r3 = 0
                java.io.File r0 = new java.io.File     // Catch:{ Throwable -> 0x0038 }
                io.realm.RealmConfiguration r1 = r2.getConfiguration()     // Catch:{ Throwable -> 0x0038 }
                java.lang.String r1 = r1.getPath()     // Catch:{ Throwable -> 0x0038 }
                r0.<init>(r1)     // Catch:{ Throwable -> 0x0038 }
                long r4 = r0.length()     // Catch:{ Throwable -> 0x0038 }
                com.netflix.falkor.cache.FalkorCacheMonitor r0 = com.netflix.falkor.cache.FalkorCacheMonitor.this     // Catch:{ Throwable -> 0x0038 }
                java.util.concurrent.atomic.AtomicLong r0 = r0.f551     // Catch:{ Throwable -> 0x0038 }
                long r0 = r0.get()     // Catch:{ Throwable -> 0x0038 }
                int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r0 == 0) goto L_0x0031
                com.netflix.falkor.cache.FalkorCacheMonitor r0 = com.netflix.falkor.cache.FalkorCacheMonitor.this     // Catch:{ Throwable -> 0x0038 }
                java.util.concurrent.atomic.AtomicLong r0 = r0.f551     // Catch:{ Throwable -> 0x0038 }
                r0.set(r4)     // Catch:{ Throwable -> 0x0038 }
                com.netflix.falkor.cache.FalkorCacheMonitor$4$2 r0 = new com.netflix.falkor.cache.FalkorCacheMonitor$4$2     // Catch:{ Throwable -> 0x0038 }
                r0.<init>()     // Catch:{ Throwable -> 0x0038 }
                o.C1348Bu.If.m4098(r0)     // Catch:{ Throwable -> 0x0038 }
            L_0x0031:
                if (r2 == 0) goto L_0x004d
                r2.close()
                goto L_0x004d
            L_0x0038:
                r4 = move-exception
                r3 = r4
                throw r4     // Catch:{ all -> 0x003b }
            L_0x003b:
                r6 = move-exception
                if (r2 == 0) goto L_0x004c
                if (r3 == 0) goto L_0x0049
                r2.close()     // Catch:{ Throwable -> 0x0044 }
                goto L_0x004c
            L_0x0044:
                r7 = move-exception
                r3.addSuppressed(r7)
                goto L_0x004c
            L_0x0049:
                r2.close()
            L_0x004c:
                throw r6
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.netflix.falkor.cache.FalkorCacheMonitor.AnonymousClass4.run():void");
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    final AtomicLong f565 = new AtomicLong(0);

    /* access modifiers changed from: package-private */
    public enum DataUpdated {
        FileSize,
        Hit,
        Miss,
        Add,
        Delete,
        CountLruBased,
        CountTimeBased,
        CountLolomo,
        All
    }

    /* access modifiers changed from: package-private */
    public interface If {
        /* renamed from: ˊ  reason: contains not printable characters */
        void m214(List<DataUpdated> list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m205(Context context, AbstractC0457 r4, AbstractC1326Az az) {
        if (this.f555) {
            throw new IllegalStateException("FalkorCacheMonitor already initialized");
        }
        this.f555 = true;
        this.f561 = context.getApplicationContext();
        m194();
        this.f553 = az;
        m193(DataUpdated.All);
        r4.mo14206(new AbstractC0390() { // from class: com.netflix.falkor.cache.FalkorCacheMonitor.3
            @Override // o.AbstractC0390
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo211(AbstractC0457 r1, Intent intent) {
            }

            @Override // o.AbstractC0390
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo213(AbstractC0457 r5) {
                FalkorCacheMonitor.this.m206("state", 0, (JSONObject) null);
            }

            @Override // o.AbstractC0390
            /* renamed from: ˋ  reason: contains not printable characters */
            public void mo209(AbstractC0457 r1) {
            }

            @Override // o.AbstractC0390
            /* renamed from: ˏ  reason: contains not printable characters */
            public void mo212(AbstractC0457 r1) {
            }

            @Override // o.AbstractC0390
            /* renamed from: ˊ  reason: contains not printable characters */
            public void mo208(AbstractC0457 r1) {
            }

            @Override // o.AbstractC0390
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo210(AbstractC0457 r1) {
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m194() {
        Completable.complete().delay(5000, TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribe(this.f564, this.f562);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m204(String str) {
        this.f552.incrementAndGet();
        if (str != null) {
            this.f554.addAndGet((long) str.getBytes().length);
        }
        m193(DataUpdated.Hit);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m200() {
        this.f557.incrementAndGet();
        m193(DataUpdated.Miss);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m201(String str) {
        this.f556.incrementAndGet();
        if (str != null) {
            this.f565.addAndGet((long) str.getBytes().length);
        }
        m193(DataUpdated.Add);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m203(int i) {
        this.f560.addAndGet(i);
        m193(DataUpdated.Delete);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
        if (r6 != null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        if (r8 != null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        r8.addSuppressed(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006e, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
        throw r9;
     */
    /* renamed from: ॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m206(java.lang.String r12, int r13, org.json.JSONObject r14) {
        /*
            r11 = this;
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.String r0 = "FalkorCache.Monitor"
            java.lang.String r1 = "logCacheAction %s %dms"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
            r4 = 1
            r2[r4] = r3
            o.C1283.m16851(r0, r1, r2)
            java.lang.String r0 = "action"
            r5.put(r0, r12)     // Catch:{ JSONException -> 0x0073 }
            java.lang.String r0 = "added"
            java.util.concurrent.atomic.AtomicInteger r1 = r11.f556     // Catch:{ JSONException -> 0x0073 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0073 }
            java.lang.String r0 = "deleted"
            java.util.concurrent.atomic.AtomicInteger r1 = r11.f560     // Catch:{ JSONException -> 0x0073 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0073 }
            java.lang.String r0 = "hits"
            java.util.concurrent.atomic.AtomicInteger r1 = r11.f552     // Catch:{ JSONException -> 0x0073 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0073 }
            java.lang.String r0 = "misses"
            java.util.concurrent.atomic.AtomicInteger r1 = r11.f557     // Catch:{ JSONException -> 0x0073 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0073 }
            if (r13 <= 0) goto L_0x0041
            java.lang.String r0 = "duration"
            r5.put(r0, r13)     // Catch:{ JSONException -> 0x0073 }
        L_0x0041:
            if (r14 == 0) goto L_0x0048
            java.lang.String r0 = "prevSizes"
            r5.put(r0, r14)     // Catch:{ JSONException -> 0x0073 }
        L_0x0048:
            io.realm.Realm r6 = com.netflix.falkor.cache.FalkorCache.C0004.m186()     // Catch:{ JSONException -> 0x0073 }
            r7 = 0
            java.lang.String r0 = "sizes"
            org.json.JSONObject r1 = m196(r6)     // Catch:{ Throwable -> 0x005d }
            r5.put(r0, r1)     // Catch:{ Throwable -> 0x005d }
            if (r6 == 0) goto L_0x0072
            r6.close()
            goto L_0x0072
        L_0x005d:
            r8 = move-exception
            r7 = r8
            throw r8     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r9 = move-exception
            if (r6 == 0) goto L_0x0071
            if (r7 == 0) goto L_0x006e
            r6.close()     // Catch:{ Throwable -> 0x0069 }
            goto L_0x0071
        L_0x0069:
            r10 = move-exception
            r7.addSuppressed(r10)
            goto L_0x0071
        L_0x006e:
            r6.close()
        L_0x0071:
            throw r9
        L_0x0072:
            goto L_0x0081
        L_0x0073:
            r6 = move-exception
            java.lang.String r0 = "FalkorCache.Monitor"
            java.lang.String r1 = "logCacheAction had exception %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r6
            o.C1283.m16851(r0, r1, r2)
        L_0x0081:
            o.Az r0 = r11.f553
            android.content.Context r1 = r11.f561
            java.lang.String r2 = "FalkorCache"
            r0.mo262(r1, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netflix.falkor.cache.FalkorCacheMonitor.m206(java.lang.String, int, org.json.JSONObject):void");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static JSONObject m196(Realm realm) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("homeTable", realm.where(C1145.class).count());
            jSONObject.put("byTimeTable", realm.where(C1202.class).count());
            jSONObject.put("byLruTable", realm.where(C1147.class).count());
        } catch (JSONException e) {
            C1283.m16851("FalkorCache.Monitor", "getRealmTableCounts had exception %s", e);
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m193(DataUpdated dataUpdated) {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r2 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (r4 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        r4.addSuppressed(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007a, code lost:
        throw r6;
     */
    /* renamed from: ˏ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m198(java.util.List<com.netflix.falkor.cache.FalkorCacheMonitor.DataUpdated> r9) {
        /*
            r8 = this;
            io.realm.Realm r2 = com.netflix.falkor.cache.FalkorCache.C0004.m186()
            r3 = 0
            java.lang.Class<o.ﮣ> r0 = o.C1147.class
            io.realm.RealmQuery r0 = r2.where(r0)     // Catch:{ Throwable -> 0x0066 }
            long r4 = r0.count()     // Catch:{ Throwable -> 0x0066 }
            java.util.concurrent.atomic.AtomicLong r0 = r8.f548     // Catch:{ Throwable -> 0x0066 }
            long r0 = r0.get()     // Catch:{ Throwable -> 0x0066 }
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0023
            com.netflix.falkor.cache.FalkorCacheMonitor$DataUpdated r0 = com.netflix.falkor.cache.FalkorCacheMonitor.DataUpdated.CountLruBased     // Catch:{ Throwable -> 0x0066 }
            r9.add(r0)     // Catch:{ Throwable -> 0x0066 }
            java.util.concurrent.atomic.AtomicLong r0 = r8.f548     // Catch:{ Throwable -> 0x0066 }
            r0.set(r4)     // Catch:{ Throwable -> 0x0066 }
        L_0x0023:
            java.lang.Class<o.ﺰ> r0 = o.C1202.class
            io.realm.RealmQuery r0 = r2.where(r0)     // Catch:{ Throwable -> 0x0066 }
            long r4 = r0.count()     // Catch:{ Throwable -> 0x0066 }
            java.util.concurrent.atomic.AtomicLong r0 = r8.f550     // Catch:{ Throwable -> 0x0066 }
            long r0 = r0.get()     // Catch:{ Throwable -> 0x0066 }
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0041
            com.netflix.falkor.cache.FalkorCacheMonitor$DataUpdated r0 = com.netflix.falkor.cache.FalkorCacheMonitor.DataUpdated.CountTimeBased     // Catch:{ Throwable -> 0x0066 }
            r9.add(r0)     // Catch:{ Throwable -> 0x0066 }
            java.util.concurrent.atomic.AtomicLong r0 = r8.f550     // Catch:{ Throwable -> 0x0066 }
            r0.set(r4)     // Catch:{ Throwable -> 0x0066 }
        L_0x0041:
            java.lang.Class<o.ﮞ> r0 = o.C1145.class
            io.realm.RealmQuery r0 = r2.where(r0)     // Catch:{ Throwable -> 0x0066 }
            long r4 = r0.count()     // Catch:{ Throwable -> 0x0066 }
            java.util.concurrent.atomic.AtomicLong r0 = r8.f563     // Catch:{ Throwable -> 0x0066 }
            long r0 = r0.get()     // Catch:{ Throwable -> 0x0066 }
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x005f
            com.netflix.falkor.cache.FalkorCacheMonitor$DataUpdated r0 = com.netflix.falkor.cache.FalkorCacheMonitor.DataUpdated.CountLolomo     // Catch:{ Throwable -> 0x0066 }
            r9.add(r0)     // Catch:{ Throwable -> 0x0066 }
            java.util.concurrent.atomic.AtomicLong r0 = r8.f563     // Catch:{ Throwable -> 0x0066 }
            r0.set(r4)     // Catch:{ Throwable -> 0x0066 }
        L_0x005f:
            if (r2 == 0) goto L_0x007b
            r2.close()
            goto L_0x007b
        L_0x0066:
            r4 = move-exception
            r3 = r4
            throw r4     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r6 = move-exception
            if (r2 == 0) goto L_0x007a
            if (r3 == 0) goto L_0x0077
            r2.close()     // Catch:{ Throwable -> 0x0072 }
            goto L_0x007a
        L_0x0072:
            r7 = move-exception
            r3.addSuppressed(r7)
            goto L_0x007a
        L_0x0077:
            r2.close()
        L_0x007a:
            throw r6
        L_0x007b:
            r2 = 0
        L_0x007c:
            java.util.List<com.netflix.falkor.cache.FalkorCacheMonitor$If> r0 = r8.f558
            int r0 = r0.size()
            if (r2 >= r0) goto L_0x0092
            java.util.List<com.netflix.falkor.cache.FalkorCacheMonitor$If> r0 = r8.f558
            java.lang.Object r0 = r0.get(r2)
            com.netflix.falkor.cache.FalkorCacheMonitor$If r0 = (com.netflix.falkor.cache.FalkorCacheMonitor.If) r0
            r0.m214(r9)
            int r2 = r2 + 1
            goto L_0x007c
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netflix.falkor.cache.FalkorCacheMonitor.m198(java.util.List):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m202() {
        this.f552.set(0);
        this.f557.set(0);
        this.f556.set(0);
        this.f560.set(0);
        this.f554.set(0);
        this.f565.set(0);
        this.f548.set(0);
        this.f550.set(0);
        this.f563.set(0);
        m193(DataUpdated.All);
    }
}
