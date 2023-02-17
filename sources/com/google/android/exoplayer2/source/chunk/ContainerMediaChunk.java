package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
public class ContainerMediaChunk extends BaseMediaChunk {
    private volatile int bytesLoaded;
    private final int chunkCount;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private volatile boolean loadCompleted;
    private final long sampleOffsetUs;

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, int i2, int i3, long j3, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, format, i, obj, j, j2, i2);
        this.chunkCount = i3;
        this.sampleOffsetUs = j3;
        this.extractorWrapper = chunkExtractorWrapper;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public int getNextChunkIndex() {
        return this.chunkIndex + this.chunkCount;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // com.google.android.exoplayer2.source.chunk.Chunk
    public final long bytesLoaded() {
        return (long) this.bytesLoaded;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final boolean isLoadCanceled() {
        return this.loadCanceled;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() {
        DataSpec subrange = this.dataSpec.subrange((long) this.bytesLoaded);
        try {
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, subrange.absoluteStreamPosition, this.dataSource.open(subrange));
            if (this.bytesLoaded == 0) {
                BaseMediaChunkOutput output = getOutput();
                output.setSampleOffsetUs(this.sampleOffsetUs);
                this.extractorWrapper.init(output);
            }
            try {
                Extractor extractor = this.extractorWrapper.extractor;
                int i = 0;
                while (i == 0 && !this.loadCanceled) {
                    this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
                    i = extractor.read(defaultExtractorInput, null);
                }
                Assertions.checkState(i != 1);
                this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
                this.loadCompleted = true;
            } catch (Throwable th) {
                this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
                throw th;
            }
        } finally {
            Util.closeQuietly(this.dataSource);
        }
    }
}
