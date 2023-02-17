package o;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public class kB {

    /* renamed from: ˊ$781c85de  reason: contains not printable characters */
    private final Object f8137$781c85de;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Gson f8138;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Cif f8139;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Map<String, Cif> f8140;

    public kB(Gson gson, String str) {
        try {
            this.f8137$781c85de = ((Class) C1235.m16591(3, 4, 51741)).getDeclaredConstructor(null).newInstance(null);
            this.f8140 = new HashMap();
            this.f8138 = gson;
            try {
                JSONObject r6 = m8180(new JSONObject(str).optJSONObject("exo"));
                Iterator<String> keys = r6.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    C1283.m16863("NetflixStreamingConfig", "has top level overrride for %s .", next);
                    char c = 65535;
                    switch (next.hashCode()) {
                        case 3059615:
                            if (next.equals("core")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1207637152:
                            if (next.equals("UiLabel")) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            this.f8139 = new Cif(next, r6.getJSONObject(next));
                            break;
                        case 1:
                            JSONObject jSONObject = r6.getJSONObject(next);
                            Iterator<String> keys2 = jSONObject.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String str2 = next + "." + next2;
                                C1283.m16863("NetflixStreamingConfig", "has overrride for %s .", str2);
                                this.f8140.put(next2, new Cif(str2, jSONObject.getJSONObject(next2)));
                            }
                            break;
                    }
                }
            } catch (JSONException e) {
                C1283.m16855("NetflixStreamingConfig", "JSONException %s while parsing streaming config.", e.getMessage());
            } catch (Exception e2) {
                C1283.m16855("NetflixStreamingConfig", "exception %s while parsing streaming config, will fallback to default.", e2.getMessage());
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private JSONObject m8180(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("UiLabel");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        String[] r2 = C2065pn.m9852();
        for (String str : r2) {
            if (!optJSONObject.has(str)) {
                JSONObject jSONObject2 = new JSONObject();
                C2065pn.m9853(jSONObject2, str);
                if (jSONObject2.length() > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.putOpt("common", jSONObject2);
                        optJSONObject.putOpt(str, jSONObject3);
                    } catch (JSONException e) {
                    }
                }
            }
        }
        if (optJSONObject.length() > 0) {
            try {
                jSONObject.putOpt("UiLabel", optJSONObject);
            } catch (JSONException e2) {
            }
        }
        return jSONObject;
    }

    /* renamed from: ॱ$59fb67b1  reason: contains not printable characters */
    public Object m8182$59fb67b1(String str, String str2) {
        Object obj = null;
        if (str2.equals("Default")) {
            obj = this.f8139 == null ? null : this.f8139.m8184$2ce695e7(str);
        } else if (this.f8140.get(str2) != null) {
            obj = this.f8140.get(str2).m8184$2ce695e7(str);
        }
        return obj == null ? this.f8137$781c85de : obj;
    }

    /* renamed from: o.kB$if  reason: invalid class name */
    class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final String f8141;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final JSONObject f8142;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final Map<String, Object> f8143 = new HashMap();

        Cif(String str, JSONObject jSONObject) {
            this.f8141 = str;
            this.f8142 = jSONObject;
            this.f8143.put("common", m8183$515ac7c9(kB.this.f8137$781c85de, "common"));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ$2ce695e7  reason: contains not printable characters */
        public Object m8184$2ce695e7(String str) {
            Object obj = this.f8143.get(str);
            if (obj != null) {
                return obj;
            }
            Object r2 = m8183$515ac7c9(this.f8143.get("common"), str);
            this.f8143.put(str, r2);
            return r2;
        }

        /* renamed from: ˏ$515ac7c9  reason: contains not printable characters */
        private Object m8183$515ac7c9(Object obj, String str) {
            try {
                JSONObject jSONObject = this.f8142.getJSONObject(str);
                JSONObject jSONObject2 = new JSONObject(kB.this.f8138.toJson(obj));
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    C1283.m16863("NetflixStreamingConfig", "%s.%s >>> has overrride for  %s=%s.", this.f8141, str, next, jSONObject.opt(next));
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                }
                Object fromJson = kB.this.f8138.fromJson(jSONObject2.toString(), (Class<Object>) ((Class) C1235.m16591(3, 4, 51741)));
                C1283.m16863("NetflixStreamingConfig", "%s final config %s ", this.f8141, kB.this.f8138.toJson(fromJson));
                return fromJson;
            } catch (JSONException e) {
                C1283.m16851("NetflixStreamingConfig", "%s use base config.", this.f8141);
                return obj;
            }
        }
    }
}
