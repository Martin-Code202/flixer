package com.netflix.mediaclient.ui.feeds;

import android.arch.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.rU;
public final class TrailersFeedActivity$trailersFeedViewModel$2 extends Lambda implements AbstractC1449Fj<TrailersFeedViewModel> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ rU f3071;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedActivity$trailersFeedViewModel$2(rU rUVar) {
        super(0);
        this.f3071 = rUVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final TrailersFeedViewModel invoke() {
        return (TrailersFeedViewModel) ViewModelProviders.of(this.f3071).get(TrailersFeedViewModel.class);
    }
}
