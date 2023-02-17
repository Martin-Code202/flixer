package o;

import org.json.JSONException;
import org.json.JSONObject;
public class kD {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f8145;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f8146;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int f8147;

    /* renamed from: ˊ  reason: contains not printable characters */
    public final int f8148;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f8149;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f8150;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f8151;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f8152;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f8153;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final boolean f8154;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static kD m8189(JSONObject jSONObject) {
        try {
            return new kD(jSONObject);
        } catch (JSONException e) {
            return null;
        }
    }

    kD(JSONObject jSONObject) {
        this.f8149 = jSONObject.getString("url");
        JSONObject jSONObject2 = jSONObject.getJSONObject("store");
        this.f8150 = jSONObject2.getString("cdn_id");
        this.f8151 = jSONObject2.getString("name");
        this.f8152 = jSONObject2.getInt("rank");
        this.f8153 = jSONObject2.getString("type");
        this.f8154 = jSONObject2.getBoolean("lowgrade");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("location");
        this.f8146 = jSONObject3.getString("id");
        this.f8145 = jSONObject3.getInt("rank");
        this.f8147 = jSONObject3.getInt("level");
        this.f8148 = jSONObject3.getInt("weight");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m8191() {
        return this.f8149;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m8194() {
        return this.f8150;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m8195() {
        return this.f8151;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m8193() {
        return this.f8152;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m8192() {
        return this.f8154;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m8190() {
        return this.f8146;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public int m8197() {
        return this.f8147;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public int m8196() {
        return this.f8148;
    }

    public String toString() {
        return "NetflixLocationInfo{url='" + this.f8149 + "', cdnId='" + this.f8150 + "', cdnName='" + this.f8151 + "', cdnRank=" + this.f8152 + ", cdnType='" + this.f8153 + "', cdnLowgrade=" + this.f8154 + ", locationId='" + this.f8146 + "', locationRank=" + this.f8145 + ", locationLevel=" + this.f8147 + ", locationWeight=" + this.f8148 + '}';
    }
}
