package o;

import org.json.JSONObject;
/* renamed from: o.ⅹ  reason: contains not printable characters */
public final class C1063 extends AbstractC0675 implements AbstractC0514 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f15212;

    public C1063(long j) {
        m14630("tvui.NrdAppId");
        this.f15212 = j;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14627(jSONObject, "appId", this.f15212);
        return jSONObject;
    }
}
