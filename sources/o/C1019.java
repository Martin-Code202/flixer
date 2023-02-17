package o;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC0923;
import o.C0761;
import o.C1161;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ᵕ  reason: contains not printable characters */
public class C1019 implements AbstractC0923<PointF, PointF> {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final List<C1161> f15114;

    /* renamed from: ॱ  reason: contains not printable characters */
    private PointF f15115;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static AbstractC0923<PointF, PointF> m15982(JSONObject jSONObject, C0433 r4) {
        if (jSONObject.has("k")) {
            return new C1019(jSONObject.opt("k"), r4);
        }
        return new C0735(C0761.Cif.m15191(jSONObject.optJSONObject("x"), r4), C0761.Cif.m15191(jSONObject.optJSONObject("y"), r4));
    }

    C1019() {
        this.f15114 = new ArrayList();
        this.f15115 = new PointF(0.0f, 0.0f);
    }

    C1019(Object obj, C0433 r9) {
        this.f15114 = new ArrayList();
        if (m15983(obj)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                this.f15114.add(C1161.C1162.m16351(jSONArray.optJSONObject(i), r9, C1020.f15116));
            }
            C1297AUx.m3439(this.f15114);
            return;
        }
        this.f15115 = C0914.m15714((JSONArray) obj, r9.m14266());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m15983(Object obj) {
        if (!(obj instanceof JSONArray)) {
            return false;
        }
        Object opt = ((JSONArray) obj).opt(0);
        return (opt instanceof JSONObject) && ((JSONObject) opt).has("t");
    }

    @Override // o.AbstractC0923
    /* renamed from: ˎ */
    public AbstractC1622coN<PointF, PointF> mo14241() {
        if (!m15984()) {
            return new C0418(this.f15115);
        }
        return new C1286(this.f15114);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m15984() {
        return !this.f15114.isEmpty();
    }

    public String toString() {
        return "initialPoint=" + this.f15115;
    }

    /* renamed from: o.ᵕ$ˋ  reason: contains not printable characters */
    static class C1020 implements AbstractC0923.Cif<PointF> {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static final AbstractC0923.Cif<PointF> f15116 = new C1020();

        private C1020() {
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public PointF mo14319(Object obj, float f) {
            return C0914.m15714((JSONArray) obj, f);
        }
    }
}
