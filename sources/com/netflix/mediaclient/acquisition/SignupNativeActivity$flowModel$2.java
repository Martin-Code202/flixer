package com.netflix.mediaclient.acquisition;

import android.arch.lifecycle.ViewModelProviders;
import com.netflix.mediaclient.acquisition.viewmodels.SignupViewModel;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class SignupNativeActivity$flowModel$2 extends Lambda implements AbstractC1449Fj<SignupViewModel> {
    final /* synthetic */ SignupNativeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignupNativeActivity$flowModel$2(SignupNativeActivity signupNativeActivity) {
        super(0);
        this.this$0 = signupNativeActivity;
    }

    @Override // o.AbstractC1449Fj
    public final SignupViewModel invoke() {
        return (SignupViewModel) ViewModelProviders.of(this.this$0).get(SignupViewModel.class);
    }
}
