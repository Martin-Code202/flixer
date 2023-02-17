package o;

import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import org.json.JSONObject;
/* renamed from: o.ﾍ  reason: contains not printable characters */
public class C1275 extends AbstractC0723 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f15972;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected String f15973;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected long f15974;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long f15975;

    public C1275(AbstractC1274 r3) {
        if (r3 == null) {
            throw new IllegalArgumentException("Session can not be null!");
        }
        this.f15972 = r3.m15059();
        this.f15975 = r3.m16816();
        this.f15973 = r3.m16817();
        m14630("SessionEnded");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m16818() {
        return this.f15975;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m16819() {
        return this.f15973;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put(SessionEndedEvent.DURATION, this.f15974);
        jSONObject.put("sessionId", this.f15975);
        return jSONObject;
    }

    @Override // o.AbstractC0723
    /* renamed from: ˏ */
    public void mo15060() {
        super.mo15060();
        if (this.f15974 != 0) {
            C0441.m14295().mo4537("Event used before: " + AbstractC0723.class.getSimpleName());
            if (C0441.m14304().mo4534()) {
                throw new IllegalStateException("This should NOT happen! Session ended event used before: " + AbstractC0723.class.getSimpleName() + ", duration was: " + this.f15974);
            }
        }
        this.f15974 = this.f14263 - this.f15972;
    }
}
