package com.netflix.mediaclient.acquisition.fragments;

import io.reactivex.functions.BiFunction;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class GiftCardPaymentFragment$initRxValidationsAndClickListeners$buttonEnabledObservable$1<T1, T2, R> implements BiFunction<Boolean, Boolean, Boolean> {
    public static final GiftCardPaymentFragment$initRxValidationsAndClickListeners$buttonEnabledObservable$1 INSTANCE = new GiftCardPaymentFragment$initRxValidationsAndClickListeners$buttonEnabledObservable$1();

    GiftCardPaymentFragment$initRxValidationsAndClickListeners$buttonEnabledObservable$1() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.functions.BiFunction
    public /* synthetic */ Boolean apply(Boolean bool, Boolean bool2) {
        return Boolean.valueOf(apply(bool, bool2));
    }

    public final boolean apply(Boolean bool, Boolean bool2) {
        C1457Fr.m5025(bool, "giftCodeValid");
        C1457Fr.m5025(bool2, "zipValid");
        return bool.booleanValue() && bool2.booleanValue();
    }
}
