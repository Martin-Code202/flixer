package com.netflix.mediaclient.service.offline.registry;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.util.Map;
public class MetaRegistry {
    transient RegistryData mCurrentRegistryData;
    @SerializedName("isPaused")
    public boolean mDownloadsPausedByUser = false;
    @SerializedName("geoCountryCode")
    public String mGeoCountryCode;
    @SerializedName("writeCounter")
    public int mMetaRegistryWriteCounter;
    @SerializedName("primaryProfileGuid")
    public String mPrimaryProfileGuid;
    @SerializedName("regMap")
    public Map<Integer, RegistryData> mRegMap;
    @SerializedName("activeRegId")
    public int mUserSelectedRegId;
    @SerializedName(LoggingRequest.VERSION)
    private final int mVersion;

    public MetaRegistry(int i) {
        this.mVersion = i;
    }

    public boolean isCurrentlySelected(RegistryData registryData) {
        return this.mCurrentRegistryData != null && registryData.mRegId == this.mCurrentRegistryData.mRegId;
    }
}
