package com.netflix.mediaclient.service.webclient.model.leafs;

import android.os.Build;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import o.AE;
import o.C1349Bv;
public class DeviceConfigData {
    public static final boolean DEFAULT_ALLOW_HEVC_MOBILE = false;
    public static final boolean DEFAULT_ALLOW_VP9_MOBILE = (Build.VERSION.SDK_INT >= 21);
    @SerializedName("alertMsgForLocaleSupport")
    private String alertMsgForLocaleSupport;
    @SerializedName("allowHevcMobile")
    private boolean allowHevcMobile = false;
    @SerializedName("allowVp9Mobile")
    private boolean allowVp9Mobile = DEFAULT_ALLOW_VP9_MOBILE;
    @SerializedName("appBootUrlSuffix")
    private String appBootUrlSuffix;
    @SerializedName("audioFormats")
    private int audioFormats;
    @SerializedName("breadcrumb_logging_specification")
    private BreadcrumbLoggingSpecification breadcrumb_logging_specification = BreadcrumbLoggingSpecification.getDefault();
    @SerializedName("consolidated_logging_specification")
    private List<ConsolidatedLoggingSessionSpecification> consolidated_logging_specification = new ArrayList();
    private int current_version;
    @SerializedName("disableActivityTracking")
    private boolean disableActivityTracking = true;
    @SerializedName("disableCastFaststart")
    private boolean disableCastFaststart;
    @SerializedName("disableDataSaver")
    private boolean disableDataSaver;
    @SerializedName("disableExoplayerTest")
    private boolean disableExoplayerTest;
    @SerializedName("disableLegacyNetflixMdx")
    private boolean disableLegacyNetflixMdx = false;
    @SerializedName("disableLicensePrefetch")
    private boolean disableLicensePrefetch;
    @SerializedName("disableLoginOverMsl")
    public boolean disableLoginOverMsl;
    @SerializedName("disablePlayBilling")
    private boolean disablePlayBilling;
    @SerializedName("disableRoar")
    private boolean disableRoar;
    private boolean disable_mdx;
    private String disable_websocket;
    @SerializedName("enableDolbyVision")
    private boolean enableDolbyVision;
    @SerializedName("enableHdr10")
    private boolean enableHdr10;
    @SerializedName("enableLocalPlayback")
    private boolean enableLocalPlayback = true;
    @SerializedName("enableMdxRemoteControlLockScreen")
    private boolean enableMdxRemoteControlLockScreen = true;
    @SerializedName("enableMdxRemoteControlNotification")
    private boolean enableMdxRemoteControlNotification = true;
    @SerializedName("enableOfflineSecureDelete")
    private boolean enableOfflineSecureDelete;
    @SerializedName("enableWidevineL1")
    private boolean enableWidevineL1;
    @SerializedName("enableWidevineL3SystemId4266")
    private boolean enableWidevineL3SystemId4266 = true;
    @SerializedName("error_logging_specification")
    private ErrorLoggingSpecification error_logging_specification = ErrorLoggingSpecification.getDefault();
    @SerializedName("forceLegacyCrypto")
    private boolean forceLegacyCrypto;
    @SerializedName("gcmBrowseEventRateLimitInSecs")
    private int gcmBrowseEventRateLimit;
    @SerializedName("gcmNListChangeEventRateLimitInSecs")
    private int gcmNListChangeEventRateLimit;
    @SerializedName("geoCountryCode")
    private String geoCountryCode;
    @SerializedName("ignorePreloadForPlayBilling")
    private boolean ignorePreloadForPlayBilling;
    private String image_pref;
    @SerializedName("ip_connectivity_policy")
    private int ip_connectivity_policy = -1;
    @SerializedName("isBlacklisted")
    private boolean isBlacklisted;
    @SerializedName("jPlayerRestartOnStreamErrors")
    private int jPlayerRestartOnStreamErrors = 2;
    @SerializedName("lockPhonePortraitEnabled")
    private boolean lockPhonePortraitEnabled;
    @SerializedName("disableAndroidJobScheduler")
    private boolean mDisableAndroidJobScheduler;
    @SerializedName("disableAndroidJobSchedulerJobFinish")
    private boolean mDisableAndroidJobSchedulerJobFinish;
    @SerializedName("mementoEnabledForWorld")
    private boolean mementoEnabledForWorld;
    private int min_version;
    @SerializedName("offlineCodecPrefData")
    private OfflineCodecPrefData offlineCodecPrefData;
    @SerializedName("offlineConfig")
    private OfflineConfig offlineConfig = OfflineConfig.createDefault();
    @SerializedName("pdsAndLogblobConfig")
    public PdsAndLogblobConfig pdsAndLogblobConfig;
    private String pt_aggregation_size;
    @SerializedName("shouldAlertForLocaleSupport")
    private boolean shouldAlertForLocaleSupport;
    private String signup_enabled;
    private String signup_timeout;
    @SerializedName("streamingCodecPrefData")
    private StreamingCodecPrefData streamingCodecPrefData;
    @SerializedName("subtitleDownloadRetryPolicy")
    private SubtitleDownloadRetryPolicy subtitleDownloadRetryPolicy = new SubtitleDownloadRetryPolicy();
    private String subtitle_configuration;
    private String type;
    @SerializedName("user_session_timeout_duration")
    private int user_session_timeout_duration = -1;
    @SerializedName("videoResolutionOverride")
    private int videoResolutionOverride;
    @SerializedName("voipConfig")
    private VoipConfiguration voipConfig = new VoipConfiguration();
    @SerializedName("voipConfirmationDialogAllocationPercentage")
    private int voipConfirmationDialogAllocationPercentage = 25;
    @SerializedName("voipEnabledOnDevice")
    private boolean voipEnabledOnDevice;

