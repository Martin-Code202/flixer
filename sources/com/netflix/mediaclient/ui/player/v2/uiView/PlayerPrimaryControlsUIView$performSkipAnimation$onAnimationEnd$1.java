package com.netflix.mediaclient.ui.player.v2.uiView;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.C2360yy;
import o.EA;
public final class PlayerPrimaryControlsUIView$performSkipAnimation$onAnimationEnd$1 extends Lambda implements AbstractC1449Fj<EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ C2360yy f3806;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerPrimaryControlsUIView$performSkipAnimation$onAnimationEnd$1(C2360yy yyVar) {
        super(0);
        this.f3806 = yyVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // o.AbstractC1449Fj
    public /* synthetic */ EA invoke() {
        m2738();
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2738() {
        this.f3806.f12536.onNext(EA.f5503);
    }
}
