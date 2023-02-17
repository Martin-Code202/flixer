package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xW;
public final class PlayerSeekbarPresenter$1 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ xW f3773;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerSeekbarPresenter$1(xW xWVar) {
        super(1);
        this.f3773 = xWVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2703(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m2703(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            if (!((xH.Con) xHVar).m12764()) {
                this.f3773.f12102.mo13085();
                this.f3773.f12104 = ((xH.Con) xHVar).m12766();
                this.f3773.f12106 = ((xH.Con) xHVar).m12767();
                this.f3773.f12102.mo13112(this.f3773.f12106);
                this.f3773.m12857(this.f3773.f12104, this.f3773.f12106, ((xH.Con) xHVar).m12761());
            }
        } else if (xHVar instanceof xH.C2292auX) {
            this.f3773.f12104 = ((xH.C2292auX) xHVar).m12769();
            if (this.f3773.f12102.mo13108()) {
                this.f3773.m12862(this.f3773.f12104, this.f3773.f12106);
            }
        } else if (!C1457Fr.m5018(xHVar, xH.C0269.f12003) && !C1457Fr.m5018(xHVar, xH.C2295iF.f11992)) {
            if (C1457Fr.m5018(xHVar, xH.C2293aux.f11990) || C1457Fr.m5018(xHVar, xH.C0273.f12007) || C1457Fr.m5018(xHVar, xH.C0275.f12009)) {
                this.f3773.f12102.mo13079();
            } else if (C1457Fr.m5018(xHVar, xH.C2290If.f11987)) {
                this.f3773.m12857(this.f3773.f12104, this.f3773.f12106, false);
            }
        } else if (!(this.f3773.f12101)) {
            this.f3773.f12102.mo13086();
        }
    }
}
