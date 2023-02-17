package com.netflix.mediaclient.service.net;

import android.net.NetworkInfo;
public enum LogMobileType {
    _2G("2g"),
    _3G("3g"),
    _4G("4g"),
    WIFI("wifi"),
    MOBILE("mobile"),
    UKNOWN("uknown");
    

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f1505;

    private LogMobileType(String str) {
        this.f1505 = str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static LogMobileType m813(NetworkType networkType) {
        if (networkType == null) {
            return UKNOWN;
        }
        if (NetworkType.m816(networkType)) {
            return _2G;
        }
        if (NetworkType.m815(networkType)) {
            return _3G;
        }
        if (NetworkType.m817(networkType)) {
            return _4G;
        }
        if (NetworkType.UNKNOWN.equals(networkType)) {
            return MOBILE;
        }
        return UKNOWN;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static LogMobileType m812(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return null;
        }
        if (networkInfo.getType() == 6) {
            return _4G;
        }
        if (networkInfo.getType() == 1) {
            return WIFI;
        }
        return m813(NetworkType.m814(networkInfo.getSubtype()));
    }
}
