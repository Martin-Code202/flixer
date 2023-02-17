package o;

import org.json.JSONObject;
/* renamed from: o.ʴ  reason: contains not printable characters */
public class C0413 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f13380;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final float f13381;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f13382;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f13383;

    C0413(String str, String str2, String str3, float f) {
        this.f13383 = str;
        this.f13380 = str2;
        this.f13382 = str3;
        this.f13381 = f;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m14219() {
        return this.f13383;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m14220() {
        return this.f13380;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m14218() {
        return this.f13382;
    }

    /* renamed from: o.ʴ$iF */
    public static class iF {
        /* renamed from: ˎ  reason: contains not printable characters */
        public static C0413 m14221(JSONObject jSONObject) {
            return new C0413(jSONObject.optString("fFamily"), jSONObject.optString("fName"), jSONObject.optString("fStyle"), (float) jSONObject.optDouble("ascent"));
        }
    }
}
