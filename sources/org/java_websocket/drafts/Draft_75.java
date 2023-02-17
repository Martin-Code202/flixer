package org.java_websocket.drafts;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;
public class Draft_75 extends Draft {
    protected ByteBuffer currentFrame;
    private boolean inframe = false;
    protected boolean readingState = false;
    protected List<Framedata> readyframes = new LinkedList();
    private final Random reuseableRandom = new Random();

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        return (!clientHandshake.getFieldValue("WebSocket-Origin").equals(serverHandshake.getFieldValue("Origin")) || !basicAccept(serverHandshake)) ? Draft.HandshakeState.NOT_MATCHED : Draft.HandshakeState.MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) {
        if (!clientHandshake.hasFieldValue("Origin") || !basicAccept(clientHandshake)) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        return Draft.HandshakeState.MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        if (framedata.getOpcode() != Framedata.Opcode.TEXT) {
            throw new RuntimeException("only text frames supported");
        }
        ByteBuffer payloadData = framedata.getPayloadData();
        ByteBuffer allocate = ByteBuffer.allocate(payloadData.remaining() + 2);
        allocate.put((byte) 0);
        payloadData.mark();
        allocate.put(payloadData);
        payloadData.reset();
        allocate.put((byte) -1);
        allocate.flip();
        return allocate;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> createFrames(String str, boolean z) {
        FramedataImpl1 framedataImpl1 = new FramedataImpl1();
        try {
            framedataImpl1.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(str)));
            framedataImpl1.setFin(true);
            framedataImpl1.setOptcode(Framedata.Opcode.TEXT);
            framedataImpl1.setTransferemasked(z);
            return Collections.singletonList(framedataImpl1);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put("Upgrade", "WebSocket");
        clientHandshakeBuilder.put("Connection", "Upgrade");
        if (!clientHandshakeBuilder.hasFieldValue("Origin")) {
            clientHandshakeBuilder.put("Origin", "random" + this.reuseableRandom.nextInt());
        }
        return clientHandshakeBuilder;
    }

    @Override // org.java_websocket.drafts.Draft
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) {
        serverHandshakeBuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
        serverHandshakeBuilder.put("Upgrade", "WebSocket");
        serverHandshakeBuilder.put("Connection", clientHandshake.getFieldValue("Connection"));
        serverHandshakeBuilder.put("WebSocket-Origin", clientHandshake.getFieldValue("Origin"));
        serverHandshakeBuilder.put("WebSocket-Location", "ws://" + clientHandshake.getFieldValue("Host") + clientHandshake.getResourceDescriptor());
        return serverHandshakeBuilder;
    }

    /* access modifiers changed from: protected */
    public List<Framedata> translateRegularFrame(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == 0) {
                if (this.readingState) {
                    return null;
                }
                this.readingState = true;
            } else if (b == -1) {
                if (!this.readingState) {
                    return null;
                }
                if (this.currentFrame != null) {
                    this.currentFrame.flip();
                    FramedataImpl1 framedataImpl1 = new FramedataImpl1();
                    framedataImpl1.setPayload(this.currentFrame);
                    framedataImpl1.setFin(true);
                    framedataImpl1.setOptcode(this.inframe ? Framedata.Opcode.CONTINUOUS : Framedata.Opcode.TEXT);
                    this.readyframes.add(framedataImpl1);
                    this.currentFrame = null;
                    byteBuffer.mark();
                }
                this.readingState = false;
                this.inframe = false;
            } else if (!this.readingState) {
                return null;
            } else {
                if (this.currentFrame == null) {
                    this.currentFrame = createBuffer();
                } else if (!this.currentFrame.hasRemaining()) {
                    this.currentFrame = increaseBuffer(this.currentFrame);
                }
                this.currentFrame.put(b);
            }
        }
        if (this.readingState) {
            FramedataImpl1 framedataImpl12 = new FramedataImpl1();
            this.currentFrame.flip();
            framedataImpl12.setPayload(this.currentFrame);
            framedataImpl12.setFin(false);
            framedataImpl12.setOptcode(this.inframe ? Framedata.Opcode.CONTINUOUS : Framedata.Opcode.TEXT);
            this.inframe = true;
            this.readyframes.add(framedataImpl12);
        }
        List<Framedata> list = this.readyframes;
        this.readyframes = new LinkedList();
        this.currentFrame = null;
        return list;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) {
        List<Framedata> translateRegularFrame = translateRegularFrame(byteBuffer);
        if (translateRegularFrame != null) {
            return translateRegularFrame;
        }
        throw new InvalidDataException(1002);
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.readingState = false;
        this.currentFrame = null;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType getCloseHandshakeType() {
        return Draft.CloseHandshakeType.NONE;
    }

    public ByteBuffer createBuffer() {
        return ByteBuffer.allocate(INITIAL_FAMESIZE);
    }

    public ByteBuffer increaseBuffer(ByteBuffer byteBuffer) {
        byteBuffer.flip();
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity() * 2);
        allocate.put(byteBuffer);
        return allocate;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft copyInstance() {
        return new Draft_75();
    }
}
