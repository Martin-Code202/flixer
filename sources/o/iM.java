package o;

import android.content.Context;
import android.graphics.Point;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.AudioSubtitleDefaultOrderInfo;
import com.netflix.mediaclient.media.PlayerManifestData;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.SubtitleTrackData;
import com.netflix.mediaclient.media.Watermark;
import com.netflix.mediaclient.service.player.StreamProfileType;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import com.netflix.mediaclient.service.player.drm.NfDrmManagerInterface;
import com.netflix.mediaclient.service.player.streamingplayback.StreamingPlaybackErrorCode;
import com.netflix.mediaclient.service.player.streamingplayback.playbackreporter.StopReason;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.ExitPipAction;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.nio.ByteBuffer;
import java.util.List;
import o.AbstractC1891is;
import o.AbstractC1933kd;
import o.jA;
import o.jD;
import o.oM;
import org.json.JSONException;
import org.json.JSONObject;
public abstract class iM extends AbstractC1891is implements jD.If, jA.If, AbstractC1628ct, AbstractC1933kd, AbstractC1981ml {

    /* renamed from: ʼॱ  reason: contains not printable characters */
    protected boolean f7539;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    protected final jD f7540;

    /* renamed from: ʾ  reason: contains not printable characters */
    protected Surface f7541;

    /* renamed from: ʿ  reason: contains not printable characters */
    protected final Handler f7542;

    /* renamed from: ˈ  reason: contains not printable characters */
    protected AbstractC1930ka f7543;

    /* renamed from: ˉ  reason: contains not printable characters */
    private long f7544;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private final NfDrmManagerInterface f7545;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    protected lV f7546;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final AbstractC1936kg f7547;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    protected final iN f7548;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private AudioSubtitleDefaultOrderInfo[] f7549;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private Subtitle[] f7550;

    /* renamed from: ˌ  reason: contains not printable characters */
    private jA f7551;

    /* renamed from: ˍ  reason: contains not printable characters */
    private jG f7552;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private boolean f7553;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private String f7554;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private final iO f7555;

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private String f7556;

    /* renamed from: ˑ  reason: contains not printable characters */
    private jM[] f7557;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private List<SubtitleTrackData> f7558;

    /* renamed from: ـ  reason: contains not printable characters */
    private boolean f7559;

    /* renamed from: ॱʻ  reason: contains not printable characters */
    private boolean f7560;

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private boolean f7561;

    /* renamed from: ॱʽ  reason: contains not printable characters */
    private boolean f7562;

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private boolean f7563;

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private boolean f7564;

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private boolean f7565;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected String f7566 = iM.class.getSimpleName();

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private C1895iw f7567;

    /* renamed from: ᐧ  reason: contains not printable characters */
    private final If f7568;

    /* renamed from: ᐨ  reason: contains not printable characters */
    private PlayerManifestData f7569;

    /* renamed from: ᶥ  reason: contains not printable characters */
    private final Runnable f7570 = new Runnable() { // from class: o.iM.4
        @Override // java.lang.Runnable
        public void run() {
            iM.this.m7471();
        }
    };

    /* renamed from: ㆍ  reason: contains not printable characters */
    private final int f7571;

    /* renamed from: ꓸ  reason: contains not printable characters */
    private boolean f7572;

    /* renamed from: ꜞ  reason: contains not printable characters */
    private boolean f7573;

    /* renamed from: ꜟ  reason: contains not printable characters */
    private Long f7574;

    /* access modifiers changed from: protected */
    /* renamed from: ˎˏ  reason: contains not printable characters */
    public abstract void mo7501();

    /* access modifiers changed from: protected */
    /* renamed from: ˏˎ  reason: contains not printable characters */
    public abstract lV mo7504();

