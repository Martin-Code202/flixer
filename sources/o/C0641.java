package o;

import org.json.JSONArray;
/* renamed from: o.ܢ  reason: contains not printable characters */
public class C0641 implements AbstractC0615 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC0556 f13961;

    public C0641(AbstractC0556 r4) {
        C0441.m14304().mo4533("" + r4);
        this.f13961 = r4;
    }

    @Override // o.AbstractC0615
    /* renamed from: ˋ */
    public JSONArray mo14655(JSONArray jSONArray) {
        jSONArray.put(this.f13961.toJSONObject());
        return jSONArray;
    }
}
