package o;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ViewFlipper;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.webclient.model.leafs.NonMemberData;
import java.util.ArrayList;
import o.C0505;
public abstract class zO extends AbstractActivityC2189ts {
    private static final String COOKIE_SUFFIX = "; ";
    private static final String DEFAULT_LOCALE = "en";
    private static final String NETFLIX_DOMAIN = ".netflix.com";
    private static final String TAG = "WebViewAccountActivity";
    protected static final String USE_LATEST_COOKIES = "useDynecomCookies";
    private ViewFlipper mFlipper;
    private String mSharedContextSessionUuid = AbstractC1358Cd.m4355();
    private zH mUiBoot;
    private WebView mWebView;
    private zI mWebViewClient;
    private boolean mWebViewLoaded;
    private boolean mWebViewVisibility;

    public abstract Object createJSBridge();

    public abstract String getBootUrl();

    public abstract Runnable getErrorHandler();

    public abstract Runnable getNextTask();

    public abstract long getTimeout();

    public boolean isWebViewLoaded() {
        return this.mWebViewLoaded;
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public zH getBootLoader() {
        return this.mUiBoot;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        if (this.mWebView == null || !this.mWebView.canGoBackOrForward(-1)) {
            return false;
        }
        return true;
    }

    @TargetApi(19)
    private void enableWebViewDebugging() {
        C1283.m16854(TAG, "Attempting to enable WebView Debugging. API Level: " + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    @Override // o.AbstractActivityC2189ts, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.signup_activity);
        this.mWebView = (WebView) findViewById(R.id.signUpWebView);
        this.mFlipper = (ViewFlipper) findViewById(R.id.flipper);
        this.mWebViewClient = createWebViewClient();
        C1317As.m3765((Activity) this);
    }

    public zI createWebViewClient() {
        return new zI(this) { // from class: o.zO.5

            /* renamed from: ˋ  reason: contains not printable characters */
            boolean f12702;

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                this.f12702 = false;
            }

            @Override // o.zI, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                this.f12702 = true;
                return super.shouldOverrideUrlLoading(webView, str);
            }

            @Override // o.zI, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!this.f12702) {
                    zO.this.onWebViewLoaded();
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void setViews(C2059ph phVar, boolean z) {
        Intent intent = getIntent();
        String bootUrl = getBootUrl();
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        this.mWebView.addJavascriptInterface(createJSBridge(), "nfandroid");
        this.mWebView.setWebViewClient(this.mWebViewClient);
        this.mWebView.setOnTouchListener(new View.OnTouchListener() { // from class: o.zO.1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (view.hasFocus()) {
                            return false;
                        }
                        view.requestFocus();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.mUiBoot = new zH(phVar, bootUrl, getDeviceLanguage(), z, this.mSharedContextSessionUuid);
        if (intent.getStringExtra("nextUrl") != null) {
            String stringExtra = intent.getStringExtra("nextUrl");
            String bootUrl2 = getBootUrl();
            Uri parse = Uri.parse(bootUrl2);
            getBootLoader().m13429(stringExtra != null ? parse.getScheme() + "://" + parse.getHost() + stringExtra : bootUrl2);
        }
        C1283.m16854(TAG, "URL: " + this.mUiBoot.m13430());
        BW.m3929(this.mSharedContextSessionUuid);
        C1283.m16854(TAG, "All the cookies in a string:" + CookieManager.getInstance().getCookie(NETFLIX_DOMAIN));
        getIntent().getExtras();
        Boolean bool = true;
        setNonMemberCookies(phVar.m9827(), phVar.m9827().mo16531(), bool.booleanValue());
        this.mWebView.loadUrl(this.mUiBoot.m13430());
        BW.m3929(this.mSharedContextSessionUuid);
        C1283.m16854(TAG, "Adding timeout for webview to load");
        if (getHandler() != null) {
            getHandler().postDelayed(getNextTask(), getTimeout());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (getHandler() != null) {
            getHandler().removeCallbacks(getNextTask());
        }
    }

    public void onWebViewLoaded() {
        C1283.m16854(TAG, "UI ready to interact");
        if (getHandler() != null) {
            getHandler().removeCallbacks(getNextTask());
        }
        runOnUiThread(new Runnable() { // from class: o.zO.3
            @Override // java.lang.Runnable
            public void run() {
                if (!zO.this.mWebViewLoaded) {
                    zO.this.webViewVisibility(true);
                    zO.this.mWebViewLoaded = true;
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void webViewVisibility(boolean z) {
        if (z != this.mWebViewVisibility) {
            C1283.m16854(TAG, "WebView visibility:" + this.mWebViewVisibility);
            this.mFlipper.showNext();
            this.mWebViewVisibility = !this.mWebViewVisibility;
        }
    }

    public void provideDialog(String str, Runnable runnable) {
        displayDialog(C0505.m14491(this, this.handler, new C1278(null, str, getString(R.string.label_ok), runnable)));
    }

    public void provideTwoButtonDialog(String str, Runnable runnable) {
        displayDialog(C0505.m14491(this, this.handler, new C0505.If(null, str, getString(R.string.label_ok), runnable, getString(R.string.label_cancel), null)));
    }

    /* access modifiers changed from: protected */
    public void noConnectivityWarning() {
        runOnUiThread(new Runnable() { // from class: o.zO.2
            @Override // java.lang.Runnable
            public void run() {
                zO.this.displayDialog(C0505.m14491(zO.this, zO.this.handler, new C1278(null, zO.this.getString(R.string.label_startup_nointernet), zO.this.getString(R.string.label_ok), null)));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showToast(int i) {
        showToast(getString(i));
    }

    public void showToast(String str) {
        if (NetflixApplication.m223()) {
            C1004.m15961(this, str, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void startNextActivity(Intent intent) {
        startActivity(intent);
        C1283.m16854(TAG, "Removing jumpToSignIn");
        if (getHandler() != null) {
            getHandler().removeCallbacks(getNextTask());
            overridePendingTransition(0, 0);
        }
    }

    private void setNonMemberCookies(AbstractC1221 r6, NonMemberData nonMemberData, boolean z) {
        AbstractC1378Cu r2 = r6.mo16512();
        boolean r3 = C1279.m16829(r6.mo16547().mo1454());
        String cookie = CookieManager.getInstance().getCookie(NETFLIX_DOMAIN);
        if (nonMemberData == null || !nonMemberData.isValid() || (C1349Bv.m4107(cookie) && cookiesIncludeNetflixId(cookie, r3) && !z)) {
            C1283.m16854(TAG, "using existing cookies. ");
        } else if (C1317As.m3774()) {
            setCookieAndSync(appendCookies(cookie, buildDeviceAndNonMemberCookies(nonMemberData, r2, r3), r3));
        } else {
            setCookieAndSyncPreO(appendCookies(cookie, buildDeviceAndNonMemberCookies(nonMemberData, r2, r3), r3));
        }
    }

    private boolean cookiesIncludeNetflixId(String str, boolean z) {
        for (String str2 : str.split(";")) {
            if (str2.contains(C1376Cs.m4554(z))) {
                return true;
            }
        }
        return false;
    }

    private void setCookieAndSyncPreO(String[] strArr) {
        CookieManager instance = CookieManager.getInstance();
        instance.removeAllCookie();
        for (String str : strArr) {
            instance.setCookie(NETFLIX_DOMAIN, str);
        }
        CookieSyncManager.createInstance(this).sync();
    }

    private void setCookieAndSync(String[] strArr) {
        CookieManager instance = CookieManager.getInstance();
        for (String str : strArr) {
            instance.setCookie(NETFLIX_DOMAIN, str);
        }
        instance.flush();
    }

    private String[] appendCookies(String str, String[] strArr, boolean z) {
        if (C1349Bv.m4113(str)) {
            return strArr;
        }
        return updateToLatestNonMemberCookies(strArr, z);
    }

    private String[] updateToLatestNonMemberCookies(String[] strArr, boolean z) {
        String cookieFromList = getCookieFromList(strArr, C1376Cs.m4549(z));
        String cookieFromList2 = getCookieFromList(strArr, C1376Cs.m4554(z));
        String cookieFromList3 = getCookieFromList(strArr, C1376Cs.m4551());
        ArrayList arrayList = new ArrayList();
        if (C1349Bv.m4107(cookieFromList)) {
            arrayList.add(cookieFromList);
        }
        if (C1349Bv.m4107(cookieFromList2)) {
            arrayList.add(cookieFromList2);
        }
        if (C1349Bv.m4107(cookieFromList3)) {
            arrayList.add(cookieFromList3);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private String getCookieFromList(String[] strArr, String str) {
        if (strArr == null) {
            return null;
        }
        for (String str2 : strArr) {
            if (C1349Bv.m4107(str2) && str2.contains(str)) {
                return str2;
            }
        }
        return null;
    }

    private String[] buildDeviceAndNonMemberCookies(NonMemberData nonMemberData, AbstractC1378Cu cu, boolean z) {
        String[] strArr = new String[4];
        int i = 0;
        if (cu != null && C1349Bv.m4107(cu.mo4542())) {
            strArr[0] = cu.mo4540() + "=" + cu.mo4542() + COOKIE_SUFFIX;
            i = 0 + 1;
        }
        if (nonMemberData == null || C1349Bv.m4113(nonMemberData.netflixId) || C1349Bv.m4113(nonMemberData.secureNetflixId)) {
            return strArr;
        }
        strArr[i] = C1376Cs.m4554(z) + "=" + nonMemberData.netflixId + COOKIE_SUFFIX;
        int i2 = i + 1;
        strArr[i2] = C1376Cs.m4549(z) + "=" + nonMemberData.secureNetflixId + "; Secure;";
        int i3 = i2 + 1;
        return strArr;
    }

    /* access modifiers changed from: protected */
    public void reload(boolean z) {
        if (z) {
            C1376Cs.m4555(getApplicationContext(), new ValueCallback<Boolean>() { // from class: o.zO.4
                /* renamed from: ˋ  reason: contains not printable characters */
                public void onReceiveValue(Boolean bool) {
                    zO.this.reloadAfterClearCookies();
                }
            });
        } else {
            reloadAfterClearCookies();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reloadAfterClearCookies() {
        this.mWebViewClient.m13436();
        this.mWebView.loadUrl(this.mUiBoot.m13430());
    }

    public String getDeviceLanguage() {
        C2059ph serviceManager = getServiceManager();
        if (serviceManager == null || !serviceManager.mo9519()) {
            return DEFAULT_LOCALE;
        }
        return serviceManager.m9763();
    }
}
