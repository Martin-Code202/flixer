package com.google.android.exoplayer2.extractor;
public interface Extractor {
    void init(ExtractorOutput extractorOutput);

    int read(ExtractorInput extractorInput, PositionHolder positionHolder);

    void seek(long j, long j2);
}
