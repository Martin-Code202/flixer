package com.netflix.mediaclient.acquisition.fragments;

import io.reactivex.functions.Function3;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class RegistrationFragment$initRxValidationsAndClickListeners$buttonEnabledObservable$1<T1, T2, T3, R> implements Function3<Boolean, Boolean, Boolean, Boolean> {
    public static final RegistrationFragment$initRxValidationsAndClickListeners$buttonEnabledObservable$1 INSTANCE = new RegistrationFragment$initRxValidationsAndClickListeners$buttonEnabledObservable$1();

    RegistrationFragment$initRxValidationsAndClickListeners$buttonEnabledObservable$1() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.functions.Function3
    public /* synthetic */ Boolean apply(Boolean bool, Boolean bool2, Boolean bool3) {
        return Boolean.valueOf(apply(bool, bool2, bool3));
    }

    public final boolean apply(Boolean bool, Boolean bool2, Boolean bool3) {
        C1457Fr.m5025(bool, "emailValid");
        C1457Fr.m5025(bool2, "passwordValid");
        C1457Fr.m5025(bool3, "touValid");
        return bool.booleanValue() && bool2.booleanValue() && bool3.booleanValue();
    }
}
