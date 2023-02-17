package org.chromium.net.urlconnection;

import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;
/* access modifiers changed from: package-private */
public final class CronetFixedModeOutputStream extends CronetOutputStream {
    private static int sDefaultBufferLength = 16384;
    private final ByteBuffer mBuffer;
    private long mBytesWritten;
    private final CronetHttpURLConnection mConnection;
    private final long mContentLength;
    private final MessageLoop mMessageLoop;
    private final UploadDataProvider mUploadDataProvider = new UploadDataProviderImpl();

    CronetFixedModeOutputStream(CronetHttpURLConnection cronetHttpURLConnection, long j, MessageLoop messageLoop) {
        if (cronetHttpURLConnection == null) {
            throw new NullPointerException();
        } else if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        } else {
            this.mContentLength = j;
            this.mBuffer = ByteBuffer.allocate((int) Math.min(this.mContentLength, (long) sDefaultBufferLength));
            this.mConnection = cronetHttpURLConnection;
            this.mMessageLoop = messageLoop;
            this.mBytesWritten = 0;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        checkNotClosed();
        checkNotExceedContentLength(1);
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) i);
        this.mBytesWritten++;
        uploadIfComplete();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        checkNotExceedContentLength(i2);
        int i3 = i2;
        while (i3 > 0) {
            ensureBufferHasRemaining();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.mBytesWritten += (long) i2;
        uploadIfComplete();
    }

    private void ensureBufferHasRemaining() {
        if (!this.mBuffer.hasRemaining()) {
            uploadBufferInternal();
        }
    }

    private void uploadIfComplete() {
        if (this.mBytesWritten == this.mContentLength) {
            uploadBufferInternal();
        }
    }

    private void uploadBufferInternal() {
        checkNotClosed();
        this.mBuffer.flip();
        this.mMessageLoop.loop();
        checkNoException();
    }

    private void checkNotExceedContentLength(int i) {
        if (this.mBytesWritten + ((long) i) > this.mContentLength) {
            throw new ProtocolException("expected " + (this.mContentLength - this.mBytesWritten) + " bytes but received " + i);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.chromium.net.urlconnection.CronetOutputStream
    public void setConnected() {
    }

    /* access modifiers changed from: package-private */
    @Override // org.chromium.net.urlconnection.CronetOutputStream
    public void checkReceivedEnoughContent() {
        if (this.mBytesWritten < this.mContentLength) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
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
            return CronetFixedModeOutputStream.this.mContentLength;
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= CronetFixedModeOutputStream.this.mBuffer.remaining()) {
                byteBuffer.put(CronetFixedModeOutputStream.this.mBuffer);
                CronetFixedModeOutputStream.this.mBuffer.clear();
                uploadDataSink.onReadSucceeded(false);
                CronetFixedModeOutputStream.this.mMessageLoop.quit();
                return;
            }
            int limit = CronetFixedModeOutputStream.this.mBuffer.limit();
            CronetFixedModeOutputStream.this.mBuffer.limit(CronetFixedModeOutputStream.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(CronetFixedModeOutputStream.this.mBuffer);
            CronetFixedModeOutputStream.this.mBuffer.limit(limit);
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) {
            uploadDataSink.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
