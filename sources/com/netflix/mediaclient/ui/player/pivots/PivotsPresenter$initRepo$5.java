package com.netflix.mediaclient.ui.player.pivots;

import android.util.Pair;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import kotlin.jvm.internal.Lambda;
import o.AbstractC0385;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C1841h;
import o.C2322xq;
import o.CH;
import o.EA;
import o.pI;
public final class PivotsPresenter$initRepo$5 extends Lambda implements AbstractC1450Fk<Pair<Status, pI>, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ C2322xq f3672;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PivotsPresenter$initRepo$5(C2322xq xqVar) {
        super(1);
        this.f3672 = xqVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Pair<Status, pI> pair) {
        m2607(pair);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2607(Pair<Status, pI> pair) {
        C1457Fr.m5025(pair, "it");
        Status status = (Status) pair.first;
        pI pIVar = (pI) pair.second;
        C1457Fr.m5016((Object) status, "res");
        if (!status.mo301()) {
            CH ch = null;
            C1457Fr.m5016((Object) pIVar, "videoDetails");
            if ((!C1457Fr.m5018(pIVar.getType(), VideoType.MOVIE)) && (!C1457Fr.m5018(this.f3672.m12985().mo2225(), VideoType.MOVIE))) {
                ch = C1841h.m6800(pIVar);
            }
            AbstractC0385.m14153(this.f3672, C2322xq.m12977(this.f3672, false, null, false, false, null, null, ch, -1, false, 319, null), null, 2, null);
            return;
        }
        AbstractC0385.m14153(this.f3672, C2322xq.m12977(this.f3672, false, null, false, false, null, null, null, 0, false, 447, null), null, 2, null);
    }
}
