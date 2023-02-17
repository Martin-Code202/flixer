package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.view.PhoneNumberCountryInput;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class OrderFinalFragment$initClickListeners$3<T> implements Consumer<Boolean> {
    final /* synthetic */ OrderFinalFragment this$0;

    OrderFinalFragment$initClickListeners$3(OrderFinalFragment orderFinalFragment) {
        this.this$0 = orderFinalFragment;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "isValid");
        ((PhoneNumberCountryInput) this.this$0._$_findCachedViewById(R.Cif.phoneNumberCountryInput)).showError(!bool.booleanValue());
    }
}
