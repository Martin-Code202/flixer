package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.android.moneyball.fields.StringField;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class RegistrationFragment$initRxValidationsAndClickListeners$emailValidationObservable$1<T> implements Consumer<CharSequence> {
    final /* synthetic */ RegistrationFragment this$0;

    RegistrationFragment$initRxValidationsAndClickListeners$emailValidationObservable$1(RegistrationFragment registrationFragment) {
        this.this$0 = registrationFragment;
    }

    public final void accept(CharSequence charSequence) {
        C1457Fr.m5025(charSequence, "it");
        StringField email = this.this$0.getRegistrationViewModel().getEmail();
        if (email != null) {
            email.setValue(charSequence.toString());
        }
    }
}
