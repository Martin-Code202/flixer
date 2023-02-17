package o;

import org.json.JSONObject;
/* renamed from: o.ڎ  reason: contains not printable characters */
public class C0609 implements AbstractC0503 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f13911;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f13912;

    public C0609(String str, String str2) {
        this.f13912 = str;
        this.f13911 = str2;
    }

    @Override // o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.f13912 != null) {
            jSONObject.put("target", this.f13912);
        }
        if (this.f13911 != null) {
            jSONObject.put("url", this.f13911);
        }
        return jSONObject;
    }
}