    public int getAppMinVresion() {
        return this.min_version;
    }

    public int getAppRecommendedVresion() {
        return this.current_version;
    }

    public String getWebsocketDisabled() {
        return this.disable_websocket;
    }

    public boolean getMdxDisabled() {
        return this.disable_mdx;
    }

    public boolean isDisableLegacyNetflixMdx() {
        return this.disableLegacyNetflixMdx;
    }

    public String getImagePref() {
        return this.image_pref;
    }

    public String getSubtitleConfiguration() {
        return this.subtitle_configuration;
    }

    public String getSignUpEnabled() {
        return this.signup_enabled;
    }

    public String getSignUpTimeout() {
        return this.signup_timeout;
    }

    public String getPTAggregationSize() {
        return this.pt_aggregation_size;
    }

    public boolean isWidevineL1Enabled() {
        return this.enableWidevineL1;
    }

    public boolean isHdr10Enabled() {
        return this.enableHdr10;
    }

    public boolean isDolbyVisionEnabled() {
        return this.enableDolbyVision;
    }

    public boolean shouldForceLegacyCrypto() {
        return this.forceLegacyCrypto;
    }

    public boolean isBlacklisted() {
        return this.isBlacklisted;
    }

    public boolean isVoipEnabledOnDevice() {
        return this.voipEnabledOnDevice;
    }

    public boolean isMementoEnabledForWorld() {
        return this.mementoEnabledForWorld;
    }

    public boolean shouldAlertForMissingLocale() {
        return this.shouldAlertForLocaleSupport;
    }

    public String getAlertMsgForLocaleSupport() {
        return this.alertMsgForLocaleSupport;
    }

    public int getAudioFormats() {
        return this.audioFormats;
    }

    public boolean isPlayBillingDisabled() {
        return this.disablePlayBilling;
    }

    public boolean toIgnorePrelaodForPlayBilling() {
        return this.ignorePreloadForPlayBilling;
    }

    public boolean getDisableCastFaststart() {
        return this.disableCastFaststart;
    }

    public boolean getDisableDataSaver() {
        return this.disableDataSaver;
    }

    public boolean disableAndroidJobScheduler() {
        return this.mDisableAndroidJobScheduler;
    }

