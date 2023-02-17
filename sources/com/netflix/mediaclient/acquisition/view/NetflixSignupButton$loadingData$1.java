package com.netflix.mediaclient.acquisition.view;

import android.arch.lifecycle.Observer;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class NetflixSignupButton$loadingData$1<T> implements Observer<Boolean> {
    final /* synthetic */ NetflixSignupButton this$0;

    NetflixSignupButton$loadingData$1(NetflixSignupButton netflixSignupButton) {
        this.this$0 = netflixSignupButton;
    }

    public final void onChanged(Boolean bool) {
        if (C1457Fr.m5018((Object) bool, (Object) true)) {
            this.this$0.showSpinner();
        } else {
            this.this$0.hideSpinner();
        }
    }
}
