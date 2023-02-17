package com.netflix.mediaclient.service.player;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.AudioSubtitleDefaultOrderInfo;
import com.netflix.mediaclient.media.PlayerManifestData;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.Watermark;
import com.netflix.mediaclient.media.manifest.Stream;
import com.netflix.mediaclient.service.player.offlineplayback.ExoPlaybackError;
import com.netflix.mediaclient.service.player.offlineplayback.OfflinePlaybackState;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.ExitPipAction;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import com.netflix.mediaclient.servicemgr.LogArguments;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.activitytracking.ActivityTracker;
import java.nio.ByteBuffer;
import java.util.List;
import o.AG;
import o.AZ;
import o.AbstractC1221;
import o.AbstractC1542bQ;
import o.AbstractC1613cg;
import o.AbstractC1891is;
import o.AbstractC1894iv;
import o.AbstractC1897iy;
import o.AbstractC1979mj;
import o.AbstractC1981ml;
import o.AbstractC2055pd;
import o.C0582;
import o.C1276;
import o.C1283;
import o.C1332Be;
import o.C1349Bv;
import o.C1886in;
import o.C1896ix;
import o.C1987mr;
import o.C2003ng;
import o.iA;
import o.iB;
import o.iD;
import o.iJ;
import o.iP;
import o.iT;
import o.jL;
import o.jO;
import o.jP;
import o.jR;
import o.jS;
import o.jU;
import o.jV;
import o.jX;
import o.jY;
import o.jZ;
import o.oM;
import o.oX;
import org.json.JSONException;
import org.json.JSONObject;
public class OfflinePlaybackSession extends AbstractC1891is implements AbstractC1894iv, AbstractC1981ml, jL.iF {

    /* renamed from: ʹ  reason: contains not printable characters */
    private Long f1557;

    /* renamed from: ʻᐝ  reason: contains not printable characters */
    private final Runnable f1558 = new Runnable() { // from class: com.netflix.mediaclient.service.player.OfflinePlaybackSession.3
        @Override // java.lang.Runnable
        public void run() {
            long r3 = OfflinePlaybackSession.this.mo928();
            if (r3 > OfflinePlaybackSession.this.f1584) {
                OfflinePlaybackSession.this.f1590.m7407((int) (r3 - OfflinePlaybackSession.this.f1584));
            }
            OfflinePlaybackSession.this.f1584 = r3;
            OfflinePlaybackSession.this.f1559.m7422((int) r3, (C1987mr) null);
            OfflinePlaybackSession.this.m879((int) r3);
            OfflinePlaybackSession.this.f1563.mo7282(OfflinePlaybackSession.this.f7778, r3);
            OfflinePlaybackSession.this.f1571.mo611(OfflinePlaybackSession.this.f7785, r3, OfflinePlaybackSession.this.m882());
            if (OfflinePlaybackSession.this.mo892()) {
                OfflinePlaybackSession.this.f1560.postDelayed(this, 1000);
            }
        }
    };

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final iD f1559;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final Handler f1560;

    /* renamed from: ʾ  reason: contains not printable characters */
    private jY f1561;

    /* renamed from: ʿ  reason: contains not printable characters */
    private final iT f1562;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final AbstractC1897iy f1563;

    /* renamed from: ˉ  reason: contains not printable characters */
    private DashManifest f1564;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private jZ f1565;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private PlayerManifestData f1566;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private Subtitle[] f1567;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private AudioSubtitleDefaultOrderInfo[] f1568;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private Surface f1569;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private Subtitle f1570;

    /* renamed from: ˌ  reason: contains not printable characters */
    private AbstractC1613cg f1571;

    /* renamed from: ˍ  reason: contains not printable characters */
    private C1886in f1572;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private iP f1573;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private String f1574;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private String f1575;

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private String f1576;

    /* renamed from: ˑ  reason: contains not printable characters */
    private String f1577;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private String f1578;

    /* renamed from: ـ  reason: contains not printable characters */
    private String f1579;

