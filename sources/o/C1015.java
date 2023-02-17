package o;

import org.json.JSONObject;
/* renamed from: o.ᵑ  reason: contains not printable characters */
public final class C1015 extends AbstractC0675 implements AbstractC0514 {
    public C1015() {
        m14630("MdxJs");
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("jsVersion", C0441.m14291());
        return jSONObject;
    }
}
