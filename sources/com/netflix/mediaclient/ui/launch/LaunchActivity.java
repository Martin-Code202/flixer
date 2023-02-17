package com.netflix.mediaclient.ui.launch;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.service.logging.apm.model.Display;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.service.webclient.model.leafs.AccountData;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import o.AD;
import o.AG;
import o.AS;
import o.AbstractActivityC2189ts;
import o.AbstractC1358Cd;
import o.AbstractC2061pj;
import o.ActivityC2153sl;
import o.ActivityC2186tp;
import o.ActivityC2187tq;
import o.ActivityC2383zq;
import o.BW;
import o.C0368;
import o.C0489;
import o.C0693;
import o.C0918;
import o.C1283;
import o.C1317As;
import o.C1339Bl;
import o.C1343Bp;
import o.C1349Bv;
import o.C1363Ci;
import o.C1491aV;
import o.C2018nv;
import o.C2059ph;
import o.ServiceC0966;
import o.oV;
import o.pJ;
import o.vH;
import o.vO;
import o.zN;
import o.zT;
import o.zV;
public class LaunchActivity extends NetflixActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static final pJ f3168 = new pJ() { // from class: com.netflix.mediaclient.ui.launch.LaunchActivity.9
        @Override // o.AbstractC2072pu
        public String getId() {
            return "70140457";
        }

        @Override // o.AbstractC2072pu
        public VideoType getType() {
            return VideoType.SHOW;
        }

        @Override // o.AbstractC2072pu
        public String getTitle() {
            return "Dummy Title";
        }

        @Override // o.pJ
        public String getBoxshotUrl() {
            return null;
        }

        @Override // o.pJ
        public String getBoxartId() {
            return null;
        }

        @Override // o.pJ
        public VideoType getErrorType() {
            return null;
        }

        @Override // o.pJ
        public boolean isOriginal() {
            return false;
        }

