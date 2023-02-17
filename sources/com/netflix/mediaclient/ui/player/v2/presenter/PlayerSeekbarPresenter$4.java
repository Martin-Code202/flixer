package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.EA;
import o.xJ;
import o.xW;
public final class PlayerSeekbarPresenter$4 extends Lambda implements AbstractC1450Fk<xJ, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ xW f3776;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerSeekbarPresenter$4(xW xWVar) {
        super(1);
        this.f3776 = xWVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xJ xJVar) {
        m2706(xJVar);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2706(xJ xJVar) {
        if (xJVar instanceof xJ.C0284) {
            this.f3776.f12101 = true;
            this.f3776.f12102.mo13114();
            this.f3776.f12102.mo13115(this.f3776.f12104);
            this.f3776.f12102.mo13111();
        } else if (xJVar instanceof xJ.C0285) {
            this.f3776.f12104 = ((xJ.C0285) xJVar).m12787();
            this.f3776.f12102.mo13115(this.f3776.f12104);
        } else if (xJVar instanceof xJ.C2297Aux) {
            this.f3776.f12101 = false;
            this.f3776.f12102.mo13117();
            this.f3776.f12102.mo13113();
        }
    }
}
