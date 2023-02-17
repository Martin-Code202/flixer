package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.mediaclient.acquisition.fragments.PlanContextFragment;
/* access modifiers changed from: package-private */
public final class PlanContextFragment$initClickListeners$1 implements View.OnClickListener {
    final /* synthetic */ PlanContextFragment this$0;

    PlanContextFragment$initClickListeners$1(PlanContextFragment planContextFragment) {
        this.this$0 = planContextFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PlanContextFragment.PlanContextClickListener planContextClickListener = this.this$0.getPlanContextClickListener();
        if (planContextClickListener != null) {
            planContextClickListener.onPlanContextConfirm();
        }
    }
}
