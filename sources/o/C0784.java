package o;

import com.netflix.cl.model.ThumbRating;
import org.json.JSONObject;
/* renamed from: o.ᒦ  reason: contains not printable characters */
public final class C0784 extends AbstractC0470 implements AbstractC0514 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private ThumbRating f14441;

    public C0784(ThumbRating thumbRating) {
        m14630("SetThumbRating");
        if (thumbRating == null) {
            this.f14441 = ThumbRating.UNRATED;
        } else {
            this.f14441 = thumbRating;
        }
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("thumbRating", this.f14441.m149());
        return jSONObject;
    }
}
