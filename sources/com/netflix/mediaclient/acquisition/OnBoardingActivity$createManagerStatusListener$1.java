package com.netflix.mediaclient.acquisition;

import com.netflix.mediaclient.acquisition.OnBoardingActivity;
import com.netflix.mediaclient.android.app.Status;
import o.C1283;
import o.C1457Fr;
import o.C2059ph;
import o.oV;
import o.zH;
public final class OnBoardingActivity$createManagerStatusListener$1 implements oV {
    final /* synthetic */ OnBoardingActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    OnBoardingActivity$createManagerStatusListener$1(OnBoardingActivity onBoardingActivity) {
        this.this$0 = onBoardingActivity;
    }

    @Override // o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        C1457Fr.m5025(phVar, "svcManager");
        C1457Fr.m5025(status, "res");
        if (status.mo298()) {
            OnBoardingActivity.access$setMSignUpParams$p(this.this$0, phVar.m9786());
            OnBoardingActivity.access$setMUiBoot$p(this.this$0, new zH(phVar, OnBoardingActivity.Companion.access$getBOOT_URL$p(OnBoardingActivity.Companion), this.this$0.getDeviceLanguage(), true, OnBoardingActivity.access$getMSharedContextSessionUuid$p(this.this$0)));
            OnBoardingActivity.access$setViews(this.this$0, phVar, false);
            return;
        }
        this.this$0.finish();
    }

    @Override // o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
        C1457Fr.m5025(status, "res");
        C1283.m16850(OnBoardingActivity.Companion.access$getTAG$p(OnBoardingActivity.Companion), "NetflixService is NOT available!");
        this.this$0.finish();
    }
}
