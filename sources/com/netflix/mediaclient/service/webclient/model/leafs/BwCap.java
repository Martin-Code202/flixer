package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public final class BwCap {
    @SerializedName("auto")
    private int auto;
    @SerializedName("low")
    private int low;

    public static /* synthetic */ BwCap copy$default(BwCap bwCap, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bwCap.auto;
        }
        if ((i3 & 2) != 0) {
            i2 = bwCap.low;
        }
        return bwCap.copy(i, i2);
    }

    public final int component1() {
        return this.auto;
    }

    public final int component2() {
        return this.low;
    }

    public final BwCap copy(int i, int i2) {
        return new BwCap(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BwCap)) {
            return false;
        }
        BwCap bwCap = (BwCap) obj;
        if (!(this.auto == bwCap.auto)) {
            return false;
        }
        return this.low == bwCap.low;
    }

    public int hashCode() {
        return (this.auto * 31) + this.low;
    }

    public String toString() {
        return "BwCap(auto=" + this.auto + ", low=" + this.low + ")";
    }

    public BwCap(int i, int i2) {
        this.auto = i;
        this.low = i2;
    }

    public final int getAuto() {
        return this.auto;
    }

    public final int getLow() {
        return this.low;
    }

    public final void setAuto(int i) {
        this.auto = i;
    }

    public final void setLow(int i) {
        this.low = i;
    }
}
