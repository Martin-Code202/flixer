package o;

import org.json.JSONObject;
/* renamed from: o.จ  reason: contains not printable characters */
public final class C0680 extends AbstractC0470 implements AbstractC0514 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f14131;

    public C0680(long j) {
        m14630("ProcessStateTransition");
        this.f14131 = j;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("actualTime", this.f14131);
        return jSONObject;
    }
}
