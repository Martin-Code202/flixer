package com.netflix.mediaclient.acquisition.fragments;

import android.view.ContextThemeWrapper;
import android.view.View;
import com.netflix.mediaclient.R;
import o.ActivityC2194tx;
/* access modifiers changed from: package-private */
public final class ConfirmFragment$initClickListeners$2 implements View.OnClickListener {
    final /* synthetic */ ConfirmFragment this$0;

    ConfirmFragment$initClickListeners$2(ConfirmFragment confirmFragment) {
        this.this$0 = confirmFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityC2194tx.m11260(new ContextThemeWrapper(this.this$0.getActivity(), (int) R.style.SignupInterruptDialog), R.string.confirm_signout);
    }
}
