package org.java_websocket;

import org.java_websocket.drafts.Draft;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
public abstract class WebSocketAdapter implements WebSocketListener {
    @Override // org.java_websocket.WebSocketListener
    public ServerHandshakeBuilder onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) {
        return new HandshakeImpl1Server();
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, ClientHandshake clientHandshake) {
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata) {
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        FramedataImpl1 framedataImpl1 = new FramedataImpl1(framedata);
        framedataImpl1.setOptcode(Framedata.Opcode.PONG);
        webSocket.sendFrame(framedataImpl1);
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
    }

    @Override // org.java_websocket.WebSocketListener
    public String getFlashPolicy(WebSocket webSocket) {
        return "<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"" + webSocket.getLocalSocketAddress().getPort() + "\" /></cross-domain-policy>\u0000";
    }
}
