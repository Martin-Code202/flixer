package com.netflix.mediaclient.acquisition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import o.AbstractActivityC2189ts;
import o.AbstractC1358Cd;
import o.AbstractC2060pi;
import o.ActivityC2383zq;
import o.C0505;
import o.C0614;
import o.C0962;
import o.C1004;
import o.C1278;
import o.C1283;
import o.C1300Ac;
import o.C1339Bl;
import o.C1376Cs;
import o.C1456Fq;
import o.C1457Fr;
import o.C2059ph;
import o.oV;
import o.zH;
import o.zO;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SetJavaScriptEnabled"})
public final class OnBoardingActivity extends zO {
    private static final String BOOT_URL = BOOT_URL;
    public static final Companion Companion = new Companion(null);
    private static final long PAGE_LOAD_TIMEOUT = TimeUnit.SECONDS.toMillis(5);
    private static final String TAG = TAG;
    private final String PREFERENCE_NON_MEMBER_PLAYBACK = "prefs_non_member_playback";
    private HashMap _$_findViewCache;
    private boolean loggingIn;
    private final OnBoardingActivity$loginQueryCallback$1 loginQueryCallback = new OnBoardingActivity$loginQueryCallback$1(this);
    private Runnable mAbortOnBoard = new OnBoardingActivity$mAbortOnBoard$1(this);
    private String mErrHandler;
    private Runnable mHandleError = new OnBoardingActivity$mHandleError$1(this);
    private final String mSharedContextSessionUuid = AbstractC1358Cd.m4355();
    private AbstractC2060pi mSignUpParams;
    private boolean mSignupOngoing;
    private zH mUiBoot;
    private boolean onLoadedBeenCalled;

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final boolean getLoggingIn() {
        return this.loggingIn;
    }

