package o;

import android.graphics.PointF;
import java.util.List;
import o.C0987;
import org.json.JSONObject;
/* renamed from: o.ᐣ  reason: contains not printable characters */
public class C0740 extends AbstractC0864<PointF, PointF> {
    private C0740(List<C1297AUx<PointF>> list, PointF pointF) {
        super(list, pointF);
    }

    @Override // o.AbstractC0923
    /* renamed from: ˎ */
    public AbstractC1622coN<PointF, PointF> mo14241() {
        if (!m15557()) {
            return new C0418(this.f14716);
        }
        return new CON(this.f14717);
    }

    /* renamed from: o.ᐣ$If */
    public static final class If {
        /* renamed from: ˋ  reason: contains not printable characters */
        public static C0740 m15120(JSONObject jSONObject, C0433 r6) {
            C0987.C0988 r4 = C0987.m15927(jSONObject, r6.m14266(), r6, C0447.f13486).m15931();
            return new C0740(r4.f15050, r4.f15049);
        }
    }
}
