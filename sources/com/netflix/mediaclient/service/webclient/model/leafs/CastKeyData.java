package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
import o.AE;
import o.C1349Bv;
public class CastKeyData {
    private static final String TAG = "nf_cast";
    @SerializedName("key")
    public String key;
    @SerializedName("keyId")
    public String keyId;

    public static CastKeyData fromJsonString(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return (CastKeyData) AE.m3322().fromJson(str, (Class<Object>) CastKeyData.class);
    }

    public String toJsonString() {
        return AE.m3322().toJson(this);
    }
}
