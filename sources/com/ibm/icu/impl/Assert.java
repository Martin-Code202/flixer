package com.ibm.icu.impl;
public class Assert {
    public static void fail(Exception exc) {
        fail(exc.toString());
    }

    public static void fail(String str) {
        throw new IllegalStateException("failure '" + str + "'");
    }

    public static void assrt(boolean z) {
        if (!z) {
            throw new IllegalStateException("assert failed");
        }
    }
}
