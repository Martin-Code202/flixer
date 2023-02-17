package com.netflix.mediaclient.service.player.streamingplayback;
public enum StreamingPlaybackErrorCode {
    NO_ERROR(0),
    MANIFEST_FETCH_ERROR(1),
    MANIFEST_PROCESS_ERROR(2),
    MANIFEST_CACHE_EXTRACT_ERROR(3),
    LICENSE_SESSION_UNAVAILABLE_ERROR(10),
    LICENSE_FETCH_ERROR(11),
    LICENSE_STORE_ERROR(12),
    LICENSE_SESSION_EXCEPTION_ERROR(13),
    MEDIA_INITIALIZATION_ERROR(20),
    MEDIA_PLAYBACK_ERROR(21),
    SUBTITLE_ERROR(31),
    LAST_SESSION_STILL_BEING_ACQUIRED(32),
    LAST_SESSION_STILL_PREPARING(33),
    REOPENING_CLOSING_SESSION(34),
    RESTART_APP_SESSION_ERROR(35);
    

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final int f1824;

    private StreamingPlaybackErrorCode(int i) {
        this.f1824 = i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m1004() {
        return this.f1824;
    }
}
