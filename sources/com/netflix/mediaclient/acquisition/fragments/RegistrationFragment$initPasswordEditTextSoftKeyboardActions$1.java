package com.netflix.mediaclient.acquisition.fragments;

import android.view.KeyEvent;
import android.widget.TextView;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.util.AUIKeyboardUtilities;
/* access modifiers changed from: package-private */
public final class RegistrationFragment$initPasswordEditTextSoftKeyboardActions$1 implements TextView.OnEditorActionListener {
    final /* synthetic */ RegistrationFragment this$0;

    RegistrationFragment$initPasswordEditTextSoftKeyboardActions$1(RegistrationFragment registrationFragment) {
        this.this$0 = registrationFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            this.this$0.handleSubmitForm();
            return true;
        }
        SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
        if (signupActivity == null) {
            return true;
        }
        AUIKeyboardUtilities.INSTANCE.dismissKeyboard(signupActivity);
        return true;
    }
}
