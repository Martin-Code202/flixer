package o;

import android.content.Context;
import com.netflix.mediaclient.service.net.IpConnectivityPolicy;
import com.netflix.mediaclient.service.webclient.model.leafs.BreadcrumbLoggingSpecification;
import com.netflix.mediaclient.service.webclient.model.leafs.ConsolidatedLoggingSessionSpecification;
import com.netflix.mediaclient.service.webclient.model.leafs.DeviceConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.ErrorLoggingSpecification;
import com.netflix.mediaclient.service.webclient.model.leafs.OfflineCodecPrefData;
import com.netflix.mediaclient.service.webclient.model.leafs.OfflineConfig;
import com.netflix.mediaclient.service.webclient.model.leafs.PdsAndLogblobConfig;
import com.netflix.mediaclient.service.webclient.model.leafs.StreamingCodecPrefData;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipConfiguration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* renamed from: o.ｳ  reason: contains not printable characters */
public class C1252 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String f15822 = "nf_configuration_device";

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final Boolean f15823 = Boolean.valueOf(C1317As.m3758() > 8);

    /* renamed from: ʻ  reason: contains not printable characters */
    private IpConnectivityPolicy f15824;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Context f15825;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Map<String, ConsolidatedLoggingSessionSpecification> f15826 = new HashMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    private DeviceConfigData f15827;

    public C1252(Context context) {
        this.f15825 = context;
        this.f15827 = DeviceConfigData.fromJsonString(C1339Bl.m4045(this.f15825, "deviceConfig", (String) null));
        m16622();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m16635() {
    }

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private void m16622() {
        this.f15826 = m16624();
        this.f15824 = IpConnectivityPolicy.m811(this.f15827.getIpConnectivityPolicy());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m16662() {
        if (this.f15827 != null) {
            return this.f15827.getImagePref();
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m16640() {
        if (this.f15827 == null || !C1349Bv.m4107(this.f15827.getPTAggregationSize())) {
            return -1;
        }
        return Integer.parseInt(this.f15827.getPTAggregationSize());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m16649() {
        if (this.f15827 != null) {
            return this.f15827.getAppMinVresion();
        }
        return -1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m16653() {
        if (this.f15827 != null) {
            return this.f15827.getAppRecommendedVresion();
        }
        return -1;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean m16672() {
        if (this.f15827 != null) {
            return this.f15827.isWidevineL1Enabled();
        }
        return false;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m16670() {
        if (this.f15827 != null) {
            return this.f15827.isHdr10Enabled();
        }
        return false;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m16629() {
        if (this.f15827 != null) {
            return this.f15827.isDolbyVisionEnabled();
        }
        return false;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m16627() {
        if (this.f15827 != null) {
            return this.f15827.disableLoginOverMsl;
        }
        return false;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m16625() {
        if (this.f15827 == null || !C1349Bv.m4107(this.f15827.getWebsocketDisabled())) {
            return true;
        }
        return Boolean.parseBoolean(this.f15827.getWebsocketDisabled());
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public boolean m16638() {
        if (this.f15827 != null) {
            return this.f15827.isDisableLegacyNetflixMdx();
        }
        return false;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public boolean m16657() {
        if (this.f15827 != null) {
            return this.f15827.getMdxDisabled();
        }
        return false;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public int m16666() {
        if (this.f15827 != null) {
            return this.f15827.getVideoResolutionOverride();
        }
        return 0;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public int m16659() {
        if (this.f15827 != null) {
            return this.f15827.getRateLimitForGcmBrowseEvents();
        }
        return 0;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public int m16645() {
        if (this.f15827 != null) {
            return this.f15827.getRateLimitForGcmNListChangeEvents();
        }
        return 0;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public int m16626() {
        if (this.f15827 != null) {
            return this.f15827.getAudioFormats();
        }
        return 0;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public boolean m16673() {
        if (this.f15827 != null) {
            return this.f15827.isPlayBillingDisabled();
        }
        return false;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public boolean m16668() {
        if (this.f15827 != null) {
            return this.f15827.toIgnorePrelaodForPlayBilling();
        }
        return false;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public boolean m16667() {
        if (this.f15827 != null) {
            return this.f15827.shouldAlertForMissingLocale();
        }
        return false;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public String m16671() {
        if (this.f15827 != null) {
            return this.f15827.getAlertMsgForLocaleSupport();
        }
        return null;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public StreamingCodecPrefData m16632() {
        if (this.f15827 != null) {
            return this.f15827.getStreamingCodecPrefData();
        }
        return null;
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public OfflineCodecPrefData m16628() {
        if (this.f15827 != null) {
            return this.f15827.getOfflineCodecPrefData();
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public ConsolidatedLoggingSessionSpecification m16654(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return this.f15826.get(str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m16641(DeviceConfigData deviceConfigData) {
        if (deviceConfigData == null) {
            C1283.m16850(f15822, "deviceConfig object is null - ignore overwrite");
            return;
        }
        C1339Bl.m4039(this.f15825, "deviceConfig", deviceConfigData.toJsonString());
        m16650(deviceConfigData.isPhonePortraitLockEnabled());
        m16642(deviceConfigData.shouldDisableRoar());
        this.f15827 = deviceConfigData;
        m16622();
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public boolean m16633() {
        return C1339Bl.m4051(this.f15825, "nf_device_config_cached", false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Map<String, ConsolidatedLoggingSessionSpecification> m16621(List<ConsolidatedLoggingSessionSpecification> list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (ConsolidatedLoggingSessionSpecification consolidatedLoggingSessionSpecification : list) {
                if (!(consolidatedLoggingSessionSpecification == null || consolidatedLoggingSessionSpecification.getSession() == null)) {
                    hashMap.put(consolidatedLoggingSessionSpecification.getSession(), consolidatedLoggingSessionSpecification);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: ᐨ  reason: contains not printable characters */
    private Map<String, ConsolidatedLoggingSessionSpecification> m16624() {
        if (this.f15827 == null) {
            return new HashMap();
        }
        return m16621(this.f15827.getConsolidatedloggingSpecification());
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public int m16631() {
        if (this.f15827 != null) {
            return this.f15827.getUserSessionTimeoutDuration();
        }
        return Integer.MIN_VALUE;
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public BreadcrumbLoggingSpecification m16630() {
        return this.f15827 != null ? this.f15827.getBreadcrumbLoggingSpecification() : BreadcrumbLoggingSpecification.getDefault();
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    public ErrorLoggingSpecification m16637() {
        return this.f15827 != null ? this.f15827.getErrorLoggingSpecification() : ErrorLoggingSpecification.getDefault();
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    public PdsAndLogblobConfig m16636() {
        return (this.f15827 == null || this.f15827.pdsAndLogblobConfig == null) ? PdsAndLogblobConfig.Companion.getDEFAULT() : this.f15827.pdsAndLogblobConfig;
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    public boolean m16634() {
        if (this.f15827 != null) {
            return this.f15827.getEnableMdxRemoteControlLockScreen();
        }
        return true;
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    public boolean m16643() {
        if (this.f15827 != null) {
            return this.f15827.getEnableMdxRemoteControlNotification();
        }
        return true;
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public boolean m16639() {
        if (this.f15827 != null) {
            return this.f15827.getEnableLocalPlayback();
        }
        return true;
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    public boolean m16648() {
        return this.f15827 == null || !this.f15827.isVoipEnabledOnDevice();
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    public VoipConfiguration m16647() {
        return this.f15827 != null ? this.f15827.getVoipConfiguration() : VoipConfiguration.DEF_VOIP_CONIFG;
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    public SubtitleDownloadRetryPolicy m16644() {
        return this.f15827 != null ? this.f15827.getSubtitleDownloadRetryPolicy() : SubtitleDownloadRetryPolicy.getDefault();
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    public boolean m16651() {
        if (this.f15827 != null) {
            return this.f15827.getDisableCastFaststart();
        }
        return false;
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    public OfflineConfig m16646() {
        if (this.f15827 != null) {
            return this.f15827.getOfflineConfig();
        }
        return null;
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    public boolean m16658() {
        if (this.f15827 != null) {
            return this.f15827.isAllowHevcMobile();
        }
        return false;
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    public boolean m16652() {
        if (this.f15827 != null) {
            return this.f15827.getDisableLicensePrefetch();
        }
        return false;
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    public boolean m16655() {
        if (this.f15827 != null) {
            return this.f15827.isActivivityTrackingDisabled();
        }
        return false;
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    public String m16660() {
        return this.f15827 != null ? this.f15827.getGeoCountryCode() : "";
    }

    /* renamed from: ˏˏ  reason: contains not printable characters */
    public boolean m16656() {
        if (this.f15827 == null) {
            return f15823.booleanValue();
        }
        String signUpEnabled = this.f15827.getSignUpEnabled();
        return C1349Bv.m4107(signUpEnabled) ? Boolean.parseBoolean(signUpEnabled) : f15823.booleanValue();
    }

    /* renamed from: ॱʼ  reason: contains not printable characters */
    public long m16664() {
        if (this.f15827 == null) {
            return 120000;
        }
        String signUpTimeout = this.f15827.getSignUpTimeout();
        if (C1349Bv.m4107(signUpTimeout)) {
            return Long.parseLong(signUpTimeout);
        }
        return 120000;
    }

    /* renamed from: ॱͺ  reason: contains not printable characters */
    public String m16669() {
        String str;
        String r4 = C1339Bl.m4045(this.f15825, "webview_url_preference", "");
        if (r4.length() > 0) {
            str = "https://" + r4;
        } else {
            str = m16623();
        }
        C1283.m16854(f15822, "mSignUpBootloader: " + str);
        return str;
    }

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private String m16623() {
        return "https://www.netflix.com";
    }

    /* renamed from: ॱʽ  reason: contains not printable characters */
    public boolean m16665() {
        if (this.f15827 != null) {
            return this.f15827.isEnabledWidevineL3SystemId4266();
        }
        return true;
    }

    /* renamed from: ॱʻ  reason: contains not printable characters */
    public void m16663() {
        if (m16633()) {
            AY ay = new AY(this.f15825);
            ay.m3495("nf_device_config_cached");
            ay.m3495("image_pref");
            ay.m3495("signup_enabled");
            ay.m3495("signup_timeout");
            ay.m3495("nf_subtitle_configuraton");
            ay.m3495("cl_configuration");
            ay.m3495("ip_connectivity_policy_overide");
            ay.m3495("apm_user_session_timeout_duration_override");
            ay.m3495("breadcrumb_log_configuration");
            ay.m3495("error_log_configuration");
            ay.m3495("voip_configuration");
            ay.m3495("offline_config");
            ay.m3495("pt_aggregation_size");
            ay.m3495("config_recommended_version");
            ay.m3495("config_min_version");
            ay.m3495("disable_mdx");
            ay.m3495("disable_websocket");
            ay.m3495("enable_widevine_l1");
            ay.m3495("enable_dynecom_signin");
            ay.m3495("enable_voip_on_device");
            ay.m3495("memento_enabled_for_world");
            ay.m3495("video_resolution_override");
            ay.m3495("gcm_browse_rate_limit");
            ay.m3495("gcm_tray_change_rate_limit");
            ay.m3495("playback_configuration_local_playback_enabled");
            ay.m3495("mdx_configuration_remote_lockscreen_enabled");
            ay.m3495("mdx_configuration_remote_notification_enabled");
            ay.m3495("jplayer_restart_count");
            ay.m3495("device_locale_not_supported");
            ay.m3495("device_locale_not_supported_msg");
            ay.m3495("disable_playbilling");
            ay.m3495("ignore_preload_playbilling");
            ay.m3495("device_config_geo_country_code");
            ay.m3495("subtitle_download_retry_policy");
            ay.m3495("disable_cast_faststart");
            ay.m3495("disable_data_saver");
            ay.m3495("prefs_allow_hevc_mobile");
            ay.m3495("prefs_allow_vp9_mobile");
            ay.m3495("prefs_activity_tracking");
            ay.m3495("enable_phone_portraitlock");
            ay.m3494();
        }
    }

    /* renamed from: ـ  reason: contains not printable characters */
    public void m16661() {
        boolean r5 = C1339Bl.m4051(this.f15825, "enable_widevine_l1", false);
        int r6 = C1339Bl.m4037(this.f15825, "config_recommended_version", -1);
        int r7 = C1339Bl.m4037(this.f15825, "config_min_version", -1);
        String r8 = C1339Bl.m4045(this.f15825, "device_config_geo_country_code", "");
        this.f15827.setEnableWidevineL1(r5);
        this.f15827.setAppRecommendedVersion(r6);
        this.f15827.setAppMinVersion(r7);
        this.f15827.setGeoCountryCode(r8);
        C1283.m16851(f15822, "recoverAndClearLegacyConfigs: L1: %b, appRecoVersion: %d, appMinVersion: %d, geo: %s", Boolean.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7), r8);
        m16641(this.f15827);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16650(boolean z) {
        C1339Bl.m4048(this.f15825, "enable_phone_portraitlock", z);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m16642(boolean z) {
        C1339Bl.m4048(this.f15825, "disable_roar", z);
    }

    /* renamed from: ᐧ  reason: contains not printable characters */
    public boolean m16674() {
        return this.f15827.isEnableOfflineSecureDelete();
    }
}
