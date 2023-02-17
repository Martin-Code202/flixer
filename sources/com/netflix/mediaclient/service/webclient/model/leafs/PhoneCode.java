package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
import o.C1457Fr;
public final class PhoneCode {
    @SerializedName("code")
    private final String code;
    @SerializedName("id")
    private final String id;
    @SerializedName("name")
    private final String name;

    public static /* synthetic */ PhoneCode copy$default(PhoneCode phoneCode, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = phoneCode.id;
        }
        if ((i & 2) != 0) {
            str2 = phoneCode.code;
        }
        if ((i & 4) != 0) {
            str3 = phoneCode.name;
        }
        return phoneCode.copy(str, str2, str3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.name;
    }

    public final PhoneCode copy(String str, String str2, String str3) {
        C1457Fr.m5025(str, "id");
        C1457Fr.m5025(str2, "code");
        C1457Fr.m5025(str3, "name");
        return new PhoneCode(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneCode)) {
            return false;
        }
        PhoneCode phoneCode = (PhoneCode) obj;
        return C1457Fr.m5018(this.id, phoneCode.id) && C1457Fr.m5018(this.code, phoneCode.code) && C1457Fr.m5018(this.name, phoneCode.name);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.code;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "PhoneCode(id=" + this.id + ", code=" + this.code + ", name=" + this.name + ")";
    }

    public PhoneCode(String str, String str2, String str3) {
        C1457Fr.m5025(str, "id");
        C1457Fr.m5025(str2, "code");
        C1457Fr.m5025(str3, "name");
        this.id = str;
        this.code = str2;
        this.name = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getName() {
        return this.name;
    }
}
