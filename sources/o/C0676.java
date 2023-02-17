package o;

import java.util.List;
import org.json.JSONObject;
/* renamed from: o.ก  reason: contains not printable characters */
public final class C0676 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final List<C0926> f14105;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final JSONObject f14106;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0433 f14107;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0676)) {
            return false;
        }
        C0676 r2 = (C0676) obj;
        return C1457Fr.m5018(this.f14107, r2.f14107) && C1457Fr.m5018(this.f14105, r2.f14105) && C1457Fr.m5018(this.f14106, r2.f14106);
    }

    public int hashCode() {
        C0433 r0 = this.f14107;
        int hashCode = (r0 != null ? r0.hashCode() : 0) * 31;
        List<C0926> list = this.f14105;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        JSONObject jSONObject = this.f14106;
        return hashCode2 + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "NetflixLottieComposition(composition=" + this.f14107 + ", tapList=" + this.f14105 + ", sourceJson=" + this.f14106 + ")";
    }

    public C0676(C0433 r2, List<C0926> list, JSONObject jSONObject) {
        C1457Fr.m5025(r2, "composition");
        C1457Fr.m5025(list, "tapList");
        C1457Fr.m5025(jSONObject, "sourceJson");
        this.f14107 = r2;
        this.f14105 = list;
        this.f14106 = jSONObject;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final C0433 m14912() {
        return this.f14107;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final List<C0926> m14913() {
        return this.f14105;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final JSONObject m14914() {
        return this.f14106;
    }
}
