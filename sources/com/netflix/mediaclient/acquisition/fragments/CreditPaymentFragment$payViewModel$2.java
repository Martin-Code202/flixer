package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.CreditOptionPayViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class CreditPaymentFragment$payViewModel$2 extends Lambda implements AbstractC1449Fj<CreditOptionPayViewModel> {
    final /* synthetic */ CreditPaymentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreditPaymentFragment$payViewModel$2(CreditPaymentFragment creditPaymentFragment) {
        super(0);
        this.this$0 = creditPaymentFragment;
    }

    @Override // o.AbstractC1449Fj
    public final CreditOptionPayViewModel invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (CreditOptionPayViewModel) ViewModelProviders.of(activity).get(CreditOptionPayViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
