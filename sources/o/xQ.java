package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerNavigationControlsPresenter$1;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerNavigationControlsPresenter$2;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
public final class xQ extends C2338yc {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC2346yk f12078;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xQ(AbstractC2346yk ykVar, Observable<xH> observable, Observable<EA> observable2) {
        super(ykVar, observable, observable2);
        C1457Fr.m5025(ykVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12078 = ykVar;
        Observable<xH> takeUntil = observable.takeUntil(observable2);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy$default(takeUntil, new PlayerNavigationControlsPresenter$2(this), null, new PlayerNavigationControlsPresenter$1(this), 2, null);
    }
}
