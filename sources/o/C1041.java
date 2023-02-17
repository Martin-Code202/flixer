package o;

import org.json.JSONObject;
/* renamed from: o.ᵨ  reason: contains not printable characters */
public final class C1041 extends AbstractC0675 implements AbstractC0514 {
    public C1041() {
        m14630("MdxLib");
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("libVersion", C0441.m14292());
        return jSONObject;
    }
}
