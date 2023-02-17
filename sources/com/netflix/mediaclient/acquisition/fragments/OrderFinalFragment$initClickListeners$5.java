package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.viewmodels.OrderFinalViewModel;
/* access modifiers changed from: package-private */
public final class OrderFinalFragment$initClickListeners$5 implements View.OnClickListener {
    final /* synthetic */ OrderFinalFragment this$0;

    OrderFinalFragment$initClickListeners$5(OrderFinalFragment orderFinalFragment) {
        this.this$0 = orderFinalFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionField nextAction = this.this$0.getOrderFinalViewModel().getNextAction();
        if (nextAction != null) {
            OrderFinalViewModel orderFinalViewModel = this.this$0.getOrderFinalViewModel();
            SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
            orderFinalViewModel.next(nextAction, signupActivity != null ? signupActivity.getServiceManager() : null, new OrderFinalFragment$initClickListeners$5$1$1(this.this$0));
        }
    }
}
