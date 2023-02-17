package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.viewmodels.CreditOptionPayViewModel;
/* access modifiers changed from: package-private */
public final class CreditPaymentFragment$initRxBindingsAndClickListeners$7 implements View.OnClickListener {
    final /* synthetic */ CreditPaymentFragment this$0;

    CreditPaymentFragment$initRxBindingsAndClickListeners$7(CreditPaymentFragment creditPaymentFragment) {
        this.this$0 = creditPaymentFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionField nextAction = this.this$0.getPayViewModel().getNextAction();
        if (nextAction != null) {
            CreditOptionPayViewModel creditOptionPayViewModel = this.this$0.getPayViewModel();
            SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
            creditOptionPayViewModel.next(nextAction, signupActivity != null ? signupActivity.getServiceManager() : null, new CreditPaymentFragment$initRxBindingsAndClickListeners$7$1$1(this.this$0));
        }
    }
}
