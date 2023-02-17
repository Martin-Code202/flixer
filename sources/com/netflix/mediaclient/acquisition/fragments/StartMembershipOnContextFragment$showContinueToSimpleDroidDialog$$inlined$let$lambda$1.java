package com.netflix.mediaclient.acquisition.fragments;

import android.content.DialogInterface;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.util.AUIMoneyballUtilities;
import com.netflix.mediaclient.acquisition.viewmodels.GooglePlayConstants;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import o.AbstractC1451Fl;
import o.C1457Fr;
import o.C1461Fv;
import o.C2059ph;
import o.EA;
import o.FO;
/* access modifiers changed from: package-private */
public final class StartMembershipOnContextFragment$showContinueToSimpleDroidDialog$$inlined$let$lambda$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ SignupNativeActivity $it;
    final /* synthetic */ StartMembershipOnContextFragment this$0;

    StartMembershipOnContextFragment$showContinueToSimpleDroidDialog$$inlined$let$lambda$1(SignupNativeActivity signupNativeActivity, StartMembershipOnContextFragment startMembershipOnContextFragment) {
        this.$it = signupNativeActivity;
        this.this$0 = startMembershipOnContextFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.this$0.getStartMembershipModel().getFlowMode() != null) {
            AUIMoneyballUtilities aUIMoneyballUtilities = AUIMoneyballUtilities.INSTANCE;
            C2059ph serviceManager = this.$it.getServiceManager();
            FlowMode flowMode = this.this$0.getStartMembershipModel().getFlowMode();
            if (flowMode == null) {
                C1457Fr.m5019();
            }
            aUIMoneyballUtilities.sendFallbackRequestToMoneyball(serviceManager, flowMode, GooglePlayConstants.ERROR_GOOGLE_PLAY_PURCHASE_RETRY_COUNT_EXCEEDED, new AbstractC1451Fl<MoneyballData, Status, EA>(this.this$0) { // from class: com.netflix.mediaclient.acquisition.fragments.StartMembershipOnContextFragment$showContinueToSimpleDroidDialog$$inlined$let$lambda$1.1
                @Override // kotlin.jvm.internal.CallableReference, o.FL
                public final String getName() {
                    return "handleMoneyballResponse";
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final FO getOwner() {
                    return C1461Fv.m5035(StartMembershipOnContextFragment.class);
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final String getSignature() {
                    return "handleMoneyballResponse(Lcom/netflix/mediaclient/service/webclient/model/leafs/MoneyballData;Lcom/netflix/mediaclient/android/app/Status;)V";
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // o.AbstractC1451Fl
                public /* bridge */ /* synthetic */ EA invoke(MoneyballData moneyballData, Status status) {
                    invoke(moneyballData, status);
                    return EA.f5503;
                }

                public final void invoke(MoneyballData moneyballData, Status status) {
                    C1457Fr.m5025(status, "p2");
                    ((StartMembershipOnContextFragment) this.receiver).handleMoneyballResponse(moneyballData, status);
                }
            });
        }
    }
}
