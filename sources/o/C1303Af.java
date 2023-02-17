package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
import o.C1305Ag;
/* renamed from: o.Af  reason: case insensitive filesystem */
public class C1303Af extends AbstractC0496 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final Integer f4408 = 4;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final Uri f4409 = Uri.parse("http://www.netflix.com/PIN");

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f4410;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private PlayVerifierVault f4411;

    /* renamed from: ʼ  reason: contains not printable characters */
    private TextView f4412;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private ProgressBar f4413;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f4414;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f4415;

    /* renamed from: ͺ  reason: contains not printable characters */
    private ImageView f4416;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f4417;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private EditText f4418;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private TextView f4419;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private C1305Ag.AbstractC0066 f4420;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static C1303Af m3591(PlayVerifierVault playVerifierVault) {
        C1283.m16854("nf_pin", "creating dialog");
        C1303Af af = new C1303Af();
        Bundle bundle = new Bundle();
        bundle.putParcelable(PlayVerifierVault.f3962, playVerifierVault);
        af.setArguments(bundle);
        af.setStyle(1, R.style.res_2131951877_netflixdialog_notitle);
        return af;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001d: APUT  
      (r2v1 java.lang.Object[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: java.lang.Boolean : 0x0018: INVOKE  (r3v3 java.lang.Boolean) = (r3v2 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreate(bundle);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.f4415);
        objArr[1] = Boolean.valueOf(bundle != null);
        C1283.m16854("nf_pin", String.format("onCreateDialog - mIsActive:%b,  restored=%b", objArr));
        if (bundle != null) {
            this.f4414 = bundle.getBoolean("pin_progress");
            this.f4417 = bundle.getBoolean("pin_error");
        }
        this.f4411 = (PlayVerifierVault) getArguments().getParcelable(PlayVerifierVault.f3962);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.pin_dialog, (ViewGroup) null);
        this.f4413 = (ProgressBar) inflate.findViewById(R.id.dialog_pin_progress_spinner);
        this.f4418 = (EditText) inflate.findViewById(R.id.pin_input);
        this.f4418.setOnEditorActionListener(new Cif());
        this.f4418.setOnKeyListener(new View$OnKeyListenerC1304iF());
        this.f4412 = (TextView) inflate.findViewById(R.id.pin_message);
        this.f4419 = (TextView) inflate.findViewById(R.id.pin_forgot);
        this.f4419.setText(C1349Bv.m4102(getString(R.string.label_pin_forgot)));
        this.f4419.setPaintFlags(this.f4419.getPaintFlags() | 8);
        this.f4419.setOnClickListener(new View.OnClickListener() { // from class: o.Af.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1303Af.this.f4419.setTextColor(C1303Af.this.getResources().getColor(R.color.pin_link_text_light));
                Intent intent = new Intent("android.intent.action.VIEW", C1303Af.f4409);
                if (intent.resolveActivity(C1303Af.this.getActivity().getPackageManager()) != null) {
                    C1303Af.this.startActivity(intent);
                }
            }
        });
        this.f4419.setFocusable(false);
        if (m3583(this.f4411)) {
            this.f4419.setVisibility(8);
        }
        this.f4416 = (ImageView) inflate.findViewById(R.id.pin_ic_input_error);
        this.f4410 = AD.m3299() ? 400 : 320;
        m3598(this.f4417);
        m3582(this.f4414);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.setButton(-2, getString(R.string.label_cancel), new DialogInterface$OnClickListenerC0065());
        this.f4415 = true;
        return create;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C1283.m16854("nf_pin", "onSavedInstanceState");
        bundle.putBoolean("pin_progress", this.f4414);
        bundle.putBoolean("pin_error", this.f4417);
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        C1283.m16854("nf_pin", "onCancel");
        this.f4415 = false;
        m3588();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1283.m16854("nf_pin", "onResume");
        this.f4419.setLinkTextColor(-1);
        m3600();
        if (!this.f4414) {
            m3603();
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1283.m16854("nf_pin", "onStart");
        if (C1306Ah.m3615().m3618()) {
            C1283.m16854("nf_pin", "onStart - dismissOnForeground");
            m3580();
        }
    }

    @Override // o.AbstractC0496, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        super.onManagerReady(phVar, status);
        C1283.m16854("nf_pin", "onManagerReady");
        if (this.f4414) {
            C1283.m16854("nf_pin", "doing pin validation again for restored dialog");
            m3586(this.f4418.getText().toString());
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m3606(C1305Ag.AbstractC0066 r3) {
        C1283.m16854("nf_pin", "setPinVerifierCallback");
        this.f4420 = r3;
    }

    /* renamed from: o.Af$ˊ  reason: contains not printable characters */
    class DialogInterface$OnClickListenerC0065 implements DialogInterface.OnClickListener {
        private DialogInterface$OnClickListenerC0065() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            C1303Af.this.f4415 = false;
            C1303Af.this.m3580();
        }
    }

    /* renamed from: o.Af$if  reason: invalid class name */
    class Cif implements TextView.OnEditorActionListener {
        private Cif() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            String charSequence = textView.getText().toString();
            if (charSequence.length() < C1303Af.f4408.intValue()) {
                return true;
            }
            if (C1303Af.this.m14474() == null) {
                C1283.m16854("nf_pin", "serviceManager is null");
                return false;
            }
            C1303Af.this.m3586(charSequence);
            return false;
        }
    }

    /* renamed from: o.Af$iF  reason: case insensitive filesystem */
    class View$OnKeyListenerC1304iF implements View.OnKeyListener {
        private View$OnKeyListenerC1304iF() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 67) {
                return false;
            }
            C1303Af.this.f4418.setError(null, null);
            C1303Af.this.m3598(false);
            String obj = ((EditText) view).getText().toString();
            if (obj.length() < C1303Af.f4408.intValue()) {
                return false;
            }
            if (C1303Af.this.m14474() == null) {
                C1283.m16854("nf_pin", "serviceManager is null");
                return false;
            }
            C1303Af.this.m3586(obj);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m3586(String str) {
        m3582(true);
        m3598(false);
        AD.m3298(m3589(m14474()), this.f4418);
        C1283.m16854("nf_pin", "onEditorAction gotDone! password: " + str);
        UserAgentInterface.PinType pinType = UserAgentInterface.PinType.MATURITY_PIN;
        String str2 = null;
        if (m3583(this.f4411)) {
            pinType = UserAgentInterface.PinType.PREVIEW_CONTENT_PIN;
            str2 = this.f4411.m2942();
        }
        m14474().m9771(str, pinType, str2, new If(this.f4420));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Af$If */
    public class If extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        protected final C1305Ag.AbstractC0066 f4422;

        public If(C1305Ag.AbstractC0066 r3) {
            super("nf_pin");
            this.f4422 = r3;
        }

        @Override // o.oP, o.oU
        public void onVerified(boolean z, Status status) {
            super.onVerified(z, status);
            C1283.m16854("nf_pin", "onVerified");
            if (!C1303Af.this.f4415) {
                C1283.m16854("nf_pin", "dialog was cancelled before.. nothing to do");
                return;
            }
            C1303Af.this.m3582(false);
            if (!status.mo298() || z) {
                C1303Af.this.m3607();
                if (status.mo298()) {
                    if (!C1303Af.this.m3583(C1303Af.this.f4411)) {
                        C1306Ah.m3615().m3619();
                    }
                    C1303Af.m3596((NetflixActivity) C1303Af.this.getActivity(), C1303Af.this.f4411, this.f4422);
                    return;
                }
                NetflixActivity netflixActivity = (NetflixActivity) C1303Af.this.getActivity();
                if (netflixActivity != null) {
                    C1303Af.m3592(netflixActivity, status);
                    return;
                }
                return;
            }
            C1303Af.this.m3605();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m3605() {
        this.f4412.setText(R.string.label_pin_error);
        this.f4418.getText().clear();
        m3598(true);
        m3594(m14474(), this.f4418);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    protected static void m3596(NetflixActivity netflixActivity, PlayVerifierVault playVerifierVault, C1305Ag.AbstractC0066 r10) {
        if (playVerifierVault == null || netflixActivity == null) {
            C1283.m16854("nf_pin", "mVault or activity is null - cannot start playback");
        } else if (PlayVerifierVault.RequestedBy.PLAY_LAUNCHER.m2951().equals(playVerifierVault.m2945())) {
            if (playVerifierVault.m2942() == null) {
                C1283.m16854("nf_pin", "videoid is null - cannot start playback");
            } else {
                PlaybackLauncher.m1616(netflixActivity, playVerifierVault.m2942(), playVerifierVault.m2947(), playVerifierVault.m2940(), playVerifierVault.m2941(), playVerifierVault.m2946(), playVerifierVault.m2943());
            }
        } else if (PlayVerifierVault.RequestedBy.MDX.m2951().equals(playVerifierVault.m2945())) {
            netflixActivity.sendIntentToNetflixService(uT.m11652(netflixActivity, "com.netflix.mediaclient.intent.action.MDX_ACTION_PINCONFIRMED", playVerifierVault.m2944()));
        } else if (PlayVerifierVault.RequestedBy.PLAYER.m2951().equals(playVerifierVault.m2945())) {
            if (r10 != null) {
                r10.onPlayVerified(true, playVerifierVault);
            } else {
                C1283.m16862("nf_pin", "notifyCallerPinVerified RequestedBy.PLAYER callback is null");
            }
        } else if (!PlayVerifierVault.RequestedBy.OFFLINE_DOWNLOAD.m2951().equals(playVerifierVault.m2945())) {
        } else {
            if (r10 != null) {
                r10.onOfflineDownloadPinAndAgeVerified(true, playVerifierVault);
            } else {
                C1283.m16862("nf_pin", "notifyCallerPinVerified RequestedBy.OFFLINE_DOWNLOAD callback is null");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private void m3580() {
        m3607();
        m3588();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m3588() {
        C1283.m16854("nf_pin", String.format("%s onPinCancelled vault: %s", NetflixActivity.class.getSimpleName(), this.f4411));
        if (this.f4411 == null) {
            C1283.m16854("nf_pin", "mValut is null - cannot start playback");
        } else if (PlayVerifierVault.RequestedBy.MDX.m2951().equals(this.f4411.m2945()) && getActivity() != null) {
            Intent r5 = uT.m11652(getActivity(), "com.netflix.mediaclient.intent.action.MDX_ACTION_PINCANCELLED", this.f4411.m2944());
            NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(getActivity(), NetflixActivity.class);
            if (netflixActivity != null) {
                netflixActivity.sendIntentToNetflixService(r5);
            }
        } else if (PlayVerifierVault.RequestedBy.PLAYER.m2951().equals(this.f4411.m2945())) {
            if (this.f4420 != null) {
                this.f4420.onPlayVerified(false, this.f4411);
            } else {
                C1283.m16862("nf_pin", "notifyCallerPinCancelled RequestedBy.PLAYER callback is null");
            }
        } else if (!PlayVerifierVault.RequestedBy.OFFLINE_DOWNLOAD.m2951().equals(this.f4411.m2945())) {
        } else {
            if (this.f4420 != null) {
                this.f4420.onOfflineDownloadPinAndAgeVerified(false, this.f4411);
            } else {
                C1283.m16862("nf_pin", "notifyCallerPinCancelled RequestedBy.OFFLINE_DOWNLOAD callback is null");
            }
        }
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment
    public void dismiss() {
        this.f4420 = null;
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m3607() {
        C1283.m16854("nf_pin", "dismissing pin dialog");
        try {
            getDialog().dismiss();
            C1306Ah.m3615().m3624();
        } catch (Exception e) {
            C1283.m16854("nf_pin", "app in backgound. cannot dismiss - retry on next start");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m3594(C2059ph phVar, EditText editText) {
        InputMethodManager r1 = m3589(phVar);
        if (r1 != null) {
            r1.showSoftInput(editText, 1);
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m3603() {
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setSoftInputMode(5);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private InputMethodManager m3589(C2059ph phVar) {
        if (phVar == null || phVar.m9814() == null) {
            return null;
        }
        return (InputMethodManager) getActivity().getSystemService("input_method");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m3582(boolean z) {
        this.f4414 = z;
        this.f4413.setVisibility(z ? 0 : 8);
        this.f4418.setVisibility(z ? 8 : 0);
        if (!m3583(this.f4411)) {
            this.f4419.setVisibility(z ? 8 : 0);
        }
        if (z) {
            this.f4412.setText(R.string.label_pin_message_sending);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m3598(boolean z) {
        this.f4417 = z;
        this.f4416.setVisibility(z ? 0 : 8);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m3600() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        try {
            layoutParams.copyFrom(getDialog().getWindow().getAttributes());
            layoutParams.width = (int) (0.5f + TypedValue.applyDimension(1, (float) this.f4410, getResources().getDisplayMetrics()));
            getDialog().getWindow().setAttributes(layoutParams);
        } catch (Exception e) {
            C1283.m16850("nf_pin", "Could not set windowSize e:" + e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3592(NetflixActivity netflixActivity, Status status) {
        new AlertDialog.Builder(netflixActivity).setCancelable(false).setMessage(String.format("%s (%d)", netflixActivity.getString(R.string.nflx_connectivity_error), Integer.valueOf(status.mo302().m271()))).setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() { // from class: o.Af.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m3583(PlayVerifierVault playVerifierVault) {
        return playVerifierVault.m2947();
    }
}
