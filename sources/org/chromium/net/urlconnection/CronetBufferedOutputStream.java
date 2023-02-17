package org.chromium.net.urlconnection;

import java.net.ProtocolException;
import java.nio.ByteBuffer;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;
/* access modifiers changed from: package-private */
public final class CronetBufferedOutputStream extends CronetOutputStream {
    private ByteBuffer mBuffer;
    private boolean mConnected = false;
    private final CronetHttpURLConnection mConnection;
    private final int mInitialContentLength;
    private final UploadDataProvider mUploadDataProvider = new UploadDataProviderImpl();

    CronetBufferedOutputStream(CronetHttpURLConnection cronetHttpURLConnection, long j) {
        if (cronetHttpURLConnection == null) {
            throw new NullPointerException("Argument connection cannot be null.");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
        } else if (j < 0) {
            throw new IllegalArgumentException("Content length < 0.");
        } else {
            this.mConnection = cronetHttpURLConnection;
            this.mInitialContentLength = (int) j;
            this.mBuffer = ByteBuffer.allocate(this.mInitialContentLength);
        }
    }

    CronetBufferedOutputStream(CronetHttpURLConnection cronetHttpURLConnection) {
        if (cronetHttpURLConnection == null) {
            throw new NullPointerException();
        }
        this.mConnection = cronetHttpURLConnection;
        this.mInitialContentLength = -1;
        this.mBuffer = ByteBuffer.allocate(16384);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        checkNotClosed();
        ensureCanWrite(1);
        this.mBuffer.put((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        checkNotClosed();
        ensureCanWrite(i2);
        this.mBuffer.put(bArr, i, i2);
    }

    private void ensureCanWrite(int i) {
        if (this.mInitialContentLength != -1 && this.mBuffer.position() + i > this.mInitialContentLength) {
            throw new ProtocolException("exceeded content-length limit of " + this.mInitialContentLength + " bytes");
        } else if (this.mConnected) {
            throw new IllegalStateException("Cannot write after being connected.");
        } else if (this.mInitialContentLength == -1 && this.mBuffer.limit() - this.mBuffer.position() <= i) {
            ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.mBuffer.capacity() * 2, this.mBuffer.capacity() + i));
            this.mBuffer.flip();
            allocate.put(this.mBuffer);
            this.mBuffer = allocate;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.chromium.net.urlconnection.CronetOutputStream
    public void setConnected() {
        this.mConnected = true;
        if (this.mBuffer.position() < this.mInitialContentLength) {
            throw new ProtocolException("Content received is less than Content-Length");
        }
        this.mBuffer.flip();
    }

    /* access modifiers changed from: package-private */
    @Override // org.chromium.net.urlconnection.CronetOutputStream
    public void checkReceivedEnoughContent() {
    }

    /* access modifiers changed from: package-private */
    @Override // org.chromium.net.urlconnection.CronetOutputStream
    public UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    class UploadDataProviderImpl extends UploadDataProvider {
        private UploadDataProviderImpl() {
        }

        @Override // org.chromium.net.UploadDataProvider
        public long getLength() {
            if (CronetBufferedOutputStream.this.mInitialContentLength == -1) {
                return CronetBufferedOutputStream.this.mConnected ? (long) CronetBufferedOutputStream.this.mBuffer.limit() : (long) CronetBufferedOutputStream.this.mBuffer.position();
            }
            return (long) CronetBufferedOutputStream.this.mInitialContentLength;
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (remaining < CronetBufferedOutputStream.this.mBuffer.remaining()) {
                byteBuffer.put(CronetBufferedOutputStream.this.mBuffer.array(), CronetBufferedOutputStream.this.mBuffer.position(), remaining);
                CronetBufferedOutputStream.this.mBuffer.position(CronetBufferedOutputStream.this.mBuffer.position() + remaining);
            } else {
                byteBuffer.put(CronetBufferedOutputStream.this.mBuffer);
            }
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) {
            CronetBufferedOutputStream.this.mBuffer.position(0);
            uploadDataSink.onRewindSucceeded();
        }
    }
}
