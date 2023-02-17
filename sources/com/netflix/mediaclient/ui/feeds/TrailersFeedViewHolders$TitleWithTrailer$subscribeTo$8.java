package com.netflix.mediaclient.ui.feeds;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1283;
import o.C1457Fr;
import o.EA;
import o.rW;
import o.rZ;
public final class TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$8 extends Lambda implements AbstractC1450Fk<Boolean, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ rZ.Cif f3137;

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ rW f3138;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$8(rZ.Cif ifVar, rW rWVar) {
        super(1);
        this.f3137 = ifVar;
        this.f3138 = rWVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Boolean bool) {
        m1917(bool);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m1917(Boolean bool) {
        C1283.m16854(rZ.Cif.m10253(this.f3137, (String) null, 1, (Object) null), "focus(" + this.f3137.getAdapterPosition() + ") " + bool);
        if (C1457Fr.m5018(this.f3137.f9750, this.f3138)) {
            this.f3137.m10265().setViewInFocus(false);
            if (this.f3137.m10265().m2347()) {
                this.f3137.m10252().m16048("focus-auto-pause");
                this.f3137.m10293(false);
            } else if (this.f3137.f9764) {
                this.f3137.m10252().m16048("focus-auto-idle");
                this.f3137.m10258().setVisibility(0);
                this.f3137.f9761.m1836(8);
                rZ.Cif.m10255(this.f3137, this.f3138, false, 2, null);
                this.f3137.f9764 = false;
            }
        }
    }
}
