package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private long endUs = -9223372036854775807L;
    public final MediaPeriod mediaPeriod;
    private boolean pendingInitialDiscontinuity;
    private ClippingSampleStream[] sampleStreams = new ClippingSampleStream[0];
    private long startUs = -9223372036854775807L;

    public ClippingMediaPeriod(MediaPeriod mediaPeriod2, boolean z) {
        this.mediaPeriod = mediaPeriod2;
        this.pendingInitialDiscontinuity = z;
    }

    public void setClipping(long j, long j2) {
        this.startUs = j;
        this.endUs = j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        this.mediaPeriod.prepare(this, this.startUs + j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        this.sampleStreams = new ClippingSampleStream[sampleStreamArr.length];
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        for (int i = 0; i < sampleStreamArr.length; i++) {
            this.sampleStreams[i] = (ClippingSampleStream) sampleStreamArr[i];
            sampleStreamArr2[i] = this.sampleStreams[i] != null ? this.sampleStreams[i].stream : null;
        }
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr2, zArr2, this.startUs + j);
        if (this.pendingInitialDiscontinuity) {
            this.pendingInitialDiscontinuity = this.startUs != 0 && shouldKeepInitialDiscontinuity(trackSelectionArr);
        }
        Assertions.checkState(selectTracks == this.startUs + j || (selectTracks >= this.startUs && (this.endUs == Long.MIN_VALUE || selectTracks <= this.endUs)));
        for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
            if (sampleStreamArr2[i2] == null) {
                this.sampleStreams[i2] = null;
            } else if (sampleStreamArr[i2] == null || this.sampleStreams[i2].stream != sampleStreamArr2[i2]) {
                this.sampleStreams[i2] = new ClippingSampleStream(this, sampleStreamArr2[i2], this.startUs, this.endUs, this.pendingInitialDiscontinuity);
            }
            sampleStreamArr[i2] = this.sampleStreams[i2];
        }
        return selectTracks - this.startUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j) {
        this.mediaPeriod.discardBuffer(this.startUs + j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (this.pendingInitialDiscontinuity) {
            ClippingSampleStream[] clippingSampleStreamArr = this.sampleStreams;
            for (ClippingSampleStream clippingSampleStream : clippingSampleStreamArr) {
                if (clippingSampleStream != null) {
                    clippingSampleStream.clearPendingDiscontinuity();
                }
            }
            this.pendingInitialDiscontinuity = false;
            long readDiscontinuity = readDiscontinuity();
            if (readDiscontinuity != -9223372036854775807L) {
                return readDiscontinuity;
            }
            return 0;
        }
        long readDiscontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        Assertions.checkState(readDiscontinuity2 >= this.startUs);
        Assertions.checkState(this.endUs == Long.MIN_VALUE || readDiscontinuity2 <= this.endUs);
        return readDiscontinuity2 - this.startUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        if (this.endUs == Long.MIN_VALUE || bufferedPositionUs < this.endUs) {
            return Math.max(0L, bufferedPositionUs - this.startUs);
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        ClippingSampleStream[] clippingSampleStreamArr = this.sampleStreams;
        for (ClippingSampleStream clippingSampleStream : clippingSampleStreamArr) {
            if (clippingSampleStream != null) {
                clippingSampleStream.clearSentEos();
            }
        }
        long seekToUs = this.mediaPeriod.seekToUs(this.startUs + j);
        Assertions.checkState(seekToUs == this.startUs + j || (seekToUs >= this.startUs && (this.endUs == Long.MIN_VALUE || seekToUs <= this.endUs)));
        return seekToUs - this.startUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        if (this.endUs == Long.MIN_VALUE || nextLoadPositionUs < this.endUs) {
            return nextLoadPositionUs - this.startUs;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.mediaPeriod.continueLoading(this.startUs + j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod2) {
        Assertions.checkState((this.startUs == -9223372036854775807L || this.endUs == -9223372036854775807L) ? false : true);
        this.callback.onPrepared(this);
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
        this.callback.onContinueLoadingRequested(this);
    }

    private static boolean shouldKeepInitialDiscontinuity(TrackSelection[] trackSelectionArr) {
        for (TrackSelection trackSelection : trackSelectionArr) {
            if (!(trackSelection == null || MimeTypes.isAudio(trackSelection.getSelectedFormat().sampleMimeType))) {
                return true;
            }
        }
        return false;
    }

    static final class ClippingSampleStream implements SampleStream {
        private final long endUs;
        private final MediaPeriod mediaPeriod;
        private boolean pendingDiscontinuity;
        private boolean sentEos;
        private final long startUs;
        private final SampleStream stream;

        public ClippingSampleStream(MediaPeriod mediaPeriod2, SampleStream sampleStream, long j, long j2, boolean z) {
            this.mediaPeriod = mediaPeriod2;
            this.stream = sampleStream;
            this.startUs = j;
            this.endUs = j2;
            this.pendingDiscontinuity = z;
        }

        public void clearPendingDiscontinuity() {
            this.pendingDiscontinuity = false;
        }

        public void clearSentEos() {
            this.sentEos = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return this.stream.isReady();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
            this.stream.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (this.pendingDiscontinuity) {
                return -3;
            }
            if (this.sentEos) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            int readData = this.stream.readData(formatHolder, decoderInputBuffer, z);
            if (this.endUs == Long.MIN_VALUE || ((readData != -4 || decoderInputBuffer.timeUs < this.endUs) && !(readData == -3 && this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE))) {
                if (readData == -4 && !decoderInputBuffer.isEndOfStream()) {
                    decoderInputBuffer.timeUs -= this.startUs;
                }
                return readData;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.sentEos = true;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void skipData(long j) {
            this.stream.skipData(this.startUs + j);
        }
    }
}
