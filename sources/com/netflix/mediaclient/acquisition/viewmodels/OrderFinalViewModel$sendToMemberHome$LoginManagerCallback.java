package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.mediaclient.android.app.Status;
import o.AbstractC1449Fj;
import o.AbstractC2061pj;
public final class OrderFinalViewModel$sendToMemberHome$LoginManagerCallback extends AbstractC2061pj {
    final /* synthetic */ AbstractC1449Fj $completion;

    public OrderFinalViewModel$sendToMemberHome$LoginManagerCallback(AbstractC1449Fj fj) {
        this.$completion = fj;
    }

    @Override // o.AbstractC2061pj, o.oU
    public void onLoginComplete(Status status) {
        this.$completion.invoke();
    }
}
