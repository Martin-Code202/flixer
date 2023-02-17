package com.netflix.mediaclient.android.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.transition.Transition;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowInsets;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import com.google.android.gms.cast.framework.CastContext;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IMdxSharedState;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.launch.LaunchActivity;
import com.netflix.mediaclient.ui.offline.DownloadSummaryListener;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.ViewUtils;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.mediaclient.util.log.UIScreen;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import o.AD;
import o.AJ;
import o.AU;
import o.AbstractC0367;
import o.AbstractC0459;
import o.AbstractC0517;
import o.AbstractC1180;
import o.AbstractC1268;
import o.AbstractC1853hl;
import o.AbstractC2057pf;
import o.AbstractC2143se;
import o.ActivityC1313Ao;
import o.ActivityC2153sl;
import o.ActivityC2187tq;
import o.ActivityC2194tx;
import o.ActivityC2280wv;
import o.ActivityC2383zq;
import o.BJ;
import o.BW;
import o.BX;
import o.C0354;
import o.C0368;
import o.C0369;
import o.C0383;
import o.C0505;
import o.C0649;
import o.C0650;
import o.C0727;
import o.C0782;
import o.C0828;
import o.C0842;
import o.C0893;
import o.C0903;
import o.C1004;
import o.C1224;
import o.C1276;
import o.C1278;
import o.C1283;
import o.C1298Aa;
import o.C1300Ac;
import o.C1305Ag;
import o.C1306Ah;
import o.C1317As;
import o.C1322Av;
import o.C1359Ce;
import o.C1362Ch;
import o.C1364Cj;
import o.C1366Cl;
import o.C1425Eo;
import o.C1698eK;
import o.C1841h;
import o.C2018nv;
import o.C2020nx;
import o.C2059ph;
import o.C2237vg;
import o.DialogC1104;
import o.DialogC2233vc;
import o.oH;
import o.oN;
import o.oV;
import o.oX;
import o.pF;
import o.qH;
import o.qL;
import o.qN;
import o.qO;
import o.rU;
import o.uL;
import o.uU;
import o.uY;
import o.vA;
import o.vT;
import o.zN;
@SuppressLint({"DefaultLocale"})
public abstract class NetflixActivity extends AppCompatActivity implements qO.AbstractC0170, AbstractC0459, C2237vg.AbstractC0246, C1305Ag.AbstractC0066 {
    private static final long ACTION_BAR_VISIBILITY_CHECK_DELAY_MS = 1000;
    private static final String ACTION_FINISH_ALL_ACTIVITIES = "com.netflix.mediaclient.ui.login.ACTION_FINISH_ALL_ACTIVITIES";
    public static final String CAST_PLAYER_FRAG_TAG = "cast_player";
    public static int DL_REQUEST_CODE = 3;
    public static final String EXTRA_DL_PLAYABLE_ID = "extra_download_playableId";
    public static final String EXTRA_DL_VIDEO_TYPE_STRING = "extra_download_videoType_string";
    public static final String EXTRA_ENABLE_TRANSITION_ANIMATION = "com.netflix.mediaclient._TRANSITION_ANIMATION";
    public static final String EXTRA_ENTRY = "entry";
    public static final String EXTRA_EXPAND_CAST_PLAYER = "expandCastPlayer";
    public static final String EXTRA_FROM = "from";
    private static final String EXTRA_IS_MDX_CONNECTING = "mdx_connecting";
    public static final String EXTRA_PLAY_CONTEXT = "extra_play_context";
    private static final String EXTRA_SHOULD_EXPAND_CAST_PLAYER = "cast_player_expanded";
    public static final String EXTRA_SOURCE = "source";
    public static final String EXTRA_VIDEO_ID = "extra_video_id";
    public static final String EXTRA_VIDEO_TYPE_STRING_VALUE = "extra_video_type_string_value";
    public static final String FRAG_DIALOG_TAG = "frag_dialog";
    private static final String INSTANCE_STATE_SAVED_TAG = "NetflixActivity_instanceState";
    private static Set<Class> LANDSCAPE_ACTIVITIES = new HashSet();
    public static final int PERMISSIONS_WRITE_EXTERNAL_STORAGE = 1;
    private static final AbstractC2057pf PREPARE_HELPER_NO_OP = new qL();
    private static final boolean PRINT_LOADING_STATUS = false;
    private static final String TAG = "NetflixActivity";
    private static boolean hasShownEndpointLatch = false;
    private static boolean isTutorialOn = true;
    private int actionBarHeight;
    vA activityPageOfflineAgentListener;
    private final Set<BroadcastReceiver> autoUnregisterLocalReceivers = new HashSet();
    private final Set<BroadcastReceiver> autoUnregisterReceivers = new HashSet();
    private final BroadcastReceiver autokillReceiver = new BroadcastReceiver() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (NetflixActivity.this.getBottomNavBar() != null) {
                NetflixActivity.this.getBottomNavBar().m433();
            }
            NetflixActivity.this.finish();
        }
    };
    private uU castPlayerFrag;
    private final BroadcastReceiver closeCastPlayerReceiver = new BroadcastReceiver() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.6
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!C1317As.m3750(NetflixActivity.this)) {
                if (intent == null || !"com.netflix.mediaclient.service.ACTION_CLOSE_CAST_PLAYER".equals(intent.getAction())) {
                    C1283.m16853(NetflixActivity.TAG, "Invalid intent: ", intent);
                } else {
                    NetflixActivity.this.notifyCastPlayerEndOfPostPlay();
                }
            }
        }
    };
    private String currentTrackerId = "";
    private final BroadcastReceiver expandCastPlayerReceiver = new BroadcastReceiver() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!C1317As.m3750(NetflixActivity.this)) {
                if (intent == null || !"com.netflix.mediaclient.service.ACTION_EXPAND_CAST_PLAYER".equals(intent.getAction())) {
                    C1283.m16853(NetflixActivity.TAG, "Invalid intent: ", intent);
                } else {
                    NetflixActivity.this.expandCastPlayerIfVisible();
                }
            }
        }
    };
    protected AbstractC2143se fragmentHelper = AbstractC2143se.f10137;
    protected Handler handler;
    private boolean hasSavedInstance;
    protected final AtomicBoolean instanceStateSaved = new AtomicBoolean(false);
    private boolean isVisible;
    private WindowInsets lastWindowInsets;
    private final BroadcastReceiver localBroadcastReceiver = new BroadcastReceiver() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.17
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (!NetflixActivity.this.isFinishing() && (action = intent.getAction()) != null) {
                char c = 65535;
                switch (action.hashCode()) {
                    case 1272812214:
                        if (action.equals("com.netflix.mediaclient.ui.cs.ACTION_CALL_ENDED")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1439017466:
                        if (action.equals("com.netflix.mediaclient.ui.error.ACTION_DISPLAY_ERROR")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        NetflixActivity.this.handleErrorDialog();
                        return;
                    case 1:
                        NetflixActivity.this.handleCustomerSupportCallEnded();
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private FloatingActionButton mBackToCustomerSupportCallFAB;
    protected Application.ActivityLifecycleCallbacks mCallback;
    private boolean mConnectingToTarget = false;
    protected AtomicLong mDialogCount = new AtomicLong(1);
    private DismissingDialogConfig mDismissingDialogConfiguration = DismissingDialogConfig.dismissOnStop;
    protected String mErrorDialogId;
    private CoordinatorLayout mFabAnchor;
    protected MenuItem mHelpMenuItem;
    protected boolean mIsTablet = false;
    protected AbstractC0459.AbstractC0460 mLoadingStatusCallback;
    private boolean mMdxStatusUpdated = false;
    protected Long mNavigationSessionId;
    private RelativeLayout mNoNetworkOverlay;
    private final LinkedList<If> mPendingServiceManagerRunnable = new LinkedList<>();
    private AbstractC2057pf mPrepareHelper = PREPARE_HELPER_NO_OP;
    protected Map<String, Long> mPresentationSessionMap = new ConcurrentHashMap();
    private final LinkedList<PopupMenu> mShownPopupMenus = new LinkedList<>();
    protected C0649 navBarBackground;
    private NetflixActionBar netflixActionBar;
    private final SlidingUpPanelLayout.iF panelSlideListener = new SlidingUpPanelLayout.iF() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.14
        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.iF
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo279(View view, float f) {
            if (NetflixActivity.this.castPlayerFrag != null) {
                NetflixActivity.this.castPlayerFrag.mo11492(f);
            }
            float f2 = 0.3f;
            if (NetflixActivity.this.actionBarHeight > 0 && view != null && view.getMeasuredHeight() > 0) {
                f2 = ((float) NetflixActivity.this.actionBarHeight) / ((float) view.getMeasuredHeight());
            }
            if (f <= f2) {
                NetflixActivity.this.hideActionBar();
            } else {
                NetflixActivity.this.showActionBar();
            }
            NetflixActivity.this.applySlidePanelOffsetToBottomBar(f);
        }

        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.iF
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo278(View view) {
            C1283.m16846(NetflixActivity.TAG, "onPanelExpanded");
            NetflixActivity.this.onSlidingPanelExpanded(view);
            if (NetflixActivity.this.castPlayerFrag != null) {
                NetflixActivity.this.castPlayerFrag.mo11484();
            }
        }

        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.iF
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo280(View view) {
            C1283.m16846(NetflixActivity.TAG, "onPanelCollapsed");
            NetflixActivity.this.onSlidingPanelCollapsed(view);
            if (NetflixActivity.this.castPlayerFrag != null) {
                NetflixActivity.this.castPlayerFrag.mo11481();
            }
        }

        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.iF
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo281(View view) {
            C1283.m16846(NetflixActivity.TAG, "onPanelAnchored");
        }
    };
    private final Runnable printLoadingStatusRunnable = new Runnable() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.9
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private C0903 renderSession;
    private final C2059ph serviceManager = new C2059ph();
    private C1425Eo shakeDetector;
    private boolean shouldExpandCastPlayer;
    protected SlidingUpPanelLayout slidingPanel;
    protected C0828 statusBarBackground;
    protected int systemNavBarHeight;
    private vT tutorialHelper = vT.f11250;
    private final Runnable updateActionBarVisibilityRunnable = new Runnable() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.13
        @Override // java.lang.Runnable
        public void run() {
            if (!C1317As.m3750(NetflixActivity.this) && NetflixActivity.this.castPlayerFrag != null && NetflixActivity.this.slidingPanel != null) {
                if (!NetflixActivity.this.castPlayerFrag.mo11497() || !NetflixActivity.this.slidingPanel.m3218()) {
                    NetflixActivity.this.showActionAndBottomBars();
                } else {
                    NetflixActivity.this.hideActionAndBottomBars();
                }
            }
        }
    };
    private final BroadcastReceiver userAgentUpdateReceiver = new BroadcastReceiver() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.12
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                m277("Null intent");
                return;
            }
            String action = intent.getAction();
            if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_ACTIVE".equals(action)) {
                m277("User profile activated - restarting app");
                C1306Ah.m3615().m3621();
                NetflixActivity.this.handleProfileActivated();
            } else if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE".equals(action)) {
                m277("Account deactivated - restarting app");
                NetflixActivity.this.handleAccountDeactivated();
            } else if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_READY_TO_SELECT".equals(action)) {
                m277("Ready to select profile - calling children");
                NetflixActivity.this.handleProfileReadyToSelect();
            } else if ("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_SELECTION_RESULT".equals(action)) {
                int intExtra = intent.getIntExtra("com.netflix.mediaclient.intent.action.EXTRA_USER_PROFILE_SELECTION_RESULT_INT", StatusCode.OK.m271());
                String stringExtra = intent.getStringExtra("com.netflix.mediaclient.intent.action.EXTRA_USER_PROFILE_SELECTION_RESULT_STRING");
                m277("Profile selection status: " + intExtra);
                NetflixActivity.this.handleProfileSelectionResult(intExtra, stringExtra);
            } else if ("com.netflix.mediaclient.intent.action.NOTIFY_PROFILES_LIST_UPDATED".equals(action)) {
                m277("Profiles list updated!");
                NetflixActivity.this.handleProfilesListUpdated();
            } else if ("com.netflix.mediaclient.intent.action.NOTIFY_CURRENT_PROFILE_INVALID".equals(action)) {
                m277("current profile is invalid");
                NetflixActivity.this.handleInvalidCurrentProfile();
            } else if ("com.netflix.mediaclient.intent.action.NOTIFY_AUTOLOGIN_TOKEN_CREATED".equals(action)) {
                m277("Received autologin token");
                NetflixActivity.this.handleDisplayToken(intent);
            } else {
                m277("No action taken for intent: " + action);
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private void m277(String str) {
        }
    };
    protected Dialog visibleDialog;
    protected final Object visibleDialogLock = new Object();

    public enum DismissingDialogConfig {
        dismissOnStop,
        doNotDismissOnStop,
        doNotDismissOnStopOnce
    }

    public abstract UIScreen getUiScreen();

    static {
        LANDSCAPE_ACTIVITIES.add(ActivityC2280wv.class);
        LANDSCAPE_ACTIVITIES.add(rU.class);
    }

    public static void setTutorialOn(boolean z) {
    }

    public static boolean isTutorialOn() {
        return isTutorialOn;
    }

    public void mdxStatusUpdatedByMdxReceiver() {
        this.mMdxStatusUpdated = true;
    }

    public boolean wasMdxStatusUpdatedByMdxReceiver() {
        try {
            return this.mMdxStatusUpdated;
        } finally {
            this.mMdxStatusUpdated = false;
        }
    }

    public void sendIntentToNetflixService(Intent intent) {
        if (this.serviceManager.mo9519()) {
            this.serviceManager.m9815(intent);
        } else {
            C1276.m16820().mo5730(new IllegalStateException("trying to send intent while serviceManager is not ready"));
        }
    }

    public static abstract class If {
        public abstract void run(C2059ph phVar);

        public void notAvailable(C2059ph phVar) {
        }

        public void isBinding() {
        }
    }

    public void setLifeCycleListener(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mCallback = activityLifecycleCallbacks;
    }

    public static void finishAllActivities(Context context) {
        context.sendBroadcast(new Intent(ACTION_FINISH_ALL_ACTIVITIES));
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        NetflixBottomNavBar bottomNavBar = getBottomNavBar();
        if (bottomNavBar == null) {
            overridePendingTransitionAnimation(getReEnterTransitionAnimation(), getSlidingRightOutTransition());
        } else if (!bottomNavBar.m432()) {
            overridePendingTransitionAnimation(getReEnterTransitionAnimation(), getSlidingRightOutTransition());
        }
    }

    private int getExitTransitionAnimation() {
        return R.anim.anim_scale_down;
    }

    private int getReEnterTransitionAnimation() {
        return R.anim.anim_scale_up;
    }

    public vT getTutorialHelper() {
        return this.tutorialHelper;
    }

    /* access modifiers changed from: protected */
    public void setupCastPlayerFrag(Bundle bundle) {
        View findViewById = findViewById(R.id.cast_player_fragment);
        if (findViewById != null) {
            findViewById.getLayoutParams().width = AD.m3317(this);
            if (bundle == null) {
                C1283.m16862(TAG, "creating CastPlayerControlsFrag");
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                this.castPlayerFrag = new uL();
                beginTransaction.replace(R.id.cast_player_fragment, (Fragment) this.castPlayerFrag, CAST_PLAYER_FRAG_TAG);
                beginTransaction.commitAllowingStateLoss();
            } else {
                C1283.m16862(TAG, "re-using CastPlayerControlsFrag");
                this.castPlayerFrag = (uL) getSupportFragmentManager().findFragmentByTag(CAST_PLAYER_FRAG_TAG);
            }
            if (this.castPlayerFrag != null) {
                this.castPlayerFrag.mo11493(new uU.If() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.4
                    @Override // o.uU.If
                    /* renamed from: ˏ  reason: contains not printable characters */
                    public void mo284(int i) {
                        NetflixActivity.this.slidingPanel.setPanelHeight(NetflixActivity.this.getCollapsedCastHeight());
                    }
                });
            }
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme();
        setupWindow();
        super.onCreate(bundle);
        setInstanceStateSaved(false);
        this.actionBarHeight = ViewUtils.m3006(this);
        this.hasSavedInstance = bundle != null;
        this.shouldExpandCastPlayer = bundle != null && bundle.getBoolean(EXTRA_SHOULD_EXPAND_CAST_PLAYER, false);
        this.mConnectingToTarget = bundle != null && bundle.getBoolean(EXTRA_IS_MDX_CONNECTING, false);
        registerFinishReceiverWithAutoUnregister(ACTION_FINISH_ALL_ACTIVITIES);
        registerReceiverWithAutoUnregister(this.expandCastPlayerReceiver, "com.netflix.mediaclient.service.ACTION_EXPAND_CAST_PLAYER");
        registerReceiverWithAutoUnregister(this.closeCastPlayerReceiver, "com.netflix.mediaclient.service.ACTION_CLOSE_CAST_PLAYER");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.netflix.mediaclient.ui.error.ACTION_DISPLAY_ERROR");
        intentFilter.addAction("com.netflix.mediaclient.ui.cs.ACTION_CALL_ENDED");
        registerReceiverLocallyWithAutoUnregister(this.localBroadcastReceiver, intentFilter);
        if (C0893.m15613()) {
            CastContext.getSharedInstance(this);
        }
        setupServiceManager();
        if (getRequestedOrientation() == -1 && NetflixApplication.getInstance().m254() && !LANDSCAPE_ACTIVITIES.contains(getClass())) {
            C1276.m16820().mo5727(String.format("%s :: Activity should have been locked to portrait ", getClass().getSimpleName()));
        }
        this.handler = new Handler();
        if (C1317As.m3758() >= 23) {
            setAssistBlocked(findViewById(16908290), true);
        }
        if (this.mCallback != null) {
            this.mCallback.onActivityCreated(this, bundle);
        }
        if (hasBottomNavBar()) {
            overridePendingTransition(0, 0);
        } else {
            overridePendingTransitionAnimation(getSlidingRightInTransition(), getExitTransitionAnimation());
        }
    }

    /* access modifiers changed from: protected */
    public void setupWindow() {
        if (getTheme().resolveAttribute(R.attr.netflixStatusBarColor, new TypedValue(), false)) {
            int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            if (!shouldShowKidsTheme()) {
                systemUiVisibility |= 512;
            } else if (Build.VERSION.SDK_INT >= 26) {
                systemUiVisibility |= 528;
            }
            getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility | 256 | 1024);
        }
    }

    public void setTheme() {
        if (!canApplyBrowseExperience()) {
            return;
        }
        if (shouldShowKidsTheme()) {
            setTheme(hasBottomNavBar() ? R.style.res_2131952236_theme_netflix_light_fullscreen : R.style.res_2131952235_theme_netflix_light);
        } else {
            setTheme(hasBottomNavBar() ? R.style.res_2131952222_theme_netflix_default_fullscreen : R.style.res_2131952221_theme_netflix_default);
        }
    }

    public boolean handleIntentInternally(Intent intent) {
        return this.fragmentHelper.mo10702(intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityApi16, android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!handleIntentInternally(intent)) {
            super.startActivityForResult(intent, i, bundle);
        }
    }

    public boolean allowTransitionAnimation() {
        return getIntent() == null || getIntent().getBooleanExtra(EXTRA_ENABLE_TRANSITION_ANIMATION, true);
    }

    private void overridePendingTransitionAnimation(int i, int i2) {
        if (allowTransitionAnimation()) {
            overridePendingTransition(i, i2);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (shouldSetIntentOnNewIntent()) {
            setIntent(intent);
        }
        super.onNewIntent(intent);
        if (hasBottomNavBar() && NetflixBottomNavBar.m411(intent)) {
            overridePendingTransition(0, 0);
        }
    }

    public boolean shouldSetIntentOnNewIntent() {
        return true;
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || !AD.f4277) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || !AD.f4277) {
            return super.onKeyUp(i, keyEvent);
        }
        openOptionsMenu();
        return true;
    }

    private void setAssistBlocked(View view, boolean z) {
        try {
            View.class.getMethod("setAssistBlocked", Boolean.TYPE).invoke(view, Boolean.valueOf(z));
        } catch (Exception e) {
            C1283.m16850(TAG, "Couldn't execute setAssistBlocked method. Got exception: " + e);
        }
    }

    /* access modifiers changed from: protected */
    public void setupServiceManager() {
        this.serviceManager.m9769(new C0007(createManagerStatusListener(), isComingFromBackground()));
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.fragmentHelper.mo10706()) {
            reportCL1NavigationSessionStart(getUiScreen());
        }
        this.castPlayerFrag = (uU) getSupportFragmentManager().findFragmentByTag(CAST_PLAYER_FRAG_TAG);
        initSlidingPanel();
        if (this.mCallback != null) {
            this.mCallback.onActivityStarted(this);
        }
    }

    @SuppressLint({"MissingPermission"})
    private void activateShakeForDebug() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateInsets() {
        if (this.lastWindowInsets != null) {
            this.systemNavBarHeight = C0354.m13960(this.slidingPanel) ? 0 : this.lastWindowInsets.getSystemWindowInsetBottom();
            if (this.slidingPanel != null) {
                if (isCastPlayerShowing()) {
                    this.slidingPanel.setPanelHeight(C0354.m13960(this.slidingPanel) ? 0 : getCollapsedCastHeight());
                }
                if (C0354.m13960(this.slidingPanel)) {
                    this.slidingPanel.setPadding(0, 0, 0, 0);
                } else {
                    this.slidingPanel.setPadding(this.lastWindowInsets.getSystemWindowInsetLeft(), 0, this.lastWindowInsets.getSystemWindowInsetRight(), this.systemNavBarHeight);
                }
            }
            onPaddingChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void initSlidingPanel() {
        this.slidingPanel = (SlidingUpPanelLayout) findViewById(R.id.sliding_panel);
        if (this.slidingPanel != null) {
            this.slidingPanel.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.23
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    NetflixActivity.this.lastWindowInsets = new WindowInsets(windowInsets);
                    NetflixActivity.this.updateInsets();
                    return windowInsets;
                }
            });
            this.slidingPanel.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.24
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    NetflixActivity.this.updateInsets();
                }
            });
            if (hasCastPlayerFrag()) {
                this.slidingPanel.setDragView(this.castPlayerFrag.mo11480());
                this.slidingPanel.setPanelHeight(getCollapsedCastHeight());
                this.slidingPanel.setPanelSlideListener(this.panelSlideListener);
                if (shouldApplyPaddingToSlidingPanel()) {
                    View childAt = this.slidingPanel.getChildAt(0);
                    childAt.setPadding(childAt.getPaddingLeft(), this.actionBarHeight, childAt.getPaddingRight(), childAt.getPaddingBottom());
                    return;
                }
                return;
            }
            this.slidingPanel.setPanelHeight(0);
        }
    }

    private boolean hasCastPlayerFrag() {
        return (this.castPlayerFrag == null || this.castPlayerFrag.mo11480() == null) ? false : true;
    }

    public void setSlidingEnabled(boolean z) {
        if (this.slidingPanel != null) {
            this.slidingPanel.setSlidingEnabled(z);
        }
    }

    public boolean shouldApplyPaddingToSlidingPanel() {
        return true;
    }

    public boolean shouldAttachToolbar() {
        return true;
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        contentViewSetup();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        contentViewSetup();
    }

    /* access modifiers changed from: protected */
    public void contentViewSetup() {
        if (shouldAddSystemBarBackgroundViews()) {
            initStatusBarBackground();
            initNavBarBackground();
        }
        if (shouldAttachToolbar()) {
            initToolbar();
        }
        addDebugOverlay();
    }

    /* access modifiers changed from: protected */
    public void initStatusBarBackground() {
        ViewGroup viewGroup = (ViewGroup) findViewById(getActionBarParentViewId());
        this.statusBarBackground = (C0828) getLayoutInflater().inflate(R.layout.status_bar_background, viewGroup, false);
        if (viewGroup != null) {
            viewGroup.addView(this.statusBarBackground);
            this.statusBarBackground.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.22
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    NetflixActivity.this.onPaddingChanged();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void initNavBarBackground() {
        ViewGroup viewGroup = (ViewGroup) findViewById(getActionBarParentViewId());
        this.navBarBackground = (C0649) getLayoutInflater().inflate(R.layout.nav_bar_background, viewGroup, false);
        if (viewGroup != null) {
            viewGroup.addView(this.navBarBackground);
        }
    }

    public void addDebugOverlay() {
    }

    public AbstractC2143se getFragmentHelper() {
        return this.fragmentHelper;
    }

    public void setFragmentHelper(AbstractC2143se seVar) {
        this.fragmentHelper = seVar;
        this.fragmentHelper.mo10707(getStatusBarHeight(), this.actionBarHeight, getFragmentBottomPadding());
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (hasBottomNavBar() && getBottomNavBar() != null) {
            getBottomNavBar().setOnTabReselectedListener(new C0369.AbstractC0370() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.25
                @Override // o.C0369.AbstractC0370
                /* renamed from: ˎ  reason: contains not printable characters */
                public void mo282(C0383 r4) {
                    NetflixBottomNavBar.NetflixTab r2 = NetflixBottomNavBar.NetflixTab.m438(r4.m14144());
                    if (r2 != null) {
                        C1364Cj.m4447(r2.m439(), null);
                    }
                    NetflixActivity.this.bottomTabReselected(r2);
                }
            });
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 232:
                if (iArr.length > 0 && iArr[0] == 0) {
                    PerformanceProfiler.INSTANCE.m671(this);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        NetflixApplication netflixApplication = (NetflixApplication) getApplication();
        NetflixApplication.m218();
        if (isComingFromBackground()) {
            onFromBackground();
        }
        setInstanceStateSaved(false);
        netflixApplication.m249(this);
        this.isVisible = true;
        this.handler.post(this.printLoadingStatusRunnable);
        netflixApplication.m235();
        addFab();
        displayNoNetworkOverlay();
        if (this.mCallback != null) {
            this.mCallback.onActivityResumed(this);
        }
        setupOfflineAgentListener();
        if (hasBottomNavBar()) {
            runWhenManagerIsReady(new If() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.21
                @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                public void run(C2059ph phVar) {
                    AJ.m3358(phVar);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void initToolbar() {
        this.netflixActionBar = createActionBar();
        this.netflixActionBar.m355(getActionBarStateBuilder().mo392());
    }

    private void onFromBackground() {
        showCastPlayerPostPlayOnResume();
        this.serviceManager.m9836();
    }

    /* access modifiers changed from: protected */
    public void showCastPlayerPostPlayOnResume() {
        IMdxSharedState sharedState;
        BJ.C0067 r4;
        if (C1298Aa.m3504(this.serviceManager) && (sharedState = getSharedState()) != null && !TextUtils.isEmpty(sharedState.mo1521()) && (this.serviceManager.m9811() instanceof C1698eK) && (r4 = ((C1698eK) this.serviceManager.m9811()).m6174()) != null && r4.f4578 != null) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_TITLE_NEXT");
            intent.putExtra("id", r4.f4578);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
            uL.m11460(this);
        }
    }

    /* access modifiers changed from: protected */
    public IMdxSharedState getSharedState() {
        return this.serviceManager.m9811().mo6191();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (this.castPlayerFrag != null) {
            this.castPlayerFrag.mo11488();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        NetflixApplication netflixApplication = (NetflixApplication) getApplication();
        NetflixApplication.m220();
        netflixApplication.m247(this);
        this.isVisible = false;
        this.handler.removeCallbacks(this.printLoadingStatusRunnable);
        netflixApplication.m238();
        if (this.mCallback != null) {
            this.mCallback.onActivityPaused(this);
        }
        removeOfflineAgentListener();
    }

    private void removeOfflineAgentListener() {
        C2059ph serviceManager2 = getServiceManager();
        if (serviceManager2 != null && serviceManager2.mo9519() && serviceManager2.m9824() && this.activityPageOfflineAgentListener != null) {
            serviceManager2.m9832().mo7135(this.activityPageOfflineAgentListener);
        }
    }

    public void dismissAllVisibleDialog() {
        try {
            if (this.visibleDialog != null) {
                this.visibleDialog.dismiss();
            }
        } catch (Throwable th) {
            C1283.m16847(TAG, "Failed to dismiss dialog!", th);
        }
        this.visibleDialog = null;
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        if (shouldReportNavigationActionEndedOnStop()) {
            reportCL1NavigationSessionEnded(getUiScreen());
        }
        synchronized (this.visibleDialogLock) {
            if (shouldDismissVisibleDialog()) {
                try {
                    this.visibleDialog.dismiss();
                } catch (Throwable th) {
                    C1283.m16847(TAG, "Failed to dismiss dialog!", th);
                }
                this.visibleDialog = null;
            }
        }
        reportPresentationSessionEnded(AppView.errorDialog);
        String str = this.mErrorDialogId;
        if (str != null) {
            reportUiModelessViewSessionEnded(IClientLogging.ModalView.errorDialog, str);
            this.mErrorDialogId = null;
        }
        super.onStop();
        if (this.mCallback != null) {
            this.mCallback.onActivityStopped(this);
        }
    }

    private boolean isErrorDialogVisible() {
        return this.mPresentationSessionMap.get(AppView.errorDialog.name()) != null;
    }

    private Long removePresentationSessionId(AppView appView) {
        if (appView != null) {
            return this.mPresentationSessionMap.remove(appView.name());
        }
        return null;
    }

    private boolean shouldDismissVisibleDialog() {
        if (isErrorDialogVisible()) {
            return false;
        }
        boolean z = this.visibleDialog != null;
        if (this.mDismissingDialogConfiguration == null) {
            this.mDismissingDialogConfiguration = DismissingDialogConfig.dismissOnStop;
            return z;
        }
        switch (this.mDismissingDialogConfiguration) {
            case dismissOnStop:
                return z;
            case doNotDismissOnStop:
                return false;
            case doNotDismissOnStopOnce:
                this.mDismissingDialogConfiguration = DismissingDialogConfig.dismissOnStop;
                return false;
            default:
                return false;
        }
    }

    public boolean shouldReportNavigationActionEndedOnStop() {
        return !this.fragmentHelper.mo10706();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ((NetflixApplication) getApplication()).m247(this);
        for (BroadcastReceiver broadcastReceiver : this.autoUnregisterReceivers) {
            unregisterReceiver(broadcastReceiver);
        }
        for (BroadcastReceiver broadcastReceiver2 : this.autoUnregisterLocalReceivers) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver2);
        }
        cleanUpInteractiveTrackers();
        if (this.serviceManager != null) {
            this.serviceManager.m9799();
        }
        this.mPendingServiceManagerRunnable.clear();
        super.onDestroy();
        if (this.mCallback != null) {
            this.mCallback.onActivityDestroyed(this);
        }
        AbstractC1180.m16408();
    }

    public boolean handleBackPressed() {
        return false;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public final void onBackPressed() {
        if (!getSupportFragmentManager().isStateSaved()) {
            uU castPlayerFrag2 = getCastPlayerFrag();
            if (castPlayerFrag2 != null && castPlayerFrag2.V_()) {
                return;
            }
            if (this.slidingPanel == null || castPlayerFrag2 == null || !this.slidingPanel.m3219() || !this.slidingPanel.m3218() || !castPlayerFrag2.isVisible()) {
                if (!this.fragmentHelper.mo10704() && !handleBackPressed()) {
                    C1300Ac.m3529();
                    C1364Cj.m4442(UIViewLogging.UIViewCommandName.backButton, getUiScreen().f4084, getDataContext());
                    try {
                        super.onBackPressed();
                    } catch (IllegalStateException e) {
                        C1283.m16855(TAG, "Error handling onBackPressed", e);
                    }
                }
            } else if (isDialogFragmentVisible()) {
                removeDialogFrag();
            } else {
                this.slidingPanel.m3213();
            }
        }
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        if (this.fragmentHelper.mo10706()) {
            this.fragmentHelper.mo10703(menu, null);
        } else {
            onCreateOptionsMenu(menu, null);
        }
        if (showHelpInMenu()) {
            this.mHelpMenuItem = menu.add(0, R.id.menu_help, 0, getString(R.string.label_help));
            this.mHelpMenuItem.setShowAsAction(1);
            Intent r5 = ActivityC1313Ao.m3721(this);
            UIScreen uiScreen = getUiScreen();
            if (uiScreen != null) {
                r5.putExtra(EXTRA_SOURCE, uiScreen.name());
            }
            if (getEntryPoint() != null) {
                r5.putExtra(EXTRA_ENTRY, getEntryPoint().name());
            }
            this.mHelpMenuItem.setIntent(r5);
            if (getServiceManager().mo9519() && getServiceManager().m9823() != null) {
                this.mHelpMenuItem.setVisible(getServiceManager().m9823().mo9649());
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void onCreateOptionsMenu(Menu menu, Menu menu2) {
    }

    public CustomerServiceLogging.EntryPoint getEntryPoint() {
        return null;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null) {
            if (this.netflixActionBar != null && this.netflixActionBar.m352(menuItem)) {
                return true;
            }
            if (this.fragmentHelper.mo10706()) {
                return this.fragmentHelper.mo10710(menuItem);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // o.C2237vg.AbstractC0246
    public void onResponse(String str) {
        if (this.castPlayerFrag != null) {
            this.castPlayerFrag.mo11490(str);
        }
    }

    public boolean hasBottomNavBar() {
        return false;
    }

    public View getSlidingPanelPullView() {
        return findViewById(R.id.sliding_panel_pull);
    }

    public NetflixBottomNavBar getBottomNavBar() {
        if (!hasBottomNavBar()) {
            return null;
        }
        NetflixBottomNavBar netflixBottomNavBar = (NetflixBottomNavBar) findViewById(R.id.bottom_navigation);
        if (netflixBottomNavBar == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.bottom_navigation_stub);
            if (viewStub != null) {
                netflixBottomNavBar = (NetflixBottomNavBar) viewStub.inflate();
            }
            if (netflixBottomNavBar != null) {
                netflixBottomNavBar.m430(new NetflixBottomNavBar.AbstractC0013() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.26
                    @Override // com.netflix.mediaclient.android.widget.NetflixBottomNavBar.AbstractC0013
                    /* renamed from: ˏ  reason: contains not printable characters */
                    public void mo283(boolean z) {
                        NetflixActivity.this.onPaddingChanged();
                    }
                });
            }
        }
        return netflixBottomNavBar;
    }

    public void bottomTabReselected(NetflixBottomNavBar.NetflixTab netflixTab) {
        if (!this.fragmentHelper.mo10709()) {
            performUpAction();
        }
    }

    public NetflixActionBar createActionBar() {
        return new NetflixActionBar(this, this.statusBarBackground);
    }

    public NetflixActionBar.iF.AbstractC0010 getActionBarStateBuilder() {
        NetflixActionBar.iF.AbstractC0010 r2 = null;
        if (this.fragmentHelper.mo10706()) {
            r2 = this.fragmentHelper.mo10699();
        }
        if (r2 == null) {
            r2 = this.netflixActionBar.m345();
            r2.mo394(getTitle()).mo396(true).mo386(NetflixBottomNavBar.m416() ? 1 : 0).mo403(hasUpAction()).mo401(NetflixBottomNavBar.m416() ? NetflixActionBar.LogoType.CENTERED : NetflixActionBar.LogoType.START_ALIGNED).mo399(false);
            onConfigureActionBarState(r2);
        }
        return r2;
    }

    public void onConfigureActionBarState(NetflixActionBar.iF.AbstractC0010 r1) {
    }

    public boolean hasUpAction() {
        if (hasBottomNavBar()) {
            return this.fragmentHelper.mo10706();
        }
        return true;
    }

    public void performUpAction() {
        if (!this.fragmentHelper.mo10705()) {
            C1364Cj.m4442(UIViewLogging.UIViewCommandName.upButton, getUiScreen().f4084, getDataContext());
            C1300Ac.m3533();
            if (!getServiceManager().mo9519()) {
                finish();
            } else if (!getServiceManager().m9789()) {
                startActivity(zN.f12697.m13529(this));
            } else if (!NetflixBottomNavBar.m416() || isTaskRoot()) {
                startActivity(ActivityC2153sl.m10782(this));
            } else if (!hasBottomNavBar()) {
                finish();
            }
            overridePendingTransitionAnimation(getReEnterTransitionAnimation(), getSlidingRightOutTransition());
        }
    }

    public int getActionBarHeight() {
        return this.actionBarHeight;
    }

    public int getBottomNavBarHeight() {
        NetflixBottomNavBar bottomNavBar = getBottomNavBar();
        if (bottomNavBar == null || !bottomNavBar.m427()) {
            return 0;
        }
        return getResources().getDimensionPixelSize(R.dimen.bottom_navigation_height);
    }

    public oV createManagerStatusListener() {
        return null;
    }

    public DialogFragment getDialogFragment() {
        return (DialogFragment) getSupportFragmentManager().findFragmentByTag(FRAG_DIALOG_TAG);
    }

    public uU getCastPlayerFrag() {
        return this.castPlayerFrag;
    }

    @Override // o.qO.AbstractC0170
    public qO.Cif getEpisodeRowListener() {
        return this.castPlayerFrag;
    }

    public NetflixActionBar getNetflixActionBar() {
        return this.netflixActionBar;
    }

    /* access modifiers changed from: protected */
    public void registerFinishReceiverWithAutoUnregister(String str) {
        registerReceiverWithAutoUnregister(this.autokillReceiver, str);
    }

    public void registerReceiverWithAutoUnregister(BroadcastReceiver broadcastReceiver, String str) {
        registerReceiverWithAutoUnregister(broadcastReceiver, new IntentFilter(str));
    }

    public void registerReceiverWithAutoUnregister(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        super.registerReceiver(broadcastReceiver, intentFilter);
        this.autoUnregisterReceivers.add(broadcastReceiver);
    }

    public void registerReceiverLocallyWithAutoUnregister(BroadcastReceiver broadcastReceiver, String str) {
        registerReceiverLocallyWithAutoUnregister(broadcastReceiver, new IntentFilter(str));
    }

    public void registerReceiverLocallyWithAutoUnregister(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);
        this.autoUnregisterLocalReceivers.add(broadcastReceiver);
    }

    public boolean shouldFinishOnManagerError() {
        return true;
    }

    public boolean canApplyBrowseExperience() {
        return false;
    }

    public boolean canShowDownloadProgressBar() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean shouldShowKidsTheme() {
        return canApplyBrowseExperience() && BrowseExperience.m1780();
    }

    public boolean showSettingsInMenu() {
        return canApplyBrowseExperience() && !BrowseExperience.m1780();
    }

    public boolean showAccountInMenu() {
        return canApplyBrowseExperience();
    }

    public boolean showSignOutInMenu() {
        return ConnectivityUtils.m2954(this) && canApplyBrowseExperience();
    }

    public boolean showOfflineInMenu() {
        return canApplyBrowseExperience();
    }

    public boolean showContactUsInSlidingMenu() {
        return canApplyBrowseExperience() && !BrowseExperience.m1780();
    }

    public boolean showHelpInMenu() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean disableShakeToReportBugs() {
        return false;
    }

    public void showFetchErrorsToast() {
        if (NetflixApplication.m223()) {
            C1004.m15961(this, "DEBUG: " + (C1841h.m6801() ? "Fetch errors ENABLED" : "Fetch errors DISABLED"), 1);
        }
    }

    public boolean showMdxInMenu() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean showCallInProgressFloatingActionButton() {
        return true;
    }

    public final boolean shouldAddCastToMenu() {
        if (!showMdxInMenu()) {
            C1283.m16854(TAG, "Activity does not required MDX.");
            return false;
        } else if (this.castPlayerFrag == null || !this.castPlayerFrag.mo11497() || !C0727.m15067()) {
            C2059ph phVar = this.serviceManager;
            if (phVar == null || !phVar.mo9519()) {
                C1283.m16855(TAG, "Service manager is %s or service manager is not ready.", phVar);
                return false;
            } else if (!phVar.m9789()) {
                C1283.m16854(TAG, "User is not logged in, not adding MDX icon");
                return false;
            } else {
                UmaAlert r5 = phVar.m9820();
                if (r5 != null && r5.blocking()) {
                    return false;
                }
                C1283.m16854(TAG, "Checking isAnyMdxTargetAvailable");
                return AU.m3426(getServiceManager().m9811());
            }
        } else {
            C1283.m16854(TAG, "MDX Player frag is showing.");
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addMdxReceiver() {
        if (!showMdxInMenu()) {
            C1283.m16854(TAG, "Activity does not required MDX, skipping add of MDX receiver.");
            return;
        }
        C1283.m16854(TAG, "Listen to updated from MDX service, add");
        uY uYVar = new uY(this);
        registerReceiverWithAutoUnregister(uYVar, uYVar.m11675());
        C1283.m16854(TAG, "Listen to updated from MDX service, added");
    }

    public void updateTargetSelectionDialog() {
        if (this.visibleDialog != null && this.visibleDialog.isShowing() && (this.visibleDialog instanceof DialogC2233vc)) {
            displayDialog(AU.m3424(this, this.castPlayerFrag));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addUserAgentUpdateReceiver() {
        registerReceiverLocallyWithAutoUnregister(this.userAgentUpdateReceiver, C2018nv.m9354());
    }

    /* access modifiers changed from: package-private */
    public boolean isComingFromBackground() {
        return getNetflixApplication().m244();
    }

    public int getActionBarParentViewId() {
        return 16908290;
    }

    public boolean isCastPlayerShowing() {
        return this.castPlayerFrag != null && this.castPlayerFrag.mo11497() && this.castPlayerFrag.isVisible();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setupOfflineAgentListener() {
        C2059ph serviceManager2 = getServiceManager();
        if (serviceManager2.mo9519()) {
            if (hasBottomNavBar()) {
                DownloadSummaryListener.INSTANCE.m2186(serviceManager2.m9832());
            }
            if (serviceManager2.m9824()) {
                removeOfflineAgentListener();
                if (this.activityPageOfflineAgentListener != null) {
                    this.activityPageOfflineAgentListener.m11813();
                }
                this.activityPageOfflineAgentListener = new vA((ViewGroup) findViewById(16908290), true);
                serviceManager2.m9832().mo7124(this.activityPageOfflineAgentListener);
                this.activityPageOfflineAgentListener.m11813();
            }
        }
    }

    public boolean hasSavedInstance() {
        return this.hasSavedInstance;
    }

    public void setupInteractiveTracking(qH qHVar, oN.AbstractC0161 r6) {
        this.currentTrackerId = qHVar.mo9577();
        C1283.m16846("InteractiveTrackerImpl", "setupInteractiveTracking -> " + qHVar.toString());
        if (getServiceManager() == null || !getServiceManager().mo9519()) {
            C1276.m16820().mo5725("setupInteractiveTracking -- Service not ready");
            return;
        }
        if (!hasSavedInstance()) {
            getImageLoader(this).mo3061(qHVar);
        }
        oN r3 = getImageLoader(this).mo3055(qHVar.mo9577());
        if (r3 == null) {
            r3 = qHVar;
            getImageLoader(this).mo3061(qHVar);
        }
        r3.mo9575(r6);
    }

    public void cleanUpInteractiveTrackers() {
        if (this.serviceManager != null && this.serviceManager.mo9519() && !this.currentTrackerId.isEmpty() && getImageLoader(this).mo3055(this.currentTrackerId) != null) {
            getImageLoader(this).mo3055(this.currentTrackerId).mo9575(null);
        }
    }

    public void runWhenManagerIsReady(If r2) {
        if (this.serviceManager.mo9519()) {
            r2.run(this.serviceManager);
            return;
        }
        r2.isBinding();
        this.mPendingServiceManagerRunnable.push(r2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.android.activity.NetflixActivity$ˊ  reason: contains not printable characters */
    public class C0007 implements oV {

        /* renamed from: ˋ  reason: contains not printable characters */
        private boolean f842 = false;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final oV f844;

        public C0007(oV oVVar, boolean z) {
            this.f844 = oVVar;
            this.f842 = z;
        }

        @Override // o.oV
        public void onManagerReady(C2059ph phVar, Status status) {
            NetflixActivity.this.mPrepareHelper = phVar.m9834();
            NetflixActivity.this.tutorialHelper = new vT(NetflixActivity.this, phVar.m9826());
            NetflixActivity.this.mIsTablet = AD.m3299();
            if (status.mo301()) {
                NetflixActivity.this.startLaunchActivityIfVisible();
            }
            if (NetflixActivity.this.netflixActionBar != null) {
                NetflixActivity.this.netflixActionBar.m362();
            }
            if (NetflixActivity.this.castPlayerFrag != null) {
                NetflixActivity.this.castPlayerFrag.onManagerReady(phVar, status);
                if (NetflixActivity.this.shouldExpandCastPlayer) {
                    NetflixActivity.this.shouldExpandCastPlayer = false;
                    NetflixActivity.this.handler.postDelayed(new Runnable() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.ˊ.2
                        @Override // java.lang.Runnable
                        public void run() {
                            NetflixActivity.this.expandCastPlayerIfVisible();
                        }
                    }, 400);
                }
            }
            DialogFragment dialogFragment = NetflixActivity.this.getDialogFragment();
            if (dialogFragment instanceof oV) {
                ((oV) dialogFragment).onManagerReady(phVar, status);
            }
            NetflixActivity.this.addMdxReceiver();
            NetflixActivity.this.addUserAgentUpdateReceiver();
            NetflixActivity.this.updateHelpInMenuStatus();
            if (NetflixActivity.this.showMdxInMenu()) {
                NetflixActivity.this.invalidateOptionsMenu();
            }
            if (this.f844 != null) {
                this.f844.onManagerReady(phVar, status);
            }
            NetflixActivity.this.addFab();
            NetflixActivity.this.displayNoNetworkOverlay();
            if (!(NetflixActivity.this instanceof LaunchActivity)) {
                phVar.m9825().mo1516(true, null);
            }
            phVar.m9825().mo1507(NetflixActivity.this.getDataContext());
            NetflixActivity.this.reportUiViewChanged(NetflixActivity.this.getUiScreen().f4084);
            if (this.f842) {
                NetflixActivity.this.showCastPlayerPostPlayOnResume();
            }
            NetflixActivity.this.displayErrorDialogIfExist();
            NetflixActivity.this.setupOfflineAgentListener();
            while (!NetflixActivity.this.mPendingServiceManagerRunnable.isEmpty()) {
                ((If) NetflixActivity.this.mPendingServiceManagerRunnable.pop()).run(NetflixActivity.this.getServiceManager());
            }
        }

        @Override // o.oV
        public void onManagerUnavailable(C2059ph phVar, Status status) {
            NetflixActivity.this.mPrepareHelper = NetflixActivity.PREPARE_HELPER_NO_OP;
            if (NetflixActivity.this.castPlayerFrag != null) {
                NetflixActivity.this.castPlayerFrag.onManagerUnavailable(phVar, status);
            }
            DialogFragment dialogFragment = NetflixActivity.this.getDialogFragment();
            if (dialogFragment instanceof oV) {
                ((oV) dialogFragment).onManagerUnavailable(phVar, status);
            }
            if (this.f844 != null) {
                this.f844.onManagerUnavailable(phVar, status);
            }
            if (NetflixActivity.this.shouldStartLaunchActivityIfVisibleOnManagerUnavailable()) {
                NetflixActivity.this.startLaunchActivityIfVisible();
            }
            if (NetflixActivity.this.shouldFinishOnManagerError()) {
                NetflixActivity.this.finish();
            }
            while (!NetflixActivity.this.mPendingServiceManagerRunnable.isEmpty()) {
                ((If) NetflixActivity.this.mPendingServiceManagerRunnable.pop()).notAvailable(NetflixActivity.this.getServiceManager());
            }
        }
    }

    public boolean shouldStartLaunchActivityIfVisibleOnManagerUnavailable() {
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateHelpInMenuStatus() {
        if (this.mHelpMenuItem != null && getServiceManager() != null && getServiceManager().m9823() != null) {
            this.mHelpMenuItem.setVisible(getServiceManager().m9823().mo9649());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void displayNoNetworkOverlay() {
        if (ConnectivityUtils.m2970(this)) {
            removeNoNetworkOverlay();
        } else {
            addNoNetworkOverlay();
        }
    }

    private void addNoNetworkOverlay() {
        if (showNoNetworkOverlayIfNeeded()) {
            C1283.m16851(TAG, "Add No network overlay to %s ", getLocalClassName());
            if (this.mNoNetworkOverlay != null) {
                ViewUtils.m3020((View) this.mNoNetworkOverlay, true);
                return;
            }
            this.mFabAnchor = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
            if (this.mFabAnchor != null) {
                LayoutInflater.from(this).inflate(R.layout.no_network_support_overlay, (ViewGroup) this.mFabAnchor, true);
                this.mNoNetworkOverlay = (RelativeLayout) this.mFabAnchor.findViewById(R.id.no_network_overlay);
                if (this.mNoNetworkOverlay == null) {
                    C1283.m16850(TAG, "No network overlay is not found in root layout! This should NOT happen!");
                    return;
                }
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.mNoNetworkOverlay.getLayoutParams();
                layoutParams.gravity = 80;
                this.mNoNetworkOverlay.setLayoutParams(layoutParams);
                this.mNoNetworkOverlay.setOnClickListener(new View.OnClickListener() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C1283.m16854(NetflixActivity.TAG, "Handle click on No Network overlay");
                        NetflixActivity.this.handleActionOnNoNetworkOverlay();
                    }
                });
            }
        }
    }

    public void removeNoNetworkOverlay() {
        if (this.mNoNetworkOverlay != null) {
            ViewUtils.m3020((View) this.mNoNetworkOverlay, false);
        }
    }

    public boolean showNoNetworkOverlayIfNeeded() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void handleActionOnNoNetworkOverlay() {
        recreate();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void addFab() {
        if (!(this instanceof ActivityC1313Ao)) {
            boolean isCustomerSupportCallInProgress = isCustomerSupportCallInProgress();
            if (this.mBackToCustomerSupportCallFAB == null || !isCustomerSupportCallInProgress) {
                this.mFabAnchor = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
                if (this.mFabAnchor != null) {
                    if (!isCustomerSupportCallInProgress) {
                        C1283.m16865(TAG, "Customer support call is NOT in progress for " + getLocalClassName());
                        return;
                    }
                    LayoutInflater.from(this).inflate(R.layout.customer_support_fab_back_to_dialer, (ViewGroup) this.mFabAnchor, true);
                    FloatingActionButton floatingActionButton = (FloatingActionButton) this.mFabAnchor.findViewById(R.id.backToCustomerSupportDialFab);
                    if (floatingActionButton == null) {
                        C1283.m16850(TAG, "Fab is not found in root layout! This should NOT happen!");
                        return;
                    }
                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
                    layoutParams.gravity = 81;
                    layoutParams.setMargins(0, 0, 0, getBottomNavBarHeight() + this.systemNavBarHeight + getResources().getDimensionPixelSize(R.dimen.back_to_contact_us_dialer_margin_bottom));
                    floatingActionButton.setLayoutParams(layoutParams);
                    floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Intent r2 = ActivityC1313Ao.m3721(NetflixActivity.this);
                            if (NetflixActivity.this.getUiScreen() != null) {
                                r2.putExtra(NetflixActivity.EXTRA_SOURCE, NetflixActivity.this.getUiScreen().name());
                            }
                            r2.putExtra(NetflixActivity.EXTRA_FROM, CustomerServiceLogging.ReturnToDialScreenFrom.fab.name());
                            NetflixActivity.this.startActivity(r2);
                        }
                    });
                    floatingActionButton.show();
                    this.mBackToCustomerSupportCallFAB = floatingActionButton;
                    return;
                }
                return;
            }
            this.mBackToCustomerSupportCallFAB.show();
        }
    }

    private synchronized void removeFab() {
        if (this.mFabAnchor == null || this.mBackToCustomerSupportCallFAB == null) {
            C1283.m16865(TAG, "Unable to remove FAB!");
        } else {
            C1283.m16854(TAG, "Hiding FAB...");
            this.mBackToCustomerSupportCallFAB.hide();
        }
    }

    private boolean isCustomerSupportCallInProgress() {
        if (this.serviceManager == null || this.serviceManager.m9787() == null || !this.serviceManager.m9787().mo1437() || (this instanceof ActivityC1313Ao)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void startLaunchActivityIfVisible() {
        if (!this.isVisible || (this instanceof LaunchActivity)) {
            C1283.m16846(TAG, "Activity is not visible, skipping launch of new activity");
            return;
        }
        C1283.m16862(TAG, "Activity is visible, starting launch activity");
        startActivity(ActivityC2187tq.m11247(this, "startLaunchActivityIfVisible()").addFlags(131072));
    }

    public static ImageLoader getImageLoader(Context context) {
        NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(context, NetflixActivity.class);
        if (netflixActivity != null) {
            return netflixActivity.serviceManager.m9829();
        }
        C1276.m16820().mo5725("getImageLoader passed a non activity context");
        return null;
    }

    public C2059ph getServiceManager() {
        if (!this.serviceManager.m9837()) {
            C1276.m16820().mo5730(new IllegalStateException("Invalid state when called netflixActivity.getServiceManager()"));
        }
        return this.serviceManager;
    }

    public AbstractC2057pf getPrepareHelper() {
        return this.mPrepareHelper;
    }

    public NetflixApplication getNetflixApplication() {
        return (NetflixApplication) getApplication();
    }

    public void runInUiThread(Runnable runnable) {
        if (runnable != null && !C1317As.m3750(this)) {
            runOnUiThread(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void expandCastPlayerIfVisible() {
        if (this.castPlayerFrag != null && this.slidingPanel != null && this.isVisible) {
            notifyCastPlayerShown(true);
        }
    }

    public void notifyCastPlayerEndOfPlayback() {
        C1283.m16846(TAG, "CastPlayer end of playback");
        if (this.slidingPanel != null) {
            this.slidingPanel.m3211();
        }
        hideCastPlayer();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyCastPlayerEndOfPostPlay() {
        C1283.m16846(TAG, "CastPlayer end of postplay");
        if (this.slidingPanel != null) {
            this.slidingPanel.m3211();
        }
        hideCastPlayer();
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_PLAYER_POST_PLAY_ACTION_HIDE"));
    }

    /* access modifiers changed from: protected */
    public void hideCastPlayer() {
        if (this.slidingPanel != null) {
            this.slidingPanel.setPanelHeight(0);
        }
        View findViewById = findViewById(R.id.cast_player_fragment);
        if (findViewById != null) {
            findViewById.setVisibility(4);
            findViewById.requestLayout();
            if (this.castPlayerFrag instanceof uL) {
                ((uL) this.castPlayerFrag).m11486(false);
            }
        }
        this.handler.post(new Runnable() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.10
            @Override // java.lang.Runnable
            public void run() {
                NetflixActionBar netflixActionBar2 = NetflixActivity.this.getNetflixActionBar();
                if (netflixActionBar2 != null && !netflixActionBar2.m346() && NetflixActivity.this.canShowActionBar()) {
                    netflixActionBar2.m356(true);
                }
                NetflixBottomNavBar bottomNavBar = NetflixActivity.this.getBottomNavBar();
                if (bottomNavBar != null && !bottomNavBar.m427()) {
                    bottomNavBar.m431(true);
                }
            }
        });
        postActionBarUpdate();
        onPaddingChanged();
    }

    public void notifyCastPlayerHidden() {
        C1283.m16846(TAG, "CastPlayer frag hidden");
        collapseSlidingPanel();
        hideCastPlayer();
        onPaddingChanged();
    }

    public void notifyCastPlayerShown(boolean z) {
        boolean r5 = ConnectivityUtils.m2954(this);
        C1283.m16848(TAG, "notifyCastPlayerShown connected=%b", Boolean.valueOf(r5));
        if (this.slidingPanel != null && r5) {
            showCastPlayer();
            postActionBarUpdate();
            if (z) {
                this.slidingPanel.post(new Runnable() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.7
                    @Override // java.lang.Runnable
                    public void run() {
                        NetflixActivity.this.slidingPanel.m3215();
                    }
                });
            }
            if (AD.m3292() && getRequestedOrientation() != 1) {
                setRequestedOrientation(1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getCollapsedCastHeight() {
        int r2 = this.castPlayerFrag != null ? this.castPlayerFrag.mo11487() : 0;
        if (hasBottomNavBar()) {
            return r2 + getResources().getDimensionPixelSize(R.dimen.bottom_navigation_height);
        }
        return r2;
    }

    /* access modifiers changed from: protected */
    public void showCastPlayer() {
        FragmentManager supportFragmentManager;
        if (this.castPlayerFrag != null && this.slidingPanel != null) {
            this.slidingPanel.setPanelHeight(getCollapsedCastHeight());
            this.slidingPanel.m3204();
            View findViewById = findViewById(R.id.cast_player_fragment);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            uU castPlayerFrag2 = getCastPlayerFrag();
            if (!castPlayerFrag2.mo11497() && (supportFragmentManager = getSupportFragmentManager()) != null) {
                supportFragmentManager.beginTransaction().show((Fragment) getCastPlayerFrag()).commitNowAllowingStateLoss();
            }
            if (castPlayerFrag2 instanceof uL) {
                ((uL) castPlayerFrag2).m11483();
            }
            onPaddingChanged();
        }
    }

    public void notifyMdxShowDetailsRequest() {
        this.handler.postDelayed(new Runnable() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.8
            @Override // java.lang.Runnable
            public void run() {
                NetflixActivity.this.collapseSlidingPanel();
            }
        }, 250);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void collapseSlidingPanel() {
        boolean z = false;
        if (this.slidingPanel != null && this.slidingPanel.m3218()) {
            C1283.m16846(TAG, "Collapsing sliding panel...");
            z = this.slidingPanel.m3213();
        }
        if (!z && this.castPlayerFrag != null) {
            this.castPlayerFrag.mo11481();
        }
    }

    private void postActionBarUpdate() {
        this.handler.removeCallbacks(this.updateActionBarVisibilityRunnable);
        this.handler.postDelayed(this.updateActionBarVisibilityRunnable, ACTION_BAR_VISIBILITY_CHECK_DELAY_MS);
    }

    public boolean isConnectingToTarget() {
        return this.mConnectingToTarget;
    }

    public void setConnectingToTarget(boolean z) {
        this.mConnectingToTarget = z;
    }

    public void closeAllPopupMenus() {
        while (!this.mShownPopupMenus.isEmpty()) {
            this.mShownPopupMenus.pop().dismiss();
        }
    }

    public boolean showMenu(PopupMenu popupMenu) {
        if (popupMenu == null || C1317As.m3750(this)) {
            return false;
        }
        popupMenu.show();
        this.mShownPopupMenus.push(popupMenu);
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.15
            @Override // android.widget.PopupMenu.OnDismissListener
            public void onDismiss(PopupMenu popupMenu2) {
                NetflixActivity.this.mShownPopupMenus.remove(popupMenu2);
            }
        });
        return true;
    }

    public boolean showDialog(DialogFragment dialogFragment) {
        if (dialogFragment == null || C1317As.m3750(this)) {
            return false;
        }
        DialogFragment dialogFragment2 = getDialogFragment();
        if (dialogFragment2 == null || !dialogFragment2.isVisible()) {
            synchronized (this.instanceStateSaved) {
                if (this.instanceStateSaved.get()) {
                    C1283.m16854(TAG, "Instance state has been saved - skipping showing dialog");
                    return false;
                }
                try {
                    FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                    DialogFragment dialogFragment3 = getDialogFragment();
                    if (dialogFragment3 != null) {
                        if (dialogFragment3 instanceof DialogFragment) {
                            C1283.m16846(TAG, "Dismissing previous dialog");
                            dialogFragment3.dismiss();
                        }
                        C1283.m16846(TAG, "Removing previous dialog");
                        beginTransaction.remove(dialogFragment3);
                    }
                    beginTransaction.addToBackStack(null);
                    C1283.m16846(TAG, "Showing dialog");
                    ViewUtils.m3017(dialogFragment, getSupportFragmentManager(), beginTransaction, FRAG_DIALOG_TAG);
                    return true;
                } catch (Throwable th) {
                    String str = "Failed to show dialog, " + th;
                    C1283.m16850(TAG, str);
                    C1276.m16820().mo5727(str);
                    return false;
                }
            }
        } else {
            String str2 = "SPY-10201, Dialog fragment already visible (" + getDialogFragment() + ") while trying to display " + dialogFragment + ". There should only be one visible at time.";
            C1283.m16865(TAG, str2);
            C1276.m16820().mo5731(new IllegalArgumentException(str2));
            return true;
        }
    }

    public boolean isDialogFragmentVisible() {
        return getDialogFragment() != null;
    }

    public boolean isPanelExpanded() {
        if (this.slidingPanel == null) {
            return false;
        }
        return this.slidingPanel.m3218();
    }

    public boolean isPanelCollapsed() {
        if (this.slidingPanel == null) {
            return false;
        }
        return this.slidingPanel.m3205();
    }

    public void removeDialogFrag() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        DialogFragment dialogFragment = getDialogFragment();
        if (dialogFragment != null) {
            if (dialogFragment instanceof DialogFragment) {
                dialogFragment.dismiss();
            }
            beginTransaction.remove(dialogFragment);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public void removeVisibleDialog() {
        synchronized (this.visibleDialogLock) {
            if (this.visibleDialog != null) {
                this.visibleDialog.dismiss();
                this.visibleDialog = null;
            }
        }
    }

    public Dialog getVisibleDialog() {
        return this.visibleDialog;
    }

    public Dialog displayDialog(AlertDialog.Builder builder) {
        AlertDialog create;
        if (builder == null) {
            return null;
        }
        synchronized (this.visibleDialogLock) {
            create = builder.create();
            displayDialog(create);
        }
        return create;
    }

    public void displayDialog(Dialog dialog) {
        if (dialog != null && !C1317As.m3750(this)) {
            synchronized (this.visibleDialogLock) {
                if (!C1317As.m3750(this)) {
                    if (isErrorDialogVisible()) {
                        C1283.m16865(TAG, "Error dualog is displayed, do not remove it!");
                        return;
                    }
                    if (this.visibleDialog != null) {
                        this.visibleDialog.dismiss();
                    }
                    if (C0650.m14802() || Config_Ab9454_InPlayerPivots.m518()) {
                        showPreservingWindowFlagsFromActivity(dialog);
                    } else {
                        dialog.show();
                    }
                    this.visibleDialog = dialog;
                }
            }
        }
    }

    private void showPreservingWindowFlagsFromActivity(Dialog dialog) {
        dialog.getWindow().setFlags(8, 8);
        dialog.show();
        dialog.getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility());
        dialog.getWindow().clearFlags(8);
    }

    public Dialog displayDialog(DialogC1104.Cif ifVar) {
        DialogC1104 r1;
        if (ifVar == null || C1317As.m3750(this)) {
            return null;
        }
        synchronized (this.visibleDialogLock) {
            r1 = ifVar.m16223();
            displayDialog(r1);
        }
        return r1;
    }

    public void updateVisibleDialog(Dialog dialog) {
        if (dialog != null) {
            synchronized (this.visibleDialogLock) {
                if (this.visibleDialog != null) {
                    this.visibleDialog.dismiss();
                }
                this.visibleDialog = dialog;
            }
        }
    }

    public void handleProfileReadyToSelect() {
    }

    public void handleProfileSelectionResult(int i, String str) {
    }

    public void handleProfileActivated() {
    }

    public void handleAccountDeactivated() {
        if (this.isVisible && !(this instanceof ActivityC2194tx)) {
            startActivity(ActivityC2194tx.m11258(this));
        }
        if (this instanceof ActivityC2194tx) {
            C1283.m16865(TAG, "Account deactivated, leave to LogoutActivity to complete transition...");
        } else {
            finish();
        }
    }

    public void handleProfilesListUpdated() {
    }

    /* access modifiers changed from: protected */
    public void handleInvalidCurrentProfile() {
        finishAllActivities(this);
        startActivity(ActivityC2383zq.m13737(this));
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        setInstanceStateSaved(true);
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(EXTRA_SHOULD_EXPAND_CAST_PLAYER, this.castPlayerFrag != null && this.castPlayerFrag.mo11497() && this.slidingPanel != null && this.slidingPanel.m3218());
        bundle.putBoolean(EXTRA_IS_MDX_CONNECTING, isConnectingToTarget());
        if (this.mCallback != null) {
            this.mCallback.onActivitySaveInstanceState(this, bundle);
        }
        this.fragmentHelper.mo10708(bundle);
    }

    public boolean isInstanceStateSaved() {
        boolean z;
        synchronized (this.instanceStateSaved) {
            z = this.instanceStateSaved.get();
        }
        return z;
    }

    private void setInstanceStateSaved(boolean z) {
        synchronized (this.instanceStateSaved) {
            this.instanceStateSaved.set(z);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getNetflixApplication().m237().mo14203();
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        getNetflixApplication().m237().mo14203();
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        getNetflixApplication().m237().mo14203();
        if (AU.m3425() || this.castPlayerFrag == null || !this.castPlayerFrag.mo11496(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleDisplayToken(Intent intent) {
    }

    @Override // o.AbstractC0459
    public void setLoadingStatusCallback(AbstractC0459.AbstractC0460 r2) {
        if (isLoadingData() || r2 == null) {
            this.mLoadingStatusCallback = r2;
        } else {
            r2.mo1654(AbstractC0367.f13235);
        }
    }

    public void onLoaded(Status status) {
        if (this.mLoadingStatusCallback != null) {
            this.mLoadingStatusCallback.mo1654(status);
        }
    }

    public C1359Ce getDataContext() {
        return null;
    }

    public C1366Cl getNavigationLevelManager() {
        return NetflixApplication.getInstance().m242();
    }

    public ApplicationPerformanceMetricsLogging getApmSafely() {
        return BW.m3931();
    }

    public void reportUiViewChanged(IClientLogging.ModalView modalView) {
        ApplicationPerformanceMetricsLogging apmSafely = getApmSafely();
        if (apmSafely != null && modalView != null) {
            apmSafely.mo1497(AD.m3306(this), modalView);
        }
    }

    public String reportUiModelessViewSessionStart(IClientLogging.ModalView modalView) {
        ApplicationPerformanceMetricsLogging apmSafely = getApmSafely();
        if (apmSafely == null || modalView == null) {
            return null;
        }
        boolean r3 = AD.m3306(this);
        String valueOf = String.valueOf(this.mDialogCount.getAndIncrement());
        apmSafely.mo1491(r3, modalView, valueOf);
        return valueOf;
    }

    public void reportUiModelessViewSessionEnded(IClientLogging.ModalView modalView, String str) {
        ApplicationPerformanceMetricsLogging apmSafely = getApmSafely();
        if (apmSafely != null) {
            AD.m3306(this);
            apmSafely.mo1488(str);
        }
    }

    public void reportCL1NavigationSessionEnded(UIScreen uIScreen) {
        if (uIScreen == null) {
            C1276.m16820().mo5725("reportCL1NavigationSessionStart:: view is NULL!");
        } else {
            C1362Ch.m4388(uIScreen.f4084, IClientLogging.CompletionReason.success, (UIError) null);
        }
    }

    public void reportCL1NavigationSessionStart(UIScreen uIScreen) {
        if (uIScreen == null) {
            C1276.m16820().mo5725("reportCL1NavigationSessionStart:: view is NULL!");
        } else {
            C1362Ch.m4423(null, uIScreen.f4084);
        }
    }

    public void reportPresentationSessionStart(AppView appView) {
        Long put;
        if (appView == null) {
            C1283.m16850(TAG, "reportPresentationSessionStart:: view is NULL!");
            return;
        }
        Long r3 = Logger.INSTANCE.m142(new C1224(getDataContext(), appView));
        if (r3 != null && (put = this.mPresentationSessionMap.put(appView.name(), r3)) != null) {
            C1283.m16865(TAG, "We had older session that we removed!");
            Logger.INSTANCE.m147(C1224.m16814(put));
        }
    }

    public void reportPresentationSessionEnded(AppView appView) {
        Logger.INSTANCE.m140(removePresentationSessionId(appView));
    }

    public void reportPresentationSessionCanceled(AppView appView) {
        Logger.INSTANCE.m129(removePresentationSessionId(appView));
    }

    public boolean canShowActionBar() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void hideActionAndBottomBars() {
        hideActionBar(false);
        if (getBottomNavBar() != null && getBottomNavBar().m427()) {
            getBottomNavBar().m426(true);
        }
        onPaddingChanged();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hideActionBar() {
        hideActionBar(true);
    }

    private void hideActionBar(boolean z) {
        if (this.netflixActionBar != null && this.netflixActionBar.m346()) {
            this.netflixActionBar.m350(true);
        }
        if (z) {
            onPaddingChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void showActionAndBottomBars() {
        showActionBar(false);
        if (getBottomNavBar() != null && !getBottomNavBar().m427()) {
            getBottomNavBar().m431(true);
        }
        onPaddingChanged();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showActionBar() {
        showActionBar(true);
    }

    private void showActionBar(boolean z) {
        if (this.netflixActionBar != null && !this.netflixActionBar.m346() && canShowActionBar()) {
            this.netflixActionBar.m356(true);
        }
        if (z) {
            onPaddingChanged();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void applySlidePanelOffsetToBottomBar(float f) {
        if (getBottomNavBar() != null) {
            getBottomNavBar().m428(f);
        }
        onPaddingChanged();
    }

    public void handleFalkorAgentErrors(Status status) {
        if (StatusCode.INVALID_COUNRTY.equals(status.mo302())) {
            C1283.m16854(TAG, "User accessing Netflix in a not supported country. Show alert and kill self");
            displayErrorDialog(getString(R.string.access_error_invalid_country), status.mo302().m271(), true);
        } else if (StatusCode.INSUFFICIENT_CONTENT.equals(status.mo302())) {
            C1283.m16854(TAG, "Insufficient content for this profile - cant show lolomo. Show alert and go to profile selection");
            displayServiceAgentDialog(getString(R.string.insufficient_lolomo_data), new Runnable() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    NetflixActivity.this.startActivity(ActivityC2383zq.m13731(NetflixActivity.this.getNetflixApplication()));
                    NetflixActivity.this.finish();
                }
            }, false);
        }
    }

    public String handleUserAgentErrors(Status status) {
        return handleUserAgentErrors(status, true);
    }

    public String handleUserAgentErrors(Status status, boolean z) {
        String r4 = status.mo307();
        String str = r4 != null ? r4 : "";
        switch (status.mo302()) {
            case NRD_LOGIN_ACTIONID_3:
                String str2 = str;
                if (str2.isEmpty()) {
                    str2 = String.format("%s ( %d )", getString(R.string.login_generic_actionid_msg), Integer.valueOf(status.mo302().m271()));
                }
                displayServiceAgentDialog(str2, null, false);
                return str2;
            case NRD_LOGIN_ACTIONID_4:
            case NRD_LOGIN_ACTIONID_8:
                String format = String.format("%s ( %d )", getString(R.string.generic_signed_out), Integer.valueOf(status.mo302().m271()));
                displayServiceAgentDialog(format, new Runnable() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.18
                    @Override // java.lang.Runnable
                    public void run() {
                        C1283.m16854(NetflixActivity.TAG, "Restarting app, time: " + System.nanoTime());
                        NetflixActivity.this.finish();
                        NetflixActivity.this.startActivity(ActivityC2194tx.m11258(NetflixActivity.this));
                    }
                }, true);
                return format;
            case NRD_LOGIN_ACTIONID_9:
                C0368.m14087(this, AbstractC0367.f13243);
                return "";
            case NRD_LOGIN_ACTIONID_1:
            case NRD_LOGIN_ACTIONID_2:
            case NRD_LOGIN_ACTIONID_5:
            case NRD_LOGIN_ACTIONID_6:
            case NRD_LOGIN_ACTIONID_7:
            case NRD_LOGIN_ACTIONID_10:
            case NRD_LOGIN_ACTIONID_11:
            case NRD_LOGIN_ACTIONID_12:
                String format2 = String.format("%s ( %d )", getString(R.string.login_generic_actionid_msg), Integer.valueOf(status.mo302().m271()));
                displayServiceAgentDialog(format2, null, false);
                return format2;
            case HTTP_SSL_DATE_TIME_ERROR:
            case HTTP_SSL_ERROR:
            case HTTP_SSL_NO_VALID_CERT:
                String string = getString(R.string.login_network_or_ssl_Error);
                displayErrorDialog(string, status.mo302().m271(), z);
                return string;
            case USER_SIGNIN_FAILURE_TRY_SIGNUP:
                C1283.m16854(TAG, "going to signup activity");
                if (!LaunchActivity.m1998(getServiceManager())) {
                    return "";
                }
                Intent r7 = zN.f12697.m13517(this);
                r7.setFlags(268468224);
                startActivity(r7);
                finish();
                return "";
            case SWITCH_PROFILE_UNKNOWN_ID:
            case MSL_SWITCH_PROFILE_BIND_FAIL:
            case MSL_SWITCH_PROFILE_NO_AUTH_DATA:
            case MSL_SWITCH_PROFILE_FAILED:
                C1283.m16854(TAG, "switch profile failed");
                String string2 = getString(R.string.nflx_switch_profile_error);
                displayErrorDialog(getString(R.string.nflx_switch_profile_error), status.mo302().m271(), true);
                return string2;
            default:
                if (!ConnectivityUtils.m2954(this)) {
                    String string3 = getString(R.string.label_nointernet);
                    displayErrorDialog(getString(R.string.label_nointernet), status.mo302().m271(), z);
                    return string3;
                }
                String string4 = getString(R.string.nflx_connectivity_error);
                displayErrorDialog(getString(R.string.nflx_connectivity_error), status.mo302().m271(), z);
                return string4;
        }
    }

    /* access modifiers changed from: protected */
    public void displayErrorDialog(String str, int i, boolean z) {
        displayServiceAgentDialog(String.format("%s ( %d )", str, Integer.valueOf(i)), z ? new Runnable() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.16
            @Override // java.lang.Runnable
            public void run() {
                NetflixActivity.this.finish();
            }
        } : null, true);
    }

    public void displayServiceAgentDialog(String str, Runnable runnable, boolean z) {
        DialogC1104.Cif r3 = C0505.m14491(this, this.handler, new C1278(null, str, getString(R.string.label_ok), runnable));
        if (!C1317As.m3750(this)) {
            synchronized (this.visibleDialogLock) {
                if (z) {
                    displayDialog(r3);
                } else if (getVisibleDialog() != null && !getVisibleDialog().isShowing()) {
                    displayDialog(r3);
                } else if (getVisibleDialog() == null) {
                    displayDialog(r3);
                }
            }
        }
    }

    public void handleNetworkErrorDialog() {
        finish();
    }

    public void onSlidingPanelExpanded(View view) {
    }

    public void onSlidingPanelCollapsed(View view) {
    }

    public boolean isTablet() {
        return this.mIsTablet;
    }

    @Override // o.C1305Ag.AbstractC0066
    public void onPlayVerified(boolean z, PlayVerifierVault playVerifierVault) {
        throw new IllegalStateException(String.format("onPlayVerified vault: %s", playVerifierVault));
    }

    @Override // o.C1305Ag.AbstractC0066
    public void onOfflineDownloadPinAndAgeVerified(boolean z, PlayVerifierVault playVerifierVault) {
        throw new IllegalStateException(String.format("onPlayVerified vault: %s", playVerifierVault));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleCustomerSupportCallEnded() {
        removeFab();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleErrorDialog() {
        if (this.isVisible) {
            C1283.m16854(TAG, "Display error dialog");
            displayErrorDialogIfExist();
            return;
        }
        C1283.m16854(TAG, "Not visible, can not display error dialog");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void displayErrorDialogIfExist() {
        oH r3;
        final AbstractC1268 r4;
        final C2059ph serviceManager2 = getServiceManager();
        if (serviceManager2 != null && (r3 = serviceManager2.m9756()) != null && (r4 = r3.mo5360()) != null) {
            if (r4.mo10135() != null) {
                C1283.m16854(TAG, "Display error dialog");
                DialogC1104.Cif r6 = C0505.m14492(this, this.handler, r4.mo10135(), new Runnable() { // from class: com.netflix.mediaclient.android.activity.NetflixActivity.20
                    @Override // java.lang.Runnable
                    public void run() {
                        serviceManager2.m9756().mo5363(r4);
                    }
                });
                this.mErrorDialogId = reportUiModelessViewSessionStart(IClientLogging.ModalView.errorDialog);
                reportPresentationSessionStart(AppView.errorDialog);
                synchronized (this.visibleDialogLock) {
                    if (!C1317As.m3750(this)) {
                        if (this.visibleDialog != null) {
                            this.visibleDialog.dismiss();
                        }
                        DialogC1104 r8 = r6.m16223();
                        r8.show();
                        C0505.m14488(r8);
                        this.visibleDialog = r8;
                        return;
                    }
                    return;
                }
            }
            C1283.m16850(TAG, "Unable to display an error dialog, data not found!");
        }
    }

    public DismissingDialogConfig getDismissingDialogConfiguration() {
        return this.mDismissingDialogConfiguration;
    }

    public void setDismissingDialogConfiguration(DismissingDialogConfig dismissingDialogConfig) {
        this.mDismissingDialogConfiguration = dismissingDialogConfig;
    }

    public Handler getHandler() {
        return this.handler;
    }

    private int getSlidingRightOutTransition() {
        return AD.m3299() ? R.anim.anim_tablet_slide_right_out : R.anim.anim_slide_right_out;
    }

    private int getSlidingRightInTransition() {
        return AD.m3299() ? R.anim.anim_tablet_slide_right_in : R.anim.anim_slide_right_in;
    }

    public void showDebugToast(String str) {
        if (NetflixApplication.m223()) {
            C1004.m15961(this, "DEBUG: " + str, 1);
        }
    }

    public static AbstractC1853hl getOfflineAgentOrNull(NetflixActivity netflixActivity) {
        C2059ph r1 = C2059ph.m9741(netflixActivity);
        if (r1 != null) {
            return r1.m9832();
        }
        return null;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == DL_REQUEST_CODE && i2 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_DL_PLAYABLE_ID);
            VideoType create = VideoType.create(intent.getStringExtra(EXTRA_DL_VIDEO_TYPE_STRING));
            AbstractC1853hl offlineAgentOrNull = getOfflineAgentOrNull(this);
            if (offlineAgentOrNull != null) {
                offlineAgentOrNull.mo7141(stringExtra, create, qN.f9515);
            }
        }
    }

    public void requestDownloadButtonRefresh(String str) {
        if (this.activityPageOfflineAgentListener != null && str != null) {
            this.activityPageOfflineAgentListener.m11812(this, str);
        }
    }

    public void flushPerformanceProfilerEvents() {
        if (this.serviceManager.m9837()) {
            PerformanceProfiler.INSTANCE.m668();
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        wrapContextLocale(getBaseContext());
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(wrapContextLocale(context));
    }

    public ContextWrapper wrapContextLocale(Context context) {
        return BX.m3947(context, C2020nx.m9362(context).m3975());
    }

    public void startRenderNavigationLevelSession() {
        if (this.renderSession != null) {
            endRenderNavigationLevelSession(IClientLogging.CompletionReason.canceled, null);
            C1283.m16854(TAG, "StartRenderNavigationLevelSession: Cancelling the current render session in progress");
        }
        this.renderSession = new C0903();
        Logger.INSTANCE.m142(this.renderSession);
    }

    public void endRenderNavigationLevelSession(IClientLogging.CompletionReason completionReason, Status status) {
        if (this.renderSession == null) {
            C1283.m16854(TAG, "EndRenderNavigationLevelSession: No start render session in progress");
            return;
        }
        switch (completionReason) {
            case success:
                Logger.INSTANCE.m133("RenderNavigationLevel");
                break;
            case canceled:
                Logger.INSTANCE.m146("RenderNavigationLevel");
                break;
            case failed:
                Logger.INSTANCE.m134("RenderNavigationLevel", C1300Ac.m3532(status));
                break;
        }
        this.renderSession = null;
    }

    public void setFragmentsHiddenState(boolean z, Transition transition) {
    }

    public boolean hasInteractiveUI() {
        return true;
    }

    public void logMetadataRenderedEvent(boolean z) {
        if (this.renderSession != null) {
            Logger.INSTANCE.m131(z ? new C0782(this.renderSession.m14625()) : new C0842(this.renderSession.m14625()));
        }
    }

    public void playerPrepare(pF pFVar, PlayerPrefetchSource playerPrefetchSource, oX oXVar) {
        if (pFVar.isAvailableToStream()) {
            getPrepareHelper().mo9729(pFVar.getPlayableId(), (long) pFVar.getPlayableBookmarkPosition(), playerPrefetchSource, oXVar);
        }
    }

    public boolean shouldAddSystemBarBackgroundViews() {
        return (getWindow().getDecorView().getSystemUiVisibility() & 1024) == 1024;
    }

    /* access modifiers changed from: protected */
    public int getFragmentBottomPadding() {
        if (this.slidingPanel == null || this.slidingPanel.m3216() <= 0) {
            return getBottomNavBarHeight();
        }
        return 0;
    }

    public void onPaddingChanged() {
        this.fragmentHelper.mo10707(getStatusBarHeight(), this.actionBarHeight, getFragmentBottomPadding());
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        if (this.statusBarBackground == null) {
            return 0;
        }
        return this.statusBarBackground.getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void setFragmentPadding(Fragment fragment) {
        if (fragment instanceof AbstractC0517) {
            ((AbstractC0517) fragment).m14533(getStatusBarHeight(), getActionBarHeight(), getFragmentBottomPadding());
        }
    }

    public int getTabsAndSystemNavHeight() {
        return getBottomNavBarHeight() + this.systemNavBarHeight;
    }
}
