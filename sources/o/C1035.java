package o;

import o.C0429;
import o.C0761;
import org.json.JSONObject;
/* renamed from: o.ᵣ  reason: contains not printable characters */
public class C1035 {

    /* renamed from: ˊ  reason: contains not printable characters */
    public final C0429 f15149;

    /* renamed from: ˋ  reason: contains not printable characters */
    public final C0761 f15150;

    /* renamed from: ˏ  reason: contains not printable characters */
    public final C0761 f15151;

    /* renamed from: ॱ  reason: contains not printable characters */
    public final C0429 f15152;

    C1035(C0429 r1, C0429 r2, C0761 r3, C0761 r4) {
        this.f15149 = r1;
        this.f15152 = r2;
        this.f15151 = r3;
        this.f15150 = r4;
    }

    /* renamed from: o.ᵣ$if  reason: invalid class name */
    public static final class Cif {
        /* renamed from: ˊ  reason: contains not printable characters */
        public static C1035 m16042(JSONObject jSONObject, C0433 r15) {
            if (jSONObject == null || !jSONObject.has("a")) {
                return new C1035(null, null, null, null);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("a");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("fc");
            C0429 r7 = null;
            if (optJSONObject2 != null) {
                r7 = C0429.iF.m14242(optJSONObject2, r15);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("sc");
            C0429 r9 = null;
            if (optJSONObject3 != null) {
                r9 = C0429.iF.m14242(optJSONObject3, r15);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("sw");
            C0761 r11 = null;
            if (optJSONObject4 != null) {
                r11 = C0761.Cif.m15191(optJSONObject4, r15);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("t");
            C0761 r13 = null;
            if (optJSONObject5 != null) {
                r13 = C0761.Cif.m15191(optJSONObject5, r15);
            }
            return new C1035(r7, r9, r11, r13);
        }
    }
}
