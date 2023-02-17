package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import o.AE;
import o.C1349Bv;
public class NonMemberData {
    private static final String TAG = "nf_config_nrm";
    @SerializedName(LoggingRequest.NETFLIX_ID)
    public String netflixId;
    @SerializedName("secureNetflixId")
    public String secureNetflixId;

    public NonMemberData(String str, String str2) {
        this.netflixId = str;
        this.secureNetflixId = str2;
    }

    public static NonMemberData fromJsonString(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return (NonMemberData) AE.m3322().fromJson(str, (Class<Object>) NonMemberData.class);
    }

    public String toJsonString() {
        return AE.m3322().toJson(this);
    }

    public boolean isValid() {
        return C1349Bv.m4107(this.netflixId) && C1349Bv.m4107(this.secureNetflixId);
    }
}
