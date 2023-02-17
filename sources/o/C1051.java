package o;

import org.json.JSONObject;
/* renamed from: o.ℴ  reason: contains not printable characters */
public final class C1051 extends AbstractC0401 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f15190;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f15191;

    public C1051(float f, boolean z, String str) {
        super(f);
        m14630("KeyboardInput");
        this.f15190 = z;
        this.f15191 = str;
    }

    @Override // o.AbstractC0401, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("isHotKey", this.f15190);
        m14626(jSONObject, "keyCode", this.f15191);
        return jSONObject;
    }
}
