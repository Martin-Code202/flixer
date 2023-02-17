package o;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipConfiguration;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.ViewUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* access modifiers changed from: package-private */
/* renamed from: o.Ak  reason: case insensitive filesystem */
public class C1309Ak {

    /* renamed from: ʼ  reason: contains not printable characters */
    private CompositeDisposable f4444 = new CompositeDisposable();

    /* renamed from: ʽ  reason: contains not printable characters */
    private View f4445;

    /* renamed from: ˊ  reason: contains not printable characters */
    private View f4446;

    /* renamed from: ˋ  reason: contains not printable characters */
    private ActivityC1313Ao f4447;

    /* renamed from: ˎ  reason: contains not printable characters */
    private View f4448;

    /* renamed from: ˏ  reason: contains not printable characters */
    private View f4449;

    /* renamed from: ॱ  reason: contains not printable characters */
    private View f4450;

    C1309Ak(ActivityC1313Ao ao) {
        this.f4447 = ao;
        this.f4449 = ao.findViewById(R.id.customerSupportDialFab);
        this.f4450 = ao.findViewById(R.id.customerSupportChatFab);
        this.f4448 = ao.findViewById(R.id.customerSupportCancelMyAccountLink);
        this.f4446 = ao.findViewById(R.id.customerSupportPasswordLink);
        this.f4445 = ao.findViewById(R.id.customerSupportUpdatePaymentLink);
        this.f4444.add(C0965.m15783(this.f4450).debounce(250, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Object>() { // from class: o.Ak.4
            @Override // io.reactivex.functions.Consumer
            public void accept(Object obj) {
                C1309Ak.this.m3635();
            }
        }));
        if (m3643()) {
            ViewUtils.m3010(this.f4448, ViewUtils.Visibility.GONE);
            ViewUtils.m3010(this.f4446, ViewUtils.Visibility.GONE);
            ViewUtils.m3010(this.f4445, ViewUtils.Visibility.GONE);
        }
        if (m3638()) {
            ViewUtils.m3010(this.f4449, ViewUtils.Visibility.GONE);
        }
        if (!C0652.m14812(this.f4447)) {
            ViewUtils.m3010(this.f4450, ViewUtils.Visibility.GONE);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m3646() {
        this.f4444.dispose();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3645() {
        if (m3638()) {
            ViewUtils.m3010(this.f4449, ViewUtils.Visibility.GONE);
        } else {
            ViewUtils.m3010(this.f4449, ViewUtils.Visibility.VISIBLE);
        }
        if (C0652.m14812(this.f4447)) {
            ViewUtils.m3010(this.f4450, ViewUtils.Visibility.VISIBLE);
        } else {
            ViewUtils.m3010(this.f4450, ViewUtils.Visibility.GONE);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m3643() {
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m3638() {
        if (!C0652.m14811(this.f4447)) {
            return true;
        }
        try {
            if (this.f4447.getServiceManager() == null || this.f4447.getServiceManager().m9827() == null) {
                C1283.m16865("VoipActivity", "Service manager or configuration not found, hide VOIP");
                return true;
            }
            VoipConfiguration r4 = this.f4447.getServiceManager().m9827().mo16527();
            if (r4 == null) {
                C1283.m16854("VoipActivity", "VOIP config does not exist, by default it is enabled");
                return false;
            }
            boolean r5 = ConnectivityUtils.m2955(this.f4447);
            if (ConnectivityUtils.m2952(this.f4447)) {
                return !r4.isEnableVoipOverData();
            }
            if (r5) {
                C1283.m16854("VoipActivity", "On WiFi, VOIP call is enabled " + r4.isEnableVoipOverWiFi());
                return !r4.isEnableVoipOverWiFi();
            }
            C1283.m16865("VoipActivity", "Not on data or WiFi? We most likely do not have network Hide by default");
            return true;
        } catch (Throwable th) {
            C1283.m16850("VoipActivity", "Something is very wrong, go with default .");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m3647(View view) {
        if (view == null) {
            C1283.m16850("VoipActivity", "launchBrowser:: null view? This should never happen!");
            return true;
        }
        switch (view.getId()) {
            case R.id.customerSupportCancelMyAccountLink /* 2131427608 */:
                m3637(this.f4447.getString(R.string.url_cs_cancel_my_account_link));
                return true;
            case R.id.customerSupportChatFab /* 2131427609 */:
            case R.id.customerSupportDialerButtonsContainer /* 2131427611 */:
            case R.id.customerSupportDialerHeader /* 2131427612 */:
            case R.id.customerSupportDialerHeaderCallStatus1 /* 2131427613 */:
            case R.id.customerSupportDialerHeaderCallStatus2 /* 2131427614 */:
            case R.id.customerSupportDialerHeaderDialPadContainer /* 2131427615 */:
            case R.id.customerSupportDialerHeaderDialPadIcon /* 2131427616 */:
            case R.id.customerSupportDialerHeaderDialPadLabel /* 2131427617 */:
            case R.id.customerSupportDialerHeaderDuration /* 2131427618 */:
            case R.id.customerSupportDialerHeaderMicContainer /* 2131427619 */:
            case R.id.customerSupportDialerHeaderMicIcon /* 2131427620 */:
            case R.id.customerSupportDialerHeaderMicLabel /* 2131427621 */:
            case R.id.customerSupportDialerHeaderSpeakerContainer /* 2131427622 */:
            case R.id.customerSupportDialerHeaderSpeakerIcon /* 2131427623 */:
            case R.id.customerSupportDialerHeaderSpeakerLabel /* 2131427624 */:
            case R.id.customerSupportDialpadStatus /* 2131427625 */:
            case R.id.customerSupportHeader /* 2131427627 */:
            case R.id.customerSupportLinks /* 2131427629 */:
            case R.id.customerSupportTextHelpCenterContainer /* 2131427631 */:
            case R.id.customerSupportTextHelpCenterDesc /* 2131427632 */:
            case R.id.customerSupportTextHelpCenterTitle /* 2131427633 */:
            case R.id.customerSupportTitle /* 2131427634 */:
            default:
                return false;
            case R.id.customerSupportDialFab /* 2131427610 */:
                this.f4447.m3731();
                return true;
            case R.id.customerSupportFixConnectionLink /* 2131427626 */:
                StringBuilder sb = new StringBuilder(this.f4447.getString(R.string.url_cs_fix_connection_link_base));
                sb.append(Locale.getDefault() != null ? Locale.getDefault().getLanguage() : "en");
                sb.append(this.f4447.getString(R.string.url_cs_fix_connection_link_path));
                m3639(sb.toString());
                return true;
            case R.id.customerSupportHelpCenterLink /* 2131427628 */:
                m3639(this.f4447.getString(R.string.url_cs_help_center_link));
                return true;
            case R.id.customerSupportPasswordLink /* 2131427630 */:
                m3637(this.f4447.getString(R.string.url_cs_password_link));
                return true;
            case R.id.customerSupportTitleRequestLink /* 2131427635 */:
                m3639(this.f4447.getString(R.string.url_cs_title_request));
                return true;
            case R.id.customerSupportUpAction /* 2131427636 */:
                C1283.m16854("VoipActivity", "Perform up action");
                this.f4447.performUpAction();
                return true;
            case R.id.customerSupportUpdatePaymentLink /* 2131427637 */:
                m3637(this.f4447.getString(R.string.url_cs_update_payment_link));
                return true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼ  reason: contains not printable characters */
    private void m3635() {
        StringBuilder sb = new StringBuilder(this.f4447.getString(R.string.url_cs_mobile_chat_base));
        if (this.f4447 != null) {
            sb.append(Locale.getDefault() != null ? Locale.getDefault().getLanguage() : "en");
            sb.append(this.f4447.getString(R.string.url_cs_mobile_chat_path));
            sb.append(BG.m3860("origin", "android_app", "?"));
            if (this.f4447.getServiceManager() != null) {
                if (this.f4447.getServiceManager().m9825() != null) {
                    String r4 = this.f4447.getServiceManager().m9825().mo1519();
                    if (C1349Bv.m4107(r4)) {
                        sb.append(BG.m3860("clSessionId", r4, "&"));
                    }
                }
                if (this.f4447.getServiceManager().m9826() != null) {
                    sb.append(BG.m3860("country", this.f4447.getServiceManager().m9826().getGeoCountry(), "&"));
                }
            }
            m3641(sb.toString(), "&", CustomerServiceLogging.Action.chat);
            return;
        }
        m3641(sb.toString(), "?", CustomerServiceLogging.Action.chat);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m3637(String str) {
        m3641(str, "?", CustomerServiceLogging.Action.url);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3641(final String str, final String str2, final CustomerServiceLogging.Action action) {
        if (this.f4447.getServiceManager() == null || !this.f4447.getServiceManager().m9789()) {
            m3640(str, action);
        } else {
            this.f4447.getServiceManager().m9784(3600000, new AbstractC2061pj() { // from class: o.Ak.1
                @Override // o.AbstractC2061pj, o.oU
                public void onAutoLoginTokenCreated(String str3, Status status) {
                    if (!status.mo298() || C1349Bv.m4113(str3)) {
                        C1283.m16854("VoipActivity", "Couldn't fetch token, opening url without auto login");
                        C1309Ak.this.m3640(str, action);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str).append(str2 + "nftoken=").append(str3);
                    C1309Ak.this.m3640(sb.toString(), action);
                }
            });
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m3639(String str) {
        m3640(str, CustomerServiceLogging.Action.url);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3640(String str, CustomerServiceLogging.Action action) {
        Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse(str));
        data.addFlags(268435456);
        if (data.resolveActivity(this.f4447.getPackageManager()) != null) {
            this.f4447.startActivity(data);
            C1356Cb.m4338(this.f4447, action, str, IClientLogging.CompletionReason.success, null);
            return;
        }
        C1283.m16850("VoipActivity", "Unable to launchHelp");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public View m3644() {
        return this.f4449;
    }
}
