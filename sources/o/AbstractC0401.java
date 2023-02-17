package o;

import org.json.JSONObject;
/* renamed from: o.ʖ  reason: contains not printable characters */
public abstract class AbstractC0401 extends AbstractC0675 implements AbstractC0514 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private float f13351;

    protected AbstractC0401(float f) {
        m14630("UserInput");
        this.f13351 = f;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("confidence", (double) this.f13351);
        return jSONObject;
    }
}
