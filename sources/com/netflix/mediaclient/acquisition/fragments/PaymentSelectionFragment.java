package com.netflix.mediaclient.acquisition.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.PayViewModel;
import java.util.HashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC0574;
import o.AbstractC1433Et;
import o.C1197;
import o.C1435Ev;
import o.C1457Fr;
import o.C1461Fv;
import o.FI;
import o.FQ;
public final class PaymentSelectionFragment extends AbstractSignupPresentationLoggingFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PaymentSelectionFragment.class), "giftButton", "getGiftButton()Landroid/widget/Button;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PaymentSelectionFragment.class), "creditButton", "getCreditButton()Landroid/widget/Button;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PaymentSelectionFragment.class), "payViewModel", "getPayViewModel()Lcom/netflix/mediaclient/acquisition/viewmodels/PayViewModel;"))};
    private HashMap _$_findViewCache;
    private final FI creditButton$delegate = C1197.m16464(this, (int) R.id.pay_credit_fragment_button);
    private final FI giftButton$delegate = C1197.m16464(this, (int) R.id.pay_gift_fragment_button);
    private final AbstractC1433Et payViewModel$delegate = C1435Ev.m4972(new PaymentSelectionFragment$payViewModel$2(this));

    public interface PaymentSelectionClickListener {
        void onPaymentCreditCardClick();

        void onPaymentGiftCardClick();
    }

    private final Button getCreditButton() {
        return (Button) this.creditButton$delegate.mo4986(this, $$delegatedProperties[1]);
    }

    private final Button getGiftButton() {
        return (Button) this.giftButton$delegate.mo4986(this, $$delegatedProperties[0]);
    }

    private final PayViewModel getPayViewModel() {
        AbstractC1433Et et = this.payViewModel$delegate;
        FQ fq = $$delegatedProperties[2];
        return (PayViewModel) et.mo3220();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupPresentationLoggingFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupPresentationLoggingFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
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

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupPresentationLoggingFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AppView getAppView() {
        return AppView.paymentContext;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pay_choice_fragment_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initClickListeners();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getPayViewModel();
    }

    private final void initClickListeners() {
        getGiftButton().setOnClickListener(new PaymentSelectionFragment$initClickListeners$1(this));
        getCreditButton().setOnClickListener(new PaymentSelectionFragment$initClickListeners$2(this));
    }

    /* access modifiers changed from: private */
    public final PaymentSelectionClickListener getPaymentSelectionClickListener() {
        return getSignupActivity();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupPresentationLoggingFragment
    public AbstractC0574 getTrackingInfo() {
        return getPayViewModel().getTrackingInfo();
    }
}
