package com.crittercism.internal;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
public final class ba implements bf {
    String a;
    String b;

    public ba(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.crittercism.internal.bf
    public final String f() {
        return this.a;
    }

    @Override // com.crittercism.internal.bf
    public final Object g() {
        throw new UnsupportedOperationException();
    }

    public static class a extends bx {
        public a(au auVar) {
            super(auVar);
        }

        @Override // com.crittercism.internal.bx
        public final bt a(as asVar, List<? extends bf> list) {
            URL url = new URL(asVar.b, "/android_v2/update_user_metadata");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", this.a.e);
                jSONObject.put("hashed_device_id", this.a.h());
                jSONObject.put("library_version", "5.8.7");
                jSONObject.put("development_platform", this.a.h);
                JSONObject jSONObject2 = new JSONObject();
                for (bf bfVar : list) {
                    ba baVar = (ba) bfVar;
                    jSONObject2.put(baVar.a, baVar.b);
                }
                jSONObject.put("metadata", jSONObject2);
                return bt.a(url, jSONObject, this.b);
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}
