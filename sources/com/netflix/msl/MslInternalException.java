package com.netflix.msl;
public class MslInternalException extends RuntimeException {
    private static final long serialVersionUID = 5787827728910061805L;

    public MslInternalException(String str, Throwable th) {
        super(str, th);
    }

    public MslInternalException(String str) {
        super(str);
    }
}
