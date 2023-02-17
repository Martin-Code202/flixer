package o;

import org.json.JSONObject;
/* renamed from: o.ᓲ  reason: contains not printable characters */
public abstract class AbstractC0841 extends AbstractC0675 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC0574 f14671;

    protected AbstractC0841(AbstractC0574 r2) {
        m14630("DataModel");
        this.f14671 = r2;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14624(jSONObject, "trackingInfo", this.f14671);
        return jSONObject;
    }
}
