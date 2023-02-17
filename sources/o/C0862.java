package o;

import android.graphics.PointF;
import o.C0740;
import org.json.JSONObject;
/* renamed from: o.ᔇ  reason: contains not printable characters */
public class C0862 implements AbstractC0342 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC0923<PointF, PointF> f14713;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0740 f14714;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f14715;

    private C0862(String str, AbstractC0923<PointF, PointF> r2, C0740 r3) {
        this.f14715 = str;
        this.f14713 = r2;
        this.f14714 = r3;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return new C1320AuX(aux, r3, this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᔇ$ˊ  reason: contains not printable characters */
    public static class C0863 {
        /* renamed from: ˎ  reason: contains not printable characters */
        static C0862 m15556(JSONObject jSONObject, C0433 r6) {
            return new C0862(jSONObject.optString("nm"), C1019.m15982(jSONObject.optJSONObject("p"), r6), C0740.If.m15120(jSONObject.optJSONObject("s"), r6));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m15555() {
        return this.f14715;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public AbstractC0923<PointF, PointF> m15553() {
        return this.f14713;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0740 m15554() {
        return this.f14714;
    }
}
