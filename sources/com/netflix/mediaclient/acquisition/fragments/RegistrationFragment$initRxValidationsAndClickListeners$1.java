package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.cl.model.AppView;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
import o.zN;
/* access modifiers changed from: package-private */
public final class RegistrationFragment$initRxValidationsAndClickListeners$1<T> implements Consumer<Boolean> {
    final /* synthetic */ RegistrationFragment this$0;

    RegistrationFragment$initRxValidationsAndClickListeners$1(RegistrationFragment registrationFragment) {
        this.this$0 = registrationFragment;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "hasFocus");
        zN.f12697.m13519(bool.booleanValue(), AppView.emailInput);
        if (!bool.booleanValue()) {
            this.this$0.getRegistrationViewModel().setShowEmailState(true);
        }
        this.this$0.setEmailValidationError();
    }
}
