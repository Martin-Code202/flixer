package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
public interface Player {

    public interface EventListener {
        void onLoadingChanged(boolean z);

        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);

        void onPlayerError(ExoPlaybackException exoPlaybackException);

        void onPlayerStateChanged(boolean z, int i);

        void onPositionDiscontinuity();

        void onTimelineChanged(Timeline timeline, Object obj);

        void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);
    }

    void addListener(EventListener eventListener);

    long getBufferedPosition();

    Object getCurrentManifest();

    long getCurrentPosition();

    TrackSelectionArray getCurrentTrackSelections();

    boolean getPlayWhenReady();

    int getPlaybackState();

    int getRendererCount();

    int getRendererType(int i);

    void release();

    void removeListener(EventListener eventListener);

    void seekTo(long j);

    void setPlayWhenReady(boolean z);

    void stop();
}
