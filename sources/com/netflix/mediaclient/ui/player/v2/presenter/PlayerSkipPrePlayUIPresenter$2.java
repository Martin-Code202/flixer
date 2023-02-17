package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.EA;
import o.xH;
import o.xV;
public final class PlayerSkipPrePlayUIPresenter$2 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ xV f3784;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerSkipPrePlayUIPresenter$2(xV xVVar) {
        super(1);
        this.f3784 = xVVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2714(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2714(xH xHVar) {
        xV xVVar = this.f3784;
        if (xHVar == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.v2.PlayerStateEvent.PlayerStarted");
        }
        xVVar.f12094 = ((xH.Con) xHVar).m12764();
        this.f3784.f12096 = ((xH.Con) xHVar).m12762();
        if (this.f3784.f12096) {
            this.f3784.f12095.mo2736(true);
        } else {
            this.f3784.f12095.mo2733();
        }
    }
}
