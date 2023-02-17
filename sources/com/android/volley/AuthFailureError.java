package com.android.volley;

import android.content.Intent;
import o.C1181;
public class AuthFailureError extends VolleyError {

    /* renamed from: ˋ  reason: contains not printable characters */
    private Intent f118;

    public AuthFailureError() {
    }

    public AuthFailureError(C1181 r1) {
        super(r1);
    }

    public AuthFailureError(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.f118 != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
