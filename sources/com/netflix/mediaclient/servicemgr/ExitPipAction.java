package com.netflix.mediaclient.servicemgr;
public enum ExitPipAction {
    CONTINUEPLAY("continueplay"),
    STOP("endsession");
    

    /* renamed from: ॱ  reason: contains not printable characters */
    String f2457;

    private ExitPipAction(String str) {
        this.f2457 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m1502() {
        return this.f2457;
    }
}
