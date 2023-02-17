package o;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.netflix.falkor.cache.FalkorCache;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import o.AbstractC0730;
@SuppressLint({"DefaultLocale"})
/* renamed from: o.ᒩ  reason: contains not printable characters */
public class C0787<T extends AbstractC0730> implements AbstractC0929<T> {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean f14445 = false;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static long f14446;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Handler f14447;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final boolean f14448;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final T f14449;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final JsonParser f14450 = new JsonParser();

    /* renamed from: ˎ  reason: contains not printable characters */
    int f14451;

    /* renamed from: ॱ  reason: contains not printable characters */
    int f14452;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AbstractC1261 f14453;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        if (r2 != null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        if (r4 != null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r4.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        r5 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0787(T r8, boolean r9, o.AbstractC1261 r10) {
        /*
            r7 = this;
            r7.<init>()
            com.google.gson.JsonParser r0 = new com.google.gson.JsonParser
            r0.<init>()
            r7.f14450 = r0
            r7.f14449 = r8
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            r7.f14447 = r0
            r7.f14448 = r9
            r7.f14453 = r10
            r0 = 0
            o.丿 r2 = r7.m15260(r0)
            r3 = 0
            r2.mo16194()     // Catch:{ Throwable -> 0x002b }
            if (r2 == 0) goto L_0x0040
            r2.close()
            goto L_0x0040
        L_0x002b:
            r4 = move-exception
            r3 = r4
            throw r4     // Catch:{ all -> 0x002e }
        L_0x002e:
            r5 = move-exception
            if (r2 == 0) goto L_0x003f
            if (r3 == 0) goto L_0x003c
            r2.close()     // Catch:{ Throwable -> 0x0037 }
            goto L_0x003f
        L_0x0037:
            r6 = move-exception
            r3.addSuppressed(r6)
            goto L_0x003f
        L_0x003c:
            r2.close()
        L_0x003f:
            throw r5
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0787.<init>(o.ᐜ, boolean, o.ｿ):void");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final AbstractC1096 m15260(boolean z) {
        return C1138.m16312(this.f14453, z);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final boolean m15261() {
        return this.f14448;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m15246(long j) {
        f14446 = j;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final int m15248() {
        return this.f14452;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final int m15250() {
        return this.f14451;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        if (r7 != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r9 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        r9.addSuppressed(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        throw r11;
     */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized o.C0856 m15249(java.util.Collection<o.C0859> r14) {
        /*
            r13 = this;
            monitor-enter(r13)
            o.ᔁ r6 = new o.ᔁ     // Catch:{ all -> 0x0046 }
            r6.<init>(r14)     // Catch:{ all -> 0x0046 }
            r0 = 0
            o.丿 r7 = r13.m15260(r0)     // Catch:{ all -> 0x0046 }
            r8 = 0
            java.util.Iterator r9 = r14.iterator()     // Catch:{ Throwable -> 0x002f }
        L_0x0010:
            boolean r0 = r9.hasNext()     // Catch:{ Throwable -> 0x002f }
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r9.next()     // Catch:{ Throwable -> 0x002f }
            r10 = r0
            o.ᔄ r10 = (o.C0859) r10     // Catch:{ Throwable -> 0x002f }
            r0 = r13
            r1 = r10
            T extends o.ᐜ r2 = r13.f14449     // Catch:{ Throwable -> 0x002f }
            r4 = r6
            r5 = r7
            r3 = 0
            r0.m15245(r1, r2, r3, r4, r5)     // Catch:{ Throwable -> 0x002f }
            goto L_0x0010
        L_0x0028:
            if (r7 == 0) goto L_0x0044
            r7.close()
            goto L_0x0044
        L_0x002f:
            r9 = move-exception
            r8 = r9
            throw r9     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r11 = move-exception
            if (r7 == 0) goto L_0x0043
            if (r8 == 0) goto L_0x0040
            r7.close()     // Catch:{ Throwable -> 0x003b }
            goto L_0x0043
        L_0x003b:
            r12 = move-exception
            r8.addSuppressed(r12)
            goto L_0x0043
        L_0x0040:
            r7.close()
        L_0x0043:
            throw r11
        L_0x0044:
            monitor-exit(r13)
            return r6
        L_0x0046:
            r14 = move-exception
            monitor-exit(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0787.m15249(java.util.Collection):o.ᔁ");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final synchronized void m15245(C0859 r17, Object obj, int i, C0856 r20, AbstractC1096 r21) {
        int size = r17.m15533().size();
        if (i < size && obj == null) {
            r20.f14699.add(r17);
        } else if (i == size) {
            if (obj != null) {
                r20.f14696.add(r17);
            } else {
                r20.f14699.add(r17);
            }
        } else if (i > size) {
            throw new IllegalStateException("Offset is invalid");
        } else if (obj instanceof C1049) {
            C1049 r7 = (C1049) obj;
            Object r8 = r7.m16079();
            if (r8 != null) {
                m15245(r7.m16080().m15535(r17.m15537(i)), r8, r7.m16080().m15533().size(), r20, r21);
            } else if (r7.m16080() == null) {
                r20.f14699.add(r17);
            } else {
                m15245(r7.m16080().m15535(r17.m15537(i)), this.f14449, 0, r20, r21);
            }
        } else if ((obj instanceof Exception) || (obj instanceof C1128)) {
            r20.f14698.add(r17);
        } else {
            AbstractC0730 r72 = (AbstractC0730) obj;
            Object obj2 = r17.m15533().get(i);
            if (obj2 instanceof List) {
                for (Object obj3 : (List) obj2) {
                    if (obj3 instanceof Map) {
                        Map map = (Map) obj3;
                        Integer num = (Integer) map.get(NetflixActivity.EXTRA_FROM);
                        Integer num2 = (Integer) map.get("to");
                        if (num == null) {
                            num = 0;
                        }
                        if (num2 == null) {
                            throw new IllegalStateException("No 'to' param");
                        }
                        for (int intValue = num.intValue(); intValue <= num2.intValue(); intValue++) {
                            m15245(r17.m15538(i, String.valueOf(intValue)), obj, i, r20, r21);
                        }
                    } else {
                        m15245(r17.m15538(i, obj3), obj, i, r20, r21);
                    }
                }
            } else if (obj2 instanceof Map) {
                Map map2 = (Map) obj2;
                Integer num3 = (Integer) map2.get(NetflixActivity.EXTRA_FROM);
                Integer num4 = (Integer) map2.get("to");
                if (num3 == null) {
                    num3 = 0;
                }
                if (num4 == null) {
                    throw new IllegalStateException("No 'to' param");
                }
                for (int intValue2 = num3.intValue(); intValue2 <= num4.intValue(); intValue2++) {
                    m15245(r17.m15538(i, String.valueOf(intValue2)), obj, i, r20, r21);
                }
            } else {
                String obj4 = obj2.toString();
                Object obj5 = r72.get(obj4);
                int i2 = i + 1;
                if (obj5 == null && r21 != null) {
                    obj5 = r21.mo16193(r17.m15533(), i2, obj4, r72);
                }
                m15245(r17, obj5, i2, r20, r21);
            }
        }
    }

    @Override // o.AbstractC0929
    /* renamed from: ˋ  reason: contains not printable characters */
    public final synchronized Object mo15251(C0859 r9) {
        if (r9 != null) {
            if (!r9.m15543()) {
                Object obj = this.f14449;
                AbstractC0730 r2 = (AbstractC0730) obj;
                List<Object> r3 = r9.m15533();
                int size = r3.size();
                for (int i = 0; i < size; i++) {
                    Object obj2 = r3.get(i);
                    if (obj2 != null) {
                        obj = r2.get((String) obj2);
                        while (obj instanceof C1049) {
                            C1049 r7 = (C1049) obj;
                            if (i == size - 1) {
                                return r7;
                            }
                            obj = r7.m16078(this);
                        }
                        if ((obj instanceof AbstractC0851) && i >= size - 2) {
                            return obj;
                        }
                        if (obj instanceof AbstractC0730) {
                            r2 = (AbstractC0730) obj;
                        } else if ((obj instanceof Exception) || (obj instanceof C1128)) {
                            return obj;
                        } else {
                            return obj;
                        }
                    }
                }
                return obj;
            }
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final synchronized void m15252(JsonObject jsonObject, AbstractC0730 r15, ArrayList<String> arrayList, AbstractC1096 r17) {
        ArrayList<String> arrayList2;
        if (jsonObject == null) {
            C1276.m16820().mo5725("json=null for path " + (arrayList == null ? "null" : arrayList.toString()) + " and node " + r15.toString());
            return;
        }
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            Object orCreate = r15.getOrCreate(key);
            if (arrayList == null) {
                arrayList2 = new ArrayList<>(4);
            } else {
                arrayList2 = new ArrayList<>(arrayList);
            }
            arrayList2.add(key);
            if ((orCreate instanceof C0993) && !AK.m3391(entry.getValue())) {
                orCreate = ((C0993) orCreate).m15933();
                if (r17 != null) {
                    r17.mo16198(arrayList2, entry.getValue());
                }
            }
            if (orCreate instanceof AbstractC0730) {
                m15252(entry.getValue().getAsJsonObject(), (AbstractC0730) orCreate, arrayList2, r17);
            } else if (orCreate instanceof C1049) {
                C1049 r9 = (C1049) orCreate;
                JsonElement value = entry.getValue();
                if (r17 != null) {
                    Date date = null;
                    if (value.isJsonObject() && "shows".equals(arrayList2.get(0)) && !value.getAsJsonObject().has("$expires")) {
                        date = new Date(System.currentTimeMillis() + 600000);
                    }
                    r17.mo16196(arrayList2, value, date);
                }
                if (value.isJsonArray()) {
                    r9.m16077(C0859.m15527(value.getAsJsonArray()));
                } else if (value.isJsonObject()) {
                    if (value.getAsJsonObject().has("_sentinel")) {
                        r15.set(key, C1128.m16280());
                    } else if (!"current".equals(key)) {
                        "latest".equals(key);
                    }
                }
            } else if (orCreate != null) {
                JsonElement value2 = entry.getValue();
                if (r17 != null) {
                    r17.mo16198(arrayList2, value2);
                }
                if (orCreate instanceof AbstractC0852) {
                    ((AbstractC0852) orCreate).populate(value2);
                } else {
                    r15.set(key, C0848.m15513("CachedModelProxy", value2, orCreate.getClass()));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r6 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        if (r8 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        r8.addSuppressed(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
        throw r9;
     */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m15254(o.C0859 r12) {
        /*
        // Method dump skipped, instructions count: 220
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0787.m15254(o.ᔄ):void");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m15256() {
        try {
            FalkorCache.C0004.m188();
        } catch (IllegalStateException e) {
            C1276.m16820().mo5729("purgePersistentCache", e);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final synchronized void m15253() {
        this.f14451 = -1;
        this.f14452 = -1;
        if (this.f14449 instanceof Flushable) {
            try {
                ((Flushable) this.f14449).flush();
            } catch (IOException e) {
                C1283.m16852("CachedModelProxy", e);
            }
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final JsonParser m15262() {
        return this.f14450;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public final T m15263() {
        return this.f14449;
    }

    @Override // o.AbstractC0929
    /* renamed from: ॱ  reason: contains not printable characters */
    public final <I extends AbstractC0851> List<I> mo15259(C0859 r2) {
        return m15255(Collections.singleton(r2));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final synchronized <I extends AbstractC0851> List<I> m15255(Collection<C0859> collection) {
        ArrayList arrayList;
        C0859 r8;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (C0859 r4 : collection) {
            int r5 = r4.m15539();
            if (r5 >= 0) {
                Object r7 = mo15251(r4.m15534(0, r5 + 1));
                if ((r7 instanceof C1049) && (r8 = ((C1049) r7).m16080()) != null) {
                    r4 = r4.m15538(r5, r8.m15533().get(r5));
                }
            }
            for (C0859 r0 : r4.m15536()) {
                Object r9 = mo15251(r0);
                if (r9 instanceof AbstractC0851) {
                    linkedHashSet.add((AbstractC0851) r9);
                }
            }
        }
        arrayList = new ArrayList(linkedHashSet.size());
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add((AbstractC0851) it.next());
        }
        return arrayList;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m15258(String str) {
        AH.m3344("CachedModelProxy", m15244(), str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m15257(File file) {
        if (file != null) {
            AH.m3341("CachedModelProxy", m15244(), file);
        } else {
            m15258("cache.txt");
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private String m15244() {
        StringBuilder sb = new StringBuilder();
        sb.append("==START OF CACHE==").append("\n");
        sb.append("==END OF CACHE==").append("\n");
        return sb.toString();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public Handler m15247() {
        return this.f14447;
    }
}
