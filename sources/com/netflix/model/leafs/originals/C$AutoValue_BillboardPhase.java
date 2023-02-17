package com.netflix.model.leafs.originals;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* renamed from: com.netflix.model.leafs.originals.$AutoValue_BillboardPhase  reason: invalid class name */
abstract class C$AutoValue_BillboardPhase extends BillboardPhase {
    private final List<BillboardCTA> actions;
    private final String supplementalMessage;

    C$AutoValue_BillboardPhase(String str, List<BillboardCTA> list) {
        this.supplementalMessage = str;
        this.actions = list;
    }

    @Override // com.netflix.model.leafs.originals.BillboardPhase
    @SerializedName("supplementalMessage")
    public String supplementalMessage() {
        return this.supplementalMessage;
    }

    @Override // com.netflix.model.leafs.originals.BillboardPhase
    @SerializedName("actions")
    public List<BillboardCTA> actions() {
        return this.actions;
    }

    public String toString() {
        return "BillboardPhase{supplementalMessage=" + this.supplementalMessage + ", actions=" + this.actions + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BillboardPhase)) {
            return false;
        }
        BillboardPhase billboardPhase = (BillboardPhase) obj;
        if (this.supplementalMessage != null ? this.supplementalMessage.equals(billboardPhase.supplementalMessage()) : billboardPhase.supplementalMessage() == null) {
            if (this.actions != null ? this.actions.equals(billboardPhase.actions()) : billboardPhase.actions() == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((1000003 ^ (this.supplementalMessage == null ? 0 : this.supplementalMessage.hashCode())) * 1000003) ^ (this.actions == null ? 0 : this.actions.hashCode());
    }
}
