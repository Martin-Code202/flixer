package com.netflix.mediaclient.ui.feeds;

import com.netflix.cl.Logger;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1244;
import o.C1457Fr;
import o.EA;
import o.rZ;
public final class TrailersFeedViewHolders$TitleWithTrailer$8 extends Lambda implements AbstractC1450Fk<EA, EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ rZ.Cif f3123;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewHolders$TitleWithTrailer$8(rZ.Cif ifVar) {
        super(1);
        this.f3123 = ifVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(EA ea) {
        m1906(ea);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m1906(EA ea) {
        C1457Fr.m5025(ea, "it");
        this.f3123.m10252().m16048("manual-play");
        this.f3123.f9761.m1832();
        this.f3123.m10265().m2337(0);
        this.f3123.m10295(true);
        Logger.INSTANCE.m142(new C1244());
        Logger.INSTANCE.m130("PlayCommand");
    }
}
