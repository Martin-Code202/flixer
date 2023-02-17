package com.netflix.mediaclient.acquisition.fragments;

import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.mediaclient.R;
/* access modifiers changed from: package-private */
public final class RegistrationFragment$initCheckboxes$1 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ RegistrationFragment this$0;

    RegistrationFragment$initCheckboxes$1(RegistrationFragment registrationFragment) {
        this.this$0 = registrationFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ((LinearLayout) this.this$0._$_findCachedViewById(R.Cif.registrationLayout)).requestFocus();
        BooleanField emailPreference = this.this$0.getRegistrationViewModel().getEmailPreference();
        if (emailPreference != null) {
            emailPreference.setValue(Boolean.valueOf(z));
        }
    }
}
