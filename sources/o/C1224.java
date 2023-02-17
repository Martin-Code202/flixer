package o;

import com.netflix.cl.model.AppView;
import org.json.JSONObject;
/* renamed from: o.Ｌ  reason: contains not printable characters */
public final class C1224 extends AbstractC1251 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private AppView f15745;

    public C1224(AbstractC0574 r2, AppView appView) {
        super(r2);
        m14630("Presentation");
        this.f15745 = appView;
    }

    @Override // o.AbstractC1251, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14628(jSONObject, "view", this.f15745);
        return jSONObject;
    }
}
