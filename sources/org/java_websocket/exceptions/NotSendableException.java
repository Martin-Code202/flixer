package org.java_websocket.exceptions;
public class NotSendableException extends RuntimeException {
    private static final long serialVersionUID = -6468967874576651628L;

    public NotSendableException() {
    }

    public NotSendableException(Throwable th) {
        super(th);
    }
}
