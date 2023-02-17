package o;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.perf.Events;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.log.UIScreen;
import com.netflix.model.leafs.LoLoMoSummary;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import o.AJ;
import o.AbstractC0459;
import o.C0790;
import o.oN;
import o.qH;
import o.vT;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.sl  reason: case insensitive filesystem */
public class ActivityC2153sl extends AbstractActivityC0360 implements qK, vT.AbstractC0242 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static long f10187 = 0;

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f10188;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean f10189 = true;

    /* renamed from: ʼ  reason: contains not printable characters */
    private pC f10190;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final BroadcastReceiver f10191 = new BroadcastReceiver() { // from class: o.sl.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ActivityC2153sl.this.invalidateOptionsMenu();
        }
    };

    /* renamed from: ʽ  reason: contains not printable characters */
    private GenreList f10192;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final oV f10193 = new oV() { // from class: o.sl.7
        @Override // o.oV
        public void onManagerReady(C2059ph phVar, Status status) {
            C1283.m16846("HomeActivity", "ServiceManager ready");
            ActivityC2153sl.this.m10795();
            ActivityC2153sl.this.m10762();
            ActivityC2153sl.this.reportUiViewChanged(ActivityC2153sl.this.m10800());
            ActivityC2153sl.this.mo10792().onManagerReady(phVar, status);
            if (ActivityC2153sl.this.f10202 != null) {
                ActivityC2153sl.this.f10202.onManagerReady(phVar, status);
            }
            ActivityC2153sl.this.setLoadingStatusCallback(new AbstractC0459.AbstractC0460() { // from class: o.sl.7.4
                @Override // o.AbstractC0459.AbstractC0460
                /* renamed from: ˎ */
                public void mo1654(final Status status2) {
                    IClientLogging.CompletionReason completionReason = status2.mo298() ? IClientLogging.CompletionReason.success : IClientLogging.CompletionReason.failed;
                    ActivityC2153sl.this.m10784(completionReason);
                    if (status2.mo298()) {
                        ActivityC2153sl.this.setupInteractiveTracking(new qH.iF(), new oN.AbstractC0161() { // from class: o.sl.7.4.2
                            @Override // o.oN.AbstractC0161
                            /* renamed from: ˊ */
                            public void mo1655(IClientLogging.CompletionReason completionReason2) {
                                ActivityC2153sl.this.m10778(completionReason2, status2);
                            }
                        });
                    } else {
                        ActivityC2153sl.this.m10778(completionReason, status2);
                    }
                    LoLoMoSummary r6 = ActivityC2153sl.this.mo10792().m10855();
                    if (r6 != null) {
                        ActivityC2153sl.this.f10207 = r6.getExpiryTimeStamp();
                        C1283.m16851("HomeActivity", "Setting the mCurrExpiryTimeStamp = %s", Long.valueOf(ActivityC2153sl.this.f10207));
                    } else {
                        C1283.m16854("HomeActivity", "The lolomosummary object is null, so reset the mCurrExpiryTimeStamp in HomeActivity");
                        ActivityC2153sl.this.f10207 = -1;
                    }
                    ActivityC2153sl.this.setLoadingStatusCallback(null);
                    C1283.m16854("HomeActivity", "LOLOMO is loaded, report UI browse startup session ended in case this was on UI startup");
                    long elapsedRealtime = SystemClock.elapsedRealtime() - ActivityC2153sl.this.f10210;
                    if (status2.mo301()) {
                        ActivityC2153sl.this.handleFalkorAgentErrors(status2);
                    }
                    if (ActivityC2153sl.this.f10202 != null) {
                        ActivityC2153sl.this.f10202.a_(status2);
                    }
                    BW.m3932(elapsedRealtime, status2.mo298(), (UIError) null);
                }
            });
        }

        @Override // o.oV
        public void onManagerUnavailable(C2059ph phVar, Status status) {
            ActivityC2153sl.this.m10784(IClientLogging.CompletionReason.failed);
            ActivityC2153sl.this.m10778(IClientLogging.CompletionReason.failed, status);
            C1283.m16865("HomeActivity", "ServiceManager unavailable");
            ActivityC2153sl.this.mo10792().onManagerUnavailable(phVar, status);
            if (ActivityC2153sl.this.f10202 != null) {
                ActivityC2153sl.this.f10202.onManagerUnavailable(phVar, status);
            }
            C1283.m16854("HomeActivity", "LOLOMO failed, report UI startup session ended in case this was on UI startup");
        }
    };

    /* renamed from: ʾ  reason: contains not printable characters */
    private final BroadcastReceiver f10194 = new BroadcastReceiver() { // from class: o.sl.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!C1317As.m3750(ActivityC2153sl.this)) {
                if (intent == null || !"com.netflix.mediaclient.service.ACTION_EXPAND_HOME_CAST_PLAYER".equals(intent.getAction())) {
                    C1283.m16853("HomeActivity", "Invalid intent: ", intent);
                } else {
                    ActivityC2153sl.this.notifyCastPlayerShown(true);
                }
            }
        }
    };

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f10195 = true;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final BroadcastReceiver f10196 = new BroadcastReceiver() { // from class: o.sl.9
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1283.m16865("HomeActivity", "Received null intent");
                return;
            }
            String action = intent.getAction();
            C1283.m16863("HomeActivity", "RefreshHomeReceiver invoked and received Intent with Action %s", action);
            if ("com.netflix.mediaclient.intent.action.REFRESH_HOME_LOLOMO".equals(action)) {
                ActivityC2153sl.this.m10793(1, intent.getStringExtra("renoMessageId"));
            }
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private final LinkedList<Intent> f10197 = new LinkedList<>();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Handler f10198;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final BroadcastReceiver f10199 = new BroadcastReceiver() { // from class: o.sl.10
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AJ.C0062 r1 = AJ.m3360(intent, "HomeActivity");
            if (r1 != ActivityC2153sl.this.f10211) {
                ActivityC2153sl.this.f10211 = r1;
                ActivityC2153sl.this.O_();
            }
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private C0790.C0791 f10200;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f10201;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC2159sr f10202;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f10203 = false;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f10204;

    /* renamed from: ॱ  reason: contains not printable characters */
    private DrawerLayout f10205;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private long f10206;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private long f10207 = -1;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private Runnable f10208;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f10209;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private long f10210;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AJ.C0062 f10211 = AJ.f4281;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private boolean f10212;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Intent m10782(NetflixActivity netflixActivity) {
        Intent intent = new Intent(netflixActivity, m10755());
        if (NetflixBottomNavBar.m416()) {
            intent.addFlags(131072);
        } else {
            intent.addFlags(67108864);
        }
        return intent;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Intent m10779(NetflixActivity netflixActivity) {
        return m10782(netflixActivity).putExtra("genre_id", "lolomo");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m10769(NetflixActivity netflixActivity, GenreList genreList) {
        m10770(netflixActivity, genreList, false);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m10770(NetflixActivity netflixActivity, GenreList genreList, boolean z) {
        Intent putExtra = new Intent(netflixActivity, m10755()).putExtra("genre_id", genreList.getId()).putExtra("genre_parcel", genreList).putExtra("genre_from_lomo", z);
        if (!NetflixBottomNavBar.m416()) {
            putExtra.addFlags(67108864);
        }
        netflixActivity.startActivity(putExtra);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m10785(Intent intent) {
        if (intent == null) {
            return false;
        }
        intent.setExtrasClassLoader(ActivityC2153sl.class.getClassLoader());
        ComponentName component = intent.getComponent();
        return component != null && component.getClassName() != null && component.getClassName().equals(m10755().getCanonicalName()) && intent.hasExtra("genre_id") && !intent.getStringExtra("genre_id").equals("lolomo");
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void setTheme() {
        if (!C0727.m15067()) {
            super.setTheme();
        } else if (shouldShowKidsTheme()) {
            setTheme(R.style.res_2131952230_theme_netflix_kids_home);
        } else {
            setTheme(R.style.res_2131952223_theme_netflix_default_home);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m10798(GenreList genreList, String str) {
        C1283.m16851("HomeActivity", "showGenreForAb9031 filter=%s, genre=%s", str, genreList.getId());
        if ("lolomo".equals(str)) {
            performUpAction();
            return;
        }
        Intent putExtra = new Intent(this, m10755()).addFlags(67108864).putExtra("genre_id", genreList.getId()).putExtra("genre_filter", str);
        if (!"lolomo".equals(genreList.getId())) {
            putExtra.putExtra("genre_parcel", genreList);
        }
        this.fragmentHelper.mo10702(putExtra);
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private static Class<?> m10755() {
        return NetflixApplication.getInstance().m254() ? ActivityC2158sq.class : ActivityC2153sl.class;
    }

    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        PerformanceProfiler.INSTANCE.m669(Events.HOME_ACTIVITY_CREATED, (Map<String, String>) null);
        this.f10201 = bundle == null;
        this.f10210 = SystemClock.elapsedRealtime();
        if (bundle != null) {
            this.f10197.addAll((Collection) bundle.getSerializable("extra_back_stack_intents"));
            this.f10211 = (AJ.C0062) bundle.getParcelable("extra_notification_list_status");
        } else {
            startRenderNavigationLevelSession();
        }
        m10766(getIntent());
        this.f10200 = new C0790.C0791();
        if (C0727.m15067()) {
            C2222uv.f11041.m11777(this);
            runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.sl.4
                @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                public void run(C2059ph phVar) {
                    if (ActivityC2153sl.this.getNetflixActionBar() != null && ActivityC2153sl.this.getNetflixActionBar().m367() != null) {
                        ActivityC2153sl.this.getNetflixActionBar().m367().m11768(phVar);
                    }
                }
            });
        }
        super.onCreate(bundle);
        m10787();
        m10767();
        this.f10206 = SystemClock.elapsedRealtime();
        if (NetflixBottomNavBar.m416()) {
            setFragmentHelper(new tH(this, bundle));
        }
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m10787() {
        if (!NetflixBottomNavBar.m416()) {
            this.f10205 = (DrawerLayout) findViewById(R.id.sliding_menu);
            if (this.f10205 != null) {
                this.f10205.setDrawerTitle(8388611, getString(R.string.accessibility_sliding_menu_name));
                this.f10205.setDrawerListener(new DrawerLayout.DrawerListener() { // from class: o.sl.3
                    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
                    public void onDrawerSlide(View view, float f) {
                    }

                    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
                    public void onDrawerOpened(View view) {
                        C1283.m16862("HomeActivity", "onDrawerOpened");
                        if (ActivityC2153sl.this.f10202 instanceof C2160ss) {
                            C1364Cj.m4453(ActivityC2153sl.this.f10212 ? CommandEndedEvent.InputValue.tap : CommandEndedEvent.InputValue.swipe);
                            ActivityC2153sl.this.f10212 = false;
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("notifications", ActivityC2153sl.this.f10211.m3371());
                                jSONObject.put("unreadNotifications", ActivityC2153sl.this.f10211.m3370());
                            } catch (JSONException e) {
                                C1283.m16855("HomeActivity", "setupViews() Got exception", e);
                            }
                            C1364Cj.m4452(jSONObject);
                            ((C2160ss) ActivityC2153sl.this.f10202).m10846(true);
                        }
                    }

                    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
                    public void onDrawerClosed(View view) {
                        C1283.m16862("HomeActivity", "onDrawerClosed");
                        if (ActivityC2153sl.this.f10202 instanceof C2160ss) {
                            ActivityC2153sl.this.m10789();
                            ((C2160ss) ActivityC2153sl.this.f10202).m10846(false);
                            C1364Cj.m4446(true);
                            C1364Cj.m4439();
                            if (ActivityC2153sl.this.f10211.m3370()) {
                                C1283.m16862("HomeActivity", "Drawer was closed - updating the wasRead state of notifications in Summary Notifications View to be true.");
                                ((C2160ss) ActivityC2153sl.this.f10202).m10844();
                            }
                        }
                    }

                    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
                    public void onDrawerStateChanged(int i) {
                    }
                });
            }
            if (this.f10205 != null) {
                m10758();
                this.f10202 = BrowseExperience.m1775().mo1781(this, this.f10205);
                C1283.m16846("HomeActivity", "Created sliding menu adapter of type: " + this.f10202.getClass());
                this.f10205.setFocusable(false);
                this.f10205.setScrimColor(getResources().getColor(R.color.drawer_layout_overlay_scrim));
                m10774();
            }
        }
    }

    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity
    public int getActionBarParentViewId() {
        if (NetflixBottomNavBar.m416()) {
            return R.id.coordinatorLayout;
        }
        return R.id.toolbar_host_view_group;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canApplyBrowseExperience() {
        return true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canShowDownloadProgressBar() {
        return !NetflixBottomNavBar.m416();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onSlidingPanelCollapsed(View view) {
        m10758();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onSlidingPanelExpanded(View view) {
        m10759();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        m10777(intent, false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m10777(Intent intent, boolean z) {
        super.onNewIntent(intent);
        C1283.m16853("HomeActivity", "onNewIntent: %s", intent);
        if (!NetflixBottomNavBar.m411(intent)) {
            AppView r3 = m10799();
            if (m10766(intent)) {
                m10756();
                if (z) {
                    getNavigationLevelManager().m4491((NetflixActivity) this, r3, true);
                } else {
                    if (r3 != AppView.browseTitles) {
                        getNavigationLevelManager().m4491((NetflixActivity) this, r3, true);
                    }
                    getNavigationLevelManager().m4488(this, m10799(), (AbstractC0574) null);
                }
                getNavigationLevelManager().m4489();
            }
            if (hasBottomNavBar()) {
                overridePendingTransition(0, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldSetIntentOnNewIntent() {
        return false;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x007d: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v0 java.lang.String) */
    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m10766(Intent intent) {
        String str;
        boolean z = true;
        if (C1349Bv.m4113(this.f10188) && this.f10190 == null && this.f10197.size() == 0 && !intent.hasExtra("genre_id") && !intent.hasExtra("lomo_parcel")) {
            intent.putExtra("genre_id", "lolomo");
        }
        if (intent.getBooleanExtra(NetflixActivity.EXTRA_EXPAND_CAST_PLAYER, false)) {
            notifyCastPlayerShown(true);
        }
        String stringExtra = intent.getStringExtra("genre_id");
        pC pCVar = (pC) intent.getParcelableExtra("lomo_parcel");
        if (!C1349Bv.m4113(stringExtra) || pCVar != null) {
            if ((stringExtra != null && stringExtra.equals(this.f10188)) || (pCVar != null && pCVar.equals(this.f10190))) {
                Object[] objArr = new Object[1];
                if (stringExtra != null) {
                    str = stringExtra;
                } else {
                    str = pCVar.getId();
                }
                objArr[0] = str;
                C1283.m16863("HomeActivity", "Asked to show list that we're already showing - skipping: %s", objArr);
                z = false;
            } else if ("lolomo".equals(this.f10188)) {
                this.f10197.add(getIntent());
            }
            if (this.f10202 instanceof C2160ss) {
                ((C2160ss) this.f10202).m10849();
            }
            if ("lolomo".equals(stringExtra)) {
                this.f10197.clear();
            }
            this.f10188 = stringExtra;
            this.f10192 = (GenreList) intent.getParcelableExtra("genre_parcel");
            this.f10209 = intent.getStringExtra("genre_filter");
            this.f10190 = (pC) intent.getParcelableExtra("lomo_parcel");
            this.f10204 = intent.getBooleanExtra("genre_from_lomo", false);
            setIntent(intent);
            runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.sl.1
                @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                public void run(C2059ph phVar) {
                    ActivityC2153sl.this.reportUiViewChanged(ActivityC2153sl.this.m10800());
                }
            });
            return z;
        }
        C1283.m16854("HomeActivity", "No new ID to show");
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m10789() {
        if (this.f10211.m3370() && this.f10198 != null && this.f10208 != null) {
            this.f10198.removeCallbacks(this.f10208);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f10202 != null) {
            this.f10202.mo10808(this);
        }
        if (this.f10203) {
            m10791();
            this.f10203 = false;
        }
        if (!NetflixBottomNavBar.m416()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("RefreshUserMessageRequest.ACTION_UMA_MESSAGE_UPDATED");
            intentFilter.addAction("RefreshUserMessageRequest.ACTION_UMA_MESSAGE_CONSUMED");
            LocalBroadcastManager.getInstance(this).registerReceiver(this.f10191, intentFilter);
            invalidateOptionsMenu();
        }
        runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.sl.8
            @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
            public void run(C2059ph phVar) {
                if (phVar.m9824() && vO.m12029(phVar.m9832()).mo11975(phVar.m9826()) > 0) {
                    ActivityC2153sl.this.getTutorialHelper().m12054(ActivityC2153sl.this, phVar);
                }
                C2167sy.m10860(ActivityC2153sl.this).m10861();
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m10795() {
        if (NetflixApplication.m223() && getServiceManager().m9826() != null && !C1339Bl.m4051(this, "prefs_debug_ttr_toast_enabled", false)) {
            C1004.m15961(this, String.format("DEBUG: Profile %s", getServiceManager().m9826().getProfileName()), 1);
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m10791() {
        startRenderNavigationLevelSession();
        m10793(0, (String) null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10793(int i, String str) {
        if (m10761() || i != 0) {
            mo10792().mo10856(i, str);
            getServiceManager().m9821();
            if (!NetflixBottomNavBar.m416()) {
                this.f10202.mo10810();
                m10768();
                return;
            }
            return;
        }
        C1283.m16854("HomeActivity", "Lolomo not expired, no ui refresh");
        endRenderNavigationLevelSession(IClientLogging.CompletionReason.success, null);
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    private boolean m10761() {
        LoLoMoSummary r5 = mo10792().m10855();
        if (r5 == null) {
            C1283.m16854("HomeActivity", "frag-lolomosummary is null, lolomo request is perhaps in-flight");
            return false;
        } else if (r5.getExpiryTimeStamp() <= 0) {
            C1283.m16851("HomeActivity", "frag-lolomosummary has no expiry value %d", Long.valueOf(r5.getExpiryTimeStamp()));
            return false;
        } else {
            this.f10207 = r5.getExpiryTimeStamp();
            long currentTimeMillis = (System.currentTimeMillis() - this.f10207) / 1000;
            boolean z = currentTimeMillis > 0;
            C1283.m16851("HomeActivity", "lolomo expiry time stamp = %s, FORCE_EXP_DELTA PLT = %s, Lolomo's time to expiry = %s", Long.valueOf(this.f10207), Long.valueOf(f10187), Long.valueOf(currentTimeMillis));
            return z;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f10206 = SystemClock.elapsedRealtime();
        this.f10203 = true;
        m10789();
        if (NetflixBottomNavBar.m416()) {
            return;
        }
        if (this.f10202 != null) {
            this.f10202.mo10809(this);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f10191);
            return;
        }
        C1276.m16820().mo5725("slidingMenuAdapter is null even though bottom tabs is on isFinishing: " + isFinishing());
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    @SuppressLint({"RtlHardcoded"})
    public boolean handleBackPressed() {
        if (this.f10205 != null && this.f10205.isDrawerOpen(8388611)) {
            C1283.m16846("HomeActivity", "Sliding drawer was open, closing...");
            this.f10205.closeDrawer(8388611);
            return true;
        } else if (this.f10197.size() > 0) {
            m10777(this.f10197.removeLast(), true);
            return true;
        } else {
            C1283.m16846("HomeActivity", "No more items in back stack");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onCreateOptionsMenu(Menu menu, Menu menu2) {
        UmaAlert umaAlert;
        if (getCastPlayerFrag() != null) {
            uM.m11540(this, menu);
        } else {
            C1283.m16850("HomeActivity", "onCreateOptionsMenu got null CastPlayerHelper");
        }
        if (!NetflixBottomNavBar.m416()) {
            if (getServiceManager() == null || !getServiceManager().mo9519()) {
                umaAlert = null;
            } else {
                umaAlert = getServiceManager().m9820();
            }
            C2389zu.m13827(this, menu).setVisible(!(umaAlert != null && umaAlert.blocking()));
        }
        super.onCreateOptionsMenu(menu, menu2);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public AbstractC2163su mo10792() {
        return (AbstractC2163su) super.mo10792();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        if (!this.fragmentHelper.mo10705()) {
            if (NetflixBottomNavBar.m416()) {
                mo10792().mo10854(false);
                NetflixActionBar netflixActionBar = getNetflixActionBar();
                if (netflixActionBar != null) {
                    netflixActionBar.m366();
                }
            } else if (this.f10197.isEmpty()) {
                m10760();
            } else {
                m10777(this.f10197.removeLast(), true);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public AbstractC2163su mo10189() {
        PerformanceProfiler.INSTANCE.m663(Sessions.LOLOMO_LOAD);
        if ("lolomo".equals(this.f10188)) {
            return m10776(this.f10188, this.f10192, this.f10188);
        }
        if (this.f10190 == null || !tK.m10965(this.f10190.getId())) {
            if (this.f10192 == null || this.f10192.getGenreType() != GenreList.GenreType.GALLERY) {
                if (!BrowseExperience.m1780() || C0727.m15067() || "1647397".equalsIgnoreCase(this.f10188)) {
                    return m10776(this.f10188, this.f10192, this.f10209);
                }
                if (this.f10204) {
                    return tD.m10890(this.f10188, this.f10192, "Lolomo");
                }
                return tD.m10890(this.f10188, this.f10192, "");
            } else if (this.f10204) {
                return tD.m10890(this.f10188, this.f10192, "Lolomo");
            } else {
                return tD.m10890(this.f10188, this.f10192, "");
            }
        } else if (this.f10204) {
            return tK.m10963(this.f10190, "Lolomo");
        } else {
            return tK.m10963(this.f10190, "");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static tQ m10776(String str, GenreList genreList, String str2) {
        if (C0727.m15067()) {
            return tS.m11022(str2, genreList);
        }
        return tQ.m11003(str, genreList);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return this.f10193;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("extra_back_stack_intents", this.f10197);
        bundle.putParcelable("extra_notification_list_status", this.f10211);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˊ */
    public int mo10187() {
        if (NetflixBottomNavBar.m416()) {
            return R.layout.base_tabs_activity;
        }
        return R.layout.home_activity;
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private void m10756() {
        m10774();
        m13998(mo10189());
        getSupportFragmentManager().beginTransaction().replace(R.id.primary_fragment, mo10792(), "primary").commit();
        getSupportFragmentManager().executePendingTransactions();
        mo10792().onManagerReady(getServiceManager(), AbstractC0367.f13235);
        O_();
    }

    @SuppressLint({"RtlHardcoded"})
    /* renamed from: ʿ  reason: contains not printable characters */
    private void m10760() {
        if (!NetflixBottomNavBar.m416() && this.f10205 != null) {
            if (this.f10205.isDrawerOpen(8388611)) {
                C1364Cj.m4442(UIViewLogging.UIViewCommandName.slidingMenuClosed, getUiScreen().f4084, getDataContext());
                this.f10205.closeDrawers();
                return;
            }
            C1364Cj.m4442(UIViewLogging.UIViewCommandName.slidingMenuOpened, getUiScreen().f4084, getDataContext());
            this.f10205.openDrawer(8388611);
            this.f10212 = true;
        }
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private void m10759() {
        if (!NetflixBottomNavBar.m416() && this.f10205 != null) {
            this.f10205.setDrawerLockMode(1);
        }
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private void m10758() {
        if (!NetflixBottomNavBar.m416() && this.f10205 != null) {
            this.f10205.setDrawerLockMode(0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onConfigureActionBarState(NetflixActionBar.iF.AbstractC0010 r2) {
        r2.mo403(!NetflixBottomNavBar.m416());
        if (!NetflixBottomNavBar.m416() && this.f10197.isEmpty()) {
            r2.mo398(getDrawable(this.f10211.m3370() ? R.drawable.ic_menu_badge : R.drawable.ic_menu));
            r2.mo395(getString(R.string.accessibility_hamburger_menu_name));
        }
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private void m10774() {
        if (this.f10202 != null) {
            this.f10202.mo10811(this.f10192);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m10784(IClientLogging.CompletionReason completionReason) {
        this.f10189 = false;
        HashMap hashMap = new HashMap();
        hashMap.put("reason", completionReason.name());
        if (mo10792() != null) {
            mo10792().m10852(hashMap);
        }
        PerformanceProfiler.INSTANCE.m665(Sessions.TTI, hashMap);
        PerformanceProfiler.INSTANCE.m665(Sessions.LOLOMO_LOAD, hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m10778(IClientLogging.CompletionReason completionReason, Status status) {
        this.f10195 = false;
        getNetflixApplication().m257();
        HashMap hashMap = new HashMap();
        hashMap.put("reason", completionReason.name());
        if (mo10792() != null) {
            mo10792().m10852(hashMap);
        }
        endRenderNavigationLevelSession(completionReason, status);
        PerformanceProfiler.INSTANCE.m665(Sessions.TTR, hashMap);
        PerformanceProfiler.INSTANCE.m668();
        m10764((Context) this);
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.app.Activity
    public void finish() {
        m10796();
        super.finish();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m10796() {
        if (this.f10189) {
            m10784(IClientLogging.CompletionReason.canceled);
        }
        if (this.f10195) {
            m10778(IClientLogging.CompletionReason.canceled, (Status) null);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (isFinishing()) {
            m10796();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˉ  reason: contains not printable characters */
    private void m10762() {
        if (this.f10201) {
            getServiceManager().m9825().mo1504().mo5775("experience=" + String.valueOf(BrowseExperience.m1775()));
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldApplyPaddingToSlidingPanel() {
        return false;
    }

    @Override // o.vT.AbstractC0242
    /* renamed from: ˏ */
    public C0697 mo10390(AbstractC2089qj qjVar) {
        if (getBottomNavBar() != null) {
            return vT.m12042(getBottomNavBar().findViewById(NetflixBottomNavBar.NetflixTab.DOWNLOADS.m442()), this, qjVar);
        }
        return vT.m12042(getNetflixActionBar().m347(), this, qjVar);
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m10768() {
        if (getServiceManager() != null && getServiceManager().m9764() != null) {
            getServiceManager().m9764().mo9475(true);
        }
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private void m10767() {
        registerReceiverWithAutoUnregister(this.f10196, "com.netflix.mediaclient.intent.action.REFRESH_HOME_LOLOMO");
        registerReceiverWithAutoUnregister(this.f10194, "com.netflix.mediaclient.service.ACTION_EXPAND_HOME_CAST_PLAYER");
        if (this.f10202 != null && this.f10202.mo10807()) {
            registerReceiverLocallyWithAutoUnregister(this.f10199, "com.netflix.mediaclient.intent.action.BA_IRIS_NOTIFICATION_LIST_UPDATED");
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public AppView m10799() {
        if (C1349Bv.m4113(this.f10188) && this.f10190 == null) {
            return AppView.browseTitles;
        }
        if ("lolomo".equals(this.f10188)) {
            return AppView.browseTitles;
        }
        return AppView.browseTitlesGallery;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public IClientLogging.ModalView m10800() {
        if (C1349Bv.m4113(this.f10188) && this.f10190 == null) {
            return IClientLogging.ModalView.homeScreen;
        }
        if ("lolomo".equals(this.f10188)) {
            return IClientLogging.ModalView.homeScreen;
        }
        return IClientLogging.ModalView.browseTitles;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.homeScreen;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showNoNetworkOverlayIfNeeded() {
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m10764(Context context) {
        C1283.m16862("HomeActivity", "notifyOthersOfTtrDone");
        if (context != null) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.HOME_TTR_DONE"));
            AR.m3408(context);
        }
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        oB oBVar = new oB("HomeActivity");
        if (!NetflixBottomNavBar.m416() || !this.fragmentHelper.mo10706()) {
            return oBVar;
        }
        return this.fragmentHelper.mo10701();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean hasBottomNavBar() {
        return NetflixBottomNavBar.m416();
    }
}
