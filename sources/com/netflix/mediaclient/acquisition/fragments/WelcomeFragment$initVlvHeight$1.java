package com.netflix.mediaclient.acquisition.fragments;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import o.AD;
import o.C0522;
import o.C1457Fr;
public final class WelcomeFragment$initVlvHeight$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ WelcomeFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    WelcomeFragment$initVlvHeight$1(WelcomeFragment welcomeFragment) {
        this.this$0 = welcomeFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(R.Cif.vlvInfoGroup);
        C1457Fr.m5016((Object) linearLayout, "vlvInfoGroup");
        ViewTreeObserver viewTreeObserver = linearLayout.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
        SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
        if (signupActivity != null) {
            View findViewById = signupActivity.getWindow().findViewById(16908290);
            C1457Fr.m5016((Object) findViewById, "it.window.findViewById<V…indow.ID_ANDROID_CONTENT)");
            int height = (findViewById.getHeight() - signupActivity.getActionBarHeight()) - ((int) this.this$0.getResources().getDimension(R.dimen.signup_welcome_tab_peak_height));
            if (AD.m3306(signupActivity)) {
                LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(R.Cif.vlvInfoGroup);
                C1457Fr.m5016((Object) linearLayout2, "vlvInfoGroup");
                height -= (int) (((float) linearLayout2.getHeight()) + this.this$0.getResources().getDimension(R.dimen.signup_welcome_tab_bar_top_margin));
            }
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, height);
            C0522 r0 = (C0522) this.this$0._$_findCachedViewById(R.Cif.vlvImageView);
            C1457Fr.m5016((Object) r0, "vlvImageView");
            r0.setLayoutParams(layoutParams);
            this.this$0.loadVlvImageUrl(this.this$0.getWelcomeModel().getVlvImageUrl(signupActivity));
        }
    }
}
