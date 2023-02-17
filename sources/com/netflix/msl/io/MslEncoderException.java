package com.netflix.msl.io;
public class MslEncoderException extends Exception {
    private static final long serialVersionUID = -6338714624096298489L;

    public MslEncoderException(String str) {
        super(str);
    }

    public MslEncoderException(String str, Throwable th) {
        super(str, th);
    }
}
