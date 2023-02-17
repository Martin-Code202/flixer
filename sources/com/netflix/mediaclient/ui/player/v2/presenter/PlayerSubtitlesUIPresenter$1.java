package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xU;
public final class PlayerSubtitlesUIPresenter$1 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ xU f3787;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerSubtitlesUIPresenter$1(xU xUVar) {
        super(1);
        this.f3787 = xUVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2717(xHVar);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2717(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            if (!((xH.Con) xHVar).m12764()) {
                this.f3787.f12093.mo13088();
            }
        } else if (C1457Fr.m5018(xHVar, xH.C0272.f12006) || C1457Fr.m5018(xHVar, xH.C0271.f12005) || (xHVar instanceof xH.C0267)) {
            this.f3787.f12093.mo13088();
        } else if ((xHVar instanceof xH.AUX) || C1457Fr.m5018(xHVar, xH.C0273.f12007) || C1457Fr.m5018(xHVar, xH.C0269.f12003) || C1457Fr.m5018(xHVar, xH.C0274.f12008) || C1457Fr.m5018(xHVar, xH.C2295iF.f11992) || C1457Fr.m5018(xHVar, xH.C2293aux.f11990)) {
            this.f3787.f12093.mo13079();
        } else if (C1457Fr.m5018(xHVar, xH.C0275.f12009) || C1457Fr.m5018(xHVar, xH.C0270.f12004)) {
            this.f3787.f12093.mo13128();
        }
    }
}
