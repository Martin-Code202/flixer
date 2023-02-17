package com.netflix.mediaclient.ui.feeds;

import com.netflix.mediaclient.ui.feeds.PlayerControls;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.pF;
import o.rW;
final class PlayerControls$1$$special$$inlined$let$lambda$1 extends Lambda implements AbstractC1450Fk<Integer, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ rW f3046;

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ pF f3047;

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ PlayerControls.AnonymousClass1 f3048;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerControls$1$$special$$inlined$let$lambda$1(pF pFVar, PlayerControls.AnonymousClass1 r3, rW rWVar) {
        super(1);
        this.f3047 = pFVar;
        this.f3048 = r3;
        this.f3046 = rWVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Integer num) {
        m1842(num);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m1842(Integer num) {
        PlayerControls playerControls = this.f3048.f3049;
        C1457Fr.m5016((Object) num, "current");
        int intValue = num.intValue();
        pF pFVar = this.f3047;
        C1457Fr.m5016((Object) pFVar, "playable");
        PlayerControls.m1811(playerControls, intValue, pFVar.getRuntime() * 1000);
    }
}
