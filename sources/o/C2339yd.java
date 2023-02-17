package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTappablePresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTappablePresenter$3;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTappablePresenter$4;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTappablePresenter$5;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTappablePresenter$7;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTappablePresenter$8;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTappablePresenter$observeCreditMarksTakingOne$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerTappablePresenter$observeCreditMarksTakingOne$3;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
import o.xH;
/* renamed from: o.yd  reason: case insensitive filesystem */
public final class C2339yd {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Observable<xH> f12490;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f12491;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f12492;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f12493 = true;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f12494;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC2353yr f12495;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Observable<EA> f12496;

    public C2339yd(AbstractC2353yr yrVar, Observable<xH> observable, Observable<EA> observable2) {
        C1457Fr.m5025(yrVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12495 = yrVar;
        this.f12490 = observable;
        this.f12496 = observable2;
        Observable<xH> take = this.f12490.takeUntil(this.f12496).filter(AnonymousClass2.f12497).take(1);
        C1457Fr.m5016((Object) take, "playerStateEventObservab…\n                .take(1)");
        SubscribersKt.subscribeBy$default(take, PlayerTappablePresenter$3.f3790, null, new PlayerTappablePresenter$2(this), 2, null);
        Observable<xH> takeUntil = this.f12490.takeUntil(this.f12496);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy$default(takeUntil, PlayerTappablePresenter$5.f3792, null, new PlayerTappablePresenter$4(this), 2, null);
        Observable<xJ> skipWhile = this.f12495.mo13082().takeUntil(this.f12496).skipWhile(new Predicate<xJ>(this) { // from class: o.yd.4

            /* renamed from: ॱ  reason: contains not printable characters */
            final /* synthetic */ C2339yd f12498;

            {
                this.f12498 = r1;
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            public final boolean test(xJ xJVar) {
                C1457Fr.m5025(xJVar, "it");
                return this.f12498.m13326();
            }
        });
        C1457Fr.m5016((Object) skipWhile, "uiView.getUIEventsObserv….skipWhile({ isLoading })");
        SubscribersKt.subscribeBy$default(skipWhile, PlayerTappablePresenter$8.f3794, null, new PlayerTappablePresenter$7(this), 2, null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m13324(boolean z) {
        this.f12493 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final boolean m13326() {
        return this.f12493;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m13323(boolean z) {
        this.f12491 = z;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final boolean m13325() {
        return this.f12491;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m13320(boolean z) {
        this.f12494 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final boolean m13328() {
        return this.f12494;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final boolean m13321() {
        return this.f12492;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m13327(boolean z) {
        this.f12492 = z;
    }

    /* renamed from: o.yd$iF */
    static final class iF<T> implements Predicate<xH> {

        /* renamed from: ˎ  reason: contains not printable characters */
        public static final iF f12499 = new iF();

        iF() {
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final boolean test(xH xHVar) {
            C1457Fr.m5025(xHVar, "it");
            return C1457Fr.m5018(xHVar, xH.C2287AUx.f11975) || C1457Fr.m5018(xHVar, xH.C0262.f11994);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m13322() {
        Observable<xH> take = this.f12490.takeUntil(this.f12496).filter(iF.f12499).take(1);
        C1457Fr.m5016((Object) take, "playerStateEventObservab…\n                .take(1)");
        SubscribersKt.subscribeBy$default(take, PlayerTappablePresenter$observeCreditMarksTakingOne$3.f3796, null, new PlayerTappablePresenter$observeCreditMarksTakingOne$2(this), 2, null);
    }
}
