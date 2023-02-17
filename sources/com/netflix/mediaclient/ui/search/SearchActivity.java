package com.netflix.mediaclient.ui.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.transition.Transition;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.netflix.cl.Logger;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab8274;
import com.netflix.mediaclient.service.logging.client.model.ActionOnUIError;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.ISearchLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.search.SearchUtils;
import com.netflix.mediaclient.util.log.UIScreen;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import o.AD;
import o.AbstractC1115;
import o.AbstractC1358Cd;
import o.AbstractC2080qa;
import o.C0416;
import o.C0523;
import o.C0567;
import o.C0616;
import o.C0636;
import o.C0727;
import o.C0803;
import o.C1091;
import o.C1276;
import o.C1283;
import o.C1349Bv;
import o.C1362Ch;
import o.C1364Cj;
import o.C2059ph;
import o.C2183tm;
import o.C2384zr;
import o.C2387zt;
import o.oB;
import o.oP;
import o.oV;
import o.oX;
import o.qK;
import o.qN;
import o.tH;
import o.tI;
import o.zA;
public class SearchActivity extends NetflixActivity implements qK {

    /* renamed from: ʻ  reason: contains not printable characters */
    private Runnable f3829;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean f3830 = false;

    /* renamed from: ʼ  reason: contains not printable characters */
    private ViewGroup f3831;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private boolean f3832 = true;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f3833;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private Disposable f3834;

    /* renamed from: ʾ  reason: contains not printable characters */
    private boolean f3835;

    /* renamed from: ʿ  reason: contains not printable characters */
    private final C0567.Cif f3836 = new C0567.Cif() { // from class: com.netflix.mediaclient.ui.search.SearchActivity.4
        @Override // o.C0567.Cif
        public void N_() {
            String str = SearchActivity.this.f3854;
            SearchActivity.this.f3854 = "";
            SearchActivity.this.m2796(str);
        }
    };

    /* renamed from: ˈ  reason: contains not printable characters */
    private View f3837;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0803 f3838;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private long f3839;

