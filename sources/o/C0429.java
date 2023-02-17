package o;

import java.util.List;
import o.C0987;
import org.json.JSONObject;
/* renamed from: o.ˇ  reason: contains not printable characters */
public class C0429 extends AbstractC0864<Integer, Integer> {
    private C0429(List<C1297AUx<Integer>> list, Integer num) {
        super(list, num);
    }

    @Override // o.AbstractC0923
    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC1622coN<Integer, Integer> mo14241() {
        if (!m15557()) {
            return new C0418(this.f14716);
        }
        return new C0583(this.f14717);
    }

    @Override // o.AbstractC0864
    public String toString() {
        return "AnimatableColorValue{initialValue=" + this.f14716 + '}';
    }

    /* renamed from: o.ˇ$iF */
    public static final class iF {
        /* renamed from: ˊ  reason: contains not printable characters */
        public static C0429 m14242(JSONObject jSONObject, C0433 r6) {
            C0987.C0988 r4 = C0987.m15927(jSONObject, 1.0f, r6, C1012.f15096).m15931();
            return new C0429(r4.f15050, r4.f15049);
        }
    }
}
