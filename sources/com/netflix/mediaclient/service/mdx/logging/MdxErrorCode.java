package com.netflix.mediaclient.service.mdx.logging;
public enum MdxErrorCode {
    MdxInitFailed("4005"),
    ConnectFailed("4010"),
    DisconnectFailed("4012"),
    ReconnectFailed("4011"),
    Cancelled("4013");
    

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f1303;

    private MdxErrorCode(String str) {
        this.f1303 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m679() {
        return this.f1303;
    }
}