    /* renamed from: ˋ  reason: contains not printable characters */
    private SearchResultsFrag f3840;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private final Runnable f3841 = new Runnable() { // from class: com.netflix.mediaclient.ui.search.SearchActivity.5
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16846("SearchActivity", "handleQueryUpdateRunnable: \"" + SearchActivity.this.f3854 + "\", request id: " + SearchActivity.this.f3839);
            if (!C1349Bv.m4113(SearchActivity.this.f3854)) {
                SearchActivity.this.f3842 = true;
                SearchActivity.this.m2797(true);
                C1362Ch.m4415(SearchActivity.this.f3839, (UserActionLogging.CommandName) null, SearchActivity.this.getUiScreen().f4084, SearchActivity.this.f3854);
                SearchActivity.this.f3847.m9764().mo9481(SearchActivity.this.f3854, CmpTaskMode.FROM_CACHE_OR_NETWORK, AD.m3299(), new Cif(SearchActivity.this.f3839));
            }
        }
    };

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f3842;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected C0616 f3843;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C2384zr f3844;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private View f3845;

    /* renamed from: ͺ  reason: contains not printable characters */
    private ViewGroup f3846;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C2059ph f3847;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private ViewGroup f3848;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private long f3849 = -1;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private AtomicBoolean f3850 = new AtomicBoolean(false);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private tI f3851;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private Bundle f3852;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private long f3853;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private String f3854;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Intent m2775(NetflixActivity netflixActivity) {
        Intent action = new Intent(netflixActivity, m2816()).setAction("android.intent.action.VIEW");
        if (netflixActivity.getServiceManager().mo9519() && netflixActivity.getServiceManager().m9826() != null) {
            action.putExtra("isKidsProfile", netflixActivity.getServiceManager().m9826().isKidsProfile());
        }
        return action;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static Class m2816() {
        return NetflixApplication.getInstance().m254() ? PortraitSearchActivity.class : SearchActivity.class;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3852 = bundle;
        SearchUtils.m2920(AD.m3299() ? SearchUtils.SearchExperience.TABLET : SearchUtils.SearchExperience.PHONE);
        this.f3835 = getIntent().getBooleanExtra("isKidsProfile", false);
        m2793(bundle);
        if (bundle == null) {
            this.f3833 = C2387zt.m13818(this.f3839, this, getUiScreen().f4084, this.f3854);
            C2387zt.m13826();
        } else {
            this.f3830 = bundle.getBoolean("search_view_focused_state");
            this.f3833 = bundle.getLong("search_view_sessionid_state");
        }
        if (zA.m13377(this) && bundle == null) {
            m2812();
        }
        m2803(getIntent());
        m2805(findViewById(16908290));
        if (NetflixBottomNavBar.m416()) {
            tH tHVar = new tH(this, bundle);
            this.fragmentHelper = tHVar;
            setFragmentHelper(tHVar);
        }
        m2802();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f3834 != null) {
            this.f3834.dispose();
        }
        if (isFinishing()) {
            C2387zt.m13816(this.f3839, this, this.f3833);
            if (this.f3847 != null) {
                this.f3847.m9764().mo9506();
            }
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (isFinishing()) {
            m2808(false);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f3844 == null || !this.f3844.m13785()) {
            m2811();
        } else {
            this.f3838.m15349();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            bundle = new Bundle();
        }
        NetflixActionBar netflixActionBar = getNetflixActionBar();
        if (!(!(netflixActionBar instanceof C0803) || ((C0803) netflixActionBar).m15346() == null || ((C0803) netflixActionBar).m15346().getQuery() == null)) {
            bundle.putString("search_query", ((C0803) netflixActionBar).m15346().getQuery().toString());
        }
        bundle.putBoolean("search_view_focused_state", this.f3830);
        bundle.putLong("search_view_sessionid_state", this.f3833);
        if (this.f3846 != null) {
            bundle.putInt("search_results_visibility", this.f3846.getVisibility());
        }
        if (this.f3831 != null) {
            bundle.putInt("genres_visibility", this.f3831.getVisibility());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void setTheme() {
        if (shouldShowKidsTheme()) {
            setTheme(hasBottomNavBar() ? R.style.res_2131952234_theme_netflix_kids_search_fullscreen : R.style.res_2131952233_theme_netflix_kids_search);
        } else {
            setTheme(hasBottomNavBar() ? R.style.res_2131952228_theme_netflix_default_search_fullscreen : R.style.res_2131952227_theme_netflix_default_search);
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public int getActionBarParentViewId() {
        if (NetflixBottomNavBar.m416()) {
            return R.id.coordinatorLayout;
        }
        return super.getActionBarParentViewId();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean m2814() {
        return Config_Ab8274.a_(this) && !this.f3835;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2805(final View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.netflix.mediaclient.ui.search.SearchActivity.3

            /* renamed from: ˊ  reason: contains not printable characters */
            private int f3859;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int height = view.getHeight();
                if (this.f3859 != 0) {
                    if (this.f3859 > height + 100) {
                        SearchActivity.this.m2818();
                    } else if (this.f3859 < height) {
                        SearchActivity.this.m2822();
                    }
                }
                this.f3859 = height;
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m2818() {
        ((C0803) getNetflixActionBar()).m15359();
        if (m2814()) {
            ((C0523) getNetflixActionBar()).m14561();
        }
        onPaddingChanged();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m2822() {
        ((C0803) getNetflixActionBar()).m15358();
        if (m2814()) {
            ((C0523) getNetflixActionBar()).m14559();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2793(Bundle bundle) {
        setContentView(R.layout.search_activity);
        m2777(bundle);
        m2770();
        m2799();
        m2772(bundle);
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canShowDownloadProgressBar() {
        return !NetflixBottomNavBar.m416();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canApplyBrowseExperience() {
        return true;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m2770() {
        this.f3846 = (ViewGroup) findViewById(R.id.search_fragment_container);
        if (m2814()) {
            this.f3848 = (ViewGroup) findViewById(R.id.search_prequery_fragment_container);
        }
        this.f3845 = findViewById(R.id.search_activity_outer_container);
        this.f3837 = findViewById(R.id.voice_search_btn);
        this.f3837.setOnClickListener(new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.search.SearchActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchActivity.this.m2812();
            }
        });
        this.f3831 = (ViewGroup) findViewById(R.id.genres_fragment_container);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m2766() {
        return NetflixBottomNavBar.m416() && !C0727.m15067();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m2772(Bundle bundle) {
        if (m2766() && getSupportFragmentManager().findFragmentByTag("GENRES_LIST") == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.genres_fragment_container, new tI(), "GENRES_LIST");
            beginTransaction.commit();
            getSupportFragmentManager().executePendingTransactions();
        }
        if (bundle == null) {
            m2773();
        } else {
            if (bundle.containsKey("search_results_visibility")) {
                this.f3846.setVisibility(bundle.getInt("search_results_visibility"));
            }
            if (bundle.containsKey("genres_visibility")) {
                this.f3831.setVisibility(bundle.getInt("genres_visibility"));
            }
        }
        this.f3840 = (SearchResultsFrag) getSupportFragmentManager().findFragmentById(R.id.search_results_frag);
        this.f3851 = (tI) getSupportFragmentManager().findFragmentByTag("GENRES_LIST");
        FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
        if (m2814()) {
            this.f3844 = (C2384zr) getSupportFragmentManager().findFragmentById(R.id.search_prequery_frag);
            beginTransaction2.show(this.f3844);
        }
        beginTransaction2.show(this.f3840);
        beginTransaction2.commit();
        if (this.f3844 != null) {
            this.f3844.m13786();
        }
        setupCastPlayerFrag(bundle);
        onPaddingChanged();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void bottomTabReselected(NetflixBottomNavBar.NetflixTab netflixTab) {
        this.fragmentHelper.mo10709();
        m2773();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        if (!NetflixBottomNavBar.m416()) {
            super.performUpAction();
        } else if (!this.fragmentHelper.mo10705()) {
            m2773();
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m2799() {
        this.f3843 = new C0616(this.f3845, this.f3836);
        this.f3843.mo14663(false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m2789(long j, AbstractC1115 r5) {
        return j > 0 && !r5.mo15949() && !TextUtils.isEmpty(r5.mo15950()) && !this.f3850.get();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m2802() {
        if (this.f3838 != null) {
            final long r3 = C0636.m14771(this);
            this.f3834 = C1091.m16183(this.f3838.m15346()).doOnNext(new Consumer<AbstractC1115>() { // from class: com.netflix.mediaclient.ui.search.SearchActivity.8
                /* renamed from: ˋ  reason: contains not printable characters */
                public void accept(AbstractC1115 r10) {
                    String charSequence = r10.mo15950().toString();
                    C1283.m16848("SearchActivity", "queryTextChanges: doOnNext '%s'", charSequence);
                    if (SearchActivity.this.f3849 == -1 && SearchActivity.this.m2789(r3, r10)) {
                        SearchActivity.this.f3849 = C2387zt.m13821(SearchActivity.this);
                    }
                    C2387zt.m13817(SearchActivity.this.f3839, SearchActivity.this, SearchActivity.this.getUiScreen().f4084, charSequence, SearchActivity.this.f3850.get() ? ISearchLogging.InputMode.speech : ISearchLogging.InputMode.keyboard, ISearchLogging.SearchType.searchQuery);
                }
            }).debounce(new Function<AbstractC1115, Observable<AbstractC1115>>() { // from class: com.netflix.mediaclient.ui.search.SearchActivity.6
                /* renamed from: ˋ  reason: contains not printable characters */
                public Observable<AbstractC1115> apply(AbstractC1115 r6) {
                    if (SearchActivity.this.m2789(r3, r6)) {
                        C1283.m16848("SearchActivity", "queryTextChanges: debounce delay %d", Long.valueOf(r3));
                        return Observable.empty().delay(r3, TimeUnit.MILLISECONDS);
                    }
                    C1283.m16846("SearchActivity", "queryTextChanges: debounce NOW");
                    SearchActivity.this.f3850.set(false);
                    return Observable.empty();
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<AbstractC1115>() { // from class: com.netflix.mediaclient.ui.search.SearchActivity.1
                /* renamed from: ˊ  reason: contains not printable characters */
                public void accept(AbstractC1115 r6) {
                    String charSequence = r6.mo15950().toString();
                    SearchActivity.this.m2796(charSequence);
                    if (SearchActivity.this.f3849 != -1) {
                        C2387zt.m13823(SearchActivity.this, SearchActivity.this.f3849);
                        SearchActivity.this.f3849 = -1;
                    }
                    if (TextUtils.isEmpty(charSequence) && SearchActivity.this.f3840 != null) {
                        SearchActivity.this.f3840.m2888();
                        SearchActivity.this.f3840.m2890();
                    }
                    if (r6.mo15949()) {
                        SearchActivity.this.f3838.m15349();
                        SearchActivity.this.m2767();
                    }
                }
            }, new Consumer<Throwable>() { // from class: com.netflix.mediaclient.ui.search.SearchActivity.9
                /* renamed from: ॱ  reason: contains not printable characters */
                public void accept(Throwable th) {
                    C1276.m16820().mo5725("RxSearchView.queryTextChanges error");
                }
            });
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2777(Bundle bundle) {
        if (this.f3838 != null) {
            this.f3838.m15350(new View.OnFocusChangeListener() { // from class: com.netflix.mediaclient.ui.search.SearchActivity.7
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    SearchActivity.this.m2808(z);
                }
            });
            if (SearchUtils.m2909()) {
                m2783();
            }
            this.f3832 = (this.f3838.m15356() == null || this.f3838.m15356().getVisibility() == 8) ? false : true;
            if (bundle != null && !TextUtils.isEmpty(bundle.getString("search_query"))) {
                this.f3838.m15355(bundle.getString("search_query"), true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2808(boolean z) {
        if (this.f3830 != z) {
            C1283.m16848("SearchActivity", "reportCLSearchQueryTextFocusChange: %b->%b", Boolean.valueOf(this.f3830), Boolean.valueOf(z));
            this.f3830 = z;
            if (z) {
                this.f3853 = C2387zt.m13811(this.f3839, this, getUiScreen().f4084, this.f3854);
            } else if (this.f3853 != 0) {
                C2387zt.m13812(this.f3839, this, this.f3853);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m2783() {
        this.f3838.m15353(new View.OnTouchListener() { // from class: com.netflix.mediaclient.ui.search.SearchActivity.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                C1283.m16846("SearchActivity", "onTouch triggering query update");
                SearchActivity.this.m2796(SearchActivity.this.f3854);
                if (SearchActivity.this.f3844 == null || !C1349Bv.m4113(SearchActivity.this.f3854)) {
                    return false;
                }
                SearchActivity.this.f3844.m13784();
                return false;
            }
        });
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m2787(Activity activity, String str) {
        activity.startActivity(new Intent(activity, m2816()).setAction("android.intent.action.SEARCH").putExtra("query", str).putExtra("submit", true));
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (NetflixBottomNavBar.m411(intent)) {
            overridePendingTransition(0, 0);
        } else if (this.fragmentHelper.mo10702(intent)) {
            overridePendingTransition(0, 0);
            return;
        }
        setIntent(intent);
        m2803(intent);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public NetflixActionBar createActionBar() {
        C0803 r1;
        if (m2814()) {
            r1 = new C0523(this, this.statusBarBackground);
        } else if (BrowseExperience.m1780()) {
            r1 = new C2183tm(this, this.statusBarBackground);
        } else {
            r1 = new C0803(this, this.statusBarBackground);
        }
        this.f3838 = r1;
        return r1;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onConfigureActionBarState(NetflixActionBar.iF.AbstractC0010 r6) {
        r6.mo396(false).mo399(false).mo391(this.f3838.m15357()).mo388(new ActionBar.LayoutParams(-1, -2, 8388611));
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: com.netflix.mediaclient.ui.search.SearchActivity.13
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                SearchActivity.this.f3847 = phVar;
                if (SearchActivity.this.f3829 != null) {
                    SearchActivity.this.f3829.run();
                }
                if (SearchActivity.this.f3844 != null && SearchActivity.this.m2814()) {
                    SearchActivity.this.f3844.onManagerReady(phVar, status);
                }
                if (SearchActivity.this.f3851 != null) {
                    SearchActivity.this.f3851.onManagerReady(phVar, status);
                }
                if (!SearchActivity.this.f3832) {
                    C1283.m16865("SearchActivity", "SPY-8468 - Voice search not available. The device has no voice search capabilities");
                }
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
            }
        };
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return this.f3842;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2803(Intent intent) {
        if ("android.intent.action.SEARCH".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("query");
            boolean booleanExtra = intent.getBooleanExtra("submit", false);
            this.f3850.set(m2782(intent));
            if (this.f3850.get()) {
                m2767();
                float[] floatArrayExtra = intent.getFloatArrayExtra("android.speech.extra.CONFIDENCE_SCORES");
                Logger.INSTANCE.m127(new C0416(floatArrayExtra == null ? 1.0f : floatArrayExtra[0], stringExtra));
            }
            if (this.f3838 != null) {
                this.f3838.m15355(stringExtra, booleanExtra);
                m2796(stringExtra);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m2782(Intent intent) {
        for (String str : intent.getExtras().keySet()) {
            if (str.startsWith("android.speech.extra")) {
                C1283.m16854("SearchActivity", "Voice search");
                return true;
            }
        }
        C1283.m16865("SearchActivity", "Not voice search?");
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2796(String str) {
        if (str == null || TextUtils.equals(this.f3854, str)) {
            C1283.m16846("SearchActivity", "Skip handleQueryUpdate");
            return;
        }
        this.f3840.m2890();
        this.f3854 = str;
        this.f3839++;
        if (this.f3854.length() == 0) {
            m2773();
        } else if (this.f3854.length() >= 1) {
            this.f3829 = null;
            if (this.f3847 == null) {
                this.f3829 = this.f3841;
            } else {
                this.f3841.run();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m2810() {
        this.f3843.mo14662(R.string.label_no_search_results, false, false);
        this.f3846.setVisibility(4);
        if (NetflixBottomNavBar.m416() && !C0727.m15067()) {
            this.f3831.setVisibility(8);
        }
        if (this.f3848 != null) {
            this.f3848.setVisibility(4);
        }
        m2788(false);
        m2797(false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2820() {
        this.f3843.mo14662(R.string.label_could_not_load_search_results, true, false);
        this.f3846.setVisibility(4);
        if (NetflixBottomNavBar.m416() && !C0727.m15067()) {
            this.f3831.setVisibility(8);
        }
        if (this.f3848 != null) {
            this.f3848.setVisibility(4);
        }
        m2788(false);
        m2797(false);
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m2773() {
        if (NetflixBottomNavBar.m416() && !C0727.m15067()) {
            this.f3831.setVisibility(0);
            this.fragmentHelper.mo10709();
        }
        this.f3846.setVisibility(4);
        if (this.f3848 != null) {
            this.f3848.setVisibility(0);
        }
        m2797(false);
        if (this.f3838 != null) {
            if (!TextUtils.isEmpty(this.f3838.m15346().getQuery())) {
                this.f3838.m15355("", true);
            }
            this.f3838.m15354(m2814() ? getString(R.string.search_netflix) : getString(m2815()));
        }
        boolean r4 = zA.m13376(this);
        m2788(r4);
        if (r4 || m2766()) {
            this.f3843.mo14663(true);
        } else {
            this.f3843.mo14662(m2819(), false, false);
        }
        if (this.f3851 != null) {
            this.f3851.m10954(false);
        }
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m2811() {
        boolean z = false;
        if (C1349Bv.m4113(this.f3854) && !m2766()) {
            z = zA.m13378(this);
            if (this.f3852 != null && this.f3830) {
                z = true;
            }
        }
        m2781(z);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2781(boolean z) {
        if (!z) {
            if (this.f3838 != null) {
                this.f3838.m15349();
            }
            m2767();
        } else if (this.f3838 != null) {
            this.f3838.m15347();
            m2808(true);
            if (!Config_Ab8274.m505(this) || this.f3835) {
                m2767();
            } else {
                AD.m3286((Activity) this);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m2788(boolean z) {
        int i = 8;
        if (z && this.f3832) {
            i = 0;
            this.f3843.mo14663(true);
        }
        this.f3837.setVisibility(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m2812() {
        if (this.f3832) {
            this.f3838.m15356().performClick();
            C1364Cj.m4435(UIViewLogging.UIViewCommandName.search, getUiScreen().f4084, CommandEndedEvent.InputMethod.voice, (CommandEndedEvent.InputValue) null, getDataContext());
            return;
        }
        C1283.m16850("SearchActivity", "Voice search button was clicked but no voice search icon in SearchView to trigger voice search dialog");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public int m2819() {
        return BrowseExperience.m1780() ? R.string.label_search_for_kids_variety : R.string.search_for_variety;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private int m2815() {
        return BrowseExperience.m1780() ? R.string.label_search_for_kids_variety : R.string.search_hint_placeholder;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2780(AbstractC2080qa qaVar) {
        this.f3843.mo14663(false);
        m2788(false);
        this.f3846.setVisibility(0);
        this.f3831.setVisibility(8);
        if (this.f3848 != null) {
            this.f3848.setVisibility(4);
        }
        if (this.f3850.get()) {
            m2767();
        }
        if (this.f3840 != null) {
            this.f3840.m2886(qaVar, this.f3854);
        }
        if (this.f3844 != null) {
            this.f3844.m13786();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m2767() {
        AD.m3309((Activity) this);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        if (m2814() && this.f3844 != null && Config_Ab8274.m504(this) != Config_Ab8274.ListType.SEARCH_HISTORY && !this.f3844.m13785()) {
            this.f3844.m13781();
            this.f3844.m13782(getServiceManager());
            return true;
        } else if (!SearchUtils.m2910() || this.f3840 == null) {
            return super.handleBackPressed();
        } else {
            return this.f3840.m2887();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2797(boolean z) {
        if (this.f3838 == null) {
            return;
        }
        if (z) {
            this.f3838.m15351();
        } else {
            this.f3838.m15352();
        }
    }

    /* renamed from: com.netflix.mediaclient.ui.search.SearchActivity$if  reason: invalid class name */
    class Cif extends oP {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final long f3870;

        public Cif(long j) {
            super("SearchActivity");
            this.f3870 = j;
        }

        @Override // o.oP, o.oU
        public void onSearchResultsFetched(AbstractC2080qa qaVar, Status status) {
            super.onSearchResultsFetched(qaVar, status);
            if (this.f3870 != SearchActivity.this.f3839) {
                C1283.m16846("SearchActivity", "Ignoring stale onSearchResultsFetched callback");
                C1362Ch.m4397(this.f3870, IClientLogging.CompletionReason.canceled, (UIError) null);
                return;
            }
            SearchActivity.this.f3842 = false;
            SearchActivity.this.m2797(false);
            if (status.mo301()) {
                C1283.m16865("SearchActivity", "Invalid status code");
                SearchActivity.this.m2820();
                C1362Ch.m4397(this.f3870, IClientLogging.CompletionReason.failed, AbstractC1358Cd.m4353(status, SearchActivity.this.getString(R.string.label_could_not_load_search_results), ActionOnUIError.displayedError));
            } else if (qaVar == null || !qaVar.hasResults()) {
                C1283.m16846("SearchActivity", "No results from server");
                SearchActivity.this.m2810();
                C1362Ch.m4397(this.f3870, IClientLogging.CompletionReason.success, (UIError) null);
            } else {
                C1283.m16851("SearchActivity", "searchResults size %d ", Integer.valueOf(qaVar.getNumResults()));
                SearchActivity.this.reportUiViewChanged(IClientLogging.ModalView.searchResults);
                SearchActivity.this.m2780(qaVar);
                C1362Ch.m4397(this.f3870, IClientLogging.CompletionReason.success, (UIError) null);
            }
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.search;
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        if (!NetflixBottomNavBar.m416()) {
            return new oB("SearchActivity");
        }
        if (this.fragmentHelper.mo10706()) {
            return this.fragmentHelper.mo10701();
        }
        return qN.f9504;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldApplyPaddingToSlidingPanel() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean hasBottomNavBar() {
        return NetflixBottomNavBar.m416();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void setFragmentsHiddenState(boolean z, Transition transition) {
        super.setFragmentsHiddenState(z, transition);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (!(this.f3840 == null || this.f3840.isHidden() == z)) {
            m2804(beginTransaction, this.f3840, z, transition);
        }
        if (!(this.f3851 == null || this.f3851.isHidden() == z)) {
            m2804(beginTransaction, this.f3851, z, transition);
        }
        if (!(this.f3844 == null || this.f3844.isHidden() == z)) {
            m2804(beginTransaction, this.f3844, z, transition);
        }
        beginTransaction.commitNowAllowingStateLoss();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2804(FragmentTransaction fragmentTransaction, Fragment fragment, boolean z, Transition transition) {
        if (z) {
            fragment.setExitTransition(transition);
            fragmentTransaction.hide(fragment);
            return;
        }
        fragment.setEnterTransition(transition);
        fragmentTransaction.show(fragment);
        m2821();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m2821() {
        NetflixActionBar netflixActionBar;
        if (!this.fragmentHelper.mo10706() && (netflixActionBar = getNetflixActionBar()) != null) {
            netflixActionBar.m355(getActionBarStateBuilder().mo392());
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onPaddingChanged() {
        super.onPaddingChanged();
        if (this.f3840 != null) {
            setFragmentPadding(this.f3840);
        }
        if (this.f3851 != null) {
            setFragmentPadding(this.f3851);
        }
        if (this.f3844 != null) {
            setFragmentPadding(this.f3844);
        }
        this.f3843.mo14659(0, getStatusBarHeight() + getActionBarHeight(), 0, getBottomNavBarHeight());
    }
}
