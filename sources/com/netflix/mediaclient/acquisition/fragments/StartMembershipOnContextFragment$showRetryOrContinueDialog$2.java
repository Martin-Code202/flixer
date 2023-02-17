package com.netflix.mediaclient.acquisition.fragments;

import android.content.DialogInterface;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.util.DebugBillingManager;
final class StartMembershipOnContextFragment$showRetryOrContinueDialog$2 implements DialogInterface.OnClickListener {
    final /* synthetic */ StartMembershipOnContextFragment this$0;

    StartMembershipOnContextFragment$showRetryOrContinueDialog$2(StartMembershipOnContextFragment startMembershipOnContextFragment) {
        this.this$0 = startMembershipOnContextFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SignupNativeActivity signupActivity;
        DebugBillingManager debugBillingManager;
        String selectedSku = this.this$0.getStartMembershipModel().getSelectedSku();
        if (selectedSku != null && (signupActivity = this.this$0.getSignupActivity()) != null && (debugBillingManager = signupActivity.getDebugBillingManager()) != null) {
            debugBillingManager.invokePurchase(selectedSku, "", 30, "", this.this$0.purchaseResponseHandler);
        }
    }
}
