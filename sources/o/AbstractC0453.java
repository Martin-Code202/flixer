package o;

import org.json.JSONObject;
/* access modifiers changed from: package-private */
/* renamed from: o.Ξ  reason: contains not printable characters */
public abstract class AbstractC0453 extends AbstractC0470 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC0574 f13503;

    protected AbstractC0453(AbstractC0574 r1) {
        this.f13503 = r1;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14624(jSONObject, "trackingInfo", this.f13503);
        return jSONObject;
    }
}
