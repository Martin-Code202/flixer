package o;

import java.net.URLDecoder;
import org.json.JSONObject;
/* renamed from: o.ft  reason: case insensitive filesystem */
public abstract class AbstractC1787ft {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected String f6814;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected JSONObject f6815;

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public abstract void mo6437(JSONObject jSONObject);

    public AbstractC1787ft(String str, JSONObject jSONObject) {
        this.f6814 = str;
        if (jSONObject == null) {
            throw new IllegalArgumentException("JSON is null");
        }
        this.f6815 = jSONObject;
        mo6437(jSONObject);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    protected static String m6458(JSONObject jSONObject, String str, String str2) {
        String r2 = AK.m3376(jSONObject, str, str2);
        if (r2 == null || "".equals(r2.trim())) {
            return r2;
        }
        try {
            return URLDecoder.decode(r2, "UTF-8");
        } catch (Throwable th) {
            return r2;
        }
    }
}
