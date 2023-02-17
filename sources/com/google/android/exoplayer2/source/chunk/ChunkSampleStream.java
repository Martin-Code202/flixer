package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> callback;
    private final T chunkSource;
    private final SampleQueue[] embeddedSampleQueues;
    private final int[] embeddedTrackTypes;
    private final boolean[] embeddedTracksSelected;
    private final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    long lastSeekPositionUs;
    private final Loader loader = new Loader("Loader:ChunkSampleStream");
    boolean loadingFinished;
    private final BaseMediaChunkOutput mediaChunkOutput;
    private final LinkedList<BaseMediaChunk> mediaChunks = new LinkedList<>();
    private final int minLoadableRetryCount;
    private final ChunkHolder nextChunkHolder = new ChunkHolder();
    private long pendingResetPositionUs;
    private Format primaryDownstreamTrackFormat;
    private final SampleQueue primarySampleQueue;
    private final int primaryTrackType;
    private final List<BaseMediaChunk> readOnlyMediaChunks = Collections.unmodifiableList(this.mediaChunks);

    public ChunkSampleStream(int i, int[] iArr, T t, SequenceableLoader.Callback<ChunkSampleStream<T>> callback2, Allocator allocator, long j, int i2, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher2) {
        this.primaryTrackType = i;
        this.embeddedTrackTypes = iArr;
        this.chunkSource = t;
        this.callback = callback2;
        this.eventDispatcher = eventDispatcher2;
        this.minLoadableRetryCount = i2;
        int length = iArr == null ? 0 : iArr.length;
        this.embeddedSampleQueues = new SampleQueue[length];
        this.embeddedTracksSelected = new boolean[length];
        int[] iArr2 = new int[(length + 1)];
        SampleQueue[] sampleQueueArr = new SampleQueue[(length + 1)];
        this.primarySampleQueue = new SampleQueue(allocator);
        iArr2[0] = i;
        sampleQueueArr[0] = this.primarySampleQueue;
        for (int i3 = 0; i3 < length; i3++) {
            SampleQueue sampleQueue = new SampleQueue(allocator);
            this.embeddedSampleQueues[i3] = sampleQueue;
            sampleQueueArr[i3 + 1] = sampleQueue;
            iArr2[i3 + 1] = iArr[i3];
        }
        this.mediaChunkOutput = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.pendingResetPositionUs = j;
        this.lastSeekPositionUs = j;
    }

    public void discardEmbeddedTracksTo(long j) {
        for (int i = 0; i < this.embeddedSampleQueues.length; i++) {
            this.embeddedSampleQueues[i].discardTo(j, true, this.embeddedTracksSelected[i]);
        }
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long j, int i) {
        for (int i2 = 0; i2 < this.embeddedSampleQueues.length; i2++) {
            if (this.embeddedTrackTypes[i2] == i) {
                Assertions.checkState(!this.embeddedTracksSelected[i2]);
                this.embeddedTracksSelected[i2] = true;
                this.embeddedSampleQueues[i2].rewind();
                this.embeddedSampleQueues[i2].advanceTo(j, true, true);
                return new EmbeddedSampleStream(this, this.embeddedSampleQueues[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public T getChunkSource() {
        return this.chunkSource;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        BaseMediaChunk baseMediaChunk;
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j = this.lastSeekPositionUs;
        BaseMediaChunk last = this.mediaChunks.getLast();
        if (last.isLoadCompleted()) {
            baseMediaChunk = last;
        } else {
            baseMediaChunk = this.mediaChunks.size() > 1 ? this.mediaChunks.get(this.mediaChunks.size() - 2) : null;
        }
        if (baseMediaChunk != null) {
            j = Math.max(j, baseMediaChunk.endTimeUs);
        }
        return Math.max(j, this.primarySampleQueue.getLargestQueuedTimestampUs());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void seekToUs(long r9) {
        /*
            r8 = this;
            r8.lastSeekPositionUs = r9
            boolean r0 = r8.isPendingReset()
            if (r0 != 0) goto L_0x001e
            com.google.android.exoplayer2.source.SampleQueue r0 = r8.primarySampleQueue
            long r1 = r8.getNextLoadPositionUs()
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r2 = 1
            boolean r0 = r0.advanceTo(r9, r2, r1)
            if (r0 == 0) goto L_0x001e
            r3 = 1
            goto L_0x001f
        L_0x001e:
            r3 = 0
        L_0x001f:
            if (r3 == 0) goto L_0x0043
            com.google.android.exoplayer2.source.SampleQueue r0 = r8.primarySampleQueue
            int r0 = r0.getReadIndex()
            r8.discardDownstreamMediaChunks(r0)
            com.google.android.exoplayer2.source.SampleQueue r0 = r8.primarySampleQueue
            r0.discardToRead()
            com.google.android.exoplayer2.source.SampleQueue[] r4 = r8.embeddedSampleQueues
            int r5 = r4.length
            r6 = 0
        L_0x0033:
            if (r6 >= r5) goto L_0x0042
            r7 = r4[r6]
            r7.rewind()
            r0 = 1
            r1 = 0
            r7.discardTo(r9, r0, r1)
            int r6 = r6 + 1
            goto L_0x0033
        L_0x0042:
            goto L_0x006e
        L_0x0043:
            r8.pendingResetPositionUs = r9
            r0 = 0
            r8.loadingFinished = r0
            java.util.LinkedList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r0 = r8.mediaChunks
            r0.clear()
            com.google.android.exoplayer2.upstream.Loader r0 = r8.loader
            boolean r0 = r0.isLoading()
            if (r0 == 0) goto L_0x005b
            com.google.android.exoplayer2.upstream.Loader r0 = r8.loader
            r0.cancelLoading()
            goto L_0x006e
        L_0x005b:
            com.google.android.exoplayer2.source.SampleQueue r0 = r8.primarySampleQueue
            r0.reset()
            com.google.android.exoplayer2.source.SampleQueue[] r4 = r8.embeddedSampleQueues
            int r5 = r4.length
            r6 = 0
        L_0x0064:
            if (r6 >= r5) goto L_0x006e
            r7 = r4[r6]
            r7.reset()
            int r6 = r6 + 1
            goto L_0x0064
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.ChunkSampleStream.seekToUs(long):void");
    }

    public void release() {
        if (!this.loader.release(this)) {
            this.primarySampleQueue.discardToEnd();
            for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
                sampleQueue.discardToEnd();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        this.primarySampleQueue.reset();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return this.loadingFinished || (!isPendingReset() && this.primarySampleQueue.hasNextSample());
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() {
        this.loader.maybeThrowError();
        if (!this.loader.isLoading()) {
            this.chunkSource.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (isPendingReset()) {
            return -3;
        }
        discardDownstreamMediaChunks(this.primarySampleQueue.getReadIndex());
        int read = this.primarySampleQueue.read(formatHolder, decoderInputBuffer, z, this.loadingFinished, this.lastSeekPositionUs);
        if (read == -4) {
            this.primarySampleQueue.discardToRead();
        }
        return read;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void skipData(long j) {
        if (!this.loadingFinished || j <= this.primarySampleQueue.getLargestQueuedTimestampUs()) {
            this.primarySampleQueue.advanceTo(j, true, true);
        } else {
            this.primarySampleQueue.advanceToEnd();
        }
        this.primarySampleQueue.discardToRead();
    }

    public void onLoadCompleted(Chunk chunk, long j, long j2) {
        this.chunkSource.onChunkLoadCompleted(chunk);
        this.eventDispatcher.loadCompleted(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
        this.callback.onContinueLoadingRequested(this);
    }

    public void onLoadCanceled(Chunk chunk, long j, long j2, boolean z) {
        this.eventDispatcher.loadCanceled(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
        if (!z) {
            this.primarySampleQueue.reset();
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            int length = sampleQueueArr.length;
            for (int i = 0; i < length; i++) {
                sampleQueueArr[i].reset();
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    public int onLoadError(Chunk chunk, long j, long j2, IOException iOException) {
        long bytesLoaded = chunk.bytesLoaded();
        boolean isMediaChunk = isMediaChunk(chunk);
        boolean z = false;
        if (this.chunkSource.onChunkLoadError(chunk, !isMediaChunk || bytesLoaded == 0 || this.mediaChunks.size() > 1, iOException)) {
            z = true;
            if (isMediaChunk) {
                BaseMediaChunk removeLast = this.mediaChunks.removeLast();
                Assertions.checkState(removeLast == chunk);
                this.primarySampleQueue.discardUpstreamSamples(removeLast.getFirstSampleIndex(0));
                for (int i = 0; i < this.embeddedSampleQueues.length; i++) {
                    this.embeddedSampleQueues[i].discardUpstreamSamples(removeLast.getFirstSampleIndex(i + 1));
                }
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
        }
        this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, bytesLoaded, iOException, z);
        if (!z) {
            return 0;
        }
        this.callback.onContinueLoadingRequested(this);
        return 2;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.loadingFinished || this.loader.isLoading()) {
            return false;
        }
        this.chunkSource.getNextChunk(this.mediaChunks.isEmpty() ? null : this.mediaChunks.getLast(), this.pendingResetPositionUs != -9223372036854775807L ? this.pendingResetPositionUs : j, this.nextChunkHolder);
        boolean z = this.nextChunkHolder.endOfStream;
        Chunk chunk = this.nextChunkHolder.chunk;
        this.nextChunkHolder.clear();
        if (z) {
            this.pendingResetPositionUs = -9223372036854775807L;
            this.loadingFinished = true;
            return true;
        } else if (chunk == null) {
            return false;
        } else {
            if (isMediaChunk(chunk)) {
                this.pendingResetPositionUs = -9223372036854775807L;
                BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                baseMediaChunk.init(this.mediaChunkOutput);
                this.mediaChunks.add(baseMediaChunk);
            }
            this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.minLoadableRetryCount));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return this.mediaChunks.getLast().endTimeUs;
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    /* access modifiers changed from: package-private */
    public boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    private void discardDownstreamMediaChunks(int i) {
        if (!this.mediaChunks.isEmpty()) {
            while (this.mediaChunks.size() > 1 && this.mediaChunks.get(1).getFirstSampleIndex(0) <= i) {
                this.mediaChunks.removeFirst();
            }
            BaseMediaChunk first = this.mediaChunks.getFirst();
            Format format = first.trackFormat;
            if (!format.equals(this.primaryDownstreamTrackFormat)) {
                this.eventDispatcher.downstreamFormatChanged(this.primaryTrackType, format, first.trackSelectionReason, first.trackSelectionData, first.startTimeUs);
            }
            this.primaryDownstreamTrackFormat = format;
        }
    }

    public final class EmbeddedSampleStream implements SampleStream {
        private final int index;
        public final ChunkSampleStream<T> parent;
        private final SampleQueue sampleQueue;

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue2, int i) {
            this.parent = chunkSampleStream;
            this.sampleQueue = sampleQueue2;
            this.index = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return ChunkSampleStream.this.loadingFinished || (!ChunkSampleStream.this.isPendingReset() && this.sampleQueue.hasNextSample());
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void skipData(long j) {
            if (!ChunkSampleStream.this.loadingFinished || j <= this.sampleQueue.getLargestQueuedTimestampUs()) {
                this.sampleQueue.advanceTo(j, true, true);
            } else {
                this.sampleQueue.advanceToEnd();
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (ChunkSampleStream.this.isPendingReset()) {
                return -3;
            }
            return this.sampleQueue.read(formatHolder, decoderInputBuffer, z, ChunkSampleStream.this.loadingFinished, ChunkSampleStream.this.lastSeekPositionUs);
        }

        public void release() {
            Assertions.checkState(ChunkSampleStream.this.embeddedTracksSelected[this.index]);
            ChunkSampleStream.this.embeddedTracksSelected[this.index] = false;
        }
    }
}
