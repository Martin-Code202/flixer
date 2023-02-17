package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.RegistrationViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class RegistrationFragment$registrationViewModel$2 extends Lambda implements AbstractC1449Fj<RegistrationViewModel> {
    final /* synthetic */ RegistrationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegistrationFragment$registrationViewModel$2(RegistrationFragment registrationFragment) {
        super(0);
        this.this$0 = registrationFragment;
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
