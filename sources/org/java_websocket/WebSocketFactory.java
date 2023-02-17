package org.java_websocket;

import java.net.Socket;
import org.java_websocket.drafts.Draft;
public interface WebSocketFactory {
    WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft, Socket socket);
}
