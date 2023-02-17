package com.netflix.mediaclient.servicemgr;

import com.netflix.mediaclient.util.ConnectivityUtils;
public enum PlayerPrefetchSource {
    ContinueWatching(0, false, true),
    DetailsPage(200, true, true),
    DetailsPageFromSearch(200, true, true),
    PostPlay(1000, false, false),
    MobileComingSoon(300, false, false),
    Previews(300, false, false),
    BigRow(0, false, true),
    PrePlay(2000, false, false);
    

    /* renamed from: ʽ  reason: contains not printable characters */
    private final boolean f2657;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f2658;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final int f2659;

    private PlayerPrefetchSource(int i, boolean z, boolean z2) {
        this.f2659 = i;
        this.f2657 = z;
        this.f2658 = z2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m1561() {
        return this.f2659;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m1560() {
        return this.f2657;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m1562(ConnectivityUtils.NetType netType) {
        return netType == ConnectivityUtils.NetType.mobile && this.f2658;
    }
}
