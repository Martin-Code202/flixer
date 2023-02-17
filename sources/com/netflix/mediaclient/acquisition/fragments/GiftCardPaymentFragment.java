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
import com.netflix.mediaclient.acquisition.view.SignupNativeConfig;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.PayViewModel;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1433Et;
import o.C0965;
import o.C1435Ev;
import o.C1457Fr;
import o.C1461Fv;
import o.FQ;
public final class GiftCardPaymentFragment extends AbstractSignupFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(GiftCardPaymentFragment.class), "payViewModel", "getPayViewModel()Lcom/netflix/mediaclient/acquisition/viewmodels/PayViewModel;"))};
    private HashMap _$_findViewCache;
    private final AbstractC1433Et payViewModel$delegate = C1435Ev.m4972(new GiftCardPaymentFragment$payViewModel$2(this));

    /* access modifiers changed from: private */
    public final PayViewModel getPayViewModel() {
        AbstractC1433Et et = this.payViewModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (PayViewModel) et.mo3220();
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
        return AppView.paymentGiftCard;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pay_option_gift_fragment_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initRxValidationsAndClickListeners();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getPayViewModel();
    }

    private final void initRxValidationsAndClickListeners() {
        boolean debounceEnabled = SignupNativeConfig.INSTANCE.getDebounceEnabled();
        EditText editText = (EditText) _$_findCachedViewById(R.Cif.giftCardEditText);
        C1457Fr.m5016((Object) editText, "giftCardEditText");
        Observable textChangesSignUpFormValidation$default = TextViewKt.textChangesSignUpFormValidation$default(editText, new GiftCardPaymentFragment$initRxValidationsAndClickListeners$giftCodeValidationObservable$1(this), debounceEnabled, null, new GiftCardPaymentFragment$initRxValidationsAndClickListeners$giftCodeValidationObservable$2(this), 4, null);
        textChangesSignUpFormValidation$default.subscribe(new GiftCardPaymentFragment$initRxValidationsAndClickListeners$1(this));
        EditText editText2 = (EditText) _$_findCachedViewById(R.Cif.zipEditText);
        C1457Fr.m5016((Object) editText2, "zipEditText");
        Observable textChangesSignUpFormValidation$default2 = TextViewKt.textChangesSignUpFormValidation$default(editText2, new GiftCardPaymentFragment$initRxValidationsAndClickListeners$zipCodeValidationObservable$1(this), debounceEnabled, null, new GiftCardPaymentFragment$initRxValidationsAndClickListeners$zipCodeValidationObservable$2(this), 4, null);
        textChangesSignUpFormValidation$default2.subscribe(new GiftCardPaymentFragment$initRxValidationsAndClickListeners$2(this));
        Observable combineLatest = Observable.combineLatest(textChangesSignUpFormValidation$default, textChangesSignUpFormValidation$default2, GiftCardPaymentFragment$initRxValidationsAndClickListeners$buttonEnabledObservable$1.INSTANCE);
        C1457Fr.m5016((Object) combineLatest, "Observable.combineLatest…tCodeValid && zipValid })");
        combineLatest.takeUntil(C0965.m15784((Button) _$_findCachedViewById(R.Cif.giftCardButton))).distinctUntilChanged().subscribe(new GiftCardPaymentFragment$initRxValidationsAndClickListeners$3(this));
        ((Button) _$_findCachedViewById(R.Cif.giftCardButton)).setOnClickListener(new GiftCardPaymentFragment$initRxValidationsAndClickListeners$4(this));
        ((Button) _$_findCachedViewById(R.Cif.giftSkipButton)).setOnClickListener(new GiftCardPaymentFragment$initRxValidationsAndClickListeners$5(this));
    }
}
