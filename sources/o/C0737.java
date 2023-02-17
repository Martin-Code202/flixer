package o;

import java.util.List;
import o.AbstractC0923;
import o.C0987;
import o.C1249;
import org.json.JSONObject;
/* renamed from: o.ᐡ  reason: contains not printable characters */
public class C0737 extends AbstractC0864<C1249, C1249> {
    C0737(List<C1297AUx<C1249>> list, C1249 r2) {
        super(list, r2);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0539 mo14241() {
        return new C0539(this.f14717);
    }

    /* renamed from: o.ᐡ$If */
    public static final class If {
        /* renamed from: ˏ  reason: contains not printable characters */
        public static C0737 m15112(JSONObject jSONObject, C0433 r5) {
            if (jSONObject != null && jSONObject.has("x")) {
                r5.m14262("Lottie doesn't support expressions.");
            }
            C0987.C0988 r3 = C0987.m15927(jSONObject, 1.0f, r5, Cif.f14308).m15931();
            return new C0737(r3.f15050, r3.f15049);
        }
    }

    /* renamed from: o.ᐡ$if  reason: invalid class name */
    static class Cif implements AbstractC0923.Cif<C1249> {

        /* renamed from: ˋ  reason: contains not printable characters */
        private static final Cif f14308 = new Cif();

        private Cif() {
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public C1249 mo14319(Object obj, float f) {
            return C1249.iF.m16620((JSONObject) obj);
        }
    }
}