    public boolean disableAndroidJobSchedulerJobFinish() {
        return this.mDisableAndroidJobSchedulerJobFinish;
    }

    public boolean isPhonePortraitLockEnabled() {
        return this.lockPhonePortraitEnabled;
    }

    public boolean shouldDisableRoar() {
        return this.disableRoar;
    }

    public List<ConsolidatedLoggingSessionSpecification> getConsolidatedloggingSpecification() {
        return this.consolidated_logging_specification;
    }

    public int getIpConnectivityPolicy() {
        return this.ip_connectivity_policy;
    }

    public int getUserSessionTimeoutDuration() {
        return this.user_session_timeout_duration;
    }

    public BreadcrumbLoggingSpecification getBreadcrumbLoggingSpecification() {
        return this.breadcrumb_logging_specification;
    }

    public ErrorLoggingSpecification getErrorLoggingSpecification() {
        return this.error_logging_specification;
    }

    public int getVideoResolutionOverride() {
        return this.videoResolutionOverride;
    }

    public int getRateLimitForGcmBrowseEvents() {
        return this.gcmBrowseEventRateLimit;
    }

    public int getRateLimitForGcmNListChangeEvents() {
        return this.gcmNListChangeEventRateLimit;
    }

    public boolean getEnableLocalPlayback() {
        return this.enableLocalPlayback;
    }

    public boolean getEnableMdxRemoteControlLockScreen() {
        return this.enableMdxRemoteControlLockScreen;
    }

    public boolean getEnableMdxRemoteControlNotification() {
        return this.enableMdxRemoteControlNotification;
    }

    public int getJPlayerStreamErrorRestartCount() {
        return this.jPlayerRestartOnStreamErrors;
    }

    public VoipConfiguration getVoipConfiguration() {
        return this.voipConfig;
    }

    public OfflineConfig getOfflineConfig() {
        return this.offlineConfig;
    }

    public SubtitleDownloadRetryPolicy getSubtitleDownloadRetryPolicy() {
        return this.subtitleDownloadRetryPolicy;
    }

    public int getVoipConfirmationDialogAllocationPercentage() {
        return this.voipConfirmationDialogAllocationPercentage;
    }

    public String getGeoCountryCode() {
        return this.geoCountryCode;
    }

    public String getAppBootUrlSuffix() {
        return this.appBootUrlSuffix;
    }

    public boolean isAllowHevcMobile() {
        return this.allowHevcMobile;
    }

    public boolean isAllowVp9Mobile() {
        return this.allowVp9Mobile;
    }

    public boolean getDisableLicensePrefetch() {
        return this.disableLicensePrefetch;
    }

    public boolean isActivivityTrackingDisabled() {
        return this.disableActivityTracking;
    }

    public boolean isEnabledWidevineL3SystemId4266() {
        return this.enableWidevineL3SystemId4266;
    }

    public String toJsonString() {
        return AE.m3322().toJson(this);
    }

    public static DeviceConfigData fromJsonString(String str) {
        if (C1349Bv.m4113(str)) {
            return new DeviceConfigData();
        }
        return (DeviceConfigData) AE.m3322().fromJson(str, (Class<Object>) DeviceConfigData.class);
    }

    public void setEnableWidevineL1(boolean z) {
        this.enableWidevineL1 = z;
    }

    public void setAppMinVersion(int i) {
        this.min_version = i;
    }

    public void setAppRecommendedVersion(int i) {
        this.current_version = i;
    }

    public void setGeoCountryCode(String str) {
        this.geoCountryCode = str;
    }

    public StreamingCodecPrefData getStreamingCodecPrefData() {
        return this.streamingCodecPrefData;
    }

    public OfflineCodecPrefData getOfflineCodecPrefData() {
        return this.offlineCodecPrefData;
    }

    public boolean isEnableOfflineSecureDelete() {
        return this.enableOfflineSecureDelete;
    }

    public boolean isDisableExoplayerTest() {
        return this.disableExoplayerTest;
    }
}
