package com.netflix.mediaclient.acquisition.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.kotlinx.TextViewKt;
import com.netflix.mediaclient.acquisition.util.crypto.NetflixPublicKey;
import com.netflix.mediaclient.acquisition.view.SignupNativeConfig;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.CreditOptionPayViewModel;
import java.util.HashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1433Et;
import o.C0482;
import o.C1435Ev;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.FQ;
public final class CreditPaymentFragment extends AbstractSignupFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(CreditPaymentFragment.class), "payViewModel", "getPayViewModel()Lcom/netflix/mediaclient/acquisition/viewmodels/CreditOptionPayViewModel;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(CreditPaymentFragment.class), "requestQueue", "getRequestQueue()Lcom/android/volley/RequestQueue;"))};
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "CreditPaymentFragment";
    private HashMap _$_findViewCache;
    private final AbstractC1433Et payViewModel$delegate = C1435Ev.m4972(new CreditPaymentFragment$payViewModel$2(this));
    private NetflixPublicKey publicKey;
    private final AbstractC1433Et requestQueue$delegate = C1435Ev.m4972(CreditPaymentFragment$requestQueue$2.INSTANCE);

    /* access modifiers changed from: private */
    public final CreditOptionPayViewModel getPayViewModel() {
        AbstractC1433Et et = this.payViewModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (CreditOptionPayViewModel) et.mo3220();
    }

    private final C0482 getRequestQueue() {
        AbstractC1433Et et = this.requestQueue$delegate;
        FQ fq = $$delegatedProperties[1];
        return (C0482) et.mo3220();
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

    public static final /* synthetic */ NetflixPublicKey access$getPublicKey$p(CreditPaymentFragment creditPaymentFragment) {
        NetflixPublicKey netflixPublicKey = creditPaymentFragment.publicKey;
        if (netflixPublicKey == null) {
            C1457Fr.m5017("publicKey");
        }
        return netflixPublicKey;
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
        return AppView.paymentCreditCard;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pay_option_credit_fragment_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initRxBindingsAndClickListeners();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        fetchSecureMOPKey();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getPayViewModel();
    }

    private final void fetchSecureMOPKey() {
        getRequestQueue().m14415(new CreditPaymentFragment$fetchSecureMOPKey$secureMOPRequest$1(this, 0, "https://ncds.nflxext.com/v1/2/current", null, new CreditPaymentFragment$fetchSecureMOPKey$secureMOPRequest$2(this), CreditPaymentFragment$fetchSecureMOPKey$secureMOPRequest$3.INSTANCE));
    }

    private final void initRxBindingsAndClickListeners() {
        boolean debounceEnabled = SignupNativeConfig.INSTANCE.getDebounceEnabled();
        EditText editText = (EditText) _$_findCachedViewById(R.Cif.firstNameEditText);
        C1457Fr.m5016((Object) editText, "firstNameEditText");
        TextViewKt.textChangesSignUpFormValidation$default(editText, new CreditPaymentFragment$initRxBindingsAndClickListeners$firstNameValidationObservable$1(this), debounceEnabled, null, new CreditPaymentFragment$initRxBindingsAndClickListeners$firstNameValidationObservable$2(this), 4, null).subscribe(new CreditPaymentFragment$initRxBindingsAndClickListeners$1(this));
        EditText editText2 = (EditText) _$_findCachedViewById(R.Cif.lastNameEditText);
        C1457Fr.m5016((Object) editText2, "lastNameEditText");
        TextViewKt.textChangesSignUpFormValidation$default(editText2, new CreditPaymentFragment$initRxBindingsAndClickListeners$lastNameValidationObservable$1(this), debounceEnabled, null, new CreditPaymentFragment$initRxBindingsAndClickListeners$lastNameValidationObservable$2(this), 4, null).subscribe(new CreditPaymentFragment$initRxBindingsAndClickListeners$2(this));
        EditText editText3 = (EditText) _$_findCachedViewById(R.Cif.creditCardEditText);
        C1457Fr.m5016((Object) editText3, "creditCardEditText");
        TextViewKt.textChangesSignUpFormValidation$default(editText3, new CreditPaymentFragment$initRxBindingsAndClickListeners$creditCardValidationObservable$1(this), debounceEnabled, null, new CreditPaymentFragment$initRxBindingsAndClickListeners$creditCardValidationObservable$2(this), 4, null).subscribe(new CreditPaymentFragment$initRxBindingsAndClickListeners$3(this));
        EditText editText4 = (EditText) _$_findCachedViewById(R.Cif.creditExpiryDateEditText);
        C1457Fr.m5016((Object) editText4, "creditExpiryDateEditText");
        TextViewKt.textChangesSignUpFormValidation$default(editText4, new CreditPaymentFragment$initRxBindingsAndClickListeners$creditExpiryDateValidationObservable$1(this), debounceEnabled, null, new CreditPaymentFragment$initRxBindingsAndClickListeners$creditExpiryDateValidationObservable$2(this), 4, null).subscribe(new CreditPaymentFragment$initRxBindingsAndClickListeners$4(this));
        EditText editText5 = (EditText) _$_findCachedViewById(R.Cif.zipCodeEditText);
        C1457Fr.m5016((Object) editText5, "zipCodeEditText");
        TextViewKt.textChangesSignUpFormValidation$default(editText5, new CreditPaymentFragment$initRxBindingsAndClickListeners$zipCodeValidationObservable$1(this), debounceEnabled, null, new CreditPaymentFragment$initRxBindingsAndClickListeners$zipCodeValidationObservable$2(this), 4, null).subscribe(new CreditPaymentFragment$initRxBindingsAndClickListeners$5(this));
        EditText editText6 = (EditText) _$_findCachedViewById(R.Cif.cvvEditText);
        C1457Fr.m5016((Object) editText6, "cvvEditText");
        TextViewKt.textChangesSignUpFormValidation$default(editText6, new CreditPaymentFragment$initRxBindingsAndClickListeners$cvvValidationObservable$1(this), debounceEnabled, null, new CreditPaymentFragment$initRxBindingsAndClickListeners$cvvValidationObservable$2(this), 4, null).subscribe(new CreditPaymentFragment$initRxBindingsAndClickListeners$6(this));
        ((Button) _$_findCachedViewById(R.Cif.creditButton)).setOnClickListener(new CreditPaymentFragment$initRxBindingsAndClickListeners$7(this));
    }
}
