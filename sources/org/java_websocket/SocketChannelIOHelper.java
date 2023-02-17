package org.java_websocket;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
public class SocketChannelIOHelper {
    static final /* synthetic */ boolean $assertionsDisabled = (!SocketChannelIOHelper.class.desiredAssertionStatus());

    public static boolean read(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, ByteChannel byteChannel) {
        byteBuffer.clear();
        int read = byteChannel.read(byteBuffer);
        byteBuffer.flip();
        if (read != -1) {
            return read != 0;
        }
        webSocketImpl.eot();
        return false;
    }

    public static boolean readMore(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, WrappedByteChannel wrappedByteChannel) {
        byteBuffer.clear();
        int readMore = wrappedByteChannel.readMore(byteBuffer);
        byteBuffer.flip();
        if (readMore != -1) {
            return wrappedByteChannel.isNeedRead();
        }
        webSocketImpl.eot();
        return false;
    }

    public static void writeBlocking(WebSocketImpl webSocketImpl, ByteChannel byteChannel) {
        if (!$assertionsDisabled && (byteChannel instanceof AbstractSelectableChannel) && !((AbstractSelectableChannel) byteChannel).isBlocking()) {
            throw new AssertionError();
        } else if ($assertionsDisabled || !(byteChannel instanceof WrappedByteChannel) || ((WrappedByteChannel) byteChannel).isBlocking()) {
            ByteBuffer take = webSocketImpl.outQueue.take();
            while (take.hasRemaining()) {
                byteChannel.write(take);
            }
        } else {
            throw new AssertionError();
        }
    }
}
