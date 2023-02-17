package com.netflix.mediaclient.ui.player.v2.presenter;

import com.netflix.mediaclient.ui.player.PostPlay;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.EA;
import o.xT;
public final class PlayerPostPlayUIPresenter$6 extends Lambda implements AbstractC1449Fj<EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ xT f3757;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerPostPlayUIPresenter$6(xT xTVar) {
        super(0);
        this.f3757 = xTVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // o.AbstractC1449Fj
    public /* synthetic */ EA invoke() {
        m2688();
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2688() {
        this.f3757.f12090.mo13079();
        PostPlay postPlay = this.f3757.f12088;
        if (postPlay != null) {
            postPlay.m2555();
        }
    }
}
