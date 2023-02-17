package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.AbstractC2346yk;
import o.C1457Fr;
import o.C2279wu;
import o.EA;
import o.xH;
import o.xI;
import o.xQ;
public final class PlayerNavigationControlsPresenter$1 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ xQ f3751;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerNavigationControlsPresenter$1(xQ xQVar) {
        super(1);
        this.f3751 = xQVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2682(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m2682(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            this.f3751.f12078.mo13085();
            AbstractC2346yk ykVar = this.f3751.f12078;
            xI xIVar = xI.f12010;
            C2279wu r2 = ((xH.Con) xHVar).m12763();
            ykVar.mo13093(xIVar.m12777(r2 != null ? r2.m12545() : null));
            if (!this.f3751.f12078.mo13108() && !((xH.Con) xHVar).m12764() && !((xH.Con) xHVar).m12761()) {
                this.f3751.f12078.mo13088();
            }
        } else if ((xHVar instanceof xH.AUX) || C1457Fr.m5018(xHVar, xH.C0269.f12003) || C1457Fr.m5018(xHVar, xH.C2295iF.f11992)) {
            this.f3751.f12078.mo13086();
        } else if (C1457Fr.m5018(xHVar, xH.C2293aux.f11990) || C1457Fr.m5018(xHVar, xH.C0273.f12007) || C1457Fr.m5018(xHVar, xH.C0275.f12009)) {
            this.f3751.f12078.mo13079();
        } else if (!(xHVar instanceof xH.C0263)) {
        } else {
            if (((xH.C0263) xHVar).m12771() != null) {
                this.f3751.f12078.mo13091();
            } else {
                this.f3751.f12078.mo13094();
            }
        }
    }
}
