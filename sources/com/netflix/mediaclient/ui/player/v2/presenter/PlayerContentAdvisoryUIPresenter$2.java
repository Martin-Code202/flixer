package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1283;
import o.C1457Fr;
import o.C2279wu;
import o.EA;
import o.xH;
import o.xN;
public final class PlayerContentAdvisoryUIPresenter$2 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ xN f3720;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerContentAdvisoryUIPresenter$2(xN xNVar) {
        super(1);
        this.f3720 = xNVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2653(xHVar);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2653(xH xHVar) {
        C2279wu r2;
        String r22;
        if ((xHVar instanceof xH.Con) && (r2 = ((xH.Con) xHVar).m12763()) != null && (r22 = r2.m12562()) != null) {
            C1283.m16854("AdvisoryUIPresenter", "Fetching advisories...");
            xN xNVar = this.f3720;
            C1457Fr.m5016((Object) r22, "it");
            xNVar.f12061 = r22;
            this.f3720.m12815();
            this.f3720.f12063.mo13315(r22);
        }
    }
}
