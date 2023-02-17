package com.netflix.mediaclient.acquisition.fragments;

import kotlin.jvm.internal.FunctionReference;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C1461Fv;
import o.EA;
import o.FO;
/* access modifiers changed from: package-private */
public final class OrderFinalFragment$openCountrySelectionDialog$1$countrySelectorDialog$1 extends FunctionReference implements AbstractC1450Fk<String, EA> {
    OrderFinalFragment$openCountrySelectionDialog$1$countrySelectorDialog$1(OrderFinalFragment orderFinalFragment) {
        super(1, orderFinalFragment);
    }

    @Override // kotlin.jvm.internal.CallableReference, o.FL
    public final String getName() {
        return "updateCountryCode";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final FO getOwner() {
        return C1461Fv.m5035(OrderFinalFragment.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "updateCountryCode(Ljava/lang/String;)V";
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* bridge */ /* synthetic */ EA invoke(String str) {
        invoke(str);
        return EA.f5503;
    }

    public final void invoke(String str) {
        C1457Fr.m5025(str, "p1");
        ((OrderFinalFragment) this.receiver).updateCountryCode(str);
    }
}
