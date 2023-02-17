package com.netflix.mediaclient.ui.player.v2.presenter;

import com.netflix.mediaclient.ui.player.PostPlay;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.EA;
import o.xH;
import o.xT;
public final class PlayerPostPlayUIPresenter$2 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ xT f3753;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerPostPlayUIPresenter$2(xT xTVar) {
        super(1);
        this.f3753 = xTVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2684(xHVar);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2684(xH xHVar) {
        xT xTVar = this.f3753;
        if (xHVar == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.v2.PlayerStateEvent.PlayerPreparePostPlay");
        }
        xTVar.f12088 = ((xH.C2288AuX) xHVar).m12759();
        PostPlay postPlay = this.f3753.f12088;
        if (postPlay != null) {
            postPlay.m2580(((xH.C2288AuX) xHVar).m12760());
        }
    }
}
