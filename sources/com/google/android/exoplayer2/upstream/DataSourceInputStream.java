package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import java.io.InputStream;
public final class DataSourceInputStream extends InputStream {
    private boolean closed = false;
    private final DataSource dataSource;
    private final DataSpec dataSpec;
    private boolean opened = false;
    private final byte[] singleByteArray;
    private long totalBytesRead;

    public DataSourceInputStream(DataSource dataSource2, DataSpec dataSpec2) {
        this.dataSource = dataSource2;
        this.dataSpec = dataSpec2;
        this.singleByteArray = new byte[1];
    }

    public long bytesRead() {
        return this.totalBytesRead;
    }

    public void open() {
        checkOpened();
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.singleByteArray) == -1) {
            return -1;
        }
        return this.singleByteArray[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        Assertions.checkState(!this.closed);
        checkOpened();
        int read = this.dataSource.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.totalBytesRead += (long) read;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            this.dataSource.close();
            this.closed = true;
        }
    }

    private void checkOpened() {
        if (!this.opened) {
            this.dataSource.open(this.dataSpec);
            this.opened = true;
        }
    }
}
