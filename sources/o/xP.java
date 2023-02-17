package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerLoadingSpinnerPresenter$1;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerLoadingSpinnerPresenter$2;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
public final class xP {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC2344yi f12077;

    public xP(AbstractC2344yi yiVar, Observable<xH> observable, Observable<EA> observable2) {
        C1457Fr.m5025(yiVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12077 = yiVar;
        Observable<xH> takeUntil = observable.takeUntil(observable2);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy$default(takeUntil, PlayerLoadingSpinnerPresenter$2.f3750, null, new PlayerLoadingSpinnerPresenter$1(this), 2, null);
    }
}
