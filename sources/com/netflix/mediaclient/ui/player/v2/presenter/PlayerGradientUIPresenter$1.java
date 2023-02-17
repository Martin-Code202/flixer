package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xO;
public final class PlayerGradientUIPresenter$1 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ xO f3731;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerGradientUIPresenter$1(xO xOVar) {
        super(1);
        this.f3731 = xOVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2664(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2664(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            if (!((xH.Con) xHVar).m12764() && !((xH.Con) xHVar).m12761()) {
                this.f3731.f12076.mo13088();
            }
        } else if (C1457Fr.m5018(xHVar, xH.C0272.f12006)) {
            this.f3731.f12076.mo13079();
        } else if (C1457Fr.m5018(xHVar, xH.C2293aux.f11990) || C1457Fr.m5018(xHVar, xH.C0273.f12007) || C1457Fr.m5018(xHVar, xH.C0275.f12009)) {
            this.f3731.f12076.mo13079();
        }
    }
}
