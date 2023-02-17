package org.java_websocket.client;

import java.net.Socket;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
public class DefaultWebSocketClientFactory implements WebSocketClient.WebSocketClientFactory {
    private final WebSocketClient webSocketClient;

    public DefaultWebSocketClientFactory(WebSocketClient webSocketClient2) {
        this.webSocketClient = webSocketClient2;
    }

    @Override // org.java_websocket.WebSocketFactory
    public WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft, Socket socket) {
        return new WebSocketImpl(this.webSocketClient, draft);
    }

    @Override // org.java_websocket.client.WebSocketClient.WebSocketClientFactory
    public ByteChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey, String str, int i) {
        if (selectionKey == null) {
            return socketChannel;
        }
        return socketChannel;
    }
}
