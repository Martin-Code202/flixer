package com.netflix.model.leafs.originals;

import com.google.gson.annotations.SerializedName;
/* renamed from: com.netflix.model.leafs.originals.$AutoValue_VideoAssets  reason: invalid class name */
abstract class C$AutoValue_VideoAssets extends VideoAssets {
    private final BillboardVideo horizontalBackground;

    C$AutoValue_VideoAssets(BillboardVideo billboardVideo) {
        if (billboardVideo == null) {
            throw new NullPointerException("Null horizontalBackground");
        }
        this.horizontalBackground = billboardVideo;
    }

    @Override // com.netflix.model.leafs.originals.VideoAssets
    @SerializedName("horizontalBackground")
    public BillboardVideo horizontalBackground() {
        return this.horizontalBackground;
    }

    public String toString() {
        return "VideoAssets{horizontalBackground=" + this.horizontalBackground + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VideoAssets) {
            return this.horizontalBackground.equals(((VideoAssets) obj).horizontalBackground());
        }
        return false;
    }

    public int hashCode() {
        return 1000003 ^ this.horizontalBackground.hashCode();
    }
}
