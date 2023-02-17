package com.netflix.mediaclient.android.widget;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0795;
import o.C1457Fr;
import o.EA;
public final class SeekButton$11 extends Lambda implements AbstractC1450Fk<EA, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ C0795 f956;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeekButton$11(C0795 r2) {
        super(1);
        this.f956 = r2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(EA ea) {
        m449(ea);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m449(EA ea) {
        C1457Fr.m5025(ea, "it");
        C0795.C0797 r4 = C0795.f14465;
        C0795.AbstractC2402If r0 = this.f956.m15290();
        if (r0 != null) {
            r0.mo1851(this.f956, this.f956.f14473, this.f956.f14467);
        }
        C0795.AbstractC2402If r02 = this.f956.m15290();
        if (r02 != null) {
            r02.mo1852(this.f956, this.f956.f14473, this.f956.f14467);
        }
        C0795.m15286(this.f956, null, 1, null);
        this.f956.f14467 = 0;
    }
}
