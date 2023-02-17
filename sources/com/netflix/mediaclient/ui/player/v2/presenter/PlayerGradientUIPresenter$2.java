package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1276;
import o.C1457Fr;
import o.EA;
import o.xO;
public final class PlayerGradientUIPresenter$2 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ xO f3732;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerGradientUIPresenter$2(xO xOVar) {
        super(1);
        this.f3732 = xOVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2665(th);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2665(Throwable th) {
        C1457Fr.m5025(th, "it");
        C1276.m16820().mo5729("onError for playerStateEventObservable", th);
        this.f3732.f12076.mo13079();
    }
}
