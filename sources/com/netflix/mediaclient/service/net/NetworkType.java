package com.netflix.mediaclient.service.net;
public enum NetworkType {
    NONE(Integer.MIN_VALUE, "NONE"),
    UNKNOWN(0, "UNKNOWN"),
    EDGE(2, "EDGE"),
    UMTS(3, "UMTS"),
    CDMA(4, "CDMA"),
    EVDO_0(5, "EVDO_0"),
    EVDO_A(6, "EVDO_A"),
    _1xRTT(7, "1xRTT"),
    HSDPA(8, "HSDPA"),
    HSUPA(9, "HSUPA"),
    HSPA(10, "HSPA"),
    IDEN(11, "IDEN"),
    EVDO_B(12, "EVDO_B"),
    LTE(13, "LTE"),
    EHRPD(14, "EHRPD"),
    GPRS(1, "GPRS"),
    HSPAP(15, "HSPAP");
    

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private String f1524;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private int f1525;

    private NetworkType(int i, String str) {
        this.f1525 = i;
        this.f1524 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static NetworkType m814(int i) {
        for (int i2 = 0; i2 < values().length; i2++) {
            if (values()[i2].f1525 == i) {
                return values()[i2];
            }
        }
        return NONE;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m815(NetworkType networkType) {
        return UMTS.equals(networkType) || HSDPA.equals(networkType) || HSPA.equals(networkType) || EVDO_0.equals(networkType) || EVDO_A.equals(networkType) || EVDO_B.equals(networkType) || _1xRTT.equals(networkType) || HSUPA.equals(networkType) || EHRPD.equals(networkType) || HSPAP.equals(networkType);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m816(NetworkType networkType) {
        return EDGE.equals(networkType) || IDEN.equals(networkType) || CDMA.equals(networkType) || GPRS.equals(networkType);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m817(NetworkType networkType) {
        return LTE.equals(networkType);
    }
}
