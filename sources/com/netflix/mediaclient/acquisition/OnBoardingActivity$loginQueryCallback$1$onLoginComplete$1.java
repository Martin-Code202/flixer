package com.netflix.mediaclient.acquisition;

import com.netflix.mediaclient.android.app.Status;
final class OnBoardingActivity$loginQueryCallback$1$onLoginComplete$1 implements Runnable {
    final /* synthetic */ Status $res;
    final /* synthetic */ OnBoardingActivity$loginQueryCallback$1 this$0;

    OnBoardingActivity$loginQueryCallback$1$onLoginComplete$1(OnBoardingActivity$loginQueryCallback$1 onBoardingActivity$loginQueryCallback$1, Status status) {
        this.this$0 = onBoardingActivity$loginQueryCallback$1;
        this.$res = status;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.this$0.handleLoginComplete(this.$res);
    }
}
