package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1276;
import o.C1457Fr;
import o.EA;
import o.xM;
public final class PlayerInterrupterUIPresenter$13 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ xM f3738;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerInterrupterUIPresenter$13(xM xMVar) {
        super(1);
        this.f3738 = xMVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2671(th);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2671(Throwable th) {
        C1457Fr.m5025(th, "it");
        C1276.m16820().mo5729("onError for uiEventObservable", th);
        this.f3738.f12046.mo13079();
    }
}
