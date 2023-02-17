package com.crittercism.internal;

import android.os.Build;
import com.crittercism.internal.aw;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class ar implements bf {
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    int h;
    int i;
    String j;
    String k;
    long l;
    public float m;

    /* synthetic */ ar(byte b2) {
        this();
    }

    public ar(au auVar) {
        this.m = 1.0f;
        this.a = be.a.a();
        this.b = auVar.e;
        this.c = auVar.h();
        this.d = "5.8.7";
        this.e = Build.MODEL;
        this.f = Build.VERSION.RELEASE;
        this.g = auVar.b();
        this.h = auVar.c().intValue();
        this.i = auVar.d().intValue();
        this.j = auVar.a.a;
        this.k = auVar.i();
        this.l = System.nanoTime();
    }

    private ar() {
        this.m = 1.0f;
    }

    /* renamed from: a */
    public final JSONObject g() {
        try {
            return new JSONObject().putOpt("appID", this.b).putOpt("deviceID", this.c).putOpt("crPlatform", "android").putOpt("crVersion", this.d).putOpt("rate", Float.valueOf(this.m)).putOpt("deviceModel", this.e).putOpt("osName", "android").putOpt("osVersion", this.f).putOpt("carrier", this.g).putOpt("mobileCountryCode", Integer.valueOf(this.h)).putOpt("mobileNetworkCode", Integer.valueOf(this.i)).putOpt("appVersion", this.j).putOpt(LoggingRequest.LOCALE, this.k);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ar arVar = (ar) obj;
        if (this.h == arVar.h && this.i == arVar.i && this.b.equals(arVar.b) && this.c.equals(arVar.c) && this.d.equals(arVar.d) && Float.compare(this.m, arVar.m) == 0 && this.e.equals(arVar.e) && this.f.equals(arVar.f) && this.g.equals(arVar.g) && this.j.equals(arVar.j)) {
            return this.k.equals(arVar.k);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Float.floatToIntBits(this.m)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h) * 31) + this.i) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    }

    @Override // com.crittercism.internal.bf
    public final String f() {
        return this.a;
    }

    public static class b implements aw.b<ar> {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        /* Return type fixed from 'com.crittercism.internal.bf' to match base method */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ ar a(File file) {
            return b(file);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.crittercism.internal.bf, java.io.OutputStream] */
        @Override // com.crittercism.internal.aw.b
        public final /* synthetic */ void a(ar arVar, OutputStream outputStream) {
            ar arVar2 = arVar;
            try {
                outputStream.write(new JSONObject().putOpt("fileName", arVar2.a).putOpt("appId", arVar2.b).putOpt("deviceId", arVar2.c).putOpt("sdkVersion", arVar2.d).putOpt("rate", Float.valueOf(arVar2.m)).putOpt(Device.MODEL, arVar2.e).putOpt("osVersion", arVar2.f).putOpt("carrier", arVar2.g).putOpt("mobileCountryCode", Integer.valueOf(arVar2.h)).putOpt("mobileNetworkCode", Integer.valueOf(arVar2.i)).putOpt("appVersion", arVar2.j).putOpt(LoggingRequest.LOCALE, arVar2.k).putOpt("timestamp", Long.valueOf(arVar2.l)).toString().getBytes("UTF8"));
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }

        private static ar b(File file) {
            try {
                JSONObject jSONObject = new JSONObject(cg.b(file));
                ar arVar = new ar((byte) 0);
                arVar.a = jSONObject.getString("fileName");
                arVar.b = jSONObject.getString("appId");
                arVar.c = jSONObject.getString("deviceId");
                arVar.d = jSONObject.getString("sdkVersion");
                arVar.m = (float) jSONObject.getDouble("rate");
                arVar.e = jSONObject.getString(Device.MODEL);
                arVar.f = jSONObject.getString("osVersion");
                arVar.g = jSONObject.getString("carrier");
                arVar.h = jSONObject.getInt("mobileCountryCode");
                arVar.i = jSONObject.getInt("mobileNetworkCode");
                arVar.j = jSONObject.getString("appVersion");
                arVar.k = jSONObject.getString(LoggingRequest.LOCALE);
                arVar.l = jSONObject.getLong("timestamp");
                return arVar;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public static class a extends bx {
        public a(au auVar) {
            super(auVar);
        }

        @Override // com.crittercism.internal.bx
        public final bt a(as asVar, List<? extends bf> list) {
            HashMap hashMap = new HashMap();
            ar arVar = null;
            for (bf bfVar : list) {
                ar arVar2 = (ar) bfVar;
                int i = 0;
                if (hashMap.containsKey(arVar2)) {
                    i = ((Integer) hashMap.get(arVar2)).intValue();
                }
                hashMap.put(arVar2, Integer.valueOf(i + 1));
                if (arVar2.l > 0) {
                    arVar = arVar2;
                }
            }
            JSONArray jSONArray = new JSONArray();
            try {
                for (ar arVar3 : hashMap.keySet()) {
                    jSONArray.put(new JSONObject().put("appLoads", arVar3.g()).put("count", ((Integer) hashMap.get(arVar3)).intValue()).put("current", arVar != null && arVar.equals(arVar3)));
                }
                URL url = new URL(asVar.d, "/v0/appload");
                Map map = this.b;
                map.put("Content-type", "application/json");
                return new bt("POST", url, jSONArray.toString().getBytes("UTF8"), map);
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}
