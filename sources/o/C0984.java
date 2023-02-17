package o;

import android.graphics.PointF;
import android.util.Log;
import java.util.Collections;
import o.C0747;
import o.C0750;
import o.C0761;
import org.json.JSONObject;
/* renamed from: o.ᴶ  reason: contains not printable characters */
public class C0984 implements AbstractC0342 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C0761 f15032;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0761 f15033;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1019 f15034;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C0761 f15035;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0747 f15036;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC0923<PointF, PointF> f15037;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0750 f15038;

    private C0984(C1019 r1, AbstractC0923<PointF, PointF> r2, C0750 r3, C0761 r4, C0747 r5, C0761 r6, C0761 r7) {
        this.f15034 = r1;
        this.f15037 = r2;
        this.f15038 = r3;
        this.f15035 = r4;
        this.f15036 = r5;
        this.f15033 = r6;
        this.f15032 = r7;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1019 m15916() {
        return this.f15034;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC0923<PointF, PointF> m15917() {
        return this.f15037;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0750 m15915() {
        return this.f15038;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0761 m15918() {
        return this.f15035;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0747 m15919() {
        return this.f15036;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public C0761 m15913() {
        return this.f15033;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public C0761 m15914() {
        return this.f15032;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public C1164 m15920() {
        return new C1164(this);
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return null;
    }

    /* renamed from: o.ᴶ$ˊ  reason: contains not printable characters */
    public static class C0985 {
        /* renamed from: ॱ  reason: contains not printable characters */
        public static C0984 m15923() {
            return new C0984(new C1019(), new C1019(), C0750.If.m15169(), C0761.Cif.m15190(), C0747.C0749.m15167(), C0761.Cif.m15190(), C0761.Cif.m15190());
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static C0984 m15921(JSONObject jSONObject, C0433 r24) {
            C1019 r9;
            C0750 r11;
            C0747 r13;
            AbstractC0923<PointF, PointF> r10 = null;
            C0761 r12 = null;
            C0761 r14 = null;
            C0761 r15 = null;
            JSONObject optJSONObject = jSONObject.optJSONObject("a");
            if (optJSONObject != null) {
                r9 = new C1019(optJSONObject.opt("k"), r24);
            } else {
                Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
                r9 = new C1019();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("p");
            if (optJSONObject2 != null) {
                r10 = C1019.m15982(optJSONObject2, r24);
            } else {
                m15922("position");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
            if (optJSONObject3 != null) {
                r11 = C0750.If.m15168(optJSONObject3, r24);
            } else {
                r11 = new C0750(Collections.emptyList(), new C0736());
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("r");
            if (optJSONObject4 == null) {
                optJSONObject4 = jSONObject.optJSONObject("rz");
            }
            if (optJSONObject4 != null) {
                r12 = C0761.Cif.m15192(optJSONObject4, r24, false);
            } else {
                m15922("rotation");
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("o");
            if (optJSONObject5 != null) {
                r13 = C0747.C0749.m15166(optJSONObject5, r24);
            } else {
                r13 = new C0747(Collections.emptyList(), 100);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("so");
            if (optJSONObject6 != null) {
                r14 = C0761.Cif.m15192(optJSONObject6, r24, false);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("eo");
            if (optJSONObject7 != null) {
                r15 = C0761.Cif.m15192(optJSONObject7, r24, false);
            }
            return new C0984(r9, r10, r11, r12, r13, r14, r15);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private static void m15922(String str) {
            throw new IllegalArgumentException("Missing transform for " + str);
        }
    }
}
