package com.netflix.mediaclient.acquisition.fragments;

import android.widget.Button;
import com.netflix.mediaclient.R;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class GiftCardPaymentFragment$initRxValidationsAndClickListeners$3<T> implements Consumer<Boolean> {
    final /* synthetic */ GiftCardPaymentFragment this$0;

    GiftCardPaymentFragment$initRxValidationsAndClickListeners$3(GiftCardPaymentFragment giftCardPaymentFragment) {
        this.this$0 = giftCardPaymentFragment;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "valid");
        Button button = (Button) this.this$0._$_findCachedViewById(R.Cif.giftCardButton);
        C1457Fr.m5016((Object) button, "giftCardButton");
        button.setEnabled(bool.booleanValue());
    }
}
