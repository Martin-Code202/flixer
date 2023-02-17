package o;

import org.json.JSONObject;
/* renamed from: o.fT  reason: case insensitive filesystem */
public class C1760fT extends AbstractC1824gj {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String f6714 = "uid";

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6715;

    public C1760fT(JSONObject jSONObject) {
        super("DIALOG_CANCEL");
        this.f6715 = jSONObject.getString(f6714);
        this.f6980 = jSONObject;
    }
}
