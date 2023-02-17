package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.android.moneyball.fields.StringField;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class CreditPaymentFragment$initRxBindingsAndClickListeners$creditCardValidationObservable$1<T> implements Consumer<CharSequence> {
    final /* synthetic */ CreditPaymentFragment this$0;

    CreditPaymentFragment$initRxBindingsAndClickListeners$creditCardValidationObservable$1(CreditPaymentFragment creditPaymentFragment) {
        this.this$0 = creditPaymentFragment;
    }

    public final void accept(CharSequence charSequence) {
        C1457Fr.m5025(charSequence, "it");
        StringField creditCardNumber = this.this$0.getPayViewModel().getCreditCardNumber();
        if (creditCardNumber != null) {
            creditCardNumber.setValue(charSequence.toString());
        }
        StringField creditData = this.this$0.getPayViewModel().getCreditData();
        if (creditData != null) {
            creditData.setValue(this.this$0.getPayViewModel().toEncryptedString(CreditPaymentFragment.access$getPublicKey$p(this.this$0)));
        }
    }
}
