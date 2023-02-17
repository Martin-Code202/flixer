package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.BookmarkStore;
import com.netflix.mediaclient.service.falkor.FalkorAgentStatus;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.BillboardInteractionType;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.model.leafs.LoLoMoSummary;
import com.netflix.model.leafs.advisory.ExpiringContentAdvisory;
import com.netflix.model.leafs.social.IrisNotificationSummary;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import o.AJ;
import o.C0876;
import o.C2058pg;
/* renamed from: o.k  reason: case insensitive filesystem */
public class C1926k extends AbstractC1052 implements AbstractC1899j, AbstractC0948 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private static final AtomicBoolean f8097 = new AtomicBoolean();

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final Boolean f8098 = true;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Boolean f8099 = Boolean.valueOf(!f8098.booleanValue());

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AtomicBoolean f8100 = new AtomicBoolean(false);

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f8101;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final BroadcastReceiver f8102 = new BroadcastReceiver() { // from class: o.k.9
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (C1926k.m8118()) {
                    C2058pg.If r5 = C2058pg.m9731(intent);
                    if ("com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_START".equals(action)) {
                        C1926k.this.m8166(r5.f9385, r5.f9387);
                    } else if ("com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_STOP".equals(action)) {
                        C1283.m16862("FalkorAgent", "Refreshing CW for LOCAL_PLAYER_PLAY_STOP...");
                        if (r5.f9386 > -1) {
                            C1926k.this.f8109.m15582(r5.f9385, r5.f9387, r5.f9386);
                        }
                        if (C1349Bv.m4126(r5.f9389, "Default")) {
                            C1926k.this.m8172(false, (String) null);
                        }
                    }
                }
            }
        }
    };

    /* renamed from: ˎ  reason: contains not printable characters */
    private final UserAgentInterface f8103;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final oI f8104;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final BroadcastReceiver f8105 = new BroadcastReceiver() { // from class: o.k.6
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                C1283.m16862("FalkorAgent", "UserAgentIntentReceiver inovoked and received Intent with Action " + intent.getAction());
                if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_ACTIVE".equals(action)) {
                    C1926k.this.m8108();
                } else if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_DEACTIVE".equals(action)) {
                    C1926k.this.m8113();
                } else if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_TYPE_CHANGED".equals(action)) {
                    C1926k.this.m8104();
                } else if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE".equals(action)) {
                    C1926k.this.m8111();
                } else if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_NOT_LOGGED_IN".equals(action)) {
                    C1926k.this.m8110();
                }
            }
        }
    };

    /* renamed from: ͺ  reason: contains not printable characters */
    private final List<AbstractC1203> f8106 = Collections.synchronizedList(new ArrayList());

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1221 f8107;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final Runnable f8108 = new Runnable() { // from class: o.k.5
        @Override // java.lang.Runnable
        public void run() {
            if (C1926k.this.r_()) {
                C1926k.this.mo7807(true, true, false, (C1999nc) null);
            }
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C0876<C1379Cv> f8109;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0902 f8110;

    public C1926k(AbstractC1221 r3, UserAgentInterface userAgentInterface, oI oIVar) {
        this.f8107 = r3;
        this.f8103 = userAgentInterface;
        this.f8104 = oIVar;
    }

    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        C1379Cv cv = new C1379Cv();
        this.f8109 = new C0876<>(cv, this.f8107.mo16511(), C1069.f15227, new C0876.If() { // from class: o.k.3
            @Override // o.C0876.If
            /* renamed from: ˏ  reason: contains not printable characters */
            public boolean mo8176() {
                return C0727.m15067();
            }
        });
        cv.m4559(this.f8109);
        this.f8110 = new C0902(this.f8109, this);
        AG.m3337(m16093(), this.f8105, C2018nv.m9354());
        AG.m3331(m16093(), this.f8102, null, "com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_START", "com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_STOP");
        m16090(AbstractC0367.f13235);
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        AG.m3329(m16093(), this.f8105);
        AG.m3329(m16093(), this.f8102);
        super.mo1236();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8147(boolean z) {
        if (z) {
            this.f8109.m15256();
        }
        this.f8109.m15253();
    }

    @Override // o.AbstractC0948
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo8126() {
        return this.f8103.mo1340();
    }

    @Override // o.AbstractC0948
    /* renamed from: ॱ  reason: contains not printable characters */
    public BookmarkStore mo8160() {
        return m16099();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public AbstractC0929<?> m8134() {
        return this.f8109;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m8104() {
        C1283.m16862("FalkorAgent", "handleProfileTypeChanged");
        m8147(true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˌ  reason: contains not printable characters */
    private void m8110() {
        C1283.m16862("FalkorAgent", "handleAccountNotLoggedIn");
        m8147(true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˍ  reason: contains not printable characters */
    private void m8111() {
        this.f8109.m15256();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m8113() {
        f8097.set(false);
        this.f8101 = true;
        this.f8109.m15256();
        if (m8109()) {
            C1283.m16862("FalkorAgent", "handleProfileActive: Flushing all caches because profile deactivate...");
            m8147(false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋˋ  reason: contains not printable characters */
    private void m8108() {
        if (m8109()) {
            C1283.m16862("FalkorAgent", "handleProfileActive: Flushing all caches because new profile activated...");
            m8147(false);
        }
        this.f8101 = false;
        f8097.set(true);
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private boolean m8109() {
        return this.f8101;
    }

    /* access modifiers changed from: private */
    /* renamed from: ˑ  reason: contains not printable characters */
    public static boolean m8118() {
        if (!f8097.get()) {
            C1283.m16854("FalkorAgent", "wrong state - canDoDataFetches false - skipping browse request");
        }
        return f8097.get();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8154(AbstractC0487 r2, AbstractC1203 r3) {
        this.f8110.m15652(r2, r3);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8114(int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, final AbstractC1203 r25, int i7, boolean z4, String str) {
        this.f8110.m15663(i, i2, i3, i4, i5, i6, z, z2, z3, new AbstractC1222() { // from class: o.k.10
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˎ */
            public void mo7402(LoLoMoSummary loLoMoSummary, Status status) {
                if (r25 != null) {
                    r25.mo7402(loLoMoSummary, status);
                }
                boolean z5 = false;
                if (status instanceof FalkorAgentStatus) {
                    z5 = ((FalkorAgentStatus) status).m546();
                } else {
                    C1283.m16865("FalkorAgent", "status is not FalkorAgentStatus");
                }
                if (!z5) {
                    C1283.m16854("FalkorAgent", "nf_preapp notifying of  prefetch done");
                    C1926k.this.m16089().mo8945(C1926k.this.m16093());
                    if (!StatusCode.OK.equals(status.mo302())) {
                        C1283.m16865("FalkorAgent", "nf_preapp prefetch failed");
                    }
                    C1339Bl.m4043(C1926k.this.m16093(), "prefs_prefetch_lolomo_fetch_time_ms", System.currentTimeMillis());
                    long j = 0;
                    if (loLoMoSummary != null) {
                        j = loLoMoSummary.getExpiryTimeStamp();
                    }
                    C1339Bl.m4043(C1926k.this.m16093(), "prefs_cache_installed_lolomo_expiry_time_stamp", j);
                }
            }
        }, i7, z4, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8164(String str, int i, int i2, int i3, int i4, boolean z, int i5, AbstractC1203 r16) {
        this.f8110.m15678(str, i, i2, i3, i4, i5, r16);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˏ */
    public void mo7816(String str, int i, int i2, AbstractC1203 r5) {
        this.f8110.m15666(str, i, i2, r5);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8144(pC pCVar, int i, int i2, boolean z, boolean z2, boolean z3, AbstractC1203 r16) {
        this.f8110.m15644(pCVar, i, i2, z, z2, z3, false, r16);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8143(pC pCVar, int i, int i2, boolean z, AbstractC1203 r14) {
        this.f8110.m15644(pCVar, i, i2, f8099.booleanValue(), z, false, false, r14);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˋ */
    public void mo7810(String str, CmpTaskMode cmpTaskMode, VideoType videoType, int i, int i2, AbstractC1203 r13) {
        this.f8110.m15639(str, cmpTaskMode, videoType, i, i2, r13);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8156(String str, CmpTaskMode cmpTaskMode, AbstractC1203 r4) {
        this.f8110.m15640(str, cmpTaskMode, r4);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8149(int i, int i2, String str, AbstractC1203 r10) {
        this.f8110.m15646(i, i2, str, f8099.booleanValue(), r10);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8135(int i, int i2, String str, AbstractC1203 r5) {
        this.f8110.m15664(i, i2, str, r5);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8127(int i, int i2, String str, AbstractC1203 r5) {
        if (str != null) {
            this.f8110.m15653(i, i2, str, r5);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8161(int i, int i2, pC pCVar, boolean z, AbstractC1203 r13) {
        this.f8110.m15675(i, i2, pCVar, f8099.booleanValue(), z, false, r13);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8132(String str, AbstractC1203 r3) {
        this.f8110.m15671(str, r3);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8153(String str, AbstractC1203 r3) {
        this.f8110.m15643(str, r3);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˊ */
    public void mo7805(String str, String str2, AbstractC1203 r5) {
        this.f8110.m15670(str, str2, false, r5);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8171(List<? extends AbstractC2072pu> list, AbstractC1203 r3) {
        this.f8110.m15662(list, r3);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8168(String str, String str2, AbstractC1203 r10) {
        this.f8110.m15680(str, str2, false, false, false, r10);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˊ */
    public void mo7806(String str, String str2, boolean z, AbstractC1203 r11) {
        this.f8110.m15680(str, str2, true, z, false, r11);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8146(AbstractC1203 r2) {
        this.f8110.m15683(r2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8138(String str, CmpTaskMode cmpTaskMode, AbstractC1203 r4) {
        this.f8110.m15658(str, cmpTaskMode, r4);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8137(String str, int i, int i2, AbstractC1203 r5) {
        this.f8110.m15638(str, i, i2, r5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8165(String str, CmpTaskMode cmpTaskMode, boolean z, AbstractC1203 r5) {
        this.f8110.m15641(str, cmpTaskMode, z, r5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8129(String str, CmpTaskMode cmpTaskMode, int i, int i2, boolean z, AbstractC1203 r13) {
        this.f8110.m15647(str, cmpTaskMode, i, i2, z, r13);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8170(String str, AbstractC1203 r3, int i, int i2) {
        this.f8110.m15651(str, r3, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8142(String str, AbstractC1203 r3) {
        this.f8110.m15650(str, r3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8159(String str, AbstractC1203 r4) {
        this.f8110.m15672(str, false, r4);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ॱ */
    public void mo7821(String str, VideoType videoType, PlayLocationType playLocationType, AbstractC1203 r5) {
        this.f8110.m15668(str, videoType, playLocationType, r5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8140(String str, VideoType videoType, AbstractC1203 r5) {
        C1283.m16846("FalkorAgent", AR.m3406());
        this.f8110.m15660(str, videoType, r5);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8139(String str, VideoType videoType, String str2, String str3, AbstractC1203 r11) {
        this.f8110.m15648(str, videoType, str2, str3, r11);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8141(String str, String str2, AbstractC1203 r5) {
        C1283.m16846("FalkorAgent", AR.m3406());
        this.f8110.m15642(str, str2, r5);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˏ */
    public void mo7817(String str, String str2, AbstractC1203 r4) {
        this.f8110.m15661(str, str2, r4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8155(VideoType videoType, String str, String str2, AbstractC1203 r5) {
        this.f8110.m15677(videoType, str, str2, r5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8130(String str, VideoType videoType, int i, int i2, AbstractC1203 r11) {
        this.f8110.m15659(str, videoType, i, i2, r11);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8167(String str, VideoType videoType, int i, String str2, AbstractC1203 r11) {
        this.f8110.m15667(str, videoType, i, str2, r11);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8158(String str, VideoType videoType, String str2, AbstractC1203 r5) {
        this.f8110.m15669(str, videoType, str2, r5);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8145(pJ pJVar, BillboardInteractionType billboardInteractionType, Map<String, String> map) {
        this.f8110.m15674(pJVar, billboardInteractionType, map);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8131(String str, ExpiringContentAdvisory.ContentAction contentAction) {
        this.f8110.m15679(str, contentAction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8169(String str, AbstractC1203 r3) {
        this.f8110.m15681(str, r3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8152(String str, VideoType videoType, int i) {
        this.f8109.m15582(str, videoType, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8172(boolean z, String str) {
        if (this.f8109.m15578()) {
            mo7811(LoMoType.CONTINUE_WATCHING.m1575(), str);
        } else if (!z && ConnectivityUtils.m2954(m16093())) {
            mo7815((String) null);
        }
    }

    @Override // o.AbstractC1899j
    public void A_() {
        this.f8110.m15636();
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˋ */
    public void mo7811(String str, String str2) {
        if (this.f8110 == null) {
            C1276.m16820().mo5725("FalkorAgent method called while netflixFalkorTasksDispatcher is null");
        } else {
            this.f8110.m15649(str, str2);
        }
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˏ */
    public void mo7815(String str) {
        this.f8109.m15587();
        C2059ph.m9742(m16093(), str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8148() {
        new BackgroundTask().m285(new Runnable() { // from class: o.k.7
            @Override // java.lang.Runnable
            public void run() {
                C1926k.this.f8109.m15586();
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8166(final String str, VideoType videoType) {
        if (videoType != VideoType.EPISODE) {
            C1283.m16851("FalkorAgent", "fetchEpisodesForSeason - videoId %s is not an episode - skip!", str);
        } else {
            m8153(str, new AbstractC1222() { // from class: o.k.8
                @Override // o.AbstractC1222, o.AbstractC1203
                /* renamed from: ˊ  reason: contains not printable characters */
                public void mo8177(CH ch, Status status) {
                    if (ch == null) {
                        if (status == null || status.mo302() != StatusCode.NET_CRONET_INTERNET_DISCONNECTED) {
                            C1276.m16820().mo5725("fetchEpisodesForSeason - fetchFalkorVideo - video is null");
                        }
                    } else if (!C1349Bv.m4113(str) && ch.isPlayableEpisode() && !C1349Bv.m4113(ch.getTopLevelId())) {
                        C1926k.this.m8168(ch.getTopLevelId(), ch.getCurrentEpisodeId(), new AbstractC1222() { // from class: o.k.8.2
                            @Override // o.AbstractC1222, o.AbstractC1203
                            /* renamed from: ˊ */
                            public void mo8175(pR pRVar, Status status2) {
                                if (pRVar != null) {
                                    String currentEpisodeId = pRVar.getCurrentEpisodeId();
                                    if (C1349Bv.m4107(currentEpisodeId)) {
                                        final int currentEpisodeNumber = pRVar.getCurrentEpisodeNumber();
                                        C1926k.this.mo7817(currentEpisodeId, (String) null, new AbstractC1222() { // from class: o.k.8.2.1
                                            @Override // o.AbstractC1222, o.AbstractC1203
                                            /* renamed from: ˎ */
                                            public void mo6203(pI pIVar, Status status3) {
                                                if (pIVar != null) {
                                                    String r7 = pIVar.mo4564();
                                                    int i = (currentEpisodeNumber / 40) * 40;
                                                    C1926k.this.mo7810(r7, CmpTaskMode.FROM_CACHE_OR_NETWORK, VideoType.SEASON, i, (i + 40) - 1, new AbstractC1222() { // from class: o.k.8.2.1.3
                                                        @Override // o.AbstractC1222, o.AbstractC1203
                                                        /* renamed from: ᐝ */
                                                        public void mo7347(List<pI> list, Status status4) {
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8128(int i, int i2, AbstractC1203 r5) {
        this.f8110.m15655(i, i2, false, r5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8150(int i, int i2, boolean z, AbstractC1203 r5) {
        this.f8110.m15655(i, i2, z, r5);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˏ */
    public void mo7814(IrisNotificationSummary irisNotificationSummary) {
        this.f8110.m15657(irisNotificationSummary, new AbstractC1222() { // from class: o.k.12
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˊ  reason: contains not printable characters */
            public void mo8173(Status status) {
                if (status.mo298()) {
                    C1926k.this.mo7807(false, false, false, (C1999nc) null);
                } else {
                    C1926k.this.mo7807(true, false, false, (C1999nc) null);
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8133(List<IrisNotificationSummary> list) {
        this.f8110.m15682(list, new AbstractC1222() { // from class: o.k.13
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˊ */
            public void mo8173(Status status) {
                if (status.mo298()) {
                    C1926k.this.mo7807(false, false, false, (C1999nc) null);
                } else {
                    C1926k.this.mo7807(true, false, false, (C1999nc) null);
                }
            }
        });
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˊ */
    public void mo7807(boolean z, final boolean z2, final boolean z3, final C1999nc ncVar) {
        if (this.f8110 == null) {
            C1276.m16820().mo5725("FalkorAgent method called while netflixFalkorTasksDispatcher is null");
            return;
        }
        this.f8110.m15655(0, 7, z, new AbstractC1222() { // from class: o.k.14
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˏ  reason: contains not printable characters */
            public void mo8174(AbstractC2082qc qcVar, Status status) {
                if (qcVar != null && status.mo302() == StatusCode.OK) {
                    AJ.C0062 r6 = C1926k.this.m8121(qcVar);
                    IrisNotificationSummary r7 = C1926k.this.m8102(qcVar);
                    AJ.m3364(r6);
                    if (z3) {
                        C1926k.this.m8117(qcVar);
                    }
                    if (z2 && C1926k.this.m8107(r7)) {
                        AbstractC2171tb r8 = sG.m10595(r7.getType());
                        if (r8.mo11058()) {
                            r8.m11066(r7, qcVar.getSocialNotificationsListSummary(), C1926k.this.m16098(), ncVar, C1926k.this.m16093());
                        }
                    }
                }
            }
        });
        if (this.f8103.mo1383() != null) {
            m8119();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8117(AbstractC2082qc qcVar) {
        AnonymousClass2 r5 = new AbstractC1222() { // from class: o.k.2
            /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0011: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v0 java.lang.String) */
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˊ  reason: contains not printable characters */
            public void mo8175(pR pRVar, Status status) {
                Object[] objArr = new Object[1];
                objArr[0] = pRVar == null ? "null" : pRVar.getId();
                C1283.m16848("FalkorAgent", "RefreshSeasonsAndEpisodes response %s", objArr);
            }
        };
        for (IrisNotificationSummary irisNotificationSummary : qcVar.getSocialNotifications()) {
            if (irisNotificationSummary != null && !irisNotificationSummary.getWasRead() && irisNotificationSummary.getVideoId() != null && irisNotificationSummary.getType() == IrisNotificationSummary.NotificationTypes.NEW_SEASON_ALERT) {
                C1283.m16848("FalkorAgent", "RefreshSeasonsAndEpisodes refreshing %s", irisNotificationSummary.getVideoId());
                this.f8110.m15652(new C1139(irisNotificationSummary.getVideoId()), r5);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m8107(IrisNotificationSummary irisNotificationSummary) {
        return irisNotificationSummary != null && !AbstractApplicationC1258.m16693() && this.f8104.mo1238();
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private void m8119() {
        s_().removeCallbacks(this.f8108);
        s_().postDelayed(this.f8108, 3600000);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private AJ.C0062 m8121(AbstractC2082qc qcVar) {
        List<IrisNotificationSummary> socialNotifications = qcVar.getSocialNotifications();
        if (socialNotifications == null) {
            return AJ.f4281;
        }
        int i = 2;
        int i2 = 0;
        int i3 = 0;
        for (IrisNotificationSummary irisNotificationSummary : socialNotifications) {
            if (i == 0) {
                break;
            }
            if (irisNotificationSummary.getWasRead()) {
                i3++;
            } else {
                i2++;
            }
            i--;
        }
        return new AJ.C0062(i3, i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private IrisNotificationSummary m8102(AbstractC2082qc qcVar) {
        List<IrisNotificationSummary> socialNotifications = qcVar.getSocialNotifications();
        if (socialNotifications == null) {
            return null;
        }
        int i = 2;
        for (IrisNotificationSummary irisNotificationSummary : socialNotifications) {
            if (i == 0) {
                return null;
            }
            if (!irisNotificationSummary.getWasRead()) {
                return irisNotificationSummary;
            }
            i--;
        }
        return null;
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˎ */
    public void mo7812(int i, int i2) {
        mo7819(i, i2, (AbstractC1203) null);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ॱ */
    public void mo7819(int i, int i2, AbstractC1203 r18) {
        int i3 = i2 - 1;
        m8114(0, i - 1, 0, i3, 0, i3, false, false, false, r18, 0, false, null);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˋ */
    public void mo7808(int i, boolean z, AbstractC1203 r9) {
        this.f8110.m15654(0, i - 1, (String) null, z, r9);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˎ */
    public void mo7813(int i, boolean z, AbstractC1203 r9) {
        this.f8110.m15646(0, i - 1, (String) null, z, r9);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˊ */
    public void mo7803(int i, AbstractC1203 r6) {
        this.f8110.m15637(0, i - 1, (String) null, r6);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8163(int i, AbstractC1203 r3) {
        this.f8110.m15676(i, r3);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8151(VideoType videoType, String str, boolean z, AbstractC1203 r5) {
        this.f8110.m15656(videoType, str, z, r5);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˏ */
    public void mo7818(List<String> list, AbstractC1203 r3) {
        if (r_()) {
            this.f8110.m15673(list, r3);
        }
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˋ */
    public void mo7809(int i, boolean z, boolean z2, AbstractC1203 r12) {
        this.f8110.m15675(0, i - 1, (pC) null, z, false, z2, r12);
    }

    @Override // o.AbstractC1899j
    /* renamed from: ॱ */
    public void mo7820(String str, final int i, final int i2, final boolean z, final AbstractC1203 r12) {
        this.f8110.m15666(str, 0, 10, new AbstractC1222() { // from class: o.k.1
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˎ */
            public void mo7393(List<pC> list, Status status) {
                boolean z2 = false;
                if (status.mo298()) {
                    int i3 = 0;
                    Iterator<pC> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        pC next = it.next();
                        if (LoMoType.m1574(next.getType())) {
                            if (i3 == i) {
                                z2 = true;
                                C1926k.this.f8110.m15644(next, 0, i2 - 1, z, false, false, true, r12);
                                break;
                            }
                            i3++;
                        }
                    }
                }
                if (!z2) {
                    r12.mo7398(null, status);
                }
            }
        });
    }

    @Override // o.AbstractC1899j
    /* renamed from: ˊ */
    public void mo7804(int i, boolean z, AbstractC1203 r5) {
        this.f8110.m15665(i - 1, z, r5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8157(String str, VideoType videoType) {
        this.f8109.m15585(str, videoType);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8136(File file) {
        this.f8109.m15257(file);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8162(int i, String str, boolean z, AbstractC1203 r19) {
        C1283.m16846("FalkorAgent", AR.m3406());
        if (r19 != null) {
            this.f8106.add(r19);
        }
        if (this.f8100.get()) {
            C1283.m16851("FalkorAgent", "Attaching callback to already prefetching lolomo request. Callback list size = %s", Integer.valueOf(this.f8106.size()));
            return;
        }
        PerformanceProfiler.INSTANCE.m663(Sessions.LOLOMO_PREFETCH);
        AnonymousClass4 r14 = new AbstractC1222() { // from class: o.k.4
            @Override // o.AbstractC1222, o.AbstractC1203
            /* renamed from: ˎ */
            public void mo7402(LoLoMoSummary loLoMoSummary, Status status) {
                C1926k.this.f8100.set(false);
                PerformanceProfiler.INSTANCE.m665(Sessions.LOLOMO_PREFETCH, StatusCode.OK.equals(status.mo302()) ? null : PerformanceProfiler.m652());
                for (AbstractC1203 r5 : C1926k.this.f8106) {
                    if (r5 != null) {
                        r5.mo7402(loLoMoSummary, status);
                    }
                }
                C1926k.this.f8106.clear();
            }
        };
        this.f8100.set(true);
        m8114(0, 21, 0, C1061.m16114().mo14169(m16093(), LoMoType.STANDARD) - 1, 0, C1061.m16114().mo14169(m16093(), LoMoType.CONTINUE_WATCHING) - 1, C1061.m16114().mo14171(), false, false, r14, i, z, str);
    }
}
