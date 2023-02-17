package com.netflix.mediaclient.ui.player.v2.presenter;

import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C2279wu;
import o.EA;
import o.xH;
import o.xR;
public final class PlayerSecondaryControlsPresenter$1 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ xR f3766;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerSecondaryControlsPresenter$1(xR xRVar) {
        super(1);
        this.f3766 = xRVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2696(xHVar);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2696(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            C2279wu r0 = ((xH.Con) xHVar).m12763();
            if (!C1457Fr.m5018(r0 != null ? r0.m12556() : null, IPlayer.PlaybackType.OfflinePlayback)) {
                C2279wu r02 = ((xH.Con) xHVar).m12763();
                if (!(!C1457Fr.m5018(r02 != null ? r02.m12546() : null, VideoType.EPISODE))) {
                    if (!((xH.Con) xHVar).m12764()) {
                        this.f3766.f12079.mo13084();
                    }
                    this.f3766.f12079.mo13085();
                    if (!this.f3766.f12079.mo13108() && !((xH.Con) xHVar).m12764() && !((xH.Con) xHVar).m12761()) {
                        this.f3766.f12079.mo13088();
                        return;
                    }
                    return;
                }
            }
            this.f3766.f12079.mo13081();
            this.f3766.f12079.mo13087();
            this.f3766.f12079.mo13085();
            if (!this.f3766.f12079.mo13108()) {
            }
        } else if ((xHVar instanceof xH.AUX) || C1457Fr.m5018(xHVar, xH.C0269.f12003) || C1457Fr.m5018(xHVar, xH.C2295iF.f11992)) {
            this.f3766.f12079.mo13086();
        } else if (C1457Fr.m5018(xHVar, xH.C2293aux.f11990) || C1457Fr.m5018(xHVar, xH.C0273.f12007) || C1457Fr.m5018(xHVar, xH.C0275.f12009)) {
            this.f3766.f12079.mo13079();
        } else if (!(xHVar instanceof xH.C2291aUx)) {
        } else {
            if (((xH.C2291aUx) xHVar).m12768() == null) {
                this.f3766.f12079.mo13081();
            } else {
                this.f3766.f12079.mo13083();
            }
        }
    }
}
