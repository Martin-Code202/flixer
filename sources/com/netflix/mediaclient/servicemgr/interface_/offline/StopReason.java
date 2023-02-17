package com.netflix.mediaclient.servicemgr.interface_.offline;
public enum StopReason {
    Unknown(0, false),
    WaitingToBeStarted(1, false),
    NetworkError(2, true),
    StorageError(3, true),
    NotEnoughSpace(4, true),
    StoppedFromAgentAPI(5, false),
    NotAllowedOnCurrentNetwork(6, false),
    NoNetworkConnectivity(7, false),
    PlayerStreaming(10, false),
    AccountInActive(11, false),
    EncodesAreNotAvailableAnyMore(101, true),
    ManifestError(102, true),
    GeoCheckError(103, true),
    DownloadLimitRequiresManualResume(104, true),
    EncodesRevoked(105, true);
    

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final int f2836;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final boolean f2837;

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m1581() {
        return this.f2837;
    }

    private StopReason(int i, boolean z) {
        this.f2836 = i;
        this.f2837 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m1583() {
        return this.f2836;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static StopReason m1580(int i) {
        StopReason[] values = values();
        for (StopReason stopReason : values) {
            if (stopReason.m1583() == i) {
                return stopReason;
            }
        }
        return Unknown;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m1582() {
        return m1583() < 100;
    }
}
