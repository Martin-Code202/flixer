package com.netflix.mediaclient.acquisition.fragments;

import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class RegistrationFragment$initRxValidationsAndClickListeners$emailValidationObservable$2<T> implements Consumer<CharSequence> {
    final /* synthetic */ RegistrationFragment this$0;

    RegistrationFragment$initRxValidationsAndClickListeners$emailValidationObservable$2(RegistrationFragment registrationFragment) {
        this.this$0 = registrationFragment;
    }

    public final void accept(CharSequence charSequence) {
        C1457Fr.m5025(charSequence, "it");
        this.this$0.setEmailValidationError();
    }
}
