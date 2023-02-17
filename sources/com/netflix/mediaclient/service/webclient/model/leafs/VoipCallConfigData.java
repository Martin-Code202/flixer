package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public class VoipCallConfigData {
    private static String TAG = "nf_log";
    @SerializedName("attributes")
    private VoipCallAttributes attributes;
    @SerializedName("tokenExpirationTS")
    private long tokenExpirationTS = Long.MAX_VALUE;
    @SerializedName("userToken")
    private String userToken;

    public String getUserToken() {
        return this.userToken;
    }

    public long getTokenExpirationTS() {
        return this.tokenExpirationTS;
    }

    public VoipCallAttributes getCallAttributes() {
        return this.attributes;
    }
}
