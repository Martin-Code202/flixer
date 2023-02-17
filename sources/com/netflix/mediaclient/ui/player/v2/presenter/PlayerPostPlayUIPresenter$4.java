package com.netflix.mediaclient.ui.player.v2.presenter;

import com.netflix.mediaclient.ui.player.PostPlay;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xT;
public final class PlayerPostPlayUIPresenter$4 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ xT f3755;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerPostPlayUIPresenter$4(xT xTVar) {
        super(1);
        this.f3755 = xTVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2686(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m2686(xH xHVar) {
        PostPlay postPlay;
        if (xHVar instanceof xH.C0265) {
            PostPlay postPlay2 = this.f3755.f12088;
            if (postPlay2 != null) {
                postPlay2.m2562(((xH.C0265) xHVar).m12772(), ((xH.C0265) xHVar).m12773());
            }
        } else if (C1457Fr.m5018(xHVar, xH.C0273.f12007)) {
            this.f3755.m12844(true);
        } else if (C1457Fr.m5018(xHVar, xH.C0272.f12006)) {
            this.f3755.m12844(false);
        } else if (C1457Fr.m5018(xHVar, xH.C2294con.f11991)) {
            this.f3755.m12843(true);
            PostPlay postPlay3 = this.f3755.f12088;
            if (postPlay3 != null) {
                postPlay3.m2576(this.f3755.m12842());
            }
        } else if (xHVar instanceof xH.C0270) {
            if (!this.f3755.m12845()) {
                PostPlay postPlay4 = this.f3755.f12088;
                if (postPlay4 != null && postPlay4.m2594()) {
                    PostPlay postPlay5 = this.f3755.f12088;
                    if (postPlay5 != null && postPlay5.m2588()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            PostPlay postPlay6 = this.f3755.f12088;
            if (postPlay6 != null) {
                postPlay6.m2582();
            }
            this.f3755.m12843(false);
        } else if (C1457Fr.m5018(xHVar, xH.C2295iF.f11992)) {
            if (this.f3755.m12845() && (postPlay = this.f3755.f12088) != null) {
                postPlay.mo2589();
            }
            PostPlay postPlay7 = this.f3755.f12088;
            if (postPlay7 != null) {
                postPlay7.m2571();
            }
            PostPlay postPlay8 = this.f3755.f12088;
            if (postPlay8 != null) {
                postPlay8.m2553();
            }
        } else if (!C1457Fr.m5018(xHVar, xH.IF.f11986)) {
        } else {
            if (this.f3755.m12845()) {
                PostPlay postPlay9 = this.f3755.f12088;
                if (postPlay9 != null) {
                    postPlay9.mo2559();
                    return;
                }
                return;
            }
            PostPlay postPlay10 = this.f3755.f12088;
            if (postPlay10 != null && postPlay10.m2594()) {
                PostPlay postPlay11 = this.f3755.f12088;
                if (postPlay11 != null) {
                    postPlay11.mo2559();
                }
                PostPlay postPlay12 = this.f3755.f12088;
                if (postPlay12 != null) {
                    postPlay12.mo2563(true);
                }
            }
        }
    }
}
