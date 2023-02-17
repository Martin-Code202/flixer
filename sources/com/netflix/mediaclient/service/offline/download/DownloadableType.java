package com.netflix.mediaclient.service.offline.download;
public enum DownloadableType {
    Audio("nfa"),
    Video("nfv"),
    Subtitle("nfs"),
    TrickPlay("nfi");
    

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f1544;

    private DownloadableType(String str) {
        this.f1544 = str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m823() {
        return this.f1544;
    }
}
