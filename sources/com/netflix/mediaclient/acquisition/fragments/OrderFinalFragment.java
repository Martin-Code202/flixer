package com.netflix.mediaclient.acquisition.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.BillingManager;
import com.netflix.mediaclient.acquisition.BillingManagerInterface;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.kotlinx.TextViewKt;
import com.netflix.mediaclient.acquisition.util.AUIMoneyballUtilities;
import com.netflix.mediaclient.acquisition.view.PhoneNumberCountryInput;
import com.netflix.mediaclient.acquisition.view.SignupInlineWarningView;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.OrderFinalViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.service.webclient.model.leafs.PhoneCode;
import com.netflix.mediaclient.service.webclient.model.leafs.PhoneCodesData;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1433Et;
import o.C0403;
import o.C0716;
import o.C0754;
import o.C0965;
import o.C1435Ev;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.DialogFragmentC0492;
import o.EI;
import o.FQ;
public final class OrderFinalFragment extends AbstractSignupFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(OrderFinalFragment.class), "orderFinalViewModel", "getOrderFinalViewModel()Lcom/netflix/mediaclient/acquisition/viewmodels/OrderFinalViewModel;"))};
    public static final Companion Companion = new Companion(null);
    public static final String TAG_COUNTRY_SELECTION_DIALOG = "countrySelector";
    private HashMap _$_findViewCache;
    private final AbstractC1433Et orderFinalViewModel$delegate = C1435Ev.m4972(new OrderFinalFragment$orderFinalViewModel$2(this));
    private Long phoneInputFocusSessionId;

    /* access modifiers changed from: private */
    public final OrderFinalViewModel getOrderFinalViewModel() {
        AbstractC1433Et et = this.orderFinalViewModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (OrderFinalViewModel) et.mo3220();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
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

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AppView getAppView() {
        return AppView.orderFinal;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.order_final_fragment_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initViews();
        initClickListeners();
        fetchPricing();
        fetchCountryData();
        initAdvertisingLogging();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getOrderFinalViewModel();
    }

    private final void initAdvertisingLogging() {
        logAdvertisingId(getServiceManager(), SignupConstants.LoggingEvent.ORDER_FINAL);
    }

    private final void initViews() {
        Object value;
        BooleanField hasFreeTrial = getOrderFinalViewModel().getHasFreeTrial();
        if (!C1457Fr.m5018(hasFreeTrial != null ? hasFreeTrial.getValue() : null, (Object) true) || getOrderFinalViewModel().getFreeTrialEndDate() == null) {
            C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.cancelText);
            C1457Fr.m5016((Object) r0, "cancelText");
            C0716 r1 = (C0716) _$_findCachedViewById(R.Cif.cancelText);
            C1457Fr.m5016((Object) r1, "cancelText");
            r0.setText(C0403.m14185(r1.getContext(), R.string.orderfinal_cancel_no_free_trial_playStore).m14186("storeName", getString(R.string.orderfinal_label_payment_playStore)).m14188());
        } else {
            C0716 r02 = (C0716) _$_findCachedViewById(R.Cif.freeTrialText);
            C1457Fr.m5016((Object) r02, "freeTrialText");
            r02.setText(getString(R.string.orderfinal_free_trial));
            C0716 r03 = (C0716) _$_findCachedViewById(R.Cif.cancelText);
            C1457Fr.m5016((Object) r03, "cancelText");
            C0716 r12 = (C0716) _$_findCachedViewById(R.Cif.cancelText);
            C1457Fr.m5016((Object) r12, "cancelText");
            C0403 r13 = C0403.m14185(r12.getContext(), R.string.orderfinal_cancel_free_trial_playStore);
            StringField freeTrialEndDate = getOrderFinalViewModel().getFreeTrialEndDate();
            r03.setText(r13.m14186("date", freeTrialEndDate != null ? freeTrialEndDate.getValue() : null).m14186("storeName", getString(R.string.orderfinal_label_payment_playStore)).m14188());
        }
        C0716 r04 = (C0716) _$_findCachedViewById(R.Cif.emailValue);
        C1457Fr.m5016((Object) r04, "emailValue");
        StringField email = getOrderFinalViewModel().getEmail();
        r04.setText(String.valueOf(email != null ? email.getValue() : null));
        C0716 r05 = (C0716) _$_findCachedViewById(R.Cif.paymentValue);
        C1457Fr.m5016((Object) r05, "paymentValue");
        r05.setText(getString(R.string.orderfinal_label_payment_playStore));
        String fullName = getOrderFinalViewModel().getFullName();
        if (!TextUtils.isEmpty(fullName)) {
            C0716 r06 = (C0716) _$_findCachedViewById(R.Cif.nameValue);
            C1457Fr.m5016((Object) r06, "nameValue");
            r06.setText(fullName);
        } else {
            C0716 r07 = (C0716) _$_findCachedViewById(R.Cif.nameValue);
            C1457Fr.m5016((Object) r07, "nameValue");
            r07.setVisibility(8);
            C0716 r08 = (C0716) _$_findCachedViewById(R.Cif.nameLabel);
            C1457Fr.m5016((Object) r08, "nameLabel");
            r08.setVisibility(8);
        }
        StringField countryCode = getOrderFinalViewModel().getCountryCode();
        if (!(countryCode == null || (value = countryCode.getValue()) == null)) {
            if (value == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            updateCountryCode((String) value);
        }
        EditText editText = (EditText) _$_findCachedViewById(R.Cif.phoneInputEditText);
        StringField mobilePhone = getOrderFinalViewModel().getMobilePhone();
        editText.setText(String.valueOf(mobilePhone != null ? mobilePhone.getValue() : null));
        ((PhoneNumberCountryInput) _$_findCachedViewById(R.Cif.phoneNumberCountryInput)).setErrorText(R.string.order_final_validation_error_phone);
        OrderFinalViewModel orderFinalViewModel = getOrderFinalViewModel();
        SignupInlineWarningView signupInlineWarningView = (SignupInlineWarningView) _$_findCachedViewById(R.Cif.orderFinalWarningView);
        C1457Fr.m5016((Object) signupInlineWarningView, "orderFinalWarningView");
        Context context = signupInlineWarningView.getContext();
        C1457Fr.m5016((Object) context, "orderFinalWarningView.context");
        ((SignupInlineWarningView) _$_findCachedViewById(R.Cif.orderFinalWarningView)).setWarningText(orderFinalViewModel.localizedErrorString(context));
    }

    private final void initClickListeners() {
        ((LinearLayout) _$_findCachedViewById(R.Cif.countryPicker)).setOnClickListener(new OrderFinalFragment$initClickListeners$1(this));
        EditText editText = (EditText) _$_findCachedViewById(R.Cif.phoneInputEditText);
        C1457Fr.m5016((Object) editText, "phoneInputEditText");
        Observable textChangesSignUpFormValidation$default = TextViewKt.textChangesSignUpFormValidation$default(editText, new OrderFinalFragment$initClickListeners$mobilePhoneValidationObservable$1(this), getEnableDebounceOnTextViews(), null, new OrderFinalFragment$initClickListeners$mobilePhoneValidationObservable$2(this), 4, null);
        ((EditText) _$_findCachedViewById(R.Cif.phoneInputEditText)).setOnFocusChangeListener(new OrderFinalFragment$initClickListeners$2(this));
        textChangesSignUpFormValidation$default.subscribe(new OrderFinalFragment$initClickListeners$3(this));
        textChangesSignUpFormValidation$default.takeUntil(C0965.m15784((C0754) _$_findCachedViewById(R.Cif.orderFinalButton))).distinctUntilChanged().subscribe(new OrderFinalFragment$initClickListeners$4(this));
        ((C0754) _$_findCachedViewById(R.Cif.orderFinalButton)).setOnClickListener(new OrderFinalFragment$initClickListeners$5(this));
    }

    public final void fetchCountryData() {
        OrderFinalViewModel orderFinalViewModel = getOrderFinalViewModel();
        SignupNativeActivity signupActivity = getSignupActivity();
        orderFinalViewModel.fetchPhoneCodes(signupActivity != null ? signupActivity.getServiceManager() : null, new OrderFinalFragment$fetchCountryData$1(this));
    }

    public final void fetchPricing() {
        BillingManagerInterface billingManager = BillingManager.Companion.getBillingManager(getSignupActivity());
        if (getOrderFinalViewModel().getOfferId() != null && billingManager != null) {
            billingManager.fetchPrices(EI.m4806(String.valueOf(getOrderFinalViewModel().getOfferId())), true, 0, new OrderFinalFragment$fetchPricing$$inlined$let$lambda$1(this, billingManager));
        }
    }

    /* access modifiers changed from: private */
    public final void updatePriceStrings(String str) {
        if (str != null) {
            BooleanField hasFreeTrial = getOrderFinalViewModel().getHasFreeTrial();
            if (!C1457Fr.m5018(hasFreeTrial != null ? hasFreeTrial.getValue() : null, (Object) true)) {
                C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.freeTrialText);
                C1457Fr.m5016((Object) r0, "freeTrialText");
                C0716 r1 = (C0716) _$_findCachedViewById(R.Cif.freeTrialText);
                C1457Fr.m5016((Object) r1, "freeTrialText");
                r0.setText(C0403.m14185(r1.getContext(), R.string.orderfinal_no_free_trial).m14186("price", str).m14188());
            }
            Boolean planHasHd = getOrderFinalViewModel().getPlanHasHd();
            boolean booleanValue = planHasHd != null ? planHasHd.booleanValue() : false;
            Boolean planHasUltraHd = getOrderFinalViewModel().getPlanHasUltraHd();
            boolean booleanValue2 = planHasUltraHd != null ? planHasUltraHd.booleanValue() : false;
            Double planMaxScreen = getOrderFinalViewModel().getPlanMaxScreen();
            int doubleValue = planMaxScreen != null ? (int) planMaxScreen.doubleValue() : 0;
            C0716 r02 = (C0716) _$_findCachedViewById(R.Cif.membershipInformation);
            C1457Fr.m5016((Object) r02, "membershipInformation");
            AUIMoneyballUtilities aUIMoneyballUtilities = AUIMoneyballUtilities.INSTANCE;
            C0716 r2 = (C0716) _$_findCachedViewById(R.Cif.membershipInformation);
            C1457Fr.m5016((Object) r2, "membershipInformation");
            Context context = r2.getContext();
            C1457Fr.m5016((Object) context, "membershipInformation.context");
            r02.setText(aUIMoneyballUtilities.getPlanDescription(context, booleanValue, booleanValue2, doubleValue, str));
        }
    }

    /* access modifiers changed from: private */
    public final void openCountrySelectionDialog() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            C1457Fr.m5016((Object) activity, "it");
            FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag(TAG_COUNTRY_SELECTION_DIALOG);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            beginTransaction.addToBackStack(null);
            PhoneCodesData phoneCodesData = getOrderFinalViewModel().getPhoneCodesData();
            List<PhoneCode> phoneCodes = phoneCodesData != null ? phoneCodesData.getPhoneCodes() : null;
            if (phoneCodes != null) {
                if (!phoneCodes.isEmpty()) {
                    DialogFragmentC0492 r8 = DialogFragmentC0492.f13598.m14468(new OrderFinalFragment$openCountrySelectionDialog$1$countrySelectorDialog$1(this));
                    r8.m14463(getOrderFinalViewModel().getPhoneCodesData());
                    r8.show(beginTransaction, TAG_COUNTRY_SELECTION_DIALOG);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateCountryCode(String str) {
        StringField countryCode = getOrderFinalViewModel().getCountryCode();
        if (countryCode != null) {
            countryCode.setValue(str);
        }
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null) {
            signupActivity.runWhenManagerIsReady(new OrderFinalFragment$updateCountryCode$1(this, str));
        }
    }
}
