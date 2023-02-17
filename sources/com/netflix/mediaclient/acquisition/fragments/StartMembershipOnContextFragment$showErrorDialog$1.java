package com.netflix.mediaclient.acquisition.fragments;

import android.content.DialogInterface;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
/* access modifiers changed from: package-private */
public final class StartMembershipOnContextFragment$showErrorDialog$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ StartMembershipOnContextFragment this$0;

    StartMembershipOnContextFragment$showErrorDialog$1(StartMembershipOnContextFragment startMembershipOnContextFragment) {
        this.this$0 = startMembershipOnContextFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
        if (signupActivity != null) {
            signupActivity.fetchMode("welcome");
        }
    }
}
