package com.android.volley;

import java.io.PrintWriter;
import java.io.StringWriter;
import o.C1181;
public class VolleyError extends Exception {

    /* renamed from: ˊ  reason: contains not printable characters */
    public final C1181 f128;

    public VolleyError() {
        this.f128 = null;
    }

    public VolleyError(C1181 r1) {
        this.f128 = r1;
    }

    public VolleyError(String str) {
        super(str);
        this.f128 = null;
    }

    public VolleyError(String str, Throwable th) {
        super(str, th);
        this.f128 = null;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.f128 = null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m84() {
        Throwable cause = getCause();
        if (cause == null) {
            return getMessage();
        }
        StringWriter stringWriter = new StringWriter();
        cause.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