    /* renamed from: ॱʻ  reason: contains not printable characters */
    private Watermark f1580;

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private long f1581;

    /* renamed from: ॱʽ  reason: contains not printable characters */
    private long f1582;

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private long f1583;

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private long f1584 = 0;

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private ResumePlayReason f1585 = ResumePlayReason.none;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final boolean f1586 = false;

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private boolean f1587;

    /* renamed from: ᐧ  reason: contains not printable characters */
    private boolean f1588;

    /* renamed from: ᐨ  reason: contains not printable characters */
    private boolean f1589;

    /* renamed from: ᶥ  reason: contains not printable characters */
    private iA f1590;

    /* renamed from: ㆍ  reason: contains not printable characters */
    private ActivityTracker f1591;

    /* renamed from: ꓸ  reason: contains not printable characters */
    private boolean f1592;

    /* renamed from: ꜞ  reason: contains not printable characters */
    private iJ f1593;

    /* renamed from: ꜟ  reason: contains not printable characters */
    private final C1896ix f1594;

    /* renamed from: ꞌ  reason: contains not printable characters */
    private final boolean f1595;

    /* renamed from: ﹳ  reason: contains not printable characters */
    private final AbstractC1221 f1596;

    /* renamed from: ﾞ  reason: contains not printable characters */
    private jL f1597;

    /* renamed from: ﾟ  reason: contains not printable characters */
    private boolean f1598;

    /* access modifiers changed from: package-private */
    public enum EndPlayReason {
        ended,
        stopped,
        error
    }

    /* access modifiers changed from: package-private */
    public enum ResumePlayReason {
        none,
        repos
    }

