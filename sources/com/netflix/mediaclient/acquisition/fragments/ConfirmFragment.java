package com.netflix.mediaclient.acquisition.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.BillingManager;
import com.netflix.mediaclient.acquisition.BillingManagerInterface;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.kotlinx.ContextKt;
import com.netflix.mediaclient.acquisition.kotlinx.TextViewKt;
import com.netflix.mediaclient.acquisition.util.AUITermsOfUseUtilities;
import com.netflix.mediaclient.acquisition.view.NetflixSignupButton;
import com.netflix.mediaclient.acquisition.view.TermsOfUseView;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.ConfirmViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.HashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1433Et;
import o.C0403;
import o.C0475;
import o.C0716;
import o.C0940;
import o.C1224;
import o.C1435Ev;
import o.C1457Fr;
import o.C1461Fv;
import o.EI;
import o.FQ;
public final class ConfirmFragment extends AbstractSignupFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(ConfirmFragment.class), "confirmViewModel", "getConfirmViewModel()Lcom/netflix/mediaclient/acquisition/viewmodels/ConfirmViewModel;"))};
    private HashMap _$_findViewCache;
    private final AbstractC1433Et confirmViewModel$delegate = C1435Ev.m4972(new ConfirmFragment$confirmViewModel$2(this));

    /* access modifiers changed from: private */
    public final ConfirmViewModel getConfirmViewModel() {
        AbstractC1433Et et = this.confirmViewModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (ConfirmViewModel) et.mo3220();
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

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AppView getAppView() {
        return AppView.orderConfirm;
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getConfirmViewModel();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.confirm_fragment_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initViews();
        initClickListeners();
        fetchPricing();
        initAccountInformationView();
        initLogging();
        initAdvertisingLogging();
    }

    private final void initAccountInformationView() {
        C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.emailValue);
        C1457Fr.m5016((Object) r0, "emailValue");
        ViewTreeObserver viewTreeObserver = r0.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ConfirmFragment$initAccountInformationView$1(this));
        }
    }

    private final void initLogging() {
        Logger.INSTANCE.m140(Logger.INSTANCE.m142(new C1224(null, AppView.orderConfirm)));
    }

    private final void initAdvertisingLogging() {
        if (getConfirmViewModel().getRecognizedFormerMember()) {
            logAdvertisingId(getServiceManager(), "orderConfirm_rejoin");
        } else {
            logAdvertisingId(getServiceManager(), SignupConstants.LoggingEvent.ORDER_CONFIRM);
        }
    }

    private final void initViews() {
        String str;
        C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.firstName);
        C1457Fr.m5016((Object) r0, SignupConstants.Field.FIRST_NAME);
        TextViewKt.setTextOrGone(r0, getConfirmViewModel().getFirstName());
        C0716 r02 = (C0716) _$_findCachedViewById(R.Cif.lastName);
        C1457Fr.m5016((Object) r02, SignupConstants.Field.LAST_NAME);
        TextViewKt.setTextOrGone(r02, getConfirmViewModel().getLastName());
        C0716 r03 = (C0716) _$_findCachedViewById(R.Cif.emailValue);
        C1457Fr.m5016((Object) r03, "emailValue");
        TextViewKt.setTextOrGone(r03, getConfirmViewModel().getEmail());
        C0716 r04 = (C0716) _$_findCachedViewById(R.Cif.freeTrialDate);
        C1457Fr.m5016((Object) r04, "freeTrialDate");
        TextViewKt.setTextOrGone(r04, getConfirmViewModel().getFreeTrialEndDate());
        Double planMaxScreen = getConfirmViewModel().getPlanMaxScreen();
        if (planMaxScreen != null) {
            double doubleValue = planMaxScreen.doubleValue();
            C0716 r05 = (C0716) _$_findCachedViewById(R.Cif.planNameText);
            C1457Fr.m5016((Object) r05, "planNameText");
            C0403 r06 = C0403.m14185(r05.getContext(), R.string.plan_title);
            C0716 r2 = (C0716) _$_findCachedViewById(R.Cif.planNameText);
            C1457Fr.m5016((Object) r2, "planNameText");
            Context context = r2.getContext();
            C1457Fr.m5016((Object) context, "planNameText.context");
            String r8 = r06.m14186("planType", ContextKt.getStringResource(context, "text_" + ((int) doubleValue) + "_stream_name")).m14188();
            C0716 r07 = (C0716) _$_findCachedViewById(R.Cif.planNameText);
            C1457Fr.m5016((Object) r07, "planNameText");
            r07.setText(r8);
        }
        if (getConfirmViewModel().getRecognizedFormerMember()) {
            String firstName = getConfirmViewModel().getFirstName();
            if (firstName == null || firstName.length() == 0) {
                str = getString(R.string.welcome_back);
            } else {
                C0716 r08 = (C0716) _$_findCachedViewById(R.Cif.confirmPreHeader);
                C1457Fr.m5016((Object) r08, "confirmPreHeader");
                str = C0403.m14185(r08.getContext(), R.string.welcome_back_name).m14186("name", getConfirmViewModel().getFirstName()).m14188();
            }
            C0716 r09 = (C0716) _$_findCachedViewById(R.Cif.confirmPreHeader);
            C1457Fr.m5016((Object) r09, "confirmPreHeader");
            r09.setText(str);
        } else {
            C0716 r010 = (C0716) _$_findCachedViewById(R.Cif.confirmPreHeader);
            C1457Fr.m5016((Object) r010, "confirmPreHeader");
            r010.setVisibility(8);
        }
        if (getConfirmViewModel().getHasFreeTrial()) {
            C0716 r011 = (C0716) _$_findCachedViewById(R.Cif.confirmHeader);
            C1457Fr.m5016((Object) r011, "confirmHeader");
            r011.setText(getString(R.string.first_month_free));
            C0716 r012 = (C0716) _$_findCachedViewById(R.Cif.confirmDetails);
            C1457Fr.m5016((Object) r012, "confirmDetails");
            r012.setText(getString(R.string.confirm_trial_reminder));
        } else {
            C0716 r013 = (C0716) _$_findCachedViewById(R.Cif.confirmHeader);
            C1457Fr.m5016((Object) r013, "confirmHeader");
            r013.setText(getString(R.string.confirm_details));
            C0716 r014 = (C0716) _$_findCachedViewById(R.Cif.confirmDetails);
            C1457Fr.m5016((Object) r014, "confirmDetails");
            r014.setVisibility(8);
            C0716 r015 = (C0716) _$_findCachedViewById(R.Cif.freeUntil);
            C1457Fr.m5016((Object) r015, "freeUntil");
            r015.setVisibility(8);
        }
        String userMessage = getConfirmViewModel().getUserMessage();
        if (userMessage != null) {
            C0716 r016 = (C0716) _$_findCachedViewById(R.Cif.userMessageText);
            C1457Fr.m5016((Object) r016, "userMessageText");
            Context context2 = r016.getContext();
            C1457Fr.m5016((Object) context2, "userMessageText.context");
            String stringResource = ContextKt.getStringResource(context2, userMessage);
            if (!TextUtils.isEmpty(stringResource)) {
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.Cif.userMessage);
                C1457Fr.m5016((Object) linearLayout, SignupConstants.Field.USER_MESSAGE);
                linearLayout.setVisibility(0);
                C0716 r017 = (C0716) _$_findCachedViewById(R.Cif.userMessageText);
                C1457Fr.m5016((Object) r017, "userMessageText");
                r017.setText(stringResource);
            } else {
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.Cif.userMessage);
                C1457Fr.m5016((Object) linearLayout2, SignupConstants.Field.USER_MESSAGE);
                linearLayout2.setVisibility(8);
            }
        }
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.confirmButton)).setLoadingData(getConfirmViewModel().isLoading());
        NetflixSignupButton netflixSignupButton = (NetflixSignupButton) _$_findCachedViewById(R.Cif.confirmButton);
        C1457Fr.m5016((Object) netflixSignupButton, "confirmButton");
        String string = netflixSignupButton.getContext().getString(R.string.button_appstore_android);
        C1457Fr.m5016((Object) string, "confirmButton.context.ge….button_appstore_android)");
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.confirmButton)).setText(string);
        initCheckboxes();
    }

    private final void initClickListeners() {
        ((TermsOfUseView) _$_findCachedViewById(R.Cif.touView)).checkedChanges().subscribe(new ConfirmFragment$initClickListeners$1(this));
        ((C0716) _$_findCachedViewById(R.Cif.logoutButton)).setOnClickListener(new ConfirmFragment$initClickListeners$2(this));
        ((C0716) _$_findCachedViewById(R.Cif.changePlanButton)).setOnClickListener(new ConfirmFragment$initClickListeners$3(this));
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.confirmButton)).setOnClickListener(new ConfirmFragment$initClickListeners$4(this));
    }

    /* access modifiers changed from: private */
    public final void handleSubmitForm() {
        if (((TermsOfUseView) _$_findCachedViewById(R.Cif.touView)).hasAcceptedTermsOfUse()) {
            Logger.INSTANCE.m140(Logger.INSTANCE.m142(new C0940()));
            Logger.INSTANCE.m140(Logger.INSTANCE.m142(new C0475()));
            getConfirmViewModel().isLoading().setValue(true);
            ActionField nextAction = getConfirmViewModel().getNextAction();
            if (nextAction != null) {
                ConfirmViewModel confirmViewModel = getConfirmViewModel();
                SignupNativeActivity signupActivity = getSignupActivity();
                confirmViewModel.next(nextAction, signupActivity != null ? signupActivity.getServiceManager() : null, new ConfirmFragment$handleSubmitForm$1$1(this));
                return;
            }
            return;
        }
        ((TermsOfUseView) _$_findCachedViewById(R.Cif.touView)).setErrorVisible(true);
    }

    public final void initCheckboxes() {
        if (getConfirmViewModel().getHasAcceptedTermsOfUse() != null) {
            StringField termsOfUseRegion = getConfirmViewModel().getTermsOfUseRegion();
            Object value = termsOfUseRegion != null ? termsOfUseRegion.getValue() : null;
            if (!(value instanceof String)) {
                value = null;
            }
            String str = (String) value;
            ((TermsOfUseView) _$_findCachedViewById(R.Cif.touView)).setText(AUITermsOfUseUtilities.INSTANCE.getTouMessage(getContext(), str));
            ((TermsOfUseView) _$_findCachedViewById(R.Cif.touView)).setCheckboxVisible(AUITermsOfUseUtilities.INSTANCE.isTouCheckboxVisible(str));
            BooleanField hasAcceptedTermsOfUse = getConfirmViewModel().getHasAcceptedTermsOfUse();
            if (hasAcceptedTermsOfUse != null) {
                hasAcceptedTermsOfUse.setValue(Boolean.valueOf(((TermsOfUseView) _$_findCachedViewById(R.Cif.touView)).hasAcceptedTermsOfUse()));
            }
        }
    }

    private final void fetchPricing() {
        BillingManagerInterface billingManager = BillingManager.Companion.getBillingManager(getSignupActivity());
        String offerId = getConfirmViewModel().getOfferId();
        if (offerId != null && billingManager != null) {
            billingManager.fetchPrices(EI.m4806(offerId), true, 1, new ConfirmFragment$fetchPricing$$inlined$let$lambda$1(this, billingManager));
        }
    }

    public final void updatePriceStrings(String str) {
        C1457Fr.m5025(str, "priceString");
        C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.price);
        C1457Fr.m5016((Object) r0, "price");
        C0716 r1 = (C0716) _$_findCachedViewById(R.Cif.price);
        C1457Fr.m5016((Object) r1, "price");
        r0.setText(C0403.m14185(r1.getContext(), R.string.price_per_mo).m14186("price", str).m14188());
    }
}
