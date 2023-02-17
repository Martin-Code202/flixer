package com.netflix.mediaclient.ui.feeds;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.rR;
public final class TrailersFeedFragment$trailersFeedViewModel$2 extends Lambda implements AbstractC1449Fj<TrailersFeedViewModel> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ rR f3073;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedFragment$trailersFeedViewModel$2(rR rRVar) {
        super(0);
        this.f3073 = rRVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final TrailersFeedViewModel invoke() {
        FragmentActivity activity = this.f3073.getActivity();
        if (activity != null) {
            return (TrailersFeedViewModel) ViewModelProviders.of(activity).get(TrailersFeedViewModel.class);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    }
}
