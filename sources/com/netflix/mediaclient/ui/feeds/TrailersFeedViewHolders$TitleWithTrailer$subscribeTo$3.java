package com.netflix.mediaclient.ui.feeds;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1283;
import o.C1457Fr;
import o.EA;
import o.rW;
import o.rZ;
public final class TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$3 extends Lambda implements AbstractC1450Fk<Boolean, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ rW f3131;

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ rZ.Cif f3132;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$3(rZ.Cif ifVar, rW rWVar) {
        super(1);
        this.f3132 = ifVar;
        this.f3131 = rWVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Boolean bool) {
        m1913(bool);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m1913(Boolean bool) {
        C1283.m16854(rZ.Cif.m10253(this.f3132, (String) null, 1, (Object) null), "focus(" + this.f3132.getAdapterPosition() + ") " + bool);
        C1457Fr.m5016((Object) bool, "focus");
        if (bool.booleanValue()) {
            this.f3132.m10252().m16048("auto-play");
            this.f3132.m10295(false);
            return;
        }
        rZ.Cif.m10255(this.f3132, this.f3131, false, 2, null);
        this.f3132.m10252().m16048("auto-play-abort");
    }
}
