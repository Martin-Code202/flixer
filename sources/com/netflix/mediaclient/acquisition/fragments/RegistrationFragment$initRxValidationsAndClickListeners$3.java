package com.netflix.mediaclient.acquisition.fragments;

import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class RegistrationFragment$initRxValidationsAndClickListeners$3<T> implements Consumer<Boolean> {
    final /* synthetic */ RegistrationFragment this$0;

    RegistrationFragment$initRxValidationsAndClickListeners$3(RegistrationFragment registrationFragment) {
        this.this$0 = registrationFragment;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "valid");
        this.this$0.getRegistrationViewModel().setAllFieldsValidated(bool.booleanValue());
    }
}
