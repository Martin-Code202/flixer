package org.java_websocket.drafts;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.framing.CloseFrameBuilder;
import org.java_websocket.framing.FrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Base64;
import org.java_websocket.util.Charsetfunctions;
public class Draft_10 extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled = (!Draft_10.class.desiredAssertionStatus());
    private Framedata fragmentedframe = null;
    private ByteBuffer incompleteframe;
    private final Random reuseableRandom = new Random();

    /* access modifiers changed from: package-private */
    public class IncompleteException extends Throwable {
        private static final long serialVersionUID = 7330519489840500997L;
        private int preferedsize;

        public IncompleteException(int i) {
            this.preferedsize = i;
        }

        public int getPreferedSize() {
            return this.preferedsize;
        }
    }

    public static int readVersion(Handshakedata handshakedata) {
        String fieldValue = handshakedata.getFieldValue("Sec-WebSocket-Version");
        if (fieldValue.length() <= 0) {
            return -1;
        }
        try {
            return new Integer(fieldValue.trim()).intValue();
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        if (!clientHandshake.hasFieldValue("Sec-WebSocket-Key") || !serverHandshake.hasFieldValue("Sec-WebSocket-Accept")) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (generateFinalKey(clientHandshake.getFieldValue("Sec-WebSocket-Key")).equals(serverHandshake.getFieldValue("Sec-WebSocket-Accept"))) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) {
        int readVersion = readVersion(clientHandshake);
        if (readVersion == 7 || readVersion == 8) {
            return basicAccept(clientHandshake) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        ByteBuffer payloadData = framedata.getPayloadData();
        boolean z = this.role == WebSocket.Role.CLIENT;
        int i = payloadData.remaining() <= 125 ? 1 : payloadData.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate((i > 1 ? i + 1 : i) + 1 + (z ? 4 : 0) + payloadData.remaining());
        allocate.put((byte) (((byte) (framedata.isFin() ? -128 : 0)) | fromOpcode(framedata.getOpcode())));
        byte[] byteArray = toByteArray((long) payloadData.remaining(), i);
        if ($assertionsDisabled || byteArray.length == i) {
            if (i == 1) {
                allocate.put((byte) (byteArray[0] | (z ? Byte.MIN_VALUE : 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? -128 : 0) | 126));
                allocate.put(byteArray);
            } else if (i == 8) {
                allocate.put((byte) ((z ? -128 : 0) | 127));
                allocate.put(byteArray);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.reuseableRandom.nextInt());
                allocate.put(allocate2.array());
                for (int i2 = 0; i2 < payloadData.limit(); i2++) {
                    allocate.put((byte) (payloadData.get() ^ allocate2.get(i2 % 4)));
                }
            } else {
                allocate.put(payloadData);
            }
            if ($assertionsDisabled || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
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

    private byte fromOpcode(Framedata.Opcode opcode) {
        if (opcode == Framedata.Opcode.CONTINUOUS) {
            return 0;
        }
        if (opcode == Framedata.Opcode.TEXT) {
            return 1;
        }
        if (opcode == Framedata.Opcode.BINARY) {
            return 2;
        }
        if (opcode == Framedata.Opcode.CLOSING) {
            return 8;
        }
        if (opcode == Framedata.Opcode.PING) {
            return 9;
        }
        if (opcode == Framedata.Opcode.PONG) {
            return 10;
        }
        throw new RuntimeException("Don't know how to handle " + opcode.toString());
    }

    private String generateFinalKey(String str) {
        try {
            return Base64.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put("Upgrade", "websocket");
        clientHandshakeBuilder.put("Connection", "Upgrade");
        clientHandshakeBuilder.put("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.reuseableRandom.nextBytes(bArr);
        clientHandshakeBuilder.put("Sec-WebSocket-Key", Base64.encodeBytes(bArr));
        return clientHandshakeBuilder;
    }

    @Override // org.java_websocket.drafts.Draft
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) {
        serverHandshakeBuilder.put("Upgrade", "websocket");
        serverHandshakeBuilder.put("Connection", clientHandshake.getFieldValue("Connection"));
        serverHandshakeBuilder.setHttpStatusMessage("Switching Protocols");
        String fieldValue = clientHandshake.getFieldValue("Sec-WebSocket-Key");
        if (fieldValue == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        serverHandshakeBuilder.put("Sec-WebSocket-Accept", generateFinalKey(fieldValue));
        return serverHandshakeBuilder;
    }

    private byte[] toByteArray(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((int) (j >>> (i2 - (i3 * 8))));
        }
        return bArr;
    }

    private Framedata.Opcode toOpcode(byte b) {
        switch (b) {
            case 0:
                return Framedata.Opcode.CONTINUOUS;
            case 1:
                return Framedata.Opcode.TEXT;
            case 2:
                return Framedata.Opcode.BINARY;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                throw new InvalidFrameException("unknow optcode " + ((int) ((short) b)));
            case 8:
                return Framedata.Opcode.CLOSING;
            case 9:
                return Framedata.Opcode.PING;
            case 10:
                return Framedata.Opcode.PONG;
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) {
        LinkedList linkedList = new LinkedList();
        if (this.incompleteframe != null) {
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.incompleteframe.remaining();
                if (remaining2 > remaining) {
                    this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(translateSingleFrame((ByteBuffer) this.incompleteframe.duplicate().position(0)));
                this.incompleteframe = null;
            } catch (IncompleteException e) {
                this.incompleteframe.limit();
                ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(e.getPreferedSize()));
                if ($assertionsDisabled || allocate.limit() > this.incompleteframe.limit()) {
                    this.incompleteframe.rewind();
                    allocate.put(this.incompleteframe);
                    this.incompleteframe = allocate;
                    return translateFrame(byteBuffer);
                }
                throw new AssertionError();
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(translateSingleFrame(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.incompleteframe = ByteBuffer.allocate(checkAlloc(e2.getPreferedSize()));
                this.incompleteframe.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public Framedata translateSingleFrame(ByteBuffer byteBuffer) {
        FrameBuilder frameBuilder;
        int remaining = byteBuffer.remaining();
        int i = 2;
        if (remaining < 2) {
            throw new IncompleteException(2);
        }
        byte b = byteBuffer.get();
        boolean z = (b >> 8) != 0;
        byte b2 = (byte) ((b & Byte.MAX_VALUE) >> 4);
        if (b2 != 0) {
            throw new InvalidFrameException("bad rsv " + ((int) b2));
        }
        byte b3 = byteBuffer.get();
        boolean z2 = (b3 & Byte.MIN_VALUE) != 0;
        int i2 = (byte) (b3 & Byte.MAX_VALUE);
        Framedata.Opcode opcode = toOpcode((byte) (b & 15));
        if (z || !(opcode == Framedata.Opcode.PING || opcode == Framedata.Opcode.PONG || opcode == Framedata.Opcode.CLOSING)) {
            if (i2 < 0 || i2 > 125) {
                if (opcode == Framedata.Opcode.PING || opcode == Framedata.Opcode.PONG || opcode == Framedata.Opcode.CLOSING) {
                    throw new InvalidFrameException("more than 125 octets");
                } else if (i2 == 126) {
                    i = 2 + 2;
                    if (remaining < i) {
                        throw new IncompleteException(i);
                    }
                    byte[] bArr = new byte[3];
                    bArr[1] = byteBuffer.get();
                    bArr[2] = byteBuffer.get();
                    i2 = new BigInteger(bArr).intValue();
                } else {
                    i = 2 + 8;
                    if (remaining < i) {
                        throw new IncompleteException(i);
                    }
                    byte[] bArr2 = new byte[8];
                    for (int i3 = 0; i3 < 8; i3++) {
                        bArr2[i3] = byteBuffer.get();
                    }
                    long longValue = new BigInteger(bArr2).longValue();
                    if (longValue > 2147483647L) {
                        throw new LimitExedeedException("Payloadsize is to big...");
                    }
                    i2 = (int) longValue;
                }
            }
            int i4 = i + (z2 ? 4 : 0) + i2;
            if (remaining < i4) {
                throw new IncompleteException(i4);
            }
            ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(i2));
            if (z2) {
                byte[] bArr3 = new byte[4];
                byteBuffer.get(bArr3);
                for (int i5 = 0; i5 < i2; i5++) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr3[i5 % 4]));
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            if (opcode == Framedata.Opcode.CLOSING) {
                frameBuilder = new CloseFrameBuilder();
            } else {
                frameBuilder = new FramedataImpl1();
                frameBuilder.setFin(z);
                frameBuilder.setOptcode(opcode);
            }
            allocate.flip();
            frameBuilder.setPayload(allocate);
            return frameBuilder;
        }
        throw new InvalidFrameException("control frames may no be fragmented");
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.incompleteframe = null;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft copyInstance() {
        return new Draft_10();
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType getCloseHandshakeType() {
        return Draft.CloseHandshakeType.TWOWAY;
    }
}
