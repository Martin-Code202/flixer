package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.mediaclient.acquisition.BillingManager;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
/* access modifiers changed from: package-private */
public final class StartMembershipOnContextFragment$initClickListeners$1 implements View.OnClickListener {
    final /* synthetic */ StartMembershipOnContextFragment this$0;

    StartMembershipOnContextFragment$initClickListeners$1(StartMembershipOnContextFragment startMembershipOnContextFragment) {
        this.this$0 = startMembershipOnContextFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BillingManager billingManager;
        this.this$0.purchaseUsedDebugBillingManager = false;
        this.this$0.getStartMembershipModel().isLoading().setValue(true);
        String selectedSku = this.this$0.getStartMembershipModel().getSelectedSku();
        if (selectedSku != null) {
            StringField devPayload = this.this$0.getStartMembershipModel().getDevPayload();
            Object value = devPayload != null ? devPayload.getValue() : null;
            if (!(value instanceof String)) {
                value = null;
            }
            String str = (String) value;
            int freeTrialInDays = this.this$0.getStartMembershipModel().getFreeTrialInDays();
            String partnerID = this.this$0.getStartMembershipModel().getPartnerID();
            SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
            if (signupActivity != null && (billingManager = signupActivity.getBillingManager()) != null) {
                billingManager.invokePurchase(selectedSku, str, freeTrialInDays, partnerID, this.this$0.purchaseResponseHandler);
            }
        }
    }
}
