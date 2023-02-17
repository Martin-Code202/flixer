package o;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.partner.PartnerInstallType;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.log.UIScreen;
import com.netflix.model.leafs.PostPlayItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import o.C0683;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SetJavaScriptEnabled"})
public class zJ extends zO implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f12614 = false;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean f12615;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f12616;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final BroadcastReceiver f12617 = new BroadcastReceiver() { // from class: o.zJ.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            zJ.this.invalidateOptionsMenu();
        }
    };

    /* renamed from: ʽ  reason: contains not printable characters */
    private C0683 f12618;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean f12619;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final AbstractC2061pj f12620 = new AbstractC2061pj() { // from class: o.zJ.4
        @Override // o.AbstractC2061pj, o.oU
        public void onLoginComplete(final Status status) {
            zJ.this.runOnUiThread(new Runnable() { // from class: o.zJ.4.1
                @Override // java.lang.Runnable
                public void run() {
                    zJ.this.m13445(status);
                }
            });
        }
    };

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f12621;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f12622 = true;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f12623;

    /* renamed from: ˋ  reason: contains not printable characters */
    Runnable f12624 = new Runnable() { // from class: o.zJ.11
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("SignupActivity", "Timeout triggered, switching to LoginActivity");
            if (!zJ.this.f12626) {
                zJ.this.startNextActivity(ActivityC2186tp.m11240(zJ.this));
                zJ.this.finish();
            }
        }
    };

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private String f12625;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f12626 = false;

    /* renamed from: ˏ  reason: contains not printable characters */
    Runnable f12627 = new Runnable() { // from class: o.zJ.1
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("SignupActivity", "Handling error during signup");
            C1376Cs.m4555(zJ.this.getApplicationContext(), new ValueCallback<Boolean>() { // from class: o.zJ.1.3
                /* renamed from: ˏ  reason: contains not printable characters */
                public void onReceiveValue(Boolean bool) {
                    zJ.this.startNextActivity(ActivityC2186tp.m11240(zJ.this));
                    zJ.this.finish();
                }
            });
        }
    };

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f12628;

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f12629;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f12630;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String f12631;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f12632;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private GoogleApiClient f12633;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private AbstractC2060pi f12634;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f12635;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f12636;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private String f12637;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Intent m13442(Context context) {
        if (AD.m3299()) {
            try {
                Intent intent = new Intent(context, zG.class);
                intent.addFlags(67141632);
                return intent;
            } catch (ActivityNotFoundException e) {
                C1283.m16847("SignupActivity", "Failed to start LoginTabletActivity Activity!", e);
                C1276.m16820().mo5730(e);
            }
        }
        Intent intent2 = new Intent(context, zJ.class);
        intent2.addFlags(67141632);
        return intent2;
    }

    @Override // o.zO, com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        if (getWebView() == null || !getWebView().canGoBackOrForward(-1)) {
            return false;
        }
        if (getWebView().canGoBackOrForward(-2) || !this.f12622) {
            provideTwoButtonDialog(getString(R.string.signup_interrupt_by_user), new Runnable() { // from class: o.zJ.8
                @Override // java.lang.Runnable
                public void run() {
                    zJ.this.reload(false);
                }
            });
            return true;
        }
        getWebView().goBack();
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        if (this.f12633 != null) {
            this.f12633.reconnect();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        C1283.m16854("SignupActivity", "onConnected");
        m13451(this.f12633);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f12633 = null;
    }

    /* access modifiers changed from: protected */
    @Override // o.zO, o.AbstractActivityC2189ts, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        startRenderNavigationLevelSession();
        super.onCreate(bundle);
        if (bundle == null) {
            PerformanceProfiler.INSTANCE.m663(Sessions.SIGN_UP);
        }
        if (m13464()) {
            startNextActivity(ActivityC2186tp.m11240(this));
            finish();
        }
        if (AS.m3410(this)) {
            this.f12633 = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Auth.CREDENTIALS_API).build();
            this.f12633.connect();
        }
        this.f12636 = m13476();
        this.f12616 = !this.f12636;
        if (this.f12636) {
            C1283.m16854("SignupActivity", "play billing is available. starting...");
            this.f12618 = new C0683(this, getHandler());
            this.f12618.m14950(new C0683.Cif() { // from class: o.zJ.6
                @Override // o.C0683.Cif
                public void onSetupFinished(boolean z) {
                    C1283.m16854("SignupActivity", "play billing setup finished.");
                    zJ.this.f12616 = true;
                    if (zJ.this.f12618 == null) {
                        C1283.m16854("SignupActivity", "activity disposed already.. quit");
                    } else if (!zJ.this.getServiceManager().mo9519()) {
                        C1283.m16854("SignupActivity", "serviceManager not ready yet.. deferring");
                    } else {
                        if (!z) {
                            C1283.m16850("SignupActivity", "Problem setting up in-app billing: ");
                        }
                        C1348Bu.m4093();
                        zJ.this.setViews(zJ.this.getServiceManager(), zJ.this.m13456(zJ.this.getApplicationContext()));
                    }
                }
            });
        }
        registerReceiverWithAutoUnregister(this.f12617, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onConfigureActionBarState(NetflixActionBar.iF.AbstractC0010 r3) {
        r3.mo396(false).mo399(true).mo401(NetflixActionBar.LogoType.START_ALIGNED);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void setTheme() {
        SignInConfigData r1 = new C0365(this).m14067();
        if (r1 == null || !r1.useDarkHeader()) {
            setTheme(R.style.res_2131952240_theme_signup);
        } else {
            setTheme(R.style.res_2131952242_theme_signup_ourstory);
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        C2059ph serviceManager = getServiceManager();
        if (serviceManager != null && serviceManager.mo9519() && serviceManager.m9758() && !this.f12615) {
            this.f12626 = false;
            getBootLoader().m13429(this.f12634.mo9851());
            runOnUiThread(new Runnable() { // from class: o.zJ.7
                @Override // java.lang.Runnable
                public void run() {
                    C1283.m16854("SignupActivity", "Disabling webview visibility");
                    zJ.this.webViewVisibility(false);
                }
            });
            getWebView().loadUrl(getBootLoader().m13430());
            serviceManager.m9795(false);
        }
        this.f12615 = false;
        super.onResume();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.app.Activity
    public void finish() {
        super.finish();
        PerformanceProfiler.INSTANCE.m672(Sessions.SIGN_UP);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m13464() {
        return Build.MANUFACTURER.toLowerCase().contains("amazon");
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f12633 != null) {
            this.f12633.disconnect();
        }
        if (this.f12618 != null) {
            C1283.m16854("SignupActivity", "Destroying inAppBilling.");
            this.f12618.m14948();
            this.f12618 = null;
        }
        if (isFinishing() && !this.f12619) {
            m13446(IClientLogging.CompletionReason.canceled);
        }
        if (isFinishing() && !this.f12621) {
            Logger.INSTANCE.m133("RenderNavigationLevel");
        }
    }

    @Override // o.zO
    public Runnable getNextTask() {
        return this.f12624;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showHelpInMenu() {
        if (!ConnectivityUtils.m2970(this) || getServiceManager() == null || getServiceManager().m9827() == null) {
            return false;
        }
        return getServiceManager().m9827().mo16557();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onCreateOptionsMenu(Menu menu, Menu menu2) {
        MenuItem menuItem;
        View actionView;
        if (this.f12622) {
            MenuItem add = menu.add(0, R.id.menu_sign_in, 0, getString(R.string.label_sign_in));
            add.setShowAsAction(1);
            add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: o.zJ.10
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem2) {
                    C1283.m16854("SignupActivity", "User tapped sign-in button");
                    zJ.this.f12632 = true;
                    Logger.INSTANCE.m142(new C0962());
                    C1362Ch.m4404((UserActionLogging.CommandName) null, zJ.this.getUiScreen().f4084);
                    zJ.this.startNextActivity(ActivityC2186tp.m11240(zJ.this));
                    return true;
                }
            });
            menuItem = add;
        } else {
            MenuItem add2 = menu.add(0, R.id.menu_sign_out, 0, getString(R.string.label_sign_out));
            add2.setShowAsAction(1);
            add2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: o.zJ.14
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem2) {
                    zJ.this.m13444();
                    return true;
                }
            });
            menuItem = add2;
        }
        if (!(menuItem == null || (actionView = menuItem.getActionView()) == null || actionView.isInTouchMode())) {
            actionView.requestFocus();
        }
        super.onCreateOptionsMenu(menu, menu2);
    }

    /* renamed from: o.zJ$ˊ  reason: contains not printable characters */
    class C0315 extends oP {
        public C0315() {
            super("SignupActivity");
        }

        @Override // o.oP, o.oU
        public void onLogoutComplete(Status status) {
            super.onLogoutComplete(status);
            zJ.this.webViewVisibility(true);
            zJ.this.reload(true);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13444() {
        webViewVisibility(false);
        runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.zJ.12
            @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
            public void run(C2059ph phVar) {
                phVar.m9760(new C0315());
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zJ$iF  reason: case insensitive filesystem */
    public class C2363iF extends WebChromeClient {
        private C2363iF() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }
    }

    public class If {
        public If() {
        }

        @JavascriptInterface
        public void toSignIn() {
            C1283.m16854("SignupActivity", "Redirecting to Login screen");
            zJ.this.startNextActivity(ActivityC2186tp.m11240(zJ.this));
            zJ.this.finish();
        }

        @JavascriptInterface
        public void passNonMemberInfo(String str) {
            C1283.m16844("SignupActivity", "Ignoring passNonMemberInfo %s", str);
        }

        @JavascriptInterface
        public void showSignIn() {
            C1283.m16854("SignupActivity", "Show SignIn: ");
            zJ.this.f12622 = true;
            zJ.this.m13470();
        }

        @JavascriptInterface
        public void showSignOut() {
            C1283.m16854("SignupActivity", "Show SignOut");
            zJ.this.f12622 = false;
            zJ.this.m13470();
        }

        @JavascriptInterface
        public void loginCompleted() {
            C1283.m16854("SignupActivity", "loginCompleted, noop");
        }

        @JavascriptInterface
        public void signupCompleted() {
            C1283.m16854("SignupActivity", "signupCompleted, report");
            AR.m3404(zJ.this);
        }

        @JavascriptInterface
        public void launchUrl(String str) {
            String str2;
            if (str == null) {
                str2 = "http://netflix.com";
            } else {
                str2 = str.trim();
                if (!str2.toLowerCase(Locale.ENGLISH).startsWith("http")) {
                    str2 = "http://" + str2;
                }
            }
            zJ.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
        }

        @JavascriptInterface
        public String getESN() {
            if (zJ.this.f12631 != null) {
                return zJ.this.f12631;
            }
            return "";
        }

        @JavascriptInterface
        public String getESNPrefix() {
            if (zJ.this.f12629 != null) {
                return zJ.this.f12629;
            }
            return "";
        }

        @JavascriptInterface
        public String getSoftwareVersion() {
            if (zJ.this.f12625 != null) {
                return zJ.this.f12625;
            }
            return "";
        }

        @JavascriptInterface
        public String getDeviceCategory() {
            if (zJ.this.f12628 != null) {
                return zJ.this.f12628;
            }
            return "phone";
        }

        @JavascriptInterface
        public String getLanguage() {
            return zJ.this.getDeviceLanguage();
        }

        @JavascriptInterface
        public void setLanguage(String str) {
            boolean equals = str.equals(getLanguage());
            C1283.m16854("SignupActivity", "Update language to " + str);
            if (!equals) {
                C2059ph serviceManager = zJ.this.getServiceManager();
                if (serviceManager == null || !serviceManager.mo9519()) {
                    C1283.m16865("SignupActivity", "setLanguage  failed, invalid state");
                    return;
                }
                zJ.this.getServiceManager().m9794(str);
                zJ.this.m13470();
            }
        }

        @JavascriptInterface
        public void supportsSignUp(String str) {
            C1283.m16854("SignupActivity", "SupportSignUp flag: " + str);
        }

        @JavascriptInterface
        public String isNetflixPreloaded() {
            if (C1317As.m3770(zJ.this)) {
                return "true";
            }
            return "false";
        }

        @JavascriptInterface
        public String isPlayBillingEnabled() {
            C2059ph serviceManager = zJ.this.getServiceManager();
            if (serviceManager == null || !serviceManager.mo9519() || zJ.this.getServiceManager().m9827() == null) {
                return "false";
            }
            AbstractC1221 r2 = zJ.this.getServiceManager().m9827();
            return !r2.mo16535() && !PartnerInstallType.m482(r2.mo16562()) ? "true" : "false";
        }

        @JavascriptInterface
        public void notifyReady() {
            C1283.m16854("SignupActivity", "Signup UI ready to interact");
            zJ.this.getHandler().removeCallbacks(zJ.this.f12624);
            zJ.this.f12619 = true;
            zJ.this.m13446(IClientLogging.CompletionReason.success);
            zJ.this.runOnUiThread(new Runnable() { // from class: o.zJ.If.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!zJ.this.f12626) {
                        zJ.this.webViewVisibility(true);
                        zJ.this.f12626 = true;
                    }
                }
            });
        }

        @JavascriptInterface
        public void notifyOnRendered() {
            C1283.m16854("SignupActivity", "All images rendered");
            zJ.this.f12621 = true;
            C1283.m16846("SignupActivity", "End session NM_TTR");
            Logger.INSTANCE.m133("RenderNavigationLevel");
        }

        @JavascriptInterface
        public void loginToApp(String str, String str2) {
            if (zJ.this.f12614) {
                C1283.m16854("SignupActivity", "loginToApp ongoing, returning NULL operation");
                return;
            }
            C1283.m16854("SignupActivity", "Login with Tokens " + str + " ErrHandler: " + str2);
            zJ.this.f12630 = str2;
            if (!ConnectivityUtils.m2970(zJ.this)) {
                zJ.this.noConnectivityWarning();
                return;
            }
            try {
                C0614 r4 = new C0614(new JSONObject(str));
                C2059ph serviceManager = zJ.this.getServiceManager();
                if (serviceManager == null || !serviceManager.mo9519()) {
                    C1283.m16854("SignupActivity", "loginToApp, invalid state to Login, bailing out");
                    return;
                }
                C1339Bl.m4048((Context) zJ.this, "prefs_non_member_playback", false);
                Logger.INSTANCE.m142(new C0962());
                serviceManager.m9806(r4, zJ.this.f12620);
                zJ.this.f12614 = true;
                zJ.this.runOnUiThread(new Runnable() { // from class: o.zJ.If.3
                    @Override // java.lang.Runnable
                    public void run() {
                        C1283.m16854("SignupActivity", "Disabling webview visibility");
                        zJ.this.webViewVisibility(false);
                    }
                });
            } catch (JSONException e) {
                C1283.m16847("SignupActivity", "Failed to LoginToApp", e);
                zJ.this.f12614 = false;
                zJ.this.provideDialog(zJ.this.getString(R.string.signup_login_fails), zJ.this.f12627);
            }
        }

        @JavascriptInterface
        public void logoutOfApp() {
            zJ.this.m13444();
        }

        @JavascriptInterface
        public void saveUserCredentials(String str, String str2) {
            zJ.this.f12623 = str;
            zJ.this.f12637 = str2;
            zJ.this.runOnUiThread(new Runnable() { // from class: o.zJ.If.2
                @Override // java.lang.Runnable
                public void run() {
                    zJ.this.m13438();
                }
            });
        }

        @JavascriptInterface
        public void playBillingGetSkuDetails(String str, String str2) {
            String[] split = str.split(",");
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str3 : split) {
                arrayList.add(str3.trim());
            }
            if (!zJ.this.m13459()) {
                C1283.m16850("SignupActivity", "playBillingGetSkuDetails - playBillingNotReady");
                m13484(str2, null);
                return;
            }
            zJ.this.f12618.m14961(arrayList, new AbstractC0687(str2) { // from class: o.zJ.If.5
                @Override // o.AbstractC0687
                /* renamed from: ˊ */
                public void mo13485(JSONObject jSONObject) {
                    If.this.m13484(m14966(), jSONObject);
                }
            });
        }

        @JavascriptInterface
        public void playBillingGetPurchases(String str, String str2) {
            String r3 = zJ.this.m13449(str);
            C1283.m16854("SignupActivity", "playBillingGetPurchases");
            if (!zJ.this.m13459()) {
                C1283.m16850("SignupActivity", "playBillingGetPurchases - playBillingNotReady");
                m13484(str2, null);
                return;
            }
            zJ.this.f12618.m14955(r3, new AbstractC0687(str2) { // from class: o.zJ.If.7
                @Override // o.AbstractC0687
                /* renamed from: ˊ */
                public void mo13485(JSONObject jSONObject) {
                    If.this.m13484(m14966(), jSONObject);
                }
            });
        }

        @JavascriptInterface
        public void playBillingGetPurchaseHistory(String str, String str2) {
            String r3 = zJ.this.m13449(str);
            C1283.m16854("SignupActivity", "playBillingGetPurchaseHistory");
            if (!zJ.this.m13459()) {
                C1283.m16850("SignupActivity", "playBillingGetPurchaseHistory - playBillingNotReady");
                m13484(str2, null);
                return;
            }
            zJ.this.f12618.m14949(r3, new AbstractC0687(str2) { // from class: o.zJ.If.10
                @Override // o.AbstractC0687
                /* renamed from: ˊ  reason: contains not printable characters */
                public void mo13485(JSONObject jSONObject) {
                    If.this.m13484(m14966(), jSONObject);
                }
            });
        }

        @JavascriptInterface
        public void playBillingPurchase(String str, String str2, int i, String str3, String str4) {
            Boolean.valueOf(C1339Bl.m4051(zJ.this, "webview_use_mocking", false));
            String r13 = zJ.this.m13449(str3);
            String r11 = zJ.this.m13449(str2);
            if (!zJ.this.m13459()) {
                C1283.m16850("SignupActivity", "playBillingPurchase - playBillingNotReady");
                m13484(str4, null);
                return;
            }
            zJ.this.f12618.m14957(zJ.this, str, r11, i, r13, 2, new AbstractC0687(str4) { // from class: o.zJ.If.8
                @Override // o.AbstractC0687
                /* renamed from: ˊ */
                public void mo13485(JSONObject jSONObject) {
                    If.this.m13484(m14966(), jSONObject);
                }
            });
        }

        @JavascriptInterface
        public void playVideo(int i, int i2, String str, String str2) {
            C2059ph serviceManager = zJ.this.getServiceManager();
            if (serviceManager != null && serviceManager.mo9519()) {
                serviceManager.m9795(true);
            }
            VideoType videoType = PostPlayItem.POST_PLAY_ITEM_EPISODE.equals(str) ? VideoType.EPISODE : VideoType.MOVIE;
            qN qNVar = new qN("mcplayer", i2, 0, 0);
            zJ.this.getBootLoader().m13431(Integer.toString(i));
            zJ.this.startActivityForResult(ActivityC2270wl.m12433(zJ.this, Integer.toString(i), videoType, qNVar), 20);
        }

        @JavascriptInterface
        public void playbackTokenActivate(String str, final String str2) {
            if (zJ.this.f12614) {
                C1283.m16854("SignupActivity", "Another potential token activate ongoing, returning NULL operation");
                return;
            }
            C1283.m16854("SignupActivity", "Token Activate with Tokens " + str);
            if (!ConnectivityUtils.m2970(zJ.this)) {
                zJ.this.noConnectivityWarning();
                return;
            }
            try {
                C0614 r4 = new C0614(new JSONObject(str));
                C2059ph serviceManager = zJ.this.getServiceManager();
                if (serviceManager == null || !serviceManager.mo9519()) {
                    C1283.m16854("SignupActivity", "tokenActivate, invalid state to token activate, bailing out");
                } else if (serviceManager.m9789()) {
                    zJ.this.runOnUiThread(new Runnable() { // from class: o.zJ.If.9
                        @Override // java.lang.Runnable
                        public void run() {
                            If.this.m13484(str2, null);
                        }
                    });
                } else {
                    Logger.INSTANCE.m142(new C0392());
                    C1339Bl.m4048((Context) zJ.this, "prefs_non_member_playback", true);
                    serviceManager.m9806(r4, new AbstractC2061pj() { // from class: o.zJ.If.1
                        @Override // o.AbstractC2061pj, o.oU
                        public void onLoginComplete(Status status) {
                            If.this.m13481(status, str2);
                        }
                    });
                }
            } catch (JSONException e) {
                C1283.m16847("SignupActivity", "Failed to TokenActivate", e);
                zJ.this.f12614 = false;
                zJ.this.provideDialog(zJ.this.getString(R.string.signup_login_fails), zJ.this.f12627);
            }
        }

        @JavascriptInterface
        public void logIDFAEvent(String str) {
            zN.f12697.m13527(zJ.this.getServiceManager(), str);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˋ  reason: contains not printable characters */
        private void m13481(Status status, String str) {
            if (status.mo307() != null) {
                status.mo307();
            }
            zJ.this.f12614 = false;
            StatusCode r5 = status.mo302();
            if (status.mo298() || r5 == StatusCode.NRD_REGISTRATION_EXISTS) {
                Logger.INSTANCE.m133("SignIn");
                m13484(str, null);
                return;
            }
            Logger.INSTANCE.m134("SignIn", C1300Ac.m3532(status));
            zJ.this.provideDialog(zJ.this.getString(R.string.signup_login_fails) + " (" + r5.m271() + ")", zJ.this.f12627);
            if (str != null) {
                String str2 = "javascript:" + str + "('" + r5.m271() + "')";
                C1283.m16854("SignupActivity", "Executing the following javascript:" + str2);
                zJ.this.getWebView().loadUrl(str2);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private void m13484(String str, JSONObject jSONObject) {
            zJ.this.getWebView().loadUrl("javascript:" + str + "('" + jSONObject + "')");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13446(IClientLogging.CompletionReason completionReason) {
        HashMap hashMap = new HashMap();
        String name = completionReason.name();
        hashMap.put("reason", name);
        C1283.m16848("SignupActivity", "End session NM_TTI with reason %s", name);
        PerformanceProfiler.INSTANCE.m665(Sessions.NON_MEMBER_TTI, hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m13459() {
        return this.f12618 != null && this.f12618.m14962();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private String m13449(String str) {
        return (!C1349Bv.m4107(str) || C1349Bv.m4126(str, "undefined")) ? "" : str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13470() {
        runOnUiThread(new Runnable() { // from class: o.zJ.13
            @Override // java.lang.Runnable
            public void run() {
                zJ.this.invalidateOptionsMenu();
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.zJ.5
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                if (!zJ.m13464()) {
                    if (zJ.this.f12616) {
                        C1348Bu.m4093();
                        zJ.this.setViews(phVar, zJ.this.m13456(phVar.m9814()));
                        return;
                    }
                    C1283.m16854("SignupActivity", "seviceMgr ready but waiting for playBilling setup to finish");
                }
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                C1283.m16850("SignupActivity", "NetflixService is NOT available!");
            }
        };
    }

    @Override // o.zO
    public String getBootUrl() {
        return this.f12634.mo9851();
    }

    @Override // o.zO
    public long getTimeout() {
        return this.f12634.mo9850();
    }

    /* access modifiers changed from: protected */
    @Override // o.zO
    public void setViews(C2059ph phVar, boolean z) {
        this.f12631 = phVar.m9777().mo14449();
        this.f12629 = phVar.m9777().mo14442();
        this.f12625 = phVar.m9775();
        this.f12628 = phVar.m9778().m2972();
        this.f12634 = phVar.m9786();
        super.setViews(phVar, z);
        getWebView().setWebChromeClient(new C2363iF());
    }

    @Override // o.zO
    public Object createJSBridge() {
        return new If();
    }

    @Override // o.zO
    public Runnable getErrorHandler() {
        return this.f12627;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfileReadyToSelect() {
        if (this.f12632) {
            C1283.m16862("SignupActivity", "Login activity is in focus, leave it to finish all account activities when it is ready");
        } else if (C1339Bl.m4051(this, "prefs_non_member_playback", false)) {
            C1283.m16862("SignupActivity", "Token activation complete for non-member playback, do not go to profile selection");
        } else {
            C1283.m16862("SignupActivity", "New profile requested - starting profile selection activity...");
            startActivity(ActivityC2383zq.m13737(this));
            finishAllAccountActivities(this);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13445(Status status) {
        if (status.mo307() != null) {
            status.mo307();
        }
        this.f12614 = false;
        StatusCode r4 = status.mo302();
        if (status.mo298() || r4 == StatusCode.NRD_REGISTRATION_EXISTS) {
            showToast(R.string.label_sign_in_successful);
            Logger.INSTANCE.m133("SignIn");
            C1376Cs.m4555(getApplicationContext(), (ValueCallback<Boolean>) null);
            return;
        }
        Logger.INSTANCE.m134("SignIn", C1300Ac.m3532(status));
        provideDialog(getString(R.string.signup_login_fails) + " (" + r4.m271() + ")", this.f12627);
        if (this.f12630 != null) {
            String str = "javascript:" + this.f12630 + "('" + r4.m271() + "')";
            C1283.m16854("SignupActivity", "Executing the following javascript:" + str);
            getWebView().loadUrl(str);
            this.f12630 = null;
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.nmLanding;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f12632 = false;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean m13476() {
        return AD.m3321(this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13452(com.google.android.gms.common.api.Status status) {
        if (status == null || !status.hasResolution()) {
            C1283.m16850("SignupActivity", "Google Play Services: STATUS: FAIL");
            showDebugToast("Google Play Services: Could Not Resolve Error");
            Logger.INSTANCE.m134("RequestSharedCredentials", null);
            return;
        }
        C1283.m16854("SignupActivity", "Google Play Services: STATUS: RESOLVING");
        try {
            status.startResolutionForResult(this, 1);
        } catch (IntentSender.SendIntentException e) {
            C1283.m16847("SignupActivity", "Google Play Services: STATUS: Failed to send resolution.", e);
            Logger.INSTANCE.m134("RequestSharedCredentials", null);
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                showDebugToast("Account credentials saved!");
            } else {
                showDebugToast("Failed to save account credentials!");
            }
        } else if (i == 2) {
            this.f12618.m14956(i, i2, intent);
        } else if (i == 20 && i2 == 21) {
            C2059ph serviceManager = getServiceManager();
            String stringExtra = intent.getStringExtra("nextUrl");
            String r5 = this.f12634.mo9851();
            Uri parse = Uri.parse(r5);
            getBootLoader().m13429(stringExtra != null ? parse.getScheme() + "://" + parse.getHost() + stringExtra : r5);
            this.f12615 = true;
            this.f12626 = false;
            runOnUiThread(new Runnable() { // from class: o.zJ.3
                @Override // java.lang.Runnable
                public void run() {
                    C1283.m16854("SignupActivity", "Disabling webview visibility");
                    zJ.this.webViewVisibility(false);
                }
            });
            getWebView().loadUrl(getBootLoader().m13430());
            if (serviceManager != null && serviceManager.mo9519()) {
                serviceManager.m9760(null);
            }
        } else {
            C1283.m16850("SignupActivity", "onActivityResult: unknown request code" + i);
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfileActivated() {
        if (!C1339Bl.m4051(this, "prefs_non_member_playback", false)) {
            super.handleProfileActivated();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private synchronized void m13451(GoogleApiClient googleApiClient) {
        if (googleApiClient == null) {
            C1283.m16854("SignupActivity", "GPS client is null, unable to try to save credentials");
            return;
        }
        if (this.f12635) {
            C1283.m16854("SignupActivity", "Trying to save credentials to GPS");
            this.f12635 = false;
            if (C1349Bv.m4113(this.f12623) || C1349Bv.m4113(this.f12637)) {
                C1283.m16865("SignupActivity", "Credential is empty, do not save it.");
            } else {
                Auth.CredentialsApi.save(googleApiClient, new Credential.Builder(this.f12623).setPassword(this.f12637).build()).setResultCallback(new ResultCallback<com.google.android.gms.common.api.Status>() { // from class: o.zJ.9
                    /* renamed from: ˏ  reason: contains not printable characters */
                    public void onResult(com.google.android.gms.common.api.Status status) {
                        if (C1317As.m3750(zJ.this)) {
                            C1283.m16850("SignupActivity", "Auth.CredentialsApi.request ActivityFinishedOrDestroyed");
                        } else if (status.isSuccess()) {
                            C1283.m16854("SignupActivity", "SAVE: OK");
                            zJ.this.showDebugToast("Credential Saved");
                        } else {
                            zJ.this.m13452(status);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private synchronized void m13438() {
        if (AS.m3410(this)) {
            GoogleApiClient googleApiClient = this.f12633;
            if (googleApiClient == null) {
                C1283.m16854("SignupActivity", "GPS client unavailable, unable to attempt to save credentials");
                return;
            }
            this.f12635 = true;
            if (googleApiClient.isConnected()) {
                m13451(googleApiClient);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public CustomerServiceLogging.EntryPoint getEntryPoint() {
        return CustomerServiceLogging.EntryPoint.nonMemberLanding;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleAccountDeactivated() {
        if (!C1339Bl.m4051(this, "prefs_non_member_playback", false)) {
            super.handleAccountDeactivated();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m13456(Context context) {
        return this.f12636 && this.f12616 && this.f12618 != null && this.f12618.m14962() && m13478();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m13478() {
        C2059ph serviceManager = getServiceManager();
        if (serviceManager == null || !serviceManager.mo9519() || getServiceManager().m9827() == null) {
            C1283.m16854("SignupActivity", "serviceMgr & configurationAgent is not ready.. disable play billing");
            return false;
        }
        return !serviceManager.m9827().mo16535() && (!PartnerInstallType.m482(serviceManager.m9827().mo16562()) || serviceManager.m9827().mo16542());
    }
}
