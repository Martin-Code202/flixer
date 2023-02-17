package com.netflix.mediaclient.acquisition.viewmodels;

import java.util.List;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
final class WelcomeSlidingDoorsViewModel$cards$2 extends Lambda implements AbstractC1449Fj<List<? extends SlidingDoorsTitleCard>> {
    final /* synthetic */ WelcomeSlidingDoorsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WelcomeSlidingDoorsViewModel$cards$2(WelcomeSlidingDoorsViewModel welcomeSlidingDoorsViewModel) {
        super(0);
        this.this$0 = welcomeSlidingDoorsViewModel;
    }

    /* Return type fixed from 'java.util.List<com.netflix.mediaclient.acquisition.viewmodels.SlidingDoorsTitleCard>' to match base method */
    @Override // o.AbstractC1449Fj
    public final List<? extends SlidingDoorsTitleCard> invoke() {
        return WelcomeSlidingDoorsViewModel.Companion.cardsFromFlowMode(this.this$0.getFlowMode());
    }
}
