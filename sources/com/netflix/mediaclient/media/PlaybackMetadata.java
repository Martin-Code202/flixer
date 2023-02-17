package com.netflix.mediaclient.media;

import o.oM;
public interface PlaybackMetadata {
    PlaybackPreCacheData getPlaybackPreCacheData();

    String getPlayerName();

    int getVideoBitrate();

    String getVideoFlavor();

    String getVideoProfile();

    String toDisplayableString(oM oMVar, String str);
}
