package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.StartMembershipViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class StartMembershipOnContextFragment$startMembershipModel$2 extends Lambda implements AbstractC1449Fj<StartMembershipViewModel> {
    final /* synthetic */ StartMembershipOnContextFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StartMembershipOnContextFragment$startMembershipModel$2(StartMembershipOnContextFragment startMembershipOnContextFragment) {
        super(0);
        this.this$0 = startMembershipOnContextFragment;
    }

    @Override // o.AbstractC1449Fj
    public final StartMembershipViewModel invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (StartMembershipViewModel) ViewModelProviders.of(activity).get(StartMembershipViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
