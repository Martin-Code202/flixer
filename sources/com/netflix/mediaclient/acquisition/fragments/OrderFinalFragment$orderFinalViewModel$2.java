package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.OrderFinalViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class OrderFinalFragment$orderFinalViewModel$2 extends Lambda implements AbstractC1449Fj<OrderFinalViewModel> {
    final /* synthetic */ OrderFinalFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderFinalFragment$orderFinalViewModel$2(OrderFinalFragment orderFinalFragment) {
        super(0);
        this.this$0 = orderFinalFragment;
    }

    @Override // o.AbstractC1449Fj
    public final OrderFinalViewModel invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (OrderFinalViewModel) ViewModelProviders.of(activity).get(OrderFinalViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
