package o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget;
import com.netflix.mediaclient.service.mdx.protocol.target.TargetSessionMessageType;
import com.netflix.mediaclient.service.mdx.protocol.target.TargetState;
import com.netflix.mediaclient.service.mdx.protocol.target.TargetStateEvent;
/* renamed from: o.gu  reason: case insensitive filesystem */
public class C1835gu {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f6998;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Handler f6999;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f7000 = 0;

    /* renamed from: ˎ  reason: contains not printable characters */
    private SessionMdxTarget f7001;

    /* renamed from: ˏ  reason: contains not printable characters */
    private TargetState f7002 = TargetState.StateInit;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f7003 = 0;

    public C1835gu(SessionMdxTarget sessionMdxTarget, Looper looper) {
        this.f7001 = sessionMdxTarget;
        this.f6999 = new Handler(looper) { // from class: o.gu.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (!TargetStateEvent.Timeout.m807(i) || !C1835gu.this.m6711()) {
                    C1283.m16863("MdxTargetStateV2", "(%d) stateId %s, eventId %d", Integer.valueOf(C1835gu.this.hashCode()), C1835gu.this.f7002.m806(), Integer.valueOf(i));
                    switch (AnonymousClass4.f7005[C1835gu.this.f7002.m806().ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                            if (!TargetStateEvent.start.m807(i)) {
                                return;
                            }
                            if (C1835gu.this.f7001.m796()) {
                                C1835gu.this.m6717(TargetState.StateStartSession);
                                return;
                            } else {
                                C1835gu.this.m6717(TargetState.StateAcquirePair);
                                return;
                            }
                        case 4:
                            if (TargetStateEvent.SendMessageRequested.m807(i)) {
                                C1835gu.this.m6717(TargetState.StateSendingMessage);
                                return;
                            } else if (TargetStateEvent.PeriodicStateCheck.m807(i)) {
                                if (C1835gu.this.m6726()) {
                                    C1835gu.this.m6717(TargetState.StateSendingMessage);
                                }
                                C1835gu.this.m6722();
                                return;
                            } else if (!C1835gu.this.m6723(i)) {
                                C1283.m16863("MdxTargetStateV2", "event %d, %d not handled @%s", Integer.valueOf(i), Integer.valueOf(message.arg1), C1835gu.this.f7002.m801());
                                return;
                            } else {
                                return;
                            }
                        case 5:
                            if (TargetStateEvent.PairSucceed.m807(i)) {
                                C1835gu.this.m6717(TargetState.StateStartSession);
                                return;
                            } else if (!TargetStateEvent.PairFail.m807(i)) {
                                return;
                            } else {
                                if (C1835gu.this.f6998) {
                                    if (C1835gu.this.f7001.m772()) {
                                        C1835gu.this.m6717(TargetState.StateRegPair);
                                        return;
                                    }
                                    C1835gu.this.m6717(TargetState.StateNoPair);
                                    C1835gu.this.f7001.m786(104, "TODO: pairing error");
                                    return;
                                } else if (!C1835gu.this.m6725()) {
                                    C1835gu.this.m6717(TargetState.StateNoPair);
                                    if (C1835gu.this.f7001.m799()) {
                                        C1835gu.this.f7001.m786(104, "pairing error after retry.");
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            }
                        case 6:
                            if (TargetStateEvent.PairSucceed.m807(i)) {
                                C1835gu.this.m6717(TargetState.StateStartSession);
                                return;
                            } else if (TargetStateEvent.PairFail.m807(i)) {
                                if (C1835gu.this.f7001.m799()) {
                                    C1835gu.this.f7001.m786(104, "TODO: regpair error");
                                }
                                C1835gu.this.m6717(TargetState.StateNoPair);
                                return;
                            } else {
                                return;
                            }
                        case 7:
                            if (TargetStateEvent.StartSessionSucceed.m807(i)) {
                                C1835gu.this.f6998 = false;
                                C1835gu.this.m6717(TargetState.StateHandShake);
                                C1835gu.this.m6722();
                                return;
                            } else if (!C1835gu.this.m6723(i)) {
                                C1283.m16863("MdxTargetStateV2", "event %d not handled @%s", Integer.valueOf(i), C1835gu.this.f7002.m801());
                                return;
                            } else {
                                return;
                            }
                        case 8:
                            if (TargetStateEvent.HandShakeSucceed.m807(i)) {
                                if (C1835gu.this.f7001.m783()) {
                                    C1835gu.this.m6717(TargetState.StateSendingMessage);
                                    return;
                                } else {
                                    C1835gu.this.m6717(TargetState.StateSessionReady);
                                    return;
                                }
                            } else if (!C1835gu.this.m6723(i)) {
                                C1283.m16863("MdxTargetStateV2", "event %d not handled @%s", Integer.valueOf(i), C1835gu.this.f7002.m801());
                                return;
                            } else {
                                return;
                            }
                        case 9:
                            if (!TargetStateEvent.MessageReceived.m807(i) || message.arg1 != TargetSessionMessageType.MESSAGE_TYPE_CAPABILITY.f1441) {
                                if (!C1835gu.this.m6723(i)) {
                                    C1283.m16863("MdxTargetStateV2", "event %d, %d not handled @%s", Integer.valueOf(i), Integer.valueOf(message.arg1), C1835gu.this.f7002.m801());
                                    return;
                                }
                                return;
                            } else if (C1835gu.this.f7001.m783()) {
                                C1835gu.this.m6717(TargetState.StateSendingMessage);
                                return;
                            } else {
                                C1835gu.this.m6717(TargetState.StateSessionReady);
                                return;
                            }
                        case 10:
                            if (!TargetStateEvent.MessageReceived.m807(i) || message.arg1 != TargetSessionMessageType.MESSAGE_TYPE_CURRENT_STATE.f1441) {
                                if (!C1835gu.this.m6723(i)) {
                                    C1283.m16863("MdxTargetStateV2", "event %d, %d not handled @%s", Integer.valueOf(i), Integer.valueOf(message.arg1), C1835gu.this.f7002.m801());
                                    return;
                                }
                                return;
                            } else if (C1835gu.this.f7001.m783()) {
                                C1835gu.this.m6717(TargetState.StateSendingMessage);
                                return;
                            } else {
                                C1835gu.this.m6717(TargetState.StateSessionReady);
                                return;
                            }
                        case 11:
                            if (TargetStateEvent.SendMessageSucceed.m807(i)) {
                                C1835gu.this.f7001.m781();
                                if (C1835gu.this.f7001.m783()) {
                                    C1835gu.this.m6717(TargetState.StateSendingMessage);
                                    return;
                                } else {
                                    C1835gu.this.m6717(TargetState.StateSessionReady);
                                    return;
                                }
                            } else if (!C1835gu.this.m6723(i)) {
                                C1283.m16863("MdxTargetStateV2", "event %d, %d not handled @%s", Integer.valueOf(i), Integer.valueOf(message.arg1), C1835gu.this.f7002.m801());
                                return;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6733() {
        this.f7002 = TargetState.StateInit;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6728() {
        this.f6998 = this.f7001.m799();
        this.f6999.obtainMessage(TargetStateEvent.start.m808()).sendToTarget();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6731(TargetStateEvent targetStateEvent) {
        this.f6999.obtainMessage(targetStateEvent.m808()).sendToTarget();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6730(TargetSessionMessageType targetSessionMessageType) {
        this.f6999.obtainMessage(TargetStateEvent.MessageReceived.m808(), targetSessionMessageType.f1441, 0).sendToTarget();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6722() {
        this.f6999.sendEmptyMessageDelayed(TargetStateEvent.PeriodicStateCheck.m808(), 25000);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Handler m6727() {
        return this.f6999;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6729(long j) {
        if (120000 > j && j > 0) {
            this.f7000 = j;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m6732() {
        return TargetState.StateAcquirePair.equals(this.f7002) || TargetState.StateRegPair.equals(this.f7002);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6717(TargetState targetState) {
        C1283.m16863("MdxTargetStateV2", "(%d) state %s => %s", Integer.valueOf(hashCode()), this.f7002.m801(), targetState.m801());
        if (!this.f7002.m804(targetState)) {
            this.f7002 = targetState;
        }
        this.f6999.removeMessages(TargetStateEvent.Timeout.m808());
        switch (this.f7002.m806()) {
            case STATE_INIT:
            case STATE_NOPAIR:
            case STATE_HASPAIR:
            case STATE_SESSION_READY:
                return;
            case STATE_ACQUIRE_PAIR:
                this.f7001.m797();
                break;
            case STATE_REGPAIR:
                this.f7001.m778();
                if (this.f7000 > 0) {
                    this.f6999.sendEmptyMessageDelayed(TargetStateEvent.Timeout.m808(), this.f7000);
                    return;
                }
                break;
            case STATE_START_SESSION:
                this.f7001.m777();
                break;
            case STATE_HAND_SHAKE:
                this.f7001.m775();
                break;
            case STATE_GET_CAP:
                this.f7001.m776();
                break;
            case STATE_GET_STATE:
                this.f7001.m774();
                break;
            case STATE_SENDING_MESSAGE:
                if (!this.f7001.m779()) {
                    this.f7002 = TargetState.StateSessionReady;
                    return;
                }
                break;
        }
        this.f6999.sendEmptyMessageDelayed(TargetStateEvent.Timeout.m808(), (long) this.f7002.m805());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m6711() {
        switch (this.f7002.m806()) {
            case STATE_INIT:
            case STATE_NOPAIR:
            case STATE_HASPAIR:
            case STATE_SESSION_READY:
                return true;
            case STATE_ACQUIRE_PAIR:
            case STATE_REGPAIR:
                if (this.f7002.m803()) {
                    if (this.f7001.m799()) {
                        this.f7001.m786(103, this.f7002.m801() + " timeout");
                    }
                    m6717(TargetState.StateNoPair);
                    return true;
                }
                m6717(this.f7002);
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean m6725() {
        switch (this.f7002.m806()) {
            case STATE_INIT:
            case STATE_NOPAIR:
            case STATE_HASPAIR:
            case STATE_SESSION_READY:
                return true;
            default:
                if (this.f7002.m803()) {
                    return false;
                }
                m6717(this.f7002);
                return true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m6723(int i) {
        if (TargetStateEvent.SendMessageFail.m807(i)) {
            long r5 = (long) this.f7002.m802();
            C1283.m16863("MdxTargetStateV2", "SendMessageFail @%s, retry after %d", this.f7002.m801(), Long.valueOf(r5));
            this.f6999.removeMessages(TargetStateEvent.MessageFailRetry.m808());
            this.f6999.removeMessages(TargetStateEvent.Timeout.m808());
            this.f6999.sendEmptyMessageDelayed(TargetStateEvent.MessageFailRetry.m808(), r5);
            return true;
        } else if (TargetStateEvent.MessageFailRetry.m807(i) || TargetStateEvent.Timeout.m807(i)) {
            if (!m6725()) {
                if (this.f7001.m799()) {
                    if (TargetStateEvent.Timeout.m807(i)) {
                        C1283.m16863("MdxTargetStateV2", "session timeout  @%s", this.f7002.m801());
                        this.f7001.m786(100, "session timeout");
                    } else {
                        C1283.m16863("MdxTargetStateV2", "session retry failure @%s", this.f7002.m801());
                        this.f7001.m786(105, "session error");
                    }
                }
                m6717(TargetState.StateHasPair);
                return true;
            }
            C1283.m16863("MdxTargetStateV2", "handle event %d, remaining @%s", Integer.valueOf(i), this.f7002.m801());
            return true;
        } else if (TargetStateEvent.SendMessageFailedBadPair.m807(i)) {
            m6717(TargetState.StateAcquirePair);
            return true;
        } else if (TargetStateEvent.SendMessageFailedNeedNewSession.m807(i)) {
            m6717(TargetState.StateStartSession);
            return true;
        } else {
            C1283.m16863("MdxTargetStateV2", "event %d not handled @%s", Integer.valueOf(i), this.f7002.m801());
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean m6726() {
        if (System.currentTimeMillis() <= this.f7003 + 25000) {
            return false;
        }
        this.f7003 = System.currentTimeMillis();
        this.f7001.m774();
        return true;
    }
}
