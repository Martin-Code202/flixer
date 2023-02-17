package com.netflix.mediaclient.net;
public enum NetworkRequestType {
    PLAY_MANIFEST,
    PLAY_LICENSE,
    PLAY_PREFETCH_MANIFEST,
    PLAY_PREFETCH_LICENSE,
    PLAY_OTHER,
    BROWSE_PREFETCH,
    BROWSE,
    BROWSE_LOG,
    CONFIG,
    AUI,
    PDS_EVENT,
    PDS_KEEP_ALIVE,
    PDS_KEEP_ALIVE_BACKGROUND,
    LOG_CL,
    LOG_CLV2,
    LOG_ADV_ID,
    LOG_PRESENTATION,
    LOG_BLOB,
    LOG,
    RELEASE_LICENSE,
    API,
    LOG_VOIP,
    CONFIG_VOIP,
    VERIFY_LOGIN,
    CONTENT_AUDIO,
    CONTENT_VIDEO,
    CONTENT_SUBTITLES,
    CONTENT_BOXART;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static NetworkRequestType m477(String str) {
        if (str == null) {
            return null;
        }
        NetworkRequestType[] values = values();
        for (NetworkRequestType networkRequestType : values) {
            if (str.equals(networkRequestType.name())) {
                return networkRequestType;
            }
        }
        if (str.startsWith("java.lang.Object")) {
            return API;
        }
        return null;
    }
}
