package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public class ConfigData {
    public ABTestConfigData abTestConfigData;
    public AccountConfigData accountConfig;
    @SerializedName("castKey")
    public CastKeyData castKeyData;
    public DeviceConfigData deviceConfig;
    @SerializedName("nrmInfo")
    public NonMemberData nrmInfo;
    @SerializedName("nrmLanguages")
    public NrmLanguagesData nrmLang;
    @SerializedName("signInConfig")
    public SignInConfigData signInConfigData;
    public String streamingConfigJson;

    public DeviceConfigData getDeviceConfig() {
        return this.deviceConfig;
    }

    public AccountConfigData getAccountConfig() {
        return this.accountConfig;
    }

    public String getStreamingConfig() {
        return this.streamingConfigJson;
    }

    public ABTestConfigData getABTestConfigData() {
        return this.abTestConfigData;
    }

    public NonMemberData getNrmConfigData() {
        return this.nrmInfo;
    }

    public NrmLanguagesData getNrmLanguagesData() {
        return this.nrmLang;
    }

    public CastKeyData getCastKeyData() {
        return this.castKeyData;
    }

    public SignInConfigData getSignInConfigData() {
        return this.signInConfigData;
    }

    public String toString() {
        return "ConfigData{deviceConfig=" + this.deviceConfig + ", accountConfig=" + this.accountConfig + ", abTestConfigData=" + this.abTestConfigData + ", streamingConfigJson='" + this.streamingConfigJson + "', nrmInfo=" + this.nrmInfo + ", signInConfigData=" + this.signInConfigData + ", castKeyData=" + this.castKeyData + '}';
    }
}
