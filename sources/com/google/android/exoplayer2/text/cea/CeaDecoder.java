package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;
import java.util.PriorityQueue;
abstract class CeaDecoder implements SubtitleDecoder {
    private final LinkedList<SubtitleInputBuffer> availableInputBuffers = new LinkedList<>();
    private final LinkedList<SubtitleOutputBuffer> availableOutputBuffers;
    private SubtitleInputBuffer dequeuedInputBuffer;
    private long playbackPositionUs;
    private final PriorityQueue<SubtitleInputBuffer> queuedInputBuffers;

    /* access modifiers changed from: protected */
    public abstract Subtitle createSubtitle();

    /* access modifiers changed from: protected */
    public abstract void decode(SubtitleInputBuffer subtitleInputBuffer);

    /* access modifiers changed from: protected */
    public abstract boolean isNewSubtitleDataAvailable();

    public CeaDecoder() {
        for (int i = 0; i < 10; i++) {
            this.availableInputBuffers.add(new SubtitleInputBuffer());
        }
        this.availableOutputBuffers = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.availableOutputBuffers.add(new CeaOutputBuffer(this));
        }
        this.queuedInputBuffers = new PriorityQueue<>();
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
        this.playbackPositionUs = j;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public SubtitleInputBuffer dequeueInputBuffer() {
        Assertions.checkState(this.dequeuedInputBuffer == null);
        if (this.availableInputBuffers.isEmpty()) {
            return null;
        }
        this.dequeuedInputBuffer = this.availableInputBuffers.pollFirst();
        return this.dequeuedInputBuffer;
    }

    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        Assertions.checkArgument(subtitleInputBuffer == this.dequeuedInputBuffer);
        if (subtitleInputBuffer.isDecodeOnly()) {
            releaseInputBuffer(subtitleInputBuffer);
        } else {
            this.queuedInputBuffers.add(subtitleInputBuffer);
        }
        this.dequeuedInputBuffer = null;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public SubtitleOutputBuffer dequeueOutputBuffer() {
        if (this.availableOutputBuffers.isEmpty()) {
            return null;
        }
        while (!this.queuedInputBuffers.isEmpty() && this.queuedInputBuffers.peek().timeUs <= this.playbackPositionUs) {
            SubtitleInputBuffer poll = this.queuedInputBuffers.poll();
            if (poll.isEndOfStream()) {
                SubtitleOutputBuffer pollFirst = this.availableOutputBuffers.pollFirst();
                pollFirst.addFlag(4);
                releaseInputBuffer(poll);
                return pollFirst;
            }
            decode(poll);
            if (isNewSubtitleDataAvailable()) {
                Subtitle createSubtitle = createSubtitle();
                if (!poll.isDecodeOnly()) {
                    SubtitleOutputBuffer pollFirst2 = this.availableOutputBuffers.pollFirst();
                    pollFirst2.setContent(poll.timeUs, createSubtitle, Long.MAX_VALUE);
                    releaseInputBuffer(poll);
                    return pollFirst2;
                }
            }
            releaseInputBuffer(poll);
        }
        return null;
    }

    private void releaseInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        subtitleInputBuffer.clear();
        this.availableInputBuffers.add(subtitleInputBuffer);
    }

    /* access modifiers changed from: protected */
    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.availableOutputBuffers.add(subtitleOutputBuffer);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        this.playbackPositionUs = 0;
        while (!this.queuedInputBuffers.isEmpty()) {
            releaseInputBuffer(this.queuedInputBuffers.poll());
        }
        if (this.dequeuedInputBuffer != null) {
            releaseInputBuffer(this.dequeuedInputBuffer);
            this.dequeuedInputBuffer = null;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }
}