    public final void setLoggingIn(boolean z) {
        this.loggingIn = z;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final String getTAG() {
            return OnBoardingActivity.TAG;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final String getBOOT_URL() {
            return OnBoardingActivity.BOOT_URL;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final long getPAGE_LOAD_TIMEOUT() {
            return OnBoardingActivity.PAGE_LOAD_TIMEOUT;
        }

        public final Intent createStartIntent(Context context) {
            C1457Fr.m5025(context, "context");
            return new Intent(context, OnBoardingActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.zO, o.AbstractActivityC2189ts, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PerformanceProfiler.INSTANCE.m663(Sessions.ONRAMP_TTR);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showHelpInMenu() {
        return false;
    }

    public final Runnable getMAbortOnBoard$NetflixApp_release() {
        return this.mAbortOnBoard;
    }

    public final void setMAbortOnBoard$NetflixApp_release(Runnable runnable) {
        C1457Fr.m5025(runnable, "<set-?>");
        this.mAbortOnBoard = runnable;
    }

    @Override // o.AbstractActivityC2189ts, o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // o.zO
    public Object createJSBridge() {
        return new OnBoardingBridge();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new OnBoardingActivity$createManagerStatusListener$1(this);
    }

    @Override // o.zO
    public void provideDialog(String str, Runnable runnable) {
        C1457Fr.m5025(str, DeepErrorElement.Debug.MESSAGE);
        C1457Fr.m5025(runnable, "runHandler");
        displayDialog(C0505.m14491(this, this.handler, new C1278(null, str, getString(R.string.label_ok), runnable)));
    }

    @Override // o.zO
    public void provideTwoButtonDialog(String str, Runnable runnable) {
        C1457Fr.m5025(str, DeepErrorElement.Debug.MESSAGE);
        C1457Fr.m5025(runnable, "posHandler");
        displayDialog(C0505.m14491(this, this.handler, new C0505.If(null, str, getString(R.string.label_ok), runnable, getString(R.string.label_cancel), null)));
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C1376Cs.m4555(getApplicationContext(), (ValueCallback<Boolean>) null);
    }

    @Override // o.zO
    public void showToast(String str) {
        C1457Fr.m5025(str, "msg");
        C1004.m15961(this, str, 1);
    }

    public final Context getContext() {
        return this;
    }

    @Override // o.zO
    public Runnable getErrorHandler() {
        return this.mHandleError;
    }

    @Override // o.zO
    public Runnable getNextTask() {
        return this.mAbortOnBoard;
    }

    @Override // o.zO
    public String getBootUrl() {
        zH zHVar = this.mUiBoot;
        if (zHVar != null) {
            AbstractC2060pi piVar = this.mSignUpParams;
            zHVar.m13429(piVar != null ? piVar.mo9851() : null);
        }
        AbstractC2060pi piVar2 = this.mSignUpParams;
        return C1457Fr.m5015(piVar2 != null ? piVar2.mo9851() : null, (Object) Companion.getBOOT_URL());
    }

    @Override // o.zO
    public long getTimeout() {
        return Companion.getPAGE_LOAD_TIMEOUT();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfileReadyToSelect() {
        if (C1339Bl.m4051(this, this.PREFERENCE_NON_MEMBER_PLAYBACK, false)) {
            C1283.m16862(Companion.getTAG(), "Token activation complete for non-member playback, do not go to profile selection");
            return;
        }
        C1283.m16862(Companion.getTAG(), "New profile requested - starting profile selection activity...");
        startActivity(ActivityC2383zq.m13737(this));
        AbstractActivityC2189ts.finishAllAccountActivities(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onConfigureActionBarState(NetflixActionBar.iF.AbstractC0010 r3) {
        C1457Fr.m5025(r3, "builder");
        r3.mo403(false).mo396(false).mo399(true).mo401(NetflixActionBar.LogoType.START_ALIGNED);
    }

    public final Runnable getMHandleError$NetflixApp_release() {
        return this.mHandleError;
    }

    public final void setMHandleError$NetflixApp_release(Runnable runnable) {
        C1457Fr.m5025(runnable, "<set-?>");
        this.mHandleError = runnable;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.onramp;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public CustomerServiceLogging.EntryPoint getEntryPoint() {
        return CustomerServiceLogging.EntryPoint.profileGate;
    }

    @Override // o.zO
    public void onWebViewLoaded() {
        super.onWebViewLoaded();
    }

    /* access modifiers changed from: private */
    public final void handleLoginComplete(Status status) {
        if (status.mo307() != null) {
            status.mo307();
        }
        this.mSignupOngoing = false;
        StatusCode r4 = status.mo302();
        if (status.mo298() || C1457Fr.m5018(r4, StatusCode.NRD_REGISTRATION_EXISTS)) {
            showToast(R.string.label_sign_in_successful);
            Logger.INSTANCE.m133("SignIn");
            C1376Cs.m4555(getApplicationContext(), (ValueCallback<Boolean>) null);
            return;
        }
        Logger.INSTANCE.m134("SignIn", C1300Ac.m3532(status));
        StringBuilder append = new StringBuilder().append(getString(R.string.signup_login_fails)).append(" (");
        C1457Fr.m5016((Object) r4, "statusCode");
        provideDialog(append.append(r4.m271()).append(")").toString(), this.mHandleError);
        if (this.mErrHandler != null) {
            String str = "javascript:" + this.mErrHandler + "('" + r4.m271() + "')";
            C1283.m16854(Companion.getTAG(), "Executing the following javascript:" + str);
            getWebView().loadUrl(str);
            this.mErrHandler = null;
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfileActivated() {
        if (!C1339Bl.m4051(this, this.PREFERENCE_NON_MEMBER_PLAYBACK, false)) {
            super.handleProfileActivated();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleAccountDeactivated() {
        if (!C1339Bl.m4051(this, this.PREFERENCE_NON_MEMBER_PLAYBACK, false)) {
            super.handleAccountDeactivated();
        }
    }

    public final class OnBoardingBridge {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public OnBoardingBridge() {
        }

        @JavascriptInterface
        public final void loginToApp(String str, String str2) {
            C1457Fr.m5025(str, "json");
            C1457Fr.m5025(str2, "errHandler");
            if (OnBoardingActivity.this.mSignupOngoing) {
                C1283.m16854(OnBoardingActivity.Companion.getTAG(), "loginToApp ongoing, returning NULL operation");
                return;
            }
            C1283.m16854(OnBoardingActivity.Companion.getTAG(), "Login with Tokens " + str + " ErrHandler: " + str2);
            OnBoardingActivity.this.mErrHandler = str2;
            if (!ConnectivityUtils.m2970(OnBoardingActivity.this)) {
                OnBoardingActivity.this.noConnectivityWarning();
                return;
            }
            try {
                C0614 r4 = new C0614(new JSONObject(str));
                C2059ph serviceManager = OnBoardingActivity.this.getServiceManager();
                C1457Fr.m5016((Object) serviceManager, "svcManager");
                if (serviceManager.mo9519()) {
                    C1339Bl.m4048((Context) OnBoardingActivity.this, OnBoardingActivity.this.PREFERENCE_NON_MEMBER_PLAYBACK, false);
                    Logger.INSTANCE.m142(new C0962());
                    serviceManager.m9806(r4, OnBoardingActivity.this.loginQueryCallback);
                    OnBoardingActivity.this.mSignupOngoing = true;
                    OnBoardingActivity.this.runOnUiThread(new OnBoardingActivity$OnBoardingBridge$loginToApp$1(this));
                    return;
                }
                C1283.m16854(OnBoardingActivity.Companion.getTAG(), "loginToApp, invalid state to Login, bailing out");
            } catch (JSONException e) {
                C1283.m16847(OnBoardingActivity.Companion.getTAG(), "Failed to LoginToApp", e);
                OnBoardingActivity.this.mSignupOngoing = false;
                OnBoardingActivity onBoardingActivity = OnBoardingActivity.this;
                String string = OnBoardingActivity.this.getString(R.string.signup_login_fails);
                C1457Fr.m5016((Object) string, "getString(R.string.signup_login_fails)");
                onBoardingActivity.provideDialog(string, OnBoardingActivity.this.getMHandleError$NetflixApp_release());
            }
        }

        @JavascriptInterface
        public final void passNonMemberInfo(String str) {
            C1457Fr.m5025(str, "nonMemberInfo");
        }

        @JavascriptInterface
        public final void onLoaded() {
        }

        @JavascriptInterface
        public final void notifyReady() {
        }

        @JavascriptInterface
        public final void supportsSignUp(String str) {
            C1457Fr.m5025(str, "flag");
        }

        @JavascriptInterface
        public final void setLanguage(String str) {
            C1457Fr.m5025(str, LoggingRequest.LOCALE);
        }

        @JavascriptInterface
        public final void showSignIn() {
        }

        @JavascriptInterface
        public final void showSignOut() {
        }
    }

    @Override // o.zO, com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        if (this.loggingIn) {
            return true;
        }
        getServiceManager().m9755(new OnBoardingActivity$handleBackPressed$MemberHomeCallback(this));
        this.loggingIn = true;
        return true;
    }
}
