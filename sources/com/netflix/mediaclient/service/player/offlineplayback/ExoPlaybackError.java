package com.netflix.mediaclient.service.player.offlineplayback;

import com.netflix.mediaclient.servicemgr.IPlayer;
public class ExoPlaybackError implements IPlayer.aux {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f1779;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f1780;

    /* renamed from: ˎ  reason: contains not printable characters */
    private ExoPlaybackErrorCode f1781;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f1782;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f1783;

    public ExoPlaybackError(ExoPlaybackErrorCode exoPlaybackErrorCode, boolean z) {
        this.f1783 = z;
        this.f1781 = exoPlaybackErrorCode;
    }

    public enum ExoPlaybackErrorCode {
        NO_ERROR(0),
        AUDIO_LOAD_ERROR(1),
        VIDEO_LOAD_ERROR(2),
        AUDIOTRACK_INIT_ERROR(3),
        AUDIOTRACK_WRITE_ERROR(4),
        DECODER_INIT_ERROR(5),
        CRYPTO_ERROR(6),
        PLAYER_ERROR(7),
        SESSION_INIT_ERROR(8),
        MANIFEST_FAILURE(9),
        MPD_ERROR(10),
        SUBTITLE_ERROR(11),
        LAST_SESSION_STILL_BEING_ACQUIRED(32),
        LAST_SESSION_STILL_PREPARING(33),
        REOPENING_CLOSING_SESSION(34),
        RESTART_APP_SESSION_ERROR(35);
        

        /* renamed from: ʻॱ  reason: contains not printable characters */
        private final int f1801;

        private ExoPlaybackErrorCode(int i) {
            this.f1801 = i;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public int m1003() {
            return this.f1801;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m1002() {
        return this.f1780;
    }

    public ExoPlaybackError(ExoPlaybackErrorCode exoPlaybackErrorCode, String str, String str2, String str3) {
        this.f1781 = exoPlaybackErrorCode;
        this.f1782 = str;
        this.f1779 = str2;
        this.f1780 = str3;
    }

    @Override // com.netflix.mediaclient.servicemgr.IPlayer.aux
    /* renamed from: ˎ  reason: contains not printable characters */
    public String mo1000() {
        return "ExoPlaybackError: [code : " + this.f1781 + ", message : " + this.f1782 + " ]";
    }

    @Override // com.netflix.mediaclient.servicemgr.IPlayer.aux
    /* renamed from: ˊ  reason: contains not printable characters */
    public int mo998() {
        return this.f1781.m1003();
    }

    @Override // com.netflix.mediaclient.servicemgr.IPlayer.aux
    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo1001() {
        if (this.f1779 != null) {
            return this.f1779 + "." + this.f1781.m1003();
        }
        return Integer.toString(this.f1781.m1003());
    }

    @Override // com.netflix.mediaclient.servicemgr.IPlayer.aux
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo999() {
        return this.f1783;
    }

    @Override // com.netflix.mediaclient.servicemgr.IPlayer.aux
    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean mo997() {
        return this.f1781 == ExoPlaybackErrorCode.RESTART_APP_SESSION_ERROR;
    }
}
