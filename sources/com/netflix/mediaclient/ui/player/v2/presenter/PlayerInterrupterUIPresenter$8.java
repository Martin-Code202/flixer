package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1276;
import o.C1457Fr;
import o.EA;
public final class PlayerInterrupterUIPresenter$8 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final PlayerInterrupterUIPresenter$8 f3747 = new PlayerInterrupterUIPresenter$8();

    PlayerInterrupterUIPresenter$8() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2678(th);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2678(Throwable th) {
        C1457Fr.m5025(th, "it");
        C1276.m16820().mo5729("onError for interrupterObservable in prepareInterrupterHide()", th);
    }
}
