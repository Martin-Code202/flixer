package o;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ViewFlipper;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.apm.model.Orientation;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipCallConfigData;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IVoip;
import com.netflix.mediaclient.util.log.UIScreen;
import o.C0505;
/* renamed from: o.Ao  reason: case insensitive filesystem */
public class ActivityC1313Ao extends NetflixActivity implements IVoip.If {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String[] f4497 = {"android.permission.RECORD_AUDIO", "android.permission.MODIFY_AUDIO_SETTINGS"};

    /* renamed from: ʻ  reason: contains not printable characters */
    private View f4498;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final View.OnClickListener f4499 = new View.OnClickListener() { // from class: o.Ao.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityC1313Ao.this.performAction(view);
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    private View f4500;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f4501;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C2059ph f4502;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private CustomerServiceLogging.ReturnToDialScreenFrom f4503;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1309Ak f4504;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private CustomerServiceLogging.EntryPoint f4505;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ViewFlipper f4506;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f4507;

    /* renamed from: ͺ  reason: contains not printable characters */
    private Cif f4508;

    /* renamed from: ॱ  reason: contains not printable characters */
    private IVoip f4509;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private IClientLogging.ModalView f4510;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f4511;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C1311Am f4512;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f4513 = false;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f4514 = false;

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1283.m16854("VoipActivity", "onCreate");
        m3716(getIntent());
        this.f4508 = new Cif(this);
        setVolumeControlStream(0);
        getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.f4508);
        if (bundle != null) {
            this.f4511 = bundle.getBoolean("com.netflix.mediaclient.ui.voip.verification_dialog");
            this.f4514 = bundle.getBoolean("com.netflix.mediaclient.ui.voip.dial.requested", false);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C1283.m16854("VoipActivity", "Saving dialog state...");
        bundle.putBoolean("com.netflix.mediaclient.ui.voip.verification_dialog", this.f4511);
        bundle.putBoolean("com.netflix.mediaclient.ui.voip.dial.requested", this.f4514);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public synchronized void onResume() {
        super.onResume();
        if (getServiceManager() != null && this.f4511) {
            m3728();
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m3727() {
        getWindow().addFlags(m3698());
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m3729() {
        getWindow().clearFlags(m3698());
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private int m3698() {
        return 4718592;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.f4502 != null) {
            m3696();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        CustomerServiceLogging.Action action;
        super.onStop();
        this.f4505 = null;
        this.f4510 = null;
        if (isFinishing()) {
            action = CustomerServiceLogging.Action.back;
        } else {
            action = CustomerServiceLogging.Action.home;
        }
        if (this.f4501) {
            C1356Cb.m4337(action);
        } else {
            C1356Cb.m4338(this, action, null, IClientLogging.CompletionReason.canceled, null);
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m3696() {
        C1283.m16854("VoipActivity", "Back to ContactUsActivity");
        if (this.f4501) {
            C1283.m16854("VoipActivity", "Dialer visible, report back to ");
            C1356Cb.m4341(this.f4510, AD.m3306(this) ? Orientation.portrait : Orientation.landscape, m3726());
            return;
        }
        C1283.m16854("VoipActivity", "Help section visible, report new help request session started");
        C1356Cb.m4339(this, m3699());
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private CustomerServiceLogging.EntryPoint m3699() {
        if (this.f4505 != null) {
            C1283.m16854("VoipActivity", "Entry field is known, use it");
            return this.f4505;
        }
        C1283.m16854("VoipActivity", "Return to help page from dial or from links");
        return null;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private CustomerServiceLogging.ReturnToDialScreenFrom m3726() {
        if (this.f4503 != null) {
            C1283.m16854("VoipActivity", "From field is known, use it");
            return this.f4503;
        }
        C1283.m16854("VoipActivity", "From field is not known, use entry point");
        if (this.f4505 != null) {
            if (CustomerServiceLogging.EntryPoint.login == this.f4505) {
                C1283.m16854("VoipActivity", "Use entry point login");
                return CustomerServiceLogging.ReturnToDialScreenFrom.login;
            } else if (CustomerServiceLogging.EntryPoint.nonMemberLanding == this.f4505) {
                C1283.m16854("VoipActivity", "Use entry point nml");
                return CustomerServiceLogging.ReturnToDialScreenFrom.nml;
            }
        }
        C1283.m16854("VoipActivity", "Entry point is not know, return null");
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m3716(getIntent());
        if (this.f4502 != null) {
            m3696();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m3716(Intent intent) {
        m3722(intent);
        m3708(intent);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m3708(Intent intent) {
        if (intent == null || !intent.getBooleanExtra("AUTODIAL", false)) {
            this.f4507 = false;
        } else {
            C1283.m16854("VoipActivity", "AutoDial requested");
            this.f4507 = true;
        }
        if (this.f4507 && this.f4502 != null) {
            C1283.m16854("VoipActivity", "Start autodial, service manager exist");
            m3731();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3722(Intent intent) {
        if (intent != null) {
            C1283.m16849("VoipActivity", intent);
            if (intent.getStringExtra(NetflixActivity.EXTRA_SOURCE) != null) {
                this.f4510 = IClientLogging.ModalView.valueOf(intent.getStringExtra(NetflixActivity.EXTRA_SOURCE));
                C1283.m16854("VoipActivity", "Source found: " + this.f4510);
            }
            if (intent.getStringExtra(NetflixActivity.EXTRA_FROM) != null) {
                this.f4503 = CustomerServiceLogging.ReturnToDialScreenFrom.valueOf(intent.getStringExtra(NetflixActivity.EXTRA_FROM));
                C1283.m16854("VoipActivity", "From found: " + this.f4503);
            }
            if (intent.getStringExtra(NetflixActivity.EXTRA_ENTRY) != null) {
                this.f4505 = CustomerServiceLogging.EntryPoint.valueOf(intent.getStringExtra(NetflixActivity.EXTRA_ENTRY));
                C1283.m16854("VoipActivity", "Entry point found: " + this.f4505);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldFinishOnManagerError() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f4512 != null) {
            this.f4512.m3692();
        }
        if (this.f4504 != null) {
            this.f4504.m3646();
        }
        if (this.f4509 != null) {
            this.f4509.mo1431(this);
            if (!(this.f4509.mo1437() || this.f4502 == null || this.f4502.m9823() == null)) {
                this.f4502.m9823().mo9644();
            }
            this.f4509 = null;
        }
        getApplicationContext().getContentResolver().unregisterContentObserver(this.f4508);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.Ao.4
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                C1283.m16854("VoipActivity", "Manager is here!");
                ActivityC1313Ao.this.m3718(phVar, status);
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                C1283.m16850("VoipActivity", "Netflix service is not fully initialized, but we still need to provide help!");
                ActivityC1313Ao.this.m3718(phVar, status);
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m3718(C2059ph phVar, Status status) {
        this.f4502 = phVar;
        this.f4509 = this.f4502.m9787();
        m3725(status.mo301());
        if (this.f4509 != null) {
            this.f4509.mo1434(this);
        }
        m3696();
        if (this.f4511) {
            C1283.m16854("VoipActivity", "Verification dialog was previosly displayed, show it again");
            m3728();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3725(boolean z) {
        setContentView(R.layout.contact_us_activity);
        m3701(R.id.customerSupportUpAction);
        m3701(R.id.customerSupportDialFab);
        m3701(R.id.customerSupportHelpCenterLink);
        m3701(R.id.customerSupportPasswordLink);
        m3701(R.id.customerSupportUpdatePaymentLink);
        m3701(R.id.customerSupportTitleRequestLink);
        m3701(R.id.customerSupportCancelMyAccountLink);
        m3701(R.id.customerSupportFixConnectionLink);
        getSupportActionBar().hide();
        this.f4506 = (ViewFlipper) findViewById(R.id.contactUsFlipper);
        this.f4504 = new C1309Ak(this);
        this.f4512 = new C1311Am(this);
        this.f4500 = findViewById(R.id.customerSupportDialFab);
        this.f4498 = findViewById(R.id.customerSupportChatFab);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4500.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4498.getLayoutParams();
        if (!C0652.m14811(this) || (!z && !this.f4502.m9823().mo9649())) {
            C1283.m16854("VoipActivity", "VOIP is disabled, do not show dial button on landing page!");
            this.f4500.setVisibility(8);
            layoutParams2.width = -2;
            this.f4498.setLayoutParams(layoutParams2);
        } else {
            C1283.m16851("VoipActivity", "VOIP is enabled, show dial button on landing page! This is force enabled: %b", Boolean.valueOf(z));
            this.f4500.setVisibility(0);
        }
        if (C0652.m14812(this)) {
            this.f4498.setVisibility(0);
        } else {
            this.f4498.setVisibility(8);
            layoutParams.width = -2;
            this.f4500.setLayoutParams(layoutParams);
        }
        if (!(!C0652.c_(this) || layoutParams == null || layoutParams2 == null)) {
            if (getResources().getConfiguration().orientation != 2) {
                layoutParams.leftToLeft = layoutParams2.leftToLeft;
                layoutParams.rightToLeft = this.f4498.getId();
                layoutParams.rightToRight = -1;
                layoutParams.leftToRight = -1;
                layoutParams2 = (ConstraintLayout.LayoutParams) this.f4498.getLayoutParams();
                layoutParams2.leftToRight = this.f4500.getId();
                layoutParams2.rightToRight = 0;
                layoutParams2.leftToLeft = -1;
                layoutParams2.rightToLeft = -1;
            } else if (layoutParams.topToBottom != layoutParams2.topToBottom) {
                layoutParams.topToBottom = layoutParams2.topToBottom;
                layoutParams2.topToBottom = this.f4500.getId();
            }
            this.f4500.setLayoutParams(layoutParams);
            this.f4498.setLayoutParams(layoutParams2);
        }
        this.f4504.m3645();
        this.f4512.m3690(this.f4502.m9787() != null && this.f4502.m9787().mo1446());
        this.f4512.m3688();
        if (this.f4509 != null && this.f4509.mo1437()) {
            C1283.m16854("VoipActivity", "Call is in progress, move to dialer");
            m3720();
        } else if (this.f4514) {
            C1283.m16854("VoipActivity", "Dial was requested in Landscape mode, dialing now");
            this.f4514 = false;
            m3711();
        } else {
            C1283.m16854("VoipActivity", "Call is not in progress, leave on landing page");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3701(int i) {
        View findViewById = findViewById(i);
        if (findViewById != null) {
            findViewById.setOnClickListener(this.f4499);
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip.If
    /* renamed from: ˎ */
    public void mo1550(IVoip.Cif ifVar) {
        if (!isFinishing()) {
            this.f4512.m3686();
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip.If
    /* renamed from: ˋ */
    public void mo1549(IVoip.Cif ifVar) {
        if (!isFinishing()) {
            this.f4512.m3694();
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip.If
    /* renamed from: ॱ */
    public void mo1553(IVoip.Cif ifVar) {
        if (!isFinishing()) {
            if (this.f4501) {
                C1283.m16854("VoipActivity", "callDisconnected:: Back to landing page contact us");
                m3706();
            } else {
                C1283.m16854("VoipActivity", "callDisconnected:: Already back to landing page contact us");
            }
            this.f4512.m3687();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m3706() {
        m3729();
        if (!isTablet()) {
            C1283.m16854("VoipActivity", "Phone, release lock on portrait for dial screen");
            setRequestedOrientation(-1);
        }
        this.f4506.showPrevious();
        this.f4501 = false;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m3720() {
        m3727();
        if (!isTablet()) {
            C1283.m16854("VoipActivity", "Phone, lock on portrait for dial screen");
            setRequestedOrientation(1);
        }
        this.f4506.showNext();
        this.f4501 = true;
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip.If
    /* renamed from: ˏ */
    public void mo1551(IVoip.Cif ifVar) {
        if (!isFinishing()) {
            if (this.f4501) {
                C1283.m16854("VoipActivity", "networkFailed:: Back to landing page contact us");
                m3706();
            } else {
                C1283.m16854("VoipActivity", "networkFailed:: Already back to landing page contact us");
            }
            this.f4512.m3687();
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip.If
    /* renamed from: ˊ */
    public void mo1548(IVoip.Cif ifVar) {
        if (!isFinishing()) {
            if (this.f4501) {
                C1283.m16854("VoipActivity", "callEnded:: Back to landing page contact us");
                m3706();
                return;
            }
            C1283.m16854("VoipActivity", "callEnded:: Already back to landing page contact us");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3732(IVoip.Cif ifVar, String str, int i) {
        if (!isFinishing()) {
            if (this.f4501) {
                C1283.m16854("VoipActivity", "callFailed:: Back to landing page contact us");
                m3706();
            } else {
                C1283.m16854("VoipActivity", "callFailed:: Already back to landing page contact us");
            }
            if (this.f4512 != null) {
                this.f4512.m3687();
            }
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip.If
    /* renamed from: ˏ */
    public void mo1552(boolean z) {
        if (!isFinishing()) {
            this.f4500.setEnabled(z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3731() {
        if (this.f4502 != null && this.f4502.m9823() != null && !this.f4502.m9823().mo9645()) {
            C1283.m16854("VoipActivity", "startDial Failed:: a GSM call is currently ongoing");
            m3717(getResources().getString(R.string.label_cs_call_error_gsm_ongoing_message));
        } else if (m3697()) {
            C1283.m16854("VoipActivity", "User is in test cell to display confirmation dialog");
            m3728();
        } else {
            C1283.m16854("VoipActivity", "Start call");
            m3711();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m3711() {
        C1283.m16854("VoipActivity", "fetching voip config before dialing");
        if (C1331Bd.m4010(this, f4497)) {
            C1283.m16854("VoipActivity", "Record audio permission are not granted. Requested them.");
            m3730();
            return;
        }
        C1283.m16854("VoipActivity", "Record audio permission has already been granted. Start dialing.");
        if (this.f4501) {
            C1283.m16854("VoipActivity", "fetchConfigAndDial:: Already in dialer");
        } else if (getResources().getConfiguration().orientation == 2) {
            C1283.m16854("VoipActivity", "We are in Landscape, switch to portrait first and then dial");
            this.f4514 = true;
            m3720();
        } else {
            m3720();
            this.f4513 = false;
            if (this.f4502 != null && this.f4502.m9823() != null) {
                this.f4502.m9823().mo9646(new AbstractC0477() { // from class: o.Ao.3
                    @Override // o.AbstractC0477
                    /* renamed from: ˏ  reason: contains not printable characters */
                    public void mo3735(VoipCallConfigData voipCallConfigData, Status status) {
                        if (!status.mo298() || voipCallConfigData == null) {
                            C1283.m16854("VoipActivity", "fetchVoipConfigData Failed:: Back to landing page contact us");
                            ActivityC1313Ao.this.m3717(ActivityC1313Ao.this.getResources().getString(R.string.label_cs_call_error_message));
                            ActivityC1313Ao.this.m3706();
                            return;
                        }
                        ActivityC1313Ao.this.m3709(voipCallConfigData);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m3717(String str) {
        displayDialog(C0505.m14492(this, this.handler, new C1278("", str, null, null), null));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m3709(VoipCallConfigData voipCallConfigData) {
        if (isFinishing() || this.f4513) {
            this.f4513 = false;
            return;
        }
        if (!isTablet()) {
            C1283.m16854("VoipActivity", "Phone, force portrait for dial screen");
            setRequestedOrientation(7);
        }
        m3702(voipCallConfigData);
        if (this.f4509 != null) {
            if (this.f4509.mo1428() && C1331Bd.m4010(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"})) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 0);
            }
            m3719();
            return;
        }
        C1283.m16850("VoipActivity", "Error while creating VoIP engine");
        m3717(getResources().getString(R.string.label_cs_call_error_message));
        m3706();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m3719() {
        C1356Cb.m4338(this, CustomerServiceLogging.Action.dial, null, IClientLogging.CompletionReason.success, null);
        if (this.f4509 == null || !this.f4509.mo1437()) {
            C1283.m16854("VoipActivity", "startDial:: Start call");
            try {
                this.f4512.m3693();
            } catch (Exception e) {
                C1283.m16847("VoipActivity", "Failed to dial", e);
                m3732(null, null, -1);
            }
        } else {
            C1283.m16850("VoipActivity", "Call is already in progress, what to start?");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3702(VoipCallConfigData voipCallConfigData) {
        if (!(this.f4502 == null || this.f4502.m9823() == null)) {
            this.f4509 = this.f4502.m9823().mo9647(voipCallConfigData);
        }
        if (this.f4509 != null) {
            this.f4509.mo1434(this);
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean m3697() {
        return (getServiceManager() == null || getServiceManager().m9827() == null || getServiceManager().m9827().mo16527() == null || !getServiceManager().m9827().mo16527().isShowConfirmationDialog()) ? false : true;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m3728() {
        this.f4511 = true;
        displayDialog(C0505.m14492(this, this.handler, new C0505.If(null, getString(R.string.label_cs_button_verify_message), getString(R.string.label_cs_button_verify_call_now), new Runnable() { // from class: o.Ao.2
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16854("VoipActivity", "User verified call to proceed!");
                ActivityC1313Ao.this.f4511 = false;
                ActivityC1313Ao.this.m3711();
            }
        }, getString(R.string.label_cs_button_verify_call_cancel), new Runnable() { // from class: o.Ao.1
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16854("VoipActivity", "User did NOT verified call to proceed!");
                ActivityC1313Ao.this.f4511 = false;
                ActivityC1313Ao.this.m3732(null, null, -1);
            }
        }), null));
    }

    public void performAction(View view) {
        if (this.f4504.m3647(view)) {
            C1283.m16854("VoipActivity", "Handled by landing page");
        } else if (this.f4512.m3689(view)) {
            C1283.m16854("VoipActivity", "Handled by dialer page");
        } else {
            C1283.m16865("VoipActivity", "Handled by nobody!");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean hasUpAction() {
        return true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showMdxInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSettingsInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSignOutInMenu() {
        return false;
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldStartLaunchActivityIfVisibleOnManagerUnavailable() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.contactUs;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public IVoip m3733() {
        return this.f4509;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m3734() {
        this.f4513 = true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        if (Boolean.valueOf(getServiceManager().mo9519() && getServiceManager().m9789()).booleanValue()) {
            try {
                if (this.f4501) {
                    C1356Cb.m4337(CustomerServiceLogging.Action.up);
                } else {
                    C1356Cb.m4338(this, CustomerServiceLogging.Action.up, null, IClientLogging.CompletionReason.canceled, null);
                }
                super.performUpAction();
                finish();
            } catch (Throwable th) {
                C1283.m16850("VoipActivity", "Running app in broken state, go for relaunch...");
                finish();
            }
        } else {
            onBackPressed();
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            C1283.m16854("VoipActivity", "Received response for Audio permission request.");
            for (String str : strArr) {
                C1283.m16854("VoipActivity", str);
            }
            int length = iArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                C1283.m16854("VoipActivity", "" + iArr[i2]);
            }
            if (C1331Bd.m4013(iArr, 2)) {
                C1283.m16854("VoipActivity", "Audio permission has now been granted. Go to dialer...");
                m3711();
                return;
            }
            C1283.m16862("VoipActivity", "Audio permission was NOT granted.");
            Snackbar.make(this.f4504.m3644(), (int) R.string.audio_permission_declined, -1).show();
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m3730() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.RECORD_AUDIO")) {
            C1283.m16862("VoipActivity", "Displaying audio permission rationale to provide additional context.");
            Snackbar.make(this.f4504.m3644(), (int) R.string.audio_permission_rationale, -2).setAction(R.string.label_ok, new View.OnClickListener() { // from class: o.Ao.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityCompat.requestPermissions(ActivityC1313Ao.this, ActivityC1313Ao.f4497, 0);
                }
            }).show();
            return;
        }
        ActivityCompat.requestPermissions(this, f4497, 0);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Class<?> m3700() {
        return NetflixApplication.getInstance().m254() ? ActivityC1310Al.class : ActivityC1313Ao.class;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Intent m3721(Context context) {
        return new Intent(context, m3700());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Intent m3712(Context context) {
        Intent intent = new Intent(context, m3700());
        intent.addFlags(268435456);
        intent.putExtra("AUTODIAL", true);
        return intent;
    }

    /* renamed from: o.Ao$if  reason: invalid class name */
    class Cif extends ContentObserver {

        /* renamed from: ˎ  reason: contains not printable characters */
        int f4522 = ((AudioManager) this.f4523.getSystemService("audio")).getStreamVolume(3);

        /* renamed from: ॱ  reason: contains not printable characters */
        Context f4523;

        public Cif(Context context) {
            super(ActivityC1313Ao.this.handler);
            this.f4523 = context;
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return super.deliverSelfNotifications();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            AudioManager audioManager = (AudioManager) this.f4523.getSystemService("audio");
            int streamVolume = audioManager.getStreamVolume(0);
            float streamMaxVolume = ((float) streamVolume) / ((float) audioManager.getStreamMaxVolume(0));
            int i = this.f4522 - streamVolume;
            if (i > 0) {
                C1283.m16854("VoipActivity", "Decreased");
                this.f4522 = streamVolume;
            } else if (i < 0) {
                C1283.m16854("VoipActivity", "Increased");
                this.f4522 = streamVolume;
            }
            C0399 r8 = new C0399(streamMaxVolume, ActivityC1313Ao.this.f4512 != null && ActivityC1313Ao.this.f4512.m3691());
            Logger.INSTANCE.m127(r8);
            Logger.INSTANCE.m131(new C1179());
            Logger.INSTANCE.m132(Long.valueOf(r8.m14625()));
            if (ActivityC1313Ao.this.f4509 != null) {
                ActivityC1313Ao.this.f4509.mo1547(streamMaxVolume);
            }
        }
    }
}
