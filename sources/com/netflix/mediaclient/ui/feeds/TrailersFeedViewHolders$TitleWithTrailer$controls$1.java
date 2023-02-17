package com.netflix.mediaclient.ui.feeds;

import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.rZ;
public final class TrailersFeedViewHolders$TitleWithTrailer$controls$1 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ rZ.Cif f3125;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewHolders$TitleWithTrailer$controls$1(rZ.Cif ifVar) {
        super(1);
        this.f3125 = ifVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m1908(th);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m1908(Throwable th) {
        C1457Fr.m5025(th, ExceptionClEvent.CATEGORY_VALUE);
        this.f3125.m10261(th);
    }
}
