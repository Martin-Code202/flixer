package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.WarnUserViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class WarnUserFragment$warnUserViewModel$2 extends Lambda implements AbstractC1449Fj<WarnUserViewModel> {
    final /* synthetic */ WarnUserFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WarnUserFragment$warnUserViewModel$2(WarnUserFragment warnUserFragment) {
        super(0);
        this.this$0 = warnUserFragment;
    }

    @Override // o.AbstractC1449Fj
    public final WarnUserViewModel invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (WarnUserViewModel) ViewModelProviders.of(activity).get(WarnUserViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
