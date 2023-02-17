package io.reactivex.rxkotlin;

import io.reactivex.functions.Action;
import o.AbstractC1449Fj;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class SubscribersKt$sam$Action$fd62537c implements Action {
    private final /* synthetic */ AbstractC1449Fj function;

    SubscribersKt$sam$Action$fd62537c(AbstractC1449Fj fj) {
        this.function = fj;
    }

    @Override // io.reactivex.functions.Action
    public final /* synthetic */ void run() {
        C1457Fr.m5016(this.function.invoke(), "invoke(...)");
    }
}
