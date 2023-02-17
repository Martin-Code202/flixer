package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.viewmodels.ConfirmViewModel;
import o.C1155;
/* access modifiers changed from: package-private */
public final class ConfirmFragment$initClickListeners$3 implements View.OnClickListener {
    final /* synthetic */ ConfirmFragment this$0;

    ConfirmFragment$initClickListeners$3(ConfirmFragment confirmFragment) {
        this.this$0 = confirmFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionField changePlanAction;
        if (!this.this$0.getHasActiveRequest() && (changePlanAction = this.this$0.getConfirmViewModel().getChangePlanAction()) != null) {
            this.this$0.setHasActiveRequest(true);
            Logger.INSTANCE.m140(Logger.INSTANCE.m142(new C1155()));
            ConfirmViewModel confirmViewModel = this.this$0.getConfirmViewModel();
            SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
            confirmViewModel.next(changePlanAction, signupActivity != null ? signupActivity.getServiceManager() : null, new ConfirmFragment$initClickListeners$3$1$1(this.this$0));
        }
    }
}
