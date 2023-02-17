package com.netflix.mediaclient.acquisition.fragments;

import android.app.AlertDialog;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.TypedValue;
import android.view.View;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.BillingManager;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.util.AUILoggingUtilities;
import com.netflix.mediaclient.acquisition.util.DebugBillingManager;
import com.netflix.mediaclient.acquisition.view.NetflixSignupButton;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.GooglePlayConstants;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.acquisition.viewmodels.StartMembershipViewModel;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC0367;
import o.AbstractC1433Et;
import o.AbstractC1451Fl;
import o.C0403;
import o.C0716;
import o.C0738;
import o.C1435Ev;
import o.C1438Ey;
import o.C1457Fr;
import o.C1461Fv;
import o.EA;
import o.ES;
import o.FQ;
import o.Ge;
import org.json.JSONObject;
public final class StartMembershipOnContextFragment extends AbstractContextFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(StartMembershipOnContextFragment.class), "startMembershipModel", "getStartMembershipModel()Lcom/netflix/mediaclient/acquisition/viewmodels/StartMembershipViewModel;"))};
    private HashMap _$_findViewCache;
    private final AbstractC1451Fl<Integer, List<? extends C0738>, EA> purchaseResponseHandler = new StartMembershipOnContextFragment$purchaseResponseHandler$1(this);
    private boolean purchaseUsedDebugBillingManager;
    private final AbstractC1433Et startMembershipModel$delegate = C1435Ev.m4972(new StartMembershipOnContextFragment$startMembershipModel$2(this));

    /* access modifiers changed from: private */
    public final StartMembershipViewModel getStartMembershipModel() {
        AbstractC1433Et et = this.startMembershipModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (StartMembershipViewModel) et.mo3220();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractContextFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractContextFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractContextFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AppView getAppView() {
        return AppView.paymentAppStore;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.payment_lock);
        if (drawable != null) {
            C1457Fr.m5016((Object) drawable, "it");
            initContextIcon(drawable);
        }
        initSignupHeading(getString(R.string.title_appstore_payment_android));
        initSubHeading(buildSubHeadings());
        String string = getString(R.string.button_appstore_android);
        C1457Fr.m5016((Object) string, "getString(R.string.button_appstore_android)");
        initContextButton(string);
        C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.subheaderTitle);
        C1457Fr.m5016((Object) r0, "subheaderTitle");
        Resources resources = getResources();
        C1457Fr.m5016((Object) resources, "resources");
        r0.setMaxWidth((int) TypedValue.applyDimension(1, 250.0f, resources.getDisplayMetrics()));
        initClickListeners();
        initAdvertisingLogging();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getStartMembershipModel();
    }

    private final Spanned buildSubHeadings() {
        String str;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        BooleanField hasFreeTrial = getStartMembershipModel().getHasFreeTrial();
        if (hasFreeTrial != null && ((Boolean) hasFreeTrial.getValue()).booleanValue()) {
            SignupNativeActivity signupActivity = getSignupActivity();
            if (signupActivity == null || (str = C0403.m14185(signupActivity, R.string.label_cancel_before).m14186("endDate", getStartMembershipModel().getFreeTrialEndDate()).m14188()) == null) {
                str = "";
            }
            spannableStringBuilder.append((CharSequence) Html.fromHtml(str)).append((CharSequence) "\n\n").append((CharSequence) Html.fromHtml(getString(R.string.label_as_a_reminder))).append((CharSequence) "\n\n");
        } else {
            spannableStringBuilder.append((CharSequence) Html.fromHtml(getString(R.string.label_pay_now_android))).append((CharSequence) "\n\n");
        }
        SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) Html.fromHtml("<b>" + getString(R.string.headline_no_commitments_cancel_anytime_line_break) + "</b>"));
        C1457Fr.m5016((Object) append, "spannedString\n          …ppend(noCommitmentsLabel)");
        return append;
    }

    private final void initClickListeners() {
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.contextButton)).setLoadingData(getStartMembershipModel().isLoading());
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.contextButton)).setOnClickListener(new StartMembershipOnContextFragment$initClickListeners$1(this));
    }

    private final void initLongClickListener() {
    }

    /* access modifiers changed from: private */
    public final void handlePurchase(C0738 r4) {
        StringField receipt = getStartMembershipModel().getReceipt();
        if (receipt != null) {
            String r1 = r4.m15117();
            C1457Fr.m5016((Object) r1, "purchase.purchaseToken");
            receipt.setValue(r1);
        }
        StringField partnerResponse = getStartMembershipModel().getPartnerResponse();
        if (partnerResponse != null) {
            String r12 = r4.m15115();
            C1457Fr.m5016((Object) r12, "purchase.originalJson");
            partnerResponse.setValue(r12);
        }
        StringField partnerResponseSignature = getStartMembershipModel().getPartnerResponseSignature();
        if (partnerResponseSignature != null) {
            String r13 = r4.m15116();
            C1457Fr.m5016((Object) r13, "purchase.signature");
            partnerResponseSignature.setValue(r13);
        }
        StringField devPayload = getStartMembershipModel().getDevPayload();
        if (devPayload != null) {
            String string = new JSONObject(r4.m15115()).getString(WelcomeFragment.KEY_PLAY_BILLING_DEVELOPER_PAYLOAD);
            if (string == null) {
                string = "";
            }
            devPayload.setValue(string);
        }
        sendReceiptToMoneyball();
    }

    /* access modifiers changed from: private */
    public final void handleUserCancel() {
        AUILoggingUtilities.INSTANCE.logDebugEvent(SignupConstants.Events.SIMPLICITY_GOOGLE_PLAY_PURCHASE_END, ES.m4862(C1438Ey.m4973("reason", "cancel"), C1438Ey.m4973("code", String.valueOf(1))));
        ActionField prevAction = getStartMembershipModel().getPrevAction();
        if (prevAction != null) {
            StartMembershipViewModel startMembershipModel = getStartMembershipModel();
            SignupNativeActivity signupActivity = getSignupActivity();
            startMembershipModel.next(prevAction, signupActivity != null ? signupActivity.getServiceManager() : null, new StartMembershipOnContextFragment$handleUserCancel$1$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void handleRestorePurchase() {
        BillingManager billingManager;
        DebugBillingManager debugBillingManager;
        AUILoggingUtilities.INSTANCE.logDebugEvent(SignupConstants.Events.SIMPLICITY_GOOGLE_PLAY_PURCHASE_END, ES.m4862(C1438Ey.m4973("reason", ExceptionClEvent.CATEGORY_VALUE), C1438Ey.m4973("code", String.valueOf(7))));
        if (this.purchaseUsedDebugBillingManager) {
            SignupNativeActivity signupActivity = getSignupActivity();
            if (signupActivity != null && (debugBillingManager = signupActivity.getDebugBillingManager()) != null) {
                debugBillingManager.restoreSubscription(this.purchaseResponseHandler);
                return;
            }
            return;
        }
        SignupNativeActivity signupActivity2 = getSignupActivity();
        if (signupActivity2 != null && (billingManager = signupActivity2.getBillingManager()) != null) {
            billingManager.restoreSubscription(this.purchaseResponseHandler);
        }
    }

    /* access modifiers changed from: private */
    public final void handleGooglePlayError(int i) {
        AUILoggingUtilities.INSTANCE.logDebugEvent(SignupConstants.Events.SIMPLICITY_GOOGLE_PLAY_PURCHASE_END, ES.m4862(C1438Ey.m4973("reason", ExceptionClEvent.CATEGORY_VALUE), C1438Ey.m4973("code", i == 0 ? GooglePlayConstants.ERROR_MISSING_RECEIPT : String.valueOf(i))));
        boolean z = getStartMembershipModel().getSimpleHawkRetryCount() < getStartMembershipModel().getGOOGLE_PLAY_RETRY_SIGNUP_LIMIT();
        getStartMembershipModel().incrementSimpleHawkRetryCount();
        if (z || !getStartMembershipModel().getPlayStoreFallbackEnabled()) {
            showRetryOrContinueDialog(GooglePlayConstants.ERROR_GOOGLE_PLAY_PURCHASE_RETRY_COUNT_EXCEEDED);
        } else {
            showContinueToSimpleDroidDialog();
        }
    }

    private final void showRetryOrContinueDialog(String str) {
        AlertDialog.Builder cancelable = new AlertDialog.Builder(getActivity()).setTitle(R.string.label_error).setMessage(R.string.googleplay_retry_or_web).setNegativeButton(getString(R.string.label_retry), new StartMembershipOnContextFragment$showRetryOrContinueDialog$retryDialog$1(this)).setCancelable(false);
        if (getStartMembershipModel().getPlayStoreFallbackEnabled()) {
            cancelable.setPositiveButton(getString(R.string.label_continue), new StartMembershipOnContextFragment$showRetryOrContinueDialog$1(this, str));
        }
        getStartMembershipModel().isLoading().setValue(true);
        cancelable.show();
    }

    private final void showContinueToSimpleDroidDialog() {
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null) {
            new AlertDialog.Builder(signupActivity).setTitle(R.string.label_error).setMessage(R.string.googleplay_go_to_web).setPositiveButton(getString(R.string.label_continue), new StartMembershipOnContextFragment$showContinueToSimpleDroidDialog$$inlined$let$lambda$1(signupActivity, this)).setCancelable(false).show();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final void showErrorDialog(String str, String str2) {
        String str3;
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null) {
            C0403 r6 = C0403.m14185(signupActivity, R.string.contact_customer_service);
            String csPhoneNumber = getStartMembershipModel().getCsPhoneNumber();
            Spanned fromHtml = Html.fromHtml(r6.m14186("CS_PHONE", csPhoneNumber == null || Ge.m5063(csPhoneNumber) ? StartMembershipOnContextFragmentKt.getNETFLIX_HELP_URL() : getStartMembershipModel().getCsPhoneNumber()).m14188());
            switch (str.hashCode()) {
                case -686919638:
                    if (str.equals(GooglePlayConstants.ERROR_APP_STORE_ACCOUNT_USED)) {
                        str3 = getString(R.string.googleplay_account_already_used);
                        break;
                    }
                    str3 = "" + getString(R.string.problem_connect_googleplay) + "\n\n" + ((Object) fromHtml);
                    break;
                case 14172407:
                    if (str.equals(GooglePlayConstants.ERROR_RETRY_MONEYBALL)) {
                        str3 = getString(R.string.googleplay_moneyball_retry_receipt);
                        break;
                    }
                    str3 = "" + getString(R.string.problem_connect_googleplay) + "\n\n" + ((Object) fromHtml);
                    break;
                default:
                    str3 = "" + getString(R.string.problem_connect_googleplay) + "\n\n" + ((Object) fromHtml);
                    break;
            }
            AlertDialog.Builder cancelable = new AlertDialog.Builder(signupActivity).setTitle(R.string.label_error).setMessage(str3).setCancelable(false);
            if (C1457Fr.m5018((Object) str, (Object) GooglePlayConstants.ERROR_RETRY_MONEYBALL)) {
                cancelable.setNegativeButton(getString(R.string.label_cancel), new StartMembershipOnContextFragment$showErrorDialog$1(this));
                cancelable.setPositiveButton(getString(R.string.label_continue), new StartMembershipOnContextFragment$showErrorDialog$2(this));
            } else {
                cancelable.setPositiveButton(getString(R.string.label_continue), new StartMembershipOnContextFragment$showErrorDialog$3(this));
            }
            cancelable.show();
        }
    }

    /* access modifiers changed from: private */
    public final void sendReceiptToMoneyball() {
        ActionField nextAction = getStartMembershipModel().getNextAction();
        if (nextAction != null) {
            StartMembershipViewModel startMembershipModel = getStartMembershipModel();
            SignupNativeActivity signupActivity = getSignupActivity();
            startMembershipModel.next(nextAction, signupActivity != null ? signupActivity.getServiceManager() : null, new StartMembershipOnContextFragment$sendReceiptToMoneyball$1$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void handleMoneyballStartMembershipResponse(MoneyballData moneyballData, Status status) {
        if ((!C1457Fr.m5018(status, AbstractC0367.f13235)) || moneyballData == null) {
            handlePostReceiptFailure();
        } else {
            handlePostReceiptSuccess(moneyballData);
        }
    }

    private final void handlePostReceiptSuccess(MoneyballData moneyballData) {
        Field field;
        FlowMode flowMode = moneyballData.getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField("errorCode")) == null) ? null : field.getValue();
        if (!(value instanceof String)) {
            value = null;
        }
        String str = (String) value;
        if (str != null) {
            AUILoggingUtilities.INSTANCE.logDebugEvent(SignupConstants.Events.SIMPLICITY_SUBMIT_GOOGLE_PLAY_RECEIPT_END, ES.m4862(C1438Ey.m4973("reason", ExceptionClEvent.CATEGORY_VALUE), C1438Ey.m4973("code", str)));
            handleMoneyballErrorCode(str);
            return;
        }
        AUILoggingUtilities.INSTANCE.logDebugEvent(SignupConstants.Events.SIMPLICITY_SUBMIT_GOOGLE_PLAY_RECEIPT_END, ES.m4862(C1438Ey.m4973("reason", FalkorPathResult.SUCCESS), C1438Ey.m4973("nextMode", moneyballData.getFlowMode().getId())));
        setCurrentMoneyballData(moneyballData);
    }

    private final void handlePostReceiptFailure() {
        AUILoggingUtilities.INSTANCE.logDebugEvent(SignupConstants.Events.SIMPLICITY_SUBMIT_GOOGLE_PLAY_RECEIPT_END, ES.m4864(C1438Ey.m4973("reason", "timeout")));
        showErrorDialog(GooglePlayConstants.ERROR_CALL_CS, GooglePlayConstants.ERROR_API_TIMED_OUT);
    }

    private final void handleMoneyballErrorCode(String str) {
        switch (str.hashCode()) {
            case -1353637471:
                if (str.equals("invalid_appstore_receipt")) {
                    showRetryOrContinueDialog(GooglePlayConstants.ERROR_INVALID_APP_STORE_RECEIPT);
                    return;
                }
                break;
            case -958948861:
                if (str.equals("task_place_order_failed_retryable")) {
                    showErrorDialog(GooglePlayConstants.ERROR_RETRY_MONEYBALL, str);
                    return;
                }
                break;
            case 805473584:
                if (str.equals("receipt_is_used_by_another_current_member")) {
                    showErrorDialog(GooglePlayConstants.ERROR_APP_STORE_ACCOUNT_USED, str);
                    return;
                }
                break;
            case 1192491665:
                if (str.equals("task_place_order_failed_non_retryable")) {
                    showErrorDialog(GooglePlayConstants.ERROR_CALL_CS, str);
                    return;
                }
                break;
        }
        showErrorDialog(GooglePlayConstants.ERROR_CALL_CS, str);
    }

    private final void initAdvertisingLogging() {
        logAdvertisingId(getServiceManager(), SignupConstants.LoggingEvent.START_MEMBERSHIP_ON_CONTEXT);
    }
}
