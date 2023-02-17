package com.netflix.mediaclient.servicemgr.interface_.offline;
public enum DownloadVideoQuality {
    DEFAULT("DEFAULT"),
    BEST("BEST"),
    UNKNOWN("");
    

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f2819;

    private DownloadVideoQuality(String str) {
        this.f2819 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static DownloadVideoQuality m1578(String str) {
        DownloadVideoQuality[] values = values();
        for (DownloadVideoQuality downloadVideoQuality : values) {
            if (downloadVideoQuality.f2819.equalsIgnoreCase(str)) {
                return downloadVideoQuality;
            }
        }
        return DEFAULT;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m1579() {
        return this.f2819;
    }
}
