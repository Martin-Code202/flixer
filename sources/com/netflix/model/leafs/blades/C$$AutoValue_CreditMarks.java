package com.netflix.model.leafs.blades;

import com.google.gson.annotations.SerializedName;
/* renamed from: com.netflix.model.leafs.blades.$$AutoValue_CreditMarks  reason: invalid class name */
abstract class C$$AutoValue_CreditMarks extends CreditMarks {
    private final int endCredit;
    private final int endRecap;
    private final int startCredit;
    private final int startRecap;

    C$$AutoValue_CreditMarks(int i, int i2, int i3, int i4) {
        this.startCredit = i;
        this.endCredit = i2;
        this.startRecap = i3;
        this.endRecap = i4;
    }

    @Override // com.netflix.model.leafs.blades.CreditMarks
    @SerializedName("startcredit")
    public int startCredit() {
        return this.startCredit;
    }

    @Override // com.netflix.model.leafs.blades.CreditMarks
    @SerializedName("endcredit")
    public int endCredit() {
        return this.endCredit;
    }

    @Override // com.netflix.model.leafs.blades.CreditMarks
    @SerializedName("startrecap")
    public int startRecap() {
        return this.startRecap;
    }

    @Override // com.netflix.model.leafs.blades.CreditMarks
    @SerializedName("endrecap")
    public int endRecap() {
        return this.endRecap;
    }

    @Override // java.lang.Object
    public String toString() {
        return "CreditMarks{startCredit=" + this.startCredit + ", endCredit=" + this.endCredit + ", startRecap=" + this.startRecap + ", endRecap=" + this.endRecap + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreditMarks)) {
            return false;
        }
        CreditMarks creditMarks = (CreditMarks) obj;
        return this.startCredit == creditMarks.startCredit() && this.endCredit == creditMarks.endCredit() && this.startRecap == creditMarks.startRecap() && this.endRecap == creditMarks.endRecap();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((((((1000003 ^ this.startCredit) * 1000003) ^ this.endCredit) * 1000003) ^ this.startRecap) * 1000003) ^ this.endRecap;
    }
}
