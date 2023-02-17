package o;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Pair;
import com.netflix.mediaclient.android.app.NetflixImmutableStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.mdx.logging.MdxErrorCode;
import com.netflix.mediaclient.service.mdx.logging.connection.MdxConnectionLogblobLogger;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.IMdxSharedState;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import o.BJ;
import o.C1695eH;
import o.C1696eI;
import o.C1703eP;
import o.C1707eT;
import o.oT;
/* renamed from: o.eK  reason: case insensitive filesystem */
public class C1698eK extends AbstractC1052 implements oG, AbstractC1712eY, AbstractC1284, C1707eT.iF, C1703eP.If, C1696eI.If, C1695eH.AbstractC0108 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private BJ.C0067 f6485 = new BJ.C0067();

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private HandlerThread f6486;

    /* renamed from: ʼ  reason: contains not printable characters */
    private iQ f6487;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private C1710eW f6488;

    /* renamed from: ʽ  reason: contains not printable characters */
    private BJ.C0067 f6489 = new BJ.C0067();

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private C1696eI f6490;

    /* renamed from: ʾ  reason: contains not printable characters */
    private C1703eP f6491;

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f6492 = false;

    /* renamed from: ˈ  reason: contains not printable characters */
    private C1695eH f6493;

    /* renamed from: ˉ  reason: contains not printable characters */
    private C1701eN f6494;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1693eF f6495;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private final Object f6496 = new Object();

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private int f6497;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f6498;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private C1694eG f6499;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6500;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private C1767fa f6501;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private final BroadcastReceiver f6502 = new BroadcastReceiver() { // from class: o.eK.7
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1697eJ r4;
            if (!intent.hasCategory("com.netflix.mediaclient.intent.category.MDX")) {
                return;
            }
            if (intent.getAction().equals("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKEND")) {
                m6197(intent);
            } else if (intent.getAction().equals("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKSTART")) {
                m6198();
            } else if ("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_STATE".equals(intent.getAction())) {
                if (C1698eK.this.mo6191() != null && C1698eK.this.mo6191().mo1522() == IMdxSharedState.MdxPlaybackState.Transitioning) {
                    C1698eK.this.m6156();
                    if (C1698eK.this.f6513.mo6406()) {
                        C1698eK.this.f6513.mo6396(C1698eK.this.m16096());
                    }
                }
                if (C1317As.m3758() >= 21 && C1698eK.this.f6494 != null) {
                    C1698eK.this.f6494.m6241(intent.getIntExtra("volume", 0), false);
                }
            } else if ("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_POSTPLAY".equals(intent.getAction())) {
                m6192(intent);
            } else if (intent.getAction().equals("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_SIMPLE_PLAYBACKSTATE")) {
                m6195(intent);
            } else if (intent.getAction().equals("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_ERROR")) {
                int intExtra = intent.getIntExtra("errorCode", 0);
                C1698eK.this.m6182();
                if (!(null == C1698eK.this.f6495 || null == (r4 = C1698eK.this.f6495.m6067(C1698eK.this.f6500)))) {
                    boolean z = false;
                    if (IMdxSharedState.MdxPlaybackState.Loading == r4.mo1522() || IMdxSharedState.MdxPlaybackState.Transitioning == r4.mo1522()) {
                        z = true;
                    }
                    if (intExtra >= 100 && intExtra < 200 && z) {
                        C1283.m16854("MdxAgent", "MdxAgent: received error, clear video detail");
                        C1698eK.this.m6162();
                    }
                }
                if ((intExtra >= 100 && intExtra < 200) || intExtra == 201) {
                    C1698eK.this.m6153();
                }
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private void m6195(Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("paused", false);
            boolean booleanExtra2 = intent.getBooleanExtra("transitioning", false);
            boolean r4 = C1698eK.m6134(intent);
            boolean booleanExtra3 = intent.getBooleanExtra("isInSkipIntroWindow", false);
            String stringExtra = intent.getStringExtra("skipIntroText");
            C1698eK.this.m6156();
            if (C1698eK.this.f6494 != null) {
                C1698eK.this.f6494.m6245(booleanExtra, r4);
            }
            C1698eK.this.f6513.mo6400(booleanExtra, booleanExtra2, booleanExtra3, stringExtra);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m6192(Intent intent) {
            String string = intent.getExtras().getString("postplayState");
            if (!C1349Bv.m4113(string)) {
                oT oTVar = new oT(string);
                if (oTVar.m9581()) {
                    m6193(intent, string);
                } else if (oTVar.m9580()) {
                    m6196(intent, string);
                }
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m6193(Intent intent, String str) {
            C1698eK.this.m6156();
            m6194(str);
            if (C1698eK.this.f6494 != null) {
                C1698eK.this.f6494.m6245(false, true);
            }
            C1698eK.this.f6513.mo6402((Notification) C1698eK.this.m6128(true).second, C1698eK.this.m16096(), true);
            C1698eK.this.f6513.mo6399(false, false, true);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m6196(Intent intent, String str) {
            BJ.C0067 r5 = C1698eK.this.mo6172();
            if (r5 != null) {
                C1698eK.this.m16095().mo7821(String.valueOf(r5.f4578), r5.m3868(), PlayLocationType.MDX, new AbstractC1222() { // from class: o.eK.7.2
                    @Override // o.AbstractC1222, o.AbstractC1203
                    /* renamed from: ˏ  reason: contains not printable characters */
                    public void mo6199(pO pOVar, Status status) {
                        List<pN> postPlayVideos;
                        if (status.mo298() && pOVar != null && (postPlayVideos = pOVar.getPostPlayVideos()) != null && postPlayVideos.size() > 0) {
                            String id = postPlayVideos.get(0).getId();
                            if (!TextUtils.isEmpty(id)) {
                                C1698eK.this.m6146(id);
                            }
                        }
                    }
                });
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private void m6198() {
            C1283.m16854("MdxAgent", "MdxAgent: receive MDX_ACTION_UPDATE_PLAYBACKSTART");
            C1698eK.this.f6493.m6078();
            C1698eK.this.m6159();
            C1698eK.this.m6156();
            if (C1698eK.this.f6494 != null) {
                C1698eK.this.f6494.m6244();
            }
            C1698eK.this.f6513.mo6402((Notification) C1698eK.this.m6128(false).second, C1698eK.this.m16096(), false);
            C1698eK.this.f6513.mo6400(false, false, false, "");
            C1698eK.this.f6513.mo6398(C1698eK.this.f6511);
            if (null != C1698eK.this.f6517) {
                C1698eK.this.f6517.m6269(C1698eK.this.f6500);
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m6197(Intent intent) {
            if (!C1698eK.m6134(intent)) {
                C1283.m16854("MdxAgent", "MdxAgent: receive MDX_ACTION_UPDATE_PLAYBACKEND");
                C1698eK.this.f6493.m6077();
                C1698eK.this.m6162();
                C1698eK.this.m6182();
                C1698eK.this.m6161();
                if (null != C1698eK.this.f6517) {
                    C1698eK.this.f6517.m6270(C1698eK.this.f6500);
                }
                if (null != C1698eK.this.f6491) {
                    C1698eK.this.f6491.m6250(C1698eK.this.f6500);
                }
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m6194(String str) {
            oT oTVar = new oT(str);
            if (oTVar.m9581()) {
                oT.C0162[] r4 = oTVar.m9582();
                if (r4.length > 0 && r4[0].m9584() && r4[0].m9583() != null) {
                    C1698eK.this.f6485 = new BJ.C0067();
                    C1698eK.this.f6485.f4577 = true;
                    C1698eK.this.f6485.f4578 = r4[0].m9583();
                    C1698eK.this.m6113(false, true);
                }
            }
        }
    };

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f6503;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private final BroadcastReceiver f6504 = new BroadcastReceiver() { // from class: o.eK.6
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1283.m16846("MdxAgent", "Null intent");
            } else if (!C1698eK.this.r_()) {
                C1283.m16854("MdxAgent", "mUserAgentReceiver MdxAgent not ready, ignoring");
            } else {
                String action = intent.getAction();
                if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_ACTIVE".equals(action)) {
                    C1283.m16854("MdxAgent", "useprofile is active");
                    C1698eK.this.m6124(true);
                } else if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_DEACTIVE".equals(action)) {
                    C1283.m16854("MdxAgent", "useprofile is not active");
                    C1698eK.this.m6124(false);
                } else if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_ACTIVE".equals(action)) {
                    C1698eK.this.m6151();
                    C1283.m16854("MdxAgent", "user account is activated");
                } else if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE".equals(action)) {
                    C1698eK.this.m6155();
                    C1283.m16854("MdxAgent", "user account is deactivated");
                }
            }
        }
    };

    /* renamed from: ˌ  reason: contains not printable characters */
    private AbstractC1221 f6505;

    /* renamed from: ˍ  reason: contains not printable characters */
    private int f6506;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1692eE f6507;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private C1713eZ f6508;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1699eL f6509;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f6510;

    /* renamed from: ͺ  reason: contains not printable characters */
    private Bitmap f6511;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AtomicBoolean f6512;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private AbstractC1778fk f6513;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private PowerManager.WakeLock f6514;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final Handler f6515;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private pT f6516;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C1707eT f6517;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private pT f6518;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private WifiManager.WifiLock f6519;

    public C1698eK(AbstractC1221 r3) {
        C1283.m16854("MdxAgent", "MdxAgent: start");
        this.f6512 = new AtomicBoolean(false);
        this.f6500 = "";
        this.f6505 = r3;
        this.f6486 = new HandlerThread("MdxAgentWorker");
        this.f6486.start();
        this.f6515 = new Handler(this.f6486.getLooper());
    }

    @Override // o.oG
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public boolean mo6167() {
        return false;
    }

    @Override // o.oG
    /* renamed from: ˉ  reason: contains not printable characters */
    public Pair<String, String>[] mo6163() {
        if (this.f6509 != null) {
            return this.f6509.m6219();
        }
        return null;
    }

    @Override // o.oG
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6180(String str) {
        final boolean z = !C1349Bv.m4126(str, this.f6500);
        final String str2 = this.f6500;
        this.f6500 = str;
        if (C1349Bv.m4113(this.f6500)) {
            m6162();
        }
        this.f6515.post(new Runnable() { // from class: o.eK.3
            @Override // java.lang.Runnable
            public void run() {
                if (z && C1349Bv.m4107(str2)) {
                    C1698eK.this.f6509.m6223(str2);
                }
                if (null != C1698eK.this.f6517) {
                    C1698eK.this.f6517.m6268(C1698eK.this.f6500);
                }
                C1698eK.this.f6509.m6216(C1698eK.this.f6500, true);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐨ  reason: contains not printable characters */
    private void m6153() {
        C1283.m16850("MdxAgent", "MdxAgent: resetTargetSelection");
        this.f6500 = "";
        if (null != this.f6517) {
            this.f6517.m6268(this.f6500);
        }
        m6162();
    }

    @Override // o.oG
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo6177(String str) {
        if (!C1349Bv.m4107(str)) {
            return false;
        }
        if (str.equals(this.f6500)) {
            return true;
        }
        mo6180(str);
        return true;
    }

    @Override // o.oG
    /* renamed from: ˋˋ  reason: contains not printable characters */
    public String mo6171() {
        return this.f6500;
    }

    @Override // o.oG
    /* renamed from: ˌ  reason: contains not printable characters */
    public C1702eO mo6173() {
        return this.f6509.m6226(this.f6500);
    }

    @Override // o.oG
    /* renamed from: ˋᐝ  reason: contains not printable characters */
    public BJ.C0067 mo6172() {
        return this.f6509.m6224(this.f6500);
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    public BJ.C0067 m6174() {
        return this.f6485;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        C1283.m16850("MdxAgent", "MdxAgent: doInit");
        if (m16101() == null) {
            C1283.m16850("MdxAgent", "config agent null at mdx doInit");
            m16090(AbstractC0367.f13240);
        } else if (m16086() == null || m16086().mo1512() == null) {
            C1283.m16850("MdxAgent", "logging agent null at mdx doInit");
            m16090(AbstractC0367.f13240);
        } else {
            this.f6501 = new C1767fa(m16086().mo1512(), m16101());
            m6160();
            m6154();
            this.f6495 = new C1693eF(m16093());
            this.f6509 = new C1699eL(this.f6495, m16101().d_().mo14449(), this.f6486.getLooper(), s_(), this.f6501);
            this.f6507 = new C1692eE(this.f6509);
            this.f6491 = new C1703eP(this.f6509, this);
            this.f6508 = new C1713eZ(this.f6486.getLooper(), C0668.d_(m16093()), AbstractApplicationC1258.getInstance().mo234(), this.f6509);
            AbstractC1823gi.m6664(m16101().d_().mo14449());
            if (null == this.f6495 || null == this.f6509 || null == this.f6507) {
                NetflixImmutableStatus netflixImmutableStatus = AbstractC0367.f13241;
                m16090(netflixImmutableStatus);
                this.f6501.m6373().m698(MdxErrorCode.MdxInitFailed, (String) null, String.valueOf(netflixImmutableStatus.mo302().m271()), "MdxAgent notifier, target manager or command handler null", (String) null);
                return;
            }
            if (!m16101().mo16515().mo13896()) {
                this.f6492 = m16101().mo16515().mo13901();
                this.f6509.m6218(m16093(), m16087(), this.f6492, this.f6505.mo16515().mo13894(), this.f6501);
            } else {
                C1283.m16854("MdxAgent", "legacy Netflix MDX is disabled.");
            }
            m6149();
            this.f6515.post(new Runnable() { // from class: o.eK.4
                @Override // java.lang.Runnable
                public void run() {
                    C1698eK.this.f6517 = new C1707eT(C1698eK.this.m16093(), C1698eK.this);
                }
            });
            this.f6490 = new C1696eI(m16093(), u_(), this, this.f6515);
            this.f6493 = new C1695eH(this, this.f6515);
            this.f6494 = new C1701eN(this, m16101().mo16515());
            m6151();
            this.f6495.m6053();
            mo5196();
            m16090(AbstractC0367.f13235);
            this.f6501.m6373().m697();
            C1283.m16850("MdxAgent", "MdxAgent: doInit done.");
        }
    }

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private void m6149() {
        if (!m6152()) {
            C1283.m16862("MdxAgent", "cast not enabled.");
        } else if (C0893.m15613()) {
            this.f6509.m6217(m16093(), m16087(), this.f6501, m16101().d_().mo14449());
        } else if (this.f6488 == null) {
            C1283.m16862("MdxAgent", "enabling cast");
            this.f6488 = new C1710eW(m16093(), s_(), this.f6515, m16101().d_().mo14449(), this.f6501);
            this.f6488.m6328(m16101().mo16515().mo13898());
            this.f6509.m6215(m16093(), this.f6488, m16087(), this.f6501);
        }
    }

    /* renamed from: ᐧ  reason: contains not printable characters */
    private boolean m6152() {
        return m16101() != null && m16101().mo16515().mo13897();
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        this.f6486.quit();
        try {
            this.f6486.join();
        } catch (InterruptedException e) {
            C1283.m16850("MdxAgent", "MdxAgent: mMdxAgentWorkerThread interrupted");
        }
        this.f6486 = null;
        m6094();
        if (null != this.f6487) {
            this.f6487.mo7539();
            this.f6487 = null;
        }
        if (this.f6494 != null) {
            this.f6494.m6246();
        }
        if (this.f6509 != null) {
            this.f6509.m6211();
        }
        if (null != this.f6488) {
            this.f6488.m6314();
        }
        m6158();
        super.mo1236();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m6166(Intent intent) {
        if (C1349Bv.m4107(this.f6500) && !this.f6509.m6227(this.f6500)) {
            this.f6509.m6216(this.f6500, true);
        }
        C1283.m16863("MdxAgent", "handleCommand %s", intent.getAction());
        if (intent.hasCategory("com.netflix.mediaclient.intent.category.MDX") && "com.netflix.mediaclient.intent.action.MDX_ACTION_PLAY_VIDEOIDS".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("uuid");
            if (C1349Bv.m4113(stringExtra) || !stringExtra.equals(this.f6500)) {
                C1283.m16850("MdxAgent", "MdxAgent: MDX_ACTION_PLAY_VIDEOIDS is for uuid: " + stringExtra + "vs. " + this.f6500);
                return true;
            }
            String stringExtra2 = intent.getStringExtra("catalogId");
            if (stringExtra2 == null || C1349Bv.m4103(stringExtra2)) {
                String stringExtra3 = intent.getStringExtra("episodeId");
                if (stringExtra3 == null || C1349Bv.m4103(stringExtra3)) {
                    int intExtra = intent.getIntExtra("trackId", -1);
                    if (intExtra == -1) {
                        C1283.m16865("MdxAgent", "MdxAgent: MDX_ACTION_PLAY_VIDEOIDS has invalid trackId");
                        intExtra = 13804431;
                    }
                    int intExtra2 = intent.getIntExtra("time", -1);
                    this.f6510 = intExtra;
                    this.f6498 = intExtra2;
                    boolean z = stringExtra3 != null;
                    this.f6503 = intent.getBooleanExtra("previewPinProtected", false);
                    if (intent.getBooleanExtra("playNext", false)) {
                        m6182();
                    }
                    if (this.f6489.f4577 != z || !C1349Bv.m4126(this.f6489.f4579, stringExtra2) || (z && !C1349Bv.m4126(this.f6489.f4578, stringExtra3))) {
                        this.f6495.m6059(this.f6500);
                        this.f6489.f4577 = z;
                        this.f6489.f4579 = stringExtra2;
                        this.f6489.f4578 = stringExtra3;
                        if (this.f6487 != null) {
                            this.f6487.mo7539();
                            this.f6487 = null;
                        }
                        m6113(true, "com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_POSTPLAY".equals(intent.getAction()));
                        return true;
                    }
                    C1283.m16854("MdxAgent", "MdxAgent: videoIds are same, start play");
                    this.f6509.mo6043(this.f6500, this.f6489.f4576, this.f6510, this.f6489.f4580, this.f6498, this.f6503);
                    this.f6495.m6063(this.f6500);
                    return true;
                }
                C1283.m16850("MdxAgent", "Unable to parse episodeId from intent.");
                return false;
            }
            C1283.m16850("MdxAgent", "Unable to parse catalogID from intent.");
            return false;
        } else if ("com.netflix.mediaclient.intent.action.MDX_ACTION_SELECT_TARGET".equals(intent.getAction())) {
            String stringExtra4 = intent.getStringExtra("uuid");
            C1283.m16854("MdxAgent", "MdxAgent: select target " + stringExtra4);
            mo6180(stringExtra4);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.MDX_CS_CAST_DISCOVERY_ISSUE".equals(intent.getAction())) {
            Pair<String, String>[] r7 = mo6163();
            boolean z2 = false;
            if (r7 != null && this.f6500 != null) {
                int length = r7.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (this.f6500.equals(r7[i].first)) {
                        z2 = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.f6501.m6363("csPage targetListCount=" + (r7 != null ? r7.length : -1) + " mCurrentTargetUuid=" + this.f6500 + " targetFound=" + z2);
            m6148();
            return true;
        } else {
            if (intent.hasCategory("com.netflix.mediaclient.intent.category.MDXRCC")) {
                C1283.m16854("MdxAgent", "MdxAgent: get nf_mdx_RemoteControlClient intent");
                intent.putExtra("uuid", this.f6500);
                if ("com.netflix.mediaclient.intent.action.MDX_ACTION__TOGGLE_PAUSE".equals(intent.getAction())) {
                    C1283.m16854("MdxAgent", "MdxAgent: get nf_mdx_RemoteControlClient intent toggle pause");
                }
            }
            if ("com.netflix.mediaclient.intent.action.MDX_ACTION_STOP".equals(intent.getAction())) {
                m6182();
                LocalBroadcastManager.getInstance(m16093()).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_TITLE_END"));
            } else if ("com.netflix.mediaclient.intent.action.MDX_ACTION_SETVOLUME".equals(intent.getAction())) {
                m6111(m16093(), intent.getIntExtra("volume", -1));
            }
            this.f6507.m6051(intent);
            return true;
        }
    }

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private void m6148() {
        if (m6152() && this.f6488 != null) {
            this.f6488.m6326();
            this.f6488.m6317();
            s_().postDelayed(new Runnable() { // from class: o.eK.1
                @Override // java.lang.Runnable
                public void run() {
                    if (C1698eK.this.f6488 != null) {
                        C1698eK.this.f6488.m6320();
                    }
                }
            }, 2000);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6111(Context context, int i) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_SETVOLUME");
        intent.putExtra("volume", i);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    public boolean m6178() {
        return null != this.f6509 && this.f6509.m6210(this.f6500);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private Pair<Integer, Notification> m6128(boolean z) {
        BJ.C0067 r4 = this.f6509.m6224(this.f6500);
        m6156();
        if (null == r4) {
            C1283.m16854("MdxAgent", "MdxAgent: new videoIds is null");
        } else if (r4.f4577 != this.f6489.f4577 || ((r4.f4577 && r4.f4578 != this.f6489.f4578) || !C1349Bv.m4126(r4.f4579, this.f6489.f4579))) {
            this.f6489 = r4;
            m6113(false, z);
            return this.f6513.mo6401(z);
        } else {
            C1283.m16854("MdxAgent", "MdxAgent: videoIds are all same");
            this.f6495.m6063(this.f6500);
            if (null != this.f6511) {
                this.f6513.mo6403(this.f6511);
            }
            if (null != this.f6518 && !this.f6489.f4577) {
                this.f6513.mo6405(false, this.f6518.getTitle(), (String) null);
            }
        }
        return this.f6513.mo6401(z);
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    public void m6184() {
        if (m6157() && this.f6509 != null) {
            C1283.m16854("MdxAgent", "MdxAgent: UI coming to foreground, try restart discovery");
            this.f6509.m6206();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m6124(boolean z) {
        if (!r_()) {
            C1283.m16854("MdxAgent", "notifyUserProfileActivation MdxAgent not ready, ignoring");
        }
        if (z) {
            C1283.m16854("MdxAgent", "MdxAgent: user login");
            return;
        }
        C1283.m16854("MdxAgent", "MdxAgent: user logout");
        mo6180((String) null);
        if (this.f6488 != null) {
            this.f6488.m6317();
        }
        m6162();
        m6133(true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private void m6151() {
        if (!m6157()) {
            C1283.m16862("MdxAgent", "startMdx profile is not active");
            return;
        }
        m6149();
        this.f6515.post(new Runnable() { // from class: o.eK.2
            @Override // java.lang.Runnable
            public void run() {
                if (C1698eK.this.f6512.compareAndSet(false, true)) {
                    C1283.m16862("MdxAgent", "startMdx starting the mdx");
                    C1698eK.this.f6501.m6366();
                    C1698eK.this.f6509.m6222();
                    C1698eK.this.f6508.m6339();
                    return;
                }
                C1283.m16862("MdxAgent", "startMdx already started");
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ㆍ  reason: contains not printable characters */
    private void m6155() {
        this.f6515.post(new Runnable() { // from class: o.eK.5
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16862("MdxAgent", "onAccountDeactivate stopping the mdx");
                C1698eK.this.f6501.m6370();
                C1698eK.this.f6512.set(false);
                C1698eK.this.f6509.m6214();
                C1698eK.this.f6508.m6338();
                C1698eK.this.m6153();
            }
        });
    }

    /* renamed from: ꜞ  reason: contains not printable characters */
    private boolean m6157() {
        UserAgentInterface r2 = m16085();
        return null != m16085() && C1349Bv.m4107(r2.mo1340()) && r2.mo1333();
    }

    @Override // o.oG
    /* renamed from: ˋ  reason: contains not printable characters */
    public ByteBuffer mo6169(int i) {
        if (null != this.f6487) {
            return this.f6487.mo7538(i);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private void m6099(String str) {
        if (null != this.f6487) {
            this.f6487.mo7539();
        }
        this.f6487 = new iR(m16093(), u_(), str);
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    public void m6182() {
        C1283.m16862("MdxAgent", "Stop all notifications");
        m6156();
        if (this.f6494 != null) {
            this.f6494.m6248();
        }
        this.f6513.mo6404(m16096());
        this.f6513.mo6397();
        this.f6513 = null;
        this.f6511 = null;
        IMdxSharedState r2 = mo6191();
        if (r2 instanceof C1697eJ) {
            ((C1697eJ) r2).m6088();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ꓸ  reason: contains not printable characters */
    private void m6156() {
        if (null == this.f6513) {
            this.f6513 = ((AbstractC2097qq) C1281.m16832(AbstractC2097qq.class)).mo10111(m16093(), true, this, this.f6494, m16101().mo16515());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m6134(Intent intent) {
        if (!intent.hasExtra("postplayState")) {
            return false;
        }
        String string = intent.getExtras().getString("postplayState");
        if (C1349Bv.m4113(string)) {
            return false;
        }
        oT oTVar = new oT(string);
        return oTVar.m9581() || oTVar.m9580();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m6146(String str) {
        if (C1349Bv.m4107(str)) {
            this.f6485 = new BJ.C0067();
            this.f6485.f4577 = true;
            this.f6485.f4578 = str;
            m6156();
            m6113(false, true);
            if (this.f6494 != null) {
                this.f6494.m6245(false, true);
            }
            this.f6513.mo6402((Notification) m6128(true).second, m16096(), true);
            this.f6513.mo6399(false, false, true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.eK$If */
    public class If extends AbstractC1222 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final boolean f6532;

        If(boolean z) {
            this.f6532 = z;
        }

        @Override // o.AbstractC1222, o.AbstractC1203
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo6200(pP pPVar, Status status) {
            if (status.mo298()) {
                C1698eK.this.f6518 = pPVar;
                String highResolutionPortraitBoxArtUrl = pPVar.getHighResolutionPortraitBoxArtUrl();
                if (null != C1698eK.this.f6490) {
                    C1698eK.this.f6490.m6085(highResolutionPortraitBoxArtUrl);
                }
                String bifUrl = pPVar.getBifUrl();
                if (C1349Bv.m4107(bifUrl)) {
                    C1698eK.this.m6099(bifUrl);
                }
                C1698eK.this.f6495.m6063(C1698eK.this.f6500);
                if (this.f6532) {
                    C1698eK.this.f6489 = new BJ.C0067(pPVar.getPlayable().isPlayableEpisode(), null, pPVar.getCatalogIdUrl(), null, pPVar.getId());
                    C1698eK.this.f6509.mo6043(C1698eK.this.f6500, C1698eK.this.f6489.f4576, C1698eK.this.f6510, C1698eK.this.f6489.f4580, C1698eK.this.f6498, C1698eK.this.f6503);
                }
                C1698eK.this.m6125(false, C1698eK.this.f6518.getTitle(), null, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.eK$if  reason: invalid class name */
    public class Cif extends AbstractC1222 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final boolean f6535;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final boolean f6536;

        /* renamed from: ˏ  reason: contains not printable characters */
        pT f6537;

        /* renamed from: ॱ  reason: contains not printable characters */
        BJ.C0067 f6538;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final String f6539;

        Cif(boolean z, boolean z2, String str) {
            this.f6536 = z;
            this.f6535 = z2;
            this.f6539 = str;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m6201(BJ.C0067 r2) {
            this.f6538 = r2;
            if (this.f6535) {
                C1698eK.this.f6485 = r2;
            } else {
                C1698eK.this.f6489 = r2;
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private void m6202(pT pTVar) {
            this.f6537 = pTVar;
            if (!this.f6535) {
                C1698eK.this.f6518 = pTVar;
            } else {
                C1698eK.this.f6516 = pTVar;
            }
        }

        @Override // o.AbstractC1222, o.AbstractC1203
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo6203(pI pIVar, Status status) {
            if (!status.mo301()) {
                if (pIVar == null || pIVar.getId() == null) {
                    C1698eK.this.m16086().mo1515().mo5714("SPY-7909: SPY-12099 FetchEpisode got bad id: " + this.f6539 + " episodeDetailsNull=" + (pIVar == null) + " getId()= " + (pIVar != null ? pIVar.getId() : null));
                    return;
                }
                m6202(pIVar);
                String highResolutionPortraitBoxArtUrl = pIVar.getHighResolutionPortraitBoxArtUrl();
                if (null != C1698eK.this.f6490) {
                    C1698eK.this.f6490.m6085(highResolutionPortraitBoxArtUrl);
                }
                String bifUrl = pIVar.getBifUrl();
                if (C1349Bv.m4107(bifUrl)) {
                    C1698eK.this.m6099(bifUrl);
                }
                C1698eK.this.f6495.m6063(C1698eK.this.f6500);
                if (this.f6536) {
                    m6201(new BJ.C0067(pIVar.getPlayable().isPlayableEpisode(), pIVar.mo4566(), pIVar.getCatalogIdUrl(), pIVar.getId(), pIVar.mo4565()));
                    C1698eK.this.f6509.mo6043(C1698eK.this.f6500, this.f6538.f4576, C1698eK.this.f6510, this.f6538.f4580, C1698eK.this.f6498, C1698eK.this.f6503);
                }
                C1698eK.this.m6125(true, this.f6537.getPlayable().getParentTitle(), ((AbstractC2097qq) C1281.m16832(AbstractC2097qq.class)).mo10110(C1698eK.this.m16093(), this.f6537.getPlayable().getSeasonAbbrSeqLabel(), this.f6537.getPlayable().getEpisodeNumber(), this.f6537.getTitle(), this.f6537.isNSRE(), this.f6537.isEpisodeNumberHidden()), this.f6535);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6113(boolean z, boolean z2) {
        if ((!z2 || !this.f6485.f4577) && (z2 || !this.f6489.f4577)) {
            m16095().mo7805(this.f6489.f4579, (String) null, new If(z));
            return;
        }
        String str = z2 ? this.f6485.f4578 : this.f6489.f4578;
        m16095().mo7817(String.valueOf(str), null, new Cif(z, z2, str));
    }

    /* renamed from: ᶥ  reason: contains not printable characters */
    private void m6154() {
        IntentFilter intentFilter = new IntentFilter("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKEND");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKSTART");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_POSTPLAY");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_SIMPLE_PLAYBACKSTATE");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_ERROR");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_STATE");
        intentFilter.addCategory("com.netflix.mediaclient.intent.category.MDX");
        intentFilter.setPriority(999);
        m16093().registerReceiver(this.f6502, intentFilter);
    }

    /* renamed from: ꜟ  reason: contains not printable characters */
    private void m6158() {
        try {
            m16093().unregisterReceiver(this.f6502);
        } catch (Exception e) {
            C1283.m16862("MdxAgent", "unregister mStartStopReceiver " + e);
        }
    }

    @Override // o.oG
    /* renamed from: ˏˏ  reason: contains not printable characters */
    public pT mo6183() {
        return this.f6518;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6133(boolean z) {
        if (null != this.f6509) {
            this.f6509.m6220(this.f6500);
        }
        this.f6495.mo6057(this.f6500, 201, "stop connecting to target");
        this.f6495.mo6070(this.f6500, null, z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ﾟ  reason: contains not printable characters */
    private void m6162() {
        this.f6489 = new BJ.C0067();
        this.f6518 = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m6125(boolean z, String str, String str2, boolean z2) {
        m6156();
        synchronized (this.f6496) {
            this.f6513.mo6405(z, str, str2);
            if (this.f6494 != null) {
                this.f6494.m6247(str2 == null ? str : str2, z2);
            }
        }
    }

    @Override // o.AbstractC1284
    /* renamed from: ˎ  reason: contains not printable characters */
    public PendingIntent mo6176(int i) {
        return m6118(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_SKIP").putExtra("time", i));
    }

    @Override // o.AbstractC1284
    /* renamed from: ˊ  reason: contains not printable characters */
    public PendingIntent mo6164() {
        return m6118(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_SKIP_INTRO"));
    }

    @Override // o.AbstractC1284
    /* renamed from: ˋ  reason: contains not printable characters */
    public PendingIntent mo6168() {
        return m6118(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_PAUSE"));
    }

    @Override // o.AbstractC1284
    /* renamed from: ˎ  reason: contains not printable characters */
    public PendingIntent mo6175() {
        return m6118(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_RESUME"));
    }

    @Override // o.AbstractC1284
    /* renamed from: ॱ  reason: contains not printable characters */
    public PendingIntent mo6186() {
        return m6118(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_STOP"));
    }

    @Override // o.AbstractC1284
    public PendingIntent B_() {
        if (this.f6518 == null || !(this.f6518 instanceof pI)) {
            return null;
        }
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_PLAY_VIDEOIDS");
        String r4 = ((pI) this.f6518).mo4562();
        String topLevelId = this.f6518.getPlayable().getTopLevelId();
        if (TextUtils.isEmpty(topLevelId) || TextUtils.isEmpty(r4)) {
            return null;
        }
        intent.putExtra("episodeId", r4);
        intent.putExtra("catalogId", topLevelId);
        intent.putExtra("playNext", true);
        return m6118(intent);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private PendingIntent m6118(Intent intent) {
        intent.setClass(m16093(), ServiceC0966.class).addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", this.f6500);
        return PendingIntent.getService(m16093(), 0, intent, 134217728);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"InlinedApi"})
    /* renamed from: ꞌ  reason: contains not printable characters */
    private void m6159() {
        m6161();
        WifiManager r2 = ConnectivityUtils.m2961(m16093());
        if (r2 != null) {
            C1283.m16854("MdxAgent", "WiFi lock acquiring...");
            this.f6519 = r2.createWifiLock(3, "MdxAgent");
            this.f6519.acquire();
            C1283.m16854("MdxAgent", "WiFi lock acquired.");
        }
        PowerManager powerManager = (PowerManager) m16093().getSystemService("power");
        if (powerManager != null && this.f6514 == null) {
            this.f6514 = powerManager.newWakeLock(1, "MdxAgent");
        }
        if (this.f6514 != null && !this.f6514.isHeld()) {
            this.f6514.acquire();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ﾞ  reason: contains not printable characters */
    private void m6161() {
        if (this.f6519 != null && this.f6519.isHeld()) {
            C1283.m16854("MdxAgent", "WiFi lock was held, release...");
            this.f6519.release();
            C1283.m16854("MdxAgent", "WiFi lock released.");
        }
        if (this.f6514 != null && this.f6514.isHeld()) {
            this.f6514.release();
        }
    }

    /* renamed from: ﹳ  reason: contains not printable characters */
    private void m6160() {
        LocalBroadcastManager.getInstance(m16093()).registerReceiver(this.f6504, C2018nv.m9354());
    }

    /* renamed from: ʹ  reason: contains not printable characters */
    private void m6094() {
        try {
            LocalBroadcastManager.getInstance(m16093()).unregisterReceiver(this.f6504);
        } catch (Exception e) {
            C1283.m16862("MdxAgent", "unregisterUserAgentReceiver " + e);
        }
    }

    @Override // o.C1707eT.iF
    /* renamed from: ˎˏ  reason: contains not printable characters */
    public void mo6179() {
        mo6180("");
        if (null != this.f6495) {
            this.f6495.mo6062();
        }
    }

    @Override // o.C1707eT.iF
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6170(final String str) {
        s_().post(new Runnable() { // from class: o.eK.8
            @Override // java.lang.Runnable
            public void run() {
                C1698eK.this.f6500 = str;
            }
        });
        if (null != this.f6509) {
            this.f6509.m6216(str, false);
        }
    }

    @Override // o.oG
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo6188(String str, int i) {
        if (null != this.f6491) {
            this.f6491.m6251(this.f6500, str, this.f6489, i, this.f6510, this.f6503);
        }
    }

    @Override // o.C1703eP.If
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo6187(String str) {
        mo6180(str);
    }

    @Override // o.C1696eI.If
    /* renamed from: ˏ */
    public void mo6086(Bitmap bitmap) {
        this.f6511 = bitmap;
        if (this.f6494 != null) {
            this.f6494.m6243(this.f6511);
        }
        if (null != this.f6513) {
            this.f6513.mo6398(this.f6511);
        }
    }

    @Override // o.C1695eH.AbstractC0108
    /* renamed from: ͺॱ */
    public long mo6079() {
        if (null != this.f6509) {
            return this.f6509.m6221(this.f6500);
        }
        return 0;
    }

    @Override // o.C1695eH.AbstractC0108
    /* renamed from: ॱʻ */
    public void mo6080() {
        if (null != this.f6495) {
            this.f6495.mo6070(this.f6500, null, false);
        }
    }

    @Override // o.oG
    /* renamed from: ॱͺ  reason: contains not printable characters */
    public IMdxSharedState mo6191() {
        if (C1349Bv.m4107(this.f6500)) {
            return this.f6495.m6067(this.f6500);
        }
        return null;
    }

    @Override // o.oG
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6181(List<C2054pc> list) {
        Pair<String, byte[]> r2 = m16101().mo16546();
        if (this.f6488 == null) {
            C1283.m16854("MdxAgent", "castManager is null ");
        } else if (r2 == null) {
            C1283.m16846("MdxAgent", "prefetchVideo shared secret is null");
        } else {
            String r6 = new C1690eC(list, m16101().d_().mo14449(), (String) r2.first, (byte[]) r2.second).m6050();
            if (C1349Bv.m4107(r6)) {
                this.f6488.m6324(r6);
            }
        }
    }

    @Override // o.oG
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo6165(String str) {
        String r6 = this.f6509 != null ? this.f6509.m6225(this.f6500) : null;
        if (r6 == null) {
            r6 = this.f6500;
        }
        this.f6501.m6369(str, r6, this.f6497, this.f6506, AD.m3279(m16093()));
        this.f6506 = 0;
    }

    @Override // o.oG
    /* renamed from: ॱʽ  reason: contains not printable characters */
    public boolean mo6190() {
        if (null == this.f6509) {
            return false;
        }
        C1283.m16846("MdxAgent", "checking isTargetLaunchingOrLaunched");
        return this.f6509.m6213(this.f6500);
    }

    @Override // o.oG
    /* renamed from: ـ  reason: contains not printable characters */
    public void mo6185() {
        C1283.m16854("MdxAgent", "transfer playback from local to target");
    }

    @Override // o.AbstractC1712eY
    /* renamed from: ॱʼ  reason: contains not printable characters */
    public void mo6189() {
        if (this.f6488 != null) {
            MdxConnectionLogblobLogger.m691();
            this.f6488.m6317();
        }
        if (this.f6509 != null) {
            MdxConnectionLogblobLogger.m691();
            this.f6509.m6209();
        }
    }

    @Override // o.AbstractC1052
    /* renamed from: ʼ */
    public void mo5196() {
        WifiInfo connectionInfo;
        this.f6497++;
        this.f6506++;
        Context r5 = m16093();
        NetworkInfo r6 = ConnectivityUtils.m2967(r5);
        boolean z = false;
        String str = "mobile";
        String r9 = ConnectivityUtils.m2966(r5);
        String str2 = "unknown";
        if (r6 != null) {
            z = r6.isConnected();
            String subtypeName = r6.getSubtypeName();
            if (r6.getType() == 1) {
                str = "WIFI";
                WifiManager r11 = ConnectivityUtils.m2961(r5);
                if (!(r11 == null || (connectionInfo = r11.getConnectionInfo()) == null)) {
                    subtypeName = connectionInfo.getSSID();
                }
            } else if (r6.getType() == 9) {
                str = "ETHERNET";
            }
            str2 = str + ":" + subtypeName;
        }
        AbstractC1823gi.m6665(r9);
        C1283.m16848("MdxAgent", "handleConnectivityChange mCurrentTargetUuid=%s %s %b %s %s", this.f6500, str, Boolean.valueOf(z), r9, str2);
        C1694eG eGVar = new C1694eG(str, str2, r9, z);
        if (eGVar.equals(this.f6499)) {
            C1283.m16862("MdxAgent", "handleConnectivityChange event, same network state. ignored");
            return;
        }
        if (eGVar.m6073() && this.f6499 != null && this.f6499.m6073()) {
            C1283.m16862("MdxAgent", "handleConnectivityChange, network changed.");
            m6112(false);
        }
        this.f6499 = eGVar;
        if (this.f6509 != null) {
            this.f6509.m6212(str, z, r9, str2);
        }
        m6112(this.f6499.m6073());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6112(boolean z) {
        if (!z) {
            m6162();
        }
        if (this.f6500 != null && this.f6495 != null) {
            this.f6495.mo6071(z);
            if (!z && this.f6513 != null) {
                this.f6513.mo6404(m16096());
            }
        }
    }
}
