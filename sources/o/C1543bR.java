package o;

import android.content.Context;
import android.os.Build;
import com.netflix.mediaclient.repository.SecurityRepository;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.Version;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.util.DeviceCategory;
import com.netflix.mediaclient.util.MediaUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.bR  reason: case insensitive filesystem */
public class C1543bR extends AbstractC1542bQ {
    public C1543bR(Context context, AbstractC1221 r25, JSONObject jSONObject, JSONObject jSONObject2) {
        DeviceCategory r4 = r25.mo16541();
        AbstractC0518 d_ = r25.d_();
        String r6 = C1349Bv.m4105("fesn2", d_.mo14445());
        String r7 = C1349Bv.m4105("fesn3", d_.mo14447());
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1048576);
        int r10 = AD.m3315(context);
        int r11 = AD.m3318(context);
        String r12 = C1350Bw.m4130(context);
        String str = IClientLogging.f2458 + "";
        int r14 = C1122.m16272(context);
        try {
            JSONObject r15 = AD.m3314(context);
            JSONObject r16 = AD.m3289(context);
            this.f6134.put("AndroidDeviceID", r7);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(r6);
            this.f6134.put("prevAndroidDeviceIDList", jSONArray);
            this.f6134.put("android_api_level", Build.VERSION.SDK_INT);
            this.f6134.put("android_version", Build.VERSION.RELEASE);
            if (jSONObject != null) {
                this.f6134.put("carrierinfo", jSONObject);
            }
            String systemPropety = SecurityRepository.getSystemPropety("ro.modversion");
            String r19 = r25.mo16559();
            this.f6134.put("chipset", C1349Bv.m4113(r19) ? "0" : r19);
            String r20 = r25.mo16506();
            this.f6134.put("chipsetHardware", C1349Bv.m4113(r20) ? "0" : r20);
            if (C1349Bv.m4107(r25.mo16504())) {
                this.f6134.put("roBspVer", r25.mo16504());
            }
            this.f6134.put("yearClass", r14);
            this.f6134.put("hwSpec", r15);
            this.f6134.put("displayInfo", r16);
            this.f6134.put("crit_session_id", str);
            this.f6134.put("dalvikVMHeapSize", maxMemory);
            this.f6134.put("deviceStorageInfo", r12);
            this.f6134.put("devicecategory", r4.m2972());
            this.f6134.put("realdevicecategory", m5759().m2972());
            this.f6134.put("playerver", "EXO-2.5.3");
            this.f6134.put(Device.ESN, d_.mo14449());
            this.f6134.put("fingerprint", Build.FINGERPRINT);
            this.f6134.put("gms_client_version", r10);
            this.f6134.put("gms_pkg_version", r11);
            this.f6134.put("installationsource", C1325Ay.m3829(context));
            this.f6134.put("installerName", C1325Ay.m3825(context));
            this.f6134.put(Version.MDXJS, "1.1.6-android");
            this.f6134.put("mdxlib_version", "2014.1");
            this.f6134.put("modversion", C1349Bv.m4113(systemPropety) ? "stock" : systemPropety);
            this.f6134.put("platform", C1317As.m3758());
            this.f6134.put("supported_crypto", AV.m3451());
            this.f6134.put("system_id", d_.mo14537());
            this.f6134.put("used_crypto", d_.mo14530().f1089);
            this.f6134.put("video_decoders", MediaUtils.m2978());
            this.f6134.putOpt("channelId", r25.mo16560());
            this.f6134.putOpt("gAdvId", r25.mo16502());
            this.f6134.putOpt("installType", r25.mo16562());
            this.f6134.put("msl_drm_session_count", AbstractC0476.f13530);
            this.f6134.put("deviceSerial", AR.m3403());
            this.f6134.put("widevineDeviceId", m5758(d_));
            if (jSONObject2 != null) {
                this.f6134.put("previous_network_stats", jSONObject2);
            }
            String r21 = C1339Bl.m4045(context, "playback_failure_info", (String) null);
            if (C1349Bv.m4107(r21)) {
                this.f6134.put("play_crash_info", r21);
            }
            C1339Bl.m4041(context, "playback_failure_info");
            this.f6134.put("pip_enabled", C1317As.m3742(context) ? C1317As.m3744(context) : false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m5758(AbstractC0518 r1) {
        if (r1 == null || r1.mo14444() == null) {
            return "";
        }
        return C1324Ax.m3822(r1.mo14444());
    }

    @Override // o.AbstractC1542bQ, com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˎ */
    public JSONObject mo1555() {
        return this.f6134;
    }

    @Override // o.AbstractC1542bQ
    /* renamed from: ॱ */
    public String mo5756() {
        return this.f6134.toString();
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "startup";
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static DeviceCategory m5759() {
        if (AD.m3303()) {
            return DeviceCategory.CHROME_OS;
        }
        if (AD.m3320()) {
            return DeviceCategory.ANDROID_STB;
        }
        if (AD.m3281()) {
            return DeviceCategory.ANDROID_TV;
        }
        if (AD.m3299()) {
            return DeviceCategory.TABLET;
        }
        return DeviceCategory.PHONE;
    }

    @Override // o.AbstractC1542bQ, com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˏ */
    public boolean mo1556() {
        return true;
    }
}
