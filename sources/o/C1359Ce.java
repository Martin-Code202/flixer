package o;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.Ce  reason: case insensitive filesystem */
public class C1359Ce implements AbstractC0574 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private Integer f5149;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f5150;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Integer f5151;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f5152;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Integer f5153;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Integer f5154;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f5155;

    public C1359Ce() {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m4362(String str) {
        this.f5155 = str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m4366(Integer num) {
        this.f5154 = num;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m4365(Integer num) {
        this.f5151 = num;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m4363(Integer num) {
        this.f5153 = num;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m4361(Integer num) {
        this.f5149 = num;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m4364(String str) {
        this.f5150 = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C1359Ce(oX oXVar, String str) {
        this(oXVar, Integer.valueOf(oXVar == null ? 0 : oXVar.mo9589()), str);
    }

    public C1359Ce(AbstractC2087qh qhVar, Integer num, String str) {
        if (qhVar != null) {
            m4363(Integer.valueOf(qhVar.getListPos()));
            m4362(qhVar.getRequestId());
            m4366(Integer.valueOf(qhVar.getTrackId()));
        }
        m4361(num);
        m4365(C1332Be.m4015(str, null));
    }

    public String toString() {
        return "DataContext [requestId=" + this.f5155 + ", trackId=" + this.f5154 + ", videoId=" + this.f5151 + ", xid=" + this.f5152 + ", row=" + this.f5153 + ", rank=" + this.f5149 + ", trackingInfo=" + this.f5150 + "]";
    }

    @Override // o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.f5155 != null) {
            jSONObject.put("requestId", this.f5155);
        }
        if (this.f5154 != null) {
            jSONObject.put("trackId", this.f5154);
        }
        if (this.f5151 != null) {
            jSONObject.put("videoId", this.f5151);
        }
        if (this.f5152 != null) {
            jSONObject.put("xid", this.f5152);
        }
        if (this.f5153 != null) {
            jSONObject.put("row", this.f5153);
        }
        if (this.f5149 != null) {
            jSONObject.put("rank", this.f5149);
        }
        if (!TextUtils.isEmpty(this.f5150)) {
            try {
                jSONObject.put("trackingInfo", new JSONObject(this.f5150));
            } catch (JSONException e) {
                C1283.m16847("DataContext", "Failed to put an errror", e);
                jSONObject.put("trackingInfo", this.f5150);
            }
        }
        return jSONObject;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C1359Ce m4360(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C1359Ce ce = new C1359Ce();
        int r3 = AK.m3386(jSONObject, "rank", -1);
        ce.f5149 = r3 < 0 ? null : Integer.valueOf(r3);
        int r32 = AK.m3386(jSONObject, "videoId", -1);
        ce.f5151 = r32 < 0 ? null : Integer.valueOf(r32);
        int r33 = AK.m3386(jSONObject, "row", -1);
        ce.f5153 = r33 < 0 ? null : Integer.valueOf(r33);
        int r34 = AK.m3386(jSONObject, "trackId", -1);
        ce.f5154 = r34 < 0 ? null : Integer.valueOf(r34);
        ce.f5155 = AK.m3376(jSONObject, "requestId", (String) null);
        ce.f5152 = AK.m3376(jSONObject, "xid", (String) null);
        ce.f5150 = AK.m3376(jSONObject, "trackingInfo", (String) null);
        return ce;
    }
}
