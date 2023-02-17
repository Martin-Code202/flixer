package com.netflix.mediaclient.service.configuration.crypto;
public enum CryptoProvider {
    LEGACY("", 0),
    WIDEVINE_L1("", 1),
    WIDEVINE_L3("L3-", 3);
    

    /* renamed from: ˋ  reason: contains not printable characters */
    public final String f1088;

    /* renamed from: ˏ  reason: contains not printable characters */
    public final int f1089;

    private CryptoProvider(String str, int i) {
        this.f1088 = str;
        this.f1089 = i;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static CryptoProvider m503(String str) {
        if (LEGACY.name().equals(str)) {
            return LEGACY;
        }
        if (WIDEVINE_L1.name().equals(str)) {
            return WIDEVINE_L1;
        }
        if (WIDEVINE_L3.name().equals(str)) {
            return WIDEVINE_L3;
        }
        return null;
    }
}
