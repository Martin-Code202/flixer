package com.netflix.mediaclient.acquisition;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import o.AbstractC1113;
import o.C1276;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class SignupNativeActivity$fetchMode$1 implements AbstractC1113 {
    final /* synthetic */ SignupNativeActivity this$0;

    SignupNativeActivity$fetchMode$1(SignupNativeActivity signupNativeActivity) {
        this.this$0 = signupNativeActivity;
    }

    @Override // o.AbstractC1113
    public final void onDataFetched(MoneyballData moneyballData, Status status) {
        C1457Fr.m5025(status, "status");
        C1276.m16820().mo5728("Signup fetched mode: " + (moneyballData != null ? moneyballData.getMode() : null));
        C1276.m16820().mo5727("SignupNativeActivity fetchMode");
        if (status.mo298()) {
            if ((moneyballData != null ? moneyballData.getFlowMode() : null) != null) {
                this.this$0.getFlowModel().getCurrentMoneyballData().setValue(moneyballData);
                return;
            }
        }
        System.out.println((Object) "SignupNativeActivity, showing an error.");
        this.this$0.showErrorDialogForStatus(status);
    }
}
