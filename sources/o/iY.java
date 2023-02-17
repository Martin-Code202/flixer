package o;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
public class iY {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean f7679;

    /* renamed from: ˋ  reason: contains not printable characters */
    String f7680;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final UserAgentInterface f7681;

    /* renamed from: ˏ  reason: contains not printable characters */
    boolean f7682;

    /* renamed from: ॱ  reason: contains not printable characters */
    JSONObject f7683;

    public iY(UserAgentInterface userAgentInterface, boolean z) {
        this.f7681 = userAgentInterface;
        this.f7679 = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public iY m7617(JSONObject jSONObject) {
        this.f7683 = jSONObject;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public iY m7620(String str) {
        this.f7680 = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public final String m7621() {
        JSONObject jSONObject = new JSONObject();
        if (this.f7683 == null) {
            return jSONObject.toString();
        }
        try {
            jSONObject.put(LoggingRequest.VERSION, 2);
            jSONObject.put("method", this.f7683.optString("rel"));
            jSONObject.put("url", this.f7683.optString("href"));
            jSONObject.put("languages", new JSONArray((Collection) Arrays.asList(this.f7681.mo1383().getLanguages())));
            long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("clientTime", seconds);
            jSONObject2.put("forceDeviceActivate", this.f7682);
            jSONObject2.putOpt("challengeBase64", this.f7680);
            jSONObject2.put("enableSecureDelete", this.f7679);
            jSONObject.putOpt("params", jSONObject2);
        } catch (Exception e) {
            C1283.m16856("nf_msl_volley_FetchLicenseRequest", e, "error creating manifest params", new Object[0]);
        }
        return jSONObject.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public iY m7619(JSONObject jSONObject, String str) {
        return m7617(jSONObject).m7620(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public iY m7618(IBladeRunnerClient.OfflineRefreshInvoke offlineRefreshInvoke) {
        this.f7682 = IBladeRunnerClient.OfflineRefreshInvoke.USER.m944() == offlineRefreshInvoke.m944();
        return this;
    }
}
