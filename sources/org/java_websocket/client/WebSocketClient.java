package org.java_websocket.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.java_websocket.SocketChannelIOHelper;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketFactory;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WrappedByteChannel;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
public abstract class WebSocketClient extends WebSocketAdapter implements Runnable {
    static final /* synthetic */ boolean $assertionsDisabled = (!WebSocketClient.class.desiredAssertionStatus());
    private SocketChannel channel;
    private CountDownLatch closeLatch;
    private WebSocketImpl conn;
    private CountDownLatch connectLatch;
    private Draft draft;
    private Map<String, String> headers;
    private InetSocketAddress proxyAddress;
    private Thread readthread;
    private int timeout;
    protected URI uri;
    private ByteChannel wrappedchannel;
    private Thread writethread;
    private WebSocketClientFactory wsfactory;

    public interface WebSocketClientFactory extends WebSocketFactory {
        ByteChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey, String str, int i);
    }

    public abstract void onClose(int i, String str, boolean z);

    public abstract void onError(Exception exc);

    public abstract void onMessage(String str);

    public abstract void onOpen(ServerHandshake serverHandshake);

    public WebSocketClient(URI uri2) {
        this(uri2, new Draft_10());
    }

    public WebSocketClient(URI uri2, Draft draft2) {
        this(uri2, draft2, null, 0);
    }

    public WebSocketClient(URI uri2, Draft draft2, Map<String, String> map, int i) {
        this.uri = null;
        this.conn = null;
        this.channel = null;
        this.wrappedchannel = null;
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.timeout = 0;
        this.wsfactory = new DefaultWebSocketClientFactory(this);
        this.proxyAddress = null;
        if (uri2 == null) {
            throw new IllegalArgumentException();
        } else if (draft2 == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else {
            this.uri = uri2;
            this.draft = draft2;
            this.headers = map;
            this.timeout = i;
            try {
                this.channel = SelectorProvider.provider().openSocketChannel();
                this.channel.configureBlocking(true);
            } catch (IOException e) {
                this.channel = null;
                onWebsocketError(null, e);
            }
            if (this.channel == null) {
                this.conn = (WebSocketImpl) this.wsfactory.createWebSocket(this, draft2, null);
                this.conn.close(-1, "Failed to create or configure SocketChannel.");
                return;
            }
            this.conn = (WebSocketImpl) this.wsfactory.createWebSocket(this, draft2, this.channel.socket());
        }
    }

    public void connect() {
        if (this.writethread != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        this.writethread = new Thread(this);
        this.writethread.start();
    }

    public boolean connectBlocking() {
        connect();
        this.connectLatch.await();
        return this.conn.isOpen();
    }

    public void close() {
        if (this.writethread != null) {
            this.conn.close(1000);
        }
    }

    public void send(String str) {
        this.conn.send(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.writethread == null) {
            this.writethread = Thread.currentThread();
        }
        interruptableRun();
        if (!$assertionsDisabled && this.channel.isOpen()) {
            throw new AssertionError();
        }
    }

    private final void interruptableRun() {
        int i;
        String str;
        if (this.channel != null) {
            try {
                if (this.proxyAddress != null) {
                    str = this.proxyAddress.getHostName();
                    i = this.proxyAddress.getPort();
                } else {
                    str = this.uri.getHost();
                    i = getPort();
                }
                this.channel.connect(new InetSocketAddress(str, i));
                WebSocketImpl webSocketImpl = this.conn;
                ByteChannel createProxyChannel = createProxyChannel(this.wsfactory.wrapChannel(this.channel, null, str, i));
                this.wrappedchannel = createProxyChannel;
                webSocketImpl.channel = createProxyChannel;
                this.timeout = 0;
                sendHandshake();
                this.readthread = new Thread(new WebsocketWriteThread());
                this.readthread.start();
                ByteBuffer allocate = ByteBuffer.allocate(WebSocketImpl.RCVBUF);
                while (this.channel.isOpen()) {
                    try {
                        if (SocketChannelIOHelper.read(allocate, this.conn, this.wrappedchannel)) {
                            this.conn.decode(allocate);
                        } else {
                            this.conn.eot();
                        }
                        if (this.wrappedchannel instanceof WrappedByteChannel) {
                            WrappedByteChannel wrappedByteChannel = (WrappedByteChannel) this.wrappedchannel;
                            if (wrappedByteChannel.isNeedRead()) {
                                while (SocketChannelIOHelper.readMore(allocate, this.conn, wrappedByteChannel)) {
                                    this.conn.decode(allocate);
                                }
                                this.conn.decode(allocate);
                            }
                        }
                    } catch (CancelledKeyException e) {
                        this.conn.eot();
                        return;
                    } catch (IOException e2) {
                        this.conn.eot();
                        return;
                    } catch (RuntimeException e3) {
                        onError(e3);
                        this.conn.closeConnection(1006, e3.getMessage());
                        return;
                    }
                }
            } catch (ClosedByInterruptException e4) {
                onWebsocketError(null, e4);
            } catch (Exception e5) {
                onWebsocketError(this.conn, e5);
                this.conn.closeConnection(-1, e5.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getPort() {
        int port = this.uri.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.uri.getScheme();
        if (scheme.equals("wss")) {
            return 443;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException("unkonow scheme" + scheme);
    }

    private void sendHandshake() {
        String str;
        String path = this.uri.getPath();
        String query = this.uri.getQuery();
        if (path == null || path.length() == 0) {
            str = "/";
        } else {
            str = path;
        }
        if (query != null) {
            str = str + "?" + query;
        }
        int port = getPort();
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.setResourceDescriptor(str);
        handshakeImpl1Client.put("Host", this.uri.getHost() + (port != 80 ? ":" + port : ""));
        if (this.headers != null) {
            for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                handshakeImpl1Client.put(entry.getKey(), entry.getValue());
            }
        }
        this.conn.startHandshake(handshakeImpl1Client);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(str);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(byteBuffer);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        this.connectLatch.countDown();
        onOpen((ServerHandshake) handshakedata);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketClose(WebSocket webSocket, int i, String str, boolean z) {
        this.connectLatch.countDown();
        this.closeLatch.countDown();
        if (this.readthread != null) {
            this.readthread.interrupt();
        }
        onClose(i, str, z);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(exc);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWriteDemand(WebSocket webSocket) {
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i, String str) {
        onCloseInitiated(i, str);
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketClosing(WebSocket webSocket, int i, String str, boolean z) {
        onClosing(i, str, z);
    }

    public void onCloseInitiated(int i, String str) {
    }

    public void onClosing(int i, String str, boolean z) {
    }

    @Override // org.java_websocket.WebSocketListener
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        if (this.channel != null) {
            return (InetSocketAddress) this.channel.socket().getLocalSocketAddress();
        }
        return null;
    }

    public void onMessage(ByteBuffer byteBuffer) {
    }

    public class DefaultClientProxyChannel extends AbstractClientProxyChannel {
        public DefaultClientProxyChannel(ByteChannel byteChannel) {
            super(byteChannel);
        }

        @Override // org.java_websocket.client.AbstractClientProxyChannel
        public String buildHandShake() {
            StringBuilder sb = new StringBuilder();
            String host = WebSocketClient.this.uri.getHost();
            sb.append("CONNECT ");
            sb.append(host);
            sb.append(":");
            sb.append(WebSocketClient.this.getPort());
            sb.append(" HTTP/1.1\n");
            sb.append("Host: ");
            sb.append(host);
            sb.append("\n");
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public class WebsocketWriteThread implements Runnable {
        private WebsocketWriteThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    SocketChannelIOHelper.writeBlocking(WebSocketClient.this.conn, WebSocketClient.this.wrappedchannel);
                } catch (IOException e) {
                    WebSocketClient.this.conn.eot();
                    return;
                } catch (InterruptedException e2) {
                    return;
                }
            }
        }
    }

    public ByteChannel createProxyChannel(ByteChannel byteChannel) {
        if (this.proxyAddress != null) {
            return new DefaultClientProxyChannel(byteChannel);
        }
        return byteChannel;
    }
}
