package o;

import java.util.List;
import o.AbstractC0923;
import o.C0987;
import org.json.JSONObject;
/* renamed from: o.ᑊ  reason: contains not printable characters */
public class C0761 extends AbstractC0864<Float, Float> {
    private C0761() {
        super(Float.valueOf(0.0f));
    }

    private C0761(List<C1297AUx<Float>> list, Float f) {
        super(list, f);
    }

    @Override // o.AbstractC0923
    /* renamed from: ˎ */
    public AbstractC1622coN<Float, Float> mo14241() {
        if (!m15557()) {
            return new C0418(this.f14716);
        }
        return new C1594cON(this.f14717);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Float mo15162() {
        return (Float) this.f14716;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᑊ$ˊ  reason: contains not printable characters */
    public static class C0762 implements AbstractC0923.Cif<Float> {

        /* renamed from: ˊ  reason: contains not printable characters */
        static final C0762 f14381 = new C0762();

        private C0762() {
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public Float mo14319(Object obj, float f) {
            return Float.valueOf(C0914.m15715(obj) * f);
        }
    }

    /* renamed from: o.ᑊ$if  reason: invalid class name */
    public static final class Cif {
        /* renamed from: ˊ  reason: contains not printable characters */
        static C0761 m15190() {
            return new C0761();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static C0761 m15191(JSONObject jSONObject, C0433 r2) {
            return m15192(jSONObject, r2, true);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public static C0761 m15192(JSONObject jSONObject, C0433 r7, boolean z) {
            float r4 = z ? r7.m14266() : 1.0f;
            if (jSONObject != null && jSONObject.has("x")) {
                r7.m14262("Lottie doesn't support expressions.");
            }
            C0987.C0988 r5 = C0987.m15927(jSONObject, r4, r7, C0762.f14381).m15931();
            return new C0761(r5.f15050, r5.f15049);
        }
    }
}
