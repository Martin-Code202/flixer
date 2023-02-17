package com.netflix.mediaclient.ui.feeds;

import com.netflix.cl.Logger;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0343;
import o.C1283;
import o.EA;
import o.rZ;
public final class TrailersFeedViewHolders$TitleWithTrailer$14 extends Lambda implements AbstractC1450Fk<Long, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ rZ.Cif f3109;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewHolders$TitleWithTrailer$14(rZ.Cif ifVar) {
        super(1);
        this.f3109 = ifVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Long l) {
        m1896(l.longValue());
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m1896(long j) {
        long j2 = j;
        if (j < 0) {
            j2 = 0;
        }
        C1283.m16854("TrailersFeedViewHolders", "Manual change end at " + j2);
        this.f3109.m10265().m2337(j2);
        this.f3109.m10295(true);
        Logger.INSTANCE.m142(new C0343());
        Logger.INSTANCE.m130("SeekCommand");
    }
}
