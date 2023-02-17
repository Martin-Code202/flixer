package o;

import android.graphics.Color;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ｰ  reason: contains not printable characters */
public class C1249 {

    /* renamed from: ʻ  reason: contains not printable characters */
    public int f15811;

    /* renamed from: ʼ  reason: contains not printable characters */
    public int f15812;

    /* renamed from: ʽ  reason: contains not printable characters */
    double f15813;

    /* renamed from: ˊ  reason: contains not printable characters */
    public int f15814;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String f15815;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String f15816;

    /* renamed from: ˏ  reason: contains not printable characters */
    public int f15817;

    /* renamed from: ॱ  reason: contains not printable characters */
    int f15818;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public int f15819;

    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean f15820;

    C1249(String str, String str2, int i, int i2, int i3, double d, int i4, int i5, int i6, boolean z) {
        this.f15815 = str;
        this.f15816 = str2;
        this.f15814 = i;
        this.f15818 = i2;
        this.f15817 = i3;
        this.f15813 = d;
        this.f15812 = i4;
        this.f15819 = i5;
        this.f15811 = i6;
        this.f15820 = z;
    }

    /* renamed from: o.ｰ$iF */
    public static final class iF {
        /* renamed from: ˎ  reason: contains not printable characters */
        public static C1249 m16620(JSONObject jSONObject) {
            String optString = jSONObject.optString("t");
            String optString2 = jSONObject.optString("f");
            int optInt = jSONObject.optInt("s");
            int optInt2 = jSONObject.optInt("j");
            int optInt3 = jSONObject.optInt("tr");
            double optDouble = jSONObject.optDouble("lh");
            JSONArray optJSONArray = jSONObject.optJSONArray("fc");
            int argb = Color.argb(255, (int) (optJSONArray.optDouble(0) * 255.0d), (int) (optJSONArray.optDouble(1) * 255.0d), (int) (optJSONArray.optDouble(2) * 255.0d));
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sc");
            int i = 0;
            if (optJSONArray2 != null) {
                i = Color.argb(255, (int) (optJSONArray2.optDouble(0) * 255.0d), (int) (optJSONArray2.optDouble(1) * 255.0d), (int) (optJSONArray2.optDouble(2) * 255.0d));
            }
            return new C1249(optString, optString2, optInt, optInt2, optInt3, optDouble, argb, i, jSONObject.optInt("sw"), jSONObject.optBoolean("of"));
        }
    }

    public int hashCode() {
        int hashCode = (((((((this.f15815.hashCode() * 31) + this.f15816.hashCode()) * 31) + this.f15814) * 31) + this.f15818) * 31) + this.f15817;
        long doubleToLongBits = Double.doubleToLongBits(this.f15813);
        return (((hashCode * 31) + ((int) ((doubleToLongBits >>> 32) ^ doubleToLongBits))) * 31) + this.f15812;
    }
}
