package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSecondaryControlsPresenter$1;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSecondaryControlsPresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSecondaryControlsPresenter$4;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSecondaryControlsPresenter$5;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
import o.xE;
public final class xR extends C2338yc {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC2347yl f12079;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f12080;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xR(AbstractC2347yl ylVar, Observable<xH> observable, xE xEVar, Observable<EA> observable2) {
        super(ylVar, observable, observable2);
        C1457Fr.m5025(ylVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(xEVar, "playerRepository");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12079 = ylVar;
        Observable<xH> takeUntil = observable.takeUntil(observable2);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy$default(takeUntil, new PlayerSecondaryControlsPresenter$2(this), null, new PlayerSecondaryControlsPresenter$1(this), 2, null);
        Observable<xE.If> filter = xEVar.m12746().takeUntil(observable2).filter(AnonymousClass1.f12081);
        C1457Fr.m5016((Object) filter, "playerRepository.getObse…it.videoDetails != null }");
        SubscribersKt.subscribeBy$default(filter, new PlayerSecondaryControlsPresenter$5(this), null, new PlayerSecondaryControlsPresenter$4(this), 2, null);
    }
}
