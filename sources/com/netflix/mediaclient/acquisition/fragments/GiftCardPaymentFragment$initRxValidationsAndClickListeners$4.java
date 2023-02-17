package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.viewmodels.PayViewModel;
/* access modifiers changed from: package-private */
public final class GiftCardPaymentFragment$initRxValidationsAndClickListeners$4 implements View.OnClickListener {
    final /* synthetic */ GiftCardPaymentFragment this$0;

    GiftCardPaymentFragment$initRxValidationsAndClickListeners$4(GiftCardPaymentFragment giftCardPaymentFragment) {
        this.this$0 = giftCardPaymentFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionField nextAction = this.this$0.getPayViewModel().getNextAction();
        if (nextAction != null) {
            PayViewModel payViewModel = this.this$0.getPayViewModel();
            SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
            payViewModel.next(nextAction, signupActivity != null ? signupActivity.getServiceManager() : null, new GiftCardPaymentFragment$initRxValidationsAndClickListeners$4$1$1(this.this$0));
        }
    }
}
