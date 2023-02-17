package o;

import com.netflix.cl.Logger;
import java.util.UUID;
import org.json.JSONObject;
/* renamed from: o.ч  reason: contains not printable characters */
public final class C0504 extends AbstractC0470 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f13625;

    /* renamed from: ॱ  reason: contains not printable characters */
    private UUID f13626;

    public C0504(UUID uuid, String str) {
        m14630("cs.Call");
        this.f13626 = uuid;
        this.f13625 = str;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        if (this.f13626 != null) {
            jSONObject.put("sharedUuid", this.f13626.toString());
        }
        if (this.f13625 != null) {
            jSONObject.put("codec", this.f13625);
        }
        return jSONObject;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0599 m14486(Long l, JSONObject jSONObject) {
        if (Logger.INSTANCE.m136() && l == null) {
            return null;
        }
        AbstractC1274 r3 = Logger.INSTANCE.m135(l);
        if (r3 instanceof C0504) {
            return new C0599((C0504) r3, jSONObject);
        }
        C0441.m14304().mo4536("CallEnded::createSessionEndedEvent: %d does not identifies AddProfile! It should NOT happen!");
        if (!C0441.m14304().mo4534()) {
            return null;
        }
        throw new IllegalStateException(l + " does not identifies AddProfile! It should NOT happen!");
    }
}
