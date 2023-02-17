package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
public final class DummyTrackOutput implements TrackOutput {
    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(Format format) {
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(ExtractorInput extractorInput, int i, boolean z) {
        int skip = extractorInput.skip(i);
        if (skip != -1) {
            return skip;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(i);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
    }
}
