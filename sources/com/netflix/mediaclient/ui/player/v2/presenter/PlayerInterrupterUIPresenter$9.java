package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xM;
public final class PlayerInterrupterUIPresenter$9 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ xM f3748;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerInterrupterUIPresenter$9(xM xMVar) {
        super(1);
        this.f3748 = xMVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2679(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2679(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            this.f3748.f12046.mo13079();
            this.f3748.f12049 = false;
        } else if (C1457Fr.m5018(xHVar, xH.C0269.f12003)) {
            this.f3748.f12049 = true;
        }
    }
}
