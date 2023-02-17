package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1276;
import o.C1457Fr;
import o.EA;
import o.xS;
public final class PlayerPrimaryControlsPresenter$2 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ xS f3759;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerPrimaryControlsPresenter$2(xS xSVar) {
        super(1);
        this.f3759 = xSVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2690(th);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2690(Throwable th) {
        C1457Fr.m5025(th, "it");
        C1276.m16820().mo5729("onError for playerStateEventObservable", th);
        this.f3759.f12082.mo13079();
    }
}
