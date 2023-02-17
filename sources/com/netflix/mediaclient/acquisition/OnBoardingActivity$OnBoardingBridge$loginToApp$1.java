package com.netflix.mediaclient.acquisition;

import com.netflix.mediaclient.acquisition.OnBoardingActivity;
import o.C1283;
final class OnBoardingActivity$OnBoardingBridge$loginToApp$1 implements Runnable {
    final /* synthetic */ OnBoardingActivity.OnBoardingBridge this$0;

    OnBoardingActivity$OnBoardingBridge$loginToApp$1(OnBoardingActivity.OnBoardingBridge onBoardingBridge) {
        this.this$0 = onBoardingBridge;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1283.m16854(OnBoardingActivity.Companion.access$getTAG$p(OnBoardingActivity.Companion), "Disabling webview visibility");
        OnBoardingActivity.access$webViewVisibility(OnBoardingActivity.this, false);
    }
}
