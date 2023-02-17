package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1283;
import o.EA;
import o.xH;
import o.xM;
public final class PlayerInterrupterUIPresenter$7 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ xM f3746;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerInterrupterUIPresenter$7(xM xMVar) {
        super(1);
        this.f3746 = xMVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2677(xHVar);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2677(xH xHVar) {
        C1283.m16854(xM.f12043.m12803(), "Time to tell the uiView to emitEventStopWatching()");
        this.f3746.f12046.mo13332();
    }
}
