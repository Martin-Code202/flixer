package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xP;
public final class PlayerLoadingSpinnerPresenter$1 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ xP f3749;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerLoadingSpinnerPresenter$1(xP xPVar) {
        super(1);
        this.f3749 = xPVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2680(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m2680(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            this.f3749.f12077.mo13079();
        } else if (C1457Fr.m5018(xHVar, xH.C0269.f12003) || C1457Fr.m5018(xHVar, xH.C2295iF.f11992)) {
            this.f3749.f12077.mo13088();
        }
    }
}
