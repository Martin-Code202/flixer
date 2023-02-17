package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSubtitlesUIPresenter$1;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSubtitlesUIPresenter$2;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
public final class xU {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC2354ys f12093;

    public xU(AbstractC2354ys ysVar, Observable<xH> observable, Observable<EA> observable2) {
        C1457Fr.m5025(ysVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12093 = ysVar;
        Observable<xH> takeUntil = observable.takeUntil(observable2);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy$default(takeUntil, PlayerSubtitlesUIPresenter$2.f3788, null, new PlayerSubtitlesUIPresenter$1(this), 2, null);
    }
}
