package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.WelcomeViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class WelcomeFragment$welcomeModel$2 extends Lambda implements AbstractC1449Fj<WelcomeViewModel> {
    final /* synthetic */ WelcomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WelcomeFragment$welcomeModel$2(WelcomeFragment welcomeFragment) {
        super(0);
        this.this$0 = welcomeFragment;
    }

    @Override // o.AbstractC1449Fj
    public final WelcomeViewModel invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (WelcomeViewModel) ViewModelProviders.of(activity).get(WelcomeViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
