package com.netflix.mediaclient.acquisition.fragments;

import android.support.design.widget.TextInputLayout;
import com.netflix.mediaclient.R;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class GiftCardPaymentFragment$initRxValidationsAndClickListeners$1<T> implements Consumer<Boolean> {
    final /* synthetic */ GiftCardPaymentFragment this$0;

    GiftCardPaymentFragment$initRxValidationsAndClickListeners$1(GiftCardPaymentFragment giftCardPaymentFragment) {
        this.this$0 = giftCardPaymentFragment;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "isValid");
        if (!bool.booleanValue()) {
            TextInputLayout textInputLayout = (TextInputLayout) this.this$0._$_findCachedViewById(R.Cif.giftCardInputLayout);
            C1457Fr.m5016((Object) textInputLayout, "giftCardInputLayout");
            textInputLayout.setError("Invalid Gift Code");
        }
        TextInputLayout textInputLayout2 = (TextInputLayout) this.this$0._$_findCachedViewById(R.Cif.giftCardInputLayout);
        C1457Fr.m5016((Object) textInputLayout2, "giftCardInputLayout");
        textInputLayout2.setErrorEnabled(!bool.booleanValue());
    }
}
