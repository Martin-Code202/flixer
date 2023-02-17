package o;

import o.C0761;
import o.C0984;
import org.json.JSONObject;
/* renamed from: o.ː  reason: contains not printable characters */
public class C0438 implements AbstractC0342 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0761 f13471;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0984 f13472;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f13473;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0761 f13474;

    C0438(String str, C0761 r2, C0761 r3, C0984 r4) {
        this.f13473 = str;
        this.f13474 = r2;
        this.f13471 = r3;
        this.f13472 = r4;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m14287() {
        return this.f13473;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0761 m14286() {
        return this.f13474;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0761 m14285() {
        return this.f13471;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0984 m14288() {
        return this.f13472;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return new C0435(aux, r3, this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ː$ˊ  reason: contains not printable characters */
    public static final class C0439 {
        /* renamed from: ˋ  reason: contains not printable characters */
        static C0438 m14289(JSONObject jSONObject, C0433 r7) {
            return new C0438(jSONObject.optString("nm"), C0761.Cif.m15192(jSONObject.optJSONObject("c"), r7, false), C0761.Cif.m15192(jSONObject.optJSONObject("o"), r7, false), C0984.C0985.m15921(jSONObject.optJSONObject("tr"), r7));
        }
    }
}
