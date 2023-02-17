package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import o.AbstractC1113;
import o.AbstractC1451Fl;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class AbstractSignupViewModel$next$1 implements AbstractC1113 {
    final /* synthetic */ AbstractC1451Fl $completion;

    AbstractSignupViewModel$next$1(AbstractC1451Fl fl) {
        this.$completion = fl;
    }

    @Override // o.AbstractC1113
    public final void onDataFetched(MoneyballData moneyballData, Status status) {
        C1457Fr.m5025(status, "status");
        this.$completion.invoke(moneyballData, status);
    }
}
