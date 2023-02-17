package com.netflix.mediaclient.service.webclient.model.leafs;

import o.C1457Fr;
public final class TermsOfUseData {
    private final String minAge;
    private final String region;
    private final String showCheckbox;

    public static /* synthetic */ TermsOfUseData copy$default(TermsOfUseData termsOfUseData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = termsOfUseData.region;
        }
        if ((i & 2) != 0) {
            str2 = termsOfUseData.showCheckbox;
        }
        if ((i & 4) != 0) {
            str3 = termsOfUseData.minAge;
        }
        return termsOfUseData.copy(str, str2, str3);
    }

    public final String component1() {
        return this.region;
    }

    public final String component2() {
        return this.showCheckbox;
    }

    public final String component3() {
        return this.minAge;
    }

    public final TermsOfUseData copy(String str, String str2, String str3) {
        C1457Fr.m5025(str, "region");
        C1457Fr.m5025(str2, "showCheckbox");
        C1457Fr.m5025(str3, "minAge");
        return new TermsOfUseData(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TermsOfUseData)) {
            return false;
        }
        TermsOfUseData termsOfUseData = (TermsOfUseData) obj;
        return C1457Fr.m5018(this.region, termsOfUseData.region) && C1457Fr.m5018(this.showCheckbox, termsOfUseData.showCheckbox) && C1457Fr.m5018(this.minAge, termsOfUseData.minAge);
    }

    public int hashCode() {
        String str = this.region;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.showCheckbox;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.minAge;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "TermsOfUseData(region=" + this.region + ", showCheckbox=" + this.showCheckbox + ", minAge=" + this.minAge + ")";
    }

    public TermsOfUseData(String str, String str2, String str3) {
        C1457Fr.m5025(str, "region");
        C1457Fr.m5025(str2, "showCheckbox");
        C1457Fr.m5025(str3, "minAge");
        this.region = str;
        this.showCheckbox = str2;
        this.minAge = str3;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getShowCheckbox() {
        return this.showCheckbox;
    }

    public final String getMinAge() {
        return this.minAge;
    }
}
