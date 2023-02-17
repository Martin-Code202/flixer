package com.netflix.model.leafs.blades;

import com.google.gson.annotations.SerializedName;
/* renamed from: com.netflix.model.leafs.blades.$AutoValue_PreplayItemAction  reason: invalid class name */
abstract class C$AutoValue_PreplayItemAction extends PreplayItemAction {
    private final int bookmarkPosition;
    private final boolean doNotIncrementInterrupter;
    private final boolean ignoreBookmark;
    private final String name;
    private final int trackId;
    private final String type;
    private final String videoId;

    C$AutoValue_PreplayItemAction(int i, String str, String str2, String str3, int i2, boolean z, boolean z2) {
        this.bookmarkPosition = i;
        if (str == null) {
            throw new NullPointerException("Null type");
        }
        this.type = str;
        if (str2 == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str2;
        if (str3 == null) {
            throw new NullPointerException("Null videoId");
        }
        this.videoId = str3;
        this.trackId = i2;
        this.doNotIncrementInterrupter = z;
        this.ignoreBookmark = z2;
    }

    @Override // com.netflix.model.leafs.blades.PreplayItemAction
    @SerializedName("bookmarkPosition")
    public int bookmarkPosition() {
        return this.bookmarkPosition;
    }

    @Override // com.netflix.model.leafs.blades.PreplayItemAction
    @SerializedName("type")
    public String type() {
        return this.type;
    }

    @Override // com.netflix.model.leafs.blades.PreplayItemAction
    @SerializedName("name")
    public String name() {
        return this.name;
    }

    @Override // com.netflix.model.leafs.blades.PreplayItemAction
    @SerializedName("videoId")
    public String videoId() {
        return this.videoId;
    }

    @Override // com.netflix.model.leafs.blades.PreplayItemAction
    @SerializedName("trackId")
    public int trackId() {
        return this.trackId;
    }

    @Override // com.netflix.model.leafs.blades.PreplayItemAction
    @SerializedName("doNotIncrementInterrupter")
    public boolean doNotIncrementInterrupter() {
        return this.doNotIncrementInterrupter;
    }

    @Override // com.netflix.model.leafs.blades.PreplayItemAction
    @SerializedName("ignoreBookmark")
    public boolean ignoreBookmark() {
        return this.ignoreBookmark;
    }

    public String toString() {
        return "PreplayItemAction{bookmarkPosition=" + this.bookmarkPosition + ", type=" + this.type + ", name=" + this.name + ", videoId=" + this.videoId + ", trackId=" + this.trackId + ", doNotIncrementInterrupter=" + this.doNotIncrementInterrupter + ", ignoreBookmark=" + this.ignoreBookmark + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PreplayItemAction)) {
            return false;
        }
        PreplayItemAction preplayItemAction = (PreplayItemAction) obj;
        return this.bookmarkPosition == preplayItemAction.bookmarkPosition() && this.type.equals(preplayItemAction.type()) && this.name.equals(preplayItemAction.name()) && this.videoId.equals(preplayItemAction.videoId()) && this.trackId == preplayItemAction.trackId() && this.doNotIncrementInterrupter == preplayItemAction.doNotIncrementInterrupter() && this.ignoreBookmark == preplayItemAction.ignoreBookmark();
    }

    public int hashCode() {
        return ((((((((((((1000003 ^ this.bookmarkPosition) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.videoId.hashCode()) * 1000003) ^ this.trackId) * 1000003) ^ (this.doNotIncrementInterrupter ? 1231 : 1237)) * 1000003) ^ (this.ignoreBookmark ? 1231 : 1237);
    }
}
