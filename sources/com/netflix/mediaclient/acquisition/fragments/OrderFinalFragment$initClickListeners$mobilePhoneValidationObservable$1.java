package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.android.moneyball.fields.StringField;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class OrderFinalFragment$initClickListeners$mobilePhoneValidationObservable$1<T> implements Consumer<CharSequence> {
    final /* synthetic */ OrderFinalFragment this$0;

    OrderFinalFragment$initClickListeners$mobilePhoneValidationObservable$1(OrderFinalFragment orderFinalFragment) {
        this.this$0 = orderFinalFragment;
    }

    public final void accept(CharSequence charSequence) {
        C1457Fr.m5025(charSequence, "it");
        StringField mobilePhone = this.this$0.getOrderFinalViewModel().getMobilePhone();
        if (mobilePhone != null) {
            mobilePhone.setValue(charSequence.toString());
        }
    }
}
