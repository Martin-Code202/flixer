package o;

import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.cl  reason: case insensitive filesystem */
public class C1618cl {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f6268 = C1618cl.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f6269;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f6270;

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f6271;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6272;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6273;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6274;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f6275;

    public C1618cl(String str, String str2, long j, String str3, int i, int i2, int i3) {
        this.f6272 = str;
        this.f6273 = str2;
        this.f6271 = j;
        this.f6274 = str3;
        this.f6275 = i;
        this.f6270 = i2;
        this.f6269 = i3;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C1618cl m5855(pV pVVar) {
        return new C1618cl(pVVar.mo6913(), pVVar.mo6883(), pVVar.mo6908(), pVVar.mo6910(), pVVar.mo6907(), pVVar.mo6897(), pVVar.mo6892());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m5860() {
        return this.f6272;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m5861() {
        return this.f6274;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m5858() {
        return this.f6273;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m5862() {
        return this.f6275;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m5859() {
        return this.f6270;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public int m5857() {
        return this.f6269;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public long m5863() {
        return this.f6271;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public JSONObject m5856() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("track_id", m5862());
            jSONObject.put("rank", m5859());
            jSONObject.put("row", m5857());
            jSONObject.put("profile_guid", m5858());
            jSONObject.put("request_id", m5861());
            jSONObject.put("oxid", m5860());
            jSONObject.put("download_utc_sec", m5863() / 1000);
        } catch (JSONException e) {
            C1283.m16847(f6268, "downloadContext jsonObject", e);
        }
        return jSONObject;
    }

    public String toString() {
        return "DownloadContext{oxid='" + this.f6272 + "', profileGuid='" + this.f6273 + "', downloadInitTimeMs=" + this.f6271 + ", requestId='" + this.f6274 + "', trackId=" + this.f6275 + ", videoPos=" + this.f6270 + ", listPos=" + this.f6269 + '}';
    }
}
