package o;

import org.json.JSONObject;
/* renamed from: o.ﬧ  reason: contains not printable characters */
public final class C1112 extends AbstractC0675 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f15330;

    public C1112(long j) {
        m14630("MediaOffset");
        this.f15330 = j;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("mediaOffset", this.f15330);
        return jSONObject;
    }
}
