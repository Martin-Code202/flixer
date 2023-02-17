package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public class OfflineCodecPrefData {
    @SerializedName("isAVCHighCodecEnabled")
    public boolean isAVCHighCodecEnabled;
    @SerializedName("isEveVP9HWCodecEnabled")
    public boolean isEveVP9HWCodecEnabled;
    @SerializedName("isVP9HWCodecEnabled")
    public boolean isVP9HWCodecEnabled;
}
