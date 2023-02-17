package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.android.moneyball.fields.StringField;
import io.reactivex.functions.Function;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class GiftCardPaymentFragment$initRxValidationsAndClickListeners$giftCodeValidationObservable$2<T, R> implements Function<CharSequence, Boolean> {
    final /* synthetic */ GiftCardPaymentFragment this$0;

    GiftCardPaymentFragment$initRxValidationsAndClickListeners$giftCodeValidationObservable$2(GiftCardPaymentFragment giftCardPaymentFragment) {
        this.this$0 = giftCardPaymentFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* synthetic */ Boolean apply(CharSequence charSequence) {
        return Boolean.valueOf(apply(charSequence));
    }

    public final boolean apply(CharSequence charSequence) {
        C1457Fr.m5025(charSequence, "it");
        StringField code = this.this$0.getPayViewModel().getCode();
        return code != null && code.isValid();
    }
}
