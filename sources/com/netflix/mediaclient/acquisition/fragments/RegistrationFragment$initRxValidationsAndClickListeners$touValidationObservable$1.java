package com.netflix.mediaclient.acquisition.fragments;

import android.widget.LinearLayout;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.mediaclient.R;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class RegistrationFragment$initRxValidationsAndClickListeners$touValidationObservable$1<T> implements Consumer<Boolean> {
    final /* synthetic */ RegistrationFragment this$0;

    RegistrationFragment$initRxValidationsAndClickListeners$touValidationObservable$1(RegistrationFragment registrationFragment) {
        this.this$0 = registrationFragment;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "it");
        ((LinearLayout) this.this$0._$_findCachedViewById(R.Cif.registrationLayout)).requestFocus();
        BooleanField hasAcceptedTermsOfUse = this.this$0.getRegistrationViewModel().getHasAcceptedTermsOfUse();
        if (hasAcceptedTermsOfUse != null) {
            hasAcceptedTermsOfUse.setValue(bool);
        }
    }
}
