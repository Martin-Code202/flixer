package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.cl.Logger;
import com.netflix.cl.util.NamedLogSessionLookup;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.BookmarkStore;
import com.netflix.mediaclient.service.NetflixPowerManager;
import com.netflix.mediaclient.service.job.NetflixJob;
import com.netflix.mediaclient.service.offline.agent.IntentCommandGroupType;
import com.netflix.mediaclient.service.offline.agent.OfflineUnavailableReason;
import com.netflix.mediaclient.service.offline.download.OfflinePlayablePersistentData;
import com.netflix.mediaclient.service.offline.registry.OfflineRegistry;
import com.netflix.mediaclient.service.offline.registry.PersistRegistryException;
import com.netflix.mediaclient.service.offline.registry.RegistryData;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.ClientActionFromLase;
import com.netflix.mediaclient.service.user.UserAgent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadVideoQuality;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import o.AbstractC1853hl;
import o.AbstractC1863hu;
import o.AbstractC1897iy;
import o.C1843hb;
import o.C1848hg;
import o.C1851hj;
import o.C1875ib;
import o.hI;
import o.hS;
/* renamed from: o.ho  reason: case insensitive filesystem */
public class C1856ho extends AbstractC1052 implements AbstractC1897iy, AbstractC1853hl, AbstractC0963, C1843hb.If, C1848hg.If {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final NetflixPowerManager f7321;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final Map<Long, AbstractC1897iy.Cif> f7322 = new HashMap();

    /* renamed from: ʼ  reason: contains not printable characters */
    private C0482 f7323;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private String f7324;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AbstractC1863hu f7325;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private C1843hb f7326;

    /* renamed from: ʾ  reason: contains not printable characters */
    private AbstractC1852hk f7327;

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f7328 = false;

    /* renamed from: ˈ  reason: contains not printable characters */
    private C1848hg f7329;

    /* renamed from: ˉ  reason: contains not printable characters */
    private long f7330;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final UserAgent f7331;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private final C1855hn f7332 = new C1855hn();

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private final C0116 f7333 = new C0116();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private hS f7334;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final C1875ib f7335;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Context f7336;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private int f7337;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private HandlerThread f7338;

    /* renamed from: ˌ  reason: contains not printable characters */
    private final C1851hj.If f7339 = new C1851hj.If() { // from class: o.ho.12
        @Override // o.C1851hj.If
        /* renamed from: ॱ */
        public void mo7111() {
            C1348Bu.m4094();
            C1283.m16862("nf_offlineAgent", "continueDownloadOnBackOff");
            C1856ho.this.m7271();
        }

        @Override // o.C1851hj.If
        /* renamed from: ˎ */
        public void mo7109() {
            C1348Bu.m4094();
            C1283.m16862("nf_offlineAgent", "continueDownloadOnNetworkChanged");
            C1856ho.this.m7271();
        }

        @Override // o.C1851hj.If
        /* renamed from: ˋ */
        public void mo7108() {
            C1348Bu.m4094();
            C1283.m16862("nf_offlineAgent", "stopDownloadsNotAllowedByNetwork");
            C1856ho.this.m7212(StopReason.NotAllowedOnCurrentNetwork);
        }

        @Override // o.C1851hj.If
        /* renamed from: ˏ */
        public void mo7110() {
            C1348Bu.m4094();
            C1283.m16862("nf_offlineAgent", "stopDownloadsNoNetwork");
            C1856ho.this.m7212(StopReason.NoNetworkConnectivity);
        }

        @Override // o.C1851hj.If
        /* renamed from: ˊ */
        public void mo7107() {
            C1348Bu.m4094();
            C1283.m16862("nf_offlineAgent", "continueDownloadOnStreamingStopped");
            C1856ho.this.m7271();
        }

        @Override // o.C1851hj.If
        /* renamed from: ᐝ */
        public void mo7113() {
            C1348Bu.m4094();
            C1283.m16862("nf_offlineAgent", "stopDownloadOnStreamingStarted");
            C1856ho.this.m7212(StopReason.PlayerStreaming);
        }

        @Override // o.C1851hj.If
        /* renamed from: ॱॱ */
        public void mo7112() {
            C1348Bu.m4094();
            C1283.m16862("nf_offlineAgent", "onDownloadResumeJob");
            if (C1856ho.this.f7331.mo1333()) {
                C1856ho.this.m7197(6);
            }
        }
    };

