package com.netflix.mediaclient.acquisition.fragments;

import android.graphics.Bitmap;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import o.AbstractC0957;
import o.C1457Fr;
public final class WelcomeFragment$loadVlVImageUrl$1$run$imageHelperListener$1 implements AbstractC0957 {
    final /* synthetic */ WelcomeFragment$loadVlVImageUrl$1 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    WelcomeFragment$loadVlVImageUrl$1$run$imageHelperListener$1(WelcomeFragment$loadVlVImageUrl$1 welcomeFragment$loadVlVImageUrl$1) {
        this.this$0 = welcomeFragment$loadVlVImageUrl$1;
    }

    @Override // o.AbstractC0957
    public void onResponse(Bitmap bitmap, String str) {
        SignupNativeActivity signupActivity;
        this.this$0.$imageView.setImageBitmap(bitmap);
        if (bitmap != null && C1457Fr.m5018((Object) this.this$0.$description, (Object) "vlvImage") && (signupActivity = this.this$0.this$0.getSignupActivity()) != null) {
            signupActivity.endRenderNavigationLevelLogging();
        }
    }

    @Override // o.AbstractC0957
    public void onErrorResponse(String str) {
    }
}
