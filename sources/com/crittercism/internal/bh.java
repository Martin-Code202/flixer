package com.crittercism.internal;
public final class bh extends Exception {
    private static final long serialVersionUID = 4511293437269420307L;

    public bh(String str, Throwable th) {
        super(str, th);
    }

    public bh(String str) {
        this(str, null);
    }

    public bh(Throwable th) {
        super(th);
    }
}
