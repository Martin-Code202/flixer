package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
/* access modifiers changed from: package-private */
public final class OrderFinalFragment$initClickListeners$1 implements View.OnClickListener {
    final /* synthetic */ OrderFinalFragment this$0;

    OrderFinalFragment$initClickListeners$1(OrderFinalFragment orderFinalFragment) {
        this.this$0 = orderFinalFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.openCountrySelectionDialog();
    }
}
