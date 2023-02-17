package o;

import org.json.JSONObject;
/* renamed from: o.ʷ  reason: contains not printable characters */
public final class C0416 extends AbstractC0401 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f13384;

    public C0416(float f, String str) {
        super(f);
        m14630("VoiceInput");
        this.f13384 = str;
    }

    @Override // o.AbstractC0401, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "phrase", this.f13384);
        return jSONObject;
    }
}
