package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTouchAwarePresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTouchAwarePresenter$3;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTouchAwarePresenter$5;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTouchAwarePresenter$6;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
/* renamed from: o.yc  reason: case insensitive filesystem */
public class C2338yc {
    public C2338yc(AbstractC2351yp ypVar, Observable<xH> observable, Observable<EA> observable2) {
        C1457Fr.m5025(ypVar, "uiView");
        C1457Fr.m5025(observable, "playerTouchEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        Observable<xH> filter = observable.takeUntil(observable2).filter(AnonymousClass5.f12489);
        C1457Fr.m5016((Object) filter, "playerTouchEventObservab…vent.PlayerShowPostPlay }");
        SubscribersKt.subscribeBy$default(filter, PlayerTouchAwarePresenter$3.f3798, null, new PlayerTouchAwarePresenter$2(ypVar), 2, null);
        Observable<xH> filter2 = observable.takeUntil(observable2).filter(AnonymousClass3.f12488);
        C1457Fr.m5016((Object) filter2, "playerTouchEventObservab…lsOnTap\n                }");
        SubscribersKt.subscribeBy$default(filter2, PlayerTouchAwarePresenter$6.f3800, null, new PlayerTouchAwarePresenter$5(ypVar), 2, null);
    }
}
