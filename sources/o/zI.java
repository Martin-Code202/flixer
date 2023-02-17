package o;

import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import java.util.Locale;
/* access modifiers changed from: package-private */
public class zI extends WebViewClient {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f12610 = null;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f12611 = false;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f12612;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final zO f12613;

    zI(zO zOVar) {
        this.f12613 = zOVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m13436() {
        this.f12611 = true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        String originalUrl = webView.getOriginalUrl();
        if (this.f12611 && !C1349Bv.m4126(this.f12610, originalUrl)) {
            webView.clearHistory();
            this.f12611 = false;
        }
        this.f12610 = originalUrl;
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (m13432(str)) {
            webView.loadUrl(str);
            return true;
        } else if (m13433(str) != NflxHandler.Response.NOT_HANDLING) {
            C1283.m16854("AccountWebViewClient", "=========> URL handled by Nflx protocol" + str);
            return true;
        } else {
            C1283.m16850("AccountWebViewClient", "=========> Invalid URL scheme, protocol not handled" + str);
            this.f12613.showToast("Invalid URL scheme " + str);
            return true;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private NflxHandler.Response m13433(String str) {
        try {
            return C0918.m15722(this.f12613, Uri.parse(str), 0).c_();
        } catch (Throwable th) {
            C1283.m16847("AccountWebViewClient", "Failed to parse nflx url ", th);
            return NflxHandler.Response.NOT_HANDLING;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        m13434(str);
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m13432(String str) {
        if (str == null) {
            return false;
        }
        return str.trim().toLowerCase(Locale.US).startsWith("https");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13434(String str) {
        if (this.f12612) {
            C1283.m16850("AccountWebViewClient", "We already failed. Ignoring to prevent multiple dialogs! URL: " + str);
            this.f12613.showToast("Loading insecure resource, ERROR:" + str);
        } else if (str != null) {
            String trim = str.toLowerCase(Locale.US).trim();
            if (!m13435(trim) && !trim.startsWith("https")) {
                this.f12612 = true;
                this.f12613.showToast("Loading insecure resource, ERROR:" + str);
                C1283.m16850("AccountWebViewClient", "Trying to load from unsecure location in release build. Prevent loading, security breach! URL: " + str);
                this.f12613.provideDialog(this.f12613.getString(R.string.signup_unable_tocomplete), this.f12613.getErrorHandler());
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m13435(String str) {
        return ((str.startsWith("data:image") || str.endsWith(".png") || str.contains(".png?")) || str.endsWith(".jpg") || str.contains(".jpg?")) || str.endsWith(".gif") || str.contains(".gif?");
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        C1283.m16850("AccountWebViewClient", "SSL error: " + sslError);
        this.f12613.showToast("SSL Failure loading ERROR: " + sslError.getUrl());
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }
}
