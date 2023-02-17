package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Pair;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.netflix.mediaclient.service.player.OfflinePlaybackSession;
import com.netflix.mediaclient.service.user.UserAgent;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.List;
import o.oM;
/* renamed from: o.iz  reason: case insensitive filesystem */
public class C1898iz implements AbstractC2056pe {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final iE f7829;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean f7830;

    /* renamed from: ʼ  reason: contains not printable characters */
    private HandlerThread f7831;

    /* renamed from: ʽ  reason: contains not printable characters */
    private AbstractC1893iu f7832;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final BroadcastReceiver f7833 = new BroadcastReceiver() { // from class: o.iz.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1283.m16853("nf_playbackSessionMgr", "Received intent ", intent);
            String action = intent.getAction();
            if ("com.netflix.mediaclient.intent.action.PLAYER_HDR_FORMAT_CHANGED".equals(action)) {
                C1283.m16854("nf_playbackSessionMgr", "HDR format has changed.");
                if (C1898iz.this.f7838 != null) {
                    C1898iz.this.f7838.m8076();
                }
                if (C1898iz.this.f7849 != null) {
                    C1898iz.this.f7849.m7890();
                }
            } else if ("com.netflix.mediaclient.intent.action.PLAYER_AUDIO_SUBTITLE_CHANGED".equals(action)) {
                C1283.m16854("nf_playbackSessionMgr", "user audio subtitle preferences have changed.");
                if (C1898iz.this.f7838 != null) {
                    C1898iz.this.f7838.m8076();
                }
                if (C1898iz.this.f7849 != null) {
                    C1898iz.this.f7849.m7890();
                }
            }
        }
    };

    /* renamed from: ʿ  reason: contains not printable characters */
    private final BroadcastReceiver f7834 = new BroadcastReceiver() { // from class: o.iz.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_DEACTIVE".equals(action) || "com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE".equals(action)) {
                    C1283.m16854("nf_playbackSessionMgr", "account or profile is now de-activated");
                    if (C1898iz.this.f7849 != null) {
                        C1898iz.this.f7849.m7890();
                    }
                    if (C1898iz.this.f7838 != null) {
                        C1898iz.this.f7838.m8076();
                    }
                }
            }
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Handler f7835;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Pair<Long, Long> f7836;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1260 f7837;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C1919jt f7838;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final iI f7839 = new iI();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final UserAgent f7840;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private AbstractC1936kg f7841;

    /* renamed from: ͺ  reason: contains not printable characters */
    private kM f7842;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Context f7843;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private AbstractC1897iy f7844;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private iB f7845;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private iH f7846;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final iT f7847;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final PriorityTaskManager f7848;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private jE f7849;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private C1932kc f7850;

    public C1898iz(Context context, iE iEVar, iT iTVar, C1260 r5, UserAgent userAgent, PriorityTaskManager priorityTaskManager) {
        C1348Bu.m4093();
        this.f7843 = context;
        this.f7829 = iEVar;
        this.f7835 = new Handler();
        this.f7837 = r5;
        this.f7840 = userAgent;
        this.f7847 = iTVar;
        this.f7848 = priorityTaskManager;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7796(AbstractC1893iu iuVar, AbstractC1897iy iyVar, AbstractC1899j jVar, AbstractC0661 r10) {
        this.f7832 = iuVar;
        this.f7836 = new Pair<>(AP.m3397(), AP.m3400());
        this.f7844 = iyVar;
        this.f7841 = iuVar.mo7769(this.f7843, this.f7837, this);
        this.f7831 = new HandlerThread("NrdpPlaybackWorkerThread", -1);
        this.f7831.start();
        this.f7849 = new jE(this.f7843, this.f7831.getLooper(), this.f7847, this.f7837.mo16548());
        this.f7838 = new C1919jt(this.f7831.getLooper(), this.f7849, this.f7847, this.f7837.m16754(), this.f7829.m16086().mo1503());
        this.f7842 = iuVar.mo7767(this.f7843, this.f7849);
        this.f7845 = new iB(this.f7843);
        this.f7850 = new C1932kc(this.f7843);
        m7790();
        this.f7830 = true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7793() {
        this.f7830 = false;
        m7788();
        if (this.f7838 != null) {
            this.f7838.m8072();
            this.f7838 = null;
        }
        if (this.f7842 != null) {
            this.f7842.m8260();
            this.f7842 = null;
        }
        if (this.f7849 != null) {
            this.f7849.m7889();
            this.f7849 = null;
        }
        if (this.f7831 != null) {
            this.f7831.quit();
            this.f7831 = null;
        }
    }

    @Override // o.AbstractC2056pe
    /* renamed from: ˊ  reason: contains not printable characters */
    public oM mo7792(oM.AbstractC0160 r25, oY oYVar, AbstractC2055pd pdVar, long j, oX oXVar, long j2) {
        C1283.m16851("nf_playbackSessionMgr", "openPlaybackSessionAndPlay %d", Long.valueOf(j));
        if (!this.f7830) {
            return null;
        }
        if (iC.m7414(this.f7829.m16088(), j + "")) {
            OfflinePlaybackSession r21 = this.f7839.m7446(j);
            if (r21 == null) {
                OfflinePlaybackSession offlinePlaybackSession = new OfflinePlaybackSession(this.f7843, this.f7835, r25, this.f7837, this.f7844, this.f7829.m16086(), this.f7840, this.f7829.u_(), this.f7847, this.f7845, j, j2, oXVar, pdVar);
                this.f7839.m7445(oYVar, offlinePlaybackSession);
                return offlinePlaybackSession;
            }
            r21.mo898(r25);
            r21.mo899(oXVar, j2, "playbackSessionMgrOffline");
            return r21;
        } else if (!ConnectivityUtils.m2954(this.f7843)) {
            C1283.m16851("nf_playbackSessionMgr", "openPlaybackSessionAndPlay no network %d", Long.valueOf(j));
            iC.m7413(this.f7843, r25);
            return null;
        } else {
            iM r212 = this.f7839.m7442(j);
            if (r212 == null) {
                AbstractC1891is r213 = this.f7832.mo7768(this.f7843, r25, this.f7849, this.f7838, this.f7840, this.f7837, this.f7829.u_(), this.f7829.m16086(), this.f7835, this.f7831.getLooper(), j, oXVar, j2, this.f7836, this.f7841, this.f7850, pdVar);
                this.f7839.m7445(oYVar, r213);
                return r213;
            }
            r212.mo898(r25);
            r212.mo899(oXVar, j2, "playbackSessionMgrStreaming");
            return r212;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7798() {
        AbstractC1891is isVar = AbstractC1891is.f7775;
        if (isVar != null) {
            isVar.mo903();
            if (C0577.m14678(this.f7843)) {
                this.f7841.mo7766(isVar.mo902());
            }
        }
        if (this.f7849 != null) {
            this.f7849.m7891();
        }
        if (this.f7838 != null) {
            this.f7838.m8076();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7794(int i) {
        if (i == 20) {
            if (this.f7838 != null) {
                this.f7838.m8070();
            }
            AbstractC1891is isVar = AbstractC1891is.f7775;
            if (isVar != null && this.f7846 != null && isVar.m7748().mo9716()) {
                this.f7846.mo7440(String.valueOf(isVar.mo7754()));
                isVar.m7756(this.f7846);
            }
        } else if (i >= 40 && this.f7849 != null) {
            this.f7849.m7887();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7790() {
        LocalBroadcastManager.getInstance(this.f7843).registerReceiver(this.f7834, C2018nv.m9354());
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m7788() {
        try {
            LocalBroadcastManager.getInstance(this.f7843).unregisterReceiver(this.f7834);
        } catch (Exception e) {
            C1283.m16856("nf_playbackSessionMgr", e, "unregisterUserAgentReceiver", new Object[0]);
        }
    }

    @Override // o.AbstractC2056pe
    /* renamed from: ॱ  reason: contains not printable characters */
    public oY mo7800() {
        AnonymousClass3 r1 = new oY() { // from class: o.iz.3
        };
        this.f7839.m7444(r1);
        return r1;
    }

    @Override // o.AbstractC2056pe
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo7802(oY oYVar) {
        this.f7839.m7443(oYVar);
    }

    @Override // o.AbstractC2056pe
    /* renamed from: ˏ  reason: contains not printable characters */
    public oM mo7799() {
        return AbstractC1891is.f7775;
    }

    @Override // o.AbstractC2056pe
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo7795(List<C2054pc> list) {
        if (this.f7849 != null) {
            this.f7849.m7888(list);
        }
        if (this.f7838 != null) {
            this.f7838.m8073(list);
        }
        if (this.f7842 != null) {
            this.f7842.m8262(list);
        }
    }

    @Override // o.AbstractC2056pe
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo7801(PlayerPrefetchSource playerPrefetchSource) {
        if (this.f7842 != null) {
            this.f7842.m8261(playerPrefetchSource);
        }
    }

    @Override // o.AbstractC2056pe
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo7797(iH iHVar) {
        this.f7846 = iHVar;
    }
}
