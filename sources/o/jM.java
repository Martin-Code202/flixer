package o;

import org.json.JSONArray;
import org.json.JSONObject;
public final class jM implements Comparable<jM> {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String[] f7967;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f7968;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f7969;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f7970;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f7971;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f7972;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final long f7973;

    public jM(JSONObject jSONObject) {
        this.f7968 = AK.m3376(jSONObject, "downloadable_id", (String) null);
        this.f7973 = AK.m3388(jSONObject, "size", -1);
        this.f7970 = AK.m3386(jSONObject, "width", 0);
        this.f7971 = AK.m3386(jSONObject, "height", 0);
        this.f7972 = AK.m3386(jSONObject, "aspectX", 0);
        this.f7969 = AK.m3386(jSONObject, "aspectY", 0);
        JSONArray r3 = AK.m3377(jSONObject, "urls");
        if (null != r3) {
            this.f7967 = new String[r3.length()];
            for (int i = 0; i < r3.length(); i++) {
                this.f7967[i] = r3.getString(i);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public float m7962() {
        if (this.f7969 != 0) {
            return (float) (this.f7972 / this.f7969);
        }
        return 0.0f;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String[] m7965() {
        return this.f7967;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m7963() {
        return this.f7968 != null && this.f7967 != null && this.f7967.length > 0 && C1349Bv.m4107(this.f7967[0]);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m7964() {
        return this.f7968;
    }

    @Override // java.lang.Object
    public String toString() {
        return "TrickplayUrl: width=" + this.f7970 + ", height=" + this.f7971 + " aspect=" + (((float) this.f7972) / ((float) this.f7969)) + ", url:" + this.f7967;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int compareTo(jM jMVar) {
        if (this == jMVar) {
            return 0;
        }
        return 1;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m7961() {
        return this.f7973;
    }
}
