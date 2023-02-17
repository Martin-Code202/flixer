package com.netflix.mediaclient.service.offline.agent;
public enum OfflineUnavailableReason {
    NA_OFFLINE_STORAGE_NOT_AVAILABLE(1),
    NA_MSL_CLIENT_DISABLED(2),
    NA_DISABLED_FROM_END_POINT(3),
    NA_WIDE_VINE_UNRECOVERABLE(4),
    NA_NO_EXTERNAL_STORAGE(5),
    NA_DISABLED_BY_SYSTEM_ID_4266(6),
    NA_DISABLED_BY_SYSTEM_ID_4266_FROM_SERVER(7);
    

    /* renamed from: ʼ  reason: contains not printable characters */
    private final int f1538;

    private OfflineUnavailableReason(int i) {
        this.f1538 = i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m822() {
        return "OF.NA." + this.f1538;
    }
}
