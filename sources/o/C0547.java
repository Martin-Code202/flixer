package o;

import org.json.JSONObject;
/* renamed from: o.ב  reason: contains not printable characters */
public class C0547 extends AbstractC0470 implements AbstractC0514 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0557 f13761;

    public C0547(C0557 r2) {
        m14630("AddProfile");
        this.f13761 = r2;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14624(jSONObject, "desiredSettings", this.f13761);
        return jSONObject;
    }
}
