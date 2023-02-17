package o;

import org.json.JSONObject;
/* renamed from: o.ⅽ  reason: contains not printable characters */
public final class C1066 extends AbstractC0675 implements AbstractC0514 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f15213;

    public C1066(long j) {
        m14630("tvui.NrdSessionId");
        this.f15213 = j;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14627(jSONObject, "nrdSessionId", this.f15213);
        return jSONObject;
    }
}
