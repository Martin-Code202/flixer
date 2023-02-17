package com.google.android.exoplayer2;
public interface RendererCapabilities {
    int getTrackType();

    int supportsFormat(Format format);

    int supportsMixedMimeTypeAdaptation();
}
