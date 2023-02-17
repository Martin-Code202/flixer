package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import java.io.IOException;
public final class DummyDataSource implements DataSource {
    public static final DataSource.Factory FACTORY = new DataSource.Factory() { // from class: com.google.android.exoplayer2.upstream.DummyDataSource.1
        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public DataSource createDataSource() {
            return new DummyDataSource();
        }
    };
    public static final DummyDataSource INSTANCE = new DummyDataSource();

    private DummyDataSource() {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        throw new IOException("Dummy source");
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
    }
}
