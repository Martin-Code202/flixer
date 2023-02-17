package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.mediaclient.acquisition.fragments.RegistrationContextFragment;
/* access modifiers changed from: package-private */
public final class RegistrationContextFragment$initClickListeners$1 implements View.OnClickListener {
    final /* synthetic */ RegistrationContextFragment this$0;

    RegistrationContextFragment$initClickListeners$1(RegistrationContextFragment registrationContextFragment) {
        this.this$0 = registrationContextFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RegistrationContextFragment.RegistrationContextClickListener registrationContextClickListener = this.this$0.getRegistrationContextClickListener();
        if (registrationContextClickListener != null) {
            registrationContextClickListener.onRegistrationContextConfirm();
        }
    }
}
