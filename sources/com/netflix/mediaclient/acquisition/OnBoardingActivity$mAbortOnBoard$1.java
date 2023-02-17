package com.netflix.mediaclient.acquisition;

import com.netflix.mediaclient.acquisition.OnBoardingActivity;
import o.C1283;
final class OnBoardingActivity$mAbortOnBoard$1 implements Runnable {
    final /* synthetic */ OnBoardingActivity this$0;

    OnBoardingActivity$mAbortOnBoard$1(OnBoardingActivity onBoardingActivity) {
        this.this$0 = onBoardingActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1283.m16854(OnBoardingActivity.Companion.access$getTAG$p(OnBoardingActivity.Companion), "Timeout triggered");
        if (!OnBoardingActivity.access$getOnLoadedBeenCalled$p(this.this$0) && !this.this$0.isFinishing()) {
            this.this$0.finish();
        }
    }
}
