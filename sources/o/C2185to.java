package o;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.ActionOnUIError;
import com.netflix.mediaclient.service.logging.client.model.RootCause;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
import com.netflix.mediaclient.ui.launch.LaunchActivity;
import com.netflix.mediaclient.util.ConnectivityUtils;
/* renamed from: o.to  reason: case insensitive filesystem */
public class C2185to extends C2188tr implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    private TextInputLayout f10576;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private ProgressBar f10577;

    /* renamed from: ʼ  reason: contains not printable characters */
    private EditText f10578;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final AbstractC2061pj f10579 = new AbstractC2061pj() { // from class: o.to.2
        @Override // o.AbstractC2061pj, o.oU
        public void onLoginComplete(final Status status) {
            if (!C1317As.m3750(C2185to.this.getActivity())) {
                C2185to.this.getActivity().runOnUiThread(new Runnable() { // from class: o.to.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        C2185to.this.m11219(status);
                    }
                });
            }
        }
    };

    /* renamed from: ʽ  reason: contains not printable characters */
    private TextInputLayout f10580;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean f10581;

    /* renamed from: ʾ  reason: contains not printable characters */
    private GoogleApiClient f10582;

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f10583;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final Handler f10584 = new Handler();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private View f10585;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private View f10586;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private View f10587;

    /* renamed from: ͺ  reason: contains not printable characters */
    private TextView f10588;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private TextView f10589;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private String f10590;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private TextView f10591;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private EditText f10592;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f10593;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private TextView f10594;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C2185to m11202(Bundle bundle) {
        C2185to toVar = new C2185to();
        toVar.setArguments(bundle);
        return toVar;
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        super.onManagerReady(phVar, status);
        C1283.m16862("LoginBaseFragment", "EmailPasswordFragment onManagerReady");
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            m11209(bundle);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11218() {
        if (AS.m3410(m14534())) {
            this.f10582 = new GoogleApiClient.Builder(m14534()).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Auth.CREDENTIALS_API).build();
            this.f10582.connect();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1283.m16862("LoginBaseFragment", "EmailPasswordFragment onCreateView");
        View inflate = layoutInflater.inflate(R.layout.login_email_password_fragment, viewGroup, false);
        mo11236(inflate);
        if (bundle != null) {
            this.f10593 = bundle.getBoolean("showPasswordSelected");
            if (this.f10593) {
                m11233();
            }
        }
        m11218();
        return inflate;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2188tr
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo11236(View view) {
        super.mo11236(view);
        this.f10578 = (EditText) view.findViewById(R.id.login_email);
        this.f10578.requestFocus();
        this.f10592 = (EditText) view.findViewById(R.id.login_password);
        this.f10586 = view.findViewById(R.id.login_form);
        this.f10585 = view.findViewById(R.id.login_action_btn);
        this.f10594 = (TextView) view.findViewById(R.id.password_inline_error);
        this.f10591 = (TextView) view.findViewById(R.id.email_inline_error);
        this.f10576 = (TextInputLayout) view.findViewById(R.id.username_text_input_layout);
        this.f10580 = (TextInputLayout) view.findViewById(R.id.password_text_input_layout);
        this.f10587 = view.findViewById(R.id.login_status_group);
        this.f10577 = (ProgressBar) view.findViewById(R.id.loading_view);
        this.f10589 = (TextView) view.findViewById(R.id.login_status_message);
        this.f10588 = (TextView) view.findViewById(R.id.show_password);
        if (zN.f12697.m13523(view.getContext())) {
            view.findViewById(R.id.login_action_new_to_netflix).setVisibility(8);
        }
        if (BX.m3957()) {
            this.f10588.setGravity(3);
            this.f10592.setGravity(5);
            this.f10592.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: o.to.1
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view2, boolean z) {
                    if (z) {
                        C2185to.this.f10592.setGravity(8388611);
                    }
                }
            });
        }
        this.f10578.addTextChangedListener(new TextWatcher() { // from class: o.to.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                C2185to.this.f10591.setVisibility(8);
                C2185to.this.f10576.setBackgroundResource(R.drawable.login_edit_text_background);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.f10592.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: o.to.9
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (!m11238(i)) {
                    return false;
                }
                C2185to.this.m11223();
                return true;
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            private boolean m11238(int i) {
                return i == R.integer.ime_action_login || i == 0 || i == 6;
            }
        });
        this.f10592.addTextChangedListener(new TextWatcher() { // from class: o.to.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (C2185to.this.f10592.length() == 0 || C2185to.this.f10592.getText().length() >= 4) {
                    C2185to.this.f10594.setVisibility(8);
                    C2185to.this.f10580.setBackgroundResource(R.drawable.login_edit_text_background);
                }
                if (C2185to.this.f10592.getText().toString().length() > 0) {
                    C2185to.this.f10588.setVisibility(0);
                } else {
                    C2185to.this.f10588.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.f10588.setOnClickListener(new View.OnClickListener() { // from class: o.to.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!C2185to.this.f10593) {
                    C2185to.this.m11233();
                } else {
                    C2185to.this.m11213();
                }
            }
        });
        view.findViewById(R.id.login_action_btn).setOnClickListener(new View.OnClickListener() { // from class: o.to.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (C2185to.this.f10592.getText().toString().length() < 4) {
                    C2185to.this.f10594.setVisibility(0);
                    C2185to.this.f10580.setBackgroundResource(R.drawable.login_edit_text_error_background);
                    C2185to.this.f10592.requestFocus();
                }
                C2185to.this.m11223();
            }
        });
        view.findViewById(R.id.login_action_forgot_pass).setOnClickListener(new View.OnClickListener() { // from class: o.to.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                C2185to.this.m11225();
            }
        });
        view.findViewById(R.id.login_action_new_to_netflix).setOnClickListener(new View.OnClickListener() { // from class: o.to.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                C2185to.this.m11206();
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11204(StatusCode statusCode, String str) {
        C2191tu.m11255(statusCode, str).show(getFragmentManager(), "fragment_alert");
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("showPasswordSelected", this.f10593);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m11233() {
        this.f10592.setTransformationMethod(null);
        this.f10592.setSelection(this.f10592.getText().length());
        this.f10588.setText(getString(R.string.hide));
        this.f10593 = true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m11213() {
        this.f10592.setTransformationMethod(new PasswordTransformationMethod());
        this.f10592.setSelection(this.f10592.getText().length());
        this.f10588.setText(getString(R.string.show));
        this.f10593 = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺ  reason: contains not printable characters */
    private void m11225() {
        Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse("https://signup.netflix.com/loginhelp"));
        if (data.resolveActivity(m14534().getPackageManager()) != null) {
            startActivityForResult(data, 0);
        } else {
            m14534().displayServiceAgentDialog(getString(R.string.label_visit_url, "https://signup.netflix.com/loginhelp"), null, false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m11206() {
        C1283.m16854("LoginBaseFragment", "going to signup activity");
        if (LaunchActivity.m1998(m14536())) {
            startActivity(zN.f12697.m13529(getActivity()));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11229(boolean z) {
        this.f10587.setVisibility(z ? 0 : 8);
        this.f10577.setVisibility(z ? 0 : 8);
        this.f10586.setVisibility(z ? 8 : 0);
        this.f10585.setEnabled(!z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m11223() {
        this.f10578.setError(null);
        this.f10592.setError(null);
        this.f10590 = this.f10578.getText().toString();
        String obj = this.f10592.getText().toString();
        boolean z = false;
        EditText editText = null;
        if (m11221(m14536(), obj)) {
            m11215(getString(R.string.invalid_password));
            editText = this.f10592;
            z = true;
        }
        if (m11211(m14536(), this.f10590)) {
            m11215(getString(R.string.invalid_email));
            editText = this.f10578;
            z = true;
        }
        if (z) {
            C1283.m16862("LoginBaseFragment", "There was an error - skipping login and showing error msg");
            editText.requestFocus();
            return;
        }
        C2059ph r5 = m14536();
        if (!ConnectivityUtils.m2970(getActivity()) || r5 == null || !r5.mo9519()) {
            m11230();
            return;
        }
        AD.m3291((Activity) getActivity());
        this.f10589.setText(R.string.login_progress_signing_in);
        AD.m3310(getActivity(), this.f10592);
        m11229(true);
        C1363Ci.m4428(SignInLogging.SignInType.emailPassword);
        Logger.INSTANCE.m142(new C0962());
        if (r5.m9789()) {
            r5.m9760(new If());
        } else {
            r5.m9772(this.f10590, obj, this.f10579);
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m11230() {
        if (!C1317As.m3750(getActivity())) {
            getActivity().runOnUiThread(new Runnable() { // from class: o.to.14
                @Override // java.lang.Runnable
                public void run() {
                    C2185to.this.m14534().displayDialog(C0505.m14491(C2185to.this.m14534(), C2185to.this.f10584, new C1278(null, C2185to.this.getString(R.string.label_nointernet), C2185to.this.getString(R.string.label_ok), null)));
                }
            });
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m11211(C2059ph phVar, String str) {
        SignInConfigData r3;
        boolean r1 = C1349Bv.m4113(str);
        boolean z = false;
        if (!(phVar == null || phVar.m9827() == null || (r3 = phVar.m9827().mo16538()) == null)) {
            z = !r3.isEmailValid(str);
        }
        return r1 || z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m11221(C2059ph phVar, String str) {
        SignInConfigData r4;
        boolean z = C1349Bv.m4113(str) || str.length() < 4;
        boolean z2 = false;
        if (!(phVar == null || phVar.m9827() == null || (r4 = phVar.m9827().mo16538()) == null)) {
            z2 = !r4.isPasswordValid(str);
        }
        return z || z2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11219(Status status) {
        m14534().setRequestedOrientation(-1);
        if (status.mo298() || status.mo302() == StatusCode.NRD_REGISTRATION_EXISTS) {
            Logger.INSTANCE.m133("SignIn");
            m14534().showDebugToast(getString(R.string.label_sign_in_successful));
            m11235();
            return;
        }
        Logger.INSTANCE.m134("SignIn", C1343Bp.m4068(status));
        m11201(status);
        m11229(false);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11228(Status status, String str) {
        C1362Ch.m4388(m14534().getUiScreen().f4084, IClientLogging.CompletionReason.failed, AbstractC1358Cd.m4353(status, str, ActionOnUIError.displayedError));
        C1362Ch.m4423(null, m14534().getUiScreen().f4084);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11215(String str) {
        C1362Ch.m4388(m14534().getUiScreen().f4084, IClientLogging.CompletionReason.canceled, new UIError(RootCause.clientFailure, ActionOnUIError.displayedError, str, null));
        C1362Ch.m4423(null, m14534().getUiScreen().f4084);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m11201(Status status) {
        String str = "";
        StatusCode r4 = status.mo302();
        if (status.mo304()) {
            str = getString(R.string.login_network_or_ssl_Error) + " (" + r4.m271() + ")";
            m14534().displayServiceAgentDialog(str, null, true);
        }
        switch (r4) {
            case ERROR_UNRECOGNIZED_EMAIL:
                str = getString(R.string.invalid_email);
                m11227(StatusCode.ERROR_UNRECOGNIZED_EMAIL);
                break;
            case ERROR_INCORRECT_PASSWORD:
                str = getString(R.string.label_incorrect_password);
                m11227(StatusCode.ERROR_INCORRECT_PASSWORD);
                break;
            case ERROR_ACCOUNT_PASSWORD_NOT_SET:
                str = getString(R.string.password_reset_error);
                m11227(StatusCode.ERROR_ACCOUNT_PASSWORD_NOT_SET);
                break;
            case USER_SIGNIN_THROTTLED:
                str = getString(R.string.login_throttled) + " (" + r4.m271() + ")";
                m14534().displayServiceAgentDialog(str, null, false);
                break;
            case NRD_LOGIN_ACTIONID_2:
                str = getString(R.string.login_actionid_2) + " (" + r4.m271() + ")";
                m14534().displayServiceAgentDialog(str, null, false);
                break;
            case NRD_LOGIN_ACTIONID_4:
                str = getString(R.string.label_incorrect_password_or_email_address);
                m11227(StatusCode.USER_SIGNIN_RETRY);
                break;
            case NRD_LOGIN_ACTIONID_8:
                str = getString(R.string.label_incorrect_password_or_email_address);
                m11227(StatusCode.USER_SIGNIN_RETRY);
                break;
            case USER_SIGNIN_RETRY:
                str = getString(R.string.login_actionid_2);
                m11227(StatusCode.USER_SIGNIN_RETRY);
                break;
            case ERROR_FORMER_MEMBER_CONSUMPTION:
                str = getString(R.string.label_unaccepted_signups_consumption_error);
                m11227(StatusCode.ERROR_FORMER_MEMBER_CONSUMPTION);
                break;
            case ERROR_FORMER_MEMBER_REDIRECT:
                str = getString(R.string.label_unaccepted_signups_redirect_error);
                m11227(StatusCode.ERROR_FORMER_MEMBER_REDIRECT);
                break;
            case ERROR_NEVER_MEMBER_CONSUMPTION:
                str = getString(R.string.welcome_back);
                m11227(StatusCode.ERROR_NEVER_MEMBER_CONSUMPTION);
                break;
            case ERROR_NEVER_MEMBER_REDIRECT:
                str = getString(R.string.welcome_back);
                m11227(StatusCode.ERROR_NEVER_MEMBER_REDIRECT);
                break;
            case ERROR_DVD_MEMBER_REDIRECT:
                str = getString(R.string.welcome_back);
                m11227(StatusCode.ERROR_DVD_MEMBER_REDIRECT);
                break;
            case ERROR_UNRECOGNIZED_CONSUMPTION:
                str = getString(R.string.label_unaccepted_signups_consumption_error);
                m11227(StatusCode.ERROR_UNRECOGNIZED_CONSUMPTION);
                break;
            case ERROR_UNRECOGNIZED_REDIRECT:
                str = getString(R.string.label_unaccepted_signups_redirect_error);
                m11227(StatusCode.ERROR_UNRECOGNIZED_REDIRECT);
                break;
            default:
                m14534().handleUserAgentErrors(status);
                break;
        }
        m11228(status, str);
        return str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11227(StatusCode statusCode) {
        switch (statusCode) {
            case ERROR_UNRECOGNIZED_EMAIL:
            case ERROR_UNRECOGNIZED_CONSUMPTION:
            case ERROR_UNRECOGNIZED_REDIRECT:
                this.f10591.setVisibility(0);
                this.f10576.setBackgroundResource(R.drawable.login_edit_text_error_background);
                this.f10591.setText(R.string.label_account_not_found);
                this.f10578.requestFocus();
                break;
            case ERROR_INCORRECT_PASSWORD:
                this.f10594.setVisibility(0);
                this.f10580.setBackgroundResource(R.drawable.login_edit_text_error_background);
                this.f10594.setText(R.string.label_incorrect_password);
                this.f10592.requestFocus();
                break;
            case ERROR_ACCOUNT_PASSWORD_NOT_SET:
                this.f10594.setVisibility(0);
                this.f10580.setBackgroundResource(R.drawable.login_edit_text_error_background);
                this.f10594.setText(R.string.label_incorrect_password);
                this.f10592.requestFocus();
                break;
        }
        if (!this.f10581) {
            m11204(statusCode, this.f10590);
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private synchronized void m11235() {
        if (!AS.m3410(getActivity())) {
            C1283.m16854("LoginBaseFragment", "SmartLock is disabled or device does not support GPS");
            m11210((com.google.android.gms.common.api.Status) null);
            return;
        }
        GoogleApiClient googleApiClient = this.f10582;
        if (googleApiClient == null) {
            C1283.m16854("LoginBaseFragment", "GPS client unavailable, unable to attempt to save credentials");
            m11210((com.google.android.gms.common.api.Status) null);
            return;
        }
        this.f10583 = true;
        if (googleApiClient.isConnected()) {
            m11203(googleApiClient);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private synchronized void m11203(GoogleApiClient googleApiClient) {
        if (googleApiClient == null) {
            C1283.m16854("LoginBaseFragment", "GPS client is null, unable to try to save credentials");
            return;
        }
        if (this.f10583) {
            C1283.m16854("LoginBaseFragment", "Trying to save credentials to GPS");
            C1363Ci.m4426(SignInLogging.CredentialService.GooglePlayService);
            this.f10583 = false;
            String obj = this.f10578.getText().toString();
            String obj2 = this.f10592.getText().toString();
            if (C1349Bv.m4113(obj) || C1349Bv.m4113(obj2)) {
                C1283.m16865("LoginBaseFragment", "Credential is empty, do not save it.");
                m11210((com.google.android.gms.common.api.Status) null);
                return;
            }
            Auth.CredentialsApi.save(googleApiClient, new Credential.Builder(obj).setPassword(obj2).build()).setResultCallback(new ResultCallback<com.google.android.gms.common.api.Status>() { // from class: o.to.4
                /* renamed from: ॱ  reason: contains not printable characters */
                public void onResult(com.google.android.gms.common.api.Status status) {
                    if (C1317As.m3750(C2185to.this.m14534())) {
                        C1283.m16850("LoginBaseFragment", "Auth.CredentialsApi.save onResult ActivityFinishedOrDestroyed");
                    } else if (status.isSuccess()) {
                        C1283.m16854("LoginBaseFragment", "SAVE: OK");
                        C2185to.this.m14534().showDebugToast("Credential Saved");
                        C1363Ci.m4429(SignInLogging.CredentialService.GooglePlayService, IClientLogging.CompletionReason.success, null);
                        if (C2185to.this.f10615 != null) {
                            C2185to.this.f10615.mo11246();
                        }
                    } else {
                        C2185to.this.m11210(status);
                    }
                }
            });
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11209(Bundle bundle) {
        String string = bundle.getString(SignupConstants.Field.EMAIL);
        String string2 = bundle.getString(SignupConstants.Field.PASSWORD);
        if (C1349Bv.m4107(string)) {
            C1283.m16865("LoginBaseFragment", "We received credential");
            this.f10578.setText(string);
            if (C1349Bv.m4107(string2)) {
                this.f10592.setText(string2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11210(com.google.android.gms.common.api.Status status) {
        boolean z = true;
        if (m14534() == null) {
            C1283.m16850("LoginBaseFragment", "NetflixActivity is null -  skipping startResolutionForResult");
        } else if (status == null || !status.hasResolution()) {
            C1283.m16850("LoginBaseFragment", "Google Play Services: STATUS: FAIL");
            m14534().showDebugToast("Google Play Services: Could Not Resolve Error");
            C1363Ci.m4429(SignInLogging.CredentialService.GooglePlayService, IClientLogging.CompletionReason.failed, C1363Ci.m4430(status));
        } else {
            C1283.m16854("LoginBaseFragment", "Google Play Services: STATUS: RESOLVING");
            try {
                status.startResolutionForResult(m14534(), 1);
                z = false;
            } catch (IntentSender.SendIntentException e) {
                C1283.m16847("LoginBaseFragment", "Google Play Services: STATUS: Failed to send resolution.", e);
                C1363Ci.m4429(SignInLogging.CredentialService.GooglePlayService, IClientLogging.CompletionReason.failed, C1363Ci.m4430(status));
            }
        }
        if (z && this.f10615 != null) {
            this.f10615.mo11246();
        }
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10615 = null;
        if (this.f10582 != null) {
            this.f10582.disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f10582 = null;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public synchronized void onConnected(Bundle bundle) {
        C1283.m16854("LoginBaseFragment", "onConnected");
        m11203(this.f10582);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        C1283.m16851("LoginBaseFragment", "onConnectionSuspended: %d", Integer.valueOf(i));
        if (this.f10582 != null) {
            this.f10582.reconnect();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.to$If */
    public class If extends oP {
        public If() {
            super("LoginBaseFragment");
        }

        @Override // o.oP, o.oU
        public void onLogoutComplete(Status status) {
            C2059ph r1;
            super.onLogoutComplete(status);
            if (status.mo298() && (r1 = C2185to.this.m14536()) != null) {
                r1.m9772(C2185to.this.f10578.getText().toString(), C2185to.this.f10592.getText().toString(), C2185to.this.f10579);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f10581 = true;
        C1283.m16854("LoginBaseFragment", "Login is paused" + this.f10581);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f10581 = false;
    }
}
