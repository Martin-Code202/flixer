package o;

import org.json.JSONObject;
/* renamed from: o.ɻ  reason: contains not printable characters */
public final class C0384 extends AbstractC0675 implements AbstractC0514 {
    public C0384() {
        m14630("TimeZone");
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("utcOffset", C0441.m14305());
        return jSONObject;
    }
}
