package o;

import org.json.JSONObject;
/* renamed from: o.װ  reason: contains not printable characters */
public final class C0571 extends C1275 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private long f13835;

    C0571(C0395 r2, long j) {
        super(r2);
        m14630("AddCachedVideoEnded");
        this.f13835 = j;
    }

    @Override // o.C1275, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("oxid", this.f13835);
        return jSONObject;
    }
}
