package org.java_websocket.framing;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.java_websocket.framing.Framedata;
import org.java_websocket.util.Charsetfunctions;
public class FramedataImpl1 implements FrameBuilder {
    protected static byte[] emptyarray = new byte[0];
    protected boolean fin;
    protected Framedata.Opcode optcode;
    protected boolean transferemasked;
    private ByteBuffer unmaskedpayload;

    public FramedataImpl1() {
    }

    public FramedataImpl1(Framedata.Opcode opcode) {
        this.optcode = opcode;
        this.unmaskedpayload = ByteBuffer.wrap(emptyarray);
    }

    public FramedataImpl1(Framedata framedata) {
        this.fin = framedata.isFin();
        this.optcode = framedata.getOpcode();
        this.unmaskedpayload = framedata.getPayloadData();
        this.transferemasked = framedata.getTransfereMasked();
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean isFin() {
        return this.fin;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode getOpcode() {
        return this.optcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean getTransfereMasked() {
        return this.transferemasked;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer getPayloadData() {
        return this.unmaskedpayload;
    }

    @Override // org.java_websocket.framing.FrameBuilder
    public void setFin(boolean z) {
        this.fin = z;
    }

    @Override // org.java_websocket.framing.FrameBuilder
    public void setOptcode(Framedata.Opcode opcode) {
        this.optcode = opcode;
    }

    @Override // org.java_websocket.framing.FrameBuilder
    public void setPayload(ByteBuffer byteBuffer) {
        this.unmaskedpayload = byteBuffer;
    }

    @Override // org.java_websocket.framing.FrameBuilder
    public void setTransferemasked(boolean z) {
        this.transferemasked = z;
    }

    public String toString() {
        return "Framedata{ optcode:" + getOpcode() + ", fin:" + isFin() + ", payloadlength:" + this.unmaskedpayload.limit() + ", payload:" + Arrays.toString(Charsetfunctions.utf8Bytes(new String(this.unmaskedpayload.array()))) + "}";
    }
}
