package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.player.StreamProfileType;
import o.AE;
import o.C1283;
import o.C1349Bv;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class AccountConfigData {
    private static final String TAG = "nf_config";
    @SerializedName("castWhitelistTargets")
    private final String castWhitelist = null;
    @SerializedName("disableMcQueenV2")
    private boolean disableMcQueenV2;
    @SerializedName("disableSuspendPlay")
    private boolean disableSuspendPlay;
    @SerializedName("enableCast")
    private boolean enableCast;
    @SerializedName("enableHTTPSAuth")
    private boolean enableHTTPSAuth;
    @SerializedName("enableLowBitrateStreams")
    private boolean enableLowBitrateStreams = true;
    @SerializedName("falkorCacheDisabled")
    private boolean falkorCacheDisabled;
    @SerializedName("JPlayerConfig")
    private String jPlayerConfig;
    @Expose
    private JSONArray mCastWhitelistJSONArray = null;
    @Expose
    private JSONObject mJPlayerConfigJSON = null;
    @Expose
    private JSONArray mMdxBlacklistTargetsJSONArray = null;
    @SerializedName("mdxBlacklistTargets")
    private final String mdxBlacklistTargets = null;
    @SerializedName("myListForKidsDisabled")
    private boolean myListForKidsDisabled;
    @SerializedName("offlineCodecPrefData")
    private OfflineCodecPrefData offlineCodecPrefData;
    @SerializedName("preAppPartnerExperience")
    private String preAppPartnerExperience;
    @SerializedName("preAppWidgetExperience")
    private String preAppWidgetExperience;
    @SerializedName("previewContent")
    public PreviewContentConfigData previewContent = PreviewContentConfigData.getDefault();
    @SerializedName("streamProfileData")
    private StreamProfileData streamProfileData;
    @SerializedName("streamingCodecPrefData")
    private StreamingCodecPrefData streamingCodecPrefData;
    @SerializedName("userPin")
    private String userPin;
    @SerializedName("videoBufferSize")
    private int videoBufferSize = 0;
    @SerializedName("voipEnabledOnAccount")
    private boolean voipEnabledOnAccount;

    public String getMdxBlacklist() {
        return this.mdxBlacklistTargets;
    }

    public String getCastBlacklist() {
        return this.castWhitelist;
    }

    public JSONArray getMdxBlacklistAsJsonArray() {
        if (this.mMdxBlacklistTargetsJSONArray == null) {
            JSONArray jSONArray = null;
            if (C1349Bv.m4107(this.mdxBlacklistTargets)) {
                try {
                    jSONArray = new JSONArray(this.mdxBlacklistTargets);
                } catch (JSONException e) {
                    C1283.m16854(TAG, String.format("mdxBlacklistTargets bad json: %s", this.mdxBlacklistTargets));
                }
            }
            this.mMdxBlacklistTargetsJSONArray = jSONArray;
        }
        return this.mMdxBlacklistTargetsJSONArray;
    }

    public boolean getCastEnabled() {
        return this.enableCast;
    }

    public boolean toDisableSuspendPlay() {
        return this.disableSuspendPlay;
    }

    public boolean toDisableMcQueenV2() {
        return this.disableMcQueenV2;
    }

    public boolean enableHTTPSAuth() {
        return this.enableHTTPSAuth;
    }

    public JSONArray getCastWhitelistAsJsonArray() {
        if (this.mCastWhitelistJSONArray == null) {
            JSONArray jSONArray = null;
            if (C1349Bv.m4107(this.castWhitelist)) {
                try {
                    jSONArray = new JSONArray(this.castWhitelist);
                } catch (JSONException e) {
                    C1283.m16854(TAG, String.format("castWhitelist bad json: %s", this.castWhitelist));
                }
            }
            this.mCastWhitelistJSONArray = jSONArray;
        }
        return this.mCastWhitelistJSONArray;
    }

    public int getVideoBufferSize() {
        return this.videoBufferSize;
    }

    public JSONObject getJPlayerThreadConfigAsJson() {
        if (this.mJPlayerConfigJSON == null) {
            JSONObject jSONObject = null;
            if (C1349Bv.m4107(this.jPlayerConfig)) {
                try {
                    jSONObject = new JSONObject(this.jPlayerConfig);
                } catch (JSONException e) {
                    C1283.m16854(TAG, String.format("jPlayerThreadConfig bad json: %s", this.jPlayerConfig));
                }
            }
            this.mJPlayerConfigJSON = jSONObject;
        }
        return this.mJPlayerConfigJSON;
    }

    public String toJsonString() {
        return AE.m3322().toJson(this);
    }

    public static AccountConfigData fromJsonString(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        AccountConfigData accountConfigData = (AccountConfigData) AE.m3322().fromJson(str, (Class<Object>) AccountConfigData.class);
        accountConfigData.mCastWhitelistJSONArray = null;
        accountConfigData.mMdxBlacklistTargetsJSONArray = null;
        accountConfigData.mJPlayerConfigJSON = null;
        return accountConfigData;
    }

    public BwCap getBwCap(StreamProfileType streamProfileType) {
        return this.streamProfileData != null ? BwCapKt.getBwCapForProfile(streamProfileType, this.streamProfileData) : StreamProfileData.Companion.getBW_CAP_DEFAULT();
    }

    public StreamingCodecPrefData getStreamingCodecPrefData() {
        return this.streamingCodecPrefData;
    }

    public OfflineCodecPrefData getOfflineCodecPrefData() {
        return this.offlineCodecPrefData;
    }

    public String getUserPin() {
        return this.userPin;
    }

    public String getPreAppWidgetExperience() {
        return this.preAppWidgetExperience;
    }

    public String getPreAppPartnerExperience() {
        return this.preAppPartnerExperience;
    }

    public boolean enableLowBitrateStreams() {
        return this.enableLowBitrateStreams;
    }

    public boolean isVoipEnabledOnAccount() {
        return this.voipEnabledOnAccount;
    }

    public PreviewContentConfigData getPreviewContentConfigData() {
        return this.previewContent;
    }

    public boolean isFalkorCacheDisabled() {
        return this.falkorCacheDisabled;
    }

    public boolean isMyListForKidsDisabled() {
        return this.myListForKidsDisabled;
    }
}
