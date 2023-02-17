package org.java_websocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.drafts.Draft_75;
import org.java_websocket.drafts.Draft_76;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.CloseFrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.util.Charsetfunctions;
public class WebSocketImpl implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled = (!WebSocketImpl.class.desiredAssertionStatus());
    public static boolean DEBUG = false;
    public static int RCVBUF = 16384;
    public static final List<Draft> defaultdraftlist = new ArrayList(4);
    public ByteChannel channel;
    private Integer closecode = null;
    private Boolean closedremotely = null;
    private String closemessage = null;
    private Framedata.Opcode current_continuous_frame_opcode = null;
    private Draft draft = null;
    private volatile boolean flushandclosestate = false;
    private ClientHandshake handshakerequest = null;
    public final BlockingQueue<ByteBuffer> inQueue;
    public SelectionKey key;
    private List<Draft> knownDrafts;
    public final BlockingQueue<ByteBuffer> outQueue;
    private WebSocket.READYSTATE readystate = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private WebSocket.Role role;
    private ByteBuffer tmpHandshakeBytes;
    private final WebSocketListener wsl;

    static {
        defaultdraftlist.add(new Draft_17());
        defaultdraftlist.add(new Draft_10());
        defaultdraftlist.add(new Draft_76());
        defaultdraftlist.add(new Draft_75());
    }

    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft2) {
        if (webSocketListener == null || (draft2 == null && this.role == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.outQueue = new LinkedBlockingQueue();
        this.inQueue = new LinkedBlockingQueue();
        this.wsl = webSocketListener;
        this.role = WebSocket.Role.CLIENT;
        if (draft2 != null) {
            this.draft = draft2.copyInstance();
        }
    }

    public void decode(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining() && !this.flushandclosestate) {
            if (DEBUG) {
                System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + "}");
            }
            if (this.readystate == WebSocket.READYSTATE.OPEN) {
                decodeFrames(byteBuffer);
            } else if (decodeHandshake(byteBuffer)) {
                decodeFrames(byteBuffer);
            }
            if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
        }
    }

    private boolean decodeHandshake(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.tmpHandshakeBytes == null) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.tmpHandshakeBytes.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.tmpHandshakeBytes.capacity() + byteBuffer.remaining());
                this.tmpHandshakeBytes.flip();
                allocate.put(this.tmpHandshakeBytes);
                this.tmpHandshakeBytes = allocate;
            }
            this.tmpHandshakeBytes.put(byteBuffer);
            this.tmpHandshakeBytes.flip();
            byteBuffer2 = this.tmpHandshakeBytes;
        }
        byteBuffer2.mark();
        try {
            if (this.draft == null && isFlashEdgeCase(byteBuffer2) == Draft.HandshakeState.MATCHED) {
                write(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(this.wsl.getFlashPolicy(this))));
                close(-3, "");
                return false;
            }
            try {
                if (this.role == WebSocket.Role.SERVER) {
                    if (this.draft == null) {
                        for (Draft draft2 : this.knownDrafts) {
                            Draft copyInstance = draft2.copyInstance();
                            try {
                                copyInstance.setParseMode(this.role);
                                byteBuffer2.reset();
                                Handshakedata translateHandshake = copyInstance.translateHandshake(byteBuffer2);
                                if (!(translateHandshake instanceof ClientHandshake)) {
                                    flushAndClose(1002, "wrong http function", false);
                                    return false;
                                }
                                ClientHandshake clientHandshake = (ClientHandshake) translateHandshake;
                                if (copyInstance.acceptHandshakeAsServer(clientHandshake) == Draft.HandshakeState.MATCHED) {
                                    try {
                                        write(copyInstance.createHandshake(copyInstance.postProcessHandshakeResponseAsServer(clientHandshake, this.wsl.onWebsocketHandshakeReceivedAsServer(this, copyInstance, clientHandshake)), this.role));
                                        this.draft = copyInstance;
                                        open(clientHandshake);
                                        return true;
                                    } catch (InvalidDataException e) {
                                        flushAndClose(e.getCloseCode(), e.getMessage(), false);
                                        return false;
                                    } catch (RuntimeException e2) {
                                        this.wsl.onWebsocketError(this, e2);
                                        flushAndClose(-1, e2.getMessage(), false);
                                        return false;
                                    }
                                }
                            } catch (InvalidHandshakeException e3) {
                            }
                        }
                        if (this.draft != null) {
                            return false;
                        }
                        close(1002, "no draft matches");
                        return false;
                    }
                    Handshakedata translateHandshake2 = this.draft.translateHandshake(byteBuffer2);
                    if (!(translateHandshake2 instanceof ClientHandshake)) {
                        flushAndClose(1002, "wrong http function", false);
                        return false;
                    }
                    ClientHandshake clientHandshake2 = (ClientHandshake) translateHandshake2;
                    if (this.draft.acceptHandshakeAsServer(clientHandshake2) == Draft.HandshakeState.MATCHED) {
                        open(clientHandshake2);
                        return true;
                    }
                    close(1002, "the handshake did finaly not match");
                    return false;
                } else if (this.role != WebSocket.Role.CLIENT) {
                    return false;
                } else {
                    this.draft.setParseMode(this.role);
                    Handshakedata translateHandshake3 = this.draft.translateHandshake(byteBuffer2);
                    if (!(translateHandshake3 instanceof ServerHandshake)) {
                        flushAndClose(1002, "Wwrong http function", false);
                        return false;
                    }
                    ServerHandshake serverHandshake = (ServerHandshake) translateHandshake3;
                    if (this.draft.acceptHandshakeAsClient(this.handshakerequest, serverHandshake) == Draft.HandshakeState.MATCHED) {
                        try {
                            this.wsl.onWebsocketHandshakeReceivedAsClient(this, this.handshakerequest, serverHandshake);
                            open(serverHandshake);
                            return true;
                        } catch (InvalidDataException e4) {
                            flushAndClose(e4.getCloseCode(), e4.getMessage(), false);
                            return false;
                        } catch (RuntimeException e5) {
                            this.wsl.onWebsocketError(this, e5);
                            flushAndClose(-1, e5.getMessage(), false);
                            return false;
                        }
                    } else {
                        close(1002, "draft " + this.draft + " refuses handshake");
                        return false;
                    }
                }
            } catch (InvalidHandshakeException e6) {
                close(e6);
                return false;
            }
        } catch (IncompleteHandshakeException e7) {
            if (this.tmpHandshakeBytes == null) {
                byteBuffer2.reset();
                int preferedSize = e7.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e7.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.tmpHandshakeBytes = ByteBuffer.allocate(preferedSize);
                this.tmpHandshakeBytes.put(byteBuffer);
                return false;
            }
            this.tmpHandshakeBytes.position(this.tmpHandshakeBytes.limit());
            this.tmpHandshakeBytes.limit(this.tmpHandshakeBytes.capacity());
            return false;
        }
    }

    private void decodeFrames(ByteBuffer byteBuffer) {
        if (!this.flushandclosestate) {
            try {
                for (Framedata framedata : this.draft.translateFrame(byteBuffer)) {
                    if (DEBUG) {
                        System.out.println("matched frame: " + framedata);
                    }
                    if (!this.flushandclosestate) {
                        Framedata.Opcode opcode = framedata.getOpcode();
                        boolean isFin = framedata.isFin();
                        if (opcode == Framedata.Opcode.CLOSING) {
                            int i = 1005;
                            String str = "";
                            if (framedata instanceof CloseFrame) {
                                CloseFrame closeFrame = (CloseFrame) framedata;
                                i = closeFrame.getCloseCode();
                                str = closeFrame.getMessage();
                            }
                            if (this.readystate == WebSocket.READYSTATE.CLOSING) {
                                closeConnection(i, str, true);
                            } else if (this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.TWOWAY) {
                                close(i, str, true);
                            } else {
                                flushAndClose(i, str, false);
                            }
                        } else if (opcode == Framedata.Opcode.PING) {
                            this.wsl.onWebsocketPing(this, framedata);
                        } else if (opcode == Framedata.Opcode.PONG) {
                            this.wsl.onWebsocketPong(this, framedata);
                        } else if (!isFin || opcode == Framedata.Opcode.CONTINUOUS) {
                            if (opcode != Framedata.Opcode.CONTINUOUS) {
                                if (this.current_continuous_frame_opcode != null) {
                                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                                }
                                this.current_continuous_frame_opcode = opcode;
                            } else if (isFin) {
                                if (this.current_continuous_frame_opcode == null) {
                                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                                }
                                this.current_continuous_frame_opcode = null;
                            } else if (this.current_continuous_frame_opcode == null) {
                                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                            }
                            try {
                                this.wsl.onWebsocketMessageFragment(this, framedata);
                            } catch (RuntimeException e) {
                                this.wsl.onWebsocketError(this, e);
                            }
                        } else if (this.current_continuous_frame_opcode != null) {
                            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
                        } else if (opcode == Framedata.Opcode.TEXT) {
                            try {
                                this.wsl.onWebsocketMessage(this, Charsetfunctions.stringUtf8(framedata.getPayloadData()));
                            } catch (RuntimeException e2) {
                                this.wsl.onWebsocketError(this, e2);
                            }
                        } else if (opcode == Framedata.Opcode.BINARY) {
                            try {
                                this.wsl.onWebsocketMessage(this, framedata.getPayloadData());
                            } catch (RuntimeException e3) {
                                this.wsl.onWebsocketError(this, e3);
                            }
                        } else {
                            throw new InvalidDataException(1002, "non control or continious frame expected");
                        }
                    } else {
                        return;
                    }
                }
            } catch (InvalidDataException e4) {
                this.wsl.onWebsocketError(this, e4);
                close(e4);
            }
        }
    }

    private void close(int i, String str, boolean z) {
        if (this.readystate != WebSocket.READYSTATE.CLOSING && this.readystate != WebSocket.READYSTATE.CLOSED) {
            if (this.readystate == WebSocket.READYSTATE.OPEN) {
                if (i != 1006) {
                    if (this.draft.getCloseHandshakeType() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                this.wsl.onWebsocketCloseInitiated(this, i, str);
                            } catch (RuntimeException e) {
                                try {
                                    this.wsl.onWebsocketError(this, e);
                                } catch (InvalidDataException e2) {
                                    this.wsl.onWebsocketError(this, e2);
                                    flushAndClose(1006, "generated frame is invalid", false);
                                }
                            }
                        }
                        sendFrame(new CloseFrameBuilder(i, str));
                    }
                    flushAndClose(i, str, z);
                } else if ($assertionsDisabled || !z) {
                    this.readystate = WebSocket.READYSTATE.CLOSING;
                    flushAndClose(i, str, false);
                    return;
                } else {
                    throw new AssertionError();
                }
            } else if (i != -3) {
                flushAndClose(-1, str, false);
            } else if ($assertionsDisabled || z) {
                flushAndClose(-3, str, true);
            } else {
                throw new AssertionError();
            }
            if (i == 1002) {
                flushAndClose(i, str, z);
            }
            this.readystate = WebSocket.READYSTATE.CLOSING;
            this.tmpHandshakeBytes = null;
        }
    }

    public void close(int i, String str) {
        close(i, str, false);
    }

    /* access modifiers changed from: protected */
    public synchronized void closeConnection(int i, String str, boolean z) {
        if (this.readystate != WebSocket.READYSTATE.CLOSED) {
            if (this.key != null) {
                this.key.cancel();
            }
            if (this.channel != null) {
                try {
                    this.channel.close();
                } catch (IOException e) {
                    this.wsl.onWebsocketError(this, e);
                }
            }
            try {
                this.wsl.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.wsl.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.handshakerequest = null;
            this.readystate = WebSocket.READYSTATE.CLOSED;
            this.outQueue.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void closeConnection(int i, boolean z) {
        closeConnection(i, "", z);
    }

    public void closeConnection(int i, String str) {
        closeConnection(i, str, false);
    }

    /* access modifiers changed from: protected */
    public synchronized void flushAndClose(int i, String str, boolean z) {
        if (!this.flushandclosestate) {
            this.closecode = Integer.valueOf(i);
            this.closemessage = str;
            this.closedremotely = Boolean.valueOf(z);
            this.flushandclosestate = true;
            this.wsl.onWriteDemand(this);
            try {
                this.wsl.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.wsl.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.handshakerequest = null;
        }
    }

    public void eot() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            closeConnection(-1, true);
        } else if (this.flushandclosestate) {
            closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
        } else if (this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.NONE) {
            closeConnection(1000, true);
        } else if (this.draft.getCloseHandshakeType() != Draft.CloseHandshakeType.ONEWAY) {
            closeConnection(1006, true);
        } else if (this.role == WebSocket.Role.SERVER) {
            closeConnection(1006, true);
        } else {
            closeConnection(1000, true);
        }
    }

    public void close(int i) {
        close(i, "", false);
    }

    public void close(InvalidDataException invalidDataException) {
        close(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        send(this.draft.createFrames(str, this.role == WebSocket.Role.CLIENT));
    }

    private void send(Collection<Framedata> collection) {
        if (!isOpen()) {
            throw new WebsocketNotConnectedException();
        }
        for (Framedata framedata : collection) {
            sendFrame(framedata);
        }
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        if (DEBUG) {
            System.out.println("send frame: " + framedata);
        }
        write(this.draft.createBinaryFrame(framedata));
    }

    private Draft.HandshakeState isFlashEdgeCase(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        if (byteBuffer.limit() > Draft.FLASH_POLICY_REQUEST.length) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (byteBuffer.limit() < Draft.FLASH_POLICY_REQUEST.length) {
            throw new IncompleteHandshakeException(Draft.FLASH_POLICY_REQUEST.length);
        }
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            if (Draft.FLASH_POLICY_REQUEST[i] != byteBuffer.get()) {
                byteBuffer.reset();
                return Draft.HandshakeState.NOT_MATCHED;
            }
            i++;
        }
        return Draft.HandshakeState.MATCHED;
    }

    public void startHandshake(ClientHandshakeBuilder clientHandshakeBuilder) {
        if ($assertionsDisabled || this.readystate != WebSocket.READYSTATE.CONNECTING) {
            this.handshakerequest = this.draft.postProcessHandshakeRequestAsClient(clientHandshakeBuilder);
            try {
                this.wsl.onWebsocketHandshakeSentAsClient(this, this.handshakerequest);
                write(this.draft.createHandshake(this.handshakerequest, this.role));
            } catch (InvalidDataException e) {
                throw new InvalidHandshakeException("Handshake data rejected by client.");
            } catch (RuntimeException e2) {
                this.wsl.onWebsocketError(this, e2);
                throw new InvalidHandshakeException("rejected because of" + e2);
            }
        } else {
            throw new AssertionError("shall only be called once");
        }
    }

    private void write(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + "}");
        }
        this.outQueue.add(byteBuffer);
        this.wsl.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        for (ByteBuffer byteBuffer : list) {
            write(byteBuffer);
        }
    }

    private void open(Handshakedata handshakedata) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft.getClass().getSimpleName());
        }
        this.readystate = WebSocket.READYSTATE.OPEN;
        try {
            this.wsl.onWebsocketOpen(this, handshakedata);
        } catch (RuntimeException e) {
            this.wsl.onWebsocketError(this, e);
        }
    }

    public boolean isOpen() {
        if ($assertionsDisabled || this.readystate != WebSocket.READYSTATE.OPEN || !this.flushandclosestate) {
            return this.readystate == WebSocket.READYSTATE.OPEN;
        }
        throw new AssertionError();
    }

    public boolean isClosing() {
        return this.readystate == WebSocket.READYSTATE.CLOSING;
    }

    public boolean isFlushAndClose() {
        return this.flushandclosestate;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    @Override // org.java_websocket.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.wsl.getLocalSocketAddress(this);
    }
}
