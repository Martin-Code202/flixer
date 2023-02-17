package org.chromium.net.urlconnection;

import java.net.HttpRetryException;
import java.nio.ByteBuffer;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;
/* access modifiers changed from: package-private */
public final class CronetChunkedOutputStream extends CronetOutputStream {
    private final ByteBuffer mBuffer;
    private final CronetHttpURLConnection mConnection;
    private boolean mLastChunk = false;
    private final MessageLoop mMessageLoop;
    private final UploadDataProvider mUploadDataProvider = new UploadDataProviderImpl();

    CronetChunkedOutputStream(CronetHttpURLConnection cronetHttpURLConnection, int i, MessageLoop messageLoop) {
        if (cronetHttpURLConnection == null) {
            throw new NullPointerException();
        } else if (i <= 0) {
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        } else {
            this.mBuffer = ByteBuffer.allocate(i);
            this.mConnection = cronetHttpURLConnection;
            this.mMessageLoop = messageLoop;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
            ensureBufferHasRemaining();
        }
    }

    @Override // org.chromium.net.urlconnection.CronetOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        if (!this.mLastChunk) {
            this.mLastChunk = true;
            this.mBuffer.flip();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.chromium.net.urlconnection.CronetOutputStream
    public void setConnected() {
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
            return -1;
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= CronetChunkedOutputStream.this.mBuffer.remaining()) {
                byteBuffer.put(CronetChunkedOutputStream.this.mBuffer);
                CronetChunkedOutputStream.this.mBuffer.clear();
                uploadDataSink.onReadSucceeded(CronetChunkedOutputStream.this.mLastChunk);
                if (!CronetChunkedOutputStream.this.mLastChunk) {
                    CronetChunkedOutputStream.this.mMessageLoop.quit();
                    return;
                }
                return;
            }
            int limit = CronetChunkedOutputStream.this.mBuffer.limit();
            CronetChunkedOutputStream.this.mBuffer.limit(CronetChunkedOutputStream.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(CronetChunkedOutputStream.this.mBuffer);
            CronetChunkedOutputStream.this.mBuffer.limit(limit);
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) {
            uploadDataSink.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    private void ensureBufferHasRemaining() {
        if (!this.mBuffer.hasRemaining()) {
            uploadBufferInternal();
        }
    }

    private void uploadBufferInternal() {
        checkNotClosed();
        this.mBuffer.flip();
        this.mMessageLoop.loop();
        checkNoException();
    }
}
