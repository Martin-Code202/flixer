package o;

import org.json.JSONObject;
/* renamed from: o.ი  reason: contains not printable characters */
public abstract class AbstractC0715 extends AbstractC0783 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC0574 f14241;

    protected AbstractC0715(AbstractC0574 r1) {
        this.f14241 = r1;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14624(jSONObject, "trackingInfo", this.f14241);
        return jSONObject;
    }
}
