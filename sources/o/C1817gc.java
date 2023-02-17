package o;

import org.json.JSONObject;
/* renamed from: o.gc  reason: case insensitive filesystem */
public final class C1817gc extends AbstractC1824gj {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String f6950 = "transactionId";

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String f6951 = "errorCode";

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String f6952 = "errorDesc";

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6953;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6954;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6955;

    public C1817gc(JSONObject jSONObject) {
        super("MESSAGE_IGNORED");
        this.f6955 = jSONObject.getString(f6950);
        this.f6953 = jSONObject.getString(f6951);
        this.f6954 = AK.m3376(jSONObject, f6952, (String) null);
    }
}
