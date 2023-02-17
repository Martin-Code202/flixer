package org.java_websocket;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;
public class AbstractWrappedByteChannel implements WrappedByteChannel {
    private final ByteChannel channel;

    public AbstractWrappedByteChannel(ByteChannel byteChannel) {
        this.channel = byteChannel;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        return this.channel.read(byteBuffer);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.channel.isOpen();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.channel.close();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        return this.channel.write(byteBuffer);
    }

    @Override // org.java_websocket.WrappedByteChannel
    public boolean isNeedRead() {
        if (this.channel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) this.channel).isNeedRead();
        }
        return false;
    }

    @Override // org.java_websocket.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) {
        if (this.channel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) this.channel).readMore(byteBuffer);
        }
        return 0;
    }

    @Override // org.java_websocket.WrappedByteChannel
    public boolean isBlocking() {
        if (this.channel instanceof SocketChannel) {
            return ((SocketChannel) this.channel).isBlocking();
        }
        if (this.channel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) this.channel).isBlocking();
        }
        return false;
    }
}
