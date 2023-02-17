package com.netflix.mediaclient.service.net;
public enum IpConnectivityPolicy {
    IP_V4_ONLY(0),
    IP_V6_ONLY(1),
    IP_V4_V6(2),
    IP_V6_V4(3);
    

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f1497;

    private IpConnectivityPolicy(int i) {
        this.f1497 = i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static IpConnectivityPolicy m811(int i) {
        switch (i) {
            case 0:
                return IP_V4_ONLY;
            case 1:
                return IP_V6_ONLY;
            case 2:
                return IP_V4_V6;
            case 3:
                return IP_V6_V4;
            default:
                return null;
        }
    }
}
