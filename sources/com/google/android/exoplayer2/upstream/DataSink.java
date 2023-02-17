package com.google.android.exoplayer2.upstream;
public interface DataSink {
    void close();

    void open(DataSpec dataSpec);

    void write(byte[] bArr, int i, int i2);
}
