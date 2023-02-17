package com.netflix.mediaclient.acquisition;

import android.arch.lifecycle.Observer;
/* access modifiers changed from: package-private */
public final class SignupNativeActivity$initSignupHeaderObserver$1<T> implements Observer<SignInButtonInHeaderType> {
    final /* synthetic */ SignupNativeActivity this$0;

    SignupNativeActivity$initSignupHeaderObserver$1(SignupNativeActivity signupNativeActivity) {
        this.this$0 = signupNativeActivity;
    }

    public final void onChanged(SignInButtonInHeaderType signInButtonInHeaderType) {
        this.this$0.invalidateOptionsMenu();
    }
}
