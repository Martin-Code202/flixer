package com.netflix.mediaclient.acquisition;

import android.content.DialogInterface;
import com.netflix.mediaclient.NetflixApplication;
/* access modifiers changed from: package-private */
public final class SignupNativeActivity$showError$dialogBuilder$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ SignupNativeActivity this$0;

    SignupNativeActivity$showError$dialogBuilder$1(SignupNativeActivity signupNativeActivity) {
        this.this$0 = signupNativeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.startActivity(NetflixApplication.m219(this.this$0));
        dialogInterface.dismiss();
        this.this$0.finish();
    }
}
