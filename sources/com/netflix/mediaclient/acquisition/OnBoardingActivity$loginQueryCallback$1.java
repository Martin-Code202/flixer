package com.netflix.mediaclient.acquisition;

import com.netflix.mediaclient.android.app.Status;
import o.AbstractC2061pj;
import o.C1457Fr;
public final class OnBoardingActivity$loginQueryCallback$1 extends AbstractC2061pj {
    final /* synthetic */ OnBoardingActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    OnBoardingActivity$loginQueryCallback$1(OnBoardingActivity onBoardingActivity) {
        this.this$0 = onBoardingActivity;
    }

    @Override // o.AbstractC2061pj, o.oU
    public void onLoginComplete(Status status) {
        C1457Fr.m5025(status, "res");
        this.this$0.runOnUiThread(new OnBoardingActivity$loginQueryCallback$1$onLoginComplete$1(this, status));
    }
}
