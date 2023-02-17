package com.netflix.mediaclient.util.l10n;
public enum BidiMarker {
    FORCED_RTL(8207),
    FORCED_LTR(8206),
    EMBEDDING_RTL(8235),
    EMBEDDING_LTR(8234);
    

    /* renamed from: ˏ  reason: contains not printable characters */
    char f4045;

    private BidiMarker(char c) {
        this.f4045 = c;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public char m3068() {
        return this.f4045;
    }
}
