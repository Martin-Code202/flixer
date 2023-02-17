package com.netflix.mediaclient.acquisition;

import com.netflix.mediaclient.android.app.Status;
import o.C1283;
import o.C1317As;
import o.C1457Fr;
import o.C2059ph;
import o.oV;
public final class SignupNativeActivity$createManagerStatusListener$1 implements oV {
    final /* synthetic */ SignupNativeActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SignupNativeActivity$createManagerStatusListener$1(SignupNativeActivity signupNativeActivity) {
        this.this$0 = signupNativeActivity;
    }

    @Override // o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        C1457Fr.m5025(phVar, "svcManager");
        C1457Fr.m5025(status, "res");
        this.this$0.updateCurrentAppLocale(phVar);
        if (!C1317As.m3750(this.this$0)) {
            this.this$0.startNavigation();
        }
    }

    @Override // o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
        C1457Fr.m5025(status, "res");
        if (!C1317As.m3750(this.this$0)) {
            C1283.m16850(SignupNativeActivity.Companion.getTAG(), "NetflixService is NOT available!");
        }
    }
}
