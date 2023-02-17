package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;
public interface Renderer extends ExoPlayer.ExoPlayerComponent {
    void disable();

    void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, long j2);

    RendererCapabilities getCapabilities();

    MediaClock getMediaClock();

    int getState();

    SampleStream getStream();

    @Override // com.google.android.exoplayer2.RendererCapabilities
    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError();

    void render(long j, long j2);

    void replaceStream(Format[] formatArr, SampleStream sampleStream, long j);

    void resetPosition(long j);

    void setCurrentStreamFinal();

    void setIndex(int i);

    void start();

    void stop();
}
