package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.PhoneCodesData;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C1457Fr;
import o.EA;
/* access modifiers changed from: package-private */
public final class OrderFinalFragment$fetchCountryData$1 extends Lambda implements AbstractC1451Fl<PhoneCodesData, Status, EA> {
    final /* synthetic */ OrderFinalFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderFinalFragment$fetchCountryData$1(OrderFinalFragment orderFinalFragment) {
        super(2);
        this.this$0 = orderFinalFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* bridge */ /* synthetic */ EA invoke(PhoneCodesData phoneCodesData, Status status) {
        invoke(phoneCodesData, status);
        return EA.f5503;
    }

    public final void invoke(PhoneCodesData phoneCodesData, Status status) {
        C1457Fr.m5025(status, "<anonymous parameter 1>");
        this.this$0.getOrderFinalViewModel().setPhoneCodesData(phoneCodesData);
    }
}
