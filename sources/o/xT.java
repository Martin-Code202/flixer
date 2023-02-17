package o;

import com.netflix.mediaclient.ui.player.PostPlay;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPostPlayUIPresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPostPlayUIPresenter$3;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPostPlayUIPresenter$4;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPostPlayUIPresenter$5;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPostPlayUIPresenter$6;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
public final class xT {

    /* renamed from: ˊ  reason: contains not printable characters */
    private PostPlay f12088;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f12089;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC2348ym f12090;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f12091;

    public xT(AbstractC2348ym ymVar, Observable<xH> observable, Observable<EA> observable2) {
        C1457Fr.m5025(ymVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12090 = ymVar;
        Observable<xH> take = observable.takeUntil(observable2).filter(AnonymousClass4.f12092).take(1);
        C1457Fr.m5016((Object) take, "playerStateEventObservab…\n                .take(1)");
        SubscribersKt.subscribeBy$default(take, PlayerPostPlayUIPresenter$3.f3754, null, new PlayerPostPlayUIPresenter$2(this), 2, null);
        Observable<xH> takeUntil = observable.takeUntil(observable2);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy(takeUntil, new PlayerPostPlayUIPresenter$5(this), new PlayerPostPlayUIPresenter$6(this), new PlayerPostPlayUIPresenter$4(this));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final boolean m12842() {
        return this.f12091;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m12844(boolean z) {
        this.f12091 = z;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m12843(boolean z) {
        this.f12089 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final boolean m12845() {
        return this.f12089;
    }
}
