package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.EA;
import o.xH;
import o.xN;
public final class PlayerContentAdvisoryUIPresenter$7 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ xN f3724;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerContentAdvisoryUIPresenter$7(xN xNVar) {
        super(1);
        this.f3724 = xNVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2657(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m2657(xH xHVar) {
        if (xHVar instanceof xH.C0273) {
            this.f3724.f12062 = true;
        } else if (xHVar instanceof xH.C0272) {
            this.f3724.f12062 = false;
        }
    }
}
