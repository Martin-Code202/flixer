package com.netflix.mediaclient.acquisition.fragments;

import android.view.View;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import o.C1080;
/* access modifiers changed from: package-private */
public final class OrderFinalFragment$initClickListeners$2 implements View.OnFocusChangeListener {
    final /* synthetic */ OrderFinalFragment this$0;

    OrderFinalFragment$initClickListeners$2(OrderFinalFragment orderFinalFragment) {
        this.this$0 = orderFinalFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.this$0.phoneInputFocusSessionId = Logger.INSTANCE.m142(new C1080(AppView.startMembershipOnContext, null));
        } else if (this.this$0.phoneInputFocusSessionId != null) {
            Logger.INSTANCE.m140(this.this$0.phoneInputFocusSessionId);
            this.this$0.phoneInputFocusSessionId = null;
        }
    }
}
