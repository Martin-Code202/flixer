package org.chromium.net.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;
final class InputStreamChannel implements ReadableByteChannel {
    private final InputStream mInputStream;
    private final AtomicBoolean mIsOpen = new AtomicBoolean(true);

    private InputStreamChannel(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    static ReadableByteChannel wrap(InputStream inputStream) {
        if (inputStream instanceof FileInputStream) {
            return ((FileInputStream) inputStream).getChannel();
        }
        return new InputStreamChannel(inputStream);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        int i;
        if (byteBuffer.hasArray()) {
            i = this.mInputStream.read(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            if (i > 0) {
                byteBuffer.position(byteBuffer.position() + i);
            }
        } else {
            byte[] bArr = new byte[Math.min(16384, Math.min(Math.max(this.mInputStream.available(), 4096), byteBuffer.remaining()))];
            i = this.mInputStream.read(bArr);
            if (i > 0) {
                byteBuffer.put(bArr, 0, i);
            }
        }
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (this.mIsOpen.compareAndSet(true, false)) {
            this.mInputStream.close();
        }
    }
}
