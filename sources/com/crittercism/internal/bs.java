package com.crittercism.internal;

import android.content.Context;
import com.crittercism.internal.ap;
import com.crittercism.internal.bw;
import com.crittercism.internal.cf;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
public final class bs implements bw.a {
    private au a;
    private Context b;
    private URL c;
    private bu d;
    private boolean e;
    private ap f;

    public bs(URL url, Context context, au auVar, ap apVar, bu buVar) {
        this.c = url;
        this.b = context;
        this.a = auVar;
        this.f = apVar;
        this.d = buVar;
    }

    private void a(JSONObject jSONObject, ap.d dVar, ap.a aVar, ap.a aVar2, ap.b bVar) {
        try {
            this.f.a((ap.e<ap.d>) dVar, (ap.d) Long.valueOf(1000 * jSONObject.getLong("interval")));
        } catch (JSONException unused) {
        }
        try {
            boolean z = jSONObject.getBoolean("enabled");
            this.f.a((ap.e<ap.a>) aVar2, (ap.a) Boolean.valueOf(z));
            this.f.a((ap.e<ap.a>) aVar, (ap.a) Boolean.valueOf(z));
        } catch (JSONException unused2) {
        }
        try {
            this.f.a((ap.e<ap.b>) bVar, (ap.b) Float.valueOf((float) jSONObject.getDouble("rate")));
        } catch (JSONException unused3) {
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("txnConfig");
            a(jSONObject2, ap.A, ap.z, ap.y, ap.B);
            long optLong = jSONObject2.optLong("defaultTimeout", ((Long) ap.H.b()).longValue());
            this.f.a((ap.e<ap.d>) ap.H, (ap.d) Long.valueOf(optLong));
            JSONObject optJSONObject = jSONObject2.optJSONObject("transactions");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.f.b(next, optJSONObject.getJSONObject(next).optLong("timeout", optLong));
                }
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.crittercism.internal.bw.a
    public final void a(bv bvVar) {
        if (bvVar != null && bvVar.b != null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bvVar.b));
                if (jSONObject.optBoolean("internalExceptionReporting", false)) {
                    cf.a = cf.a.b;
                } else {
                    cf.a = cf.a.c;
                }
                if (jSONObject.optInt("needPkg", 0) == 1) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("device_name", "Android");
                        jSONObject2.putOpt("pkg", this.b.getPackageName());
                        jSONObject2.putOpt("app_id", this.a.e);
                        jSONObject2.putOpt("hashed_device_id", this.a.h());
                        jSONObject2.putOpt("library_version", "5.8.7");
                        this.d.a(bt.a(new URL(this.c + "/android_v2/update_package_name"), jSONObject2, bt.a(this.a)));
                    } catch (JSONException unused) {
                    } catch (IOException unused2) {
                    } catch (IOException e2) {
                        cf.d("IOException in handleResponse(): " + e2.getMessage());
                        cf.a(e2);
                    }
                    this.e = true;
                }
                try {
                    a(jSONObject.getJSONObject("crashConfig"), ap.g, ap.f, ap.e, ap.h);
                } catch (JSONException unused3) {
                }
                try {
                    a(jSONObject.getJSONObject("ndkConfig"), ap.f16012o, ap.n, ap.m, ap.p);
                } catch (JSONException unused4) {
                }
                try {
                    a(jSONObject.getJSONObject("heConfig"), ap.k, ap.j, ap.i, ap.l);
                } catch (JSONException unused5) {
                }
                try {
                    a(jSONObject.getJSONObject("metadataConfig"), ap.s, ap.r, ap.q, ap.t);
                } catch (JSONException unused6) {
                }
                try {
                    a(jSONObject.getJSONObject("apm").getJSONObject("net"), ap.c, ap.b, ap.a, ap.d);
                } catch (JSONException unused7) {
                }
                a(jSONObject);
            } catch (JSONException unused8) {
            }
        }
    }
}
