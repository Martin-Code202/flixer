package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.util.DebugBillingManager;
import java.util.List;
import o.AbstractC1451Fl;
import o.C0738;
import o.C1461Fv;
import o.EA;
import o.FO;
final class WelcomeSlidingDoorsFragment$initLongClickListeners$1 implements View.OnLongClickListener {
    final /* synthetic */ WelcomeSlidingDoorsFragment this$0;

    WelcomeSlidingDoorsFragment$initLongClickListeners$1(WelcomeSlidingDoorsFragment welcomeSlidingDoorsFragment) {
        this.this$0 = welcomeSlidingDoorsFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        DebugBillingManager debugBillingManager;
        SignupNativeActivity signupActivity = this.this$0.getSignupActivity();
        if (signupActivity == null || (debugBillingManager = signupActivity.getDebugBillingManager()) == null) {
            return true;
        }
        debugBillingManager.restoreSubscription(new AbstractC1451Fl<Integer, List<? extends C0738>, EA>(this.this$0) { // from class: com.netflix.mediaclient.acquisition.fragments.WelcomeSlidingDoorsFragment$initLongClickListeners$1.1
            @Override // kotlin.jvm.internal.CallableReference, o.FL
            public final String getName() {
                return "handleRestore";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final FO getOwner() {
                return C1461Fv.m5035(WelcomeSlidingDoorsFragment.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final String getSignature() {
                return "handleRestore(ILjava/util/List;)V";
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // o.AbstractC1451Fl
            public /* synthetic */ EA invoke(Integer num, List<? extends C0738> list) {
                invoke(num.intValue(), list);
                return EA.f5503;
            }

            public final void invoke(int i, List<? extends C0738> list) {
                ((WelcomeSlidingDoorsFragment) this.receiver).handleRestore(i, list);
            }
        });
        return true;
    }
}
