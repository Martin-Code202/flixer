package org.chromium.net;

import java.nio.ByteBuffer;
public final class UploadDataProviders {

    /* access modifiers changed from: package-private */
    /* renamed from: org.chromium.net.UploadDataProviders$1  reason: invalid class name */
    public static class AnonymousClass1 {
    }

    public static UploadDataProvider create(ByteBuffer byteBuffer) {
        return new ByteBufferUploadProvider(byteBuffer.slice(), null);
    }

    public static UploadDataProvider create(byte[] bArr, int i, int i2) {
        return new ByteBufferUploadProvider(ByteBuffer.wrap(bArr, i, i2).slice(), null);
    }

    public static UploadDataProvider create(byte[] bArr) {
        return create(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    public static final class ByteBufferUploadProvider extends UploadDataProvider {
        private final ByteBuffer mUploadBuffer;

        /* synthetic */ ByteBufferUploadProvider(ByteBuffer byteBuffer, AnonymousClass1 r2) {
            this(byteBuffer);
        }

        private ByteBufferUploadProvider(ByteBuffer byteBuffer) {
            this.mUploadBuffer = byteBuffer;
        }

        @Override // org.chromium.net.UploadDataProvider
        public long getLength() {
            return (long) this.mUploadBuffer.limit();
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            if (byteBuffer.remaining() >= this.mUploadBuffer.remaining()) {
                byteBuffer.put(this.mUploadBuffer);
            } else {
                int limit = this.mUploadBuffer.limit();
                this.mUploadBuffer.limit(this.mUploadBuffer.position() + byteBuffer.remaining());
                byteBuffer.put(this.mUploadBuffer);
                this.mUploadBuffer.limit(limit);
            }
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) {
            this.mUploadBuffer.position(0);
            uploadDataSink.onRewindSucceeded();
        }
    }
}
