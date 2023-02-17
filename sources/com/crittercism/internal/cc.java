package com.crittercism.internal;

import android.os.Build;
import com.crittercism.internal.aw;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class cc implements bf {
    String a;
    long b;
    public int c;
    long d;
    long e;
    int f;
    int g;
    String h;
    List<b> i;
    float j;

    /* synthetic */ cc(byte b2) {
        this();
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class d extends Enum<d> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        public static final int h = 8;
        public static final int i = 9;
        private static final /* synthetic */ int[] j = {a, b, c, d, e, f, g, h, i};

        public static int[] a() {
            return (int[]) j.clone();
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class e extends Enum<e> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {a, b, c};

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* access modifiers changed from: package-private */
    public static final class c extends Enum<c> {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c = {a, b};

        public static int[] a() {
            return (int[]) c.clone();
        }
    }

    public static class a {
        public String a;
        public long b;
        public int c;
        public long d;
        int e = e.a;

        public final cc a() {
            return new cc(this.a, this.b, this.c, this.d, this.e);
        }
    }

    public cc(String str, long j2, int i2, long j3, int i3) {
        this.b = -1;
        this.c = -1;
        this.e = -1;
        this.f = d.b;
        this.g = e.a;
        this.h = be.a.a();
        this.i = new LinkedList();
        this.j = 1.0f;
        String str2 = str;
        this.a = str2.length() > 255 ? str2.substring(0, 255) : str2;
        this.c = i2;
        this.d = j2;
        this.b = j3;
        this.g = i3;
    }

    private cc() {
        this.b = -1;
        this.c = -1;
        this.e = -1;
        this.f = d.b;
        this.g = e.a;
        this.h = be.a.a();
        this.i = new LinkedList();
        this.j = 1.0f;
    }

    public final void a(int i2, long j2) {
        if (this.f == d.b) {
            this.e = j2;
            if (a() > this.b) {
                this.f = d.f;
            } else {
                this.f = i2;
            }
        }
    }

    public final long a() {
        long j2 = this.e;
        if (this.e < 0) {
            j2 = System.currentTimeMillis();
        }
        Collections.sort(this.i);
        Iterator<b> it = this.i.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.b < this.d) {
                it.remove();
            } else if (next.b > j2) {
                it.remove();
            }
        }
        if (this.f == d.f) {
            return this.b;
        }
        if (this.g == e.c || this.i.size() == 0) {
            return j2 - this.d;
        }
        int i2 = c.b;
        if (this.i.get(0).a == c.b) {
            i2 = c.a;
        }
        int i3 = i2;
        long j3 = 0;
        long j4 = this.d;
        for (b bVar : this.i) {
            if (bVar.b >= this.d) {
                if (bVar.b > j2) {
                    break;
                }
                if (i3 == c.b) {
                    j3 += bVar.b - j4;
                }
                j4 = bVar.b;
                i3 = bVar.a;
            }
        }
        if (i3 == c.b) {
            return j3 + (j2 - j4);
        }
        return j3;
    }

    /* renamed from: b */
    public final JSONArray g() {
        Object obj;
        JSONArray jSONArray = null;
        try {
            JSONArray put = new JSONArray().put(this.a).put(this.f - 1).put(((double) this.b) / 1000.0d);
            if (this.c == -1) {
                obj = JSONObject.NULL;
            } else {
                obj = Integer.valueOf(this.c);
            }
            jSONArray = put.put(obj).put(new JSONObject()).put(ci.a.a(new Date(this.d))).put(ci.a.a(new Date(this.e)));
            if (Build.VERSION.SDK_INT >= 14) {
                jSONArray.put(((double) a()) / 1000.0d);
            } else {
                jSONArray.put(JSONObject.NULL);
            }
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    @Override // com.crittercism.internal.bf
    public final String f() {
        return this.h;
    }

    public static class g implements aw.b<cc> {
        private g() {
        }

        public /* synthetic */ g(byte b) {
            this();
        }

        /* Return type fixed from 'com.crittercism.internal.bf' to match base method */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ cc a(File file) {
            return b(file);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.crittercism.internal.bf, java.io.OutputStream] */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ void a(cc ccVar, OutputStream outputStream) {
            cc ccVar2 = ccVar;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", ccVar2.a);
                jSONObject.put("state", ccVar2.f - 1);
                jSONObject.put("timeout", ccVar2.b);
                jSONObject.put("value", ccVar2.c);
                jSONObject.put("startTime", ccVar2.d);
                jSONObject.put("endTime", ccVar2.e);
                jSONObject.put("sequenceNumber", ccVar2.h);
                jSONObject.put("rate", (double) ccVar2.j);
                jSONObject.put("type", ccVar2.g - 1);
                JSONArray jSONArray = new JSONArray();
                for (b bVar : ccVar2.i) {
                    jSONArray.put(new JSONObject().put("type", bVar.a - 1).put("time", bVar.b));
                }
                jSONObject.put("lifeCycleTransitions", jSONArray);
                outputStream.write(jSONObject.toString().getBytes("UTF8"));
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }

        private static cc b(File file) {
            try {
                JSONObject jSONObject = new JSONObject(cg.b(file));
                cc ccVar = new cc((byte) 0);
                ccVar.a = jSONObject.getString("name");
                ccVar.f = d.a()[jSONObject.getInt("state")];
                ccVar.b = jSONObject.getLong("timeout");
                ccVar.c = jSONObject.getInt("value");
                ccVar.d = jSONObject.getLong("startTime");
                ccVar.e = jSONObject.getLong("endTime");
                ccVar.h = jSONObject.getString("sequenceNumber");
                ccVar.j = (float) jSONObject.getDouble("rate");
                ccVar.g = e.a()[jSONObject.getInt("type")];
                JSONArray jSONArray = jSONObject.getJSONArray("lifeCycleTransitions");
                for (int i = 0; i < jSONArray.length(); i++) {
                    ccVar.i.add(new b(jSONArray.getJSONObject(i)));
                }
                return ccVar;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public static class f extends bx {
        private au c;
        private av<at> d;

        public f(au auVar, av<at> avVar) {
            super(auVar);
            this.c = auVar;
            this.d = avVar;
        }

        @Override // com.crittercism.internal.bx
        public final bt a(as asVar, List<? extends bf> list) {
            URL url = new URL(asVar.c + "/api/v1/transactions");
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appID", this.c.e);
                jSONObject2.put("deviceID", this.c.h());
                jSONObject2.put("crPlatform", "android");
                jSONObject2.put("developmentPlatform", this.c.h);
                jSONObject2.put("crVersion", "5.8.7");
                jSONObject2.put("deviceModel", Build.MODEL);
                jSONObject2.put("osName", "Android");
                jSONObject2.put("osVersion", Build.VERSION.RELEASE);
                jSONObject2.put("carrier", this.c.b());
                jSONObject2.put("mobileCountryCode", this.c.c());
                jSONObject2.put("mobileNetworkCode", this.c.d());
                jSONObject2.put("appVersion", this.c.a.a);
                jSONObject2.put(LoggingRequest.LOCALE, this.c.i());
                jSONObject.put("appState", jSONObject2);
                JSONArray jSONArray = new JSONArray();
                for (bf bfVar : list) {
                    jSONArray.put(bfVar.g());
                }
                jSONObject.put("transactions", jSONArray);
                if (a(list)) {
                    jSONObject.put("systemBreadcrumbs", this.d.a());
                    jSONObject.put("breadcrumbs", new JSONObject());
                    jSONObject.put("endpoints", new JSONArray());
                }
                return bt.a(url, jSONObject, this.b);
            } catch (JSONException e) {
                throw ((IOException) new IOException(e.getMessage()).initCause(e));
            }
        }

        private static boolean a(List<? extends bf> list) {
            for (bf bfVar : list) {
                int i = ((cc) bfVar).f;
                if (!(i == d.c || i == d.i || i == d.h)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements Comparable<b> {
        public int a;
        public long b;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(b bVar) {
            b bVar2 = bVar;
            if (this.b < bVar2.b) {
                return -1;
            }
            if (this.b == bVar2.b) {
                return 0;
            }
            return 1;
        }

        public b(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public b(JSONObject jSONObject) {
            this.a = c.a()[jSONObject.getInt("type")];
            this.b = jSONObject.getLong("time");
        }
    }
}
