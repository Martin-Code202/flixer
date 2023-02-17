package com.netflix.mediaclient.service.player.bladerunnerclient.volley;
public enum EdgeApiError {
    HystrixTimeout(4000),
    NOT_KNOWN_TO_CLIENT(-7778);
    

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f1728;

    private EdgeApiError(int i) {
        this.f1728 = i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private int m982() {
        return this.f1728;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static EdgeApiError m983(int i) {
        EdgeApiError[] values = values();
        for (EdgeApiError edgeApiError : values) {
            if (edgeApiError.m982() == i) {
                return edgeApiError;
            }
        }
        return NOT_KNOWN_TO_CLIENT;
    }
}
