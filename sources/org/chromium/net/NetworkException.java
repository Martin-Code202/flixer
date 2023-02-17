package org.chromium.net;
public abstract class NetworkException extends CronetException {
    public abstract int getCronetInternalErrorCode();

    public abstract int getErrorCode();

    protected NetworkException(String str, Throwable th) {
        super(str, th);
    }
}
