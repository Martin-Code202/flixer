package o;

import org.json.JSONObject;
/* renamed from: o.ᵩ  reason: contains not printable characters */
public class C1042 extends AbstractC0715 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f15157;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f15158;

    public C1042(long j, boolean z, AbstractC0574 r5) {
        super(r5);
        m14630("PushNotificationPresented");
        this.f15158 = j;
        this.f15157 = z;
    }

    @Override // o.AbstractC0715, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("presentedTime", this.f15158);
        jSONObject.put("deviceHasNotificationSound", this.f15157);
        return jSONObject;
    }
}
