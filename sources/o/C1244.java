package o;

import org.json.JSONObject;
/* renamed from: o.ｪ  reason: contains not printable characters */
public final class C1244 extends AbstractC1100 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f15785 = -1;

    public C1244() {
        m14630("PlayCommand");
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        if (this.f15785 > 0) {
            jSONObject.put("actualTime", this.f15785);
        }
        return jSONObject;
    }
}
