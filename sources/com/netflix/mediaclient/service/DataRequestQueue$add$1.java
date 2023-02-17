package com.netflix.mediaclient.service;

import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0938;
import o.EA;
public final class DataRequestQueue$add$1 extends Lambda implements AbstractC1450Fk<C0938, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ NetflixDataRequest f1058;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataRequestQueue$add$1(NetflixDataRequest netflixDataRequest) {
        super(1);
        this.f1058 = netflixDataRequest;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(C0938 r2) {
        m491(r2);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m491(C0938 r3) {
        C0938.f14820.m15751(this.f1058);
    }
}
