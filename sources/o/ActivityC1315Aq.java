package o;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ViewFlipper;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.util.log.UIScreen;
/* renamed from: o.Aq  reason: case insensitive filesystem */
public class ActivityC1315Aq extends NetflixActivity {

    /* renamed from: ˋ  reason: contains not printable characters */
    protected WebView f4524;

    /* renamed from: ˎ  reason: contains not printable characters */
    private iF f4525;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f4526;

    /* renamed from: ॱ  reason: contains not printable characters */
    private ViewFlipper f4527;

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.external_web);
        this.f4524 = (WebView) findViewById(R.id.externalWebView);
        this.f4527 = (ViewFlipper) findViewById(R.id.flipper);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Intent intent = getIntent();
        if (intent == null) {
            C1283.m16865("ExternalWeb", "Started with no intent! It should no happen!");
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("url");
        if (!URLUtil.isNetworkUrl(stringExtra)) {
            C1283.m16850("ExternalWeb", "Url " + stringExtra + " is not a network URL! Destroy activity!");
            finish();
            return;
        }
        mo3736(stringExtra);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo3736(String str) {
        WebSettings settings = this.f4524.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        if (C1317As.m3758() >= 16) {
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setSupportMultipleWindows(false);
        this.f4524.setWebChromeClient(new Cif());
        this.f4525 = new iF();
        this.f4524.setWebViewClient(this.f4525);
        this.f4524.setOnTouchListener(new View.OnTouchListener() { // from class: o.Aq.2
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
        this.f4525.m3738();
        this.f4524.loadUrl(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C1283.m16865("ExternalWeb", "Received new intent when UI is visible");
        if (intent == null) {
            C1283.m16865("ExternalWeb", "Started with no intent! It should no happen!");
            return;
        }
        String stringExtra = intent.getStringExtra("url");
        if (!URLUtil.isNetworkUrl(stringExtra)) {
            C1283.m16850("ExternalWeb", "Url " + stringExtra + " is not a network URL! Stay!");
            return;
        }
        m3737(false);
        this.f4525.m3738();
        this.f4524.loadUrl(stringExtra);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m3737(boolean z) {
        if (z != this.f4526) {
            this.f4527.showNext();
            this.f4526 = !this.f4526;
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.externalLink;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSettingsInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSignOutInMenu() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onConfigureActionBarState(NetflixActionBar.iF.AbstractC0010 r3) {
        r3.mo396(false).mo399(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Aq$if  reason: invalid class name */
    public class Cif extends WebChromeClient {
        private Cif() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Aq$iF */
    public class iF extends WebViewClient {

        /* renamed from: ˎ  reason: contains not printable characters */
        private boolean f4529;

        /* renamed from: ॱ  reason: contains not printable characters */
        private String f4531;

        private iF() {
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m3738() {
            this.f4529 = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            String originalUrl = webView.getOriginalUrl();
            if (this.f4529 && !C1349Bv.m4126(this.f4531, originalUrl)) {
                webView.clearHistory();
                this.f4529 = false;
            }
            this.f4531 = originalUrl;
            ActivityC1315Aq.this.m3737(true);
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            C1276.m16820().mo5725("Could not load url : " + str2 + " ERR = (" + i + ") " + str);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            C1276.m16820().mo5727("Could not load url : " + webResourceRequest.getUrl().toString() + " ERR = (" + webResourceError.getErrorCode() + ") " + webResourceError.getDescription().toString());
        }
    }
}
