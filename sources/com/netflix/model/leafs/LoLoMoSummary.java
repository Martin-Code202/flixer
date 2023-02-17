package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import java.util.Map;
import o.AbstractC0847;
import o.AbstractC0852;
import o.C1283;
import o.C1349Bv;
import o.pA;
public class LoLoMoSummary extends AbstractC0847 implements pA, AbstractC0852 {
    private static final String TAG = "LoLoMoSummary";
    @SerializedName("fromCache")
    private boolean fromCache;
    @SerializedName("expiryTimeStamp")
    private long mExpiryTimeStamp;
    @SerializedName("id")
    private String mId;
    @SerializedName("length")
    private int mNumLoMos;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("profileGuid")
    private String profileGuid;

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        C1283.m16851(TAG, "Got Lolomo summary response: %s", asJsonObject);
        for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1106363674:
                    if (key.equals("length")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3355:
                    if (key.equals("id")) {
                        c = 0;
                        break;
                    }
                    break;
                case 110371416:
                    if (key.equals("title")) {
                        c = 1;
                        break;
                    }
                    break;
                case 177313746:
                    if (key.equals("profileGuid")) {
                        c = 4;
                        break;
                    }
                    break;
                case 306021635:
                    if (key.equals("expiryTimeStamp")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.mId = entry.getValue().getAsString();
                    break;
                case 1:
                    this.mTitle = C1349Bv.m4128(entry.getValue().getAsString());
                    break;
                case 2:
                    this.mExpiryTimeStamp = entry.getValue().getAsLong();
                    break;
                case 3:
                    this.mNumLoMos = entry.getValue().getAsInt();
                    break;
                case 4:
                    this.profileGuid = entry.getValue().getAsString();
                    break;
            }
        }
    }

    @Override // o.AbstractC2069pr
    public String getId() {
        return this.mId;
    }

    @Override // o.AbstractC2069pr
    public String getTitle() {
        return this.mTitle;
    }

    @Override // o.pA
    public int getNumLoMos() {
        return this.mNumLoMos;
    }

    public long getExpiryTimeStamp() {
        return this.mExpiryTimeStamp;
    }

    public String getLolomoProfileGuid() {
        return this.profileGuid;
    }

    public String getLolomoId() {
        return this.mId;
    }

    @Override // o.AbstractC2069pr
    public LoMoType getType() {
        return LoMoType.STANDARD;
    }

    public boolean isFromCache() {
        return this.fromCache;
    }

    public void setFromCache(boolean z) {
        this.fromCache = z;
    }
}
