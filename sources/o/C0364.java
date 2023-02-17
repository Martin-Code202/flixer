package o;

import o.C0814;
import org.json.JSONObject;
/* renamed from: o.ǃ  reason: contains not printable characters */
public class C0364 implements AbstractC0342 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f13189;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f13190;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0814 f13191;

    private C0364(String str, int i, C0814 r3) {
        this.f13189 = str;
        this.f13190 = i;
        this.f13191 = r3;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m14064() {
        return this.f13189;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0814 m14063() {
        return this.f13191;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return new C0434(aux, r3, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.f13189 + ", index=" + this.f13190 + ", hasAnimation=" + this.f13191.m15557() + '}';
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ǃ$if  reason: invalid class name */
    public static class Cif {
        /* renamed from: ˋ  reason: contains not printable characters */
        static C0364 m14065(JSONObject jSONObject, C0433 r6) {
            return new C0364(jSONObject.optString("nm"), jSONObject.optInt("ind"), C0814.iF.m15384(jSONObject.optJSONObject("ks"), r6));
        }
    }
}
