package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
import o.AE;
import o.C1349Bv;
public class NrmLanguagesData {
    private static final String TAG = "nf_languages_nrm";
    @SerializedName("default")
    public String defaultLanguage;
    @SerializedName("localizedNames")
    public String[] localizedNames;
    @SerializedName("tags")
    public String[] tags;

    public static NrmLanguagesData fromJsonString(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return (NrmLanguagesData) AE.m3322().fromJson(str, (Class<Object>) NrmLanguagesData.class);
    }

    public String toJsonString() {
        return AE.m3322().toJson(this);
    }
}
