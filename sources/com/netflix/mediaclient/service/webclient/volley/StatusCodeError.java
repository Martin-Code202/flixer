package com.netflix.mediaclient.service.webclient.volley;

import com.android.volley.VolleyError;
import com.netflix.mediaclient.StatusCode;
public class StatusCodeError extends VolleyError {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final StatusCode f2366;

    public StatusCodeError(StatusCode statusCode) {
        this.f2366 = statusCode;
    }

    public StatusCodeError(StatusCode statusCode, String str) {
        super(str);
        this.f2366 = statusCode;
    }

    public StatusCodeError(StatusCode statusCode, Throwable th) {
        super(th);
        this.f2366 = statusCode;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public StatusCode m1474() {
        return this.f2366;
    }
}
