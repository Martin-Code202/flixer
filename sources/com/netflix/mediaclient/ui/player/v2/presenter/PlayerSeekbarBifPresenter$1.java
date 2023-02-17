package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xY;
public final class PlayerSeekbarBifPresenter$1 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ xY f3770;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerSeekbarBifPresenter$1(xY xYVar) {
        super(1);
        this.f3770 = xYVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2700(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m2700(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            this.f3770.f12113 = ((xH.Con) xHVar).m12765();
            this.f3770.f12115.mo13079();
        } else if (xHVar instanceof xH.AUX) {
            this.f3770.m12874(((xH.AUX) xHVar).m12757(), ((xH.AUX) xHVar).m12758(), false);
            this.f3770.f12115.mo13138();
        } else if (xHVar instanceof xH.C0266) {
            this.f3770.m12874(((xH.C0266) xHVar).m12775(), ((xH.C0266) xHVar).m12776(), ((xH.C0266) xHVar).m12774());
        } else if ((xHVar instanceof xH.C0267) || C1457Fr.m5018(xHVar, xH.C0269.f12003)) {
            this.f3770.f12115.mo13079();
        }
    }
}
