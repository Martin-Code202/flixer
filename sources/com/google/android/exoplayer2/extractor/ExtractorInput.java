package com.google.android.exoplayer2.extractor;
public interface ExtractorInput {
    long getLength();

    long getPosition();

    void peekFully(byte[] bArr, int i, int i2);

    int read(byte[] bArr, int i, int i2);

    void readFully(byte[] bArr, int i, int i2);

    boolean readFully(byte[] bArr, int i, int i2, boolean z);

    void resetPeekPosition();

    int skip(int i);

    void skipFully(int i);
}
