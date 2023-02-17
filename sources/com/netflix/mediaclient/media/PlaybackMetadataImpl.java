package com.netflix.mediaclient.media;

import android.util.Pair;
import o.C0561;
import o.oM;
public final class PlaybackMetadataImpl implements PlaybackMetadata {
    public long mAudioHit;
    public long mDuration;
    public boolean mLdlHit;
    public boolean mManifestCacheHit;
    public long mPlayDelay;
    public String mPlayerName;
    private C0561 mStreamingStat;
    public long mVideoBitRate;
    public String mVideoDecoderName;
    public String mVideoFlavor;
    public long mVideoHit;
    private String mVideoProfile;
    public Pair<Integer, Integer> mVideoResolution = Pair.create(0, 0);

    private String getAudioTrackType(AudioSource audioSource) {
        if (audioSource == null) {
            return "unknown";
        }
        switch (audioSource.getTrackType()) {
            case 0:
                return "primary";
            case 1:
                return "commentary";
            case 2:
                return "assistive";
            default:
                return "unknown";
        }
    }

    private String getAudioChannel(AudioSource audioSource) {
        if (audioSource == null) {
            return "-1";
        }
        switch (audioSource.getNumChannels()) {
            case 1:
                return "Mono";
            case 2:
                return "Stereo";
            case 3:
            case 4:
            case 5:
            default:
                return "-1";
            case 6:
                return "5.1";
            case 7:
                return "6.1";
            case 8:
                return "7.1";
        }
    }

    public void setStreamingStat(C0561 r1) {
        this.mStreamingStat = r1;
    }

    @Override // com.netflix.mediaclient.media.PlaybackMetadata
    public int getVideoBitrate() {
        if (this.mStreamingStat != null) {
            return this.mStreamingStat.m14639();
        }
        return 0;
    }

    public void setPlayerManifestData(PlayerManifestData playerManifestData) {
        if (playerManifestData != null) {
            this.mDuration = playerManifestData.getDuration();
            this.mVideoProfile = playerManifestData.getVideoProfileTag();
            this.mVideoFlavor = playerManifestData.getRawVideoProfileType();
            return;
        }
        this.mVideoProfile = "";
        this.mVideoFlavor = "";
    }

    @Override // com.netflix.mediaclient.media.PlaybackMetadata
    public String toDisplayableString(oM oMVar, String str) {
        return "n/a";
    }

    @Override // com.netflix.mediaclient.media.PlaybackMetadata
    public String getVideoProfile() {
        return this.mVideoProfile;
    }

    @Override // com.netflix.mediaclient.media.PlaybackMetadata
    public String getPlayerName() {
        return this.mPlayerName;
    }

    @Override // com.netflix.mediaclient.media.PlaybackMetadata
    public String getVideoFlavor() {
        return this.mVideoFlavor;
    }

    @Override // com.netflix.mediaclient.media.PlaybackMetadata
    public PlaybackPreCacheData getPlaybackPreCacheData() {
        return new PlaybackPreCacheData(this.mManifestCacheHit, this.mLdlHit, this.mAudioHit, this.mVideoHit);
    }
}