    public OfflinePlaybackSession(Context context, Handler handler, oM.AbstractC0160 r16, AbstractC1221 r17, AbstractC1897iy iyVar, IClientLogging iClientLogging, UserAgentInterface userAgentInterface, C2003ng ngVar, iT iTVar, iB iBVar, long j, long j2, oX oXVar, AbstractC2055pd pdVar) {
        super(context, iClientLogging, ngVar, userAgentInterface, r17, iBVar, oXVar, j, j2, pdVar);
        this.f1560 = handler;
        this.f1559 = new iD(handler);
        mo898(r16);
        this.f1596 = r17;
        this.f1563 = iyVar;
        this.f1592 = false;
        this.f1562 = iTVar;
        this.f1594 = C1896ix.m7782(this.f7785);
        mo899(oXVar, j2, "OfflinePlaybackSession constructor");
        this.f1595 = this.f1596.mo16537().getDisableOfflineLogblobs();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˍ  reason: contains not printable characters */
    private void m870() {
        f7775 = this;
        m876();
        m863(this.f1563, this.f7778);
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m876() {
        this.f1576 = AZ.m3500();
        this.f1583 = SystemClock.elapsedRealtime();
        this.f1571 = this.f7793.mo1518().mo5848(this.f7785, Long.toString(this.f7778), mo896(), this.f7784, this.f7781);
        this.f1557 = Long.valueOf(Logger.INSTANCE.m127(new C0582(C1332Be.m4014(this.f1576).longValue(), null)));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo899(oX oXVar, long j, String str) {
        this.f7781 = oXVar;
        this.f7784 = j;
        if (this.f1593 == null) {
            this.f1593 = new iJ(this.f1594);
            this.f7785.registerReceiver(this.f1593, AG.m3335("android.intent.action.ACTION_POWER_CONNECTED"));
        }
        if (this.f1572 == null) {
            this.f1572 = new C1886in(this.f7780, this, this, this.f7778, this.f7786);
        }
        AbstractC1891is isVar = AbstractC1891is.f7775;
        if (isVar == null || isVar.mo7754() != this.f7778) {
            if (isVar == null) {
                C1283.m16862("nf_OfflinePlaybackSession", "...no last active session, creating a new session...");
                this.f1598 = false;
                m870();
            } else if (isVar.mo912()) {
                C1283.m16850("nf_OfflinePlaybackSession", "LAST_SESSION_STILL_BEING_ACQUIRED");
                m7757(this.f1559, new ExoPlaybackError(ExoPlaybackError.ExoPlaybackErrorCode.LAST_SESSION_STILL_BEING_ACQUIRED, true));
            } else if (!isVar.mo923()) {
                C1283.m16850("nf_OfflinePlaybackSession", "LAST_SESSION_STILL_PREPARING");
                m7757(this.f1559, new ExoPlaybackError(ExoPlaybackError.ExoPlaybackErrorCode.LAST_SESSION_STILL_PREPARING, true));
            } else {
                C1283.m16863("nf_OfflinePlaybackSession", ".... closing the last active session %d", Long.valueOf(isVar.mo7754()));
                this.f1598 = false;
                isVar.mo920(new AbstractC1891is.AbstractC0128() { // from class: com.netflix.mediaclient.service.player.OfflinePlaybackSession.5
                    @Override // o.AbstractC1891is.AbstractC0128
                    /* renamed from: ॱ  reason: contains not printable characters */
                    public void mo933() {
                        C1283.m16862("nf_OfflinePlaybackSession", "....last active session closed, will start the new session...");
                        OfflinePlaybackSession.this.m870();
                    }
                });
            }
        } else if (mo912()) {
            C1283.m16862("nf_OfflinePlaybackSession", "not re-opening a closing session");
            m7757(this.f1559, new ExoPlaybackError(ExoPlaybackError.ExoPlaybackErrorCode.REOPENING_CLOSING_SESSION, true));
        } else {
            C1283.m16862("nf_OfflinePlaybackSession", "resuming the last active session");
            mo919(-5000, 5000);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m863(AbstractC1897iy iyVar, long j) {
        C1283.m16854("nf_OfflinePlaybackSession", "requestOfflineManifest movieId=" + j);
        iyVar.mo7280(j, new AbstractC1897iy.Cif() { // from class: com.netflix.mediaclient.service.player.OfflinePlaybackSession.1
            @Override // o.AbstractC1897iy.Cif
            /* renamed from: ˏ  reason: contains not printable characters */
            public void mo932(long j2, AbstractC1897iy.If r4, String str, Status status) {
                if (status.mo298()) {
                    OfflinePlaybackSession.this.m881(r4);
                } else {
                    OfflinePlaybackSession.this.m861(str, status);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m861(String str, Status status) {
        m7760();
        if (!this.f1598) {
            C1283.m16851("nf_OfflinePlaybackSession", "onManifestResponse error=%s", status);
            this.f1577 = str;
            String r6 = status.mo305();
            m862(OfflinePlaybackState.MANIFEST_FETCH.toString(), "OfflinePlayback.ManifestRequestFailure", status.toString() + (r6 != null ? " dbgmsg=" + r6 : ""));
            m7752(this.f1559, new ExoPlaybackError(ExoPlaybackError.ExoPlaybackErrorCode.MANIFEST_FAILURE, "onManifestResponse failed " + status, OfflinePlaybackState.MANIFEST_FETCH.toString(), null));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m881(AbstractC1897iy.If r12) {
        if (!this.f1598) {
            this.f1568 = r12.mo7633();
            this.f1567 = r12.mo7639();
            this.f7788 = r12.mo7636();
            this.f1571.mo612(r12);
            this.f1577 = r12.mo7637();
            this.f1578 = r12.mo7632();
            this.f1580 = r12.mo7640();
            List<Stream> list = r12.mo7638().get(0).streams;
            this.f1581 = (long) list.get(0).bitrate;
            this.f1575 = list.get(0).downloadable_id;
            this.f1566 = r12.mo7628();
            this.f1564 = m885(r12);
            byte[] r9 = r12.mo7642();
            if (r9 == null || r9.length <= 0) {
                C1283.m16854("nf_OfflinePlaybackSession", "invalid offline KeySetId, assume it is clear content");
            } else {
                C1283.m16860("nf_OfflinePlaybackSession", "has KeySetId", r9);
                try {
                    this.f1565 = new jZ(r9);
                } catch (Throwable th) {
                    m7760();
                    m862(OfflinePlaybackState.MANIFEST_PROCESSING.toString(), "OfflinePlayback.DrmSessionRestoreFailed", th.getMessage());
                    this.f1571.mo607(m882(), OfflinePlaybackState.MANIFEST_PROCESSING.toString(), "OfflinePlayback.DrmSessionRestoreFailed");
                    m7752(this.f1559, new ExoPlaybackError(ExoPlaybackError.ExoPlaybackErrorCode.SESSION_INIT_ERROR, "OfflineDrmSession failed", OfflinePlaybackState.MANIFEST_PROCESSING.toString(), null));
                    return;
                }
            }
            if (m875(this.f7785, r12.mo7630())) {
                this.f1597 = new jL(r12, this.f1562, this.f7793.mo1503(), this.f1576, this.f1571, this);
                this.f1597.m7958();
            }
            if (r12.mo7629() != null) {
                this.f1573 = new iP(r12.mo7629());
            }
            m868(r12);
            this.f1590 = new iA();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static DashManifest m885(AbstractC1897iy.If r2) {
        Object r1 = r2.mo7635();
        if (r1 instanceof DashManifest) {
            return (DashManifest) r1;
        }
        return null;
    }

    @Override // o.AbstractC1891is
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo896() {
        return this.f1576;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ᐝ  reason: contains not printable characters */
    public IPlayer.aux mo930() {
        return new ExoPlaybackError(ExoPlaybackError.ExoPlaybackErrorCode.RESTART_APP_SESSION_ERROR, false);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public boolean mo922() {
        return false;
    }

    @Override // o.oM
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo926(boolean z) {
        if (this.f1561 != null) {
            this.f1561.m8033(z);
        }
    }

    @Override // o.oM
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo915(float f) {
        if (this.f1561 != null) {
            this.f1561.m8031(f);
        }
    }

    @Override // o.oM
    public void K_() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f1583;
        try {
            m874(new jP(mo928(), elapsedRealtime, this.f1576, this.f1577, this.f1578));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // o.oM
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo907(ExitPipAction exitPipAction) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f1583;
        try {
            m874(new jR(mo928(), elapsedRealtime, exitPipAction.m1502(), this.f1576, this.f1577, this.f1578));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // o.oM
    /* renamed from: ॱˋ  reason: contains not printable characters */
    public void mo927() {
        if (mo912()) {
            C1283.m16844("nf_OfflinePlaybackSession", "trying to re-acquire a session which is being acquired by another session %d", Long.valueOf(this.f7778));
            return;
        }
        C1283.m16851("nf_OfflinePlaybackSession", "play: %d", Long.valueOf(this.f7778));
        if (this.f1598) {
            this.f7784 = mo928();
            mo899(this.f7781, this.f7784, "OfflinePlaybackSessionPlay");
        } else if (this.f1561 != null) {
            this.f1561.m8038();
            this.f1571.mo615(this.f1590.m7406());
        }
    }

    @Override // o.oM
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public void mo931() {
        if (this.f1561 != null) {
            C1283.m16854("nf_OfflinePlaybackSession", "pause: ");
            this.f1561.m8034();
            this.f1563.mo7284(this.f7778);
            this.f1571.mo609(this.f1590.m7406());
        }
    }

    @Override // o.oM
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public void mo929() {
        C1283.m16854("nf_OfflinePlaybackSession", "unpause: ");
        mo927();
    }

    @Override // o.oM
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo897(long j, boolean z) {
        if (this.f1561 != null) {
            C1283.m16854("nf_OfflinePlaybackSession", "seekTo: ");
            if (this.f1585 == ResumePlayReason.none) {
                this.f1585 = ResumePlayReason.repos;
            }
            this.f1584 = j;
            this.f1561.mo7982(j);
            this.f1571.mo614(j);
            if (this.f1572 != null && this.f1572.m7714() != null) {
                this.f1572.m7714().mo8733((int) j);
            }
        }
    }

    @Override // o.oM
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo919(int i, int i2) {
        if (this.f1561 != null) {
            mo897(this.f1561.m8036() + ((long) i), true);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m868(AbstractC1897iy.If r8) {
        Subtitle r6 = r8.mo7631();
        if (this.f1572 != null) {
            this.f1572.m7715(r6, 0.0f, this.f7784, false);
        } else {
            C1276.m16820().mo5725("Unable to initialize subtitles with " + this.f7778);
        }
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    private String m883() {
        try {
            if (this.f1591 == null) {
                return "";
            }
            this.f1591.m3050();
            String jSONObject = this.f1591.m3053().toString();
            this.f1591 = null;
            return jSONObject;
        } catch (Exception e) {
            C1276.m16820().mo5730(e);
            return "";
        }
    }

    @Override // o.AbstractC1891is
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo920(AbstractC1891is.AbstractC0128 r7) {
        this.f7789 = 0;
        this.f1559.m7420();
        this.f7792 = r7;
        if (this.f1598) {
            C1283.m16854("nf_OfflinePlaybackSession", "already in process of closing... ");
            return;
        }
        m7761();
        this.f1598 = true;
        this.f1592 = false;
        C1283.m16851("nf_OfflinePlaybackSession", "close: %d", Long.valueOf(this.f7778));
        if (this.f1561 != null) {
            this.f1561.m8037();
            this.f1560.removeCallbacks(this.f1558);
            this.f1563.mo7289(this.f7778);
            if (m7751()) {
                mo907(ExitPipAction.STOP);
                mo7758(false);
            }
            m865(EndPlayReason.stopped, null, null, null, m883());
            C1283.m16854("nf_OfflinePlaybackSession", "close: " + m882());
            m884();
            this.f1571.mo607(m882(), null, null);
        } else {
            this.f1563.mo7281(this.f7778);
        }
        if (this.f1561 != null) {
            this.f1561.mo7981();
            this.f1561 = null;
        } else {
            this.f1563.mo7281(this.f7778);
        }
        if (this.f1573 != null) {
            this.f1573.mo7539();
            this.f1573 = null;
        }
        if (this.f1572 != null) {
            this.f1572.m7711();
            this.f1572 = null;
        }
        Logger.INSTANCE.m132(this.f1557);
        if (this.f1593 != null) {
            this.f7785.unregisterReceiver(this.f1593);
            this.f1593 = null;
        }
        m7760();
        if (this.f7792 != null) {
            this.f7792.mo933();
            this.f7792 = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public boolean mo912() {
        return this.f7792 != null;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ͺ  reason: contains not printable characters */
    public boolean mo923() {
        return this.f1592;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ʻॱ  reason: contains not printable characters */
    public boolean mo889() {
        return false;
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private void m884() {
        if (this.f1597 != null) {
            this.f1597.m7959();
        }
    }

    @Override // o.oM
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo906(Surface surface) {
        if (this.f1561 != null) {
            this.f1561.m8035(surface);
        }
        this.f1569 = surface;
    }

    @Override // o.oM
    /* renamed from: ॱˎ  reason: contains not printable characters */
    public long mo928() {
        if (this.f1561 != null) {
            return this.f1561.m8036();
        }
        return 0;
    }

    @Override // o.oM
    /* renamed from: ʾ  reason: contains not printable characters */
    public boolean mo892() {
        return this.f1561 != null && this.f1561.m8030();
    }

    @Override // o.oM
    /* renamed from: ʿ  reason: contains not printable characters */
    public AudioSource mo893() {
        String str = null;
        if (this.f1561 != null) {
            str = this.f1561.m8040();
        }
        return m7749(str);
    }

    @Override // o.oM
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo901(AudioSource audioSource) {
        if (this.f1561 == null) {
            return false;
        }
        boolean r2 = this.f1561.m8039(audioSource.getId());
        if (r2) {
            m877();
        }
        return r2;
    }

    @Override // o.oM
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo918(Subtitle subtitle, boolean z) {
        if (this.f1561 == null) {
            return false;
        }
        this.f1570 = subtitle;
        if (this.f1570 != null) {
            this.f1579 = this.f1570.getDownloadableId();
        } else {
            this.f1579 = null;
        }
        this.f1572.m7715(subtitle, 0.0f, this.f7784, z);
        if (subtitle == null) {
            C1283.m16854("nf_OfflinePlaybackSession", "Removing subtitles");
        }
        this.f1590.m7408(this.f1575, this.f1574, this.f1579);
        return false;
    }

    @Override // o.oM
    /* renamed from: ʼॱ  reason: contains not printable characters */
    public Subtitle[] mo890() {
        return this.f1567;
    }

    @Override // o.oM, o.AbstractC1977mh
    /* renamed from: ʽॱ  reason: contains not printable characters */
    public Subtitle mo891() {
        return this.f1570;
    }

    @Override // o.oM
    /* renamed from: ॱ  reason: contains not printable characters */
    public C1987mr mo924(long j) {
        if (!mo892()) {
            C1283.m16854("nf_OfflinePlaybackSession", "not playing");
            return null;
        } else if (mo891() == null) {
            C1283.m16854("nf_OfflinePlaybackSession", "Subtitles are not visible, do not send any update");
            return null;
        } else {
            C1886in inVar = this.f1572;
            if (inVar != null) {
                return inVar.m7713(j);
            }
            return null;
        }
    }

    @Override // o.oM
    /* renamed from: ˈ  reason: contains not printable characters */
    public AudioSubtitleDefaultOrderInfo[] mo894() {
        return this.f1568;
    }

    @Override // o.oM
    /* renamed from: ˋ  reason: contains not printable characters */
    public ByteBuffer mo905(long j) {
        if (this.f1573 == null) {
            return null;
        }
        if (j < 2147483647L) {
            return this.f1573.mo7538((int) j);
        }
        C1283.m16855("nf_OfflinePlaybackSession", "%d ms is too big, BifManager won't handle.", Long.valueOf(j));
        return null;
    }

    @Override // o.oM
    /* renamed from: ˉ  reason: contains not printable characters */
    public Watermark mo895() {
        return this.f1580;
    }

    @Override // o.oM
    /* renamed from: ˊˊ  reason: contains not printable characters */
    public StreamProfileType mo902() {
        return StreamProfileType.AL0;
    }

    @Override // o.oM
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public PlayerManifestData mo904() {
        return this.f1566;
    }

    @Override // o.oM
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo909(boolean z) {
    }

    @Override // o.oM
    /* renamed from: ˊˋ  reason: contains not printable characters */
    public void mo903() {
    }

    @Override // o.oM
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo898(oM.AbstractC0160 r2) {
        this.f1559.m7423(r2);
    }

    @Override // o.oM
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo921(oM.AbstractC0160 r2) {
        this.f1559.m7419(r2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private synchronized void m879(int i) {
        C1987mr r2 = mo924((long) i);
        if (r2 != null) {
            this.f1559.m7425(r2);
        }
    }

    @Override // o.AbstractC1894iv
    public void F_() {
        m877();
        this.f1592 = true;
        this.f1559.m7421(this);
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private void m877() {
        if (this.f1561 != null) {
            String r4 = this.f1561.m8040();
            if (r4 != null) {
                AudioSource[] audioSourceArr = this.f7788;
                for (AudioSource audioSource : audioSourceArr) {
                    if (C1349Bv.m4123(audioSource.getId(), r4)) {
                        this.f1574 = audioSource.getStreams().get(0).downloadable_id;
                        this.f1582 = (long) audioSource.getStreams().get(0).bitrate;
                    }
                }
            }
            this.f1590.m7408(this.f1575, this.f1574, this.f1579);
        }
    }

    @Override // o.AbstractC1894iv
    public void G_() {
        m867("Playing", "Paused");
    }

    @Override // o.AbstractC1894iv
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo900(boolean z) {
        mo927();
    }

    @Override // o.AbstractC1894iv
    public void H_() {
        this.f1560.post(new Runnable() { // from class: com.netflix.mediaclient.service.player.OfflinePlaybackSession.2
            @Override // java.lang.Runnable
            public void run() {
                if (OfflinePlaybackSession.this.f7782 != null) {
                    OfflinePlaybackSession.this.f7782.mo7441();
                    OfflinePlaybackSession.this.f7782 = null;
                }
            }
        });
        if (!this.f1587) {
            m862((String) null, (String) null, (String) null);
        } else {
            if (this.f1585 == ResumePlayReason.none) {
                m867("Paused", "Playing");
            } else {
                m880(this.f1585);
            }
            this.f1585 = ResumePlayReason.none;
        }
        this.f1563.mo7287(this.f7778);
        this.f1559.m7424();
        this.f1560.post(this.f1558);
    }

    @Override // o.AbstractC1894iv
    public void I_() {
        m865(EndPlayReason.ended, null, null, null, m883());
        m884();
        this.f1571.mo607(m882(), null, null);
        this.f1563.mo7289(this.f7778);
        this.f1559.m7417();
    }

    @Override // o.AbstractC1894iv
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo908(IPlayer.aux aux) {
        m7760();
        if (aux instanceof ExoPlaybackError) {
            ExoPlaybackError exoPlaybackError = (ExoPlaybackError) aux;
            if (this.f1587) {
                m865(EndPlayReason.error, exoPlaybackError.mo1001(), "OfflinePlayback.PlaybackFailed", exoPlaybackError.m1002(), m883());
                m884();
                this.f1571.mo607(m882(), exoPlaybackError.mo1001(), "OfflinePlayback.PlaybackFailed");
            } else {
                m862(OfflinePlaybackState.PLAYBACK_INIT.toString(), "OfflinePlayback.PlaybackFailed", exoPlaybackError.m1002());
            }
            m7752(this.f1559, exoPlaybackError);
            this.f1563.mo7279(this.f7778);
        }
    }

    @Override // o.AbstractC1894iv
    public void J_() {
    }

    @Override // o.AbstractC1981ml
    /* renamed from: ˋˊ  reason: contains not printable characters */
    public void mo910() {
        if (!this.f1592) {
            this.f1561 = jY.m7980(this.f7785, this.f1565, this.f1560, this, this.f1564, this.f7784);
            this.f1584 = this.f7784;
            if (this.f1569 != null) {
                this.f1561.m8035(this.f1569);
            }
        }
    }

    @Override // o.AbstractC1981ml
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo925(ISubtitleDef.SubtitleFailure subtitleFailure, Status status) {
        m7760();
        C1283.m16851("nf_OfflinePlaybackSession", "onSubtitleError %s", subtitleFailure);
        m7752(this.f1559, new ExoPlaybackError(ExoPlaybackError.ExoPlaybackErrorCode.SUBTITLE_ERROR, "SubtitleFailure=" + subtitleFailure.toString(), OfflinePlaybackState.PLAYBACK_INIT.toString(), null));
    }

    @Override // o.AbstractC1981ml
    /* renamed from: ˋˋ  reason: contains not printable characters */
    public void mo911() {
        C1283.m16854("nf_OfflinePlaybackSession", "subtitle stalled, start buffering");
    }

    @Override // o.AbstractC1981ml
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo916(long j) {
    }

    @Override // o.oM
    /* renamed from: ˋᐝ  reason: contains not printable characters */
    public ISubtitleDef.SubtitleProfile mo913() {
        AbstractC1979mj r2;
        C1886in inVar = this.f1572;
        if (inVar == null || (r2 = inVar.m7714()) == null) {
            return null;
        }
        return r2.D_();
    }

    @Override // o.oM
    /* renamed from: ˌ  reason: contains not printable characters */
    public IPlayer.PlaybackType mo914() {
        return IPlayer.PlaybackType.OfflinePlayback;
    }

    @Override // o.jL.iF
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo917(IPlayer.aux aux) {
        m7752(this.f1559, aux);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m862(String str, String str2, String str3) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f1583;
        boolean r28 = ConnectivityUtils.m2970(this.f7785);
        LogArguments.LogLevel logLevel = LogArguments.LogLevel.INFO;
        if (str != null) {
            logLevel = LogArguments.LogLevel.ERROR;
        }
        this.f1594.m7784(true);
        try {
            m874(new jU(logLevel, this.f7778, (long) this.f7781.getTrackId(), this.f1576, this.f1577, this.f1578, elapsedRealtime, this.f7784, this.f1575, this.f1581, this.f1574, this.f1582, elapsedRealtime, r28, str, str2, str3, this.f7786.mo9715().m9854()));
            if (str != null) {
                this.f1589 = true;
            } else if (ActivityTracker.m3046(this.f1596, this.f7785)) {
                boolean z = false;
                JSONObject r31 = jX.m7979(this.f7785, null, this.f7786);
                Integer valueOf = Integer.valueOf(r31 == null ? 0 : r31.optInt("activityDenominator"));
                if (valueOf != null && valueOf.intValue() > 0) {
                    z = this.f1577.hashCode() % valueOf.intValue() == 0;
                }
                if (z) {
                    this.f1591 = new ActivityTracker(this.f7785);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f1587 = true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m865(EndPlayReason endPlayReason, String str, String str2, String str3, String str4) {
        C1283.m16854("nf_OfflinePlaybackSession", "reportEndPlay: ");
        if (this.f1588 || this.f1589) {
            C1283.m16854("nf_OfflinePlaybackSession", "reportEndPlay: Already logged or error reported");
            return;
        }
        this.f1594.m7784(false);
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f1583;
        long r27 = mo928();
        boolean r29 = ConnectivityUtils.m2970(this.f7785);
        LogArguments.LogLevel logLevel = LogArguments.LogLevel.INFO;
        if (endPlayReason == EndPlayReason.error) {
            logLevel = LogArguments.LogLevel.ERROR;
            this.f1589 = true;
        }
        JSONObject jSONObject = null;
        if (this.f1561 != null) {
            jSONObject = this.f1561.m7983();
        }
        try {
            m874(new jO(logLevel, this.f7778, (long) this.f7781.getTrackId(), this.f1576, this.f1577, this.f1578, elapsedRealtime, r27, this.f1590.m7405() / 1000, endPlayReason.name(), r29, jSONObject, this.f1594.m7783(), str, str2, str3, str4, null, this.f1596.d_().mo14447()));
            this.f1588 = true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m867(String str, String str2) {
        try {
            m874(new jS(this.f1576, this.f1577, this.f1578, SystemClock.elapsedRealtime() - this.f1583, mo928(), str, str2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m880(ResumePlayReason resumePlayReason) {
        try {
            long r19 = mo928();
            m874(new jV(this.f7778, r19, SystemClock.elapsedRealtime() - this.f1583, this.f1576, this.f1577, this.f1578, resumePlayReason.name(), this.f1575, this.f1581, this.f1574, this.f1582));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m874(AbstractC1542bQ bQVar) {
        if (this.f1595) {
            C1283.m16854("nf_OfflinePlaybackSession", "dropping logblob event. disabled via config");
        } else {
            this.f7793.mo1512().mo5226(bQVar);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏˏ  reason: contains not printable characters */
    private JSONObject m882() {
        return this.f1590 != null ? this.f1590.m7406() : iA.m7404();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m875(Context context, JSONObject jSONObject) {
        if (!ConnectivityUtils.m2954(context)) {
            C1283.m16854("nf_OfflinePlaybackSession", "skip hybrid license - no network");
            return false;
        } else if (!m869(jSONObject)) {
            return true;
        } else {
            C1283.m16854("nf_OfflinePlaybackSession", "skip hybrid license - legacy manifest");
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m869(JSONObject jSONObject) {
        return jSONObject == null || !jSONObject.has("href");
    }
}
