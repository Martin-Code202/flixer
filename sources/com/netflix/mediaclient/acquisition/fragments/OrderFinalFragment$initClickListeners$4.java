package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.mediaclient.R;
import io.reactivex.functions.Consumer;
import o.C0754;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class OrderFinalFragment$initClickListeners$4<T> implements Consumer<Boolean> {
    final /* synthetic */ OrderFinalFragment this$0;

    OrderFinalFragment$initClickListeners$4(OrderFinalFragment orderFinalFragment) {
        this.this$0 = orderFinalFragment;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "valid");
        C0754 r0 = (C0754) this.this$0._$_findCachedViewById(R.Cif.orderFinalButton);
        C1457Fr.m5016((Object) r0, "orderFinalButton");
        r0.setEnabled(bool.booleanValue());
    }
}
