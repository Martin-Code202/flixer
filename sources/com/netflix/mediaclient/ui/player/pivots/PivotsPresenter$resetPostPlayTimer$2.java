package com.netflix.mediaclient.ui.player.pivots;

import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.ui.player.pivots.PivotsUIView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C2322xq;
import o.EA;
public final class PivotsPresenter$resetPostPlayTimer$2 extends Lambda implements AbstractC1450Fk<IPlayerFragment.PublisherEvents, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ C2322xq f3674;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PivotsPresenter$resetPostPlayTimer$2(C2322xq xqVar) {
        super(1);
        this.f3674 = xqVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(IPlayerFragment.PublisherEvents publisherEvents) {
        m2609(publisherEvents);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2609(IPlayerFragment.PublisherEvents publisherEvents) {
        Disposable disposable = this.f3674.f12244;
        if (disposable != null) {
            disposable.dispose();
        }
        C2322xq xqVar = this.f3674;
        Observable<Long> take = Observable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).take(11);
        C1457Fr.m5016((Object) take, "Observable\n             …    .take(startTimer + 1)");
        xqVar.f12244 = SubscribersKt.subscribeBy$default(take, null, new AbstractC1449Fj<EA>(this) { // from class: com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$resetPostPlayTimer$2.2

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ PivotsPresenter$resetPostPlayTimer$2 f3677;

            {
                this.f3677 = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // o.AbstractC1449Fj
            public /* synthetic */ EA invoke() {
                m2611();
                return EA.f5503;
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public final void m2611() {
                this.f3677.f3674.m12968();
            }
        }, new AbstractC1450Fk<Long, EA>(this, 10) { // from class: com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$resetPostPlayTimer$2.1

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ PivotsPresenter$resetPostPlayTimer$2 f3675;

            {
                this.f3675 = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // o.AbstractC1450Fk
            public /* synthetic */ EA invoke(Long l) {
                m2610(l);
                return EA.f5503;
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m2610(Long l) {
                this.f3675.f3674.m12985().mo2229();
                C2322xq xqVar2 = this.f3675.f3674;
                C2322xq xqVar3 = this.f3675.f3674;
                PivotsUIView.PivotsListVisibility pivotsListVisibility = PivotsUIView.PivotsListVisibility.SHOW;
                long j = 10;
                C1457Fr.m5016((Object) l, "it");
                xqVar2.m14156(C2322xq.m12977(xqVar3, false, pivotsListVisibility, false, false, null, null, null, (int) (j - l.longValue()), false, 373, null), l);
            }
        }, 1, null);
    }
}
