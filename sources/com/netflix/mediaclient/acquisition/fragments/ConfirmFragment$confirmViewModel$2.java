package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.ConfirmViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class ConfirmFragment$confirmViewModel$2 extends Lambda implements AbstractC1449Fj<ConfirmViewModel> {
    final /* synthetic */ ConfirmFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConfirmFragment$confirmViewModel$2(ConfirmFragment confirmFragment) {
        super(0);
        this.this$0 = confirmFragment;
    }

    @Override // o.AbstractC1449Fj
    public final ConfirmViewModel invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (ConfirmViewModel) ViewModelProviders.of(activity).get(ConfirmViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
