package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import o.AbstractC1449Fj;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
public final class SubscribersKt {
    private static final AbstractC1449Fj<EA> onCompleteStub = SubscribersKt$onCompleteStub$1.INSTANCE;
    private static final AbstractC1450Fk<Throwable, EA> onErrorStub = SubscribersKt$onErrorStub$1.INSTANCE;
    private static final AbstractC1450Fk<Object, EA> onNextStub = SubscribersKt$onNextStub$1.INSTANCE;

    public static /* synthetic */ Disposable subscribeBy$default(Observable observable, AbstractC1450Fk fk, AbstractC1449Fj fj, AbstractC1450Fk fk2, int i, Object obj) {
        if ((i & 1) != 0) {
            fk = onErrorStub;
        }
        if ((i & 2) != 0) {
            fj = onCompleteStub;
        }
        if ((i & 4) != 0) {
            fk2 = onNextStub;
        }
        return subscribeBy(observable, fk, fj, fk2);
    }

    public static final <T> Disposable subscribeBy(Observable<T> observable, AbstractC1450Fk<? super Throwable, EA> fk, AbstractC1449Fj<EA> fj, AbstractC1450Fk<? super T, EA> fk2) {
        C1457Fr.m5025(observable, "$receiver");
        C1457Fr.m5025(fk, "onError");
        C1457Fr.m5025(fj, "onComplete");
        C1457Fr.m5025(fk2, "onNext");
        Disposable subscribe = observable.subscribe(new SubscribersKt$sam$Consumer$2b2a3ebc(fk2), new SubscribersKt$sam$Consumer$2b2a3ebc(fk), new SubscribersKt$sam$Action$fd62537c(fj));
        C1457Fr.m5016((Object) subscribe, "subscribe(onNext, onError, onComplete)");
        return subscribe;
    }

    public static final <T> Disposable subscribeBy(Single<T> single, AbstractC1450Fk<? super Throwable, EA> fk, AbstractC1450Fk<? super T, EA> fk2) {
        C1457Fr.m5025(single, "$receiver");
        C1457Fr.m5025(fk, "onError");
        C1457Fr.m5025(fk2, "onSuccess");
        Disposable subscribe = single.subscribe(new SubscribersKt$sam$Consumer$2b2a3ebc(fk2), new SubscribersKt$sam$Consumer$2b2a3ebc(fk));
        C1457Fr.m5016((Object) subscribe, "subscribe(onSuccess, onError)");
        return subscribe;
    }
}
