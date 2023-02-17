package o;

import android.content.Context;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.DeviceCommandHandler;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.AccountConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.CastKeyData;
import com.netflix.mediaclient.service.webclient.model.leafs.ConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.DeviceConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.NonMemberData;
import com.netflix.mediaclient.service.webclient.model.leafs.NrmLanguagesData;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipCallConfigData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
/* renamed from: o.乁  reason: contains not printable characters */
public final class C1098 {

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final String f15268 = String.format("['%s']", "signInConfig");

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final String f15269 = String.format("['%s']", "nrmInfo");

    /* renamed from: ˋ  reason: contains not printable characters */
    static final String f15270 = String.format("['%s']", "accountConfig");

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final String f15271 = String.format("['%s']", "nrmLanguages");

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final String f15272 = String.format("['%s']", "castKey");

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final String f15273 = String.format("['%s']", "deviceConfig");

    /* renamed from: ॱॱ  reason: contains not printable characters */
    static final String f15274 = String.format("['%s']", "customerSupportVoipConfigData");

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static final String f15275 = String.format("['%s']", "refreshSignInConfig");

    /* renamed from: ˎ  reason: contains not printable characters */
    public static ConfigData m16204(Context context, String str) {
        JsonElement jsonElement;
        ConfigData configData = new ConfigData();
        JsonObject r3 = C0848.m15512("nf_config_data", str);
        if (C0848.m15504(r3)) {
            C1283.m16850("nf_config_data", "Empty response for configuration request!");
            FalkorException falkorException = new FalkorException("Empty response for configuration request: " + str);
            C1276.m16820().mo5731(falkorException);
            throw falkorException;
        }
        if (r3.has("deviceConfig")) {
            DeviceCommandHandler.m976(context, C0848.m15509(r3, "deviceConfig"));
            configData.deviceConfig = (DeviceConfigData) C0848.m15506(r3, "deviceConfig", DeviceConfigData.class);
        }
        if (r3.has("accountConfig")) {
            configData.accountConfig = (AccountConfigData) C0848.m15506(r3, "accountConfig", AccountConfigData.class);
        }
        if (r3.has("abTestConfig")) {
            try {
                configData.abTestConfigData = new ABTestConfigData(r3.get("abTestConfig").toString());
            } catch (JSONException e) {
                throw new FalkorException("unable to parse ABTestConfigData");
            }
        }
        if (r3.has("castKey")) {
            configData.castKeyData = (CastKeyData) C0848.m15506(r3, "castKey", CastKeyData.class);
        }
        if (r3.has("streamingConfig") && (jsonElement = r3.get("streamingConfig")) != null) {
            configData.streamingConfigJson = jsonElement.toString();
        }
        if (r3.has("nrmInfo")) {
            configData.nrmInfo = (NonMemberData) C0848.m15506(r3, "nrmInfo", NonMemberData.class);
        }
        if (r3.has("nrmLanguages")) {
            configData.nrmLang = (NrmLanguagesData) C0848.m15506(r3, "nrmLanguages", NrmLanguagesData.class);
        }
        if (r3.has("signInConfig")) {
            configData.signInConfigData = (SignInConfigData) C0848.m15506(r3, "signInConfig", SignInConfigData.class);
        }
        return configData;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static List<String> m16202(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f15273);
        arrayList.add(f15270);
        arrayList.add(f15272);
        arrayList.add(String.format("[['%s', '%s'], '%s']", "abTestConfig", "streamingConfig2", m16206(context)));
        return arrayList;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static VoipCallConfigData m16205(String str) {
        VoipCallConfigData voipCallConfigData = new VoipCallConfigData();
        JsonObject r6 = C0848.m15512("nf_config_data", str);
        if (C0848.m15504(r6)) {
            C1283.m16850("nf_config_data", "Empty response for voip configuration request!");
            FalkorException falkorException = new FalkorException("Empty response for voip configuration request: " + str);
            C1276.m16820().mo5731(falkorException);
            throw falkorException;
        } else if (!r6.has("customerSupportVoipConfigData")) {
            return voipCallConfigData;
        } else {
            C1283.m16851("nf_config_data", "Customer Support VOIP config json: %s", r6.get("customerSupportVoipConfigData"));
            return (VoipCallConfigData) C0848.m15506(r6, "customerSupportVoipConfigData", VoipCallConfigData.class);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static List<String> m16203() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f15274);
        return arrayList;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m16206(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        if (!C1337Bj.m4033()) {
            for (AbstractC1067 r3 : C1272.m16804()) {
                if (!AD.m3299() || !r3.mo509()) {
                    if (AD.m3299() || !r3.m16126()) {
                        arrayList.add(r3.mo511());
                    }
                }
            }
        }
        return C1349Bv.m4117((String[]) arrayList.toArray(new String[arrayList.size()]));
    }
}
