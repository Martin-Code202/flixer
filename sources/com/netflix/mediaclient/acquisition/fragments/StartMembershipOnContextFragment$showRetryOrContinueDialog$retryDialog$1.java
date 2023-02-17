package com.netflix.mediaclient.acquisition.fragments;

import android.content.DialogInterface;
import com.netflix.mediaclient.acquisition.BillingManager;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
/* access modifiers changed from: package-private */
public final class StartMembershipOnContextFragment$showRetryOrContinueDialog$retryDialog$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ StartMembershipOnContextFragment this$0;

    StartMembershipOnContextFragment$showRetryOrContinueDialog$retryDialog$1(StartMembershipOnContextFragment startMembershipOnContextFragment) {
        this.this$0 = startMembershipOnContextFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SignupNativeActivity signupActivity;
        BillingManager billingManager;
        String selectedSku = this.this$0.getStartMembershipModel().getSelectedSku();
        if (selectedSku != null && (signupActivity = this.this$0.getSignupActivity()) != null && (billingManager = signupActivity.getBillingManager()) != null) {
            billingManager.invokePurchase(selectedSku, "", 30, "", this.this$0.purchaseResponseHandler);
        }
    }
}
