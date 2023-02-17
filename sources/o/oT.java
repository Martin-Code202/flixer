package o;

import com.netflix.model.leafs.PostPlayItem;
import org.json.JSONException;
import org.json.JSONObject;
public class oT {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f9235;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C0162[] f9236;

    /* renamed from: o.oT$ˊ  reason: contains not printable characters */
    public class C0162 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f9237;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f9238;

        C0162(String str, String str2) {
            this.f9237 = str;
            this.f9238 = str2;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public String m9583() {
            return this.f9237;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public boolean m9584() {
            if (null != this.f9238) {
                return this.f9238.contains(PostPlayItem.POST_PLAY_ITEM_EPISODE);
            }
            return false;
        }
    }

    public oT(String str) {
        C1283.m16862(oT.class.getSimpleName(), str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f9235 = jSONObject.optString("state");
            JSONObject jSONObject2 = jSONObject.getJSONObject("title");
            String optString = jSONObject2.optString("id");
            String optString2 = jSONObject2.optString("type");
            this.f9236 = new C0162[1];
            this.f9236[0] = new C0162(optString, optString2);
        } catch (JSONException e) {
            C1283.m16850(oT.class.getSimpleName(), "JSON error " + str);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0162[] m9582() {
        return this.f9236;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m9581() {
        return "POST_PLAY_COUNTDOWN".equals(this.f9235);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m9580() {
        return "POST_PLAY_PROMPT".equals(this.f9235);
    }
}
