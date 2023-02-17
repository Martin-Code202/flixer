package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.netflix.mediaclient.service.net.NetworkType;
public class CurrentNetworkInfo {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f1912;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final NetType f1913;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Integer f1914;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final NetSpec f1915;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Integer f1916;

    private CurrentNetworkInfo(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        int i = 0;
        if (telephonyManager != null) {
            this.f1912 = telephonyManager.getSimOperatorName();
            i = telephonyManager.getPhoneType();
            String simOperator = telephonyManager.getSimOperator();
            if (simOperator == null || simOperator.length() <= 4) {
                this.f1914 = null;
                this.f1916 = null;
            } else {
                this.f1914 = Integer.valueOf(Integer.parseInt(simOperator.substring(0, 3)));
                this.f1916 = Integer.valueOf(Integer.parseInt(simOperator.substring(3)));
            }
        } else {
            this.f1912 = null;
            this.f1914 = null;
            this.f1916 = null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.f1913 = NetType.m1043(activeNetworkInfo, i);
            this.f1915 = NetSpec.m1042(activeNetworkInfo);
            return;
        }
        this.f1913 = NetType.NONE;
        this.f1915 = NetSpec.UNKNOWN;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static CurrentNetworkInfo m1036(Context context) {
        return new CurrentNetworkInfo(context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CurrentNetworkInfo currentNetworkInfo = (CurrentNetworkInfo) obj;
        if (this.f1916 != null) {
            if (!this.f1916.equals(currentNetworkInfo.f1916)) {
                return false;
            }
        } else if (currentNetworkInfo.f1916 != null) {
            return false;
        }
        if (this.f1914 != null) {
            if (!this.f1914.equals(currentNetworkInfo.f1914)) {
                return false;
            }
        } else if (currentNetworkInfo.f1914 != null) {
            return false;
        }
        if (this.f1912 != null) {
            if (!this.f1912.equals(currentNetworkInfo.f1912)) {
                return false;
            }
        } else if (currentNetworkInfo.f1912 != null) {
            return false;
        }
        return this.f1913 == currentNetworkInfo.f1913 && this.f1915 == currentNetworkInfo.f1915;
    }

    public int hashCode() {
        return ((((((((this.f1916 != null ? this.f1916.hashCode() : 0) * 31) + (this.f1914 != null ? this.f1914.hashCode() : 0)) * 31) + (this.f1912 != null ? this.f1912.hashCode() : 0)) * 31) + (this.f1913 != null ? this.f1913.hashCode() : 0)) * 31) + (this.f1915 != null ? this.f1915.hashCode() : 0);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Integer m1041() {
        return this.f1916;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Integer m1037() {
        return this.f1914;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m1038() {
        return this.f1912;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public NetType m1039() {
        return this.f1913;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public NetSpec m1040() {
        return this.f1915;
    }

    public enum NetType {
        MOBILE,
        GSM,
        CDMA,
        WIMAX,
        WIFI,
        WIRED,
        BLUETOOTH,
        NONE;

        /* renamed from: ॱ  reason: contains not printable characters */
        public static NetType m1043(NetworkInfo networkInfo, int i) {
            switch (networkInfo.getType()) {
                case 1:
                    return WIFI;
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                default:
                    switch (i) {
                        case 1:
                            return GSM;
                        case 2:
                            return CDMA;
                        default:
                            return MOBILE;
                    }
                case 6:
                    return WIMAX;
                case 7:
                    return BLUETOOTH;
                case 9:
                    return WIRED;
            }
        }
    }

    public enum NetSpec {
        CELL_2G,
        CELL_3G,
        CELL_4G,
        WIRED,
        WIFI,
        MOBILE,
        UNKNOWN;

        /* renamed from: ˎ  reason: contains not printable characters */
        public static NetSpec m1042(NetworkInfo networkInfo) {
            switch (networkInfo.getType()) {
                case 1:
                    return WIFI;
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                default:
                    NetworkType r1 = NetworkType.m814(networkInfo.getSubtype());
                    if (NetworkType.m816(r1)) {
                        return CELL_2G;
                    }
                    if (NetworkType.m815(r1)) {
                        return CELL_3G;
                    }
                    if (NetworkType.m817(r1)) {
                        return CELL_4G;
                    }
                    return MOBILE;
                case 6:
                case 7:
                    return CELL_4G;
                case 9:
                    return WIRED;
            }
        }
    }
}
