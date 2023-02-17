package com.netflix.mediaclient.ui.player.v2.presenter;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C2339yd;
import o.EA;
import o.xH;
public final class PlayerTappablePresenter$4 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ C2339yd f3791;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerTappablePresenter$4(C2339yd ydVar) {
        super(1);
        this.f3791 = ydVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2721(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2721(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            this.f3791.f12495.mo13085();
            if (!((xH.Con) xHVar).m12761()) {
                this.f3791.m13323(true);
            }
            this.f3791.m13322();
        } else if (C1457Fr.m5018(xHVar, xH.C0275.f12009)) {
            this.f3791.m13323(false);
            this.f3791.m13320(false);
        } else if (C1457Fr.m5018(xHVar, xH.C2289Aux.f11978)) {
            this.f3791.m13320(false);
        } else if (C1457Fr.m5018(xHVar, xH.C2294con.f11991)) {
            this.f3791.m13327(true);
        } else if (C1457Fr.m5018(xHVar, xH.IF.f11986)) {
            if (this.f3791.m13321()) {
                this.f3791.f12495.mo13086();
            }
        } else if ((xHVar instanceof xH.AUX) || C1457Fr.m5018(xHVar, xH.C0269.f12003) || C1457Fr.m5018(xHVar, xH.C2293aux.f11990)) {
            this.f3791.f12495.mo13086();
        }
    }
}