        @Override // o.pJ
        public boolean isPreRelease() {
            return false;
        }
    };

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f3169;

    /* renamed from: ʼ  reason: contains not printable characters */
    private AtomicBoolean f3170 = new AtomicBoolean(false);

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Runnable f3171 = new Runnable() { // from class: com.netflix.mediaclient.ui.launch.LaunchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (LaunchActivity.this.f3170.get()) {
                C1283.m16854("LaunchActivity", "Callback already returned, login workflow in progress, do nothing");
                return;
            }
            C1283.m16854("LaunchActivity", "=====> Timeout on Google Play Services, go with regular workflow");
            LaunchActivity.this.m1979(LaunchActivity.this.getServiceManager());
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f3172;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f3173 = true;

    /* renamed from: ˎ  reason: contains not printable characters */
    private long f3174;

    /* renamed from: ˏ  reason: contains not printable characters */
    private GoogleApiClient f3175;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f3176;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Status f3177;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final BroadcastReceiver f3178 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.ui.launch.LaunchActivity.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.netflix.mediaclient.intent.action.HANDLER_RESULT".equals(intent.getAction())) {
                C1283.m16854("LaunchActivity", "Delayed nflx action completed, finish activity");
                LaunchActivity.this.finish();
            }
        }
    };

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo2013() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f3174 = System.currentTimeMillis();
        super.onCreate(bundle);
        if (NetflixApplication.getInstance().m254()) {
            setRequestedOrientation(1);
        }
        if (bundle == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("isColdStart", String.valueOf(!ServiceC0966.m15814()));
            if (mo2013()) {
                PerformanceProfiler.INSTANCE.m664();
                PerformanceProfiler.INSTANCE.m670(Sessions.TTI, hashMap);
                PerformanceProfiler.INSTANCE.m670(Sessions.TTR, hashMap);
                PerformanceProfiler.INSTANCE.m670(Sessions.NON_MEMBER_TTI, hashMap);
            }
            PerformanceProfiler.INSTANCE.m670(Sessions.LAUNCH_ACTIVITY_LIFE, hashMap);
        }
        m1977();
        if (getNetflixApplication().m259()) {
            C1283.m16854("LaunchActivity", "Service is ready, just use loading view...");
            setContentView(new C0489(this));
            return;
        }
        C1283.m16854("LaunchActivity", "Service is NOT ready, use splash screen... nf_config: splashscreen");
        this.f3176 = System.currentTimeMillis();
        setContentView(R.layout.splash_screen);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean allowTransitionAnimation() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f3177 != null && this.f3177.mo301() && !this.f3169) {
            this.f3169 = C0368.m14087(this, this.f3177);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f3169 = false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m2009();
        if (this.f3175 != null) {
            this.f3175.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        PerformanceProfiler.INSTANCE.m663(Sessions.LAUNCH_ACTIVITY_MANAGER_LOAD);
        return new oV() { // from class: com.netflix.mediaclient.ui.launch.LaunchActivity.2
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                PerformanceProfiler.INSTANCE.m672(Sessions.LAUNCH_ACTIVITY_MANAGER_LOAD);
                LaunchActivity.this.f3177 = status;
                LaunchActivity.this.f3173 = false;
                if (C0368.m14087(LaunchActivity.this, status)) {
                    LaunchActivity.this.f3169 = true;
                } else {
                    LaunchActivity.this.m2007(phVar);
                }
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                PerformanceProfiler.INSTANCE.m665(Sessions.LAUNCH_ACTIVITY_MANAGER_LOAD, PerformanceProfiler.m652());
                LaunchActivity.this.f3173 = false;
                LaunchActivity.this.f3177 = status;
                LaunchActivity.this.f3169 = C0368.m14087(LaunchActivity.this, status);
            }
        };
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.app.Activity
    public void finish() {
        PerformanceProfiler.INSTANCE.m672(Sessions.LAUNCH_ACTIVITY_LIFE);
        super.finish();
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return this.f3173;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldFinishOnManagerError() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showMdxInMenu() {
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2007(C2059ph phVar) {
        if (!isFinishing()) {
            C1283.m16854("LaunchActivity", "LaunchActivity::handleManagerReady: starts ");
            boolean r4 = phVar.m9789();
            View findViewById = findViewById(R.id.splash_screen_progress);
            if (!r4 && findViewById != null) {
                findViewById.setVisibility(0);
            }
            if (this.f3176 > 0) {
                C1283.m16854("LaunchActivity", "Splash screen was displayed, reporting");
                BW.m3946(AD.m3306(this), IClientLogging.ModalView.appLoading, this.f3176);
            }
            if (!r4 || C1339Bl.m4051(this, "prefs_non_member_playback", false)) {
                C1283.m16854("LaunchActivity", "LaunchActivity::handleManagerReady: user not logged in ");
                m2011(phVar);
                return;
            }
            C1283.m16854("LaunchActivity", "LaunchActivity::handleManagerReady: user logged in ");
            m1990(phVar);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1990(C2059ph phVar) {
        NflxHandler.Response response = null;
        if (phVar.m9826() != null) {
            response = m2005();
        }
        if (response != null && response == NflxHandler.Response.HANDLING) {
            C1283.m16854("LaunchActivity", "Handled by nflx workflow");
            finish();
        } else if (response != null && response == NflxHandler.Response.HANDLING_WITH_DELAY) {
            C1283.m16854("LaunchActivity", "Handled by nflx workflow with delay. Stay on splash screen...");
        } else if (phVar.m9826() == null || m1986(phVar)) {
            m2003(phVar);
        } else {
            m1985(phVar);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2003(C2059ph phVar) {
        Display r6 = AbstractC1358Cd.m4350(this);
        if (mo2014()) {
            BW.m3928(ApplicationPerformanceMetricsLogging.UiStartupTrigger.touchGesture, IClientLogging.ModalView.profilesGate, Long.valueOf(this.f3174), r6, null, C1491aV.m5403(this));
            BW.m3945(this.f3174);
        }
        m2000(ActivityC2383zq.m13725(this));
        finish();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1985(final C2059ph phVar) {
        Display r6 = AbstractC1358Cd.m4350(this);
        if (m2010(phVar)) {
            C1283.m16851("LaunchActivity", "Redirect to offline activity with profile %s, %s", phVar.m9826().getProfileName(), phVar.m9826().getProfileGuid());
            m2000(vH.m11936(this).putExtra(NetflixActivity.EXTRA_ENABLE_TRANSITION_ANIMATION, false));
        } else {
            C1283.m16851("LaunchActivity", "Redirect to home with profile %s, %s", phVar.m9826().getProfileName(), phVar.m9826().getProfileGuid());
            m2000(ActivityC2153sl.m10779(this).putExtra(NetflixActivity.EXTRA_ENABLE_TRANSITION_ANIMATION, false));
        }
        if (zV.m13566(phVar)) {
            if (zV.m13561(phVar)) {
                C1283.m16854("LaunchActivity", "EOG: double check with server if priceIncrease message is still valid to show");
                phVar.m9783(new AbstractC2061pj() { // from class: com.netflix.mediaclient.ui.launch.LaunchActivity.5
                    @Override // o.AbstractC2061pj, o.oU
                    public void onAccountDataFetched(AccountData accountData, Status status) {
                        super.onAccountDataFetched(accountData, status);
                        if (!status.mo298() || !zV.m13566(phVar)) {
                            C1283.m16851("LaunchActivity", "EOG: skip showing priceIncrease message, user has already acted on it. accountData: %s", accountData);
                        } else {
                            LaunchActivity.this.m1978(phVar);
                        }
                        LaunchActivity.this.finish();
                    }
                });
                return;
            }
            m1978(phVar);
        }
        if (mo2014()) {
            BW.m3928(ApplicationPerformanceMetricsLogging.UiStartupTrigger.touchGesture, IClientLogging.ModalView.homeScreen, Long.valueOf(this.f3174), r6, null, C1491aV.m5403(this));
            BW.m3945(this.f3174);
        }
        finish();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private void m1978(C2059ph phVar) {
        m2000(zT.m13546(this, zT.m13549(phVar.m9808().isBlocking())));
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean m2010(C2059ph phVar) {
        if (ConnectivityUtils.m2970(this)) {
            C1283.m16854("LaunchActivity", "Network connectivity exist, go to LOLOMO");
            return false;
        } else if (!phVar.m9824()) {
            C1283.m16854("LaunchActivity", "Offline feature not available!");
            return false;
        } else if (phVar.m9832() == null || vO.m12029(phVar.m9832()).mo4074() <= 0) {
            C1283.m16854("LaunchActivity", "Network connectivity do NOT exist, we do NOT have any offline titles available, load LOLOMO...");
            return false;
        } else {
            C1283.m16851("LaunchActivity", "Network connectivity do NOT exist, we have %d offline titles available, load Offline UI...", Integer.valueOf(vO.m12029(phVar.m9832()).mo4074()));
            return true;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo2012() {
        return AS.m3410(this);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m2011(C2059ph phVar) {
        String action = getIntent().getAction();
        if (action != null && action.equals("com.netflix.mediaclient.LOGIN")) {
            m1980(phVar);
        } else if (mo2012()) {
            C1363Ci.m4428(SignInLogging.SignInType.smartLock);
            C1363Ci.m4431(SignInLogging.CredentialService.GooglePlayService);
            this.f3175 = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Auth.CREDENTIALS_API).build();
            this.f3175.connect();
            this.handler.postDelayed(this.f3171, 30000);
        } else {
            C1283.m16854("LaunchActivity", "Google Play Services are not available, go with regular workflow");
            m1979(phVar);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m1980(C2059ph phVar) {
        if (!ConnectivityUtils.m2970(this) || phVar == null || !phVar.mo9519()) {
            C1283.m16861("no connectivity, exiting...");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString(SignupConstants.Field.EMAIL);
            String string2 = extras.getString(SignupConstants.Field.PASSWORD);
            AD.m3291((Activity) this);
            C1363Ci.m4428(SignInLogging.SignInType.emailPassword);
            if (phVar.m9789()) {
                C1283.m16854("LaunchActivity", "we shouldn't really be here. ");
            } else {
                phVar.m9772(string, string2, new AbstractC2061pj() { // from class: com.netflix.mediaclient.ui.launch.LaunchActivity.3
                    @Override // o.AbstractC2061pj, o.oU
                    public void onLoginComplete(final Status status) {
                        LaunchActivity.this.runOnUiThread(new Runnable() { // from class: com.netflix.mediaclient.ui.launch.LaunchActivity.3.3
                            @Override // java.lang.Runnable
                            public void run() {
                                C1283.m16861("Sign in via intent finished. ");
                                LaunchActivity.this.m1983(status, (Credential) null);
                            }
                        });
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼ  reason: contains not printable characters */
    private void m1979(C2059ph phVar) {
        m1988();
        boolean r2 = C1339Bl.m4051(this, "prefs_non_member_playback", false);
        if (!ConnectivityUtils.m2970(this) || ((!m1998(phVar) || getNetflixApplication().m255()) && !r2)) {
            m1993(phVar);
        } else {
            m2008(phVar);
        }
        C2018nv.m9352(this);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1988() {
        this.f3170.set(true);
        this.handler.removeCallbacks(this.f3171);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m1998(C2059ph phVar) {
        if (phVar == null || !phVar.mo9519() || phVar.m9786() == null) {
            return false;
        }
        return phVar.m9786().mo9849();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m2008(C2059ph phVar) {
        C1283.m16854("LaunchActivity", "User has not signed up, redirect to Signup screen");
        Display r6 = AbstractC1358Cd.m4350(this);
        if (mo2014()) {
            BW.m3928(ApplicationPerformanceMetricsLogging.UiStartupTrigger.touchGesture, IClientLogging.ModalView.signupPrompt, Long.valueOf(this.f3174), r6, null, C1491aV.m5403(this));
        }
        m2000(zN.f12697.m13529(this));
        if (mo2014()) {
            BW.m3945(this.f3174);
        }
        finish();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m1993(C2059ph phVar) {
        Display r6 = AbstractC1358Cd.m4350(this);
        C1283.m16854("LaunchActivity", "User is NOT logged in, redirect to Login screen");
        if (mo2014()) {
            BW.m3928(ApplicationPerformanceMetricsLogging.UiStartupTrigger.touchGesture, IClientLogging.ModalView.login, Long.valueOf(this.f3174), r6, null, C1491aV.m5403(this));
        }
        Intent r7 = ActivityC2186tp.m11240(this);
        if (C1349Bv.m4107(this.f3172)) {
            r7.putExtra(SignupConstants.Field.EMAIL, this.f3172);
        }
        m2000(r7);
        if (mo2014()) {
            BW.m3945(this.f3174);
        }
        finish();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1991(C2059ph phVar, Credential credential, Status status) {
        C1283.m16854("LaunchActivity", "User is NOT logged in, redirect to Login screen");
        if (mo2014()) {
            BW.m3928(ApplicationPerformanceMetricsLogging.UiStartupTrigger.touchGesture, IClientLogging.ModalView.login, Long.valueOf(this.f3174), AbstractC1358Cd.m4350(this), null, C1491aV.m5403(this));
        }
        m2000(ActivityC2186tp.m11239(this, credential, status));
        if (mo2014()) {
            BW.m3945(this.f3174);
        }
        finish();
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean m1986(C2059ph phVar) {
        if (phVar == null) {
            C1283.m16850("LaunchActivity", "shouldProfileGateBeShown was called with null manager");
            return false;
        }
        boolean z = phVar.m9833().size() == 1 && !(this instanceof ActivityC2187tq);
        if (m2010(phVar) || !z) {
            return false;
        }
        int r3 = C1339Bl.m4037(this, "user_saw_profile_gate", 0);
        boolean z2 = r3 < 2;
        if (z2) {
            C1339Bl.m4042((Context) this, "user_saw_profile_gate", r3 + 1);
        }
        return z2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private NflxHandler.Response m2005() {
        Intent intent = getIntent();
        if (C0693.m14983(intent)) {
            return C0693.m14984(this, intent);
        }
        try {
            NflxHandler.Response c_ = C0918.m15721(this, intent, this.f3174).c_();
            C0918.m15724(this, intent);
            return c_;
        } catch (Throwable th) {
            C1283.m16847("LaunchActivity", "Failed to parse nflx url ", th);
            return NflxHandler.Response.NOT_HANDLING;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2000(Intent intent) {
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m1977() {
        C1283.m16854("LaunchActivity", "Register receiver");
        AG.m3334(this, this.f3178, "LocalIntentNflxUi", "com.netflix.mediaclient.intent.action.HANDLER_RESULT");
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m2009() {
        C1283.m16854("LaunchActivity", "Unregistering Nflx receiver");
        AG.m3329(this, this.f3178);
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.appLoading;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo2014() {
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        m1979(getServiceManager());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        C1283.m16854("LaunchActivity", "onConnected, retrieve credentials if any");
        Auth.CredentialsApi.request(this.f3175, new CredentialRequest.Builder().setSupportsPasswordLogin(true).build()).setResultCallback(new ResultCallback<CredentialRequestResult>() { // from class: com.netflix.mediaclient.ui.launch.LaunchActivity.10
            /* renamed from: ˏ  reason: contains not printable characters */
            public void onResult(CredentialRequestResult credentialRequestResult) {
                if (C1317As.m3750(LaunchActivity.this)) {
                    C1283.m16850("LaunchActivity", "Auth.CredentialsApi.request ActivityFinishedOrDestroyed");
                } else if (credentialRequestResult.getStatus().getStatusCode() == 4) {
                    C1283.m16854("LaunchActivity", "Sign in is required, go with regular workflow");
                    if (credentialRequestResult.getCredential() != null) {
                        LaunchActivity.this.f3172 = credentialRequestResult.getCredential().getId();
                        C1283.m16854("LaunchActivity", "Saving hint in case user ends up on login page " + LaunchActivity.this.f3172);
                    } else {
                        C1283.m16854("LaunchActivity", "No credentials!");
                    }
                    Error r3 = C1363Ci.m4430(credentialRequestResult.getStatus());
                    C1363Ci.m4427(SignInLogging.CredentialService.GooglePlayService, IClientLogging.CompletionReason.failed, r3);
                    C1363Ci.m4425(SignInLogging.SignInType.smartLock, IClientLogging.CompletionReason.failed, r3);
                    LaunchActivity.this.m1979(LaunchActivity.this.getServiceManager());
                } else if (credentialRequestResult.getStatus().isSuccess()) {
                    LaunchActivity.this.m1982(credentialRequestResult.getCredential());
                } else {
                    LaunchActivity.this.m1996(credentialRequestResult.getStatus());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m1996(com.google.android.gms.common.api.Status status) {
        boolean z = false;
        if (status == null || !status.hasResolution()) {
            C1283.m16850("LaunchActivity", "Google Play Services: STATUS: FAIL");
            showDebugToast("Google Play Services: Could Not Resolve Error");
            z = true;
        } else {
            C1283.m16854("LaunchActivity", "Google Play Services: STATUS: RESOLVING");
            try {
                status.startResolutionForResult(this, 2);
            } catch (IntentSender.SendIntentException e) {
                C1283.m16847("LaunchActivity", "Google Play Services: STATUS: Failed to send resolution.", e);
                z = true;
            }
        }
        if (z) {
            C1283.m16854("LaunchActivity", "Failed to initiate resolve, start regular user not signed in workflow");
            Error r3 = C1363Ci.m4430(status);
            C1363Ci.m4427(SignInLogging.CredentialService.GooglePlayService, IClientLogging.CompletionReason.failed, r3);
            C1363Ci.m4425(SignInLogging.SignInType.smartLock, IClientLogging.CompletionReason.failed, r3);
            m1979(getServiceManager());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1982(Credential credential) {
        m1988();
        showDebugToast("Google Play Services: Credential Retrieved");
        m1995(credential);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m1995(final Credential credential) {
        C1363Ci.m4427(SignInLogging.CredentialService.GooglePlayService, IClientLogging.CompletionReason.success, null);
        Display r6 = AbstractC1358Cd.m4350(this);
        C1283.m16854("LaunchActivity", "User is NOT logged in, redirect to Login screen with login credentials");
        if (mo2014()) {
            BW.m3928(ApplicationPerformanceMetricsLogging.UiStartupTrigger.touchGesture, IClientLogging.ModalView.login, Long.valueOf(this.f3174), r6, null, C1491aV.m5403(this));
        }
        getServiceManager().m9772(credential.getId(), credential.getPassword(), new AbstractC2061pj() { // from class: com.netflix.mediaclient.ui.launch.LaunchActivity.6
            @Override // o.AbstractC2061pj, o.oU
            public void onLoginComplete(final Status status) {
                LaunchActivity.this.runOnUiThread(new Runnable() { // from class: com.netflix.mediaclient.ui.launch.LaunchActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LaunchActivity.this.m1983(status, credential);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1983(Status status, Credential credential) {
        C1283.m16854("LaunchActivity", "Login Complete - Status: " + status);
        C1283.m16861("Login complete - Status: " + status);
        setRequestedOrientation(-1);
        if (status.mo298() || status.mo302() == StatusCode.NRD_REGISTRATION_EXISTS) {
            showDebugToast(getString(R.string.label_sign_in_successful));
            C1363Ci.m4425(SignInLogging.SignInType.smartLock, IClientLogging.CompletionReason.success, (Error) null);
            return;
        }
        C1283.m16850("LaunchActivity", "Login failed, redirect to LoginActivity with credential and status");
        m1991(getServiceManager(), credential, status);
        C1363Ci.m4425(SignInLogging.SignInType.smartLock, IClientLogging.CompletionReason.failed, C1343Bp.m4064(status));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        if (this.f3175 != null) {
            this.f3175.reconnect();
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 2) {
            C1283.m16850("LaunchActivity", "onActivityResult: uknown request code" + i);
            Error r3 = C1363Ci.m4424(i);
            C1363Ci.m4427(SignInLogging.CredentialService.GooglePlayService, IClientLogging.CompletionReason.failed, r3);
            C1363Ci.m4425(SignInLogging.SignInType.smartLock, IClientLogging.CompletionReason.failed, r3);
            m1979(getServiceManager());
        } else if (i2 == -1) {
            C1283.m16854("LaunchActivity", "onActivityResult: conflict resolved");
            m1982((Credential) intent.getParcelableExtra("com.google.android.gms.credentials.Credential"));
        } else {
            C1283.m16850("LaunchActivity", "Credential Read: NOT OK");
            showDebugToast("Google Play Services: Credential Read Failed");
            Error r32 = C1363Ci.m4424(i2);
            C1363Ci.m4427(SignInLogging.CredentialService.GooglePlayService, IClientLogging.CompletionReason.failed, r32);
            C1363Ci.m4425(SignInLogging.SignInType.smartLock, IClientLogging.CompletionReason.failed, r32);
            m1979(getServiceManager());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfileReadyToSelect() {
        C1283.m16862("LaunchActivity", "New profile requested - starting profile selection activity...");
        startActivity(ActivityC2383zq.m13737(this));
        AbstractActivityC2189ts.finishAllAccountActivities(this);
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleAccountDeactivated() {
        C1283.m16862("LaunchActivity", "Account deactivated ...");
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean hasInteractiveUI() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldAddSystemBarBackgroundViews() {
        return false;
    }
}
