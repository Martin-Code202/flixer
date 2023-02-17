package com.netflix.mediaclient.ui.player.v2.presenter;

import com.netflix.mediaclient.media.Watermark;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.AbstractC2352yq;
import o.C1457Fr;
import o.EA;
import o.oM;
import o.xH;
import o.xZ;
public final class PlayerWatermarkPresenter$1 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ xZ f3801;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerWatermarkPresenter$1(xZ xZVar) {
        super(1);
        this.f3801 = xZVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2731(xHVar);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2731(xH xHVar) {
        if (xHVar instanceof xH.Con) {
            oM r0 = ((xH.Con) xHVar).m12765();
            if ((r0 != null ? r0.mo895() : null) != null) {
                this.f3801.f12116.mo13088();
                AbstractC2352yq yqVar = this.f3801.f12116;
                oM r1 = ((xH.Con) xHVar).m12765();
                Watermark r12 = r1 != null ? r1.mo895() : null;
                C1457Fr.m5016((Object) r12, "it.playerSession?.watermark");
                String identifier = r12.getIdentifier();
                C1457Fr.m5016((Object) identifier, "it.playerSession?.watermark.identifier");
                yqVar.mo13215(identifier);
                AbstractC2352yq yqVar2 = this.f3801.f12116;
                oM r13 = ((xH.Con) xHVar).m12765();
                Watermark r14 = r13 != null ? r13.mo895() : null;
                C1457Fr.m5016((Object) r14, "it.playerSession?.watermark");
                yqVar2.mo13214(((float) r14.getOpacity()) / 100.0f);
            }
        }
    }
}
