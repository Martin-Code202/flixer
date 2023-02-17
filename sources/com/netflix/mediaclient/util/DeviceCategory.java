package com.netflix.mediaclient.util;
public enum DeviceCategory {
    UNKNOWN("unknown"),
    PHONE("phone"),
    TABLET("tablet"),
    GOOGLE_TV("google-tv"),
    ANDROID_TV("android-tv"),
    CHROME_OS("chrome-os"),
    ANDROID_STB("android-stb");
    

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f3991;

    private DeviceCategory(String str) {
        this.f3991 = str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m2972() {
        return this.f3991;
    }
}
