package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xL;
public final class PlayerImmersiveModePresenter$2 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ xL f3734;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerImmersiveModePresenter$2(xL xLVar) {
        super(1);
        this.f3734 = xLVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2667(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2667(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            if (!((xH.Con) xHVar).m12764()) {
                this.f3734.f12040.mo13334();
            }
        } else if (C1457Fr.m5018(xHVar, xH.C0272.f12006)) {
            this.f3734.f12040.mo13334();
        } else if (C1457Fr.m5018(xHVar, xH.C2294con.f11991)) {
            this.f3734.f12040.mo13335();
        }
    }
}
