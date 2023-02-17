package com.netflix.mediaclient.ui.player.v2.presenter;

import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1283;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xM;
public final class PlayerInterrupterUIPresenter$2 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ Observable f3739;

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ xM f3740;

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ Observable f3741;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerInterrupterUIPresenter$2(xM xMVar, Observable observable, Observable observable2) {
        super(1);
        this.f3740 = xMVar;
        this.f3741 = observable;
        this.f3739 = observable2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2672(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m2672(xH xHVar) {
        C1283.m16854(xM.f12043.m12803(), "Inside PlayerPrepareInterrupter - Time to prepare interrupter display observable");
        if (!(this.f3740.f12049)) {
            C1283.m16854(xM.f12043.m12803(), "Time to show the interrupter");
            this.f3740.f12046.mo13333();
            return;
        }
        Observable take = this.f3741.takeUntil(Observable.merge(this.f3740.f12048, this.f3739)).filter(AnonymousClass4.f3744).take(1);
        C1457Fr.m5016((Object) take, "playerStateEventObservab…                 .take(1)");
        SubscribersKt.subscribeBy$default(take, AnonymousClass3.f3743, null, new AbstractC1450Fk<xH, EA>(this) { // from class: com.netflix.mediaclient.ui.player.v2.presenter.PlayerInterrupterUIPresenter$2.2

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ PlayerInterrupterUIPresenter$2 f3742;

            {
                this.f3742 = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // o.AbstractC1450Fk
            public /* synthetic */ EA invoke(xH xHVar2) {
                m2673(xHVar2);
                return EA.f5503;
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public final void m2673(xH xHVar2) {
                C1283.m16854(xM.f12043.m12803(), "Time to show the interrupter");
                this.f3742.f3740.f12046.mo13333();
            }
        }, 2, null);
    }
}
