package com.netflix.mediaclient.acquisition.fragments;

import java.util.List;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C0738;
import o.EA;
import o.EI;
/* access modifiers changed from: package-private */
public final class StartMembershipOnContextFragment$purchaseResponseHandler$1 extends Lambda implements AbstractC1451Fl<Integer, List<? extends C0738>, EA> {
    final /* synthetic */ StartMembershipOnContextFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StartMembershipOnContextFragment$purchaseResponseHandler$1(StartMembershipOnContextFragment startMembershipOnContextFragment) {
        super(2);
        this.this$0 = startMembershipOnContextFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* synthetic */ EA invoke(Integer num, List<? extends C0738> list) {
        invoke(num.intValue(), list);
        return EA.f5503;
    }

    public final void invoke(int i, List<? extends C0738> list) {
        this.this$0.getStartMembershipModel().isLoading().setValue(false);
        if (i == 0) {
            if ((list != null ? (C0738) EI.m4828((List<? extends Object>) list) : null) != null) {
                this.this$0.handlePurchase((C0738) EI.m4833((List<? extends Object>) list));
                return;
            }
        }
        if (i == 1) {
            this.this$0.handleUserCancel();
        } else if (i == 7) {
            this.this$0.handleRestorePurchase();
        } else {
            this.this$0.handleGooglePlayError(i);
        }
    }
}
