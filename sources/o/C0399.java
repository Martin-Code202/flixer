package o;

import org.json.JSONObject;
/* renamed from: o.ʔ  reason: contains not printable characters */
public final class C0399 extends AbstractC0675 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private float f13349;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f13350;

    public C0399(float f, boolean z) {
        m14630("Volume");
        this.f13349 = f;
        this.f13350 = z;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("muting", this.f13350);
        jSONObject.put("level", (double) this.f13349);
        return jSONObject;
    }
}
