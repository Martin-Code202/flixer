package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1276;
import o.C1457Fr;
import o.EA;
import o.xR;
public final class PlayerSecondaryControlsPresenter$2 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ xR f3767;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerSecondaryControlsPresenter$2(xR xRVar) {
        super(1);
        this.f3767 = xRVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2697(th);
        return EA.f5503;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m2697(Throwable th) {
        C1457Fr.m5025(th, "it");
        C1276.m16820().mo5729("onError for playerStateEventObservable", th);
        this.f3767.f12079.mo13079();
    }
}
