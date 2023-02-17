package o;

import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import org.json.JSONObject;
/* renamed from: o.ј  reason: contains not printable characters */
public class C0510 implements AbstractC0503 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private C0501 f13646;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0510 f13647;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f13648;

    public C0510(String str) {
        this(str, null, null);
    }

    public C0510(String str, C0501 r3) {
        this(str, r3, null);
    }

    public C0510(String str, C0501 r4, C0510 r5) {
        if (str == null) {
            throw new IllegalArgumentException("Code is required for an error!");
        }
        this.f13648 = str;
        this.f13646 = r4;
        this.f13647 = r5;
    }

    @Override // o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", this.f13648);
        if (this.f13647 != null) {
            jSONObject.put("cause", this.f13647.toJSONObject());
        }
        if (this.f13646 != null) {
            jSONObject.put(DeepErrorElement.DEBUG, this.f13646.m14481());
        }
        return jSONObject;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C0510 m14526(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("code");
        JSONObject optJSONObject = jSONObject.optJSONObject(DeepErrorElement.DEBUG);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("cause");
        C0510 r4 = null;
        if (optJSONObject2 != null) {
            try {
                r4 = m14526(optJSONObject2);
            } catch (Throwable th) {
            }
        }
        C0501 r5 = null;
        if (optJSONObject != null) {
            r5 = new C0501(optJSONObject);
        }
        return new C0510(string, r5, r4);
    }
}
