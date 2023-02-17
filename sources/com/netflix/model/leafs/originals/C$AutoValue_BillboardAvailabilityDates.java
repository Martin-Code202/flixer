package com.netflix.model.leafs.originals;

import com.google.gson.annotations.SerializedName;
/* renamed from: com.netflix.model.leafs.originals.$AutoValue_BillboardAvailabilityDates  reason: invalid class name */
abstract class C$AutoValue_BillboardAvailabilityDates extends BillboardAvailabilityDates {
    private final Long start;

    C$AutoValue_BillboardAvailabilityDates(Long l) {
        this.start = l;
    }

    @Override // com.netflix.model.leafs.originals.BillboardAvailabilityDates
    @SerializedName("start")
    public Long start() {
        return this.start;
    }

    public String toString() {
        return "BillboardAvailabilityDates{start=" + this.start + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BillboardAvailabilityDates)) {
            return false;
        }
        BillboardAvailabilityDates billboardAvailabilityDates = (BillboardAvailabilityDates) obj;
        if (this.start == null) {
            return billboardAvailabilityDates.start() == null;
        }
        return this.start.equals(billboardAvailabilityDates.start());
    }

    public int hashCode() {
        return 1000003 ^ (this.start == null ? 0 : this.start.hashCode());
    }
}
