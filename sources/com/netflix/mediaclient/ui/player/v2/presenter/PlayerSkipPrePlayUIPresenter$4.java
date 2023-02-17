package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xV;
public final class PlayerSkipPrePlayUIPresenter$4 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ xV f3785;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerSkipPrePlayUIPresenter$4(xV xVVar) {
        super(1);
        this.f3785 = xVVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2715(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m2715(xH xHVar) {
        if (xHVar instanceof xH.C0275) {
            this.f3785.f12095.mo2735(false);
        } else if (C1457Fr.m5018(xHVar, xH.C2290If.f11987)) {
            if (!(this.f3785.f12094)) {
                this.f3785.f12095.mo2736(false);
            }
        } else if (C1457Fr.m5018(xHVar, xH.C0270.f12004)) {
            this.f3785.f12095.mo2735(false);
        }
    }
}
