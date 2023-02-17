package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.util.AUIMoneyballUtilities;
import com.netflix.mediaclient.acquisition.viewmodels.GooglePlayConstants;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.EA;
/* access modifiers changed from: package-private */
public final class PlanSelectionFragment$initPrices$1 extends Lambda implements AbstractC1450Fk<Map<String, ? extends String>, EA> {
    final /* synthetic */ PlanSelectionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlanSelectionFragment$initPrices$1(PlanSelectionFragment planSelectionFragment) {
        super(1);
        this.this$0 = planSelectionFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* bridge */ /* synthetic */ EA invoke(Map<String, ? extends String> map) {
        invoke((Map<String, String>) map);
        return EA.f5503;
    }

    public final void invoke(Map<String, String> map) {
        if (map != null || !this.this$0.getPlanSelectionModel().getPlayStoreFallbackEnabled()) {
            this.this$0.getPlanSelectionModel().setPlayBillingPrices(map);
            this.this$0.initPlanRowValues();
            return;
        }
        FlowMode flowMode = this.this$0.getPlanSelectionModel().getFlowMode();
        if (flowMode != null) {
            AUIMoneyballUtilities aUIMoneyballUtilities = AUIMoneyballUtilities.INSTANCE;
            SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
            aUIMoneyballUtilities.sendFallbackRequestToMoneyball(signupActivity != null ? signupActivity.getServiceManager() : null, flowMode, GooglePlayConstants.ERROR_GOOGLE_PLAY_FETCH_RETRY_COUNT_EXCEEDED, new PlanSelectionFragment$initPrices$1$1$1(this.this$0));
        }
    }
}
