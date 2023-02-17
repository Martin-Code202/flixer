package o;

import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ס  reason: contains not printable characters */
public class C0561 extends AbstractC0537 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private JSONObject f13804;

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m14639() {
        try {
            return this.f13804.getInt("streamingBitrate");
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
