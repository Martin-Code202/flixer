package o;

import com.netflix.cl.Logger;
import com.netflix.cl.model.InputKind;
import org.json.JSONObject;
/* renamed from: o.ᵝ  reason: contains not printable characters */
public final class C1027 extends AbstractC0470 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private InputKind f15135;

    public C1027(InputKind inputKind) {
        m14630("ValidateInput");
        this.f15135 = inputKind;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14628(jSONObject, "inputKind", this.f15135);
        return jSONObject;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C1025 m16017(Long l) {
        if (Logger.INSTANCE.m136() && l == null) {
            return null;
        }
        AbstractC1274 r3 = Logger.INSTANCE.m135(l);
        if (r3 instanceof C1027) {
            return new C1025((C1027) r3);
        }
        C0441.m14304().mo4536("ValidateInputRejected::createSessionEndedEvent: %d does not identifies ValidateInput! It should NOT happen!");
        if (!C0441.m14304().mo4534()) {
            return null;
        }
        throw new IllegalStateException(l + " does not identifies ValidateInput! It should NOT happen!");
    }
}
