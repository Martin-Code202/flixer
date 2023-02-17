package org.java_websocket.handshake;
public class HandshakeImpl1Server extends HandshakedataImpl1 implements ServerHandshakeBuilder {
    private short httpstatus;
    private String httpstatusmessage;

    @Override // org.java_websocket.handshake.ServerHandshake
    public String getHttpStatusMessage() {
        return this.httpstatusmessage;
    }

    @Override // org.java_websocket.handshake.ServerHandshakeBuilder
    public void setHttpStatusMessage(String str) {
        this.httpstatusmessage = str;
    }

    @Override // org.java_websocket.handshake.ServerHandshakeBuilder
    public void setHttpStatus(short s) {
        this.httpstatus = s;
    }
}
