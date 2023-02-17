package com.netflix.mediaclient.acquisition.fragments;

import android.content.DialogInterface;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.util.AUIMoneyballUtilities;
/* access modifiers changed from: package-private */
public final class StartMembershipOnContextFragment$showRetryOrContinueDialog$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ String $fallbackReason;
    final /* synthetic */ StartMembershipOnContextFragment this$0;

    StartMembershipOnContextFragment$showRetryOrContinueDialog$1(StartMembershipOnContextFragment startMembershipOnContextFragment, String str) {
        this.this$0 = startMembershipOnContextFragment;
        this.$fallbackReason = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        FlowMode flowMode = this.this$0.getStartMembershipModel().getFlowMode();
        if (flowMode != null) {
            AUIMoneyballUtilities aUIMoneyballUtilities = AUIMoneyballUtilities.INSTANCE;
            SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
            aUIMoneyballUtilities.sendFallbackRequestToMoneyball(signupActivity != null ? signupActivity.getServiceManager() : null, flowMode, this.$fallbackReason, new StartMembershipOnContextFragment$showRetryOrContinueDialog$1$1$1(this.this$0));
        }
    }
}
