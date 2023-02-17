package o;

import com.netflix.mediaclient.service.logging.client.model.Event;
import org.json.JSONObject;
/* renamed from: o.Ꮀ  reason: contains not printable characters */
public abstract class AbstractC0723 extends AbstractC0556 {

    /* renamed from: ˋ  reason: contains not printable characters */
    protected long f14263;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f14264;

    protected AbstractC0723() {
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("time", this.f14263);
        jSONObject.put(Event.SEQUENCE, this.f14264);
        return jSONObject;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m15059() {
        return this.f14263;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo15060() {
        if (!(this.f14264 == 0 && this.f14263 == 0)) {
            C0441.m14295().mo4537("Event used before: " + AbstractC0723.class.getSimpleName());
            if (C0441.m14304().mo4534()) {
                throw new IllegalStateException("This should NOT happen! Event used before: " + AbstractC0723.class.getSimpleName());
            }
        }
        this.f14264 = C0441.m14302();
        this.f14263 = C0441.m14299();
    }
}
