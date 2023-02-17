package o;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.google.android.gms.auth.api.credentials.Credential;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.log.UIScreen;
/* renamed from: o.tp  reason: case insensitive filesystem */
public class ActivityC2186tp extends AbstractActivityC2189ts implements AbstractC2192tv {

    /* renamed from: ˋ  reason: contains not printable characters */
    private C2185to f10610;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f10611;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final BroadcastReceiver f10612 = new BroadcastReceiver() { // from class: o.tp.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ActivityC2186tp.this.invalidateOptionsMenu();
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Intent m11240(Context context) {
        if (AD.m3299()) {
            try {
                return m11241(context, null, null);
            } catch (ActivityNotFoundException e) {
                C1283.m16847("LoginActivity", "Failed to start LoginTabletActivity Activity!", e);
                C1276.m16820().mo5730(e);
            }
        }
        return m11239(context, null, null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Intent m11239(Context context, Credential credential, Status status) {
        Intent intent = new Intent(context, ActivityC2186tp.class);
        AS.m3411(credential, status, intent);
        return intent;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Intent m11241(Context context, Credential credential, Status status) {
        Intent intent = new Intent(context, ActivityC2190tt.class);
        AS.m3411(credential, status, intent);
        return intent;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        C2059ph serviceManager = getServiceManager();
        if (serviceManager != null && serviceManager.mo9519()) {
            serviceManager.m9795(false);
        }
        super.onResume();
    }

    @Override // o.AbstractActivityC2189ts, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1317As.m3765((Activity) this);
        setContentView(R.layout.login_activity);
        if (bundle != null) {
            this.f10610 = (C2185to) getSupportFragmentManager().findFragmentByTag("EmailPasswordFragment");
        } else {
            PerformanceProfiler.INSTANCE.m663(Sessions.LOG_IN);
            m11245();
        }
        C1362Ch.m4400(IClientLogging.CompletionReason.success, (UIError) null);
        registerReceiverWithAutoUnregister(this.f10612, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.app.Activity
    public void finish() {
        super.finish();
        PerformanceProfiler.INSTANCE.m672(Sessions.LOG_IN);
    }

    @Override // o.AbstractC2192tv
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo11246() {
        if (this.f10611) {
            C1283.m16854("LoginActivity", "handleBackToRegularWorkflow:: New profile requested - starting profile selection activity...");
            C1339Bl.m4048((Context) this, "prefs_non_member_playback", false);
            startActivity(ActivityC2383zq.m13737(this));
            finishAllAccountActivities(this);
            return;
        }
        C1283.m16854("LoginActivity", "Back to regular workflow for profile activated...");
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfileReadyToSelect() {
        C1283.m16854("LoginActivity", "New profile requested - starting profile selection activity...");
        if (AS.m3410(this)) {
            C1283.m16854("LoginActivity", "SmartLogin save enabled, do save credentials...");
            this.f10611 = true;
            return;
        }
        C1283.m16854("LoginActivity", "SmartLogin save not enabled, regular workflow...");
        C1339Bl.m4048((Context) this, "prefs_non_member_playback", false);
        startActivity(ActivityC2383zq.m13737(this));
        finishAllAccountActivities(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfileActivated() {
        if (AS.m3410(this)) {
            C1283.m16854("LoginActivity", "SmartLogin save enabled, do save credentials for profile activated...");
            this.f10611 = false;
            return;
        }
        C1283.m16854("LoginActivity", "SmartLogin save not enabled, regular workflow for profile activated...");
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleAccountDeactivated() {
        C1283.m16862("LoginActivity", "Account deactivated ...");
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.login;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.tp.3
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                Fragment r1 = ActivityC2186tp.this.m11242();
                if (r1 != null) {
                    ((AbstractC0517) r1).onManagerReady(phVar, status);
                }
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                C0368.m14087(ActivityC2186tp.this, status);
                Fragment r1 = ActivityC2186tp.this.m11242();
                if (r1 != null) {
                    ((AbstractC0517) r1).onManagerUnavailable(phVar, status);
                }
            }
        };
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            C1283.m16850("LoginActivity", "onActivityResult: unknown request code" + i);
        } else if (i2 == -1) {
            showDebugToast("Account credentials saved!");
            C1363Ci.m4429(SignInLogging.CredentialService.GooglePlayService, IClientLogging.CompletionReason.success, null);
        } else {
            showDebugToast("Failed to save account credentials!");
            C1363Ci.m4429(SignInLogging.CredentialService.GooglePlayService, IClientLogging.CompletionReason.failed, C1363Ci.m4424(i2));
        }
        mo11246();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private Fragment m11242() {
        return m11244(getSupportFragmentManager());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private Fragment m11244(FragmentManager fragmentManager) {
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        C1283.m16851("LoginActivity", "getBackStackEntryCount %d", Integer.valueOf(backStackEntryCount));
        if (backStackEntryCount == 0) {
            return null;
        }
        return fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11245() {
        C1283.m16862("LoginActivity", "showEmailPasswordFragment");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        this.f10610 = C2185to.m11202(getIntent().getExtras());
        beginTransaction.replace(R.id.login_fragment_container, this.f10610, "EmailPasswordFragment");
        beginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        m11244(supportFragmentManager);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showHelpInMenu() {
        if (!ConnectivityUtils.m2970(this) || getServiceManager() == null || getServiceManager().m9827() == null) {
            return false;
        }
        return getServiceManager().m9827().mo16557();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public CustomerServiceLogging.EntryPoint getEntryPoint() {
        return CustomerServiceLogging.EntryPoint.login;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC2189ts, com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean hasUpAction() {
        return zN.f12697.m13528(this) ? !zN.f12697.m13523(this) : !zJ.m13464();
    }

    @Override // o.AbstractActivityC2189ts, com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        C1364Cj.m4442(UIViewLogging.UIViewCommandName.upButton, getUiScreen().f4084, getDataContext());
        C1300Ac.m3533();
        startActivity(zN.f12697.m13529(this));
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showNoNetworkOverlayIfNeeded() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onConfigureActionBarState(NetflixActionBar.iF.AbstractC0010 r4) {
        r4.mo396(false).mo399(true).mo401(NetflixActionBar.LogoType.START_ALIGNED);
        SignInConfigData r2 = new C0365(this).m14067();
        if (r2 != null && r2.isSignupBlocked()) {
            r4.mo403(false);
        }
    }
}
