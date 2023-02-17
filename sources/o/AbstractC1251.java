package o;

import org.json.JSONObject;
/* renamed from: o.ｲ  reason: contains not printable characters */
public abstract class AbstractC1251 extends AbstractC1274 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC0574 f15821;

    protected AbstractC1251(AbstractC0574 r1) {
        this.f15821 = r1;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14624(jSONObject, "trackingInfo", this.f15821);
        return jSONObject;
    }
}
