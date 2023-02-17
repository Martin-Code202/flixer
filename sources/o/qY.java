package o;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import o.C0567;
import o.oN;
import o.qH;
import o.qO;
public class qY implements AbstractC2141sc, qO.AbstractC0170, qO.Cif, qK {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static boolean f9572;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private static boolean f9573;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static boolean f9574;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private int f9575;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f9576;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f9577;

    /* renamed from: ˈ  reason: contains not printable characters */
    private String f9578;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected oX f9579 = new oB("DetailsHelper");

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private AbstractC0517 f9580;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Intent f9581;

    /* renamed from: ˎ  reason: contains not printable characters */
    private NetflixActivity f9582;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ArrayList<iF> f9583 = new ArrayList<>();

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f9584 = -1;

    /* renamed from: ͺ  reason: contains not printable characters */
    private C2116re f9585;

    /* renamed from: ॱ  reason: contains not printable characters */
    private tH f9586;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private ViewGroup f9587;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private int f9588;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private DetailsActivity.Action f9589;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final ArrayList<Intent> f9590 = new ArrayList<>();

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private ViewGroup f9591;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private int f9592;

    public qY(tH tHVar, NetflixActivity netflixActivity, Bundle bundle, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.f9586 = tHVar;
        this.f9582 = netflixActivity;
        this.f9587 = viewGroup;
        this.f9591 = viewGroup2;
        if (bundle != null) {
            m10032(bundle);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m10032(Bundle bundle) {
        m10072(bundle.getString("dh_video_id"));
        m10057(bundle.getString("dh_episode_id"));
        m10054((Intent) bundle.getParcelable("dh_intent"));
        oX oXVar = (oX) bundle.getParcelable("dh_play_context");
        if (oXVar == null) {
            C1276.m16820().mo5725("DetailsHelper null context passed in intent.");
            oXVar = new oB("DetailsHelper");
        }
        m10073(oXVar);
        this.f9583.clear();
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("dh_back_stack");
        if (parcelableArrayList != null) {
            this.f9583.addAll(parcelableArrayList);
        }
        this.f9590.clear();
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("dh_intent_stack");
        if (parcelableArrayList2 != null) {
            this.f9590.addAll(parcelableArrayList2);
        }
        m10035((AbstractC0517) this.f9582.getSupportFragmentManager().findFragmentByTag("dh_primary_fragment"));
        m10040((C2116re) this.f9582.getSupportFragmentManager().findFragmentByTag("dh_secondary_fragment"));
        m10020();
        this.f9582.runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.qY.5
            @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
            public void run(C2059ph phVar) {
                AbstractC0517 r1 = qY.this.f9580;
                if (r1 != null) {
                    r1.onManagerReady(phVar, AbstractC0367.f13235);
                }
                C2116re reVar = qY.this.f9585;
                if (reVar != null) {
                    reVar.onManagerReady(phVar, AbstractC0367.f13235);
                }
            }
        });
        this.f9582.getHandler().post(new Runnable() { // from class: o.qY.2
            @Override // java.lang.Runnable
            public void run() {
                qY.this.m10020();
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m10079(Bundle bundle) {
        bundle.putString("dh_video_id", m10053());
        bundle.putString("dh_episode_id", m10078());
        bundle.putParcelable("dh_intent", m10060());
        bundle.putParcelable("dh_play_context", this.f9579);
        bundle.putParcelableArrayList("dh_back_stack", this.f9583);
        bundle.putParcelableArrayList("dh_intent_stack", this.f9590);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10054(Intent intent) {
        this.f9581 = intent;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Intent m10060() {
        return this.f9581;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m10053() {
        return this.f9576;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10072(String str) {
        this.f9576 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10057(String str) {
        this.f9577 = str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m10078() {
        return this.f9577;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo10080(Intent intent) {
        return intent.getComponent() != null && (m10021(intent) || m10045(intent));
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean m10021(Intent intent) {
        return intent.getComponent() != null && intent.getComponent().getClassName().equals(ActivityC2121rj.m10436().getCanonicalName());
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean m10045(Intent intent) {
        return intent.getComponent() != null && intent.getComponent().getClassName().equals(ActivityC2132ru.m10478().getCanonicalName());
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˋ  reason: contains not printable characters */
    public AbstractC0517 mo10061(Intent intent) {
        if (mo10080(intent)) {
            return null;
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m10068(Intent intent) {
        C1283.m16853("DetailsHelper", "handleIntent: ", intent);
        if (intent == null || intent.getComponent() == null) {
            return false;
        }
        if (!m10021(intent) && !m10045(intent)) {
            return false;
        }
        Intent r6 = m10060();
        if (r6 != null) {
            C1283.m16846("DetailsHelper", "ADD: Adding Intent: " + r6);
            this.f9590.add(r6);
        } else {
            C1283.m16846("DetailsHelper", "ADD: Not adding Intent: " + r6);
        }
        m10054(intent);
        m10044();
        this.f9584 = m10060().getIntExtra("extra_model_view_id", -1);
        this.f9582.runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.qY.3
            @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
            public void run(C2059ph phVar) {
                qY.this.m10025();
                qY.this.m10041(false, (Parcelable) null);
            }
        });
        m10020();
        mo10075(intent);
        NetflixApplication.getInstance().m242().m4488(this.f9582, AppView.movieDetails, new C1359Ce(mo1635(), m10053()));
        return true;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo10074() {
        if (!m10082()) {
            return false;
        }
        while (m10082() && this.f9586.mo10704()) {
        }
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m10067() {
        if (!NetflixBottomNavBar.m416()) {
            return false;
        }
        C1283.m16846("DetailsHelper", "Back pressed, mBackStack size: " + this.f9583.size());
        if (this.f9583.size() > 0 && this.f9590.size() > 0) {
            iF remove = this.f9583.remove(this.f9583.size() - 1);
            m10054(this.f9590.remove(this.f9590.size() - 1));
            m10072(remove.f9599);
            m10073(remove.f9598);
            m10041(true, remove.f9601);
            m10020();
            NetflixApplication.getInstance().m242().m4491(this.f9582, AppView.movieDetails, true);
            return true;
        } else if (this.f9580 != null) {
            m10054((Intent) null);
            FragmentTransaction beginTransaction = this.f9582.getSupportFragmentManager().beginTransaction();
            m10038(this.f9580, null, true);
            beginTransaction.remove(this.f9580);
            if (this.f9585 != null) {
                m10038(this.f9585, null, true);
                beginTransaction.remove(this.f9585);
            }
            beginTransaction.commit();
            this.f9582.getSupportFragmentManager().executePendingTransactions();
            m10035((AbstractC0517) null);
            m10040((C2116re) null);
            m10072((String) null);
            m10073(new oB("DetailsHelper"));
            NetflixApplication.getInstance().m242().m4491(this.f9582, AppView.movieDetails, true);
            return true;
        } else {
            C1283.m16846("DetailsHelper", "No more videos in back stack");
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m10020() {
        if (this.f9581 != null && m10045(this.f9581)) {
            this.f9587.setVisibility(m10046() ? 0 : 8);
            this.f9591.setVisibility(0);
            if (this.f9580.getView() != null) {
                this.f9585.m10391(m10046() ? 8 : 0);
            }
        } else if (this.f9581 != null && m10021(this.f9581)) {
            this.f9587.setVisibility(0);
            this.f9591.setVisibility(8);
        }
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo10075(Intent intent) {
        if (!m10082()) {
            return false;
        }
        if (m10045(intent) && this.f9585 != null) {
            this.f9585.mo10383();
            return false;
        } else if (this.f9580 == null) {
            return false;
        } else {
            this.f9580.af_();
            return false;
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m10082() {
        return m10060() != null;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ʽ  reason: contains not printable characters */
    public AppView mo10051(Intent intent) {
        return AppView.movieDetails;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ᐝ  reason: contains not printable characters */
    public UIScreen mo10083() {
        return UIScreen.movieDetails;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ʻ  reason: contains not printable characters */
    public AbstractC0574 mo10050(Intent intent) {
        return new C1359Ce(mo1635(), m10053());
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m10044() {
        if (C1349Bv.m4107(m10053())) {
            Parcelable parcelable = null;
            if (this.f9580 instanceof AbstractC2124rm) {
                parcelable = ((AbstractC2124rm) this.f9580).mo10450();
            }
            this.f9583.add(new iF(m10053(), mo1635(), parcelable));
        }
        m10072(m10060().getStringExtra(NetflixActivity.EXTRA_VIDEO_ID));
        m10057(m10060().getStringExtra("extra_episode_id"));
        m10073((qN) m10060().getParcelableExtra(NetflixActivity.EXTRA_PLAY_CONTEXT));
        m10056((DetailsActivity.Action) m10060().getSerializableExtra("extra_action"), m10060().getStringExtra("extra_action_token"));
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public AbstractC0517 m10049() {
        if (this.f9581 == null) {
            return null;
        }
        if (!m10045(this.f9581)) {
            return C2122rk.m10441(m10053(), this.f9584);
        }
        if (C0881.m15600(this.f9582)) {
            return rB.m10134(m10053(), m10078());
        }
        return C2134rw.m10488(m10053(), m10078(), this.f9584);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m10035(AbstractC0517 r2) {
        this.f9580 = r2;
        if (r2 instanceof qW) {
            ((qW) r2).m9985(this);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public AbstractC0517 m10052() {
        return this.f9580;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private C2116re m10043() {
        if (this.f9581 == null || !m10045(this.f9581)) {
            return null;
        }
        if (C0881.m15600(this.f9582)) {
            return C2117rf.m10409(m10053(), m10078(), !m10046());
        }
        return C2116re.m10365(m10053(), m10078(), !m10046());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10058(pR pRVar) {
        if (pRVar.getId() == null) {
            C1276.m16820().mo5728("Requested videoId: " + m10053() + ", episodeId: " + m10078());
            C1276.m16820().mo5728("Details title: " + pRVar.getTitle());
            C1276.m16820().mo5728(pRVar.toString());
            C1276.m16820().mo5725("ShowDetails id was null in DetailsHelper.dataReady");
        } else if ((this.f9580 instanceof C2134rw) && pRVar.getId().equals(m10053())) {
            ((C2134rw) this.f9580).m10489(pRVar);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10040(C2116re reVar) {
        this.f9585 = reVar;
        if (reVar != null) {
            reVar.m10395(this);
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public C2116re m10064() {
        return this.f9585;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean m10046() {
        return AD.m3299() && AD.m3307(this.f9582);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10041(boolean z, Parcelable parcelable) {
        if (this.f9582.getServiceManager().mo9519()) {
            Fragment fragment = this.f9580;
            Fragment fragment2 = this.f9585;
            AbstractC0517 r5 = m10049();
            m10035(r5);
            if (r5 instanceof C2122rk) {
                ((C2122rk) r5).mo10452(parcelable);
            }
            if (r5 != null) {
                r5.m14533(this.f9575, this.f9588, this.f9592);
            }
            FragmentTransaction beginTransaction = this.f9582.getSupportFragmentManager().beginTransaction();
            m10038(fragment, r5, z);
            beginTransaction.replace(R.id.stacked_primary_fragment, r5, "dh_primary_fragment");
            C2116re r7 = m10043();
            if (r7 != null) {
                r7.m14475(this.f9575, this.f9588, this.f9592);
                m10038(fragment2, r7, z);
                beginTransaction.replace(R.id.stacked_secondary_fragment, r7, "dh_secondary_fragment");
            } else if (fragment2 != null) {
                m10038(fragment2, null, z);
                beginTransaction.remove(fragment2);
            }
            m10040(r7);
            beginTransaction.commit();
            this.f9582.getSupportFragmentManager().executePendingTransactions();
            this.f9580.onManagerReady(this.f9582.getServiceManager(), AbstractC0367.f13235);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10038(Fragment fragment, Fragment fragment2, boolean z) {
        this.f9586.m10940(fragment, fragment2, z);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10073(oX oXVar) {
        this.f9579 = oXVar;
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        return this.f9579;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10056(DetailsActivity.Action action, String str) {
        this.f9589 = action;
        this.f9578 = str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10071(Status status) {
        IClientLogging.CompletionReason completionReason = status.mo298() ? IClientLogging.CompletionReason.success : IClientLogging.CompletionReason.failed;
        if (f9572) {
            m10029(completionReason);
        }
        if (status.mo301() && f9574) {
            m10039(completionReason, status);
        }
        if (!this.f9582.isFinishing()) {
            C1283.m16854("DetailsHelper", "DetailsPage is loaded, reporting navigate.ended for movieDetails");
            C1362Ch.m4388(mo10083().f4084, completionReason, (UIError) null);
            if (status.mo301()) {
                this.f9582.handleFalkorAgentErrors(status);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʿ  reason: contains not printable characters */
    private void m10025() {
        m10026();
        m10022();
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private void m10022() {
        if (f9574) {
            C1283.m16854("DetailsHelper", "Received a start DP TTR session while already tracking another");
            m10039(IClientLogging.CompletionReason.canceled, (Status) null);
        }
        f9574 = true;
        this.f9582.startRenderNavigationLevelSession();
        PerformanceProfiler.INSTANCE.m663(Sessions.DP_TTR);
        this.f9582.runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.qY.1
            @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
            public void run(C2059ph phVar) {
                oN r4;
                qY.this.f9582.setupInteractiveTracking(new qH.C0166(), qY.this.m10023());
                ImageLoader r3 = phVar.m9829();
                if (r3 != null && (r4 = r3.mo3055(qH.C0166.f9444)) != null) {
                    r4.mo9573();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽॱ  reason: contains not printable characters */
    private oN.AbstractC0161 m10023() {
        return new oN.AbstractC0161() { // from class: o.qY.4
            @Override // o.oN.AbstractC0161
            /* renamed from: ˊ */
            public void mo1655(IClientLogging.CompletionReason completionReason) {
                if (qY.f9574) {
                    qY.this.m10039(completionReason, (Status) null);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10039(IClientLogging.CompletionReason completionReason, Status status) {
        if (!f9574) {
            C1276.m16820().mo5725("Received a end DP TTR session while not tracking any");
        }
        if (f9572) {
            f9573 = true;
            C1283.m16854("DetailsHelper", "Defer DP_TTR end until DP_TTI is complete.");
            return;
        }
        f9573 = false;
        f9574 = false;
        this.f9582.endRenderNavigationLevelSession(completionReason, status);
        PerformanceProfiler.INSTANCE.m665(Sessions.DP_TTR, m10030(completionReason));
        PerformanceProfiler.INSTANCE.m668();
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    private void m10026() {
        if (f9572) {
            C1283.m16854("DetailsHelper", "Received a start DP TTI session while already tracking another");
            m10029(IClientLogging.CompletionReason.canceled);
        }
        f9572 = true;
        PerformanceProfiler.INSTANCE.m663(Sessions.DP_TTI);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m10029(IClientLogging.CompletionReason completionReason) {
        if (!f9572) {
            C1276.m16820().mo5725("Received a end DP TTI session while not tracking any");
        }
        f9572 = false;
        PerformanceProfiler.INSTANCE.m665(Sessions.DP_TTI, m10030(completionReason));
        this.f9582.logMetadataRenderedEvent(false);
        if (f9573) {
            f9573 = false;
            m10039(completionReason, (Status) null);
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public VideoType m10081() {
        if (this.f9581 == null || !m10045(this.f9581)) {
            return VideoType.MOVIE;
        }
        return VideoType.SHOW;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Map<String, String> m10030(IClientLogging.CompletionReason completionReason) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", completionReason.name());
        if (m10081() != null) {
            hashMap.put("videoType", m10081().name());
        }
        return hashMap;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private void m10024() {
        if (f9572) {
            m10029(IClientLogging.CompletionReason.canceled);
        }
        if (f9574) {
            m10039(IClientLogging.CompletionReason.canceled, (Status) null);
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void m10059() {
        m10024();
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo10055(Intent intent, AbstractC0517 r2, boolean z) {
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo10062(Intent intent, AbstractC0517 r2, boolean z) {
    }

    @Override // o.qO.AbstractC0170
    public qO.Cif getEpisodeRowListener() {
        qO.Cif episodeRowListener = this.f9582.getEpisodeRowListener();
        if (episodeRowListener != null) {
            return episodeRowListener;
        }
        return this;
    }

    @Override // o.qO.Cif
    /* renamed from: ˏ */
    public void mo2536(pI pIVar) {
        PlaybackLauncher.m1607(this.f9582, pIVar.getPlayable(), pIVar.getType(), mo1635());
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public C2136ry m10076() {
        AbstractC0517 r4 = this.f9580;
        String str = null;
        if (r4 instanceof qW) {
            str = ((qW) r4).m9988();
        }
        return new C2136ry(m10053(), str, m10081(), mo1635());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10070(Menu menu, Menu menu2) {
        uM.m11540(this.f9582, menu);
        AJ.m3368(menu, this.f9582);
        boolean z = true;
        C2059ph serviceManager = this.f9582.getServiceManager();
        if (serviceManager.mo9519() && serviceManager.m9826() != null && serviceManager.m9826().isKidsProfile()) {
            C1283.m16846("DetailsHelper", "We have a kids profile - hide share icon");
            z = false;
        }
        if (C0881.m15597(this.f9582)) {
            z = false;
        }
        if (z) {
            C1283.m16846("DetailsHelper", "Adding share icon");
            menu.add(0, R.id.social_share_sheet_item, 0, R.string.share_button_name).setIcon(ContextCompat.getDrawable(this.f9582, R.drawable.ic_menu_share)).setShowAsAction(2);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m10063(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.social_share_sheet_item) {
            return false;
        }
        String r2 = m10053();
        AbstractC0517 r3 = this.f9580;
        String str = null;
        if (r3 instanceof qW) {
            str = ((qW) r3).m9988();
        }
        AJ.m3357(this.f9582, r2, str == null ? "" : str);
        return true;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m10077() {
        m10028(this.f9580);
        m10028(this.f9585);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m10065(int i, int i2, int i3) {
        this.f9575 = i;
        this.f9588 = i2;
        this.f9592 = i3;
        AbstractC0517 r0 = this.f9580;
        if (r0 != null) {
            r0.m14533(i, i2, i3);
        }
        C2116re reVar = this.f9585;
        if (reVar != null) {
            reVar.m14475(i, i2, i3);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m10028(Fragment fragment) {
        if (fragment != null && (fragment instanceof C0567.Cif)) {
            C1283.m16846("DetailsHelper", "Found frag to execute retry request...");
            ((C0567.Cif) fragment).N_();
        }
    }

    public static class iF implements Parcelable {
        public static final Parcelable.Creator<iF> CREATOR = new Parcelable.Creator<iF>() { // from class: o.qY.iF.1
            /* renamed from: ˋ  reason: contains not printable characters */
            public iF createFromParcel(Parcel parcel) {
                return new iF(parcel);
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public iF[] newArray(int i) {
                return new iF[i];
            }
        };

        /* renamed from: ˊ  reason: contains not printable characters */
        public final oX f9598;

        /* renamed from: ˋ  reason: contains not printable characters */
        public final String f9599;

        /* renamed from: ˏ  reason: contains not printable characters */
        boolean f9600;

        /* renamed from: ॱ  reason: contains not printable characters */
        Parcelable f9601;

        iF(String str, oX oXVar, Parcelable parcelable) {
            this.f9599 = str;
            this.f9598 = oXVar;
            this.f9601 = parcelable;
        }

        private iF(Parcel parcel) {
            this.f9599 = parcel.readString();
            this.f9598 = (oX) parcel.readParcelable(qN.class.getClassLoader());
            try {
                this.f9601 = parcel.readParcelable(C1317As.m3754(GridLayoutManager.class));
            } catch (Throwable th) {
                C1283.m16847("DetailsHelper", "SPY-8852: Failed to load layout manager state", th);
                C1276.m16820().mo5731(th);
            }
            this.f9600 = parcel.readByte() == 1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f9599);
            parcel.writeParcelable(this.f9598, i);
            parcel.writeParcelable(this.f9601, 0);
            parcel.writeByte(this.f9600 ? (byte) 1 : 0);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public String toString() {
            return "BackStackData [mVideoId=" + this.f9599 + ", playContext=" + this.f9598 + ", layoutManagerState=" + this.f9601 + "]";
        }
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo10069(Intent intent, Fragment fragment) {
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo10066(Intent intent, Fragment fragment) {
    }
}
