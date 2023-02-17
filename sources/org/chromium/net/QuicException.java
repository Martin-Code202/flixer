package org.chromium.net;
public abstract class QuicException extends NetworkException {
    protected QuicException(String str, Throwable th) {
        super(str, th);
    }
}
