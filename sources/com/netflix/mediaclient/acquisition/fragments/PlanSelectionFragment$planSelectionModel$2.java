package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.PlanSelectionViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class PlanSelectionFragment$planSelectionModel$2 extends Lambda implements AbstractC1449Fj<PlanSelectionViewModel> {
    final /* synthetic */ PlanSelectionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlanSelectionFragment$planSelectionModel$2(PlanSelectionFragment planSelectionFragment) {
        super(0);
        this.this$0 = planSelectionFragment;
    }

    @Override // o.AbstractC1449Fj
    public final PlanSelectionViewModel invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (PlanSelectionViewModel) ViewModelProviders.of(activity).get(PlanSelectionViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
