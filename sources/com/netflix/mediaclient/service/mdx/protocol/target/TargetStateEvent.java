package com.netflix.mediaclient.service.mdx.protocol.target;
public enum TargetStateEvent {
    PairSucceed(0),
    PairFail(1),
    PairFailedNeedRegPair(2),
    StartSessionSucceed(3),
    StartSessionFail(4),
    HandShakeSucceed(5),
    HandShakeFailed(6),
    SendMessageSucceed(10),
    SendMessageFail(11),
    SendMessageFailedNeedNewSession(12),
    SendMessageFailedBadPair(13),
    MessageReceived(20),
    SendMessageRequested(21),
    MessageFailRetry(30),
    Timeout(31),
    start(32),
    PeriodicStateCheck(33);
    

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private int f1477;

    private TargetStateEvent(int i) {
        this.f1477 = i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m807(int i) {
        return this.f1477 == i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m808() {
        return this.f1477;
    }
}
