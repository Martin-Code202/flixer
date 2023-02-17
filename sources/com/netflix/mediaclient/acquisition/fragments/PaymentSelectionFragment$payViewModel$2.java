package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.PayViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
final class PaymentSelectionFragment$payViewModel$2 extends Lambda implements AbstractC1449Fj<PayViewModel> {
    final /* synthetic */ PaymentSelectionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentSelectionFragment$payViewModel$2(PaymentSelectionFragment paymentSelectionFragment) {
        super(0);
        this.this$0 = paymentSelectionFragment;
    }

    @Override // o.AbstractC1449Fj
    public final PayViewModel invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (PayViewModel) ViewModelProviders.of(activity).get(PayViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
