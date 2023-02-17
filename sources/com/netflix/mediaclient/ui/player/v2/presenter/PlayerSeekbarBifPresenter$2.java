package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1276;
import o.C1457Fr;
import o.EA;
import o.xY;
public final class PlayerSeekbarBifPresenter$2 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ xY f3771;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerSeekbarBifPresenter$2(xY xYVar) {
        super(1);
        this.f3771 = xYVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2701(th);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m2701(Throwable th) {
        C1457Fr.m5025(th, "it");
        C1276.m16820().mo5729("onError for playerStateEventObservable", th);
        this.f3771.f12115.mo13079();
    }
}
