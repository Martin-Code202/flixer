package com.netflix.mediaclient.acquisition.fragments;

import android.support.design.widget.TextInputLayout;
import com.netflix.mediaclient.R;
import io.reactivex.functions.Consumer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class CreditPaymentFragment$initRxBindingsAndClickListeners$2<T> implements Consumer<Boolean> {
    final /* synthetic */ CreditPaymentFragment this$0;

    CreditPaymentFragment$initRxBindingsAndClickListeners$2(CreditPaymentFragment creditPaymentFragment) {
        this.this$0 = creditPaymentFragment;
    }

    public final void accept(Boolean bool) {
        C1457Fr.m5025(bool, "isValid");
        if (!bool.booleanValue()) {
            TextInputLayout textInputLayout = (TextInputLayout) this.this$0._$_findCachedViewById(R.Cif.firstNameLayout);
            C1457Fr.m5016((Object) textInputLayout, "firstNameLayout");
            textInputLayout.setError("Invalid Last Name");
        }
        TextInputLayout textInputLayout2 = (TextInputLayout) this.this$0._$_findCachedViewById(R.Cif.lastNameLayout);
        C1457Fr.m5016((Object) textInputLayout2, "lastNameLayout");
        textInputLayout2.setErrorEnabled(!bool.booleanValue());
    }
}
