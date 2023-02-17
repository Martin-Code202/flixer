package o;

import org.json.JSONObject;
/* renamed from: o.gb  reason: case insensitive filesystem */
public final class C1816gb extends AbstractC1824gj {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static String f6942 = "ancestorVideoType";

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String f6943 = "title";

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String f6944 = "ancestorVideoId";

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String f6945 = "videoId";

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f6946;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6947;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6948;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f6949;

    public C1816gb(JSONObject jSONObject) {
        super("PIN_VERIFICATION_SHOW");
        this.f6947 = jSONObject.optString(f6943);
        this.f6946 = jSONObject.optInt(f6945, -1);
        this.f6949 = jSONObject.optInt(f6944, -1);
        this.f6948 = jSONObject.optString(f6942);
        this.f6980 = jSONObject;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m6645() {
        return this.f6947;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m6648() {
        return this.f6946;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m6646() {
        return this.f6949;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m6647() {
        return this.f6948;
    }
}
