package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import org.json.JSONObject;
/* renamed from: o.aS  reason: case insensitive filesystem */
public class C1487aS {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f5916;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f5917;

    public C1487aS(String str, String str2) {
        this.f5917 = str;
        this.f5916 = str2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public JSONObject m5391() {
        JSONObject jSONObject = new JSONObject();
        if (this.f5917 == null) {
            jSONObject.put(NetflixActivity.EXTRA_SOURCE, this.f5917);
        }
        if (this.f5916 == null) {
            jSONObject.put("deeplinkParams", this.f5916);
        }
        return jSONObject;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C1487aS m5390(String str, String str2) {
        if (str == null && str2 == null) {
            return null;
        }
        return new C1487aS(str, str2);
    }

    public String toString() {
        return "DeepLink{source='" + this.f5917 + "', deeplinkParams='" + this.f5916 + "'}";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m5392() {
        return this.f5916;
    }
}
