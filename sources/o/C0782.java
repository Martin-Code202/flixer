package o;

import org.json.JSONObject;
/* renamed from: o.ᒣ  reason: contains not printable characters */
public class C0782 extends C0842 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f14440;

    public C0782(long j) {
        super(j);
        m14630("CachedMetadataRendered");
        this.f14440 = j;
    }

    @Override // o.C0842, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14627(jSONObject, "renderNavigationLevelId", this.f14440);
        return jSONObject;
    }
}
