package o;

import org.json.JSONObject;
/* renamed from: o.ډ  reason: contains not printable characters */
public final class C0599 extends C1275 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private JSONObject f13896;

    C0599(C0504 r2, JSONObject jSONObject) {
        super(r2);
        m14630("cs.CallEnded");
        this.f13896 = jSONObject;
    }

    @Override // o.C1275, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        if (this.f13896 != null) {
            jSONObject.put("qualityReport", this.f13896);
        }
        return jSONObject;
    }
}
