package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import com.netflix.mediaclient.service.webclient.model.leafs.TermsOfUseData;
import o.AbstractC1113;
import o.AbstractC1451Fl;
import o.C1457Fr;
final class AbstractSignupViewModel$fetchTermsOfUse$1 implements AbstractC1113 {
    final /* synthetic */ AbstractC1451Fl $completion;

    AbstractSignupViewModel$fetchTermsOfUse$1(AbstractC1451Fl fl) {
        this.$completion = fl;
    }

    @Override // o.AbstractC1113
    public final void onDataFetched(MoneyballData moneyballData, Status status) {
        AbstractC1451Fl fl = this.$completion;
        TermsOfUseData termsOfUseData = moneyballData != null ? moneyballData.getTermsOfUseData() : null;
        C1457Fr.m5016((Object) status, "res");
        fl.invoke(termsOfUseData, status);
    }
}
