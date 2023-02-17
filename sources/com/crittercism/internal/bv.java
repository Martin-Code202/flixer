package com.crittercism.internal;
public final class bv {
    public int a = -1;
    public byte[] b;
    public Exception c;

    public bv(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public bv(Exception exc) {
        this.c = exc;
    }
}
