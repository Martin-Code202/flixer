package o;

import org.json.JSONObject;
/* renamed from: o.ʕ  reason: contains not printable characters */
public final class C0400 extends AbstractC0675 implements AbstractC0514 {
    public C0400() {
        m14630("UserAgent");
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "userAgent", C0441.m14301());
        return jSONObject;
    }
}
