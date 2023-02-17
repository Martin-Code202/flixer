package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerWatermarkPresenter$1;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerWatermarkPresenter$2;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
public final class xZ {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC2352yq f12116;

    public xZ(AbstractC2352yq yqVar, Observable<xH> observable, Observable<EA> observable2) {
        C1457Fr.m5025(yqVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12116 = yqVar;
        Observable<xH> takeUntil = observable.takeUntil(observable2);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy$default(takeUntil, PlayerWatermarkPresenter$2.f3802, null, new PlayerWatermarkPresenter$1(this), 2, null);
    }
}
