package o;

import android.graphics.Path;
import o.C0429;
import o.C0747;
import org.json.JSONObject;
/* renamed from: o.ʲ  reason: contains not printable characters */
public class C0410 implements AbstractC0342 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Path.FillType f13373;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C0429 f13374;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f13375;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0747 f13376;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final boolean f13377;

    private C0410(String str, boolean z, Path.FillType fillType, C0429 r4, C0747 r5) {
        this.f13375 = str;
        this.f13377 = z;
        this.f13373 = fillType;
        this.f13374 = r4;
        this.f13376 = r5;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ʲ$ˊ  reason: contains not printable characters */
    public static class C0411 {
        /* renamed from: ˋ  reason: contains not printable characters */
        static C0410 m14215(JSONObject jSONObject, C0433 r16) {
            C0429 r7 = null;
            C0747 r9 = null;
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("c");
            if (optJSONObject != null) {
                r7 = C0429.iF.m14242(optJSONObject, r16);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            if (optJSONObject2 != null) {
                r9 = C0747.C0749.m15166(optJSONObject2, r16);
            }
            return new C0410(optString, jSONObject.optBoolean("fillEnabled"), jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, r7, r9);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m14211() {
        return this.f13375;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0429 m14214() {
        return this.f13374;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0747 m14212() {
        return this.f13376;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Path.FillType m14213() {
        return this.f13373;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return new C0422(aux, r3, this);
    }

    public String toString() {
        String str;
        Object obj;
        StringBuilder append = new StringBuilder().append("ShapeFill{color=");
        if (this.f13374 == null) {
            str = "null";
        } else {
            str = Integer.toHexString(((Integer) this.f13374.mo15162()).intValue());
        }
        StringBuilder append2 = append.append(str).append(", fillEnabled=").append(this.f13377).append(", opacity=");
        if (this.f13376 == null) {
            obj = "null";
        } else {
            obj = this.f13376.mo15162();
        }
        return append2.append(obj).append('}').toString();
    }
}
