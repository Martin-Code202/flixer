package com.netflix.mediaclient.service.msl.client;

import com.netflix.mediaclient.StatusCode;
import com.netflix.msl.MslInternalException;
public class WidevineContextException extends MslInternalException {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final StatusCode f1491;

    /* renamed from: ˎ  reason: contains not printable characters */
    public StatusCode m810() {
        return this.f1491;
    }

    public WidevineContextException(String str, StatusCode statusCode, Throwable th) {
        super(str, th);
        this.f1491 = statusCode;
    }
}
