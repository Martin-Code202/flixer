package com.netflix.mediaclient.acquisition;

import com.netflix.mediaclient.android.app.Status;
import o.AbstractC2061pj;
import o.ActivityC2383zq;
public final class SignupNativeActivity$launchProfilesGate$MemberHomeCallback extends AbstractC2061pj {
    final /* synthetic */ SignupNativeActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public SignupNativeActivity$launchProfilesGate$MemberHomeCallback(SignupNativeActivity signupNativeActivity) {
        this.this$0 = signupNativeActivity;
    }

    @Override // o.AbstractC2061pj, o.oU
    public void onLoginComplete(Status status) {
        this.this$0.setLoggingIn(false);
        if (status != null && status.mo298()) {
            this.this$0.startActivity(ActivityC2383zq.m13737(this.this$0));
        }
        this.this$0.finish();
    }
}
