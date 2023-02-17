package com.netflix.mediaclient.acquisition.fragments;

import android.widget.CompoundButton;
import com.netflix.android.moneyball.fields.BooleanField;
/* access modifiers changed from: package-private */
public final class ObtainConsentFragment$initClickHandlers$5 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ObtainConsentFragment this$0;

    ObtainConsentFragment$initClickHandlers$5(ObtainConsentFragment obtainConsentFragment) {
        this.this$0 = obtainConsentFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        BooleanField emailConsent = this.this$0.getObtainConsentViewModel().getEmailConsent();
        if (emailConsent != null) {
            emailConsent.setValue(Boolean.valueOf(z));
        }
    }
}