    public iM(Context context, oM.AbstractC0160 r15, jD jDVar, NfDrmManagerInterface nfDrmManagerInterface, UserAgentInterface userAgentInterface, AbstractC1221 r19, C2003ng ngVar, IClientLogging iClientLogging, Handler handler, Looper looper, long j, oX oXVar, long j2, AbstractC1936kg kgVar, C1932kc kcVar, AbstractC2055pd pdVar) {
        super(context, iClientLogging, ngVar, userAgentInterface, r19, kcVar, oXVar, j, j2, pdVar);
        this.f7566 += hashCode();
        this.f7540 = jDVar;
        this.f7545 = nfDrmManagerInterface;
        this.f7544 = j2;
        this.f7555 = new iO(handler);
        mo898(r15);
        this.f7542 = new Handler(looper);
        this.f7553 = true;
        this.f7569 = null;
        this.f7568 = new If();
        this.f7547 = kgVar;
        this.f7548 = new iN(this.f7542, this, this, this.f7780, this.f7787, this.f7778, pdVar);
        this.f7571 = r19.mo16530();
        C1283.m16851(this.f7566, "create playback session %d @ %d", Long.valueOf(j), Long.valueOf(j2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎˎ  reason: contains not printable characters */
    public void m7500() {
        C1283.m16862(this.f7566, "createLoggingSession");
        this.f7783 = AZ.m3500();
        this.f7546 = mo7504();
        this.f7546.mo8586(this.f7778, this.f7784, this.f7786.mo9715().m9854(), 0);
        this.f7574 = Long.valueOf(Logger.INSTANCE.m127(new C0582(C1332Be.m4014(this.f7783).longValue(), null)));
        m7480();
        this.f7791 = this.f7793.mo1518().mo5847(this.f7785, Long.toString(this.f7778), mo896(), this.f7784, this.f7542, new iL(this.f7781, ConnectivityUtils.m2958(this.f7785)).m7448(), this.f7781, this, this.f7786);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ˊ */
    public void mo899(oX oXVar, long j, String str) {
        this.f7781 = oXVar;
        this.f7784 = j;
        this.f7542.removeCallbacks(this.f7570);
        m7462(this.f7542, this.f7570);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺॱ  reason: contains not printable characters */
    private void m7471() {
        AbstractC1891is isVar = AbstractC1891is.f7775;
        if (isVar == null || isVar.mo7754() != this.f7778) {
            if (isVar == null) {
                C1283.m16863(this.f7566, "...no last active session, creating a new session for %d ...", Long.valueOf(this.f7778));
                this.f7565 = false;
                mo7501();
            } else if (isVar.mo912()) {
                C1283.m16850(this.f7566, "LAST_SESSION_STILL_BEING_ACQUIRED");
                m7757(this.f7555, new C1934ke(StreamingPlaybackErrorCode.LAST_SESSION_STILL_BEING_ACQUIRED, true));
            } else if (isVar.mo923() || isVar.mo889()) {
                C1283.m16863(this.f7566, ".... closing the last active session %d", Long.valueOf(isVar.mo7754()));
                this.f7565 = false;
                isVar.mo920(new AbstractC1891is.AbstractC0128() { // from class: o.iM.13
                    @Override // o.AbstractC1891is.AbstractC0128
                    /* renamed from: ॱ */
                    public void mo933() {
                        C1283.m16862(iM.this.f7566, "....last active session closed, will start the new session...");
                        C1348Bu.m4094();
                        iM.this.mo7501();
                    }
                });
            } else {
                C1283.m16850(this.f7566, "LAST_SESSION_STILL_PREPARING");
                m7757(this.f7555, new C1934ke(StreamingPlaybackErrorCode.LAST_SESSION_STILL_PREPARING, true));
            }
        } else if (mo912()) {
            C1283.m16862(this.f7566, "not re-opening a closing session");
            m7757(this.f7555, new C1934ke(StreamingPlaybackErrorCode.REOPENING_CLOSING_SESSION, true));
        } else {
            C1283.m16863(this.f7566, "resuming the last active session %d %d", Long.valueOf(this.f7544), Long.valueOf(this.f7784));
            AbstractC1930ka r6 = m7489();
            if (r6 != null) {
                if (m7470()) {
                    r6.mo8363(-5000, 5000);
                } else {
                    r6.mo8366(this.f7784, true);
                }
                if (this.f7548 != null) {
                    this.f7548.m7522((int) this.f7784);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ʻॱ */
    public boolean mo889() {
        if (System.currentTimeMillis() - this.f7789 < 30000) {
            return false;
        }
        if (this.f7552 != null && (!this.f7552.m7910() || this.f7551 != null)) {
            return !this.f7562;
        }
        C1283.m16862(this.f7566, "hasManifestOrLicenseOrPrepareStuck manifest or license stuck");
        return true;
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    private boolean m7470() {
        return this.f7544 > 0 && Math.abs(this.f7544 - this.f7784) < 10000;
    }

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private void m7480() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("xid", this.f7783);
        } catch (JSONException e) {
            C1283.m16850(this.f7566, "Unable to create play info jsonobject");
        }
        C1339Bl.m4039(this.f7785, "playback_failure_info", jSONObject.toString());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7462(Handler handler, Runnable runnable) {
        handler.post(runnable);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7466(Handler handler, Runnable runnable, long j) {
        handler.postDelayed(runnable, j);
    }

    /* renamed from: ـ  reason: contains not printable characters */
    private boolean m7472() {
        if (this.f7552 == null || !this.f7552.m7910()) {
            return true;
        }
        this.f7551 = this.f7545.mo8074(Long.valueOf(mo7754()), new C1923jx(this.f7783, this.f7552.m7935(), this.f7552.m7924(), this.f7552.m7921(), this.f7552.m7933()));
        if (this.f7551 == null) {
            C1283.m16850(this.f7566, "no available drm session.BUG!!!");
            m7467(StreamingPlaybackErrorCode.LICENSE_SESSION_UNAVAILABLE_ERROR, (Status) null);
            return false;
        }
        C1283.m16851(this.f7566, "has drm session with flavor %s", this.f7551.m7836().m8093());
        return true;
    }

    /* renamed from: ॱʽ  reason: contains not printable characters */
    private void m7478() {
        AbstractC1930ka r7 = m7489();
        if (this.f7539 && this.f7552 != null && r7 != null && m7472()) {
            this.f7553 = false;
            this.f7556 = m7484();
            r7.mo8361(this.f7552, this.f7783, this.f7556, (long) ((int) this.f7784), this.f7551);
            if (this.f7551 != null && !m7459(this.f7551)) {
                this.f7551.m7837(this);
                if (this.f7551.m7831()) {
                    this.f7546.mo8578();
                }
            }
        }
    }

    @Override // o.oM
    /* renamed from: ॱˋ */
    public void mo927() {
        if (mo912()) {
            C1283.m16844(this.f7566, "trying to re-acquire a session which is being acquired by another session %d", Long.valueOf(this.f7778));
        } else if (this.f7565) {
            this.f7784 = mo5965();
            mo899(this.f7781, this.f7784, "StreamingPlaybackSessionPlay");
        } else {
            m7462(this.f7542, new Runnable() { // from class: o.iM.12
                @Override // java.lang.Runnable
                public void run() {
                    if (iM.this.m7488()) {
                        iM.this.f7572 = true;
                        return;
                    }
                    AbstractC1930ka r2 = iM.this.m7489();
                    if (r2 != null) {
                        r2.mo8365();
                    }
                }
            });
        }
    }

    @Override // o.oM
    /* renamed from: ᐝॱ */
    public void mo931() {
        C1283.m16863(this.f7566, "pause %d", Long.valueOf(this.f7778));
        if (!this.f7562) {
            C1283.m16863(this.f7566, "playerNotPrepared, ignore pause %d", Long.valueOf(this.f7778));
        } else {
            m7462(this.f7542, new Runnable() { // from class: o.iM.15
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC1930ka r5 = iM.this.m7489();
                    if (r5 != null) {
                        iM.this.f7546.mo8582();
                        r5.mo8372();
                        return;
                    }
                    C1283.m16851(iM.this.f7566, "no-session, ignoring pause %d", Long.valueOf(iM.this.f7778));
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱʼ  reason: contains not printable characters */
    private void m7477() {
        C1283.m16863(this.f7566, "pause due to subtitle rebuffering %d", Long.valueOf(this.f7778));
        if (!this.f7562) {
            C1283.m16863(this.f7566, "playerNotPrepared, ignore pause %d", Long.valueOf(this.f7778));
        } else {
            m7462(this.f7542, new Runnable() { // from class: o.iM.14
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC1930ka r5 = iM.this.m7489();
                    if (r5 != null) {
                        iM.this.f7546.mo8579();
                        r5.mo8372();
                        return;
                    }
                    C1283.m16851(iM.this.f7566, "no-session, ignoring pause %d", Long.valueOf(iM.this.f7778));
                }
            });
        }
    }

    @Override // o.oM
    /* renamed from: ॱᐝ */
    public void mo929() {
        C1283.m16863(this.f7566, "unpause %d", Long.valueOf(this.f7778));
        mo927();
    }

    @Override // o.oM
    /* renamed from: ˊ */
    public void mo897(final long j, final boolean z) {
        final int r7 = (this.f7552 == null || this.f7552.m7920() - j >= 15000) ? (int) j : ((int) this.f7552.m7920()) - 15000;
        if (((long) r7) == j || this.f7544 <= ((long) r7)) {
            this.f7548.m7522(r7);
            m7462(this.f7542, new Runnable() { // from class: o.iM.11
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC1930ka r4 = iM.this.m7489();
                    if (r4 != null) {
                        iM.this.f7546.mo8593(StopReason.SEEK, j);
                        r4.mo8366((long) r7, z);
                    }
                }
            });
            return;
        }
        C1283.m16863(this.f7566, "ignoring seek %d", Long.valueOf(this.f7778));
    }

    @Override // o.oM
    /* renamed from: ˏ */
    public void mo919(final int i, final int i2) {
        this.f7548.m7522(i);
        m7462(this.f7542, new Runnable() { // from class: o.iM.17
            @Override // java.lang.Runnable
            public void run() {
                AbstractC1930ka r6 = iM.this.m7489();
                if (r6 != null) {
                    iM.this.f7546.mo8593(StopReason.SEEK, iM.this.mo928() + ((long) i));
                    r6.mo8363(i, i2);
                }
            }
        });
    }

    @Override // o.AbstractC1891is
    /* renamed from: ˏ */
    public void mo920(AbstractC1891is.AbstractC0128 r6) {
        C1283.m16863(this.f7566, "close %d", Long.valueOf(this.f7778));
        this.f7789 = 0;
        this.f7555.m7531();
        this.f7792 = r6;
        m7761();
        m7462(this.f7542, new Runnable() { // from class: o.iM.18
            @Override // java.lang.Runnable
            public void run() {
                iM.this.m7476();
            }
        });
        if (this.f7548 != null) {
            this.f7548.m7519();
        }
        C1339Bl.m4041(this.f7785, "playback_failure_info");
        Logger.INSTANCE.m132(this.f7574);
    }

    /* access modifiers changed from: private */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0024: APUT  
      (r2v1 java.lang.Object[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: java.lang.Boolean : 0x001f: INVOKE  (r3v3 java.lang.Boolean) = (r3v2 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* access modifiers changed from: public */
    /* renamed from: ॱʻ  reason: contains not printable characters */
    private void m7476() {
        AbstractC1930ka r5 = m7489();
        if (this.f7565 || r5 == null) {
            String str = this.f7566;
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.f7565);
            objArr[1] = Boolean.valueOf(r5 != null);
            C1283.m16851(str, "already in process of closing...mSessionIsClosingOrClosed=%b hasSessionPlayer=%b", objArr);
            return;
        }
        this.f7565 = true;
        this.f7553 = false;
        this.f7562 = false;
        this.f7561 = false;
        this.f7560 = false;
        C1283.m16851(this.f7566, "doClose %d", Long.valueOf(mo7754()));
        this.f7791.mo638(mo928());
        this.f7546.mo8593(StopReason.STOPPED, -1);
        if (m7751()) {
            this.f7546.mo8612(ExitPipAction.STOP, mo928());
            mo7758(false);
        }
        if (this.f7552 == null) {
            this.f7540.mo7859(Long.valueOf(mo7754()));
        }
        r5.mo8362();
        this.f7545.mo8071(Long.valueOf(mo7754()));
        if (this.f7543.mo8371()) {
            m7497();
        }
        if (this.f7567 != null) {
            this.f7567.m7779();
            this.f7567 = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ˋॱ */
    public boolean mo912() {
        return this.f7792 != null;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ͺ */
    public boolean mo923() {
        return this.f7562;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ˏॱ */
    public boolean mo922() {
        return true;
    }

    @Override // o.oM
    /* renamed from: ˋ */
    public void mo906(final Surface surface) {
        C1283.m16862(this.f7566, "setSurface begin.");
        final ConditionVariable conditionVariable = new ConditionVariable();
        m7462(this.f7542, new Runnable() { // from class: o.iM.19
            @Override // java.lang.Runnable
            public void run() {
                iM.this.m7473(surface);
                conditionVariable.open();
            }
        });
        if (!conditionVariable.block(1000)) {
            C1283.m16865(this.f7566, "setSurface does not complete within given timeout.");
        }
        C1283.m16862(this.f7566, "setSurface end.");
    }

    /* access modifiers changed from: private */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0030: APUT  
      (r2v3 java.lang.Object[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: java.lang.Boolean : 0x002b: INVOKE  (r3v9 java.lang.Boolean) = (r3v8 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0055: APUT  
      (r2v1 java.lang.Object[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: java.lang.Boolean : 0x0050: INVOKE  (r3v3 java.lang.Boolean) = (r3v2 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7473(Surface surface) {
        this.f7541 = surface;
        AbstractC1930ka r5 = m7489();
        if (r5 != null) {
            if (this.f7541 == null) {
                this.f7546.mo8614();
                this.f7791.mo641();
            }
            String str = this.f7566;
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.f7778);
            objArr[1] = Boolean.valueOf(surface != null);
            C1283.m16851(str, "doSetSurface %d hasSurface=%b", objArr);
            r5.mo8373(this.f7541);
            return;
        }
        String str2 = this.f7566;
        Object[] objArr2 = new Object[2];
        objArr2[0] = Long.valueOf(this.f7778);
        objArr2[1] = Boolean.valueOf(surface != null);
        C1283.m16851(str2, "doSetSurface no-session, ignoring %d hasSurface=%b", objArr2);
    }

    @Override // o.oM
    /* renamed from: ॱˎ */
    public long mo928() {
        return this.f7544;
    }

    @Override // o.oM
    /* renamed from: ॱ */
    public void mo926(final boolean z) {
        m7462(this.f7542, new Runnable() { // from class: o.iM.5
            @Override // java.lang.Runnable
            public void run() {
                AbstractC1930ka r1 = iM.this.m7489();
                if (r1 != null) {
                    r1.mo8364(z);
                }
            }
        });
    }

    @Override // o.oM
    /* renamed from: ˎ */
    public void mo915(final float f) {
        m7462(this.f7542, new Runnable() { // from class: o.iM.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC1930ka r1 = iM.this.m7489();
                if (r1 != null) {
                    r1.mo8368(f);
                }
            }
        });
    }

    @Override // o.oM
    /* renamed from: ʾ */
    public boolean mo892() {
        return this.f7559 && !this.f7560 && !m7488();
    }

    @Override // o.oM
    /* renamed from: ʿ */
    public AudioSource mo893() {
        return m7749(this.f7556);
    }

    @Override // o.oM
    /* renamed from: ˊ */
    public boolean mo901(AudioSource audioSource) {
        if (this.f7565) {
            return false;
        }
        final String id = audioSource.getId();
        m7462(this.f7542, new Runnable() { // from class: o.iM.2
            @Override // java.lang.Runnable
            public void run() {
                if (!C1349Bv.m4126(iM.this.f7556, id)) {
                    AbstractC1930ka r5 = iM.this.m7489();
                    if (r5 != null) {
                        r5.mo8367(id);
                        AudioSource r6 = iM.this.m7749(iM.this.f7556);
                        AudioSource r7 = iM.this.m7749(id);
                        if (!(r6 == null || r7 == null)) {
                            iM.this.f7546.mo8603(r6.getLanguageCodeIso639_1(), r6.getNumChannels(), r7.getLanguageCodeIso639_1(), r7.getNumChannels());
                        }
                    }
                    iM.this.f7556 = id;
                }
            }
        });
        return false;
    }

    @Override // o.oM
    /* renamed from: ˎ */
    public boolean mo918(final Subtitle subtitle, final boolean z) {
        if (this.f7565) {
            return false;
        }
        m7462(this.f7542, new Runnable() { // from class: o.iM.3
            @Override // java.lang.Runnable
            public void run() {
                Subtitle r5 = iM.this.f7548.m7518(subtitle, iM.this.mo928(), z);
                if (z && r5 != null) {
                    C1283.m16854(iM.this.f7566, "onUserSubtitle changed");
                    iM.this.m7464(false);
                    if (iM.this.m7488()) {
                        C1283.m16854(iM.this.f7566, "start subtitle buffering ...");
                        iM.this.mo931();
                        iM.this.f7572 = true;
                        iM.this.f7555.m7527(true);
                    }
                    iM.this.f7542.removeCallbacks(iM.this.f7568);
                    iM.this.f7563 = false;
                    if (iM.this.f7786.mo9712()) {
                        iM.this.m7466(iM.this.f7542, iM.this.f7568, 45000);
                    }
                }
                iM.this.f7554 = subtitle != null ? subtitle.getId() : null;
            }
        });
        return false;
    }

    @Override // o.oM
    /* renamed from: ʼॱ */
    public Subtitle[] mo890() {
        return this.f7550;
    }

    @Override // o.oM, o.AbstractC1977mh
    /* renamed from: ʽॱ */
    public Subtitle mo891() {
        if (this.f7550 == null) {
            return null;
        }
        Subtitle[] subtitleArr = this.f7550;
        for (Subtitle subtitle : subtitleArr) {
            if (C1349Bv.m4126(subtitle.getId(), this.f7554)) {
                return subtitle;
            }
        }
        return null;
    }

    @Override // o.oM
    /* renamed from: ॱ */
    public C1987mr mo924(long j) {
        if (this.f7548 != null) {
            return this.f7548.m7523(j);
        }
        return null;
    }

    @Override // o.oM
    /* renamed from: ˈ */
    public AudioSubtitleDefaultOrderInfo[] mo894() {
        return this.f7549;
    }

    @Override // o.oM
    /* renamed from: ˋ */
    public ByteBuffer mo905(long j) {
        if (j >= 2147483647L) {
            C1283.m16855(this.f7566, "%d ms is too big, BifManager won't handle.", Long.valueOf(j));
            return null;
        }
        iR r5 = this.f7567 != null ? this.f7567.m7781() : null;
        if (r5 != null) {
            return r5.mo7538((int) j);
        }
        return null;
    }

    /* renamed from: ᐨ  reason: contains not printable characters */
    private List<SubtitleTrackData> m7487() {
        return this.f7558;
    }

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private String m7485() {
        if (this.f7549 == null || this.f7549.length <= 0) {
            return null;
        }
        return this.f7549[0].getSubtitleTrackId();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7493(final int i, final int i2) {
        C1283.m16851(this.f7566, "StreamingPlaybackSession min: %d, max: %d", Integer.valueOf(i), Integer.valueOf(i2));
        m7462(this.f7542, new Runnable() { // from class: o.iM.8
            @Override // java.lang.Runnable
            public void run() {
                AbstractC1930ka r2 = iM.this.m7489();
                if (r2 != null) {
                    r2.mo8369(i, i2);
                }
            }
        });
    }

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private jM[] m7483() {
        return this.f7557;
    }

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private String m7484() {
        if (this.f7549 == null || this.f7549.length <= 0) {
            return null;
        }
        return this.f7549[0].getAudioTrackId();
    }

    @Override // o.jD.If
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo7495(jG jGVar) {
        AbstractC1930ka r4 = m7489();
        if (!this.f7565 && r4 != null) {
            this.f7546.mo8589("requestManifestEnd");
            this.f7552 = jGVar;
            if (this.f7552 instanceof jH) {
                try {
                    ((jH) this.f7552).m7939();
                } catch (JSONException e) {
                    m7467(StreamingPlaybackErrorCode.MANIFEST_CACHE_EXTRACT_ERROR, new NetflixStatus(StatusCode.MANIFEST_CACHE_EXTRACT_ERROR));
                    C1283.m16847(this.f7566, "failed to load Manifest %s", e);
                    return;
                }
            }
            m7492();
            if (this.f7791 != null) {
                this.f7791.mo645(this.f7552);
            }
            JSONObject r5 = jX.m7979(this.f7785, this.f7552, this.f7786);
            if (r5 != null) {
                r4.mo8370(r5);
                this.f7546.mo8606(r5, this.f7787);
            }
            this.f7546.mo8597(this.f7552.mo7908());
            this.f7546.mo8602(this.f7552.m7909());
            PlayerPrefetchSource r6 = this.f7552.m7911();
            if (r6 != null) {
                this.f7546.mo8587(this.f7552.m7914(), r6.name());
            }
            this.f7546.mo8585((long) this.f7781.getTrackId());
            this.f7549 = this.f7552.m7928();
            if (this.f7549 == null) {
                this.f7549 = new AudioSubtitleDefaultOrderInfo[0];
            }
            m7478();
            this.f7788 = this.f7552.m7907();
            if (this.f7788 == null) {
                this.f7788 = new AudioSource[0];
            }
            this.f7550 = this.f7552.m7932();
            if (this.f7550 == null) {
                this.f7550 = new Subtitle[0];
            }
            this.f7557 = this.f7552.m7936();
            this.f7558 = this.f7552.m7927(Long.parseLong(this.f7783));
            this.f7569 = this.f7552.m7930();
            m7486();
        }
    }

    @Override // o.jD.If
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo7506(Long l, Status status) {
        m7760();
        if (status.mo302() == StatusCode.MANIFEST_PREFETCH_PROCESSING_ERROR) {
            m7467(StreamingPlaybackErrorCode.MANIFEST_PROCESS_ERROR, status);
        } else {
            m7467(StreamingPlaybackErrorCode.MANIFEST_FETCH_ERROR, status);
        }
    }

    @Override // o.AbstractC1981ml
    /* renamed from: ˋˊ */
    public void mo910() {
        C1283.m16851(this.f7566, "onSubtitleLoaded %d mPlayerPlaying=%b", Long.valueOf(this.f7778), Boolean.valueOf(this.f7559));
        this.f7546.mo8589("subtitleLoaded");
        m7462(this.f7542, new Runnable() { // from class: o.iM.9
            @Override // java.lang.Runnable
            public void run() {
                if (iM.this.f7561 || iM.this.f7563) {
                    iM.this.f7542.removeCallbacks(iM.this.f7568);
                    return;
                }
                iM.this.m7464(true);
                iM.this.f7542.removeCallbacks(iM.this.f7568);
                if (iM.this.f7572) {
                    C1283.m16854(iM.this.f7566, "Subtitle loaded");
                    iM.this.mo927();
                    iM.this.f7572 = false;
                }
                if (iM.this.f7573) {
                    iM.this.m7491();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7464(boolean z) {
        C1283.m16851(this.f7566, "setSubtitleLoaded %b", Boolean.valueOf(z));
        this.f7561 = z;
    }

    @Override // o.AbstractC1981ml
    /* renamed from: ॱ */
    public void mo925(ISubtitleDef.SubtitleFailure subtitleFailure, Status status) {
        if (this.f7563) {
            this.f7542.removeCallbacks(this.f7568);
            return;
        }
        m7760();
        C1283.m16851(this.f7566, "onSubtitleError %s", subtitleFailure);
        this.f7563 = true;
        lX r4 = this.f7546.mo8581(subtitleFailure, status);
        if (r4 != null) {
            r4.m8714(this.f7785);
        }
        m7752(this.f7555, new C1934ke(r4));
    }

    @Override // o.AbstractC1981ml
    /* renamed from: ˋˋ */
    public void mo911() {
        m7462(this.f7542, new Runnable() { // from class: o.iM.6
            @Override // java.lang.Runnable
            public void run() {
                iM.this.m7464(false);
                C1283.m16854(iM.this.f7566, "subtitle stalled");
                if (iM.this.m7488()) {
                    C1283.m16854(iM.this.f7566, "start subtitle buffering ...");
                    iM.this.m7477();
                    iM.this.f7572 = true;
                    iM.this.f7555.m7527(true);
                }
                iM.this.f7542.removeCallbacks(iM.this.f7568);
                iM.this.m7466(iM.this.f7542, iM.this.f7568, 45000);
            }
        });
    }

    @Override // o.AbstractC1981ml
    /* renamed from: ˎ */
    public void mo916(long j) {
        C1283.m16851(this.f7566, "onSubtitleBufferingComplete %d mSubtitleLoaded=%b mSubtitleErrored=%b pts=%d", Long.valueOf(this.f7778), Boolean.valueOf(this.f7561), Boolean.valueOf(this.f7563), Long.valueOf(j));
        if (this.f7563) {
            this.f7542.removeCallbacks(this.f7568);
        } else {
            m7462(this.f7542, new Runnable() { // from class: o.iM.7
                @Override // java.lang.Runnable
                public void run() {
                    iM.this.m7464(true);
                    iM.this.f7542.removeCallbacks(iM.this.f7568);
                    if (!iM.this.f7560 && iM.this.f7572) {
                        iM.this.mo927();
                        iM.this.f7572 = false;
                    }
                    if (!iM.this.f7560 && iM.this.f7573) {
                        iM.this.m7491();
                    }
                }
            });
        }
    }

    /* renamed from: ᐧ  reason: contains not printable characters */
    private void m7486() {
        Point point = mo904().getPlaybackDisplaySpec().aspectRatioDimension;
        float f = ((float) point.x) / ((float) point.y);
        this.f7554 = m7485();
        this.f7548.m7520(m7487(), this.f7554, this.f7784, f);
    }

    @Override // o.jA.If
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo7499(Long l) {
        if (l.longValue() == mo7754() && !this.f7565) {
            m7462(this.f7542, new Runnable() { // from class: o.iM.10
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC1930ka r1 = iM.this.m7489();
                    if (r1 != null) {
                        r1.mo8360("DummyLicense");
                    }
                }
            });
        }
    }

    @Override // o.jA.If
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo7494(Status status) {
        m7760();
        if (this.f7551 == null || !m7459(this.f7551)) {
            m7467(StreamingPlaybackErrorCode.LICENSE_FETCH_ERROR, status);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7467(StreamingPlaybackErrorCode streamingPlaybackErrorCode, Status status) {
        this.f7546.mo8598(streamingPlaybackErrorCode, status);
        lX r5 = this.f7546.mo8580();
        if (r5 != null) {
            r5.m8714(this.f7785);
            if (streamingPlaybackErrorCode == StreamingPlaybackErrorCode.LICENSE_FETCH_ERROR && (status instanceof BladerunnerErrorStatus) && "CONCURRENT_STREAM_QUOTA_EXCEEDED_FAULT".equals(((BladerunnerErrorStatus) status).m968())) {
                m7752(this.f7555, new C1935kf(r5.m8711(), r5.m8713(), r5.m8710()));
                return;
            } else if (streamingPlaybackErrorCode == StreamingPlaybackErrorCode.MANIFEST_FETCH_ERROR && (status instanceof BladerunnerErrorStatus) && ((BladerunnerErrorStatus) status).m968().equals("ACCOUNT_ON_HOLD_FAULT")) {
                C1931kb kbVar = new C1931kb(r5.m8711(), r5.m8713(), r5.m8710());
                if (kbVar.m8375() != null) {
                    m7752(this.f7555, kbVar);
                    return;
                }
                C1276.m16820().mo5727("uma unavailable for account hold, falling back to blade runner error response based dialog");
            }
        }
        m7752(this.f7555, new C1934ke(r5));
    }

    @Override // o.oM
    /* renamed from: ˋ */
    public void mo909(boolean z) {
        if (this.f7783 == null) {
            C1276.m16820().mo5725("report subtitle visibility change while sessionId is null");
        } else {
            this.f7791.mo648(Long.valueOf(this.f7783).longValue(), z);
        }
    }

    @Override // o.AbstractC1628ct
    /* renamed from: ˎ */
    public long mo5965() {
        return mo928();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1891is
    /* renamed from: ᐝ */
    public IPlayer.aux mo930() {
        return new C1934ke(StreamingPlaybackErrorCode.RESTART_APP_SESSION_ERROR, false);
    }

    @Override // o.AbstractC1894iv
    public void F_() {
        C1283.m16863(this.f7566, "playerPrepared %d", Long.valueOf(mo7754()));
        this.f7547.mo7766(mo902());
        this.f7562 = true;
        if (!m7488()) {
            mo927();
        } else {
            this.f7572 = true;
        }
        m7743();
        this.f7555.m7530(this);
    }

    @Override // o.AbstractC1894iv
    public void G_() {
        C1283.m16863(this.f7566, "playerPaused %d", Long.valueOf(mo7754()));
        this.f7559 = false;
        this.f7791.mo647(mo928());
        this.f7546.mo8582();
    }

    @Override // o.AbstractC1894iv
    /* renamed from: ˊ */
    public void mo900(boolean z) {
        C1283.m16863(this.f7566, "playerBuffering %d", Long.valueOf(mo7754()));
        this.f7560 = true;
        this.f7555.m7527(z);
    }

    @Override // o.AbstractC1894iv
    public void H_() {
        C1283.m16863(this.f7566, "playerStarted %d mSubtitleLoaded=%b", Long.valueOf(mo7754()), Boolean.valueOf(this.f7561));
        m7761();
        this.f7559 = true;
        if (!m7488()) {
            m7491();
        } else {
            this.f7573 = true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ꜞ  reason: contains not printable characters */
    private void m7491() {
        C1283.m16862(this.f7566, "notify playerStarted");
        this.f7573 = false;
        this.f7791.mo637(mo5965());
        this.f7555.m7528();
        if (this.f7567 == null) {
            this.f7567 = new C1895iw(this.f7542, this.f7546);
            this.f7567.m7780(this.f7785, this.f7776, m7483());
        }
    }

    @Override // o.AbstractC1894iv
    public void I_() {
        C1283.m16863(this.f7566, "playerStopped %d", Long.valueOf(mo7754()));
        this.f7559 = false;
        this.f7564 = true;
        this.f7555.m7532();
        this.f7791.mo638(mo5965());
    }

    @Override // o.AbstractC1933kd
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7502(long j, AbstractC1933kd.iF iFVar) {
        this.f7546.mo8600(j, iFVar);
    }

    @Override // o.AbstractC1933kd
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo7496(String str) {
        this.f7546.mo8589(str);
    }

    @Override // o.AbstractC1894iv
    /* renamed from: ˋ */
    public void mo908(IPlayer.aux aux) {
        m7760();
        this.f7791.mo638(mo5965());
        lX r3 = this.f7546.mo8580();
        if (r3 != null) {
            r3.m8714(this.f7785);
        }
        m7752(this.f7555, new C1934ke(r3));
    }

    @Override // o.AbstractC1894iv
    public void J_() {
        C1283.m16863(this.f7566, "playerBufferingComplete %d", Long.valueOf(this.f7778));
        this.f7560 = false;
        if (m7488()) {
            mo931();
            this.f7572 = true;
            m7466(this.f7542, this.f7568, 15000);
        }
    }

    @Override // o.AbstractC1933kd
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7503(AbstractC0542 r4) {
        this.f7791.mo640(Long.valueOf(this.f7783).longValue(), r4);
    }

    @Override // o.AbstractC1933kd
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo7498(int i) {
        this.f7544 = (long) i;
        this.f7555.m7533(i, this.f7548.m7523((long) i));
        this.f7791.mo642(mo5965());
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    public void m7497() {
        this.f7559 = false;
        m7490();
        this.f7562 = false;
        this.f7561 = false;
        this.f7563 = false;
        if (this.f7543 != null) {
            this.f7543.mo8359();
        }
        this.f7543 = null;
        if (this.f7551 != null) {
            this.f7551.m7839();
        }
        if (this.f7791 != null) {
            this.f7791.mo644(mo928());
        }
        this.f7546.mo8604(this.f7564 ? "ended" : "stopped", mo928(), "");
        if (this.f7552 != null && (this.f7552 instanceof jH)) {
            ((jH) this.f7552).m7937();
        }
        this.f7542.removeCallbacks(this.f7568);
        AbstractC1891is.AbstractC0128 r5 = this.f7792;
        this.f7792 = null;
        m7760();
        if (r5 != null) {
            C1283.m16862(this.f7566, "notifying close done");
            r5.mo933();
        }
    }

    @Override // o.oM
    /* renamed from: ˉ */
    public Watermark mo895() {
        if (this.f7552 != null) {
            return this.f7552.m7918();
        }
        return null;
    }

    @Override // o.oM
    /* renamed from: ˊᐝ */
    public PlayerManifestData mo904() {
        return this.f7569;
    }

    @Override // o.oM
    /* renamed from: ˊˋ */
    public void mo903() {
        if (this.f7546 != null) {
            this.f7546.mo8591();
        }
    }

    @Override // o.oM
    /* renamed from: ˋᐝ */
    public ISubtitleDef.SubtitleProfile mo913() {
        return this.f7548.m7524();
    }

    @Override // o.oM
    /* renamed from: ˌ */
    public IPlayer.PlaybackType mo914() {
        return IPlayer.PlaybackType.StreamingPlayback;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m7459(jA jAVar) {
        Exception r3 = jAVar.m7832();
        if (r3 == null) {
            return false;
        }
        C1283.m16856(this.f7566, r3, "drm session has exception", new Object[0]);
        m7752(this.f7555, new C1934ke(this.f7546.mo8609(r3.toString())));
        return true;
    }

    /* renamed from: ꜟ  reason: contains not printable characters */
    private void m7492() {
        if (this.f7571 > 0) {
            C1283.m16851(this.f7566, "Disabling streams over %d resolution.", Integer.valueOf(this.f7571));
            this.f7552.m7917(this.f7571);
        }
    }

    /* renamed from: ꓸ  reason: contains not printable characters */
    private void m7490() {
        if (this.f7551 != null) {
            this.f7551.m7829();
        } else {
            C1283.m16854(this.f7566, "ignore sending releaseLicense, drm session null");
        }
    }

    /* access modifiers changed from: package-private */
    public class If implements Runnable {
        private If() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!iM.this.f7561) {
                C1283.m16854(iM.this.f7566, "timeout in subtitle loading");
                iM.this.mo925(ISubtitleDef.SubtitleFailure.timedOut, (Status) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᶥ  reason: contains not printable characters */
    private boolean m7488() {
        return this.f7786.mo9712() && !this.f7561;
    }

    @Override // o.oM
    /* renamed from: ˊˊ */
    public StreamProfileType mo902() {
        return this.f7552 != null ? this.f7552.m7926() : StreamProfileType.CE3;
    }

    @Override // o.oM
    /* renamed from: ˊ */
    public void mo898(oM.AbstractC0160 r2) {
        this.f7555.m7534(r2);
    }

    @Override // o.oM
    /* renamed from: ˏ */
    public void mo921(oM.AbstractC0160 r2) {
        this.f7555.m7529(r2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ㆍ  reason: contains not printable characters */
    private AbstractC1930ka m7489() {
        return this.f7543;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏˏ  reason: contains not printable characters */
    public void m7505() {
        AbstractC1891is.f7775 = this;
    }

    @Override // o.oM
    public void K_() {
        if (this.f7546 != null) {
            this.f7546.mo8592(mo928());
        }
    }

    @Override // o.oM
    /* renamed from: ˋ */
    public void mo907(ExitPipAction exitPipAction) {
        if (this.f7546 != null) {
            this.f7546.mo8612(exitPipAction, mo928());
        }
    }
}
