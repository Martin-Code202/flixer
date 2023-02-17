package com.netflix.model.leafs.originals;

import com.google.gson.annotations.SerializedName;
/* renamed from: com.netflix.model.leafs.originals.$AutoValue_BillboardVideo  reason: invalid class name */
abstract class C$AutoValue_BillboardVideo extends BillboardVideo {
    private final boolean autoPlay;
    private final boolean isTrailer;
    private final String motionId;
    private final boolean motionShouldLoop;
    private final String motionUrl;

    C$AutoValue_BillboardVideo(String str, String str2, boolean z, boolean z2, boolean z3) {
        this.motionId = str;
        this.motionUrl = str2;
        this.motionShouldLoop = z;
        this.isTrailer = z2;
        this.autoPlay = z3;
    }

    @Override // com.netflix.model.leafs.originals.BillboardVideo
    @SerializedName("motionId")
    public String motionId() {
        return this.motionId;
    }

    @Override // com.netflix.model.leafs.originals.BillboardVideo
    @SerializedName("motionUrl")
    public String motionUrl() {
        return this.motionUrl;
    }

    @Override // com.netflix.model.leafs.originals.BillboardVideo
    @SerializedName("motionShouldLoop")
    public boolean motionShouldLoop() {
        return this.motionShouldLoop;
    }

    @Override // com.netflix.model.leafs.originals.BillboardVideo
    @SerializedName("isTrailer")
    public boolean isTrailer() {
        return this.isTrailer;
    }

    @Override // com.netflix.model.leafs.originals.BillboardVideo
    @SerializedName("autoPlay")
    public boolean autoPlay() {
        return this.autoPlay;
    }

    public String toString() {
        return "BillboardVideo{motionId=" + this.motionId + ", motionUrl=" + this.motionUrl + ", motionShouldLoop=" + this.motionShouldLoop + ", isTrailer=" + this.isTrailer + ", autoPlay=" + this.autoPlay + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BillboardVideo)) {
            return false;
        }
        BillboardVideo billboardVideo = (BillboardVideo) obj;
        if (this.motionId != null ? this.motionId.equals(billboardVideo.motionId()) : billboardVideo.motionId() == null) {
            if (this.motionUrl != null ? this.motionUrl.equals(billboardVideo.motionUrl()) : billboardVideo.motionUrl() == null) {
                if (this.motionShouldLoop == billboardVideo.motionShouldLoop() && this.isTrailer == billboardVideo.isTrailer() && this.autoPlay == billboardVideo.autoPlay()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((1000003 ^ (this.motionId == null ? 0 : this.motionId.hashCode())) * 1000003) ^ (this.motionUrl == null ? 0 : this.motionUrl.hashCode())) * 1000003) ^ (this.motionShouldLoop ? 1231 : 1237)) * 1000003) ^ (this.isTrailer ? 1231 : 1237)) * 1000003) ^ (this.autoPlay ? 1231 : 1237);
    }
}
