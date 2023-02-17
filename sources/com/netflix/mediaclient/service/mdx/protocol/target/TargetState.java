package com.netflix.mediaclient.service.mdx.protocol.target;
public enum TargetState {
    StateInit(TargetStateId.STATE_INIT, "STATE_INIT", 0, 0, 0),
    StateHasPair(TargetStateId.STATE_HASPAIR, "STATE_HASPAIR", 0, 0, 0),
    StateNoPair(TargetStateId.STATE_NOPAIR, "STATE_NOPAIR", 0, 0, 0),
    StateSessionReady(TargetStateId.STATE_SESSION_READY, "STATE_SESSION_READY", 0, 0, 0),
    StateAcquirePair(TargetStateId.STATE_ACQUIRE_PAIR, "STATE_ACQUIRE_PAIR", 2, 16000, 1000),
    StateRegPair(TargetStateId.STATE_REGPAIR, "STATE_REGPAIR", 2, 32000, 1000),
    StateStartSession(TargetStateId.STATE_START_SESSION, "STATE_START_SESSION", 2, 8000, 1000),
    StateHandShake(TargetStateId.STATE_HAND_SHAKE, "STATE_HAND_SHAKE", 2, 8000, 1000),
    StateGetCap(TargetStateId.STATE_GET_CAP, "STATE_GET_CAP", 2, 8000, 1000),
    StateGetState(TargetStateId.STATE_GET_STATE, "STATE_GET_STATE", 2, 8000, 1000),
    StateSendingMessage(TargetStateId.STATE_SENDING_MESSAGE, "STATE_SENDING_MESSAGE", 2, 8000, 1000);
    

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f1454 = 0;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f1455;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private TargetStateId f1456;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String f1457;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private int f1458 = 0;

    private TargetState(TargetStateId targetStateId, String str, int i, int i2, int i3) {
        this.f1457 = str;
        this.f1454 = i;
        this.f1456 = targetStateId;
        this.f1455 = i2;
        this.f1458 = i3;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m801() {
        return this.f1457;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public TargetStateId m806() {
        return this.f1456;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m805() {
        return this.f1455;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m802() {
        int i = this.f1458;
        this.f1458 *= 2;
        return i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m804(TargetState targetState) {
        return m806() == targetState.m806();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m803() {
        if (this.f1454 < 0) {
            return true;
        }
        this.f1454--;
        return false;
    }
}
