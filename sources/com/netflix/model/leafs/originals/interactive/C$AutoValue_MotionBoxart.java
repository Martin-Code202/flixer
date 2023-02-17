package com.netflix.model.leafs.originals.interactive;

import com.google.gson.annotations.SerializedName;
/* renamed from: com.netflix.model.leafs.originals.interactive.$AutoValue_MotionBoxart  reason: invalid class name */
abstract class C$AutoValue_MotionBoxart extends MotionBoxart {
    private final String overlayUrl;
    private final String url;

    C$AutoValue_MotionBoxart(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null url");
        }
        this.url = str;
        if (str2 == null) {
            throw new NullPointerException("Null overlayUrl");
        }
        this.overlayUrl = str2;
    }

    @Override // com.netflix.model.leafs.originals.interactive.MotionBoxart
    @SerializedName("url")
    public String url() {
        return this.url;
    }

    @Override // com.netflix.model.leafs.originals.interactive.MotionBoxart
    @SerializedName("overlayUrl")
    public String overlayUrl() {
        return this.overlayUrl;
    }

    public String toString() {
        return "MotionBoxart{url=" + this.url + ", overlayUrl=" + this.overlayUrl + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MotionBoxart)) {
            return false;
        }
        MotionBoxart motionBoxart = (MotionBoxart) obj;
        return this.url.equals(motionBoxart.url()) && this.overlayUrl.equals(motionBoxart.overlayUrl());
    }

    public int hashCode() {
        return ((1000003 ^ this.url.hashCode()) * 1000003) ^ this.overlayUrl.hashCode();
    }
}
