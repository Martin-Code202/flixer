package o;

import org.json.JSONObject;
/* renamed from: o.ᴮ  reason: contains not printable characters */
public final class C0970 extends AbstractC0453 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f14973;

    public C0970(long j, AbstractC0574 r4) {
        super(r4);
        m14630("StartPlay");
        this.f14973 = j;
    }

    @Override // o.AbstractC0453, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("startOffset", this.f14973);
        return jSONObject;
    }
}
