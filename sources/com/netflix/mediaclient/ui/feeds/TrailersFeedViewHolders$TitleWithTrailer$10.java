package com.netflix.mediaclient.ui.feeds;

import com.netflix.cl.Logger;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1243;
import o.C1244;
import o.C1457Fr;
import o.EA;
import o.rW;
import o.rZ;
public final class TrailersFeedViewHolders$TitleWithTrailer$10 extends Lambda implements AbstractC1450Fk<EA, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ rZ.Cif f3105;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewHolders$TitleWithTrailer$10(rZ.Cif ifVar) {
        super(1);
        this.f3105 = ifVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(EA ea) {
        m1892(ea);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m1892(EA ea) {
        C1457Fr.m5025(ea, "it");
        if (this.f3105.m10265().m2347()) {
            rW rWVar = this.f3105.f9750;
            if (rWVar != null) {
                rWVar.m10217(10);
            }
            Logger.INSTANCE.m142(new C1243());
            Logger.INSTANCE.m130("PauseCommand");
            return;
        }
        rW rWVar2 = this.f3105.f9750;
        if (rWVar2 != null) {
            rWVar2.m10217(11);
        }
        Logger.INSTANCE.m142(new C1244());
        Logger.INSTANCE.m130("PlayCommand");
    }
}
