package com.netflix.mediaclient.ui.feeds;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0682;
import o.C1283;
import o.C1457Fr;
import o.EA;
import o.rW;
import o.rZ;
public final class TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$10 extends Lambda implements AbstractC1450Fk<Integer, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ rW f3126;

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ rZ.Cif f3127;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$10(rZ.Cif ifVar, rW rWVar) {
        super(1);
        this.f3127 = ifVar;
        this.f3126 = rWVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Integer num) {
        m1909(num);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m1909(Integer num) {
        C1283.m16854(rZ.Cif.m10253(this.f3127, (String) null, 1, (Object) null), "playPauseRequest(" + this.f3127.getAdapterPosition() + ") " + num);
        if (!C1457Fr.m5018(this.f3127.f9750, this.f3126)) {
            return;
        }
        if (!this.f3127.m10265().m2347() && !this.f3127.m10265().m2331() && (num == null || num.intValue() != 41)) {
            return;
        }
        if (num != null && num.intValue() == 40) {
            this.f3127.m10265().setViewInFocus(false);
            this.f3127.m10293(false);
        } else if (num != null && num.intValue() == 41) {
            if (C0682.m14921() || this.f3127.f9754.m1952()) {
                this.f3127.m10295(false);
            } else {
                rZ.Cif.m10255(this.f3127, this.f3126, false, 2, null);
            }
        } else if ((num != null && num.intValue() == 10) || (num != null && num.intValue() == 30)) {
            this.f3127.m10293(true);
        } else if ((num != null && num.intValue() == 11) || (num != null && num.intValue() == 31)) {
            this.f3127.m10295(true);
        } else if (num != null && num.intValue() == 20) {
            this.f3127.m10293(false);
        } else if (num != null && num.intValue() == 21) {
            this.f3127.m10295(false);
        }
    }
}
