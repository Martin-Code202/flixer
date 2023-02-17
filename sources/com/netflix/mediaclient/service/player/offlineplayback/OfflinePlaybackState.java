package com.netflix.mediaclient.service.player.offlineplayback;
public enum OfflinePlaybackState {
    MANIFEST_FETCH("100.1"),
    MANIFEST_PROCESSING("101.1"),
    PLAYBACK_INIT("102.1"),
    PLAYBACK_PLAY("102.2");
    

    /* renamed from: ˏ  reason: contains not printable characters */
    String f1807;

    private OfflinePlaybackState(String str) {
        this.f1807 = str;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.f1807;
    }
}
