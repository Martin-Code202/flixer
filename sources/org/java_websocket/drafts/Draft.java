package org.java_websocket.drafts;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.java_websocket.WebSocket;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;
public abstract class Draft {
    public static final byte[] FLASH_POLICY_REQUEST = Charsetfunctions.utf8Bytes("<policy-file-request/>\u0000");
    public static int INITIAL_FAMESIZE = 64;
    public static int MAX_FAME_SIZE = 1000;
    protected WebSocket.Role role = null;

    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake);

    public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake);

    public abstract Draft copyInstance();

    public abstract ByteBuffer createBinaryFrame(Framedata framedata);

    public abstract List<Framedata> createFrames(String str, boolean z);

    public abstract CloseHandshakeType getCloseHandshakeType();

    public abstract ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder);

    public abstract HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder);

    public abstract void reset();

    public abstract List<Framedata> translateFrame(ByteBuffer byteBuffer);

    public static ByteBuffer readLine(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = 48;
        while (byteBuffer.hasRemaining()) {
            b = byteBuffer.get();
            allocate.put(b);
            if (b == 13 && b == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String readStringLine(ByteBuffer byteBuffer) {
        ByteBuffer readLine = readLine(byteBuffer);
        if (readLine == null) {
            return null;
        }
        return Charsetfunctions.stringAscii(readLine.array(), 0, readLine.limit());
    }

    public static HandshakeBuilder translateHandshakeHttp(ByteBuffer byteBuffer, WebSocket.Role role2) {
        ServerHandshakeBuilder serverHandshakeBuilder;
        String readStringLine = readStringLine(byteBuffer);
        if (readStringLine == null) {
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        String[] split = readStringLine.split(" ", 3);
        if (split.length != 3) {
            throw new InvalidHandshakeException();
        }
        if (role2 == WebSocket.Role.CLIENT) {
            serverHandshakeBuilder = new HandshakeImpl1Server();
            ServerHandshakeBuilder serverHandshakeBuilder2 = serverHandshakeBuilder;
            serverHandshakeBuilder2.setHttpStatus(Short.parseShort(split[1]));
            serverHandshakeBuilder2.setHttpStatusMessage(split[2]);
        } else {
            HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
            handshakeImpl1Client.setResourceDescriptor(split[1]);
            serverHandshakeBuilder = handshakeImpl1Client;
        }
        String readStringLine2 = readStringLine(byteBuffer);
        while (readStringLine2 != null && readStringLine2.length() > 0) {
            String[] split2 = readStringLine2.split(":", 2);
            if (split2.length != 2) {
                throw new InvalidHandshakeException("not an http header");
            }
            serverHandshakeBuilder.put(split2[0], split2[1].replaceFirst("^ +", ""));
            readStringLine2 = readStringLine(byteBuffer);
        }
        if (readStringLine2 != null) {
            return serverHandshakeBuilder;
        }
        throw new IncompleteHandshakeException();
    }

    /* access modifiers changed from: protected */
    public boolean basicAccept(Handshakedata handshakedata) {
        return handshakedata.getFieldValue("Upgrade").equalsIgnoreCase("websocket") && handshakedata.getFieldValue("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, WebSocket.Role role2) {
        return createHandshake(handshakedata, role2, true);
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, WebSocket.Role role2, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake) {
            sb.append("GET ");
            sb.append(((ClientHandshake) handshakedata).getResourceDescriptor());
            sb.append(" HTTP/1.1");
        } else if (handshakedata instanceof ServerHandshake) {
            sb.append("HTTP/1.1 101 " + ((ServerHandshake) handshakedata).getHttpStatusMessage());
        } else {
            throw new RuntimeException("unknow role");
        }
        sb.append("\r\n");
        Iterator<String> iterateHttpFields = handshakedata.iterateHttpFields();
        while (iterateHttpFields.hasNext()) {
            String next = iterateHttpFields.next();
            String fieldValue = handshakedata.getFieldValue(next);
            sb.append(next);
            sb.append(": ");
            sb.append(fieldValue);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] asciiBytes = Charsetfunctions.asciiBytes(sb.toString());
        byte[] content = z ? handshakedata.getContent() : null;
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + asciiBytes.length);
        allocate.put(asciiBytes);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public Handshakedata translateHandshake(ByteBuffer byteBuffer) {
        return translateHandshakeHttp(byteBuffer, this.role);
    }

    public int checkAlloc(int i) {
        if (i >= 0) {
            return i;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    public void setParseMode(WebSocket.Role role2) {
        this.role = role2;
    }
}
