package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xS;
public final class PlayerPrimaryControlsPresenter$1 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ xS f3758;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerPrimaryControlsPresenter$1(xS xSVar) {
        super(1);
        this.f3758 = xSVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2689(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2689(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            if (!((xH.Con) xHVar).m12764() && !((xH.Con) xHVar).m12761()) {
                this.f3758.f12082.mo13088();
                this.f3758.f12082.mo13347(true);
                this.f3758.f12082.mo13348();
                this.f3758.f12082.mo13350();
                this.f3758.f12082.mo13345(true);
            }
        } else if (xHVar instanceof xH.AUX) {
            this.f3758.m12831();
        } else if (C1457Fr.m5018(xHVar, xH.C0269.f12003) || C1457Fr.m5018(xHVar, xH.C2295iF.f11992)) {
            this.f3758.f12082.mo13346();
            this.f3758.m12831();
        } else if (!(xHVar instanceof xH.C2292auX)) {
            if (C1457Fr.m5018(xHVar, xH.C2293aux.f11990) || C1457Fr.m5018(xHVar, xH.C0273.f12007) || C1457Fr.m5018(xHVar, xH.C0275.f12009)) {
                this.f3758.f12082.mo13079();
            } else if (C1457Fr.m5018(xHVar, xH.C0274.f12008)) {
                this.f3758.f12082.mo13347(false);
            } else if (C1457Fr.m5018(xHVar, xH.C0271.f12005)) {
                this.f3758.f12082.mo13347(true);
            } else if (C1457Fr.m5018(xHVar, xH.C2290If.f11987)) {
                this.f3758.f12082.mo13349(true);
                this.f3758.f12082.mo13349(false);
                this.f3758.f12082.mo13350();
                this.f3758.f12082.mo13345(true);
            } else if (xHVar instanceof xH.Cif) {
                boolean r3 = ((xH.Cif) xHVar).m12770();
                if (!this.f3758.f12082.mo13108()) {
                    this.f3758.f12082.mo13346();
                    this.f3758.f12082.mo13343(!r3);
                    this.f3758.f12082.mo13352();
                    this.f3758.m12835(r3);
                    this.f3758.m12834();
                    this.f3758.m12836(true);
                }
                this.f3758.f12082.mo13351(r3);
            }
        }
    }
}
