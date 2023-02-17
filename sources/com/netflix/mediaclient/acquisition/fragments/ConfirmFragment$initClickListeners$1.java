package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.android.moneyball.fields.BooleanField;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class ConfirmFragment$initClickListeners$1<T> implements Consumer<Boolean> {
    final /* synthetic */ ConfirmFragment this$0;

    ConfirmFragment$initClickListeners$1(ConfirmFragment confirmFragment) {
        this.this$0 = confirmFragment;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "isChecked");
        BooleanField hasAcceptedTermsOfUse = this.this$0.getConfirmViewModel().getHasAcceptedTermsOfUse();
        if (hasAcceptedTermsOfUse != null) {
            hasAcceptedTermsOfUse.setValue(bool);
        }
    }
}
