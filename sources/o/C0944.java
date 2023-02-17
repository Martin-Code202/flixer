package o;

import com.netflix.cl.model.GestureInputKind;
import org.json.JSONObject;
/* renamed from: o.ᴄ  reason: contains not printable characters */
public class C0944 extends AbstractC0401 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private GestureInputKind f14842;

    public C0944(float f, GestureInputKind gestureInputKind) {
        super(f);
        m14630("GestureInput");
        this.f14842 = gestureInputKind;
    }

    @Override // o.AbstractC0401, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14628(jSONObject, "gesture", this.f14842);
        return jSONObject;
    }
}
