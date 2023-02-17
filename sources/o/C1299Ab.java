package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.NetworkErrorStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
import o.C1305Ag;
/* renamed from: o.Ab  reason: case insensitive filesystem */
public class C1299Ab extends AbstractC0496 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f4332;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f4333;

    /* renamed from: ʽ  reason: contains not printable characters */
    private ProgressBar f4334;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C1305Ag.AbstractC0066 f4335;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AlertDialog f4336;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f4337;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f4338;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private PlayVerifierVault f4339;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private TextView f4340;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected static C1299Ab m3513(PlayVerifierVault playVerifierVault) {
        C1283.m16854("nf_age", "creating dialog");
        C1299Ab ab = new C1299Ab();
        Bundle bundle = new Bundle();
        bundle.putParcelable(PlayVerifierVault.f3962, playVerifierVault);
        ab.setArguments(bundle);
        ab.setStyle(1, R.style.res_2131951877_netflixdialog_notitle);
        return ab;
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreate(bundle);
        this.f4332 = true;
        this.f4338 = bundle != null;
        C1283.m16854("nf_age", String.format("onCreateDialog - mIsActive:%b,  restored=%b", Boolean.valueOf(this.f4337), Boolean.valueOf(this.f4338)));
        if (this.f4338) {
            this.f4332 = bundle.getBoolean("age_progress");
        }
        this.f4339 = (PlayVerifierVault) getArguments().getParcelable(PlayVerifierVault.f3962);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.age_dialog, (ViewGroup) null);
        this.f4334 = (ProgressBar) inflate.findViewById(R.id.dialog_age_progress_spinner);
        this.f4340 = (TextView) inflate.findViewById(R.id.age_message);
        this.f4333 = AD.m3299() ? 400 : 320;
        builder.setView(inflate);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.setButton(-2, getString(R.string.label_cancel), new Cif());
        create.setButton(-1, getString(R.string.label_age_verify_button), new DialogInterface$OnClickListenerC0064());
        this.f4337 = true;
        this.f4336 = create;
        boolean z = this.f4338;
        return create;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C1283.m16854("nf_age", "onSavedInstanceState");
        bundle.putBoolean("age_progress", this.f4332);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m3515(boolean z) {
        this.f4332 = z;
        this.f4334.setVisibility(z ? 0 : 8);
        this.f4340.setText(z ? R.string.label_age_check_message : R.string.label_age_verify_message);
        m3512(!z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3512(boolean z) {
        Button button = this.f4336.getButton(-1);
        if (button != null) {
            button.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        C1283.m16854("nf_age", "onCancel");
        this.f4337 = false;
        m3519();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1283.m16854("nf_age", "onResume");
        m3509();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        C1283.m16854("nf_age", "onStart");
        super.onStart();
        m3515(this.f4332);
        if (!this.f4338 && m14474() != null) {
            C1283.m16854("nf_age", "starting age verification");
            m14474().m9773(new If());
        }
    }

    @Override // o.AbstractC0496, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        super.onManagerReady(phVar, status);
        C1283.m16854("nf_age", "onManagerReady - starting age verification");
        phVar.m9773(new If());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m3520() {
        this.f4337 = false;
        m3515(false);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m3521(C1305Ag.AbstractC0066 r1) {
        this.f4335 = r1;
    }

    /* renamed from: o.Ab$if  reason: invalid class name */
    class Cif implements DialogInterface.OnClickListener {
        private Cif() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            C1283.m16854("nf_age", "onCancel button");
            C1299Ab.this.m3508();
            C1299Ab.this.m3519();
        }
    }

    /* renamed from: o.Ab$ˋ  reason: contains not printable characters */
    class DialogInterface$OnClickListenerC0064 implements DialogInterface.OnClickListener {
        private DialogInterface$OnClickListenerC0064() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            C1283.m16854("nf_age", "verifyButton clicked - going to webview");
            final NetflixActivity r2 = C1299Ab.this.m14476();
            new Runnable() { // from class: o.Ab.ˋ.2
                @Override // java.lang.Runnable
                public void run() {
                    C1283.m16854("nf_age", "Get autologin token...");
                    final C2154sm smVar = new C2154sm(r2);
                    final NetworkErrorStatus networkErrorStatus = new NetworkErrorStatus(BK.f4581);
                    final AnonymousClass1 r5 = new Runnable() { // from class: o.Ab.ˋ.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            smVar.m10804((String) null, networkErrorStatus);
                        }
                    };
                    r2.getHandler().postDelayed(r5, 10000);
                    r2.getServiceManager().m9784(3600000, new AbstractC2061pj() { // from class: o.Ab.ˋ.2.5
                        @Override // o.AbstractC2061pj, o.oU
                        public void onAutoLoginTokenCreated(String str, Status status) {
                            r2.getHandler().removeCallbacks(r5);
                            smVar.m10803(str, status, "https://www.netflix.com/verifyage");
                        }
                    });
                }
            }.run();
            C1299Ab.this.m3508();
            C1299Ab.this.m3519();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m3509() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        try {
            layoutParams.copyFrom(getDialog().getWindow().getAttributes());
            layoutParams.width = (int) (0.5f + TypedValue.applyDimension(1, (float) this.f4333, getResources().getDisplayMetrics()));
            getDialog().getWindow().setAttributes(layoutParams);
        } catch (Exception e) {
            C1283.m16850("nf_age", "Could not set windowSize e:" + e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private void m3508() {
        C1283.m16854("nf_age", "dismissing age dialog");
        getDialog().dismiss();
        this.f4337 = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m3519() {
        C1283.m16854("nf_pin", String.format("%s onAgeCancelled vault: %s", NetflixActivity.class.getSimpleName(), this.f4339));
        if (this.f4339 == null) {
            C1283.m16854("nf_age", "mValut is null - cannot start playback");
        } else if (PlayVerifierVault.RequestedBy.MDX.m2951().equals(this.f4339.m2945()) && getActivity() != null) {
            NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(getActivity(), NetflixActivity.class);
            if (netflixActivity != null) {
                netflixActivity.sendIntentToNetflixService(uT.m11652(getActivity(), "com.netflix.mediaclient.intent.action.MDX_ACTION_PINCANCELLED", this.f4339.m2944()));
            }
        } else if (PlayVerifierVault.RequestedBy.PLAYER.m2951().equals(this.f4339.m2945())) {
            if (this.f4335 != null) {
                this.f4335.onPlayVerified(false, this.f4339);
            } else {
                C1283.m16854("nf_age", "notifyCallerAgeCancelled PLAYER callback is null");
            }
        } else if (!PlayVerifierVault.RequestedBy.OFFLINE_DOWNLOAD.m2951().equals(this.f4339.m2945())) {
        } else {
            if (this.f4335 != null) {
                this.f4335.onOfflineDownloadPinAndAgeVerified(false, this.f4339);
            } else {
                C1283.m16854("nf_age", "notifyCallerAgeCancelled OFFLINE_DOWNLOAD callback is null");
            }
        }
    }

    /* renamed from: o.Ab$If */
    class If extends oP {
        public If() {
            super("nf_age");
        }

        @Override // o.oP, o.oU
        public void onVerified(boolean z, Status status) {
            super.onVerified(z, status);
            C1283.m16854("nf_age", String.format("onVerified mVault:%s", C1299Ab.this.f4339));
            if (!C1299Ab.this.f4337) {
                C1283.m16854("nf_age", "dialog was cancelled before.. nothing to do");
                return;
            }
            C1283.m16851("nf_age", "onAgeVerified statusCode:%d", Integer.valueOf(status.mo302().m271()));
            if (!status.mo298() || !z) {
                C1299Ab.this.m3520();
                return;
            }
            C1299Ab.this.m3508();
            C1305Ag.m3608((NetflixActivity) C1299Ab.this.getActivity(), C1299Ab.this.f4339, C1299Ab.this.f4335);
        }
    }
}
