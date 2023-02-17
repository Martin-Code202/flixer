package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.android.moneyball.fields.ChoiceField;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.viewmodels.PlanSelectionViewModel;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class PlanSelectionFragment$initClickListeners$1 implements View.OnClickListener {
    final /* synthetic */ PlanSelectionFragment this$0;

    PlanSelectionFragment$initClickListeners$1(PlanSelectionFragment planSelectionFragment) {
        this.this$0 = planSelectionFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ChoiceField planChoice;
        this.this$0.getPlanSelectionModel().isLoading().setValue(true);
        if (!(this.this$0.getPlanSelectionModel().getPlanSelected() == null || (planChoice = this.this$0.getPlanSelectionModel().getPlanChoice()) == null)) {
            String planSelected = this.this$0.getPlanSelectionModel().getPlanSelected();
            if (planSelected == null) {
                C1457Fr.m5019();
            }
            planChoice.setValue(planSelected);
        }
        ActionField nextAction = this.this$0.getPlanSelectionModel().getNextAction();
        if (nextAction != null) {
            PlanSelectionViewModel planSelectionViewModel = this.this$0.getPlanSelectionModel();
            SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
            planSelectionViewModel.next(nextAction, signupActivity != null ? signupActivity.getServiceManager() : null, new PlanSelectionFragment$initClickListeners$1$1$1(this.this$0));
        }
    }
}
