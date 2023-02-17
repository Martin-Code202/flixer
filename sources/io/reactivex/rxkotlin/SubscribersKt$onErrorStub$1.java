package io.reactivex.rxkotlin;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
final class SubscribersKt$onErrorStub$1 extends Lambda implements AbstractC1450Fk<Throwable, EA> {
    public static final SubscribersKt$onErrorStub$1 INSTANCE = new SubscribersKt$onErrorStub$1();

    SubscribersKt$onErrorStub$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* bridge */ /* synthetic */ EA invoke(Throwable th) {
        invoke(th);
        return EA.f5503;
    }

    public final void invoke(Throwable th) {
        C1457Fr.m5025(th, "it");
        throw new OnErrorNotImplementedException(th);
    }
}
