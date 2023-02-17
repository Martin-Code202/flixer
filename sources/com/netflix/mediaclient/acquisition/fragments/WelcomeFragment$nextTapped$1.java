package com.netflix.mediaclient.acquisition.fragments;

import java.util.List;
import kotlin.jvm.internal.FunctionReference;
import o.AbstractC1451Fl;
import o.C0738;
import o.C1461Fv;
import o.EA;
import o.FO;
/* access modifiers changed from: package-private */
public final class WelcomeFragment$nextTapped$1 extends FunctionReference implements AbstractC1451Fl<Integer, List<? extends C0738>, EA> {
    WelcomeFragment$nextTapped$1(WelcomeFragment welcomeFragment) {
        super(2, welcomeFragment);
    }

    @Override // kotlin.jvm.internal.CallableReference, o.FL
    public final String getName() {
        return "handleRestore";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final FO getOwner() {
        return C1461Fv.m5035(WelcomeFragment.class);
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
        ((WelcomeFragment) this.receiver).handleRestore(i, list);
    }
}