    /* renamed from: ˍ  reason: contains not printable characters */
    private final hJ f7340 = new hJ() { // from class: o.ho.13
        @Override // o.hJ
        /* renamed from: ˊ */
        public void mo6947(hI hIVar, Status status) {
            C1283.m16863("nf_offlineAgent", "onInitialized playableId=%s status=%s", hIVar.mo6915(), status);
            if (C1856ho.this.f7328) {
                C1856ho.this.m7226(hIVar.mo6915(), status);
            } else {
                C1283.m16850("nf_offlineAgent", "onInitialized no longer available");
            }
        }

        @Override // o.hJ
        /* renamed from: ˏ */
        public void mo6950(hI hIVar, Status status) {
            C1283.m16863("nf_offlineAgent", "onNetworkError playableId=%s status=%s", hIVar.mo6915(), status);
            C1856ho.this.m7276();
            C1856ho.this.m7243(hIVar);
            C1856ho.this.f7351.m7100(hIVar.mo6915());
        }

        @Override // o.hJ
        /* renamed from: ˊ */
        public void mo6946(hI hIVar) {
            String r4 = hIVar.mo6915();
            C1283.m16863("nf_offlineAgent", "onDownloadCompletedSuccess playableId=%s", r4);
            C1856ho.this.m7276();
            C1856ho.this.m7206(hIVar);
            C1856ho.this.f7351.m7101(r4);
            C1856ho.this.m7271();
        }

        @Override // o.hJ
        /* renamed from: ˏ */
        public void mo6949(hI hIVar) {
            C1856ho.this.m7207(hIVar, hIVar.mo6916());
        }

        @Override // o.hJ
        /* renamed from: ˊ */
        public void mo6945() {
            C1856ho.this.m7276();
        }

        @Override // o.hJ
        /* renamed from: ˎ */
        public void mo6948(hI hIVar, Status status) {
            C1283.m16863("nf_offlineAgent", "onStorageError status=%s", status);
            if (status.mo302().m271() == StatusCode.DL_VIEWABLE_DIRECTORY_MISSING.m271()) {
                C1856ho.this.f7344.remove(hIVar);
                C1856ho.this.m7276();
                C1856ho.this.f7342.mo7290();
                return;
            }
            C1856ho.this.m7276();
            C1856ho.this.m7243(hIVar);
            C1856ho.this.f7351.m7090();
        }

        @Override // o.hJ
        /* renamed from: ॱ */
        public void mo6952(hI hIVar, Status status) {
            C1283.m16844("nf_offlineAgent", "onUnRecoverableError playableId=%s status=%s", hIVar.mo6915(), status);
            C1856ho.this.m7276();
            C1856ho.this.m7243(hIVar);
            C1856ho.this.f7351.m7093(hIVar.mo6915(), status);
            C1856ho.this.m7271();
        }

        @Override // o.hJ
        /* renamed from: ॱ */
        public void mo6951(OfflinePlayablePersistentData offlinePlayablePersistentData) {
            C1856ho.this.f7347.m842(offlinePlayablePersistentData);
            mo6945();
        }
    };

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC0661 f7341;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private final C1875ib.iF f7342 = new C1875ib.iF() { // from class: o.ho.14
        @Override // o.C1875ib.iF
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo7290() {
            if (C1856ho.this.f7331.mo1333()) {
                boolean r5 = C1856ho.this.f7346.mo16558();
                if (r5) {
                    C1283.m16863("nf_offlineAgent", "onStorageAddedOrRemoved ignored disabledFromConfig=%b", Boolean.valueOf(r5));
                    return;
                }
                boolean r6 = C1856ho.this.m7234(StopReason.WaitingToBeStarted);
                OfflineRegistry.RegistryState r7 = C1856ho.this.f7347.m846(C1856ho.this.f7335);
                C1283.m16863("nf_offlineAgent", "onStorageAddedOrRemoved state=%s", r7.toString());
                switch (AnonymousClass16.f7368[r7.ordinal()]) {
                    case 1:
                        C1856ho.this.f7328 = false;
                        break;
                    case 2:
                        C1856ho.this.f7328 = true;
                        C1856ho.this.m7275();
                        break;
                    case 3:
                        C1856ho.this.f7328 = false;
                        hW.m6991(C1856ho.this.m16086().mo1512(), OfflineUnavailableReason.NA_OFFLINE_STORAGE_NOT_AVAILABLE);
                        break;
                }
                if (r6) {
                    C1856ho.this.m7271();
                }
                hW.m6994(C1856ho.this.m16086().mo1512(), C1856ho.this.f7347.m852());
                C1856ho.this.f7332.m7157(C1856ho.this.s_(), C1856ho.this.f7328);
            }
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC2023o f7343;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final List<hI> f7344 = new ArrayList();

    /* renamed from: ͺ  reason: contains not printable characters */
    private hX f7345;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1221 f7346;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final OfflineRegistry f7347;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f7348 = false;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private C1858hq f7349;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final iT f7350;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C1851hj f7351;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC2102qv f7352;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private Cif f7353;

    public C1856ho(Context context, iT iTVar, C1260 r7, UserAgent userAgent, AbstractC1863hu huVar, AbstractC2023o oVar, AbstractC0661 r11, NetflixPowerManager netflixPowerManager, BookmarkStore bookmarkStore) {
        this.f7346 = r7;
        this.f7350 = iTVar;
        this.f7331 = userAgent;
        this.f7336 = context;
        this.f7343 = oVar;
        this.f7341 = r11;
        this.f7321 = netflixPowerManager;
        this.f7325 = huVar;
        m7264();
        this.f7335 = new C1875ib(this.f7336, this.f7338.getLooper(), this.f7342);
        this.f7347 = new OfflineRegistry(this.f7336);
        this.f7353.post(new Runnable() { // from class: o.ho.2
            @Override // java.lang.Runnable
            public void run() {
                C1856ho.this.f7347.m846(C1856ho.this.f7335);
            }
        });
        this.f7349 = new C1858hq(this, this.f7325);
        this.f7352 = (AbstractC2102qv) C1281.m16832(AbstractC2102qv.class);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m7262(String str) {
        C1283.m16862("nf_offlineAgent", "processNextCreateRequest");
        if (this.f7324 == null) {
            hI r8 = C1857hp.m7302(this.f7344);
            if (r8 != null) {
                C1283.m16863("nf_offlineAgent", "processNextCreateRequest processing playableId=%s", r8.mo6915());
                this.f7324 = r8.mo6915();
                if (!this.f7331.mo1333()) {
                    m7226(this.f7324, new NetflixStatus(StatusCode.DL_USER_NOT_LOGGED_IN));
                    return;
                }
                long r9 = C1317As.m3763(new File(this.f7347.m833()));
                hW.m6996(m16086().mo1512(), r8.mo6915(), r8.mo6913(), r8.mo6882(), r9, this.f7347.m833(), str);
                if (!C1857hp.m7295(r9, this.f7347.m833(), this.f7344)) {
                    C1283.m16850("nf_offlineAgent", "handleCreateRequest not enough space");
                    m7226(this.f7324, new NetflixStatus(StatusCode.DL_NOT_ENOUGH_FREE_SPACE));
                    return;
                }
                r8.mo6893();
                return;
            }
            return;
        }
        C1283.m16863("nf_offlineAgent", "processNextCreateRequest already processing, mPlayableIdInFlight=%s", this.f7324);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱʻ  reason: contains not printable characters */
    private void m7252() {
        OfflineUnavailableReason r11 = this.f7346.mo16555();
        if (r11 != null) {
            hW.m6991(m16086().mo1512(), r11);
            m16090(AbstractC0367.f13235);
            return;
        }
        this.f7335.m7656();
        this.f7332.m7158(this.f7321);
        this.f7345 = new C1877id(this.f7350, this.f7338, m16086().mo1518(), m16086());
        this.f7334 = new hR(m16093(), this.f7338.getLooper(), this.f7350, m16086());
        switch (this.f7347.m841()) {
            case NOT_READY:
                m16090(new NetflixStatus(StatusCode.DL_OFFLINE_AGENT_NOT_READY));
                return;
            case SUCCESS:
            default:
                m7275();
                this.f7327 = ((AbstractC2102qv) C1281.m16832(AbstractC2102qv.class)).mo10120(s_(), m16093(), m16096(), m16097(), this.f7346.mo16548(), this);
                this.f7351 = new C1851hj(m16093(), this.f7343, this.f7333, this.f7344, this.f7338.getLooper(), this.f7339, this.f7347.m849(), m16086(), t_(), this.f7347.m840().size() + this.f7344.size() > 0);
                this.f7338.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: o.ho.17
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread, Throwable th) {
                        C1856ho.this.m7227(thread, th);
                    }
                });
                this.f7326 = new C1843hb(m16093(), this, this.f7338.getLooper());
                this.f7326.m7036();
                C1283.m16854("nf_offlineAgent", "OfflineAgent doInit success.");
                this.f7328 = true;
                C1339Bl.m4048(this.f7336, "offline_ever_worked", true);
                m16090(AbstractC0367.f13235);
                return;
            case STORAGE_ERROR:
                hW.m6991(m16086().mo1512(), OfflineUnavailableReason.NA_OFFLINE_STORAGE_NOT_AVAILABLE);
                m16090(AbstractC0367.f13235);
                return;
        }
    }

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private void m7258() {
        final Cif ifVar = this.f7353;
        this.f7325.mo7344(C1857hp.m7305(this.f7344), new AbstractC1863hu.Cif() { // from class: o.ho.23
            @Override // o.AbstractC1863hu.Cif
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo7291(final Map<String, Boolean> map) {
                if (C1856ho.this.mo7118()) {
                    ifVar.post(new Runnable() { // from class: o.ho.23.5
                        @Override // java.lang.Runnable
                        public void run() {
                            C1856ho.this.m7242(map);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7227(Thread thread, Throwable th) {
        C1283.m16856("nf_offlineAgent", th, "uncaughtException threadName=%s", Thread.currentThread().getName());
        try {
            C1283.m16850("nf_offlineAgent", "uncaughtException stopping all downloads");
            this.f7353.removeCallbacksAndMessages(null);
            m7234(StopReason.WaitingToBeStarted);
            this.f7351.m7099();
            C1283.m16850("nf_offlineAgent", "uncaughtException stopped all downloads");
        } catch (Exception e) {
            C1283.m16856("nf_offlineAgent", e, "setUncaughtExceptionHandler error stopping downloads", new Object[0]);
        }
        C1283.m16850("nf_offlineAgent", "passing to defaultExceptionHandler");
        Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, th);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱʽ  reason: contains not printable characters */
    private void m7254() {
        C1283.m16862("nf_offlineAgent", "handleAgentDestroyRequest");
        if (this.f7335 != null) {
            this.f7335.m7655();
        }
        if (this.f7326 != null) {
            this.f7326.m7035();
        }
        if (this.f7334 != null) {
            this.f7334.mo6972();
        }
        if (this.f7351 != null) {
            this.f7351.m7088();
        }
        m7212(StopReason.WaitingToBeStarted);
        if (this.f7323 != null) {
            C1283.m16862("nf_offlineAgent", "Stopping Volley RequestQueue");
            this.f7323.m14416();
            this.f7323 = null;
        }
        for (hI hIVar : this.f7344) {
            hIVar.mo6880();
        }
        this.f7344.clear();
        m7267();
        super.mo1236();
        C1283.m16862("nf_offlineAgent", "destroyInBgThread done");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7215(C1844hc hcVar) {
        String str = hcVar.f7220;
        m7277();
        hI r5 = C1857hp.m7298(str, this.f7344);
        if (r5 != null && r5.mo6881() == DownloadState.CreateFailed) {
            C1283.m16862("nf_offlineAgent", "handleCreateRequest removing CreateFailed item");
            this.f7344.remove(r5);
            this.f7347.m853(r5.mo6890(), false);
            r5 = null;
        }
        if (r5 == null) {
            C1283.m16863("nf_offlineAgent", "handleCreateRequest creating new item %s", str);
            OfflinePlayablePersistentData createOfflineContentPersistentData = OfflinePlayablePersistentData.createOfflineContentPersistentData(str, hcVar.f7219, AZ.m3503(), this.f7331.mo1340(), m7274().m1579());
            createOfflineContentPersistentData.mDxId = AZ.m3501();
            C1365Ck.m4456(createOfflineContentPersistentData.mOxId);
            NamedLogSessionLookup.INSTANCE.m152(createOfflineContentPersistentData.mOxId, Logger.INSTANCE.m142(new C0395()));
            hI r52 = m7185(this.f7347.m833(), createOfflineContentPersistentData);
            this.f7347.m836(createOfflineContentPersistentData);
            this.f7344.add(r52);
            m7262("handleCreateRequest");
            this.f7332.m7163(s_(), str);
            return;
        }
        C1283.m16850("nf_offlineAgent", "handleCreateRequest already requested");
        this.f7332.m7152(s_(), str, new NetflixStatus(StatusCode.DL_TITTLE_ALREADY_REQUESTED_FOR_DOWNLOAD));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private void m7169(String str) {
        m7276();
        hI r5 = C1857hp.m7298(str, this.f7344);
        if (r5 == null) {
            C1283.m16844("nf_offlineAgent", "handleResumeRequest not found playableId=%s", str);
        } else if (r5.mo6881() != DownloadState.Stopped) {
            C1283.m16844("nf_offlineAgent", "handleResumeRequest not stopped, state=%s", r5.mo6881().toString());
        } else {
            r5.mo6890().setDownloadStateStopped(StopReason.WaitingToBeStarted);
            r5.mo6890().resetPersistentStatus();
            boolean r6 = m7223(r5);
            if (r6) {
                m7187(r5);
            } else {
                m7243(r5);
            }
            C1283.m16863("nf_offlineAgent", "handleResumeRequest playableId=%s resumed=%b", r5.mo6915(), Boolean.valueOf(r6));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m7223(hI hIVar) {
        if (!this.f7351.m7104(hIVar)) {
            return false;
        }
        hIVar.mo6903();
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private void m7178(String str) {
        C1283.m16863("nf_offlineAgent", "handlePauseRequest playableId=%s", str);
        hI r4 = C1857hp.m7298(str, this.f7344);
        if (r4 == null) {
            C1283.m16844("nf_offlineAgent", "handlePauseRequest playableId=%s not found", str);
        } else if (r4.mo6881() != DownloadState.Complete) {
            r4.mo6905(StopReason.StoppedFromAgentAPI);
            m7276();
            m7243(r4);
        } else {
            C1283.m16850("nf_offlineAgent", "handlePauseRequest trying to pause a completed item");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7191(boolean z) {
        this.f7347.m838(z);
        this.f7351.m7096(z);
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˊᐝ */
    public void mo7122() {
        if (this.f7351 != null) {
            this.f7351.m7097();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ـ  reason: contains not printable characters */
    private void m7237() {
        C1283.m16862("nf_offlineAgent", "handleDownloadMaintenanceJob");
        if (this.f7329 != null) {
            this.f7329.m7052();
        }
        hW.m6995(m16086().mo1512(), NetflixJob.NetflixJobId.NETFLIX_MAINTENANCE);
        this.f7329 = new C1848hg(this, this.f7334, this.f7344, this.f7347);
        this.f7329.m7051(this.f7325);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱʼ  reason: contains not printable characters */
    private void m7253() {
        C1283.m16862("nf_offlineAgent", "handleDownloadResumeJob");
        hW.m6995(m16086().mo1512(), NetflixJob.NetflixJobId.DOWNLOAD_RESUME);
        m7271();
        this.f7351.m7105();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7242(Map<String, Boolean> map) {
        C1283.m16862("nf_offlineAgent", "handleGeoPlayabilityUpdated");
        if (!m7167()) {
            C1857hp.m7294(map, this.f7344);
            this.f7347.m843(this.f7346.mo16556());
            m7276();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7213(final String str, C1847hf hfVar) {
        C1283.m16863("nf_offlineAgent", "handleDeleteRequest playableId=%s", str);
        hI r4 = C1857hp.m7298(str, this.f7344);
        if (r4 == null) {
            C1283.m16850("nf_offlineAgent", "handleDeleteRequest offlinePlayable not found");
        } else if (r4.mo6915().equals(this.f7324)) {
            C1283.m16862("nf_offlineAgent", "handleDeleteRequest not deleting in-flight item");
            m7240(str, new NetflixStatus(StatusCode.DL_BUSY_TRY_DELETE_AGAIN), (C1847hf) null);
        } else {
            m7175(r4.mo6890().mOxId);
            this.f7344.remove(r4);
            this.f7347.m853(r4.mo6890(), true);
            Status r5 = r4.mo6889(false);
            C1857hp.m7303(this.f7336, r5, r4);
            this.f7351.m7092(str);
            m7276();
            m7270();
            m7240(str, r5, hfVar);
            m7271();
            if (hfVar == null) {
                s_().post(new Runnable() { // from class: o.ho.22
                    @Override // java.lang.Runnable
                    public void run() {
                        C1856ho.this.m7259(str);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7241(final List<String> list) {
        Status status = AbstractC0367.f13235;
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            C1283.m16863("nf_offlineAgent", "handleDeletePlayables playableId=%s", str);
            hI r7 = C1857hp.m7298(str, this.f7344);
            if (r7 == null) {
                C1283.m16850("nf_offlineAgent", "handleDeletePlayables offlinePlayable not found");
            } else if (r7.mo6915().equals(this.f7324)) {
                C1283.m16862("nf_offlineAgent", "handleDeletePlayables not deleting in-flight item");
                status = new NetflixStatus(StatusCode.DL_BUSY_TRY_DELETE_AGAIN);
            } else {
                m7175(r7.mo6890().mOxId);
                this.f7344.remove(r7);
                this.f7347.m853(r7.mo6890(), true);
                Status r8 = r7.mo6889(false);
                if (status.mo298()) {
                    status = r8;
                }
                C1857hp.m7303(this.f7336, r8, r7);
                this.f7351.m7092(str);
                m7276();
            }
        }
        m7276();
        m7270();
        m7228(list, status);
        m7271();
        s_().post(new Runnable() { // from class: o.ho.25
            @Override // java.lang.Runnable
            public void run() {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    C1856ho.this.m7259((String) list.get(i2));
                }
            }
        });
    }

    /* renamed from: ᐨ  reason: contains not printable characters */
    private void m7269() {
        for (hI hIVar : this.f7344) {
            hIVar.mo6898((hI.iF) null);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m7175(String str) {
        Long valueOf = Long.valueOf(Long.parseLong(str));
        C1365Ck.m4460(str);
        C0590.m14710(str, new C0708(valueOf.longValue()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7249(boolean z) {
        C1283.m16863("nf_offlineAgent", "handleDeleteAllRequest deletePermanently=%b", Boolean.valueOf(z));
        Status status = AbstractC0367.f13235;
        m7265();
        final ArrayList arrayList = new ArrayList();
        for (hI hIVar : this.f7344) {
            if (hIVar.mo6915().equals(this.f7324)) {
                C1283.m16862("nf_offlineAgent", "handleDeleteRequest not deleting in-flight item");
            } else {
                m7175(hIVar.mo6890().mOxId);
                this.f7347.m853(hIVar.mo6890(), true);
                Status r9 = hIVar.mo6889(z);
                if (r9.mo301()) {
                    C1283.m16844("nf_offlineAgent", "handleDeleteAllRequest can't delete playableId=%s status=%s", hIVar.mo6915(), r9);
                    status = r9;
                }
                C1857hp.m7303(this.f7336, r9, hIVar);
                arrayList.add(hIVar.mo6915());
            }
        }
        this.f7347.m837("");
        this.f7344.clear();
        this.f7351.m7091();
        if (z) {
            C1857hp.m7307(this.f7336);
            this.f7347.m845();
        }
        m7276();
        mo7137();
        m7211(status);
        s_().post(new Runnable() { // from class: o.ho.24
            @Override // java.lang.Runnable
            public void run() {
                for (String str : arrayList) {
                    C1856ho.this.m7259(str);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m7259(String str) {
        this.f7325.mo7343(m16093(), str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐧ  reason: contains not printable characters */
    private void m7268() {
        m7225(this.f7336);
        this.f7343.mo8793(this.f7333, this.f7337);
    }

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private void m7265() {
        final HashMap hashMap = new HashMap();
        s_().post(new Runnable() { // from class: o.ho.21
            @Override // java.lang.Runnable
            public void run() {
                C1856ho.this.m7199(hashMap);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7199(Map<String, pV> map) {
        this.f7352.mo10117(map);
    }

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private void m7264() {
        if (this.f7338 == null) {
            this.f7338 = new HandlerThread("nf_of_bg", 10);
            this.f7338.start();
            this.f7353 = new Cif(this.f7338.getLooper());
        }
    }

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private void m7267() {
        if (this.f7353 != null) {
            this.f7353.removeCallbacksAndMessages(null);
            this.f7353 = null;
        }
        if (this.f7338 != null) {
            HandlerThread handlerThread = this.f7338;
            this.f7338 = null;
            handlerThread.quit();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        C1283.m16862("nf_offlineAgent", "OfflineAgent doInit");
        this.f7328 = false;
        m7264();
        m7197(0);
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        C1283.m16862("nf_offlineAgent", "destroy");
        this.f7328 = false;
        this.f7335.m7655();
        this.f7332.m7150();
        if (this.f7353 != null) {
            m7197(5);
        }
        this.f7343.mo8790(this.f7333);
    }

    @Override // o.AbstractC1052
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7286(int i) {
        if (this.f7345 != null) {
            this.f7345.mo7003(i);
        }
    }

    @Override // o.AbstractC1052
    /* renamed from: ʼ */
    public void mo5196() {
        super.mo5196();
        if (this.f7328 && this.f7351 != null) {
            this.f7351.m7089();
            this.f7349.m7323();
        }
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˉ */
    public boolean mo7118() {
        return !m7167();
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ॱ */
    public void mo7141(String str, VideoType videoType, oX oXVar) {
        C1283.m16863("nf_offlineAgent", "requestOfflineViewing playableId=%s", str);
        C1283.m16861("request offline viewing started.");
        if (m7167()) {
            C1276.m16820().mo5725("SPY-12255 got requestOfflineViewing while offline feature disabled.");
            return;
        }
        C1857hp.m7308(this.f7336, 0);
        m7273();
        m7191(false);
        C1844hc hcVar = new C1844hc(str, oXVar);
        this.f7325.mo7342(this.f7331.mo1383(), m16097(), str, videoType);
        this.f7353.sendMessageAtFrontOfQueue(this.f7353.obtainMessage(1, hcVar));
    }

    /* renamed from: ꜞ  reason: contains not printable characters */
    private void m7273() {
        String r4 = this.f7331.mo1384();
        String r5 = this.f7347.m855();
        if (C1349Bv.m4107(r4) && C1349Bv.m4113(r5)) {
            this.f7347.m837(r4);
            C1283.m16863("nf_offlineAgent", "updatePrimaryProfileGuidIfMissing %s", r4);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private hI m7185(String str, OfflinePlayablePersistentData offlinePlayablePersistentData) {
        return new hF(m16093(), offlinePlayablePersistentData, new hG(), C1888ip.m7717(str, offlinePlayablePersistentData.mPlayableId), this.f7323, this.f7345, this.f7334, this.f7340, this.f7338, m16086());
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ॱ */
    public void mo7140(String str) {
        C1348Bu.m4093();
        m7191(false);
        m7210(2, str);
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˊ */
    public void mo7121(String str, VideoType videoType, oX oXVar) {
        C1348Bu.m4093();
        this.f7353.obtainMessage(14, new C1847hf(str, oXVar, videoType, false)).sendToTarget();
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˏ */
    public void mo7134(String str, VideoType videoType, oX oXVar) {
        C1348Bu.m4093();
        this.f7353.obtainMessage(14, new C1847hf(str, oXVar, videoType, true)).sendToTarget();
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˎ */
    public void mo7129(List<String> list) {
        C1348Bu.m4093();
        if (list.size() > 0) {
            m7191(false);
            this.f7353.sendMessage(this.f7353.obtainMessage(13, list));
            return;
        }
        C1283.m16862("nf_offlineAgent", "deleteOfflinePlayables nothing to be done");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᶥ  reason: contains not printable characters */
    private void m7270() {
        final Map<String, pV> hashMap = new HashMap<>();
        for (hI hIVar : this.f7344) {
            hashMap.put(hIVar.mo6915(), hIVar);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C1283.m16862("nf_offlineAgent", "buildNewUiList already in main regenerate");
            m7199(hashMap);
            return;
        }
        s_().post(new Runnable() { // from class: o.ho.27
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16862("nf_offlineAgent", "buildNewUiList now in main.. regenerate");
                C1856ho.this.m7199(hashMap);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ꓸ  reason: contains not printable characters */
    private void m7272() {
        this.f7325.mo7345(m16097(), new Runnable() { // from class: o.ho.5
            @Override // java.lang.Runnable
            public void run() {
                C1856ho.this.m7270();
            }
        });
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˋ */
    public void mo7123(String str) {
        C1348Bu.m4093();
        m7191(true);
        m7210(3, str);
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˎ */
    public void mo7128(String str) {
        C1348Bu.m4093();
        m7191(false);
        m7210(4, str);
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˋ */
    public void mo7124(AbstractC1854hm hmVar) {
        C1348Bu.m4093();
        this.f7332.m7164(s_(), hmVar);
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˏ */
    public void mo7135(AbstractC1854hm hmVar) {
        C1348Bu.m4093();
        this.f7332.m7159(s_(), hmVar);
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˎ */
    public void mo7130(final boolean z) {
        C1348Bu.m4093();
        C1283.m16863("nf_offlineAgent", "setRequiresUnmeteredNetwork requires=%b", Boolean.valueOf(z));
        this.f7353.post(new Runnable() { // from class: o.ho.1
            @Override // java.lang.Runnable
            public void run() {
                C1856ho.this.f7351.m7102(z);
            }
        });
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˎˎ */
    public boolean mo7131() {
        C1348Bu.m4093();
        return this.f7351 == null || this.f7351.m7094();
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˏ */
    public void mo7132(DownloadVideoQuality downloadVideoQuality) {
        C1339Bl.m4039(m16093(), "download_video_quality", downloadVideoQuality.m1579());
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˍ */
    public DownloadVideoQuality mo7127() {
        return m7274();
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˌ */
    public void mo7126() {
        C1348Bu.m4093();
        m7197(8);
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˋᐝ */
    public void mo7125() {
        m7197(15);
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˏ */
    public void mo7133(final String str) {
        C1283.m16863("nf_offlineAgent", "requestRefreshLicenseForPlayable playableId=%s", str);
        this.f7353.post(new Runnable() { // from class: o.ho.4
            @Override // java.lang.Runnable
            public void run() {
                final hI r2 = C1857hp.m7298(str, C1856ho.this.f7344);
                if (r2 != null) {
                    r2.mo6904(IBladeRunnerClient.OfflineRefreshInvoke.USER, new AbstractC1853hl.AbstractC0115() { // from class: o.ho.4.4
                        @Override // o.AbstractC1853hl.AbstractC0115
                        /* renamed from: ॱ */
                        public void mo6919(Status status) {
                            r2.mo6890().setPersistentStatus(status);
                            C1856ho.this.m7225(C1856ho.this.m16093());
                            C1856ho.this.m7214(r2, status);
                        }
                    });
                }
            }
        });
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˊ */
    public void mo7120(final String str) {
        C1283.m16863("nf_offlineAgent", "requestRenewPlayWindowForPlayable playableId=%s", str);
        this.f7353.post(new Runnable() { // from class: o.ho.3
            @Override // java.lang.Runnable
            public void run() {
                hI r2 = C1857hp.m7298(str, C1856ho.this.f7344);
                if (r2 != null) {
                    OfflinePlayablePersistentData r3 = r2.mo6890();
                    Status r4 = C1860hr.m7328(C1856ho.this.m16093(), r3);
                    r3.setPersistentStatus(r4);
                    C1856ho.this.m7225(C1856ho.this.m16093());
                    C1856ho.this.m7200(r2, r4);
                }
            }
        });
    }

    /* renamed from: ꜟ  reason: contains not printable characters */
    private DownloadVideoQuality m7274() {
        return DownloadVideoQuality.m1578(C1339Bl.m4045(m16093(), "download_video_quality", DownloadVideoQuality.DEFAULT.m1579()));
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    public AbstractC0963 m7283() {
        return this;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ㆍ  reason: contains not printable characters */
    private void m7271() {
        if (!this.f7331.mo1333() || !this.f7328) {
            C1283.m16850("nf_offlineAgent", "startDownloadIfAllowed user is not logged in or offline not available");
            return;
        }
        hI r5 = this.f7351.m7106();
        if (r5 != null) {
            C1283.m16863("nf_offlineAgent", "starting the download for %s", r5.mo6915());
            r5.mo6903();
            return;
        }
        C1283.m16863("nf_offlineAgent", "no downloadable item found, count=%d", Integer.valueOf(this.f7344.size()));
    }

    /* renamed from: ﾞ  reason: contains not printable characters */
    private void m7277() {
        if (this.f7323 == null) {
            this.f7323 = this.f7341.mo14824(new C1036(), new C1813gS(this.f7336, new C2015ns(this.f7341)), this.f7346.mo16539(), false, "offline");
            this.f7323.m14410();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m7234(StopReason stopReason) {
        boolean z = false;
        for (hI hIVar : this.f7344) {
            if (C1889iq.m7738(hIVar)) {
                hIVar.mo6905(stopReason);
                m7243(hIVar);
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7212(StopReason stopReason) {
        if (m7234(stopReason)) {
            C1283.m16862("nf_offlineAgent", "stopAllDownloadsAndPersistRegistry something was stopped");
            m7225(m16093());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ꞌ  reason: contains not printable characters */
    private void m7275() {
        C1283.m16862("nf_offlineAgent", "buildFalkorDataAndPlayableListFromPersistentStore");
        if (this.f7347.m835() == null) {
            this.f7347.m843(this.f7346.mo16556());
        }
        if (this.f7347.m839()) {
            m7277();
        }
        this.f7344.clear();
        OfflineRegistry.C0018 r2 = this.f7347.m850();
        while (r2.hasMoreElements()) {
            RegistryData r3 = r2.nextElement();
            for (OfflinePlayablePersistentData offlinePlayablePersistentData : r3.mOfflinePlayablePersistentDataList) {
                this.f7344.add(m7185(r3.mOfflineRootStorageDirPath, offlinePlayablePersistentData));
            }
        }
        mo7137();
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˏˏ */
    public void mo7137() {
        m7270();
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˏˎ */
    public pY mo7136() {
        return this.f7347.m856();
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˊ */
    public void mo7119(int i) {
        this.f7353.obtainMessage(11, Integer.valueOf(i)).sendToTarget();
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ͺॱ */
    public void mo7139() {
        this.f7353.obtainMessage(12).sendToTarget();
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ॱ */
    public void mo7142(final String str, final AbstractC1853hl.Cif ifVar) {
        if (m7167()) {
            m7198(str, StatusCode.DL_OFFLINE_AGENT_NOT_READY, ifVar);
        } else {
            this.f7353.post(new Runnable() { // from class: o.ho.10
                @Override // java.lang.Runnable
                public void run() {
                    hI r4 = C1857hp.m7298(str, C1856ho.this.f7344);
                    if (r4 == null) {
                        C1856ho.this.m7198(str, StatusCode.DL_OFFLINE_PLAYABLE_NOT_FOUND, ifVar);
                    } else {
                        r4.mo6894(ifVar);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7198(final String str, final StatusCode statusCode, final AbstractC1853hl.Cif ifVar) {
        s_().post(new Runnable() { // from class: o.ho.7
            @Override // java.lang.Runnable
            public void run() {
                ifVar.mo5886(str, null, new NetflixStatus(statusCode));
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ﹳ  reason: contains not printable characters */
    private void m7276() {
        C1283.m16862("nf_offlineAgent", "saveToRegistry");
        this.f7348 = true;
        this.f7353.post(new Runnable() { // from class: o.ho.9
            @Override // java.lang.Runnable
            public void run() {
                if (!C1856ho.this.f7348) {
                    C1283.m16862("nf_offlineAgent", "saveToRegistry avoiding duplicate save.");
                    return;
                }
                C1856ho.this.m7225(C1856ho.this.m16093());
                C1856ho.this.f7348 = false;
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7225(Context context) {
        if (context != null) {
            try {
                this.f7347.m847();
            } catch (PersistRegistryException e) {
                C1283.m16850("nf_offlineAgent", "doSaveToRegistryInBGThread can't persist registry");
                hW.m6998(m16086().mo1512(), "-1", "-1", "-1", e.getMessage());
                m7239(new NetflixStatus(StatusCode.DL_CANT_PERSIST_REGISTRY));
                C1276.m16820().mo5729(e.getMessage(), e);
                long j = this.f7330;
                this.f7330 = System.currentTimeMillis();
                if (this.f7330 - j >= TimeUnit.MINUTES.toMillis(30)) {
                    this.f7342.mo7290();
                }
            }
        } else {
            C1283.m16850("nf_offlineAgent", "doSaveToRegistryInBGThread context is null");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7226(String str, Status status) {
        C1283.m16862("nf_offlineAgent", "sendResponseForCreate");
        hI r5 = C1857hp.m7298(str, this.f7344);
        if (r5 == null) {
            C1283.m16844("nf_offlineAgent", "sendResponseForCreate not found playableId=%s", str);
            hW.m6998(m16086().mo1512(), str, "-1", "-1", "mPlayableIdInFlight " + this.f7324);
            C1857hp.m7304(this.f7353, "sendResponseForCreate notFound " + str);
            return;
        }
        if (r5.mo6881() != DownloadState.Creating) {
            C1283.m16844("nf_offlineAgent", "sendResponseForCreate STATE %s", r5.mo6881());
            hW.m6998(m16086().mo1512(), str, r5.mo6913(), r5.mo6882(), "STATE " + r5.mo6881());
            C1857hp.m7304(this.f7353, "STATE " + r5.mo6881());
        }
        this.f7324 = null;
        if (status.mo298()) {
            Long r6 = NamedLogSessionLookup.INSTANCE.m151(r5.mo6890().mOxId);
            C1365Ck.m4461(r5.mo6890().mOxId, IClientLogging.ModalView.addCachedVideoButton, IClientLogging.CompletionReason.success, null);
            Logger.INSTANCE.m147(C0395.m14179(r6, Long.parseLong(r5.mo6890().mOxId)));
            if (status.mo302() == StatusCode.DL_WARNING_DL_N_TIMES_BEFORE_DATE) {
                r5.mo6890().setWarningStatus(status);
                r5.mo6890().setDownloadStateStopped(StopReason.DownloadLimitRequiresManualResume);
            } else {
                r5.mo6890().setDownloadStateStopped(StopReason.WaitingToBeStarted);
            }
        } else {
            r5.mo6890().setPersistentStatus(status);
            C1365Ck.m4461(r5.mo6890().mOxId, IClientLogging.ModalView.addCachedVideoButton, IClientLogging.CompletionReason.failed, C1343Bp.m4064(status));
            Logger.INSTANCE.m147(C0395.m14366(NamedLogSessionLookup.INSTANCE.m151(r5.mo6890().mOxId), C1343Bp.m4068(status)));
            r5.mo6890().setCreateFailedState();
            if (status.mo302() == StatusCode.DL_TOTAL_LICENSE_PER_DEVICE_LIMIT) {
                m7170();
            } else if (status.mo302() == StatusCode.DL_NOT_ENOUGH_FREE_SPACE) {
                this.f7347.m848(this.f7344);
            }
        }
        m7225(m16093());
        m7270();
        this.f7332.m7152(s_(), str, status);
        m7262("sendResponseForCreate");
        if (status.mo298() && !this.f7347.m849() && !this.f7351.m7103()) {
            C1283.m16863("nf_offlineAgent", "sendResponseForCreate playableId=%s resumed=%b", str, Boolean.valueOf(m7223(r5)));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7207(pV pVVar, int i) {
        this.f7332.m7155(s_(), pVVar, i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7206(pV pVVar) {
        this.f7332.m7154(s_(), pVVar);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7240(String str, Status status, C1847hf hfVar) {
        if (hfVar != null && hfVar.f7228 && this.f7347.m852() == 2) {
            m7209(this.f7347.m834() == 0 ? 1 : 0);
        }
        this.f7332.m7162(s_(), str, status, this, hfVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7228(List<String> list, Status status) {
        this.f7332.m7153(s_(), list, status);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7243(hI hIVar) {
        StopReason r6 = hIVar.mo6911();
        String str = null;
        if (r6 == StopReason.EncodesAreNotAvailableAnyMore || r6 == StopReason.ManifestError) {
            str = NetflixApplication.m222().toJson(hIVar.mo6890());
        }
        hW.m6989(m16086().mo1512(), hIVar.mo6915(), hIVar.mo6913(), hIVar.mo6882(), hIVar.mo6911(), str);
        this.f7332.m7160(s_(), hIVar, r6);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7187(hI hIVar) {
        this.f7332.m7165(s_(), hIVar);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7239(Status status) {
        this.f7332.m7151(s_(), status);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7211(Status status) {
        this.f7332.m7161(s_(), status);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7214(hI hIVar, Status status) {
        this.f7332.m7166(s_(), hIVar, status);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7200(hI hIVar, Status status) {
        this.f7332.m7156(s_(), hIVar, status);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7210(int i, String str) {
        this.f7353.obtainMessage(i, str).sendToTarget();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7197(int i) {
        this.f7353.obtainMessage(i).sendToTarget();
    }

    @Override // o.AbstractC0963
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7288(Intent intent) {
        IntentCommandGroupType r5 = IntentCommandGroupType.m819(intent);
        switch (r5) {
            case DownloadNotification:
                this.f7327.mo7116(intent);
                return;
            default:
                C1283.m16844("nf_offlineAgent", "unsupported IntentCommandGroupType=%s", r5.toString());
                return;
        }
    }

    /* renamed from: ʹ  reason: contains not printable characters */
    private boolean m7167() {
        return !this.f7328 || this.f7346.mo16558();
    }

    @Override // o.C1843hb.If
    /* renamed from: ॱ */
    public void mo7040() {
        C1348Bu.m4094();
        if (!m7167()) {
            m7212(StopReason.AccountInActive);
            s_().post(new Runnable() { // from class: o.ho.8
                @Override // java.lang.Runnable
                public void run() {
                    C1856ho.this.f7327.mo7117();
                }
            });
            this.f7349.m7316();
        }
    }

    @Override // o.C1843hb.If
    public void C_() {
        C1348Bu.m4094();
        C1283.m16862("nf_offlineAgent", "onUserAccountActive");
        if (!m7167()) {
            m7173();
            this.f7349.m7322();
        }
    }

    @Override // o.C1843hb.If
    /* renamed from: ˋ */
    public void mo7038() {
        C1348Bu.m4094();
        C1283.m16862("nf_offlineAgent", "onAccountDataFetched");
        if (!m7167()) {
            m7173();
            m7269();
            if (C1850hi.m7056(this.f7347.m835(), this.f7346.mo16556(), this.f7344)) {
                m7258();
            }
            m7278();
        }
    }

    /* renamed from: ﾟ  reason: contains not printable characters */
    private void m7278() {
        if (m7171()) {
            boolean z = this.f7344.size() == 0;
            int r6 = C1857hp.m7301(this.f7336);
            if (!z || r6 < 3) {
                C1857hp.m7299(this.f7336);
                if (z) {
                    int i = r6 + 1;
                    C1283.m16863("nf_offlineAgent", "zeroPlayableSyncCount %d", Integer.valueOf(i));
                    C1857hp.m7308(this.f7336, i);
                }
                this.f7353.postDelayed(new Runnable() { // from class: o.ho.6
                    @Override // java.lang.Runnable
                    public void run() {
                        C1856ho.this.m7170();
                    }
                }, 10000);
                return;
            }
            C1283.m16863("nf_offlineAgent", "Not calling sync, already did %d syncs", 3);
            return;
        }
        C1283.m16862("nf_offlineAgent", "Not calling sync, too early");
    }

    /* renamed from: ʻˋ  reason: contains not printable characters */
    private boolean m7171() {
        if (this.f7346.e_()) {
            C1283.m16862("nf_offlineAgent", "ESN migration required, do license sync if any license exist.");
            return true;
        }
        C1283.m16862("nf_offlineAgent", "ESN migration is NOT required, regular workflow.");
        return C1857hp.m7306(this.f7336);
    }

    /* renamed from: ʻᐝ  reason: contains not printable characters */
    private void m7173() {
        if (C1857hp.m7300(this.f7331, this.f7347)) {
            m7249(true);
            this.f7349.m7314();
        }
    }

    @Override // o.C1843hb.If
    /* renamed from: ˎ */
    public void mo7039() {
        C1348Bu.m4094();
        if (!m7167()) {
            this.f7351.m7098();
        }
    }

    @Override // o.C1843hb.If
    /* renamed from: ˊ */
    public void mo7037() {
        C1348Bu.m4094();
        if (!m7167()) {
            this.f7351.m7095();
        }
    }

    @Override // o.C1848hg.If
    /* renamed from: ॱॱ */
    public void mo7053() {
        C1283.m16862("nf_offlineAgent", "onAllMaintenanceJobDone");
        m7197(10);
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    public void m7285() {
        if (mo7118()) {
            s_().post(new Runnable() { // from class: o.ho.15
                @Override // java.lang.Runnable
                public void run() {
                    C1856ho.this.m7272();
                    if (C1856ho.this.f7349.mo7054()) {
                        C1856ho.this.mo7124(C1856ho.this.f7349);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ho$if  reason: invalid class name */
    public class Cif extends Handler {
        Cif(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C1856ho.this.m7252();
                    return;
                case 1:
                    C1856ho.this.m7215((C1844hc) message.obj);
                    return;
                case 2:
                    C1856ho.this.m7213((String) message.obj, (C1847hf) null);
                    return;
                case 3:
                    C1856ho.this.m7178((String) message.obj);
                    return;
                case 4:
                    C1856ho.this.m7169((String) message.obj);
                    return;
                case 5:
                    C1856ho.this.m7254();
                    return;
                case 6:
                    C1856ho.this.m7253();
                    return;
                case 7:
                    C1856ho.this.m7237();
                    return;
                case 8:
                    C1856ho.this.m7249(false);
                    return;
                case 9:
                    C1856ho.this.m7186((Long) message.obj);
                    return;
                case 10:
                    C1856ho.this.m7268();
                    C1856ho.this.f7329 = null;
                    return;
                case 11:
                    C1856ho.this.m7209(((Integer) message.obj).intValue());
                    return;
                case 12:
                    C1856ho.this.m7176();
                    return;
                case 13:
                    C1856ho.this.m7241((List) message.obj);
                    return;
                case 14:
                    C1847hf hfVar = (C1847hf) message.obj;
                    C1856ho.this.m7213(hfVar.f7227, hfVar);
                    return;
                case 15:
                    C1856ho.this.m7249(true);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ho$ˊ  reason: contains not printable characters */
    public class C0116 implements AbstractC2078q {
        private C0116() {
        }

        @Override // o.AbstractC2078q
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo7293(int i) {
            if (C1856ho.this.f7331.mo1333()) {
                C1856ho.this.f7337 = i;
                C1856ho.this.m7197(7);
            }
        }

        @Override // o.AbstractC2078q
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo7292() {
        }
    }

    @Override // o.AbstractC1897iy
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo7280(final long j, final AbstractC1897iy.Cif ifVar) {
        C1283.m16863("nf_offlineAgent", "requestOfflineManifest movieId=%d", Long.valueOf(j));
        if (m7167()) {
            ifVar.mo932(j, null, "-1", new NetflixStatus(StatusCode.DL_OFFLINE_AGENT_NOT_READY));
        } else {
            this.f7353.post(new Runnable() { // from class: o.ho.11
                @Override // java.lang.Runnable
                public void run() {
                    C1856ho.this.f7322.put(Long.valueOf(j), ifVar);
                    hI r7 = C1857hp.m7298(j + "", C1856ho.this.f7344);
                    if (r7 != null) {
                        r7.mo6899(new hI.Cif() { // from class: o.ho.11.3
                            @Override // o.hI.Cif
                            /* renamed from: ˊ */
                            public void mo6943(AbstractC1897iy.If r9, String str, Status status) {
                                C1283.m16862("nf_offlineAgent", "onPlayableManifestReady");
                                AbstractC1897iy.Cif ifVar2 = (AbstractC1897iy.Cif) C1856ho.this.f7322.remove(Long.valueOf(j));
                                if (ifVar2 != null) {
                                    C1856ho.this.m7233(r9, ifVar2, j, str, status);
                                    if (status.mo302().m271() == StatusCode.DL_MANIFEST_DATA_MISSING.m271()) {
                                        C1856ho.this.m7271();
                                    } else if (status.mo302().m271() == StatusCode.DL_MANIFEST_NOT_FOUND_IN_CACHE.m271()) {
                                        C1856ho.this.f7342.mo7290();
                                    }
                                } else {
                                    C1283.m16862("nf_offlineAgent", "onPlayableManifestReady originalCallback not found");
                                }
                            }
                        });
                    } else {
                        C1856ho.this.m7233(null, ifVar, j, "-1", new NetflixStatus(StatusCode.DL_OFFLINE_PLAYABLE_NOT_FOUND));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7186(Long l) {
        hI r2 = C1857hp.m7298(l.toString(), this.f7344);
        if (r2 != null) {
            r2.mo6909();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7209(int i) {
        C1283.m16863("nf_offlineAgent", "handleChangeCurrentOfflineStorageVolume newVolumeIndex=%d", Integer.valueOf(i));
        if (C1857hp.m7296(this.f7344)) {
            C1283.m16850("nf_offlineAgent", "handleChangeCurrentOfflineStorageVolume can't change volume while active create operations");
            return;
        }
        boolean r6 = m7234(StopReason.WaitingToBeStarted);
        if (this.f7347.m844(i)) {
            m7225(this.f7336);
            if (r6) {
                m7271();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼˊ  reason: contains not printable characters */
    private void m7176() {
        this.f7347.m854();
        LocalBroadcastManager.getInstance(this.f7336).sendBroadcast(new Intent("com.netflix.mediaclient.intent.offline.osv.space.usage.updated"));
    }

    @Override // o.AbstractC1897iy
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo7281(final long j) {
        if (r_()) {
            this.f7353.post(new Runnable() { // from class: o.ho.18
                @Override // java.lang.Runnable
                public void run() {
                    C1856ho.this.f7322.remove(Long.valueOf(j));
                }
            });
        } else {
            C1283.m16863("nf_offlineAgent", "abortManifestRequest OfflineAgent not ready error movieId=%d", Long.valueOf(j));
        }
    }

    @Override // o.AbstractC1897iy
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7287(long j) {
        this.f7353.sendMessageDelayed(this.f7353.obtainMessage(9, Long.valueOf(j)), 30000);
    }

    @Override // o.AbstractC1897iy
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo7284(long j) {
    }

    @Override // o.AbstractC1897iy
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo7289(long j) {
        this.f7353.removeMessages(9, Long.valueOf(j));
    }

    @Override // o.AbstractC1897iy
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo7282(long j, long j2) {
    }

    @Override // o.AbstractC1897iy
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo7279(long j) {
        this.f7353.removeMessages(9, Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7233(final AbstractC1897iy.If r10, final AbstractC1897iy.Cif ifVar, final long j, final String str, final Status status) {
        s_().post(new Runnable() { // from class: o.ho.19
            @Override // java.lang.Runnable
            public void run() {
                ifVar.mo932(j, r10, str, status);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻˊ  reason: contains not printable characters */
    private void m7170() {
        C1283.m16862("nf_offlineAgent", "syncLicensesToServer");
        if (this.f7331.mo1333()) {
            this.f7334.mo6975(C1857hp.m7297(this.f7347.m851()), new hS.AbstractC0113() { // from class: o.ho.20
                @Override // o.hS.AbstractC0113
                /* renamed from: ˏ */
                public void mo6978(Map<String, ClientActionFromLase> map, Status status) {
                    C1283.m16863("nf_offlineAgent", "onLicenseSyncDone res=%s", status);
                    for (Map.Entry<String, ClientActionFromLase> entry : map.entrySet()) {
                        hI r6 = C1857hp.m7298(entry.getKey(), C1856ho.this.f7344);
                        if (r6 != null) {
                            r6.mo6891(entry.getValue());
                        }
                    }
                }
            });
        }
    }

    @Override // o.AbstractC1853hl
    /* renamed from: ˑ */
    public AbstractC1849hh mo7138() {
        return this.f7349;
    }
}
