package o;

import org.json.JSONObject;
/* renamed from: o.ˎ  reason: contains not printable characters */
public class C0436 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f13467;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f13468;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f13469;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f13470;

    private C0436(int i, int i2, String str, String str2) {
        this.f13469 = i;
        this.f13468 = i2;
        this.f13467 = str;
        this.f13470 = str2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ˎ$If */
    public static class If {
        /* renamed from: ˊ  reason: contains not printable characters */
        static C0436 m14284(JSONObject jSONObject) {
            return new C0436(jSONObject.optInt("w"), jSONObject.optInt("h"), jSONObject.optString("id"), jSONObject.optString("p"));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m14283() {
        return this.f13467;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m14282() {
        return this.f13470;
    }
}
