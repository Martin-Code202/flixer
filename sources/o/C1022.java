package o;

import android.graphics.PointF;
import o.C0740;
import o.C0761;
import org.json.JSONObject;
/* renamed from: o.ᵗ  reason: contains not printable characters */
public class C1022 implements AbstractC0342 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC0923<PointF, PointF> f15117;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f15118;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0761 f15119;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0740 f15120;

    private C1022(String str, AbstractC0923<PointF, PointF> r2, C0740 r3, C0761 r4) {
        this.f15118 = str;
        this.f15117 = r2;
        this.f15120 = r3;
        this.f15119 = r4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᵗ$if  reason: invalid class name */
    public static class Cif {
        /* renamed from: ˎ  reason: contains not printable characters */
        static C1022 m15992(JSONObject jSONObject, C0433 r7) {
            return new C1022(jSONObject.optString("nm"), C1019.m15982(jSONObject.optJSONObject("p"), r7), C0740.If.m15120(jSONObject.optJSONObject("s"), r7), C0761.Cif.m15191(jSONObject.optJSONObject("r"), r7));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m15990() {
        return this.f15118;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0761 m15988() {
        return this.f15119;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0740 m15991() {
        return this.f15120;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC0923<PointF, PointF> m15989() {
        return this.f15117;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return new C1595cOn(aux, r3, this);
    }

    public String toString() {
        return "RectangleShape{cornerRadius=" + this.f15119.mo15162() + ", position=" + this.f15117 + ", size=" + this.f15120 + '}';
    }
}
