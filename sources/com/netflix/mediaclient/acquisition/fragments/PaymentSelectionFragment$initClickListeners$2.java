package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.mediaclient.acquisition.fragments.PaymentSelectionFragment;
/* access modifiers changed from: package-private */
public final class PaymentSelectionFragment$initClickListeners$2 implements View.OnClickListener {
    final /* synthetic */ PaymentSelectionFragment this$0;

    PaymentSelectionFragment$initClickListeners$2(PaymentSelectionFragment paymentSelectionFragment) {
        this.this$0 = paymentSelectionFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PaymentSelectionFragment.PaymentSelectionClickListener paymentSelectionClickListener = this.this$0.getPaymentSelectionClickListener();
        if (paymentSelectionClickListener != null) {
            paymentSelectionClickListener.onPaymentCreditCardClick();
        }
    }
}
