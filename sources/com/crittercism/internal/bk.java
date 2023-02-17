package com.crittercism.internal;

import com.crittercism.error.CRXMLHttpRequestException;
public final class bk extends Enum<bk> {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    private static final /* synthetic */ int[] f = {a, b, c, d, e};

    public static int a(Throwable th) {
        int i = d - 1;
        if (th instanceof CRXMLHttpRequestException) {
            return e - 1;
        }
        return i;
    }
}
