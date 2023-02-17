package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.WelcomeSlidingDoorsViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class WelcomeSlidingDoorsFragment$welcomeModel$2 extends Lambda implements AbstractC1449Fj<WelcomeSlidingDoorsViewModel> {
    final /* synthetic */ WelcomeSlidingDoorsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WelcomeSlidingDoorsFragment$welcomeModel$2(WelcomeSlidingDoorsFragment welcomeSlidingDoorsFragment) {
        super(0);
        this.this$0 = welcomeSlidingDoorsFragment;
    }

    @Override // o.AbstractC1449Fj
    public final WelcomeSlidingDoorsViewModel invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (WelcomeSlidingDoorsViewModel) ViewModelProviders.of(activity).get(WelcomeSlidingDoorsViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
