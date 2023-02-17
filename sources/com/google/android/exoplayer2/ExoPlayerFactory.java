package com.google.android.exoplayer2;

import com.google.android.exoplayer2.trackselection.TrackSelector;
public final class ExoPlayerFactory {
    public static SimpleExoPlayer newSimpleInstance(RenderersFactory renderersFactory, TrackSelector trackSelector) {
        return newSimpleInstance(renderersFactory, trackSelector, new DefaultLoadControl());
    }

    public static SimpleExoPlayer newSimpleInstance(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl) {
        return new SimpleExoPlayer(renderersFactory, trackSelector, loadControl);
    }
}
