package o;

import org.json.JSONObject;
/* renamed from: o.ς  reason: contains not printable characters */
public final class C0464 extends C1275 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f13509;

    C0464(C1241 r2, long j) {
        super(r2);
        m14630("UserInteractionEnded");
        this.f13509 = j;
    }

    @Override // o.C1275, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("lastUserActivityTime", this.f13509);
        return jSONObject;
    }
}
