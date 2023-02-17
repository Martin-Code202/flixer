package o;

import org.json.JSONObject;
/* renamed from: o.ϲ  reason: contains not printable characters */
public final class C0478 implements AbstractC0503 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0484[] f13544;

    public C0478(C0484[] r1) {
        this.f13544 = r1;
    }

    @Override // o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.f13544 != null) {
            C0484[] r3 = this.f13544;
            for (C0484 r6 : r3) {
                if (!(r6 == null || r6.f13562 == null)) {
                    jSONObject.put(r6.f13562, r6.f13563);
                }
            }
        }
        return jSONObject;
    }
}
