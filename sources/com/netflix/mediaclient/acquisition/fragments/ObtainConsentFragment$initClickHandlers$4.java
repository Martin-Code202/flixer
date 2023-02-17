package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.android.moneyball.fields.BooleanField;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class ObtainConsentFragment$initClickHandlers$4<T> implements Consumer<Boolean> {
    final /* synthetic */ ObtainConsentFragment this$0;

    ObtainConsentFragment$initClickHandlers$4(ObtainConsentFragment obtainConsentFragment) {
        this.this$0 = obtainConsentFragment;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "it");
        BooleanField informationAbroadConsent = this.this$0.getObtainConsentViewModel().getInformationAbroadConsent();
        if (informationAbroadConsent != null) {
            informationAbroadConsent.setValue(bool);
        }
    }
}
