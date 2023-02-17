package o;

import org.json.JSONObject;
/* renamed from: o.ᓳ  reason: contains not printable characters */
public class C0842 extends AbstractC0783 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f14672;

    public C0842(long j) {
        m14630("MetadataRendered");
        this.f14672 = j;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14627(jSONObject, "renderNavigationLevelId", this.f14672);
        return jSONObject;
    }
}
