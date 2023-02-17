package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.framing.Framedata;
public interface FrameBuilder extends Framedata {
    void setFin(boolean z);

    void setOptcode(Framedata.Opcode opcode);

    void setPayload(ByteBuffer byteBuffer);

    void setTransferemasked(boolean z);
}
