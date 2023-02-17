package com.google.android.exoplayer2.source.chunk;
public interface ChunkSource {
    void getNextChunk(MediaChunk mediaChunk, long j, ChunkHolder chunkHolder);

    void maybeThrowError();

    void onChunkLoadCompleted(Chunk chunk);

    boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc);
}
