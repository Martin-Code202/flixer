package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import kotlin.jvm.internal.FunctionReference;
import o.AbstractC1451Fl;
import o.C1457Fr;
import o.C1461Fv;
import o.EA;
import o.FO;
/* access modifiers changed from: package-private */
public final class RegistrationFragment$handleSubmitForm$1$1 extends FunctionReference implements AbstractC1451Fl<MoneyballData, Status, EA> {
    RegistrationFragment$handleSubmitForm$1$1(RegistrationFragment registrationFragment) {
        super(2, registrationFragment);
    }

    @Override // kotlin.jvm.internal.CallableReference, o.FL
    public final String getName() {
        return "handleMoneyballResponse";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final FO getOwner() {
        return C1461Fv.m5035(RegistrationFragment.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "handleMoneyballResponse(Lcom/netflix/mediaclient/service/webclient/model/leafs/MoneyballData;Lcom/netflix/mediaclient/android/app/Status;)V";
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* bridge */ /* synthetic */ EA invoke(MoneyballData moneyballData, Status status) {
        invoke(moneyballData, status);
        return EA.f5503;
    }

    public final void invoke(MoneyballData moneyballData, Status status) {
        C1457Fr.m5025(status, "p2");
        ((RegistrationFragment) this.receiver).handleMoneyballResponse(moneyballData, status);
    }
}
