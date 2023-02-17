package io.reactivex.rxkotlin;

import io.reactivex.functions.Consumer;
import o.AbstractC1450Fk;
import o.C1457Fr;
/* access modifiers changed from: package-private */
public final class SubscribersKt$sam$Consumer$2b2a3ebc implements Consumer {
    private final /* synthetic */ AbstractC1450Fk function;

    SubscribersKt$sam$Consumer$2b2a3ebc(AbstractC1450Fk fk) {
        this.function = fk;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(T t) {
        C1457Fr.m5016(this.function.invoke(t), "invoke(...)");
    }
}
