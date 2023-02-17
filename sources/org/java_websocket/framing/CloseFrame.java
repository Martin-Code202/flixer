package org.java_websocket.framing;
public interface CloseFrame extends Framedata {
    int getCloseCode();

    String getMessage();
}
