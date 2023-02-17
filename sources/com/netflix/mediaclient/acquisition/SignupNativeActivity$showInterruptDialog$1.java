package com.netflix.mediaclient.acquisition;

import android.content.DialogInterface;
/* access modifiers changed from: package-private */
public final class SignupNativeActivity$showInterruptDialog$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ SignupNativeActivity this$0;

    SignupNativeActivity$showInterruptDialog$1(SignupNativeActivity signupNativeActivity) {
        this.this$0 = signupNativeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.fetchMode("welcome");
    }
}
