package com.netflix.model.leafs.blades;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* renamed from: com.netflix.model.leafs.blades.$AutoValue_PrePlayItem  reason: invalid class name */
abstract class C$AutoValue_PrePlayItem extends PrePlayItem {
    private final List<PreplayItemAction> actions;
    private final String impressionData;
    private final String supplementalMessage;
    private final String title;
    private final String type;

    C$AutoValue_PrePlayItem(String str, String str2, String str3, String str4, List<PreplayItemAction> list) {
        if (str == null) {
            throw new NullPointerException("Null impressionData");
        }
        this.impressionData = str;
        if (str2 == null) {
            throw new NullPointerException("Null type");
        }
        this.type = str2;
        if (str3 == null) {
            throw new NullPointerException("Null title");
        }
        this.title = str3;
        if (str4 == null) {
            throw new NullPointerException("Null supplementalMessage");
        }
        this.supplementalMessage = str4;
        if (list == null) {
            throw new NullPointerException("Null actions");
        }
        this.actions = list;
    }

    @Override // com.netflix.model.leafs.blades.PrePlayItem
    @SerializedName("impressionData")
    public String impressionData() {
        return this.impressionData;
    }

    @Override // com.netflix.model.leafs.blades.PrePlayItem
    @SerializedName("type")
    public String type() {
        return this.type;
    }

    @Override // com.netflix.model.leafs.blades.PrePlayItem
    @SerializedName("title")
    public String title() {
        return this.title;
    }

    @Override // com.netflix.model.leafs.blades.PrePlayItem
    @SerializedName("supplementalMessage")
    public String supplementalMessage() {
        return this.supplementalMessage;
    }

    @Override // com.netflix.model.leafs.blades.PrePlayItem
    @SerializedName("actions")
    public List<PreplayItemAction> actions() {
        return this.actions;
    }

    public String toString() {
        return "PrePlayItem{impressionData=" + this.impressionData + ", type=" + this.type + ", title=" + this.title + ", supplementalMessage=" + this.supplementalMessage + ", actions=" + this.actions + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrePlayItem)) {
            return false;
        }
        PrePlayItem prePlayItem = (PrePlayItem) obj;
        return this.impressionData.equals(prePlayItem.impressionData()) && this.type.equals(prePlayItem.type()) && this.title.equals(prePlayItem.title()) && this.supplementalMessage.equals(prePlayItem.supplementalMessage()) && this.actions.equals(prePlayItem.actions());
    }

    public int hashCode() {
        return ((((((((1000003 ^ this.impressionData.hashCode()) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.title.hashCode()) * 1000003) ^ this.supplementalMessage.hashCode()) * 1000003) ^ this.actions.hashCode();
    }
}
