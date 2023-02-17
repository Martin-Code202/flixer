package o;

import org.json.JSONObject;
/* renamed from: o.ر  reason: contains not printable characters */
public final class C0581 extends AbstractC0675 implements AbstractC0514 {
    public C0581() {
        m14630("AppVersion");
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "appVersion", C0441.m14296());
        return jSONObject;
    }
}
