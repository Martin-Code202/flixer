package o;

import org.json.JSONException;
import org.json.JSONObject;
public class jQ {

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f7974;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f7975;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f7976;

    public jQ(String str) {
        this.f7975 = str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7968(int i, long j) {
        this.f7976 += i;
        this.f7974 += j;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public JSONObject m7967() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("decName", this.f7975);
            jSONObject.put("droppedFrames", this.f7976);
            jSONObject.put("elapsedTime", this.f7974);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
