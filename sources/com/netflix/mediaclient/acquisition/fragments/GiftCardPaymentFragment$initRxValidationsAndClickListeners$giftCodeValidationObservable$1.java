package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.android.moneyball.fields.StringField;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class GiftCardPaymentFragment$initRxValidationsAndClickListeners$giftCodeValidationObservable$1<T> implements Consumer<CharSequence> {
    final /* synthetic */ GiftCardPaymentFragment this$0;

    GiftCardPaymentFragment$initRxValidationsAndClickListeners$giftCodeValidationObservable$1(GiftCardPaymentFragment giftCardPaymentFragment) {
        this.this$0 = giftCardPaymentFragment;
    }

    public final void accept(CharSequence charSequence) {
        C1457Fr.m5025(charSequence, "it");
        StringField code = this.this$0.getPayViewModel().getCode();
        if (code != null) {
            code.setValue(charSequence.toString());
        }
    }
}
