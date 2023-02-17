package o;

import com.netflix.cl.model.PushNotificationType;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.Ꭻ  reason: contains not printable characters */
public final class C0722 extends C1275 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f14258;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f14259;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f14260;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private PushNotificationType[] f14261;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f14262;

    C0722(C0724 r2, String str, PushNotificationType[] pushNotificationTypeArr, boolean z, boolean z2, String str2) {
        super(r2);
        m14630("RegisterForPushNotificationsEnded");
        this.f14260 = str;
        this.f14262 = str2;
        this.f14261 = pushNotificationTypeArr;
        this.f14259 = z;
        this.f14258 = z2;
    }

    @Override // o.C1275, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        if (this.f14260 != null) {
            jSONObject.put("deviceToken", this.f14260);
        }
        if (this.f14262 != null) {
            jSONObject.put("oldDeviceToken", this.f14262);
        }
        jSONObject.put("infoOptStatus", this.f14259);
        jSONObject.put("pushOptStatus", this.f14258);
        if (this.f14261 != null) {
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("enabledNotificationTypes", jSONArray);
            PushNotificationType[] pushNotificationTypeArr = this.f14261;
            for (PushNotificationType pushNotificationType : pushNotificationTypeArr) {
                if (pushNotificationType != null) {
                    jSONArray.put(pushNotificationType.name());
                }
            }
        }
        return jSONObject;
    }
}
