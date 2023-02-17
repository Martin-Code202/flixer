package o;

import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ˆ  reason: contains not printable characters */
public class C0428 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f13421;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f13422;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f13423;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final char f13424;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<C0551> f13425;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final double f13426;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m14237(char c, String str, String str2) {
        return ((((c + 0) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    C0428(List<C0551> list, char c, int i, double d, String str, String str2) {
        this.f13425 = list;
        this.f13424 = c;
        this.f13422 = i;
        this.f13426 = d;
        this.f13423 = str;
        this.f13421 = str2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public List<C0551> m14238() {
        return this.f13425;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public double m14239() {
        return this.f13426;
    }

    /* renamed from: o.ˆ$iF */
    public static class iF {
        /* renamed from: ˏ  reason: contains not printable characters */
        public static C0428 m14240(JSONObject jSONObject, C0433 r19) {
            JSONArray optJSONArray;
            char charAt = jSONObject.optString("ch").charAt(0);
            int optInt = jSONObject.optInt("size");
            double optDouble = jSONObject.optDouble("w");
            String optString = jSONObject.optString("style");
            String optString2 = jSONObject.optString("fFamily");
            JSONObject optJSONObject = jSONObject.optJSONObject(Event.DATA);
            List emptyList = Collections.emptyList();
            if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("shapes")) == null)) {
                emptyList = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    emptyList.add((C0551) C0551.m14596(optJSONArray.optJSONObject(i), r19));
                }
            }
            return new C0428(emptyList, charAt, optInt, optDouble, optString, optString2);
        }
    }

    public int hashCode() {
        return m14237(this.f13424, this.f13421, this.f13423);
    }
}
