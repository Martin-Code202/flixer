package com.google.android.exoplayer2.decoder;
public final class DecoderCounters {
    public int decoderInitCount;
    public int decoderReleaseCount;
    public int droppedOutputBufferCount;
    public int inputBufferCount;
    public int maxConsecutiveDroppedOutputBufferCount;
    public int renderedOutputBufferCount;
    public int skippedOutputBufferCount;

    public synchronized void ensureUpdated() {
    }
}
