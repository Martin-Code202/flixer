package org.java_websocket.handshake;
public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {
    private String resourcedescriptor;

    @Override // org.java_websocket.handshake.ClientHandshakeBuilder
    public void setResourceDescriptor(String str) {
        this.resourcedescriptor = str;
    }

    @Override // org.java_websocket.handshake.ClientHandshake
    public String getResourceDescriptor() {
        return this.resourcedescriptor;
    }
}
