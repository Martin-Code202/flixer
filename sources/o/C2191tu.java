package o;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.ui.launch.LaunchActivity;
/* renamed from: o.tu  reason: case insensitive filesystem */
public class C2191tu extends AbstractC0496 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private StatusCode f10617;

    /* renamed from: ʼ  reason: contains not printable characters */
    private TextView f10618;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f10619;

    /* renamed from: ˏ  reason: contains not printable characters */
    private TextView f10620;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private TextView f10621;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private TextView f10622;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C2191tu m11255(StatusCode statusCode, String str) {
        C2191tu tuVar = new C2191tu();
        Bundle bundle = new Bundle();
        bundle.putSerializable("errorCode", statusCode);
        bundle.putString(SignupConstants.Field.EMAIL, str);
        tuVar.setArguments(bundle);
        tuVar.setCancelable(false);
        return tuVar;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return layoutInflater.inflate(R.layout.login_error_dialog, viewGroup);
    }

    @Override // o.AbstractC0496, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f10620 = (TextView) view.findViewById(R.id.login_dialog_title);
        this.f10622 = (TextView) view.findViewById(R.id.login_dialog_action);
        this.f10618 = (TextView) view.findViewById(R.id.login_dialog_cancel);
        this.f10621 = (TextView) view.findViewById(R.id.login_dialog_message);
        this.f10617 = (StatusCode) getArguments().getSerializable("errorCode");
        this.f10619 = getArguments().getString(SignupConstants.Field.EMAIL);
        m11253(this.f10617);
        this.f10618.setOnClickListener(new View.OnClickListener() { // from class: o.tu.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                C2191tu.this.dismiss();
            }
        });
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0021: APUT  (r1v29 java.lang.Object[]), (0 ??[int, short, byte, char]), (r2v24 java.lang.String) */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11253(StatusCode statusCode) {
        switch (statusCode) {
            case ERROR_INCORRECT_PASSWORD:
                String string = getString(R.string.label_incorrect_password);
                Object[] objArr = new Object[1];
                objArr[0] = this.f10619 != null ? this.f10619 : "";
                m11251(string, getString(R.string.label_incorrect_password_error, objArr), getString(R.string.label_recover_password));
                this.f10622.setOnClickListener(new View.OnClickListener() { // from class: o.tu.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C2191tu.this.m11256("https://www.netflix.com/LoginHelp");
                    }
                });
                return;
            case ERROR_UNRECOGNIZED_EMAIL:
                if (m11257()) {
                    m11251(getString(R.string.invalid_email), getString(R.string.label_invalid_email_error), getString(R.string.label_create_account));
                    this.f10622.setOnClickListener(new View.OnClickListener() { // from class: o.tu.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            C2191tu.this.dismiss();
                            C2191tu.this.startActivity(zN.f12697.m13517(C2191tu.this.getActivity()));
                        }
                    });
                    return;
                }
                m11251(getString(R.string.invalid_email), getString(R.string.label_invalid_email_error), null);
                return;
            case ERROR_ACCOUNT_PASSWORD_NOT_SET:
                m11251(getString(R.string.label_reset_password), getString(R.string.label_no_password_set_error), getString(R.string.label_reset_password));
                this.f10622.setOnClickListener(new View.OnClickListener() { // from class: o.tu.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C2191tu.this.m11256("https://www.netflix.com/LoginHelp");
                    }
                });
                return;
            case ERROR_UNRECOGNIZED_CONSUMPTION:
                m11252(getString(R.string.invalid_email), R.id.invalid_email, getString(R.string.label_invalid_email_error), R.id.label_invalid_email_error, null, -1);
                return;
            case ERROR_UNRECOGNIZED_REDIRECT:
                m11252(getString(R.string.label_visit_netflix_com), R.id.label_visit_netflix_com, getString(R.string.label_unaccepted_signups_redirect_error), R.id.label_unaccepted_signups_redirect_error, getString(R.string.label_get_started_netflix_com), R.id.label_get_started_netflix_com);
                this.f10622.setOnClickListener(new View.OnClickListener() { // from class: o.tu.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C2191tu.this.m11256("https://www.netflix.com");
                    }
                });
                return;
            case ERROR_FORMER_MEMBER_CONSUMPTION:
                m11252(getString(R.string.label_inactive_account), R.id.label_inactive_account, getString(R.string.label_restart_membership_consumption_error), R.id.label_restart_membership_consumption_error, null, -1);
                return;
            case ERROR_FORMER_MEMBER_REDIRECT:
                m11252(getString(R.string.label_inactive_account), R.id.label_inactive_account, getString(R.string.label_restart_membership_redirect_error), R.id.label_restart_membership_redirect_error, getString(R.string.label_get_started_netflix_com), R.id.label_get_started_netflix_com);
                this.f10622.setOnClickListener(new View.OnClickListener() { // from class: o.tu.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C2191tu.this.m11256("https://www.netflix.com");
                    }
                });
                return;
            case ERROR_NEVER_MEMBER_CONSUMPTION:
                m11252(getString(R.string.label_pick_up_left_off), R.id.label_pick_up_left_off, getString(R.string.label_finish_setup_consumption_error), R.id.label_finish_setup_consumption_error, null, -1);
                return;
            case ERROR_NEVER_MEMBER_REDIRECT:
                m11252(getString(R.string.label_pick_up_left_off), R.id.label_pick_up_left_off, getString(R.string.label_finish_setup_redirect_error), R.id.label_finish_setup_redirect_error, getString(R.string.label_get_started_netflix_com), R.id.label_get_started_netflix_com);
                this.f10622.setOnClickListener(new View.OnClickListener() { // from class: o.tu.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C2191tu.this.m11256("https://www.netflix.com");
                    }
                });
                return;
            case ERROR_DVD_MEMBER_REDIRECT:
                m11252(getString(R.string.label_visit_netflix_com), R.id.label_visit_netflix_com, getString(R.string.label_dvd_upgrade_account_error), R.id.label_dvd_upgrade_account_error, null, -1);
                return;
            case USER_SIGNIN_RETRY:
                m11251(getString(R.string.label_incorrect_password_or_email_address), getString(R.string.login_actionid_2), null);
                return;
            default:
                return;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11251(String str, String str2, String str3) {
        m11252(str, -1, str2, -1, str3, -1);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11252(String str, int i, String str2, int i2, String str3, int i3) {
        this.f10620.setText(str);
        if (-1 != i) {
            this.f10620.setId(i);
        }
        this.f10621.setText(str2);
        if (-1 != i2) {
            this.f10621.setId(i2);
        }
        if (str3 != null) {
            this.f10622.setText(str3);
            if (-1 != i3) {
                this.f10622.setId(i3);
                return;
            }
            return;
        }
        this.f10622.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11256(String str) {
        dismiss();
        Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse(str));
        if (data.resolveActivity(m14476().getPackageManager()) != null) {
            startActivityForResult(data, 0);
        } else {
            m14476().displayServiceAgentDialog(getString(R.string.label_visit_url, str), null, false);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean m11257() {
        return !AD.m3287() && LaunchActivity.m1998(m14474());
    }

    @Override // o.AbstractC0496, o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }
}
