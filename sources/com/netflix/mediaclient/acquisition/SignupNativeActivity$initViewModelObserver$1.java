package com.netflix.mediaclient.acquisition;

import android.arch.lifecycle.Observer;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class SignupNativeActivity$initViewModelObserver$1<T> implements Observer<MoneyballData> {
    final /* synthetic */ SignupNativeActivity this$0;

    SignupNativeActivity$initViewModelObserver$1(SignupNativeActivity signupNativeActivity) {
        this.this$0 = signupNativeActivity;
    }

    public final void onChanged(MoneyballData moneyballData) {
        if (!C1457Fr.m5018((Object) this.this$0.suppressNavigateToFlowMode, (Object) true) || this.this$0.getCurrentFragment() == null) {
            this.this$0.suppressNavigateToFlowMode = false;
            this.this$0.navigateToFlowMode(moneyballData != null ? moneyballData.getFlowMode() : null);
            return;
        }
        this.this$0.suppressNavigateToFlowMode = false;
        if ((moneyballData != null ? moneyballData.getFlowMode() : null) != null) {
            this.this$0.hideProgressSpinner();
        }
    }
}
