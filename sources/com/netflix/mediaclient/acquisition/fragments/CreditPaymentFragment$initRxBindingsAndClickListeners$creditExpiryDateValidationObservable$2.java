package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.android.moneyball.fields.NumberField;
import io.reactivex.functions.Function;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class CreditPaymentFragment$initRxBindingsAndClickListeners$creditExpiryDateValidationObservable$2<T, R> implements Function<CharSequence, Boolean> {
    final /* synthetic */ CreditPaymentFragment this$0;

    CreditPaymentFragment$initRxBindingsAndClickListeners$creditExpiryDateValidationObservable$2(CreditPaymentFragment creditPaymentFragment) {
        this.this$0 = creditPaymentFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* synthetic */ Boolean apply(CharSequence charSequence) {
        return Boolean.valueOf(apply(charSequence));
    }

    public final boolean apply(CharSequence charSequence) {
        NumberField creditExpirationYear;
        C1457Fr.m5025(charSequence, "it");
        NumberField creditExpirationMonth = this.this$0.getPayViewModel().getCreditExpirationMonth();
        return creditExpirationMonth != null && creditExpirationMonth.isValid() && (creditExpirationYear = this.this$0.getPayViewModel().getCreditExpirationYear()) != null && creditExpirationYear.isValid();
    }
}
