package o;

import java.util.List;
import o.AbstractC0923;
import o.C0987;
import org.json.JSONObject;
/* renamed from: o.ᐩ  reason: contains not printable characters */
public class C0747 extends AbstractC0864<Integer, Integer> {
    private C0747() {
        super(100);
    }

    C0747(List<C1297AUx<Integer>> list, Integer num) {
        super(list, num);
    }

    @Override // o.AbstractC0923
    /* renamed from: ˎ */
    public AbstractC1622coN<Integer, Integer> mo14241() {
        if (!m15557()) {
            return new C0418(this.f14716);
        }
        return new C1371CoN(this.f14717);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Integer mo15162() {
        return (Integer) this.f14716;
    }

    /* renamed from: o.ᐩ$ˋ  reason: contains not printable characters */
    public static final class C0749 {
        /* renamed from: ˋ  reason: contains not printable characters */
        static C0747 m15167() {
            return new C0747();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static C0747 m15166(JSONObject jSONObject, C0433 r5) {
            if (jSONObject != null && jSONObject.has("x")) {
                r5.m14262("Lottie doesn't support expressions.");
            }
            C0987.C0988 r2 = C0987.m15927(jSONObject, 1.0f, r5, C0748.f14360).m15931();
            return new C0747(r2.f15050, r2.f15049);
        }
    }

    /* renamed from: o.ᐩ$ˊ  reason: contains not printable characters */
    static class C0748 implements AbstractC0923.Cif<Integer> {

        /* renamed from: ˋ  reason: contains not printable characters */
        private static final C0748 f14360 = new C0748();

        private C0748() {
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public Integer mo14319(Object obj, float f) {
            return Integer.valueOf(Math.round(C0914.m15715(obj) * f));
        }
    }
}
