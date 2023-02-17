package o;

import org.json.JSONObject;
/* renamed from: o.ๆ  reason: contains not printable characters */
public final class C0708 extends AbstractC0470 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f14234;

    public C0708(long j) {
        m14630("RemoveCachedVideo");
        this.f14234 = j;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("oxid", this.f14234);
        return jSONObject;
    }
}
