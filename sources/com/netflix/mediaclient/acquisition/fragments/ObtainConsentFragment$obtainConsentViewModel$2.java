package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.netflix.mediaclient.acquisition.viewmodels.ObtainConsentViewModel;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class ObtainConsentFragment$obtainConsentViewModel$2 extends Lambda implements AbstractC1449Fj<ObtainConsentViewModel> {
    final /* synthetic */ ObtainConsentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ObtainConsentFragment$obtainConsentViewModel$2(ObtainConsentFragment obtainConsentFragment) {
        super(0);
        this.this$0 = obtainConsentFragment;
    }

    @Override // o.AbstractC1449Fj
    public final ObtainConsentViewModel invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (ObtainConsentViewModel) ViewModelProviders.of(activity).get(ObtainConsentViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
