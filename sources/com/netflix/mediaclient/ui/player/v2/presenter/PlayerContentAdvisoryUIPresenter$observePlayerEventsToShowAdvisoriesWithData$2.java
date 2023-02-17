package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1283;
import o.EA;
import o.xH;
import o.xN;
public final class PlayerContentAdvisoryUIPresenter$observePlayerEventsToShowAdvisoriesWithData$2 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ xN f3728;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerContentAdvisoryUIPresenter$observePlayerEventsToShowAdvisoriesWithData$2(xN xNVar) {
        super(1);
        this.f3728 = xNVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2661(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2661(xH xHVar) {
        C1283.m16851("AdvisoryUIPresenter", "Showing Advisories with data if any. Size is %s", Integer.valueOf(this.f3728.m12812().size()));
        this.f3728.m12810();
    }
}
