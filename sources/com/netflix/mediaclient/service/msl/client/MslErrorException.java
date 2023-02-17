package com.netflix.mediaclient.service.msl.client;

import o.DD;
public class MslErrorException extends Exception {

    /* renamed from: ˊ  reason: contains not printable characters */
    private DD f1490;

    public MslErrorException(DD dd) {
        this.f1490 = dd;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public DD m809() {
        return this.f1490;
    }
}
