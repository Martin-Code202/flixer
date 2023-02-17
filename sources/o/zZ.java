package o;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.NetworkErrorStatus;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class zZ extends ActivityC1315Aq {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C2364iF f12759 = new C2364iF(null);

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final List<String> f12760 = new ArrayList();

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f12761;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f12762;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final Intent m13580(Context context, String str, String str2, String str3, boolean z) {
        return f12759.m13588(context, str, str2, str3, z);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final void m13582(String str) {
        f12759.m13587(str);
    }

    /* renamed from: o.zZ$iF  reason: case insensitive filesystem */
    public static final class C2364iF {
        private C2364iF() {
        }

        public /* synthetic */ C2364iF(C1456Fq fq) {
            this();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private final List<String> m13585() {
            return zZ.f12760;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m13587(String str) {
            if (str != null) {
                try {
                    List<String> r0 = m13585();
                    String host = new URL(str).getHost();
                    C1457Fr.m5016((Object) host, "URL(url).host");
                    r0.add(host);
                } catch (MalformedURLException e) {
                    C1276.m16820().mo5725("can not add a malformed url = \"" + str + "\" to trusted hosts list");
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private final boolean m13584(String str) {
            if (str == null) {
                return false;
            }
            try {
                return m13585().contains(new URL(str).getHost());
            } catch (MalformedURLException e) {
                return false;
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final Intent m13588(Context context, String str, String str2, String str3, boolean z) {
            Class cls;
            C1457Fr.m5025(context, "context");
            if (str == null) {
                C1276.m16820().mo5725("UmaLinkAction: url is null!");
                return null;
            } else if (!URLUtil.isNetworkUrl(str)) {
                C1276.m16820().mo5725("UmaLinkAction: " + str + " is not a network URL!");
                return null;
            } else {
                if (NetflixApplication.getInstance().m254()) {
                    cls = zX.class;
                } else {
                    cls = zZ.class;
                }
                Intent intent = new Intent(context, cls);
                intent.putExtra("url", str);
                String str4 = str2;
                if (str4 == null) {
                    str4 = "Success!";
                }
                intent.putExtra("success_msg", str4);
                String str5 = str3;
                if (str5 == null) {
                    str5 = "Failed!";
                }
                intent.putExtra("failure_msg", str5);
                intent.putExtra("auto_login_enable", z);
                return intent;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.ActivityC1315Aq, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebView webView = this.f4524;
        String stringExtra = getIntent().getStringExtra("success_msg");
        C1457Fr.m5016((Object) stringExtra, "intent.getStringExtra(INTENT_EXTRA_SUCCESS_MSG)");
        String stringExtra2 = getIntent().getStringExtra("failure_msg");
        C1457Fr.m5016((Object) stringExtra2, "intent.getStringExtra(INTENT_EXTRA_FAILURE_MSG)");
        webView.addJavascriptInterface(new If(this, this, stringExtra, stringExtra2), "nfandroid");
        this.f12762 = getIntent().getBooleanExtra("auto_login_enable", false);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        if (this.f4524 == null || !this.f4524.canGoBackOrForward(-1)) {
            return super.handleBackPressed();
        }
        this.f4524.goBack();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.ActivityC1315Aq
    /* renamed from: ˊ */
    public void mo3736(String str) {
        if (str == null) {
            C1276.m16820().mo5727("not loading empty url");
        } else if (!this.f12762) {
            super.mo3736(str);
        } else {
            runWhenManagerIsReady(new C0318(this, str));
        }
    }

    /* renamed from: o.zZ$ˊ  reason: contains not printable characters */
    public static final class C0318 extends NetflixActivity.If {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ String f12770;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ zZ f12771;

        C0318(zZ zZVar, String str) {
            this.f12771 = zZVar;
            this.f12770 = str;
        }

        @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
        public void run(C2059ph phVar) {
            C1457Fr.m5025(phVar, "manager");
            this.f12771.m13576(this.f12770);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m13576(String str) {
        if (str != null) {
            if (!f12759.m13584(str)) {
                C1276.m16820().mo5725("loading " + str + " with auto login token for non-trusted host names");
            }
            Cif ifVar = new Cif(new C2154sm(this), new NetworkErrorStatus(BK.f4581), str);
            getHandler().postDelayed(ifVar, 10000);
            getServiceManager().m9784(3600000, new C0319(this, ifVar, str));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zZ$if  reason: invalid class name */
    public static final class Cif implements Runnable {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ NetworkErrorStatus f12767;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C2154sm f12768;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ String f12769;

        Cif(C2154sm smVar, NetworkErrorStatus networkErrorStatus, String str) {
            this.f12768 = smVar;
            this.f12767 = networkErrorStatus;
            this.f12769 = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f12768.m10803(null, this.f12767, this.f12769);
        }
    }

    /* renamed from: o.zZ$ˋ  reason: contains not printable characters */
    public static final class C0319 extends AbstractC2061pj {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ Runnable f12772;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ zZ f12773;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ String f12774;

        C0319(zZ zZVar, Runnable runnable, String str) {
            this.f12773 = zZVar;
            this.f12772 = runnable;
            this.f12774 = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
            if ((r6.length() == 0) != false) goto L_0x0015;
         */
        @Override // o.AbstractC2061pj, o.oU
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onAutoLoginTokenCreated(java.lang.String r6, com.netflix.mediaclient.android.app.Status r7) {
            /*
                r5 = this;
                java.lang.String r0 = "res"
                o.C1457Fr.m5025(r7, r0)
                if (r6 == 0) goto L_0x0015
                r2 = r6
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                int r0 = r2.length()
                if (r0 != 0) goto L_0x0012
                r0 = 1
                goto L_0x0013
            L_0x0012:
                r0 = 0
            L_0x0013:
                if (r0 == 0) goto L_0x001e
            L_0x0015:
                o.ｕ r0 = o.C1276.m16820()
                java.lang.String r1 = "valid auto login token was not created"
                r0.mo5727(r1)
            L_0x001e:
                r2 = r6
                if (r2 == 0) goto L_0x0022
                goto L_0x0024
            L_0x0022:
                java.lang.String r2 = ""
            L_0x0024:
                o.zZ r3 = r5.f12773
                r0 = r3
                android.content.Context r0 = (android.content.Context) r0
                boolean r0 = o.C1317As.m3750(r0)
                if (r0 != 0) goto L_0x0043
                android.os.Handler r0 = o.zZ.m13581(r3)
                java.lang.Runnable r1 = r5.f12772
                r0.removeCallbacks(r1)
                java.lang.String r0 = r5.f12774
                java.lang.String r4 = o.C2154sm.m10802(r0, r2)
                o.zZ r0 = r5.f12773
                o.zZ.m13577(r0, r4)
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o.zZ.C0319.onAutoLoginTokenCreated(java.lang.String, com.netflix.mediaclient.android.app.Status):void");
        }
    }

    public final class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final String f12763;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ zZ f12764;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final Context f12765;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f12766;

        public If(zZ zZVar, Context context, String str, String str2) {
            C1457Fr.m5025(context, "context");
            C1457Fr.m5025(str, "successMsg");
            C1457Fr.m5025(str2, "failureMsg");
            this.f12764 = zZVar;
            this.f12765 = context;
            this.f12766 = str;
            this.f12763 = str2;
        }

        @JavascriptInterface
        public final void onSuccess() {
            C1004.m15961(this.f12765, this.f12766, 1);
            this.f12764.f12761 = true;
        }

        @JavascriptInterface
        public final void onFailure() {
            C1004.m15961(this.f12765, this.f12763, 1);
        }

        @JavascriptInterface
        public final void showToastMessage(String str) {
            C1457Fr.m5025(str, "toastString");
            C1004.m15961(this.f12765, str, 1);
        }

        @JavascriptInterface
        public final void exit() {
            if (!this.f12764.isFinishing()) {
                this.f12764.finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.f12761) {
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(new Intent("RefreshUserMessageRequest.ACTION_DISMISS_UMA_MESSAGE"));
        } else {
            getServiceManager().m9821();
        }
    }
}
