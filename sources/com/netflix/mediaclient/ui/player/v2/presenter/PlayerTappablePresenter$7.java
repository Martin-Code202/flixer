package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C2339yd;
import o.EA;
import o.xJ;
public final class PlayerTappablePresenter$7 extends Lambda implements AbstractC1450Fk<xJ, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ C2339yd f3793;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerTappablePresenter$7(C2339yd ydVar) {
        super(1);
        this.f3793 = ydVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xJ xJVar) {
        m2723(xJVar);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2723(xJ xJVar) {
        if (C1457Fr.m5018(xJVar, xJ.C0280.f12028)) {
            if (this.f3793.m13325() || this.f3793.m13321()) {
                this.f3793.f12495.mo13218();
                this.f3793.m13323(false);
                this.f3793.m13327(false);
            } else if (!this.f3793.m13328()) {
                this.f3793.f12495.mo13220();
                this.f3793.m13323(true);
            } else {
                this.f3793.f12495.mo13218();
                this.f3793.m13320(false);
            }
        } else if (xJVar instanceof xJ.Con) {
            this.f3793.f12495.mo13219(((xJ.Con) xJVar).m12781(), this.f3793.m13325());
        }
    }
}
