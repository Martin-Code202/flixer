package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.util.DebugBillingManager;
final class StartMembershipOnContextFragment$initLongClickListener$1 implements View.OnLongClickListener {
    final /* synthetic */ StartMembershipOnContextFragment this$0;

    StartMembershipOnContextFragment$initLongClickListener$1(StartMembershipOnContextFragment startMembershipOnContextFragment) {
        this.this$0 = startMembershipOnContextFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        SignupNativeActivity signupActivity;
        DebugBillingManager debugBillingManager;
        this.this$0.purchaseUsedDebugBillingManager = true;
        String selectedSku = this.this$0.getStartMembershipModel().getSelectedSku();
        if (!(selectedSku == null || (signupActivity = this.this$0.getSignupActivity()) == null || (debugBillingManager = signupActivity.getDebugBillingManager()) == null)) {
            debugBillingManager.invokePurchase(selectedSku, "", 30, "", this.this$0.purchaseResponseHandler);
        }
        return true;
    }
}
