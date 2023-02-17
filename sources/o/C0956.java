package o;

import org.json.JSONObject;
/* renamed from: o.ᴛ  reason: contains not printable characters */
public final class C0956 extends AbstractC0675 implements AbstractC0514 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f14863;

    public C0956(String str) {
        m14630("FtlConnection");
        this.f14863 = str;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "via", this.f14863);
        return jSONObject;
    }
}
