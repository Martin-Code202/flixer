package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.RegistrationViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class RegistrationContextFragment$registrationModel$2 extends Lambda implements AbstractC1449Fj<RegistrationViewModel> {
    final /* synthetic */ RegistrationContextFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegistrationContextFragment$registrationModel$2(RegistrationContextFragment registrationContextFragment) {
        super(0);
        this.this$0 = registrationContextFragment;
    }

    @Override // o.AbstractC1449Fj
    public final RegistrationViewModel invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (RegistrationViewModel) ViewModelProviders.of(activity).get(RegistrationViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
