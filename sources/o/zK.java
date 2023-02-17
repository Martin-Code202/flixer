package o;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.util.log.UIScreen;
import com.netflix.model.leafs.OnRampEligibility;
import java.util.concurrent.TimeUnit;
import o.C0505;
@SuppressLint({"SetJavaScriptEnabled"})
public class zK extends zO {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static C0317 f12669 = new C0317();

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final long f12670 = TimeUnit.SECONDS.toMillis(5);

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f12671;

    /* renamed from: ˋ  reason: contains not printable characters */
    Runnable f12672 = new Runnable() { // from class: o.zK.2
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("OnRampActivity", "Timeout triggered");
            if (!zK.this.f12674 && !zK.this.isFinishing()) {
                PerformanceProfiler.INSTANCE.m665(Sessions.ONRAMP_TTR, PerformanceProfiler.m652());
                zK.this.finish();
            }
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    Runnable f12673 = new Runnable() { // from class: o.zK.3
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("OnRampActivity", "Handling error during Onramp");
            C1376Cs.m4555(zK.this.getApplicationContext(), new ValueCallback<Boolean>() { // from class: o.zK.3.1
                /* renamed from: ˋ  reason: contains not printable characters */
                public void onReceiveValue(Boolean bool) {
                    PerformanceProfiler.INSTANCE.m665(Sessions.ONRAMP_TTR, PerformanceProfiler.m652());
                    zK.this.finish();
                }
            });
        }
    };

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f12674;

    /* renamed from: o.zK$ˋ  reason: contains not printable characters */
    public static class C0317 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean f12682;

        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean m13494() {
            boolean z = this.f12682;
            this.f12682 = false;
            return z;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.zO, o.AbstractActivityC2189ts, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PerformanceProfiler.INSTANCE.m663(Sessions.ONRAMP_TTR);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C0317 m13486() {
        return f12669;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m13489(C2059ph phVar, Activity activity) {
        return phVar.mo9519() && activity != null && phVar.m9826() != null && C1003.m15951(activity) && !phVar.m9826().isPrimaryProfile();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showHelpInMenu() {
        return false;
    }

    @Override // o.AbstractActivityC2189ts, o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // o.zO
    public Object createJSBridge() {
        return new C0316();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.zK.1
            @Override // o.oV
            public void onManagerReady(final C2059ph phVar, Status status) {
                phVar.m9784(3600000, new AbstractC2061pj() { // from class: o.zK.1.1
                    @Override // o.AbstractC2061pj, o.oU
                    public void onAutoLoginTokenCreated(String str, Status status2) {
                        if (!status2.mo298() || C1349Bv.m4113(str)) {
                            zK.this.finish();
                            return;
                        }
                        zK.this.f12671 = "https://www.netflix.com/welcome/onramp?isProfilesOnRamp=true&nftoken=" + str;
                        zK.this.setViews(phVar, false);
                    }
                });
                if (phVar.m9826() != null) {
                    phVar.m9793(OnRampEligibility.Action.RECORD, (oU) null);
                }
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                C1283.m16850("OnRampActivity", "NetflixService is NOT available!");
                zK.this.finish();
            }
        };
    }

    @Override // o.zO
    public void provideDialog(String str, Runnable runnable) {
        displayDialog(C0505.m14491(this, this.handler, new C1278(null, str, getString(R.string.label_ok), runnable)));
    }

    @Override // o.zO
    public void provideTwoButtonDialog(String str, Runnable runnable) {
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
        C1004.m15961(this, str, 1);
    }

    @Override // o.zO
    public Runnable getErrorHandler() {
        return this.f12673;
    }

    @Override // o.zO
    public Runnable getNextTask() {
        return this.f12672;
    }

    @Override // o.zO
    public String getBootUrl() {
        return this.f12671;
    }

    @Override // o.zO
    public long getTimeout() {
        return f12670;
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
        PerformanceProfiler.INSTANCE.m672(Sessions.ONRAMP_TTR);
    }

    /* renamed from: o.zK$ˊ  reason: contains not printable characters */
    public class C0316 {
        public C0316() {
        }

        @JavascriptInterface
        public void onRampInitiated() {
        }

        @JavascriptInterface
        public void onRampCompleted(int i) {
            C1283.m16854("OnRampActivity", "onRampCompleted");
            if (i > 0) {
                zK.f12669.f12682 = true;
                zK.this.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.REFRESH_HOME_LOLOMO"));
            }
            zK.this.finish();
        }

        @JavascriptInterface
        public void passNonMemberInfo(String str) {
        }

        @JavascriptInterface
        public void onLoaded() {
            zK.this.f12674 = true;
        }

        @JavascriptInterface
        public void notifyReady() {
        }

        @JavascriptInterface
        public void supportsSignUp(String str) {
        }

        @JavascriptInterface
        public void setLanguage(String str) {
        }

        @JavascriptInterface
        public void showSignIn() {
        }

        @JavascriptInterface
        public void showSignOut() {
        }
    }
}
