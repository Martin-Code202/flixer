package com.netflix.mediaclient.acquisition.util;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import o.AbstractC1113;
import o.AbstractC1451Fl;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class AUIMoneyballUtilitiesKt$sam$MoneyballAgentWebCallback$58373d51 implements AbstractC1113 {
    private final /* synthetic */ AbstractC1451Fl function;

    AUIMoneyballUtilitiesKt$sam$MoneyballAgentWebCallback$58373d51(AbstractC1451Fl fl) {
        this.function = fl;
    }

    @Override // o.AbstractC1113
    public final /* synthetic */ void onDataFetched(MoneyballData moneyballData, Status status) {
        C1457Fr.m5016(this.function.invoke(moneyballData, status), "invoke(...)");
    }
}
