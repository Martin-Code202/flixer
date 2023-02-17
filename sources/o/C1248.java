package o;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.netflix.falkor.cache.FalkorCache;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import io.realm.Realm;
import io.realm.RealmModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* renamed from: o.ｯ  reason: contains not printable characters */
public class C1248 implements AbstractC1096 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final long f15794 = TimeUnit.DAYS.toMillis(90);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Realm f15795;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final long f15796;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1261 f15797;

    protected C1248(Realm realm, AbstractC1261 r2, long j) {
        this.f15795 = realm;
        this.f15797 = r2;
        this.f15796 = j;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static AbstractC1096 m16614(AbstractC1261 r2, long j) {
        return new C1248(FalkorCache.C0004.m186(), r2, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public final Realm m16619() {
        return this.f15795;
    }

    @Override // o.AbstractC1096, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        FalkorCache.C0004.m184(this.f15795);
    }

    @Override // o.AbstractC1096
    /* renamed from: ˊ */
    public void mo16192() {
        FalkorCache.C0004.m189(this.f15795);
    }

    @Override // o.AbstractC1096
    /* renamed from: ˏ */
    public void mo16197() {
        FalkorCache.C0004.m185(this.f15795);
    }

    @Override // o.AbstractC1096
    /* renamed from: ˎ */
    public void mo16195() {
        FalkorCache.C0004.m187(this.f15795);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ｯ$If */
    public static class If implements Realm.Transaction {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final Class f15807;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Date f15808;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final ArrayList<String> f15809;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final JsonElement f15810;

        private If(Class<? extends RealmModel> cls, ArrayList<String> arrayList, JsonElement jsonElement, Date date, long j) {
            this.f15807 = cls;
            this.f15809 = arrayList;
            this.f15810 = jsonElement;
            if (date == null) {
                this.f15808 = C1248.m16617(jsonElement, cls, j);
            } else {
                this.f15808 = date;
            }
        }

        @Override // io.realm.Realm.Transaction
        public void execute(Realm realm) {
            try {
                boolean z = this.f15810.isJsonObject() && this.f15810.getAsJsonObject().has("_sentinel");
                FalkorCache.If r3 = (FalkorCache.If) this.f15807.newInstance();
                r3.setPath(this.f15809.toString());
                r3.setPayload(this.f15810.toString());
                r3.setSentinel(z);
                r3.setLastModifiedTime(System.currentTimeMillis());
                if (this.f15808 != null) {
                    r3.setExpiry(this.f15808);
                }
                realm.copyToRealmOrUpdate(r3);
                if (r3 instanceof FalkorCache.Cif) {
                    FalkorCache.LruBackup.m169((FalkorCache.Cif) r3);
                }
                FalkorCache.m165().m201(r3.getPayload());
            } catch (IllegalArgumentException e) {
                C1276.m16820().mo5729("SPY-12279: Exception for path: " + this.f15809.toString(), e);
                throw e;
            } catch (IllegalAccessException | InstantiationException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // o.AbstractC1096
    /* renamed from: ॱ */
    public void mo16198(ArrayList<String> arrayList, JsonElement jsonElement) {
        mo16196(arrayList, jsonElement, null);
    }

    @Override // o.AbstractC1096
    /* renamed from: ˎ */
    public void mo16196(ArrayList<String> arrayList, final JsonElement jsonElement, final Date date) {
        C1348Bu.m4094();
        try {
            Class<? extends RealmModel> r9 = this.f15797.mo16141(arrayList.get(0), m16618());
            if (r9 == null) {
                return;
            }
            if (r9 == C1145.class) {
                final String jsonElement2 = jsonElement.toString();
                FalkorCache.C0004.m190(this.f15795, new Realm.Transaction() { // from class: o.ｯ.5
                    @Override // io.realm.Realm.Transaction
                    public void execute(Realm realm) {
                        C1145 r5 = (C1145) C1248.this.f15795.where(C1145.class).findFirst();
                        if (r5 == null) {
                            r5 = (C1145) realm.createObject(C1145.class);
                        } else {
                            C1283.m16863("FalkorCache.RealmHelper", "Overwriting non-expired lolomo %s (expire=%s)", r5.getLolomosRef(), r5.getExpiry().toString());
                        }
                        r5.setLolomosRef(jsonElement2);
                        if (date == null) {
                            r5.setExpiry(C1248.m16617(jsonElement, C1145.class, C1248.this.f15796));
                        } else {
                            r5.setExpiry(date);
                        }
                    }
                });
                FalkorCache.m165().m201(jsonElement2);
                return;
            }
            FalkorCache.C0004.m190(this.f15795, new If(r9, arrayList, jsonElement, date, this.f15796));
        } catch (IllegalArgumentException | IllegalStateException e) {
            C1276.m16820().mo5729("addToCache", e);
        }
    }

    @Override // o.AbstractC1096
    /* renamed from: ˋ */
    public Object mo16193(List<Object> list, int i, String str, AbstractC0730 r18) {
        C1049 r7 = null;
        if (list.isEmpty() || str.isEmpty()) {
            return null;
        }
        try {
            String str2 = (String) list.get(0);
            Class<? extends RealmModel> r9 = this.f15797.mo16141(str2, m16618());
            if (r9 == null) {
                return null;
            }
            if (r9 != C1145.class) {
                return m16613(list, i, str, r18, r9, true);
            }
            C1145 r11 = (C1145) this.f15795.where(C1145.class).greaterThan("expiry", new Date()).findFirst();
            if (r11 != null) {
                C1049 r13 = new C1049(C0859.m15527(((JsonElement) ((Gson) C1281.m16832(Gson.class)).fromJson(r11.getLolomosRef(), (Class<Object>) JsonElement.class)).getAsJsonArray()));
                r18.set(str2, r13);
                r7 = r13;
                FalkorCache.m165().m204(r11.getLolomosRef());
            } else {
                FalkorCache.m165().m200();
            }
            return r7;
        } catch (JsonSyntaxException | IllegalArgumentException | IllegalStateException e) {
            C1276.m16820().mo5729("retrieveFromCache", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if (r4 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (r6 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        r6.addSuppressed(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        throw r9;
     */
    @Override // o.AbstractC1096
    /* renamed from: ˋ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo16194() {
        /*
            r11 = this;
            io.realm.Realm r4 = com.netflix.falkor.cache.FalkorCache.C0004.m186()     // Catch:{ Exception -> 0x0044 }
            r5 = 0
            com.netflix.falkor.cache.FalkorCache.m165()     // Catch:{ Throwable -> 0x002e }
            org.json.JSONObject r6 = com.netflix.falkor.cache.FalkorCacheMonitor.m196(r4)     // Catch:{ Throwable -> 0x002e }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x002e }
            o.ｯ$3 r0 = new o.ｯ$3     // Catch:{ Throwable -> 0x002e }
            r0.<init>()     // Catch:{ Throwable -> 0x002e }
            com.netflix.falkor.cache.FalkorCache.C0004.m190(r4, r0)     // Catch:{ Throwable -> 0x002e }
            com.netflix.falkor.cache.FalkorCacheMonitor r0 = com.netflix.falkor.cache.FalkorCache.m165()     // Catch:{ Throwable -> 0x002e }
            java.lang.String r1 = "trim"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x002e }
            long r2 = r2 - r7
            int r2 = (int) r2     // Catch:{ Throwable -> 0x002e }
            r0.m206(r1, r2, r6)     // Catch:{ Throwable -> 0x002e }
            if (r4 == 0) goto L_0x0043
            r4.close()
            goto L_0x0043
        L_0x002e:
            r6 = move-exception
            r5 = r6
            throw r6     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r9 = move-exception
            if (r4 == 0) goto L_0x0042
            if (r5 == 0) goto L_0x003f
            r4.close()     // Catch:{ Throwable -> 0x003a }
            goto L_0x0042
        L_0x003a:
            r10 = move-exception
            r5.addSuppressed(r10)
            goto L_0x0042
        L_0x003f:
            r4.close()
        L_0x0042:
            throw r9
        L_0x0043:
            goto L_0x004e
        L_0x0044:
            r4 = move-exception
            o.ｕ r0 = o.C1276.m16820()
            java.lang.String r1 = "expireLolomoListsFromCache"
            r0.mo5729(r1, r4)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1248.mo16194():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        if (r4 != null) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        if (r6 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r6.addSuppressed(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        throw r10;
     */
    @Override // o.AbstractC1096
    /* renamed from: ॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo16199(final java.util.List<java.lang.Object> r13) {
        /*
            r12 = this;
            io.realm.Realm r4 = com.netflix.falkor.cache.FalkorCache.C0004.m186()     // Catch:{ Exception -> 0x0064 }
            r5 = 0
            o.ｿ r0 = r12.f15797     // Catch:{ Throwable -> 0x004e }
            r1 = 0
            java.lang.Object r1 = r13.get(r1)     // Catch:{ Throwable -> 0x004e }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Throwable -> 0x004e }
            boolean r2 = r12.m16618()     // Catch:{ Throwable -> 0x004e }
            java.lang.Class r6 = r0.mo16141(r1, r2)     // Catch:{ Throwable -> 0x004e }
            if (r6 == 0) goto L_0x0047
            com.netflix.falkor.cache.FalkorCache.m165()     // Catch:{ Throwable -> 0x004e }
            org.json.JSONObject r7 = com.netflix.falkor.cache.FalkorCacheMonitor.m196(r4)     // Catch:{ Throwable -> 0x004e }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x004e }
            java.lang.Class<o.ﮞ> r0 = o.C1145.class
            if (r6 != r0) goto L_0x0030
            o.ｯ$4 r0 = new o.ｯ$4     // Catch:{ Throwable -> 0x004e }
            r0.<init>()     // Catch:{ Throwable -> 0x004e }
            com.netflix.falkor.cache.FalkorCache.C0004.m190(r4, r0)     // Catch:{ Throwable -> 0x004e }
            goto L_0x0038
        L_0x0030:
            o.ｯ$1 r0 = new o.ｯ$1     // Catch:{ Throwable -> 0x004e }
            r0.<init>(r13, r6)     // Catch:{ Throwable -> 0x004e }
            com.netflix.falkor.cache.FalkorCache.C0004.m190(r4, r0)     // Catch:{ Throwable -> 0x004e }
        L_0x0038:
            com.netflix.falkor.cache.FalkorCacheMonitor r0 = com.netflix.falkor.cache.FalkorCache.m165()     // Catch:{ Throwable -> 0x004e }
            java.lang.String r1 = "trim"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x004e }
            long r2 = r2 - r8
            int r2 = (int) r2     // Catch:{ Throwable -> 0x004e }
            r0.m206(r1, r2, r7)     // Catch:{ Throwable -> 0x004e }
        L_0x0047:
            if (r4 == 0) goto L_0x0063
            r4.close()
            goto L_0x0063
        L_0x004e:
            r6 = move-exception
            r5 = r6
            throw r6     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r10 = move-exception
            if (r4 == 0) goto L_0x0062
            if (r5 == 0) goto L_0x005f
            r4.close()     // Catch:{ Throwable -> 0x005a }
            goto L_0x0062
        L_0x005a:
            r11 = move-exception
            r5.addSuppressed(r11)
            goto L_0x0062
        L_0x005f:
            r4.close()
        L_0x0062:
            throw r10
        L_0x0063:
            goto L_0x006e
        L_0x0064:
            r4 = move-exception
            o.ｕ r0 = o.C1276.m16820()
            java.lang.String r1 = "expireLolomoListsFromCache"
            r0.mo5729(r1, r4)
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1248.mo16199(java.util.List):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public static Date m16617(JsonElement jsonElement, Class<? extends RealmModel> cls, long j) {
        Date r4 = C0848.m15503(jsonElement);
        if (r4 != null) {
            return r4;
        }
        if (cls == C1145.class) {
            return new Date(System.currentTimeMillis() + j);
        }
        if (cls == C1202.class) {
            return new Date(System.currentTimeMillis() + j);
        }
        if (cls == C1147.class) {
            return new Date(System.currentTimeMillis() + f15794);
        }
        return r4;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Object m16613(List<Object> list, int i, String str, AbstractC0730 r12, Class cls, boolean z) {
        FalkorCache.If r5;
        Object orCreate = r12.getOrCreate(str);
        if (orCreate == null) {
            return orCreate;
        }
        String obj = list.subList(0, i).toString();
        if (z) {
            r5 = (FalkorCache.If) this.f15795.where(cls).equalTo(FalkorPathResult.PATH, obj).greaterThan("expiry", new Date()).findFirst();
        } else {
            r5 = (FalkorCache.If) this.f15795.where(cls).equalTo(FalkorPathResult.PATH, obj).findFirst();
        }
        if (r5 == null || C1349Bv.m4113(r5.getPayload())) {
            FalkorCache.m165().m200();
            return null;
        } else if ((orCreate instanceof C1049) || (orCreate instanceof AbstractC0852)) {
            if (r5 instanceof FalkorCache.Cif) {
                FalkorCache.LruBackup.m178((FalkorCache.Cif) r5);
            }
            JsonElement jsonElement = (JsonElement) ((Gson) C1281.m16832(Gson.class)).fromJson(r5.getPayload(), (Class<Object>) JsonElement.class);
            if (orCreate instanceof C1049) {
                if (r5.getSentinel() || !jsonElement.isJsonArray()) {
                    orCreate = C1128.m16280();
                } else {
                    ((C1049) orCreate).m16077(C0859.m15527(jsonElement.getAsJsonArray()));
                }
                r12.set(str, orCreate);
            } else if (orCreate instanceof AbstractC0852) {
                ((AbstractC0852) orCreate).populate(jsonElement);
                r12.set(str, orCreate);
            }
            if ((orCreate instanceof AbstractC0847) && orCreate != C1128.m16280()) {
                ((AbstractC0847) orCreate).setLastModifiedInCache(r5.getLastModifiedTime());
            }
            FalkorCache.m165().m204(r5.getPayload());
            return orCreate;
        } else if (!(orCreate instanceof C0993) || !(((C0993) orCreate).m15933() instanceof AbstractC0871)) {
            return orCreate;
        } else {
            ((AbstractC0852) ((C0993) orCreate).m15933()).populate((JsonElement) ((Gson) C1281.m16832(Gson.class)).fromJson(r5.getPayload(), (Class<Object>) JsonElement.class));
            FalkorCache.m165().m204(r5.getPayload());
            return orCreate;
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean m16618() {
        return this.f15796 > 0;
    }
}
